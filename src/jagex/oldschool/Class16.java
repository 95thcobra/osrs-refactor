package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.awt.CanvasWrapper;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;

public class Class16 {

  static IndexedSprite[] anIndexedSpriteArray3;
  static int anInt63;
  public final int anInt64;
  public final Position aCoordinates4;
  public final Position aCoordinates5;
  final Class4 aClass4_1;
  final int anInt66;
  final int anInt68;
  int anInt65;
  int anInt67;

  Class16(final int int_0, final Position coordinates_0, final Position coordinates_1,
      final Class4 class4_0) {
    anInt64 = int_0;
    aCoordinates4 = coordinates_0;
    aCoordinates5 = coordinates_1;
    aClass4_1 = class4_0;
    final MapIconConfig area_0 = MapIconConfig.icons[anInt64];
    final DirectSprite spritepixels_0 = area_0.getSprite(false);
    if (spritepixels_0 != null) {
      anInt66 = spritepixels_0.width;
      anInt68 = spritepixels_0.height;
    } else {
      anInt66 = 0;
      anInt68 = 0;
    }
  }

  static void method196(final InterfaceComponent widget_0, final int int_0, final int int_1,
      final int int_2) {
    final CacheableNode_Sub1 cacheablenode_sub1_0 = widget_0.method579(false);
    if (cacheablenode_sub1_0 != null) {
      if (Client.anInt644 < 3) {
        CanvasWrapper.compass
            .method950(int_0, int_1, cacheablenode_sub1_0.anInt460, cacheablenode_sub1_0.anInt461,
                25, 25, Client.mapAngle, 256, cacheablenode_sub1_0.anIntArray102,
                cacheablenode_sub1_0.anIntArray103);
      } else {
        Rasterizer2d.method887(int_0, int_1, 0, cacheablenode_sub1_0.anIntArray102,
            cacheablenode_sub1_0.anIntArray103);
      }
    }
  }

  static void method197() {
    for (PendingSpawn pendingspawn_0 = (PendingSpawn) Client.pendingSpawns
        .getFirst(); pendingspawn_0 != null;
        pendingspawn_0 = (PendingSpawn) Client.pendingSpawns.getNext()) {
      if (pendingspawn_0.hitpoints == -1) {
        pendingspawn_0.delay = 0;
        Class8.method154(pendingspawn_0);
      } else {
        pendingspawn_0.unlink();
      }
    }

  }

  public static int method198(final int int_0, final Script script_0, final boolean bool_0) {
    final InterfaceComponent widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    if (int_0 == 1500) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.relativeX;
      return 1;
    }
    if (int_0 == 1501) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.relativeY;
      return 1;
    }
    if (int_0 == 1502) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.width;
      return 1;
    }
    if (int_0 == 1503) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.height;
      return 1;
    }
    if (int_0 == 1504) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.isHidden ? 1 : 0;
      return 1;
    }
    if (int_0 == 1505) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.parentId;
      return 1;
    }
    return 2;
  }

  public static void method199(String string_0, final boolean bool_0) {
    string_0 = string_0.toLowerCase();
    short[] shorts_0 = new short[16];
    int int_0 = 0;

    for (int int_1 = 0; int_1 < ItemConfig.anInt491; int_1++) {
      final ItemConfig itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
      if ((!bool_0 || itemcomposition_0.aBool62) && itemcomposition_0.notedTemplate == -1
          && itemcomposition_0.name.toLowerCase().indexOf(string_0) != -1) {
        if (int_0 >= 250) {
          AClass1_Sub2.anInt306 = -1;
          Variables.aShortArray3 = null;
          return;
        }

        if (int_0 >= shorts_0.length) {
          final short[] shorts_1 = new short[shorts_0.length * 2];

          for (int int_3 = 0; int_3 < int_0; int_3++) {
            shorts_1[int_3] = shorts_0[int_3];
          }

          shorts_0 = shorts_1;
        }

        shorts_0[int_0++] = (short) int_1;
      }
    }

    Variables.aShortArray3 = shorts_0;
    Class64.anInt165 = 0;
    AClass1_Sub2.anInt306 = int_0;
    final String[] strings_0 = new String[AClass1_Sub2.anInt306];

    for (int int_2 = 0; int_2 < AClass1_Sub2.anInt306; int_2++) {
      strings_0[int_2] = AudioWorker.getItemDefinition(shorts_0[int_2]).name;
    }

    LoginScreen.method301(strings_0, Variables.aShortArray3);
  }

  static boolean method200(final InterfaceComponent widget_0) {
    final int int_0 = widget_0.contentType;
    if (int_0 == 205) {
      Client.anInt595 = 250;
      return true;
    }
    int int_1;
    int int_2;
    if (int_0 >= 300 && int_0 <= 313) {
      int_1 = (int_0 - 300) / 2;
      int_2 = int_0 & 0x1;
      Client.aPlayerComposition1.method503(int_1, int_2 == 1);
    }

    if (int_0 >= 314 && int_0 <= 323) {
      int_1 = (int_0 - 314) / 2;
      int_2 = int_0 & 0x1;
      Client.aPlayerComposition1.method504(int_1, int_2 == 1);
    }

    if (int_0 == 324) {
      Client.aPlayerComposition1.method505(false);
    }

    if (int_0 == 325) {
      Client.aPlayerComposition1.method505(true);
    }

    if (int_0 == 326) {
      Client.outbound.putEncipheredByte(23);
      Client.aPlayerComposition1.method506(Client.outbound);
      return true;
    }
    return false;
  }

  boolean method193(final int int_0, final int int_1) {
    final MapIconConfig area_0 = MapIconConfig.icons[anInt64];
    switch (area_0.anEnum7_4.anInt374) {
      case 0:
        if (int_0 >= anInt65 && int_0 < anInt66 + anInt65) {
          break;
        }

        return false;
      case 1:
        if (int_0 > anInt65 - anInt66 && int_0 <= anInt65) {
          break;
        }

        return false;
      case 2:
        if (int_0 < anInt65 - anInt66 / 2 || int_0 > anInt66 / 2 + anInt65) {
          return false;
        }
    }

    switch (area_0.anEnum8_4.anInt376) {
      case 0:
        if (int_1 >= anInt67 - anInt68 / 2 && int_1 <= anInt68 / 2 + anInt67) {
          break;
        }

        return false;
      case 1:
        if (int_1 <= anInt67 - anInt68 || int_1 > anInt67) {
          return false;
        }
        break;
      case 2:
        if (int_1 < anInt67 || int_1 >= anInt68 + anInt67) {
          return false;
        }
    }

    return true;
  }

  boolean method194(final int int_0, final int int_1) {
    return aClass4_1 == null ? false
        : int_0 >= anInt65 - aClass4_1.anInt33 / 2 && int_0 <= aClass4_1.anInt33 / 2
            + anInt65
            ? int_1 >= anInt67 && int_1 <= aClass4_1.anInt34 + anInt67
            : false;
  }

  boolean method195(final int int_0, final int int_1) {
    return method193(int_0, int_1) ? true : method194(int_0, int_1);
  }

}
