package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.security.Isaac;

public class FloorUnderlayDefinition extends Subnode {

  static Cache underlays;
  static AbstractPackage underlay_ref;

  static {
    underlays = new Cache(64);
  }

  public int hue;
  public int saturation;
  public int hueMultiplier;
  public int lightness;
  int rgbColor;

  FloorUnderlayDefinition() {
    rgbColor = 0;
  }

  public static String format(final CharSequence charsequence_0, final FormatConfig class108_0) {
    if (charsequence_0 == null) {
      return null;
    }
    int start = 0;

    int end;
    for (end = charsequence_0.length(); start < end
        && AbstractPackage.isDelimiter(charsequence_0.charAt(start)); start++) {
    }

    while (end > start && AbstractPackage.isDelimiter(charsequence_0.charAt(end - 1))) {
      --end;
    }

    final int len = end - start;
    if (len < 1 || len > Node_Sub5.getMaximum(class108_0)) {
      return null;
    }
    final StringBuilder stringbuilder_0 = new StringBuilder(len);

    for (int int_3 = start; int_3 < end; int_3++) {
      final char char_0 = charsequence_0.charAt(int_3);
      if (Isaac.method484(char_0)) {
        char char_1;
        switch (char_0) {
          case ' ':
          case '-':
          case '_':
          case ' ':
            char_1 = 95;
            break;
          case '#':
          case '[':
          case ']':
            char_1 = char_0;
            break;
          case 'À':
          case 'Á':
          case 'Â':
          case 'Ã':
          case 'Ä':
          case 'à':
          case 'á':
          case 'â':
          case 'ã':
          case 'ä':
            char_1 = 97;
            break;
          case 'Ç':
          case 'ç':
            char_1 = 99;
            break;
          case 'È':
          case 'É':
          case 'Ê':
          case 'Ë':
          case 'è':
          case 'é':
          case 'ê':
          case 'ë':
            char_1 = 101;
            break;
          case 'Í':
          case 'Î':
          case 'Ï':
          case 'í':
          case 'î':
          case 'ï':
            char_1 = 105;
            break;
          case 'Ñ':
          case 'ñ':
            char_1 = 110;
            break;
          case 'Ò':
          case 'Ó':
          case 'Ô':
          case 'Õ':
          case 'Ö':
          case 'ò':
          case 'ó':
          case 'ô':
          case 'õ':
          case 'ö':
            char_1 = 111;
            break;
          case 'Ù':
          case 'Ú':
          case 'Û':
          case 'Ü':
          case 'ù':
          case 'ú':
          case 'û':
          case 'ü':
            char_1 = 117;
            break;
          case 'ß':
            char_1 = 98;
            break;
          case 'ÿ':
          case 'Ÿ':
            char_1 = 121;
            break;
          default:
            char_1 = Character.toLowerCase(char_0);
        }

        if (char_1 != 0) {
          stringbuilder_0.append(char_1);
        }
      }
    }

    if (stringbuilder_0.length() == 0) {
      return null;
    }
    return stringbuilder_0.toString();
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
    if (double_4 != double_5) {
      if (double_0 < 0.5D) {
        double_7 = (double_5 - double_4) / (double_4 + double_5);
      }

      if (double_0 >= 0.5D) {
        double_7 = (double_5 - double_4) / (2.0D - double_5 - double_4);
      }

      if (double_5 == double_1) {
        double_6 = (double_2 - double_3) / (double_5 - double_4);
      } else if (double_2 == double_5) {
        double_6 = (double_3 - double_1) / (double_5 - double_4) + 2.0D;
      } else if (double_5 == double_3) {
        double_6 = (double_1 - double_2) / (double_5 - double_4) + 4.0D;
      }
    }

    double_6 /= 6.0D;
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
    }

    if (double_0 > 0.5D) {
      hueMultiplier = (int) ((1.0D - double_0) * double_7 * 512.0D);
    } else {
      hueMultiplier = (int) (double_0 * double_7 * 512.0D);
    }

    if (hueMultiplier < 1) {
      hueMultiplier = 1;
    }

    hue = (int) (hueMultiplier * double_6);
  }

  void decode(final Buffer buffer_0, final int int_0, final int int_1) {
    if (int_0 == 1) {
      rgbColor = buffer_0.getUnsignedMedium();
    }

  }

  void post() {
    setHSL(rgbColor);
  }

  void decode(final Buffer buffer_0, final int int_0) {
    while (true) {
      final int int_1 = buffer_0.getUnsignedByte();
      if (int_1 == 0) {
        return;
      }

      this.decode(buffer_0, int_1, int_0);
    }
  }

}
