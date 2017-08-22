package jagex.oldschool;

public class Residue {

  int classBook;
  int end;
  int type;
  int begin;
  int partitionSize;
  int[] anIntArray69;
  int classification;

  Residue() {
    type = Node_Sub2.get(16);
    begin = Node_Sub2.get(24);
    end = Node_Sub2.get(24);
    partitionSize = Node_Sub2.get(24) + 1;
    classification = Node_Sub2.get(6) + 1;
    classBook = Node_Sub2.get(8);
    final int[] ints_0 = new int[classification];

    int int_0;
    for (int_0 = 0; int_0 < classification; int_0++) {
      int int_1 = 0;
      final int int_2 = Node_Sub2.get(3);
      final boolean bool_0 = Node_Sub2.getBit() != 0;
      if (bool_0) {
        int_1 = Node_Sub2.get(5);
      }

      ints_0[int_0] = int_1 << 3 | int_2;
    }

    anIntArray69 = new int[classification * 8];

    for (int_0 = 0; int_0 < classification * 8; int_0++) {
      anIntArray69[int_0] =
          (ints_0[int_0 >> 3] & 1 << (int_0 & 0x7)) != 0 ? Node_Sub2.get(8) : -1;
    }

  }

  void decodeResidue(final float[] floats_0, final int int_0, final boolean bool_0) {
    int int_1;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      floats_0[int_1] = 0.0F;
    }

    if (!bool_0) {
      int_1 = Node_Sub2.codeBooks[classBook].dimensions;
      final int int_2 = end - begin;
      final int int_3 = int_2 / partitionSize;
      final int[] ints_0 = new int[int_3];

      for (int int_4 = 0; int_4 < 8; int_4++) {
        int int_5 = 0;

        while (int_5 < int_3) {
          int int_6;
          int int_7;
          if (int_4 == 0) {
            int_6 = Node_Sub2.codeBooks[classBook].getHuffmanRoot();

            for (int_7 = int_1 - 1; int_7 >= 0; --int_7) {
              if (int_5 + int_7 < int_3) {
                ints_0[int_5 + int_7] = int_6 % classification;
              }

              int_6 /= classification;
            }
          }

          for (int_6 = 0; int_6 < int_1; int_6++) {
            int_7 = ints_0[int_5];
            final int int_8 = anIntArray69[int_7 * 8 + int_4];
            if (int_8 >= 0) {
              final int int_9 = int_5 * partitionSize + begin;
              final CodeBook codebook_0 = Node_Sub2.codeBooks[int_8];
              int int_10;
              if (type == 0) {
                int_10 = partitionSize / codebook_0.dimensions;

                for (int int_11 = 0; int_11 < int_10; int_11++) {
                  final float[] floats_1 = codebook_0.method342();

                  for (int int_12 = 0; int_12 < codebook_0.dimensions; int_12++) {
                    floats_0[int_9 + int_11 + int_12 * int_10] += floats_1[int_12];
                  }
                }
              } else {
                int_10 = 0;

                while (int_10 < partitionSize) {
                  final float[] floats_2 = codebook_0.method342();

                  for (int int_13 = 0; int_13 < codebook_0.dimensions; int_13++) {
                    floats_0[int_9 + int_10] += floats_2[int_13];
                    ++int_10;
                  }
                }
              }
            }

            ++int_5;
            if (int_5 >= int_3) {
              break;
            }
          }
        }
      }

    }
  }

}
