package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;

public enum Enum3 implements MappedEnum {

  anEnum3_2(1, 0), anEnum3_3(0, 1), anEnum3_4(2, 2), anEnum3_5(3, 3);

  public static int anInt339;
  public final int anInt338;
  final int anInt337;

  Enum3(final int int_1, final int int_2) {
    anInt338 = int_1;
    anInt337 = int_2;
  }

  public static void method654(final AbstractPackage indexdatabase_0) {
    Enum.anIndexDataBase22 = indexdatabase_0;
  }

  @Override
  public int mappedOrdinal() {
    return anInt337;
  }

}
