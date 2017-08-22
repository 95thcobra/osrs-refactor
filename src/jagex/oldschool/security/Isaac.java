package jagex.oldschool.security;

import jagex.oldschool.Class52;
import jagex.oldschool.Class98;
import jagex.oldschool.DecorativeObject;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.io.BufferedFile;

public final class Isaac {

  public static BufferedFile[] aCacheFileArray1;
  public static int anInt181;
  public static BitmapFont aFont4;
  public static int cameraX;
  int valuesRemaining;
  int anInt182;
  int anInt183;
  int[] mm;
  int[] randResult;
  int anInt184;

  public Isaac(final int[] ints_0) {
    mm = new int[256];
    randResult = new int[256];

    for (int int_0 = 0; int_0 < ints_0.length; int_0++) {
      randResult[int_0] = ints_0[int_0];
    }

    method483();
  }

  public static int log(int int_0) {
    int int_1 = 0;
    if (int_0 < 0 || int_0 >= 65536) {
      int_0 >>>= 16;
      int_1 += 16;
    }

    if (int_0 >= 256) {
      int_0 >>>= 8;
      int_1 += 8;
    }

    if (int_0 >= 16) {
      int_0 >>>= 4;
      int_1 += 4;
    }

    if (int_0 >= 4) {
      int_0 >>>= 2;
      int_1 += 2;
    }

    if (int_0 >= 1) {
      int_0 >>>= 1;
      ++int_1;
    }

    return int_0 + int_1;
  }

  public static boolean method484(final char char_0) {
    if (Character.isISOControl(char_0)) {
      return false;
    }
    if (DecorativeObject.method479(char_0)) {
      return true;
    }
    char[] chars_0 = Class98.aCharArray3;

    int int_0;
    char char_1;
    for (int_0 = 0; int_0 < chars_0.length; int_0++) {
      char_1 = chars_0[int_0];
      if (char_0 == char_1) {
        return true;
      }
    }

    chars_0 = Class98.aCharArray4;

    for (int_0 = 0; int_0 < chars_0.length; int_0++) {
      char_1 = chars_0[int_0];
      if (char_0 == char_1) {
        return true;
      }
    }

    return false;
  }

  public static String method485(final CharSequence charsequence_0) {
    final int int_0 = charsequence_0.length();
    final StringBuilder stringbuilder_0 = new StringBuilder(int_0);

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final char char_0 = charsequence_0.charAt(int_1);
      if ((char_0 < 97 || char_0 > 122) && (char_0 < 65 || char_0 > 90)
          && (char_0 < 48 || char_0 > 57) && char_0 != 46 && char_0 != 45 && char_0 != 42
          && char_0 != 95) {
        if (char_0 == 32) {
          stringbuilder_0.append('+');
        } else {
          final byte byte_0 = Class52.method330(char_0);
          stringbuilder_0.append('%');
          int int_2 = byte_0 >> 4 & 0xF;
          if (int_2 >= 10) {
            stringbuilder_0.append((char) (int_2 + 55));
          } else {
            stringbuilder_0.append((char) (int_2 + 48));
          }

          int_2 = byte_0 & 0xF;
          if (int_2 >= 10) {
            stringbuilder_0.append((char) (int_2 + 55));
          } else {
            stringbuilder_0.append((char) (int_2 + 48));
          }
        }
      } else {
        stringbuilder_0.append(char_0);
      }
    }

    return stringbuilder_0.toString();
  }

  final void generateMoreResults() {
    anInt182 += ++anInt183;

    for (int int_0 = 0; int_0 < 256; int_0++) {
      final int int_1 = mm[int_0];
      if ((int_0 & 0x2) == 0) {
        if ((int_0 & 0x1) == 0) {
          anInt184 ^= anInt184 << 13;
        } else {
          anInt184 ^= anInt184 >>> 6;
        }
      } else if ((int_0 & 0x1) == 0) {
        anInt184 ^= anInt184 << 2;
      } else {
        anInt184 ^= anInt184 >>> 16;
      }

      anInt184 += mm[int_0 + 128 & 0xFF];
      int int_2;
      mm[int_0] = int_2 = mm[(int_1 & 0x3FC) >> 2] + anInt182 + anInt184;
      randResult[int_0] = anInt182 = mm[(int_2 >> 8 & 0x3FC) >> 2] + int_1;
    }

  }

  final void method483() {
    int int_0 = -1640531527;
    int int_1 = -1640531527;
    int int_2 = -1640531527;
    int int_3 = -1640531527;
    int int_4 = -1640531527;
    int int_5 = -1640531527;
    int int_6 = -1640531527;
    int int_7 = -1640531527;

    int int_8;
    for (int_8 = 0; int_8 < 4; int_8++) {
      int_7 ^= int_6 << 11;
      int_4 += int_7;
      int_6 += int_5;
      int_6 ^= int_5 >>> 2;
      int_3 += int_6;
      int_5 += int_4;
      int_5 ^= int_4 << 8;
      int_2 += int_5;
      int_4 += int_3;
      int_4 ^= int_3 >>> 16;
      int_1 += int_4;
      int_3 += int_2;
      int_3 ^= int_2 << 10;
      int_0 += int_3;
      int_2 += int_1;
      int_2 ^= int_1 >>> 4;
      int_7 += int_2;
      int_1 += int_0;
      int_1 ^= int_0 << 8;
      int_6 += int_1;
      int_0 += int_7;
      int_0 ^= int_7 >>> 9;
      int_5 += int_0;
      int_7 += int_6;
    }

    for (int_8 = 0; int_8 < 256; int_8 += 8) {
      int_7 += randResult[int_8];
      int_6 += randResult[int_8 + 1];
      int_5 += randResult[int_8 + 2];
      int_4 += randResult[int_8 + 3];
      int_3 += randResult[int_8 + 4];
      int_2 += randResult[int_8 + 5];
      int_1 += randResult[int_8 + 6];
      int_0 += randResult[int_8 + 7];
      int_7 ^= int_6 << 11;
      int_4 += int_7;
      int_6 += int_5;
      int_6 ^= int_5 >>> 2;
      int_3 += int_6;
      int_5 += int_4;
      int_5 ^= int_4 << 8;
      int_2 += int_5;
      int_4 += int_3;
      int_4 ^= int_3 >>> 16;
      int_1 += int_4;
      int_3 += int_2;
      int_3 ^= int_2 << 10;
      int_0 += int_3;
      int_2 += int_1;
      int_2 ^= int_1 >>> 4;
      int_7 += int_2;
      int_1 += int_0;
      int_1 ^= int_0 << 8;
      int_6 += int_1;
      int_0 += int_7;
      int_0 ^= int_7 >>> 9;
      int_5 += int_0;
      int_7 += int_6;
      mm[int_8] = int_7;
      mm[int_8 + 1] = int_6;
      mm[int_8 + 2] = int_5;
      mm[int_8 + 3] = int_4;
      mm[int_8 + 4] = int_3;
      mm[int_8 + 5] = int_2;
      mm[int_8 + 6] = int_1;
      mm[int_8 + 7] = int_0;
    }

    for (int_8 = 0; int_8 < 256; int_8 += 8) {
      int_7 += mm[int_8];
      int_6 += mm[int_8 + 1];
      int_5 += mm[int_8 + 2];
      int_4 += mm[int_8 + 3];
      int_3 += mm[int_8 + 4];
      int_2 += mm[int_8 + 5];
      int_1 += mm[int_8 + 6];
      int_0 += mm[int_8 + 7];
      int_7 ^= int_6 << 11;
      int_4 += int_7;
      int_6 += int_5;
      int_6 ^= int_5 >>> 2;
      int_3 += int_6;
      int_5 += int_4;
      int_5 ^= int_4 << 8;
      int_2 += int_5;
      int_4 += int_3;
      int_4 ^= int_3 >>> 16;
      int_1 += int_4;
      int_3 += int_2;
      int_3 ^= int_2 << 10;
      int_0 += int_3;
      int_2 += int_1;
      int_2 ^= int_1 >>> 4;
      int_7 += int_2;
      int_1 += int_0;
      int_1 ^= int_0 << 8;
      int_6 += int_1;
      int_0 += int_7;
      int_0 ^= int_7 >>> 9;
      int_5 += int_0;
      int_7 += int_6;
      mm[int_8] = int_7;
      mm[int_8 + 1] = int_6;
      mm[int_8 + 2] = int_5;
      mm[int_8 + 3] = int_4;
      mm[int_8 + 4] = int_3;
      mm[int_8 + 5] = int_2;
      mm[int_8 + 6] = int_1;
      mm[int_8 + 7] = int_0;
    }

    generateMoreResults();
    valuesRemaining = 256;
  }

  public final int nextInt() {
    if (--valuesRemaining + 1 == 0) {
      generateMoreResults();
      valuesRemaining = 255;
    }

    return randResult[valuesRemaining];
  }

}
