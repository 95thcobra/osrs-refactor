package jagex.oldschool;

public enum Enum8 implements MappedEnum {

  anEnum8_1(1, 0), anEnum8_2(0, 1), anEnum8_3(2, 2);

  static int[][][] anIntArrayArrayArray1;
  public final int anInt376;
  final int anInt377;

  Enum8(final int int_1, final int int_2) {
    anInt376 = int_1;
    anInt377 = int_2;
  }

  @Override
  public int mappedOrdinal() {
    return anInt377;
  }

}
