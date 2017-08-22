package jagex.oldschool.scene;

import jagex.oldschool.Class65;
import jagex.oldschool.Client;
import jagex.oldschool.Model;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.ui.InterfaceComponent;
import java.io.File;

public abstract class Renderable extends Subnode {

  public int minimumY;

  protected Renderable() {
    minimumY = 1000;
  }

  public static boolean method711(final InterfaceComponent widget_0) {
    if (Client.aBool80) {
      if (Client.getWidgetConfig(widget_0) != 0) {
        return false;
      }

      if (widget_0.type == 0) {
        return false;
      }
    }

    return widget_0.isHidden;
  }

  public static void method712(final File file_0) {
    Class65.aFile3 = file_0;
    if (!Class65.aFile3.exists()) {
      throw new RuntimeException("");
    }
    Class65.aBool20 = true;
  }

  public static String method713(final InterfaceComponent widget_0) {
    final int int_0 = Client.getWidgetConfig(widget_0);
    final int int_1 = int_0 >> 11 & 0x3F;
    return int_1 == 0 ? null
        : widget_0.selectedAction != null && widget_0.selectedAction.trim().length() != 0
            ? widget_0.selectedAction
            : null;
  }

  protected Model getModel() {
    return null;
  }

  public void draw(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5,
      final int int_6, final int int_7, final int int_8) {
    final Model model_0 = getModel();
    if (model_0 != null) {
      minimumY = model_0.minimumY;
      model_0.draw(int_0, int_1, int_2, int_3, int_4, int_5, int_6, int_7, int_8);
    }

  }

}
