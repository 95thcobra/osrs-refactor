package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.collections.Node;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.io.SocketStream;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.scene.Scene;
import jagex.oldschool.social.Ignore;

public final class PendingSpawn extends Node {

  int delay;
  int hitpoints;
  int anInt333;// 333
  int level;
  int anInt334;
  int type;
  int x;
  int y;
  int anInt335;
  int id;
  int anInt336;
  int orientation;

  PendingSpawn() {
    delay = 0;
    hitpoints = -1;
  }

  public static AnimationSequence getAnimationSequence(final int id) {
    AnimationSequence sequence_0 = (AnimationSequence) AnimationSequence.sequences.get(id);
    if (sequence_0 != null) {
      return sequence_0;
    }
    final byte[] bytes_0 = AnimationSequence.config.get(12, id);
    sequence_0 = new AnimationSequence();
    if (bytes_0 != null) {
      sequence_0.decode(new Buffer(bytes_0));
    }

    sequence_0.post();
    AnimationSequence.sequences.put(sequence_0, id);
    return sequence_0;
  }

  static void method651(final int int_0) {
    final short short_0 = 256;
    LoginScreen.anInt101 += int_0 * 128;
    int int_1;
    if (LoginScreen.anInt101 > LoginScreen.anIntArray21.length) {
      LoginScreen.anInt101 -= LoginScreen.anIntArray21.length;
      int_1 = (int) (Math.random() * 12.0D);
      WorldMapData_Sub1.method599(LoginScreen.anIndexedSpriteArray6[int_1]);
    }

    int_1 = 0;
    final int int_2 = int_0 * 128;
    final int int_3 = (short_0 - int_0) * 128;

    int int_4;
    int int_5;
    for (int_4 = 0; int_4 < int_3; int_4++) {
      int_5 = Ignore.anIntArray60[int_1 + int_2]
          - LoginScreen.anIntArray21[int_1 + LoginScreen.anInt101 & LoginScreen.anIntArray21.length - 1]
          * int_0
          / 6;
      if (int_5 < 0) {
        int_5 = 0;
      }

      Ignore.anIntArray60[int_1++] = int_5;
    }

    int int_6;
    int int_7;
    for (int_4 = short_0 - int_0; int_4 < short_0; int_4++) {
      int_5 = int_4 * 128;

      for (int_6 = 0; int_6 < 128; int_6++) {
        int_7 = (int) (Math.random() * 100.0D);
        if (int_7 < 50 && int_6 > 10 && int_6 < 118) {
          Ignore.anIntArray60[int_5 + int_6] = 255;
        } else {
          Ignore.anIntArray60[int_5 + int_6] = 0;
        }
      }
    }

    if (LoginScreen.anInt99 > 0) {
      LoginScreen.anInt99 -= int_0 * 4;
    }

    if (LoginScreen.anInt100 > 0) {
      LoginScreen.anInt100 -= int_0 * 4;
    }

    if (LoginScreen.anInt99 == 0 && LoginScreen.anInt100 == 0) {
      int_4 = (int) (Math.random() * (2000 / int_0));
      if (int_4 == 0) {
        LoginScreen.anInt99 = 1024;
      }

      if (int_4 == 1) {
        LoginScreen.anInt100 = 1024;
      }
    }

    for (int_4 = 0; int_4 < short_0 - int_0; int_4++) {
      LoginScreen.anIntArray20[int_4] = LoginScreen.anIntArray20[int_0 + int_4];
    }

    for (int_4 = short_0 - int_0; int_4 < short_0; int_4++) {
      LoginScreen.anIntArray20[int_4] = (int) (Math.sin(LoginScreen.anInt104 / 14.0D) * 16.0D
          + Math.sin(LoginScreen.anInt104 / 15.0D) * 14.0D + Math.sin(LoginScreen.anInt104 / 16.0D)
          * 12.0D);
      ++LoginScreen.anInt104;
    }

    LoginScreen.anInt102 += int_0;
    int_4 = (int_0 + (Client.tick & 0x1)) / 2;
    if (int_4 > 0) {
      for (int_5 = 0; int_5 < LoginScreen.anInt102 * 100; int_5++) {
        int_6 = (int) (Math.random() * 124.0D) + 2;
        int_7 = (int) (Math.random() * 128.0D) + 128;
        Ignore.anIntArray60[int_6 + (int_7 << 7)] = 192;
      }

      LoginScreen.anInt102 = 0;

      int int_8;
      for (int_5 = 0; int_5 < short_0; int_5++) {
        int_6 = 0;
        int_7 = int_5 * 128;

        for (int_8 = -int_4; int_8 < 128; int_8++) {
          if (int_8 + int_4 < 128) {
            int_6 += Ignore.anIntArray60[int_4 + int_8 + int_7];
          }

          if (int_8 - (int_4 + 1) >= 0) {
            int_6 -= Ignore.anIntArray60[int_8 + int_7 - (int_4 + 1)];
          }

          if (int_8 >= 0) {
            LoginScreen.anIntArray23[int_8 + int_7] = int_6 / (int_4 * 2 + 1);
          }
        }
      }

      for (int_5 = 0; int_5 < 128; int_5++) {
        int_6 = 0;

        for (int_7 = -int_4; int_7 < short_0; int_7++) {
          int_8 = int_7 * 128;
          if (int_4 + int_7 < short_0) {
            int_6 += LoginScreen.anIntArray23[int_5 + int_8 + int_4 * 128];
          }

          if (int_7 - (int_4 + 1) >= 0) {
            int_6 -= LoginScreen.anIntArray23[int_8 + int_5 - 128 * (int_4 + 1)];
          }

          if (int_7 >= 0) {
            Ignore.anIntArray60[int_5 + int_8] = int_6 / (int_4 * 2 + 1);
          }
        }
      }
    }

  }

  static void method652(final Scene region_0, final CollisionData[] collisiondatas_0) {
    int int_0;
    int int_1;
    int int_2;
    int int_3;
    for (int_0 = 0; int_0 < 4; int_0++) {
      for (int_1 = 0; int_1 < 104; int_1++) {
        for (int_2 = 0; int_2 < 104; int_2++) {
          if ((Class22.flags[int_0][int_1][int_2] & 0x1) == 1) {
            int_3 = int_0;
            if ((Class22.flags[1][int_1][int_2] & 0x2) == 2) {
              int_3 = int_0 - 1;
            }

            if (int_3 >= 0) {
              collisiondatas_0[int_3].method570(int_1, int_2);
            }
          }
        }
      }
    }

    Class22.anInt71 += (int) (Math.random() * 5.0D) - 2;
    if (Class22.anInt71 < -8) {
      Class22.anInt71 = -8;
    }

    if (Class22.anInt71 > 8) {
      Class22.anInt71 = 8;
    }

    Class22.anInt72 += (int) (Math.random() * 5.0D) - 2;
    if (Class22.anInt72 < -16) {
      Class22.anInt72 = -16;
    }

    if (Class22.anInt72 > 16) {
      Class22.anInt72 = 16;
    }

    int int_4;
    int int_5;
    int int_6;
    int int_7;
    int int_8;
    int int_9;
    int int_10;
    int int_11;
    int int_12;
    int int_13;
    for (int_0 = 0; int_0 < 4; int_0++) {
      final byte[][] bytes_0 = Class22.aByteArrayArrayArray4[int_0];
      int_4 = (int) Math.sqrt(5100.0D);
      int_5 = int_4 * 768 >> 8;

      int int_14;
      int int_15;
      for (int_6 = 1; int_6 < 103; int_6++) {
        for (int_7 = 1; int_7 < 103; int_7++) {
          int_8 = Class22.heightmap[int_0][int_7 + 1][int_6] - Class22.heightmap[int_0][int_7
              - 1][int_6];
          int_9 =
              Class22.heightmap[int_0][int_7][int_6 + 1] - Class22.heightmap[int_0][int_7][int_6
                  - 1];
          int_10 = (int) Math.sqrt(int_9 * int_9 + 65536 + int_8 * int_8);
          int_11 = (int_8 << 8) / int_10;
          int_12 = 65536 / int_10;
          int_13 = (int_9 << 8) / int_10;
          int_14 = 96 + (int_11 * -50 + int_12 * -10 + int_13 * -50) / int_5;
          int_15 = (bytes_0[int_7][int_6] >> 1) + (bytes_0[int_7][int_6 + 1] >> 3)
              + (bytes_0[int_7][int_6 - 1] >> 2) + (bytes_0[int_7 - 1][int_6] >> 2)
              + (bytes_0[int_7 + 1][int_6] >> 3);
          WorldMapType2.anIntArrayArray14[int_7][int_6] = int_14 - int_15;
        }
      }

      for (int_6 = 0; int_6 < 104; int_6++) {
        Class22.blendedHue[int_6] = 0;
        WorldMapType1.blendedSaturation[int_6] = 0;
        Class13.anIntArray2[int_6] = 0;
        HuffmanCodec.anIntArray67[int_6] = 0;
        JavaxSourceDataLineProvider.anIntArray3[int_6] = 0;
      }

      for (int_6 = -5; int_6 < 109; int_6++) {
        for (int_7 = 0; int_7 < 104; int_7++) {
          int_8 = int_6 + 5;
          if (int_8 >= 0 && int_8 < 104) {
            int_9 = Class22.underlayIds[int_0][int_8][int_7] & 0xFF;
            if (int_9 > 0) {
              final FloorUnderlayDefinition floorunderlaydefinition_0 = Class20
                  .method204(int_9 - 1);
              Class22.blendedHue[int_7] += floorunderlaydefinition_0.hue;
              WorldMapType1.blendedSaturation[int_7] += floorunderlaydefinition_0.saturation;
              Class13.anIntArray2[int_7] += floorunderlaydefinition_0.lightness;
              HuffmanCodec.anIntArray67[int_7] += floorunderlaydefinition_0.hueMultiplier;
              ++JavaxSourceDataLineProvider.anIntArray3[int_7];
            }
          }

          int_9 = int_6 - 5;
          if (int_9 >= 0 && int_9 < 104) {
            int_10 = Class22.underlayIds[int_0][int_9][int_7] & 0xFF;
            if (int_10 > 0) {
              final FloorUnderlayDefinition floorunderlaydefinition_1 = Class20
                  .method204(int_10 - 1);
              Class22.blendedHue[int_7] -= floorunderlaydefinition_1.hue;
              WorldMapType1.blendedSaturation[int_7] -= floorunderlaydefinition_1.saturation;
              Class13.anIntArray2[int_7] -= floorunderlaydefinition_1.lightness;
              HuffmanCodec.anIntArray67[int_7] -= floorunderlaydefinition_1.hueMultiplier;
              --JavaxSourceDataLineProvider.anIntArray3[int_7];
            }
          }
        }

        if (int_6 >= 1 && int_6 < 103) {
          int_7 = 0;
          int_8 = 0;
          int_9 = 0;
          int_10 = 0;
          int_11 = 0;

          for (int_12 = -5; int_12 < 109; int_12++) {
            int_13 = int_12 + 5;
            if (int_13 >= 0 && int_13 < 104) {
              int_7 += Class22.blendedHue[int_13];
              int_8 += WorldMapType1.blendedSaturation[int_13];
              int_9 += Class13.anIntArray2[int_13];
              int_10 += HuffmanCodec.anIntArray67[int_13];
              int_11 += JavaxSourceDataLineProvider.anIntArray3[int_13];
            }

            int_14 = int_12 - 5;
            if (int_14 >= 0 && int_14 < 104) {
              int_7 -= Class22.blendedHue[int_14];
              int_8 -= WorldMapType1.blendedSaturation[int_14];
              int_9 -= Class13.anIntArray2[int_14];
              int_10 -= HuffmanCodec.anIntArray67[int_14];
              int_11 -= JavaxSourceDataLineProvider.anIntArray3[int_14];
            }

            if (int_12 >= 1 && int_12 < 103
                && (!Client.lowMemory || (Class22.flags[0][int_6][int_12] & 0x2) != 0
                || (Class22.flags[int_0][int_6][int_12] & 0x10) == 0)) {
              if (int_0 < Class22.anInt70) {
                Class22.anInt70 = int_0;
              }

              int_15 = Class22.underlayIds[int_0][int_6][int_12] & 0xFF;
              final int int_19 = Class22.overlayIds[int_0][int_6][int_12] & 0xFF;
              if (int_15 > 0 || int_19 > 0) {
                final int int_20 = Class22.heightmap[int_0][int_6][int_12];
                final int int_21 = Class22.heightmap[int_0][int_6 + 1][int_12];
                final int int_22 = Class22.heightmap[int_0][int_6 + 1][int_12 + 1];
                final int int_23 = Class22.heightmap[int_0][int_6][int_12 + 1];
                final int int_24 = WorldMapType2.anIntArrayArray14[int_6][int_12];
                final int int_25 = WorldMapType2.anIntArrayArray14[int_6 + 1][int_12];
                final int int_26 = WorldMapType2.anIntArrayArray14[int_6 + 1][int_12 + 1];
                final int int_27 = WorldMapType2.anIntArrayArray14[int_6][int_12 + 1];
                int int_28 = -1;
                int int_29 = -1;
                int int_30;
                int int_31;
                if (int_15 > 0) {
                  int_30 = int_7 * 256 / int_10;
                  int_31 = int_8 / int_11;
                  int int_32 = int_9 / int_11;
                  int_28 = SocketStream.method555(int_30, int_31, int_32);
                  int_30 = int_30 + Class22.anInt71 & 0xFF;
                  int_32 += Class22.anInt72;
                  if (int_32 < 0) {
                    int_32 = 0;
                  } else if (int_32 > 255) {
                    int_32 = 255;
                  }

                  int_29 = SocketStream.method555(int_30, int_31, int_32);
                }

                if (int_0 > 0) {
                  boolean bool_0 = true;
                  if (int_15 == 0 && Class22.overlayPaths[int_0][int_6][int_12] != 0) {
                    bool_0 = false;
                  }

                  if (int_19 > 0 && !NpcConfig.method868(int_19 - 1).isHidden) {
                    bool_0 = false;
                  }

                  if (bool_0 && int_20 == int_21 && int_22 == int_20 && int_20 == int_23) {
                    Enum8.anIntArrayArrayArray1[int_0][int_6][int_12] |= 0x924;
                  }
                }

                int_30 = 0;
                if (int_29 != -1) {
                  int_30 = Rasterizer3d.HSL_TABLE[Enum2.method626(int_29, 96)];
                }

                if (int_19 == 0) {
                  region_0.addTile(int_0, int_6, int_12, 0, 0, -1, int_20, int_21, int_22, int_23,
                      Enum2.method626(int_28, int_24), Enum2.method626(int_28, int_25),
                      Enum2.method626(int_28, int_26), Enum2.method626(int_28, int_27), 0, 0, 0,
                      0, int_30, 0);
                } else {
                  int_31 = Class22.overlayPaths[int_0][int_6][int_12] + 1;
                  final byte byte_0 = Class22.overlayRotations[int_0][int_6][int_12];
                  final Overlay overlay_0 = NpcConfig.method868(int_19 - 1);
                  int int_33 = overlay_0.texture;
                  int int_34;
                  int int_35;
                  int int_36;
                  int int_37;
                  if (int_33 >= 0) {
                    int_34 = Rasterizer3d.materials.getHsl(int_33);
                    int_35 = -1;
                  } else if (overlay_0.color == 16711935) {
                    int_35 = -2;
                    int_33 = -1;
                    int_34 = -2;
                  } else {
                    int_35 = SocketStream.method555(overlay_0.hue, overlay_0.saturation,
                        overlay_0.lightness);
                    int_36 = overlay_0.hue + Class22.anInt71 & 0xFF;
                    int_37 = overlay_0.lightness + Class22.anInt72;
                    if (int_37 < 0) {
                      int_37 = 0;
                    } else if (int_37 > 255) {
                      int_37 = 255;
                    }

                    int_34 = SocketStream.method555(int_36, overlay_0.saturation, int_37);
                  }

                  int_36 = 0;
                  if (int_34 != -2) {
                    int_36 = Rasterizer3d.HSL_TABLE[Class46.adjustHSLListness0(int_34, 96)];
                  }

                  if (overlay_0.otherRgbColor != -1) {
                    int_37 = overlay_0.otherHue + Class22.anInt71 & 0xFF;
                    int int_38 = overlay_0.otherLightness + Class22.anInt72;
                    if (int_38 < 0) {
                      int_38 = 0;
                    } else if (int_38 > 255) {
                      int_38 = 255;
                    }

                    int_34 = SocketStream.method555(int_37, overlay_0.otherSaturation, int_38);
                    int_36 = Rasterizer3d.HSL_TABLE[Class46.adjustHSLListness0(int_34, 96)];
                  }

                  region_0.addTile(int_0, int_6, int_12, int_31, byte_0, int_33, int_20, int_21,
                      int_22, int_23, Enum2.method626(int_28, int_24),
                      Enum2.method626(int_28, int_25), Enum2.method626(int_28, int_26),
                      Enum2.method626(int_28, int_27), Class46.adjustHSLListness0(int_35, int_24),
                      Class46.adjustHSLListness0(int_35, int_25),
                      Class46.adjustHSLListness0(int_35, int_26),
                      Class46.adjustHSLListness0(int_35, int_27), int_30, int_36);
                }
              }
            }
          }
        }
      }

      for (int_6 = 1; int_6 < 103; int_6++) {
        for (int_7 = 1; int_7 < 103; int_7++) {
          if ((Class22.flags[int_0][int_7][int_6] & 0x8) != 0) {
            int_12 = 0;
          } else if (int_0 > 0 && (Class22.flags[1][int_7][int_6] & 0x2) != 0) {
            int_12 = int_0 - 1;
          } else {
            int_12 = int_0;
          }

          region_0.setPhysicalLevel(int_0, int_7, int_6, int_12);
        }
      }

      Class22.underlayIds[int_0] = null;
      Class22.overlayIds[int_0] = null;
      Class22.overlayPaths[int_0] = null;
      Class22.overlayRotations[int_0] = null;
      Class22.aByteArrayArrayArray4[int_0] = null;
    }

    region_0.applyLighting(-50, -10, -50);

    for (int_0 = 0; int_0 < 104; int_0++) {
      for (int_1 = 0; int_1 < 104; int_1++) {
        if ((Class22.flags[1][int_0][int_1] & 0x2) == 2) {
          region_0.setBridge(int_0, int_1);
        }
      }
    }

    int_0 = 1;
    int_1 = 2;
    int_2 = 4;

    for (int_3 = 0; int_3 < 4; int_3++) {
      if (int_3 > 0) {
        int_0 <<= 3;
        int_1 <<= 3;
        int_2 <<= 3;
      }

      for (int int_16 = 0; int_16 <= int_3; int_16++) {
        for (int int_17 = 0; int_17 <= 104; int_17++) {
          for (int int_18 = 0; int_18 <= 104; int_18++) {
            short short_0;
            if ((Enum8.anIntArrayArrayArray1[int_16][int_18][int_17] & int_0) != 0) {
              int_4 = int_17;
              int_5 = int_17;
              int_6 = int_16;

              for (int_7 = int_16;
                  int_4 > 0 && (Enum8.anIntArrayArrayArray1[int_16][int_18][int_4 - 1]
                      & int_0) != 0; --int_4) {
              }

              while (int_5 < 104
                  && (Enum8.anIntArrayArrayArray1[int_16][int_18][int_5 + 1] & int_0) != 0) {
                ++int_5;
              }

              label484:
              while (int_6 > 0) {
                for (int_8 = int_4; int_8 <= int_5; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_6 - 1][int_18][int_8] & int_0) == 0) {
                    break label484;
                  }
                }

                --int_6;
              }

              label473:
              while (int_7 < int_3) {
                for (int_8 = int_4; int_8 <= int_5; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_7 + 1][int_18][int_8] & int_0) == 0) {
                    break label473;
                  }
                }

                ++int_7;
              }

              int_8 = (int_5 - int_4 + 1) * (int_7 + 1 - int_6);
              if (int_8 >= 8) {
                short_0 = 240;
                int_10 = Class22.heightmap[int_7][int_18][int_4] - short_0;
                int_11 = Class22.heightmap[int_6][int_18][int_4];
                Scene.addOcclude(int_3, 1, int_18 * 128, int_18 * 128, int_4 * 128,
                    int_5 * 128 + 128, int_10, int_11);

                for (int_12 = int_6; int_12 <= int_7; int_12++) {
                  for (int_13 = int_4; int_13 <= int_5; int_13++) {
                    Enum8.anIntArrayArrayArray1[int_12][int_18][int_13] &= ~int_0;
                  }
                }
              }
            }

            if ((Enum8.anIntArrayArrayArray1[int_16][int_18][int_17] & int_1) != 0) {
              int_4 = int_18;
              int_5 = int_18;
              int_6 = int_16;

              for (int_7 = int_16;
                  int_4 > 0 && (Enum8.anIntArrayArrayArray1[int_16][int_4 - 1][int_17]
                      & int_1) != 0; --int_4) {
              }

              while (int_5 < 104
                  && (Enum8.anIntArrayArrayArray1[int_16][int_5 + 1][int_17] & int_1) != 0) {
                ++int_5;
              }

              label537:
              while (int_6 > 0) {
                for (int_8 = int_4; int_8 <= int_5; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_6 - 1][int_8][int_17] & int_1) == 0) {
                    break label537;
                  }
                }

                --int_6;
              }

              label526:
              while (int_7 < int_3) {
                for (int_8 = int_4; int_8 <= int_5; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_7 + 1][int_8][int_17] & int_1) == 0) {
                    break label526;
                  }
                }

                ++int_7;
              }

              int_8 = (int_7 + 1 - int_6) * (int_5 - int_4 + 1);
              if (int_8 >= 8) {
                short_0 = 240;
                int_10 = Class22.heightmap[int_7][int_4][int_17] - short_0;
                int_11 = Class22.heightmap[int_6][int_4][int_17];
                Scene.addOcclude(int_3, 2, int_4 * 128, 128 + int_5 * 128, int_17 * 128,
                    int_17 * 128, int_10, int_11);

                for (int_12 = int_6; int_12 <= int_7; int_12++) {
                  for (int_13 = int_4; int_13 <= int_5; int_13++) {
                    Enum8.anIntArrayArrayArray1[int_12][int_13][int_17] &= ~int_1;
                  }
                }
              }
            }

            if ((Enum8.anIntArrayArrayArray1[int_16][int_18][int_17] & int_2) != 0) {
              int_4 = int_18;
              int_5 = int_18;
              int_6 = int_17;

              for (int_7 = int_17;
                  int_6 > 0 && (Enum8.anIntArrayArrayArray1[int_16][int_18][int_6 - 1]
                      & int_2) != 0; --int_6) {
              }

              while (int_7 < 104
                  && (Enum8.anIntArrayArrayArray1[int_16][int_18][int_7 + 1] & int_2) != 0) {
                ++int_7;
              }

              label590:
              while (int_4 > 0) {
                for (int_8 = int_6; int_8 <= int_7; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_16][int_4 - 1][int_8] & int_2) == 0) {
                    break label590;
                  }
                }

                --int_4;
              }

              label579:
              while (int_5 < 104) {
                for (int_8 = int_6; int_8 <= int_7; int_8++) {
                  if ((Enum8.anIntArrayArrayArray1[int_16][int_5 + 1][int_8] & int_2) == 0) {
                    break label579;
                  }
                }

                ++int_5;
              }

              if ((int_7 - int_6 + 1) * (int_5 - int_4 + 1) >= 4) {
                int_8 = Class22.heightmap[int_16][int_4][int_6];
                Scene.addOcclude(int_3, 4, int_4 * 128, int_5 * 128 + 128, int_6 * 128,
                    int_7 * 128 + 128, int_8, int_8);

                for (int_9 = int_4; int_9 <= int_5; int_9++) {
                  for (int_10 = int_6; int_10 <= int_7; int_10++) {
                    Enum8.anIntArrayArrayArray1[int_16][int_9][int_10] &= ~int_2;
                  }
                }
              }
            }
          }
        }
      }
    }

  }

  public static Enum9[] method653() {
    return new Enum9[] {
        Enum9.anEnum9_6, Enum9.anEnum9_3, Enum9.anEnum9_2, Enum9.anEnum9_5, Enum9.anEnum9_4
    };
  }

}
