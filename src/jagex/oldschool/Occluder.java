package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.awt.Parameter;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.io.AbstractByteBuffer;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;

public final class Occluder {

  int testDirection;
  int minX;
  int type;
  int minNormalX;
  int minTileX;
  int minZ;
  int minTileZ;
  int maxNormalX;
  int maxZ;
  int anInt163;
  int minY;
  int maxX;
  int minNormalY;
  int anInt164;
  int maxNormalY;
  int maxY;
  int maxTileZ;
  int maxTIleX;

  public static Parameter[] method402() {
    return new Parameter[] {
        Parameter.PARAMETER_1, Parameter.PARAMETER_12, Parameter.PARAMETER_2,
        Parameter.PARAMETER_10, Parameter.PARAMETER_15, Parameter.PARAMETER_6,
        Parameter.PARAMETER_7,
        Parameter.PARAMETER_11, Parameter.PARAMETER_4, Parameter.PARAMETER_14,
        Parameter.PARAMETER_3,
        Parameter.PARAMETER_13, Parameter.PARAMETER_5, Parameter.PARAMETER_9,
        Parameter.PARAMETER_8
    };
  }

  public static String method403(final int int_0) {
    return (int_0 >> 24 & 0xFF) + "." + (int_0 >> 16 & 0xFF) + "." + (int_0 >> 8 & 0xFF) + "."
        + (int_0 & 0xFF);
  }

  public static int method404(final int int_0, final int int_1, int int_2) {
    int_2 &= 0x3;
    return int_2 == 0 ? int_0 : int_2 == 1 ? int_1 : int_2 == 2 ? 7 - int_0 : 7 - int_1;
  }

  public static void method405(final InterfaceComponent[] widgets_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5, final int int_6) {
    for (int int_7 = 0; int_7 < widgets_0.length; int_7++) {
      final InterfaceComponent widget_0 = widgets_0[int_7];
      if (widget_0 != null
          && (!widget_0.hasScript || widget_0.type == 0 || widget_0.aBool28
          || Client.getWidgetConfig(widget_0) != 0 || widget_0 == Client.aWidget10
          || widget_0.contentType == 1338)
          && widget_0.parentId == int_0 && (!widget_0.hasScript || !Renderable
          .method711(widget_0))) {
        final int int_8 = widget_0.relativeX + int_5;
        final int int_9 = int_6 + widget_0.relativeY;
        int int_10;
        int int_11;
        int int_12;
        int int_13;
        int int_14;
        int int_15;
        int int_17;
        if (widget_0.type == 2) {
          int_10 = int_1;
          int_11 = int_2;
          int_12 = int_3;
          int_13 = int_4;
        } else if (widget_0.type == 9) {
          int_14 = int_8;
          int_15 = int_9;
          int int_16 = int_8 + widget_0.width;
          int_17 = int_9 + widget_0.height;
          if (int_16 < int_8) {
            int_14 = int_16;
            int_16 = int_8;
          }

          if (int_17 < int_9) {
            int_15 = int_17;
            int_17 = int_9;
          }

          ++int_16;
          ++int_17;
          int_10 = int_14 > int_1 ? int_14 : int_1;
          int_11 = int_15 > int_2 ? int_15 : int_2;
          int_12 = int_16 < int_3 ? int_16 : int_3;
          int_13 = int_17 < int_4 ? int_17 : int_4;
        } else {
          int_14 = int_8 + widget_0.width;
          int_15 = int_9 + widget_0.height;
          int_10 = int_8 > int_1 ? int_8 : int_1;
          int_11 = int_9 > int_2 ? int_9 : int_2;
          int_12 = int_14 < int_3 ? int_14 : int_3;
          int_13 = int_15 < int_4 ? int_15 : int_4;
        }

        if (widget_0 == Client.aWidget9) {
          Client.aBool78 = true;
          Client.anInt628 = int_8;
          Client.anInt629 = int_9;
        }

        if (!widget_0.hasScript || int_10 < int_12 && int_11 < int_13) {
          int_14 = Mouse.anInt249;
          int_15 = Mouse.anInt251;
          if (Mouse.anInt248 != 0) {
            int_14 = Mouse.anInt253;
            int_15 = Mouse.anInt254;
          }

          boolean bool_0 =
              int_14 >= int_10 && int_15 >= int_11 && int_14 < int_12 && int_15 < int_13;
          int int_18;
          int int_19;
          int int_20;
          int int_21;
          int int_22;
          int int_23;
          int int_24;
          int int_25;
          int int_26;
          if (widget_0.contentType == 1337) {
            if (!Client.aBool82 && !Client.isMenuOpen && bool_0) {
              if (Client.itemSelectionState == 0 && !Client.spellSelected) {
                DynamicObject
                    .addMenuEntry("Walk here", "", 23, 0, int_14 - int_10, int_15 - int_11);
              }

              int_17 = -1;
              int_18 = -1;

              for (int_19 = 0; int_19 < Class56.anInt142; int_19++) {
                int_20 = Class56.anIntArray35[int_19];
                int_21 = int_20 & 0x7F;
                int_22 = int_20 >> 7 & 0x7F;
                int_23 = int_20 >> 29 & 0x3;
                int_24 = int_20 >> 14 & 0x7FFF;
                if (int_18 != int_20) {
                  int_18 = int_20;
                  if (int_23 == 2
                      && Class11.region.method376(Class12.plane, int_21, int_22, int_20) >= 0) {
                    ObjectConfig objectcomposition_0 = Class2.getObjectDefinition(int_24);
                    if (objectcomposition_0.impostorIds != null) {
                      objectcomposition_0 = objectcomposition_0.getImpostor();
                    }

                    if (objectcomposition_0 == null) {
                      continue;
                    }

                    if (Client.itemSelectionState == 1) {
                      DynamicObject
                          .addMenuEntry("Use",
                              Client.aString33 + " " + "->" + " " + Square.getColTags(65535)
                                  + objectcomposition_0.name,
                              1, int_20, int_21, int_22);
                    } else if (Client.spellSelected) {
                      if ((JavaxSourceDataLineProvider.anInt62 & 0x4) == 4) {
                        DynamicObject.addMenuEntry(
                            Client.aString34, Client.aString35 + " " + "->" + " "
                                + Square.getColTags(65535) + objectcomposition_0.name,
                            2, int_20, int_21, int_22);
                      }
                    } else {
                      String[] strings_1 = objectcomposition_0.actions;
                      if (Client.aBool90) {
                        strings_1 = Class65.method409(strings_1);
                      }

                      if (strings_1 != null) {
                        for (int_26 = 4; int_26 >= 0; --int_26) {
                          if (strings_1[int_26] != null) {
                            short short_0 = 0;
                            if (int_26 == 0) {
                              short_0 = 3;
                            }

                            if (int_26 == 1) {
                              short_0 = 4;
                            }

                            if (int_26 == 2) {
                              short_0 = 5;
                            }

                            if (int_26 == 3) {
                              short_0 = 6;
                            }

                            if (int_26 == 4) {
                              short_0 = 1001;
                            }

                            DynamicObject.addMenuEntry(strings_1[int_26],
                                Square.getColTags(65535) + objectcomposition_0.name,
                                short_0, int_20, int_21, int_22);
                          }
                        }
                      }

                      DynamicObject.addMenuEntry("Examine",
                          Square.getColTags(65535) + objectcomposition_0.name, 1002,
                          objectcomposition_0.id << 14, int_21, int_22);
                    }
                  }

                  Npc npc_0;
                  Player player_0;
                  int[] ints_0;
                  int int_28;
                  if (int_23 == 1) {
                    final Npc npc_1 = Client.cachedNPCs[int_24];
                    if (npc_1 == null) {
                      continue;
                    }

                    if (npc_1.config.anInt477 == 1 && (npc_1.x & 0x7F) == 64
                        && (npc_1.y & 0x7F) == 64) {
                      for (int_25 = 0; int_25 < Client.anInt636; int_25++) {
                        npc_0 = Client.cachedNPCs[Client.npcIndices[int_25]];
                        if (npc_0 != null && npc_1 != npc_0
                            && npc_0.config.anInt477 == 1 && npc_1.x == npc_0.x
                            && npc_1.y == npc_0.y) {
                          Class8.method155(npc_0.config, Client.npcIndices[int_25],
                              int_21, int_22);
                        }
                      }

                      int_25 = Class39.anInt89;
                      ints_0 = Class39.anIntArray14;

                      for (int_28 = 0; int_28 < int_25; int_28++) {
                        player_0 = Client.cachedPlayers[ints_0[int_28]];
                        if (player_0 != null && player_0.x == npc_1.x
                            && player_0.y == npc_1.y) {
                          Class65.method408(player_0, ints_0[int_28], int_21, int_22);
                        }
                      }
                    }

                    Class8.method155(npc_1.config, int_24, int_21, int_22);
                  }

                  if (int_23 == 0) {
                    final Player player_1 = Client.cachedPlayers[int_24];
                    if (player_1 == null) {
                      continue;
                    }

                    if ((player_1.x & 0x7F) == 64 && (player_1.y & 0x7F) == 64) {
                      for (int_25 = 0; int_25 < Client.anInt636; int_25++) {
                        npc_0 = Client.cachedNPCs[Client.npcIndices[int_25]];
                        if (npc_0 != null && npc_0.config.anInt477 == 1
                            && player_1.x == npc_0.x && npc_0.y == player_1.y) {
                          Class8.method155(npc_0.config, Client.npcIndices[int_25],
                              int_21, int_22);
                        }
                      }

                      int_25 = Class39.anInt89;
                      ints_0 = Class39.anIntArray14;

                      for (int_28 = 0; int_28 < int_25; int_28++) {
                        player_0 = Client.cachedPlayers[ints_0[int_28]];
                        if (player_0 != null && player_0 != player_1
                            && player_0.x == player_1.x && player_0.y == player_1.y) {
                          Class65.method408(player_0, ints_0[int_28], int_21, int_22);
                        }
                      }
                    }

                    if (int_24 != Client.anInt652) {
                      Class65.method408(player_1, int_24, int_21, int_22);
                    } else {
                      int_17 = int_20;
                    }
                  }

                  if (int_23 == 3) {
                    final Deque deque_0 = Client.groundItemDeque[Class12.plane][int_21][int_22];
                    if (deque_0 != null) {
                      for (GroundItem item_0 = (GroundItem) deque_0
                          .getLast(); item_0 != null; item_0 = (GroundItem) deque_0.getPrevious()) {
                        final ItemConfig itemcomposition_1 = AudioWorker
                            .getItemDefinition(item_0.id);
                        if (Client.itemSelectionState == 1) {
                          DynamicObject.addMenuEntry("Use", Client.aString33 + " " + "->"
                                  + " " + Square.getColTags(16748608) + itemcomposition_1.name,
                              16, item_0.id, int_21, int_22);
                        } else if (Client.spellSelected) {
                          if ((JavaxSourceDataLineProvider.anInt62 & 0x1) == 1) {
                            DynamicObject.addMenuEntry(Client.aString34,
                                Client.aString35 + " " + "->" + " "
                                    + Square.getColTags(16748608)
                                    + itemcomposition_1.name,
                                17, item_0.id, int_21, int_22);
                          }
                        } else {
                          String[] strings_2 = itemcomposition_1.groundActions;
                          if (Client.aBool90) {
                            strings_2 = Class65.method409(strings_2);
                          }

                          for (int int_27 = 4; int_27 >= 0; --int_27) {
                            if (strings_2 != null && strings_2[int_27] != null) {
                              byte byte_1 = 0;
                              if (int_27 == 0) {
                                byte_1 = 18;
                              }

                              if (int_27 == 1) {
                                byte_1 = 19;
                              }

                              if (int_27 == 2) {
                                byte_1 = 20;
                              }

                              if (int_27 == 3) {
                                byte_1 = 21;
                              }

                              if (int_27 == 4) {
                                byte_1 = 22;
                              }

                              DynamicObject.addMenuEntry(strings_2[int_27],
                                  Square.getColTags(16748608) + itemcomposition_1.name,
                                  byte_1, item_0.id, int_21, int_22);
                            } else if (int_27 == 2) {
                              DynamicObject.addMenuEntry("Take",
                                  Square.getColTags(16748608) + itemcomposition_1.name,
                                  20, item_0.id, int_21, int_22);
                            }
                          }

                          DynamicObject.addMenuEntry("Examine",
                              Square.getColTags(16748608) + itemcomposition_1.name, 1004,
                              item_0.id, int_21, int_22);
                        }
                      }
                    }
                  }
                }
              }

              if (int_17 != -1) {
                int_19 = int_17 & 0x7F;
                int_20 = int_17 >> 7 & 0x7F;
                final Player player_2 = Client.cachedPlayers[Client.anInt652];
                Class65.method408(player_2, Client.anInt652, int_19, int_20);
              }
            }
          } else if (widget_0.contentType == 1338) {
            AClass2_Sub1.method617(widget_0, int_8, int_9);
          } else {
            if (widget_0.contentType == 1400) {
              Class14.renderOverview
                  .method35(Mouse.anInt249, Mouse.anInt251, bool_0, int_8,
                      int_9, widget_0.width, widget_0.height);
            }

            if (!Client.isMenuOpen && bool_0) {
              if (widget_0.contentType == 1400) {
                Class14.renderOverview
                    .method36(int_8, int_9, widget_0.width, widget_0.height, int_14,
                        int_15);
              } else {
                int_17 = int_14 - int_8;
                int_18 = int_15 - int_9;
                if (widget_0.anInt263 == 1) {
                  DynamicObject.addMenuEntry(widget_0.tooltip, "", 24, 0, 0, widget_0.id);
                }

                String string_0;
                if (widget_0.anInt263 == 2 && !Client.spellSelected) {
                  string_0 = Renderable.method713(widget_0);
                  if (string_0 != null) {
                    DynamicObject.addMenuEntry(string_0,
                        Square.getColTags(65280) + widget_0.aString17, 25, 0, -1, widget_0.id);
                  }
                }

                if (widget_0.anInt263 == 3) {
                  DynamicObject.addMenuEntry("Close", "", 26, 0, 0, widget_0.id);
                }

                if (widget_0.anInt263 == 4) {
                  DynamicObject.addMenuEntry(widget_0.tooltip, "", 28, 0, 0, widget_0.id);
                }

                if (widget_0.anInt263 == 5) {
                  DynamicObject.addMenuEntry(widget_0.tooltip, "", 29, 0, 0, widget_0.id);
                }

                if (widget_0.anInt263 == 6 && Client.aWidget13 == null) {
                  DynamicObject.addMenuEntry(widget_0.tooltip, "", 30, 0, -1, widget_0.id);
                }

                if (widget_0.type == 2) {
                  int_19 = 0;

                  for (int_20 = 0; int_20 < widget_0.height; int_20++) {
                    for (int_21 = 0; int_21 < widget_0.width; int_21++) {
                      int_22 = int_21 * (widget_0.paddingX + 32);
                      int_23 = (widget_0.paddingY + 32) * int_20;
                      if (int_19 < 20) {
                        int_22 += widget_0.xSprites[int_19];
                        int_23 += widget_0.anIntArray72[int_19];
                      }

                      if (int_17 >= int_22 && int_18 >= int_23 && int_17 < int_22 + 32
                          && int_18 < int_23 + 32) {
                        Client.anInt689 = int_19;
                        Class104.aWidget6 = widget_0;
                        if (widget_0.itemIds[int_19] > 0) {
                          final ItemConfig itemcomposition_0 = AudioWorker
                              .getItemDefinition(widget_0.itemIds[int_19] - 1);
                          if (Client.itemSelectionState == 1
                              && Class12.method165(Client.getWidgetConfig(widget_0))) {
                            if (widget_0.id != Class1.anInt15
                                || int_19 != MessageNode.selectedItemIndex) {
                              DynamicObject.addMenuEntry("Use",
                                  Client.aString33 + " " + "->" + " "
                                      + Square.getColTags(16748608)
                                      + itemcomposition_0.name,
                                  31, itemcomposition_0.id, int_19, widget_0.id);
                            }
                          } else if (Client.spellSelected
                              && Class12.method165(Client.getWidgetConfig(widget_0))) {
                            if ((JavaxSourceDataLineProvider.anInt62 & 0x10) == 16) {
                              DynamicObject.addMenuEntry(Client.aString34,
                                  Client.aString35 + " " + "->" + " "
                                      + Square.getColTags(16748608)
                                      + itemcomposition_0.name,
                                  32, itemcomposition_0.id, int_19, widget_0.id);
                            }
                          } else {
                            String[] strings_0 = itemcomposition_0.inventoryActions;
                            if (Client.aBool90) {
                              strings_0 = Class65.method409(strings_0);
                            }

                            int_25 = -1;
                            if (Client.aBool91 && Keyboard.aBoolArray3[81]) {
                              int_25 = itemcomposition_0.method902();
                            }

                            if (Class12.method165(Client.getWidgetConfig(widget_0))) {
                              for (int_26 = 4; int_26 >= 3; --int_26) {
                                if (int_26 != int_25) {
                                  Class2.method120(widget_0, itemcomposition_0,
                                      int_19, int_26, false);
                                }
                              }
                            }

                            if (Class89.method495(Client.getWidgetConfig(widget_0))) {
                              DynamicObject.addMenuEntry("Use",
                                  Square.getColTags(16748608) + itemcomposition_0.name,
                                  38, itemcomposition_0.id, int_19, widget_0.id);
                            }

                            if (Class12.method165(Client.getWidgetConfig(widget_0))) {
                              for (int_26 = 2; int_26 >= 0; --int_26) {
                                if (int_26 != int_25) {
                                  Class2.method120(widget_0, itemcomposition_0,
                                      int_19, int_26, false);
                                }
                              }

                              if (int_25 >= 0) {
                                Class2.method120(widget_0, itemcomposition_0, int_19,
                                    int_25, true);
                              }
                            }

                            strings_0 = widget_0.configActions;
                            if (Client.aBool90) {
                              strings_0 = Class65.method409(strings_0);
                            }

                            if (strings_0 != null) {
                              for (int_26 = 4; int_26 >= 0; --int_26) {
                                if (strings_0[int_26] != null) {
                                  byte byte_0 = 0;
                                  if (int_26 == 0) {
                                    byte_0 = 39;
                                  }

                                  if (int_26 == 1) {
                                    byte_0 = 40;
                                  }

                                  if (int_26 == 2) {
                                    byte_0 = 41;
                                  }

                                  if (int_26 == 3) {
                                    byte_0 = 42;
                                  }

                                  if (int_26 == 4) {
                                    byte_0 = 43;
                                  }

                                  DynamicObject.addMenuEntry(strings_0[int_26],
                                      Square.getColTags(16748608)
                                          + itemcomposition_0.name,
                                      byte_0, itemcomposition_0.id, int_19,
                                      widget_0.id);
                                }
                              }
                            }

                            DynamicObject.addMenuEntry("Examine",
                                Square.getColTags(16748608) + itemcomposition_0.name,
                                1005, itemcomposition_0.id, int_19, widget_0.id);
                          }
                        }
                      }

                      ++int_19;
                    }
                  }
                }

                if (widget_0.hasScript) {
                  if (Client.spellSelected) {
                    if (Class52.method336(Client.getWidgetConfig(widget_0))
                        && (JavaxSourceDataLineProvider.anInt62 & 0x20) == 32) {
                      DynamicObject.addMenuEntry(Client.aString34,
                          Client.aString35 + " " + "->" + " " + widget_0.name, 58, 0,
                          widget_0.index, widget_0.id);
                    }
                  } else {
                    for (int_19 = 9; int_19 >= 5; --int_19) {
                      final String string_1 = Class38.method265(widget_0, int_19);
                      if (string_1 != null) {
                        DynamicObject.addMenuEntry(string_1, widget_0.name, 1007, int_19 + 1,
                            widget_0.index, widget_0.id);
                      }
                    }

                    string_0 = Renderable.method713(widget_0);
                    if (string_0 != null) {
                      DynamicObject.addMenuEntry(string_0, widget_0.name, 25, 0, widget_0.index,
                          widget_0.id);
                    }

                    for (int_20 = 4; int_20 >= 0; --int_20) {
                      final String string_2 = Class38.method265(widget_0, int_20);
                      if (string_2 != null) {
                        DynamicObject.addMenuEntry(string_2, widget_0.name, 57, int_20 + 1,
                            widget_0.index, widget_0.id);
                      }
                    }

                    if (InterfaceComponent.allowsContinueOption(Client.getWidgetConfig(widget_0))) {
                      DynamicObject.addMenuEntry("Continue", "", 30, 0, widget_0.index,
                          widget_0.id);
                    }
                  }
                }
              }
            }

            if (widget_0.type == 0) {
              if (!widget_0.hasScript && Renderable.method711(widget_0)
                  && widget_0 != IntegerVariable.aWidget4) {
                continue;
              }

              method405(widgets_0, widget_0.id, int_10, int_11, int_12, int_13,
                  int_8 - widget_0.scrollX,
                  int_9 - widget_0.scrollY);
              if (widget_0.children != null) {
                method405(widget_0.children, widget_0.id, int_10, int_11, int_12, int_13,
                    int_8 - widget_0.scrollX, int_9 - widget_0.scrollY);
              }

              final OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable.get(widget_0.id);
              if (widgetnode_0 != null) {
                if (widgetnode_0.owner == 0 && Mouse.anInt249 >= int_10
                    && Mouse.anInt251 >= int_11 && Mouse.anInt249 < int_12
                    && Mouse.anInt251 < int_13 && !Client.isMenuOpen && !Client.aBool80) {
                  for (ScriptCall scriptevent_0 = (ScriptCall) Client.aDeque7
                      .getFirst(); scriptevent_0 != null;
                      scriptevent_0 = (ScriptCall) Client.aDeque7
                          .getNext()) {
                    if (scriptevent_0.aBool49) {
                      scriptevent_0.unlink();
                      scriptevent_0.widget.aBool35 = false;
                    }
                  }

                  if (Class3.anInt21 == 0) {
                    Client.aWidget9 = null;
                    Client.aWidget10 = null;
                  }

                  if (!Client.isMenuOpen) {
                    Class2.method118();
                  }
                }

                AbstractByteBuffer.method274(widgetnode_0.id, int_10, int_11, int_12, int_13, int_8,
                    int_9);
              }
            }

            if (widget_0.hasScript) {
              ScriptCall scriptevent_3;
              if (!widget_0.aBool31) {
                if (widget_0.aBool37 && Mouse.anInt249 >= int_10
                    && Mouse.anInt251 >= int_11 && Mouse.anInt249 < int_12
                    && Mouse.anInt251 < int_13) {
                  for (scriptevent_3 = (ScriptCall) Client.aDeque7
                      .getFirst(); scriptevent_3 != null;
                      scriptevent_3 = (ScriptCall) Client.aDeque7
                          .getNext()) {
                    if (scriptevent_3.aBool49
                        && scriptevent_3.widget.scrollListener == scriptevent_3.anObjectArray22) {
                      scriptevent_3.unlink();
                    }
                  }
                }
              } else if (Mouse.anInt249 >= int_10 && Mouse.anInt251 >= int_11
                  && Mouse.anInt249 < int_12 && Mouse.anInt251 < int_13) {
                for (scriptevent_3 = (ScriptCall) Client.aDeque7
                    .getFirst(); scriptevent_3 != null; scriptevent_3 = (ScriptCall) Client.aDeque7
                    .getNext()) {
                  if (scriptevent_3.aBool49) {
                    scriptevent_3.unlink();
                    scriptevent_3.widget.aBool35 = false;
                  }
                }

                if (Class3.anInt21 == 0) {
                  Client.aWidget9 = null;
                  Client.aWidget10 = null;
                }

                if (!Client.isMenuOpen) {
                  Class2.method118();
                }
              }

              if (Mouse.anInt249 >= int_10 && Mouse.anInt251 >= int_11
                  && Mouse.anInt249 < int_12 && Mouse.anInt251 < int_13) {
                bool_0 = true;
              } else {
                bool_0 = false;
              }

              boolean bool_2 = false;
              if ((Mouse.anInt252 == 1
                  || !GrandExchangeOffer.aBool5 && Mouse.anInt252 == 4) && bool_0) {
                bool_2 = true;
              }

              boolean bool_1 = false;
              if ((Mouse.anInt248 == 1
                  || !GrandExchangeOffer.aBool5 && Mouse.anInt248 == 4)
                  && Mouse.anInt253 >= int_10 && Mouse.anInt254 >= int_11
                  && Mouse.anInt253 < int_12 && Mouse.anInt254 < int_13) {
                bool_1 = true;
              }

              if (bool_1) {
                Class22
                    .method210(widget_0, Mouse.anInt253 - int_8, Mouse.anInt254 - int_9);
              }

              if (widget_0.contentType == 1400) {
                Class14.renderOverview.method44(Mouse.anInt249, Mouse.anInt251,
                    bool_0 & bool_2);
              }

              if (Client.aWidget9 != null && widget_0 != Client.aWidget9 && bool_0) {
                int_20 = Client.getWidgetConfig(widget_0);
                final boolean bool_3 = (int_20 >> 20 & 0x1) != 0;
                if (bool_3) {
                  Client.aWidget12 = widget_0;
                }
              }

              if (widget_0 == Client.aWidget10) {
                Client.aBool79 = true;
                Client.anInt606 = int_8;
                Client.anInt611 = int_9;
              }

              if (widget_0.aBool28) {
                ScriptCall scriptevent_2;
                if (bool_0 && Client.anInt617 != 0 && widget_0.scrollListener != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.aBool49 = true;
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anInt381 = Client.anInt617;
                  scriptevent_2.anObjectArray22 = widget_0.scrollListener;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.aWidget9 != null || Class29.aWidget3 != null || Client.isMenuOpen) {
                  bool_1 = false;
                  bool_2 = false;
                  bool_0 = false;
                }

                if (!widget_0.aBool36 && bool_1) {
                  widget_0.aBool36 = true;
                  if (widget_0.anObjectArray9 != null) {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.aBool49 = true;
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anInt380 = Mouse.anInt253 - int_8;
                    scriptevent_2.anInt381 = Mouse.anInt254 - int_9;
                    scriptevent_2.anObjectArray22 = widget_0.anObjectArray9;
                    Client.aDeque7.addLast(scriptevent_2);
                  }
                }

                if (widget_0.aBool36 && bool_2 && widget_0.anObjectArray11 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.aBool49 = true;
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                  scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray11;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (widget_0.aBool36 && !bool_2) {
                  widget_0.aBool36 = false;
                  if (widget_0.anObjectArray12 != null) {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.aBool49 = true;
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                    scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                    scriptevent_2.anObjectArray22 = widget_0.anObjectArray12;
                    Client.aDeque9.addLast(scriptevent_2);
                  }
                }

                if (bool_2 && widget_0.anObjectArray10 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.aBool49 = true;
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                  scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray10;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (!widget_0.aBool35 && bool_0) {
                  widget_0.aBool35 = true;
                  if (widget_0.mouseEnterListener != null) {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.aBool49 = true;
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                    scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                    scriptevent_2.anObjectArray22 = widget_0.mouseEnterListener;
                    Client.aDeque7.addLast(scriptevent_2);
                  }
                }

                if (widget_0.aBool35 && bool_0 && widget_0.mouseHoverListener != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.aBool49 = true;
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                  scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                  scriptevent_2.anObjectArray22 = widget_0.mouseHoverListener;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (widget_0.aBool35 && !bool_0) {
                  widget_0.aBool35 = false;
                  if (widget_0.mouseExitListener != null) {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.aBool49 = true;
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anInt380 = Mouse.anInt249 - int_8;
                    scriptevent_2.anInt381 = Mouse.anInt251 - int_9;
                    scriptevent_2.anObjectArray22 = widget_0.mouseExitListener;
                    Client.aDeque9.addLast(scriptevent_2);
                  }
                }

                if (widget_0.renderListener != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.renderListener;
                  Client.aDeque8.addLast(scriptevent_2);
                }

                ScriptCall scriptevent_1;
                if (widget_0.configListenerArgs != null && Client.anInt637
                    > widget_0.anInt289) {
                  if (widget_0.configTriggers != null
                      && Client.anInt637 - widget_0.anInt289 <= 32) {
                    label1382:
                    for (int_19 = widget_0.anInt289; int_19 < Client.anInt637; int_19++) {
                      int_20 = Client.anIntArray143[int_19 & 0x1F];

                      for (int_21 = 0; int_21 < widget_0.configTriggers.length; int_21++) {
                        if (int_20 == widget_0.configTriggers[int_21]) {
                          scriptevent_1 = new ScriptCall();
                          scriptevent_1.widget = widget_0;
                          scriptevent_1.anObjectArray22 = widget_0.configListenerArgs;
                          Client.aDeque7.addLast(scriptevent_1);
                          break label1382;
                        }
                      }
                    }
                  } else {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anObjectArray22 = widget_0.configListenerArgs;
                    Client.aDeque7.addLast(scriptevent_2);
                  }

                  widget_0.anInt289 = Client.anInt637;
                }

                if (widget_0.tableListenerArgs != null && Client.anInt641 > widget_0.anInt290) {
                  if (widget_0.tableModTriggers != null
                      && Client.anInt641 - widget_0.anInt290 <= 32) {
                    label1358:
                    for (int_19 = widget_0.anInt290; int_19 < Client.anInt641; int_19++) {
                      int_20 = Client.interfaceItemTriggers[int_19 & 0x1F];

                      for (int_21 = 0; int_21 < widget_0.tableModTriggers.length; int_21++) {
                        if (int_20 == widget_0.tableModTriggers[int_21]) {
                          scriptevent_1 = new ScriptCall();
                          scriptevent_1.widget = widget_0;
                          scriptevent_1.anObjectArray22 = widget_0.tableListenerArgs;
                          Client.aDeque7.addLast(scriptevent_1);
                          break label1358;
                        }
                      }
                    }
                  } else {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anObjectArray22 = widget_0.tableListenerArgs;
                    Client.aDeque7.addLast(scriptevent_2);
                  }

                  widget_0.anInt290 = Client.anInt641;
                }

                if (widget_0.skillListenerArgs != null && Client.anInt645 > widget_0.anInt291) {
                  if (widget_0.skillTriggers != null
                      && Client.anInt645 - widget_0.anInt291 <= 32) {
                    label1334:
                    for (int_19 = widget_0.anInt291; int_19 < Client.anInt645; int_19++) {
                      int_20 = Client.anIntArray144[int_19 & 0x1F];

                      for (int_21 = 0; int_21 < widget_0.skillTriggers.length; int_21++) {
                        if (int_20 == widget_0.skillTriggers[int_21]) {
                          scriptevent_1 = new ScriptCall();
                          scriptevent_1.widget = widget_0;
                          scriptevent_1.anObjectArray22 = widget_0.skillListenerArgs;
                          Client.aDeque7.addLast(scriptevent_1);
                          break label1334;
                        }
                      }
                    }
                  } else {
                    scriptevent_2 = new ScriptCall();
                    scriptevent_2.widget = widget_0;
                    scriptevent_2.anObjectArray22 = widget_0.skillListenerArgs;
                    Client.aDeque7.addLast(scriptevent_2);
                  }

                  widget_0.anInt291 = Client.anInt645;
                }

                if (Client.chatCycle > widget_0.anInt288 && widget_0.anObjectArray13 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray13;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.anInt646 > widget_0.anInt288 && widget_0.anObjectArray15 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray15;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.anInt659 > widget_0.anInt288 && widget_0.anObjectArray16 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray16;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.anInt664 > widget_0.anInt288 && widget_0.anObjectArray20 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray20;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.anInt688 > widget_0.anInt288 && widget_0.anObjectArray21 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray21;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                if (Client.anInt639 > widget_0.anInt288 && widget_0.anObjectArray17 != null) {
                  scriptevent_2 = new ScriptCall();
                  scriptevent_2.widget = widget_0;
                  scriptevent_2.anObjectArray22 = widget_0.anObjectArray17;
                  Client.aDeque7.addLast(scriptevent_2);
                }

                widget_0.anInt288 = Client.cycleCntr;
                if (widget_0.anObjectArray14 != null) {
                  for (int_19 = 0; int_19 < Client.anInt686; int_19++) {
                    final ScriptCall scriptevent_4 = new ScriptCall();
                    scriptevent_4.widget = widget_0;
                    scriptevent_4.anInt384 = Client.anIntArray165[int_19];
                    scriptevent_4.anInt385 = Client.anIntArray166[int_19];
                    scriptevent_4.anObjectArray22 = widget_0.anObjectArray14;
                    Client.aDeque7.addLast(scriptevent_4);
                  }
                }
              }
            }

            if (!widget_0.hasScript && Client.aWidget9 == null && Class29.aWidget3 == null
                && !Client.isMenuOpen) {
              if ((widget_0.anInt273 >= 0 || widget_0.anInt276 != 0)
                  && Mouse.anInt249 >= int_10 && Mouse.anInt251 >= int_11
                  && Mouse.anInt249 < int_12 && Mouse.anInt251 < int_13) {
                if (widget_0.anInt273 >= 0) {
                  IntegerVariable.aWidget4 = widgets_0[widget_0.anInt273];
                } else {
                  IntegerVariable.aWidget4 = widget_0;
                }
              }

              if (widget_0.type == 8 && Mouse.anInt249 >= int_10
                  && Mouse.anInt251 >= int_11 && Mouse.anInt249 < int_12
                  && Mouse.anInt251 < int_13) {
                Class43.aWidget5 = widget_0;
              }

              if (widget_0.scrollHeight > widget_0.height) {
                int_17 = int_8 + widget_0.width;
                int_18 = widget_0.height;
                int_19 = widget_0.scrollHeight;
                int_20 = Mouse.anInt249;
                int_21 = Mouse.anInt251;
                if (Client.aBool89) {
                  Client.anInt670 = 32;
                } else {
                  Client.anInt670 = 0;
                }

                Client.aBool89 = false;
                if (Mouse.anInt252 == 1
                    || !GrandExchangeOffer.aBool5 && Mouse.anInt252 == 4) {
                  if (int_20 >= int_17 && int_20 < int_17 + 16 && int_21 >= int_9
                      && int_21 < int_9 + 16) {
                    widget_0.scrollY -= 4;
                    Class28.method236(widget_0);
                  } else if (int_20 >= int_17 && int_20 < int_17 + 16
                      && int_21 >= int_18 + int_9 - 16 && int_21 < int_18 + int_9) {
                    widget_0.scrollY += 4;
                    Class28.method236(widget_0);
                  } else if (int_20 >= int_17 - Client.anInt670
                      && int_20 < int_17 + Client.anInt670 + 16 && int_21 >= int_9 + 16
                      && int_21 < int_18 + int_9 - 16) {
                    int_22 = int_18 * (int_18 - 32) / int_19;
                    if (int_22 < 8) {
                      int_22 = 8;
                    }

                    int_23 = int_21 - int_9 - 16 - int_22 / 2;
                    int_24 = int_18 - 32 - int_22;
                    widget_0.scrollY = int_23 * (int_19 - int_18) / int_24;
                    Class28.method236(widget_0);
                    Client.aBool89 = true;
                  }
                }

                if (Client.anInt617 != 0) {
                  int_22 = widget_0.width;
                  if (int_20 >= int_17 - int_22 && int_21 >= int_9 && int_20 < int_17 + 16
                      && int_21 <= int_9 + int_18) {
                    widget_0.scrollY += Client.anInt617 * 45;
                    Class28.method236(widget_0);
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
