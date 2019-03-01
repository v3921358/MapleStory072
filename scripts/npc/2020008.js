/** 
 Tylus: Warrior 3rd job advancement
 El Nath: Chief's Residence (211000001)
 
 Custom Quest 100100, 100102
 */

var status = 0;
var job;
function start() {
    status = -1;
    action(1, 0, 0);
}

function action(mode, type, selection) {
    if (mode == 0 && status == 1) {
        cm.sendOk("等您下定決心再次找我吧.");
        cm.dispose();
        return;
    }
    if (mode == 1)
        status++;
    else
        status--;
    if (status == 0) {
        if (!(cm.getJob() == 110 || cm.getJob() == 120 || cm.getJob() == 130 || cm.getJob() == 2110)) {
            if (cm.getQuestStatus(6192) == 1) {
                if (cm.getParty() != null) {
                    var ddz = cm.getEventManager("ProtectTylus");
                    if (ddz == null) {
                        cm.sendOk("发生未知错误");
                    } else {
                        var prop = ddz.getProperty("state");
                        if (prop == null || prop.equals("0")) {
                            ddz.startInstance(cm.getParty(), cm.getMap());
                        } else {
                            cm.sendOk("别人已经在试图保护Tylus,请稍后再试。");
                        }
                    }
                } else {
                    cm.sendOk("Please form a party in order to protect Tylus!");
                }
            } else if (cm.getQuestStatus(6192) == 2) {
                cm.sendOk("You have protected me. Thank you. I will teach you stance skill.");
                if (cm.getJob() == 112) {
                    if (cm.getPlayer().getMasterLevel(1121002) <= 0) {
                        cm.teachSkill(1121002, 0, 10);
                    }
                } else if (cm.getJob() == 122) {
                    if (cm.getPlayer().getMasterLevel(1221002) <= 0) {
                        cm.teachSkill(1221002, 0, 10);
                    }
                } else if (cm.getJob() == 132) {
                    if (cm.getPlayer().getMasterLevel(1321002) <= 0) {
                        cm.teachSkill(1321002, 0, 10);
                    }
                }
            } else {
                cm.sendOk("May the Gods be with you!");
            }
            cm.dispose();
            return;
        }

        if ((cm.getJob() == 110 || cm.getJob() == 120 || cm.getJob() == 130) && cm.getPlayerStat("LVL") >= 70) {
            if (cm.getQuestStatus(100100) == 0 || cm.getQuestStatus(100100) == 1) {
                cm.sendOk("你是否要进行第三次转职？嗯,很好。现在去找#b#p1022000##k，他将会给你提供线索。");
                cm.forceStartQuest(100100);
                cm.dispose();
            } else if (cm.getQuestStatus(100102) == 1) {
                if (cm.haveItem(4031057)) {
                    cm.gainItem(4031057, -1);
                }
                cm.sendOk("去雪原圣地找回遗失的#r智慧项链#k。");
                cm.dispose();
            } else if (cm.getQuestStatus(100102) == 2) {
                cm.sendNext("#rBy Odin's ring!#k Indeed, you have proven to be worthy of the strength I will now bestow upon you.");
            } else if ((cm.getJob() == 110 || cm.getJob() == 120 || cm.getJob() == 130) && cm.getPlayerStat("LVL") >= 70 && cm.getPlayerStat("RSP") > (cm.getPlayerStat("LVL") - 70) * 3) {
                cm.sendNext("#rBy Odin's beard!#k You are a strong one.");
            } else {
                cm.sendOk("Your time has yet to come...");
                cm.dispose();
            }
        }

        /*if ((cm.getJob() == 110 || cm.getJob() == 120 || cm.getJob() == 130) && cm.getPlayerStat("LVL") >= 70) {
         if (cm.getPlayerStat("RSP") > (cm.getPlayerStat("LVL") - 70) * 3) {
         if (cm.getPlayer().getAllSkillLevels() > cm.getPlayerStat("LVL") * 3) { //player used too much SP means they have assigned to their skills.. conflict
         cm.sendOk("It appears that you have a great number of SP yet you have used enough SP on your skills already. Your SP has been reset. #ePlease talk to me again to make the job advancement.#n");
         cm.getPlayer().resetSP((cm.getPlayerStat("LVL") - 70) * 3);
         } else {
         cm.sendOk("Hmm...You have too many #bSP#k. You can't make the job advancement with too many SP left.");
         }
         cm.safeDispose();
         } else {
         cm.sendNext("You are indeed a strong one.");
         }
         } else {
         cm.sendOk("Please make sure that you are eligible for the job advancement. (level 70+)");
         cm.safeDispose();
         }*/
    } else if (status == 1) {

        if (cm.getQuestStatus(100102) == 2) {
            if (cm.getPlayerStat("LVL") >= 70 && cm.getPlayerStat("RSP") <= (cm.getPlayerStat("LVL") - 70) * 3) {
                if (cm.getJob() == 110) { // FIGHTER
                    cm.changeJob(111); // CRUSADER
                    cm.sendOk("You are now a #bCrusader#k.");
                    cm.dispose();
                } else if (cm.getJob() == 120) { // PAGE
                    cm.changeJob(121); // WHITEKNIHT
                    cm.sendOk("You are now a #bWhite Knight#k.");
                    cm.dispose();
                } else if (cm.getJob() == 130) { // SPEARMAN
                    cm.changeJob(131); // DRAGONKNIGHT
                    cm.sendOk("You are now a #bDragon Knight#k");
                    cm.dispose();
                } else if (cm.getJob() == 2110) { // ARAN
                    cm.changeJob(2111); // ARAN
                    if (cm.canHold(1142131, 1)) {
                        cm.forceCompleteQuest(29926);
                        cm.gainItem(1142131, 1); //temp fix
                    }
                    cm.sendOk("You are now a #bAran#k.");
                    cm.dispose();
                }
            } else {
                cm.sendOk("Come back when you are level 70 and used SP.");
                cm.dispose();
            }
        } else if (cm.getQuestStatus(100100) == 2) {
            cm.sendAcceptDecline("Is your mind ready to undertake the final test?");
        } else {
            cm.sendAcceptDecline("But I can make you even stronger. Although you will have to prove not only your strength but your knowledge. Are you ready for the challenge?");
        }

    }
}