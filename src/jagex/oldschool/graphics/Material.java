package jagex.oldschool.graphics;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;

public class Material extends Node {

  static int[] anIntArray73;
  int[] fileIds;
  int[] pixels;
  boolean solid;
  boolean loaded;
  int anInt302;
  int hsl;
  int[] anIntArray74;
  int anInt304;
  int[] anIntArray75;
  int[] anIntArray76;

  Material(final Buffer buffer) {
    loaded = false;
    hsl = buffer.getUnsignedShort();
    solid = buffer.getUnsignedByte() == 1;
    final int int_0 = buffer.getUnsignedByte();
    if (int_0 >= 1 && int_0 <= 4) {
      fileIds = new int[int_0];

      int int_1;
      for (int_1 = 0; int_1 < int_0; int_1++) {
        fileIds[int_1] = buffer.getUnsignedShort();
      }

      if (int_0 > 1) {
        anIntArray75 = new int[int_0 - 1];

        for (int_1 = 0; int_1 < int_0 - 1; int_1++) {
          anIntArray75[int_1] = buffer.getUnsignedByte();
        }
      }

      if (int_0 > 1) {
        anIntArray76 = new int[int_0 - 1];

        for (int_1 = 0; int_1 < int_0 - 1; int_1++) {
          anIntArray76[int_1] = buffer.getUnsignedByte();
        }
      }

      anIntArray74 = new int[int_0];

      for (int_1 = 0; int_1 < int_0; int_1++) {
        anIntArray74[int_1] = buffer.getInt();
      }

      anInt302 = buffer.getUnsignedByte();
      anInt304 = buffer.getUnsignedByte();
      pixels = null;
    } else {
      throw new RuntimeException();
    }
  }

  void clear() {
    pixels = null;
  }

  boolean method613(final double double_0, final int int_0, final AbstractPackage indexdatabase_0) {
    int int_1;
    for (int_1 = 0; int_1 < fileIds.length; int_1++) {
      if (indexdatabase_0.method447(fileIds[int_1]) == null) {
        return false;
      }
    }

    int_1 = int_0 * int_0;
    pixels = new int[int_1];

    for (int int_2 = 0; int_2 < fileIds.length; int_2++) {
      final IndexedSprite indexedsprite_0 = AnimationSequence.method878(indexdatabase_0, fileIds[int_2]);
      indexedsprite_0.unpack();
      final byte[] bytes_0 = indexedsprite_0.pixels;
      final int[] ints_0 = indexedsprite_0.palette;
      final int int_3 = anIntArray74[int_2];
      if ((int_3 & 0xFF000000) == 16777216) {
      }

      if ((int_3 & 0xFF000000) == 33554432) {
      }

      int int_4;
      int int_5;
      int int_6;
      int int_7;
      if ((int_3 & 0xFF000000) == 50331648) {
        int_4 = int_3 & 0xFF00FF;
        int_5 = int_3 >> 8 & 0xFF;

        for (int_6 = 0; int_6 < ints_0.length; int_6++) {
          int_7 = ints_0[int_6];
          if (int_7 >> 8 == (int_7 & 0xFFFF)) {
            int_7 &= 0xFF;
            ints_0[int_6] = int_4 * int_7 >> 8 & 0xFF00FF | int_5 * int_7 & 0xFF00;
          }
        }
      }

      for (int_4 = 0; int_4 < ints_0.length; int_4++) {
        ints_0[int_4] = Rasterizer3d.brighten(ints_0[int_4], double_0);
      }

      if (int_2 == 0) {
        int_4 = 0;
      } else {
        int_4 = anIntArray75[int_2 - 1];
      }

      if (int_4 == 0) {
        if (int_0 == indexedsprite_0.width) {
          for (int_5 = 0; int_5 < int_1; int_5++) {
            pixels[int_5] = ints_0[bytes_0[int_5] & 0xFF];
          }
        } else if (indexedsprite_0.width == 64 && int_0 == 128) {
          int_5 = 0;

          for (int_6 = 0; int_6 < int_0; int_6++) {
            for (int_7 = 0; int_7 < int_0; int_7++) {
              pixels[int_5++] = ints_0[bytes_0[(int_6 >> 1 << 6) + (int_7 >> 1)] & 0xFF];
            }
          }
        } else {
          if (indexedsprite_0.width != 128 || int_0 != 64) {
            throw new RuntimeException();
          }

          int_5 = 0;

          for (int_6 = 0; int_6 < int_0; int_6++) {
            for (int_7 = 0; int_7 < int_0; int_7++) {
              pixels[int_5++] = ints_0[bytes_0[(int_7 << 1) + (int_6 << 1 << 7)] & 0xFF];
            }
          }
        }
      }

      if (int_4 == 1) {
      }

      if (int_4 == 2) {
      }

      if (int_4 == 3) {
      }
    }

    return true;
  }

  void method614(final int int_0) {
    if (pixels != null) {
      short short_0;
      int int_1;
      int int_2;
      int int_3;
      int int_4;
      int int_5;
      int[] ints_0;
      if (anInt302 == 1 || anInt302 == 3) {
        if (anIntArray73 == null || anIntArray73.length < pixels.length) {
          anIntArray73 = new int[pixels.length];
        }

        if (pixels.length == 4096) {
          short_0 = 64;
        } else {
          short_0 = 128;
        }

        int_1 = pixels.length;
        int_2 = short_0 * anInt304 * int_0;
        int_3 = int_1 - 1;
        if (anInt302 == 1) {
          int_2 = -int_2;
        }

        for (int_4 = 0; int_4 < int_1; int_4++) {
          int_5 = int_4 + int_2 & int_3;
          anIntArray73[int_4] = pixels[int_5];
        }

        ints_0 = pixels;
        pixels = anIntArray73;
        anIntArray73 = ints_0;
      }

      if (anInt302 == 2 || anInt302 == 4) {
        if (anIntArray73 == null || anIntArray73.length < pixels.length) {
          anIntArray73 = new int[pixels.length];
        }

        if (pixels.length == 4096) {
          short_0 = 64;
        } else {
          short_0 = 128;
        }

        int_1 = pixels.length;
        int_2 = anInt304 * int_0;
        int_3 = short_0 - 1;
        if (anInt302 == 2) {
          int_2 = -int_2;
        }

        for (int_4 = 0; int_4 < int_1; int_4 += short_0) {
          for (int_5 = 0; int_5 < short_0; int_5++) {
            final int int_6 = int_4 + int_5;
            final int int_7 = int_4 + (int_5 + int_2 & int_3);
            anIntArray73[int_6] = pixels[int_7];
          }
        }

        ints_0 = pixels;
        pixels = anIntArray73;
        anIntArray73 = ints_0;
      }
    }
  }

}
