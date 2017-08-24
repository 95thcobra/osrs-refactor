package jagex.oldschool.social;

import jagex.oldschool.Class11;
import jagex.oldschool.World;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;

public class Ignore {

  public static int[] anIntArray59;
  public static int[] anIntArray60;
  public String name;
  public String previousName;

  public static boolean loadWidget(final int int_0) {
    if (PrimitiveType.validInterfaces[int_0]) {
      return true;
    }
    if (!AudioWorker.widgetIndex.contains(int_0)) {
      return false;
    }
    final int int_1 = AudioWorker.widgetIndex.fileCount(int_0);
    if (int_1 == 0) {
      PrimitiveType.validInterfaces[int_0] = true;
      return true;
    }
    if (Time.widgets[int_0] == null) {
      Time.widgets[int_0] = new InterfaceComponent[int_1];
    }

    for (int int_2 = 0; int_2 < int_1; int_2++) {
      if (Time.widgets[int_0][int_2] == null) {
        final byte[] bytes_0 = AudioWorker.widgetIndex.get(int_0, int_2);
        if (bytes_0 != null) {
          Time.widgets[int_0][int_2] = new InterfaceComponent();
          Time.widgets[int_0][int_2].id = int_2 + (int_0 << 16);
          if (bytes_0[0] == -1) {
            Time.widgets[int_0][int_2].decodeActive(new Buffer(bytes_0));
          } else {
            Time.widgets[int_0][int_2].decode(new Buffer(bytes_0));
          }
        }
      }
    }

    PrimitiveType.validInterfaces[int_0] = true;
    return true;
  }

  public static void method535() {
    PlayerVariable.varplayers.reset();
  }

  public static int method536(final GameBuffer packetbuffer_0) {
    final int int_0 = packetbuffer_0.getBits(2);
    int int_1;
    if (int_0 == 0) {
      int_1 = 0;
    } else if (int_0 == 1) {
      int_1 = packetbuffer_0.getBits(5);
    } else if (int_0 == 2) {
      int_1 = packetbuffer_0.getBits(8);
    } else {
      int_1 = packetbuffer_0.getBits(11);
    }

    return int_1;
  }

  public static void method537(final int int_0, final int int_1, final int int_2,
      final boolean bool_0,
      final int int_3,
      final boolean bool_1) {
    if (int_0 < int_1) {
      final int int_4 = (int_0 + int_1) / 2;
      int int_5 = int_0;
      final World world_0 = World.worldList[int_4];
      World.worldList[int_4] = World.worldList[int_1];
      World.worldList[int_1] = world_0;

      for (int int_6 = int_0; int_6 < int_1; int_6++) {
        final World world_1 = World.worldList[int_6];
        final int int_7 = Class11.method163(world_1, world_0, int_2, bool_0);
        int int_8;
        if (int_7 != 0) {
          if (bool_0) {
            int_8 = -int_7;
          } else {
            int_8 = int_7;
          }
        } else if (int_3 == -1) {
          int_8 = 0;
        } else {
          final int int_9 = Class11.method163(world_1, world_0, int_3, bool_1);
          if (bool_1) {
            int_8 = -int_9;
          } else {
            int_8 = int_9;
          }
        }

        if (int_8 <= 0) {
          final World world_2 = World.worldList[int_6];
          World.worldList[int_6] = World.worldList[int_5];
          World.worldList[int_5++] = world_2;
        }
      }

      World.worldList[int_1] = World.worldList[int_5];
      World.worldList[int_5] = world_0;
      method537(int_0, int_5 - 1, int_2, bool_0, int_3, bool_1);
      method537(int_5 + 1, int_1, int_2, bool_0, int_3, bool_1);
    }
  }

  public static char method538(final char char_0, final int int_0) {
    if (char_0 >= 192 && char_0 <= 255) {
      if (char_0 >= 192 && char_0 <= 198) {
        return 'A';
      }

      if (char_0 == 199) {
        return 'C';
      }

      if (char_0 >= 200 && char_0 <= 203) {
        return 'E';
      }

      if (char_0 >= 204 && char_0 <= 207) {
        return 'I';
      }

      if (char_0 >= 210 && char_0 <= 214) {
        return 'O';
      }

      if (char_0 >= 217 && char_0 <= 220) {
        return 'U';
      }

      if (char_0 == 221) {
        return 'Y';
      }

      if (char_0 == 223) {
        return 's';
      }

      if (char_0 >= 224 && char_0 <= 230) {
        return 'a';
      }

      if (char_0 == 231) {
        return 'c';
      }

      if (char_0 >= 232 && char_0 <= 235) {
        return 'e';
      }

      if (char_0 >= 236 && char_0 <= 239) {
        return 'i';
      }

      if (char_0 >= 242 && char_0 <= 246) {
        return 'o';
      }

      if (char_0 >= 249 && char_0 <= 252) {
        return 'u';
      }

      if (char_0 == 253 || char_0 == 255) {
        return 'y';
      }
    }

    return char_0 == 338 ? 'O' : char_0 == 339 ? 'o' : char_0 == 376 ? 'Y' : char_0;
  }

}
