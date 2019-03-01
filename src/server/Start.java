package server;

import client.LoginCrypto;
import client.SkillFactory;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.OnlyID;
import constants.ServerConfig;
import constants.ServerConstants;
import database.DBConPool;
import handling.MapleServerHandler;
import handling.cashshop.CashShopServer;
import handling.channel.ChannelServer;
import handling.channel.MapleDojoRanking;
import handling.channel.MapleGuildRanking;
import handling.login.LoginInformationProvider;
import handling.login.LoginServer;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuild;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import server.Timer.BuffTimer;
import server.Timer.CloneTimer;
import server.Timer.EtcTimer;
import server.Timer.EventTimer;
import server.Timer.MapTimer;
import server.Timer.PingTimer;
import server.Timer.WorldTimer;
import server.events.MapleOxQuizFactory;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.life.MobSkillFactory;
import server.life.PlayerNPC;
import server.maps.MapleMapFactory;
import server.quest.MapleQuest;
import tools.CpuSerialTools;
import tools.CustomPlayerRankings;
import tools.FileoutputUtil;
import tools.MacAddressTool;

public class Start {

    public static long startTime = System.currentTimeMillis();
    public static final Start instance = new Start();
    public static AtomicInteger CompletedLoadingThreads = new AtomicInteger(0);

    public void run() throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("settings.ini"));
        } catch (IOException ex) {
            System.out.println("载入设定党 settings.ini 失败");
            System.exit(0);
        }
        ServerConfig.userLimit = Integer.parseInt(p.getProperty("userLimit", "1500"));
        ServerConfig.interface_ = p.getProperty("ip");
        ServerConfig.logPackets = Boolean.parseBoolean(p.getProperty("logOps"));
        ServerConfig.adminOnly = Boolean.parseBoolean(p.getProperty("adminOnly"));
        ServerConfig.USE_FIXED_IV = Boolean.parseBoolean(p.getProperty("antiSniff"));

        // 数据库连接设定
        ServerConstants.SQL_PORT = p.getProperty("sql_port");
        ServerConstants.SQL_USER = p.getProperty("sql_user");
        ServerConstants.SQL_PASSWORD = p.getProperty("sql_password");
        ServerConstants.SQL_DATABASE = p.getProperty("sql_db");

        //System.setProperty("wzpath", p.getProperty("wzpath"));
        if (ServerConfig.adminOnly || ServerConstants.Use_Localhost) {
            System.out.println("管理员模式开启");
        }
        try (Connection con = DBConPool.getInstance().getDataSource().getConnection()) {
            try (PreparedStatement ps = con.prepareStatement("UPDATE accounts SET loggedin = 0")) {
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("执行中出现异常 - 无法连线到数据库." + ex);
        }

        System.out.println("正在载入 MapleSNDA_V072");
        World.init();
        System.out.println("主机位置: " + ServerConfig.interface_ + ":" + LoginServer.PORT);
        System.out.println("客户端版本: " + ServerConstants.MAPLE_VERSION + "." + ServerConstants.MAPLE_PATCH);
        //System.out.println("Source Revision: " + ServerConstants.SOURCE_REVISION);
        System.out.println("主要世界: " + ServerConstants.MAIN_WORLD);

        System.out.println("正在加载Timer...");
        WorldTimer.getInstance().start();
        EtcTimer.getInstance().start();
        MapTimer.getInstance().start();
        CloneTimer.getInstance().start();
        EventTimer.getInstance().start();
        BuffTimer.getInstance().start();
        PingTimer.getInstance().start();
        System.out.println("正在加载排行榜...");
        MapleDojoRanking.getInstance().load();
        MapleGuildRanking.getInstance().load();
        System.out.println("正在加载家族...");
        MapleGuild.loadAll();
        System.out.println("正在加载学院...");
        MapleFamily.loadAll();
        System.out.println("正在加载任务...");
        MapleLifeFactory.loadQuestCounts();
        MapleQuest.initQuests();
        MapleOxQuizFactory.getInstance();
        System.out.println("正在加载道具...");
        MapleItemInformationProvider.getInstance().runEtc();
        MapleMonsterInformationProvider.getInstance().load();
        MapleItemInformationProvider.getInstance().runItems();
        System.out.println("正在加载技能...");
        SkillFactory.load();
        MobSkillFactory.getInstance();
        MapleCarnivalFactory.getInstance();
        System.out.println("正在加载奖励...");
        RandomRewards.load();
        System.out.println("正在加载其他配置...");
        LoginInformationProvider.getInstance();
        SpeedRunner.loadSpeedRuns();
        MapleInventoryIdentifier.getInstance();
        MapleMapFactory.loadCustomLife();
        PreparedStatement ps;
        try (Connection con = DBConPool.getInstance().getDataSource().getConnection()) {
            ps = con.prepareStatement("DELETE FROM `moonlightachievements` where achievementid > 0;");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.err.println("moonlightachievements" + ex);
            FileoutputUtil.outputFileError("logs/数据库异常.txt", ex);
        }
        CashItemFactory.getInstance().initialize();
        MapleServerHandler.initiate();
        LoginServer.run_startup_configurations();
        ChannelServer.startChannel_Main();
        CashShopServer.run_startup_configurations();
        //FarmServer.run_startup_configurations();
        Runtime.getRuntime().addShutdownHook(new Thread(new Shutdown()));
        World.registerRespawn();
        ShutdownServer.registerMBean();
        PlayerNPC.loadAll();
        MapleMonsterInformationProvider.getInstance().addExtra();
        LoginServer.setOn();
        RankingWorker.run();
        //System.out.println("Event Script List: " + ServerConfig.getEventList());
        if (ServerConfig.logPackets) {
            System.out.println("数据包记录已开启.");
        }
        if (ServerConfig.USE_FIXED_IV) {
            System.out.println("反抓包已开启.");
        }

        CustomPlayerRankings.getInstance().load();
        long now = System.currentTimeMillis() - start;
        long seconds = now / 1000;
        long ms = now % 1000;
        System.out.println("开启一共花了: " + seconds + "秒 " + ms + "毫秒");
        OnlyID.getInstance();
    }

    public static class Shutdown implements Runnable {

        @Override
        public void run() {
            ShutdownServer.getInstance().run();
            ShutdownServer.getInstance().run();
        }
    }

    public static void main(final String args[]) throws InterruptedException, IOException {
        //instance.run();
        /*if (ServerConfig.Business) {
         String[] Jiqima = {"a3aebd0fdae5ddc7a38cee1c28eb39db88e25613450a10415d5f008a24afcefd3bbe66eea8056c299541941c39e75270d34d231329a63ffe2f2764f7931d63f7"};
         String CPU = CpuSerialTools.getCPUSerial();
           
         String CpuSha512 = LoginCrypto.hexSha512(CPU);
         System.out.println("本机编号:" +   CpuSha512);
         if (CpuSha512 != null) {
         for (int i = 0; i < Jiqima.length; i++) {
         if (Jiqima[i].equals(CpuSha512)) {
         instance.run();
         break;
         }
         }
         } else {
         System.exit(0);
         }
         } else {*/
        instance.run();
        //}

    }
}
