package jagex.oldschool.map;

import jagex.oldschool.io.Buffer;

public class MapAsset {

  public static final MapAsset aClass6_1;
  public static final MapAsset aClass6_2;
  public static final MapAsset aClass6_3;
  public static final MapAsset aClass6_4;
  public static final MapAsset aClass6_5;
  public static Buffer aBuffer1;

  static {
    aClass6_1 = new MapAsset("details");
    aClass6_2 = new MapAsset("compositemap");
    aClass6_4 = new MapAsset("compositetexture");
    aClass6_3 = new MapAsset("area");
    aClass6_5 = new MapAsset("labels");
  }

  public final String aString2;

  MapAsset(final String string_0) {
    aString2 = string_0;
  }

}
