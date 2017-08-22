package jagex.oldschool.util;

import jagex.oldschool.AClass3_Sub1;
import jagex.oldschool.AClass4_Sub2;
import jagex.oldschool.AClass5_Sub1;
import jagex.oldschool.CacheableNode_Sub4;
import jagex.oldschool.Class23;
import jagex.oldschool.Class25;
import jagex.oldschool.Class40;
import jagex.oldschool.Client;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.io.SocketStream;
import jagex.oldschool.audio.SoundEffect;

public class MilliRegulator extends Regulator {

  int anInt386;
  int sleepTime;
  long[] memory;
  int anInt387;
  long milliTime;
  int anInt388;

  public MilliRegulator() {
    memory = new long[10];
    anInt386 = 256;
    sleepTime = 1;
    anInt387 = 0;
    milliTime = Time.currentTimeMillis();

    for (int int_0 = 0; int_0 < 10; int_0++) {
      memory[int_0] = milliTime;
    }

  }

  public static void method710() {
    for (int int_0 = 0; int_0 < Client.anInt648; int_0++) {
      --Client.anIntArray147[int_0];
      if (Client.anIntArray147[int_0] >= -10) {
        SoundEffect soundeffect_0 = Client.audioEffects[int_0];
        if (soundeffect_0 == null) {
          soundeffect_0 = SoundEffect.getTrack(Client.anIndexData5, Client.anIntArray145[int_0], 0);
          if (soundeffect_0 == null) {
            continue;
          }

          Client.anIntArray147[int_0] += soundeffect_0.calculateDelay();
          Client.audioEffects[int_0] = soundeffect_0;
        }

        if (Client.anIntArray147[int_0] < 0) {
          int int_8;
          if (Client.anIntArray148[int_0] != 0) {
            final int int_2 = (Client.anIntArray148[int_0] & 0xFF) * 128;
            final int int_3 = Client.anIntArray148[int_0] >> 16 & 0xFF;
            int int_4 = int_3 * 128 + 64 - GrandExchangeOffer.localPlayer.x;
            if (int_4 < 0) {
              int_4 = -int_4;
            }

            final int int_5 = Client.anIntArray148[int_0] >> 8 & 0xFF;
            int int_6 = int_5 * 128 + 64 - GrandExchangeOffer.localPlayer.y;
            if (int_6 < 0) {
              int_6 = -int_6;
            }

            int int_7 = int_6 + int_4 - 128;
            if (int_7 > int_2) {
              Client.anIntArray147[int_0] = -100;
              continue;
            }

            if (int_7 < 0) {
              int_7 = 0;
            }

            int_8 = (int_2 - int_7) * Client.anInt634 / int_2;
          } else {
            int_8 = Client.anInt647;
          }

          if (int_8 > 0) {
            final AClass5_Sub1 aclass5_sub1_0 = soundeffect_0.method428()
                .method727(Class40.aClass54_1);
            final AClass4_Sub2 aclass4_sub2_0 = AClass4_Sub2.method769(aclass5_sub1_0, 100, int_8);
            aclass4_sub2_0.method747(Client.anIntArray146[int_0] - 1);
            Class25.anAClass4_Sub1_1.method721(aclass4_sub2_0);
          }

          Client.anIntArray147[int_0] = -100;
        }
      } else {
        --Client.anInt648;

        for (int int_1 = int_0; int_1 < Client.anInt648; int_1++) {
          Client.anIntArray145[int_1] = Client.anIntArray145[int_1 + 1];
          Client.audioEffects[int_1] = Client.audioEffects[int_1 + 1];
          Client.anIntArray146[int_1] = Client.anIntArray146[int_1 + 1];
          Client.anIntArray147[int_1] = Client.anIntArray147[int_1 + 1];
          Client.anIntArray148[int_1] = Client.anIntArray148[int_1 + 1];
        }

        --int_0;
      }
    }

    if (Client.aBool81 && !SocketStream.method554()) {
      if (Client.anInt656 != 0 && Client.anInt613 != -1) {
        Class23
            .method212(CacheableNode_Sub4.indexTrack1, Client.anInt613, 0, Client.anInt656, false);
      }

      Client.aBool81 = false;
    }

  }

  @Override
  public int sleep(final int min, final int delta) {
    final int int_2 = anInt386;
    final int int_3 = sleepTime;
    anInt386 = 300;
    sleepTime = 1;
    milliTime = Time.currentTimeMillis();
    if (memory[anInt388] == 0L) {
      anInt386 = int_2;
      sleepTime = int_3;
    } else if (milliTime > memory[anInt388]) {
      anInt386 = (int) (min * 2560 / (milliTime - memory[anInt388]));
    }

    if (anInt386 < 25) {
      anInt386 = 25;
    }

    if (anInt386 > 256) {
      anInt386 = 256;
      sleepTime = (int) (min - (milliTime - memory[anInt388]) / 10L);
    }

    if (sleepTime > min) {
      sleepTime = min;
    }

    memory[anInt388] = milliTime;
    anInt388 = (anInt388 + 1) % 10;
    int int_4;
    if (sleepTime > 1) {
      for (int_4 = 0; int_4 < 10; int_4++) {
        if (memory[int_4] != 0L) {
          memory[int_4] += sleepTime;
        }
      }
    }

    if (sleepTime < delta) {
      sleepTime = delta;
    }

    AClass3_Sub1.method725(sleepTime);

    for (int_4 = 0; anInt387 < 256; anInt387 += anInt386) {
      ++int_4;
    }

    anInt387 &= 0xFF;
    return int_4;
  }

  @Override
  public void reset() {
    for (int int_0 = 0; int_0 < 10; int_0++) {
      memory[int_0] = 0L;
    }

  }

}
