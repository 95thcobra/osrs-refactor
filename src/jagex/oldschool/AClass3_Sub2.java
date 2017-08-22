package jagex.oldschool;

import jagex.oldschool.graphics.Rasterizer2d;

public final class AClass3_Sub2 extends AClass3 {

  static int anInt398;
  static int anInt399;
  final int anInt400;
  final int anInt401;
  final int anInt402;
  final int anInt403;
  final int anInt404;

  public AClass3_Sub2(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    anInt400 = int_0;
    anInt401 = int_1;
    anInt402 = int_2;
    anInt403 = int_3;
    anInt404 = int_4;
  }

  @Override
  final void method618() {
    Rasterizer2d.drawRectangle(anInt400 + Rasterizer2d.lx,
        anInt401 + Rasterizer2d.ly,
        anInt402 - anInt400, anInt403 - anInt401, anInt404);
  }

}
