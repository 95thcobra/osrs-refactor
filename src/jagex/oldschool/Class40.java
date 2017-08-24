package jagex.oldschool;

import jagex.oldschool.device.Keyboard;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.task.TaskQueue;

public class Class40 {

  public static final Class40 aClass40_2;
  public static final Class40 aClass40_3;
  static UrlStreamWorker aClass24_1;
  public static Class54 aClass54_1;

  static {
    aClass40_2 = new Class40();
    aClass40_3 = new Class40();
  }

  public static void method268() {
    if (TaskQueue.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
      Keyboard.anIntArray29[186] = 57;
      Keyboard.anIntArray29[187] = 27;
      Keyboard.anIntArray29[188] = 71;
      Keyboard.anIntArray29[189] = 26;
      Keyboard.anIntArray29[190] = 72;
      Keyboard.anIntArray29[191] = 73;
      Keyboard.anIntArray29[192] = 58;
      Keyboard.anIntArray29[219] = 42;
      Keyboard.anIntArray29[220] = 74;
      Keyboard.anIntArray29[221] = 43;
      Keyboard.anIntArray29[222] = 59;
      Keyboard.anIntArray29[223] = 28;
    } else {
      Keyboard.anIntArray29[44] = 71;
      Keyboard.anIntArray29[45] = 26;
      Keyboard.anIntArray29[46] = 72;
      Keyboard.anIntArray29[47] = 73;
      Keyboard.anIntArray29[59] = 57;
      Keyboard.anIntArray29[61] = 27;
      Keyboard.anIntArray29[91] = 42;
      Keyboard.anIntArray29[92] = 74;
      Keyboard.anIntArray29[93] = 43;
      Keyboard.anIntArray29[192] = 28;
      Keyboard.anIntArray29[222] = 58;
      Keyboard.anIntArray29[520] = 59;
    }
  }

  public static Game[] method269() {
    return new Game[] {
        Game.GAME5, Game.OLDSCHOOL, Game.RUNESCAPE, Game.STELLARDAWN, Game.GAME3,
        Game.GAME4
    };
  }

  static void method270(final int int_0, final int int_1) {
    final int[] ints_0 = new int[4];
    final int[] ints_1 = new int[4];
    ints_0[0] = int_0;
    ints_1[0] = int_1;
    int int_2 = 1;

    for (int int_3 = 0; int_3 < 4; int_3++) {
      if (World.anIntArray63[int_3] != int_0) {
        ints_0[int_2] = World.anIntArray63[int_3];
        ints_1[int_2] = World.anIntArray62[int_3];
        ++int_2;
      }
    }

    World.anIntArray63 = ints_0;
    World.anIntArray62 = ints_1;
    ScriptCall.method707(World.worldList, 0, World.worldList.length - 1, World.anIntArray63,
        World.anIntArray62);
  }

  static int method271(final int int_0, final int int_1, final int int_2) {
    final int int_3 = 256 - int_2;
    return ((int_1 & 0xFF00FF) * int_2 + int_3 * (int_0 & 0xFF00FF) & 0xFF00FF00)
        + ((int_0 & 0xFF00) * int_3 + (int_1 & 0xFF00) * int_2 & 0xFF0000) >> 8;
  }

  static void method272(final int int_0, final int int_1, final int int_2, final int int_3) {
    for (int int_4 = int_1; int_4 <= int_3 + int_1; int_4++) {
      for (int int_5 = int_0; int_5 <= int_0 + int_2; int_5++) {
        if (int_5 >= 0 && int_5 < 104 && int_4 >= 0 && int_4 < 104) {
          Class22.aByteArrayArrayArray4[0][int_5][int_4] = 127;
          if (int_0 == int_5 && int_5 > 0) {
            Class22.heightmap[0][int_5][int_4] = Class22.heightmap[0][int_5 - 1][int_4];
          }

          if (int_5 == int_0 + int_2 && int_5 < 103) {
            Class22.heightmap[0][int_5][int_4] = Class22.heightmap[0][int_5 + 1][int_4];
          }

          if (int_4 == int_1 && int_4 > 0) {
            Class22.heightmap[0][int_5][int_4] = Class22.heightmap[0][int_5][int_4 - 1];
          }

          if (int_4 == int_3 + int_1 && int_4 < 103) {
            Class22.heightmap[0][int_5][int_4] = Class22.heightmap[0][int_5][int_4 + 1];
          }
        }
      }
    }

  }

  public static int method273(final int int_0, final Script script_0, final boolean bool_0) {
    if (int_0 == 5306) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class45.method287();
      return 1;
    }
    int int_1;
    if (int_0 == 5307) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      if (int_1 == 1 || int_1 == 2) {
        Client.aLong25 = 0L;
        if (int_1 >= 2) {
          Client.isResized = true;
        } else {
          Client.isResized = false;
        }

        if (Class45.method287() == 1) {
          Enum1.clientInstance.method1041(765, 503);
        } else {
          Enum1.clientInstance.method1041(7680, 2160);
        }

        if (Client.state >= 25) {
          Class51.method327();
        }
      }

      return 1;
    }
    if (int_0 == 5308) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = LongVariable.preferences.windowMode;
      return 1;
    }
    if (int_0 != 5309) {
      return 2;
    }
    int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
    if (int_1 == 1 || int_1 == 2) {
      LongVariable.preferences.windowMode = int_1;
      Class4.method125();
    }

    return 1;
  }

}
