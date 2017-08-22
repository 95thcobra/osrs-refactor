package jagex.oldschool;

import jagex.oldschool.config.ObjectConfig;

public class Class54 {

  static int anInt130;
  int[][] anIntArrayArray9;
  int anInt131;
  int anInt132;

  public Class54(int int_0, int int_1) {
    if (int_1 != int_0) {
      final int int_2 = CombatInfo1.method666(int_0, int_1);
      int_0 /= int_2;
      int_1 /= int_2;
      anInt132 = int_0;
      anInt131 = int_1;
      anIntArrayArray9 = new int[int_0][14];

      for (int int_3 = 0; int_3 < int_0; int_3++) {
        final int[] ints_0 = anIntArrayArray9[int_3];
        final double double_0 = (double) int_3 / (double) int_0 + 6.0D;
        int int_4 = (int) Math.floor(1.0D + (double_0 - 7.0D));
        if (int_4 < 0) {
          int_4 = 0;
        }

        int int_5 = (int) Math.ceil(double_0 + 7.0D);
        if (int_5 > 14) {
          int_5 = 14;
        }

        for (final double double_1 = (double) int_1 / (double) int_0; int_4 < int_5; int_4++) {
          final double double_2 = 3.141592653589793D * (int_4 - double_0);
          double double_3 = double_1;
          if (double_2 < -1.0E-4D || double_2 > 1.0E-4D) {
            double_3 = double_1 * (Math.sin(double_2) / double_2);
          }

          double_3 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * (int_4 - double_0));
          ints_0[int_4] = (int) Math.floor(double_3 * 65536.0D + 0.5D);
        }
      }

    }
  }

  public static void method349() {
    ObjectConfig.objects.reset();
    ObjectConfig.aNodeCache9.reset();
    ObjectConfig.cachedModels.reset();
    ObjectConfig.aNodeCache8.reset();
  }

  byte[] method346(byte[] bytes_0) {
    if (anIntArrayArray9 != null) {
      final int int_0 = (int) ((long) anInt131 * (long) bytes_0.length / anInt132) + 14;
      final int[] ints_0 = new int[int_0];
      int int_1 = 0;
      int int_2 = 0;

      int int_3;
      for (int_3 = 0; int_3 < bytes_0.length; int_3++) {
        final byte byte_0 = bytes_0[int_3];
        final int[] ints_1 = anIntArrayArray9[int_2];

        int int_4;
        for (int_4 = 0; int_4 < 14; int_4++) {
          ints_0[int_1 + int_4] += byte_0 * ints_1[int_4];
        }

        int_2 += anInt131;
        int_4 = int_2 / anInt132;
        int_1 += int_4;
        int_2 -= int_4 * anInt132;
      }

      bytes_0 = new byte[int_0];

      for (int_3 = 0; int_3 < int_0; int_3++) {
        final int int_5 = ints_0[int_3] + 32768 >> 16;
        if (int_5 < -128) {
          bytes_0[int_3] = -128;
        } else if (int_5 > 127) {
          bytes_0[int_3] = 127;
        } else {
          bytes_0[int_3] = (byte) int_5;
        }
      }
    }

    return bytes_0;
  }

  int method347(int int_0) {
    if (anIntArrayArray9 != null) {
      int_0 = (int) ((long) int_0 * (long) anInt131 / anInt132);
    }

    return int_0;
  }

  int method348(int int_0) {
    if (anIntArrayArray9 != null) {
      int_0 = (int) ((long) int_0 * (long) anInt131 / anInt132) + 6;
    }

    return int_0;
  }

}
