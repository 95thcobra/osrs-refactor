package jagex.oldschool;

import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class Overlay extends Subnode {

  public static Cache overlays;

  static {
    overlays = new Cache(64);
  }

  public int otherRgbColor;
  public int color;
  public boolean isHidden;
  public int texture;
  public int hue;
  public int otherHue;
  public int saturation;
  public int otherSaturation;
  public int lightness;
  public int otherLightness;

  public Overlay() {
    color = 0;
    texture = -1;
    isHidden = true;
    otherRgbColor = -1;
  }

  void method714(final Buffer buffer_0, final int int_0, final int int_1) {
    if (int_0 == 1) {
      color = buffer_0.getUnsignedMedium();
    } else {
      if (int_0 == 2) {
        texture = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 5) {
        isHidden = false;
        return;
      }

      if (int_0 == 7) {
        otherRgbColor = buffer_0.getUnsignedMedium();
        return;
      }

      if (int_0 == 8) {
        return;
      }
    }

  }

  void setHSL(final int int_0) {
    final double double_1 = (int_0 >> 16 & 0xFF) / 256.0D;
    final double double_2 = (int_0 >> 8 & 0xFF) / 256.0D;
    final double double_3 = (int_0 & 0xFF) / 256.0D;
    double double_4 = double_1;
    if (double_2 < double_1) {
      double_4 = double_2;
    }

    if (double_3 < double_4) {
      double_4 = double_3;
    }

    double double_5 = double_1;
    if (double_2 > double_1) {
      double_5 = double_2;
    }

    if (double_3 > double_5) {
      double_5 = double_3;
    }

    double double_6 = 0.0D;
    double double_7 = 0.0D;
    final double double_0 = (double_5 + double_4) / 2.0D;
    if (double_5 != double_4) {
      if (double_0 < 0.5D) {
        double_7 = (double_5 - double_4) / (double_4 + double_5);
      }

      if (double_0 >= 0.5D) {
        double_7 = (double_5 - double_4) / (2.0D - double_5 - double_4);
      }

      if (double_5 == double_1) {
        double_6 = (double_2 - double_3) / (double_5 - double_4);
      } else if (double_5 == double_2) {
        double_6 = 2.0D + (double_3 - double_1) / (double_5 - double_4);
      } else if (double_3 == double_5) {
        double_6 = (double_1 - double_2) / (double_5 - double_4) + 4.0D;
      }
    }

    double_6 /= 6.0D;
    hue = (int) (256.0D * double_6);
    saturation = (int) (double_7 * 256.0D);
    lightness = (int) (double_0 * 256.0D);
    if (saturation < 0) {
      saturation = 0;
    } else if (saturation > 255) {
      saturation = 255;
    }

    if (lightness < 0) {
      lightness = 0;
    } else if (lightness > 255) {
      lightness = 255;
      return;
    }

  }

  public void post() {
    if (otherRgbColor != -1) {
      setHSL(otherRgbColor);
      otherHue = hue;
      otherSaturation = saturation;
      otherLightness = lightness;
    }

    setHSL(color);
  }

  public void decode(final Buffer buffer_0, final int int_0) {
    while (true) {
      final int int_1 = buffer_0.getUnsignedByte();
      if (int_1 == 0) {
        return;
      }

      method714(buffer_0, int_1, int_0);
    }
  }

}
