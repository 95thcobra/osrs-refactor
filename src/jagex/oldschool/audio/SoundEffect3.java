package jagex.oldschool.audio;

import jagex.oldschool.audio.Envelope;
import jagex.oldschool.io.Buffer;

public class SoundEffect3 {

  static float[][] minimisedCoefficients;
  static int[][] coefficients;
  static float fowardMinimisedCoefficientMultiplier;
  static int fowardMultiplier;

  static {
    minimisedCoefficients = new float[2][8];
    coefficients = new int[2][8];
  }

  int[][][] phases;
  int[][][] magnitudes;
  int[] unity;
  int[] pairs;

  SoundEffect3() {
    pairs = new int[2];
    phases = new int[2][2][4];
    magnitudes = new int[2][2][4];
    unity = new int[2];
  }

  static float normalise(final float float_0) {
    final float float_1 = 32.703197F * (float) Math.pow(2.0D, float_0);
    return float_1 * 3.1415927F / 11025.0F;
  }

  float interpolateMagniture(final int int_0, final int int_1, final float float_0) {
    float float_1 = magnitudes[int_0][0][int_1]
        + float_0 * (magnitudes[int_0][1][int_1] - magnitudes[int_0][0][int_1]);
    float_1 *= 0.0015258789F;
    return 1.0F - (float) Math.pow(10.0D, -float_1 / 20.0F);
  }

  float interpolatePhase(final int int_0, final int int_1, final float float_0) {
    float float_1 =
        phases[int_0][0][int_1] + float_0 * (phases[int_0][1][int_1] - phases[int_0][0][int_1]);
    float_1 *= 1.2207031E-4F;
    return normalise(float_1);
  }

  int compute(final int int_0, final float float_0) {
    float float_1;
    if (int_0 == 0) {
      float_1 = unity[0] + (unity[1] - unity[0]) * float_0;
      float_1 *= 0.0030517578F;
      fowardMinimisedCoefficientMultiplier = (float) Math.pow(0.1D, float_1 / 20.0F);
      fowardMultiplier = (int) (fowardMinimisedCoefficientMultiplier * 65536.0F);
    }

    if (pairs[int_0] == 0) {
      return 0;
    }
    float_1 = interpolateMagniture(int_0, 0, float_0);
    minimisedCoefficients[int_0][0] =
        -2.0F * float_1 * (float) Math.cos(interpolatePhase(int_0, 0, float_0));
    minimisedCoefficients[int_0][1] = float_1 * float_1;

    int int_1;
    for (int_1 = 1; int_1 < pairs[int_0]; int_1++) {
      float_1 = interpolateMagniture(int_0, int_1, float_0);
      final float float_2 =
          -2.0F * float_1 * (float) Math.cos(interpolatePhase(int_0, int_1, float_0));
      final float float_3 = float_1 * float_1;
      minimisedCoefficients[int_0][int_1 * 2 + 1] =
          minimisedCoefficients[int_0][int_1 * 2 - 1] * float_3;
      minimisedCoefficients[int_0][int_1 * 2] =
          minimisedCoefficients[int_0][int_1 * 2 - 1] * float_2
              + minimisedCoefficients[int_0][int_1 * 2 - 2] * float_3;

      for (int int_2 = int_1 * 2 - 1; int_2 >= 2; --int_2) {
        minimisedCoefficients[int_0][int_2] += minimisedCoefficients[int_0][int_2 - 1] * float_2
            + minimisedCoefficients[int_0][int_2 - 2] * float_3;
      }

      minimisedCoefficients[int_0][1] += minimisedCoefficients[int_0][0] * float_2 + float_3;
      minimisedCoefficients[int_0][0] += float_2;
    }

    if (int_0 == 0) {
      for (int_1 = 0; int_1 < pairs[0] * 2; int_1++) {
        minimisedCoefficients[0][int_1] *= fowardMinimisedCoefficientMultiplier;
      }
    }

    for (int_1 = 0; int_1 < pairs[int_0] * 2; int_1++) {
      coefficients[int_0][int_1] = (int) (minimisedCoefficients[int_0][int_1] * 65536.0F);
    }

    return pairs[int_0] * 2;
  }

  final void decode(final Buffer buffer_0, final Envelope audioenvelope_0) {
    final int int_0 = buffer_0.getUnsignedByte();
    pairs[0] = int_0 >> 4;
    pairs[1] = int_0 & 0xF;
    if (int_0 == 0) {
      final int[] ints_0 = unity;
      unity[1] = 0;
      ints_0[0] = 0;
    } else {
      unity[0] = buffer_0.getUnsignedShort();
      unity[1] = buffer_0.getUnsignedShort();
      final int int_1 = buffer_0.getUnsignedByte();

      int int_2;
      int int_3;
      for (int_2 = 0; int_2 < 2; int_2++) {
        for (int_3 = 0; int_3 < pairs[int_2]; int_3++) {
          phases[int_2][0][int_3] = buffer_0.getUnsignedShort();
          magnitudes[int_2][0][int_3] = buffer_0.getUnsignedShort();
        }
      }

      for (int_2 = 0; int_2 < 2; int_2++) {
        for (int_3 = 0; int_3 < pairs[int_2]; int_3++) {
          if ((int_1 & 1 << int_2 * 4 << int_3) != 0) {
            phases[int_2][1][int_3] = buffer_0.getUnsignedShort();
            magnitudes[int_2][1][int_3] = buffer_0.getUnsignedShort();
          } else {
            phases[int_2][1][int_3] = phases[int_2][0][int_3];
            magnitudes[int_2][1][int_3] = magnitudes[int_2][0][int_3];
          }
        }
      }

      if (int_1 != 0 || unity[1] != unity[0]) {
        audioenvelope_0.decodeSegments(buffer_0);
      }

    }
  }

}
