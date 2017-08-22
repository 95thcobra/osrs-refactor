package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.FontType;
import java.util.HashMap;

public class Class93 {

  AbstractPackage anIndexDataBase8;
  HashMap aHashMap8;
  AbstractPackage anIndexDataBase9;

  public Class93(final AbstractPackage indexdatabase_0, final AbstractPackage indexdatabase_1) {
    anIndexDataBase8 = indexdatabase_0;
    anIndexDataBase9 = indexdatabase_1;
    aHashMap8 = new HashMap();
  }

  public HashMap method513(final FontType[] class105s_0) {
    final HashMap hashmap_0 = new HashMap();
    final FontType[] class105s_1 = class105s_0;

    for (int int_0 = 0; int_0 < class105s_1.length; int_0++) {
      final FontType class105_0 = class105s_1[int_0];
      if (aHashMap8.containsKey(class105_0)) {
        hashmap_0.put(class105_0, aHashMap8.get(class105_0));
      } else {
        final BitmapFont font_0 = Class4
            .method124(anIndexDataBase8, anIndexDataBase9, class105_0.aString14, "");
        if (font_0 != null) {
          aHashMap8.put(class105_0, font_0);
          hashmap_0.put(class105_0, font_0);
        }
      }
    }

    return hashmap_0;
  }

}
