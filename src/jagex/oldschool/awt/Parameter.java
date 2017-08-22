package jagex.oldschool.awt;

import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.Class94;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.security.Isaac;

public class Parameter {

  public static final Parameter PARAMETER_11;
  public static final Parameter PARAMETER_3;
  public static final Parameter PARAMETER_1;
  public static final Parameter PARAMETER_12;
  public static final Parameter PARAMETER_13;
  public static final Parameter PARAMETER_2;
  public static final Parameter PARAMETER_10;
  public static final Parameter PARAMETER_15;
  public static final Parameter PARAMETER_6;
  public static final Parameter PARAMETER_7;
  public static final Parameter PARAMETER_4;
  public static final Parameter PARAMETER_14;
  public static final Parameter PARAMETER_5;
  public static final Parameter PARAMETER_9;
  public static final Parameter PARAMETER_8;

  static {
    PARAMETER_1 = new Parameter("1", "1");
    PARAMETER_13 = new Parameter("13", "13");
    PARAMETER_2 = new Parameter("2", "2");
    PARAMETER_15 = new Parameter("15", "15");
    PARAMETER_10 = new Parameter("10", "10");
    PARAMETER_12 = new Parameter("12", "12");
    PARAMETER_4 = new Parameter("4", "4");
    PARAMETER_7 = new Parameter("7", "7");
    PARAMETER_8 = new Parameter("8", "8");
    PARAMETER_5 = new Parameter("5", "5");
    PARAMETER_14 = new Parameter("14", "14");
    PARAMETER_9 = new Parameter("9", "9");
    PARAMETER_11 = new Parameter("11", "11");
    PARAMETER_3 = new Parameter("3", "3");
    PARAMETER_6 = new Parameter("6", "6");
  }

  public final String key;

  Parameter(final String string_0, final String string_1) {
    key = string_1;
  }

  public static DirectSprite[] method75(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1) {
    if (!FileOnDisk.method74(indexdatabase_0, int_0, int_1)) {
      return null;
    }
    final DirectSprite[] spritepixelss_0 = new DirectSprite[SpriteLoader.anInt205];

    for (int int_2 = 0; int_2 < SpriteLoader.anInt205; int_2++) {
      final DirectSprite spritepixels_0 = spritepixelss_0[int_2] = new DirectSprite();
      spritepixels_0.unpackedWidth = SpriteLoader.anInt204;
      spritepixels_0.unpackedHeight = Isaac.anInt181;
      spritepixels_0.offsetX = SpriteLoader.anIntArray56[int_2];
      spritepixels_0.offsetY = CacheableNode_Sub1.offsetsY[int_2];
      spritepixels_0.width = Class94.anIntArray48[int_2];
      spritepixels_0.height = SpriteLoader.anIntArray57[int_2];
      final int int_3 = spritepixels_0.height * spritepixels_0.width;
      final byte[] bytes_0 = SpriteLoader.spritePixels[int_2];
      spritepixels_0.buffer = new int[int_3];

      for (int int_4 = 0; int_4 < int_3; int_4++) {
        spritepixels_0.buffer[int_4] = SpriteLoader.anIntArray58[bytes_0[int_4] & 0xFF];
      }
    }

    SpriteLoader.anIntArray56 = null;
    CacheableNode_Sub1.offsetsY = null;
    Class94.anIntArray48 = null;
    SpriteLoader.anIntArray57 = null;
    SpriteLoader.anIntArray58 = null;
    SpriteLoader.spritePixels = null;
    return spritepixelss_0;
  }

}
