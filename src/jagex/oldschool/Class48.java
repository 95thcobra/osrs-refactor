package jagex.oldschool;

import jagex.oldschool.awt.CanvasWrapper;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.scene.Mobile;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Occluder;
import jagex.oldschool.scene.Player;

public class Class48 {

  static long aLong3;
  static int anInt97;

  static void method297(final byte[] bytes_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5, final int int_6,
      final CollisionData[] collisiondatas_0) {
    int int_8;
    for (int int_7 = 0; int_7 < 8; int_7++) {
      for (int_8 = 0; int_8 < 8; int_8++) {
        if (int_7 + int_1 > 0 && int_7 + int_1 < 103 && int_2 + int_8 > 0
            && int_2 + int_8 < 103) {
          collisiondatas_0[int_0].flags[int_7 + int_1][int_2 + int_8] &= 0xFEFFFFFF;
        }
      }
    }

    final Buffer buffer_0 = new Buffer(bytes_0);

    for (int_8 = 0; int_8 < 4; int_8++) {
      for (int int_9 = 0; int_9 < 64; int_9++) {
        for (int int_10 = 0; int_10 < 64; int_10++) {
          if (int_8 == int_3 && int_9 >= int_4 && int_9 < int_4 + 8 && int_10 >= int_5
              && int_10 < int_5 + 8) {
            Class7.loadTerrain(buffer_0, int_0,
                int_1 + Occluder.method404(int_9 & 0x7, int_10 & 0x7, int_6),
                int_2 + CombatInfo1.method669(int_9 & 0x7, int_10 & 0x7, int_6), 0, 0, int_6);
          } else {
            Class7.loadTerrain(buffer_0, 0, -1, -1, 0, 0, 0);
          }
        }
      }
    }

  }

  static void method298() {
    for (int int_0 = 0; int_0 < Client.anInt636; int_0++) {
      final int int_1 = Client.npcIndices[int_0];
      final Npc npc_0 = Client.cachedNPCs[int_1];
      if (npc_0 != null) {
        Class98.method515(npc_0, npc_0.config.anInt477);
      }
    }

  }

  static void method299(final Mobile actor_0, final int int_0, final int int_1,
      final int int_2, final int int_3,
      final int int_4) {
    if (actor_0 != null) {
      if (actor_0.hasConfig()) {
        if (actor_0 instanceof Npc) {
          NpcConfig npccomposition_0 = ((Npc) actor_0).config;
          if (npccomposition_0.configs != null) {
            npccomposition_0 = npccomposition_0.transform();
          }

          if (npccomposition_0 == null) {
            return;
          }
        }

        final int int_5 = Class39.anInt89;
        final int[] ints_0 = Class39.anIntArray14;
        int int_6 = 3;
        int int_8;
        int int_13;
        int int_14;
        if (!actor_0.combatInfoList.isEmpty()) {
          Class13.characterToScreen(actor_0, actor_0.anInt507 + 15);

          for (
              CombatInfoListHolder combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList
                  .getFirst(); combatinfolistholder_0 != null;
              combatinfolistholder_0 = (CombatInfoListHolder) actor_0.combatInfoList
                  .getNext()) {
            final CombatInfo1 combatinfo1_0 = combatinfolistholder_0.method640(Client.tick);
            if (combatinfo1_0 == null) {
              if (combatinfolistholder_0.method641()) {
                combatinfolistholder_0.unlink();
              }
            } else {
              final CombatInfo2 combatinfo2_0 = combatinfolistholder_0.combatInfo2;
              final DirectSprite spritepixels_0 = combatinfo2_0.method783();
              final DirectSprite spritepixels_1 = combatinfo2_0.method784();
              int int_7 = 0;
              if (spritepixels_0 != null && spritepixels_1 != null) {
                if (combatinfo2_0.anInt449 * 2 < spritepixels_1.width) {
                  int_7 = combatinfo2_0.anInt449;
                }

                int_8 = spritepixels_1.width - int_7 * 2;
              } else {
                int_8 = combatinfo2_0.healthScale;
              }

              int int_9 = 255;
              final int int_10 = Client.tick - combatinfo1_0.anInt361;
              final int int_11 = int_8 * combatinfo1_0.health / combatinfo2_0.healthScale;
              int int_12;
              int int_62;
              if (combatinfo1_0.anInt362 > int_10) {
                int_12 = combatinfo2_0.anInt447 == 0 ? 0
                    : combatinfo2_0.anInt447 * (int_10 / combatinfo2_0.anInt447);
                int_13 = int_8 * combatinfo1_0.healthRatio / combatinfo2_0.healthScale;
                int_62 = int_12 * (int_11 - int_13) / combatinfo1_0.anInt362 + int_13;
              } else {
                int_62 = int_11;
                int_12 = combatinfo2_0.anInt446 + combatinfo1_0.anInt362 - int_10;
                if (combatinfo2_0.anInt444 >= 0) {
                  int_9 = (int_12 << 8) / (combatinfo2_0.anInt446 - combatinfo2_0.anInt444);
                }
              }

              if (combatinfo1_0.health > 0 && int_62 < 1) {
                int_62 = 1;
              }

              int_12 = int_1 + Client.screenY - (int_8 >> 1);
              int_13 = int_2 + Client.screenX - int_6;
              if (spritepixels_0 != null && spritepixels_1 != null) {
                int_12 -= int_7;
                if (int_62 == int_8) {
                  int_62 += int_7 * 2;
                } else {
                  int_62 += int_7;
                }

                int_14 = spritepixels_0.height;
                int_6 += int_14;
                if (int_9 >= 0 && int_9 < 255) {
                  spritepixels_0.method953(int_12, int_13, int_9);
                  Rasterizer2d.resizeClip(int_12, int_13, int_12 + int_62, int_14 + int_13);
                  spritepixels_1.method953(int_12, int_13, int_9);
                } else {
                  spritepixels_0.method938(int_12, int_13);
                  Rasterizer2d.resizeClip(int_12, int_13, int_12 + int_62, int_14 + int_13);
                  spritepixels_1.method938(int_12, int_13);
                }

                Rasterizer2d.setClip(int_1, int_2, int_1 + int_3, int_2 + int_4);
                int_6 += 2;
              } else {
                if (Client.screenY > -1) {
                  Rasterizer2d.fillRectangle(int_12, int_13, int_62, 5, 65280);
                  Rasterizer2d.fillRectangle(int_62 + int_12, int_13, int_8 - int_62, 5, 16711680);
                }

                int_6 += 7;
              }
            }
          }
        }

        if (int_6 < 30) {
          int_6 = 30;
        }

        if (int_0 < int_5) {
          final Player player_0 = (Player) actor_0;
          if (player_0.hidden) {
            return;
          }

          if (player_0.skullIcon != -1 || player_0.overheadIcon != -1) {
            Class13.characterToScreen(actor_0, actor_0.anInt507 + 15);
            if (Client.screenY > -1) {
              if (player_0.skullIcon != -1) {
                CanvasWrapper.mapfunctions[player_0.skullIcon].method938(int_1 + Client.screenY - 12,
                    int_2 + Client.screenX - int_6);
                int_6 += 25;
              }

              if (player_0.overheadIcon != -1) {
                Enum1.hitmarks[player_0.overheadIcon].method938(int_1 + Client.screenY - 12,
                    int_2 + Client.screenX - int_6);
                int_6 += 25;
              }
            }
          }

          if (int_0 >= 0 && Client.anInt614 == 10 && ints_0[int_0] == Client.anInt620) {
            Class13.characterToScreen(actor_0, actor_0.anInt507 + 15);
            if (Client.screenY > -1) {
              Class45.pkIcons[1].method938(int_1 + Client.screenY - 12,
                  int_2 + Client.screenX - int_6);
            }
          }
        } else {
          NpcConfig npccomposition_1 = ((Npc) actor_0).config;
          if (npccomposition_1.configs != null) {
            npccomposition_1 = npccomposition_1.transform();
          }

          if (npccomposition_1.anInt489 >= 0 && npccomposition_1.anInt489
              < Enum1.hitmarks.length) {
            Class13.characterToScreen(actor_0, actor_0.anInt507 + 15);
            if (Client.screenY > -1) {
              Enum1.hitmarks[npccomposition_1.anInt489].method938(int_1 + Client.screenY - 12,
                  int_2 + Client.screenX - 30);
            }
          }

          if (Client.anInt614 == 1 && Client.npcIndices[int_0 - int_5] == Client.anInt616
              && Client.tick % 20 < 10) {
            Class13.characterToScreen(actor_0, actor_0.anInt507 + 15);
            if (Client.screenY > -1) {
              Class45.pkIcons[0]
                  .method938(int_1 + Client.screenY - 12, int_2 + Client.screenX - 28);
            }
          }
        }

        if (actor_0.overhead != null
            && (int_0 >= int_5 || !actor_0.inSequence && (Client.anInt673 == 4 || !actor_0.aBool65
                && (Client.anInt673 == 0 || Client.anInt673 == 3 || Client.anInt673 == 1
                && WorldMapType2.isFriended(((Player) actor_0).name, false))))) {
          Class13.characterToScreen(actor_0, actor_0.anInt507);
          if (Client.screenY > -1 && Client.anInt681 < Client.anInt683) {
            Client.anIntArray156[Client.anInt681] = Class22.aFont3.method989(actor_0.overhead) / 2;
            Client.anIntArray155[Client.anInt681] = Class22.aFont3.verticalSpace;
            Client.anIntArray152[Client.anInt681] = Client.screenY;
            Client.anIntArray154[Client.anInt681] = Client.screenX;
            Client.anIntArray158[Client.anInt681] = actor_0.anInt510;
            Client.anIntArray159[Client.anInt681] = actor_0.anInt511;
            Client.anIntArray160[Client.anInt681] = actor_0.anInt509;
            Client.aStringArray6[Client.anInt681] = actor_0.overhead;
            ++Client.anInt681;
          }
        }

        for (int int_15 = 0; int_15 < 4; int_15++) {
          final int int_16 = actor_0.hitsplatCycles[int_15];
          final int int_17 = actor_0.anIntArray109[int_15];
          CacheableNode_Sub2 cacheablenode_sub2_1 = null;
          int int_18 = 0;
          if (int_17 >= 0) {
            if (int_16 <= Client.tick) {
              continue;
            }

            cacheablenode_sub2_1 = RemoteEnvironment.method523(actor_0.anIntArray109[int_15]);
            int_18 = cacheablenode_sub2_1.anInt471;
            if (cacheablenode_sub2_1 != null && cacheablenode_sub2_1.anIntArray104 != null) {
              cacheablenode_sub2_1 = cacheablenode_sub2_1.method834();
              if (cacheablenode_sub2_1 == null) {
                actor_0.hitsplatCycles[int_15] = -1;
                continue;
              }
            }
          } else if (int_16 < 0) {
            continue;
          }

          int_8 = actor_0.anIntArray110[int_15];
          CacheableNode_Sub2 cacheablenode_sub2_0 = null;
          if (int_8 >= 0) {
            cacheablenode_sub2_0 = RemoteEnvironment.method523(int_8);
            if (cacheablenode_sub2_0 != null && cacheablenode_sub2_0.anIntArray104 != null) {
              cacheablenode_sub2_0 = cacheablenode_sub2_0.method834();
            }
          }

          if (int_16 - int_18 <= Client.tick) {
            if (cacheablenode_sub2_1 == null) {
              actor_0.hitsplatCycles[int_15] = -1;
            } else {
              Class13.characterToScreen(actor_0, actor_0.anInt507 / 2);
              if (Client.screenY > -1) {
                if (int_15 == 1) {
                  Client.screenX -= 20;
                }

                if (int_15 == 2) {
                  Client.screenY -= 15;
                  Client.screenX -= 10;
                }

                if (int_15 == 3) {
                  Client.screenY += 15;
                  Client.screenX -= 10;
                }

                DirectSprite spritepixels_2 = null;
                DirectSprite spritepixels_3 = null;
                DirectSprite spritepixels_4 = null;
                DirectSprite spritepixels_5 = null;
                int_13 = 0;
                int_14 = 0;
                int int_19 = 0;
                int int_20 = 0;
                int int_21 = 0;
                int int_22 = 0;
                int int_23 = 0;
                int int_24 = 0;
                DirectSprite spritepixels_6 = null;
                DirectSprite spritepixels_7 = null;
                DirectSprite spritepixels_8 = null;
                DirectSprite spritepixels_9 = null;
                int int_25 = 0;
                int int_26 = 0;
                int int_27 = 0;
                int int_28 = 0;
                int int_29 = 0;
                int int_30 = 0;
                int int_31 = 0;
                int int_32 = 0;
                int int_33 = 0;
                spritepixels_2 = cacheablenode_sub2_1.method835();
                int int_34;
                if (spritepixels_2 != null) {
                  int_13 = spritepixels_2.width;
                  int_34 = spritepixels_2.height;
                  if (int_34 > int_33) {
                    int_33 = int_34;
                  }

                  int_21 = spritepixels_2.offsetX;
                }

                spritepixels_3 = cacheablenode_sub2_1.method836();
                if (spritepixels_3 != null) {
                  int_14 = spritepixels_3.width;
                  int_34 = spritepixels_3.height;
                  if (int_34 > int_33) {
                    int_33 = int_34;
                  }

                  int_22 = spritepixels_3.offsetX;
                }

                spritepixels_4 = cacheablenode_sub2_1.method837();
                if (spritepixels_4 != null) {
                  int_19 = spritepixels_4.width;
                  int_34 = spritepixels_4.height;
                  if (int_34 > int_33) {
                    int_33 = int_34;
                  }

                  int_23 = spritepixels_4.offsetX;
                }

                spritepixels_5 = cacheablenode_sub2_1.method838();
                if (spritepixels_5 != null) {
                  int_20 = spritepixels_5.width;
                  int_34 = spritepixels_5.height;
                  if (int_34 > int_33) {
                    int_33 = int_34;
                  }

                  int_24 = spritepixels_5.offsetX;
                }

                if (cacheablenode_sub2_0 != null) {
                  spritepixels_6 = cacheablenode_sub2_0.method835();
                  if (spritepixels_6 != null) {
                    int_25 = spritepixels_6.width;
                    int_34 = spritepixels_6.height;
                    if (int_34 > int_33) {
                      int_33 = int_34;
                    }

                    int_29 = spritepixels_6.offsetX;
                  }

                  spritepixels_7 = cacheablenode_sub2_0.method836();
                  if (spritepixels_7 != null) {
                    int_26 = spritepixels_7.width;
                    int_34 = spritepixels_7.height;
                    if (int_34 > int_33) {
                      int_33 = int_34;
                    }

                    int_30 = spritepixels_7.offsetX;
                  }

                  spritepixels_8 = cacheablenode_sub2_0.method837();
                  if (spritepixels_8 != null) {
                    int_27 = spritepixels_8.width;
                    int_34 = spritepixels_8.height;
                    if (int_34 > int_33) {
                      int_33 = int_34;
                    }

                    int_31 = spritepixels_8.offsetX;
                  }

                  spritepixels_9 = cacheablenode_sub2_0.method838();
                  if (spritepixels_9 != null) {
                    int_28 = spritepixels_9.width;
                    int_34 = spritepixels_9.height;
                    if (int_34 > int_33) {
                      int_33 = int_34;
                    }

                    int_32 = spritepixels_9.offsetX;
                  }
                }

                BitmapFont font_0 = cacheablenode_sub2_1.method839();
                if (font_0 == null) {
                  font_0 = VertexNormal.aFont5;
                }

                BitmapFont font_1;
                if (cacheablenode_sub2_0 != null) {
                  font_1 = cacheablenode_sub2_0.method839();
                  if (font_1 == null) {
                    font_1 = VertexNormal.aFont5;
                  }
                } else {
                  font_1 = VertexNormal.aFont5;
                }

                String string_0 = null;
                String string_1 = null;
                int int_35 = 0;
                string_0 = cacheablenode_sub2_1.method840(actor_0.hitsplatTypes[int_15]);
                final int int_63 = font_0.method989(string_0);
                if (cacheablenode_sub2_0 != null) {
                  string_1 = cacheablenode_sub2_0.method840(actor_0.anIntArray111[int_15]);
                  int_35 = font_1.method989(string_1);
                }

                int int_36 = 0;
                int int_37 = 0;
                if (int_14 > 0) {
                  if (spritepixels_4 == null && spritepixels_5 == null) {
                    int_36 = 1;
                  } else {
                    int_36 = int_63 / int_14 + 1;
                  }
                }

                if (cacheablenode_sub2_0 != null && int_26 > 0) {
                  if (spritepixels_8 == null && spritepixels_9 == null) {
                    int_37 = 1;
                  } else {
                    int_37 = int_35 / int_26 + 1;
                  }
                }

                int int_38 = 0;
                final int int_39 = int_38;
                if (int_13 > 0) {
                  int_38 += int_13;
                }

                int_38 += 2;
                final int int_40 = int_38;
                if (int_19 > 0) {
                  int_38 += int_19;
                }

                final int int_41 = int_38;
                int int_42 = int_38;
                int int_43;
                if (int_14 > 0) {
                  int_43 = int_36 * int_14;
                  int_38 += int_43;
                  int_42 += (int_43 - int_63) / 2;
                } else {
                  int_38 += int_63;
                }

                int_43 = int_38;
                if (int_20 > 0) {
                  int_38 += int_20;
                }

                int int_44 = 0;
                int int_45 = 0;
                int int_46 = 0;
                int int_47 = 0;
                int int_48 = 0;
                int int_49;
                if (cacheablenode_sub2_0 != null) {
                  int_38 += 2;
                  int_44 = int_38;
                  if (int_25 > 0) {
                    int_38 += int_25;
                  }

                  int_38 += 2;
                  int_45 = int_38;
                  if (int_27 > 0) {
                    int_38 += int_27;
                  }

                  int_46 = int_38;
                  int_48 = int_38;
                  if (int_26 > 0) {
                    int_49 = int_26 * int_37;
                    int_38 += int_49;
                    int_48 += (int_49 - int_35) / 2;
                  } else {
                    int_38 += int_35;
                  }

                  int_47 = int_38;
                  if (int_28 > 0) {
                    int_38 += int_28;
                  }
                }

                int_49 = actor_0.hitsplatCycles[int_15] - Client.tick;
                final int int_50 = cacheablenode_sub2_1.anInt472
                    - int_49 * cacheablenode_sub2_1.anInt472 / cacheablenode_sub2_1.anInt471;
                final int int_51 = int_49 * cacheablenode_sub2_1.anInt474
                    / cacheablenode_sub2_1.anInt471 + -cacheablenode_sub2_1.anInt474;
                final int int_52 = int_50 + int_1 + Client.screenY - (int_38 >> 1);
                final int int_53 = int_2 + Client.screenX - 12 + int_51;
                int int_54 = int_53;
                int int_55 = int_33 + int_53;
                final int int_56 = int_53 + cacheablenode_sub2_1.anInt475 + 15;
                final int int_57 = int_56 - font_0.minSpacing;
                final int int_58 = int_56 + font_0.maxSpacing;
                if (int_57 < int_53) {
                  int_54 = int_57;
                }

                if (int_58 > int_55) {
                  int_55 = int_58;
                }

                int int_59 = 0;
                int int_60;
                int int_61;
                if (cacheablenode_sub2_0 != null) {
                  int_59 = int_53 + cacheablenode_sub2_0.anInt475 + 15;
                  int_60 = int_59 - font_1.minSpacing;
                  int_61 = int_59 + font_1.maxSpacing;
                  if (int_60 < int_54) {
                  }

                  if (int_61 > int_55) {
                  }
                }

                int_60 = 255;
                if (cacheablenode_sub2_1.anInt473 >= 0) {
                  int_60 = (int_49 << 8)
                      / (cacheablenode_sub2_1.anInt471 - cacheablenode_sub2_1.anInt473);
                }

                if (int_60 >= 0 && int_60 < 255) {
                  if (spritepixels_2 != null) {
                    spritepixels_2.method953(int_52 + int_39 - int_21, int_53, int_60);
                  }

                  if (spritepixels_4 != null) {
                    spritepixels_4.method953(int_52 + int_40 - int_23, int_53, int_60);
                  }

                  if (spritepixels_3 != null) {
                    for (int_61 = 0; int_61 < int_36; int_61++) {
                      spritepixels_3.method953(int_41 + int_52 - int_22 + int_61 * int_14,
                          int_53, int_60);
                    }
                  }

                  if (spritepixels_5 != null) {
                    spritepixels_5.method953(int_52 + int_43 - int_24, int_53, int_60);
                  }

                  font_0
                      .method1004(string_0, int_42 + int_52, int_56, cacheablenode_sub2_1.anInt470,
                          0, int_60);
                  if (cacheablenode_sub2_0 != null) {
                    if (spritepixels_6 != null) {
                      spritepixels_6.method953(int_52 + int_44 - int_29, int_53, int_60);
                    }

                    if (spritepixels_8 != null) {
                      spritepixels_8.method953(int_52 + int_45 - int_31, int_53, int_60);
                    }

                    if (spritepixels_7 != null) {
                      for (int_61 = 0; int_61 < int_37; int_61++) {
                        spritepixels_7.method953(
                            int_26 * int_61 + int_52 + int_46 - int_30, int_53,
                            int_60);
                      }
                    }

                    if (spritepixels_9 != null) {
                      spritepixels_9.method953(int_52 + int_47 - int_32, int_53, int_60);
                    }

                    font_1.method1004(string_1, int_52 + int_48, int_59,
                        cacheablenode_sub2_0.anInt470, 0, int_60);
                  }
                } else {
                  if (spritepixels_2 != null) {
                    spritepixels_2.method938(int_52 + int_39 - int_21, int_53);
                  }

                  if (spritepixels_4 != null) {
                    spritepixels_4.method938(int_52 + int_40 - int_23, int_53);
                  }

                  if (spritepixels_3 != null) {
                    for (int_61 = 0; int_61 < int_36; int_61++) {
                      spritepixels_3.method938(int_41 + int_52 - int_22 + int_61 * int_14,
                          int_53);
                    }
                  }

                  if (spritepixels_5 != null) {
                    spritepixels_5.method938(int_43 + int_52 - int_24, int_53);
                  }

                  font_0.method999(string_0, int_42 + int_52, int_56,
                      cacheablenode_sub2_1.anInt470 | 0xFF000000, 0);
                  if (cacheablenode_sub2_0 != null) {
                    if (spritepixels_6 != null) {
                      spritepixels_6.method938(int_44 + int_52 - int_29, int_53);
                    }

                    if (spritepixels_8 != null) {
                      spritepixels_8.method938(int_52 + int_45 - int_31, int_53);
                    }

                    if (spritepixels_7 != null) {
                      for (int_61 = 0; int_61 < int_37; int_61++) {
                        spritepixels_7.method938(
                            int_26 * int_61 + int_46 + int_52 - int_30, int_53);
                      }
                    }

                    if (spritepixels_9 != null) {
                      spritepixels_9.method938(int_47 + int_52 - int_32, int_53);
                    }

                    font_1.method999(string_1, int_52 + int_48, int_59,
                        cacheablenode_sub2_0.anInt470 | 0xFF000000, 0);
                  }
                }
              }
            }
          }
        }

      }
    }
  }

}
