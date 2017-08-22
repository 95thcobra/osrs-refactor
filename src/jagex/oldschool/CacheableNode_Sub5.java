package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.security.Isaac;

public class CacheableNode_Sub5 extends Subnode {

  public static Cache aNodeCache16;
  public static AbstractPackage anIndexDataBase28;

  static {
    aNodeCache16 = new Cache(64);
  }

  public boolean aBool58;

  public CacheableNode_Sub5() {
    aBool58 = false;
  }

  public static void method858(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final boolean bool_0, final BitmapFont font_0) {
    Class47.item_ref = indexdatabase_0;
    LongVariable.anIndexDataBase2 = indexdatabase_1;
    ItemConfig.isMembersWorld = bool_0;
    ItemConfig.anInt491 = Class47.item_ref.fileCount(10);
    Isaac.aFont4 = font_0;
  }

  void method856(final Buffer buffer_0, final int int_0) {
    if (int_0 == 2) {
      aBool58 = true;
    }

  }

  public void method857(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method856(buffer_0, int_0);
    }
  }

}
