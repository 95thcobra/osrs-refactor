package jagex.oldschool.scene;

import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.Class104;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.Class11;
import jagex.oldschool.Class94;
import jagex.oldschool.Model;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.config.SpotAnimationConfig;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.security.Isaac;

public final class Projectile extends Renderable {

  public static Class104 aClass104_4;
  int id;
  boolean isMoving;
  int x1;
  public int cycle;
  public double x;
  double aDouble1;
  int anInt536;
  int y1;
  int anInt537;
  int rotationY;
  public double velocityZ;
  double scalar;
  int start;
  public int floor;
  public double z;
  double velocityX;
  double heightOffset;
  int height;
  public int startTime;
  double velocityY;
  int slope;
  public int interacting;
  public int endHeight;
  public int rotationX;
  AnimationSequence animationSequence;

  public Projectile(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5,
      final int int_6, final int int_7, final int int_8, final int int_9, final int int_10) {
    isMoving = false;
    anInt536 = 0;
    anInt537 = 0;
    id = int_0;
    floor = int_1;
    x1 = int_2;
    y1 = int_3;
    height = int_4;
    startTime = int_5;
    cycle = int_6;
    slope = int_7;
    start = int_8;
    interacting = int_9;
    endHeight = int_10;
    isMoving = false;
    final int int_11 = Class11.getSpotAnimationConfig(id).sequenceId;
    if (int_11 != -1) {
      animationSequence = PendingSpawn.getAnimationSequence(int_11);
    } else {
      animationSequence = null;
    }
  }

  public static IndexedSprite getSprite(final AbstractPackage indexdatabase_0, final String string_0,
      final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    IndexedSprite indexedsprite_0;
    if (!FileOnDisk.method74(indexdatabase_0, int_0, int_1)) {
      indexedsprite_0 = null;
    } else {
      final IndexedSprite indexedsprite_1 = new IndexedSprite();
      indexedsprite_1.unpackedWidth = SpriteLoader.anInt204;
      indexedsprite_1.unpackedHeight = Isaac.anInt181;
      indexedsprite_1.offsetX = SpriteLoader.anIntArray56[0];
      indexedsprite_1.offsetY = CacheableNode_Sub1.offsetsY[0];
      indexedsprite_1.width = Class94.anIntArray48[0];
      indexedsprite_1.height = SpriteLoader.anIntArray57[0];
      indexedsprite_1.palette = SpriteLoader.anIntArray58;
      indexedsprite_1.pixels = SpriteLoader.spritePixels[0];
      SpriteLoader.anIntArray56 = null;
      CacheableNode_Sub1.offsetsY = null;
      Class94.anIntArray48 = null;
      SpriteLoader.anIntArray57 = null;
      SpriteLoader.anIntArray58 = null;
      SpriteLoader.spritePixels = null;
      indexedsprite_0 = indexedsprite_1;
    }

    return indexedsprite_0;
  }

  @Override
  protected final Model getModel() {
    final SpotAnimationConfig spotanim_0 = Class11.getSpotAnimationConfig(id);
    final Model model_0 = spotanim_0.method729(anInt536);
    if (model_0 == null) {
      return null;
    }
    model_0.method975(rotationY);
    return model_0;
  }

  public final void method964(final int int_0) {
    isMoving = true;
    x += aDouble1 * int_0;
    velocityZ += int_0 * scalar;
    z += velocityX * int_0 + int_0 * heightOffset * 0.5D * int_0;
    velocityX += int_0 * heightOffset;
    rotationX = (int) (Math.atan2(aDouble1, scalar) * 325.949D) + 1024 & 0x7FF;
    rotationY = (int) (Math.atan2(velocityX, velocityY) * 325.949D) & 0x7FF;
    if (animationSequence != null) {
      anInt537 += int_0;

      while (true) {
        do {
          do {
            if (anInt537 <= animationSequence.frameLenghts[anInt536]) {
              return;
            }

            anInt537 -= animationSequence.frameLenghts[anInt536];
            ++anInt536;
          } while (anInt536 < animationSequence.frameIDs.length);

          anInt536 -= animationSequence.frameStep;
        } while (anInt536 >= 0 && anInt536 < animationSequence.frameIDs.length);

        anInt536 = 0;
      }
    }
  }

  public final void method965(final int int_0, final int int_1, final int int_2, final int int_3) {
    double double_0;
    if (!isMoving) {
      double_0 = int_0 - x1;
      final double double_1 = int_1 - y1;
      final double double_2 = Math.sqrt(double_0 * double_0 + double_1 * double_1);
      x = x1 + start * double_0 / double_2;
      velocityZ = y1 + double_1 * start / double_2;
      z = height;
    }

    double_0 = cycle + 1 - int_3;
    aDouble1 = (int_0 - x) / double_0;
    scalar = (int_1 - velocityZ) / double_0;
    velocityY = Math.sqrt(aDouble1 * aDouble1 + scalar * scalar);
    if (!isMoving) {
      velocityX = -velocityY * Math.tan(slope * 0.02454369D);
    }

    heightOffset = 2.0D * (int_2 - z - double_0 * velocityX) / (double_0 * double_0);
  }

}
