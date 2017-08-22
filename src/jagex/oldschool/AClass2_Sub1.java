package jagex.oldschool;

import jagex.oldschool.device.Keyboard;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.scene.Player;
import jagex.oldschool.ui.InterfaceComponent;

public class AClass2_Sub1 extends AClass2 {

  public static void method615(final Player player_0, final int int_0, final int int_1,
      final byte byte_0) {
    final int int_2 = player_0.pathX[0];
    final int int_3 = player_0.pathY[0];
    final int int_4 = player_0.getSize();
    if (int_2 >= int_4 && int_2 < 104 - int_4 && int_3 >= int_4 && int_3 < 104
        - int_4) {
      if (int_0 >= int_4 && int_0 < 104 - int_4 && int_1 >= int_4 && int_1 < 104
          - int_4) {
        final int int_5 = player_0.getSize();
        final AClass2 aclass2_0 = Comparator0.method304(int_0, int_1);
        final CollisionData collisiondata_0 = Client.collisionMaps[player_0.anInt585];
        final int[] ints_0 = Client.anIntArray141;
        final int[] ints_1 = Client.anIntArray142;

        int int_6;
        int int_7;
        for (int_6 = 0; int_6 < 128; int_6++) {
          for (int_7 = 0; int_7 < 128; int_7++) {
            Class66.anIntArrayArray10[int_6][int_7] = 0;
            Class66.anIntArrayArray11[int_6][int_7] = 99999999;
          }
        }

        int int_8;
        int int_9;
        byte byte_2;
        int int_10;
        int int_11;
        int int_12;
        int int_14;
        int int_15;
        int int_16;
        boolean bool_0;
        int int_23;
        int int_24;
        int int_25;
        if (int_5 == 1) {
          bool_0 = Class26.method232(int_2, int_3, aclass2_0, collisiondata_0);
        } else if (int_5 == 2) {
          int_8 = int_2;
          int_9 = int_3;
          final byte byte_1 = 64;
          byte_2 = 64;
          int_10 = int_2 - byte_1;
          int_11 = int_3 - byte_2;
          Class66.anIntArrayArray10[byte_1][byte_2] = 99;
          Class66.anIntArrayArray11[byte_1][byte_2] = 0;
          final byte byte_3 = 0;
          int_12 = 0;
          Class66.anIntArray38[byte_3] = int_2;
          int_25 = byte_3 + 1;
          Class66.anIntArray39[byte_3] = int_3;
          final int[][] ints_2 = collisiondata_0.flags;

          boolean bool_1;
          while (true) {
            if (int_12 == int_25) {
              AClass2.anInt153 = int_8;
              Class66.anInt166 = int_9;
              bool_1 = false;
              break;
            }

            int_8 = Class66.anIntArray38[int_12];
            int_9 = Class66.anIntArray39[int_12];
            int_12 = int_12 + 1 & 0xFFF;
            int_23 = int_8 - int_10;
            int_24 = int_9 - int_11;
            int_14 = int_8 - collisiondata_0.x;
            int_15 = int_9 - collisiondata_0.y;
            if (aclass2_0.method399(2, int_8, int_9, collisiondata_0)) {
              AClass2.anInt153 = int_8;
              Class66.anInt166 = int_9;
              bool_1 = true;
              break;
            }

            int_16 = Class66.anIntArrayArray11[int_23][int_24] + 1;
            if (int_23 > 0 && Class66.anIntArrayArray10[int_23 - 1][int_24] == 0
                && (ints_2[int_14 - 1][int_15] & 0x124010E) == 0
                && (ints_2[int_14 - 1][int_15 + 1] & 0x1240138) == 0) {
              Class66.anIntArray38[int_25] = int_8 - 1;
              Class66.anIntArray39[int_25] = int_9;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 - 1][int_24] = 2;
              Class66.anIntArrayArray11[int_23 - 1][int_24] = int_16;
            }

            if (int_23 < 126 && Class66.anIntArrayArray10[int_23 + 1][int_24] == 0
                && (ints_2[int_14 + 2][int_15] & 0x1240183) == 0
                && (ints_2[int_14 + 2][int_15 + 1] & 0x12401E0) == 0) {
              Class66.anIntArray38[int_25] = int_8 + 1;
              Class66.anIntArray39[int_25] = int_9;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 + 1][int_24] = 8;
              Class66.anIntArrayArray11[int_23 + 1][int_24] = int_16;
            }

            if (int_24 > 0 && Class66.anIntArrayArray10[int_23][int_24 - 1] == 0
                && (ints_2[int_14][int_15 - 1] & 0x124010E) == 0
                && (ints_2[int_14 + 1][int_15 - 1] & 0x1240183) == 0) {
              Class66.anIntArray38[int_25] = int_8;
              Class66.anIntArray39[int_25] = int_9 - 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23][int_24 - 1] = 1;
              Class66.anIntArrayArray11[int_23][int_24 - 1] = int_16;
            }

            if (int_24 < 126 && Class66.anIntArrayArray10[int_23][int_24 + 1] == 0
                && (ints_2[int_14][int_15 + 2] & 0x1240138) == 0
                && (ints_2[int_14 + 1][int_15 + 2] & 0x12401E0) == 0) {
              Class66.anIntArray38[int_25] = int_8;
              Class66.anIntArray39[int_25] = int_9 + 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23][int_24 + 1] = 4;
              Class66.anIntArrayArray11[int_23][int_24 + 1] = int_16;
            }

            if (int_23 > 0 && int_24 > 0 && Class66.anIntArrayArray10[int_23 - 1][int_24 - 1]
                == 0
                && (ints_2[int_14 - 1][int_15] & 0x124013E) == 0
                && (ints_2[int_14 - 1][int_15 - 1] & 0x124010E) == 0
                && (ints_2[int_14][int_15 - 1] & 0x124018F) == 0) {
              Class66.anIntArray38[int_25] = int_8 - 1;
              Class66.anIntArray39[int_25] = int_9 - 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 - 1][int_24 - 1] = 3;
              Class66.anIntArrayArray11[int_23 - 1][int_24 - 1] = int_16;
            }

            if (int_23 < 126 && int_24 > 0 && Class66.anIntArrayArray10[int_23 + 1][int_24 - 1]
                == 0
                && (ints_2[int_14 + 1][int_15 - 1] & 0x124018F) == 0
                && (ints_2[int_14 + 2][int_15 - 1] & 0x1240183) == 0
                && (ints_2[int_14 + 2][int_15] & 0x12401E3) == 0) {
              Class66.anIntArray38[int_25] = int_8 + 1;
              Class66.anIntArray39[int_25] = int_9 - 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 + 1][int_24 - 1] = 9;
              Class66.anIntArrayArray11[int_23 + 1][int_24 - 1] = int_16;
            }

            if (int_23 > 0 && int_24 < 126 && Class66.anIntArrayArray10[int_23 - 1][int_24 + 1]
                == 0
                && (ints_2[int_14 - 1][int_15 + 1] & 0x124013E) == 0
                && (ints_2[int_14 - 1][int_15 + 2] & 0x1240138) == 0
                && (ints_2[int_14][int_15 + 2] & 0x12401F8) == 0) {
              Class66.anIntArray38[int_25] = int_8 - 1;
              Class66.anIntArray39[int_25] = int_9 + 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 - 1][int_24 + 1] = 6;
              Class66.anIntArrayArray11[int_23 - 1][int_24 + 1] = int_16;
            }

            if (int_23 < 126 && int_24 < 126
                && Class66.anIntArrayArray10[int_23 + 1][int_24 + 1] == 0
                && (ints_2[int_14 + 1][int_15 + 2] & 0x12401F8) == 0
                && (ints_2[int_14 + 2][int_15 + 2] & 0x12401E0) == 0
                && (ints_2[int_14 + 2][int_15 + 1] & 0x12401E3) == 0) {
              Class66.anIntArray38[int_25] = int_8 + 1;
              Class66.anIntArray39[int_25] = int_9 + 1;
              int_25 = int_25 + 1 & 0xFFF;
              Class66.anIntArrayArray10[int_23 + 1][int_24 + 1] = 12;
              Class66.anIntArrayArray11[int_23 + 1][int_24 + 1] = int_16;
            }
          }

          bool_0 = bool_1;
        } else {
          bool_0 = FileCache.method73(int_2, int_3, int_5, aclass2_0, collisiondata_0);
        }

        int int_22;
        label379:
        {
          int_7 = int_2 - 64;
          int_8 = int_3 - 64;
          int_9 = AClass2.anInt153;
          int_23 = Class66.anInt166;
          if (!bool_0) {
            int_24 = Integer.MAX_VALUE;
            int_10 = Integer.MAX_VALUE;
            final byte byte_4 = 10;
            int_25 = aclass2_0.anInt154;
            int_12 = aclass2_0.anInt155;
            final int int_13 = aclass2_0.anInt156;
            int_14 = aclass2_0.anInt157;

            for (int_15 = int_25 - byte_4; int_15 <= int_25 + byte_4; int_15++) {
              for (int_16 = int_12 - byte_4; int_16 <= byte_4 + int_12; int_16++) {
                final int int_17 = int_15 - int_7;
                final int int_18 = int_16 - int_8;
                if (int_17 >= 0 && int_18 >= 0 && int_17 < 128 && int_18 < 128
                    && Class66.anIntArrayArray11[int_17][int_18] < 100) {
                  int int_19 = 0;
                  if (int_15 < int_25) {
                    int_19 = int_25 - int_15;
                  } else if (int_15 > int_13 + int_25 - 1) {
                    int_19 = int_15 - (int_25 + int_13 - 1);
                  }

                  int int_20 = 0;
                  if (int_16 < int_12) {
                    int_20 = int_12 - int_16;
                  } else if (int_16 > int_14 + int_12 - 1) {
                    int_20 = int_16 - (int_12 + int_14 - 1);
                  }

                  final int int_21 = int_20 * int_20 + int_19 * int_19;
                  if (int_21 < int_24 || int_24 == int_21
                      && Class66.anIntArrayArray11[int_17][int_18] < int_10) {
                    int_24 = int_21;
                    int_10 = Class66.anIntArrayArray11[int_17][int_18];
                    int_9 = int_15;
                    int_23 = int_16;
                  }
                }
              }
            }

            if (int_24 == Integer.MAX_VALUE) {
              int_22 = -1;
              break label379;
            }
          }

          if (int_2 == int_9 && int_3 == int_23) {
            int_22 = 0;
          } else {
            byte_2 = 0;
            Class66.anIntArray38[byte_2] = int_9;
            int_24 = byte_2 + 1;
            Class66.anIntArray39[byte_2] = int_23;

            for (int_10 = int_11 = Class66.anIntArrayArray10[int_9 - int_7][int_23
                - int_8]; int_2 != int_9
                || int_23 != int_3; int_10 = Class66.anIntArrayArray10[int_9 - int_7][int_23
                - int_8]) {
              if (int_10 != int_11) {
                int_11 = int_10;
                Class66.anIntArray38[int_24] = int_9;
                Class66.anIntArray39[int_24++] = int_23;
              }

              if ((int_10 & 0x2) != 0) {
                ++int_9;
              } else if ((int_10 & 0x8) != 0) {
                --int_9;
              }

              if ((int_10 & 0x1) != 0) {
                ++int_23;
              } else if ((int_10 & 0x4) != 0) {
                --int_23;
              }
            }

            int_25 = 0;

            while (int_24-- > 0) {
              ints_0[int_25] = Class66.anIntArray38[int_24];
              ints_1[int_25++] = Class66.anIntArray39[int_24];
              if (int_25 >= ints_0.length) {
                break;
              }
            }

            int_22 = int_25;
          }
        }

        int_6 = int_22;
        if (int_22 >= 1) {
          for (int_7 = 0; int_7 < int_6 - 1; int_7++) {
            player_0.method1051(Client.anIntArray141[int_7], Client.anIntArray142[int_7], byte_0);
          }

        }
      }
    }
  }

  static void method616() {
    for (int int_0 = 0; int_0 < Client.menuOptionCount; int_0++) {
      final int int_1 = Client.menuTypes[int_0];
      final boolean bool_0 =
          int_1 == 57 || int_1 == 58 || int_1 == 1007 || int_1 == 25 || int_1 == 30;
      if (bool_0) {
        if (int_0 < Client.menuOptionCount - 1) {
          for (int int_2 = int_0; int_2 < Client.menuOptionCount - 1; int_2++) {
            Client.menuOptions[int_2] = Client.menuOptions[int_2 + 1];
            Client.menuTargets[int_2] = Client.menuTargets[int_2 + 1];
            Client.menuTypes[int_2] = Client.menuTypes[int_2 + 1];
            Client.menuIdentifiers[int_2] = Client.menuIdentifiers[int_2 + 1];
            Client.menuActionParams0[int_2] = Client.menuActionParams0[int_2 + 1];
            Client.menuActionParams1[int_2] = Client.menuActionParams1[int_2 + 1];
            Client.aBoolArray11[int_2] = Client.aBoolArray11[int_2 + 1];
          }
        }

        --Client.menuOptionCount;
      }
    }

  }

  static void method617(final InterfaceComponent widget_0, final int int_0, final int int_1) {
    if (Client.anInt644 == 0 || Client.anInt644 == 3) {
      if (Mouse.anInt248 == 1 || !GrandExchangeOffer.aBool5 && Mouse.anInt248
          == 4) {
        final CacheableNode_Sub1 cacheablenode_sub1_0 = widget_0.method579(true);
        if (cacheablenode_sub1_0 == null) {
          return;
        }

        int int_2 = Mouse.anInt253 - int_0;
        int int_3 = Mouse.anInt254 - int_1;
        if (cacheablenode_sub1_0.method827(int_2, int_3)) {
          int_2 -= cacheablenode_sub1_0.anInt460 / 2;
          int_3 -= cacheablenode_sub1_0.anInt461 / 2;
          final int int_4 = Client.mapAngle & 0x7FF;
          final int int_5 = Rasterizer3d.SINE[int_4];
          final int int_6 = Rasterizer3d.COSINE[int_4];
          final int int_7 = int_2 * int_6 + int_5 * int_3 >> 11;
          final int int_8 = int_3 * int_6 - int_5 * int_2 >> 11;
          final int int_9 = int_7 + GrandExchangeOffer.localPlayer.x >> 7;
          final int int_10 = GrandExchangeOffer.localPlayer.y - int_8 >> 7;
          Client.outbound.putEncipheredByte(110);
          Client.outbound.putByte(18);
          Client.outbound.putByteAdd(
              Keyboard.aBoolArray3[82] ? Keyboard.aBoolArray3[81] ? 2 : 1 : 0);
          Client.outbound.putLeShortAdd(int_9 + Boundry.baseX);
          Client.outbound.putShort(int_10 + WorldMapData_Sub1.baseY);
          Client.outbound.putByte(int_2);
          Client.outbound.putByte(int_3);
          Client.outbound.putShort(Client.mapAngle);
          Client.outbound.putByte(57);
          Client.outbound.putByte(0);
          Client.outbound.putByte(0);
          Client.outbound.putByte(89);
          Client.outbound.putShort(GrandExchangeOffer.localPlayer.x);
          Client.outbound.putShort(GrandExchangeOffer.localPlayer.y);
          Client.outbound.putByte(63);
          Client.destinationX = int_9;
          Client.destinationY = int_10;
          return;
        }
      }

    }
  }

  @Override
  public boolean method399(final int int_0, final int int_1, final int int_2,
      final CollisionData collisiondata_0) {
    return int_1 == anInt154 && int_2 == anInt155;
  }

}
