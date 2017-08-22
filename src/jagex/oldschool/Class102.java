package jagex.oldschool;

import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.security.Isaac;

public class Class102 {

  public int anInt199;
  public int anInt200;

  Class102(final int int_0, final int int_1, final int int_2, final int int_3) {
    method517(int_0, int_1);
    method518(int_2, int_3);
  }

  public Class102(final int int_0, final int int_1) {
    this(0, 0, int_0, int_1);
  }

  public static void decodeSprite(final byte[] bytes_0) {
    final Buffer buffer_0 = new Buffer(bytes_0);
    buffer_0.offset = bytes_0.length - 2;
    SpriteLoader.anInt205 = buffer_0.getUnsignedShort();
    SpriteLoader.anIntArray56 = new int[SpriteLoader.anInt205];
    CacheableNode_Sub1.offsetsY = new int[SpriteLoader.anInt205];
    Class94.anIntArray48 = new int[SpriteLoader.anInt205];
    SpriteLoader.anIntArray57 = new int[SpriteLoader.anInt205];
    SpriteLoader.spritePixels = new byte[SpriteLoader.anInt205][];
    buffer_0.offset = bytes_0.length - 7 - SpriteLoader.anInt205 * 8;
    SpriteLoader.anInt204 = buffer_0.getUnsignedShort();
    Isaac.anInt181 = buffer_0.getUnsignedShort();
    final int int_0 = (buffer_0.getUnsignedByte() & 0xFF) + 1;

    int int_1;
    for (int_1 = 0; int_1 < SpriteLoader.anInt205; int_1++) {
      SpriteLoader.anIntArray56[int_1] = buffer_0.getUnsignedShort();
    }

    for (int_1 = 0; int_1 < SpriteLoader.anInt205; int_1++) {
      CacheableNode_Sub1.offsetsY[int_1] = buffer_0.getUnsignedShort();
    }

    for (int_1 = 0; int_1 < SpriteLoader.anInt205; int_1++) {
      Class94.anIntArray48[int_1] = buffer_0.getUnsignedShort();
    }

    for (int_1 = 0; int_1 < SpriteLoader.anInt205; int_1++) {
      SpriteLoader.anIntArray57[int_1] = buffer_0.getUnsignedShort();
    }

    buffer_0.offset = bytes_0.length - 7 - SpriteLoader.anInt205 * 8 - (int_0 - 1) * 3;
    SpriteLoader.anIntArray58 = new int[int_0];

    for (int_1 = 1; int_1 < int_0; int_1++) {
      SpriteLoader.anIntArray58[int_1] = buffer_0.getUnsignedMedium();
      if (SpriteLoader.anIntArray58[int_1] == 0) {
        SpriteLoader.anIntArray58[int_1] = 1;
      }
    }

    buffer_0.offset = 0;

    for (int_1 = 0; int_1 < SpriteLoader.anInt205; int_1++) {
      final int int_2 = Class94.anIntArray48[int_1];
      final int int_3 = SpriteLoader.anIntArray57[int_1];
      final int int_4 = int_2 * int_3;
      final byte[] bytes_1 = new byte[int_4];
      SpriteLoader.spritePixels[int_1] = bytes_1;
      final int int_5 = buffer_0.getUnsignedByte();
      int int_6;
      if (int_5 == 0) {
        for (int_6 = 0; int_6 < int_4; int_6++) {
          bytes_1[int_6] = buffer_0.getByte();
        }
      } else if (int_5 == 1) {
        for (int_6 = 0; int_6 < int_2; int_6++) {
          for (int int_7 = 0; int_7 < int_3; int_7++) {
            bytes_1[int_6 + int_2 * int_7] = buffer_0.getByte();
          }
        }
      }
    }

  }

  void method517(final int int_0, final int int_1) {
  }

  void method518(final int int_0, final int int_1) {
    anInt199 = int_0;
    anInt200 = int_1;
  }

}
