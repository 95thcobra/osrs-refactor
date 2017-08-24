package jagex.oldschool.scene;

import jagex.oldschool.Enum5;
import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.asset.Package;
import jagex.oldschool.io.CacheWorker;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.scene.Renderable;

public final class DecorativeObject {

  public int hash;
  public Renderable renderable1;
  public Renderable renderable2;
  int renderInfoBitPacked;
  int offsetX;
  int x;
  int offsetY;
  int y;
  int floor;
  int renderFlag;
  int rotation;

  DecorativeObject() {
    hash = 0;
    renderInfoBitPacked = 0;
  }

  public static void method478(final int int_0, final FileCache indexfile_0,
      final Package indexdata_0) {
    final LocalRequest filesystem_0 = new LocalRequest();
    filesystem_0.id = 1;
    filesystem_0.hash = int_0;
    filesystem_0.cache = indexfile_0;
    filesystem_0.requestor = indexdata_0;
    synchronized (CacheWorker.aDeque1) {
      CacheWorker.aDeque1.addLast(filesystem_0);
    }

    Enum5.method663();
  }

  public static boolean method479(final char char_0) {
    return char_0 >= 48 && char_0 <= 57 || char_0 >= 65 && char_0 <= 90
        || char_0 >= 97 && char_0 <= 122;
  }

  public static int method480(char char_0, final int int_0) {
    int int_1 = char_0 << 4;
    if (Character.isUpperCase(char_0) || Character.isTitleCase(char_0)) {
      char_0 = Character.toLowerCase(char_0);
      int_1 = (char_0 << 4) + 1;
    }

    return int_1;
  }

}
