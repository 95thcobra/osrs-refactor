package jagex.oldschool;

import jagex.oldschool.collections.Subnode;

public class CacheableNode_Sub1 extends Subnode {

  public static int[] offsetsY;
  public final int[] anIntArray102;
  public final int anInt460;
  public final int anInt461;
  public final int[] anIntArray103;

  public CacheableNode_Sub1(final int int_0, final int int_1, final int[] ints_0,
      final int[] ints_1,
      final int int_2) {
    anInt460 = int_0;
    anInt461 = int_1;
    anIntArray103 = ints_0;
    anIntArray102 = ints_1;
  }

  public boolean method827(final int int_0, final int int_1) {
    if (int_1 >= 0 && int_1 < anIntArray102.length) {
      final int int_2 = anIntArray102[int_1];
      if (int_0 >= int_2 && int_0 <= int_2 + anIntArray103[int_1]) {
        return true;
      }
    }

    return false;
  }

}
