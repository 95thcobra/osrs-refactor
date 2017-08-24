package jagex.oldschool;

public class FormatConfig {

  public static final FormatConfig aClass108_1;
  public static final FormatConfig aClass108_9;
  static final FormatConfig aClass108_2;
  static final FormatConfig aClass108_3;
  static final FormatConfig aClass108_4;
  static final FormatConfig aClass108_5;
  static final FormatConfig aClass108_6;
  static final FormatConfig aClass108_7;
  static final FormatConfig aClass108_8;

  static {
    aClass108_1 = new FormatConfig(6, 0, "", "");
    aClass108_2 = new FormatConfig(8, 1, "", "");
    aClass108_3 = new FormatConfig(7, 2, "", "");
    aClass108_4 = new FormatConfig(3, 3, "", "");
    aClass108_5 = new FormatConfig(2, 4, "", "");
    aClass108_6 = new FormatConfig(4, 5, "", "");
    aClass108_7 = new FormatConfig(5, 6, "", "");
    aClass108_8 = new FormatConfig(1, 7, "", "");
    aClass108_9 = new FormatConfig(0, -1, "", "", true,
        new FormatConfig[] {aClass108_1, aClass108_2, aClass108_3, aClass108_5, aClass108_4});
  }

  public final int anInt206;
  final String identifier;

  FormatConfig(final int int_0, final int int_1, final String string_0, final String string_1) {
    anInt206 = int_0;
    identifier = string_1;
  }

  FormatConfig(final int int_0, final int int_1, final String string_0, final String string_1,
      final boolean bool_0,
      final FormatConfig[] class108s_0) {
    anInt206 = int_0;
    identifier = string_1;
  }

  @Override
  public String toString() {
    return identifier;
  }

}
