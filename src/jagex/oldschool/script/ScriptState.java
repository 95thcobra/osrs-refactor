package jagex.oldschool.script;

import jagex.oldschool.Class11;
import jagex.oldschool.Class2;
import jagex.oldschool.Class8;
import jagex.oldschool.Client;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.Node_Sub5;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.asset.Package;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.graphics.IndexedSprite;

public class ScriptState {

  public static Package indexSoundEffects;
  public int invokedFromPc;
  public Script invokedFromScript;
  public int[] savedLocalInts;
  public String[] savedLocalStrings;

  public ScriptState() {
    invokedFromPc = -1;
  }

  public static int method558(final byte[] bytes_0, final int int_0,
      final CharSequence charsequence_0) {
    final int int_1 = charsequence_0.length();
    int int_2 = int_0;

    for (int int_3 = 0; int_3 < int_1; int_3++) {
      final char char_0 = charsequence_0.charAt(int_3);
      if (char_0 <= 127) {
        bytes_0[int_2++] = (byte) char_0;
      } else if (char_0 <= 2047) {
        bytes_0[int_2++] = (byte) (0xC0 | char_0 >> 6);
        bytes_0[int_2++] = (byte) (0x80 | char_0 & 0x3F);
      } else {
        bytes_0[int_2++] = (byte) (0xE0 | char_0 >> 12);
        bytes_0[int_2++] = (byte) (0x80 | char_0 >> 6 & 0x3F);
        bytes_0[int_2++] = (byte) (0x80 | char_0 & 0x3F);
      }
    }

    return int_2 - int_0;
  }

  public static void method559(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    int int_5 = Class11.scene.method372(int_0, int_1, int_2);
    int int_6;
    int int_7;
    int int_8;
    int int_9;
    int int_10;
    int int_11;
    if (int_5 != 0) {
      int_6 = Class11.scene.method376(int_0, int_1, int_2, int_5);
      int_7 = int_6 >> 6 & 0x3;
      int_8 = int_6 & 0x1F;
      int_9 = int_3;
      if (int_5 > 0) {
        int_9 = int_4;
      }

      final int[] ints_0 = ItemConfig.map.buffer;
      int_10 = 24624 + int_1 * 4 + (103 - int_2) * 2048;
      int_11 = int_5 >> 14 & 0x7FFF;
      final ObjectConfig objectcomposition_0 = Class2.getObjectConfig(int_11);
      if (objectcomposition_0.mapSceneId != -1) {
        final IndexedSprite indexedsprite_0 = Client.anIndexedSpriteArray9[objectcomposition_0.mapSceneId];
        if (indexedsprite_0 != null) {
          final int int_12 = (objectcomposition_0.width * 4 - indexedsprite_0.width) / 2;
          final int int_13 = (objectcomposition_0.height * 4 - indexedsprite_0.height) / 2;
          indexedsprite_0.method933(int_12 + int_1 * 4 + 48,
              int_13 + 48 + (104 - int_2 - objectcomposition_0.height) * 4);
        }
      } else {
        if (int_8 == 0 || int_8 == 2) {
          if (int_7 == 0) {
            ints_0[int_10] = int_9;
            ints_0[int_10 + 512] = int_9;
            ints_0[int_10 + 1024] = int_9;
            ints_0[int_10 + 1536] = int_9;
          } else if (int_7 == 1) {
            ints_0[int_10] = int_9;
            ints_0[int_10 + 1] = int_9;
            ints_0[int_10 + 2] = int_9;
            ints_0[int_10 + 3] = int_9;
          } else if (int_7 == 2) {
            ints_0[int_10 + 3] = int_9;
            ints_0[int_10 + 512 + 3] = int_9;
            ints_0[int_10 + 1024 + 3] = int_9;
            ints_0[int_10 + 1536 + 3] = int_9;
          } else if (int_7 == 3) {
            ints_0[int_10 + 1536] = int_9;
            ints_0[int_10 + 1536 + 1] = int_9;
            ints_0[int_10 + 1536 + 2] = int_9;
            ints_0[int_10 + 1536 + 3] = int_9;
          }
        }

        if (int_8 == 3) {
          if (int_7 == 0) {
            ints_0[int_10] = int_9;
          } else if (int_7 == 1) {
            ints_0[int_10 + 3] = int_9;
          } else if (int_7 == 2) {
            ints_0[int_10 + 1536 + 3] = int_9;
          } else if (int_7 == 3) {
            ints_0[int_10 + 1536] = int_9;
          }
        }

        if (int_8 == 2) {
          if (int_7 == 3) {
            ints_0[int_10] = int_9;
            ints_0[int_10 + 512] = int_9;
            ints_0[int_10 + 1024] = int_9;
            ints_0[int_10 + 1536] = int_9;
          } else if (int_7 == 0) {
            ints_0[int_10] = int_9;
            ints_0[int_10 + 1] = int_9;
            ints_0[int_10 + 2] = int_9;
            ints_0[int_10 + 3] = int_9;
          } else if (int_7 == 1) {
            ints_0[int_10 + 3] = int_9;
            ints_0[int_10 + 512 + 3] = int_9;
            ints_0[int_10 + 1024 + 3] = int_9;
            ints_0[int_10 + 1536 + 3] = int_9;
          } else if (int_7 == 2) {
            ints_0[int_10 + 1536] = int_9;
            ints_0[int_10 + 1536 + 1] = int_9;
            ints_0[int_10 + 1536 + 2] = int_9;
            ints_0[int_10 + 1536 + 3] = int_9;
          }
        }
      }
    }

    int_5 = Class11.scene.method377(int_0, int_1, int_2);
    if (int_5 != 0) {
      int_6 = Class11.scene.method376(int_0, int_1, int_2, int_5);
      int_7 = int_6 >> 6 & 0x3;
      int_8 = int_6 & 0x1F;
      int_9 = int_5 >> 14 & 0x7FFF;
      final ObjectConfig objectcomposition_2 = Class2.getObjectConfig(int_9);
      int int_14;
      if (objectcomposition_2.mapSceneId != -1) {
        final IndexedSprite indexedsprite_1 = Client.anIndexedSpriteArray9[objectcomposition_2.mapSceneId];
        if (indexedsprite_1 != null) {
          int_11 = (objectcomposition_2.width * 4 - indexedsprite_1.width) / 2;
          int_14 = (objectcomposition_2.height * 4 - indexedsprite_1.height) / 2;
          indexedsprite_1.method933(int_1 * 4 + int_11 + 48,
              int_14 + (104 - int_2 - objectcomposition_2.height) * 4 + 48);
        }
      } else if (int_8 == 9) {
        int_10 = 15658734;
        if (int_5 > 0) {
          int_10 = 15597568;
        }

        final int[] ints_1 = ItemConfig.map.buffer;
        int_14 = int_1 * 4 + 24624 + (103 - int_2) * 2048;
        if (int_7 != 0 && int_7 != 2) {
          ints_1[int_14] = int_10;
          ints_1[int_14 + 1 + 512] = int_10;
          ints_1[int_14 + 1024 + 2] = int_10;
          ints_1[int_14 + 1536 + 3] = int_10;
        } else {
          ints_1[int_14 + 1536] = int_10;
          ints_1[int_14 + 1 + 1024] = int_10;
          ints_1[int_14 + 512 + 2] = int_10;
          ints_1[int_14 + 3] = int_10;
        }
      }
    }

    int_5 = Class11.scene.method375(int_0, int_1, int_2);
    if (int_5 != 0) {
      int_6 = int_5 >> 14 & 0x7FFF;
      final ObjectConfig objectcomposition_1 = Class2.getObjectConfig(int_6);
      if (objectcomposition_1.mapSceneId != -1) {
        final IndexedSprite indexedsprite_2 = Client.anIndexedSpriteArray9[objectcomposition_1.mapSceneId];
        if (indexedsprite_2 != null) {
          int_9 = (objectcomposition_1.width * 4 - indexedsprite_2.width) / 2;
          final int int_15 = (objectcomposition_1.height * 4 - indexedsprite_2.height) / 2;
          indexedsprite_2.method933(int_9 + int_1 * 4 + 48,
              int_15 + (104 - int_2 - objectcomposition_1.height) * 4 + 48);
          return;
        }
      }
    }

  }

  public static int method560(int int_0, final Script script_0, final boolean bool_0) {
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      widget_0 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    if (int_0 == 1927) {
      if (ScriptExecutor.anInt83 >= 10) {
        throw new RuntimeException();
      }
      if (widget_0.anObjectArray2 == null) {
        return 0;
      }
      final ScriptCall scriptevent_0 = new ScriptCall();
      scriptevent_0.widget = widget_0;
      scriptevent_0.anObjectArray22 = widget_0.anObjectArray2;
      scriptevent_0.anInt382 = ScriptExecutor.anInt83 + 1;
      Client.aDeque7.addLast(scriptevent_0);
      return 1;
    }
    return 2;
  }

  public static void method561(final int int_0, final int int_1) {
    Client.outbound.putEncipheredByte(72);
    Client.outbound.putShort(int_1);
    Client.outbound.putIntMe(int_0);
  }

}
