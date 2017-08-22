package jagex.oldschool;

public enum Enum9 implements MappedEnum {

  anEnum9_2(0, 0), anEnum9_3(1, 1), anEnum9_4(2, 2), anEnum9_5(3, 3), anEnum9_6(4, 4);

  public final int anInt378;
  final int anInt379;

  Enum9(final int int_1, final int int_2) {
    anInt378 = int_1;
    anInt379 = int_2;
  }

  @Override
  public int mappedOrdinal() {
    return anInt379;
  }

}
