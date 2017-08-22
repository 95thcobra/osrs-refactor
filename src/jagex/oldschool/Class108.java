package jagex.oldschool;

public class Class108 {

  public static final Class108 aClass108_1;
  public static final Class108 aClass108_9;
  static final Class108 aClass108_2;
  static final Class108 aClass108_3;
  static final Class108 aClass108_4;
  static final Class108 aClass108_5;
  static final Class108 aClass108_6;
  static final Class108 aClass108_7;
  static final Class108 aClass108_8;

  static {
    aClass108_1 = new Class108(6, 0, "", "");
    aClass108_2 = new Class108(8, 1, "", "");
    aClass108_3 = new Class108(7, 2, "", "");
    aClass108_4 = new Class108(3, 3, "", "");
    aClass108_5 = new Class108(2, 4, "", "");
    aClass108_6 = new Class108(4, 5, "", "");
    aClass108_7 = new Class108(5, 6, "", "");
    aClass108_8 = new Class108(1, 7, "", "");
    aClass108_9 = new Class108(0, -1, "", "", true,
        new Class108[] {aClass108_1, aClass108_2, aClass108_3, aClass108_5, aClass108_4});
  }

  public final int anInt206;
  final String identifier;

  Class108(final int int_0, final int int_1, final String string_0, final String string_1) {
    anInt206 = int_0;
    identifier = string_1;
  }

  Class108(final int int_0, final int int_1, final String string_0, final String string_1,
      final boolean bool_0,
      final Class108[] class108s_0) {
    anInt206 = int_0;
    identifier = string_1;
  }

  @Override
  public String toString() {
    return identifier;
  }

}
