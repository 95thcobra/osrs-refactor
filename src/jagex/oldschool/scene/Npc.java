package jagex.oldschool.scene;

import jagex.oldschool.Class1;
import jagex.oldschool.Class11;
import jagex.oldschool.Model;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.config.NpcConfig;

public final class Npc extends Mobile {

  public static AbstractPackage anIndexDataBase30;
  public NpcConfig config;

  public static void sendGameMessage(final int int_0, final String string_0, final String string_1) {
    Class1.addChatMessage(int_0, string_0, string_1, null);
  }

  @Override
  protected final Model getModel() {
    if (config == null) {
      return null;
    }
    final AnimationSequence sequence_0 = super.animation != -1 && super.actionAnimationDisable == 0
        ? PendingSpawn.getAnimationSequence(super.animation)
        : null;
    final AnimationSequence sequence_1 = super.poseAnimation != -1
        && (super.poseAnimation != super.idlePoseAnimation || sequence_0 == null)
        ? PendingSpawn.getAnimationSequence(super.poseAnimation)
        : null;
    Model model_0 = config
        .method864(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
    if (model_0 == null) {
      return null;
    }
    model_0.calculateRectangularBounds();
    super.anInt507 = model_0.minimumY;
    if (super.graphic != -1 && super.anInt508 != -1) {
      final Model model_1 = Class11.getSpotAnimationConfig(super.graphic).method729(super.anInt508);
      if (model_1 != null) {
        model_1.method985(0, -super.anInt512, 0);
        final Model[] models_0 = new Model[] {model_0, model_1};
        model_0 = new Model(models_0, 2);
      }
    }

    if (config.anInt477 == 1) {
      model_0.aBool68 = true;
    }

    return model_0;
  }

  @Override
  public final boolean hasConfig() {
    return config != null;
  }

  public final void method1023(final int int_0, final byte byte_0) {
    int int_1 = super.pathX[0];
    int int_2 = super.pathY[0];
    if (int_0 == 0) {
      --int_1;
      ++int_2;
    }

    if (int_0 == 1) {
      ++int_2;
    }

    if (int_0 == 2) {
      ++int_1;
      ++int_2;
    }

    if (int_0 == 3) {
      --int_1;
    }

    if (int_0 == 4) {
      ++int_1;
    }

    if (int_0 == 5) {
      --int_1;
      --int_2;
    }

    if (int_0 == 6) {
      --int_2;
    }

    if (int_0 == 7) {
      ++int_1;
      --int_2;
    }

    if (super.animation != -1 && PendingSpawn.getAnimationSequence(super.animation).priority == 1) {
      super.animation = -1;
    }

    if (super.queueSize < 9) {
      ++super.queueSize;
    }

    for (int int_3 = super.queueSize; int_3 > 0; --int_3) {
      super.pathX[int_3] = super.pathX[int_3 - 1];
      super.pathY[int_3] = super.pathY[int_3 - 1];
      super.aByteArray20[int_3] = super.aByteArray20[int_3 - 1];
    }

    super.pathX[0] = int_1;
    super.pathY[0] = int_2;
    super.aByteArray20[0] = byte_0;
  }

  public final void method1024(final int int_0, final int int_1, final boolean bool_0) {
    if (super.animation != -1 && PendingSpawn.getAnimationSequence(super.animation).priority == 1) {
      super.animation = -1;
    }

    if (!bool_0) {
      final int int_2 = int_0 - super.pathX[0];
      final int int_3 = int_1 - super.pathY[0];
      if (int_2 >= -8 && int_2 <= 8 && int_3 >= -8 && int_3 <= 8) {
        if (super.queueSize < 9) {
          ++super.queueSize;
        }

        for (int int_4 = super.queueSize; int_4 > 0; --int_4) {
          super.pathX[int_4] = super.pathX[int_4 - 1];
          super.pathY[int_4] = super.pathY[int_4 - 1];
          super.aByteArray20[int_4] = super.aByteArray20[int_4 - 1];
        }

        super.pathX[0] = int_0;
        super.pathY[0] = int_1;
        super.aByteArray20[0] = 1;
        return;
      }
    }

    super.queueSize = 0;
    super.anInt497 = 0;
    super.anInt498 = 0;
    super.pathX[0] = int_0;
    super.pathY[0] = int_1;
    super.x = super.pathX[0] * 128 + super.anInt499 * 64;
    super.y = super.pathY[0] * 128 + super.anInt499 * 64;
  }

}
