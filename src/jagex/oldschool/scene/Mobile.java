package jagex.oldschool.scene;

import jagex.oldschool.CacheableNode_Sub2;
import jagex.oldschool.Class28;
import jagex.oldschool.Comparator0;
import jagex.oldschool.Client;
import jagex.oldschool.CombatInfo2;
import jagex.oldschool.CombatInfoListHolder;
import jagex.oldschool.RemoteEnvironment;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.collections.IterableQueue;
import jagex.oldschool.io.Buffer;

public abstract class Mobile extends Renderable {

  public int animation;
  public int queueSize;
  public int[] pathX;
  public int[] hitsplatCycles;
  public int[] pathY;
  public boolean aBool63;
  public int anInt496;
  public int anInt497;
  byte aByte4;
  public IterableQueue combatInfoList;
  public int actionAnimationDisable;
  public int anInt498;
  public int poseAnimation;
  public int anInt499;
  public int[] hitsplatTypes;
  public int idlePoseAnimation;
  public int actionFrame;
  public int anInt500;
  public int poseFrame;
  public int anInt501;
  public int anInt502;
  public byte[] aByteArray20;
  public int anInt503;
  public int x;
  public int[] anIntArray109;
  public int anInt504;
  public int anInt505;
  public int y;
  public int[] anIntArray110;
  public int anInt506;
  public int anInt507;
  public int[] anIntArray111;
  public String overhead;
  public int graphic;
  public boolean inSequence;
  public int anInt508;
  public int anInt509;
  public int anInt510;
  public int anInt511;
  public int anInt512;
  public int interacting;
  public boolean aBool64;
  public int orientation;
  public int anInt513;
  public int anInt514;
  public int anInt515;
  public int anInt516;
  public int anInt517;
  public int anInt518;
  public int anInt519;
  public int angle;
  public int anInt520;
  public int anInt521;
  public int anInt522;
  public int anInt523;
  public int anInt524;
  public int anInt525;
  public int anInt526;
  public int graphicsDelay;
  public boolean aBool65;

  Mobile() {
    aBool63 = false;
    anInt499 = 1;
    idlePoseAnimation = -1;
    anInt500 = -1;
    anInt501 = -1;
    anInt502 = -1;
    anInt503 = -1;
    anInt504 = -1;
    anInt505 = -1;
    anInt506 = -1;
    overhead = null;
    inSequence = false;
    anInt509 = 100;
    anInt510 = 0;
    anInt511 = 0;
    aByte4 = 0;
    anIntArray109 = new int[4];
    hitsplatTypes = new int[4];
    hitsplatCycles = new int[4];
    anIntArray110 = new int[4];
    anIntArray111 = new int[4];
    combatInfoList = new IterableQueue();
    interacting = -1;
    aBool64 = false;
    anInt496 = -1;
    poseAnimation = -1;
    poseFrame = 0;
    anInt513 = 0;
    animation = -1;
    actionFrame = 0;
    anInt514 = 0;
    actionAnimationDisable = 0;
    anInt515 = 0;
    graphic = -1;
    anInt508 = 0;
    anInt516 = 0;
    anInt517 = 0;
    anInt507 = 200;
    anInt518 = 0;
    anInt519 = 32;
    queueSize = 0;
    pathX = new int[10];
    pathY = new int[10];
    aByteArray20 = new byte[10];
    anInt498 = 0;
    anInt497 = 0;
  }

  public static void method914() {
    Client.outbound.putEncipheredByte(187);

    for (OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable
        .method66(); widgetnode_0 != null;
        widgetnode_0 = (OpenedInterface) Client.componentTable.method67()) {
      if (widgetnode_0.owner == 0 || widgetnode_0.owner == 3) {
        Comparator0.method305(widgetnode_0, true);
      }
    }

    if (Client.aWidget13 != null) {
      Class28.method236(Client.aWidget13);
      Client.aWidget13 = null;
    }

  }

  public boolean hasConfig() {
    return false;
  }

  public final void method910() {
    queueSize = 0;
    anInt497 = 0;
  }

  public final void method911(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5) {
    boolean bool_0 = true;
    boolean bool_1 = true;

    int int_6;
    for (int_6 = 0; int_6 < 4; int_6++) {
      if (hitsplatCycles[int_6] > int_4) {
        bool_0 = false;
      } else {
        bool_1 = false;
      }
    }

    int_6 = -1;
    int int_7 = -1;
    int int_8 = 0;
    if (int_0 >= 0) {
      final CacheableNode_Sub2 cacheablenode_sub2_0 = RemoteEnvironment.method523(int_0);
      int_7 = cacheablenode_sub2_0.anInt469;
      int_8 = cacheablenode_sub2_0.anInt471;
    }

    int int_9;
    if (bool_1) {
      if (int_7 == -1) {
        return;
      }

      int_6 = 0;
      int_9 = 0;
      if (int_7 == 0) {
        int_9 = hitsplatCycles[0];
      } else if (int_7 == 1) {
        int_9 = hitsplatTypes[0];
      }

      for (int int_10 = 1; int_10 < 4; int_10++) {
        if (int_7 == 0) {
          if (hitsplatCycles[int_10] < int_9) {
            int_6 = int_10;
            int_9 = hitsplatCycles[int_10];
          }
        } else if (int_7 == 1 && hitsplatTypes[int_10] < int_9) {
          int_6 = int_10;
          int_9 = hitsplatTypes[int_10];
        }
      }

      if (int_7 == 1 && int_9 >= int_1) {
        return;
      }
    } else {
      if (bool_0) {
        aByte4 = 0;
      }

      for (int_9 = 0; int_9 < 4; int_9++) {
        final byte byte_0 = aByte4;
        aByte4 = (byte) ((aByte4 + 1) % 4);
        if (hitsplatCycles[byte_0] <= int_4) {
          int_6 = byte_0;
          break;
        }
      }
    }

    if (int_6 >= 0) {
      anIntArray109[int_6] = int_0;
      hitsplatTypes[int_6] = int_1;
      anIntArray110[int_6] = int_2;
      anIntArray111[int_6] = int_3;
      hitsplatCycles[int_6] = int_4 + int_8 + int_5;
    }
  }

  public final void method912(final int int_0) {
    CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.aNodeCache7.get(int_0);
    CombatInfo2 combatinfo2_1;
    if (combatinfo2_0 != null) {
      combatinfo2_1 = combatinfo2_0;
    } else {
      final byte[] bytes_0 = CombatInfo2.anIndexDataBase19.get(33, int_0);
      combatinfo2_0 = new CombatInfo2();
      if (bytes_0 != null) {
        combatinfo2_0.method782(new Buffer(bytes_0));
      }

      CombatInfo2.aNodeCache7.put(combatinfo2_0, int_0);
      combatinfo2_1 = combatinfo2_0;
    }

    combatinfo2_0 = combatinfo2_1;

    for (CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) combatInfoList
        .getFirst(); combatinfolistholder_0 != null;
        combatinfolistholder_0 = (CombatInfoListHolder) combatInfoList
            .getNext()) {
      if (combatinfo2_0 == combatinfolistholder_0.combatInfo2) {
        combatinfolistholder_0.unlink();
        return;
      }
    }

  }

  public final void method913(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5) {
    CombatInfo2 combatinfo2_0 = (CombatInfo2) CombatInfo2.aNodeCache7.get(int_0);
    CombatInfo2 combatinfo2_1;
    if (combatinfo2_0 != null) {
      combatinfo2_1 = combatinfo2_0;
    } else {
      final byte[] bytes_0 = CombatInfo2.anIndexDataBase19.get(33, int_0);
      combatinfo2_0 = new CombatInfo2();
      if (bytes_0 != null) {
        combatinfo2_0.method782(new Buffer(bytes_0));
      }

      CombatInfo2.aNodeCache7.put(combatinfo2_0, int_0);
      combatinfo2_1 = combatinfo2_0;
    }

    combatinfo2_0 = combatinfo2_1;
    CombatInfoListHolder combatinfolistholder_2 = null;
    CombatInfoListHolder combatinfolistholder_0 = null;
    int int_6 = combatinfo2_1.anInt445;
    int int_7 = 0;

    CombatInfoListHolder combatinfolistholder_1;
    for (combatinfolistholder_1 = (CombatInfoListHolder) combatInfoList
        .getFirst(); combatinfolistholder_1 != null;
        combatinfolistholder_1 = (CombatInfoListHolder) combatInfoList
            .getNext()) {
      ++int_7;
      if (combatinfolistholder_1.combatInfo2.anInt448 == combatinfo2_0.anInt448) {
        combatinfolistholder_1.method639(int_1 + int_3, int_4, int_5, int_2);
        return;
      }

      if (combatinfolistholder_1.combatInfo2.anInt443 <= combatinfo2_0.anInt443) {
        combatinfolistholder_2 = combatinfolistholder_1;
      }

      if (combatinfolistholder_1.combatInfo2.anInt445 > int_6) {
        combatinfolistholder_0 = combatinfolistholder_1;
        int_6 = combatinfolistholder_1.combatInfo2.anInt445;
      }
    }

    if (combatinfolistholder_0 != null || int_7 < 4) {
      combatinfolistholder_1 = new CombatInfoListHolder(combatinfo2_0);
      if (combatinfolistholder_2 == null) {
        combatInfoList.addFirst(combatinfolistholder_1);
      } else {
        IterableQueue.appendAsChild(combatinfolistholder_1, combatinfolistholder_2);
      }

      combatinfolistholder_1.method639(int_1 + int_3, int_4, int_5, int_2);
      if (int_7 >= 4) {
        combatinfolistholder_0.unlink();
      }

    }
  }

}
