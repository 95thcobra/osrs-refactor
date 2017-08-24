package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.collections.HashTable;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.social.Ignore;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;

public class AClass4_Sub3 extends AClass4 {

  int anInt450;
  int anInt451;
  int[] anIntArray86;
  int[] anIntArray87;
  HashTable aHashTable8;
  int[] anIntArray88;
  int[] anIntArray89;
  int[] anIntArray90;
  Node_Sub3[][] aNode_Sub3ArrayArray1;
  int[] anIntArray91;
  Class74 aClass74_1;
  AClass4_Sub4 anAClass4_Sub4_1;
  int[] anIntArray92;
  int anInt452;
  int[] anIntArray93;
  int[] anIntArray94;
  long aLong19;
  int[] anIntArray95;
  int[] anIntArray96;
  int anInt453;
  Node_Sub3[][] aNode_Sub3ArrayArray2;
  boolean aBool53;
  int[] anIntArray97;
  int[] anIntArray98;
  long aLong20;
  int[] anIntArray99;
  int[] anIntArray100;

  public AClass4_Sub3() {
    anInt451 = 256;
    anInt453 = 1000000;
    anIntArray92 = new int[16];
    anIntArray88 = new int[16];
    anIntArray95 = new int[16];
    anIntArray90 = new int[16];
    anIntArray89 = new int[16];
    anIntArray94 = new int[16];
    anIntArray87 = new int[16];
    anIntArray99 = new int[16];
    anIntArray98 = new int[16];
    anIntArray91 = new int[16];
    anIntArray100 = new int[16];
    anIntArray97 = new int[16];
    anIntArray96 = new int[16];
    anIntArray86 = new int[16];
    anIntArray93 = new int[16];
    aNode_Sub3ArrayArray1 = new Node_Sub3[16][128];
    aNode_Sub3ArrayArray2 = new Node_Sub3[16][128];
    aClass74_1 = new Class74();
    anAClass4_Sub4_1 = new AClass4_Sub4(this);
    aHashTable8 = new HashTable(128);
    method794();
  }

  static void method818(final int int_0) {
    if (int_0 != -1) {
      if (Ignore.loadWidget(int_0)) {
        final InterfaceComponent[] widgets_0 = Time.widgets[int_0];

        for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
          final InterfaceComponent widget_0 = widgets_0[int_1];
          if (widget_0.anObjectArray5 != null) {
            final ScriptCall scriptevent_0 = new ScriptCall();
            scriptevent_0.widget = widget_0;
            scriptevent_0.anObjectArray22 = widget_0.anObjectArray5;
            ScriptExecutor.execute(scriptevent_0, 2000000);
          }
        }

      }
    }
  }

  public static InterfaceComponent method819(final int int_0, final int int_1) {
    final InterfaceComponent widget_0 = ScriptExecutor.method240(int_0);
    return int_1 == -1 ? widget_0
        : widget_0 != null && widget_0.children != null && int_1 < widget_0.children.length
            ? widget_0.children[int_1]
            : null;
  }

  void method787(final int int_0, final int int_1) {
    anIntArray90[int_0] = int_1;
    anIntArray94[int_0] = int_1 & 0xFFFFFF80;
    method795(int_0, int_1);
  }

  void method788(final int int_0, final int int_1, final int int_2) {
    final Node_Sub3 node_sub3_0 = aNode_Sub3ArrayArray1[int_0][int_1];
    if (node_sub3_0 != null) {
      aNode_Sub3ArrayArray1[int_0][int_1] = null;
      if ((anIntArray91[int_0] & 0x2) == 0) {
        node_sub3_0.anInt345 = 0;
      } else {
        for (Node_Sub3 node_sub3_1 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
            .getFirst(); node_sub3_1 != null; node_sub3_1 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
            .getNext()) {
          if (node_sub3_1.anInt343 == node_sub3_0.anInt343 && node_sub3_1.anInt345 < 0
              && node_sub3_1 != node_sub3_0) {
            node_sub3_0.anInt345 = 0;
            break;
          }
        }

      }
    }
  }

  void method789(final int int_0) {
    for (Node_Sub3 node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
        .getFirst(); node_sub3_0 != null;
        node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6.getNext()) {
      if (int_0 < 0 || node_sub3_0.anInt343 == int_0) {
        if (node_sub3_0.anAClass4_Sub2_3 != null) {
          node_sub3_0.anAClass4_Sub2_3.method738(AbstractSourceLine.sampleRate / 100);
          if (node_sub3_0.anAClass4_Sub2_3.method740()) {
            anAClass4_Sub4_1.anAClass4_Sub1_2.method721(node_sub3_0.anAClass4_Sub2_3);
          }

          node_sub3_0.method657();
        }

        if (node_sub3_0.anInt345 < 0) {
          aNode_Sub3ArrayArray1[node_sub3_0.anInt343][node_sub3_0.anInt351] = null;
        }

        node_sub3_0.unlink();
      }
    }

  }

  public synchronized void method790() {
    aClass74_1.method432();
    method794();
  }

  void method791(int int_0) {
    if (int_0 >= 0) {
      anIntArray92[int_0] = 12800;
      anIntArray88[int_0] = 8192;
      anIntArray95[int_0] = 16383;
      anIntArray87[int_0] = 8192;
      anIntArray99[int_0] = 0;
      anIntArray98[int_0] = 8192;
      method801(int_0);
      method803(int_0);
      anIntArray91[int_0] = 0;
      anIntArray100[int_0] = 32767;
      anIntArray97[int_0] = 256;
      anIntArray96[int_0] = 0;
      method810(int_0, 8192);
    } else {
      for (int_0 = 0; int_0 < 16; int_0++) {
        method791(int_0);
      }

    }
  }

  void method792(final int int_0, final int int_1, final int int_2) {
  }

  void method793(final int int_0, final int int_1, final int int_2) {
    method788(int_0, int_1, 64);
    if ((anIntArray91[int_0] & 0x2) != 0) {
      for (Node_Sub3 node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
          .getLast(); node_sub3_0 != null;
          node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6.getPrevious()) {
        if (node_sub3_0.anInt343 == int_0 && node_sub3_0.anInt345 < 0) {
          aNode_Sub3ArrayArray1[int_0][node_sub3_0.anInt351] = null;
          aNode_Sub3ArrayArray1[int_0][int_1] = node_sub3_0;
          final int int_3 =
              (node_sub3_0.anInt342 * node_sub3_0.anInt341 >> 12) + node_sub3_0.anInt344;
          node_sub3_0.anInt344 += int_1 - node_sub3_0.anInt351 << 8;
          node_sub3_0.anInt342 = int_3 - node_sub3_0.anInt344;
          node_sub3_0.anInt341 = 4096;
          node_sub3_0.anInt351 = int_1;
          return;
        }
      }
    }

    final Node_Sub5 node_sub5_0 = (Node_Sub5) aHashTable8.get(anIntArray89[int_0]);
    if (node_sub5_0 != null) {
      final AClass5_Sub1 aclass5_sub1_0 = node_sub5_0.anAClass5_Sub1Array1[int_1];
      if (aclass5_sub1_0 != null) {
        final Node_Sub3 node_sub3_1 = new Node_Sub3();
        node_sub3_1.anInt343 = int_0;
        node_sub3_1.aNode_Sub5_1 = node_sub5_0;
        node_sub3_1.anAClass5_Sub1_1 = aclass5_sub1_0;
        node_sub3_1.aClass78_1 = node_sub5_0.aClass78Array1[int_1];
        node_sub3_1.anInt348 = node_sub5_0.aByteArray16[int_1];
        node_sub3_1.anInt351 = int_1;
        node_sub3_1.anInt349 =
            int_2 * int_2 * node_sub5_0.aByteArray14[int_1] * node_sub5_0.anInt365
                + 1024 >> 11;
        node_sub3_1.anInt347 = node_sub5_0.aByteArray15[int_1] & 0xFF;
        node_sub3_1.anInt344 = (int_1 << 8) - (node_sub5_0.aShortArray5[int_1] & 0x7FFF);
        node_sub3_1.anInt352 = 0;
        node_sub3_1.anInt355 = 0;
        node_sub3_1.anInt356 = 0;
        node_sub3_1.anInt345 = -1;
        node_sub3_1.anInt357 = 0;
        if (anIntArray96[int_0] == 0) {
          node_sub3_1.anAClass4_Sub2_3 = AClass4_Sub2
              .method768(aclass5_sub1_0, method798(node_sub3_1),
                  method814(node_sub3_1), method815(node_sub3_1));
        } else {
          node_sub3_1.anAClass4_Sub2_3 = AClass4_Sub2
              .method768(aclass5_sub1_0, method798(node_sub3_1), 0,
                  method815(node_sub3_1));
          method813(node_sub3_1, node_sub5_0.aShortArray5[int_1] < 0);
        }

        if (node_sub5_0.aShortArray5[int_1] < 0) {
          node_sub3_1.anAClass4_Sub2_3.method747(-1);
        }

        if (node_sub3_1.anInt348 >= 0) {
          final Node_Sub3 node_sub3_2 = aNode_Sub3ArrayArray2[int_0][node_sub3_1.anInt348];
          if (node_sub3_2 != null && node_sub3_2.anInt345 < 0) {
            aNode_Sub3ArrayArray1[int_0][node_sub3_2.anInt351] = null;
            node_sub3_2.anInt345 = 0;
          }

          aNode_Sub3ArrayArray2[int_0][node_sub3_1.anInt348] = node_sub3_1;
        }

        anAClass4_Sub4_1.aDeque6.addLast(node_sub3_1);
        aNode_Sub3ArrayArray1[int_0][int_1] = node_sub3_1;
      }
    }
  }

  void method794() {
    method789(-1);
    method791(-1);

    int int_0;
    for (int_0 = 0; int_0 < 16; int_0++) {
      anIntArray89[int_0] = anIntArray90[int_0];
    }

    for (int_0 = 0; int_0 < 16; int_0++) {
      anIntArray94[int_0] = anIntArray90[int_0] & 0xFFFFFF80;
    }

  }

  void method795(final int int_0, final int int_1) {
    if (int_1 != anIntArray89[int_0]) {
      anIntArray89[int_0] = int_1;

      for (int int_2 = 0; int_2 < 128; int_2++) {
        aNode_Sub3ArrayArray2[int_0][int_2] = null;
      }
    }

  }

  @Override
  public synchronized void method632(final int[] ints_0, int int_0, int int_1) {
    if (aClass74_1.method433()) {
      final int int_2 = aClass74_1.anInt172 * anInt453 / AbstractSourceLine.sampleRate;

      do {
        final long long_0 = aLong20 + (long) int_1 * (long) int_2;
        if (aLong19 - long_0 >= 0L) {
          aLong20 = long_0;
          break;
        }

        final int int_3 = (int) ((aLong19 - aLong20 + int_2 - 1L) / int_2);
        aLong20 += (long) int_3 * (long) int_2;
        anAClass4_Sub4_1.method632(ints_0, int_0, int_3);
        int_0 += int_3;
        int_1 -= int_3;
        method812();
      } while (aClass74_1.method433());
    }

    anAClass4_Sub4_1.method632(ints_0, int_0, int_1);
  }

  @Override
  public synchronized void method633(int int_0) {
    if (aClass74_1.method433()) {
      final int int_1 = aClass74_1.anInt172 * anInt453 / AbstractSourceLine.sampleRate;

      do {
        final long long_0 = (long) int_1 * (long) int_0 + aLong20;
        if (aLong19 - long_0 >= 0L) {
          aLong20 = long_0;
          break;
        }

        final int int_2 = (int) ((int_1 + aLong19 - aLong20 - 1L) / int_1);
        aLong20 += (long) int_2 * (long) int_1;
        anAClass4_Sub4_1.method633(int_2);
        int_0 -= int_2;
        method812();
      } while (aClass74_1.method433());
    }

    anAClass4_Sub4_1.method633(int_0);
  }

  void method796(final int int_0, final int int_1) {
  }

  void method797(final int int_0, final int int_1) {
    anIntArray87[int_0] = int_1;
  }

  @Override
  public synchronized AClass4 method635() {
    return null;
  }

  int method798(final Node_Sub3 node_sub3_0) {
    int int_0 = (node_sub3_0.anInt341 * node_sub3_0.anInt342 >> 12) + node_sub3_0.anInt344;
    int_0 +=
        (anIntArray87[node_sub3_0.anInt343] - 8192) * anIntArray97[node_sub3_0.anInt343] >> 12;
    final Class78 class78_0 = node_sub3_0.aClass78_1;
    int int_1;
    if (class78_0.anInt174 > 0 && (class78_0.anInt176 > 0 || anIntArray99[node_sub3_0.anInt343]
        > 0)) {
      int_1 = class78_0.anInt176 << 2;
      final int int_2 = class78_0.anInt177 << 1;
      if (node_sub3_0.anInt353 < int_2) {
        int_1 = int_1 * node_sub3_0.anInt353 / int_2;
      }

      int_1 += anIntArray99[node_sub3_0.anInt343] >> 7;
      final double double_0 = Math.sin(0.01227184630308513D * (node_sub3_0.anInt354 & 0x1FF));
      int_0 += (int) (double_0 * int_1);
    }

    int_1 = (int) (node_sub3_0.anAClass5_Sub1_1.anInt405 * 256 * Math
        .pow(2.0D, 3.255208333333333E-4D * int_0)
        / AbstractSourceLine.sampleRate + 0.5D);
    return int_1 < 1 ? 1 : int_1;
  }

  public synchronized boolean method799(final MidiFile track1_0, final AbstractPackage indexdatabase_0,
      final Class55 class55_0, final int int_0) {
    track1_0.method708();
    boolean bool_0 = true;
    int[] ints_0 = null;
    if (int_0 > 0) {
      ints_0 = new int[] {int_0};
    }

    for (Node_Sub4 node_sub4_0 = (Node_Sub4) track1_0.aHashTable7
        .method66(); node_sub4_0 != null;
        node_sub4_0 = (Node_Sub4) track1_0.aHashTable7.method67()) {
      final int int_1 = (int) node_sub4_0.hash;
      Node_Sub5 node_sub5_0 = (Node_Sub5) aHashTable8.get(int_1);
      if (node_sub5_0 == null) {
        final byte[] bytes_0 = indexdatabase_0.method453(int_1);
        Node_Sub5 node_sub5_1;
        if (bytes_0 == null) {
          node_sub5_1 = null;
        } else {
          node_sub5_1 = new Node_Sub5(bytes_0);
        }

        node_sub5_0 = node_sub5_1;
        if (node_sub5_1 == null) {
          bool_0 = false;
          continue;
        }

        aHashTable8.put(node_sub5_1, int_1);
      }

      if (!node_sub5_0.method676(class55_0, node_sub4_0.aByteArray13, ints_0)) {
        bool_0 = false;
      }
    }

    if (bool_0) {
      track1_0.method709();
    }

    return bool_0;
  }

  boolean method800(final Node_Sub3 node_sub3_0) {
    if (node_sub3_0.anAClass4_Sub2_3 == null) {
      if (node_sub3_0.anInt345 >= 0) {
        node_sub3_0.unlink();
        if (node_sub3_0.anInt348 > 0
            && node_sub3_0 == aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348]) {
          aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348] = null;
        }
      }

      return true;
    }
    return false;
  }

  void method801(final int int_0) {
    if ((anIntArray91[int_0] & 0x2) != 0) {
      for (Node_Sub3 node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
          .getFirst(); node_sub3_0 != null;
          node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6.getNext()) {
        if (node_sub3_0.anInt343 == int_0 && aNode_Sub3ArrayArray1[int_0][node_sub3_0.anInt351]
            == null
            && node_sub3_0.anInt345 < 0) {
          node_sub3_0.anInt345 = 0;
        }
      }
    }

  }

  int method802() {
    return anInt451;
  }

  void method803(final int int_0) {
    if ((anIntArray91[int_0] & 0x4) != 0) {
      for (Node_Sub3 node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
          .getFirst(); node_sub3_0 != null;
          node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6.getNext()) {
        if (node_sub3_0.anInt343 == int_0) {
          node_sub3_0.anInt350 = 0;
        }
      }
    }

  }

  void method804(final int int_0) {
    int int_1 = int_0 & 0xF0;
    int int_2;
    int int_3;
    int int_4;
    if (int_1 == 128) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      int_4 = int_0 >> 16 & 0x7F;
      method788(int_2, int_3, int_4);
    } else if (int_1 == 144) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      int_4 = int_0 >> 16 & 0x7F;
      if (int_4 > 0) {
        method793(int_2, int_3, int_4);
      } else {
        method788(int_2, int_3, 64);
      }
    } else if (int_1 == 160) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      int_4 = int_0 >> 16 & 0x7F;
      method792(int_2, int_3, int_4);
    } else if (int_1 == 176) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      int_4 = int_0 >> 16 & 0x7F;
      if (int_3 == 0) {
        anIntArray94[int_2] = (int_4 << 14) + (anIntArray94[int_2] & 0xFFE03FFF);
      }

      if (int_3 == 32) {
        anIntArray94[int_2] = (int_4 << 7) + (anIntArray94[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 1) {
        anIntArray99[int_2] = (int_4 << 7) + (anIntArray99[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 33) {
        anIntArray99[int_2] = int_4 + (anIntArray99[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 5) {
        anIntArray98[int_2] = (int_4 << 7) + (anIntArray98[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 37) {
        anIntArray98[int_2] = int_4 + (anIntArray98[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 7) {
        anIntArray92[int_2] = (int_4 << 7) + (anIntArray92[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 39) {
        anIntArray92[int_2] = int_4 + (anIntArray92[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 10) {
        anIntArray88[int_2] = (int_4 << 7) + (anIntArray88[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 42) {
        anIntArray88[int_2] = int_4 + (anIntArray88[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 11) {
        anIntArray95[int_2] = (int_4 << 7) + (anIntArray95[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 43) {
        anIntArray95[int_2] = int_4 + (anIntArray95[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 64) {
        if (int_4 >= 64) {
          anIntArray91[int_2] |= 0x1;
        } else {
          anIntArray91[int_2] &= 0xFFFFFFFE;
        }
      }

      if (int_3 == 65) {
        if (int_4 >= 64) {
          anIntArray91[int_2] |= 0x2;
        } else {
          method801(int_2);
          anIntArray91[int_2] &= 0xFFFFFFFD;
        }
      }

      if (int_3 == 99) {
        anIntArray100[int_2] = (int_4 << 7) + (anIntArray100[int_2] & 0x7F);
      }

      if (int_3 == 98) {
        anIntArray100[int_2] = (anIntArray100[int_2] & 0x3F80) + int_4;
      }

      if (int_3 == 101) {
        anIntArray100[int_2] = (int_4 << 7) + (anIntArray100[int_2] & 0x7F) + 16384;
      }

      if (int_3 == 100) {
        anIntArray100[int_2] = (anIntArray100[int_2] & 0x3F80) + int_4 + 16384;
      }

      if (int_3 == 120) {
        method789(int_2);
      }

      if (int_3 == 121) {
        method791(int_2);
      }

      if (int_3 == 123) {
        method817(int_2);
      }

      int int_5;
      if (int_3 == 6) {
        int_5 = anIntArray100[int_2];
        if (int_5 == 16384) {
          anIntArray97[int_2] = (int_4 << 7) + (anIntArray97[int_2] & 0xFFFFC07F);
        }
      }

      if (int_3 == 38) {
        int_5 = anIntArray100[int_2];
        if (int_5 == 16384) {
          anIntArray97[int_2] = int_4 + (anIntArray97[int_2] & 0xFFFFFF80);
        }
      }

      if (int_3 == 16) {
        anIntArray96[int_2] = (int_4 << 7) + (anIntArray96[int_2] & 0xFFFFC07F);
      }

      if (int_3 == 48) {
        anIntArray96[int_2] = int_4 + (anIntArray96[int_2] & 0xFFFFFF80);
      }

      if (int_3 == 81) {
        if (int_4 >= 64) {
          anIntArray91[int_2] |= 0x4;
        } else {
          method803(int_2);
          anIntArray91[int_2] &= 0xFFFFFFFB;
        }
      }

      if (int_3 == 17) {
        method810(int_2, (int_4 << 7) + (anIntArray86[int_2] & 0xFFFFC07F));
      }

      if (int_3 == 49) {
        method810(int_2, int_4 + (anIntArray86[int_2] & 0xFFFFFF80));
      }

    } else if (int_1 == 192) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      method795(int_2, int_3 + anIntArray94[int_2]);
    } else if (int_1 == 208) {
      int_2 = int_0 & 0xF;
      int_3 = int_0 >> 8 & 0x7F;
      method796(int_2, int_3);
    } else if (int_1 == 224) {
      int_2 = int_0 & 0xF;
      int_3 = (int_0 >> 8 & 0x7F) + (int_0 >> 9 & 0x3F80);
      method797(int_2, int_3);
    } else {
      int_1 = int_0 & 0xFF;
      if (int_1 == 255) {
        method794();
      }
    }
  }

  public synchronized boolean method805() {
    return aClass74_1.method433();
  }

  public synchronized void method806() {
    for (Node_Sub5 node_sub5_0 = (Node_Sub5) aHashTable8
        .method66(); node_sub5_0 != null; node_sub5_0 = (Node_Sub5) aHashTable8.method67()) {
      node_sub5_0.method675();
    }

  }

  synchronized void method807() {
    for (Node_Sub5 node_sub5_0 = (Node_Sub5) aHashTable8
        .method66(); node_sub5_0 != null; node_sub5_0 = (Node_Sub5) aHashTable8.method67()) {
      node_sub5_0.unlink();
    }

  }

  boolean method808(final Node_Sub3 node_sub3_0, final int[] ints_0, final int int_0,
      final int int_1) {
    node_sub3_0.anInt346 = AbstractSourceLine.sampleRate / 100;
    if (node_sub3_0.anInt345 < 0
        || node_sub3_0.anAClass4_Sub2_3 != null && !node_sub3_0.anAClass4_Sub2_3.method736()) {
      int int_2 = node_sub3_0.anInt341;
      if (int_2 > 0) {
        int_2 -= (int) (
            16.0D * Math.pow(2.0D, anIntArray98[node_sub3_0.anInt343] * 4.921259842519685E-4D)
                + 0.5D);
        if (int_2 < 0) {
          int_2 = 0;
        }

        node_sub3_0.anInt341 = int_2;
      }

      node_sub3_0.anAClass4_Sub2_3.method737(method798(node_sub3_0));
      final Class78 class78_0 = node_sub3_0.aClass78_1;
      boolean bool_0 = false;
      ++node_sub3_0.anInt353;
      node_sub3_0.anInt354 += class78_0.anInt174;
      final double double_0 = ((node_sub3_0.anInt351 - 60 << 8)
          + (node_sub3_0.anInt341 * node_sub3_0.anInt342 >> 12)) * 5.086263020833333E-6D;
      if (class78_0.anInt175 > 0) {
        if (class78_0.anInt178 > 0) {
          node_sub3_0.anInt352 += (int) (128.0D * Math.pow(2.0D, class78_0.anInt178 * double_0)
              + 0.5D);
        } else {
          node_sub3_0.anInt352 += 128;
        }
      }

      if (class78_0.aByteArray9 != null) {
        if (class78_0.anInt179 > 0) {
          node_sub3_0.anInt355 += (int) (128.0D * Math.pow(2.0D, class78_0.anInt179 * double_0)
              + 0.5D);
        } else {
          node_sub3_0.anInt355 += 128;
        }

        while (node_sub3_0.anInt356 < class78_0.aByteArray9.length - 2
            && node_sub3_0.anInt355 > (class78_0.aByteArray9[node_sub3_0.anInt356 + 2] & 0xFF)
            << 8) {
          node_sub3_0.anInt356 += 2;
        }

        if (class78_0.aByteArray9.length - 2 == node_sub3_0.anInt356
            && class78_0.aByteArray9[node_sub3_0.anInt356 + 1] == 0) {
          bool_0 = true;
        }
      }

      if (node_sub3_0.anInt345 >= 0 && class78_0.aByteArray10 != null
          && (anIntArray91[node_sub3_0.anInt343] & 0x1) == 0 && (node_sub3_0.anInt348 < 0
          || node_sub3_0 != aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348])) {
        if (class78_0.anInt180 > 0) {
          node_sub3_0.anInt345 += (int) (128.0D * Math.pow(2.0D, class78_0.anInt180 * double_0)
              + 0.5D);
        } else {
          node_sub3_0.anInt345 += 128;
        }

        while (node_sub3_0.anInt357 < class78_0.aByteArray10.length - 2
            && node_sub3_0.anInt345 > (class78_0.aByteArray10[node_sub3_0.anInt357 + 2] & 0xFF)
            << 8) {
          node_sub3_0.anInt357 += 2;
        }

        if (class78_0.aByteArray10.length - 2 == node_sub3_0.anInt357) {
          bool_0 = true;
        }
      }

      if (bool_0) {
        node_sub3_0.anAClass4_Sub2_3.method738(node_sub3_0.anInt346);
        if (ints_0 != null) {
          node_sub3_0.anAClass4_Sub2_3.method632(ints_0, int_0, int_1);
        } else {
          node_sub3_0.anAClass4_Sub2_3.method633(int_1);
        }

        if (node_sub3_0.anAClass4_Sub2_3.method740()) {
          anAClass4_Sub4_1.anAClass4_Sub1_2.method721(node_sub3_0.anAClass4_Sub2_3);
        }

        node_sub3_0.method657();
        if (node_sub3_0.anInt345 >= 0) {
          node_sub3_0.unlink();
          if (node_sub3_0.anInt348 > 0
              && node_sub3_0
              == aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348]) {
            aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348] = null;
          }
        }

        return true;
      }
      node_sub3_0.anAClass4_Sub2_3.method733(node_sub3_0.anInt346, method814(node_sub3_0),
          method815(node_sub3_0));
      return false;
    }
    node_sub3_0.method657();
    node_sub3_0.unlink();
    if (node_sub3_0.anInt348 > 0
        && node_sub3_0 == aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348]) {
      aNode_Sub3ArrayArray2[node_sub3_0.anInt343][node_sub3_0.anInt348] = null;
    }

    return true;
  }

  public synchronized void method809(final int int_0) {
    anInt451 = int_0;
  }

  @Override
  public synchronized AClass4 method636() {
    return anAClass4_Sub4_1;
  }

  void method810(final int int_0, final int int_1) {
    anIntArray86[int_0] = int_1;
    anIntArray93[int_0] = (int) (2097152.0D * Math.pow(2.0D, int_1 * 5.4931640625E-4D) + 0.5D);
  }

  public synchronized void method811(final MidiFile track1_0, final boolean bool_0) {
    method790();
    aClass74_1.method434(track1_0.aByteArray17);
    aBool53 = bool_0;
    aLong20 = 0L;
    final int int_0 = aClass74_1.method437();

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      aClass74_1.method435(int_1);
      aClass74_1.method439(int_1);
      aClass74_1.method443(int_1);
    }

    anInt450 = aClass74_1.method436();
    anInt452 = aClass74_1.anIntArray42[anInt450];
    aLong19 = aClass74_1.method441(anInt452);
  }

  void method812() {
    int int_0 = anInt450;
    int int_1 = anInt452;

    long long_0;
    for (long_0 = aLong19; int_1 == anInt452; long_0 = aClass74_1.method441(int_1)) {
      while (int_1 == aClass74_1.anIntArray42[int_0]) {
        aClass74_1.method435(int_0);
        final int int_2 = aClass74_1.method438(int_0);
        if (int_2 == 1) {
          aClass74_1.method442();
          aClass74_1.method443(int_0);
          if (aClass74_1.method444()) {
            if (!aBool53 || int_1 == 0) {
              method794();
              aClass74_1.method432();
              return;
            }

            aClass74_1.method445(long_0);
          }
          break;
        }

        if ((int_2 & 0x80) != 0) {
          method804(int_2);
        }

        aClass74_1.method439(int_0);
        aClass74_1.method443(int_0);
      }

      int_0 = aClass74_1.method436();
      int_1 = aClass74_1.anIntArray42[int_0];
    }

    anInt450 = int_0;
    anInt452 = int_1;
    aLong19 = long_0;
  }

  void method813(final Node_Sub3 node_sub3_0, final boolean bool_0) {
    int int_0 = node_sub3_0.anAClass5_Sub1_1.aByteArray18.length;
    int int_2;
    if (bool_0 && node_sub3_0.anAClass5_Sub1_1.aBool50) {
      final int int_1 = int_0 + int_0 - node_sub3_0.anAClass5_Sub1_1.anInt406;
      int_2 = (int) ((long) int_1 * (long) anIntArray96[node_sub3_0.anInt343] >> 6);
      int_0 <<= 8;
      if (int_2 >= int_0) {
        int_2 = (int_0 + int_0) - 1 - int_2;
        node_sub3_0.anAClass4_Sub2_3.method741();
      }
    } else {
      int_2 = (int) ((long) anIntArray96[node_sub3_0.anInt343] * (long) int_0 >> 6);
    }

    node_sub3_0.anAClass4_Sub2_3.method734(int_2);
  }

  @Override
  public synchronized int method638() {
    return 0;
  }

  int method814(final Node_Sub3 node_sub3_0) {
    final Class78 class78_0 = node_sub3_0.aClass78_1;
    int int_0 =
        anIntArray92[node_sub3_0.anInt343] * anIntArray95[node_sub3_0.anInt343] + 4096 >> 13;
    int_0 = int_0 * int_0 + 16384 >> 15;
    int_0 = int_0 * node_sub3_0.anInt349 + 16384 >> 15;
    int_0 = int_0 * anInt451 + 128 >> 8;
    if (class78_0.anInt175 > 0) {
      int_0 = (int) (
          int_0 * Math.pow(0.5D, class78_0.anInt175 * 1.953125E-5D * node_sub3_0.anInt352)
              + 0.5D);
    }

    int int_1;
    int int_2;
    int int_3;
    int int_4;
    if (class78_0.aByteArray9 != null) {
      int_1 = node_sub3_0.anInt355;
      int_2 = class78_0.aByteArray9[node_sub3_0.anInt356 + 1];
      if (node_sub3_0.anInt356 < class78_0.aByteArray9.length - 2) {
        int_3 = (class78_0.aByteArray9[node_sub3_0.anInt356] & 0xFF) << 8;
        int_4 = (class78_0.aByteArray9[node_sub3_0.anInt356 + 2] & 0xFF) << 8;
        int_2 += (class78_0.aByteArray9[node_sub3_0.anInt356 + 3] - int_2) * (int_1 - int_3)
            / (int_4 - int_3);
      }

      int_0 = int_2 * int_0 + 32 >> 6;
    }

    if (node_sub3_0.anInt345 > 0 && class78_0.aByteArray10 != null) {
      int_1 = node_sub3_0.anInt345;
      int_2 = class78_0.aByteArray10[node_sub3_0.anInt357 + 1];
      if (node_sub3_0.anInt357 < class78_0.aByteArray10.length - 2) {
        int_3 = (class78_0.aByteArray10[node_sub3_0.anInt357] & 0xFF) << 8;
        int_4 = (class78_0.aByteArray10[node_sub3_0.anInt357 + 2] & 0xFF) << 8;
        int_2 += (int_1 - int_3) * (class78_0.aByteArray10[node_sub3_0.anInt357 + 3] - int_2)
            / (int_4 - int_3);
      }

      int_0 = 32 + int_2 * int_0 >> 6;
    }

    return int_0;
  }

  int method815(final Node_Sub3 node_sub3_0) {
    final int int_0 = anIntArray88[node_sub3_0.anInt343];
    return int_0 < 8192 ? 32 + int_0 * node_sub3_0.anInt347 >> 6
        : 16384 - (32 + (128 - node_sub3_0.anInt347) * (16384 - int_0) >> 6);
  }

  public synchronized void method816(final int int_0, final int int_1) {
    method787(int_0, int_1);
  }

  void method817(final int int_0) {
    for (Node_Sub3 node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6
        .getFirst(); node_sub3_0 != null;
        node_sub3_0 = (Node_Sub3) anAClass4_Sub4_1.aDeque6.getNext()) {
      if ((int_0 < 0 || node_sub3_0.anInt343 == int_0) && node_sub3_0.anInt345 < 0) {
        aNode_Sub3ArrayArray1[node_sub3_0.anInt343][node_sub3_0.anInt351] = null;
        node_sub3_0.anInt345 = 0;
      }
    }

  }

}
