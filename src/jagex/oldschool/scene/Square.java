package jagex.oldschool.scene;

import jagex.oldschool.AClass3;
import jagex.oldschool.Class22;
import jagex.oldschool.Class46;
import jagex.oldschool.Client;
import jagex.oldschool.asset.Package;
import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.util.Arrays;

public final class Square extends Node {

  public static Package indexTextures;
  SolidSquare solid;
  ItemLayer itemLayer;
  DecorativeObject decorativeObject;
  WallObject wallObject;
  int entityCount;
  GameObject[] objects;
  GroundObject groundObject;
  int physicalLevel;
  ShapedSquare shaped;
  int[] entityFlags;
  Square bridge;
  int cullingFlags;
  int plane;
  boolean visible;
  int x;
  int z;
  int renderLevel;
  boolean draw;
  int wallCullDirection;
  boolean drawEntities;
  int wallUncullDirection;
  int wallDrawFlags;
  int wallCullOppositeDirection;

  Square(final int int_0, final int x, final int z) {
    objects = new GameObject[5];
    entityFlags = new int[5];
    cullingFlags = 0;
    renderLevel = plane = int_0;
    this.x = x;
    this.z = z;
  }

  public static String embedColor(final int int_0) {
    return "<col=" + Integer.toHexString(int_0) + ">";
  }

  public static boolean method659(final String string_0, final int int_0) {
    return AClass3.method620(string_0, int_0, "openjs");
  }

  public static void method660(final byte[] bytes_0, final int int_0, final int int_1,
      final Scene region_0,
      final CollisionData[] collisiondatas_0) {
    final Buffer buffer_0 = new Buffer(bytes_0);
    int int_2 = -1;

    while (true) {
      final int int_3 = buffer_0.getUnsignedSmartShort();
      if (int_3 == 0) {
        return;
      }

      int_2 += int_3;
      int int_4 = 0;

      while (true) {
        final int int_5 = buffer_0.getUnsignedSmartShort();
        if (int_5 == 0) {
          break;
        }

        int_4 += int_5 - 1;
        final int int_6 = int_4 & 0x3F;
        final int int_7 = int_4 >> 6 & 0x3F;
        final int int_8 = int_4 >> 12;
        final int int_9 = buffer_0.getUnsignedByte();
        final int int_10 = int_9 >> 2;
        final int int_11 = int_9 & 0x3;
        final int int_12 = int_7 + int_0;
        final int int_13 = int_6 + int_1;
        if (int_12 > 0 && int_13 > 0 && int_12 < 103 && int_13 < 103) {
          int int_14 = int_8;
          if ((Class22.flags[1][int_12][int_13] & 0x2) == 2) {
            int_14 = int_8 - 1;
          }

          CollisionData collisiondata_0 = null;
          if (int_14 >= 0) {
            collisiondata_0 = collisiondatas_0[int_14];
          }

          Class46
              .addObject(int_8, int_12, int_13, int_2, int_11, int_10, region_0, collisiondata_0);
        }
      }
    }
  }

  public static void method661(final byte[] bytes_0, final int int_0) {
    if (Client.aByteArray28 == null) {
      Client.aByteArray28 = new byte[24];
    }

    Arrays.copy(bytes_0, int_0, Client.aByteArray28, 0, 24);
  }

}
