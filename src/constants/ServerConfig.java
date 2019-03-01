package constants;

public class ServerConfig {

    public static boolean checkCopyItem = true;
    public static boolean Business = true;
    public static boolean adminOnly = false;
    public static boolean logPackets = false;
    public static boolean AutoDisconnect = true;
    public static final double Activity_Bonus_Rate = 50 / 100.0D;
    public static final int flags = 3;
    public static final String serverName = "MapleStory72";
    public static final String eventMessage = "MapleStory72";
    public static final int flag = 3;
    public static final int maxCharacters = 3;
    public static final String scrollingMessage = "目前版本H005版， 群宠归来，爱不释手！";
    public static int userLimit = 1500;
    public static String interface_ = Business ? "61.160.247.81" : "127.0.0.1" ;
    public static final int channelCount = 1;
    public static final String events = ""/* + "AutomatedEvent,"*/ + "Relic,HontalePQ,HorntailBattle,cpq2,elevator,Christmas,FireDemon,Amoria,cpq,AutomatedEvent,Flight,English,English0,English1,English2,WuGongPQ,ElementThanatos,4jberserk,4jrush,Trains,Geenie,AirPlane,OrbisPQ,HenesysPQ,Romeo,Juliet,Pirate,Ellin,DollHouse,BossBalrog_NORMAL,Nibergen,PinkBeanBattle,ZakumBattle,NamelessMagicMonster,Dunas,Dunas2,ZakumPQ,LudiPQ,KerningPQ,ProtectTylus,Vergamot,CoreBlaze,GuildQuest,Aufhaven,KyrinTrainingGroundC,KyrinTrainingGroundV,ProtectPig,ScarTarBattle,s4resurrection,s4resurrection2,s4nest,s4aWorld,DLPracticeField,ServerMessage,BossQuestEASY,BossQuestHARD,BossQuestHELL,BossQuestMed,shaoling,Ravana,MV,BossBalrog,QiajiPQ,Relic,Boats";

    /*Anti-Sniff*/
    public static boolean USE_FIXED_IV;
    public static final byte[] Static_LocalIV = new byte[]{71, 113, 26, 44};
    public static final byte[] Static_RemoteIV = new byte[]{70, 112, 25, 43};
}
