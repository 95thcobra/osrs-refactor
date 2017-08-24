package jagex.oldschool.scene;

import jagex.oldschool.awt.Parameter;

public final class Occluder {

  int testDirection;
  int minX;
  int type;
  int minNormalX;
  int minTileX;
  int minZ;
  int minTileZ;
  int maxNormalX;
  int maxZ;
  int anInt163;
  int minY;
  int maxX;
  int minNormalY;
  int anInt164;
  int maxNormalY;
  int maxY;
  int maxTileZ;
  int maxTIleX;

  public static Parameter[] method402() {
    return new Parameter[] {
        Parameter.PARAMETER_1, Parameter.PARAMETER_12, Parameter.PARAMETER_2,
        Parameter.PARAMETER_10, Parameter.PARAMETER_15, Parameter.PARAMETER_6,
        Parameter.PARAMETER_7,
        Parameter.PARAMETER_11, Parameter.PARAMETER_4, Parameter.PARAMETER_14,
        Parameter.PARAMETER_3,
        Parameter.PARAMETER_13, Parameter.PARAMETER_5, Parameter.PARAMETER_9,
        Parameter.PARAMETER_8
    };
  }

  public static String method403(final int int_0) {
    return (int_0 >> 24 & 0xFF) + "." + (int_0 >> 16 & 0xFF) + "." + (int_0 >> 8 & 0xFF) + "."
        + (int_0 & 0xFF);
  }

  public static int method404(final int int_0, final int int_1, int int_2) {
    int_2 &= 0x3;
    return int_2 == 0 ? int_0 : int_2 == 1 ? int_1 : int_2 == 2 ? 7 - int_0 : 7 - int_1;
  }

}
