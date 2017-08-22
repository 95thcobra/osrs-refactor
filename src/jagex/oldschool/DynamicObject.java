package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.scene.Renderable;

public class DynamicObject extends Renderable {

  AnimationSequence aSequence2;
  int id;
  int anInt564;
  int type;
  int orientation;
  int level;
  int anInt565;
  int sceneX;
  int sceneY;

  DynamicObject(final int int_0, final int int_1, final int int_2, final int int_3, final int int_4,
      final int int_5,
      final int int_6, final boolean bool_0, final Renderable renderable_0) {
    id = int_0;
    type = int_1;
    orientation = int_2;
    level = int_3;
    sceneX = int_4;
    sceneY = int_5;
    if (int_6 != -1) {
      aSequence2 = PendingSpawn.getAnimationSequence(int_6);
      anInt565 = 0;
      anInt564 = Client.tick - 1;
      if (aSequence2.replyMode == 0 && renderable_0 != null
          && renderable_0 instanceof DynamicObject) {
        final DynamicObject dynamicobject_1 = (DynamicObject) renderable_0;
        if (dynamicobject_1.aSequence2 == aSequence2) {
          anInt565 = dynamicobject_1.anInt565;
          anInt564 = dynamicobject_1.anInt564;
          return;
        }
      }

      if (bool_0 && aSequence2.frameStep != -1) {
        anInt565 = (int) (Math.random() * aSequence2.frameIDs.length);
        anInt564 -= (int) (Math.random() * aSequence2.frameLenghts[anInt565]);
      }
    }

  }

  public static void addMenuEntry(final String string_0, final String string_1,
      final int int_0,
      final int int_1, final int int_2, final int int_3) {
    final boolean bool_0 = false;
    if (!Client.isMenuOpen && Client.menuOptionCount < 500) {
      Client.menuOptions[Client.menuOptionCount] = string_0;
      Client.menuTargets[Client.menuOptionCount] = string_1;
      Client.menuTypes[Client.menuOptionCount] = int_0;
      Client.menuIdentifiers[Client.menuOptionCount] = int_1;
      Client.menuActionParams0[Client.menuOptionCount] = int_2;
      Client.menuActionParams1[Client.menuOptionCount] = int_3;
      Client.aBoolArray11[Client.menuOptionCount] = bool_0;
      ++Client.menuOptionCount;
    }
  }

  @Override
  protected final Model getModel() {
    if (aSequence2 != null) {
      int int_0 = Client.tick - anInt564;
      if (int_0 > 100 && aSequence2.frameStep > 0) {
        int_0 = 100;
      }

      label55:
      {
        do {
          do {
            if (int_0 <= aSequence2.frameLenghts[anInt565]) {
              break label55;
            }

            int_0 -= aSequence2.frameLenghts[anInt565];
            ++anInt565;
          } while (anInt565 < aSequence2.frameIDs.length);

          anInt565 -= aSequence2.frameStep;
        } while (anInt565 >= 0 && anInt565 < aSequence2.frameIDs.length);

        aSequence2 = null;
      }

      anInt564 = Client.tick - int_0;
    }

    ObjectConfig objectcomposition_0 = Class2.getObjectDefinition(id);
    if (objectcomposition_0.impostorIds != null) {
      objectcomposition_0 = objectcomposition_0.getImpostor();
    }

    if (objectcomposition_0 == null) {
      return null;
    }
    int int_1;
    int int_2;
    if (orientation != 1 && orientation != 3) {
      int_1 = objectcomposition_0.sizeX;
      int_2 = objectcomposition_0.sizeY;
    } else {
      int_1 = objectcomposition_0.sizeY;
      int_2 = objectcomposition_0.sizeX;
    }

    final int int_3 = (int_1 >> 1) + sceneX;
    final int int_4 = sceneX + (int_1 + 1 >> 1);
    final int int_5 = (int_2 >> 1) + sceneY;
    final int int_6 = (int_2 + 1 >> 1) + sceneY;
    final int[][] ints_0 = Class22.heightmap[level];
    final int int_7 = ints_0[int_3][int_6] + ints_0[int_3][int_5] + ints_0[int_4][int_5]
        + ints_0[int_4][int_6] >> 2;
    final int int_8 = (sceneX << 7) + (int_1 << 6);
    final int int_9 = (sceneY << 7) + (int_2 << 6);
    return objectcomposition_0
        .method820(type, orientation, ints_0, int_8, int_7, int_9, aSequence2, anInt565);
  }

}
