package jagex.oldschool;

import jagex.oldschool.script.Script;
import java.util.Comparator;

public final class Class31 implements Comparator {

  static int menuHeight;
  static byte[][] aByteArrayArray2;
  static int[] landRegionFielIds;

  public static Script method244(final ScriptArguments class83_0, final int int_0, final int int_1) {
    final int int_2 = (int_0 << 8) + class83_0.anInt185;
    Script script_0 = Class85.method490(int_2, class83_0);
    if (script_0 != null) {
      return script_0;
    }
    final int int_3 = (int_1 + 40000 << 8) + class83_0.anInt185;
    script_0 = Class85.method490(int_3, class83_0);
    return script_0 != null ? script_0 : null;
  }

  int method243(final Class44 class44_0, final Class44 class44_1) {
    return
        class44_0.aGrandExchangeOffer1.totalQuantity < class44_1.aGrandExchangeOffer1.totalQuantity
            ? -1
            : class44_1.aGrandExchangeOffer1.totalQuantity
                == class44_0.aGrandExchangeOffer1.totalQuantity ? 0
                : 1;
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method243((Class44) object_0, (Class44) object_1);
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

}
