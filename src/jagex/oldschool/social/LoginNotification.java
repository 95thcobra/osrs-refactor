package jagex.oldschool.social;

import jagex.oldschool.UrlStreamRequest;
import jagex.oldschool.Class69;
import jagex.oldschool.Client;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.scene.Scene;
import jagex.oldschool.util.Time;

public class LoginNotification extends Class69 {

  public static UrlStreamRequest listFetcher;
  public int second;
  public String aString18;
  public short state;

  public LoginNotification(final String string_0, final int int_0) {
    second = (int) (Time.currentTimeMillis() / 1000L);
    aString18 = string_0;
    state = (short) int_0;
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

      Scene.method391(ints_0, 500, 800, int_2, int_3);
    }

    Client.anInt667 = int_0;
    Client.anInt668 = int_1;
    Client.viewportHeight = int_2;
    Client.viewportWidth = int_3;
  }

}
