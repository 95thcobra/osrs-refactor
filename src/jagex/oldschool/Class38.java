package jagex.oldschool;

import jagex.oldschool.collections.IterableQueue;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.map.MapIcon;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.ui.InterfaceComponent;

public class Class38 {

  public static boolean aBool10;
  public static boolean aBool11;
  public static boolean aBool12;
  public static Class40 aClass40_1;
  public static IterableQueue aCombatInfoList1;

  static {
    aBool10 = false;
    aBool11 = false;
    aBool12 = false;
    aClass40_1 = Class40.aClass40_2;
    aCombatInfoList1 = new IterableQueue();
  }

  static void method264(final byte[] bytes_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final CollisionData[] collisiondatas_0) {
    int int_5;
    int int_6;
    for (int int_4 = 0; int_4 < 4; int_4++) {
      for (int_5 = 0; int_5 < 64; int_5++) {
        for (int_6 = 0; int_6 < 64; int_6++) {
          if (int_5 + int_0 > 0 && int_5 + int_0 < 103 && int_6 + int_1 > 0
              && int_6 + int_1 < 103) {
            collisiondatas_0[int_4].flags[int_5 + int_0][int_6 + int_1] &= 0xFEFFFFFF;
          }
        }
      }
    }

    final Buffer buffer_0 = new Buffer(bytes_0);

    for (int_5 = 0; int_5 < 4; int_5++) {
      for (int_6 = 0; int_6 < 64; int_6++) {
        for (int int_7 = 0; int_7 < 64; int_7++) {
          Class7.loadTerrain(buffer_0, int_5, int_6 + int_0, int_7 + int_1, int_2, int_3, 0);
        }
      }
    }

  }

  static String method265(final InterfaceComponent widget_0, final int int_0) {
    final int int_1 = Client.getWidgetConfig(widget_0);
    final boolean bool_0 = (int_1 >> int_0 + 1 & 0x1) != 0;
    return !bool_0
        && widget_0.anObjectArray8 == null
        ? null
        : widget_0.actions != null && widget_0.actions.length > int_0
            && widget_0.actions[int_0] != null && widget_0.actions[int_0].trim().length() != 0
            ? widget_0.actions[int_0]
            : null;
  }

  static void method266(int int_0, int int_1, final int int_2) {
    if (int_0 >= 128 && int_1 >= 128 && int_0 <= 13056 && int_1 <= 13056) {
      int int_3 = Client.getTileHeight(int_0, int_1, Class12.plane) - int_2;
      int_0 -= Isaac.cameraX;
      int_3 -= WorldMapData.cameraZ;
      int_1 -= MapIcon.cameraY;
      final int int_4 = Rasterizer3d.SINE[Keyboard.cameraPitch];
      final int int_5 = Rasterizer3d.COSINE[Keyboard.cameraPitch];
      final int int_6 = Rasterizer3d.SINE[Boundry.cameraYaw];
      final int int_7 = Rasterizer3d.COSINE[Boundry.cameraYaw];
      int int_8 = int_6 * int_1 + int_0 * int_7 >> 16;
      int_1 = int_7 * int_1 - int_0 * int_6 >> 16;
      int_0 = int_8;
      int_8 = int_5 * int_3 - int_4 * int_1 >> 16;
      int_1 = int_4 * int_3 + int_5 * int_1 >> 16;
      if (int_1 >= 50) {
        Client.screenY = int_0 * Client.scale / int_1 + Client.viewportHeight / 2;
        Client.screenX = Client.viewportWidth / 2 + int_8 * Client.scale / int_1;
      } else {
        Client.screenY = -1;
        Client.screenX = -1;
      }
    } else {
      Client.screenY = -1;
      Client.screenX = -1;
    }
  }

}
