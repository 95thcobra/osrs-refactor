package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.PrimitiveType;

public class CacheableNode_Sub2 extends Subnode {

  static Cache aNodeCache11;
  static Cache aNodeCache12;
  static Cache aNodeCache13;
  public static AbstractPackage anIndexDataBase23;
  public static AbstractPackage anIndexDataBase24;
  public static AbstractPackage anIndexDataBase25;

  static {
    aNodeCache12 = new Cache(64);
    aNodeCache13 = new Cache(64);
    aNodeCache11 = new Cache(20);
  }

  public int anInt469;
  public int anInt470;
  public int anInt471;
  public int[] anIntArray104;
  public int anInt472;
  public int anInt473;
  public int anInt474;
  public int anInt475;
  String aString29;
  int anInt462;
  int anInt463;
  int anInt464;
  int anInt465;
  int anInt466;
  int anInt467;
  int anInt468;

  CacheableNode_Sub2() {
    anInt467 = -1;
    anInt470 = 16777215;
    anInt471 = 70;
    anInt463 = -1;
    anInt464 = -1;
    anInt465 = -1;
    anInt466 = -1;
    anInt472 = 0;
    anInt474 = 0;
    anInt473 = -1;
    aString29 = "";
    anInt469 = -1;
    anInt475 = 0;
    anInt462 = -1;
    anInt468 = -1;
  }

  public static int method841(final CharSequence charsequence_0) {
    return Class52.parseInt(charsequence_0, 10, true);
  }

  void method832(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      anInt467 = buffer_0.getSmartInt();
    } else {
      if (int_0 == 2) {
        anInt470 = buffer_0.getUnsignedMedium();
        return;
      }

      if (int_0 == 3) {
        anInt463 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 4) {
        anInt465 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 5) {
        anInt464 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 6) {
        anInt466 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 7) {
        anInt472 = buffer_0.getShort();
        return;
      }

      if (int_0 == 8) {
        aString29 = buffer_0.getSuffixedString();
        return;
      }

      if (int_0 == 9) {
        anInt471 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 10) {
        anInt474 = buffer_0.getShort();
        return;
      }

      if (int_0 == 11) {
        anInt473 = 0;
        return;
      }

      if (int_0 == 12) {
        anInt469 = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 13) {
        anInt475 = buffer_0.getShort();
        return;
      }

      if (int_0 == 14) {
        anInt473 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 17 || int_0 == 18) {
        anInt462 = buffer_0.getUnsignedShort();
        if (anInt462 == 65535) {
          anInt462 = -1;
        }

        anInt468 = buffer_0.getUnsignedShort();
        if (anInt468 == 65535) {
          anInt468 = -1;
        }

        int int_1 = -1;
        if (int_0 == 18) {
          int_1 = buffer_0.getUnsignedShort();
          if (int_1 == 65535) {
            int_1 = -1;
          }
        }

        final int int_2 = buffer_0.getUnsignedByte();
        anIntArray104 = new int[int_2 + 2];

        for (int int_3 = 0; int_3 <= int_2; int_3++) {
          anIntArray104[int_3] = buffer_0.getUnsignedShort();
          if (anIntArray104[int_3] == 65535) {
            anIntArray104[int_3] = -1;
          }
        }

        anIntArray104[int_2 + 1] = int_1;
        return;
      }
    }

  }

  void method833(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method832(buffer_0, int_0);
    }
  }

  public final CacheableNode_Sub2 method834() {
    int int_0 = -1;
    if (anInt462 != -1) {
      int_0 = PrimitiveType.method629(anInt462);
    } else if (anInt468 != -1) {
      int_0 = Variables.widgetSettings[anInt468];
    }

    int int_1;
    if (int_0 >= 0 && int_0 < anIntArray104.length - 1) {
      int_1 = anIntArray104[int_0];
    } else {
      int_1 = anIntArray104[anIntArray104.length - 1];
    }

    return int_1 != -1 ? RemoteEnvironment.method523(int_1) : null;
  }

  public DirectSprite method835() {
    if (anInt463 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) aNodeCache13.get(anInt463);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase24, anInt463, 0);
    if (spritepixels_0 != null) {
      aNodeCache13.put(spritepixels_0, anInt463);
    }

    return spritepixels_0;
  }

  public DirectSprite method836() {
    if (anInt464 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) aNodeCache13.get(anInt464);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase24, anInt464, 0);
    if (spritepixels_0 != null) {
      aNodeCache13.put(spritepixels_0, anInt464);
    }

    return spritepixels_0;
  }

  public DirectSprite method837() {
    if (anInt465 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) aNodeCache13.get(anInt465);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase24, anInt465, 0);
    if (spritepixels_0 != null) {
      aNodeCache13.put(spritepixels_0, anInt465);
    }

    return spritepixels_0;
  }

  public DirectSprite method838() {
    if (anInt466 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) aNodeCache13.get(anInt466);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase24, anInt466, 0);
    if (spritepixels_0 != null) {
      aNodeCache13.put(spritepixels_0, anInt466);
    }

    return spritepixels_0;
  }

  public BitmapFont method839() {
    if (anInt467 == -1) {
      return null;
    }
    BitmapFont font_0 = (BitmapFont) aNodeCache11.get(anInt467);
    if (font_0 != null) {
      return font_0;
    }
    font_0 = LocalRequest.method650(anIndexDataBase24, anIndexDataBase25, anInt467, 0);
    if (font_0 != null) {
      aNodeCache11.put(font_0, anInt467);
    }

    return font_0;
  }

  public String method840(final int int_0) {
    String string_0 = aString29;

    while (true) {
      final int int_1 = string_0.indexOf("%1");
      if (int_1 < 0) {
        return string_0;
      }

      final String string_1 = string_0.substring(0, int_1);
      final String string_2 = Integer.toString(int_0);
      string_0 = string_1 + string_2 + string_0.substring(int_1 + 2);
    }
  }

}
