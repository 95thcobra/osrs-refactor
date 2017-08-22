package jagex.oldschool.util;

import jagex.oldschool.CacheableNode_Sub2;
import jagex.oldschool.Client;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.script.Script;
import jagex.oldschool.ui.InterfaceComponent;

public class Time {

  public static InterfaceComponent[][] widgets;
  static long last;
  static long delta;
  public static Package indexSprites;

  public static void method395(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final AbstractPackage indexdatabase_2) {
    CacheableNode_Sub2.anIndexDataBase23 = indexdatabase_0;
    CacheableNode_Sub2.anIndexDataBase24 = indexdatabase_1;
    CacheableNode_Sub2.anIndexDataBase25 = indexdatabase_2;
  }

  public static int method396(final int int_0, final Script script_0, final boolean bool_0) {
    if (int_0 == 5630) {
      Client.anInt595 = 250;
      return 1;
    }
    return 2;
  }

  public static synchronized long currentTimeMillis() {
    final long long_0 = System.currentTimeMillis();
    if (long_0 < last) {
      delta += last - long_0;
    }

    last = long_0;
    return delta + long_0;
  }
}
