package jagex.oldschool;

public class AClass5_Sub1 extends AClass5 {

  public byte[] aByteArray18;
  public int anInt405;
  public boolean aBool50;
  public int anInt406;
  int anInt407;

  public AClass5_Sub1(final int int_0, final byte[] bytes_0, final int int_1, final int int_2) {
    anInt405 = int_0;
    aByteArray18 = bytes_0;
    anInt406 = int_1;
    anInt407 = int_2;
  }

  AClass5_Sub1(final int int_0, final byte[] bytes_0, final int int_1, final int int_2,
      final boolean bool_0) {
    anInt405 = int_0;
    aByteArray18 = bytes_0;
    anInt406 = int_1;
    anInt407 = int_2;
    aBool50 = bool_0;
  }

  public AClass5_Sub1 method727(final Class54 class54_0) {
    aByteArray18 = class54_0.method346(aByteArray18);
    anInt405 = class54_0.method347(anInt405);
    if (anInt406 == anInt407) {
      anInt406 = anInt407 = class54_0.method348(anInt406);
    } else {
      anInt406 = class54_0.method348(anInt406);
      anInt407 = class54_0.method348(anInt407);
      if (anInt406 == anInt407) {
        --anInt406;
      }
    }

    return this;
  }

}
