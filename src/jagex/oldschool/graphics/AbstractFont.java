package jagex.oldschool.graphics;

import jagex.oldschool.CacheableNode_Sub2;
import jagex.oldschool.Class52;
import java.util.Random;

public abstract class AbstractFont extends Rasterizer2d {

  public static IndexedSprite[] modIcons;
  static int strikeRGB;
  static String[] aStringArray5;
  static int underlineRGB;
  static Random aRandom1;
  static int anInt554;
  static int prevShadeRGB;
  static int prevColorRGB;
  static int color;
  static int shadow;
  static int anInt555;
  static int anInt556;

  static {
    strikeRGB = -1;
    underlineRGB = -1;
    prevShadeRGB = -1;
    shadow = -1;
    prevColorRGB = 0;
    color = 0;
    anInt554 = 256;
    anInt555 = 0;
    anInt556 = 0;
    aRandom1 = new Random();
    aStringArray5 = new String[100];
  }

  public int verticalSpace;
  public int minSpacing;
  public int maxSpacing;
  int[] anIntArray136;
  byte[][] gylphs;
  int[] horizontalOffsets;
  int[] verticalOffsets;
  byte[] aByteArray26;
  int[] gylphHeights;
  int[] glyphWidths;

  AbstractFont(final byte[] bytes_0, final int[] ints_0, final int[] ints_1, final int[] ints_2,
      final int[] ints_3,
      final int[] ints_4, final byte[][] bytes_1) {
    gylphs = new byte[256][];
    verticalSpace = 0;
    horizontalOffsets = ints_0;
    verticalOffsets = ints_1;
    gylphHeights = ints_2;
    glyphWidths = ints_3;
    method992(bytes_0);
    gylphs = bytes_1;
    int int_0 = Integer.MAX_VALUE;
    int int_1 = Integer.MIN_VALUE;

    for (int int_2 = 0; int_2 < 256; int_2++) {
      if (verticalOffsets[int_2] < int_0 && glyphWidths[int_2] != 0) {
        int_0 = verticalOffsets[int_2];
      }

      if (verticalOffsets[int_2] + glyphWidths[int_2] > int_1) {
        int_1 = verticalOffsets[int_2] + glyphWidths[int_2];
      }
    }

    minSpacing = verticalSpace - int_0;
    maxSpacing = int_1 - verticalSpace;
  }

  AbstractFont(final byte[] bytes_0) {
    gylphs = new byte[256][];
    verticalSpace = 0;
    method992(bytes_0);
  }

  static int method1005(final byte[][] bytes_0, final byte[][] bytes_1, final int[] ints_0,
      final int[] ints_1,
      final int[] ints_2, final int int_0, final int int_1) {
    final int int_2 = ints_0[int_0];
    final int int_3 = int_2 + ints_2[int_0];
    final int int_4 = ints_0[int_1];
    final int int_5 = int_4 + ints_2[int_1];
    int int_6 = int_2;
    if (int_4 > int_2) {
      int_6 = int_4;
    }

    int int_7 = int_3;
    if (int_5 < int_3) {
      int_7 = int_5;
    }

    int int_8 = ints_1[int_0];
    if (ints_1[int_1] < int_8) {
      int_8 = ints_1[int_1];
    }

    final byte[] bytes_2 = bytes_1[int_0];
    final byte[] bytes_3 = bytes_0[int_1];
    int int_9 = int_6 - int_2;
    int int_10 = int_6 - int_4;

    for (int int_11 = int_6; int_11 < int_7; int_11++) {
      final int int_12 = bytes_2[int_9++] + bytes_3[int_10++];
      if (int_12 < int_8) {
        int_8 = int_12;
      }
    }

    return -int_8;
  }

  static void renderShadeRGB(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3,
      final int int_4) {
    int int_5 = int_0 + int_1 * Rasterizer2d.targetWidth;
    int int_6 = Rasterizer2d.targetWidth - int_2;
    int int_7 = 0;
    int int_8 = 0;
    int int_9;
    if (int_1 < Rasterizer2d.ly) {
      int_9 = Rasterizer2d.ly - int_1;
      int_3 -= int_9;
      int_1 = Rasterizer2d.ly;
      int_8 += int_2 * int_9;
      int_5 += int_9 * Rasterizer2d.targetWidth;
    }

    if (int_1 + int_3 > Rasterizer2d.uy) {
      int_3 -= int_1 + int_3 - Rasterizer2d.uy;
    }

    if (int_0 < Rasterizer2d.lx) {
      int_9 = Rasterizer2d.lx - int_0;
      int_2 -= int_9;
      int_0 = Rasterizer2d.lx;
      int_8 += int_9;
      int_5 += int_9;
      int_7 += int_9;
      int_6 += int_9;
    }

    if (int_2 + int_0 > Rasterizer2d.ux) {
      int_9 = int_2 + int_0 - Rasterizer2d.ux;
      int_2 -= int_9;
      int_7 += int_9;
      int_6 += int_9;
    }

    if (int_2 > 0 && int_3 > 0) {
      render(Rasterizer2d.targetBuffer, bytes_0, int_4, int_8, int_5, int_2, int_3, int_6, int_7);
    }
  }

  static void renderShadeRGBA(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3,
      final int int_4,
      final int int_5) {
    int int_6 = int_0 + int_1 * Rasterizer2d.targetWidth;
    int int_7 = Rasterizer2d.targetWidth - int_2;
    int int_8 = 0;
    int int_9 = 0;
    int int_10;
    if (int_1 < Rasterizer2d.ly) {
      int_10 = Rasterizer2d.ly - int_1;
      int_3 -= int_10;
      int_1 = Rasterizer2d.ly;
      int_9 += int_2 * int_10;
      int_6 += int_10 * Rasterizer2d.targetWidth;
    }

    if (int_1 + int_3 > Rasterizer2d.uy) {
      int_3 -= int_1 + int_3 - Rasterizer2d.uy;
    }

    if (int_0 < Rasterizer2d.lx) {
      int_10 = Rasterizer2d.lx - int_0;
      int_2 -= int_10;
      int_0 = Rasterizer2d.lx;
      int_9 += int_10;
      int_6 += int_10;
      int_8 += int_10;
      int_7 += int_10;
    }

    if (int_2 + int_0 > Rasterizer2d.ux) {
      int_10 = int_2 + int_0 - Rasterizer2d.ux;
      int_2 -= int_10;
      int_8 += int_10;
      int_7 += int_10;
    }

    if (int_2 > 0 && int_3 > 0) {
      renderRGBA(Rasterizer2d.targetBuffer, bytes_0, int_4, int_9, int_6, int_2, int_3, int_7,
          int_8, int_5);
    }
  }

  static void renderRGBA(final int[] ints_0, final byte[] bytes_0, int int_0, int int_1, int int_2,
      final int int_3,
      final int int_4, final int int_5, final int int_6, int int_7) {
    int_0 = (int_7 * (int_0 & 0xFF00FF) & 0xFF00FF00) + ((int_0 & 0xFF00) * int_7 & 0xFF0000)
        >> 8;
    int_7 = 256 - int_7;

    for (int int_8 = -int_4; int_8 < 0; int_8++) {
      for (int int_9 = -int_3; int_9 < 0; int_9++) {
        if (bytes_0[int_1++] != 0) {
          final int int_10 = ints_0[int_2];
          ints_0[int_2++] = (((int_10 & 0xFF00) * int_7 & 0xFF0000)
              + ((int_10 & 0xFF00FF) * int_7 & 0xFF00FF00) >> 8) + int_0;
        } else {
          ++int_2;
        }
      }

      int_2 += int_5;
      int_1 += int_6;
    }

  }

  static void render(final int[] ints_0, final byte[] bytes_0, final int int_0, int int_1,
      int int_2, int int_3,
      final int int_4, final int int_5, final int int_6) {
    final int int_7 = -(int_3 >> 2);
    int_3 = -(int_3 & 0x3);

    for (int int_8 = -int_4; int_8 < 0; int_8++) {
      int int_9;
      for (int_9 = int_7; int_9 < 0; int_9++) {
        if (bytes_0[int_1++] != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        if (bytes_0[int_1++] != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        if (bytes_0[int_1++] != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }

        if (bytes_0[int_1++] != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }
      }

      for (int_9 = int_3; int_9 < 0; int_9++) {
        if (bytes_0[int_1++] != 0) {
          ints_0[int_2++] = int_0;
        } else {
          ++int_2;
        }
      }

      int_2 += int_5;
      int_1 += int_6;
    }

  }

  public static String appendTags(final String string_0) {
    final int int_0 = string_0.length();
    int int_1 = 0;

    for (int int_2 = 0; int_2 < int_0; int_2++) {
      final char char_0 = string_0.charAt(int_2);
      if (char_0 == 60 || char_0 == 62) {
        int_1 += 3;
      }
    }

    final StringBuilder stringbuilder_0 = new StringBuilder(int_0 + int_1);

    for (int int_3 = 0; int_3 < int_0; int_3++) {
      final char char_1 = string_0.charAt(int_3);
      if (char_1 == 60) {
        stringbuilder_0.append("<lt>");
      } else if (char_1 == 62) {
        stringbuilder_0.append("<gt>");
      } else {
        stringbuilder_0.append(char_1);
      }
    }

    return stringbuilder_0.toString();
  }

  void setColor(final int int_0, final int int_1) {
    strikeRGB = -1;
    underlineRGB = -1;
    prevShadeRGB = int_1;
    shadow = int_1;
    prevColorRGB = int_0;
    color = int_0;
    anInt554 = 256;
    anInt555 = 0;
    anInt556 = 0;
  }

  public int method989(final String string_0) {
    if (string_0 == null) {
      return 0;
    }
    int int_0 = -1;
    int int_1 = -1;
    int int_2 = 0;

    for (int int_3 = 0; int_3 < string_0.length(); int_3++) {
      char char_0 = string_0.charAt(int_3);
      if (char_0 == 60) {
        int_0 = int_3;
      } else {
        if (char_0 == 62 && int_0 != -1) {
          final String string_1 = string_0.substring(int_0 + 1, int_3);
          int_0 = -1;
          if (string_1.equals("lt")) {
            char_0 = 60;
          } else {
            if (!string_1.equals("gt")) {
              if (string_1.startsWith("img=")) {
                try {
                  final int int_4 = CacheableNode_Sub2.method841(string_1.substring(4));
                  int_2 += modIcons[int_4].unpackedWidth;
                  int_1 = -1;
                } catch (final Exception exception_0) {
                }
              }
              continue;
            }

            char_0 = 62;
          }
        }

        if (char_0 == 160) {
          char_0 = 32;
        }

        if (int_0 == -1) {
          int_2 += anIntArray136[(char) (Class52.method330(char_0) & 0xFF)];
          if (aByteArray26 != null && int_1 != -1) {
            int_2 += aByteArray26[char_0 + (int_1 << 8)];
          }

          int_1 = char_0;
        }
      }
    }

    return int_2;
  }

  public int method990(final String string_0, final int[] ints_0, final String[] strings_0) {
    if (string_0 == null) {
      return 0;
    }
    int int_0 = 0;
    int int_1 = 0;
    final StringBuilder stringbuilder_0 = new StringBuilder(100);
    int int_2 = -1;
    int int_3 = 0;
    byte byte_0 = 0;
    int int_4 = -1;
    char char_0 = 0;
    int int_5 = 0;
    final int int_6 = string_0.length();

    for (int int_7 = 0; int_7 < int_6; int_7++) {
      char char_1 = string_0.charAt(int_7);
      if (char_1 == 60) {
        int_4 = int_7;
      } else {
        if (char_1 == 62 && int_4 != -1) {
          final String string_2 = string_0.substring(int_4 + 1, int_7);
          int_4 = -1;
          stringbuilder_0.append('<');
          stringbuilder_0.append(string_2);
          stringbuilder_0.append('>');
          if (string_2.equals("br")) {
            strings_0[int_5] = stringbuilder_0.toString()
                .substring(int_1, stringbuilder_0.length());
            ++int_5;
            int_1 = stringbuilder_0.length();
            int_0 = 0;
            int_2 = -1;
            char_0 = 0;
          } else if (string_2.equals("lt")) {
            int_0 += method993('<');
            if (aByteArray26 != null && char_0 != -1) {
              int_0 += aByteArray26[(char_0 << 8) + 60];
            }

            char_0 = 60;
          } else if (string_2.equals("gt")) {
            int_0 += method993('>');
            if (aByteArray26 != null && char_0 != -1) {
              int_0 += aByteArray26[(char_0 << 8) + 62];
            }

            char_0 = 62;
          } else if (string_2.startsWith("img=")) {
            try {
              final String string_3 = string_2.substring(4);
              final int int_8 = Class52.parseInt(string_3, 10, true);
              int_0 += modIcons[int_8].unpackedWidth;
              char_0 = 0;
            } catch (final Exception exception_0) {
            }
          }

          char_1 = 0;
        }

        if (int_4 == -1) {
          if (char_1 != 0) {
            stringbuilder_0.append(char_1);
            int_0 += method993(char_1);
            if (aByteArray26 != null && char_0 != -1) {
              int_0 += aByteArray26[char_1 + (char_0 << 8)];
            }

            char_0 = char_1;
          }

          if (char_1 == 32) {
            int_2 = stringbuilder_0.length();
            int_3 = int_0;
            byte_0 = 1;
          }

          if (ints_0 != null && int_0 > ints_0[int_5 < ints_0.length ? int_5
              : ints_0.length - 1]
              && int_2 >= 0) {
            strings_0[int_5] = stringbuilder_0.toString().substring(int_1, int_2 - byte_0);
            ++int_5;
            int_1 = int_2;
            int_2 = -1;
            int_0 -= int_3;
            char_0 = 0;
          }

          if (char_1 == 45) {
            int_2 = stringbuilder_0.length();
            int_3 = int_0;
            byte_0 = 0;
          }
        }
      }
    }

    final String string_1 = stringbuilder_0.toString();
    if (string_1.length() > int_1) {
      strings_0[int_5++] = string_1.substring(int_1, string_1.length());
    }

    return int_5;
  }

  void method991(final String string_0, int int_0, int int_1) {
    int_1 -= verticalSpace;
    int int_2 = -1;
    int int_3 = -1;

    for (int int_4 = 0; int_4 < string_0.length(); int_4++) {
      if (string_0.charAt(int_4) != 0) {
        char char_0 = (char) (Class52.method330(string_0.charAt(int_4)) & 0xFF);
        if (char_0 == 60) {
          int_2 = int_4;
        } else {
          int int_6;
          if (char_0 == 62 && int_2 != -1) {
            final String string_1 = string_0.substring(int_2 + 1, int_4);
            int_2 = -1;
            if (string_1.equals("lt")) {
              char_0 = 60;
            } else {
              if (!string_1.equals("gt")) {
                if (string_1.startsWith("img=")) {
                  try {
                    int_6 = CacheableNode_Sub2.method841(string_1.substring(4));
                    final IndexedSprite indexedsprite_0 = modIcons[int_6];
                    indexedsprite_0.method933(int_0,
                        int_1 + verticalSpace - indexedsprite_0.unpackedHeight);
                    int_0 += indexedsprite_0.unpackedWidth;
                    int_3 = -1;
                  } catch (final Exception exception_0) {
                  }
                } else {
                  setRGB(string_1);
                }
                continue;
              }

              char_0 = 62;
            }
          }

          if (char_0 == 160) {
            char_0 = 32;
          }

          if (int_2 == -1) {
            if (aByteArray26 != null && int_3 != -1) {
              int_0 += aByteArray26[char_0 + (int_3 << 8)];
            }

            final int int_5 = gylphHeights[char_0];
            int_6 = glyphWidths[char_0];
            if (char_0 != 32) {
              if (anInt554 == 256) {
                if (shadow != -1) {
                  renderShadeRGB(gylphs[char_0], int_0 + horizontalOffsets[char_0] + 1,
                      int_1 + verticalOffsets[char_0] + 1, int_5, int_6, shadow);
                }

                renderRGB(gylphs[char_0], int_0 + horizontalOffsets[char_0],
                    int_1 + verticalOffsets[char_0], int_5, int_6, color);
              } else {
                if (shadow != -1) {
                  renderShadeRGBA(gylphs[char_0], int_0 + horizontalOffsets[char_0] + 1,
                      int_1 + verticalOffsets[char_0] + 1, int_5, int_6, shadow, anInt554);
                }

                this.renderRGBA(gylphs[char_0], int_0 + horizontalOffsets[char_0],
                    int_1 + verticalOffsets[char_0], int_5, int_6, color, anInt554);
              }
            } else if (anInt555 > 0) {
              anInt556 += anInt555;
              int_0 += anInt556 >> 8;
              anInt556 &= 0xFF;
            }

            final int int_7 = anIntArray136[char_0];
            if (strikeRGB != -1) {
              Rasterizer2d.drawHorizontalLine(int_0, int_1 + (int) (verticalSpace * 0.7D), int_7, strikeRGB);
            }

            if (underlineRGB != -1) {
              Rasterizer2d.drawHorizontalLine(int_0, int_1 + verticalSpace + 1, int_7, underlineRGB);
            }

            int_0 += int_7;
            int_3 = char_0;
          }
        }
      }
    }

  }

  void method992(final byte[] bytes_0) {
    anIntArray136 = new int[256];
    int int_0;
    if (bytes_0.length == 257) {
      for (int_0 = 0; int_0 < anIntArray136.length; int_0++) {
        anIntArray136[int_0] = bytes_0[int_0] & 0xFF;
      }

      verticalSpace = bytes_0[256] & 0xFF;
    } else {
      int_0 = 0;

      for (int int_1 = 0; int_1 < 256; int_1++) {
        anIntArray136[int_1] = bytes_0[int_0++] & 0xFF;
      }

      final int[] ints_0 = new int[256];
      final int[] ints_1 = new int[256];

      int int_2;
      for (int_2 = 0; int_2 < 256; int_2++) {
        ints_0[int_2] = bytes_0[int_0++] & 0xFF;
      }

      for (int_2 = 0; int_2 < 256; int_2++) {
        ints_1[int_2] = bytes_0[int_0++] & 0xFF;
      }

      final byte[][] bytes_1 = new byte[256][];

      int int_4;
      for (int int_3 = 0; int_3 < 256; int_3++) {
        bytes_1[int_3] = new byte[ints_0[int_3]];
        byte byte_0 = 0;

        for (int_4 = 0; int_4 < bytes_1[int_3].length; int_4++) {
          byte_0 += bytes_0[int_0++];
          bytes_1[int_3][int_4] = byte_0;
        }
      }

      final byte[][] bytes_2 = new byte[256][];

      int int_6;
      for (int_6 = 0; int_6 < 256; int_6++) {
        bytes_2[int_6] = new byte[ints_0[int_6]];
        byte byte_1 = 0;

        for (int int_5 = 0; int_5 < bytes_2[int_6].length; int_5++) {
          byte_1 += bytes_0[int_0++];
          bytes_2[int_6][int_5] = byte_1;
        }
      }

      aByteArray26 = new byte[65536];

      for (int_6 = 0; int_6 < 256; int_6++) {
        if (int_6 != 32 && int_6 != 160) {
          for (int_4 = 0; int_4 < 256; int_4++) {
            if (int_4 != 32 && int_4 != 160) {
              aByteArray26[int_4 + (int_6 << 8)] = (byte) method1005(bytes_1, bytes_2, ints_1,
                  anIntArray136, ints_0, int_6, int_4);
            }
          }
        }
      }

      verticalSpace = ints_1[32] + ints_0[32];
    }
  }

  void drawMouseoverText(final String string_0, int int_0, int int_1, final int[] ints_0,
      final int[] ints_1) {
    int_1 -= verticalSpace;
    int int_2 = -1;
    int int_3 = -1;
    int int_4 = 0;

    for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
      if (string_0.charAt(int_5) != 0) {
        char char_0 = (char) (Class52.method330(string_0.charAt(int_5)) & 0xFF);
        if (char_0 == 60) {
          int_2 = int_5;
        } else {
          int int_7;
          int int_8;
          int int_9;
          if (char_0 == 62 && int_2 != -1) {
            final String string_1 = string_0.substring(int_2 + 1, int_5);
            int_2 = -1;
            if (string_1.equals("lt")) {
              char_0 = 60;
            } else {
              if (!string_1.equals("gt")) {
                if (string_1.startsWith("img=")) {
                  try {
                    if (ints_0 != null) {
                      int_7 = ints_0[int_4];
                    } else {
                      int_7 = 0;
                    }

                    if (ints_1 != null) {
                      int_8 = ints_1[int_4];
                    } else {
                      int_8 = 0;
                    }

                    ++int_4;
                    final String string_2 = string_1.substring(4);
                    int_9 = Class52.parseInt(string_2, 10, true);
                    final IndexedSprite indexedsprite_0 = modIcons[int_9];
                    indexedsprite_0.method933(int_7 + int_0,
                        int_8 + int_1 + verticalSpace - indexedsprite_0.unpackedHeight);
                    int_0 += indexedsprite_0.unpackedWidth;
                    int_3 = -1;
                  } catch (final Exception exception_0) {
                  }
                } else {
                  setRGB(string_1);
                }
                continue;
              }

              char_0 = 62;
            }
          }

          if (char_0 == 160) {
            char_0 = 32;
          }

          if (int_2 == -1) {
            if (aByteArray26 != null && int_3 != -1) {
              int_0 += aByteArray26[char_0 + (int_3 << 8)];
            }

            final int int_6 = gylphHeights[char_0];
            int_7 = glyphWidths[char_0];
            if (ints_0 != null) {
              int_8 = ints_0[int_4];
            } else {
              int_8 = 0;
            }

            if (ints_1 != null) {
              int_9 = ints_1[int_4];
            } else {
              int_9 = 0;
            }

            ++int_4;
            if (char_0 != 32) {
              if (anInt554 == 256) {
                if (shadow != -1) {
                  renderShadeRGB(gylphs[char_0], int_8 + int_0 + horizontalOffsets[char_0] + 1,
                      int_1 + int_9 + verticalOffsets[char_0] + 1, int_6, int_7, shadow);
                }

                renderRGB(gylphs[char_0], int_8 + int_0 + horizontalOffsets[char_0],
                    int_1 + int_9 + verticalOffsets[char_0], int_6, int_7, color);
              } else {
                if (shadow != -1) {
                  renderShadeRGBA(gylphs[char_0], int_8 + int_0 + horizontalOffsets[char_0] + 1,
                      int_1 + int_9 + verticalOffsets[char_0] + 1, int_6, int_7, shadow,
                      anInt554);
                }

                this.renderRGBA(gylphs[char_0], int_8 + int_0 + horizontalOffsets[char_0],
                    int_1 + int_9 + verticalOffsets[char_0], int_6, int_7, color, anInt554);
              }
            } else if (anInt555 > 0) {
              anInt556 += anInt555;
              int_0 += anInt556 >> 8;
              anInt556 &= 0xFF;
            }

            final int int_10 = anIntArray136[char_0];
            if (strikeRGB != -1) {
              Rasterizer2d
                  .drawHorizontalLine(int_0, int_1 + (int) (verticalSpace * 0.7D), int_10, strikeRGB);
            }

            if (underlineRGB != -1) {
              Rasterizer2d.drawHorizontalLine(int_0, int_1 + verticalSpace, int_10, underlineRGB);
            }

            int_0 += int_10;
            int_3 = char_0;
          }
        }
      }
    }

  }

  int method993(char char_0) {
    if (char_0 == 160) {
      char_0 = 32;
    }

    return anIntArray136[Class52.method330(char_0) & 0xFF];
  }

  public int method994(final String string_0, final int int_0) {
    return method990(string_0, new int[] {int_0}, aStringArray5);
  }

  void setRGB(final String string_0) {
    try {
      String string_1;
      int int_0;
      if (string_0.startsWith("col=")) {
        string_1 = string_0.substring(4);
        int_0 = Class52.parseInt(string_1, 16, true);
        color = int_0;
      } else if (string_0.equals("/col")) {
        color = prevColorRGB;
      } else if (string_0.startsWith("str=")) {
        string_1 = string_0.substring(4);
        int_0 = Class52.parseInt(string_1, 16, true);
        strikeRGB = int_0;
      } else if (string_0.equals("str")) {
        strikeRGB = 8388608;
      } else if (string_0.equals("/str")) {
        strikeRGB = -1;
      } else if (string_0.startsWith("u=")) {
        string_1 = string_0.substring(2);
        int_0 = Class52.parseInt(string_1, 16, true);
        underlineRGB = int_0;
      } else if (string_0.equals("u")) {
        underlineRGB = 0;
      } else if (string_0.equals("/u")) {
        underlineRGB = -1;
      } else if (string_0.startsWith("shad=")) {
        string_1 = string_0.substring(5);
        int_0 = Class52.parseInt(string_1, 16, true);
        shadow = int_0;
      } else if (string_0.equals("shad")) {
        shadow = 0;
      } else if (string_0.equals("/shad")) {
        shadow = prevShadeRGB;
      } else {
        if (string_0.equals("br")) {
          setColor(prevColorRGB, prevShadeRGB);
        }

      }
    } catch (final Exception exception_0) {
    }
  }

  public int method995(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4, final int int_5, final int int_6, int int_7, int int_8) {
    if (string_0 == null) {
      return 0;
    }
    setColor(int_4, int_5);
    if (int_8 == 0) {
      int_8 = verticalSpace;
    }

    int[] ints_0 = new int[] {int_2};
    if (int_3 < int_8 + minSpacing + maxSpacing && int_3 < int_8 + int_8) {
      ints_0 = null;
    }

    final int int_9 = method990(string_0, ints_0, aStringArray5);
    if (int_7 == 3 && int_9 == 1) {
      int_7 = 1;
    }

    int int_10;
    int int_11;
    if (int_7 == 0) {
      int_10 = int_1 + minSpacing;
    } else if (int_7 == 1) {
      int_10 = int_1 + (int_3 - minSpacing - maxSpacing - int_8 * (int_9 - 1)) / 2 + minSpacing;
    } else if (int_7 == 2) {
      int_10 = (int_1 + int_3) - maxSpacing - int_8 * (int_9 - 1);
    } else {
      int_11 = (int_3 - minSpacing - maxSpacing - int_8 * (int_9 - 1)) / (int_9 + 1);
      if (int_11 < 0) {
        int_11 = 0;
      }

      int_10 = int_1 + int_11 + minSpacing;
      int_8 += int_11;
    }

    for (int_11 = 0; int_11 < int_9; int_11++) {
      if (int_6 == 0) {
        method991(aStringArray5[int_11], int_0, int_10);
      } else if (int_6 == 1) {
        method991(aStringArray5[int_11], int_0 + (int_2 - method989(aStringArray5[int_11])) / 2,
            int_10);
      } else if (int_6 == 2) {
        method991(aStringArray5[int_11], int_0 + int_2 - method989(aStringArray5[int_11]),
            int_10);
      } else if (int_11 == int_9 - 1) {
        method991(aStringArray5[int_11], int_0, int_10);
      } else {
        method996(aStringArray5[int_11], int_2);
        method991(aStringArray5[int_11], int_0, int_10);
        anInt555 = 0;
      }

      int_10 += int_8;
    }

    return int_9;
  }

  void method996(final String string_0, final int int_0) {
    int int_1 = 0;
    boolean bool_0 = false;

    for (int int_2 = 0; int_2 < string_0.length(); int_2++) {
      final char char_0 = string_0.charAt(int_2);
      if (char_0 == 60) {
        bool_0 = true;
      } else if (char_0 == 62) {
        bool_0 = false;
      } else if (!bool_0 && char_0 == 32) {
        ++int_1;
      }
    }

    if (int_1 > 0) {
      anInt555 = (int_0 - method989(string_0) << 8) / int_1;
    }

  }

  public abstract void renderRGB(byte[] var1, int var2, int var3, int var4, int var5, int var6);

  public abstract void renderRGBA(byte[] var1, int var2, int var3, int var4, int var5, int var6,
      int var7);

  public int method997(final String string_0, final int int_0) {
    final int int_1 = method990(string_0, new int[] {int_0}, aStringArray5);
    int int_2 = 0;

    for (int int_3 = 0; int_3 < int_1; int_3++) {
      final int int_4 = method989(aStringArray5[int_3]);
      if (int_4 > int_2) {
        int_2 = int_4;
      }
    }

    return int_2;
  }

  public void drawRandomizedMouseoverText(final String string_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      aRandom1.setSeed(int_4);
      anInt554 = 192 + (aRandom1.nextInt() & 0x1F);
      final int[] ints_0 = new int[string_0.length()];
      int int_5 = 0;

      for (int int_6 = 0; int_6 < string_0.length(); int_6++) {
        ints_0[int_6] = int_5;
        if ((aRandom1.nextInt() & 0x3) == 0) {
          ++int_5;
        }
      }

      drawMouseoverText(string_0, int_0, int_1, ints_0, null);
    }
  }

  public void method998(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      method991(string_0, int_0 - method989(string_0) / 2, int_1);
    }
  }

  public void method999(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      method991(string_0, int_0, int_1);
    }
  }

  public void method1000(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      method991(string_0, int_0 - method989(string_0), int_1);
    }
  }

  public void method1001(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      final int[] ints_0 = new int[string_0.length()];

      for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
        ints_0[int_5] = (int) (Math.sin(int_5 / 2.0D + int_4 / 5.0D) * 5.0D);
      }

      drawMouseoverText(string_0, int_0 - method989(string_0) / 2, int_1, null, ints_0);
    }
  }

  public void method1002(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      final int[] ints_0 = new int[string_0.length()];
      final int[] ints_1 = new int[string_0.length()];

      for (int int_5 = 0; int_5 < string_0.length(); int_5++) {
        ints_0[int_5] = (int) (Math.sin(int_5 / 5.0D + int_4 / 5.0D) * 5.0D);
        ints_1[int_5] = (int) (Math.sin(int_5 / 3.0D + int_4 / 5.0D) * 5.0D);
      }

      drawMouseoverText(string_0, int_0 - method989(string_0) / 2, int_1, ints_0, ints_1);
    }
  }

  public void method1003(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4, final int int_5) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      double double_0 = 7.0D - int_5 / 8.0D;
      if (double_0 < 0.0D) {
        double_0 = 0.0D;
      }

      final int[] ints_0 = new int[string_0.length()];

      for (int int_6 = 0; int_6 < string_0.length(); int_6++) {
        ints_0[int_6] = (int) (Math.sin(int_6 / 1.5D + int_4 / 1.0D) * double_0);
      }

      drawMouseoverText(string_0, int_0 - method989(string_0) / 2, int_1, null, ints_0);
    }
  }

  public void method1004(final String string_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4) {
    if (string_0 != null) {
      setColor(int_2, int_3);
      anInt554 = int_4;
      method991(string_0, int_0, int_1);
    }
  }

}
