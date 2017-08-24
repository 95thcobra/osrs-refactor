package jagex.oldschool.scene;

public final class ShapedSquare {

  static final int[][] anIntArrayArray12;
  static final int[][] anIntArrayArray13;
  static int[] sx;
  static int[] sy;
  static int[] vertexSceneX;
  static int[] vertexSceneY;
  static int[] vertexSceneZ;

  static {
    sx = new int[6];
    sy = new int[6];
    vertexSceneX = new int[6];
    vertexSceneY = new int[6];
    vertexSceneZ = new int[6];
    anIntArrayArray12 = new int[][] {
        {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6},
        {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8},
        {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}
    };
    anIntArrayArray13 = new int[][] {
        {0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3},
        {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3},
        {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4},
        {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3},
        {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5},
        {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5},
        {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3},
        {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3},
        {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}
    };
  }

  int[] vx;
  boolean flatShade;
  int[] v0;
  int[] vy;
  int configuration;
  int orientation;
  int[] v1;
  int underlay;
  int[] vz;
  int[] v2;
  int overlay;
  int[] triangleTextureId;
  int[] triangleColorA;
  int[] triangleColorB;
  int[] triangleColorC;

  ShapedSquare(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4, final int int_5,
      final int int_6, final int int_7, final int int_8, final int int_9, final int int_10,
      final int int_11,
      final int int_12, final int int_13, final int int_14, final int int_15, final int int_16,
      final int int_17,
      final int int_18) {
    flatShade = true;
    if (int_6 != int_5 || int_7 != int_5 || int_8 != int_5) {
      flatShade = false;
    }

    configuration = int_0;
    orientation = int_1;
    underlay = int_17;
    overlay = int_18;
    final short short_0 = 128;
    final int int_19 = short_0 / 2;
    final int int_20 = short_0 / 4;
    final int int_21 = short_0 * 3 / 4;
    final int[] ints_0 = anIntArrayArray12[int_0];
    final int int_22 = ints_0.length;
    vx = new int[int_22];
    vy = new int[int_22];
    vz = new int[int_22];
    final int[] ints_1 = new int[int_22];
    final int[] ints_2 = new int[int_22];
    final int int_23 = short_0 * int_3;
    final int int_24 = int_4 * short_0;

    int int_26;
    int int_27;
    int int_28;
    int int_29;
    int int_30;
    int int_31;
    for (int int_25 = 0; int_25 < int_22; int_25++) {
      int_26 = ints_0[int_25];
      if ((int_26 & 0x1) == 0 && int_26 <= 8) {
        int_26 = (int_26 - int_1 - int_1 - 1 & 0x7) + 1;
      }

      if (int_26 > 8 && int_26 <= 12) {
        int_26 = (int_26 - 9 - int_1 & 0x3) + 9;
      }

      if (int_26 > 12 && int_26 <= 16) {
        int_26 = (int_26 - 13 - int_1 & 0x3) + 13;
      }

      if (int_26 == 1) {
        int_27 = int_23;
        int_28 = int_24;
        int_29 = int_5;
        int_30 = int_9;
        int_31 = int_13;
      } else if (int_26 == 2) {
        int_27 = int_23 + int_19;
        int_28 = int_24;
        int_29 = int_6 + int_5 >> 1;
        int_30 = int_10 + int_9 >> 1;
        int_31 = int_14 + int_13 >> 1;
      } else if (int_26 == 3) {
        int_27 = int_23 + short_0;
        int_28 = int_24;
        int_29 = int_6;
        int_30 = int_10;
        int_31 = int_14;
      } else if (int_26 == 4) {
        int_27 = int_23 + short_0;
        int_28 = int_24 + int_19;
        int_29 = int_7 + int_6 >> 1;
        int_30 = int_10 + int_11 >> 1;
        int_31 = int_14 + int_15 >> 1;
      } else if (int_26 == 5) {
        int_27 = int_23 + short_0;
        int_28 = int_24 + short_0;
        int_29 = int_7;
        int_30 = int_11;
        int_31 = int_15;
      } else if (int_26 == 6) {
        int_27 = int_23 + int_19;
        int_28 = int_24 + short_0;
        int_29 = int_7 + int_8 >> 1;
        int_30 = int_12 + int_11 >> 1;
        int_31 = int_16 + int_15 >> 1;
      } else if (int_26 == 7) {
        int_27 = int_23;
        int_28 = int_24 + short_0;
        int_29 = int_8;
        int_30 = int_12;
        int_31 = int_16;
      } else if (int_26 == 8) {
        int_27 = int_23;
        int_28 = int_24 + int_19;
        int_29 = int_8 + int_5 >> 1;
        int_30 = int_12 + int_9 >> 1;
        int_31 = int_16 + int_13 >> 1;
      } else if (int_26 == 9) {
        int_27 = int_23 + int_19;
        int_28 = int_24 + int_20;
        int_29 = int_6 + int_5 >> 1;
        int_30 = int_10 + int_9 >> 1;
        int_31 = int_14 + int_13 >> 1;
      } else if (int_26 == 10) {
        int_27 = int_23 + int_21;
        int_28 = int_24 + int_19;
        int_29 = int_7 + int_6 >> 1;
        int_30 = int_10 + int_11 >> 1;
        int_31 = int_14 + int_15 >> 1;
      } else if (int_26 == 11) {
        int_27 = int_23 + int_19;
        int_28 = int_24 + int_21;
        int_29 = int_7 + int_8 >> 1;
        int_30 = int_12 + int_11 >> 1;
        int_31 = int_16 + int_15 >> 1;
      } else if (int_26 == 12) {
        int_27 = int_23 + int_20;
        int_28 = int_24 + int_19;
        int_29 = int_8 + int_5 >> 1;
        int_30 = int_12 + int_9 >> 1;
        int_31 = int_16 + int_13 >> 1;
      } else if (int_26 == 13) {
        int_27 = int_23 + int_20;
        int_28 = int_24 + int_20;
        int_29 = int_5;
        int_30 = int_9;
        int_31 = int_13;
      } else if (int_26 == 14) {
        int_27 = int_23 + int_21;
        int_28 = int_24 + int_20;
        int_29 = int_6;
        int_30 = int_10;
        int_31 = int_14;
      } else if (int_26 == 15) {
        int_27 = int_23 + int_21;
        int_28 = int_24 + int_21;
        int_29 = int_7;
        int_30 = int_11;
        int_31 = int_15;
      } else {
        int_27 = int_23 + int_20;
        int_28 = int_24 + int_21;
        int_29 = int_8;
        int_30 = int_12;
        int_31 = int_16;
      }

      vx[int_25] = int_27;
      vy[int_25] = int_29;
      vz[int_25] = int_28;
      ints_1[int_25] = int_30;
      ints_2[int_25] = int_31;
    }

    final int[] ints_3 = anIntArrayArray13[int_0];
    int_26 = ints_3.length / 4;
    v0 = new int[int_26];
    v1 = new int[int_26];
    v2 = new int[int_26];
    triangleColorA = new int[int_26];
    triangleColorB = new int[int_26];
    triangleColorC = new int[int_26];
    if (int_2 != -1) {
      triangleTextureId = new int[int_26];
    }

    int_27 = 0;

    for (int_28 = 0; int_28 < int_26; int_28++) {
      int_29 = ints_3[int_27];
      int_30 = ints_3[int_27 + 1];
      int_31 = ints_3[int_27 + 2];
      int int_32 = ints_3[int_27 + 3];
      int_27 += 4;
      if (int_30 < 4) {
        int_30 = int_30 - int_1 & 0x3;
      }

      if (int_31 < 4) {
        int_31 = int_31 - int_1 & 0x3;
      }

      if (int_32 < 4) {
        int_32 = int_32 - int_1 & 0x3;
      }

      v0[int_28] = int_30;
      v1[int_28] = int_31;
      v2[int_28] = int_32;
      if (int_29 == 0) {
        triangleColorA[int_28] = ints_1[int_30];
        triangleColorB[int_28] = ints_1[int_31];
        triangleColorC[int_28] = ints_1[int_32];
        if (triangleTextureId != null) {
          triangleTextureId[int_28] = -1;
        }
      } else {
        triangleColorA[int_28] = ints_2[int_30];
        triangleColorB[int_28] = ints_2[int_31];
        triangleColorC[int_28] = ints_2[int_32];
        if (triangleTextureId != null) {
          triangleTextureId[int_28] = int_2;
        }
      }
    }

    int_28 = int_5;
    int_29 = int_6;
    if (int_6 < int_5) {
      int_28 = int_6;
    }

    if (int_6 > int_6) {
      int_29 = int_6;
    }

    if (int_7 < int_28) {
      int_28 = int_7;
    }

    if (int_7 > int_29) {
      int_29 = int_7;
    }

    if (int_8 < int_28) {
      int_28 = int_8;
    }

    if (int_8 > int_29) {
      int_29 = int_8;
    }

    int_28 /= 14;
    int_29 /= 14;
  }

}
