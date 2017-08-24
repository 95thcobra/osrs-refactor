package jagex.oldschool.scene;

import jagex.oldschool.Enum7;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.FileOnDisk;

public final class GroundObject {

  public static int anInt213;
  public Renderable renderable;
  public int hash;
  int x;
  int y;
  int floor;
  int renderInfoBitPacked;

  public static IndexedSprite[] method552(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1) {
    return !FileOnDisk.method74(indexdatabase_0, int_0, int_1) ? null : Enum7.method704();
  }

}
