package jagex.oldschool;

import jagex.oldschool.scene.Mobile;

public final class AClass3_Sub1 extends AClass3 {

  final int anInt391;
  final int anInt392;
  final int anInt393;
  final int anInt394;
  final int anInt395;
  final int anInt396;
  final int anInt397;

  AClass3_Sub1(final Model model_0, final int int_0, final int int_1, final int int_2,
      final int int_3) {
    anInt391 = int_0 + model_0.anInt545 - model_0.anInt542;
    anInt393 = int_1 + model_0.anInt549 - model_0.anInt550;
    anInt395 = int_2 + model_0.anInt551 - model_0.anInt553;
    anInt392 = int_0 + model_0.anInt542 + model_0.anInt545;
    anInt394 = int_1 + model_0.anInt549 + model_0.anInt550;
    anInt396 = int_2 + model_0.anInt553 + model_0.anInt551;
    anInt397 = int_3;
  }

  public static void method725(final long long_0) {
    if (long_0 > 0L) {
      if (long_0 % 10L == 0L) {
        final long long_1 = long_0 - 1L;

        try {
          Thread.sleep(long_1);
        } catch (final InterruptedException interruptedexception_1) {
        }

        try {
          Thread.sleep(1L);
        } catch (final InterruptedException interruptedexception_2) {
        }
      } else {
        try {
          Thread.sleep(long_0);
        } catch (final InterruptedException interruptedexception_0) {
        }
      }
    }
  }

  static void method726(final Mobile actor_0) {
    if (actor_0.anInt521 == Client.tick || actor_0.animation == -1
        || actor_0.actionAnimationDisable != 0
        || actor_0.anInt514
        + 1 > PendingSpawn.getAnimationSequence(actor_0.animation).frameLenghts[actor_0.actionFrame]) {
      final int int_0 = actor_0.anInt521 - actor_0.anInt520;
      final int int_1 = Client.tick - actor_0.anInt520;
      final int int_2 = actor_0.anInt499 * 64 + actor_0.anInt522 * 128;
      final int int_3 = actor_0.anInt523 * 128 + actor_0.anInt499 * 64;
      final int int_4 = actor_0.anInt524 * 128 + actor_0.anInt499 * 64;
      final int int_5 = actor_0.anInt525 * 128 + actor_0.anInt499 * 64;
      actor_0.x = (int_1 * int_4 + int_2 * (int_0 - int_1)) / int_0;
      actor_0.y = (int_1 * int_5 + int_3 * (int_0 - int_1)) / int_0;
    }

    actor_0.anInt498 = 0;
    actor_0.orientation = actor_0.anInt526;
    actor_0.angle = actor_0.orientation;
  }

  @Override
  final void method618() {
    for (int int_0 = 0; int_0 < 8; int_0++) {
      final int int_1 = (int_0 & 0x1) == 0 ? anInt391 : anInt392;
      final int int_2 = (int_0 & 0x2) == 0 ? anInt393 : anInt394;
      final int int_3 = (int_0 & 0x4) == 0 ? anInt395 : anInt396;
      if ((int_0 & 0x1) == 0) {
        Class52.method332(int_1, int_2, int_3, anInt392, int_2, int_3, anInt397);
      }

      if ((int_0 & 0x2) == 0) {
        Class52.method332(int_1, int_2, int_3, int_1, anInt394, int_3, anInt397);
      }

      if ((int_0 & 0x4) == 0) {
        Class52.method332(int_1, int_2, int_3, int_1, int_2, anInt396, anInt397);
      }
    }

  }

}
