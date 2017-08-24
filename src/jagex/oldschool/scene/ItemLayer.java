package jagex.oldschool.scene;

import jagex.oldschool.Class56;
import jagex.oldschool.Class99;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;

public final class ItemLayer {

  Renderable bottom;
  int x;
  int y;
  int hash;
  int flags;
  Renderable middle;
  Renderable top;
  int height;

  public static boolean method528(final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    int int_7 = Class56.anInt141 + int_6;
    if (int_7 < int_0 && int_7 < int_1 && int_7 < int_2) {
      return false;
    }
    int_7 = Class56.anInt141 - int_6;
    if (int_7 > int_0 && int_7 > int_1 && int_7 > int_2) {
      return false;
    }
    int_7 = Class56.anInt140 + int_6;
    if (int_7 < int_3 && int_7 < int_4 && int_7 < int_5) {
      return false;
    }
    int_7 = Class56.anInt140 - int_6;
    return int_7 <= int_3 || int_7 <= int_4 || int_7 <= int_5;
  }

  public static void method529(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final AbstractPackage indexdatabase_2, final AbstractPackage indexdatabase_3) {
    AudioWorker.widgetIndex = indexdatabase_0;
    Class99.anIndexDataBase10 = indexdatabase_1;
    Npc.anIndexDataBase30 = indexdatabase_2;
    InterfaceComponent.anIndexDataBase13 = indexdatabase_3;
    Time.widgets = new InterfaceComponent[AudioWorker.widgetIndex.size()][];
    PrimitiveType.validInterfaces = new boolean[AudioWorker.widgetIndex.size()];
  }

}
