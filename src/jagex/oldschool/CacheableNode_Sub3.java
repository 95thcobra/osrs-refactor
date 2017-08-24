package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.scene.GroundObject;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Square;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.social.Ignore;

public class CacheableNode_Sub3 extends Subnode {

  public static Cache aNodeCache14;
  public static AbstractPackage anIndexDataBase26;

  static {
    aNodeCache14 = new Cache(64);
  }

  public int anInt476;
  public String aString30;
  char aChar2;
  public boolean aBool57;

  CacheableNode_Sub3() {
    aBool57 = true;
  }

  public static DirectSprite method846(final AbstractPackage indexdatabase_0, final int int_0,
      final int int_1) {
    if (!FileOnDisk.method74(indexdatabase_0, int_0, int_1)) {
      return null;
    }
    final DirectSprite spritepixels_0 = new DirectSprite();
    spritepixels_0.unpackedWidth = SpriteLoader.anInt204;
    spritepixels_0.unpackedHeight = Isaac.anInt181;
    spritepixels_0.offsetX = SpriteLoader.anIntArray56[0];
    spritepixels_0.offsetY = CacheableNode_Sub1.offsetsY[0];
    spritepixels_0.width = Class94.anIntArray48[0];
    spritepixels_0.height = SpriteLoader.anIntArray57[0];
    final int int_2 = spritepixels_0.width * spritepixels_0.height;
    final byte[] bytes_0 = SpriteLoader.spritePixels[0];
    spritepixels_0.buffer = new int[int_2];

    for (int int_3 = 0; int_3 < int_2; int_3++) {
      spritepixels_0.buffer[int_3] = SpriteLoader.anIntArray58[bytes_0[int_3] & 0xFF];
    }

    SpriteLoader.anIntArray56 = null;
    CacheableNode_Sub1.offsetsY = null;
    Class94.anIntArray48 = null;
    SpriteLoader.anIntArray57 = null;
    SpriteLoader.anIntArray58 = null;
    SpriteLoader.spritePixels = null;
    return spritepixels_0;
  }

  static void method847() {
    WorldMapType2.flush(false);
    Client.anInt615 = 0;
    boolean bool_0 = true;

    int int_0;
    for (int_0 = 0; int_0 < Class31.aByteArrayArray2.length; int_0++) {
      if (Ignore.anIntArray59[int_0] != -1 && Class31.aByteArrayArray2[int_0] == null) {
        Class31.aByteArrayArray2[int_0] = Class44.maps
            .get(Ignore.anIntArray59[int_0], 0);
        if (Class31.aByteArrayArray2[int_0] == null) {
          bool_0 = false;
          ++Client.anInt615;
        }
      }

      if (Class31.landRegionFielIds[int_0] != -1 && Class10.aByteArrayArray1[int_0] == null) {
        Class10.aByteArrayArray1[int_0] = Class44.maps
            .get(Class31.landRegionFielIds[int_0], 0,
                Player.xteaKeys[int_0]);
        if (Class10.aByteArrayArray1[int_0] == null) {
          bool_0 = false;
          ++Client.anInt615;
        }
      }
    }

    if (!bool_0) {
      Client.anInt612 = 1;
    } else {
      Client.anInt621 = 0;
      bool_0 = true;

      int int_1;
      int int_2;
      for (int_0 = 0; int_0 < Class31.aByteArrayArray2.length; int_0++) {
        final byte[] bytes_0 = Class10.aByteArrayArray1[int_0];
        if (bytes_0 != null) {
          int_1 = (Class57.mapRegions[int_0] >> 8) * 64 - Boundry.baseX;
          int_2 = (Class57.mapRegions[int_0] & 0xFF) * 64 - WorldMapData_Sub1.baseY;
          if (Client.isDynamicRegion) {
            int_1 = 10;
            int_2 = 10;
          }

          bool_0 &= Enum1.method601(bytes_0, int_1, int_2);
        }
      }

      if (!bool_0) {
        Client.anInt612 = 2;
      } else {
        if (Client.anInt612 != 0) {
          Class51.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
        }

        Class77.method468();
        Client.method516();
        Class77.method468();
        Class11.scene.reset();
        Class77.method468();
        System.gc();

        for (int_0 = 0; int_0 < 4; int_0++) {
          Client.collisionMaps[int_0].reset();
        }

        int int_3;
        for (int_0 = 0; int_0 < 4; int_0++) {
          for (int_3 = 0; int_3 < 104; int_3++) {
            for (int_1 = 0; int_1 < 104; int_1++) {
              Class22.flags[int_0][int_3][int_1] = 0;
            }
          }
        }

        Class77.method468();
        Class22.anInt70 = 99;
        Class22.underlayIds = new byte[4][104][104];
        Class22.overlayIds = new byte[4][104][104];
        Class22.overlayPaths = new byte[4][104][104];
        Class22.overlayRotations = new byte[4][104][104];
        Enum8.anIntArrayArrayArray1 = new int[4][105][105];
        Class22.aByteArrayArrayArray4 = new byte[4][105][105];
        WorldMapType2.anIntArrayArray14 = new int[105][105];
        Class22.blendedHue = new int[104];
        WorldMapType1.blendedSaturation = new int[104];
        Class13.anIntArray2 = new int[104];
        HuffmanCodec.anIntArray67 = new int[104];
        JavaxSourceDataLineProvider.anIntArray3 = new int[104];
        int_0 = Class31.aByteArrayArray2.length;
        Class25.method223();
        WorldMapType2.flush(true);
        int int_4;
        if (!Client.isDynamicRegion) {
          byte[] bytes_1;
          for (int_3 = 0; int_3 < int_0; int_3++) {
            int_1 = (Class57.mapRegions[int_3] >> 8) * 64 - Boundry.baseX;
            int_2 = (Class57.mapRegions[int_3] & 0xFF) * 64 - WorldMapData_Sub1.baseY;
            bytes_1 = Class31.aByteArrayArray2[int_3];
            if (bytes_1 != null) {
              Class77.method468();
              Class38.method264(bytes_1, int_1, int_2, Class45.anInt96 * 8 - 48,
                  GroundObject.anInt213 * 8 - 48, Client.collisionMaps);
            }
          }

          for (int_3 = 0; int_3 < int_0; int_3++) {
            int_1 = (Class57.mapRegions[int_3] >> 8) * 64 - Boundry.baseX;
            int_2 = (Class57.mapRegions[int_3] & 0xFF) * 64 - WorldMapData_Sub1.baseY;
            bytes_1 = Class31.aByteArrayArray2[int_3];
            if (bytes_1 == null && GroundObject.anInt213 < 800) {
              Class77.method468();
              Class40.method272(int_1, int_2, 64, 64);
            }
          }

          WorldMapType2.flush(true);

          for (int_3 = 0; int_3 < int_0; int_3++) {
            final byte[] bytes_2 = Class10.aByteArrayArray1[int_3];
            if (bytes_2 != null) {
              int_2 = (Class57.mapRegions[int_3] >> 8) * 64 - Boundry.baseX;
              int_4 = (Class57.mapRegions[int_3] & 0xFF) * 64 - WorldMapData_Sub1.baseY;
              Class77.method468();
              Square.method660(bytes_2, int_2, int_4, Class11.scene, Client.collisionMaps);
            }
          }
        }

        int int_5;
        int int_6;
        int int_7;
        if (Client.isDynamicRegion) {
          int int_8;
          int int_9;
          int int_10;
          for (int_3 = 0; int_3 < 4; int_3++) {
            Class77.method468();

            for (int_1 = 0; int_1 < 13; int_1++) {
              for (int_2 = 0; int_2 < 13; int_2++) {
                boolean bool_1 = false;
                int_5 = Client.anIntArrayArrayArray2[int_3][int_1][int_2];
                if (int_5 != -1) {
                  int_6 = int_5 >> 24 & 0x3;
                  int_7 = int_5 >> 1 & 0x3;
                  int_8 = int_5 >> 14 & 0x3FF;
                  int_9 = int_5 >> 3 & 0x7FF;
                  int_10 = (int_8 / 8 << 8) + int_9 / 8;

                  for (int int_11 = 0; int_11 < Class57.mapRegions.length; int_11++) {
                    if (Class57.mapRegions[int_11] == int_10
                        && Class31.aByteArrayArray2[int_11] != null) {
                      Class48.method297(Class31.aByteArrayArray2[int_11], int_3, int_1 * 8,
                          int_2 * 8, int_6, (int_8 & 0x7) * 8, (int_9 & 0x7) * 8, int_7,
                          Client.collisionMaps);
                      bool_1 = true;
                      break;
                    }
                  }
                }

                if (!bool_1) {
                  UrlStreamRequest.method263(int_3, int_1 * 8, int_2 * 8);
                }
              }
            }
          }

          for (int_3 = 0; int_3 < 13; int_3++) {
            for (int_1 = 0; int_1 < 13; int_1++) {
              int_2 = Client.anIntArrayArrayArray2[0][int_3][int_1];
              if (int_2 == -1) {
                Class40.method272(int_3 * 8, int_1 * 8, 8, 8);
              }
            }
          }

          WorldMapType2.flush(true);

          for (int_3 = 0; int_3 < 4; int_3++) {
            Class77.method468();

            for (int_1 = 0; int_1 < 13; int_1++) {
              for (int_2 = 0; int_2 < 13; int_2++) {
                int_4 = Client.anIntArrayArrayArray2[int_3][int_1][int_2];
                if (int_4 != -1) {
                  int_5 = int_4 >> 24 & 0x3;
                  int_6 = int_4 >> 1 & 0x3;
                  int_7 = int_4 >> 14 & 0x3FF;
                  int_8 = int_4 >> 3 & 0x7FF;
                  int_9 = (int_7 / 8 << 8) + int_8 / 8;

                  for (int_10 = 0; int_10 < Class57.mapRegions.length; int_10++) {
                    if (Class57.mapRegions[int_10] == int_9
                        && Class10.aByteArrayArray1[int_10] != null) {
                      IntegerVariable.method247(Class10.aByteArrayArray1[int_10], int_3, int_1 * 8,
                          int_2 * 8, int_5, (int_7 & 0x7) * 8, (int_8 & 0x7) * 8, int_6,
                          Class11.scene, Client.collisionMaps);
                      break;
                    }
                  }
                }
              }
            }
          }
        }

        WorldMapType2.flush(true);
        Client.method516();
        Class77.method468();
        PendingSpawn.method652(Class11.scene, Client.collisionMaps);
        WorldMapType2.flush(true);
        int_3 = Class22.anInt70;
        if (int_3 > Class12.plane) {
          int_3 = Class12.plane;
        }

        if (int_3 < Class12.plane - 1) {
          int_3 = Class12.plane - 1;
        }

        if (Client.lowMemory) {
          Class11.scene.setup(Class22.anInt70);
        } else {
          Class11.scene.setup(0);
        }

        for (int_1 = 0; int_1 < 104; int_1++) {
          for (int_2 = 0; int_2 < 104; int_2++) {
            AClass4_Sub4.groundItemSpawned(int_1, int_2);
          }
        }

        Class77.method468();
        Class16.method197();
        ObjectConfig.aNodeCache9.reset();
        if (Enum1.clientInstance.method1047()) {
          Client.outbound.putEncipheredByte(86);
          Client.outbound.putInt(1057001181);
        }

        if (!Client.isDynamicRegion) {
          int_1 = (Class45.anInt96 - 6) / 8;
          int_2 = (Class45.anInt96 + 6) / 8;
          int_4 = (GroundObject.anInt213 - 6) / 8;
          int_5 = (GroundObject.anInt213 + 6) / 8;

          for (int_6 = int_1 - 1; int_6 <= int_2 + 1; int_6++) {
            for (int_7 = int_4 - 1; int_7 <= int_5 + 1; int_7++) {
              if (int_6 < int_1 || int_6 > int_2 || int_7 < int_4 || int_7 > int_5) {
                Class44.maps.method461("m" + int_6 + "_" + int_7);
                Class44.maps.method461("l" + int_6 + "_" + int_7);
              }
            }
          }
        }

        Mouse.setGameState(30);
        Class77.method468();
        Class28.method238();
        Client.outbound.putEncipheredByte(11);
        Stub.regulator.reset();

        for (int_1 = 0; int_1 < 32; int_1++) {
          Stub.aLongArray3[int_1] = 0L;
        }

        for (int_1 = 0; int_1 < 32; int_1++) {
          Stub.memory[int_1] = 0L;
        }

        Stub.cycles = 0;
      }
    }
  }

  void method842(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      final byte byte_0 = buffer_0.getByte();
      int int_1 = byte_0 & 0xFF;
      if (int_1 == 0) {
        throw new IllegalArgumentException("");
      }
      if (int_1 >= 128 && int_1 < 160) {
        char char_0 = Class99.aCharArray5[int_1 - 128];
        if (char_0 == 0) {
          char_0 = 63;
        }

        int_1 = char_0;
      }

      final char char_1 = (char) int_1;
      aChar2 = char_1;
    } else {
      if (int_0 == 2) {
        anInt476 = buffer_0.getInt();
      } else {
        if (int_0 == 4) {
          aBool57 = false;
          return;
        }

        if (int_0 == 5) {
          aString30 = buffer_0.getString();
          return;
        }
      }

    }
  }

  void method843() {
  }

  void method844(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method842(buffer_0, int_0);
    }
  }

  public boolean method845() {
    return aChar2 == 115;
  }

}
