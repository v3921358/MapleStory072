package handling;

public enum RecvPacketOpcode implements WritableIntValueHolder {

    //请求登入帐号密码
    LOGIN_PASSWORD(false, (short) 0x01),
    //回到频道列表
    REDISPLAY_SERVERLIST(true, (short) 0x2),
    //选择性别
    SET_GENDER(false, (short) 0x03),
    //请求服务器状态
    SERVERSTATUS_REQUEST(false, (short) 0x04),
    //请求人物列表
    CHARLIST_REQUEST(false, (short) 0x06),
    //开始游戏
    CHAR_SELECT(true, (short) 0x07),
    //请求登入游戏
    PLAYER_LOGGEDIN(false, (short) 0x08),
    //检查人物名字
    CHECK_CHAR_NAME(true, (short) 0x09),
    //注册帐号
    CHECK_REGISTER_ACCOUNT(false, (byte) 0x0A),
    //帐号检测
    CHECK_ACCOUNT(false, (byte) 0x0B),
    //注册帐号
    REGISTER_ACCOUNT(false, (byte) 0x0C),
    //创建人物
    CREATE_CHAR(false, (short) 0x0E),
    //通讯包
    PONG(false, (short) 0x11),
    //错误信息
    CLIENT_ERROR(false, (short) 0x12),
    //切换地图 -2
    CHANGE_MAP(true, (short) 0x1F),
    //更换频道 -2
    CHANGE_CHANNEL(true, (short) 0x20),
    //现金商店
    ENTER_CASH_SHOP(true, (short) 0x21),
    //人物移动 -2
    MOVE_PLAYER(true, (short) 0x22),
    //取消椅子
    CANCEL_CHAIR(true, (short) 0x23),
    //使用椅子
    USE_CHAIR(true, (short) 0x24),
    //近距离攻击 -3
    CLOSE_RANGE_ATTACK(true, (short) 0x25),
    //远距离攻击 -3
    RANGED_ATTACK(true, (short) 0x26),
    //魔法攻击 -3
    MAGIC_ATTACK(true, (short) 0x27),
    //能量攻击 -3
    PASSIVE_ENERGY(true, (short) 0x28),
    //角色受到伤害
    TAKE_DAMAGE(true, (short) 0x29),
    //普通聊天 -3
    GENERAL_CHAT(true, (short) 0x2A),
    //关闭黑板 
    CLOSE_CHALKBOARD(true, (short) 0x2B),
    //人物面部表情 
    FACE_EXPRESSION(true, (short) 0x2C),
    //使用物品效果
    USE_ITEMEFFECT(true, (short) 0x2D),
    //使用未知效果 
    WHEEL_OF_FORTUNE(true, (short) 0x2E),
    //使用称号效果 
    USE_TITLE(true, (short) 0x2F),
    MONSTER_BOOK_COVER(true, (short) 0x32),
    //NPC交谈 -3
    NPC_TALK(true, (short) 0x33),
    //NPC详细交谈 -3
    NPC_TALK_MORE(true, (short) 0x35),
    //结婚反馈
    MARRAGE_RECV(true, (short) 0x36),
    //NPC商店
    NPC_SHOP(true, (short) 0x37),
    //仓库
    STORAGE(true, (short) 0x38),
    //使用雇佣商店 
    USE_HIRED_MERCHANT(true, (short) 0x39),
    //打开雇佣仓库
    MERCH_ITEM_STORE(true, (short) 0x3A),
    //送货员
    PACKAGE_OPERATION(true, (short) 0x3B),
    //商店搜索器 
    OWL(true, (short) 0x3C),
    //商店搜索器传送
    OWL_WARP(true, (short) 0x3D),
    //物品整理
    ITEM_SORT(true, (short) 0x3F),
    //物品排序
    ITEM_GATHER(true, (short) 0x40),
    //物品移动
    ITEM_MOVE(true, (short) 0x41),
    //使用物品
    USE_ITEM(true, (short) 0x42),
    //取消物品结果
    CANCEL_ITEM_EFFECT(true, (short) 0x43),
    //使用召唤包
    USE_SUMMON_BAG(true, (short) 0x45),
    //宠物食品
    PET_FOOD(true, (short) 0x46),
    //坐骑食品
    USE_MOUNT_FOOD(true, (short) 0x47),
    //使用特殊消耗物品 
    USE_SCRIPTED_NPC_ITEM(true, (short) 0x48),
    //使用现金物品
    USE_CASH_ITEM(true, (short) 0x49),
    //使用扑捉物品
    USE_CATCH_ITEM(true, (short) 0x4B),
    //使用技能书
    USE_SKILL_BOOK(true, (short) 0x4C),
    //使用回城卷
    USE_RETURN_SCROLL(true, (short) 0x4F),
    //使用砸卷
    USE_UPGRADE_SCROLL(true, (short) 0x50),
    //分发能力点
    DISTRIBUTE_AP(true, (short) 0x51),
    //自动分发能力点
    AUTO_ASSIGN_AP(true, (short) 0x52),
    //自动回复HP/MP
    HEAL_OVER_TIME(true, (short) 0x53),
    //分发技能点
    DISTRIBUTE_SP(true, (short) 0x54),
    //角色使用技能
    SPECIAL_MOVE(true, (short) 0x55),
    //取消增益效果
    CANCEL_BUFF(true, (short) 0x56),
    //技能效果
    SKILL_EFFECT(true, (short) 0x57),
    //金币掉落 -3
    MESO_DROP(true, (short) 0x58),
    //给人气
    GIVE_FAME(true, (short) 0x59),
    //返回人物信息 -3
    CHAR_INFO_REQUEST(true, (short) 0x5B),
    //召唤宠物
    SPAWN_PET(true, (short) 0x5C),
    //取消负面效果
    CANCEL_DEBUFF(true, (short) 0x5D),
    //特殊地图移动
    CHANGE_MAP_SPECIAL(true, (short) 0x5E),
    //使用时空门
    USE_INNER_PORTAL(true, (short) 0x5F),
    //缩地石
    TROCK_ADD_MAP(true, (short) 0x60),
    //使用测谎仪 
    LIE_DETECTOR(true, (short) 0x61),
    //测谎仪技能 
    LIE_DETECTOR_SKILL(true, (short) 0x62),
    //确认测谎验证码
    LIE_DETECTOR_RESPONSE(true, (short) 0x63),
    //刷新测谎验证码 
    LIE_DETECTOR_REFRESH(true, (short) 0x64),
    //任务动作
    QUEST_ACTION(true, (short) 0x65),
    //辅助效果回应
    BUFF_RESPONSE(true, (short) 0x66),
    //技能宏
    SKILL_MACRO(true, (short) 0x69),
    //悄悄话
    PARTYCHAT(true, (short) 0x6F),
    //悄悄话
    COMMAND(true, (short) 0x70),
    //聊天招待
    MESSENGER(true, (short) 0x71),
    //玩家互动
    PLAYER_INTERACTION(true, (short) 0x72),
    //开设组队
    PARTY_OPERATION(true, (short) 0x73),
    //拒绝组队邀请
    DENY_PARTY_REQUEST(true, (short) 0x74),
    //开设家族
    GUILD_OPERATION(true, (short) 0x75),
    //拒绝家族邀请
    DENY_GUILD_REQUEST(true, (short) 0x76),
    //好友操作
    BUDDYLIST_MODIFY(true, (short) 0x79),
    //小纸条
    NOTE_ACTION(true, (short) 0x7A),
    //使用门
    USE_DOOR(true, (short) 0x7C),
    //使用门
    USE_MECH_DOOR(true, (short) 0x7D),
    //改变键盘布局
    CHANGE_KEYMAP(true, (short) 0x7E),
    //剪刀石头布 
    RPS_GAME(true, (short) 0x7F),
    //戒指操作 
    RING_ACTION(true, (short) 0x80),
    //
    WEDDING_ACTION(true, (short) 0x81),
    //家族联盟
    ALLIANCE_OPERATION(true, (short) 0x85),
    //拒绝家族联盟
    DENY_ALLIANCE_REQUEST(true, (short) 0x86),
    //家族BBS
    BBS_OPERATION(true, (short) 0x87),//150
    //进入拍卖
    ENTER_MTS(true, (short) 0x88),
    //孙子兵法
    ITEM_SUNZI(true, (short) 0x89),
    //宠物移动
    MOVE_PET(true, (short) 0x9D),
    //宠物说话
    PET_CHAT(true, (short) 0x9E),
    //宠物命令
    PET_COMMAND(true, (short) 0x9F),
    //宠物拣取
    PET_LOOT(true, (short) 0xA0),
    //宠物自动吃药
    PET_AUTO_POT(true, (short) 0xA1),
    //宠物排除道具
    PET_IGNORE(true, (short) 0xA2),
    //召唤兽移
    MOVE_SUMMON(true, (short) 0xA5),
    //召唤兽攻击
    SUMMON_ATTACK(true, (short) 0xA6),
    //召唤兽受到伤害
    DAMAGE_SUMMON(true, (short) 0xA7),
    //召唤兽技能
    SUB_SUMMON(true, (short) 0xA8),
    //移除召唤兽
    REMOVE_SUMMON(true, (short) 0xA9),
    //怪物移动 -8
    MOVE_LIFE(true, (short) 0xAF),
    //怪物仇恨
    AUTO_AGGRO(true, (short) 0xB0),
    //怪物伤害怪物
    FRIENDLY_DAMAGE(true, (short) 0xB3),
    //NPC说话
    NPC_ACTION(true, (short) 0xB8),
    //人物数据更新
    PLAYER_UPDATE(true, (short) 0xD6),
    //豆豆机操作
    BEANS_OPERATION(true, (short) 0xD8),
    //豆豆刷新
    BEANS_UPDATE(true, (short) 0xD9),
    
    //物品拣起 -8
    ITEM_PICKUP(true, (short) 0xBE),
    //攻击反应堆
    DAMAGE_REACTOR(true, (short) 0xC1),
    //双击反应堆
    TOUCH_REACTOR(true, (short) 0xC2),
    //
    CLICK_REACTOR(true, (short) 0xC3),
    SNOWBALL(true, (short) 0xC5),
    LEFT_KNOCK_BACK(true, (short) 0xC6),
    COCONUT(true, (short) 0xC7),
    //嘉年華
    MONSTER_CARNIVAL(true, (short) 0xCD),
    //确认点卷 -B
    CS_UPDATE(true, (short) 0xDD),
    //商城购买 -B
    BUY_CS_ITEM(true, (short) 0xDE),
    //商城兑换券 -B
    COUPON_CODE(true, (short) 0xDF),
    // General
    RSA_KEY(false),
    STRANGE_DATA,
    MAPLETV,
    LOGIN_REDIRECTOR(false, (short) 0x999),
    CRASH_INFO(false, (short) 0x2E),
    // Login
    GUEST_LOGIN(true, (short) 0x16),
    TOS(true, (short) 0x1D),
    VIEW_SERVERLIST(false, (short) 0x21),
    SERVERLIST_REQUEST(false, (short) 0x999),
    CHAR_SELECT_NO_PIC(false, (short) 0x25),
    DELETE_CHAR(true, (short) 0x2C),
    AUTH_REQUEST(false, (short) 0x30),
    VIEW_REGISTER_PIC(true, (short) 0x999),
    VIEW_SELECT_PIC(true, (short) 0x35),
    CLIENT_START(false, (short) 0x38),
    CLIENT_FAILED(false, (short) 0x39),
    PART_TIME_JOB(true, (short) 0x3B),
    CHARACTER_CARD(true, (short) 0x3C),
    ENABLE_LV50_CHAR(true, (short) 0x3D),
    CREATE_LV50_CHAR(true, (short) 0x3E),
    ENABLE_SPECIAL_CREATION(true, (short) 0x3E),
    CLIENT_HELLO(false, (short) 0x3F),
    CREATE_SPECIAL_CHAR(true, (short) 0x41),
    CREATE_ULTIMATE(false, (short) 0x999),
    AUTH_SECOND_PASSWORD(true, (short) 0x47),
    WRONG_PASSWORD(false, (short) 0x49),//v145
    
    /*
     * Channel Opcodes.
     * Used for in-game packets.
     */
    ENTER_FARM(true, (short) 0x57),
    ENTER_AZWAN(true, (short) 0x999),//
    ENTER_AZWAN_EVENT(true, (short) 0x999),//4A
    LEAVE_AZWAN(true, (short) 0x999),//4B
    ENTER_PVP(true, (short) 0x50),
    ENTER_PVP_PARTY(true, (short) 0x999),
    LEAVE_PVP(true, (short) 0x999),
    PVP_ATTACK(true, (short) 0x69),
    FACE_ANDROID(true, (short) 0x6B),//6D

    ANGELIC_CHANGE(true, (short) 0x70),//72
    CHANGE_CODEX_SET(true, (short) 0x999),//7A
    CODEX_UNK(true, (short) 0x999),//7B
    MONSTER_BOOK_DROPS(true, (short) 0x7A),//7C

    MOVE_BAG(true, (short) 0x93),//95
    SWITCH_BAG(true, (short) 0x94),//96

    USE_RECIPE(true, (short) 0x9F),//9D
    USE_NEBULITE(true, (short) 0xA0),//9E
    USE_ALIEN_SOCKET(true, (short) 0xA1),//9F
    USE_ALIEN_SOCKET_RESPONSE(true, (short) 0x999),//A0
    USE_NEBULITE_FUSION(true, (short) 0xA3),//A1

    USE_EXP_POTION(true, (short) 0xAC),//A8
    TOT_GUIDE(true, (short) 0xB4),//B6
    USE_OWL_MINERVA(true, (short) 0xBC),//BA
    USE_TELE_ROCK(true, (short) 0xBD),//BB

    USE_FLAG_SCROLL(true, (short) 0x999),//BE
    USE_EQUIP_SCROLL(true, (short) 0x999),//BF
    USE_POTENTIAL_SCROLL(true, (short) 0x999),//C3
    USE_ABYSS_SCROLL(true, (short) 0x999),//C4
    USE_CARVED_SEAL(true, (short) 0x999),//C5
    USE_BAG(true, (short) 0x999),
    USE_CRAFTED_CUBE(true, (short) 0x999),
    USE_MAGNIFY_GLASS(true, (short) 0x999),//CA

    GET_BOOK_INFO(true, (short) 0xDF),//DC
    USE_FAMILIAR(true, (short) 0xE0),//DD
    SPAWN_FAMILIAR(true, (short) 0xE1),//DE
    RENAME_FAMILIAR(true, (short) 0xE2),//DF
    PET_BUFF(true, (short) 0xE3),//E0

    REPORT(true, (short) 0xEC),//E9

    REISSUE_MEDAL(true, (short) 0xEE),//EB
    //    BUFF_RESPONSE(true, (short) 0xEF),//EC

    REWARD_ITEM(true, (short) 0xF5),//F2
    ITEM_MAKER(true, (short) 0x999),
    REPAIR_ALL(true, (short) 0xFE),//C7
    REPAIR(true, (short) 0xFF),//C8
    SOLOMON(true, (short) 0xCA),//C9
    GACH_EXP(true, (short) 0xCB),//CA
    FOLLOW_REQUEST(true, (short) 0x102),//FD
    PQ_REWARD(true, (short) 0x103),//FE
    FOLLOW_REPLY(true, (short) 0x106),//101
    AUTO_FOLLOW_REPLY(true, (short) 0x999),
    USE_TREASURE_CHEST(true, (short) 0x999),
    PROFESSION_INFO(true, (short) 0x102),
    USE_POT(true, (short) 0x999),//D6
    CLEAR_POT(true, (short) 0x999),
    FEED_POT(true, (short) 0x999),
    CURE_POT(true, (short) 0x999),
    REWARD_POT(true, (short) 0xDA),
    AZWAN_REVIVE(true, (short) 0xDB),
    USE_COSMETIC(true, (short) 0x999),
    INNER_CIRCULATOR(true, (short) 0xDF),
    PVP_RESPAWN(true, (short) 0xE0),
    GAIN_FORCE(true, (short) 0xE1),
    SPOUSE_CHAT(true, (short) 0x12A),
    ALLOW_PARTY_INVITE(true, (short) 0x130),//12F
    EXPEDITION_OPERATION(true, (short) 0x999),//130
    EXPEDITION_LISTING(true, (short) 0x131),
    ADMIN_COMMAND(true, (short) 0x134),//12C
    ADMIN_LOG(true, (short) 0x135),//12D

    REQUEST_FAMILY(true, (short) 0x146),//13D
    OPEN_FAMILY(true, (short) 0x147),//13E
    FAMILY_OPERATION(true, (short) 0x148),//13F
    DELETE_JUNIOR(true, (short) 0x149),//140
    DELETE_SENIOR(true, (short) 0x14A),//141
    ACCEPT_FAMILY(true, (short) 0x14B),//142
    USE_FAMILY(true, (short) 0x14C),//143
    FAMILY_PRECEPT(true, (short) 0x14D),//144
    FAMILY_SUMMON(true, (short) 0x14E),//145

    SOLOMON_EXP(true, (short) 0x151),//151
    NEW_YEAR_CARD(true, (short) 0x11E),
    XMAS_SURPRISE(true, (short) 0x111),
    TWIN_DRAGON_EGG(true, (short) 0x112),
    ARAN_COMBO(true, (short) 0x15E),//0x152
    TRANSFORM_PLAYER(true, (short) 0x999),
    CYGNUS_SUMMON(true, (short) 0x999),
    CRAFT_DONE(true, (short) 0x162),//157
    CRAFT_EFFECT(true, (short) 0x163),//158
    CRAFT_MAKE(true, (short) 0x164),//159
    CHANGE_ROOM_CHANNEL(true, (short) 0x169),//15D
    EVENT_CARD(true, (short) 0x16A),//15E
    CHOOSE_SKILL(true, (short) 0x16B),//15F
    SKILL_SWIPE(true, (short) 0x16C),//160
    VIEW_SKILLS(true, (short) 0x16D),//161
    CANCEL_OUT_SWIPE(true, (short) 0x16E),//162
    YOUR_INFORMATION(true, (short) 0x16F),//163
    FIND_FRIEND(true, (short) 0x170),//164
    PINKBEAN_CHOCO_OPEN(true, (short) 0x171),//165
    PINKBEAN_CHOCO_SUMMON(true, (short) 0x172),//166
    BUY_SILENT_CRUSADE(true, (short) 0x127),
    CASSANDRAS_COLLECTION(true, (short) 0x178),//new v145
    BUDDY_ADD(true, (short) 0x1A2),
    MOVE_HAKU(true, (short) 0x1C1),//1B1
    CHANGE_HAKU(true, (short) 0x1C2),//1B2
    //HAKU_1D8(true, (short) 0x1D8),//test
    //HAKU_1D9(true, (short) 0x1D9),//test

    PVP_SUMMON(true, (short) 0x1CE),//1BE
    MOVE_DRAGON(true, (short) 0x1CF),//1C0
    USE_ITEM_QUEST(true, (short) 0x1D2),//1C4
    MOVE_ANDROID(true, (short) 0x1D3),//1C5
    UPDATE_QUEST(true, (short) 0x1D5),//1C7//+16
    QUEST_ITEM(true, (short) 0x1D6),//1D6
    MOVE_FAMILIAR(true, (short) 0x1DC),//1DC
    TOUCH_FAMILIAR(true, (short) 0x1DD),//1DD
    ATTACK_FAMILIAR(true, (short) 0x1DE),//1DE
    REVEAL_FAMILIAR(true, (short) 0x1DF),//1DF
    QUICK_SLOT(true, (short) 0x1D0),
    PAM_SONG(true, (short) 0x1D8),
    MONSTER_BOMB(true, (short) 0x21C),//212
    HYPNOTIZE_DMG(true, (short) 0x21D),//213

    MOB_BOMB(true, (short) 0x221),//217
    MOB_NODE(true, (short) 0x222),//218
    DISPLAY_NODE(true, (short) 0x223),//219

    MAKE_EXTRACTOR(true, (short) 0x23B),//231
    UPDATE_ENV(true, (short) 0x161),
    CANDY_RANKING(true, (short) 0x185),
    LUCKY_LUCKY_MONSTORY(true, (short) 0x198),//new v147
    SHIP_OBJECT(true, (short) 0x999),
    PARTY_SEARCH_START(true, (short) 0x24C),//24B
    PARTY_SEARCH_STOP(true, (short) 0x24D),//24C
    START_HARVEST(true, (short) 0x24F),//24E
    STOP_HARVEST(true, (short) 0x250),//24F
    QUICK_MOVE(true, (short) 0x999),//19E

    CASH_CATEGORY(true, (short) 0x2AD),//295
    PLACE_FARM_OBJECT(false, (short) 0x278),
    FARM_SHOP_BUY(false, (short) 0x27D),
    FARM_COMPLETE_QUEST(false, (short) 0x281),
    FARM_NAME(false, (short) 0x282),
    HARVEST_FARM_BUILDING(false, (short) 0x283),
    USE_FARM_ITEM(false, (short) 0x284),
    RENAME_MONSTER(false, (short) 0x999),
    NURTURE_MONSTER(false, (short) 0x295),
    EXIT_FARM(false, (short) 0x299),
    FARM_QUEST_CHECK(false, (short) 0x29D),
    FARM_FIRST_ENTRY(false, (short) 0x2A8),
    GOLDEN_HAMMER(true, (short) 0x2A4),
    VICIOUS_HAMMER(true, (short) 0x1BD),
    PYRAMID_BUY_ITEM(true, (short) 0x999),
    CLASS_COMPETITION(true, (short) 0x999),
    MAGIC_WHEEL(true, (short) 0x2EB),
    REWARD(true, (short) 0x2EC),
    BLACK_FRIDAY(true, (short) 0x2BE),
    RECEIVE_GIFT_EFFECT(true, (short) 0x2F5),//new v145
    UPDATE_RED_LEAF(true, (short) 0x29C),
    //Not Placed:
    ADMIN_CHAT(true, (short) 0x999),
    SPECIAL_STAT(false, (short) 0x10C),//107
    UPDATE_HYPER(true, (short) 0x171),//
    RESET_HYPER(true, (short) 0x172),//
    DRESSUP_TIME(true, (short) 0x17F),
    DF_COMBO(true, (short) 0x10F),
    BUTTON_PRESSED(true, (short) 0x1E9),//1D3
    OS_INFORMATION(true, (short) 0x1E6),//1D6
    LUCKY_LOGOUT(true, (short) 0x2B6),
    MESSENGER_RANKING(true, (short) 0x1DD),
    MECH_CANCEL(true, (short) 0x999),
    UNKNOWN;
    private short code = -2;

    @Override
    public void setValue(short code) {
        this.code = code;
    }

    @Override
    public final short getValue() {
        return code;
    }
    private final boolean CheckState;

    private RecvPacketOpcode() {
        this.CheckState = true;
    }

    private RecvPacketOpcode(final boolean CheckState) {
        this.CheckState = CheckState;
    }

    private RecvPacketOpcode(final boolean CheckState, short code) {
        this.CheckState = CheckState;
        this.code = code;
    }

    public final boolean NeedsChecking() {
        return CheckState;
    }

    public static String nameOf(short value) {
        for (RecvPacketOpcode header : RecvPacketOpcode.values()) {
            if (header.getValue() == value) {
                return header.name();
            }
        }
        return "UNKNOWN";
    }

    public static boolean isSpamHeader(RecvPacketOpcode header) {
        switch (header) {
            case PONG:
            case NPC_ACTION:
            //            case ENTER:
            //            case CRASH_INFO:
            //            case AUTH_REQUEST:
            case MOVE_LIFE:
            case MOVE_PLAYER:
            //            case SPECIAL_MOVE:
            //            case MOVE_ANDROID:
            //            case MOVE_DRAGON:
            case MOVE_SUMMON:
            //            case MOVE_FAMILIAR:
            case MOVE_PET:
            //            case CLOSE_RANGE_ATTACK:
            //case QUEST_ACTION:
            case AUTO_AGGRO:
            case HEAL_OVER_TIME:
            //            case CHANGE_KEYMAP:
            //            case USE_INNER_PORTAL:
            //            case MOVE_HAKU:
            //            case FRIENDLY_DAMAGE:
            //             case CLOSE_RANGE_ATTACK: //todo code zero
            //case RANGED_ATTACK: //todo code zero
                //            case ARAN_COMBO:
                //            case SPECIAL_STAT:
                //            case UPDATE_HYPER:
                //            case RESET_HYPER:
                //            case ANGELIC_CHANGE:
                //            case DRESSUP_TIME:
                //            case BUTTON_PRESSED:
                return true;
            default:
                return false;
        }
    }
}
