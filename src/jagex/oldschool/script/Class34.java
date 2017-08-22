package jagex.oldschool.script;

import jagex.oldschool.AClass3_Sub2;
import jagex.oldschool.JavaxSourceDataLineProvider;
import jagex.oldschool.Class26;
import jagex.oldschool.Class28;
import jagex.oldschool.Class38;
import jagex.oldschool.Class8;
import jagex.oldschool.Client;
import jagex.oldschool.Enum9;
import jagex.oldschool.Node_Sub5;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.PlayerIdentity;
import jagex.oldschool.config.InventoryConfig;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;

public class Class34 {

  static final Class34 ONE;
  static final Class34 TWO;
  static final Class34 ZERO;
  static final Class34 FIVE;
  static final Class34 THREE;
  static final Class34 SIX;
  static final Class34 FOUR;
  public static int canvasHeight;

  static {
    ONE = new Class34(1);
    TWO = new Class34(2);
    ZERO = new Class34(0);
    FIVE = new Class34(5);
    THREE = new Class34(3);
    SIX = new Class34(6);
    FOUR = new Class34(4);
  }

  final int anInt86;

  Class34(final int int_0) {
    anInt86 = int_0;
  }

  public static void method249(final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4) {
    Class38.aCombatInfoList1.addLast(new AClass3_Sub2(int_0, int_1, int_2, int_3, int_4));
  }

  public static int method250(int int_0, final Script script_0, final boolean bool_0) {
    int int_1 = -1;
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      widget_0 = ScriptExecutor.method240(int_1);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    if (int_0 == 1100) {
      ScriptExecutor.intStackSize -= 2;
      widget_0.scrollX = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      if (widget_0.scrollX > widget_0.scrollWidth - widget_0.width) {
        widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
      }

      if (widget_0.scrollX < 0) {
        widget_0.scrollX = 0;
      }

      widget_0.scrollY = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
        widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
      }

      if (widget_0.scrollY < 0) {
        widget_0.scrollY = 0;
      }

      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1101) {
      widget_0.textColor = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1102) {
      widget_0.aBool29 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1103) {
      widget_0.opacity = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1104) {
      widget_0.anInt280 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1105) {
      widget_0.spriteId = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1106) {
      widget_0.textureId = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1107) {
      widget_0.aBool32 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1108) {
      widget_0.modelType = 1;
      widget_0.modelId = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1109) {
      ScriptExecutor.intStackSize -= 6;
      widget_0.anInt284 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      widget_0.anInt285 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      widget_0.rotationX = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
      widget_0.rotationZ = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
      widget_0.rotationY = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 4];
      widget_0.modelZoom = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 5];
      Class28.method236(widget_0);
      return 1;
    }
    int int_3;
    if (int_0 == 1110) {
      int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      if (int_3 != widget_0.anInt266) {
        widget_0.anInt266 = int_3;
        widget_0.anInt272 = 0;
        widget_0.anInt271 = 0;
        Class28.method236(widget_0);
      }

      return 1;
    }
    if (int_0 == 1111) {
      widget_0.aBool34 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1112) {
      final String string_0 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      if (!string_0.equals(widget_0.text)) {
        widget_0.text = string_0;
        Class28.method236(widget_0);
      }

      return 1;
    }
    if (int_0 == 1113) {
      widget_0.fontId = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1114) {
      ScriptExecutor.intStackSize -= 3;
      widget_0.anInt281 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      widget_0.anInt282 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      widget_0.anInt283 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1115) {
      widget_0.textShadowed = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1116) {
      widget_0.borderThickness = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1117) {
      widget_0.sprite2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1118) {
      widget_0.flippedVertically = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1119) {
      widget_0.flippedHorizontally = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1120) {
      ScriptExecutor.intStackSize -= 2;
      widget_0.scrollWidth = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      widget_0.scrollHeight = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      Class28.method236(widget_0);
      if (int_1 != -1 && widget_0.type == 0) {
        JavaxSourceDataLineProvider.method190(Time.widgets[int_1 >> 16], widget_0, false);
      }

      return 1;
    }
    if (int_0 == 1121) {
      int_3 = widget_0.id;
      final int int_2 = widget_0.index;
      Client.outbound.putEncipheredByte(72);
      Client.outbound.putShort(int_2);
      Client.outbound.putIntMe(int_3);
      Client.aWidget13 = widget_0;
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1122) {
      widget_0.anInt258 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1123) {
      widget_0.anInt274 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1124) {
      widget_0.anInt279 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      Class28.method236(widget_0);
      return 1;
    }
    if (int_0 == 1125) {
      int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      final Enum9 enum9_0 = (Enum9) PlayerIdentity.forOrdinal(PendingSpawn.method653(), int_3);
      if (enum9_0 != null) {
        widget_0.anEnum9_1 = enum9_0;
        Class28.method236(widget_0);
      }

      return 1;
    }
    if (int_0 == 1126) {
      final boolean bool_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      widget_0.aBool30 = bool_1;
      return 1;
    }
    return 2;
  }

  public static InventoryConfig method251(final int int_0) {
    InventoryConfig invtype_0 = (InventoryConfig) InventoryConfig.inventoryCache.get(int_0);
    if (invtype_0 != null) {
      return invtype_0;
    }
    final byte[] bytes_0 = InventoryConfig.anIndexDataBase17.get(5, int_0);
    invtype_0 = new InventoryConfig();
    if (bytes_0 != null) {
      invtype_0.decode(new Buffer(bytes_0));
    }

    InventoryConfig.inventoryCache.put(invtype_0, int_0);
    return invtype_0;
  }

}
