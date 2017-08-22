package jagex.oldschool.audio;

import jagex.oldschool.util.Arrays;
import jagex.oldschool.io.Buffer;
import java.util.Random;

public class Instrument {

  static int[] NOISE;
  static int[] samples;
  static int[] SINE;
  static int[] phases;
  static int[] delays;
  static int[] volumeSteps;
  static int[] pitchSteps;
  static int[] pitchBaseSteps;

  static {
    NOISE = new int[32768];
    final Random random_0 = new Random(0L);

    int int_0;
    for (int_0 = 0; int_0 < 32768; int_0++) {
      NOISE[int_0] = (random_0.nextInt() & 0x2) - 1;
    }

    SINE = new int[32768];

    for (int_0 = 0; int_0 < 32768; int_0++) {
      SINE[int_0] = (int) (Math.sin(int_0 / 5215.1903D) * 16384.0D);
    }

    samples = new int[220500];
    phases = new int[5];
    delays = new int[5];
    volumeSteps = new int[5];
    pitchSteps = new int[5];
    pitchBaseSteps = new int[5];
  }

  Envelope pitch;
  int duration;
  int offset;
  int[] oscillatorVolume;
  Envelope volume;
  int[] oscillatorPitch;
  Envelope pitchModifier;
  Envelope volumeMultiplier;
  Envelope pitchModifierAmplitude;
  int[] oscillatorDelays;
  Envelope volumeMultiplierAmplitude;
  int delayTime;
  int delayDecay;
  Envelope release;
  Envelope anAudioEnvelope1;
  SoundEffect3 filter;
  Envelope filterEnvelope;

  Instrument() {
    oscillatorVolume = new int[] {0, 0, 0, 0, 0};
    oscillatorPitch = new int[] {0, 0, 0, 0, 0};
    oscillatorDelays = new int[] {0, 0, 0, 0, 0};
    delayTime = 0;
    delayDecay = 100;
    duration = 500;
    offset = 0;
  }

  public final int[] synthesize(final int int_0, final int int_1) {
    Arrays.clear(samples, 0, int_0);
    if (int_1 < 10) {
      return samples;
    }
    final double double_0 = int_0 / (int_1 + 0.0D);
    pitch.reset();
    volume.reset();
    int int_2 = 0;
    int int_3 = 0;
    int int_4 = 0;
    if (pitchModifier != null) {
      pitchModifier.reset();
      pitchModifierAmplitude.reset();
      int_2 = (int) ((pitchModifier.end - pitchModifier.start) * 32.768D / double_0);
      int_3 = (int) (pitchModifier.start * 32.768D / double_0);
    }

    int int_5 = 0;
    int int_6 = 0;
    int int_7 = 0;
    if (volumeMultiplier != null) {
      volumeMultiplier.reset();
      volumeMultiplierAmplitude.reset();
      int_5 = (int) ((volumeMultiplier.end - volumeMultiplier.start) * 32.768D / double_0);
      int_6 = (int) (volumeMultiplier.start * 32.768D / double_0);
    }

    int int_8;
    for (int_8 = 0; int_8 < 5; int_8++) {
      if (oscillatorVolume[int_8] != 0) {
        phases[int_8] = 0;
        delays[int_8] = (int) (oscillatorDelays[int_8] * double_0);
        volumeSteps[int_8] = (oscillatorVolume[int_8] << 14) / 100;
        pitchSteps[int_8] = (int) ((pitch.end - pitch.start) * 32.768D
            * Math.pow(1.0057929410678534D, oscillatorPitch[int_8]) / double_0);
        pitchBaseSteps[int_8] = (int) (pitch.start * 32.768D / double_0);
      }
    }

    int int_9;
    int int_10;
    int int_11;
    int int_12;
    for (int_8 = 0; int_8 < int_0; int_8++) {
      int_9 = pitch.step(int_0);
      int_10 = volume.step(int_0);
      if (pitchModifier != null) {
        int_11 = pitchModifier.step(int_0);
        int_12 = pitchModifierAmplitude.step(int_0);
        int_9 += evaluateWave(int_4, int_12, pitchModifier.form) >> 1;
        int_4 += (int_11 * int_2 >> 16) + int_3;
      }

      if (volumeMultiplier != null) {
        int_11 = volumeMultiplier.step(int_0);
        int_12 = volumeMultiplierAmplitude.step(int_0);
        int_10 =
            int_10 * ((evaluateWave(int_7, int_12, volumeMultiplier.form) >> 1) + 32768) >> 15;
        int_7 = int_7 + int_6 + (int_11 * int_5 >> 16);
      }

      for (int_11 = 0; int_11 < 5; int_11++) {
        if (oscillatorVolume[int_11] != 0) {
          int_12 = delays[int_11] + int_8;
          if (int_12 < int_0) {
            samples[int_12] += evaluateWave(phases[int_11], volumeSteps[int_11] * int_10 >> 15,
                pitch.form);
            phases[int_11] += (pitchSteps[int_11] * int_9 >> 16) + pitchBaseSteps[int_11];
          }
        }
      }
    }

    int int_13;
    if (release != null) {
      release.reset();
      anAudioEnvelope1.reset();
      int_8 = 0;
      boolean bool_1 = true;

      for (int_11 = 0; int_11 < int_0; int_11++) {
        int_12 = release.step(int_0);
        int_13 = anAudioEnvelope1.step(int_0);
        if (bool_1) {
          int_9 = release.start + (int_12 * (release.end - release.start) >> 8);
        } else {
          int_9 = (int_13 * (release.end - release.start) >> 8) + release.start;
        }

        int_8 += 256;
        if (int_8 >= int_9) {
          int_8 = 0;
          bool_1 = !bool_1;
        }

        if (bool_1) {
          samples[int_11] = 0;
        }
      }
    }

    if (delayTime > 0 && delayDecay > 0) {
      int_8 = (int) (delayTime * double_0);

      for (int_9 = int_8; int_9 < int_0; int_9++) {
        samples[int_9] += samples[int_9 - int_8] * delayDecay / 100;
      }
    }

    if (filter.pairs[0] > 0 || filter.pairs[1] > 0) {
      filterEnvelope.reset();
      int_8 = filterEnvelope.step(int_0 + 1);
      int_9 = filter.compute(0, int_8 / 65536.0F);
      int_10 = filter.compute(1, int_8 / 65536.0F);
      if (int_0 >= int_9 + int_10) {
        int_11 = 0;
        int_12 = int_10;
        if (int_10 > int_0 - int_9) {
          int_12 = int_0 - int_9;
        }

        int int_14;
        while (int_11 < int_12) {
          int_13 = (int) ((long) samples[int_11 + int_9] * (long) SoundEffect3.fowardMultiplier
              >> 16);

          for (int_14 = 0; int_14 < int_9; int_14++) {
            int_13 += (int) ((long) samples[(int_11 + int_9) - 1 - int_14]
                * (long) SoundEffect3.coefficients[0][int_14] >> 16);
          }

          for (int_14 = 0; int_14 < int_11; int_14++) {
            int_13 -= (int) ((long) samples[int_11 - 1 - int_14]
                * (long) SoundEffect3.coefficients[1][int_14] >> 16);
          }

          samples[int_11] = int_13;
          int_8 = filterEnvelope.step(int_0 + 1);
          ++int_11;
        }

        int_12 = 128;

        while (true) {
          if (int_12 > int_0 - int_9) {
            int_12 = int_0 - int_9;
          }

          int int_15;
          while (int_11 < int_12) {
            int_14 = (int) ((long) samples[int_11 + int_9]
                * (long) SoundEffect3.fowardMultiplier >> 16);

            for (int_15 = 0; int_15 < int_9; int_15++) {
              int_14 += (int) ((long) samples[(int_11 + int_9) - 1 - int_15]
                  * (long) SoundEffect3.coefficients[0][int_15] >> 16);
            }

            for (int_15 = 0; int_15 < int_10; int_15++) {
              int_14 -= (int) ((long) samples[int_11 - 1 - int_15]
                  * (long) SoundEffect3.coefficients[1][int_15] >> 16);
            }

            samples[int_11] = int_14;
            int_8 = filterEnvelope.step(int_0 + 1);
            ++int_11;
          }

          if (int_11 >= int_0 - int_9) {
            while (int_11 < int_0) {
              int_14 = 0;

              for (int_15 = int_11 + int_9 - int_0; int_15 < int_9; int_15++) {
                int_14 += (int) ((long) samples[(int_11 + int_9) - 1 - int_15]
                    * (long) SoundEffect3.coefficients[0][int_15] >> 16);
              }

              for (int_15 = 0; int_15 < int_10; int_15++) {
                int_14 -= (int) ((long) samples[int_11 - 1 - int_15]
                    * (long) SoundEffect3.coefficients[1][int_15] >> 16);
              }

              samples[int_11] = int_14;
              filterEnvelope.step(int_0 + 1);
              ++int_11;
            }
            break;
          }

          int_9 = filter.compute(0, int_8 / 65536.0F);
          int_10 = filter.compute(1, int_8 / 65536.0F);
          int_12 += 128;
        }
      }
    }

    for (int_8 = 0; int_8 < int_0; int_8++) {
      if (samples[int_8] < -32768) {
        samples[int_8] = -32768;
      }

      if (samples[int_8] > 32767) {
        samples[int_8] = 32767;
      }
    }

    return samples;
  }

  final void decode(final Buffer buffer_0) {
    pitch = new Envelope();
    pitch.decode(buffer_0);
    volume = new Envelope();
    volume.decode(buffer_0);
    int int_0 = buffer_0.getUnsignedByte();
    if (int_0 != 0) {
      --buffer_0.offset;
      pitchModifier = new Envelope();
      pitchModifier.decode(buffer_0);
      pitchModifierAmplitude = new Envelope();
      pitchModifierAmplitude.decode(buffer_0);
    }

    int_0 = buffer_0.getUnsignedByte();
    if (int_0 != 0) {
      --buffer_0.offset;
      volumeMultiplier = new Envelope();
      volumeMultiplier.decode(buffer_0);
      volumeMultiplierAmplitude = new Envelope();
      volumeMultiplierAmplitude.decode(buffer_0);
    }

    int_0 = buffer_0.getUnsignedByte();
    if (int_0 != 0) {
      --buffer_0.offset;
      release = new Envelope();
      release.decode(buffer_0);
      anAudioEnvelope1 = new Envelope();
      anAudioEnvelope1.decode(buffer_0);
    }

    for (int int_1 = 0; int_1 < 10; int_1++) {
      final int int_2 = buffer_0.getUnsignedSmartShort();
      if (int_2 == 0) {
        break;
      }

      oscillatorVolume[int_1] = int_2;
      oscillatorPitch[int_1] = buffer_0.getSmartShort();
      oscillatorDelays[int_1] = buffer_0.getUnsignedSmartShort();
    }

    delayTime = buffer_0.getUnsignedSmartShort();
    delayDecay = buffer_0.getUnsignedSmartShort();
    duration = buffer_0.getUnsignedShort();
    offset = buffer_0.getUnsignedShort();
    filter = new SoundEffect3();
    filterEnvelope = new Envelope();
    filter.decode(buffer_0, filterEnvelope);
  }

  final int evaluateWave(final int int_0, final int int_1, final int int_2) {
    return int_2 == 1 ? (int_0 & 0x7FFF) < 16384 ? int_1 : -int_1
        : int_2 == 2 ? SINE[int_0 & 0x7FFF] * int_1 >> 14
            : int_2 == 3 ? (int_1 * (int_0 & 0x7FFF) >> 14) - int_1
                : int_2 == 4 ? int_1 * NOISE[int_0 / 2607 & 0x7FFF] : 0;
  }

}
