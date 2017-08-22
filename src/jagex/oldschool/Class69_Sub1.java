package jagex.oldschool;

import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.graphics.Materials;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.util.Time;

public class Class69_Sub1 extends Class69 {

  static Class37 listFetcher;
  int second;
  String aString18;
  short aShort1;

  Class69_Sub1(final String string_0, final int int_0) {
    second = (int) (Time.currentTimeMillis() / 1000L);
    aString18 = string_0;
    aShort1 = (short) int_0;
  }

  static boolean method610(final Model model_0, final int int_0, final int int_1,
      final int int_2) {
    if (!Materials.method557()) {
      return false;
    }
    int int_3;
    int int_4;
    int int_5;
    int int_6;
    int int_7;
    int int_8;
    int int_9;
    int int_12;
    int int_13;
    if (!Class56.aBool19) {
      int_3 = Region.pitchSin;
      int_4 = Region.pitchCos;
      int_5 = Region.yawSin;
      int_6 = Region.yawCos;
      final byte byte_0 = 50;
      final short short_0 = 3500;
      int_7 = (Class56.anInt140 - Rasterizer3d.cx) * byte_0 / Rasterizer3d.anInt530;
      int_8 = (Class56.anInt141 - Rasterizer3d.cy) * byte_0 / Rasterizer3d.anInt530;
      int_9 = (Class56.anInt140 - Rasterizer3d.cx) * short_0 / Rasterizer3d.anInt530;
      int int_10 = (Class56.anInt141 - Rasterizer3d.cy) * short_0 / Rasterizer3d.anInt530;
      int int_11 = Rasterizer3d.method924(int_8, byte_0, int_4, int_3);
      int_12 = Rasterizer3d.method925(int_8, byte_0, int_4, int_3);
      int_8 = int_11;
      int_11 = Rasterizer3d.method924(int_10, short_0, int_4, int_3);
      int_13 = Rasterizer3d.method925(int_10, short_0, int_4, int_3);
      int_10 = int_11;
      int_11 = Rasterizer3d.method926(int_7, int_12, int_6, int_5);
      int_12 = Rasterizer3d.method927(int_7, int_12, int_6, int_5);
      int_7 = int_11;
      int_11 = Rasterizer3d.method926(int_9, int_13, int_6, int_5);
      int_13 = Rasterizer3d.method927(int_9, int_13, int_6, int_5);
      Class56.anInt143 = (int_11 + int_7) / 2;
      PlayerVariable.anInt495 = (int_10 + int_8) / 2;
      IntegerVariable.anInt84 = (int_13 + int_12) / 2;
      AClass3_Sub2.anInt398 = (int_11 - int_7) / 2;
      Class22.anInt73 = (int_10 - int_8) / 2;
      Enum2.anInt307 = (int_13 - int_12) / 2;
      HuffmanCodec.anInt215 = Math.abs(AClass3_Sub2.anInt398);
      LoginScreen.anInt106 = Math.abs(Class22.anInt73);
      Class16.anInt63 = Math.abs(Enum2.anInt307);
    }

    int_3 = model_0.anInt545 + int_0;
    int_4 = int_1 + model_0.anInt549;
    int_5 = int_2 + model_0.anInt551;
    int_6 = model_0.anInt542;
    int_12 = model_0.anInt550;
    int_13 = model_0.anInt553;
    int_7 = Class56.anInt143 - int_3;
    int_8 = PlayerVariable.anInt495 - int_4;
    int_9 = IntegerVariable.anInt84 - int_5;
    return Math.abs(int_7) > int_6 + HuffmanCodec.anInt215 ? false
        : Math.abs(int_8) > int_12 + LoginScreen.anInt106 ? false
            : Math.abs(int_9) > int_13 + Class16.anInt63 ? false
                : Math.abs(int_9 * Class22.anInt73 - int_8 * Enum2.anInt307) > int_12
                    * Class16.anInt63 + int_13 * LoginScreen.anInt106
                    ? false
                    : Math.abs(int_7 * Enum2.anInt307 - int_9
                        * AClass3_Sub2.anInt398) > int_6 * Class16.anInt63
                        + int_13 * HuffmanCodec.anInt215
                        ? false
                        : Math.abs(int_8 * AClass3_Sub2.anInt398
                            - int_7 * Class22.anInt73) <= int_6
                            * LoginScreen.anInt106
                            + int_12
                            * HuffmanCodec.anInt215;
  }

  public static void method611(int int_0, int int_1, int int_2, int int_3, final boolean bool_0) {
    if (int_2 < 1) {
      int_2 = 1;
    }

    if (int_3 < 1) {
      int_3 = 1;
    }

    int int_4 = int_3 - 334;
    if (int_4 < 0) {
      int_4 = 0;
    } else if (int_4 > 100) {
      int_4 = 100;
    }

    int int_5 = (Client.aShort3 - Client.aShort4) * int_4 / 100 + Client.aShort4;
    final int int_6 = int_3 * int_5 * 512 / (int_2 * 334);
    int int_7;
    int int_8;
    short short_0;
    if (int_6 < Client.aShort5) {
      short_0 = Client.aShort5;
      int_5 = short_0 * int_2 * 334 / (int_3 * 512);
      if (int_5 > Client.aShort7) {
        int_5 = Client.aShort7;
        int_7 = int_3 * int_5 * 512 / (short_0 * 334);
        int_8 = (int_2 - int_7) / 2;
        if (bool_0) {
          Rasterizer2d.resetClip();
          Rasterizer2d.fillRectangle(int_0, int_1, int_8, int_3, -16777216);
          Rasterizer2d.fillRectangle(int_0 + int_2 - int_8, int_1, int_8, int_3, -16777216);
        }

        int_0 += int_8;
        int_2 -= int_8 * 2;
      }
    } else if (int_6 > Client.aShort6) {
      short_0 = Client.aShort6;
      int_5 = short_0 * int_2 * 334 / (int_3 * 512);
      if (int_5 < Client.aShort10) {
        int_5 = Client.aShort10;
        int_7 = short_0 * int_2 * 334 / (int_5 * 512);
        int_8 = (int_3 - int_7) / 2;
        if (bool_0) {
          Rasterizer2d.resetClip();
          Rasterizer2d.fillRectangle(int_0, int_1, int_2, int_8, -16777216);
          Rasterizer2d.fillRectangle(int_0, int_3 + int_1 - int_8, int_2, int_8, -16777216);
        }

        int_1 += int_8;
        int_3 -= int_8 * 2;
      }
    }

    int_7 = (Client.aShort8 - Client.aShort9) * int_4 / 100 + Client.aShort9;
    Client.scale = int_3 * int_7 * int_5 / 85504 << 1;
    if (int_2 != Client.viewportHeight || int_3 != Client.viewportWidth) {
      final int[] ints_0 = new int[9];

      for (int int_9 = 0; int_9 < 9; int_9++) {
        final int int_10 = 15 + int_9 * 32 + 128;
        final int int_11 = int_10 * 3 + 600;
        final int int_12 = Rasterizer3d.SINE[int_10];
        ints_0[int_9] = int_12 * int_11 >> 16;
      }

      Region.method391(ints_0, 500, 800, int_2, int_3);
    }

    Client.anInt667 = int_0;
    Client.anInt668 = int_1;
    Client.viewportHeight = int_2;
    Client.viewportWidth = int_3;
  }

}
