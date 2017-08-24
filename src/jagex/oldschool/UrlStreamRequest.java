package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.io.AbstractByteBuffer;
import jagex.oldschool.io.DirectByteBuffer;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.script.ScriptState;
import java.net.URL;

public class UrlStreamRequest {

  static Package anIndexData1;
  final URL anURL1;
  byte[] aByteArray2;
  boolean aBool9;

  UrlStreamRequest(final URL url_0) {
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
    AudioSystem.anIndexDataBase7 = indexdatabase_0;
    AudioSystem.anIndexDataBase6 = indexdatabase_1;
    AudioSystem.anIndexDataBase5 = indexdatabase_2;
    AudioSystem.anAClass4_Sub3_1 = aclass4_sub3_0;
    return true;
  }

  static void updateMap(final int plane) {
    final int[] dest = ItemConfig.map.buffer;
    final int len = dest.length;

    int int_2;
    for (int i = 0; i < len; i++) {
      dest[i] = 0;
    }

    int int_3;
    int int_4;
    for (int z = 1; z < 103; z++) {
      int step = (103 - z) * 2048 + 24628;

      for (int x = 1; x < 103; x++) {
        if ((Class22.flags[plane][x][z] & 0x18) == 0) {
          Class11.scene.method370(dest, step, 512, plane, x, z);
        }

        if (plane < 3 && (Class22.flags[plane + 1][x][z] & 0x8) != 0) {
          Class11.scene.method370(dest, step, 512, plane + 1, x, z);
        }

        step += 4;
      }
    }

    int_2 = (238 + (int) (Math.random() * 20.0D) - 10 << 16)
        + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + 238
        + (int) (Math.random() * 20.0D) - 10;
    int_3 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
    ItemConfig.map.init();

    int int_5;
    for (int_4 = 1; int_4 < 103; int_4++) {
      for (int_5 = 1; int_5 < 103; int_5++) {
        if ((Class22.flags[plane][int_5][int_4] & 0x18) == 0) {
          ScriptState.method559(plane, int_5, int_4, int_2, int_3);
        }

        if (plane < 3 && (Class22.flags[plane + 1][int_5][int_4] & 0x8) != 0) {
          ScriptState.method559(plane + 1, int_5, int_4, int_2, int_3);
        }
      }
    }

    Client.iconCount = 0;

    for (int x = 0; x < 104; x++) {
      for (int z = 0; z < 104; z++) {
        int hash = Class11.scene.method375(Class12.plane, x, z);
        if (hash == 0) {
          continue;
        }
        int configId = hash >> 14 & 0x7FFF;
        final int iconId = Class2.getObjectConfig(configId).iconId;
        if (iconId < 0) {
          continue;
        }
        Client.iconSprites[Client.iconCount] = MapIconConfig.icons[iconId].getSprite(false);
        Client.iconX[Client.iconCount] = x;
        Client.iconY[Client.iconCount] = z;
        ++Client.iconCount;
      }
    }

    FileCache.rasterBuffer.init();
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
