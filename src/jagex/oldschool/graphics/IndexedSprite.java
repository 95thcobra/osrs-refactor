package jagex.oldschool.graphics;

public final class IndexedSprite extends Rasterizer2d {

  public int offsetX;
  public int[] palette;
  public int width;
  public int unpackedWidth;
  public int height;
  public int offsetY;
  public int unpackedHeight;
  public byte[] pixels;

  static void method936(final int[] ints_0, final byte[] bytes_0, final int[] ints_1, int int_0,
      int int_1, int int_2,
      final int int_3, final int int_4, final int int_5) {
    final int int_6 = -(int_2 >> 2);
    int_2 = -(int_2 & 0x3);

    for (int int_7 = -int_3; int_7 < 0; int_7++) {
      int int_8;
      byte byte_0;
      for (int_8 = int_6; int_8 < 0; int_8++) {
        byte_0 = bytes_0[int_0++];
        if (byte_0 != 0) {
          ints_0[int_1++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_1;
        }

        byte_0 = bytes_0[int_0++];
        if (byte_0 != 0) {
          ints_0[int_1++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_1;
        }

        byte_0 = bytes_0[int_0++];
        if (byte_0 != 0) {
          ints_0[int_1++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_1;
        }

        byte_0 = bytes_0[int_0++];
        if (byte_0 != 0) {
          ints_0[int_1++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_1;
        }
      }

      for (int_8 = int_2; int_8 < 0; int_8++) {
        byte_0 = bytes_0[int_0++];
        if (byte_0 != 0) {
          ints_0[int_1++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_1;
        }
      }

      int_1 += int_4;
      int_0 += int_5;
    }

  }

  static void method937(final int[] ints_0, final byte[] bytes_0, final int[] ints_1, int int_0,
      int int_1, int int_2,
      final int int_3, final int int_4, final int int_5, final int int_6, final int int_7,
      final int int_8) {
    final int int_9 = int_0;

    for (int int_10 = -int_5; int_10 < 0; int_10++) {
      final int int_11 = int_8 * (int_1 >> 16);

      for (int int_12 = -int_4; int_12 < 0; int_12++) {
        final byte byte_0 = bytes_0[(int_0 >> 16) + int_11];
        if (byte_0 != 0) {
          ints_0[int_2++] = ints_1[byte_0 & 0xFF];
        } else {
          ++int_2;
        }

        int_0 += int_6;
      }

      int_1 += int_7;
      int_0 = int_9;
      int_2 += int_3;
    }

  }

  public void unpack() {
    if (width != unpackedWidth || height != unpackedHeight) {
      final byte[] bytes_0 = new byte[unpackedWidth * unpackedHeight];
      int int_0 = 0;

      for (int int_1 = 0; int_1 < height; int_1++) {
        for (int int_2 = 0; int_2 < width; int_2++) {
          bytes_0[int_2 + offsetX + (int_1 + offsetY) * unpackedWidth] = pixels[int_0++];
        }
      }

      pixels = bytes_0;
      width = unpackedWidth;
      height = unpackedHeight;
      offsetX = 0;
      offsetY = 0;
    }
  }

  public void method933(int x, int y) {
    x += offsetX;
    y += offsetY;
    int int_2 = x + y * Rasterizer2d.targetWidth;
    int int_3 = 0;
    int int_4 = height;
    int int_5 = width;
    int int_6 = Rasterizer2d.targetWidth - int_5;
    int int_7 = 0;
    int int_8;
    if (y < Rasterizer2d.ly) {
      int_8 = Rasterizer2d.ly - y;
      int_4 -= int_8;
      y = Rasterizer2d.ly;
      int_3 += int_8 * int_5;
      int_2 += int_8 * Rasterizer2d.targetWidth;
    }

    if (int_4 + y > Rasterizer2d.uy) {
      int_4 -= int_4 + y - Rasterizer2d.uy;
    }

    if (x < Rasterizer2d.lx) {
      int_8 = Rasterizer2d.lx - x;
      int_5 -= int_8;
      x = Rasterizer2d.lx;
      int_3 += int_8;
      int_2 += int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 + x > Rasterizer2d.ux) {
      int_8 = int_5 + x - Rasterizer2d.ux;
      int_5 -= int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 > 0 && int_4 > 0) {
      method936(Rasterizer2d.targetBuffer, pixels, palette, int_3, int_2, int_5, int_4, int_6,
          int_7);
    }
  }

  public void method934(int x, int y, int width, int height) {
    final int w = this.width;
    final int h = this.height;
    int int_6 = 0;
    int int_7 = 0;
    final int int_8 = unpackedWidth;
    final int int_9 = unpackedHeight;
    final int int_10 = (int_8 << 16) / width;
    final int int_11 = (int_9 << 16) / height;
    int int_12;
    if (offsetX > 0) {
      int_12 = (int_10 + (offsetX << 16) - 1) / int_10;
      x += int_12;
      int_6 += int_12 * int_10 - (offsetX << 16);
    }

    if (offsetY > 0) {
      int_12 = (int_11 + (offsetY << 16) - 1) / int_11;
      y += int_12;
      int_7 += int_12 * int_11 - (offsetY << 16);
    }

    if (w < int_8) {
      width = (int_10 + (w << 16) - int_6 - 1) / int_10;
    }

    if (h < int_9) {
      height = (int_11 + (h << 16) - int_7 - 1) / int_11;
    }

    int_12 = x + y * Rasterizer2d.targetWidth;
    int int_13 = Rasterizer2d.targetWidth - width;
    if (y + height > Rasterizer2d.uy) {
      height -= y + height - Rasterizer2d.uy;
    }

    int int_14;
    if (y < Rasterizer2d.ly) {
      int_14 = Rasterizer2d.ly - y;
      height -= int_14;
      int_12 += int_14 * Rasterizer2d.targetWidth;
      int_7 += int_11 * int_14;
    }

    if (width + x > Rasterizer2d.ux) {
      int_14 = width + x - Rasterizer2d.ux;
      width -= int_14;
      int_13 += int_14;
    }

    if (x < Rasterizer2d.lx) {
      int_14 = Rasterizer2d.lx - x;
      width -= int_14;
      int_12 += int_14;
      int_6 += int_10 * int_14;
      int_13 += int_14;
    }

    method937(Rasterizer2d.targetBuffer, pixels, palette, int_6, int_7, int_12, int_13, width,
        height, int_10,
        int_11, w);
  }

  public void add(final int red, final int green, final int blue) {
    for (int int_3 = 0; int_3 < palette.length; int_3++) {
      int r = palette[int_3] >> 16 & 0xFF;
      r += red;
      if (r < 0) {
        r = 0;
      } else if (r > 255) {
        r = 255;
      }

      int g = palette[int_3] >> 8 & 0xFF;
      g += green;
      if (g < 0) {
        g = 0;
      } else if (g > 255) {
        g = 255;
      }

      int b = palette[int_3] & 0xFF;
      b += blue;
      if (b < 0) {
        b = 0;
      } else if (b > 255) {
        b = 255;
      }

      palette[int_3] = b + (g << 8) + (r << 16);
    }

  }

}
