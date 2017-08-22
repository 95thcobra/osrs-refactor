package jagex.oldschool;

import jagex.oldschool.graphics.BitmapFont;

public class Class12 {

  static final Class12 aClass12_1;
  static final Class12 aClass12_2;
  public static Game game;
  public static int plane;
  static BitmapFont font_p12full;

  static {
    aClass12_1 = new Class12(0);
    aClass12_2 = new Class12(1);
  }

  final int anInt57;

  Class12(final int int_0) {
    anInt57 = int_0;
  }

  public static boolean method164(final char char_0) {
    return char_0 >= 32 && char_0 <= 126 ? true
        : char_0 >= 160 && char_0 <= 255 ? true
            : char_0 == 8364 || char_0 == 338 || char_0 == 8212 || char_0 == 339
                || char_0 == 376;
  }

  public static boolean method165(final int int_0) {
    return (int_0 >> 30 & 0x1) != 0;
  }

}
