package jagex.oldschool;

import jagex.oldschool.collections.Node;

public abstract class AClass4 extends Node {

  public boolean aBool43;
  public AClass5 anAClass5_1;
  public AClass4 anAClass4_2;
  public int anInt321;

  protected AClass4() {
    aBool43 = true;
  }

  public abstract void method632(int[] var1, int var2, int var3);

  public abstract void method633(int var1);

  final void method634(final int[] ints_0, final int int_0, final int int_1) {
    if (aBool43) {
      method632(ints_0, int_0, int_1);
    } else {
      method633(int_1);
    }
  }

  public abstract AClass4 method635();

  public abstract AClass4 method636();

  public int method637() {
    return 255;
  }

  public abstract int method638();

}
