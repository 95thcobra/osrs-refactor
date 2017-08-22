package jagex.oldschool.io;

import jagex.oldschool.security.Isaac;

public final class GameBuffer extends Buffer {

  static final int[] MASKS = new int[] {
      0x0, 0x1, 0x3, 0x7, 0xf, 0x1f, 0x3f, 0x7f, 0xff, 0x1ff, 0x3ff, 0x7ff, 0xfff, 0x1fff, 0x3fff,
      0x7fff, 0xffff, 0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff,
      0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, 0xffffffff
  };

  int bitPosition;
  Isaac cipher;

  public GameBuffer(final int capacity) {
    super(capacity);
  }

  public int getDecipheredByte() {
    return super.bytes[super.offset++] - cipher.nextInt() & 0xFF;
  }

  public void putEncipheredByte(final int i) {
    super.bytes[super.offset++] = (byte) (i + cipher.nextInt());
  }

  public void beginBitAccess() {
    bitPosition = super.offset * 8;
  }

  public int getBits(int n) {
    int byteOff = bitPosition >> 3;
    int remaining = 8 - (bitPosition & 0x7);
    int i = 0;

    for (bitPosition += n; n > remaining; remaining = 8) {
      i += (super.bytes[byteOff++] & MASKS[remaining]) << n - remaining;
      n -= remaining;
    }

    if (remaining == n) {
      i += super.bytes[byteOff] & MASKS[remaining];
    } else {
      i += super.bytes[byteOff] >> remaining - n & MASKS[n];
    }

    return i;
  }

  public void endBitAccess() {
    super.offset = (bitPosition + 7) / 8;
  }

  public int availableBits(final int bitOff) {
    return bitOff * 8 - bitPosition;
  }

  public void seed(final int[] key) {
    cipher = new Isaac(key);
  }

}
