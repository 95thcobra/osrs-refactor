package jagex.oldschool;

import jagex.oldschool.graphics.DirectSprite;

public enum Enum2 implements MappedEnum {

  anEnum2_1(0), anEnum2_2(1), anEnum2_3(2), anEnum2_4(3);

  public static DirectSprite aSpritePixels3;
  static int anInt307;
  final int anInt308;

  Enum2(final int int_1) {
    anInt308 = int_1;
  }

  static int method626(final int int_0, int int_1) {
    if (int_0 == -1) {
      return 12345678;
    }
    int_1 = (int_0 & 0x7F) * int_1 / 128;
    if (int_1 < 2) {
      int_1 = 2;
    } else if (int_1 > 126) {
      int_1 = 126;
    }

    return (int_0 & 0xFF80) + int_1;
  }

  @Override
  public int mappedOrdinal() {
    return anInt308;
  }

}
