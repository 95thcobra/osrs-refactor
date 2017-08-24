package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.social.Friend;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Time;

public class Class23 {

  static final Class23 aClass23_1;
  static final Class23 aClass23_2;
  static final Class23 aClass23_3;
  static final Class23 aClass23_4;
  public static AudioWorker task;
  public static int anInt74;

  static {
    aClass23_1 = new Class23();
    aClass23_2 = new Class23();
    aClass23_3 = new Class23();
    aClass23_4 = new Class23();
  }

  static int method211(final int int_0, final int int_1) {
    final Overlay overlay_0 = NpcConfig.method868(int_0);
    if (overlay_0 == null) {
      return int_1;
    }
    if (overlay_0.otherRgbColor >= 0) {
      return overlay_0.otherRgbColor | 0xFF000000;
    }
    if (overlay_0.texture >= 0) {
      final int int_2 = Friend
          .method521(Rasterizer3d.materials.getHsl(overlay_0.texture), 96);
      return Rasterizer3d.HSL_TABLE[int_2] | 0xFF000000;
    }
    if (overlay_0.color == 16711935) {
      return int_1;
    }
    final int int_3 = overlay_0.hue;
    int int_4 = overlay_0.saturation;
    final int int_5 = overlay_0.lightness;
    if (int_5 > 179) {
      int_4 /= 2;
    }

    if (int_5 > 192) {
      int_4 /= 2;
    }

    if (int_5 > 217) {
      int_4 /= 2;
    }

    if (int_5 > 243) {
      int_4 /= 2;
    }

    final int int_6 = (int_4 / 32 << 7) + int_5 / 2 + (int_3 / 4 << 10);
    final int int_7 = Friend.method521(int_6, 96);
    return Rasterizer3d.HSL_TABLE[int_7] | 0xFF000000;
  }

  public static void method212(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1, final int int_2,
      final boolean bool_0) {
    AudioSystem.anInt168 = 1;
    AudioSystem.anIndexDataBase4 = indexdatabase_0;
    Enum3.anInt339 = int_0;
    NestedException.anInt527 = int_1;
    AudioSystem.anInt170 = int_2;
    Class36.aBool8 = bool_0;
    AudioSystem.anInt169 = 10000;
  }

  public static void method213(final InterfaceComponent[] widgets_0, final int int_0) {
    for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
      final InterfaceComponent widget_0 = widgets_0[int_1];
      if (widget_0 != null) {
        if (widget_0.type == 0) {
          if (widget_0.children != null) {
            method213(widget_0.children, int_0);
          }

          final OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable.get(widget_0.id);
          if (widgetnode_0 != null) {
            Friend.method522(widgetnode_0.id, int_0);
          }
        }

        ScriptCall scriptevent_0;
        if (int_0 == 0 && widget_0.anObjectArray18 != null) {
          scriptevent_0 = new ScriptCall();
          scriptevent_0.widget = widget_0;
          scriptevent_0.anObjectArray22 = widget_0.anObjectArray18;
          Position.execute(scriptevent_0);
        }

        if (int_0 == 1 && widget_0.anObjectArray19 != null) {
          if (widget_0.index >= 0) {
            final InterfaceComponent widget_1 = ScriptExecutor.method240(widget_0.id);
            if (widget_1 == null || widget_1.children == null
                || widget_0.index >= widget_1.children.length
                || widget_0 != widget_1.children[widget_0.index]) {
              continue;
            }
          }

          scriptevent_0 = new ScriptCall();
          scriptevent_0.widget = widget_0;
          scriptevent_0.anObjectArray22 = widget_0.anObjectArray19;
          Position.execute(scriptevent_0);
        }
      }
    }

  }

  public static int method214(int int_0, final Script script_0, final boolean bool_0) {
    int int_1 = -1;
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      widget_0 = ScriptExecutor.method240(int_1);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    if (int_0 == 1000) {
      ScriptExecutor.intStackSize -= 4;
      widget_0.originalX = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      widget_0.originalY = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      widget_0.anInt261 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
      widget_0.anInt264 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
      Class28.method236(widget_0);
      Enum1.clientInstance.method1061(widget_0);
      if (int_1 != -1 && widget_0.type == 0) {
        JavaxSourceDataLineProvider.method190(Time.widgets[int_1 >> 16], widget_0, false);
      }

      return 1;
    }
    if (int_0 == 1001) {
      ScriptExecutor.intStackSize -= 4;
      widget_0.originalWidth = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      widget_0.anInt265 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      widget_0.anInt262 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
      widget_0.buttonType = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
      Class28.method236(widget_0);
      Enum1.clientInstance.method1061(widget_0);
      if (int_1 != -1 && widget_0.type == 0) {
        JavaxSourceDataLineProvider.method190(Time.widgets[int_1 >> 16], widget_0, false);
      }

      return 1;
    }
    if (int_0 == 1003) {
      final boolean bool_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      if (bool_1 != widget_0.isHidden) {
        widget_0.isHidden = bool_1;
        Class28.method236(widget_0);
      }

      return 1;
    }
    if (int_0 == 1005) {
      widget_0.aBool31 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      return 1;
    }
    if (int_0 == 1006) {
      widget_0.aBool37 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      return 1;
    }
    return 2;
  }

  static InterfaceComponent method215(final InterfaceComponent widget_0) {
    InterfaceComponent widget_1 = Preferences.method424(widget_0);
    if (widget_1 == null) {
      widget_1 = widget_0.dragParent;
    }

    return widget_1;
  }

}
