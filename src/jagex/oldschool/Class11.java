package jagex.oldschool;

import jagex.oldschool.config.SpotAnimationConfig;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Scene;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;

public class Class11 {

  static final Class11 aClass11_1;
  static final Class11 aClass11_2;
  public static Scene scene;
  static int anInt55;

  static {
    aClass11_2 = new Class11(0);
    aClass11_1 = new Class11(1);
  }

  final int anInt56;

  Class11(final int int_0) {
    anInt56 = int_0;
  }

  public static SpotAnimationConfig getSpotAnimationConfig(final int int_0) {
    SpotAnimationConfig spotanim_0 = (SpotAnimationConfig) SpotAnimationConfig.spotanims.get(int_0);
    if (spotanim_0 != null) {
      return spotanim_0;
    }
    final byte[] bytes_0 = SpotAnimationConfig.anIndexDataBase15.get(13, int_0);
    spotanim_0 = new SpotAnimationConfig();
    spotanim_0.id = int_0;
    if (bytes_0 != null) {
      spotanim_0.decode(new Buffer(bytes_0));
    }

    SpotAnimationConfig.spotanims.put(spotanim_0, int_0);
    return spotanim_0;
  }

  static void method160() {
    Class39.anInt89 = 0;

    for (int int_0 = 0; int_0 < 2048; int_0++) {
      Class39.aBufferArray1[int_0] = null;
      Class39.aByteArray4[int_0] = 1;
    }

  }

  public static void method161(final int int_0, final int int_1, final int int_2, final int int_3,
      final DirectSprite spritepixels_0, final CacheableNode_Sub1 cacheablenode_sub1_0) {
    final int int_4 = int_2 * int_2 + int_3 * int_3;
    if (int_4 > 4225 && int_4 < 90000) {
      final int int_5 = Client.mapAngle & 0x7FF;
      final int int_6 = Rasterizer3d.SINE[int_5];
      final int int_7 = Rasterizer3d.COSINE[int_5];
      final int int_8 = int_7 * int_2 + int_3 * int_6 >> 16;
      final int int_9 = int_3 * int_7 - int_6 * int_2 >> 16;
      final double double_0 = Math.atan2(int_8, int_9);
      final int int_10 = (int) (Math.sin(double_0) * 63.0D);
      final int int_11 = (int) (Math.cos(double_0) * 57.0D);
      Class57.mapedge
          .method956(int_0 + int_10 + 94 + 4 - 10, (int_1 + 83) - int_11 - 20, 20, 20, 15, 15,
              double_0, 256);
    } else {
      WorldMapData_Sub1.drawDot(int_0, int_1, int_2, int_3, spritepixels_0, cacheablenode_sub1_0);
    }
  }

  public static int method162(int int_0, final Script script_0, final boolean bool_0) {
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      widget_0 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    int int_1;
    if (int_0 == 1300) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] - 1;
      if (int_1 >= 0 && int_1 <= 9) {
        widget_0.method584(int_1, ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize]);
        return 1;
      }
      --Class26.scriptStringStackSize;
      return 1;
    }
    if (int_0 == 1301) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      final int int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      widget_0.dragParent = AClass4_Sub3.method819(int_1, int_2);
      return 1;
    }
    if (int_0 == 1302) {
      widget_0.aBool33 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      return 1;
    }
    if (int_0 == 1303) {
      widget_0.anInt275 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      return 1;
    }
    if (int_0 == 1304) {
      widget_0.anInt277 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      return 1;
    }
    if (int_0 == 1305) {
      widget_0.name = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      return 1;
    }
    if (int_0 == 1306) {
      widget_0.selectedAction = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      return 1;
    }
    if (int_0 == 1307) {
      widget_0.actions = null;
      return 1;
    }
    return 2;
  }

  public static int method163(final World world_0, final World world_1, final int int_0,
      final boolean bool_0) {
    if (int_0 == 1) {
      int int_1 = world_0.playerCount;
      int int_2 = world_1.playerCount;
      if (!bool_0) {
        if (int_1 == -1) {
          int_1 = 2001;
        }

        if (int_2 == -1) {
          int_2 = 2001;
        }
      }

      return int_1 - int_2;
    }
    return int_0 == 2 ? world_0.location - world_1.location
        : int_0 == 3
            ? world_0.activity.equals("-") ? world_1.activity.equals("-") ? 0 : bool_0 ? -1 : 1
            : world_1.activity.equals("-") ? bool_0 ? 1 : -1
                : world_0.activity.compareTo(world_1.activity)
            : int_0 == 4
                ? world_0.method543() ? world_1.method543() ? 0 : 1
                : world_1.method543() ? -1 : 0
                : int_0 == 5
                    ? world_0.method544() ? world_1.method544() ? 0 : 1
                    : world_1.method544() ? -1 : 0
                    : int_0 == 6
                        ? world_0.method542() ? world_1.method542() ? 0 : 1
                        : world_1.method542() ? -1 : 0
                        : int_0 == 7
                            ? world_0.method539() ? world_1.method539() ? 0 : 1
                            : world_1.method539() ? -1 : 0
                            : world_0.id - world_1.id;
  }

}
