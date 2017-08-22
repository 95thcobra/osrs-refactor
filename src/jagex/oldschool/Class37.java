package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.io.AbstractByteBuffer;
import jagex.oldschool.io.DirectByteBuffer;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.script.ScriptState;
import java.net.URL;

public class Class37 {

  static Package anIndexData1;
  final URL anURL1;
  byte[] aByteArray2;
  boolean aBool9;

  Class37(final URL url_0) {
    anURL1 = url_0;
  }

  public static Object wrap(final byte[] bytes) {
    if (bytes == null) {
      return null;
    }
    if (bytes.length > 136 && !AbstractByteBuffer.USE_HEAP_BUFFERS) {
      try {
        final DirectByteBuffer buffer = new DirectByteBuffer();
        buffer.put(bytes);
        return buffer;
      } catch (final Throwable throwable_0) {
        AbstractByteBuffer.USE_HEAP_BUFFERS = true;
      }
    }

    return bytes;
  }

  public static boolean method261(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final AbstractPackage indexdatabase_2, final AClass4_Sub3 aclass4_sub3_0) {
    Class72.anIndexDataBase7 = indexdatabase_0;
    Class72.anIndexDataBase6 = indexdatabase_1;
    Class72.anIndexDataBase5 = indexdatabase_2;
    Class72.anAClass4_Sub3_1 = aclass4_sub3_0;
    return true;
  }

  static void method262(final int int_0) {
    final int[] ints_0 = ItemConfig.aSpritePixels5.buffer;
    final int int_1 = ints_0.length;

    int int_2;
    for (int_2 = 0; int_2 < int_1; int_2++) {
      ints_0[int_2] = 0;
    }

    int int_3;
    int int_4;
    for (int_2 = 1; int_2 < 103; int_2++) {
      int_3 = (103 - int_2) * 2048 + 24628;

      for (int_4 = 1; int_4 < 103; int_4++) {
        if ((Class22.flags[int_0][int_4][int_2] & 0x18) == 0) {
          Class11.region.method370(ints_0, int_3, 512, int_0, int_4, int_2);
        }

        if (int_0 < 3 && (Class22.flags[int_0 + 1][int_4][int_2] & 0x8) != 0) {
          Class11.region.method370(ints_0, int_3, 512, int_0 + 1, int_4, int_2);
        }

        int_3 += 4;
      }
    }

    int_2 = (238 + (int) (Math.random() * 20.0D) - 10 << 16)
        + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + 238 + (int) (Math.random() * 20.0D)
        - 10;
    int_3 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
    ItemConfig.aSpritePixels5.method943();

    int int_5;
    for (int_4 = 1; int_4 < 103; int_4++) {
      for (int_5 = 1; int_5 < 103; int_5++) {
        if ((Class22.flags[int_0][int_5][int_4] & 0x18) == 0) {
          ScriptState.method559(int_0, int_5, int_4, int_2, int_3);
        }

        if (int_0 < 3 && (Class22.flags[int_0 + 1][int_5][int_4] & 0x8) != 0) {
          ScriptState.method559(int_0 + 1, int_5, int_4, int_2, int_3);
        }
      }
    }

    Client.anInt661 = 0;

    for (int_4 = 0; int_4 < 104; int_4++) {
      for (int_5 = 0; int_5 < 104; int_5++) {
        int int_6 = Class11.region.method375(Class12.plane, int_4, int_5);
        if (int_6 != 0) {
          int_6 = int_6 >> 14 & 0x7FFF;
          final int int_7 = Class2.getObjectDefinition(int_6).mapIconId;
          if (int_7 >= 0) {
            Client.aSpritePixelsArray4[Client.anInt661] = Area.anAreaArray1[int_7].method774(false);
            Client.anIntArray149[Client.anInt661] = int_4;
            Client.anIntArray151[Client.anInt661] = int_5;
            ++Client.anInt661;
          }
        }
      }
    }

    FileCache.aBufferProvider1.init();
  }

  static void method263(final int int_0, final int int_1, final int int_2) {
    int int_3;
    for (int_3 = 0; int_3 < 8; int_3++) {
      for (int int_4 = 0; int_4 < 8; int_4++) {
        Class22.heightmap[int_0][int_3 + int_1][int_4 + int_2] = 0;
      }
    }

    if (int_1 > 0) {
      for (int_3 = 1; int_3 < 8; int_3++) {
        Class22.heightmap[int_0][int_1][int_3 + int_2] = Class22.heightmap[int_0][int_1 - 1][
            int_3 + int_2];
      }
    }

    if (int_2 > 0) {
      for (int_3 = 1; int_3 < 8; int_3++) {
        Class22.heightmap[int_0][int_3 + int_1][int_2] = Class22.heightmap[int_0][int_3
            + int_1][int_2 - 1];
      }
    }

    if (int_1 > 0 && Class22.heightmap[int_0][int_1 - 1][int_2] != 0) {
      Class22.heightmap[int_0][int_1][int_2] = Class22.heightmap[int_0][int_1 - 1][int_2];
    } else {
      if (int_2 > 0 && Class22.heightmap[int_0][int_1][int_2 - 1] != 0) {
        Class22.heightmap[int_0][int_1][int_2] = Class22.heightmap[int_0][int_1][int_2 - 1];
        return;
      }

      if (int_1 > 0 && int_2 > 0 && Class22.heightmap[int_0][int_1 - 1][int_2 - 1] != 0) {
        Class22.heightmap[int_0][int_1][int_2] = Class22.heightmap[int_0][int_1 - 1][int_2 - 1];
        return;
      }
    }

  }

  boolean method258() {
    return aBool9;
  }

  byte[] method259() {
    return aByteArray2;
  }

}
