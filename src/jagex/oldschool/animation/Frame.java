package jagex.oldschool.animation;

import jagex.oldschool.io.Buffer;

public class Frame {

  static int[] anIntArray49;
  static int[] anIntArray50;
  static int[] anIntArray51;
  static int[] anIntArray52;

  static {
    anIntArray49 = new int[500];
    anIntArray50 = new int[500];
    anIntArray51 = new int[500];
    anIntArray52 = new int[500];
  }

  boolean showing;
  public FrameBase skin;
  public int anInt198;
  public int[] anIntArray53;
  public int[] translator_x;
  public int[] translator_y;
  public int[] translator_z;

  Frame(final byte[] bytes_0, final FrameBase framemap_0) {
    skin = null;
    anInt198 = -1;
    showing = false;
    skin = framemap_0;
    final Buffer buffer_0 = new Buffer(bytes_0);
    final Buffer buffer_1 = new Buffer(bytes_0);
    buffer_0.offset = 2;
    final int int_0 = buffer_0.getUnsignedByte();
    int int_1 = -1;
    int int_2 = 0;
    buffer_1.offset = int_0 + buffer_0.offset;

    int int_3;
    for (int_3 = 0; int_3 < int_0; int_3++) {
      final int int_4 = buffer_0.getUnsignedByte();
      if (int_4 > 0) {
        if (skin.types[int_3] != 0) {
          for (int int_5 = int_3 - 1; int_5 > int_1; --int_5) {
            if (skin.types[int_5] == 0) {
              anIntArray49[int_2] = int_5;
              anIntArray50[int_2] = 0;
              anIntArray51[int_2] = 0;
              anIntArray52[int_2] = 0;
              ++int_2;
              break;
            }
          }
        }

        anIntArray49[int_2] = int_3;
        short short_0 = 0;
        if (skin.types[int_3] == 3) {
          short_0 = 128;
        }

        if ((int_4 & 0x1) != 0) {
          anIntArray50[int_2] = buffer_1.getSmartShort();
        } else {
          anIntArray50[int_2] = short_0;
        }

        if ((int_4 & 0x2) != 0) {
          anIntArray51[int_2] = buffer_1.getSmartShort();
        } else {
          anIntArray51[int_2] = short_0;
        }

        if ((int_4 & 0x4) != 0) {
          anIntArray52[int_2] = buffer_1.getSmartShort();
        } else {
          anIntArray52[int_2] = short_0;
        }

        int_1 = int_3;
        ++int_2;
        if (skin.types[int_3] == 5) {
          showing = true;
        }
      }
    }

    if (bytes_0.length != buffer_1.offset) {
      throw new RuntimeException();
    }
    anInt198 = int_2;
    anIntArray53 = new int[int_2];
    translator_x = new int[int_2];
    translator_y = new int[int_2];
    translator_z = new int[int_2];

    for (int_3 = 0; int_3 < int_2; int_3++) {
      anIntArray53[int_3] = anIntArray49[int_3];
      translator_x[int_3] = anIntArray50[int_3];
      translator_y[int_3] = anIntArray51[int_3];
      translator_z[int_3] = anIntArray52[int_3];
    }

  }

}
