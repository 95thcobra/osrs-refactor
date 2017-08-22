package jagex.oldschool;

import jagex.oldschool.graphics.Rasterizer2d;

public class Class14 {

  public static RenderOverview renderOverview;
  byte[][][] aByteArrayArrayArray3;
  int anInt61;

  Class14(final int int_0) {
    anInt61 = int_0;
  }

  void method178() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    int int_0 = 0;

    int int_1;
    int int_2;
    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[0][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[0][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 >= int_1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[0][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 >= int_1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[0][3] = bytes_0;
  }

  int method179(int int_0, final int int_1) {
    if (int_1 == 9) {
      int_0 = int_0 + 1 & 0x3;
    }

    if (int_1 == 10) {
      int_0 = int_0 + 3 & 0x3;
    }

    if (int_1 == 11) {
      int_0 = int_0 + 3 & 0x3;
    }

    return int_0;
  }

  void method180() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    int int_0 = 0;

    int int_1;
    int int_2;
    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[1][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_0 >= 0 && int_0 < bytes_0.length) {
          if (int_2 >= int_1 << 1) {
            bytes_0[int_0] = -1;
          }

          ++int_0;
        } else {
          ++int_0;
        }
      }
    }

    aByteArrayArrayArray3[1][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 <= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[1][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 >= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[1][3] = bytes_0;
  }

  int method181(final int int_0) {
    return int_0 != 9 && int_0 != 10 ? int_0 == 11 ? 8 : int_0 : 1;
  }

  void method182() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    int int_0 = 0;

    int int_1;
    int int_2;
    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 <= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[2][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 >= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[2][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[2][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 >= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[2][3] = bytes_0;
  }

  void method183() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    int int_0 = 0;

    int int_1;
    int int_2;
    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 >= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[3][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[3][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 >= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[3][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 <= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[3][3] = bytes_0;
  }

  void method184() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    int int_0 = 0;

    int int_1;
    int int_2;
    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 >= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[4][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 <= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[4][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = 0; int_2 < anInt61; int_2++) {
        if (int_2 >= int_1 >> 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[4][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_0 = 0;

    for (int_1 = 0; int_1 < anInt61; int_1++) {
      for (int_2 = anInt61 - 1; int_2 >= 0; --int_2) {
        if (int_2 <= int_1 << 1) {
          bytes_0[int_0] = -1;
        }

        ++int_0;
      }
    }

    aByteArrayArrayArray3[4][3] = bytes_0;
  }

  void method185() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    bytes_0 = new byte[anInt61 * anInt61];
    int int_2 = 0;

    int int_0;
    int int_1;
    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 <= anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[5][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_0 <= anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[5][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 >= anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[5][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_0 >= anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[5][3] = bytes_0;
  }

  void method186() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    bytes_0 = new byte[anInt61 * anInt61];
    int int_2 = 0;

    int int_0;
    int int_1;
    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 <= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[6][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = anInt61 - 1; int_0 >= 0; --int_0) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 <= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[6][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = anInt61 - 1; int_0 >= 0; --int_0) {
      for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
        if (int_1 <= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[6][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
        if (int_1 <= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[6][3] = bytes_0;
  }

  void method187(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4, final int int_5,
      int int_6, int int_7) {
    if (int_6 != 0 && anInt61 != 0) {
      if (aByteArrayArrayArray3 != null) {
        int_7 = method179(int_7, int_6);
        int_6 = method181(int_6);
        Rasterizer2d.method882(int_0, int_1, int_4, int_5, int_2, int_3,
            aByteArrayArrayArray3[int_6 - 1][int_7], anInt61);
      }
    }
  }

  void method188() {
    byte[] bytes_0 = new byte[anInt61 * anInt61];
    bytes_0 = new byte[anInt61 * anInt61];
    int int_2 = 0;

    int int_0;
    int int_1;
    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 >= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[7][0] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = anInt61 - 1; int_0 >= 0; --int_0) {
      for (int_1 = 0; int_1 < anInt61; int_1++) {
        if (int_1 >= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[7][1] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = anInt61 - 1; int_0 >= 0; --int_0) {
      for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
        if (int_1 >= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[7][2] = bytes_0;
    bytes_0 = new byte[anInt61 * anInt61];
    int_2 = 0;

    for (int_0 = 0; int_0 < anInt61; int_0++) {
      for (int_1 = anInt61 - 1; int_1 >= 0; --int_1) {
        if (int_1 >= int_0 - anInt61 / 2) {
          bytes_0[int_2] = -1;
        }

        ++int_2;
      }
    }

    aByteArrayArrayArray3[7][3] = bytes_0;
  }

  void method189() {
    if (aByteArrayArrayArray3 == null) {
      aByteArrayArrayArray3 = new byte[8][4][];
      method178();
      method180();
      method182();
      method183();
      method184();
      method185();
      method186();
      method188();
    }
  }

}
