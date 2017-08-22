package jagex.oldschool;

import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Base37;

public class AClass1_Sub2 extends AClass1 {

  static long aLong18;
  public static Class108 aClass108_10;
  static int anInt305;
  public static int anInt306;

  static void method623(final int int_0, final int int_1, final int int_2, final int int_3) {
    final InterfaceComponent widget_0 = AClass4_Sub3.method819(int_0, int_1);
    if (widget_0 != null && widget_0.anObjectArray7 != null) {
      final ScriptCall scriptevent_0 = new ScriptCall();
      scriptevent_0.widget = widget_0;
      scriptevent_0.anObjectArray22 = widget_0.anObjectArray7;
      Position.execute(scriptevent_0);
    }

    Client.anInt684 = int_3;
    Client.spellSelected = true;
    Class10.anInt50 = int_0;
    Client.anInt685 = int_1;
    JavaxSourceDataLineProvider.anInt62 = int_2;
    Class28.method236(widget_0);
  }

  public static String method624(long long_0) {
    if (long_0 > 0L && long_0 < 6582952005840035281L) {
      if (long_0 % 37L == 0L) {
        return null;
      }
      int int_0 = 0;

      for (long long_1 = long_0; long_1 != 0L; long_1 /= 37L) {
        ++int_0;
      }

      StringBuilder stringbuilder_0;
      char char_0;
      for (stringbuilder_0 = new StringBuilder(int_0); long_0 != 0L;
          stringbuilder_0.append(char_0)) {
        final long long_2 = long_0;
        long_0 /= 37L;
        char_0 = Base37.ALPHABET[(int) (long_2 - 37L * long_0)];
        if (char_0 == 95) {
          final int int_1 = stringbuilder_0.length() - 1;
          stringbuilder_0.setCharAt(int_1, Character.toUpperCase(stringbuilder_0.charAt(int_1)));
          char_0 = 160;
        }
      }

      stringbuilder_0.reverse();
      stringbuilder_0.setCharAt(0, Character.toUpperCase(stringbuilder_0.charAt(0)));
      return stringbuilder_0.toString();
    }
    return null;
  }

  static void method625(final String[] strings_0, final short[] shorts_0, final int int_0,
      final int int_1) {
    if (int_0 < int_1) {
      final int int_2 = (int_1 + int_0) / 2;
      int int_3 = int_0;
      final String string_0 = strings_0[int_2];
      strings_0[int_2] = strings_0[int_1];
      strings_0[int_1] = string_0;
      final short short_0 = shorts_0[int_2];
      shorts_0[int_2] = shorts_0[int_1];
      shorts_0[int_1] = short_0;

      for (int int_4 = int_0; int_4 < int_1; int_4++) {
        if (string_0 == null
            || strings_0[int_4] != null && strings_0[int_4].compareTo(string_0) < (int_4
            & 0x1)) {
          final String string_1 = strings_0[int_4];
          strings_0[int_4] = strings_0[int_3];
          strings_0[int_3] = string_1;
          final short short_1 = shorts_0[int_4];
          shorts_0[int_4] = shorts_0[int_3];
          shorts_0[int_3++] = short_1;
        }
      }

      strings_0[int_1] = strings_0[int_3];
      strings_0[int_3] = string_0;
      shorts_0[int_1] = shorts_0[int_3];
      shorts_0[int_3] = short_0;
      method625(strings_0, shorts_0, int_0, int_3 - 1);
      method625(strings_0, shorts_0, int_3 + 1, int_1);
    }
  }

  void method622(final Buffer buffer_0, final Buffer buffer_1) {
    int int_0 = buffer_1.getUnsignedByte();
    if (int_0 != Class11.aClass11_2.anInt56) {
      throw new IllegalStateException("");
    }
    anInt43 = buffer_1.getUnsignedByte();
    anInt42 = buffer_1.getUnsignedByte();
    anInt44 = buffer_1.getUnsignedShort();
    anInt45 = buffer_1.getUnsignedShort();
    anInt41 = buffer_1.getUnsignedShort();
    anInt40 = buffer_1.getUnsignedShort();
    anInt42 = Math.min(anInt42, 4);
    aShortArrayArrayArray1 = new short[1][64][64];
    aShortArrayArrayArray2 = new short[anInt42][64][64];
    aByteArrayArrayArray1 = new byte[anInt42][64][64];
    aByteArrayArrayArray2 = new byte[anInt42][64][64];
    aClass13ArrayArrayArrayArray1 = new Class13[anInt42][64][64][];
    int_0 = buffer_0.getUnsignedByte();
    if (int_0 != Class12.aClass12_1.anInt57) {
      throw new IllegalStateException("");
    }
    final int int_1 = buffer_0.getUnsignedByte();
    final int int_2 = buffer_0.getUnsignedByte();
    if (int_1 == anInt41 && int_2 == anInt40) {
      for (int int_3 = 0; int_3 < 64; int_3++) {
        for (int int_4 = 0; int_4 < 64; int_4++) {
          method149(int_3, int_4, buffer_0);
        }
      }

    } else {
      throw new IllegalStateException("");
    }
  }

  @Override
  public int hashCode() {
    return anInt41 | anInt40 << 8;
  }

  @Override
  public boolean equals(final Object object_0) {
    if (!(object_0 instanceof AClass1_Sub2)) {
      return false;
    }
    final AClass1_Sub2 aclass1_sub2_1 = (AClass1_Sub2) object_0;
    return aclass1_sub2_1.anInt41 == anInt41 && aclass1_sub2_1.anInt40 == anInt40;
  }

}
