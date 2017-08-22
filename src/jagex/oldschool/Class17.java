package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.awt.Parameter;
import jagex.oldschool.graphics.DirectSprite;
import javax.imageio.ImageIO;

public class Class17 {

  static {
    ImageIO.setUseCache(false);
  }

  static boolean method201(final int int_0, final int int_1) {
    return int_0 != 4 || int_1 < 8;
  }

  public static DirectSprite[] method202(final AbstractPackage indexdatabase_0, final String string_0,
      final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    return Parameter.method75(indexdatabase_0, int_0, int_1);
  }

}
