package jagex.oldschool;

import jagex.oldschool.security.Isaac;

public class CodeBook {

  float[][] valueVector;
  int entries;
  int[] anIntArray33;
  int[] entryLengths;
  int dimensions;
  int[] anIntArray34;

  CodeBook() {
    Node_Sub2.get(24);
    dimensions = Node_Sub2.get(16);
    entries = Node_Sub2.get(24);
    entryLengths = new int[entries];
    final boolean bool_0 = Node_Sub2.getBit() != 0;
    int int_0;
    int int_1;
    int int_3;
    if (bool_0) {
      int_0 = 0;

      for (int_1 = Node_Sub2.get(5) + 1; int_0 < entries; int_1++) {
        final int int_2 = Node_Sub2.get(Isaac.log(entries - int_0));

        for (int_3 = 0; int_3 < int_2; int_3++) {
          entryLengths[int_0++] = int_1;
        }
      }
    } else {
      final boolean bool_2 = Node_Sub2.getBit() != 0;

      for (int_1 = 0; int_1 < entries; int_1++) {
        if (bool_2 && Node_Sub2.getBit() == 0) {
          entryLengths[int_1] = 0;
        } else {
          entryLengths[int_1] = Node_Sub2.get(5) + 1;
        }
      }
    }

    createHuffmanTree();
    int_0 = Node_Sub2.get(4);
    if (int_0 > 0) {
      final float float_3 = Node_Sub2.float32Unpack(Node_Sub2.get(32));
      final float float_4 = Node_Sub2.float32Unpack(Node_Sub2.get(32));
      int_3 = Node_Sub2.get(4) + 1;
      final boolean bool_1 = Node_Sub2.getBit() != 0;
      int int_4;
      if (int_0 == 1) {
        int_4 = method343(entries, dimensions);
      } else {
        int_4 = entries * dimensions;
      }

      anIntArray34 = new int[int_4];

      int int_5;
      for (int_5 = 0; int_5 < int_4; int_5++) {
        anIntArray34[int_5] = Node_Sub2.get(int_3);
      }

      valueVector = new float[entries][dimensions];
      float float_0;
      int int_6;
      int int_7;
      if (int_0 == 1) {
        for (int_5 = 0; int_5 < entries; int_5++) {
          float_0 = 0.0F;
          int_6 = 1;

          for (int_7 = 0; int_7 < dimensions; int_7++) {
            final int int_8 = int_5 / int_6 % int_4;
            final float float_2 = anIntArray34[int_8] * float_4 + float_3 + float_0;
            valueVector[int_5][int_7] = float_2;
            if (bool_1) {
              float_0 = float_2;
            }

            int_6 *= int_4;
          }
        }

        return;
      }

      for (int_5 = 0; int_5 < entries; int_5++) {
        float_0 = 0.0F;
        int_6 = int_5 * dimensions;

        for (int_7 = 0; int_7 < dimensions; int_7++) {
          final float float_1 = anIntArray34[int_6] * float_4 + float_3 + float_0;
          valueVector[int_5][int_7] = float_1;
          if (bool_1) {
            float_0 = float_1;
          }

          ++int_6;
        }
      }
    }

  }

  static int method343(final int int_0, final int int_1) {
    int int_2 = (int) Math.pow(int_0, 1.0D / int_1) + 1;

    while (true) {
      int int_3 = int_2;
      int int_4 = int_1;

      int int_5;
      for (int_5 = 1; int_4 > 1; int_4 >>= 1) {
        if ((int_4 & 0x1) != 0) {
          int_5 *= int_3;
        }

        int_3 *= int_3;
      }

      int int_6;
      if (int_4 == 1) {
        int_6 = int_3 * int_5;
      } else {
        int_6 = int_5;
      }

      if (int_6 <= int_0) {
        return int_2;
      }

      --int_2;
    }
  }

  int getHuffmanRoot() {
    int int_0;
    for (int_0 = 0; anIntArray33[int_0] >= 0;
        int_0 = Node_Sub2.getBit() != 0 ? anIntArray33[int_0] : int_0 + 1) {
    }

    return ~anIntArray33[int_0];
  }

  float[] method342() {
    return valueVector[getHuffmanRoot()];
  }

  void createHuffmanTree() {
    final int[] ints_0 = new int[entries];
    final int[] ints_1 = new int[33];

    int int_0;
    int int_1;
    int int_3;
    int int_4;
    int int_5;
    int int_6;
    int int_8;
    for (int_0 = 0; int_0 < entries; int_0++) {
      int_1 = entryLengths[int_0];
      if (int_1 != 0) {
        int_3 = 1 << 32 - int_1;
        int_4 = ints_1[int_1];
        ints_0[int_0] = int_4;
        int int_7;
        if ((int_4 & int_3) != 0) {
          int_5 = ints_1[int_1 - 1];
        } else {
          int_5 = int_4 | int_3;

          for (int_6 = int_1 - 1; int_6 >= 1; --int_6) {
            int_7 = ints_1[int_6];
            if (int_7 != int_4) {
              break;
            }

            int_8 = 1 << 32 - int_6;
            if ((int_7 & int_8) != 0) {
              ints_1[int_6] = ints_1[int_6 - 1];
              break;
            }

            ints_1[int_6] = int_7 | int_8;
          }
        }

        ints_1[int_1] = int_5;

        for (int_6 = int_1 + 1; int_6 <= 32; int_6++) {
          int_7 = ints_1[int_6];
          if (int_7 == int_4) {
            ints_1[int_6] = int_5;
          }
        }
      }
    }

    anIntArray33 = new int[8];
    int int_2 = 0;

    for (int_0 = 0; int_0 < entries; int_0++) {
      int_1 = entryLengths[int_0];
      if (int_1 != 0) {
        int_3 = ints_0[int_0];
        int_4 = 0;

        for (int_5 = 0; int_5 < int_1; int_5++) {
          int_6 = Integer.MIN_VALUE >>> int_5;
          if ((int_3 & int_6) != 0) {
            if (anIntArray33[int_4] == 0) {
              anIntArray33[int_4] = int_2;
            }

            int_4 = anIntArray33[int_4];
          } else {
            ++int_4;
          }

          if (int_4 >= anIntArray33.length) {
            final int[] ints_2 = new int[anIntArray33.length * 2];

            for (int_8 = 0; int_8 < anIntArray33.length; int_8++) {
              ints_2[int_8] = anIntArray33[int_8];
            }

            anIntArray33 = ints_2;
          }

          int_6 >>>= 1;
        }

        anIntArray33[int_4] = ~int_0;
        if (int_4 >= int_2) {
          int_2 = int_4 + 1;
        }
      }
    }

  }

}
