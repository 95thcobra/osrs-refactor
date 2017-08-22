package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.security.Isaac;

public class Node_Sub2 extends Node {

  static boolean aBool44;
  static byte[] payload;
  static int position;
  static int bitPosition;
  static CodeBook[] codeBooks;
  static int blockSize1;
  static int[] modeMappings;
  static int blockSize0;
  static float[] aFloatArray2;
  static boolean[] modeBlockFlags;
  static float[] aFloatArray3;
  static float[] aFloatArray4;
  static Mapping[] mappings;
  static float[] aFloatArray5;
  static float[] aFloatArray6;
  static float[] aFloatArray7;
  static float[] aFloatArray8;
  static Floor[] floors;
  static int[] anIntArray79;
  static int[] anIntArray80;
  static Residue[] residues;

  static {
    aBool44 = false;
  }

  byte[][] aByteArrayArray7;
  byte[] aByteArray11;
  int anInt322;
  int anInt323;
  int anInt324;
  float[] aFloatArray9;
  int anInt325;
  int anInt326;
  int anInt327;
  int anInt328;
  boolean aBool45;
  boolean aBool46;
  int anInt329;

  Node_Sub2(final byte[] bytes_0) {
    decode(bytes_0);
  }

  static int getBit() {
    final int int_0 = payload[position] >> bitPosition & 0x1;
    ++bitPosition;
    position += bitPosition >> 3;
    bitPosition &= 0x7;
    return int_0;
  }

  static void setBytes(final byte[] bytes_0, final int int_0) {
    payload = bytes_0;
    position = int_0;
    bitPosition = 0;
  }

  static int get(int int_0) {
    int int_1 = 0;

    int int_2;
    int int_3;
    for (int_2 = 0; int_0 >= 8 - bitPosition; int_0 -= int_3) {
      int_3 = 8 - bitPosition;
      final int int_4 = (1 << int_3) - 1;
      int_1 += (payload[position] >> bitPosition & int_4) << int_2;
      bitPosition = 0;
      ++position;
      int_2 += int_3;
    }

    if (int_0 > 0) {
      int_3 = (1 << int_0) - 1;
      int_1 += (payload[position] >> bitPosition & int_3) << int_2;
      bitPosition += int_0;
    }

    return int_1;
  }

  static boolean method645(final AbstractPackage indexdatabase_0) {
    if (!aBool44) {
      final byte[] bytes_0 = indexdatabase_0.get(0, 0);
      if (bytes_0 == null) {
        return false;
      }

      method647(bytes_0);
      aBool44 = true;
    }

    return true;
  }

  static Node_Sub2 method646(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1) {
    if (!method645(indexdatabase_0)) {
      indexdatabase_0.method450(int_0, int_1);
      return null;
    }
    final byte[] bytes_0 = indexdatabase_0.get(int_0, int_1);
    return bytes_0 == null ? null : new Node_Sub2(bytes_0);
  }

  static void method647(final byte[] bytes_0) {
    setBytes(bytes_0, 0);
    blockSize0 = 1 << get(4);
    blockSize1 = 1 << get(4);
    aFloatArray2 = new float[blockSize1];

    int int_0;
    int int_1;
    int int_2;
    int int_3;
    int int_4;
    for (int_0 = 0; int_0 < 2; int_0++) {
      int_1 = int_0 != 0 ? blockSize1 : blockSize0;
      int_2 = int_1 >> 1;
      int_3 = int_1 >> 2;
      int_4 = int_1 >> 3;
      final float[] floats_0 = new float[int_2];

      for (int int_5 = 0; int_5 < int_3; int_5++) {
        floats_0[int_5 * 2] = (float) Math.cos(int_5 * 4 * 3.141592653589793D / int_1);
        floats_0[int_5 * 2 + 1] = -((float) Math.sin(int_5 * 4 * 3.141592653589793D / int_1));
      }

      final float[] floats_1 = new float[int_2];

      for (int int_6 = 0; int_6 < int_3; int_6++) {
        floats_1[int_6 * 2] = (float) Math
            .cos((int_6 * 2 + 1) * 3.141592653589793D / (int_1 * 2));
        floats_1[int_6 * 2 + 1] = (float) Math
            .sin((int_6 * 2 + 1) * 3.141592653589793D / (int_1 * 2));
      }

      final float[] floats_2 = new float[int_3];

      for (int int_7 = 0; int_7 < int_4; int_7++) {
        floats_2[int_7 * 2] = (float) Math.cos((int_7 * 4 + 2) * 3.141592653589793D / int_1);
        floats_2[int_7 * 2 + 1] = -((float) Math
            .sin((int_7 * 4 + 2) * 3.141592653589793D / int_1));
      }

      final int[] ints_0 = new int[int_4];
      final int int_8 = Isaac.log(int_4 - 1);

      for (int int_9 = 0; int_9 < int_4; int_9++) {
        ints_0[int_9] = Class56.method364(int_9, int_8);
      }

      if (int_0 != 0) {
        aFloatArray3 = floats_0;
        aFloatArray6 = floats_1;
        aFloatArray8 = floats_2;
        anIntArray80 = ints_0;
      } else {
        aFloatArray4 = floats_0;
        aFloatArray5 = floats_1;
        aFloatArray7 = floats_2;
        anIntArray79 = ints_0;
      }
    }

    int_0 = get(8) + 1;
    codeBooks = new CodeBook[int_0];

    for (int_1 = 0; int_1 < int_0; int_1++) {
      codeBooks[int_1] = new CodeBook();
    }

    int_1 = get(6) + 1;

    for (int_2 = 0; int_2 < int_1; int_2++) {
      get(16);
    }

    int_1 = get(6) + 1;
    floors = new Floor[int_1];

    for (int_2 = 0; int_2 < int_1; int_2++) {
      floors[int_2] = new Floor();
    }

    int_2 = get(6) + 1;
    residues = new Residue[int_2];

    for (int_3 = 0; int_3 < int_2; int_3++) {
      residues[int_3] = new Residue();
    }

    int_3 = get(6) + 1;
    mappings = new Mapping[int_3];

    for (int_4 = 0; int_4 < int_3; int_4++) {
      mappings[int_4] = new Mapping();
    }

    int_4 = get(6) + 1;
    modeBlockFlags = new boolean[int_4];
    modeMappings = new int[int_4];

    for (int int_10 = 0; int_10 < int_4; int_10++) {
      modeBlockFlags[int_10] = getBit() != 0;
      get(16);
      get(16);
      modeMappings[int_10] = get(8);
    }

  }

  static float float32Unpack(final int int_0) {
    int int_1 = int_0 & 0x1FFFFF;
    final int int_2 = int_0 & 0x80000000;
    final int int_3 = (int_0 & 0x7FE00000) >> 21;
    if (int_2 != 0) {
      int_1 = -int_1;
    }

    return (float) (int_1 * Math.pow(2.0D, int_3 - 788));
  }

  void decode(final byte[] bytes_0) {
    final Buffer buffer_0 = new Buffer(bytes_0);
    anInt324 = buffer_0.getInt();
    anInt325 = buffer_0.getInt();
    anInt327 = buffer_0.getInt();
    anInt328 = buffer_0.getInt();
    if (anInt328 < 0) {
      anInt328 = ~anInt328;
      aBool45 = true;
    }

    final int int_0 = buffer_0.getInt();
    aByteArrayArray7 = new byte[int_0][];

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      int int_2 = 0;

      int int_3;
      do {
        int_3 = buffer_0.getUnsignedByte();
        int_2 += int_3;
      } while (int_3 >= 255);

      final byte[] bytes_1 = new byte[int_2];
      buffer_0.get(bytes_1, 0, int_2);
      aByteArrayArray7[int_1] = bytes_1;
    }

  }

  AClass5_Sub1 method643(final int[] ints_0) {
    if (ints_0 != null && ints_0[0] <= 0) {
      return null;
    }
    if (aByteArray11 == null) {
      anInt322 = 0;
      aFloatArray9 = new float[blockSize1];
      aByteArray11 = new byte[anInt325];
      anInt326 = 0;
      anInt323 = 0;
    }

    for (; anInt323 < aByteArrayArray7.length; anInt323++) {
      if (ints_0 != null && ints_0[0] <= 0) {
        return null;
      }

      final float[] floats_0 = method644(anInt323);
      if (floats_0 != null) {
        int int_0 = anInt326;
        int int_1 = floats_0.length;
        if (int_1 > anInt325 - int_0) {
          int_1 = anInt325 - int_0;
        }

        for (int int_2 = 0; int_2 < int_1; int_2++) {
          int int_3 = (int) (128.0F + floats_0[int_2] * 128.0F);
          if ((int_3 & 0xFFFFFF00) != 0) {
            int_3 = ~int_3 >> 31;
          }

          aByteArray11[int_0++] = (byte) (int_3 - 128);
        }

        if (ints_0 != null) {
          ints_0[0] -= int_0 - anInt326;
        }

        anInt326 = int_0;
      }
    }

    aFloatArray9 = null;
    final byte[] bytes_0 = aByteArray11;
    aByteArray11 = null;
    return new AClass5_Sub1(anInt324, bytes_0, anInt327, anInt328, aBool45);
  }

  float[] method644(final int int_0) {
    setBytes(aByteArrayArray7[int_0], 0);
    getBit();
    final int int_1 = get(Isaac.log(modeMappings.length - 1));
    final boolean bool_0 = modeBlockFlags[int_1];
    final int int_2 = bool_0 ? blockSize1 : blockSize0;
    boolean bool_1 = false;
    boolean bool_2 = false;
    if (bool_0) {
      bool_1 = getBit() != 0;
      bool_2 = getBit() != 0;
    }

    final int int_3 = int_2 >> 1;
    int int_4;
    int int_5;
    int int_6;
    if (bool_0 && !bool_1) {
      int_4 = (int_2 >> 2) - (blockSize0 >> 2);
      int_5 = (blockSize0 >> 2) + (int_2 >> 2);
      int_6 = blockSize0 >> 1;
    } else {
      int_4 = 0;
      int_5 = int_3;
      int_6 = int_2 >> 1;
    }

    int int_7;
    int int_8;
    int int_9;
    if (bool_0 && !bool_2) {
      int_7 = int_2 - (int_2 >> 2) - (blockSize0 >> 2);
      int_8 = (blockSize0 >> 2) + int_2 - (int_2 >> 2);
      int_9 = blockSize0 >> 1;
    } else {
      int_7 = int_3;
      int_8 = int_2;
      int_9 = int_2 >> 1;
    }

    final Mapping mapping_0 = mappings[modeMappings[int_1]];
    final int int_10 = mapping_0.mux;
    int int_11 = mapping_0.submapFloors[int_10];
    final boolean bool_3 = !floors[int_11].decodedFloor();
    final boolean bool_4 = bool_3;

    for (int_11 = 0; int_11 < mapping_0.anInt209; int_11++) {
      final Residue residue_0 = residues[mapping_0.anIntArray61[int_11]];
      final float[] floats_0 = aFloatArray2;
      residue_0.decodeResidue(floats_0, int_2 >> 1, bool_4);
    }

    int int_12;
    if (!bool_3) {
      int_11 = mapping_0.mux;
      int_12 = mapping_0.submapFloors[int_11];
      floors[int_12].computeFloor(aFloatArray2, int_2 >> 1);
    }

    int int_13;
    if (bool_3) {
      for (int_11 = int_2 >> 1; int_11 < int_2; int_11++) {
        aFloatArray2[int_11] = 0.0F;
      }
    } else {
      int_11 = int_2 >> 1;
      int_12 = int_2 >> 2;
      int_13 = int_2 >> 3;
      final float[] floats_2 = aFloatArray2;

      int int_15;
      for (int_15 = 0; int_15 < int_11; int_15++) {
        floats_2[int_15] *= 0.5F;
      }

      for (int_15 = int_11; int_15 < int_2; int_15++) {
        floats_2[int_15] = -floats_2[int_2 - int_15 - 1];
      }

      final float[] floats_3 = bool_0 ? aFloatArray3 : aFloatArray4;
      final float[] floats_4 = bool_0 ? aFloatArray6 : aFloatArray5;
      final float[] floats_5 = bool_0 ? aFloatArray8 : aFloatArray7;
      final int[] ints_0 = bool_0 ? anIntArray80 : anIntArray79;

      int int_16;
      float float_0;
      float float_1;
      float float_2;
      float float_3;
      for (int_16 = 0; int_16 < int_12; int_16++) {
        float_0 = floats_2[int_16 * 4] - floats_2[int_2 - int_16 * 4 - 1];
        float_1 = floats_2[int_16 * 4 + 2] - floats_2[int_2 - int_16 * 4 - 3];
        float_2 = floats_3[int_16 * 2];
        float_3 = floats_3[int_16 * 2 + 1];
        floats_2[int_2 - int_16 * 4 - 1] = float_0 * float_2 - float_1 * float_3;
        floats_2[int_2 - int_16 * 4 - 3] = float_0 * float_3 + float_1 * float_2;
      }

      float float_4;
      float float_5;
      for (int_16 = 0; int_16 < int_13; int_16++) {
        float_0 = floats_2[int_11 + int_16 * 4 + 3];
        float_1 = floats_2[int_11 + int_16 * 4 + 1];
        float_2 = floats_2[int_16 * 4 + 3];
        float_3 = floats_2[int_16 * 4 + 1];
        floats_2[int_11 + 3 + int_16 * 4] = float_0 + float_2;
        floats_2[int_11 + 1 + int_16 * 4] = float_1 + float_3;
        float_4 = floats_3[int_11 - 4 - int_16 * 4];
        float_5 = floats_3[int_11 - 3 - int_16 * 4];
        floats_2[int_16 * 4 + 3] =
            (float_0 - float_2) * float_4 - (float_1 - float_3) * float_5;
        floats_2[int_16 * 4 + 1] =
            (float_1 - float_3) * float_4 + (float_0 - float_2) * float_5;
      }

      int_16 = Isaac.log(int_2 - 1);

      int int_19;
      int int_20;
      int int_21;
      int int_22;
      for (int_19 = 0; int_19 < int_16 - 3; int_19++) {
        int_20 = int_2 >> int_19 + 2;
        int_21 = 8 << int_19;

        for (int_22 = 0; int_22 < 2 << int_19; int_22++) {
          final int int_23 = int_2 - int_20 * int_22 * 2;
          final int int_24 = int_2 - int_20 * (int_22 * 2 + 1);

          for (int int_17 = 0; int_17 < int_2 >> int_19 + 4; int_17++) {
            final int int_18 = int_17 * 4;
            final float float_6 = floats_2[int_23 - 1 - int_18];
            final float float_7 = floats_2[int_23 - 3 - int_18];
            final float float_8 = floats_2[int_24 - 1 - int_18];
            final float float_9 = floats_2[int_24 - 3 - int_18];
            floats_2[int_23 - 1 - int_18] = float_6 + float_8;
            floats_2[int_23 - 3 - int_18] = float_7 + float_9;
            final float float_10 = floats_3[int_17 * int_21];
            final float float_11 = floats_3[int_17 * int_21 + 1];
            floats_2[int_24 - 1 - int_18] = (float_6 - float_8) * float_10
                - (float_7 - float_9) * float_11;
            floats_2[int_24 - 3 - int_18] = (float_7 - float_9) * float_10
                + (float_6 - float_8) * float_11;
          }
        }
      }

      for (int_19 = 1; int_19 < int_13 - 1; int_19++) {
        int_20 = ints_0[int_19];
        if (int_19 < int_20) {
          int_21 = int_19 * 8;
          int_22 = int_20 * 8;
          float_4 = floats_2[int_21 + 1];
          floats_2[int_21 + 1] = floats_2[int_22 + 1];
          floats_2[int_22 + 1] = float_4;
          float_4 = floats_2[int_21 + 3];
          floats_2[int_21 + 3] = floats_2[int_22 + 3];
          floats_2[int_22 + 3] = float_4;
          float_4 = floats_2[int_21 + 5];
          floats_2[int_21 + 5] = floats_2[int_22 + 5];
          floats_2[int_22 + 5] = float_4;
          float_4 = floats_2[int_21 + 7];
          floats_2[int_21 + 7] = floats_2[int_22 + 7];
          floats_2[int_22 + 7] = float_4;
        }
      }

      for (int_19 = 0; int_19 < int_11; int_19++) {
        floats_2[int_19] = floats_2[int_19 * 2 + 1];
      }

      for (int_19 = 0; int_19 < int_13; int_19++) {
        floats_2[int_2 - 1 - int_19 * 2] = floats_2[int_19 * 4];
        floats_2[int_2 - 2 - int_19 * 2] = floats_2[int_19 * 4 + 1];
        floats_2[int_2 - int_12 - 1 - int_19 * 2] = floats_2[int_19 * 4 + 2];
        floats_2[int_2 - int_12 - 2 - int_19 * 2] = floats_2[int_19 * 4 + 3];
      }

      for (int_19 = 0; int_19 < int_13; int_19++) {
        float_1 = floats_5[int_19 * 2];
        float_2 = floats_5[int_19 * 2 + 1];
        float_3 = floats_2[int_11 + int_19 * 2];
        float_4 = floats_2[int_11 + int_19 * 2 + 1];
        float_5 = floats_2[int_2 - 2 - int_19 * 2];
        final float float_12 = floats_2[int_2 - 1 - int_19 * 2];
        float float_13 = float_2 * (float_3 - float_5) + float_1 * (float_4 + float_12);
        floats_2[int_11 + int_19 * 2] = (float_3 + float_5 + float_13) * 0.5F;
        floats_2[int_2 - 2 - int_19 * 2] = (float_3 + float_5 - float_13) * 0.5F;
        float_13 = float_2 * (float_4 + float_12) - float_1 * (float_3 - float_5);
        floats_2[int_11 + int_19 * 2 + 1] = (float_4 - float_12 + float_13) * 0.5F;
        floats_2[int_2 - 1 - int_19 * 2] = (-float_4 + float_12 + float_13) * 0.5F;
      }

      for (int_19 = 0; int_19 < int_12; int_19++) {
        floats_2[int_19] = floats_2[int_19 * 2 + int_11] * floats_4[int_19 * 2]
            + floats_2[int_11 + int_19 * 2 + 1] * floats_4[int_19 * 2 + 1];
        floats_2[int_11 - 1 - int_19] =
            floats_2[int_19 * 2 + int_11] * floats_4[int_19 * 2 + 1]
                - floats_2[int_11 + int_19 * 2 + 1] * floats_4[int_19 * 2];
      }

      for (int_19 = 0; int_19 < int_12; int_19++) {
        floats_2[int_19 + int_2 - int_12] = -floats_2[int_19];
      }

      for (int_19 = 0; int_19 < int_12; int_19++) {
        floats_2[int_19] = floats_2[int_12 + int_19];
      }

      for (int_19 = 0; int_19 < int_12; int_19++) {
        floats_2[int_12 + int_19] = -floats_2[int_12 - int_19 - 1];
      }

      for (int_19 = 0; int_19 < int_12; int_19++) {
        floats_2[int_11 + int_19] = floats_2[int_2 - int_19 - 1];
      }

      for (int_19 = int_4; int_19 < int_5; int_19++) {
        float_1 = (float) Math.sin((int_19 - int_4 + 0.5D) / int_6 * 0.5D * 3.141592653589793D);
        aFloatArray2[int_19] *= (float) Math.sin(1.5707963267948966D * float_1 * float_1);
      }

      for (int_19 = int_7; int_19 < int_8; int_19++) {
        float_1 = (float) Math
            .sin((int_19 - int_7 + 0.5D) / int_9 * 0.5D * 3.141592653589793D
                + 1.5707963267948966D);
        aFloatArray2[int_19] *= (float) Math.sin(1.5707963267948966D * float_1 * float_1);
      }
    }

    float[] floats_1 = null;
    if (anInt322 > 0) {
      int_12 = int_2 + anInt322 >> 2;
      floats_1 = new float[int_12];
      int int_14;
      if (!aBool46) {
        for (int_13 = 0; int_13 < anInt329; int_13++) {
          int_14 = int_13 + (anInt322 >> 1);
          floats_1[int_13] += aFloatArray9[int_14];
        }
      }

      if (!bool_3) {
        for (int_13 = int_4; int_13 < int_2 >> 1; int_13++) {
          int_14 = floats_1.length - (int_2 >> 1) + int_13;
          floats_1[int_14] += aFloatArray2[int_13];
        }
      }
    }

    final float[] floats_6 = aFloatArray9;
    aFloatArray9 = aFloatArray2;
    aFloatArray2 = floats_6;
    anInt322 = int_2;
    anInt329 = int_8 - (int_2 >> 1);
    aBool46 = bool_3;
    return floats_1;
  }

}
