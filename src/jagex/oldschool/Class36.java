package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.Bag;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.security.Isaac;
import java.util.HashMap;
import java.util.Map;

public class Class36 {

  static final Map chatLineMap;
  static final IterableHashTable anIterableHashTable1;
  static final Bag aClass76_1;
  public static boolean aBool8;
  static int anInt88;

  static {
    chatLineMap = new HashMap();
    anIterableHashTable1 = new IterableHashTable(1024);
    aClass76_1 = new Bag();
    anInt88 = 0;
  }

  public static void method257(final AClass4 aclass4_0) {
    aclass4_0.aBool43 = false;
    if (aclass4_0.anAClass5_1 != null) {
      aclass4_0.anAClass5_1.anInt330 = 0;
    }

    for (AClass4 aclass4_1 = aclass4_0.method636(); aclass4_1 != null;
        aclass4_1 = aclass4_0.method635()) {
      method257(aclass4_1);
    }

  }

  public static DirectSprite createSprite(final int int_0, final int int_1, final int int_2,
      final int int_3,
      int int_4, final boolean bool_0) {
    if (int_1 == -1) {
      int_4 = 0;
    } else if (int_4 == 2 && int_1 != 1) {
      int_4 = 1;
    }

    final long long_0 = ((long) int_2 << 38) + int_0 + ((long) int_1 << 16) + ((long) int_4 << 40)
        + ((long) int_3 << 42);
    DirectSprite spritepixels_0;
    if (!bool_0) {
      spritepixels_0 = (DirectSprite) ItemConfig.itemSpriteCache.get(long_0);
      if (spritepixels_0 != null) {
        return spritepixels_0;
      }
    }

    ItemConfig itemcomposition_0 = AudioWorker.getItemDefinition(int_0);
    if (int_1 > 1 && itemcomposition_0.countObj != null) {
      int int_5 = -1;

      for (int int_6 = 0; int_6 < 10; int_6++) {
        if (int_1 >= itemcomposition_0.countCo[int_6] && itemcomposition_0.countCo[int_6]
            != 0) {
          int_5 = itemcomposition_0.countObj[int_6];
        }
      }

      if (int_5 != -1) {
        itemcomposition_0 = AudioWorker.getItemDefinition(int_5);
      }
    }

    final Model model_0 = itemcomposition_0.getModel(1);
    if (model_0 == null) {
      return null;
    }
    DirectSprite spritepixels_1 = null;
    if (itemcomposition_0.notedTemplate != -1) {
      spritepixels_1 = createSprite(itemcomposition_0.note, 10, 1, 0, 0, true);
      if (spritepixels_1 == null) {
        return null;
      }
    } else if (itemcomposition_0.notedId != -1) {
      spritepixels_1 = createSprite(itemcomposition_0.unnotedId, int_1, int_2, int_3, 0, false);
      if (spritepixels_1 == null) {
        return null;
      }
    } else if (itemcomposition_0.anInt493 != -1) {
      spritepixels_1 = createSprite(itemcomposition_0.anInt494, int_1, 0, 0, 0, false);
      if (spritepixels_1 == null) {
        return null;
      }
    }

    final int[] ints_0 = Rasterizer2d.targetBuffer;
    final int int_7 = Rasterizer2d.targetWidth;
    final int int_8 = Rasterizer2d.targetHeight;
    final int[] ints_1 = new int[4];
    Rasterizer2d.getClip(ints_1);
    spritepixels_0 = new DirectSprite(36, 32);
    Rasterizer2d.init(spritepixels_0.buffer, 36, 32);
    Rasterizer2d.clear();
    Rasterizer3d.init();
    Rasterizer3d.method928(16, 16);
    Rasterizer3d.rasterGouraudLowRes = false;
    if (itemcomposition_0.anInt493 != -1) {
      spritepixels_1.method938(0, 0);
    }

    int int_9 = itemcomposition_0.zoom2d;
    if (bool_0) {
      int_9 = (int) (1.5D * int_9);
    } else if (int_2 == 2) {
      int_9 = (int) (int_9 * 1.04D);
    }

    final int int_10 = int_9 * Rasterizer3d.SINE[itemcomposition_0.xan2d] >> 16;
    final int int_11 = int_9 * Rasterizer3d.COSINE[itemcomposition_0.xan2d] >> 16;
    model_0.calculateRectangularBounds();
    model_0.method986(0, itemcomposition_0.yan2d, itemcomposition_0.zan2d, itemcomposition_0.xan2d,
        itemcomposition_0.offsetX2d,
        model_0.minimumY / 2 + int_10 + itemcomposition_0.offsetY2d,
        int_11 + itemcomposition_0.offsetY2d);
    if (itemcomposition_0.notedId != -1) {
      spritepixels_1.method938(0, 0);
    }

    if (int_2 >= 1) {
      spritepixels_0.method947(1);
    }

    if (int_2 >= 2) {
      spritepixels_0.method947(16777215);
    }

    if (int_3 != 0) {
      spritepixels_0.method948(int_3);
    }

    Rasterizer2d.init(spritepixels_0.buffer, 36, 32);
    if (itemcomposition_0.notedTemplate != -1) {
      spritepixels_1.method938(0, 0);
    }

    if (int_4 == 1 || int_4 == 2 && itemcomposition_0.isStackable == 1) {
      final BitmapFont font_0 = Isaac.aFont4;
      String string_0;
      if (int_1 < 100000) {
        string_0 = "<col=ffff00>" + int_1 + "</col>";
      } else if (int_1 < 10000000) {
        string_0 = "<col=ffffff>" + int_1 / 1000 + "K" + "</col>";
      } else {
        string_0 = "<col=00ff80>" + int_1 / 1000000 + "M" + "</col>";
      }

      font_0.method999(string_0, 0, 9, 16776960, 1);
    }

    if (!bool_0) {
      ItemConfig.itemSpriteCache.put(spritepixels_0, long_0);
    }

    Rasterizer2d.init(ints_0, int_7, int_8);
    Rasterizer2d.setClip(ints_1);
    Rasterizer3d.init();
    Rasterizer3d.rasterGouraudLowRes = true;
    return spritepixels_0;
  }

}
