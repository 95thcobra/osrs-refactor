package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.config.SpotAnimationConfig;
import jagex.oldschool.scene.Renderable;

public final class SpotAnimation extends Renderable {

  int id;
  boolean finished;
  int anInt528;
  int anInt529;
  AnimationSequence aSequence1;
  int level;
  int x;
  int y;
  int height;
  int startCycle;

  SpotAnimation(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4, final int int_5,
      final int int_6) {
    anInt529 = 0;
    anInt528 = 0;
    finished = false;
    id = int_0;
    level = int_1;
    x = int_2;
    y = int_3;
    height = int_4;
    startCycle = int_6 + int_5;
    final int int_7 = Class11.getSpotAnimationConfig(id).sequenceId;
    if (int_7 != -1) {
      finished = false;
      aSequence1 = PendingSpawn.getAnimationSequence(int_7);
    } else {
      finished = true;
    }
  }

  @Override
  protected final Model getModel() {
    final SpotAnimationConfig spotanim_0 = Class11.getSpotAnimationConfig(id);
    Model model_0;
    if (!finished) {
      model_0 = spotanim_0.method729(anInt529);
    } else {
      model_0 = spotanim_0.method729(-1);
    }

    return model_0 == null ? null : model_0;
  }

  final void method915(final int int_0) {
    if (!finished) {
      anInt528 += int_0;

      while (anInt528 > aSequence1.frameLenghts[anInt529]) {
        anInt528 -= aSequence1.frameLenghts[anInt529];
        ++anInt529;
        if (anInt529 >= aSequence1.frameIDs.length) {
          finished = true;
          break;
        }
      }

    }
  }

}
