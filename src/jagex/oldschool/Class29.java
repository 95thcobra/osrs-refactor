package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Position;
import jagex.oldschool.ui.InterfaceComponent;

public class Class29 {

  static InterfaceComponent aWidget3;
  public static int anInt81;
  static int cameraY;
  int anInt82;
  Position aCoordinates6;

  Class29(final int int_0, final Position coordinates_0) {
    anInt82 = int_0;
    aCoordinates6 = coordinates_0;
  }

  public static IndexedSprite[] method239(final AbstractPackage indexdatabase_0,
      final String string_0,
      final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    return GroundObject.method552(indexdatabase_0, int_0, int_1);
  }

  static void xteaChanged(final boolean bool_0) {
    Client.isDynamicRegion = bool_0;
    int int_0;
    int int_1;
    int int_2;
    int int_3;
    int int_4;
    int int_5;
    if (!Client.isDynamicRegion) {
      int_0 = Client.secretPacketBuffer2.getUnsignedLeShort();
      int_1 = Client.secretPacketBuffer2.getUnsignedLeShortAdd();
      int int_12 = Client.secretPacketBuffer2.getUnsignedShort();
      Player.xteaKeys = new int[int_12][4];

      for (int_2 = 0; int_2 < int_12; int_2++) {
        for (int_3 = 0; int_3 < 4; int_3++) {
          Player.xteaKeys[int_2][int_3] = Client.secretPacketBuffer2.getInt();
        }
      }

      Class57.mapRegions = new int[int_12];
      Ignore.anIntArray59 = new int[int_12];
      Class31.landRegionFielIds = new int[int_12];
      Class31.aByteArrayArray2 = new byte[int_12][];
      Class10.aByteArrayArray1 = new byte[int_12][];
      boolean bool_2 = false;
      if ((int_1 / 8 == 48 || int_1 / 8 == 49) && int_0 / 8 == 48) {
        bool_2 = true;
      }

      if (int_1 / 8 == 48 && int_0 / 8 == 148) {
        bool_2 = true;
      }

      int_12 = 0;

      for (int_3 = (int_1 - 6) / 8; int_3 <= (int_1 + 6) / 8; int_3++) {
        for (int_4 = (int_0 - 6) / 8; int_4 <= (int_0 + 6) / 8; int_4++) {
          int_5 = int_4 + (int_3 << 8);
          if (!bool_2 || int_4 != 49 && int_4 != 149 && int_4 != 147 && int_3 != 50
              && (int_3 != 49 || int_4 != 47)) {
            Class57.mapRegions[int_12] = int_5;
            Ignore.anIntArray59[int_12] = Class44.maps.getFile("m" + int_3 + "_" + int_4);
            Class31.landRegionFielIds[int_12] = Class44.maps
                .getFile("l" + int_3 + "_" + int_4);
            ++int_12;
          }
        }
      }

      Class52.method335(int_1, int_0, true);
    } else {
      int_0 = Client.secretPacketBuffer2.getUnsignedShortAdd();
      int_1 = Client.secretPacketBuffer2.getUnsignedShortAdd();
      final boolean bool_1 = Client.secretPacketBuffer2.getUnsignedByte() == 1;
      int_2 = Client.secretPacketBuffer2.getUnsignedShort();
      Client.secretPacketBuffer2.beginBitAccess();

      int int_6;
      for (int_3 = 0; int_3 < 4; int_3++) {
        for (int_4 = 0; int_4 < 13; int_4++) {
          for (int_5 = 0; int_5 < 13; int_5++) {
            int_6 = Client.secretPacketBuffer2.getBits(1);
            if (int_6 == 1) {
              Client.anIntArrayArrayArray2[int_3][int_4][int_5] = Client.secretPacketBuffer2
                  .getBits(26);
            } else {
              Client.anIntArrayArrayArray2[int_3][int_4][int_5] = -1;
            }
          }
        }
      }

      Client.secretPacketBuffer2.endBitAccess();
      Player.xteaKeys = new int[int_2][4];

      for (int_3 = 0; int_3 < int_2; int_3++) {
        for (int_4 = 0; int_4 < 4; int_4++) {
          Player.xteaKeys[int_3][int_4] = Client.secretPacketBuffer2.getInt();
        }
      }

      Class57.mapRegions = new int[int_2];
      Ignore.anIntArray59 = new int[int_2];
      Class31.landRegionFielIds = new int[int_2];
      Class31.aByteArrayArray2 = new byte[int_2][];
      Class10.aByteArrayArray1 = new byte[int_2][];
      int_2 = 0;

      for (int_3 = 0; int_3 < 4; int_3++) {
        for (int_4 = 0; int_4 < 13; int_4++) {
          for (int_5 = 0; int_5 < 13; int_5++) {
            int_6 = Client.anIntArrayArrayArray2[int_3][int_4][int_5];
            if (int_6 != -1) {
              final int int_7 = int_6 >> 14 & 0x3FF;
              final int int_8 = int_6 >> 3 & 0x7FF;
              int int_9 = (int_7 / 8 << 8) + int_8 / 8;

              int int_10;
              for (int_10 = 0; int_10 < int_2; int_10++) {
                if (Class57.mapRegions[int_10] == int_9) {
                  int_9 = -1;
                  break;
                }
              }

              if (int_9 != -1) {
                Class57.mapRegions[int_2] = int_9;
                int_10 = int_9 >> 8 & 0xFF;
                final int int_11 = int_9 & 0xFF;
                Ignore.anIntArray59[int_2] = Class44.maps.getFile("m" + int_10 + "_" + int_11);
                Class31.landRegionFielIds[int_2] = Class44.maps
                    .getFile("l" + int_10 + "_" + int_11);
                ++int_2;
              }
            }
          }
        }
      }

      Class52.method335(int_1, int_0, !bool_1);
    }
  }

  static int getTileHeight(final int int_0, final int int_1, final int int_2) {
    final int int_3 = int_0 >> 7;
    final int int_4 = int_1 >> 7;
    if (int_3 >= 0 && int_4 >= 0 && int_3 <= 103 && int_4 <= 103) {
      int int_5 = int_2;
      if (int_2 < 3 && (Class22.flags[1][int_3][int_4] & 0x2) == 2) {
        int_5 = int_2 + 1;
      }

      final int int_6 = int_0 & 0x7F;
      final int int_7 = int_1 & 0x7F;
      final int int_8 = int_6 * Class22.heightmap[int_5][int_3 + 1][int_4]
          + (128 - int_6) * Class22.heightmap[int_5][int_3][int_4] >> 7;
      final int int_9 = Class22.heightmap[int_5][int_3][int_4 + 1] * (128 - int_6)
          + Class22.heightmap[int_5][int_3 + 1][int_4 + 1] * int_6 >> 7;
      return int_9 * int_7 + int_8 * (128 - int_7) >> 7;
    }
    return 0;
  }

}
