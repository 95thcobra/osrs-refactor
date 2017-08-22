package jagex.oldschool;

import jagex.oldschool.audio.AbstractSourceLine;

public class AClass4_Sub2 extends AClass4 {

  int anInt415;
  int anInt416;
  int anInt417;
  int anInt418;
  int anInt419;
  int anInt420;
  int anInt421;
  int anInt422;
  int anInt423;
  int anInt424;
  int anInt425;
  int anInt426;
  int anInt427;
  boolean aBool51;
  int anInt428;

  AClass4_Sub2(final AClass5_Sub1 aclass5_sub1_0, final int int_0, final int int_1,
      final int int_2) {
    anAClass5_1 = aclass5_sub1_0;
    anInt423 = aclass5_sub1_0.anInt406;
    anInt425 = aclass5_sub1_0.anInt407;
    aBool51 = aclass5_sub1_0.aBool50;
    anInt420 = int_0;
    anInt416 = int_1;
    anInt415 = int_2;
    anInt421 = 0;
    method735();
  }

  AClass4_Sub2(final AClass5_Sub1 aclass5_sub1_0, final int int_0, final int int_1) {
    anAClass5_1 = aclass5_sub1_0;
    anInt423 = aclass5_sub1_0.anInt406;
    anInt425 = aclass5_sub1_0.anInt407;
    aBool51 = aclass5_sub1_0.aBool50;
    anInt420 = int_0;
    anInt416 = int_1;
    anInt415 = 8192;
    anInt421 = 0;
    method735();
  }

  static int method750(final int int_0, final int int_1) {
    return int_1 < 0 ? int_0
        : (int) (int_0 * Math.sqrt((16384 - int_1) * 1.220703125E-4D) + 0.5D);
  }

  static int method751(final int int_0, final int int_1) {
    return int_1 < 0 ? -int_0 : (int) (int_0 * Math.sqrt(int_1 * 1.220703125E-4D) + 0.5D);
  }

  static int method752(final int int_0, int int_1, final byte[] bytes_0, final int[] ints_0,
      int int_2, int int_3,
      final int int_4, int int_5, final int int_6, final int int_7,
      final AClass4_Sub2 aclass4_sub2_0,
      final int int_8, final int int_9) {
    if (int_8 == 0 || (int_5 = int_3 + (int_8 + int_7 - int_2 - 257) / int_8) > int_6) {
      int_5 = int_6;
    }

    byte byte_0;
    int int_10;
    while (int_3 < int_5) {
      int_1 = int_2 >> 8;
      byte_0 = bytes_0[int_1];
      int_10 = int_3++;
      ints_0[int_10] +=
          ((byte_0 << 8) + (int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0)) * int_4 >> 6;
      int_2 += int_8;
    }

    if (int_8 == 0 || (int_5 = int_3 + (int_8 + int_7 - int_2 - 1) / int_8) > int_6) {
      int_5 = int_6;
    }

    for (int_1 = int_9; int_3 < int_5; int_2 += int_8) {
      byte_0 = bytes_0[int_2 >> 8];
      int_10 = int_3++;
      ints_0[int_10] += ((byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
    }

    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method753(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      final int int_4, int int_5, final int int_6, final int int_7,
      final AClass4_Sub2 aclass4_sub2_0,
      final int int_8, final int int_9) {
    if (int_8 == 0 || (int_5 = int_3 + (int_8 + int_7 + 256 - int_2) / int_8) > int_6) {
      int_5 = int_6;
    }

    int int_10;
    while (int_3 < int_5) {
      int_1 = int_2 >> 8;
      final byte byte_0 = bytes_0[int_1 - 1];
      int_10 = int_3++;
      ints_0[int_10] +=
          ((bytes_0[int_1] - byte_0) * (int_2 & 0xFF) + (byte_0 << 8)) * int_4 >> 6;
      int_2 += int_8;
    }

    if (int_8 == 0 || (int_5 = int_3 + (int_8 + int_7 - int_2) / int_8) > int_6) {
      int_5 = int_6;
    }

    int_0 = int_9;

    for (int_1 = int_8; int_3 < int_5; int_2 += int_1) {
      int_10 = int_3++;
      ints_0[int_10] +=
          ((int_0 << 8) + (bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF)) * int_4 >> 6;
    }

    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method754(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2,
      int int_3,
      final int int_4, int int_5, final AClass4_Sub2 aclass4_sub2_0) {
    int_0 >>= 8;
    int_5 >>= 8;
    int_2 <<= 2;
    if ((int_3 = int_1 + int_5 - int_0) > int_4) {
      int_3 = int_4;
    }

    int int_6;
    for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2) {
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0++] * int_2;
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0++] * int_2;
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0++] * int_2;
      int_6 = int_1++;
    }

    for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0++] * int_2) {
      int_6 = int_1++;
    }

    aclass4_sub2_0.anInt421 = int_0 << 8;
    return int_1;
  }

  static int method755(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      final int int_4, final int int_5, int int_6, final int int_7, final int int_8,
      final AClass4_Sub2 aclass4_sub2_0, final int int_9, final int int_10) {
    if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 257) / int_9) > int_7) {
      int_6 = int_7;
    }

    int_3 <<= 1;

    byte byte_0;
    int int_11;
    for (int_6 <<= 1; int_3 < int_6; int_2 += int_9) {
      int_1 = int_2 >> 8;
      byte_0 = bytes_0[int_1];
      int_0 = (byte_0 << 8) + (bytes_0[int_1 + 1] - byte_0) * (int_2 & 0xFF);
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_4 >> 6;
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_5 >> 6;
    }

    if (int_9 == 0 || (int_6 = (int_3 >> 1) + (int_8 - int_2 + int_9 - 1) / int_9)
        > int_7) {
      int_6 = int_7;
    }

    int_6 <<= 1;

    for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
      byte_0 = bytes_0[int_2 >> 8];
      int_0 = (byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF);
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_4 >> 6;
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_5 >> 6;
    }

    aclass4_sub2_0.anInt421 = int_2;
    return int_3 >> 1;
  }

  static int method756(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2,
      int int_3,
      final int int_4, int int_5, final AClass4_Sub2 aclass4_sub2_0) {
    int_0 >>= 8;
    int_5 >>= 8;
    int_2 <<= 2;
    if ((int_3 = int_1 + int_0 - (int_5 - 1)) > int_4) {
      int_3 = int_4;
    }

    int int_6;
    for (int_3 -= 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2) {
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0--] * int_2;
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0--] * int_2;
      int_6 = int_1++;
      ints_0[int_6] += bytes_0[int_0--] * int_2;
      int_6 = int_1++;
    }

    for (int_3 += 3; int_1 < int_3; ints_0[int_6] += bytes_0[int_0--] * int_2) {
      int_6 = int_1++;
    }

    aclass4_sub2_0.anInt421 = int_0 << 8;
    return int_1;
  }

  static int method757(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      final int int_4, final int int_5, int int_6, final int int_7, final int int_8,
      final AClass4_Sub2 aclass4_sub2_0, final int int_9, final int int_10) {
    if (int_9 == 0 || (int_6 = int_3 + (int_8 + 256 - int_2 + int_9) / int_9) > int_7) {
      int_6 = int_7;
    }

    int_3 <<= 1;

    int int_11;
    for (int_6 <<= 1; int_3 < int_6; int_2 += int_9) {
      int_1 = int_2 >> 8;
      final byte byte_0 = bytes_0[int_1 - 1];
      int_0 = (bytes_0[int_1] - byte_0) * (int_2 & 0xFF) + (byte_0 << 8);
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_4 >> 6;
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_5 >> 6;
    }

    if (int_9 == 0 || (int_6 = (int_3 >> 1) + (int_8 - int_2 + int_9) / int_9) > int_7) {
      int_6 = int_7;
    }

    int_6 <<= 1;

    for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
      int_0 = (int_1 << 8) + (int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1);
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_4 >> 6;
      int_11 = int_3++;
      ints_0[int_11] += int_0 * int_5 >> 6;
    }

    aclass4_sub2_0.anInt421 = int_2;
    return int_3 >> 1;
  }

  static int method758(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1,
      int int_2, int int_3,
      int int_4, int int_5, final int int_6, int int_7, final AClass4_Sub2 aclass4_sub2_0) {
    int_1 >>= 8;
    int_7 >>= 8;
    int_3 <<= 2;
    int_4 <<= 2;
    if ((int_5 = int_2 + int_7 - int_1) > int_6) {
      int_5 = int_6;
    }

    int_2 <<= 1;
    int_5 <<= 1;

    int int_8;
    byte byte_0;
    for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
      byte_0 = bytes_0[int_1++];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1++];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1++];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1++];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
    }

    for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
      byte_0 = bytes_0[int_1++];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
    }

    aclass4_sub2_0.anInt421 = int_1 << 8;
    return int_2 >> 1;
  }

  static int method759(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1,
      int int_2, int int_3,
      int int_4, int int_5, final int int_6, int int_7, final AClass4_Sub2 aclass4_sub2_0) {
    int_1 >>= 8;
    int_7 >>= 8;
    int_3 <<= 2;
    int_4 <<= 2;
    if ((int_5 = int_1 + int_2 - (int_7 - 1)) > int_6) {
      int_5 = int_6;
    }

    int_2 <<= 1;
    int_5 <<= 1;

    int int_8;
    byte byte_0;
    for (int_5 -= 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
      byte_0 = bytes_0[int_1--];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1--];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1--];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
      ints_0[int_8] += byte_0 * int_4;
      byte_0 = bytes_0[int_1--];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
    }

    for (int_5 += 6; int_2 < int_5; ints_0[int_8] += byte_0 * int_4) {
      byte_0 = bytes_0[int_1--];
      int_8 = int_2++;
      ints_0[int_8] += int_3 * byte_0;
      int_8 = int_2++;
    }

    aclass4_sub2_0.anInt421 = int_1 << 8;
    return int_2 >> 1;
  }

  static int method760(final int int_0, int int_1, final byte[] bytes_0, final int[] ints_0,
      int int_2, int int_3,
      int int_4, final int int_5, int int_6, final int int_7, final int int_8,
      final AClass4_Sub2 aclass4_sub2_0,
      final int int_9, final int int_10) {
    aclass4_sub2_0.anInt422 -= aclass4_sub2_0.anInt427 * int_3;
    aclass4_sub2_0.anInt424 -= aclass4_sub2_0.anInt428 * int_3;
    if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 257) / int_9) > int_7) {
      int_6 = int_7;
    }

    byte byte_0;
    int int_11;
    while (int_3 < int_6) {
      int_1 = int_2 >> 8;
      byte_0 = bytes_0[int_1];
      int_11 = int_3++;
      ints_0[int_11] +=
          ((byte_0 << 8) + (int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0)) * int_4 >> 6;
      int_4 += int_5;
      int_2 += int_9;
    }

    if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9 - 1) / int_9) > int_7) {
      int_6 = int_7;
    }

    for (int_1 = int_10; int_3 < int_6; int_2 += int_9) {
      byte_0 = bytes_0[int_2 >> 8];
      int_11 = int_3++;
      ints_0[int_11] += ((byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
      int_4 += int_5;
    }

    aclass4_sub2_0.anInt422 += aclass4_sub2_0.anInt427 * int_3;
    aclass4_sub2_0.anInt424 += aclass4_sub2_0.anInt428 * int_3;
    aclass4_sub2_0.anInt417 = int_4;
    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method761(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      int int_4, final int int_5, int int_6, final int int_7, final int int_8,
      final AClass4_Sub2 aclass4_sub2_0,
      final int int_9, final int int_10) {
    aclass4_sub2_0.anInt422 -= aclass4_sub2_0.anInt427 * int_3;
    aclass4_sub2_0.anInt424 -= aclass4_sub2_0.anInt428 * int_3;
    if (int_9 == 0 || (int_6 = int_3 + (int_8 + 256 - int_2 + int_9) / int_9) > int_7) {
      int_6 = int_7;
    }

    int int_11;
    while (int_3 < int_6) {
      int_1 = int_2 >> 8;
      final byte byte_0 = bytes_0[int_1 - 1];
      int_11 = int_3++;
      ints_0[int_11] +=
          ((byte_0 << 8) + (bytes_0[int_1] - byte_0) * (int_2 & 0xFF)) * int_4 >> 6;
      int_4 += int_5;
      int_2 += int_9;
    }

    if (int_9 == 0 || (int_6 = int_3 + (int_8 - int_2 + int_9) / int_9) > int_7) {
      int_6 = int_7;
    }

    int_0 = int_10;

    for (int_1 = int_9; int_3 < int_6; int_2 += int_1) {
      int_11 = int_3++;
      ints_0[int_11] +=
          ((int_0 << 8) + (bytes_0[int_2 >> 8] - int_0) * (int_2 & 0xFF)) * int_4 >> 6;
      int_4 += int_5;
    }

    aclass4_sub2_0.anInt422 += aclass4_sub2_0.anInt427 * int_3;
    aclass4_sub2_0.anInt424 += aclass4_sub2_0.anInt428 * int_3;
    aclass4_sub2_0.anInt417 = int_4;
    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method762(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2,
      int int_3,
      int int_4, final int int_5, int int_6, final AClass4_Sub2 aclass4_sub2_0) {
    int_0 >>= 8;
    int_6 >>= 8;
    int_2 <<= 2;
    int_3 <<= 2;
    if ((int_4 = int_1 + int_6 - int_0) > int_5) {
      int_4 = int_5;
    }

    aclass4_sub2_0.anInt422 += aclass4_sub2_0.anInt427 * (int_4 - int_1);
    aclass4_sub2_0.anInt424 += aclass4_sub2_0.anInt428 * (int_4 - int_1);

    int int_7;
    for (int_4 -= 3; int_1 < int_4; int_2 += int_3) {
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0++] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0++] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0++] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0++] * int_2;
    }

    for (int_4 += 3; int_1 < int_4; int_2 += int_3) {
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0++] * int_2;
    }

    aclass4_sub2_0.anInt417 = int_2 >> 2;
    aclass4_sub2_0.anInt421 = int_0 << 8;
    return int_1;
  }

  static int method763(final byte[] bytes_0, final int[] ints_0, int int_0, int int_1, int int_2,
      int int_3,
      int int_4, final int int_5, int int_6, final AClass4_Sub2 aclass4_sub2_0) {
    int_0 >>= 8;
    int_6 >>= 8;
    int_2 <<= 2;
    int_3 <<= 2;
    if ((int_4 = int_1 + int_0 - (int_6 - 1)) > int_5) {
      int_4 = int_5;
    }

    aclass4_sub2_0.anInt422 += aclass4_sub2_0.anInt427 * (int_4 - int_1);
    aclass4_sub2_0.anInt424 += aclass4_sub2_0.anInt428 * (int_4 - int_1);

    int int_7;
    for (int_4 -= 3; int_1 < int_4; int_2 += int_3) {
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0--] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0--] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0--] * int_2;
      int_2 += int_3;
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0--] * int_2;
    }

    for (int_4 += 3; int_1 < int_4; int_2 += int_3) {
      int_7 = int_1++;
      ints_0[int_7] += bytes_0[int_0--] * int_2;
    }

    aclass4_sub2_0.anInt417 = int_2 >> 2;
    aclass4_sub2_0.anInt421 = int_0 << 8;
    return int_1;
  }

  static int method764(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      int int_4, int int_5, final int int_6, final int int_7, int int_8, final int int_9,
      final int int_10,
      final AClass4_Sub2 aclass4_sub2_0, final int int_11, final int int_12) {
    aclass4_sub2_0.anInt417 -= int_3 * aclass4_sub2_0.anInt426;
    if (int_11 == 0 || (int_8 = int_3 + (int_10 - int_2 + int_11 - 257) / int_11)
        > int_9) {
      int_8 = int_9;
    }

    int_3 <<= 1;

    byte byte_0;
    int int_13;
    for (int_8 <<= 1; int_3 < int_8; int_2 += int_11) {
      int_1 = int_2 >> 8;
      byte_0 = bytes_0[int_1];
      int_0 = (byte_0 << 8) + (int_2 & 0xFF) * (bytes_0[int_1 + 1] - byte_0);
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_4 >> 6;
      int_4 += int_6;
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_5 >> 6;
      int_5 += int_7;
    }

    if (int_11 == 0 || (int_8 = (int_3 >> 1) + (int_10 - int_2 + int_11 - 1) / int_11)
        > int_9) {
      int_8 = int_9;
    }

    int_8 <<= 1;

    for (int_1 = int_12; int_3 < int_8; int_2 += int_11) {
      byte_0 = bytes_0[int_2 >> 8];
      int_0 = (byte_0 << 8) + (int_1 - byte_0) * (int_2 & 0xFF);
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_4 >> 6;
      int_4 += int_6;
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_5 >> 6;
      int_5 += int_7;
    }

    int_3 >>= 1;
    aclass4_sub2_0.anInt417 += int_3 * aclass4_sub2_0.anInt426;
    aclass4_sub2_0.anInt422 = int_4;
    aclass4_sub2_0.anInt424 = int_5;
    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method765(int int_0, int int_1, final byte[] bytes_0, final int[] ints_0, int int_2,
      int int_3,
      int int_4, int int_5, final int int_6, final int int_7, int int_8, final int int_9,
      final int int_10,
      final AClass4_Sub2 aclass4_sub2_0, final int int_11, final int int_12) {
    aclass4_sub2_0.anInt417 -= int_3 * aclass4_sub2_0.anInt426;
    if (int_11 == 0 || (int_8 = int_3 + (int_10 + 256 - int_2 + int_11) / int_11)
        > int_9) {
      int_8 = int_9;
    }

    int_3 <<= 1;

    int int_13;
    for (int_8 <<= 1; int_3 < int_8; int_2 += int_11) {
      int_1 = int_2 >> 8;
      final byte byte_0 = bytes_0[int_1 - 1];
      int_0 = (byte_0 << 8) + (bytes_0[int_1] - byte_0) * (int_2 & 0xFF);
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_4 >> 6;
      int_4 += int_6;
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_5 >> 6;
      int_5 += int_7;
    }

    if (int_11 == 0 || (int_8 = (int_3 >> 1) + (int_10 - int_2 + int_11) / int_11)
        > int_9) {
      int_8 = int_9;
    }

    int_8 <<= 1;

    for (int_1 = int_12; int_3 < int_8; int_2 += int_11) {
      int_0 = (int_1 << 8) + (int_2 & 0xFF) * (bytes_0[int_2 >> 8] - int_1);
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_4 >> 6;
      int_4 += int_6;
      int_13 = int_3++;
      ints_0[int_13] += int_0 * int_5 >> 6;
      int_5 += int_7;
    }

    int_3 >>= 1;
    aclass4_sub2_0.anInt417 += int_3 * aclass4_sub2_0.anInt426;
    aclass4_sub2_0.anInt422 = int_4;
    aclass4_sub2_0.anInt424 = int_5;
    aclass4_sub2_0.anInt421 = int_2;
    return int_3;
  }

  static int method766(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1,
      int int_2, int int_3,
      int int_4, int int_5, int int_6, int int_7, final int int_8, int int_9,
      final AClass4_Sub2 aclass4_sub2_0) {
    int_1 >>= 8;
    int_9 >>= 8;
    int_3 <<= 2;
    int_4 <<= 2;
    int_5 <<= 2;
    int_6 <<= 2;
    if ((int_7 = int_9 + int_2 - int_1) > int_8) {
      int_7 = int_8;
    }

    aclass4_sub2_0.anInt417 += (int_7 - int_2) * aclass4_sub2_0.anInt426;
    int_2 <<= 1;
    int_7 <<= 1;

    byte byte_0;
    int int_10;
    for (int_7 -= 6; int_2 < int_7; int_4 += int_6) {
      byte_0 = bytes_0[int_1++];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1++];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1++];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1++];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
    }

    for (int_7 += 6; int_2 < int_7; int_4 += int_6) {
      byte_0 = bytes_0[int_1++];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
    }

    aclass4_sub2_0.anInt422 = int_3 >> 2;
    aclass4_sub2_0.anInt424 = int_4 >> 2;
    aclass4_sub2_0.anInt421 = int_1 << 8;
    return int_2 >> 1;
  }

  static int method767(final int int_0, final byte[] bytes_0, final int[] ints_0, int int_1,
      int int_2, int int_3,
      int int_4, int int_5, int int_6, int int_7, final int int_8, int int_9,
      final AClass4_Sub2 aclass4_sub2_0) {
    int_1 >>= 8;
    int_9 >>= 8;
    int_3 <<= 2;
    int_4 <<= 2;
    int_5 <<= 2;
    int_6 <<= 2;
    if ((int_7 = int_1 + int_2 - (int_9 - 1)) > int_8) {
      int_7 = int_8;
    }

    aclass4_sub2_0.anInt417 += (int_7 - int_2) * aclass4_sub2_0.anInt426;
    int_2 <<= 1;
    int_7 <<= 1;

    byte byte_0;
    int int_10;
    for (int_7 -= 6; int_2 < int_7; int_4 += int_6) {
      byte_0 = bytes_0[int_1--];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1--];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1--];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
      int_4 += int_6;
      byte_0 = bytes_0[int_1--];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
    }

    for (int_7 += 6; int_2 < int_7; int_4 += int_6) {
      byte_0 = bytes_0[int_1--];
      int_10 = int_2++;
      ints_0[int_10] += int_3 * byte_0;
      int_3 += int_5;
      int_10 = int_2++;
      ints_0[int_10] += byte_0 * int_4;
    }

    aclass4_sub2_0.anInt422 = int_3 >> 2;
    aclass4_sub2_0.anInt424 = int_4 >> 2;
    aclass4_sub2_0.anInt421 = int_1 << 8;
    return int_2 >> 1;
  }

  public static AClass4_Sub2 method768(final AClass5_Sub1 aclass5_sub1_0, final int int_0,
      final int int_1,
      final int int_2) {
    return aclass5_sub1_0.aByteArray18 != null && aclass5_sub1_0.aByteArray18.length != 0
        ? new AClass4_Sub2(aclass5_sub1_0, int_0, int_1, int_2)
        : null;
  }

  public static AClass4_Sub2 method769(final AClass5_Sub1 aclass5_sub1_0, final int int_0,
      final int int_1) {
    return aclass5_sub1_0.aByteArray18 != null && aclass5_sub1_0.aByteArray18.length != 0
        ? new AClass4_Sub2(aclass5_sub1_0,
        (int) (aclass5_sub1_0.anInt405 * 256L * int_0 / (AbstractSourceLine.sampleRate * 100)),
        int_1 << 6)
        : null;
  }

  public synchronized int method730() {
    return anInt415 < 0 ? -1 : anInt415;
  }

  synchronized void method731(final int int_0) {
    method732(int_0, method730());
  }

  synchronized void method732(final int int_0, final int int_1) {
    anInt416 = int_0;
    anInt415 = int_1;
    anInt419 = 0;
    method735();
  }

  public synchronized void method733(int int_0, final int int_1, final int int_2) {
    if (int_0 == 0) {
      method732(int_1, int_2);
    } else {
      final int int_3 = method750(int_1, int_2);
      final int int_4 = method751(int_1, int_2);
      if (int_3 == anInt422 && int_4 == anInt424) {
        anInt419 = 0;
      } else {
        int int_5 = int_1 - anInt417;
        if (anInt417 - int_1 > int_5) {
          int_5 = anInt417 - int_1;
        }

        if (int_3 - anInt422 > int_5) {
          int_5 = int_3 - anInt422;
        }

        if (anInt422 - int_3 > int_5) {
          int_5 = anInt422 - int_3;
        }

        if (int_4 - anInt424 > int_5) {
          int_5 = int_4 - anInt424;
        }

        if (anInt424 - int_4 > int_5) {
          int_5 = anInt424 - int_4;
        }

        if (int_0 > int_5) {
          int_0 = int_5;
        }

        anInt419 = int_0;
        anInt416 = int_1;
        anInt415 = int_2;
        anInt426 = (int_1 - anInt417) / int_0;
        anInt427 = (int_3 - anInt422) / int_0;
        anInt428 = (int_4 - anInt424) / int_0;
      }
    }
  }

  @Override
  public synchronized void method632(final int[] ints_0, final int int_0, int int_1) {
    if (anInt416 == 0 && anInt419 == 0) {
      method633(int_1);
    } else {
      final AClass5_Sub1 aclass5_sub1_0 = (AClass5_Sub1) anAClass5_1;
      final int int_2 = anInt423 << 8;
      final int int_3 = anInt425 << 8;
      final int int_4 = aclass5_sub1_0.aByteArray18.length << 8;
      final int int_5 = int_3 - int_2;
      if (int_5 <= 0) {
        anInt418 = 0;
      }

      int int_6 = int_0;
      int_1 += int_0;
      if (anInt421 < 0) {
        if (anInt420 <= 0) {
          method739();
          unlink();
          return;
        }

        anInt421 = 0;
      }

      if (anInt421 >= int_4) {
        if (anInt420 >= 0) {
          method739();
          unlink();
          return;
        }

        anInt421 = int_4 - 1;
      }

      if (anInt418 < 0) {
        if (aBool51) {
          if (anInt420 < 0) {
            int_6 = method743(ints_0, int_0, int_2, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
            if (anInt421 >= int_2) {
              return;
            }

            anInt421 = (int_2 + int_2) - 1 - anInt421;
            anInt420 = -anInt420;
          }

          while (true) {
            int_6 = method746(ints_0, int_6, int_3, int_1,
                aclass5_sub1_0.aByteArray18[anInt425 - 1]);
            if (anInt421 < int_3) {
              return;
            }

            anInt421 = (int_3 + int_3) - 1 - anInt421;
            anInt420 = -anInt420;
            int_6 = method743(ints_0, int_6, int_2, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
            if (anInt421 >= int_2) {
              return;
            }

            anInt421 = (int_2 + int_2) - 1 - anInt421;
            anInt420 = -anInt420;
          }
        }
        if (anInt420 < 0) {
          while (true) {
            int_6 = method743(ints_0, int_6, int_2, int_1,
                aclass5_sub1_0.aByteArray18[anInt425 - 1]);
            if (anInt421 >= int_2) {
              return;
            }

            anInt421 = int_3 - 1 - (int_3 - 1 - anInt421) % int_5;
          }
        }
        while (true) {
          int_6 = method746(ints_0, int_6, int_3, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
          if (anInt421 < int_3) {
            return;
          }

          anInt421 = int_2 + (anInt421 - int_2) % int_5;
        }
      }
      if (anInt418 > 0) {
        if (aBool51) {
          label139:
          {
            if (anInt420 < 0) {
              int_6 = method743(ints_0, int_0, int_2, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
              if (anInt421 >= int_2) {
                return;
              }

              anInt421 = (int_2 + int_2) - 1 - anInt421;
              anInt420 = -anInt420;
              if (--anInt418 == 0) {
                break label139;
              }
            }

            do {
              int_6 = method746(ints_0, int_6, int_3, int_1,
                  aclass5_sub1_0.aByteArray18[anInt425 - 1]);
              if (anInt421 < int_3) {
                return;
              }

              anInt421 = (int_3 + int_3) - 1 - anInt421;
              anInt420 = -anInt420;
              if (--anInt418 == 0) {
                break;
              }

              int_6 = method743(ints_0, int_6, int_2, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
              if (anInt421 >= int_2) {
                return;
              }

              anInt421 = (int_2 + int_2) - 1 - anInt421;
              anInt420 = -anInt420;
            } while (--anInt418 != 0);
          }
        } else {
          int int_7;
          if (anInt420 < 0) {
            while (true) {
              int_6 = method743(ints_0, int_6, int_2, int_1,
                  aclass5_sub1_0.aByteArray18[anInt425 - 1]);
              if (anInt421 >= int_2) {
                return;
              }

              int_7 = (int_3 - 1 - anInt421) / int_5;
              if (int_7 >= anInt418) {
                anInt421 += int_5 * anInt418;
                anInt418 = 0;
                break;
              }

              anInt421 += int_5 * int_7;
              anInt418 -= int_7;
            }
          } else {
            while (true) {
              int_6 = method746(ints_0, int_6, int_3, int_1, aclass5_sub1_0.aByteArray18[anInt423]);
              if (anInt421 < int_3) {
                return;
              }

              int_7 = (anInt421 - int_2) / int_5;
              if (int_7 >= anInt418) {
                anInt421 -= int_5 * anInt418;
                anInt418 = 0;
                break;
              }

              anInt421 -= int_5 * int_7;
              anInt418 -= int_7;
            }
          }
        }
      }

      if (anInt420 < 0) {
        method743(ints_0, int_6, 0, int_1, 0);
        if (anInt421 < 0) {
          anInt421 = -1;
          method739();
          unlink();
        }
      } else {
        method746(ints_0, int_6, int_4, int_1, 0);
        if (anInt421 >= int_4) {
          anInt421 = int_4;
          method739();
          unlink();
          return;
        }
      }

    }
  }

  @Override
  public synchronized void method633(int int_0) {
    if (anInt419 > 0) {
      if (int_0 >= anInt419) {
        if (anInt416 == Integer.MIN_VALUE) {
          anInt416 = 0;
          anInt424 = 0;
          anInt422 = 0;
          anInt417 = 0;
          unlink();
          int_0 = anInt419;
        }

        anInt419 = 0;
        method735();
      } else {
        anInt417 += anInt426 * int_0;
        anInt422 += anInt427 * int_0;
        anInt424 += anInt428 * int_0;
        anInt419 -= int_0;
      }
    }

    final AClass5_Sub1 aclass5_sub1_0 = (AClass5_Sub1) anAClass5_1;
    final int int_1 = anInt423 << 8;
    final int int_2 = anInt425 << 8;
    final int int_3 = aclass5_sub1_0.aByteArray18.length << 8;
    final int int_4 = int_2 - int_1;
    if (int_4 <= 0) {
      anInt418 = 0;
    }

    if (anInt421 < 0) {
      if (anInt420 <= 0) {
        method739();
        unlink();
        return;
      }

      anInt421 = 0;
    }

    if (anInt421 >= int_3) {
      if (anInt420 >= 0) {
        method739();
        unlink();
        return;
      }

      anInt421 = int_3 - 1;
    }

    anInt421 += anInt420 * int_0;
    if (anInt418 < 0) {
      if (!aBool51) {
        if (anInt420 < 0) {
          if (anInt421 < int_1) {
            anInt421 = int_2 - 1 - (int_2 - 1 - anInt421) % int_4;
          }
        } else if (anInt421 >= int_2) {
          anInt421 = int_1 + (anInt421 - int_1) % int_4;
        }
      } else {
        if (anInt420 < 0) {
          if (anInt421 >= int_1) {
            return;
          }

          anInt421 = (int_1 + int_1) - 1 - anInt421;
          anInt420 = -anInt420;
        }

        while (anInt421 >= int_2) {
          anInt421 = (int_2 + int_2) - 1 - anInt421;
          anInt420 = -anInt420;
          if (anInt421 >= int_1) {
            return;
          }

          anInt421 = (int_1 + int_1) - 1 - anInt421;
          anInt420 = -anInt420;
        }

      }
    } else {
      if (anInt418 > 0) {
        if (aBool51) {
          label131:
          {
            if (anInt420 < 0) {
              if (anInt421 >= int_1) {
                return;
              }

              anInt421 = (int_1 + int_1) - 1 - anInt421;
              anInt420 = -anInt420;
              if (--anInt418 == 0) {
                break label131;
              }
            }

            do {
              if (anInt421 < int_2) {
                return;
              }

              anInt421 = (int_2 + int_2) - 1 - anInt421;
              anInt420 = -anInt420;
              if (--anInt418 == 0) {
                break;
              }

              if (anInt421 >= int_1) {
                return;
              }

              anInt421 = (int_1 + int_1) - 1 - anInt421;
              anInt420 = -anInt420;
            } while (--anInt418 != 0);
          }
        } else {
          int int_5;
          if (anInt420 < 0) {
            if (anInt421 >= int_1) {
              return;
            }

            int_5 = (int_2 - 1 - anInt421) / int_4;
            if (int_5 < anInt418) {
              anInt421 += int_4 * int_5;
              anInt418 -= int_5;
              return;
            }

            anInt421 += int_4 * anInt418;
            anInt418 = 0;
          } else {
            if (anInt421 < int_2) {
              return;
            }

            int_5 = (anInt421 - int_1) / int_4;
            if (int_5 < anInt418) {
              anInt421 -= int_4 * int_5;
              anInt418 -= int_5;
              return;
            }

            anInt421 -= int_4 * anInt418;
            anInt418 = 0;
          }
        }
      }

      if (anInt420 < 0) {
        if (anInt421 < 0) {
          anInt421 = -1;
          method739();
          unlink();
          return;
        }
      } else if (anInt421 >= int_3) {
        anInt421 = int_3;
        method739();
        unlink();
        return;
      }

    }
  }

  public synchronized void method734(int int_0) {
    final int int_1 = ((AClass5_Sub1) anAClass5_1).aByteArray18.length << 8;
    if (int_0 < -1) {
      int_0 = -1;
    }

    if (int_0 > int_1) {
      int_0 = int_1;
    }

    anInt421 = int_0;
  }

  void method735() {
    anInt417 = anInt416;
    anInt422 = method750(anInt416, anInt415);
    anInt424 = method751(anInt416, anInt415);
  }

  @Override
  public AClass4 method635() {
    return null;
  }

  public boolean method736() {
    return anInt421 < 0 || anInt421 >= ((AClass5_Sub1) anAClass5_1).aByteArray18.length << 8;
  }

  public synchronized void method737(final int int_0) {
    if (anInt420 < 0) {
      anInt420 = -int_0;
    } else {
      anInt420 = int_0;
    }
  }

  public synchronized void method738(int int_0) {
    if (int_0 == 0) {
      method731(0);
      unlink();
    } else if (anInt422 == 0 && anInt424 == 0) {
      anInt419 = 0;
      anInt416 = 0;
      anInt417 = 0;
      unlink();
    } else {
      int int_1 = -anInt417;
      if (anInt417 > int_1) {
        int_1 = anInt417;
      }

      if (-anInt422 > int_1) {
        int_1 = -anInt422;
      }

      if (anInt422 > int_1) {
        int_1 = anInt422;
      }

      if (-anInt424 > int_1) {
        int_1 = -anInt424;
      }

      if (anInt424 > int_1) {
        int_1 = anInt424;
      }

      if (int_0 > int_1) {
        int_0 = int_1;
      }

      anInt419 = int_0;
      anInt416 = Integer.MIN_VALUE;
      anInt426 = -anInt417 / int_0;
      anInt427 = -anInt422 / int_0;
      anInt428 = -anInt424 / int_0;
    }
  }

  void method739() {
    if (anInt419 != 0) {
      if (anInt416 == Integer.MIN_VALUE) {
        anInt416 = 0;
      }

      anInt419 = 0;
      method735();
    }

  }

  public boolean method740() {
    return anInt419 != 0;
  }

  public synchronized void method741() {
    anInt420 = (anInt420 ^ anInt420 >> 31) + (anInt420 >>> 31);
    anInt420 = -anInt420;
  }

  @Override
  public AClass4 method636() {
    return null;
  }

  @Override
  public int method637() {
    int int_0 = anInt417 * 3 >> 6;
    int_0 = (int_0 ^ int_0 >> 31) + (int_0 >>> 31);
    if (anInt418 == 0) {
      int_0 -= int_0 * anInt421 / (((AClass5_Sub1) anAClass5_1).aByteArray18.length << 8);
    } else if (anInt418 >= 0) {
      int_0 -= int_0 * anInt423 / ((AClass5_Sub1) anAClass5_1).aByteArray18.length;
    }

    return int_0 > 255 ? 255 : int_0;
  }

  public synchronized int method742() {
    return anInt420 < 0 ? -anInt420 : anInt420;
  }

  int method743(final int[] ints_0, int int_0, final int int_1, final int int_2, final int int_3) {
    while (true) {
      if (anInt419 > 0) {
        int int_4 = int_0 + anInt419;
        if (int_4 > int_2) {
          int_4 = int_2;
        }

        anInt419 += int_0;
        if (anInt420 == -256 && (anInt421 & 0xFF) == 0) {
          if (Class56.stereo) {
            int_0 = method767(0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
                anInt422, anInt424, anInt427, anInt428, 0, int_4, int_1, this);
          } else {
            int_0 = method763(((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
                anInt417,
                anInt426, 0, int_4, int_1, this);
          }
        } else if (Class56.stereo) {
          int_0 = method765(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421,
              int_0,
              anInt422, anInt424, anInt427, anInt428, 0, int_4, int_1, this, anInt420, int_3);
        } else {
          int_0 = method761(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421,
              int_0,
              anInt417, anInt426, 0, int_4, int_1, this, anInt420, int_3);
        }

        anInt419 -= int_0;
        if (anInt419 != 0) {
          return int_0;
        }

        if (!method745()) {
          continue;
        }

        return int_2;
      }

      if (anInt420 == -256 && (anInt421 & 0xFF) == 0) {
        if (Class56.stereo) {
          return method759(0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
              anInt422,
              anInt424, 0, int_2, int_1, this);
        }

        return method756(((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
            anInt417, 0, int_2,
            int_1, this);
      }

      if (Class56.stereo) {
        return method757(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
            anInt422,
            anInt424, 0, int_2, int_1, this, anInt420, int_3);
      }

      return method753(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
          anInt417, 0,
          int_2, int_1, this, anInt420, int_3);
    }
  }

  public synchronized int method744() {
    return anInt416 == Integer.MIN_VALUE ? 0 : anInt416;
  }

  boolean method745() {
    int int_0 = anInt416;
    int int_1;
    int int_2;
    if (int_0 == Integer.MIN_VALUE) {
      int_1 = 0;
      int_2 = 0;
      int_0 = 0;
    } else {
      int_2 = method750(int_0, anInt415);
      int_1 = method751(int_0, anInt415);
    }

    if (int_0 == anInt417 && int_2 == anInt422 && int_1 == anInt424) {
      if (anInt416 == Integer.MIN_VALUE) {
        anInt416 = 0;
        anInt424 = 0;
        anInt422 = 0;
        anInt417 = 0;
        unlink();
        return true;
      }
      method735();
      return false;
    }
    if (anInt417 < int_0) {
      anInt426 = 1;
      anInt419 = int_0 - anInt417;
    } else if (anInt417 > int_0) {
      anInt426 = -1;
      anInt419 = anInt417 - int_0;
    } else {
      anInt426 = 0;
    }

    if (anInt422 < int_2) {
      anInt427 = 1;
      if (anInt419 == 0 || anInt419 > int_2 - anInt422) {
        anInt419 = int_2 - anInt422;
      }
    } else if (anInt422 > int_2) {
      anInt427 = -1;
      if (anInt419 == 0 || anInt419 > anInt422 - int_2) {
        anInt419 = anInt422 - int_2;
      }
    } else {
      anInt427 = 0;
    }

    if (anInt424 < int_1) {
      anInt428 = 1;
      if (anInt419 == 0 || anInt419 > int_1 - anInt424) {
        anInt419 = int_1 - anInt424;
      }
    } else if (anInt424 > int_1) {
      anInt428 = -1;
      if (anInt419 == 0 || anInt419 > anInt424 - int_1) {
        anInt419 = anInt424 - int_1;
      }
    } else {
      anInt428 = 0;
    }

    return false;
  }

  int method746(final int[] ints_0, int int_0, final int int_1, final int int_2, final int int_3) {
    while (true) {
      if (anInt419 > 0) {
        int int_4 = int_0 + anInt419;
        if (int_4 > int_2) {
          int_4 = int_2;
        }

        anInt419 += int_0;
        if (anInt420 == 256 && (anInt421 & 0xFF) == 0) {
          if (Class56.stereo) {
            int_0 = method766(0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
                anInt422, anInt424, anInt427, anInt428, 0, int_4, int_1, this);
          } else {
            int_0 = method762(((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
                anInt417,
                anInt426, 0, int_4, int_1, this);
          }
        } else if (Class56.stereo) {
          int_0 = method764(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421,
              int_0,
              anInt422, anInt424, anInt427, anInt428, 0, int_4, int_1, this, anInt420, int_3);
        } else {
          int_0 = method760(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421,
              int_0,
              anInt417, anInt426, 0, int_4, int_1, this, anInt420, int_3);
        }

        anInt419 -= int_0;
        if (anInt419 != 0) {
          return int_0;
        }

        if (!method745()) {
          continue;
        }

        return int_2;
      }

      if (anInt420 == 256 && (anInt421 & 0xFF) == 0) {
        if (Class56.stereo) {
          return method758(0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
              anInt422,
              anInt424, 0, int_2, int_1, this);
        }

        return method754(((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
            anInt417, 0, int_2,
            int_1, this);
      }

      if (Class56.stereo) {
        return method755(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
            anInt422,
            anInt424, 0, int_2, int_1, this, anInt420, int_3);
      }

      return method752(0, 0, ((AClass5_Sub1) anAClass5_1).aByteArray18, ints_0, anInt421, int_0,
          anInt417, 0,
          int_2, int_1, this, anInt420, int_3);
    }
  }

  public synchronized void method747(final int int_0) {
    anInt418 = int_0;
  }

  @Override
  public int method638() {
    return anInt416 == 0 && anInt419 == 0 ? 0 : 1;
  }

  public synchronized void method748(final int int_0, final int int_1) {
    method733(int_0, int_1, method730());
  }

  public synchronized void method749(final int int_0) {
    method732(int_0 << 6, method730());
  }

}
