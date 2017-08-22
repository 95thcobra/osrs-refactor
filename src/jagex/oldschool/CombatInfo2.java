package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;

public class CombatInfo2 extends Subnode {

  public static Cache aNodeCache7;
  public static Cache spriteCache;
  public static AbstractPackage anIndexDataBase19;
  public static AbstractPackage anIndexDataBase20;

  static {
    aNodeCache7 = new Cache(64);
    spriteCache = new Cache(64);
  }

  public int anInt443;
  public int anInt444;
  public int anInt445;
  public int anInt446;
  public int anInt447;
  public int anInt448;
  public int healthScale;
  public int anInt449;
  int anInt441;
  int anInt442;

  public CombatInfo2() {
    anInt443 = 255;
    anInt445 = 255;
    anInt444 = -1;
    anInt447 = 1;
    anInt446 = 70;
    anInt442 = -1;
    anInt441 = -1;
    healthScale = 30;
    anInt449 = 0;
  }

  void method781(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      buffer_0.getUnsignedShort();
    } else {
      if (int_0 == 2) {
        anInt443 = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 3) {
        anInt445 = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 4) {
        anInt444 = 0;
        return;
      }

      if (int_0 == 5) {
        anInt446 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 6) {
        buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 7) {
        anInt442 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 8) {
        anInt441 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 11) {
        anInt444 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 14) {
        healthScale = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 15) {
        anInt449 = buffer_0.getUnsignedByte();
        return;
      }
    }

  }

  public void method782(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method781(buffer_0, int_0);
    }
  }

  public DirectSprite method783() {
    if (anInt441 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) spriteCache.get(anInt441);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase20, anInt441, 0);
    if (spritepixels_0 != null) {
      spriteCache.put(spritepixels_0, anInt441);
    }

    return spritepixels_0;
  }

  public DirectSprite method784() {
    if (anInt442 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) spriteCache.get(anInt442);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase20, anInt442, 0);
    if (spritepixels_0 != null) {
      spriteCache.put(spritepixels_0, anInt442);
    }

    return spritepixels_0;
  }

}
