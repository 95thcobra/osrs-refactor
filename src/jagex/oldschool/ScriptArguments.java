package jagex.oldschool;

import jagex.oldschool.script.DerivedType;

public class ScriptArguments implements Interface4 {

  public static final ScriptArguments aClass83_1;
  public static final ScriptArguments aClass83_2;
  public static final ScriptArguments aClass83_3;
  public static final ScriptArguments aClass83_4;
  public static final ScriptArguments aClass83_5;
  public static final ScriptArguments aClass83_6;
  public static final ScriptArguments aClass83_7;
  public static final ScriptArguments aClass83_8;
  public static final ScriptArguments aClass83_9;
  static final ScriptArguments aClass83_10;

  static {
    aClass83_1 = new ScriptArguments("", 10);
    aClass83_3 = new ScriptArguments("", 11);
    aClass83_5 = new ScriptArguments("", 12);
    aClass83_6 = new ScriptArguments("", 13);
    aClass83_4 = new ScriptArguments("", 14);
    aClass83_7 = new ScriptArguments("", 15, new DerivedType[] {
        DerivedType.TYPE_I, DerivedType.TYPE_I
    }, null);
    aClass83_8 = new ScriptArguments("", 16,
        new DerivedType[] {DerivedType.TYPE_I, DerivedType.TYPE_I},
        null);
    aClass83_9 = new ScriptArguments("", 17,
        new DerivedType[] {DerivedType.TYPE_I, DerivedType.TYPE_I},
        null);
    aClass83_10 = new ScriptArguments("", 73, true, true);
    aClass83_2 = new ScriptArguments("", 76, true, false);
  }

  public final int anInt185;

  ScriptArguments(final String string_0, final int int_0) {
    this(string_0, int_0, false, null, false, null);
  }

  ScriptArguments(final String string_0, final int int_0, final boolean bool_0,
      final DerivedType[] scriptvartypes_0,
      final boolean bool_1, final DerivedType[] scriptvartypes_1) {
    anInt185 = int_0;
  }

  ScriptArguments(final String string_0, final int int_0, final DerivedType[] scriptvartypes_0,
      final DerivedType[] scriptvartypes_1) {
    this(string_0, int_0, scriptvartypes_0 != null, scriptvartypes_0, scriptvartypes_1 != null,
        scriptvartypes_1);
  }

  ScriptArguments(final String string_0, final int int_0, final boolean bool_0, final boolean bool_1) {
    this(string_0, int_0, bool_0, null, bool_1, null);
  }

  @Override
  public int mappedOrdinal() {
    return anInt185;
  }

}
