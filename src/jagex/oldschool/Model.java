package jagex.oldschool;

import jagex.oldschool.animation.Animation;
import jagex.oldschool.animation.Frame;
import jagex.oldschool.animation.FrameBase;
import jagex.oldschool.graphics.Materials;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.scene.ItemLayer;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.script.Class34;

public class Model extends Renderable {

  public static int[] sx;
  public static int[] sy;
  static boolean[] aBoolArray6;
  static int[] anIntArray114;
  static int[] anIntArray115;
  static Model aModel1;
  static byte[] aByteArray21;
  static Model aModel2;
  static int anInt538;
  static byte[] aByteArray22;
  static int[] anIntArray116;
  static int anInt539;
  static boolean[] clipped;
  static int anInt540;
  static int[] anIntArray117;
  static int[] anIntArray118;
  static int[] yViewportBuffer;
  static int[] anIntArray119;
  static int[] anIntArray121;
  static int[] anIntArray122;
  static int[] anIntArray124;
  static int[] anIntArray125;
  static int[][] anIntArrayArray15;
  static int[] shsl;
  static int[] anIntArray126;
  static int[] HSL_TABLE;
  static int[][] anIntArrayArray16;
  static int[] anIntArray128;
  static int[] anIntArray129;
  static boolean aBool67;

  static {
    aModel2 = new Model();
    aByteArray22 = new byte[1];
    aModel1 = new Model();
    aByteArray21 = new byte[1];
    clipped = new boolean[4700];
    aBoolArray6 = new boolean[4700];
    sx = new int[4700];
    sy = new int[4700];
    anIntArray126 = new int[4700];
    yViewportBuffer = new int[4700];
    anIntArray119 = new int[4700];
    anIntArray117 = new int[4700];
    anIntArray114 = new int[1600];
    anIntArrayArray15 = new int[1600][512];
    anIntArray121 = new int[12];
    anIntArrayArray16 = new int[12][2000];
    anIntArray128 = new int[2000];
    anIntArray129 = new int[2000];
    anIntArray125 = new int[12];
    anIntArray118 = new int[10];
    anIntArray122 = new int[10];
    shsl = new int[10];
    aBool67 = true;
    anIntArray115 = Rasterizer3d.SINE;
    anIntArray116 = Rasterizer3d.COSINE;
    HSL_TABLE = Rasterizer3d.HSL_TABLE;
    anIntArray124 = Rasterizer3d.anIntArray113;
  }

  public int anInt542;
  public int anInt545;
  public int[] v0;
  public int fc;
  public int[] v1;
  public int[] v2;
  public int anInt549;
  public int[] hsl2;
  public int anInt550;
  public boolean aBool68;
  public int anInt551;
  public int anInt553;
  int maxRadius;
  int anInt543;
  int[][] anIntArrayArray17;
  int vc;
  int radius;
  int[] vx;
  int[] vz;
  int[] vy;
  int[][] anIntArrayArray18;
  byte aByte5;
  int maximumY;
  int anInt548;
  byte[] alpha;
  int[] hsl0;
  int[] hsl1;
  byte[] priorities;
  short[] materials;
  int minRadius;
  byte[] ti;
  int[] t0;
  int[] t1;
  int[] t2;

  Model() {
    vc = 0;
    fc = 0;
    aByte5 = 0;
    anInt548 = 0;
    aBool68 = false;
    anInt542 = -1;
    anInt550 = -1;
    anInt553 = -1;
  }

  public Model(final Model[] models_0, final int int_0) {
    vc = 0;
    fc = 0;
    aByte5 = 0;
    anInt548 = 0;
    aBool68 = false;
    anInt542 = -1;
    anInt550 = -1;
    anInt553 = -1;
    boolean bool_0 = false;
    boolean bool_1 = false;
    boolean bool_2 = false;
    boolean bool_3 = false;
    vc = 0;
    fc = 0;
    anInt548 = 0;
    aByte5 = -1;

    int int_1;
    Model model_1;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      model_1 = models_0[int_1];
      if (model_1 != null) {
        vc += model_1.vc;
        fc += model_1.fc;
        anInt548 += model_1.anInt548;
        if (model_1.priorities != null) {
          bool_0 = true;
        } else {
          if (aByte5 == -1) {
            aByte5 = model_1.aByte5;
          }

          if (aByte5 != model_1.aByte5) {
            bool_0 = true;
          }
        }

        bool_1 |= model_1.alpha != null;
        bool_2 |= model_1.materials != null;
        bool_3 |= model_1.ti != null;
      }
    }

    vx = new int[vc];
    vy = new int[vc];
    vz = new int[vc];
    v0 = new int[fc];
    v1 = new int[fc];
    v2 = new int[fc];
    hsl0 = new int[fc];
    hsl1 = new int[fc];
    hsl2 = new int[fc];
    if (bool_0) {
      priorities = new byte[fc];
    }

    if (bool_1) {
      alpha = new byte[fc];
    }

    if (bool_2) {
      materials = new short[fc];
    }

    if (bool_3) {
      ti = new byte[fc];
    }

    if (anInt548 > 0) {
      t0 = new int[anInt548];
      t1 = new int[anInt548];
      t2 = new int[anInt548];
    }

    vc = 0;
    fc = 0;
    anInt548 = 0;

    for (int_1 = 0; int_1 < int_0; int_1++) {
      model_1 = models_0[int_1];
      if (model_1 != null) {
        int int_2;
        for (int_2 = 0; int_2 < model_1.fc; int_2++) {
          v0[fc] = vc + model_1.v0[int_2];
          v1[fc] = vc + model_1.v1[int_2];
          v2[fc] = vc + model_1.v2[int_2];
          hsl0[fc] = model_1.hsl0[int_2];
          hsl1[fc] = model_1.hsl1[int_2];
          hsl2[fc] = model_1.hsl2[int_2];
          if (bool_0) {
            if (model_1.priorities != null) {
              priorities[fc] = model_1.priorities[int_2];
            } else {
              priorities[fc] = model_1.aByte5;
            }
          }

          if (bool_1 && model_1.alpha != null) {
            alpha[fc] = model_1.alpha[int_2];
          }

          if (bool_2) {
            if (model_1.materials != null) {
              materials[fc] = model_1.materials[int_2];
            } else {
              materials[fc] = -1;
            }
          }

          if (bool_3) {
            if (model_1.ti != null && model_1.ti[int_2] != -1) {
              ti[fc] = (byte) (anInt548 + model_1.ti[int_2]);
            } else {
              ti[fc] = -1;
            }
          }

          ++fc;
        }

        for (int_2 = 0; int_2 < model_1.anInt548; int_2++) {
          t0[anInt548] = vc + model_1.t0[int_2];
          t1[anInt548] = vc + model_1.t1[int_2];
          t2[anInt548] = vc + model_1.t2[int_2];
          ++anInt548;
        }

        for (int_2 = 0; int_2 < model_1.vc; int_2++) {
          vx[vc] = model_1.vx[int_2];
          vy[vc] = model_1.vy[int_2];
          vz[vc] = model_1.vz[int_2];
          ++vc;
        }
      }
    }

  }

  public void calculateRectangularBounds() {
    if (anInt543 != 1) {
      anInt543 = 1;
      super.minimumY = 0;
      maximumY = 0;
      radius = 0;

      for (int int_0 = 0; int_0 < vc; int_0++) {
        final int x = vx[int_0];
        final int y = vy[int_0];
        final int z = vz[int_0];
        if (-y > super.minimumY) {
          super.minimumY = -y;
        }

        if (y > maximumY) {
          maximumY = y;
        }

        final int radius = x * x + z * z;
        if (radius > this.radius) {
          this.radius = radius;
        }
      }

      radius = (int) (Math.sqrt(radius) + 0.99D);
      minRadius = (int) (Math.sqrt(radius * radius + super.minimumY * super.minimumY) + 0.99D);
      maxRadius = minRadius + (int) (Math.sqrt(radius * radius + maximumY * maximumY) + 0.99D);
    }
  }

  final void method967(final int int_0) {
    final int int_1 = Rasterizer3d.cx;
    final int int_2 = Rasterizer3d.cy;
    int int_3 = 0;
    final int int_4 = v0[int_0];
    final int int_5 = v1[int_0];
    final int int_6 = v2[int_0];
    final int int_7 = anIntArray117[int_4];
    final int int_8 = anIntArray117[int_5];
    final int int_9 = anIntArray117[int_6];
    if (alpha == null) {
      Rasterizer3d.alpha = 0;
    } else {
      Rasterizer3d.alpha = alpha[int_0] & 0xFF;
    }

    int int_10;
    int int_11;
    int int_12;
    int int_13;
    if (int_7 >= 50) {
      anIntArray118[int_3] = sx[int_4];
      anIntArray122[int_3] = sy[int_4];
      shsl[int_3++] = hsl0[int_0];
    } else {
      int_10 = yViewportBuffer[int_4];
      int_11 = anIntArray119[int_4];
      int_12 = hsl0[int_0];
      if (int_9 >= 50) {
        int_13 = anIntArray124[int_9 - int_7] * (50 - int_7);
        anIntArray118[int_3] = int_1
            + Rasterizer3d.scaleFactor * (int_10 + ((yViewportBuffer[int_6] - int_10) * int_13
                >> 16))
                / 50;
        anIntArray122[int_3] = int_2
            + (int_11 + ((anIntArray119[int_6] - int_11) * int_13 >> 16)) * Rasterizer3d.scaleFactor
                / 50;
        shsl[int_3++] = int_12 + ((hsl2[int_0] - int_12) * int_13 >> 16);
      }

      if (int_8 >= 50) {
        int_13 = anIntArray124[int_8 - int_7] * (50 - int_7);
        anIntArray118[int_3] = int_1
            + Rasterizer3d.scaleFactor * (int_10 + ((yViewportBuffer[int_5] - int_10) * int_13
                >> 16))
                / 50;
        anIntArray122[int_3] = int_2
            + (int_11 + ((anIntArray119[int_5] - int_11) * int_13 >> 16)) * Rasterizer3d.scaleFactor
                / 50;
        shsl[int_3++] = int_12 + ((hsl1[int_0] - int_12) * int_13 >> 16);
      }
    }

    if (int_8 >= 50) {
      anIntArray118[int_3] = sx[int_5];
      anIntArray122[int_3] = sy[int_5];
      shsl[int_3++] = hsl1[int_0];
    } else {
      int_10 = yViewportBuffer[int_5];
      int_11 = anIntArray119[int_5];
      int_12 = hsl1[int_0];
      if (int_7 >= 50) {
        int_13 = anIntArray124[int_7 - int_8] * (50 - int_8);
        anIntArray118[int_3] = int_1
            + Rasterizer3d.scaleFactor * (int_10 + ((yViewportBuffer[int_4] - int_10) * int_13
                >> 16))
                / 50;
        anIntArray122[int_3] = int_2
            + Rasterizer3d.scaleFactor * (int_11 + ((anIntArray119[int_4] - int_11) * int_13 >> 16))
                / 50;
        shsl[int_3++] = int_12 + ((hsl0[int_0] - int_12) * int_13 >> 16);
      }

      if (int_9 >= 50) {
        int_13 = anIntArray124[int_9 - int_8] * (50 - int_8);
        anIntArray118[int_3] = int_1
            + Rasterizer3d.scaleFactor * (int_10 + ((yViewportBuffer[int_6] - int_10) * int_13
                >> 16))
                / 50;
        anIntArray122[int_3] = int_2
            + (int_11 + ((anIntArray119[int_6] - int_11) * int_13 >> 16)) * Rasterizer3d.scaleFactor
                / 50;
        shsl[int_3++] = int_12 + ((hsl2[int_0] - int_12) * int_13 >> 16);
      }
    }

    if (int_9 >= 50) {
      anIntArray118[int_3] = sx[int_6];
      anIntArray122[int_3] = sy[int_6];
      shsl[int_3++] = hsl2[int_0];
    } else {
      int_10 = yViewportBuffer[int_6];
      int_11 = anIntArray119[int_6];
      int_12 = hsl2[int_0];
      if (int_8 >= 50) {
        int_13 = anIntArray124[int_8 - int_9] * (50 - int_9);
        anIntArray118[int_3] = int_1
            + Rasterizer3d.scaleFactor * (int_10 + ((yViewportBuffer[int_5] - int_10) * int_13
                >> 16))
                / 50;
        anIntArray122[int_3] = int_2
            + Rasterizer3d.scaleFactor * (int_11 + ((anIntArray119[int_5] - int_11) * int_13 >> 16))
                / 50;
        shsl[int_3++] = int_12 + ((hsl1[int_0] - int_12) * int_13 >> 16);
      }

      if (int_7 >= 50) {
        int_13 = anIntArray124[int_7 - int_9] * (50 - int_9);
        anIntArray118[int_3] = int_1
            + (int_10 + ((yViewportBuffer[int_4] - int_10) * int_13 >> 16))
                * Rasterizer3d.scaleFactor
                / 50;
        anIntArray122[int_3] = int_2
            + (int_11 + ((anIntArray119[int_4] - int_11) * int_13 >> 16)) * Rasterizer3d.scaleFactor
                / 50;
        shsl[int_3++] = int_12 + ((hsl0[int_0] - int_12) * int_13 >> 16);
      }
    }

    int_10 = anIntArray118[0];
    int_11 = anIntArray118[1];
    int_12 = anIntArray118[2];
    int_13 = anIntArray122[0];
    final int int_14 = anIntArray122[1];
    final int int_15 = anIntArray122[2];
    Rasterizer3d.clipped = false;
    int int_16;
    int int_17;
    int int_18;
    int int_19;
    if (int_3 == 3) {
      if (int_10 < 0 || int_11 < 0 || int_12 < 0 || int_10 > Rasterizer3d.width
          || int_11 > Rasterizer3d.width || int_12 > Rasterizer3d.width) {
        Rasterizer3d.clipped = true;
      }

      if (materials != null && materials[int_0] != -1) {
        if (ti != null && ti[int_0] != -1) {
          int_17 = ti[int_0] & 0xFF;
          int_16 = t0[int_17];
          int_18 = t1[int_17];
          int_19 = t2[int_17];
        } else {
          int_16 = int_4;
          int_18 = int_5;
          int_19 = int_6;
        }

        if (hsl2[int_0] == -1) {
          Rasterizer3d.drawTextured(int_13, int_14, int_15, int_10, int_11, int_12,
              hsl0[int_0],
              hsl0[int_0], hsl0[int_0], yViewportBuffer[int_16],
              yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray119[int_16],
              anIntArray119[int_18], anIntArray119[int_19], anIntArray117[int_16],
              anIntArray117[int_18],
              anIntArray117[int_19], materials[int_0]);
        } else {
          Rasterizer3d.drawTextured(int_13, int_14, int_15, int_10, int_11, int_12,
              shsl[0],
              shsl[1], shsl[2], yViewportBuffer[int_16],
              yViewportBuffer[int_18],
              yViewportBuffer[int_19], anIntArray119[int_16], anIntArray119[int_18],
              anIntArray119[int_19], anIntArray117[int_16], anIntArray117[int_18],
              anIntArray117[int_19],
              materials[int_0]);
        }
      } else if (hsl2[int_0] == -1) {
        Rasterizer3d.drawSolid(int_13, int_14, int_15, int_10, int_11, int_12,
            HSL_TABLE[hsl0[int_0]]);
      } else {
        Rasterizer3d.drawShaded(int_13, int_14, int_15, int_10, int_11, int_12, shsl[0],
            shsl[1], shsl[2]);
      }
    }

    if (int_3 == 4) {
      if (int_10 < 0 || int_11 < 0 || int_12 < 0 || int_10 > Rasterizer3d.width
          || int_11 > Rasterizer3d.width || int_12 > Rasterizer3d.width || anIntArray118[3] < 0
          || anIntArray118[3] > Rasterizer3d.width) {
        Rasterizer3d.clipped = true;
      }

      if (materials != null && materials[int_0] != -1) {
        if (ti != null && ti[int_0] != -1) {
          int_17 = ti[int_0] & 0xFF;
          int_16 = t0[int_17];
          int_18 = t1[int_17];
          int_19 = t2[int_17];
        } else {
          int_16 = int_4;
          int_18 = int_5;
          int_19 = int_6;
        }

        final short short_0 = materials[int_0];
        if (hsl2[int_0] == -1) {
          Rasterizer3d.drawTextured(int_13, int_14, int_15, int_10, int_11, int_12,
              hsl0[int_0],
              hsl0[int_0], hsl0[int_0], yViewportBuffer[int_16],
              yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray119[int_16],
              anIntArray119[int_18], anIntArray119[int_19], anIntArray117[int_16],
              anIntArray117[int_18],
              anIntArray117[int_19], short_0);
          Rasterizer3d.drawTextured(int_13, int_15, anIntArray122[3], int_10, int_12,
              anIntArray118[3],
              hsl0[int_0], hsl0[int_0], hsl0[int_0],
              yViewportBuffer[int_16],
              yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray119[int_16],
              anIntArray119[int_18], anIntArray119[int_19], anIntArray117[int_16],
              anIntArray117[int_18],
              anIntArray117[int_19], short_0);
        } else {
          Rasterizer3d.drawTextured(int_13, int_14, int_15, int_10, int_11, int_12,
              shsl[0],
              shsl[1], shsl[2], yViewportBuffer[int_16],
              yViewportBuffer[int_18],
              yViewportBuffer[int_19], anIntArray119[int_16], anIntArray119[int_18],
              anIntArray119[int_19], anIntArray117[int_16], anIntArray117[int_18],
              anIntArray117[int_19],
              short_0);
          Rasterizer3d.drawTextured(int_13, int_15, anIntArray122[3], int_10, int_12,
              anIntArray118[3],
              shsl[0], shsl[2], shsl[3], yViewportBuffer[int_16],
              yViewportBuffer[int_18], yViewportBuffer[int_19], anIntArray119[int_16],
              anIntArray119[int_18], anIntArray119[int_19], anIntArray117[int_16],
              anIntArray117[int_18],
              anIntArray117[int_19], short_0);
        }
      } else if (hsl2[int_0] == -1) {
        int_16 = HSL_TABLE[hsl0[int_0]];
        Rasterizer3d.drawSolid(int_13, int_14, int_15, int_10, int_11, int_12, int_16);
        Rasterizer3d
            .drawSolid(int_13, int_15, anIntArray122[3], int_10, int_12, anIntArray118[3], int_16);
      } else {
        Rasterizer3d.drawShaded(int_13, int_14, int_15, int_10, int_11, int_12, shsl[0],
            shsl[1], shsl[2]);
        Rasterizer3d.drawShaded(int_13, int_15, anIntArray122[3], int_10, int_12, anIntArray118[3],
            shsl[0], shsl[2], shsl[3]);
      }
    }
  }

  public void method968(final Animation frames_0, final int int_0) {
    if (anIntArrayArray17 != null) {
      if (int_0 != -1) {
        final Frame frame_0 = frames_0.frames[int_0];
        final FrameBase framemap_0 = frame_0.skin;
        anInt538 = 0;
        anInt539 = 0;
        anInt540 = 0;

        for (int int_1 = 0; int_1 < frame_0.anInt198; int_1++) {
          final int int_2 = frame_0.anIntArray53[int_1];
          method981(framemap_0.types[int_2], framemap_0.list[int_2], frame_0.translator_x[int_1],
              frame_0.translator_y[int_1], frame_0.translator_z[int_1]);
        }

        method969();
      }
    }
  }

  void method969() {
    anInt543 = 0;
    anInt542 = -1;
  }

  Model method970(final boolean bool_0, final Model model_1, final byte[] bytes_0) {
    model_1.vc = vc;
    model_1.fc = fc;
    model_1.anInt548 = anInt548;
    if (model_1.vx == null || model_1.vx.length < vc) {
      model_1.vx = new int[vc + 100];
      model_1.vy = new int[vc + 100];
      model_1.vz = new int[vc + 100];
    }

    int int_0;
    for (int_0 = 0; int_0 < vc; int_0++) {
      model_1.vx[int_0] = vx[int_0];
      model_1.vy[int_0] = vy[int_0];
      model_1.vz[int_0] = vz[int_0];
    }

    if (bool_0) {
      model_1.alpha = alpha;
    } else {
      model_1.alpha = bytes_0;
      if (alpha == null) {
        for (int_0 = 0; int_0 < fc; int_0++) {
          model_1.alpha[int_0] = 0;
        }
      } else {
        for (int_0 = 0; int_0 < fc; int_0++) {
          model_1.alpha[int_0] = alpha[int_0];
        }
      }
    }

    model_1.v0 = v0;
    model_1.v1 = v1;
    model_1.v2 = v2;
    model_1.hsl0 = hsl0;
    model_1.hsl1 = hsl1;
    model_1.hsl2 = hsl2;
    model_1.priorities = priorities;
    model_1.ti = ti;
    model_1.materials = materials;
    model_1.aByte5 = aByte5;
    model_1.t0 = t0;
    model_1.t1 = t1;
    model_1.t2 = t2;
    model_1.anIntArrayArray17 = anIntArrayArray17;
    model_1.anIntArrayArray18 = anIntArrayArray18;
    model_1.aBool68 = aBool68;
    model_1.method969();
    return model_1;
  }

  void method971(final int int_0) {
    if (anInt542 == -1) {
      int int_1 = 0;
      int int_2 = 0;
      int int_3 = 0;
      int int_4 = 0;
      int int_5 = 0;
      int int_6 = 0;
      final int int_7 = anIntArray116[int_0];
      final int int_8 = anIntArray115[int_0];

      for (int int_9 = 0; int_9 < vc; int_9++) {
        final int int_10 = Rasterizer3d.method916(vx[int_9], vz[int_9], int_7, int_8);
        final int int_11 = vy[int_9];
        final int int_12 = Rasterizer3d.method917(vx[int_9], vz[int_9], int_7, int_8);
        if (int_10 < int_1) {
          int_1 = int_10;
        }

        if (int_10 > int_4) {
          int_4 = int_10;
        }

        if (int_11 < int_2) {
          int_2 = int_11;
        }

        if (int_11 > int_5) {
          int_5 = int_11;
        }

        if (int_12 < int_3) {
          int_3 = int_12;
        }

        if (int_12 > int_6) {
          int_6 = int_12;
        }
      }

      anInt545 = (int_4 + int_1) / 2;
      anInt549 = (int_5 + int_2) / 2;
      anInt551 = (int_6 + int_3) / 2;
      anInt542 = (int_4 - int_1 + 1) / 2;
      anInt550 = (int_5 - int_2 + 1) / 2;
      anInt553 = (int_6 - int_3 + 1) / 2;
      if (anInt542 < 32) {
        anInt542 = 32;
      }

      if (anInt553 < 32) {
        anInt553 = 32;
      }

      if (aBool68) {
        anInt542 += 8;
        anInt553 += 8;
      }

    }
  }

  public Model method972(final boolean bool_0) {
    if (!bool_0 && aByteArray22.length < fc) {
      aByteArray22 = new byte[fc + 100];
    }

    return method970(bool_0, aModel2, aByteArray22);
  }

  void calculateRadialBounds() {
    if (anInt543 != 2) {
      anInt543 = 2;
      radius = 0;

      for (int int_0 = 0; int_0 < vc; int_0++) {
        final int x = vx[int_0];
        final int y = vy[int_0];
        final int z = vz[int_0];
        final int int_4 = x * x + z * z + y * y;
        if (int_4 > radius) {
          radius = int_4;
        }
      }

      radius = (int) (Math.sqrt(radius) + 0.99D);
      minRadius = radius;
      maxRadius = radius + radius;
    }
  }

  public Model method974(final boolean bool_0) {
    if (!bool_0 && aByteArray21.length < fc) {
      aByteArray21 = new byte[fc + 100];
    }

    return method970(bool_0, aModel1, aByteArray21);
  }

  public void method975(final int int_0) {
    final int int_1 = anIntArray115[int_0];
    final int int_2 = anIntArray116[int_0];

    for (int int_3 = 0; int_3 < vc; int_3++) {
      final int int_4 = int_2 * vy[int_3] - int_1 * vz[int_3] >> 16;
      vz[int_3] = int_1 * vy[int_3] + int_2 * vz[int_3] >> 16;
      vy[int_3] = int_4;
    }

    method969();
  }

  public Model method976(final int[][] ints_0, final int int_0, final int int_1, final int int_2,
      final boolean bool_0, final int int_3) {
    calculateRectangularBounds();
    int int_4 = int_0 - radius;
    int int_5 = int_0 + radius;
    int int_6 = int_2 - radius;
    int int_7 = int_2 + radius;
    if (int_4 >= 0 && int_5 + 128 >> 7 < ints_0.length && int_6 >= 0
        && int_7 + 128 >> 7 < ints_0[0].length) {
      int_4 >>= 7;
      int_5 = int_5 + 127 >> 7;
      int_6 >>= 7;
      int_7 = int_7 + 127 >> 7;
      if (int_1 == ints_0[int_4][int_6] && int_1 == ints_0[int_5][int_6] && int_1
          == ints_0[int_4][int_7]
          && int_1 == ints_0[int_5][int_7]) {
        return this;
      }
      Model model_1;
      if (bool_0) {
        model_1 = new Model();
        model_1.vc = vc;
        model_1.fc = fc;
        model_1.anInt548 = anInt548;
        model_1.vx = vx;
        model_1.vz = vz;
        model_1.v0 = v0;
        model_1.v1 = v1;
        model_1.v2 = v2;
        model_1.hsl0 = hsl0;
        model_1.hsl1 = hsl1;
        model_1.hsl2 = hsl2;
        model_1.priorities = priorities;
        model_1.alpha = alpha;
        model_1.ti = ti;
        model_1.materials = materials;
        model_1.aByte5 = aByte5;
        model_1.t0 = t0;
        model_1.t1 = t1;
        model_1.t2 = t2;
        model_1.anIntArrayArray17 = anIntArrayArray17;
        model_1.anIntArrayArray18 = anIntArrayArray18;
        model_1.aBool68 = aBool68;
        model_1.vy = new int[model_1.vc];
      } else {
        model_1 = this;
      }

      int int_8;
      int int_9;
      int int_10;
      int int_11;
      int int_12;
      int int_13;
      int int_14;
      int int_15;
      int int_16;
      int int_17;
      if (int_3 == 0) {
        for (int_8 = 0; int_8 < model_1.vc; int_8++) {
          int_9 = int_0 + vx[int_8];
          int_10 = int_2 + vz[int_8];
          int_11 = int_9 & 0x7F;
          int_12 = int_10 & 0x7F;
          int_13 = int_9 >> 7;
          int_14 = int_10 >> 7;
          int_15 = ints_0[int_13][int_14] * (128 - int_11)
              + ints_0[int_13 + 1][int_14] * int_11 >> 7;
          int_16 = ints_0[int_13][int_14 + 1] * (128 - int_11)
              + ints_0[int_13 + 1][int_14 + 1] * int_11 >> 7;
          int_17 = int_15 * (128 - int_12) + int_16 * int_12 >> 7;
          model_1.vy[int_8] = int_17 + vy[int_8] - int_1;
        }
      } else {
        for (int_8 = 0; int_8 < model_1.vc; int_8++) {
          int_9 = (-vy[int_8] << 16) / super.minimumY;
          if (int_9 < int_3) {
            int_10 = int_0 + vx[int_8];
            int_11 = int_2 + vz[int_8];
            int_12 = int_10 & 0x7F;
            int_13 = int_11 & 0x7F;
            int_14 = int_10 >> 7;
            int_15 = int_11 >> 7;
            int_16 = ints_0[int_14][int_15] * (128 - int_12)
                + ints_0[int_14 + 1][int_15] * int_12 >> 7;
            int_17 = ints_0[int_14][int_15 + 1] * (128 - int_12)
                + ints_0[int_14 + 1][int_15 + 1] * int_12 >> 7;
            final int int_18 = int_16 * (128 - int_13) + int_17 * int_13 >> 7;
            model_1.vy[int_8] = vy[int_8]
                + (int_3 - int_9) * (int_18 - int_1) / int_3;
          }
        }
      }

      model_1.method969();
      return model_1;
    }
    return this;
  }

  public void method977() {
    for (int int_0 = 0; int_0 < vc; int_0++) {
      final int int_1 = vz[int_0];
      vz[int_0] = vx[int_0];
      vx[int_0] = -int_1;
    }

    method969();
  }

  @Override
  public void draw(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5,
      final int int_6, final int int_7, final int int_8) {
    anIntArray114[0] = -1;
    if (anInt543 != 1) {
      calculateRectangularBounds();
    }

    method971(int_0);
    final int int_9 = int_4 * int_7 - int_3 * int_5 >> 16;
    final int int_10 = int_1 * int_6 + int_2 * int_9 >> 16;
    final int int_11 = int_2 * radius >> 16;
    final int int_12 = int_10 + int_11;
    if (int_12 > 50) {
      if (int_10 < 3500) {
        final int int_13 = int_7 * int_3 + int_4 * int_5 >> 16;
        int int_14 = (int_13 - radius) * Rasterizer3d.scaleFactor;
        if (int_14 / int_12 < Rasterizer3d.sux) {
          int int_15 = (int_13 + radius) * Rasterizer3d.scaleFactor;
          if (int_15 / int_12 > Rasterizer3d.slx) {
            final int int_16 = int_2 * int_6 - int_9 * int_1 >> 16;
            final int int_17 = int_1 * radius >> 16;
            int int_18 = (int_16 + int_17) * Rasterizer3d.scaleFactor;
            if (int_18 / int_12 > Rasterizer3d.sly) {
              final int int_19 = (int_2 * super.minimumY >> 16) + int_17;
              int int_20 = (int_16 - int_19) * Rasterizer3d.scaleFactor;
              if (int_20 / int_12 < Rasterizer3d.suy) {
                final int int_21 = int_11 + (int_1 * super.minimumY >> 16);
                boolean bool_0 = false;
                boolean bool_1 = false;
                if (int_10 - int_21 <= 50) {
                  bool_1 = true;
                }

                final boolean bool_2 = bool_1 || anInt548 > 0;
                final int int_22 = Class56.anInt140;
                final int int_23 = Class56.anInt141;
                final boolean bool_3 = Materials.method557();
                if (Class38.aBool10 && int_8 > 0) {
                  if (Client.method610(this, int_5, int_6, int_7)) {
                    Node_Sub5.method678(this, int_5, int_6, int_7, -65281);
                  } else if (Class38.aClass40_1 == Class40.aClass40_3) {
                    Node_Sub5.method678(this, int_5, int_6, int_7, -16776961);
                  }
                }

                int int_25;
                int int_26;
                int int_27;
                int int_28;
                int int_29;
                int int_30;
                int int_31;
                if (Class38.aBool11 && int_8 > 0) {
                  int int_24 = int_10 - int_11;
                  if (int_24 <= 50) {
                    int_24 = 50;
                  }

                  if (int_13 > 0) {
                    int_25 = int_14 / int_12;
                    int_26 = int_15 / int_24;
                  } else {
                    int_26 = int_15 / int_12;
                    int_25 = int_14 / int_24;
                  }

                  if (int_16 > 0) {
                    int_27 = int_20 / int_12;
                    int_28 = int_18 / int_24;
                  } else {
                    int_28 = int_18 / int_12;
                    int_27 = int_20 / int_24;
                  }

                  int_29 = -8355840;
                  int_30 = int_22 - Rasterizer3d.cx;
                  int_31 = int_23 - Rasterizer3d.cy;
                  if (int_30 > int_25 && int_30 < int_26 && int_31 > int_27
                      && int_31 < int_28) {
                    int_29 = -256;
                  }

                  Class34.method249(int_25 + Rasterizer3d.cx, int_27 + Rasterizer3d.cy,
                      int_26 + Rasterizer3d.cx, int_28 + Rasterizer3d.cy, int_29);
                }

                boolean bool_4 = false;
                if (int_8 > 0 && bool_3) {
                  boolean bool_5 = false;
                  if (aBool67) {
                    bool_5 = Client.method610(this, int_5, int_6, int_7);
                  } else {
                    int_26 = int_10 - int_11;
                    if (int_26 <= 50) {
                      int_26 = 50;
                    }

                    if (int_13 > 0) {
                      int_14 /= int_12;
                      int_15 /= int_26;
                    } else {
                      int_15 /= int_12;
                      int_14 /= int_26;
                    }

                    if (int_16 > 0) {
                      int_20 /= int_12;
                      int_18 /= int_26;
                    } else {
                      int_18 /= int_12;
                      int_20 /= int_26;
                    }

                    int_27 = int_22 - Rasterizer3d.cx;
                    int_28 = int_23 - Rasterizer3d.cy;
                    if (int_27 > int_14 && int_27 < int_15 && int_28 > int_20
                        && int_28 < int_18) {
                      bool_5 = true;
                    }
                  }

                  if (bool_5) {
                    if (aBool68) {
                      Enum1.method600(int_8);
                    } else {
                      bool_4 = true;
                    }
                  }
                }

                int_25 = Rasterizer3d.cx;
                int_26 = Rasterizer3d.cy;
                int_27 = 0;
                int_28 = 0;
                if (int_0 != 0) {
                  int_27 = anIntArray115[int_0];
                  int_28 = anIntArray116[int_0];
                }

                for (int_29 = 0; int_29 < vc; int_29++) {
                  int_30 = vx[int_29];
                  int_31 = vy[int_29];
                  int int_32 = vz[int_29];
                  int int_33;
                  if (int_0 != 0) {
                    int_33 = int_32 * int_27 + int_30 * int_28 >> 16;
                    int_32 = int_32 * int_28 - int_30 * int_27 >> 16;
                    int_30 = int_33;
                  }

                  int_30 += int_5;
                  int_31 += int_6;
                  int_32 += int_7;
                  int_33 = int_32 * int_3 + int_4 * int_30 >> 16;
                  int_32 = int_4 * int_32 - int_30 * int_3 >> 16;
                  int_30 = int_33;
                  int_33 = int_2 * int_31 - int_32 * int_1 >> 16;
                  int_32 = int_31 * int_1 + int_2 * int_32 >> 16;
                  anIntArray126[int_29] = int_32 - int_10;
                  if (int_32 >= 50) {
                    sx[int_29] = int_25 + int_30 * Rasterizer3d.scaleFactor / int_32;
                    sy[int_29] = int_33 * Rasterizer3d.scaleFactor / int_32 + int_26;
                  } else {
                    sx[int_29] = -5000;
                    bool_0 = true;
                  }

                  if (bool_2) {
                    yViewportBuffer[int_29] = int_30;
                    anIntArray119[int_29] = int_33;
                    anIntArray117[int_29] = int_32;
                  }
                }

                try {
                  method983(bool_0, bool_4, aBool68, int_8);
                } catch (final Exception exception_0) {
                }
              }
            }
          }
        }
      }
    }
  }

  public void method978() {
    for (int int_0 = 0; int_0 < vc; int_0++) {
      vx[int_0] = -vx[int_0];
      vz[int_0] = -vz[int_0];
    }

    method969();
  }

  public void method979(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < vc; int_3++) {
      vx[int_3] = vx[int_3] * int_0 / 128;
      vy[int_3] = int_1 * vy[int_3] / 128;
      vz[int_3] = int_2 * vz[int_3] / 128;
    }

    method969();
  }

  public void method980() {
    for (int int_0 = 0; int_0 < vc; int_0++) {
      final int int_1 = vx[int_0];
      vx[int_0] = vz[int_0];
      vz[int_0] = -int_1;
    }

    method969();
  }

  void method981(final int int_0, final int[] ints_0, final int int_1, final int int_2,
      final int int_3) {
    final int int_4 = ints_0.length;
    int int_5;
    int int_6;
    int int_8;
    int int_9;
    if (int_0 == 0) {
      int_5 = 0;
      anInt538 = 0;
      anInt539 = 0;
      anInt540 = 0;

      for (int_6 = 0; int_6 < int_4; int_6++) {
        final int int_7 = ints_0[int_6];
        if (int_7 < anIntArrayArray17.length) {
          final int[] ints_1 = anIntArrayArray17[int_7];

          for (int_8 = 0; int_8 < ints_1.length; int_8++) {
            int_9 = ints_1[int_8];
            anInt538 += vx[int_9];
            anInt539 += vy[int_9];
            anInt540 += vz[int_9];
            ++int_5;
          }
        }
      }

      if (int_5 > 0) {
        anInt538 = int_1 + anInt538 / int_5;
        anInt539 = int_2 + anInt539 / int_5;
        anInt540 = int_3 + anInt540 / int_5;
      } else {
        anInt538 = int_1;
        anInt539 = int_2;
        anInt540 = int_3;
      }
    } else {
      int[] ints_2;
      int int_10;
      if (int_0 == 1) {
        for (int_5 = 0; int_5 < int_4; int_5++) {
          int_6 = ints_0[int_5];
          if (int_6 < anIntArrayArray17.length) {
            ints_2 = anIntArrayArray17[int_6];

            for (int_10 = 0; int_10 < ints_2.length; int_10++) {
              int_8 = ints_2[int_10];
              vx[int_8] += int_1;
              vy[int_8] += int_2;
              vz[int_8] += int_3;
            }
          }
        }

      } else if (int_0 == 2) {
        for (int_5 = 0; int_5 < int_4; int_5++) {
          int_6 = ints_0[int_5];
          if (int_6 < anIntArrayArray17.length) {
            ints_2 = anIntArrayArray17[int_6];

            for (int_10 = 0; int_10 < ints_2.length; int_10++) {
              int_8 = ints_2[int_10];
              vx[int_8] -= anInt538;
              vy[int_8] -= anInt539;
              vz[int_8] -= anInt540;
              int_9 = (int_1 & 0xFF) * 8;
              final int int_11 = (int_2 & 0xFF) * 8;
              final int int_12 = (int_3 & 0xFF) * 8;
              int int_13;
              int int_14;
              int int_15;
              if (int_12 != 0) {
                int_13 = anIntArray115[int_12];
                int_14 = anIntArray116[int_12];
                int_15 = int_13 * vy[int_8] + int_14 * vx[int_8] >> 16;
                vy[int_8] =
                    int_14 * vy[int_8] - int_13 * vx[int_8] >> 16;
                vx[int_8] = int_15;
              }

              if (int_9 != 0) {
                int_13 = anIntArray115[int_9];
                int_14 = anIntArray116[int_9];
                int_15 = int_14 * vy[int_8] - int_13 * vz[int_8] >> 16;
                vz[int_8] =
                    int_13 * vy[int_8] + int_14 * vz[int_8] >> 16;
                vy[int_8] = int_15;
              }

              if (int_11 != 0) {
                int_13 = anIntArray115[int_11];
                int_14 = anIntArray116[int_11];
                int_15 = int_13 * vz[int_8] + int_14 * vx[int_8] >> 16;
                vz[int_8] =
                    int_14 * vz[int_8] - int_13 * vx[int_8] >> 16;
                vx[int_8] = int_15;
              }

              vx[int_8] += anInt538;
              vy[int_8] += anInt539;
              vz[int_8] += anInt540;
            }
          }
        }

      } else if (int_0 == 3) {
        for (int_5 = 0; int_5 < int_4; int_5++) {
          int_6 = ints_0[int_5];
          if (int_6 < anIntArrayArray17.length) {
            ints_2 = anIntArrayArray17[int_6];

            for (int_10 = 0; int_10 < ints_2.length; int_10++) {
              int_8 = ints_2[int_10];
              vx[int_8] -= anInt538;
              vy[int_8] -= anInt539;
              vz[int_8] -= anInt540;
              vx[int_8] = int_1 * vx[int_8] / 128;
              vy[int_8] = int_2 * vy[int_8] / 128;
              vz[int_8] = int_3 * vz[int_8] / 128;
              vx[int_8] += anInt538;
              vy[int_8] += anInt539;
              vz[int_8] += anInt540;
            }
          }
        }

      } else if (int_0 == 5) {
        if (anIntArrayArray18 != null && alpha != null) {
          for (int_5 = 0; int_5 < int_4; int_5++) {
            int_6 = ints_0[int_5];
            if (int_6 < anIntArrayArray18.length) {
              ints_2 = anIntArrayArray18[int_6];

              for (int_10 = 0; int_10 < ints_2.length; int_10++) {
                int_8 = ints_2[int_10];
                int_9 = (alpha[int_8] & 0xFF) + int_1 * 8;
                if (int_9 < 0) {
                  int_9 = 0;
                } else if (int_9 > 255) {
                  int_9 = 255;
                }

                alpha[int_8] = (byte) int_9;
              }
            }
          }
        }

      }
    }
  }

  public void method982(final Animation frames_0, final int int_0, final Animation frames_1,
      final int int_1,
      final int[] ints_0) {
    if (int_0 != -1) {
      if (ints_0 != null && int_1 != -1) {
        final Frame frame_0 = frames_0.frames[int_0];
        final Frame frame_1 = frames_1.frames[int_1];
        final FrameBase framemap_0 = frame_0.skin;
        anInt538 = 0;
        anInt539 = 0;
        anInt540 = 0;
        byte byte_0 = 0;
        int int_5 = byte_0 + 1;
        int int_2 = ints_0[byte_0];

        int int_3;
        int int_4;
        for (int_3 = 0; int_3 < frame_0.anInt198; int_3++) {
          for (int_4 = frame_0.anIntArray53[int_3]; int_4 > int_2; int_2 = ints_0[int_5++]) {
          }

          if (int_4 != int_2 || framemap_0.types[int_4] == 0) {
            method981(framemap_0.types[int_4], framemap_0.list[int_4], frame_0.translator_x[int_3],
                frame_0.translator_y[int_3], frame_0.translator_z[int_3]);
          }
        }

        anInt538 = 0;
        anInt539 = 0;
        anInt540 = 0;
        byte_0 = 0;
        int_5 = byte_0 + 1;
        int_2 = ints_0[byte_0];

        for (int_3 = 0; int_3 < frame_1.anInt198; int_3++) {
          for (int_4 = frame_1.anIntArray53[int_3]; int_4 > int_2; int_2 = ints_0[int_5++]) {
          }

          if (int_4 == int_2 || framemap_0.types[int_4] == 0) {
            method981(framemap_0.types[int_4], framemap_0.list[int_4], frame_1.translator_x[int_3],
                frame_1.translator_y[int_3], frame_1.translator_z[int_3]);
          }
        }

        method969();
      } else {
        method968(frames_0, int_0);
      }
    }
  }

  final void method983(final boolean bool_0, boolean bool_1, final boolean bool_2,
      final int int_0) {
    if (maxRadius < 1600) {
      int int_1;
      for (int_1 = 0; int_1 < maxRadius; int_1++) {
        anIntArray114[int_1] = 0;
      }

      int_1 = bool_2 ? 20 : 5;
      if (Class38.aBool12 && bool_1) {
        GrandExchangeOffer.method175(this, int_1);
      }

      int int_2;
      int int_3;
      int int_4;
      int int_5;
      int int_6;
      int int_7;
      int int_8;
      int int_10;
      int int_11;
      int int_13;
      for (int_2 = 0; int_2 < fc; int_2++) {
        if (hsl2[int_2] != -2) {
          int_3 = v0[int_2];
          int_5 = v1[int_2];
          int_4 = v2[int_2];
          int_6 = sx[int_3];
          int_7 = sx[int_5];
          int_8 = sx[int_4];
          int int_9;
          if (!bool_0 || int_6 != -5000 && int_7 != -5000 && int_8 != -5000) {
            if (bool_1 && ItemLayer.method528(sy[int_3], sy[int_5],
                sy[int_4], int_6, int_7, int_8, int_1)) {
              Enum1.method600(int_0);
              bool_1 = false;
            }

            if ((int_6 - int_7) * (sy[int_4] - sy[int_5])
                - (int_8 - int_7) * (sy[int_3] - sy[int_5]) > 0) {
              aBoolArray6[int_2] = false;
              if (int_6 >= 0 && int_7 >= 0 && int_8 >= 0 && int_6
                  <= Rasterizer3d.width
                  && int_7 <= Rasterizer3d.width && int_8 <= Rasterizer3d.width) {
                clipped[int_2] = false;
              } else {
                clipped[int_2] = true;
              }

              int_9 = (anIntArray126[int_3] + anIntArray126[int_5] + anIntArray126[int_4]) / 3
                  + minRadius;
              anIntArrayArray15[int_9][anIntArray114[int_9]++] = int_2;
            }
          } else {
            int_9 = yViewportBuffer[int_3];
            int_10 = yViewportBuffer[int_5];
            int_11 = yViewportBuffer[int_4];
            int int_12 = anIntArray119[int_3];
            int_13 = anIntArray119[int_5];
            int int_14 = anIntArray119[int_4];
            int int_15 = anIntArray117[int_3];
            final int int_16 = anIntArray117[int_5];
            int int_17 = anIntArray117[int_4];
            int_9 -= int_10;
            int_11 -= int_10;
            int_12 -= int_13;
            int_14 -= int_13;
            int_15 -= int_16;
            int_17 -= int_16;
            final int int_18 = int_12 * int_17 - int_15 * int_14;
            final int int_19 = int_15 * int_11 - int_9 * int_17;
            final int int_20 = int_9 * int_14 - int_12 * int_11;
            if (int_10 * int_18 + int_13 * int_19 + int_16 * int_20 > 0) {
              aBoolArray6[int_2] = true;
              final int int_21 =
                  (anIntArray126[int_3] + anIntArray126[int_5] + anIntArray126[int_4])
                      / 3 + minRadius;
              anIntArrayArray15[int_21][anIntArray114[int_21]++] = int_2;
            }
          }
        }
      }

      int[] ints_0;
      if (priorities == null) {
        for (int_2 = maxRadius - 1; int_2 >= 0; --int_2) {
          int_3 = anIntArray114[int_2];
          if (int_3 > 0) {
            ints_0 = anIntArrayArray15[int_2];

            for (int_4 = 0; int_4 < int_3; int_4++) {
              draw(ints_0[int_4]);
            }
          }
        }

      } else {
        for (int_2 = 0; int_2 < 12; int_2++) {
          anIntArray121[int_2] = 0;
          anIntArray125[int_2] = 0;
        }

        for (int_2 = maxRadius - 1; int_2 >= 0; --int_2) {
          int_3 = anIntArray114[int_2];
          if (int_3 > 0) {
            ints_0 = anIntArrayArray15[int_2];

            for (int_4 = 0; int_4 < int_3; int_4++) {
              int_6 = ints_0[int_4];
              final byte byte_0 = priorities[int_6];
              int_8 = anIntArray121[byte_0]++;
              anIntArrayArray16[byte_0][int_8] = int_6;
              if (byte_0 < 10) {
                anIntArray125[byte_0] += int_2;
              } else if (byte_0 == 10) {
                anIntArray128[int_8] = int_2;
              } else {
                anIntArray129[int_8] = int_2;
              }
            }
          }
        }

        int_2 = 0;
        if (anIntArray121[1] > 0 || anIntArray121[2] > 0) {
          int_2 = (anIntArray125[1] + anIntArray125[2]) / (anIntArray121[1] + anIntArray121[2]);
        }

        int_3 = 0;
        if (anIntArray121[3] > 0 || anIntArray121[4] > 0) {
          int_3 = (anIntArray125[3] + anIntArray125[4]) / (anIntArray121[3] + anIntArray121[4]);
        }

        int_5 = 0;
        if (anIntArray121[6] > 0 || anIntArray121[8] > 0) {
          int_5 = (anIntArray125[8] + anIntArray125[6]) / (anIntArray121[8] + anIntArray121[6]);
        }

        int_6 = 0;
        int_7 = anIntArray121[10];
        int[] ints_1 = anIntArrayArray16[10];
        int[] ints_2 = anIntArray128;
        if (int_6 == int_7) {
          int_6 = 0;
          int_7 = anIntArray121[11];
          ints_1 = anIntArrayArray16[11];
          ints_2 = anIntArray129;
        }

        if (int_6 < int_7) {
          int_4 = ints_2[int_6];
        } else {
          int_4 = -1000;
        }

        for (int_10 = 0; int_10 < 10; int_10++) {
          while (int_10 == 0 && int_4 > int_2) {
            draw(ints_1[int_6++]);
            if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
              int_6 = 0;
              int_7 = anIntArray121[11];
              ints_1 = anIntArrayArray16[11];
              ints_2 = anIntArray129;
            }

            if (int_6 < int_7) {
              int_4 = ints_2[int_6];
            } else {
              int_4 = -1000;
            }
          }

          while (int_10 == 3 && int_4 > int_3) {
            draw(ints_1[int_6++]);
            if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
              int_6 = 0;
              int_7 = anIntArray121[11];
              ints_1 = anIntArrayArray16[11];
              ints_2 = anIntArray129;
            }

            if (int_6 < int_7) {
              int_4 = ints_2[int_6];
            } else {
              int_4 = -1000;
            }
          }

          while (int_10 == 5 && int_4 > int_5) {
            draw(ints_1[int_6++]);
            if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
              int_6 = 0;
              int_7 = anIntArray121[11];
              ints_1 = anIntArrayArray16[11];
              ints_2 = anIntArray129;
            }

            if (int_6 < int_7) {
              int_4 = ints_2[int_6];
            } else {
              int_4 = -1000;
            }
          }

          int_11 = anIntArray121[int_10];
          final int[] ints_3 = anIntArrayArray16[int_10];

          for (int_13 = 0; int_13 < int_11; int_13++) {
            draw(ints_3[int_13]);
          }
        }

        while (int_4 != -1000) {
          draw(ints_1[int_6++]);
          if (int_6 == int_7 && ints_1 != anIntArrayArray16[11]) {
            int_6 = 0;
            ints_1 = anIntArrayArray16[11];
            int_7 = anIntArray121[11];
            ints_2 = anIntArray129;
          }

          if (int_6 < int_7) {
            int_4 = ints_2[int_6];
          } else {
            int_4 = -1000;
          }
        }

      }
    }
  }

  final void draw(final int id) {
    if (aBoolArray6[id]) {
      method967(id);
    } else {
      final int v0 = this.v0[id];
      final int v1 = this.v1[id];
      final int v2 = this.v2[id];

      Rasterizer3d.clipped = clipped[id];
      if (alpha == null) {
        Rasterizer3d.alpha = 0;
      } else {
        Rasterizer3d.alpha = alpha[id] & 0xFF;
      }

      if (materials != null && materials[id] != -1) {
        int i0;
        int i1;
        int i2;
        if (ti != null && ti[id] != -1) {
          final int i = ti[id] & 0xFF;
          i0 = t0[i];
          i1 = t1[i];
          i2 = t2[i];
        } else {
          i0 = v0;
          i1 = v1;
          i2 = v2;
        }

        if (hsl2[id] == -1) {
          Rasterizer3d
              .drawTextured(sy[v0], sy[v1], sy[v2],
                  sx[v0], sx[v1], sx[v2],
                  hsl0[id],
                  hsl0[id], hsl0[id], yViewportBuffer[i0],
                  yViewportBuffer[i1],
                  yViewportBuffer[i2], anIntArray119[i0], anIntArray119[i1],
                  anIntArray119[i2],
                  anIntArray117[i0], anIntArray117[i1], anIntArray117[i2],
                  materials[id]);
        } else {
          Rasterizer3d
              .drawTextured(sy[v0], sy[v1], sy[v2],
                  sx[v0], sx[v1], sx[v2],
                  hsl0[id],
                  hsl1[id], hsl2[id], yViewportBuffer[i0],
                  yViewportBuffer[i1],
                  yViewportBuffer[i2], anIntArray119[i0], anIntArray119[i1],
                  anIntArray119[i2],
                  anIntArray117[i0], anIntArray117[i1], anIntArray117[i2],
                  materials[id]);
        }
      } else if (hsl2[id] == -1) {
        Rasterizer3d.drawSolid(sy[v0], sy[v1], sy[v2],
            sx[v0], sx[v1], sx[v2],
            HSL_TABLE[hsl0[id]]);
      } else {
        Rasterizer3d.drawShaded(sy[v0], sy[v1], sy[v2],
            sx[v0], sx[v1], sx[v2], hsl0[id],
            hsl1[id], hsl2[id]);
      }
    }
  }

  public void method985(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < vc; int_3++) {
      vx[int_3] += int_0;
      vy[int_3] += int_1;
      vz[int_3] += int_2;
    }

    method969();
  }

  public final void method986(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    anIntArray114[0] = -1;
    if (anInt543 != 2 && anInt543 != 1) {
      calculateRadialBounds();
    }

    final int int_7 = Rasterizer3d.cx;
    final int int_8 = Rasterizer3d.cy;
    final int int_9 = anIntArray115[int_0];
    final int int_10 = anIntArray116[int_0];
    final int int_11 = anIntArray115[int_1];
    final int int_12 = anIntArray116[int_1];
    final int int_13 = anIntArray115[int_2];
    final int int_14 = anIntArray116[int_2];
    final int int_15 = anIntArray115[int_3];
    final int int_16 = anIntArray116[int_3];
    final int int_17 = int_15 * int_5 + int_16 * int_6 >> 16;

    for (int int_18 = 0; int_18 < vc; int_18++) {
      int int_19 = vx[int_18];
      int int_20 = vy[int_18];
      int int_21 = vz[int_18];
      int int_22;
      if (int_2 != 0) {
        int_22 = int_20 * int_13 + int_19 * int_14 >> 16;
        int_20 = int_20 * int_14 - int_19 * int_13 >> 16;
        int_19 = int_22;
      }

      if (int_0 != 0) {
        int_22 = int_20 * int_10 - int_21 * int_9 >> 16;
        int_21 = int_20 * int_9 + int_21 * int_10 >> 16;
        int_20 = int_22;
      }

      if (int_1 != 0) {
        int_22 = int_21 * int_11 + int_19 * int_12 >> 16;
        int_21 = int_21 * int_12 - int_19 * int_11 >> 16;
        int_19 = int_22;
      }

      int_19 += int_4;
      int_20 += int_5;
      int_21 += int_6;
      int_22 = int_20 * int_16 - int_21 * int_15 >> 16;
      int_21 = int_20 * int_15 + int_21 * int_16 >> 16;
      anIntArray126[int_18] = int_21 - int_17;
      sx[int_18] = int_7 + int_19 * Rasterizer3d.scaleFactor / int_21;
      sy[int_18] = int_8 + int_22 * Rasterizer3d.scaleFactor / int_21;
      if (anInt548 > 0) {
        yViewportBuffer[int_18] = int_19;
        anIntArray119[int_18] = int_22;
        anIntArray117[int_18] = int_21;
      }
    }

    try {
      method983(false, false, false, 0);
    } catch (final Exception exception_0) {
    }
  }

  public final void method987(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7) {
    anIntArray114[0] = -1;
    if (anInt543 != 2 && anInt543 != 1) {
      calculateRadialBounds();
    }

    final int int_8 = Rasterizer3d.cx;
    final int int_9 = Rasterizer3d.cy;
    final int int_10 = anIntArray115[int_0];
    final int int_11 = anIntArray116[int_0];
    final int int_12 = anIntArray115[int_1];
    final int int_13 = anIntArray116[int_1];
    final int int_14 = anIntArray115[int_2];
    final int int_15 = anIntArray116[int_2];
    final int int_16 = anIntArray115[int_3];
    final int int_17 = anIntArray116[int_3];
    final int int_18 = int_16 * int_5 + int_17 * int_6 >> 16;

    for (int int_19 = 0; int_19 < vc; int_19++) {
      int int_20 = vx[int_19];
      int int_21 = vy[int_19];
      int int_22 = vz[int_19];
      int int_23;
      if (int_2 != 0) {
        int_23 = int_21 * int_14 + int_20 * int_15 >> 16;
        int_21 = int_21 * int_15 - int_20 * int_14 >> 16;
        int_20 = int_23;
      }

      if (int_0 != 0) {
        int_23 = int_21 * int_11 - int_22 * int_10 >> 16;
        int_22 = int_21 * int_10 + int_22 * int_11 >> 16;
        int_21 = int_23;
      }

      if (int_1 != 0) {
        int_23 = int_22 * int_12 + int_20 * int_13 >> 16;
        int_22 = int_22 * int_13 - int_20 * int_12 >> 16;
        int_20 = int_23;
      }

      int_20 += int_4;
      int_21 += int_5;
      int_22 += int_6;
      int_23 = int_21 * int_17 - int_22 * int_16 >> 16;
      int_22 = int_21 * int_16 + int_22 * int_17 >> 16;
      anIntArray126[int_19] = int_22 - int_18;
      sx[int_19] = int_8 + int_20 * Rasterizer3d.scaleFactor / int_7;
      sy[int_19] = int_9 + int_23 * Rasterizer3d.scaleFactor / int_7;
      if (anInt548 > 0) {
        yViewportBuffer[int_19] = int_20;
        anIntArray119[int_19] = int_23;
        anIntArray117[int_19] = int_22;
      }
    }

    try {
      method983(false, false, false, 0);
    } catch (final Exception exception_0) {
    }
  }

  public int method988() {
    calculateRectangularBounds();
    return radius;
  }

}
