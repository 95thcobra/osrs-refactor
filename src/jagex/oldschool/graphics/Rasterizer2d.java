package jagex.oldschool.graphics;

import jagex.oldschool.collections.Subnode;

public class Rasterizer2d extends Subnode {

  public static int ly;
  public static int lx;
  public static int[] targetBuffer;
  public static int targetWidth;
  public static int targetHeight;
  public static int uy;
  protected static int ux;

  static {
    ly = 0;
    uy = 0;
    lx = 0;
    ux = 0;
  }

  public static void getClip(final int[] ints_0) {
    ints_0[0] = lx;
    ints_0[1] = ly;
    ints_0[2] = ux;
    ints_0[3] = uy;
  }

  public static void init(final int[] buffer, final int width, final int height) {
    targetBuffer = buffer;
    targetWidth = width;
    targetHeight = height;
    setClip(0, 0, width, height);
  }

  public static void drawVerticalLine(final int x, int y, int height, final int rgb) {
    if (x >= lx && x < ux) {
      if (y < ly) {
        height -= ly - y;
        y = ly;
      }

      if (height + y > uy) {
        height = uy - y;
      }

      final int int_4 = x + targetWidth * y;

      for (int int_5 = 0; int_5 < height; int_5++) {
        targetBuffer[int_4 + int_5 * targetWidth] = rgb;
      }

    }
  }

  public static void fillRectangle(int x, int y, int width, int height, final int rgb) {
    if (x < lx) {
      width -= lx - x;
      x = lx;
    }

    if (y < ly) {
      height -= ly - y;
      y = ly;
    }

    if (x + width > ux) {
      width = ux - x;
    }

    if (height + y > uy) {
      height = uy - y;
    }

    final int step = targetWidth - width;
    int off = x + targetWidth * y;

    for (int int_7 = -height; int_7 < 0; int_7++) {
      for (int int_8 = -width; int_8 < 0; int_8++) {
        targetBuffer[off++] = rgb;
      }

      off += step;
    }

  }

  public static void drawHorizontalLine(int x, final int y, int width, final int rgb) {
    if (y >= ly && y < uy) {
      if (x < lx) {
        width -= lx - x;
        x = lx;
      }

      if (x + width > ux) {
        width = ux - x;
      }

      final int int_4 = x + targetWidth * y;

      for (int int_5 = 0; int_5 < width; int_5++) {
        targetBuffer[int_4 + int_5] = rgb;
      }

    }
  }

  public static void setClip(int lx, int ly, int ux, int uy) {
    if (lx < 0) {
      lx = 0;
    }

    if (ly < 0) {
      ly = 0;
    }

    if (ux > targetWidth) {
      ux = targetWidth;
    }

    if (uy > targetHeight) {
      uy = targetHeight;
    }

    Rasterizer2d.lx = lx;
    Rasterizer2d.ly = ly;
    Rasterizer2d.ux = ux;
    Rasterizer2d.uy = uy;
  }

  public static void method882(final int x, final int y, int width, int height,
      final int rgba0, final int rgba1, final byte[] mask, final int size) {
    if (x + width >= 0 && height + y >= 0) {
      if (x < targetWidth) {
        if (y < targetHeight) {
          int int_7 = 0;
          int int_8 = 0;
          if (x < 0) {
            int_7 -= x;
            width += x;
          }

          if (y < 0) {
            int_8 -= y;
            height += y;
          }

          if (x + width > targetWidth) {
            width = targetWidth - x;
          }

          if (height + y > targetHeight) {
            height = targetHeight - y;
          }

          final int int_9 = mask.length / size;
          final int int_10 = targetWidth - width;
          final int a0 = rgba0 >>> 24;
          final int a1 = rgba1 >>> 24;
          int int_13;
          int int_14;
          int int_15;
          int int_16;
          int int_17;
          if (a0 == 255 && a1 == 255) {
            int_13 = (int_8 + y) * targetWidth + x + int_7;

            for (int_14 = int_8 + y; int_14 < height + int_8 + y; int_14++) {
              for (int_15 = x + int_7; int_15 < x + int_7 + width; int_15++) {
                int_16 = (int_14 - y) % int_9;
                int_17 = (int_15 - x) % size;
                if (mask[int_17 + int_16 * size] != 0) {
                  targetBuffer[int_13++] = rgba1;
                } else {
                  targetBuffer[int_13++] = rgba0;
                }
              }

              int_13 += int_10;
            }

          } else {
            int_13 = (int_8 + y) * targetWidth + x + int_7;

            for (int_14 = int_8 + y; int_14 < height + int_8 + y; int_14++) {
              for (int_15 = x + int_7; int_15 < x + int_7 + width; int_15++) {
                int_16 = (int_14 - y) % int_9;
                int_17 = (int_15 - x) % size;
                int int_18 = rgba0;
                if (mask[int_16 * size + int_17] != 0) {
                  int_18 = rgba1;
                }

                final int int_19 = int_18 >>> 24;
                final int int_20 = 255 - int_19;
                final int int_21 = targetBuffer[int_13];
                final int int_22 =
                    ((int_18 & 0xFF00FF) * int_19 + (int_21 & 0xFF00FF) * int_20
                        & 0xFF00FF00)
                        + (int_19 * (int_18 & 0xFF00) + int_20 * (int_21 & 0xFF00)
                        & 0xFF0000) >> 8;
                targetBuffer[int_13++] = int_22;
              }

              int_13 += int_10;
            }

          }
        }
      }
    }
  }

  public static void method883(final int int_0, int int_1, int int_2, final int int_3,
      final int int_4) {
    if (int_4 != 0) {
      if (int_4 == 256) {
        method884(int_0, int_1, int_2, int_3);
      } else {
        if (int_2 < 0) {
          int_2 = -int_2;
        }

        final int int_5 = 256 - int_4;
        final int int_6 = (int_3 >> 16 & 0xFF) * int_4;
        final int int_7 = (int_3 >> 8 & 0xFF) * int_4;
        final int int_8 = int_4 * (int_3 & 0xFF);
        int int_9 = int_1 - int_2;
        if (int_9 < ly) {
          int_9 = ly;
        }

        int int_10 = int_2 + int_1 + 1;
        if (int_10 > uy) {
          int_10 = uy;
        }

        int int_11 = int_9;
        final int int_12 = int_2 * int_2;
        int int_13 = 0;
        int int_14 = int_1 - int_9;
        int int_15 = int_14 * int_14;
        int int_16 = int_15 - int_14;
        if (int_1 > int_10) {
          int_1 = int_10;
        }

        int int_17;
        int int_18;
        int int_19;
        int int_20;
        int int_21;
        int int_22;
        int int_23;
        int int_24;
        while (int_11 < int_1) {
          while (int_16 <= int_12 || int_15 <= int_12) {
            int_15 = int_15 + int_13 + int_13;
            int_16 += int_13++ + int_13;
          }

          int_17 = int_0 - int_13 + 1;
          if (int_17 < lx) {
            int_17 = lx;
          }

          int_18 = int_0 + int_13;
          if (int_18 > ux) {
            int_18 = ux;
          }

          int_19 = int_17 + int_11 * targetWidth;

          for (int_20 = int_17; int_20 < int_18; int_20++) {
            int_21 = int_5 * (targetBuffer[int_19] >> 16 & 0xFF);
            int_22 = (targetBuffer[int_19] >> 8 & 0xFF) * int_5;
            int_23 = int_5 * (targetBuffer[int_19] & 0xFF);
            int_24 = (int_6 + int_21 >> 8 << 16) + (int_7 + int_22 >> 8 << 8)
                + (int_8 + int_23 >> 8);
            targetBuffer[int_19++] = int_24;
          }

          ++int_11;
          int_15 -= int_14-- + int_14;
          int_16 -= int_14 + int_14;
        }

        int_13 = int_2;
        int_14 = -int_14;
        int_16 = int_12 + int_14 * int_14;
        int_15 = int_16 - int_2;

        for (int_16 -= int_14; int_11 < int_10; int_15 += int_14++ + int_14) {
          while (int_16 > int_12 && int_15 > int_12) {
            int_16 -= int_13-- + int_13;
            int_15 -= int_13 + int_13;
          }

          int_17 = int_0 - int_13;
          if (int_17 < lx) {
            int_17 = lx;
          }

          int_18 = int_0 + int_13;
          if (int_18 > ux - 1) {
            int_18 = ux - 1;
          }

          int_19 = int_17 + int_11 * targetWidth;

          for (int_20 = int_17; int_20 <= int_18; int_20++) {
            int_21 = int_5 * (targetBuffer[int_19] >> 16 & 0xFF);
            int_22 = (targetBuffer[int_19] >> 8 & 0xFF) * int_5;
            int_23 = int_5 * (targetBuffer[int_19] & 0xFF);
            int_24 = (int_6 + int_21 >> 8 << 16) + (int_7 + int_22 >> 8 << 8)
                + (int_8 + int_23 >> 8);
            targetBuffer[int_19++] = int_24;
          }

          ++int_11;
          int_16 = int_16 + int_14 + int_14;
        }

      }
    }
  }

  public static void drawRectangle(final int x, final int y, final int width,
      final int height, final int hsl) {
    drawHorizontalLine(x, y, width, hsl);
    drawHorizontalLine(x, height + y - 1, width, hsl);
    drawVerticalLine(x, y, height, hsl);
    drawVerticalLine(x + width - 1, y, height, hsl);
  }

  static void method884(final int int_0, int int_1, int int_2, final int int_3) {
    if (int_2 == 0) {
      set(int_0, int_1, int_3);
    } else {
      if (int_2 < 0) {
        int_2 = -int_2;
      }

      int int_4 = int_1 - int_2;
      if (int_4 < ly) {
        int_4 = ly;
      }

      int int_5 = int_2 + int_1 + 1;
      if (int_5 > uy) {
        int_5 = uy;
      }

      int int_6 = int_4;
      final int int_7 = int_2 * int_2;
      int int_8 = 0;
      int int_9 = int_1 - int_4;
      int int_10 = int_9 * int_9;
      int int_11 = int_10 - int_9;
      if (int_1 > int_5) {
        int_1 = int_5;
      }

      int int_12;
      int int_13;
      int int_14;
      int int_15;
      while (int_6 < int_1) {
        while (int_11 <= int_7 || int_10 <= int_7) {
          int_10 = int_10 + int_8 + int_8;
          int_11 += int_8++ + int_8;
        }

        int_12 = int_0 - int_8 + 1;
        if (int_12 < lx) {
          int_12 = lx;
        }

        int_13 = int_0 + int_8;
        if (int_13 > ux) {
          int_13 = ux;
        }

        int_14 = int_12 + int_6 * targetWidth;

        for (int_15 = int_12; int_15 < int_13; int_15++) {
          targetBuffer[int_14++] = int_3;
        }

        ++int_6;
        int_10 -= int_9-- + int_9;
        int_11 -= int_9 + int_9;
      }

      int_8 = int_2;
      int_9 = int_6 - int_1;
      int_11 = int_9 * int_9 + int_7;
      int_10 = int_11 - int_2;

      for (int_11 -= int_9; int_6 < int_5; int_10 += int_9++ + int_9) {
        while (int_11 > int_7 && int_10 > int_7) {
          int_11 -= int_8-- + int_8;
          int_10 -= int_8 + int_8;
        }

        int_12 = int_0 - int_8;
        if (int_12 < lx) {
          int_12 = lx;
        }

        int_13 = int_0 + int_8;
        if (int_13 > ux - 1) {
          int_13 = ux - 1;
        }

        int_14 = int_12 + int_6 * targetWidth;

        for (int_15 = int_12; int_15 <= int_13; int_15++) {
          targetBuffer[int_14++] = int_3;
        }

        ++int_6;
        int_11 = int_11 + int_9 + int_9;
      }

    }
  }

  public static void resetClip() {
    lx = 0;
    ly = 0;
    ux = targetWidth;
    uy = targetHeight;
  }

  public static void drawLine(int x0, int y0, int x1, int y1, final int rgb) {
    x1 -= x0;
    y1 -= y0;
    if (y1 == 0) {
      if (x1 >= 0) {
        drawHorizontalLine(x0, y0, x1 + 1, rgb);
      } else {
        drawHorizontalLine(x0 + x1, y0, -x1 + 1, rgb);
      }
    } else if (x1 == 0) {
      if (y1 >= 0) {
        drawVerticalLine(x0, y0, y1 + 1, rgb);
      } else {
        drawVerticalLine(x0, y1 + y0, -y1 + 1, rgb);
      }
    } else {
      if (y1 + x1 < 0) {
        x0 += x1;
        x1 = -x1;
        y0 += y1;
        y1 = -y1;
      }

      int int_5;
      int int_6;
      if (x1 > y1) {
        y0 <<= 16;
        y0 += 32768;
        y1 <<= 16;
        int_5 = (int) Math.floor((double) y1 / (double) x1 + 0.5D);
        x1 += x0;
        if (x0 < lx) {
          y0 += int_5 * (lx - x0);
          x0 = lx;
        }

        if (x1 >= ux) {
          x1 = ux - 1;
        }

        while (x0 <= x1) {
          int_6 = y0 >> 16;
          if (int_6 >= ly && int_6 < uy) {
            targetBuffer[x0 + int_6 * targetWidth] = rgb;
          }

          y0 += int_5;
          ++x0;
        }

      } else {
        x0 <<= 16;
        x0 += 32768;
        x1 <<= 16;
        int_5 = (int) Math.floor((double) x1 / (double) y1 + 0.5D);
        y1 += y0;
        if (y0 < ly) {
          x0 += (ly - y0) * int_5;
          y0 = ly;
        }

        if (y1 >= uy) {
          y1 = uy - 1;
        }

        while (y0 <= y1) {
          int_6 = x0 >> 16;
          if (int_6 >= lx && int_6 < ux) {
            targetBuffer[int_6 + targetWidth * y0] = rgb;
          }

          x0 += int_5;
          ++y0;
        }

      }
    }
  }

  public static void setClip(final int[] ints_0) {
    lx = ints_0[0];
    ly = ints_0[1];
    ux = ints_0[2];
    uy = ints_0[3];
  }

  static void set(final int x, final int y, final int rgb) {
    if (x >= lx && y >= ly && x < ux
        && y < uy) {
      targetBuffer[x + targetWidth * y] = rgb;
    }
  }

  public static void fillRectangle(int int_0, int int_1, int int_2, int int_3, int int_4,
      final int int_5) {
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    int_4 = (int_5 * (int_4 & 0xFF00FF) >> 8 & 0xFF00FF) + (int_5 * (int_4 & 0xFF00) >> 8
        & 0xFF00);
    final int int_6 = 256 - int_5;
    final int int_7 = targetWidth - int_2;
    int int_8 = int_0 + targetWidth * int_1;

    for (int int_9 = 0; int_9 < int_3; int_9++) {
      for (int int_10 = -int_2; int_10 < 0; int_10++) {
        int int_11 = targetBuffer[int_8];
        int_11 = ((int_11 & 0xFF00FF) * int_6 >> 8 & 0xFF00FF)
            + (int_6 * (int_11 & 0xFF00) >> 8 & 0xFF00);
        targetBuffer[int_8++] = int_11 + int_4;
      }

      int_8 += int_7;
    }

  }

  public static void method886(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final int int_5) {
    int int_6 = 0;
    final int int_7 = 65536 / int_3;
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_6 += (ly - int_1) * int_7;
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    final int int_8 = targetWidth - int_2;
    int int_9 = int_0 + targetWidth * int_1;

    for (int int_10 = -int_3; int_10 < 0; int_10++) {
      final int int_11 = 65536 - int_6 >> 8;
      final int int_12 = int_6 >> 8;
      final int int_13 =
          (int_12 * (int_5 & 0xFF00FF) + int_11 * (int_4 & 0xFF00FF) & 0xFF00FF00)
              + (int_11 * (int_4 & 0xFF00) + int_12 * (int_5 & 0xFF00) & 0xFF0000) >>> 8;

      for (int int_14 = -int_2; int_14 < 0; int_14++) {
        targetBuffer[int_9++] = int_13;
      }

      int_9 += int_8;
      int_6 += int_7;
    }

  }

  public static void method887(int int_0, int int_1, final int int_2, final int[] ints_0,
      final int[] ints_1) {
    int int_3 = int_0 + targetWidth * int_1;

    for (int_1 = 0; int_1 < ints_0.length; int_1++) {
      int int_4 = int_3 + ints_0[int_1];

      for (int_0 = -ints_1[int_1]; int_0 < 0; int_0++) {
        targetBuffer[int_4++] = int_2;
      }

      int_3 += targetWidth;
    }

  }

  public static void method888(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5) {
    drawHorizontalLine(int_0, int_1, int_2, int_4, int_5);
    drawHorizontalLine(int_0, int_3 + int_1 - 1, int_2, int_4, int_5);
    if (int_3 >= 3) {
      drawVerticalLine(int_0, int_1 + 1, int_3 - 2, int_4, int_5);
      drawVerticalLine(int_0 + int_2 - 1, int_1 + 1, int_3 - 2, int_4, int_5);
    }

  }

  public static void method889(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final int int_5,
      final int int_6, final int int_7) {
    int int_8 = 0;
    final int int_9 = int_5 == int_4 && int_7 == int_6 ? -1 : 65536 / int_3;
    int int_10 = int_6;
    int int_11 = 256 - int_6;
    int int_12 = int_4;
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_8 += (ly - int_1) * int_9;
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    final int int_13 = targetWidth - int_2;
    int int_14 = int_0 + targetWidth * int_1;

    for (int int_15 = -int_3; int_15 < 0; int_15++) {
      int int_16;
      int int_17;
      for (int_16 = -int_2; int_16 < 0; int_16++) {
        int_17 = targetBuffer[int_14];
        final int int_18 = int_12 + int_17;
        final int int_19 = (int_12 & 0xFF00FF) + (int_17 & 0xFF00FF);
        final int int_20 = (int_19 & 0x1000100) + (int_18 - int_19 & 0x10000);
        if (int_11 == 0) {
          targetBuffer[int_14++] = int_18 - int_20 | int_20 - (int_20 >>> 8);
        } else {
          final int int_21 = int_18 - int_20 | int_20 - (int_20 >>> 8);
          targetBuffer[int_14++] = ((int_21 & 0xFF00FF) * int_10 >> 8 & 0xFF00FF)
              + (int_10 * (int_21 & 0xFF00) >> 8 & 0xFF00)
              + ((int_17 & 0xFF00FF) * int_11 >> 8 & 0xFF00FF)
              + (int_11 * (int_17 & 0xFF00) >> 8 & 0xFF00);
        }
      }

      if (int_9 > 0) {
        int_8 += int_9;
        int_16 = 65536 - int_8 >> 8;
        int_17 = int_8 >> 8;
        if (int_7 != int_6) {
          int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
          int_11 = 256 - int_10;
        }

        if (int_5 != int_4) {
          int_12 = (int_16 * (int_4 & 0xFF00FF) + int_17 * (int_5 & 0xFF00FF) & 0xFF00FF00)
              + (int_16 * (int_4 & 0xFF00) + int_17 * (int_5 & 0xFF00) & 0xFF0000) >>> 8;
        }
      }

      int_14 += int_13;
    }

  }

  public static void method890(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final int int_5,
      final int int_6, final int int_7) {
    int int_8 = 0;
    final int int_9 = int_5 == int_4 && int_7 == int_6 ? -1 : 65536 / int_3;
    int int_10 = int_6;
    int int_11 = 256 - int_6;
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_8 += (ly - int_1) * int_9;
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    int int_12 = int_4 >> 16;
    int int_13 = (int_4 & 0xFF00) >> 8;
    int int_14 = int_4 & 0xFF;
    final int int_15 = targetWidth - int_2;
    int int_16 = int_0 + targetWidth * int_1;

    for (int int_17 = 0; int_17 < int_3; int_17++) {
      int int_18;
      int int_19;
      int int_20;
      for (int_18 = -int_2; int_18 < 0; int_18++) {
        int_19 = targetBuffer[int_16];
        int_20 = int_19 >> 16;
        final int int_21 = (int_19 & 0xFF00) >> 8;
        final int int_22 = int_19 & 0xFF;
        int int_23;
        int int_24;
        int int_25;
        if (int_11 == 0) {
          int_23 = int_20 < 127 ? int_12 * int_20 >> 7
              : 255 - ((255 - int_12) * (255 - int_20) >> 7);
          int_24 = int_21 < 127 ? int_13 * int_21 >> 7
              : 255 - ((255 - int_13) * (255 - int_21) >> 7);
          int_25 = int_22 < 127 ? int_14 * int_22 >> 7
              : 255 - ((255 - int_14) * (255 - int_22) >> 7);
        } else {
          int_23 = int_20 < 127 ? int_20 * int_11 + (int_12 * int_20 * int_10 >> 7) >> 8
              : (255 - ((255 - int_12) * (255 - int_20) >> 7)) * int_10 + int_20 * int_11
                  >> 8;
          int_24 = int_21 < 127 ? (int_13 * int_21 * int_10 >> 7) + int_21 * int_11 >> 8
              : (255 - ((255 - int_13) * (255 - int_21) >> 7)) * int_10 + int_21 * int_11
                  >> 8;
          int_25 = int_22 < 127 ? int_22 * int_11 + (int_14 * int_22 * int_10 >> 7) >> 8
              : (255 - ((255 - int_14) * (255 - int_22) >> 7)) * int_10 + int_22 * int_11
                  >> 8;
        }

        targetBuffer[int_16++] = int_25 + (int_24 << 8) + (int_23 << 16);
      }

      if (int_9 > 0) {
        int_8 += int_9;
        int_18 = 65536 - int_8 >> 8;
        int_19 = int_8 >> 8;
        if (int_7 != int_6) {
          int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
          int_11 = 256 - int_10;
        }

        if (int_5 != int_4) {
          int_20 = (int_18 * (int_4 & 0xFF00FF) + int_19 * (int_5 & 0xFF00FF) & 0xFF00FF00)
              + (int_19 * (int_5 & 0xFF00) + int_18 * (int_4 & 0xFF00) & 0xFF0000) >>> 8;
          int_12 = int_20 >> 16;
          int_13 = (int_20 & 0xFF00) >> 8;
          int_14 = int_20 & 0xFF;
        }
      }

      int_16 += int_15;
    }

  }

  public static void method891(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final int int_5,
      final int int_6, final int int_7) {
    int int_8 = 0;
    final int int_9 = 65536 / int_3;
    int int_10 = int_6;
    int int_11 = 256 - int_6;
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_8 += (ly - int_1) * int_9;
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    int int_12 = int_4 & 0xFF0000;
    int int_13 = int_4 & 0xFF00;
    int int_14 = int_4 & 0xFF;
    int int_15 = int_12 * int_6 >> 8;
    int int_16 = int_13 * int_6 >> 8;
    int int_17 = int_14 * int_6 >> 8;
    final int int_18 = targetWidth - int_2;
    int int_19 = int_0 + targetWidth * int_1;

    for (int int_20 = 0; int_20 < int_3; int_20++) {
      int int_21;
      int int_22;
      int int_23;
      for (int_21 = -int_2; int_21 < 0; int_21++) {
        int_22 = targetBuffer[int_19];
        int_23 = int_22 & 0xFF0000;
        final int int_24 = int_23 <= int_12 ? int_23
            : int_11 == 0 ? int_12 : int_15 + (int_23 * int_11 >> 8) & 0xFF0000;
        final int int_25 = int_22 & 0xFF00;
        final int int_26 = int_25 <= int_13 ? int_25
            : int_11 == 0 ? int_13 : int_16 + (int_25 * int_11 >> 8) & 0xFF00;
        final int int_27 = int_22 & 0xFF;
        final int int_28 = int_27 <= int_14 ? int_27
            : int_11 == 0 ? int_14 : int_17 + (int_27 * int_11 >> 8);
        targetBuffer[int_19++] = int_24 + int_26 + int_28;
      }

      if (int_9 > 0) {
        int_8 += int_9;
        int_21 = 65536 - int_8 >> 8;
        int_22 = int_8 >> 8;
        if (int_7 != int_6) {
          int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
          int_11 = 256 - int_10;
        }

        if (int_5 != int_4) {
          int_23 = (int_21 * (int_4 & 0xFF00FF) + int_22 * (int_5 & 0xFF00FF) & 0xFF00FF00)
              + (int_21 * (int_4 & 0xFF00) + int_22 * (int_5 & 0xFF00) & 0xFF0000) >>> 8;
          int_12 = int_23 & 0xFF0000;
          int_13 = int_23 & 0xFF00;
          int_14 = int_23 & 0xFF;
          int_15 = int_12 * int_10 >> 8;
          int_16 = int_13 * int_10 >> 8;
          int_17 = int_14 * int_10 >> 8;
        }
      }

      int_19 += int_18;
    }

  }

  public static void method892(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final int int_5,
      final int int_6, final int int_7) {
    int int_8 = 0;
    final int int_9 = 65536 / int_3;
    int int_10 = int_6;
    int int_11 = 256 - int_6;
    if (int_0 < lx) {
      int_2 -= lx - int_0;
      int_0 = lx;
    }

    if (int_1 < ly) {
      int_8 += (ly - int_1) * int_9;
      int_3 -= ly - int_1;
      int_1 = ly;
    }

    if (int_0 + int_2 > ux) {
      int_2 = ux - int_0;
    }

    if (int_3 + int_1 > uy) {
      int_3 = uy - int_1;
    }

    int int_12 = int_4 & 0xFF0000;
    int int_13 = int_4 & 0xFF00;
    int int_14 = int_4 & 0xFF;
    int int_15 = int_12 * int_6 >> 8;
    int int_16 = int_13 * int_6 >> 8;
    int int_17 = int_14 * int_6 >> 8;
    final int int_18 = targetWidth - int_2;
    int int_19 = int_0 + targetWidth * int_1;

    for (int int_20 = 0; int_20 < int_3; int_20++) {
      int int_21;
      int int_22;
      int int_23;
      for (int_21 = -int_2; int_21 < 0; int_21++) {
        int_22 = targetBuffer[int_19];
        int_23 = int_22 & 0xFF0000;
        final int int_24 = int_23 >= int_12 ? int_23
            : int_11 == 0 ? int_12 : int_15 + (int_23 * int_11 >> 8) & 0xFF0000;
        final int int_25 = int_22 & 0xFF00;
        final int int_26 = int_25 >= int_13 ? int_25
            : int_11 == 0 ? int_13 : int_16 + (int_25 * int_11 >> 8) & 0xFF00;
        final int int_27 = int_22 & 0xFF;
        final int int_28 = int_27 >= int_14 ? int_27
            : int_11 == 0 ? int_14 : int_17 + (int_27 * int_11 >> 8);
        targetBuffer[int_19++] = int_24 + int_26 + int_28;
      }

      if (int_9 > 0) {
        int_8 += int_9;
        int_21 = 65536 - int_8 >> 8;
        int_22 = int_8 >> 8;
        if (int_7 != int_6) {
          int_10 = (65536 - int_8) * int_6 + int_8 * int_7 >> 16;
          int_11 = 256 - int_10;
        }

        if (int_5 != int_4) {
          int_23 = (int_21 * (int_4 & 0xFF00FF) + int_22 * (int_5 & 0xFF00FF) & 0xFF00FF00)
              + (int_21 * (int_4 & 0xFF00) + int_22 * (int_5 & 0xFF00) & 0xFF0000) >>> 8;
          int_12 = int_23 & 0xFF0000;
          int_13 = int_23 & 0xFF00;
          int_14 = int_23 & 0xFF;
          int_15 = int_12 * int_10 >> 8;
          int_16 = int_13 * int_10 >> 8;
          int_17 = int_14 * int_10 >> 8;
        }
      }

      int_19 += int_18;
    }

  }

  public static void resizeClip(final int int_0, final int int_1, final int int_2,
      final int int_3) {
    if (lx < int_0) {
      lx = int_0;
    }

    if (ly < int_1) {
      ly = int_1;
    }

    if (ux > int_2) {
      ux = int_2;
    }

    if (uy > int_3) {
      uy = int_3;
    }

  }

  public static void clear() {
    int int_0 = 0;

    int int_1;
    for (int_1 = targetWidth * targetHeight - 7; int_0 < int_1;
        targetBuffer[int_0++] = 0) {
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
      targetBuffer[int_0++] = 0;
    }

    for (int_1 += 7; int_0 < int_1; targetBuffer[int_0++] = 0) {
    }

  }

  static void drawHorizontalLine(int x, final int y, int width, final int rgb, final int alpha) {
    if (y >= ly) {
      if (y < uy) {
        if (x < lx) {
          width -= lx - x;
          x = lx;
        }

        if (x + width > ux) {
          width = ux - x;
        }

        final int int_5 = 256 - alpha;
        final int int_6 = (rgb >> 16 & 0xFF) * alpha;
        final int int_7 = (rgb >> 8 & 0xFF) * alpha;
        final int int_8 = alpha * (rgb & 0xFF);
        int int_9 = x + targetWidth * y;

        for (int int_10 = 0; int_10 < width; int_10++) {
          final int int_11 = int_5 * (targetBuffer[int_9] >> 16 & 0xFF);
          final int int_12 = (targetBuffer[int_9] >> 8 & 0xFF) * int_5;
          final int int_13 = int_5 * (targetBuffer[int_9] & 0xFF);
          final int int_14 = (int_6 + int_11 >> 8 << 16) + (int_7 + int_12 >> 8 << 8)
              + (int_8 + int_13 >> 8);
          targetBuffer[int_9++] = int_14;
        }

      }
    }
  }

  static void drawVerticalLine(final int x, int y, int height, final int rgb, final int alpha) {
    if (x >= lx && x < ux) {
      if (y < ly) {
        height -= ly - y;
        y = ly;
      }

      if (height + y > uy) {
        height = uy - y;
      }

      final int inv = 256 - alpha;
      final int int_6 = (rgb >> 16 & 0xFF) * alpha;
      final int int_7 = (rgb >> 8 & 0xFF) * alpha;
      final int int_8 = alpha * (rgb & 0xFF);
      int int_9 = x + targetWidth * y;

      for (int int_10 = 0; int_10 < height; int_10++) {
        final int int_11 = inv * (targetBuffer[int_9] >> 16 & 0xFF);
        final int int_12 = (targetBuffer[int_9] >> 8 & 0xFF) * inv;
        final int int_13 = inv * (targetBuffer[int_9] & 0xFF);
        final int int_14 = (int_6 + int_11 >> 8 << 16) + (int_7 + int_12 >> 8 << 8)
            + (int_8 + int_13 >> 8);
        targetBuffer[int_9] = int_14;
        int_9 += targetWidth;
      }

    }
  }

}
