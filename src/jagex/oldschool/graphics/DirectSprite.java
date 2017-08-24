package jagex.oldschool.graphics;

public final class DirectSprite extends Rasterizer2d {

  public int unpackedWidth;
  public int offsetX;
  public int height;
  public int[] buffer;
  public int width;
  public int unpackedHeight;
  public int offsetY;

  public DirectSprite(final int[] buffer, final int width, final int height) {
    this.buffer = buffer;
    this.width = unpackedWidth = width;
    this.height = unpackedHeight = height;
    offsetY = 0;
    offsetX = 0;
  }

  public DirectSprite(final int width, final int height) {
    this(new int[height * width], width, height);
  }

  public DirectSprite() {
  }

  static void method958(final int[] ints_0, final int[] ints_1, int int_0, int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5) {
    for (int int_6 = -int_3; int_6 < 0; int_6++) {
      int int_7;
      for (int_7 = int_1 + int_2 - 3; int_1 < int_7; ints_0[int_1++] = ints_1[int_0++]) {
        ints_0[int_1++] = ints_1[int_0++];
        ints_0[int_1++] = ints_1[int_0++];
        ints_0[int_1++] = ints_1[int_0++];
      }

      for (int_7 += 3; int_1 < int_7; ints_0[int_1++] = ints_1[int_0++]) {
      }

      int_1 += int_4;
      int_0 += int_5;
    }

  }

  static void method959(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2,
      final int int_3,
      final int int_4, final int int_5, final int int_6, final int int_7) {
    final int int_8 = 256 - int_7;

    for (int int_9 = -int_4; int_9 < 0; int_9++) {
      for (int int_10 = -int_3; int_10 < 0; int_10++) {
        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          final int int_11 = ints_0[int_2];
          ints_0[int_2++] =
              ((int_11 & 0xFF00FF) * int_8 + int_7 * (int_0 & 0xFF00FF) & 0xFF00FF00)
                  + ((int_0 & 0xFF00) * int_7 + int_8 * (int_11 & 0xFF00) & 0xFF0000) >> 8;
        } else {
          ++int_2;
        }
      }

      int_2 += int_5;
      int_1 += int_6;
    }

  }

  static void method960(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2,
      int int_3,
      final int int_4, final int int_5, final int int_6) {
    final int int_7 = -(int_3 >> 2);
    int_3 = -(int_3 & 0x3);

    for (int int_8 = -int_4; int_8 < 0; int_8++) {
      int int_9;
      for (int_9 = int_7; int_9 < 0; int_9++) {
        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }
      }

      for (int_9 = int_3; int_9 < 0; int_9++) {
        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }
      }

      int_2 += int_5;
      int_1 += int_6;
    }

  }

  static void method961(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2,
      final int int_3,
      final int int_4, final int int_5, final int int_6, final int int_7, int int_8) {
    final int int_9 = 256 - int_7;
    int int_10 = (int_8 & 0xFF00FF) * int_9 & 0xFF00FF00;
    int int_11 = (int_8 & 0xFF00) * int_9 & 0xFF0000;
    int_8 = (int_10 | int_11) >>> 8;

    for (int int_12 = -int_4; int_12 < 0; int_12++) {
      for (int int_13 = -int_3; int_13 < 0; int_13++) {
        int_0 = ints_1[int_1++];
        if (int_0 != 0) {
          int_10 = int_7 * (int_0 & 0xFF00FF) & 0xFF00FF00;
          int_11 = (int_0 & 0xFF00) * int_7 & 0xFF0000;
          ints_0[int_2++] = int_8 + ((int_10 | int_11) >>> 8);
        } else {
          ++int_2;
        }
      }

      int_2 += int_5;
      int_1 += int_6;
    }

  }

  static void method962(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2,
      int int_3,
      final int int_4, final int int_5, final int int_6, final int int_7, final int int_8,
      final int int_9,
      final int int_10) {
    final int int_11 = 256 - int_10;
    final int int_12 = int_1;

    for (int int_13 = -int_6; int_13 < 0; int_13++) {
      final int int_14 = int_9 * (int_2 >> 16);

      for (int int_15 = -int_5; int_15 < 0; int_15++) {
        int_0 = ints_1[(int_1 >> 16) + int_14];
        if (int_0 != 0) {
          final int int_16 = ints_0[int_3];
          ints_0[int_3++] =
              (int_10 * (int_0 & 0xFF00FF) + (int_16 & 0xFF00FF) * int_11 & 0xFF00FF00)
                  + ((int_0 & 0xFF00) * int_10 + int_11 * (int_16 & 0xFF00) & 0xFF0000) >> 8;
        } else {
          ++int_3;
        }

        int_1 += int_7;
      }

      int_2 += int_8;
      int_1 = int_12;
      int_3 += int_4;
    }

  }

  static void method963(final int[] ints_0, final int[] ints_1, int int_0, int int_1, int int_2,
      int int_3,
      final int int_4, final int int_5, final int int_6, final int int_7, final int int_8,
      final int int_9) {
    final int int_10 = int_1;

    for (int int_11 = -int_6; int_11 < 0; int_11++) {
      final int int_12 = int_9 * (int_2 >> 16);

      for (int int_13 = -int_5; int_13 < 0; int_13++) {
        int_0 = ints_1[(int_1 >> 16) + int_12];
        if (int_0 != 0) {
          ints_0[int_3++] = int_0;
        } else {
          ++int_3;
        }

        int_1 += int_7;
      }

      int_2 += int_8;
      int_1 = int_10;
      int_3 += int_4;
    }

  }

  public void method938(int int_0, int int_1) {
    int_0 += offsetX;
    int_1 += offsetY;
    int int_2 = int_0 + int_1 * Rasterizer2d.targetWidth;
    int int_3 = 0;
    int int_4 = height;
    int int_5 = width;
    int int_6 = Rasterizer2d.targetWidth - int_5;
    int int_7 = 0;
    int int_8;
    if (int_1 < Rasterizer2d.ly) {
      int_8 = Rasterizer2d.ly - int_1;
      int_4 -= int_8;
      int_1 = Rasterizer2d.ly;
      int_3 += int_8 * int_5;
      int_2 += int_8 * Rasterizer2d.targetWidth;
    }

    if (int_4 + int_1 > Rasterizer2d.uy) {
      int_4 -= int_4 + int_1 - Rasterizer2d.uy;
    }

    if (int_0 < Rasterizer2d.lx) {
      int_8 = Rasterizer2d.lx - int_0;
      int_5 -= int_8;
      int_0 = Rasterizer2d.lx;
      int_3 += int_8;
      int_2 += int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 + int_0 > Rasterizer2d.ux) {
      int_8 = int_5 + int_0 - Rasterizer2d.ux;
      int_5 -= int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 > 0 && int_4 > 0) {
      method960(Rasterizer2d.targetBuffer, buffer, 0, int_3, int_2, int_5, int_4, int_6, int_7);
    }
  }

  void method939(int int_0, int int_1, final int int_2, final int int_3, final int int_4,
      final int int_5) {
    if (int_5 != 0) {
      int_0 -= offsetX << 4;
      int_1 -= offsetY << 4;
      final double double_0 = (int_4 & 0xFFFF) * 9.587379924285257E-5D;
      final int int_6 = (int) Math.floor(Math.sin(double_0) * int_5 + 0.5D);
      final int int_7 = (int) Math.floor(Math.cos(double_0) * int_5 + 0.5D);
      final int int_8 = int_7 * -int_0 + -int_1 * int_6;
      final int int_9 = int_6 * - -int_0 + -int_1 * int_7;
      final int int_10 = int_7 * ((width << 4) - int_0) + -int_1 * int_6;
      final int int_11 = int_6 * -((width << 4) - int_0) + -int_1 * int_7;
      final int int_12 = ((height << 4) - int_1) * int_6 + int_7 * -int_0;
      final int int_13 = ((height << 4) - int_1) * int_7 + int_6 * - -int_0;
      final int int_14 = int_7 * ((width << 4) - int_0) + ((height << 4) - int_1) * int_6;
      final int int_15 = int_6 * -((width << 4) - int_0) + ((height << 4) - int_1) * int_7;
      int int_16;
      int int_17;
      if (int_8 < int_10) {
        int_16 = int_8;
        int_17 = int_10;
      } else {
        int_16 = int_10;
        int_17 = int_8;
      }

      if (int_12 < int_16) {
        int_16 = int_12;
      }

      if (int_14 < int_16) {
        int_16 = int_14;
      }

      if (int_12 > int_17) {
        int_17 = int_12;
      }

      if (int_14 > int_17) {
        int_17 = int_14;
      }

      int int_18;
      int int_19;
      if (int_9 < int_11) {
        int_18 = int_9;
        int_19 = int_11;
      } else {
        int_18 = int_11;
        int_19 = int_9;
      }

      if (int_13 < int_18) {
        int_18 = int_13;
      }

      if (int_15 < int_18) {
        int_18 = int_15;
      }

      if (int_13 > int_19) {
        int_19 = int_13;
      }

      if (int_15 > int_19) {
        int_19 = int_15;
      }

      int_16 >>= 12;
      int_17 = int_17 + 4095 >> 12;
      int_18 >>= 12;
      int_19 = int_19 + 4095 >> 12;
      int_16 += int_2;
      int_17 += int_2;
      int_18 += int_3;
      int_19 += int_3;
      int_16 >>= 4;
      int_17 = int_17 + 15 >> 4;
      int_18 >>= 4;
      int_19 = int_19 + 15 >> 4;
      if (int_16 < Rasterizer2d.lx) {
        int_16 = Rasterizer2d.lx;
      }

      if (int_17 > Rasterizer2d.ux) {
        int_17 = Rasterizer2d.ux;
      }

      if (int_18 < Rasterizer2d.ly) {
        int_18 = Rasterizer2d.ly;
      }

      if (int_19 > Rasterizer2d.uy) {
        int_19 = Rasterizer2d.uy;
      }

      int_17 = int_16 - int_17;
      if (int_17 < 0) {
        int_19 = int_18 - int_19;
        if (int_19 < 0) {
          int int_20 = int_18 * Rasterizer2d.targetWidth + int_16;
          final double double_1 = 1.6777216E7D / int_5;
          final int int_21 = (int) Math.floor(Math.sin(double_0) * double_1 + 0.5D);
          final int int_22 = (int) Math.floor(Math.cos(double_0) * double_1 + 0.5D);
          final int int_23 = (int_16 << 4) + 8 - int_2;
          final int int_24 = (int_18 << 4) + 8 - int_3;
          int int_25 = (int_0 << 8) - (int_24 * int_21 >> 4);
          int int_26 = (int_1 << 8) + (int_24 * int_22 >> 4);
          int int_27;
          int int_28;
          int int_29;
          int int_30;
          int int_31;
          int int_32;
          int int_33;
          if (int_22 == 0) {
            if (int_21 != 0) {
              if (int_21 < 0) {
                for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                  int_28 = int_20;
                  int_29 = int_25;
                  int_30 = int_26 + (int_23 * int_21 >> 4);
                  int_31 = int_17;
                  if (int_25 >= 0 && int_25 - (width << 12) < 0) {
                    if ((int_32 = int_30 - (height << 12)) >= 0) {
                      int_32 = (int_21 - int_32) / int_21;
                      int_31 = int_17 + int_32;
                      int_30 += int_21 * int_32;
                      int_28 = int_20 + int_32;
                    }

                    if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                      int_31 = int_32;
                    }

                    while (int_31 < 0) {
                      int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                      if (int_33 != 0) {
                        Rasterizer2d.targetBuffer[int_28++] = int_33;
                      } else {
                        ++int_28;
                      }

                      int_30 += int_21;
                      ++int_31;
                    }
                  }

                  ++int_27;
                  int_25 -= int_21;
                }

                return;
              }

              for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                int_28 = int_20;
                int_29 = int_25;
                int_30 = int_26 + (int_23 * int_21 >> 4);
                int_31 = int_17;
                if (int_25 >= 0 && int_25 - (width << 12) < 0) {
                  if (int_30 < 0) {
                    int_32 = (int_21 - 1 - int_30) / int_21;
                    int_31 = int_17 + int_32;
                    int_30 += int_21 * int_32;
                    int_28 = int_20 + int_32;
                  }

                  if ((int_32 = ((int_30 + 1) - (height << 12) - int_21) / int_21) > int_31) {
                    int_31 = int_32;
                  }

                  while (int_31 < 0) {
                    int_33 = buffer[(int_29 >> 12) + (int_30 >> 12) * width];
                    if (int_33 != 0) {
                      Rasterizer2d.targetBuffer[int_28++] = int_33;
                    } else {
                      ++int_28;
                    }

                    int_30 += int_21;
                    ++int_31;
                  }
                }

                ++int_27;
                int_25 -= int_21;
              }

              return;
            }

            for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
              int_28 = int_20;
              int_29 = int_25;
              int_30 = int_26;
              int_31 = int_17;
              if (int_25 >= 0 && int_26 >= 0 && int_25 - (width << 12) < 0
                  && int_26 - (height << 12) < 0) {
                for (; int_31 < 0; int_31++) {
                  int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                  if (int_33 != 0) {
                    Rasterizer2d.targetBuffer[int_28++] = int_33;
                  } else {
                    ++int_28;
                  }
                }
              }

              ++int_27;
            }
          } else {
            if (int_22 < 0) {
              if (int_21 == 0) {
                for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                  int_28 = int_20;
                  int_29 = (int_23 * int_22 >> 4) + int_25;
                  int_30 = int_26;
                  int_31 = int_17;
                  if (int_26 >= 0 && int_26 - (height << 12) < 0) {
                    if ((int_32 = int_29 - (width << 12)) >= 0) {
                      int_32 = (int_22 - int_32) / int_22;
                      int_31 = int_17 + int_32;
                      int_29 += int_22 * int_32;
                      int_28 = int_20 + int_32;
                    }

                    if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                      int_31 = int_32;
                    }

                    while (int_31 < 0) {
                      int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                      if (int_33 != 0) {
                        Rasterizer2d.targetBuffer[int_28++] = int_33;
                      } else {
                        ++int_28;
                      }

                      int_29 += int_22;
                      ++int_31;
                    }
                  }

                  ++int_27;
                  int_26 += int_22;
                }

                return;
              }

              if (int_21 < 0) {
                for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                  int_28 = int_20;
                  int_29 = int_25 + (int_23 * int_22 >> 4);
                  int_30 = int_26 + (int_23 * int_21 >> 4);
                  int_31 = int_17;
                  if ((int_32 = int_29 - (width << 12)) >= 0) {
                    int_32 = (int_22 - int_32) / int_22;
                    int_31 = int_17 + int_32;
                    int_29 += int_22 * int_32;
                    int_30 += int_21 * int_32;
                    int_28 = int_20 + int_32;
                  }

                  if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                    int_31 = int_32;
                  }

                  if ((int_32 = int_30 - (height << 12)) >= 0) {
                    int_32 = (int_21 - int_32) / int_21;
                    int_31 += int_32;
                    int_29 += int_22 * int_32;
                    int_30 += int_21 * int_32;
                    int_28 += int_32;
                  }

                  if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                    int_31 = int_32;
                  }

                  while (int_31 < 0) {
                    int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                    if (int_33 != 0) {
                      Rasterizer2d.targetBuffer[int_28++] = int_33;
                    } else {
                      ++int_28;
                    }

                    int_29 += int_22;
                    int_30 += int_21;
                    ++int_31;
                  }

                  ++int_27;
                  int_25 -= int_21;
                  int_26 += int_22;
                }

                return;
              }

              for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                int_28 = int_20;
                int_29 = int_25 + (int_23 * int_22 >> 4);
                int_30 = int_26 + (int_23 * int_21 >> 4);
                int_31 = int_17;
                if ((int_32 = int_29 - (width << 12)) >= 0) {
                  int_32 = (int_22 - int_32) / int_22;
                  int_31 = int_17 + int_32;
                  int_29 += int_22 * int_32;
                  int_30 += int_21 * int_32;
                  int_28 = int_20 + int_32;
                }

                if ((int_32 = (int_29 - int_22) / int_22) > int_31) {
                  int_31 = int_32;
                }

                if (int_30 < 0) {
                  int_32 = (int_21 - 1 - int_30) / int_21;
                  int_31 += int_32;
                  int_29 += int_22 * int_32;
                  int_30 += int_21 * int_32;
                  int_28 += int_32;
                }

                if ((int_32 = ((int_30 + 1) - (height << 12) - int_21) / int_21) > int_31) {
                  int_31 = int_32;
                }

                while (int_31 < 0) {
                  int_33 = buffer[(int_29 >> 12) + (int_30 >> 12) * width];
                  if (int_33 != 0) {
                    Rasterizer2d.targetBuffer[int_28++] = int_33;
                  } else {
                    ++int_28;
                  }

                  int_29 += int_22;
                  int_30 += int_21;
                  ++int_31;
                }

                ++int_27;
                int_25 -= int_21;
                int_26 += int_22;
              }

              return;
            }

            if (int_21 == 0) {
              for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                int_28 = int_20;
                int_29 = int_25 + (int_23 * int_22 >> 4);
                int_30 = int_26;
                int_31 = int_17;
                if (int_26 >= 0 && int_26 - (height << 12) < 0) {
                  if (int_29 < 0) {
                    int_32 = (int_22 - 1 - int_29) / int_22;
                    int_31 = int_17 + int_32;
                    int_29 += int_22 * int_32;
                    int_28 = int_20 + int_32;
                  }

                  if ((int_32 = ((int_29 + 1) - (width << 12) - int_22) / int_22) > int_31) {
                    int_31 = int_32;
                  }

                  while (int_31 < 0) {
                    int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                    if (int_33 != 0) {
                      Rasterizer2d.targetBuffer[int_28++] = int_33;
                    } else {
                      ++int_28;
                    }

                    int_29 += int_22;
                    ++int_31;
                  }
                }

                ++int_27;
                int_26 += int_22;
              }

              return;
            }

            if (int_21 < 0) {
              for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
                int_28 = int_20;
                int_29 = int_25 + (int_23 * int_22 >> 4);
                int_30 = int_26 + (int_23 * int_21 >> 4);
                int_31 = int_17;
                if (int_29 < 0) {
                  int_32 = (int_22 - 1 - int_29) / int_22;
                  int_31 = int_17 + int_32;
                  int_29 += int_22 * int_32;
                  int_30 += int_21 * int_32;
                  int_28 = int_20 + int_32;
                }

                if ((int_32 = ((int_29 + 1) - (width << 12) - int_22) / int_22) > int_31) {
                  int_31 = int_32;
                }

                if ((int_32 = int_30 - (height << 12)) >= 0) {
                  int_32 = (int_21 - int_32) / int_21;
                  int_31 += int_32;
                  int_29 += int_22 * int_32;
                  int_30 += int_21 * int_32;
                  int_28 += int_32;
                }

                if ((int_32 = (int_30 - int_21) / int_21) > int_31) {
                  int_31 = int_32;
                }

                while (int_31 < 0) {
                  int_33 = buffer[(int_29 >> 12) + (int_30 >> 12) * width];
                  if (int_33 != 0) {
                    Rasterizer2d.targetBuffer[int_28++] = int_33;
                  } else {
                    ++int_28;
                  }

                  int_29 += int_22;
                  int_30 += int_21;
                  ++int_31;
                }

                ++int_27;
                int_25 -= int_21;
                int_26 += int_22;
              }

              return;
            }

            for (int_27 = int_19; int_27 < 0; int_20 += Rasterizer2d.targetWidth) {
              int_28 = int_20;
              int_29 = (int_23 * int_22 >> 4) + int_25;
              int_30 = (int_23 * int_21 >> 4) + int_26;
              int_31 = int_17;
              if (int_29 < 0) {
                int_32 = (int_22 - 1 - int_29) / int_22;
                int_31 = int_17 + int_32;
                int_29 += int_22 * int_32;
                int_30 += int_21 * int_32;
                int_28 = int_20 + int_32;
              }

              if ((int_32 = ((int_29 + 1) - (width << 12) - int_22) / int_22) > int_31) {
                int_31 = int_32;
              }

              if (int_30 < 0) {
                int_32 = (int_21 - 1 - int_30) / int_21;
                int_31 += int_32;
                int_29 += int_22 * int_32;
                int_30 += int_21 * int_32;
                int_28 += int_32;
              }

              if ((int_32 = ((int_30 + 1) - (height << 12) - int_21) / int_21) > int_31) {
                int_31 = int_32;
              }

              while (int_31 < 0) {
                int_33 = buffer[(int_30 >> 12) * width + (int_29 >> 12)];
                if (int_33 != 0) {
                  Rasterizer2d.targetBuffer[int_28++] = int_33;
                } else {
                  ++int_28;
                }

                int_29 += int_22;
                int_30 += int_21;
                ++int_31;
              }

              ++int_27;
              int_25 -= int_21;
              int_26 += int_22;
            }
          }

        }
      }
    }
  }

  public void method940(int int_0, int int_1, int int_2, int int_3) {
    if (int_2 > 0 && int_3 > 0) {
      final int int_4 = width;
      final int int_5 = height;
      int int_6 = 0;
      int int_7 = 0;
      final int int_8 = unpackedWidth;
      final int int_9 = unpackedHeight;
      final int int_10 = (int_8 << 16) / int_2;
      final int int_11 = (int_9 << 16) / int_3;
      int int_12;
      if (offsetX > 0) {
        int_12 = (int_10 + (offsetX << 16) - 1) / int_10;
        int_0 += int_12;
        int_6 += int_12 * int_10 - (offsetX << 16);
      }

      if (offsetY > 0) {
        int_12 = (int_11 + (offsetY << 16) - 1) / int_11;
        int_1 += int_12;
        int_7 += int_12 * int_11 - (offsetY << 16);
      }

      if (int_4 < int_8) {
        int_2 = (int_10 + (int_4 << 16) - int_6 - 1) / int_10;
      }

      if (int_5 < int_9) {
        int_3 = (int_11 + (int_5 << 16) - int_7 - 1) / int_11;
      }

      int_12 = int_0 + int_1 * Rasterizer2d.targetWidth;
      int int_13 = Rasterizer2d.targetWidth - int_2;
      if (int_1 + int_3 > Rasterizer2d.uy) {
        int_3 -= int_1 + int_3 - Rasterizer2d.uy;
      }

      int int_14;
      if (int_1 < Rasterizer2d.ly) {
        int_14 = Rasterizer2d.ly - int_1;
        int_3 -= int_14;
        int_12 += int_14 * Rasterizer2d.targetWidth;
        int_7 += int_11 * int_14;
      }

      if (int_2 + int_0 > Rasterizer2d.ux) {
        int_14 = int_2 + int_0 - Rasterizer2d.ux;
        int_2 -= int_14;
        int_13 += int_14;
      }

      if (int_0 < Rasterizer2d.lx) {
        int_14 = Rasterizer2d.lx - int_0;
        int_2 -= int_14;
        int_12 += int_14;
        int_6 += int_10 * int_14;
        int_13 += int_14;
      }

      method963(Rasterizer2d.targetBuffer, buffer, 0, int_6, int_7, int_12, int_13, int_2, int_3,
          int_10, int_11,
          int_4);
    }
  }

  public void method941(final int int_0, final int int_1, final int int_2, final int int_3) {
    if (int_2 <= unpackedWidth && int_3 <= unpackedHeight) {
      int int_4 = int_2 * offsetX / unpackedWidth + int_0;
      int int_5 = (int_2 * (offsetX + width) + unpackedWidth - 1) / unpackedWidth + int_0;
      int int_6 = int_1 + int_3 * offsetY / unpackedHeight;
      int int_7 = int_1 + ((offsetY + height) * int_3 + unpackedHeight - 1) / unpackedHeight;
      if (int_4 < Rasterizer2d.lx) {
        int_4 = Rasterizer2d.lx;
      }

      if (int_5 > Rasterizer2d.ux) {
        int_5 = Rasterizer2d.ux;
      }

      if (int_6 < Rasterizer2d.ly) {
        int_6 = Rasterizer2d.ly;
      }

      if (int_7 > Rasterizer2d.uy) {
        int_7 = Rasterizer2d.uy;
      }

      if (int_4 < int_5) {
        if (int_6 < int_7) {
          int int_8 = int_6 * Rasterizer2d.targetWidth + int_4;
          final int int_9 = Rasterizer2d.targetWidth - (int_5 - int_4);
          if (int_8 < Rasterizer2d.targetBuffer.length) {
            for (int int_10 = int_6; int_10 < int_7; int_10++) {
              for (int int_11 = int_4; int_11 < int_5; int_11++) {
                final int int_12 = int_11 - int_0 << 4;
                final int int_13 = int_10 - int_1 << 4;
                int int_14 = int_12 * unpackedWidth / int_2 - (offsetX << 4);
                int int_15 = (int_12 + 16) * unpackedWidth / int_2 - (offsetX << 4);
                int int_16 = int_13 * unpackedHeight / int_3 - (offsetY << 4);
                int int_17 = (int_13 + 16) * unpackedHeight / int_3 - (offsetY << 4);
                final int int_18 = (int_15 - int_14) * (int_17 - int_16) >> 1;
                if (int_18 != 0) {
                  if (int_14 < 0) {
                    int_14 = 0;
                  }

                  if (int_15 >= width << 4) {
                    int_15 = width << 4;
                  }

                  if (int_16 < 0) {
                    int_16 = 0;
                  }

                  if (int_17 >= height << 4) {
                    int_17 = height << 4;
                  }

                  --int_15;
                  --int_17;
                  final int int_19 = 16 - (int_14 & 0xF);
                  final int int_20 = (int_15 & 0xF) + 1;
                  final int int_21 = 16 - (int_16 & 0xF);
                  final int int_22 = (int_17 & 0xF) + 1;
                  int_14 >>= 4;
                  int_15 >>= 4;
                  int_16 >>= 4;
                  int_17 >>= 4;
                  int int_23 = 0;
                  int int_24 = 0;
                  int int_25 = 0;
                  int int_26 = 0;

                  int int_27;
                  for (int_27 = int_16; int_27 <= int_17; int_27++) {
                    int int_28 = 16;
                    if (int_27 == int_16) {
                      int_28 = int_21;
                    }

                    if (int_27 == int_17) {
                      int_28 = int_22;
                    }

                    for (int int_29 = int_14; int_29 <= int_15; int_29++) {
                      final int int_30 = buffer[int_27 * width + int_29];
                      if (int_30 != 0) {
                        int int_31;
                        if (int_29 == int_14) {
                          int_31 = int_28 * int_19;
                        } else if (int_29 == int_15) {
                          int_31 = int_28 * int_20;
                        } else {
                          int_31 = int_28 << 4;
                        }

                        int_26 += int_31;
                        int_23 += int_31 * (int_30 >> 16 & 0xFF);
                        int_24 += int_31 * (int_30 >> 8 & 0xFF);
                        int_25 += (int_30 & 0xFF) * int_31;
                      }
                    }
                  }

                  if (int_26 >= int_18) {
                    int_27 = int_25 / int_26 + (int_23 / int_26 << 16)
                        + (int_24 / int_26 << 8);
                    if (int_27 == 0) {
                      int_27 = 1;
                    }

                    Rasterizer2d.targetBuffer[int_8] = int_27;
                  }

                  ++int_8;
                }
              }

              int_8 += int_9;
            }

          }
        }
      }
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void method942(int int_0, int int_1) {
    int_0 += offsetX;
    int_1 += offsetY;
    int int_2 = int_0 + int_1 * Rasterizer2d.targetWidth;
    int int_3 = 0;
    int int_4 = height;
    int int_5 = width;
    int int_6 = Rasterizer2d.targetWidth - int_5;
    int int_7 = 0;
    int int_8;
    if (int_1 < Rasterizer2d.ly) {
      int_8 = Rasterizer2d.ly - int_1;
      int_4 -= int_8;
      int_1 = Rasterizer2d.ly;
      int_3 += int_8 * int_5;
      int_2 += int_8 * Rasterizer2d.targetWidth;
    }

    if (int_4 + int_1 > Rasterizer2d.uy) {
      int_4 -= int_4 + int_1 - Rasterizer2d.uy;
    }

    if (int_0 < Rasterizer2d.lx) {
      int_8 = Rasterizer2d.lx - int_0;
      int_5 -= int_8;
      int_0 = Rasterizer2d.lx;
      int_3 += int_8;
      int_2 += int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 + int_0 > Rasterizer2d.ux) {
      int_8 = int_5 + int_0 - Rasterizer2d.ux;
      int_5 -= int_8;
      int_7 += int_8;
      int_6 += int_8;
    }

    if (int_5 > 0) {
      if (int_4 > 0) {
        method958(Rasterizer2d.targetBuffer, buffer, int_3, int_2, int_5, int_4, int_6, int_7);
      }
    }
  }

  public void init() {
    Rasterizer2d.init(buffer, width, height);
  }

  public DirectSprite copy() {
    final DirectSprite spritepixels_1 = new DirectSprite(unpackedWidth, unpackedHeight);

    for (int int_0 = 0; int_0 < height; int_0++) {
      for (int int_1 = 0; int_1 < width; int_1++) {
        spritepixels_1.buffer[int_1 + (int_0 + offsetY) * unpackedWidth + offsetX] = buffer[
            int_0 * width + int_1];
      }
    }

    return spritepixels_1;
  }

  public void method944() {
    final int[] ints_0 = new int[width * height];
    int int_0 = 0;

    for (int int_1 = height - 1; int_1 >= 0; --int_1) {
      for (int int_2 = 0; int_2 < width; int_2++) {
        ints_0[int_0++] = buffer[int_2 + int_1 * width];
      }
    }

    buffer = ints_0;
    offsetY = unpackedHeight - height - offsetY;
  }

  public void method945() {
    final int[] ints_0 = new int[width * height];
    int int_0 = 0;

    for (int int_1 = 0; int_1 < height; int_1++) {
      for (int int_2 = width - 1; int_2 >= 0; --int_2) {
        ints_0[int_0++] = buffer[int_2 + int_1 * width];
      }
    }

    buffer = ints_0;
    offsetX = unpackedWidth - width - offsetX;
  }

  public void method946(final int int_0) {
    if (width != unpackedWidth || height != unpackedHeight) {
      int int_1 = int_0;
      if (int_0 > offsetX) {
        int_1 = offsetX;
      }

      int int_2 = int_0;
      if (int_0 + offsetX + width > unpackedWidth) {
        int_2 = unpackedWidth - offsetX - width;
      }

      int int_3 = int_0;
      if (int_0 > offsetY) {
        int_3 = offsetY;
      }

      int int_4 = int_0;
      if (int_0 + offsetY + height > unpackedHeight) {
        int_4 = unpackedHeight - offsetY - height;
      }

      final int int_5 = int_1 + int_2 + width;
      final int int_6 = int_3 + int_4 + height;
      final int[] ints_0 = new int[int_5 * int_6];

      for (int int_7 = 0; int_7 < height; int_7++) {
        for (int int_8 = 0; int_8 < width; int_8++) {
          ints_0[(int_7 + int_3) * int_5 + int_8 + int_1] = buffer[int_8 + int_7 * width];
        }
      }

      buffer = ints_0;
      width = int_5;
      height = int_6;
      offsetX -= int_1;
      offsetY -= int_3;
    }
  }

  public void method947(final int int_0) {
    final int[] ints_0 = new int[width * height];
    int int_1 = 0;

    for (int int_2 = 0; int_2 < height; int_2++) {
      for (int int_3 = 0; int_3 < width; int_3++) {
        int int_4 = buffer[int_1];
        if (int_4 == 0) {
          if (int_3 > 0 && buffer[int_1 - 1] != 0) {
            int_4 = int_0;
          } else if (int_2 > 0 && buffer[int_1 - width] != 0) {
            int_4 = int_0;
          } else if (int_3 < width - 1 && buffer[int_1 + 1] != 0) {
            int_4 = int_0;
          } else if (int_2 < height - 1 && buffer[int_1 + width] != 0) {
            int_4 = int_0;
          }
        }

        ints_0[int_1++] = int_4;
      }
    }

    buffer = ints_0;
  }

  public void method948(final int int_0) {
    for (int int_1 = height - 1; int_1 > 0; --int_1) {
      final int int_2 = int_1 * width;

      for (int int_3 = width - 1; int_3 > 0; --int_3) {
        if (buffer[int_3 + int_2] == 0 && buffer[(int_3 + int_2) - 1 - width] != 0) {
          buffer[int_3 + int_2] = int_0;
        }
      }
    }

  }

  public void method949() {
    if (width != unpackedWidth || height != unpackedHeight) {
      final int[] ints_0 = new int[unpackedWidth * unpackedHeight];

      for (int int_0 = 0; int_0 < height; int_0++) {
        for (int int_1 = 0; int_1 < width; int_1++) {
          ints_0[(int_0 + offsetY) * unpackedWidth + int_1 + offsetX] = buffer[int_1 +
              int_0 * width];
        }
      }

      buffer = ints_0;
      width = unpackedWidth;
      height = unpackedHeight;
      offsetX = 0;
      offsetY = 0;
    }
  }

  public void method950(int int_0, int int_1, final int int_2, final int int_3, final int int_4,
      final int int_5,
      final int int_6, final int int_7, final int[] ints_0, final int[] ints_1) {
    try {
      final int int_8 = -int_2 / 2;
      final int int_9 = -int_3 / 2;
      int int_10 = (int) (Math.sin(int_6 / 326.11D) * 65536.0D);
      int int_11 = (int) (Math.cos(int_6 / 326.11D) * 65536.0D);
      int_10 = int_10 * int_7 >> 8;
      int_11 = int_11 * int_7 >> 8;
      int int_12 = (int_4 << 16) + int_9 * int_10 + int_8 * int_11;
      int int_13 = int_9 * int_11 - int_8 * int_10 + (int_5 << 16);
      int int_14 = int_0 + int_1 * Rasterizer2d.targetWidth;

      for (int_1 = 0; int_1 < int_3; int_1++) {
        final int int_15 = ints_0[int_1];
        int int_16 = int_14 + int_15;
        int int_17 = int_12 + int_11 * int_15;
        int int_18 = int_13 - int_10 * int_15;

        for (int_0 = -ints_1[int_1]; int_0 < 0; int_0++) {
          Rasterizer2d.targetBuffer[int_16++] = buffer[width * (int_18 >> 16) + (int_17 >> 16)];
          int_17 += int_11;
          int_18 -= int_10;
        }

        int_12 += int_10;
        int_13 += int_11;
        int_14 += Rasterizer2d.targetWidth;
      }

    } catch (final Exception exception_0) {
    }
  }

  public void method951(int int_0, int int_1, int int_2, int int_3, final int int_4) {
    if (int_2 > 0 && int_3 > 0) {
      final int int_5 = width;
      final int int_6 = height;
      int int_7 = 0;
      int int_8 = 0;
      final int int_9 = unpackedWidth;
      final int int_10 = unpackedHeight;
      final int int_11 = (int_9 << 16) / int_2;
      final int int_12 = (int_10 << 16) / int_3;
      int int_13;
      if (offsetX > 0) {
        int_13 = (int_11 + (offsetX << 16) - 1) / int_11;
        int_0 += int_13;
        int_7 += int_13 * int_11 - (offsetX << 16);
      }

      if (offsetY > 0) {
        int_13 = (int_12 + (offsetY << 16) - 1) / int_12;
        int_1 += int_13;
        int_8 += int_13 * int_12 - (offsetY << 16);
      }

      if (int_5 < int_9) {
        int_2 = (int_11 + (int_5 << 16) - int_7 - 1) / int_11;
      }

      if (int_6 < int_10) {
        int_3 = (int_12 + (int_6 << 16) - int_8 - 1) / int_12;
      }

      int_13 = int_0 + int_1 * Rasterizer2d.targetWidth;
      int int_14 = Rasterizer2d.targetWidth - int_2;
      if (int_1 + int_3 > Rasterizer2d.uy) {
        int_3 -= int_1 + int_3 - Rasterizer2d.uy;
      }

      int int_15;
      if (int_1 < Rasterizer2d.ly) {
        int_15 = Rasterizer2d.ly - int_1;
        int_3 -= int_15;
        int_13 += int_15 * Rasterizer2d.targetWidth;
        int_8 += int_12 * int_15;
      }

      if (int_2 + int_0 > Rasterizer2d.ux) {
        int_15 = int_2 + int_0 - Rasterizer2d.ux;
        int_2 -= int_15;
        int_14 += int_15;
      }

      if (int_0 < Rasterizer2d.lx) {
        int_15 = Rasterizer2d.lx - int_0;
        int_2 -= int_15;
        int_13 += int_15;
        int_7 += int_11 * int_15;
        int_14 += int_15;
      }

      method962(Rasterizer2d.targetBuffer, buffer, 0, int_7, int_8, int_13, int_14, int_2, int_3,
          int_11, int_12,
          int_5, int_4);
    }
  }

  public void method952(final int int_0, final int int_1, final int int_2, final int int_3) {
    method939(unpackedWidth << 3, unpackedHeight << 3, int_0 << 4, int_1 << 4, int_2, int_3);
  }

  public void method953(int int_0, int int_1, final int int_2) {
    int_0 += offsetX;
    int_1 += offsetY;
    int int_3 = int_0 + int_1 * Rasterizer2d.targetWidth;
    int int_4 = 0;
    int int_5 = height;
    int int_6 = width;
    int int_7 = Rasterizer2d.targetWidth - int_6;
    int int_8 = 0;
    int int_9;
    if (int_1 < Rasterizer2d.ly) {
      int_9 = Rasterizer2d.ly - int_1;
      int_5 -= int_9;
      int_1 = Rasterizer2d.ly;
      int_4 += int_9 * int_6;
      int_3 += int_9 * Rasterizer2d.targetWidth;
    }

    if (int_5 + int_1 > Rasterizer2d.uy) {
      int_5 -= int_5 + int_1 - Rasterizer2d.uy;
    }

    if (int_0 < Rasterizer2d.lx) {
      int_9 = Rasterizer2d.lx - int_0;
      int_6 -= int_9;
      int_0 = Rasterizer2d.lx;
      int_4 += int_9;
      int_3 += int_9;
      int_8 += int_9;
      int_7 += int_9;
    }

    if (int_6 + int_0 > Rasterizer2d.ux) {
      int_9 = int_6 + int_0 - Rasterizer2d.ux;
      int_6 -= int_9;
      int_8 += int_9;
      int_7 += int_9;
    }

    if (int_6 > 0 && int_5 > 0) {
      method959(Rasterizer2d.targetBuffer, buffer, 0, int_4, int_3, int_6, int_5, int_7, int_8,
          int_2);
    }
  }

  public DirectSprite method954() {
    final DirectSprite spritepixels_1 = new DirectSprite(width, height);
    spritepixels_1.unpackedWidth = unpackedWidth;
    spritepixels_1.unpackedHeight = unpackedHeight;
    spritepixels_1.offsetX = unpackedWidth - width - offsetX;
    spritepixels_1.offsetY = offsetY;

    for (int int_0 = 0; int_0 < height; int_0++) {
      for (int int_1 = 0; int_1 < width; int_1++) {
        spritepixels_1.buffer[int_0 * width + int_1] = buffer[(int_0 * width + width) - 1
            - int_1];
      }
    }

    return spritepixels_1;
  }

  public void method955(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int[] ints_0, final int[] ints_1) {
    final int int_6 = int_1 < 0 ? -int_1 : 0;
    final int int_7 = int_1 + height <= int_5 ? height : int_5 - int_1;
    final int int_8 = int_0 < 0 ? -int_0 : 0;
    if (width + int_0 <= int_4) {
    } else {
    }

    int int_10 =
        int_2 + int_8 + (int_6 + int_1 + int_3) * Rasterizer2d.targetWidth + int_0;
    int int_11 = int_6 + int_1;

    for (int int_12 = int_6; int_12 < int_7; int_12++) {
      final int int_14 = ints_0[int_11];
      final int int_15 = ints_1[int_11++];
      int int_16 = int_10;
      int int_17;
      if (int_0 < int_14) {
        int_17 = int_14 - int_0;
        int_16 = int_10 + int_17 - int_8;
      } else {
        int_17 = int_8;
      }

      int int_9;
      if (width + int_0 <= int_14 + int_15) {
        int_9 = width;
      } else {
        int_9 = int_14 + int_15 - int_0;
      }

      for (int int_18 = int_17; int_18 < int_9; int_18++) {
        final int int_19 = buffer[int_18 + int_12 * width];
        if (int_19 != 0) {
          Rasterizer2d.targetBuffer[int_16++] = int_19;
        } else {
          ++int_16;
        }
      }

      int_10 += Rasterizer2d.targetWidth;
    }

  }

  public void method956(int int_0, int int_1, final int int_2, final int int_3, final int int_4,
      final int int_5,
      final double double_0, final int int_6) {
    try {
      final int int_7 = -int_2 / 2;
      final int int_8 = -int_3 / 2;
      int int_9 = (int) (Math.sin(double_0) * 65536.0D);
      int int_10 = (int) (Math.cos(double_0) * 65536.0D);
      int_9 = int_9 * int_6 >> 8;
      int_10 = int_10 * int_6 >> 8;
      int int_11 = int_8 * int_9 + int_7 * int_10 + (int_4 << 16);
      int int_12 = (int_5 << 16) + int_8 * int_10 - int_7 * int_9;
      int int_13 = int_0 + int_1 * Rasterizer2d.targetWidth;

      for (int_1 = 0; int_1 < int_3; int_1++) {
        int int_14 = int_13;
        int int_15 = int_11;
        int int_16 = int_12;

        for (int_0 = -int_2; int_0 < 0; int_0++) {
          final int int_17 = buffer[width * (int_16 >> 16) + (int_15 >> 16)];
          if (int_17 != 0) {
            Rasterizer2d.targetBuffer[int_14++] = int_17;
          } else {
            ++int_14;
          }

          int_15 += int_10;
          int_16 -= int_9;
        }

        int_11 += int_9;
        int_12 += int_10;
        int_13 += Rasterizer2d.targetWidth;
      }

    } catch (final Exception exception_0) {
    }
  }

  public void method957(int int_0, int int_1, final int int_2, final int int_3) {
    if (int_2 == 256) {
      method938(int_0, int_1);
    } else {
      int_0 += offsetX;
      int_1 += offsetY;
      int int_4 = int_0 + int_1 * Rasterizer2d.targetWidth;
      int int_5 = 0;
      int int_6 = height;
      int int_7 = width;
      int int_8 = Rasterizer2d.targetWidth - int_7;
      int int_9 = 0;
      int int_10;
      if (int_1 < Rasterizer2d.ly) {
        int_10 = Rasterizer2d.ly - int_1;
        int_6 -= int_10;
        int_1 = Rasterizer2d.ly;
        int_5 += int_10 * int_7;
        int_4 += int_10 * Rasterizer2d.targetWidth;
      }

      if (int_6 + int_1 > Rasterizer2d.uy) {
        int_6 -= int_6 + int_1 - Rasterizer2d.uy;
      }

      if (int_0 < Rasterizer2d.lx) {
        int_10 = Rasterizer2d.lx - int_0;
        int_7 -= int_10;
        int_0 = Rasterizer2d.lx;
        int_5 += int_10;
        int_4 += int_10;
        int_9 += int_10;
        int_8 += int_10;
      }

      if (int_7 + int_0 > Rasterizer2d.ux) {
        int_10 = int_7 + int_0 - Rasterizer2d.ux;
        int_7 -= int_10;
        int_9 += int_10;
        int_8 += int_10;
      }

      if (int_7 > 0 && int_6 > 0) {
        method961(Rasterizer2d.targetBuffer, buffer, 0, int_5, int_4, int_7, int_6, int_8, int_9,
            int_2,
            int_3);
      }
    }
  }

}
