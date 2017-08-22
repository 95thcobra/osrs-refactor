package jagex.oldschool;

import jagex.oldschool.asset.Package;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Mobile;
import jagex.oldschool.scene.Position;
import jagex.oldschool.ui.Inventory;

public class Boundry {

  public static int baseX;
  public static int anInt48;
  static Package indexModels;
  static IndexedSprite anIndexedSprite1;
  static int cameraYaw;
  public int anInt49;
  public Position aCoordinates2;
  public Position aCoordinates3;

  public Boundry(final int int_0, final Position coordinates_0, final Position coordinates_1) {
    anInt49 = int_0;
    aCoordinates2 = coordinates_0;
    aCoordinates3 = coordinates_1;
  }

  static void setItemTableSlot(final int int_0, final int int_1, final int int_2, final int int_3) {
    Inventory itemcontainer_0 = (Inventory) Inventory.inventories.get(int_0);
    if (itemcontainer_0 == null) {
      itemcontainer_0 = new Inventory();
      Inventory.inventories.put(itemcontainer_0, int_0);
    }

    if (itemcontainer_0.ids.length <= int_1) {
      final int[] ints_0 = new int[int_1 + 1];
      final int[] ints_1 = new int[int_1 + 1];

      int int_4;
      for (int_4 = 0; int_4 < itemcontainer_0.ids.length; int_4++) {
        ints_0[int_4] = itemcontainer_0.ids[int_4];
        ints_1[int_4] = itemcontainer_0.counts[int_4];
      }

      for (int_4 = itemcontainer_0.ids.length; int_4 < int_1; int_4++) {
        ints_0[int_4] = -1;
        ints_1[int_4] = 0;
      }

      itemcontainer_0.ids = ints_0;
      itemcontainer_0.counts = ints_1;
    }

    itemcontainer_0.ids[int_1] = int_2;
    itemcontainer_0.counts[int_1] = int_3;
  }

  static void method156(final Mobile actor_0) {
    if (actor_0.anInt519 != 0) {
      if (actor_0.interacting != -1) {
        Object object_0 = null;
        if (actor_0.interacting < 32768) {
          object_0 = Client.cachedNPCs[actor_0.interacting];
        } else if (actor_0.interacting >= 32768) {
          object_0 = Client.cachedPlayers[actor_0.interacting - 32768];
        }

        if (object_0 != null) {
          final int int_0 = actor_0.x - ((Mobile) object_0).x;
          final int int_1 = actor_0.y - ((Mobile) object_0).y;
          if (int_0 != 0 || int_1 != 0) {
            actor_0.orientation = (int) (Math.atan2(int_0, int_1) * 325.949D) & 0x7FF;
          }
        } else if (actor_0.aBool64) {
          actor_0.interacting = -1;
          actor_0.aBool64 = false;
        }
      }

      if (actor_0.anInt496 != -1 && (actor_0.queueSize == 0 || actor_0.anInt498 > 0)) {
        actor_0.orientation = actor_0.anInt496;
        actor_0.anInt496 = -1;
      }

      final int int_2 = actor_0.orientation - actor_0.angle & 0x7FF;
      if (int_2 == 0 && actor_0.aBool64) {
        actor_0.interacting = -1;
        actor_0.aBool64 = false;
      }

      if (int_2 == 0) {
        actor_0.anInt518 = 0;
      } else {
        ++actor_0.anInt518;
        boolean bool_0;
        if (int_2 > 1024) {
          actor_0.angle -= actor_0.anInt519;
          bool_0 = true;
          if (int_2 < actor_0.anInt519 || int_2 > 2048 - actor_0.anInt519) {
            actor_0.angle = actor_0.orientation;
            bool_0 = false;
          }

          if (actor_0.idlePoseAnimation == actor_0.poseAnimation && (actor_0.anInt518 > 25
              || bool_0)) {
            if (actor_0.anInt500 != -1) {
              actor_0.poseAnimation = actor_0.anInt500;
            } else {
              actor_0.poseAnimation = actor_0.anInt502;
            }
          }
        } else {
          actor_0.angle += actor_0.anInt519;
          bool_0 = true;
          if (int_2 < actor_0.anInt519 || int_2 > 2048 - actor_0.anInt519) {
            actor_0.angle = actor_0.orientation;
            bool_0 = false;
          }

          if (actor_0.idlePoseAnimation == actor_0.poseAnimation && (actor_0.anInt518 > 25
              || bool_0)) {
            if (actor_0.anInt501 != -1) {
              actor_0.poseAnimation = actor_0.anInt501;
            } else {
              actor_0.poseAnimation = actor_0.anInt502;
            }
          }
        }

        actor_0.angle &= 0x7FF;
      }
    }
  }

  public static CacheableNode_Sub4 method157(final int int_0) {
    CacheableNode_Sub4 cacheablenode_sub4_0 = (CacheableNode_Sub4) CacheableNode_Sub4.aNodeCache15
        .get(int_0);
    if (cacheablenode_sub4_0 != null) {
      return cacheablenode_sub4_0;
    }
    final byte[] bytes_0 = CacheableNode_Sub4.anIndexDataBase27.get(34, int_0);
    cacheablenode_sub4_0 = new CacheableNode_Sub4();
    if (bytes_0 != null) {
      cacheablenode_sub4_0.method854(new Buffer(bytes_0));
    }

    cacheablenode_sub4_0.method853();
    CacheableNode_Sub4.aNodeCache15.put(cacheablenode_sub4_0, int_0);
    return cacheablenode_sub4_0;
  }

}
