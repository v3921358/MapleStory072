package handling.channel.handler;

import java.util.ArrayList;
import java.util.List;
import client.MapleCharacter;
import client.MapleClient;
import tools.Triple;
import tools.data.LittleEndianAccessor;
import tools.packet.CField;
import tools.packet.CWvsContext;

public class BeanGame {

    public static final void BeansGameAction(LittleEndianAccessor slea, MapleClient c) {
        MapleCharacter chr = c.getPlayer();
        List<Triple<Short, Byte, Integer>> beansInfo = new ArrayList();
        int type = slea.readByte();
        int power;
        switch (type) {
            case 0: { // 調整鋼珠力道
                power = slea.readShort();
                chr.setBeansRange(power);
                break;
            }
            case 1: { // 開始打鋼珠
                break;
            }
            case 2: { // 暫停打鋼珠
                break;
            }
            case 3: { // 鋼珠進入蘑菇中獎區
                //[56 00 00 00 08 D5 AF 00 0F 00 18 00]
                //[79 00 00 00 19 2A B0 00 14 00 18 00]
                int beanNumber = slea.readInt(); // 中獎鋼珠序號
                int bb = slea.readInt();
                int cc = slea.readInt();

                System.out.println("aa: " + beanNumber);
                System.out.println("bb: " + bb);
                System.out.println("cc: " + cc);

                //c.sendPacket(MaplePacketCreator.shootBeans((byte) 0, beansInfo));
                c.getSession().write(CField.showBeansTips(new String[]{chr.getName()}));
                break;
            }
            case 6: { // 發射鋼珠訊息
                byte unk = slea.readByte(); // 未知,奇數個或偶數個?待實測
                byte shootNum = slea.readByte(); // 發射個數
                if (shootNum < 1) {
                    return;
                }
                for (int i = 0; i < shootNum; i++) {
                    int beanNumber = slea.readInt(); // 這場打鋼珠時的鋼珠序號(從0開始)
                    chr.setBeansNum(chr.getBeansNum() + 1);
                    if (beanNumber + 1 != chr.getBeansNum()) {
                        return;
                    }
                    
                    slea.readShort(); // Unk
                    slea.readShort(); // Unk
                    power = slea.readShort();
                    slea.readShort(); // Unk
                    beansInfo.add(new Triple((short) (power + rand(-100, 100)), (byte) getBeanType(), beanNumber));
                }
                chr.gainBeans(-shootNum);
                chr.setCanSetBeansNum(true);
                c.getSession().write(CField.shootBeans(unk, beansInfo));
                break;
            }
            default: {
                System.out.println("未處理的類型【" + type + "】\n包" + slea.toString());
                break;
            }
        }
    }

    private static int getBeanType() {
        int random = rand(1, 100);
        int beanType = 0;
        //3 - �?, 2 - ???, 1 - �?, 0 - ?��?�?
        switch (random) {
            case 2:
                beanType = 1; //�?
                break;
            case 49:
                beanType = 2; //???
                break;
            case 99:
                beanType = 3; //�?
                break;
        }
        return beanType;
    }

    private static int rand(int lbound, int ubound) {
        return (int) ((Math.random() * (ubound - lbound + 1)) + lbound);
    }

    public static final void BeansUpdate(LittleEndianAccessor slea, MapleClient c) {
        //c.getSession().write(CField.updateBeans(c.getPlayer().getId(), c.getPlayer().getBeans()));
        c.getSession().write(CWvsContext.enableActions());
    }
}
