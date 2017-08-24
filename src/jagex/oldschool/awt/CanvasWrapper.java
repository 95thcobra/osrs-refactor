package jagex.oldschool.awt;

import jagex.oldschool.CacheableNode_Sub4;
import jagex.oldschool.Class23;
import jagex.oldschool.Class26;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.Class36;
import jagex.oldschool.AudioSystem;
import jagex.oldschool.Class8;
import jagex.oldschool.Client;
import jagex.oldschool.Enum3;
import jagex.oldschool.Node_Sub5;
import jagex.oldschool.NestedException;
import jagex.oldschool.asset.Package;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.script.Script;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.BzipDecompressor.State;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class CanvasWrapper extends Canvas {

  public static DirectSprite compass;
  public static DirectSprite[] mapfunctions;
  Component component;

  public CanvasWrapper(final Component component_0) {
    component = component_0;
  }

  public static void method715() {
    if (Mouse.mouse != null) {
      synchronized (Mouse.mouse) {
        Mouse.mouse = null;
      }
    }

  }

  public static int method716(int int_0, final Script script_0, final boolean bool_0) {
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      widget_0 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    String string_0 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
    int[] ints_0 = null;
    if (string_0.length() > 0 && string_0.charAt(string_0.length() - 1) == 89) {
      int int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      if (int_1 > 0) {
        for (ints_0 = new int[int_1]; int_1-- > 0;
            ints_0[int_1] = ScriptExecutor.intStack[--ScriptExecutor.intStackSize]) {
        }
      }

      string_0 = string_0.substring(0, string_0.length() - 1);
    }

    Object[] objects_0 = new Object[string_0.length() + 1];

    int int_2;
    for (int_2 = objects_0.length - 1; int_2 >= 1; --int_2) {
      if (string_0.charAt(int_2 - 1) == 115) {
        objects_0[int_2] = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      } else {
        objects_0[int_2] = new Integer(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      }
    }

    int_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
    if (int_2 != -1) {
      objects_0[0] = new Integer(int_2);
    } else {
      objects_0 = null;
    }

    if (int_0 == 1400) {
      widget_0.anObjectArray9 = objects_0;
    } else if (int_0 == 1401) {
      widget_0.anObjectArray10 = objects_0;
    } else if (int_0 == 1402) {
      widget_0.anObjectArray12 = objects_0;
    } else if (int_0 == 1403) {
      widget_0.mouseEnterListener = objects_0;
    } else if (int_0 == 1404) {
      widget_0.mouseExitListener = objects_0;
    } else if (int_0 == 1405) {
      widget_0.anObjectArray3 = objects_0;
    } else if (int_0 == 1406) {
      widget_0.anObjectArray6 = objects_0;
    } else if (int_0 == 1407) {
      widget_0.configListenerArgs = objects_0;
      widget_0.configTriggers = ints_0;
    } else if (int_0 == 1408) {
      widget_0.renderListener = objects_0;
    } else if (int_0 == 1409) {
      widget_0.anObjectArray8 = objects_0;
    } else if (int_0 == 1410) {
      widget_0.anObjectArray4 = objects_0;
    } else if (int_0 == 1411) {
      widget_0.anObjectArray11 = objects_0;
    } else if (int_0 == 1412) {
      widget_0.mouseHoverListener = objects_0;
    } else if (int_0 == 1414) {
      widget_0.tableListenerArgs = objects_0;
      widget_0.tableModTriggers = ints_0;
    } else if (int_0 == 1415) {
      widget_0.skillListenerArgs = objects_0;
      widget_0.skillTriggers = ints_0;
    } else if (int_0 == 1416) {
      widget_0.anObjectArray7 = objects_0;
    } else if (int_0 == 1417) {
      widget_0.scrollListener = objects_0;
    } else if (int_0 == 1418) {
      widget_0.anObjectArray13 = objects_0;
    } else if (int_0 == 1419) {
      widget_0.anObjectArray14 = objects_0;
    } else if (int_0 == 1420) {
      widget_0.anObjectArray15 = objects_0;
    } else if (int_0 == 1421) {
      widget_0.anObjectArray16 = objects_0;
    } else if (int_0 == 1422) {
      widget_0.anObjectArray17 = objects_0;
    } else if (int_0 == 1423) {
      widget_0.anObjectArray18 = objects_0;
    } else if (int_0 == 1424) {
      widget_0.anObjectArray19 = objects_0;
    } else if (int_0 == 1425) {
      widget_0.anObjectArray20 = objects_0;
    } else if (int_0 == 1426) {
      widget_0.anObjectArray21 = objects_0;
    } else {
      if (int_0 != 1427) {
        return 2;
      }

      widget_0.anObjectArray2 = objects_0;
    }

    widget_0.aBool28 = true;
    return 1;
  }

  public static int method717(final int int_0, final Script script_0, final boolean bool_0) {
    if (int_0 == 3200) {
      ScriptExecutor.intStackSize -= 3;
      IntegerVariable.method245(ScriptExecutor.intStack[ScriptExecutor.intStackSize],
          ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1],
          ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2]);
      return 1;
    }
    int int_1;
    if (int_0 != 3201) {
      if (int_0 == 3202) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        if (Client.anInt656 != 0 && int_1 != -1) {
          Class23.method212(State.indexTrack2, int_1, 0, Client.anInt656, false);
          Client.aBool81 = true;
        }

        return 1;
      }
      return 2;
    }
    int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
    if (int_1 == -1 && !Client.aBool81) {
      AudioSystem.anAClass4_Sub3_1.method790();
      AudioSystem.anInt168 = 1;
      AudioSystem.anIndexDataBase4 = null;
    } else if (int_1 != -1 && int_1 != Client.anInt613 && Client.anInt656 != 0
        && !Client.aBool81) {
      final Package indexdata_0 = CacheableNode_Sub4.indexTrack1;
      final int int_2 = Client.anInt656;
      AudioSystem.anInt168 = 1;
      AudioSystem.anIndexDataBase4 = indexdata_0;
      Enum3.anInt339 = int_1;
      NestedException.anInt527 = 0;
      AudioSystem.anInt170 = int_2;
      Class36.aBool8 = false;
      AudioSystem.anInt169 = 2;
    }

    Client.anInt613 = int_1;
    return 1;
  }

  @Override
  public final void update(final Graphics graphics_0) {
    component.update(graphics_0);
  }

  @Override
  public final void paint(final Graphics graphics_0) {
    component.paint(graphics_0);
  }

}
