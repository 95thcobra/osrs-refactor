package jagex.oldschool.io;

import jagex.oldschool.Class35;
import jagex.oldschool.Class63;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.CombatInfo1;
import jagex.oldschool.collections.Node;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptState;
import java.math.BigInteger;

public class Buffer extends Node {

  public final static int[] CRC_TABLE;

  static {
    CRC_TABLE = new int[256];

    for (int i = 0; i < 256; i++) {
      int n = i;

      for (int j = 0; j < 8; j++) {
        if ((n & 0x1) == 1) {
          n = n >>> 1 ^ 0xEDB88320;
        } else {
          n >>>= 1;
        }
      }

      CRC_TABLE[i] = n;
    }
  }

  public byte[] bytes;
  public int offset;

  public Buffer(final int capacity) {
    bytes = Class63.getPooledBuffer(capacity);
    offset = 0;
  }

  public Buffer(final byte[] bytes) {
    this.bytes = bytes;
    offset = 0;
  }

  public int getInt() {
    offset += 4;
    return ((bytes[offset - 3] & 0xFF) << 16) + (bytes[offset - 1] & 0xFF) + (
        (bytes[offset - 2] & 0xFF) << 8)
        + ((bytes[offset - 4] & 0xFF) << 24);
  }

  public void putByte(final int b) {
    bytes[offset++] = (byte) b;
  }

  public int getUnsignedByte() {
    return bytes[offset++] & 0xFF;
  }

  public int getSmartInt() {
    if (bytes[offset] < 0) {
      return getInt() & 0x7FFFFFFF;
    }
    final int int_0 = getUnsignedShort();
    return int_0 == 32767 ? -1 : int_0;
  }

  public int getUnsignedMedium() {
    offset += 3;
    return ((bytes[offset - 3] & 0xFF) << 16) + (bytes[offset - 1] & 0xFF)
        + ((bytes[offset - 2] & 0xFF) << 8);
  }

  public int getVariableInt() {
    byte i = bytes[offset++];

    int n;
    for (n = 0; i < 0; i = bytes[offset++]) {
      n = (n | i & 0x7F) << 7;
    }

    return n | i;
  }

  public String getString() {
    final int off = offset;

    while (bytes[offset++] != 0) {
    }

    final int i = offset - off - 1;
    return i == 0 ? "" : ScriptCall.getString(bytes, off, i);
  }

  public byte getByte() {
    return bytes[offset++];
  }

  public int getUnsignedShort() {
    offset += 2;
    return (bytes[offset - 1] & 0xFF) + ((bytes[offset - 2] & 0xFF) << 8);
  }

  public void get(final byte[] dest, final int off, final int len) {
    for (int i = off; i < len + off; i++) {
      dest[i] = bytes[offset++];
    }
  }

  public void putInt(final int i) {
    bytes[offset++] = (byte) (i >> 24);
    bytes[offset++] = (byte) (i >> 16);
    bytes[offset++] = (byte) (i >> 8);
    bytes[offset++] = (byte) i;
  }

  public void putShort(final int i) {
    bytes[offset++] = (byte) (i >> 8);
    bytes[offset++] = (byte) i;
  }

  public int getShort() {
    offset += 2;
    int s = (bytes[offset - 1] & 0xFF) + ((bytes[offset - 2] & 0xFF) << 8);
    if (s > 32767) {
      s -= 65536;
    }

    return s;
  }

  public String getSuffixedString() {
    final byte check = bytes[offset++];
    if (check != 0) {
      throw new IllegalStateException("");
    }
    final int off = offset;

    while (bytes[offset++] != 0) {
    }

    final int len = offset - off - 1;
    return len == 0 ? "" : ScriptCall.getString(bytes, off, len);
  }

  public void putVariableInt(final int i) {
    if ((i & 0xFFFFFF80) != 0) {
      if ((i & 0xFFFFC000) != 0) {
        if ((i & 0xFFE00000) != 0) {
          if ((i & 0xF0000000) != 0) {
            putByte(i >>> 28 | 0x80);
          }

          putByte(i >>> 21 | 0x80);
        }

        putByte(i >>> 14 | 0x80);
      }

      putByte(i >>> 7 | 0x80);
    }

    putByte(i & 0x7F);
  }

  public void put(final byte[] src, final int off, final int len) {
    for (int i = off; i < len + off; i++) {
      bytes[offset++] = src[i];
    }

  }

  public long getLong() {
    final long upper = getInt() & 0xFFFFFFFFL;
    final long lower = getInt() & 0xFFFFFFFFL;
    return lower + (upper << 32);
  }

  public void decipher(final int[] key, final int off, final int len) {
    final int start = offset;
    offset = off;
    final int count = (len - off) / 8;

    for (int i = 0; i < count; i++) {
      int a = getInt();
      int b = getInt();
      int sum = 0xc6ef3720;
      final int delta = 0x9e3779b9;

      for (int round = 32; round-- > 0; a -= b + (b << 4 ^ b >>> 5)
          ^ sum + key[sum & 0x3]) {
        b -= a + (a << 4 ^ a >>> 5) ^ key[sum >>> 11 & 0x3] + sum;
        sum -= delta;
      }

      offset -= 8;
      putInt(a);
      putInt(b);
    }

    offset = start;
  }

  public int getUnsignedSmartInt() {
    return bytes[offset] < 0 ? getInt() & 0x7FFFFFFF : getUnsignedShort();
  }

  public void putString(final String str) {
    final int terminator = str.indexOf(0);
    if (terminator >= 0) {
      throw new IllegalArgumentException("");
    }
    offset += CombatInfo1.copy(str, 0, str.length(), bytes, offset);
    bytes[offset++] = 0;
  }

  public void putMedium(final int m) {
    bytes[offset++] = (byte) (m >> 16);
    bytes[offset++] = (byte) (m >> 8);
    bytes[offset++] = (byte) m;
  }

  public int getSmartShort() {
    final int b = bytes[offset] & 0xFF;
    return b < 128 ? getUnsignedByte() - 64 : getUnsignedShort() - 49152;
  }

  public void putPrefixedString(final String str) {
    final int terminator = str.indexOf(0);
    if (terminator >= 0) {
      throw new IllegalArgumentException("");
    }
    bytes[offset++] = 0;
    offset += CombatInfo1.copy(str, 0, str.length(), bytes, offset);
    bytes[offset++] = 0;
  }

  public void putLengthByte(final int int_0) {
    bytes[offset - int_0 - 1] = (byte) int_0;
  }

  @SuppressWarnings("UnusedReturnValue")
  public int putChecksum(final int start) {
    final int checksum = CollisionData.getChecksum(bytes, start, offset);
    putInt(checksum);
    return checksum;
  }

  public void putLeShortAdd(final int int_0) {
    bytes[offset++] = (byte) (int_0 + 128);
    bytes[offset++] = (byte) (int_0 >> 8);
  }

  public int getUnsignedSmartShort() {
    final int b = bytes[offset] & 0xFF;
    return b < 128 ? getUnsignedByte() : getUnsignedShort() - 32768;
  }

  public void putLong(final long l) {
    bytes[offset++] = (byte) (int) (l >> 56);
    bytes[offset++] = (byte) (int) (l >> 48);
    bytes[offset++] = (byte) (int) (l >> 40);
    bytes[offset++] = (byte) (int) (l >> 32);
    bytes[offset++] = (byte) (int) (l >> 24);
    bytes[offset++] = (byte) (int) (l >> 16);
    bytes[offset++] = (byte) (int) (l >> 8);
    bytes[offset++] = (byte) (int) l;
  }

  public void putShortAdd(final int s) {
    bytes[offset++] = (byte) (s >> 8);
    bytes[offset++] = (byte) (s + 128);
  }

  public byte getByteSub() {
    return (byte) (128 - bytes[offset++]);
  }

  public int getUnsignedLeShort() {
    offset += 2;
    return ((bytes[offset - 1] & 0xFF) << 8) + (bytes[offset - 2] & 0xFF);
  }

  public int getMeInt() {
    offset += 4;
    return ((bytes[offset - 1] & 0xFF) << 8) + ((bytes[offset - 4] & 0xFF) << 16) + (
        bytes[offset - 2] & 0xFF)
        + ((bytes[offset - 3] & 0xFF) << 24);
  }

  public int getUnsignedByteAdd() {
    return bytes[offset++] - 128 & 0xFF;
  }

  public int getUnsignedByteSub() {
    return 128 - bytes[offset++] & 0xFF;
  }

  public int getLeInt() {
    offset += 4;
    return (bytes[offset - 4] & 0xFF) + ((bytes[offset - 3] & 0xFF) << 8) + (
        (bytes[offset - 2] & 0xFF) << 16)
        + ((bytes[offset - 1] & 0xFF) << 24);
  }

  public void putIntMe(final int int_0) {
    bytes[offset++] = (byte) (int_0 >> 16);
    bytes[offset++] = (byte) (int_0 >> 24);
    bytes[offset++] = (byte) int_0;
    bytes[offset++] = (byte) (int_0 >> 8);
  }

  public void putLeShort(final int int_0) {
    bytes[offset++] = (byte) int_0;
    bytes[offset++] = (byte) (int_0 >> 8);
  }

  public int getImeInt() {
    offset += 4;
    return ((bytes[offset - 2] & 0xFF) << 24) + ((bytes[offset - 4] & 0xFF) << 8) + (
        bytes[offset - 3] & 0xFF)
        + ((bytes[offset - 1] & 0xFF) << 16);
  }

  public int getUnsignedLeShortAdd() {
    offset += 2;
    return ((bytes[offset - 1] & 0xFF) << 8) + (bytes[offset - 2] - 128 & 0xFF);
  }

  public int getUnsignedShortAdd() {
    offset += 2;
    return (bytes[offset - 1] - 128 & 0xFF) + ((bytes[offset - 2] & 0xFF) << 8);
  }

  public void putLeInt(final int i) {
    bytes[offset++] = (byte) i;
    bytes[offset++] = (byte) (i >> 8);
    bytes[offset++] = (byte) (i >> 16);
    bytes[offset++] = (byte) (i >> 24);
  }

  public void putLengthShort(final int s) {
    bytes[offset - s - 2] = (byte) (s >> 8);
    bytes[offset - s - 1] = (byte) s;
  }

  public int getUnsignedLeMedium() {
    offset += 3;
    return (bytes[offset - 3] & 0xFF) + ((bytes[offset - 2] & 0xFF) << 8)
        + ((bytes[offset - 1] & 0xFF) << 16);
  }

  public void encipher(final BigInteger exponent, final BigInteger modulus) {
    final int len = offset;
    offset = 0;
    final byte[] src = new byte[len];
    get(src, 0, len);
    final BigInteger a = new BigInteger(src);
    final BigInteger b = a.modPow(exponent, modulus);
    final byte[] enciphered = b.toByteArray();
    offset = 0;
    putShort(enciphered.length);
    put(enciphered, 0, enciphered.length);
  }

  public String getCESU8() {
    final byte byte_0 = bytes[offset++];
    if (byte_0 != 0) {
      throw new IllegalStateException("");
    }
    final int int_0 = getVariableInt();
    if (int_0 + offset > bytes.length) {
      throw new IllegalStateException("");
    }
    final byte[] bytes_0 = bytes;
    final int int_1 = offset;
    final char[] chars_0 = new char[int_0];
    int int_2 = 0;
    int int_3 = int_1;

    int int_6;
    for (final int int_4 = int_0 + int_1; int_3 < int_4; chars_0[int_2++] = (char) int_6) {
      final int int_5 = bytes_0[int_3++] & 0xFF;
      if (int_5 < 128) {
        if (int_5 == 0) {
          int_6 = 65533;
        } else {
          int_6 = int_5;
        }
      } else if (int_5 < 192) {
        int_6 = 65533;
      } else if (int_5 < 224) {
        if (int_3 < int_4 && (bytes_0[int_3] & 0xC0) == 128) {
          int_6 = (int_5 & 0x1F) << 6 | bytes_0[int_3++] & 0x3F;
          if (int_6 < 128) {
            int_6 = 65533;
          }
        } else {
          int_6 = 65533;
        }
      } else if (int_5 < 240) {
        if (int_3 + 1 < int_4 && (bytes_0[int_3] & 0xC0) == 128
            && (bytes_0[int_3 + 1] & 0xC0) == 128) {
          int_6 = (int_5 & 0xF) << 12 | (bytes_0[int_3++] & 0x3F) << 6
              | bytes_0[int_3++] & 0x3F;
          if (int_6 < 2048) {
            int_6 = 65533;
          }
        } else {
          int_6 = 65533;
        }
      } else if (int_5 < 248) {
        if (int_3 + 2 < int_4 && (bytes_0[int_3] & 0xC0) == 128
            && (bytes_0[int_3 + 1] & 0xC0) == 128 && (bytes_0[int_3 + 2] & 0xC0) == 128) {
          int_6 = (int_5 & 0x7) << 18 | (bytes_0[int_3++] & 0x3F) << 12
              | (bytes_0[int_3++] & 0x3F) << 6 | bytes_0[int_3++] & 0x3F;
          if (int_6 >= 65536 && int_6 <= 1114111) {
            int_6 = 65533;
          } else {
            int_6 = 65533;
          }
        } else {
          int_6 = 65533;
        }
      } else {
        int_6 = 65533;
      }
    }

    final String string_0 = new String(chars_0, 0, int_2);
    offset += int_0;
    return string_0;
  }

  public int getUnsignedByteNegate() {
    return 0 - bytes[offset++] & 0xFF;
  }

  public void putCESU8(final CharSequence seq) {
    final int int_0 = Class35.getLength(seq);
    bytes[offset++] = 0;
    putVariableInt(int_0);
    offset += ScriptState.method558(bytes, offset, seq);
  }

  public void putWideInt(final long l) {
    bytes[offset++] = (byte) (int) (l >> 40);
    bytes[offset++] = (byte) (int) (l >> 32);
    bytes[offset++] = (byte) (int) (l >> 24);
    bytes[offset++] = (byte) (int) (l >> 16);
    bytes[offset++] = (byte) (int) (l >> 8);
    bytes[offset++] = (byte) (int) l;
  }

  public int getLeShortAdd() {
    offset += 2;
    int s = ((bytes[offset - 1] & 0xFF) << 8) + (bytes[offset - 2] - 128 & 0xFF);
    if (s > 32767) {
      s -= 65536;
    }

    return s;
  }

  public int getLeShort() {
    offset += 2;
    int s = ((bytes[offset - 1] & 0xFF) << 8) + (bytes[offset - 2] & 0xFF);
    if (s > 32767) {
      s -= 65536;
    }

    return s;
  }

  public void encipher(final int[] key) {
    final int count = offset / 8;
    offset = 0;

    for (int i = 0; i < count; i++) {
      int a = getInt();
      int b = getInt();
      int sum = 0;
      final int delta = 0x9e3779b9;

      for (int rounds = 32; rounds-- > 0; b += a + (a << 4 ^ a >>> 5)
          ^ key[sum >>> 11 & 0x3] + sum) {
        a += b + (b << 4 ^ b >>> 5) ^ sum + key[sum & 0x3];
        sum += delta;
      }

      offset -= 8;
      putInt(a);
      putInt(b);
    }

  }

  public void putLengthInt(final int i) {
    bytes[offset - i - 4] = (byte) (i >> 24);
    bytes[offset - i - 3] = (byte) (i >> 16);
    bytes[offset - i - 2] = (byte) (i >> 8);
    bytes[offset - i - 1] = (byte) i;
  }

  public boolean validate() {
    offset -= 4;
    final int checksum = CollisionData.getChecksum(bytes, 0, offset);
    final int compare = getInt();
    return checksum == compare;
  }

  public void putByteAdd(final int int_0) {
    bytes[offset++] = (byte) (int_0 + 128);
  }

  public void putByteNegate(final int int_0) {
    bytes[offset++] = (byte) (0 - int_0);
  }

  public void putByteSub(final int int_0) {
    bytes[offset++] = (byte) (128 - int_0);
  }

  public byte getByteAdd() {
    return (byte) (bytes[offset++] - 128);
  }

  public void decipher(final int[] key) {
    final int count = offset / 8;
    offset = 0;

    for (int i = 0; i < count; i++) {
      int a = getInt();
      int b = getInt();
      int sum = 0xc6ef3720;
      final int delta = 0x9e3779b9;

      for (int rounds = 32; rounds-- > 0; a -= b + (b << 4 ^ b >>> 5)
          ^ sum + key[sum & 0x3]) {
        b -= a + (a << 4 ^ a >>> 5) ^ key[sum >>> 11 & 0x3] + sum;
        sum -= delta;
      }

      offset -= 8;
      putInt(a);
      putInt(b);
    }

  }

  public void encipher(final int[] key, final int off, final int len) {
    final int start = offset;
    offset = off;
    final int count = (len - off) / 8;

    for (int i = 0; i < count; i++) {
      int a = getInt();
      int b = getInt();
      int sum = 0;
      final int delta = 0x9e3779b9;

      for (int round = 32; round-- > 0; b += a + (a << 4 ^ a >>> 5)
          ^ key[sum >>> 11 & 0x3] + sum) {
        a += b + (b << 4 ^ b >>> 5) ^ sum + key[sum & 0x3];
        sum += delta;
      }

      offset -= 8;
      putInt(a);
      putInt(b);
    }

    offset = start;
  }

  @SuppressWarnings("UnusedReturnValue")
  public String getNullableString() {
    if (bytes[offset] == 0) {
      ++offset;
      return null;
    }
    return getString();
  }

  public void putImeInt(final int i) {
    bytes[offset++] = (byte) (i >> 8);
    bytes[offset++] = (byte) i;
    bytes[offset++] = (byte) (i >> 24);
    bytes[offset++] = (byte) (i >> 16);
  }

  public void putShortSmart(final int s) {
    if (s >= 0 && s < 128) {
      putByte(s);
    } else if (s >= 0 && s < 32768) {
      putShort(s + 32768);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
