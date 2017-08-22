package jagex.oldschool.asset;

import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.Class94;
import jagex.oldschool.collections.Node;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.io.FileOnDisk;

public class LocalRequest extends Node {

  public int id;
  public FileCache cache;
  public byte[] bytes;
  public Package requestor;

  public static BitmapFont method650(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final int int_0, final int int_1) {
    if (!FileOnDisk.method74(indexdatabase_0, int_0, int_1)) {
      return null;
    }
    final byte[] bytes_0 = indexdatabase_1.get(int_0, int_1);
    BitmapFont font_0;
    if (bytes_0 == null) {
      font_0 = null;
    } else {
      final BitmapFont font_1 = new BitmapFont(bytes_0, SpriteLoader.anIntArray56, CacheableNode_Sub1.offsetsY,
          Class94.anIntArray48, SpriteLoader.anIntArray57, SpriteLoader.anIntArray58, SpriteLoader.spritePixels);
      SpriteLoader.anIntArray56 = null;
      CacheableNode_Sub1.offsetsY = null;
      Class94.anIntArray48 = null;
      SpriteLoader.anIntArray57 = null;
      SpriteLoader.anIntArray58 = null;
      SpriteLoader.spritePixels = null;
      font_0 = font_1;
    }

    return font_0;
  }

}
