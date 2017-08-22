package jagex.oldschool;

import jagex.oldschool.asset.RemoteAssetRequestor;
import jagex.oldschool.io.HuffmanCodec;

public final class SceneTilePaint {

  static Class93 aClass93_1;
  boolean flatShade;
  int swColor;
  int rgb;
  int seColor;
  int neColor;
  int nwColor;
  int texture;

  SceneTilePaint(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4, final int int_5,
      final boolean bool_0) {
    flatShade = true;
    swColor = int_0;
    seColor = int_1;
    neColor = int_2;
    nwColor = int_3;
    texture = int_4;
    rgb = int_5;
    flatShade = bool_0;
  }

  public static void method344() {
    if (RemoteAssetRequestor.aSocketStream2 != null) {
      RemoteAssetRequestor.aSocketStream2.close();
    }

  }

  public static void method345(final HuffmanCodec codec) {
    Class94.aHuffman1 = codec;
  }

}
