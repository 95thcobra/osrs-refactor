package jagex.oldschool;

import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.security.Isaac;

public enum Enum7 implements MappedEnum {

  anEnum7_1(1, 0), anEnum7_2(2, 1), anEnum7_3(0, 2);

  public final int anInt374;
  final int anInt375;

  Enum7(final int int_1, final int int_2) {
    anInt374 = int_1;
    anInt375 = int_2;
  }

  static IndexedSprite[] method704() {
    final IndexedSprite[] indexedsprites_0 = new IndexedSprite[SpriteLoader.anInt205];

    for (int int_0 = 0; int_0 < SpriteLoader.anInt205; int_0++) {
      final IndexedSprite indexedsprite_0 = indexedsprites_0[int_0] = new IndexedSprite();
      indexedsprite_0.unpackedWidth = SpriteLoader.anInt204;
      indexedsprite_0.unpackedHeight = Isaac.anInt181;
      indexedsprite_0.offsetX = SpriteLoader.anIntArray56[int_0];
      indexedsprite_0.offsetY = CacheableNode_Sub1.offsetsY[int_0];
      indexedsprite_0.width = Class94.anIntArray48[int_0];
      indexedsprite_0.height = SpriteLoader.anIntArray57[int_0];
      indexedsprite_0.palette = SpriteLoader.anIntArray58;
      indexedsprite_0.pixels = SpriteLoader.spritePixels[int_0];
    }

    SpriteLoader.anIntArray56 = null;
    CacheableNode_Sub1.offsetsY = null;
    Class94.anIntArray48 = null;
    SpriteLoader.anIntArray57 = null;
    SpriteLoader.anIntArray58 = null;
    SpriteLoader.spritePixels = null;
    return indexedsprites_0;
  }

  @Override
  public int mappedOrdinal() {
    return anInt375;
  }

}
