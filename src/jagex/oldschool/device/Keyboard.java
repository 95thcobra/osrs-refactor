package jagex.oldschool.device;

import jagex.oldschool.AClass1;
import jagex.oldschool.AClass3;
import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.Class11;
import jagex.oldschool.Class12;
import jagex.oldschool.Class20;
import jagex.oldschool.Class39;
import jagex.oldschool.Class59;
import jagex.oldschool.Class77;
import jagex.oldschool.Boundry;
import jagex.oldschool.io.CacheWorker;
import jagex.oldschool.Client;
import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.Inventory;
import jagex.oldschool.scene.AreaSound;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.asset.Package;
import jagex.oldschool.scene.Player;
import jagex.oldschool.WorldMapData_Sub1;
import jagex.oldschool.WorldMapType2;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.FileCache;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener, FocusListener {

  public static boolean[] aBoolArray3;
  public static int[] anIntArray32;
  public static int anInt127;
  public static int keyboardIdleTicks;
  public static Keyboard keyboard;
  public static int anInt123;
  public static int[] anIntArray29;
  public static int[] anIntArray30;
  public static int anInt124;
  public static int anInt125;
  public static int anInt126;
  public static char[] aCharArray1;
  public static int[] anIntArray31;
  public static int anInt128;
  public static int anInt129;
  public static int cameraPitch;

  static {
    keyboard = new Keyboard();
    aBoolArray3 = new boolean[112];
    anIntArray30 = new int[128];
    anInt124 = 0;
    anInt123 = 0;
    aCharArray1 = new char[128];
    anIntArray31 = new int[128];
    anIntArray32 = new int[128];
    anInt127 = 0;
    anInt126 = 0;
    anInt125 = 0;
    anInt128 = 0;
    keyboardIdleTicks = 0;
    anIntArray29 = new int[] {
        -1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1,
        -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1,
        -1, -1, -1,
        -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50,
        34, 51, 52,
        53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1,
        -1, 228,
        231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7,
        8, 9, 10, 11,
        12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1
    };
  }

  public static void fetch(final int int_0, final FileCache indexfile_0,
      final Package indexdata_0) {
    byte[] bytes_0 = null;
    synchronized (CacheWorker.aDeque1) {
      for (LocalRequest filesystem_0 = (LocalRequest) CacheWorker.aDeque1
          .getFirst(); filesystem_0 != null;
          filesystem_0 = (LocalRequest) CacheWorker.aDeque1.getNext()) {
        if (int_0 == filesystem_0.hash && indexfile_0 == filesystem_0.cache
            && filesystem_0.id == 0) {
          bytes_0 = filesystem_0.bytes;
          break;
        }
      }
    }

    if (bytes_0 != null) {
      indexdata_0.validate(indexfile_0, int_0, bytes_0, true);
    } else {
      final byte[] bytes_1 = indexfile_0.method71(int_0);
      indexdata_0.validate(indexfile_0, int_0, bytes_1, true);
    }
  }

  public static void method340(final int int_0) {
    final Inventory itemcontainer_0 = (Inventory) Inventory.inventories.get(int_0);
    if (itemcontainer_0 != null) {
      itemcontainer_0.unlink();
    }
  }

  public static void method341(final InterfaceComponent widget_0, final int int_0, final int int_1,
      final int int_2) {
    Class77.method468();
    final CacheableNode_Sub1 cacheablenode_sub1_0 = widget_0.method579(false);
    if (cacheablenode_sub1_0 != null) {
      Rasterizer2d.setClip(int_0, int_1, cacheablenode_sub1_0.anInt460 + int_0,
          int_1 + cacheablenode_sub1_0.anInt461);
      if (Client.anInt644 != 2 && Client.anInt644 != 5) {
        final int int_3 = Client.mapAngle & 0x7FF;
        final int int_4 = GrandExchangeOffer.localPlayer.x / 32 + 48;
        final int int_5 = 464 - GrandExchangeOffer.localPlayer.y / 32;
        ItemConfig.map.method950(int_0, int_1, cacheablenode_sub1_0.anInt460,
            cacheablenode_sub1_0.anInt461, int_4, int_5, int_3, 256,
            cacheablenode_sub1_0.anIntArray102,
            cacheablenode_sub1_0.anIntArray103);

        int int_6;
        int int_7;
        int int_8;
        for (int_6 = 0; int_6 < Client.iconCount; int_6++) {
          int_7 = Client.iconX[int_6] * 4 + 2 - GrandExchangeOffer.localPlayer.x / 32;
          int_8 = Client.iconY[int_6] * 4 + 2 - GrandExchangeOffer.localPlayer.y / 32;
          WorldMapData_Sub1.drawDot(int_0, int_1, int_7, int_8, Client.iconSprites[int_6],
              cacheablenode_sub1_0);
        }

        int int_9;
        int int_10;
        for (int_6 = 0; int_6 < 104; int_6++) {
          for (int_7 = 0; int_7 < 104; int_7++) {
            final Deque deque_0 = Client.groundItemDeque[Class12.plane][int_6][int_7];
            if (deque_0 != null) {
              int_9 = int_6 * 4 + 2 - GrandExchangeOffer.localPlayer.x / 32;
              int_10 = int_7 * 4 + 2 - GrandExchangeOffer.localPlayer.y / 32;
              WorldMapData_Sub1.drawDot(int_0, int_1, int_9, int_10, Class20.mapDots[0],
                  cacheablenode_sub1_0);
            }
          }
        }

        for (int_6 = 0; int_6 < Client.anInt636; int_6++) {
          final Npc npc_0 = Client.cachedNPCs[Client.npcIndices[int_6]];
          if (npc_0 != null && npc_0.hasConfig()) {
            NpcConfig npccomposition_0 = npc_0.config;
            if (npccomposition_0 != null && npccomposition_0.configs != null) {
              npccomposition_0 = npccomposition_0.transform();
            }

            if (npccomposition_0 != null && npccomposition_0.isMinimapVisible
                && npccomposition_0.aBool60) {
              int_9 = npc_0.x / 32 - GrandExchangeOffer.localPlayer.x / 32;
              int_10 = npc_0.y / 32 - GrandExchangeOffer.localPlayer.y / 32;
              WorldMapData_Sub1.drawDot(int_0, int_1, int_9, int_10, Class20.mapDots[1],
                  cacheablenode_sub1_0);
            }
          }
        }

        int_6 = Class39.anInt89;
        final int[] ints_0 = Class39.anIntArray14;

        for (int_8 = 0; int_8 < int_6; int_8++) {
          final Player player_0 = Client.cachedPlayers[ints_0[int_8]];
          if (player_0 != null && player_0.hasConfig() && !player_0.hidden
              && player_0 != GrandExchangeOffer.localPlayer) {
            int_10 = player_0.x / 32 - GrandExchangeOffer.localPlayer.x / 32;
            final int int_11 = player_0.y / 32 - GrandExchangeOffer.localPlayer.y / 32;
            boolean bool_0 = false;
            if (WorldMapType2.isFriended(player_0.name, true)) {
              bool_0 = true;
            }

            boolean bool_1 = false;

            for (int int_12 = 0; int_12 < AreaSound.clanChatCount; int_12++) {
              if (player_0.name.equals(AClass1.clanMembers[int_12].username)) {
                bool_1 = true;
                break;
              }
            }

            boolean bool_2 = false;
            if (GrandExchangeOffer.localPlayer.team != 0 && player_0.team != 0
                && player_0.team == GrandExchangeOffer.localPlayer.team) {
              bool_2 = true;
            }

            if (bool_0) {
              WorldMapData_Sub1.drawDot(int_0, int_1, int_10, int_11, Class20.mapDots[3],
                  cacheablenode_sub1_0);
            } else if (bool_2) {
              WorldMapData_Sub1.drawDot(int_0, int_1, int_10, int_11, Class20.mapDots[4],
                  cacheablenode_sub1_0);
            } else if (bool_1) {
              WorldMapData_Sub1.drawDot(int_0, int_1, int_10, int_11, Class20.mapDots[5],
                  cacheablenode_sub1_0);
            } else {
              WorldMapData_Sub1.drawDot(int_0, int_1, int_10, int_11, Class20.mapDots[2],
                  cacheablenode_sub1_0);
            }
          }
        }

        if (Client.anInt614 != 0 && Client.tick % 20 < 10) {
          if (Client.anInt614 == 1 && Client.anInt616 >= 0
              && Client.anInt616 < Client.cachedNPCs.length) {
            final Npc npc_1 = Client.cachedNPCs[Client.anInt616];
            if (npc_1 != null) {
              int_9 = npc_1.x / 32 - GrandExchangeOffer.localPlayer.x / 32;
              int_10 = npc_1.y / 32 - GrandExchangeOffer.localPlayer.y / 32;
              Class11.method161(int_0, int_1, int_9, int_10, AClass3.aSpritePixelsArray3[1],
                  cacheablenode_sub1_0);
            }
          }

          if (Client.anInt614 == 2) {
            int_8 = 2 + Client.hintArrowX * 4 - Boundry.baseX * 4
                - GrandExchangeOffer.localPlayer.x / 32;
            int_9 = Client.hintArrowY * 4 - WorldMapData_Sub1.baseY * 4 + 2
                - GrandExchangeOffer.localPlayer.y / 32;
            Class11.method161(int_0, int_1, int_8, int_9, AClass3.aSpritePixelsArray3[1],
                cacheablenode_sub1_0);
          }

          if (Client.anInt614 == 10 && Client.anInt620 >= 0
              && Client.anInt620 < Client.cachedPlayers.length) {
            final Player player_1 = Client.cachedPlayers[Client.anInt620];
            if (player_1 != null) {
              int_9 = player_1.x / 32 - GrandExchangeOffer.localPlayer.x / 32;
              int_10 = player_1.y / 32 - GrandExchangeOffer.localPlayer.y / 32;
              Class11.method161(int_0, int_1, int_9, int_10, AClass3.aSpritePixelsArray3[1],
                  cacheablenode_sub1_0);
            }
          }
        }

        if (Client.destinationX != 0) {
          int_8 = 2 + Client.destinationX * 4 - GrandExchangeOffer.localPlayer.x / 32;
          int_9 = Client.destinationY * 4 + 2 - GrandExchangeOffer.localPlayer.y / 32;
          WorldMapData_Sub1.drawDot(int_0, int_1, int_8, int_9, AClass3.aSpritePixelsArray3[0],
              cacheablenode_sub1_0);
        }

        if (!GrandExchangeOffer.localPlayer.hidden) {
          Rasterizer2d.fillRectangle(cacheablenode_sub1_0.anInt460 / 2 + int_0 - 1,
              cacheablenode_sub1_0.anInt461 / 2 + int_1 - 1, 3, 3, 16777215);
        }
      } else {
        Rasterizer2d.method887(int_0, int_1, 0, cacheablenode_sub1_0.anIntArray102,
            cacheablenode_sub1_0.anIntArray103);
      }

      Client.aBoolArray10[int_2] = true;
    }
  }

  public static void poll() {
    synchronized (keyboard) {
      ++keyboardIdleTicks;
      anInt126 = anInt128;
      anInt127 = 0;
      int int_0;
      if (anInt123 < 0) {
        for (int_0 = 0; int_0 < 112; int_0++) {
          aBoolArray3[int_0] = false;
        }

        anInt123 = anInt124;
      } else {
        while (anInt123 != anInt124) {
          int_0 = anIntArray30[anInt124];
          anInt124 = anInt124 + 1 & 0x7F;
          if (int_0 < 0) {
            aBoolArray3[~int_0] = false;
          } else {
            if (!aBoolArray3[int_0]
                && anInt127 < anIntArray32.length - 1) {
              anIntArray32[++anInt127 - 1] = int_0;
            }

            aBoolArray3[int_0] = true;
          }
        }
      }

      if (anInt127 > 0) {
        keyboardIdleTicks = 0;
      }

      anInt128 = anInt125;
    }
  }

  @Override
  public final void focusGained(final FocusEvent focusevent_0) {
  }

  @Override
  public final synchronized void keyReleased(final KeyEvent keyevent_0) {
    if (keyboard != null) {
      int int_0 = keyevent_0.getKeyCode();
      if (int_0 >= 0 && int_0 < anIntArray29.length) {
        int_0 = anIntArray29[int_0] & 0xFFFFFF7F;
      } else {
        int_0 = -1;
      }

      if (anInt123 >= 0 && int_0 >= 0) {
        anIntArray30[anInt123] = ~int_0;
        anInt123 = anInt123 + 1 & 0x7F;
        if (anInt124 == anInt123) {
          anInt123 = -1;
        }
      }
    }

    keyevent_0.consume();
  }

  @Override
  public final synchronized void focusLost(final FocusEvent focusevent_0) {
    if (keyboard != null) {
      anInt123 = -1;
    }

  }

  @Override
  public final synchronized void keyPressed(final KeyEvent keyevent_0) {
    if (keyboard != null) {
      int int_0 = keyevent_0.getKeyCode();
      if (int_0 >= 0 && int_0 < anIntArray29.length) {
        int_0 = anIntArray29[int_0];
        if ((int_0 & 0x80) != 0) {
          int_0 = -1;
        }
      } else {
        int_0 = -1;
      }

      if (anInt123 >= 0 && int_0 >= 0) {
        anIntArray30[anInt123] = int_0;
        anInt123 = anInt123 + 1 & 0x7F;
        if (anInt124 == anInt123) {
          anInt123 = -1;
        }
      }

      int int_1;
      if (int_0 >= 0) {
        int_1 = anInt125 + 1 & 0x7F;
        if (int_1 != anInt126) {
          anIntArray31[anInt125] = int_0;
          aCharArray1[anInt125] = 0;
          anInt125 = int_1;
        }
      }

      int_1 = keyevent_0.getModifiers();
      if ((int_1 & 0xA) != 0 || int_0 == 85 || int_0 == 10) {
        keyevent_0.consume();
      }
    }

  }

  @Override
  public final void keyTyped(final KeyEvent keyevent_0) {
    if (keyboard != null) {
      final char char_0 = keyevent_0.getKeyChar();
      if (char_0 != 0 && char_0 != 65535 && Class59.method397(char_0)) {
        final int int_0 = anInt125 + 1 & 0x7F;
        if (int_0 != anInt126) {
          anIntArray31[anInt125] = -1;
          aCharArray1[anInt125] = char_0;
          anInt125 = int_0;
        }
      }
    }

    keyevent_0.consume();
  }

}
