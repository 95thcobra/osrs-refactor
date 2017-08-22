package jagex.oldschool.graphics;

public final class BitmapFont extends AbstractFont {

  public BitmapFont(final byte[] bytes_0, final int[] ints_0, final int[] ints_1, final int[] ints_2,
      final int[] ints_3,
      final int[] ints_4, final byte[][] bytes_1) {
    super(bytes_0, ints_0, ints_1, ints_2, ints_3, ints_4, bytes_1);
  }

  public BitmapFont(final byte[] bytes_0) {
    super(bytes_0);
  }

  @Override
  public final void renderRGB(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3,
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
      int_8 += int_9 * int_2;
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

    if (int_0 + int_2 > Rasterizer2d.ux) {
      int_9 = int_0 + int_2 - Rasterizer2d.ux;
      int_2 -= int_9;
      int_7 += int_9;
      int_6 += int_9;
    }

    if (int_2 > 0 && int_3 > 0) {
      AbstractFont
          .render(Rasterizer2d.targetBuffer, bytes_0, int_4, int_8, int_5, int_2, int_3, int_6,
              int_7);
    }
  }

  @Override
  public final void renderRGBA(final byte[] bytes_0, int int_0, int int_1, int int_2, int int_3,
      final int int_4,
      final int int_5) {
    int int_6 = int_1 * Rasterizer2d.targetWidth + int_0;
    int int_7 = Rasterizer2d.targetWidth - int_2;
    int int_8 = 0;
    int int_9 = 0;
    int int_10;
    if (int_1 < Rasterizer2d.ly) {
      int_10 = Rasterizer2d.ly - int_1;
      int_3 -= int_10;
      int_1 = Rasterizer2d.ly;
      int_9 += int_10 * int_2;
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

    if (int_0 + int_2 > Rasterizer2d.ux) {
      int_10 = int_0 + int_2 - Rasterizer2d.ux;
      int_2 -= int_10;
      int_8 += int_10;
      int_7 += int_10;
    }

    if (int_2 > 0 && int_3 > 0) {
      renderRGBA(Rasterizer2d.targetBuffer, bytes_0, int_4, int_9, int_6, int_2, int_3,
              int_7,
              int_8, int_5);
    }
  }

}
