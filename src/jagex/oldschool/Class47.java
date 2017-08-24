package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import java.util.Comparator;

public final class Class47 implements Comparator {

  public static AbstractPackage skel_ref;
  public static AbstractPackage item_ref;
  static RemoteEnvironment remoteEnv;

  public static void pollMouse() {
    synchronized (Mouse.mouse) {
      Mouse.anInt252 = Mouse.anInt246 * -1995837037;
      Mouse.anInt249 = Mouse.mouseX;
      Mouse.anInt251 = Mouse.mouseY;
      Mouse.anInt248 = Mouse.anInt255;
      Mouse.anInt253 = Mouse.anInt247;
      Mouse.anInt254 = Mouse.anInt250;
      Mouse.aLong17 = Mouse.aLong16;
      Mouse.anInt255 = 0;
    }
  }

  public static CacheableNode_Sub6 method295(final int int_0) {
    CacheableNode_Sub6 cacheablenode_sub6_0 = (CacheableNode_Sub6) CacheableNode_Sub6.aNodeCache17
        .get(int_0);
    if (cacheablenode_sub6_0 != null) {
      return cacheablenode_sub6_0;
    }
    final byte[] bytes_0 = CollisionData.anIndexDataBase12.get(19, int_0);
    cacheablenode_sub6_0 = new CacheableNode_Sub6();
    if (bytes_0 != null) {
      cacheablenode_sub6_0.method860(new Buffer(bytes_0));
    }

    CacheableNode_Sub6.aNodeCache17.put(cacheablenode_sub6_0, int_0);
    return cacheablenode_sub6_0;
  }

  public static int method296(final int int_0, final Script script_0, final boolean bool_0) {
    final InterfaceComponent widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    if (int_0 == 1600) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollX;
      return 1;
    }
    if (int_0 == 1601) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollY;
      return 1;
    }
    if (int_0 == 1602) {
      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_0.text;
      return 1;
    }
    if (int_0 == 1603) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollWidth;
      return 1;
    }
    if (int_0 == 1604) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollHeight;
      return 1;
    }
    if (int_0 == 1605) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.modelZoom;
      return 1;
    }
    if (int_0 == 1606) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationX;
      return 1;
    }
    if (int_0 == 1607) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationY;
      return 1;
    }
    if (int_0 == 1608) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationZ;
      return 1;
    }
    if (int_0 == 1609) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.opacity;
      return 1;
    }
    if (int_0 == 1610) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anInt279;
      return 1;
    }
    if (int_0 == 1611) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.textColor;
      return 1;
    }
    if (int_0 == 1612) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anInt274;
      return 1;
    }
    if (int_0 == 1613) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anEnum9_1.mappedOrdinal();
      return 1;
    }
    return 2;
  }

  int method293(final Class44 class44_0, final Class44 class44_1) {
    return class44_0.method282().compareTo(class44_1.method282());
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method293((Class44) object_0, (Class44) object_1);
  }

}
