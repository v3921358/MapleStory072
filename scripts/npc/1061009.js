/* Door of Dimension
 Enter 3rd job event
 */

function start() {
    if (cm.getQuestStatus(100101) == 1 && !cm.haveItem(4031059)) {
        //var em = cm.getEventManager("3rdjob");
        //if (em == null) {
        //    cm.sendOk("Sorry, but everything is broken.");
        //} else {
        //    em.newInstance(cm.getName()).registerPlayer(cm.getChar());
        //}
        //} else {
        //cm.sendOk("lul.");
        if (cm.getPlayer().getMapId() == 100040106 && cm.getJob() == 210 || cm.getJob() == 220 || cm.getJob() == 230) {
            cm.resetMap(108010201);
            cm.warp(108010200, 0);
            //cm.spawnMobOnMap(9001001, 1, -276, -3, 108010201);
            cm.dispose();
        } else if (cm.getPlayer().getMapId() == 105070001 && cm.getJob() == 110 || cm.getJob() == 120 || cm.getJob() == 130 || cm.getJob() == 2110) {
            cm.resetMap(108010301);
            cm.warp(108010300, 0);
            //cm.spawnMobOnMap(9001000, 1, -276, -3, 108010301);
            cm.dispose();
        } else if (cm.getPlayer().getMapId() == 105040305 && cm.getJob() == 310 || cm.getJob() == 320) {
            cm.resetMap(108010101);
            cm.warp(108010100, 0);
            //cm.spawnMobOnMap(9001002, 1, -276, -3, 108010101);
            cm.dispose();
        } else if (cm.getPlayer().getMapId() == 107000402 && cm.getJob() == 410 || cm.getJob() == 420) {
            cm.resetMap(108010401);
            cm.warp(108010400, 0);
            //cm.spawnMobOnMap(9001003, 1, -276, -3, 108010401);
            cm.dispose();
        } else if (cm.getPlayer().getMapId() == 105070200 && cm.getJob() == 510 || cm.getJob() == 520) {
            cm.resetMap(108010501);
            cm.warp(108010500, 0);
            //cm.spawnMobOnMap(9001004, 1, -276, -3, 108010501);
            cm.dispose();
        } else {
            cm.sendOk("发生未知错误。");
            cm.dispose();
        }

    }
    cm.dispose();
}

function action(mode, type, selection) {

}