package jagex.oldschool;

import jagex.oldschool.io.Buffer;

public class Class74 {

  static final byte[] aByteArray8;

  static {
    aByteArray8 = new byte[] {
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1,
        (byte) 1,
        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1,
        (byte) 1,
        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1,
        (byte) 1,
        (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2,
        (byte) 2,
        (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 0, (byte) 1, (byte) 2, (byte) 1, (byte) 0,
        (byte) 0,
        (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        (byte) 0
    };
  }

  long aLong9;
  int[] anIntArray40;
  Buffer aBuffer4;
  int anInt171;
  int[] anIntArray41;
  int[] anIntArray42;
  int[] anIntArray43;
  int anInt172;

  Class74(final byte[] bytes_0) {
    aBuffer4 = new Buffer(null);
    method434(bytes_0);
  }

  Class74() {
    aBuffer4 = new Buffer(null);
  }

  int method431(final int int_0) {
    final byte byte_0 = aBuffer4.bytes[aBuffer4.offset];
    int int_3;
    if (byte_0 < 0) {
      int_3 = byte_0 & 0xFF;
      anIntArray43[int_0] = int_3;
      ++aBuffer4.offset;
    } else {
      int_3 = anIntArray43[int_0];
    }

    if (int_3 != 240 && int_3 != 247) {
      return method440(int_0, int_3);
    }
    final int int_1 = aBuffer4.getVariableInt();
    if (int_3 == 247 && int_1 > 0) {
      final int int_2 = aBuffer4.bytes[aBuffer4.offset] & 0xFF;
      if (int_2 >= 241 && int_2 <= 243 || int_2 == 246 || int_2 == 248
          || int_2 >= 250 && int_2 <= 252 || int_2 == 254) {
        ++aBuffer4.offset;
        anIntArray43[int_0] = int_2;
        return method440(int_0, int_2);
      }
    }

    aBuffer4.offset += int_1;
    return 0;
  }

  void method432() {
    aBuffer4.bytes = null;
    anIntArray41 = null;
    anIntArray40 = null;
    anIntArray42 = null;
    anIntArray43 = null;
  }

  boolean method433() {
    return aBuffer4.bytes != null;
  }

  void method434(final byte[] bytes_0) {
    aBuffer4.bytes = bytes_0;
    aBuffer4.offset = 10;
    final int int_0 = aBuffer4.getUnsignedShort();
    anInt172 = aBuffer4.getUnsignedShort();
    anInt171 = 500000;
    anIntArray41 = new int[int_0];

    int int_1;
    int int_3;
    for (int_1 = 0; int_1 < int_0; aBuffer4.offset += int_3) {
      final int int_2 = aBuffer4.getInt();
      int_3 = aBuffer4.getInt();
      if (int_2 == 1297379947) {
        anIntArray41[int_1] = aBuffer4.offset;
        ++int_1;
      }
    }

    aLong9 = 0L;
    anIntArray40 = new int[int_0];

    for (int_1 = 0; int_1 < int_0; int_1++) {
      anIntArray40[int_1] = anIntArray41[int_1];
    }

    anIntArray42 = new int[int_0];
    anIntArray43 = new int[int_0];
  }

  void method435(final int int_0) {
    aBuffer4.offset = anIntArray40[int_0];
  }

  int method436() {
    final int int_0 = anIntArray40.length;
    int int_1 = -1;
    int int_2 = Integer.MAX_VALUE;

    for (int int_3 = 0; int_3 < int_0; int_3++) {
      if (anIntArray40[int_3] >= 0 && anIntArray42[int_3] < int_2) {
        int_1 = int_3;
        int_2 = anIntArray42[int_3];
      }
    }

    return int_1;
  }

  int method437() {
    return anIntArray40.length;
  }

  int method438(final int int_0) {
    final int int_1 = method431(int_0);
    return int_1;
  }

  void method439(final int int_0) {
    final int int_1 = aBuffer4.getVariableInt();
    anIntArray42[int_0] += int_1;
  }

  int method440(final int int_0, final int int_1) {
    int int_2;
    if (int_1 == 255) {
      final int int_5 = aBuffer4.getUnsignedByte();
      int_2 = aBuffer4.getVariableInt();
      if (int_5 == 47) {
        aBuffer4.offset += int_2;
        return 1;
      }
      if (int_5 == 81) {
        final int int_3 = aBuffer4.getUnsignedMedium();
        int_2 -= 3;
        final int int_4 = anIntArray42[int_0];
        aLong9 += (long) int_4 * (long) (anInt171 - int_3);
        anInt171 = int_3;
        aBuffer4.offset += int_2;
        return 2;
      }
      aBuffer4.offset += int_2;
      return 3;
    }
    final byte byte_0 = aByteArray8[int_1 - 128];
    int_2 = int_1;
    if (byte_0 >= 1) {
      int_2 = int_1 | aBuffer4.getUnsignedByte() << 8;
    }

    if (byte_0 >= 2) {
      int_2 |= aBuffer4.getUnsignedByte() << 16;
    }

    return int_2;
  }

  long method441(final int int_0) {
    return aLong9 + (long) int_0 * (long) anInt171;
  }

  void method442() {
    aBuffer4.offset = -1;
  }

  void method443(final int int_0) {
    anIntArray40[int_0] = aBuffer4.offset;
  }

  boolean method444() {
    final int int_0 = anIntArray40.length;

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      if (anIntArray40[int_1] >= 0) {
        return false;
      }
    }

    return true;
  }

  void method445(final long long_0) {
    aLong9 = long_0;
    final int int_0 = anIntArray40.length;

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      anIntArray42[int_1] = 0;
      anIntArray43[int_1] = 0;
      aBuffer4.offset = anIntArray41[int_1];
      method439(int_1);
      anIntArray40[int_1] = aBuffer4.offset;
    }

  }

}
