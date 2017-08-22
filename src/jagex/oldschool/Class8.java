package jagex.oldschool;

import jagex.oldschool.asset.RemoteAssetRequestor;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.ui.InterfaceComponent;
import java.io.IOException;

public class Class8 {

  public static InterfaceComponent aWidget1;
  int anInt46;
  int anInt47;
  int[][] anIntArrayArray2;
  int[][] anIntArrayArray3;
  int[][] anIntArrayArray4;
  int[][] anIntArrayArray5;

  Class8(final int int_0, final int int_1) {
    anInt46 = int_0;
    anInt47 = int_1;
    anIntArrayArray2 = new int[int_0][int_1];
    anIntArrayArray4 = new int[int_0][int_1];
    anIntArrayArray3 = new int[int_0][int_1];
    anIntArrayArray5 = new int[int_0][int_1];
  }

  public static void sendConInfo(final boolean bool_0) {
    if (RemoteAssetRequestor.aSocketStream2 != null) {
      try {
        final Buffer buffer_0 = new Buffer(4);
        buffer_0.putByte(bool_0 ? 2 : 3);
        buffer_0.putMedium(0);
        RemoteAssetRequestor.aSocketStream2.write(buffer_0.bytes, 0, 4);
      } catch (final IOException ioexception_0) {
        try {
          RemoteAssetRequestor.aSocketStream2.close();
        } catch (final Exception exception_0) {
        }

        ++RemoteAssetRequestor.anInt192;
        RemoteAssetRequestor.aSocketStream2 = null;
      }
    }
  }

  public static void method153() {
    Area.skeletonsIndex.reset();
  }

  static void method154(final PendingSpawn pendingspawn_0) {
    int int_0 = 0;
    int int_1 = -1;
    int int_2 = 0;
    int int_3 = 0;
    if (pendingspawn_0.type == 0) {
      int_0 = Class11.region.method372(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
    }

    if (pendingspawn_0.type == 1) {
      int_0 = Class11.region.method374(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
    }

    if (pendingspawn_0.type == 2) {
      int_0 = Class11.region.method377(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
    }

    if (pendingspawn_0.type == 3) {
      int_0 = Class11.region.method375(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y);
    }

    if (int_0 != 0) {
      final int int_4 = Class11.region
          .method376(pendingspawn_0.level, pendingspawn_0.x, pendingspawn_0.y, int_0);
      int_1 = int_0 >> 14 & 0x7FFF;
      int_2 = int_4 & 0x1F;
      int_3 = int_4 >> 6 & 0x3;
    }

    pendingspawn_0.anInt333 = int_1;
    pendingspawn_0.anInt334 = int_2;
    pendingspawn_0.anInt335 = int_3;
  }

  static void method155(NpcConfig npccomposition_0, final int int_0, final int int_1,
      final int int_2) {
    if (Client.menuOptionCount < 400) {
      if (npccomposition_0.configs != null) {
        npccomposition_0 = npccomposition_0.transform();
      }

      if (npccomposition_0 != null) {
        if (npccomposition_0.aBool60) {
          if (!npccomposition_0.aBool61 || Client.anInt679 == int_0) {
            String string_0 = npccomposition_0.name;
            if (npccomposition_0.combatLevel != 0) {
              string_0 = string_0
                  + Class1.method117(npccomposition_0.combatLevel,
                  GrandExchangeOffer.localPlayer.combatLevel)
                  + " " + " (" + "level-" + npccomposition_0.combatLevel + ")";
            }

            if (npccomposition_0.aBool61 && Client.aBool92) {
              DynamicObject
                  .addMenuEntry("Examine", Square.getColTags(16776960) + string_0, 1003, int_0,
                      int_1, int_2);
            }

            if (Client.itemSelectionState == 1) {
              DynamicObject.addMenuEntry("Use",
                  Client.aString33 + " " + "->" + " " + Square.getColTags(16776960) + string_0, 7,
                  int_0, int_1, int_2);
            } else if (Client.spellSelected) {
              if ((JavaxSourceDataLineProvider.anInt62 & 0x2) == 2) {
                DynamicObject.addMenuEntry(Client.aString34,
                    Client.aString35 + " " + "->" + " " + Square.getColTags(16776960) + string_0, 8,
                    int_0, int_1, int_2);
                return;
              }
            } else {
              final int int_3 = npccomposition_0.aBool61 && Client.aBool92 ? 2000 : 0;
              String[] strings_0 = npccomposition_0.actions;
              if (Client.aBool90) {
                strings_0 = Class65.method409(strings_0);
              }

              int int_4;
              int int_5;
              if (strings_0 != null) {
                for (int_4 = 4; int_4 >= 0; --int_4) {
                  if (strings_0[int_4] != null && !strings_0[int_4].equalsIgnoreCase("Attack")) {
                    int_5 = 0;
                    if (int_4 == 0) {
                      int_5 = int_3 + 9;
                    }

                    if (int_4 == 1) {
                      int_5 = int_3 + 10;
                    }

                    if (int_4 == 2) {
                      int_5 = int_3 + 11;
                    }

                    if (int_4 == 3) {
                      int_5 = int_3 + 12;
                    }

                    if (int_4 == 4) {
                      int_5 = int_3 + 13;
                    }

                    DynamicObject.addMenuEntry(strings_0[int_4],
                        Square.getColTags(16776960) + string_0, int_5, int_0, int_1, int_2);
                  }
                }
              }

              if (strings_0 != null) {
                for (int_4 = 4; int_4 >= 0; --int_4) {
                  if (strings_0[int_4] != null && strings_0[int_4].equalsIgnoreCase("Attack")) {
                    short short_0 = 0;
                    if (Client.anEnum2_6 != Enum2.anEnum2_4) {
                      if (Enum2.anEnum2_2 == Client.anEnum2_6
                          || Client.anEnum2_6 == Enum2.anEnum2_1
                          && npccomposition_0.combatLevel
                          > GrandExchangeOffer.localPlayer.combatLevel) {
                        short_0 = 2000;
                      }

                      int_5 = 0;
                      if (int_4 == 0) {
                        int_5 = short_0 + 9;
                      }

                      if (int_4 == 1) {
                        int_5 = short_0 + 10;
                      }

                      if (int_4 == 2) {
                        int_5 = short_0 + 11;
                      }

                      if (int_4 == 3) {
                        int_5 = short_0 + 12;
                      }

                      if (int_4 == 4) {
                        int_5 = short_0 + 13;
                      }

                      DynamicObject.addMenuEntry(strings_0[int_4],
                          Square.getColTags(16776960) + string_0, int_5, int_0, int_1, int_2);
                    }
                  }
                }
              }

              if (!npccomposition_0.aBool61 || !Client.aBool92) {
                DynamicObject
                    .addMenuEntry("Examine", Square.getColTags(16776960) + string_0, 1003, int_0,
                        int_1, int_2);
                return;
              }
            }

          }
        }
      }
    }
  }

  int method151(final int int_0, final int int_1) {
    if (int_0 >= 0 && int_1 >= 0 && int_0 < anInt46 && int_1 < anInt47) {
      if (anIntArrayArray3[int_0][int_1] == 0) {
        return 0;
      }
      final int int_2 = anIntArrayArray2[int_0][int_1] / anIntArrayArray5[int_0][int_1];
      final int int_3 = anIntArrayArray4[int_0][int_1] / anIntArrayArray5[int_0][int_1];
      final int int_4 = anIntArrayArray3[int_0][int_1] / anIntArrayArray5[int_0][int_1];
      final double double_0 = int_2 / 256.0D;
      final double double_1 = int_3 / 256.0D;
      final double double_2 = int_4 / 256.0D;
      double double_3 = double_2;
      double double_4 = double_2;
      double double_5 = double_2;
      if (double_1 != 0.0D) {
        double double_6;
        if (double_2 < 0.5D) {
          double_6 = double_2 * (1.0D + double_1);
        } else {
          double_6 = double_1 + double_2 - double_1 * double_2;
        }

        final double double_7 = double_2 * 2.0D - double_6;
        double double_8 = double_0 + 0.3333333333333333D;
        if (double_8 > 1.0D) {
          --double_8;
        }

        double double_9 = double_0 - 0.3333333333333333D;
        if (double_9 < 0.0D) {
          ++double_9;
        }

        if (double_8 * 6.0D < 1.0D) {
          double_3 = (double_6 - double_7) * 6.0D * double_8 + double_7;
        } else if (2.0D * double_8 < 1.0D) {
          double_3 = double_6;
        } else if (3.0D * double_8 < 2.0D) {
          double_3 = double_7 + 6.0D * (0.6666666666666666D - double_8) * (double_6 - double_7);
        } else {
          double_3 = double_7;
        }

        if (double_0 * 6.0D < 1.0D) {
          double_4 = double_0 * 6.0D * (double_6 - double_7) + double_7;
        } else if (double_0 * 2.0D < 1.0D) {
          double_4 = double_6;
        } else if (3.0D * double_0 < 2.0D) {
          double_4 = 6.0D * (double_6 - double_7) * (0.6666666666666666D - double_0) + double_7;
        } else {
          double_4 = double_7;
        }

        if (6.0D * double_9 < 1.0D) {
          double_5 = double_7 + double_9 * (double_6 - double_7) * 6.0D;
        } else if (2.0D * double_9 < 1.0D) {
          double_5 = double_6;
        } else if (double_9 * 3.0D < 2.0D) {
          double_5 = double_7 + 6.0D * (double_6 - double_7) * (0.6666666666666666D - double_9);
        } else {
          double_5 = double_7;
        }
      }

      final int int_5 = (int) (double_3 * 256.0D);
      final int int_6 = (int) (256.0D * double_4);
      final int int_7 = (int) (256.0D * double_5);
      final int int_8 = int_7 + (int_6 << 8) + (int_5 << 16);
      return int_8;
    }
    return 0;
  }

  void method152(final int int_0, final int int_1, final int int_2,
      final FloorUnderlayDefinition floorunderlaydefinition_0) {
    if (floorunderlaydefinition_0 != null) {
      if (int_2 + int_0 >= 0 && int_2 + int_1 >= 0) {
        if (int_0 - int_2 <= anInt46) {
          if (int_1 - int_2 <= anInt47) {
            final int int_3 = Math.max(0, int_0 - int_2);
            final int int_4 = Math.min(anInt46, int_2 + int_0);
            final int int_5 = Math.max(0, int_1 - int_2);
            final int int_6 = Math.min(anInt47, int_2 + int_1);

            for (int int_7 = int_3; int_7 < int_4; int_7++) {
              for (int int_8 = int_5; int_8 < int_6; int_8++) {
                anIntArrayArray2[int_7][int_8] += floorunderlaydefinition_0.hue * 256
                    / floorunderlaydefinition_0.hueMultiplier;
                anIntArrayArray4[int_7][int_8] += floorunderlaydefinition_0.saturation;
                anIntArrayArray3[int_7][int_8] += floorunderlaydefinition_0.lightness;
                ++anIntArrayArray5[int_7][int_8];
              }
            }

          }
        }
      }
    }
  }

}
