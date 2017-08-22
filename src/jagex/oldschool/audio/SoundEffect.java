package jagex.oldschool.audio;

import jagex.oldschool.AClass5_Sub1;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.io.Buffer;

public class SoundEffect {

  int start;
  Instrument[] instruments;
  int end;

  SoundEffect(final Buffer buffer_0) {
    instruments = new Instrument[10];

    for (int int_0 = 0; int_0 < 10; int_0++) {
      final int int_1 = buffer_0.getUnsignedByte();
      if (int_1 != 0) {
        --buffer_0.offset;
        instruments[int_0] = new Instrument();
        instruments[int_0].decode(buffer_0);
      }
    }

    start = buffer_0.getUnsignedShort();
    end = buffer_0.getUnsignedShort();
  }

  public static SoundEffect getTrack(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1) {
    final byte[] bytes_0 = indexdatabase_0.get(int_0, int_1);
    return bytes_0 == null ? null : new SoundEffect(new Buffer(bytes_0));
  }

  final byte[] mix() {
    int int_0 = 0;

    int int_1;
    for (int_1 = 0; int_1 < 10; int_1++) {
      if (instruments[int_1] != null && instruments[int_1].duration + instruments[int_1].offset
          > int_0) {
        int_0 = instruments[int_1].duration + instruments[int_1].offset;
      }
    }

    if (int_0 == 0) {
      return new byte[0];
    }
    int_1 = int_0 * 22050 / 1000;
    final byte[] bytes_0 = new byte[int_1];

    for (int int_2 = 0; int_2 < 10; int_2++) {
      if (instruments[int_2] != null) {
        final int int_3 = instruments[int_2].duration * 22050 / 1000;
        final int int_4 = instruments[int_2].offset * 22050 / 1000;
        final int[] ints_0 = instruments[int_2].synthesize(int_3, instruments[int_2].duration);

        for (int int_5 = 0; int_5 < int_3; int_5++) {
          int int_6 = (ints_0[int_5] >> 8) + bytes_0[int_5 + int_4];
          if ((int_6 + 128 & 0xFFFFFF00) != 0) {
            int_6 = int_6 >> 31 ^ 0x7F;
          }

          bytes_0[int_5 + int_4] = (byte) int_6;
        }
      }
    }

    return bytes_0;
  }

  public AClass5_Sub1 method428() {
    final byte[] bytes_0 = mix();
    return new AClass5_Sub1(22050, bytes_0, start * 22050 / 1000, end * 22050 / 1000);
  }

  public final int calculateDelay() {
    int int_0 = 9999999;

    int int_1;
    for (int_1 = 0; int_1 < 10; int_1++) {
      if (instruments[int_1] != null && instruments[int_1].offset / 20 < int_0) {
        int_0 = instruments[int_1].offset / 20;
      }
    }

    if (start < end && start / 20 < int_0) {
      int_0 = start / 20;
    }

    if (int_0 != 9999999 && int_0 != 0) {
      for (int_1 = 0; int_1 < 10; int_1++) {
        if (instruments[int_1] != null) {
          instruments[int_1].offset -= int_0 * 20;
        }
      }

      if (start < end) {
        start -= int_0 * 20;
        end -= int_0 * 20;
      }

      return int_0;
    }
    return 0;
  }

}
