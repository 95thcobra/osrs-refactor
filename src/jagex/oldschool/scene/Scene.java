package jagex.oldschool.scene;

import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;

public class Scene {

  static final int[] anIntArray36;
  static final int[] anIntArray37;
  static final int[] TILE_WALL_DRAW_FLAGS_1;
  static final int[] WALL_UNCULL_FLAGS_0;
  static final int[] WALL_UNCULL_FLAGS_1;
  static final int[] WALL_UNCULL_FLAGS_2;
  static final int[] WALL_UNCULL_FLAGS_3;
  public static boolean lowMemory;
  public static int selectedRegionTileX;
  public static int selectedRegionTileY;
  static boolean viewportWalking;
  static int[] levelOccluderCount;
  static int anInt144;
  static Deque tileDeque;
  static int cameraX;
  static int plane;
  static int tick;
  static int MAX_OCCLUDER_LEVELS;
  static Occluder[][] levelOccluders;
  static int tileUpdateCount;
  static Occluder[] anOccluderArray1;
  static int cameraZ;
  static boolean checkClick;
  static GameObject[] entityBuffer;
  static int cameraY;
  static int anInt146;
  public static int rxs;
  static int mx;
  static int csx;
  public static int rxc;
  public static int rys;
  static int my;
  public static int ryc;
  static int csz;
  static boolean[][][][] sectors;
  static int lx;
  static boolean[][] visible;
  static int ux;
  static int lz;
  static int uz;
  static int anInt147;
  static int anInt148;
  static int anInt149;
  static int anInt150;
  static int anInt151;
  static int anInt152;

  static {
    lowMemory = true;
    tileUpdateCount = 0;
    plane = 0;
    entityBuffer = new GameObject[100];
    checkClick = false;
    anInt146 = 0;
    mx = 0;
    my = 0;
    selectedRegionTileX = -1;
    selectedRegionTileY = -1;
    viewportWalking = false;
    MAX_OCCLUDER_LEVELS = 4;
    levelOccluderCount = new int[MAX_OCCLUDER_LEVELS];
    levelOccluders = new Occluder[MAX_OCCLUDER_LEVELS][500];
    anInt144 = 0;
    anOccluderArray1 = new Occluder[500];
    tileDeque = new Deque();
    anIntArray37 = new int[] {19, 55, 38, 155, 255, 110, 137, 205, 76};
    anIntArray36 = new int[] {160, 192, 80, 96, 0, 144, 80, 48, 160};
    TILE_WALL_DRAW_FLAGS_1 = new int[] {76, 8, 137, 4, 0, 1, 38, 2, 19};
    WALL_UNCULL_FLAGS_0 = new int[] {0, 0, 2, 0, 0, 2, 1, 1, 0};
    WALL_UNCULL_FLAGS_1 = new int[] {2, 0, 0, 2, 0, 0, 0, 4, 4};
    WALL_UNCULL_FLAGS_2 = new int[] {0, 4, 4, 8, 0, 0, 8, 0, 0};
    WALL_UNCULL_FLAGS_3 = new int[] {1, 1, 0, 0, 0, 8, 0, 0, 8};
    sectors = new boolean[8][32][51][51];
  }

  int lowerPlane;
  int entityCount;
  int[][][] tileCycles;
  int width;
  int planes;
  Square[][][] squares;
  GameObject[] objects;
  int height;
  int[][][] heightmap;
  int[][] TILE_MASK_2D;
  int[][] TILE_ROTATION_2D;

  public Scene(final int planes, final int width, final int height, final int[][][] ints_0) {
    lowerPlane = 0;
    entityCount = 0;
    objects = new GameObject[5000];
    TILE_MASK_2D = new int[][] {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
        {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1},
        {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}
    };
    TILE_ROTATION_2D = new int[][] {
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3},
        {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
        {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}
    };
    this.planes = planes;
    this.width = width;
    this.height = height;
    squares = new Square[planes][width][height];
    tileCycles = new int[planes][width + 1][height + 1];
    heightmap = ints_0;
    reset();
  }

  public static boolean method389() {
    return viewportWalking && selectedRegionTileX != -1;
  }

  public static int[] method390(int int_0, final int int_1, int int_2) {
    int int_3 = int_2 * rys + int_0 * ryc >> 16;
    int_2 = int_2 * ryc - int_0 * rys >> 16;
    int_0 = int_3;
    int_3 = rxc * int_1 - int_2 * rxs >> 16;
    int_2 = rxs * int_1 + int_2 * rxc >> 16;
    int_2 |= 0x1;
    final int int_4 =
        Rasterizer3d.cx + int_0 * Rasterizer3d.scaleFactor / int_2 + Rasterizer2d.lx;
    final int int_5 =
        Rasterizer3d.cy + Rasterizer3d.scaleFactor * int_3 / int_2 + Rasterizer2d.ly;
    return new int[] {int_4, int_5};
  }

  public static void method391(final int[] ints_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3) {
    anInt147 = 0;
    anInt148 = 0;
    anInt149 = int_2;
    anInt150 = int_3;
    anInt151 = int_2 / 2;
    anInt152 = int_3 / 2;
    final boolean[][][][] bools_0 = new boolean[9][32][53][53];

    int int_4;
    int int_5;
    int int_6;
    int int_7;
    int int_9;
    int int_10;
    for (int rx = 128; rx <= 384; rx += 32) {
      for (int ry = 0; ry < 2048; ry += 64) {
        rxs = Rasterizer3d.SINE[rx];
        rxc = Rasterizer3d.COSINE[rx];
        rys = Rasterizer3d.SINE[ry];
        ryc = Rasterizer3d.COSINE[ry];
        int radialX = (rx - 128) / 32;
        int radialY = ry / 64;

        for (int int_8 = -26; int_8 <= 26; int_8++) {
          for (int_9 = -26; int_9 <= 26; int_9++) {
            int_10 = int_8 * 128;
            final int int_11 = int_9 * 128;
            boolean bool_0 = false;

            for (int int_12 = -int_0; int_12 <= int_1; int_12 += 128) {
              if (method393(int_10, ints_0[radialX] + int_12, int_11)) {
                bool_0 = true;
                break;
              }
            }

            bools_0[radialX][radialY][int_8 + 1 + 25][int_9 + 1 + 25] = bool_0;
          }
        }
      }
    }

    for (int_4 = 0; int_4 < 8; int_4++) {
      for (int_5 = 0; int_5 < 32; int_5++) {
        for (int_6 = -25; int_6 < 25; int_6++) {
          for (int_7 = -25; int_7 < 25; int_7++) {
            boolean bool_1 = false;

            label76:
            for (int_9 = -1; int_9 <= 1; int_9++) {
              for (int_10 = -1; int_10 <= 1; int_10++) {
                if (bools_0[int_4][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                  bool_1 = true;
                  break label76;
                }

                if (bools_0[int_4][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1
                    + 25]) {
                  bool_1 = true;
                  break label76;
                }

                if (bools_0[int_4 + 1][int_5][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1 + 25]) {
                  bool_1 = true;
                  break label76;
                }

                if (bools_0[int_4 + 1][(int_5 + 1) % 31][int_6 + int_9 + 1 + 25][int_7 + int_10 + 1
                    + 25]) {
                  bool_1 = true;
                  break label76;
                }
              }
            }

            sectors[int_4][int_5][int_6 + 25][int_7 + 25] = bool_1;
          }
        }
      }
    }

  }

  static int lighten(final int hsl, int lightness) {
    lightness = (hsl & 0x7F) * lightness >> 7;
    if (lightness < 2) {
      lightness = 2;
    } else if (lightness > 126) {
      lightness = 126;
    }

    return (hsl & 0xFF80) + lightness;
  }

  static boolean method393(final int int_0, final int int_1, final int int_2) {
    final int int_3 = int_0 * ryc + int_2 * rys >> 16;
    final int int_4 = int_2 * ryc - int_0 * rys >> 16;
    final int int_5 = int_4 * rxc + rxs * int_1 >> 16;
    final int int_6 = rxc * int_1 - int_4 * rxs >> 16;
    if (int_5 >= 50 && int_5 <= 3500) {
      final int int_7 = int_3 * 390 / int_5 + anInt151;
      final int int_8 = int_6 * 390 / int_5 + anInt152;
      return int_7 >= anInt147 && int_7 <= anInt149 && int_8 >= anInt148 && int_8
          <= anInt150;
    }
    return false;
  }

  public static void method394() {
    selectedRegionTileX = -1;
    viewportWalking = false;
  }

  public static void addOcclude(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7) {
    final Occluder occluder_0 = new Occluder();
    occluder_0.minTileX = int_2 / 128;
    occluder_0.maxTIleX = int_3 / 128;
    occluder_0.minTileZ = int_4 / 128;
    occluder_0.maxTileZ = int_5 / 128;
    occluder_0.type = int_1;
    occluder_0.minX = int_2;
    occluder_0.maxX = int_3;
    occluder_0.minZ = int_4;
    occluder_0.maxZ = int_5;
    occluder_0.minY = int_6;
    occluder_0.maxY = int_7;
    levelOccluders[int_0][levelOccluderCount[int_0]++] = occluder_0;
  }

  boolean isTileOccluded(final int plane, final int sx, final int sz) {
    final int int_3 = tileCycles[plane][sx][sz];
    if (int_3 == -tick) {
      return false;
    }
    if (int_3 == tick) {
      return true;
    }
    final int x = sx << 7;
    final int z = sz << 7;
    if (this.isOccluded(x + 1, heightmap[plane][sx][sz], z + 1)
        && this.isOccluded(x + 128 - 1, heightmap[plane][sx + 1][sz], z + 1)
        && this
        .isOccluded(x + 128 - 1, heightmap[plane][sx + 1][sz + 1], z + 128 - 1)
        && this.isOccluded(x + 1, heightmap[plane][sx][sz + 1], z + 128 - 1)) {
      tileCycles[plane][sx][sz] = tick;
      return true;
    }
    tileCycles[plane][sx][sz] = -tick;
    return false;
  }

  void removeEntity(final GameObject gameobject_0) {
    for (int int_0 = gameobject_0.relativeX; int_0 <= gameobject_0.offsetX; int_0++) {
      for (int int_1 = gameobject_0.relativeY; int_1 <= gameobject_0.offsetY; int_1++) {
        final Square tile_0 = squares[gameobject_0.plane][int_0][int_1];
        if (tile_0 != null) {
          int int_2;
          for (int_2 = 0; int_2 < tile_0.entityCount; int_2++) {
            if (tile_0.objects[int_2] == gameobject_0) {
              --tile_0.entityCount;

              for (int int_3 = int_2; int_3 < tile_0.entityCount; int_3++) {
                tile_0.objects[int_3] = tile_0.objects[int_3 + 1];
                tile_0.entityFlags[int_3] = tile_0.entityFlags[int_3 + 1];
              }

              tile_0.objects[tile_0.entityCount] = null;
              break;
            }
          }

          tile_0.cullingFlags = 0;

          for (int_2 = 0; int_2 < tile_0.entityCount; int_2++) {
            tile_0.cullingFlags |= tile_0.entityFlags[int_2];
          }
        }
      }
    }

  }

  boolean addEntityMarker(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7, final Renderable renderable_0,
      final int int_8,
      final boolean bool_0, final int int_9, final int int_10) {
    int int_12;
    for (int int_11 = int_1; int_11 < int_1 + int_3; int_11++) {
      for (int_12 = int_2; int_12 < int_2 + int_4; int_12++) {
        if (int_11 < 0 || int_12 < 0 || int_11 >= width || int_12 >= height) {
          return false;
        }

        final Square tile_0 = squares[int_0][int_11][int_12];
        if (tile_0 != null && tile_0.entityCount >= 5) {
          return false;
        }
      }
    }

    final GameObject gameobject_0 = new GameObject();
    gameobject_0.hash = int_9;
    gameobject_0.flags = int_10;
    gameobject_0.plane = int_0;
    gameobject_0.x = int_5;
    gameobject_0.y = int_6;
    gameobject_0.height = int_7;
    gameobject_0.renderable = renderable_0;
    gameobject_0.orientation = int_8;
    gameobject_0.relativeX = int_1;
    gameobject_0.relativeY = int_2;
    gameobject_0.offsetX = int_1 + int_3 - 1;
    gameobject_0.offsetY = int_2 + int_4 - 1;

    for (int_12 = int_1; int_12 < int_1 + int_3; int_12++) {
      for (int int_13 = int_2; int_13 < int_2 + int_4; int_13++) {
        int int_14 = 0;
        if (int_12 > int_1) {
          ++int_14;
        }

        if (int_12 < int_1 + int_3 - 1) {
          int_14 += 4;
        }

        if (int_13 > int_2) {
          int_14 += 8;
        }

        if (int_13 < int_2 + int_4 - 1) {
          int_14 += 2;
        }

        for (int int_15 = int_0; int_15 >= 0; --int_15) {
          if (squares[int_15][int_12][int_13] == null) {
            squares[int_15][int_12][int_13] = new Square(int_15, int_12, int_13);
          }
        }

        final Square tile_1 = squares[int_0][int_12][int_13];
        tile_1.objects[tile_1.entityCount] = gameobject_0;
        tile_1.entityFlags[tile_1.entityCount] = int_14;
        tile_1.cullingFlags |= int_14;
        ++tile_1.entityCount;
      }
    }

    if (bool_0) {
      objects[entityCount++] = gameobject_0;
    }

    return true;
  }

  boolean isOccluded(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < anInt144; int_3++) {
      final Occluder occluder_0 = anOccluderArray1[int_3];
      int int_4;
      int int_5;
      int int_6;
      int int_7;
      int int_8;
      if (occluder_0.testDirection == 1) {
        int_4 = occluder_0.minX - int_0;
        if (int_4 > 0) {
          int_5 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
          int_6 = (int_4 * occluder_0.maxNormalX >> 8) + occluder_0.maxZ;
          int_7 = occluder_0.minY + (int_4 * occluder_0.minNormalY >> 8);
          int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
          if (int_2 >= int_5 && int_2 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
            return true;
          }
        }
      } else if (occluder_0.testDirection == 2) {
        int_4 = int_0 - occluder_0.minX;
        if (int_4 > 0) {
          int_5 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
          int_6 = occluder_0.maxZ + (int_4 * occluder_0.maxNormalX >> 8);
          int_7 = occluder_0.minY + (int_4 * occluder_0.minNormalY >> 8);
          int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
          if (int_2 >= int_5 && int_2 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
            return true;
          }
        }
      } else if (occluder_0.testDirection == 3) {
        int_4 = occluder_0.minZ - int_2;
        if (int_4 > 0) {
          int_5 = occluder_0.minX + (int_4 * occluder_0.anInt163 >> 8);
          int_6 = occluder_0.maxX + (int_4 * occluder_0.anInt164 >> 8);
          int_7 = (int_4 * occluder_0.minNormalY >> 8) + occluder_0.minY;
          int_8 = occluder_0.maxY + (int_4 * occluder_0.maxNormalY >> 8);
          if (int_0 >= int_5 && int_0 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
            return true;
          }
        }
      } else if (occluder_0.testDirection == 4) {
        int_4 = int_2 - occluder_0.minZ;
        if (int_4 > 0) {
          int_5 = occluder_0.minX + (int_4 * occluder_0.anInt163 >> 8);
          int_6 = occluder_0.maxX + (int_4 * occluder_0.anInt164 >> 8);
          int_7 = occluder_0.minY + (int_4 * occluder_0.minNormalY >> 8);
          int_8 = (int_4 * occluder_0.maxNormalY >> 8) + occluder_0.maxY;
          if (int_0 >= int_5 && int_0 <= int_6 && int_1 >= int_7 && int_1 <= int_8) {
            return true;
          }
        }
      } else if (occluder_0.testDirection == 5) {
        int_4 = int_1 - occluder_0.minY;
        if (int_4 > 0) {
          int_5 = (int_4 * occluder_0.anInt163 >> 8) + occluder_0.minX;
          int_6 = occluder_0.maxX + (int_4 * occluder_0.anInt164 >> 8);
          int_7 = (int_4 * occluder_0.minNormalX >> 8) + occluder_0.minZ;
          int_8 = occluder_0.maxZ + (int_4 * occluder_0.maxNormalX >> 8);
          if (int_0 >= int_5 && int_0 <= int_6 && int_2 >= int_7 && int_2 <= int_8) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public void reset() {
    int int_0;
    int int_1;
    for (int_0 = 0; int_0 < planes; int_0++) {
      for (int_1 = 0; int_1 < width; int_1++) {
        for (int int_2 = 0; int_2 < height; int_2++) {
          squares[int_0][int_1][int_2] = null;
        }
      }
    }

    for (int_0 = 0; int_0 < MAX_OCCLUDER_LEVELS; int_0++) {
      for (int_1 = 0; int_1 < levelOccluderCount[int_0]; int_1++) {
        levelOccluders[int_0][int_1] = null;
      }

      levelOccluderCount[int_0] = 0;
    }

    for (int_0 = 0; int_0 < entityCount; int_0++) {
      objects[int_0] = null;
    }

    entityCount = 0;

    for (int_0 = 0; int_0 < entityBuffer.length; int_0++) {
      entityBuffer[int_0] = null;
    }

  }

  void method366(final ModelBase modeldata_0, final int int_0, final int int_1, final int int_2,
      final int int_3,
      final int int_4) {
    boolean bool_0 = true;
    int int_5 = int_1;
    final int int_6 = int_1 + int_3;
    final int int_7 = int_2 - 1;
    final int int_8 = int_2 + int_4;

    for (int int_9 = int_0; int_9 <= int_0 + 1; int_9++) {
      if (int_9 != planes) {
        for (int int_10 = int_5; int_10 <= int_6; int_10++) {
          if (int_10 >= 0 && int_10 < width) {
            for (int int_11 = int_7; int_11 <= int_8; int_11++) {
              if (int_11 >= 0 && int_11 < height && (!bool_0 || int_10 >= int_6 || int_11
                  >= int_8
                  || int_11 < int_2 && int_1 != int_10)) {
                final Square tile_0 = squares[int_9][int_10][int_11];
                if (tile_0 != null) {
                  final int int_12 = (heightmap[int_9][int_10 + 1][int_11]
                      + heightmap[int_9][int_10 + 1][int_11 + 1]
                      + heightmap[int_9][int_10][int_11]
                      + heightmap[int_9][int_10][int_11 + 1]) / 4
                      - (heightmap[int_0][int_1][int_2] + heightmap[int_0][int_1 + 1][int_2]
                      + heightmap[int_0][int_1][int_2 + 1]
                      + heightmap[int_0][int_1 + 1][int_2 + 1]) / 4;
                  final WallObject wallobject_0 = tile_0.wallObject;
                  if (wallobject_0 != null) {
                    ModelBase modeldata_1;
                    if (wallobject_0.renderable1 instanceof ModelBase) {
                      modeldata_1 = (ModelBase) wallobject_0.renderable1;
                      ModelBase.method1020(modeldata_0, modeldata_1,
                          (1 - int_3) * 64 + (int_10 - int_1) * 128, int_12,
                          (int_11 - int_2) * 128 + (1 - int_4) * 64, bool_0);
                    }

                    if (wallobject_0.renderable2 instanceof ModelBase) {
                      modeldata_1 = (ModelBase) wallobject_0.renderable2;
                      ModelBase.method1020(modeldata_0, modeldata_1,
                          (int_10 - int_1) * 128 + (1 - int_3) * 64, int_12,
                          (int_11 - int_2) * 128 + (1 - int_4) * 64, bool_0);
                    }
                  }

                  for (int int_13 = 0; int_13 < tile_0.entityCount; int_13++) {
                    final GameObject gameobject_0 = tile_0.objects[int_13];
                    if (gameobject_0 != null && gameobject_0.renderable instanceof ModelBase) {
                      final ModelBase modeldata_2 = (ModelBase) gameobject_0.renderable;
                      final int int_14 = gameobject_0.offsetX - gameobject_0.relativeX + 1;
                      final int int_15 = gameobject_0.offsetY - gameobject_0.relativeY + 1;
                      ModelBase.method1020(modeldata_0, modeldata_2,
                          (gameobject_0.relativeX - int_1) * 128 + (int_14 - int_3) * 64,
                          int_12,
                          (gameobject_0.relativeY - int_2) * 128 + (int_15 - int_4) * 64,
                          bool_0);
                    }
                  }
                }
              }
            }
          }
        }

        --int_5;
        bool_0 = false;
      }
    }

  }

  public void method367(final int int_0, final int int_1, final int int_2, final boolean bool_0) {
    if (!method389() || bool_0) {
      checkClick = true;
      viewportWalking = bool_0;
      anInt146 = int_0;
      mx = int_1;
      my = int_2;
      selectedRegionTileX = -1;
      selectedRegionTileY = -1;
    }
  }

  boolean within(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7) {
    if (int_1 < int_2 && int_1 < int_3 && int_1 < int_4) {
      return false;
    }
    if (int_1 > int_2 && int_1 > int_3 && int_1 > int_4) {
      return false;
    }
    if (int_0 < int_5 && int_0 < int_6 && int_0 < int_7) {
      return false;
    }
    if (int_0 > int_5 && int_0 > int_6 && int_0 > int_7) {
      return false;
    }
    final int int_8 = (int_1 - int_2) * (int_6 - int_5) - (int_0 - int_5) * (int_3 - int_2);
    final int int_9 = (int_5 - int_7) * (int_1 - int_4) - (int_0 - int_7) * (int_2 - int_4);
    final int int_10 = (int_7 - int_6) * (int_1 - int_3) - (int_0 - int_6) * (int_4 - int_3);
    return int_8 * int_10 > 0 && int_10 * int_9 > 0;
  }

  boolean isWallOccluded(final int int_0, final int int_1, final int int_2, final int int_3) {
    if (!isTileOccluded(int_0, int_1, int_2)) {
      return false;
    }
    final int int_4 = int_1 << 7;
    final int int_5 = int_2 << 7;
    final int int_6 = heightmap[int_0][int_1][int_2] - 1;
    final int int_7 = int_6 - 120;
    final int int_8 = int_6 - 230;
    final int int_9 = int_6 - 238;
    if (int_3 < 16) {
      if (int_3 == 1) {
        if (int_4 > cameraX) {
          if (!this.isOccluded(int_4, int_6, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4, int_6, int_5 + 128)) {
            return false;
          }
        }

        if (int_0 > 0) {
          if (!this.isOccluded(int_4, int_7, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4, int_7, int_5 + 128)) {
            return false;
          }
        }

        if (!this.isOccluded(int_4, int_8, int_5)) {
          return false;
        }

        if (!this.isOccluded(int_4, int_8, int_5 + 128)) {
          return false;
        }

        return true;
      }

      if (int_3 == 2) {
        if (int_5 < cameraZ) {
          if (!this.isOccluded(int_4, int_6, int_5 + 128)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_6, int_5 + 128)) {
            return false;
          }
        }

        if (int_0 > 0) {
          if (!this.isOccluded(int_4, int_7, int_5 + 128)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_7, int_5 + 128)) {
            return false;
          }
        }

        if (!this.isOccluded(int_4, int_8, int_5 + 128)) {
          return false;
        }

        if (!this.isOccluded(int_4 + 128, int_8, int_5 + 128)) {
          return false;
        }

        return true;
      }

      if (int_3 == 4) {
        if (int_4 < cameraX) {
          if (!this.isOccluded(int_4 + 128, int_6, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_6, int_5 + 128)) {
            return false;
          }
        }

        if (int_0 > 0) {
          if (!this.isOccluded(int_4 + 128, int_7, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_7, int_5 + 128)) {
            return false;
          }
        }

        if (!this.isOccluded(int_4 + 128, int_8, int_5)) {
          return false;
        }

        if (!this.isOccluded(int_4 + 128, int_8, int_5 + 128)) {
          return false;
        }

        return true;
      }

      if (int_3 == 8) {
        if (int_5 > cameraZ) {
          if (!this.isOccluded(int_4, int_6, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_6, int_5)) {
            return false;
          }
        }

        if (int_0 > 0) {
          if (!this.isOccluded(int_4, int_7, int_5)) {
            return false;
          }

          if (!this.isOccluded(int_4 + 128, int_7, int_5)) {
            return false;
          }
        }

        if (!this.isOccluded(int_4, int_8, int_5)) {
          return false;
        }

        if (!this.isOccluded(int_4 + 128, int_8, int_5)) {
          return false;
        }

        return true;
      }
    }

    return !this.isOccluded(int_4 + 64, int_9, int_5 + 64) ? false
        : int_3 == 16 ? this.isOccluded(int_4, int_8, int_5 + 128)
            : int_3 == 32 ? this.isOccluded(int_4 + 128, int_8, int_5 + 128)
                : int_3 == 64 ? this.isOccluded(int_4 + 128, int_8, int_5)
                    : int_3 == 128 ? this.isOccluded(int_4, int_8, int_5) : true;
  }

  void drawTileUnderlay(final SolidSquare scenetilepaint_0, final int plane, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int x, final int z) {
    int int_7;
    int x0 = int_7 = (x << 7) - cameraX;
    int z1;
    int z0 = z1 = (z << 7) - cameraZ;
    int int_11;
    int int_12 = int_11 = x0 + 128;
    int z3;
    int z2 = z3 = z0 + 128;
    int y0 = heightmap[plane][x][z] - cameraY;
    int y1 = heightmap[plane][x + 1][z] - cameraY;
    int y2 = heightmap[plane][x + 1][z + 1] - cameraY;
    final int y3 = heightmap[plane][x][z + 1] - cameraY;
    int int_19 = int_3 * z0 + x0 * int_4 >> 16;
    z0 = z0 * int_4 - int_3 * x0 >> 16;
    x0 = int_19;
    int_19 = y0 * int_2 - int_1 * z0 >> 16;
    z0 = int_1 * y0 + z0 * int_2 >> 16;
    y0 = int_19;
    if (z0 < 50) {
      return;
    }
    int_19 = int_3 * z1 + int_12 * int_4 >> 16;
    z1 = z1 * int_4 - int_3 * int_12 >> 16;
    int_12 = int_19;
    int_19 = y1 * int_2 - int_1 * z1 >> 16;
    z1 = int_1 * y1 + z1 * int_2 >> 16;
    y1 = int_19;
    if (z1 < 50) {
      return;
    }
    int_19 = int_11 * int_4 + int_3 * z2 >> 16;
    z2 = z2 * int_4 - int_3 * int_11 >> 16;
    int_11 = int_19;
    int_19 = y2 * int_2 - int_1 * z2 >> 16;
    z2 = int_1 * y2 + z2 * int_2 >> 16;
    y2 = int_19;
    if (z2 < 50) {
      return;
    }
    int_19 = int_3 * z3 + int_7 * int_4 >> 16;
    z3 = z3 * int_4 - int_3 * int_7 >> 16;
    int_7 = int_19;
    int_19 = y3 * int_2 - int_1 * z3 >> 16;
    z3 = int_1 * y3 + z3 * int_2 >> 16;
    if (z3 < 50) {
      return;
    }
    final int sx0 = Rasterizer3d.cx + x0 * Rasterizer3d.scaleFactor / z0;
    final int sy0 = Rasterizer3d.cy + y0 * Rasterizer3d.scaleFactor / z0;
    final int sx1 = int_12 * Rasterizer3d.scaleFactor / z1 + Rasterizer3d.cx;
    final int sy1 = Rasterizer3d.cy + y1 * Rasterizer3d.scaleFactor / z1;
    final int sx2 = int_11 * Rasterizer3d.scaleFactor / z2 + Rasterizer3d.cx;
    final int sy2 = Rasterizer3d.cy + y2 * Rasterizer3d.scaleFactor / z2;
    final int sx3 = int_7 * Rasterizer3d.scaleFactor / z3 + Rasterizer3d.cx;
    final int sy3 = int_19 * Rasterizer3d.scaleFactor / z3 + Rasterizer3d.cy;
    Rasterizer3d.alpha = 0;
    int int_28;
    if ((sx2 - sx3) * (sy1 - sy3) - (sy2 - sy3) * (sx1 - sx3) > 0) {

      Rasterizer3d.clipped = sx2 < 0 || sx3 < 0 || sx1 < 0 || sx2 > Rasterizer3d.width
          || sx3 > Rasterizer3d.width || sx1 > Rasterizer3d.width;

      if (checkClick && within(mx, my, sy2, sy3, sy1, sx2, sx3, sx1)) {
        selectedRegionTileX = x;
        selectedRegionTileY = z;
      }

      if (scenetilepaint_0.texture == -1) {
        if (scenetilepaint_0.neColor != 12345678) {
          Rasterizer3d.drawShaded(sy2, sy3, sy1, sx2, sx3, sx1,
              scenetilepaint_0.neColor, scenetilepaint_0.hsl2,
              scenetilepaint_0.hsl1);
        }
      } else if (!lowMemory) {
        if (scenetilepaint_0.flatShade) {
          Rasterizer3d.drawTextured0(sy2, sy3, sy1, sx2, sx3, sx1,
              scenetilepaint_0.neColor, scenetilepaint_0.hsl2,
              scenetilepaint_0.hsl1, x0, int_12, int_7, y0, y1, int_19,
              z0, z1, z3, scenetilepaint_0.texture);
        } else {
          Rasterizer3d.drawTextured0(sy2, sy3, sy1, sx2, sx3, sx1,
              scenetilepaint_0.neColor, scenetilepaint_0.hsl2,
              scenetilepaint_0.hsl1, int_11, int_7, int_12, y2, int_19, y1,
              z2, z3, z1, scenetilepaint_0.texture);
        }
      } else {
        int_28 = Rasterizer3d.materials.getHsl(scenetilepaint_0.texture);
        Rasterizer3d.drawShaded(sy2, sy3, sy1, sx2, sx3, sx1,
            lighten(int_28, scenetilepaint_0.neColor),
            lighten(int_28, scenetilepaint_0.hsl2),
            lighten(int_28, scenetilepaint_0.hsl1));
      }
    }

    if ((sx0 - sx1) * (sy3 - sy1) - (sy0 - sy1) * (sx3 - sx1) > 0) {
      Rasterizer3d.clipped = sx0 < 0 || sx1 < 0 || sx3 < 0 || sx0 > Rasterizer3d.width
          || sx1 > Rasterizer3d.width || sx3 > Rasterizer3d.width;

      if (checkClick && within(mx, my, sy0, sy1, sy3, sx0,
          sx1,
          sx3)) {
        selectedRegionTileX = x;
        selectedRegionTileY = z;
      }

      if (scenetilepaint_0.texture == -1) {
        if (scenetilepaint_0.hsl0 != 12345678) {
          Rasterizer3d.drawShaded(sy0, sy1, sy3, sx0, sx1, sx3,
              scenetilepaint_0.hsl0, scenetilepaint_0.hsl1, scenetilepaint_0.hsl2);
        }
      } else {
        if (lowMemory) {
          int_28 = Rasterizer3d.materials.getHsl(scenetilepaint_0.texture);
          Rasterizer3d.drawShaded(sy0, sy1, sy3, sx0, sx1, sx3,
              lighten(int_28, scenetilepaint_0.hsl0),
              lighten(int_28, scenetilepaint_0.hsl1),
              lighten(int_28, scenetilepaint_0.hsl2));
          return;
        }

        Rasterizer3d.drawTextured0(sy0, sy1, sy3, sx0, sx1, sx3,
            scenetilepaint_0.hsl0, scenetilepaint_0.hsl1,
            scenetilepaint_0.hsl2, x0, int_12, int_7, y0, y1, int_19,
            z0, z1, z3, scenetilepaint_0.texture);
        return;
      }
    }
  }

  void drawShapedSquare(final ShapedSquare square, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5) {
    int vertexCount = square.vx.length;

    for (int i = 0; i < vertexCount; i++) {
      int x = square.vx[i] - cameraX;
      int y = square.vy[i] - cameraY;
      int z = square.vz[i] - cameraZ;
      int ty = z * int_2 + int_3 * x >> 16;
      z = int_3 * z - x * int_2 >> 16;
      x = ty;
      ty = int_1 * y - z * int_0 >> 16;
      z = y * int_0 + int_1 * z >> 16;
      if (z < 50) {
        return;
      }

      if (square.triangleTextureId != null) {
        ShapedSquare.vertexSceneX[i] = x;
        ShapedSquare.vertexSceneY[i] = ty;
        ShapedSquare.vertexSceneZ[i] = z;
      }

      ShapedSquare.sx[i] = Rasterizer3d.cx + x * Rasterizer3d.scaleFactor / z;
      ShapedSquare.sy[i] = Rasterizer3d.cy + ty * Rasterizer3d.scaleFactor / z;
    }

    Rasterizer3d.alpha = 0;
    int faceCount = square.v0.length;

    for (int i = 0; i < faceCount; i++) {
      int v0 = square.v0[i];
      int v1 = square.v1[i];
      int v2 = square.v2[i];
      int x0 = ShapedSquare.sx[v0];
      final int x1 = ShapedSquare.sx[v1];
      final int x2 = ShapedSquare.sx[v2];
      final int y0 = ShapedSquare.sy[v0];
      final int y1 = ShapedSquare.sy[v1];
      final int y2 = ShapedSquare.sy[v2];
      if ((x0 - x1) * (y2 - y1) - (y0 - y1) * (x2 - x1) > 0) {
        Rasterizer3d.clipped = false;
        if (x0 < 0 || x1 < 0 || x2 < 0 || x0 > Rasterizer3d.width
            || x1 > Rasterizer3d.width || x2 > Rasterizer3d.width) {
          Rasterizer3d.clipped = true;
        }

        if (checkClick && within(mx, my, y0, y1, y2, x0, x1,
            x2)) {
          selectedRegionTileX = int_4;
          selectedRegionTileY = int_5;
        }

        if (square.triangleTextureId != null
            && square.triangleTextureId[i] != -1) {
          if (!lowMemory) {
            if (square.flatShade) {
              Rasterizer3d.drawTextured0(y0, y1, y2, x0, x1, x2,
                  square.triangleColorA[i], square.triangleColorB[i],
                  square.triangleColorC[i], ShapedSquare.vertexSceneX[0],
                  ShapedSquare.vertexSceneX[1], ShapedSquare.vertexSceneX[3],
                  ShapedSquare.vertexSceneY[0], ShapedSquare.vertexSceneY[1],
                  ShapedSquare.vertexSceneY[3], ShapedSquare.vertexSceneZ[0],
                  ShapedSquare.vertexSceneZ[1], ShapedSquare.vertexSceneZ[3],
                  square.triangleTextureId[i]);
            } else {
              Rasterizer3d.drawTextured0(y0, y1, y2, x0, x1, x2,
                  square.triangleColorA[i], square.triangleColorB[i],
                  square.triangleColorC[i], ShapedSquare.vertexSceneX[v0],
                  ShapedSquare.vertexSceneX[v1], ShapedSquare.vertexSceneX[v2],
                  ShapedSquare.vertexSceneY[v0], ShapedSquare.vertexSceneY[v1],
                  ShapedSquare.vertexSceneY[v2], ShapedSquare.vertexSceneZ[v0],
                  ShapedSquare.vertexSceneZ[v1], ShapedSquare.vertexSceneZ[v2],
                  square.triangleTextureId[i]);
            }
          } else {
            final int int_17 = Rasterizer3d.materials
                .getHsl(square.triangleTextureId[i]);
            Rasterizer3d.drawShaded(y0, y1, y2, x0, x1, x2,
                lighten(int_17, square.triangleColorA[i]),
                lighten(int_17, square.triangleColorB[i]),
                lighten(int_17, square.triangleColorC[i]));
          }
        } else if (square.triangleColorA[i] != 12345678) {
          Rasterizer3d.drawShaded(y0, y1, y2, x0, x1, x2,
              square.triangleColorA[i], square.triangleColorB[i],
              square.triangleColorC[i]);
        }
      }
    }

  }

  void method368(final ModelBase modeldata_0, final int int_0, final int int_1, final int int_2) {
    Square tile_0;
    ModelBase modeldata_1;
    if (int_1 < width) {
      tile_0 = squares[int_0][int_1 + 1][int_2];
      if (tile_0 != null && tile_0.groundObject != null
          && tile_0.groundObject.renderable instanceof ModelBase) {
        modeldata_1 = (ModelBase) tile_0.groundObject.renderable;
        ModelBase.method1020(modeldata_0, modeldata_1, 128, 0, 0, true);
      }
    }

    if (int_2 < width) {
      tile_0 = squares[int_0][int_1][int_2 + 1];
      if (tile_0 != null && tile_0.groundObject != null
          && tile_0.groundObject.renderable instanceof ModelBase) {
        modeldata_1 = (ModelBase) tile_0.groundObject.renderable;
        ModelBase.method1020(modeldata_0, modeldata_1, 0, 0, 128, true);
      }
    }

    if (int_1 < width && int_2 < height) {
      tile_0 = squares[int_0][int_1 + 1][int_2 + 1];
      if (tile_0 != null && tile_0.groundObject != null
          && tile_0.groundObject.renderable instanceof ModelBase) {
        modeldata_1 = (ModelBase) tile_0.groundObject.renderable;
        ModelBase.method1020(modeldata_0, modeldata_1, 128, 0, 128, true);
      }
    }

    if (int_1 < width && int_2 > 0) {
      tile_0 = squares[int_0][int_1 + 1][int_2 - 1];
      if (tile_0 != null && tile_0.groundObject != null
          && tile_0.groundObject.renderable instanceof ModelBase) {
        modeldata_1 = (ModelBase) tile_0.groundObject.renderable;
        ModelBase.method1020(modeldata_0, modeldata_1, 128, 0, -128, true);
      }
    }

  }

  boolean isOccluded(final int int_0, final int int_1, final int int_2, final int int_3) {
    if (!isTileOccluded(int_0, int_1, int_2)) {
      return false;
    }
    final int int_4 = int_1 << 7;
    final int int_5 = int_2 << 7;
    return this.isOccluded(int_4 + 1, heightmap[int_0][int_1][int_2] - int_3, int_5 + 1)
        && this
        .isOccluded(int_4 + 128 - 1, heightmap[int_0][int_1 + 1][int_2] - int_3, int_5 + 1)
        && this.isOccluded(int_4 + 128 - 1, heightmap[int_0][int_1 + 1][int_2 + 1] - int_3,
        int_5 + 128 - 1)
        && this
        .isOccluded(int_4 + 1, heightmap[int_0][int_1][int_2 + 1] - int_3, int_5 + 128 - 1);
  }

  void updateOccluders() {
    final int int_0 = levelOccluderCount[plane];
    final Occluder[] occluders_0 = levelOccluders[plane];
    anInt144 = 0;

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final Occluder occluder_0 = occluders_0[int_1];
      int int_2;
      int int_3;
      int int_4;
      int int_6;
      boolean bool_1;
      if (occluder_0.type == 1) {
        int_2 = occluder_0.minTileX - csx + 25;
        if (int_2 >= 0 && int_2 <= 50) {
          int_3 = occluder_0.minTileZ - csz + 25;
          if (int_3 < 0) {
            int_3 = 0;
          }

          int_4 = occluder_0.maxTileZ - csz + 25;
          if (int_4 > 50) {
            int_4 = 50;
          }

          bool_1 = false;

          while (int_3 <= int_4) {
            if (visible[int_2][int_3++]) {
              bool_1 = true;
              break;
            }
          }

          if (bool_1) {
            int_6 = cameraX - occluder_0.minX;
            if (int_6 > 32) {
              occluder_0.testDirection = 1;
            } else {
              if (int_6 >= -32) {
                continue;
              }

              occluder_0.testDirection = 2;
              int_6 = -int_6;
            }

            occluder_0.minNormalX = (occluder_0.minZ - cameraZ << 8) / int_6;
            occluder_0.maxNormalX = (occluder_0.maxZ - cameraZ << 8) / int_6;
            occluder_0.minNormalY = (occluder_0.minY - cameraY << 8) / int_6;
            occluder_0.maxNormalY = (occluder_0.maxY - cameraY << 8) / int_6;
            anOccluderArray1[anInt144++] = occluder_0;
          }
        }
      } else if (occluder_0.type == 2) {
        int_2 = occluder_0.minTileZ - csz + 25;
        if (int_2 >= 0 && int_2 <= 50) {
          int_3 = occluder_0.minTileX - csx + 25;
          if (int_3 < 0) {
            int_3 = 0;
          }

          int_4 = occluder_0.maxTIleX - csx + 25;
          if (int_4 > 50) {
            int_4 = 50;
          }

          bool_1 = false;

          while (int_3 <= int_4) {
            if (visible[int_3++][int_2]) {
              bool_1 = true;
              break;
            }
          }

          if (bool_1) {
            int_6 = cameraZ - occluder_0.minZ;
            if (int_6 > 32) {
              occluder_0.testDirection = 3;
            } else {
              if (int_6 >= -32) {
                continue;
              }

              occluder_0.testDirection = 4;
              int_6 = -int_6;
            }

            occluder_0.anInt163 = (occluder_0.minX - cameraX << 8) / int_6;
            occluder_0.anInt164 = (occluder_0.maxX - cameraX << 8) / int_6;
            occluder_0.minNormalY = (occluder_0.minY - cameraY << 8) / int_6;
            occluder_0.maxNormalY = (occluder_0.maxY - cameraY << 8) / int_6;
            anOccluderArray1[anInt144++] = occluder_0;
          }
        }
      } else if (occluder_0.type == 4) {
        int_2 = occluder_0.minY - cameraY;
        if (int_2 > 128) {
          int_3 = occluder_0.minTileZ - csz + 25;
          if (int_3 < 0) {
            int_3 = 0;
          }

          int_4 = occluder_0.maxTileZ - csz + 25;
          if (int_4 > 50) {
            int_4 = 50;
          }

          if (int_3 <= int_4) {
            int int_5 = occluder_0.minTileX - csx + 25;
            if (int_5 < 0) {
              int_5 = 0;
            }

            int_6 = occluder_0.maxTIleX - csx + 25;
            if (int_6 > 50) {
              int_6 = 50;
            }

            boolean bool_0 = false;

            label144:
            for (int int_7 = int_5; int_7 <= int_6; int_7++) {
              for (int int_8 = int_3; int_8 <= int_4; int_8++) {
                if (visible[int_7][int_8]) {
                  bool_0 = true;
                  break label144;
                }
              }
            }

            if (bool_0) {
              occluder_0.testDirection = 5;
              occluder_0.anInt163 = (occluder_0.minX - cameraX << 8) / int_2;
              occluder_0.anInt164 = (occluder_0.maxX - cameraX << 8) / int_2;
              occluder_0.minNormalX = (occluder_0.minZ - cameraZ << 8) / int_2;
              occluder_0.maxNormalX = (occluder_0.maxZ - cameraZ << 8) / int_2;
              anOccluderArray1[anInt144++] = occluder_0;
            }
          }
        }
      }
    }

  }

  boolean isAreaOccluded(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5) {
    int int_6;
    int int_7;
    if (int_2 == int_1 && int_4 == int_3) {
      if (!isTileOccluded(int_0, int_1, int_3)) {
        return false;
      }
      int_6 = int_1 << 7;
      int_7 = int_3 << 7;
      return this.isOccluded(int_6 + 1, heightmap[int_0][int_1][int_3] - int_5, int_7 + 1)
          && this
          .isOccluded(int_6 + 128 - 1, heightmap[int_0][int_1 + 1][int_3] - int_5, int_7 + 1)
          && this.isOccluded(int_6 + 128 - 1, heightmap[int_0][int_1 + 1][int_3 + 1] - int_5,
          int_7 + 128 - 1)
          && this
          .isOccluded(int_6 + 1, heightmap[int_0][int_1][int_3 + 1] - int_5, int_7 + 128 - 1);
    }
    for (int_6 = int_1; int_6 <= int_2; int_6++) {
      for (int_7 = int_3; int_7 <= int_4; int_7++) {
        if (tileCycles[int_0][int_6][int_7] == -tick) {
          return false;
        }
      }
    }

    int_6 = (int_1 << 7) + 1;
    int_7 = (int_3 << 7) + 2;
    final int int_8 = heightmap[int_0][int_1][int_3] - int_5;
    if (!this.isOccluded(int_6, int_8, int_7)) {
      return false;
    }
    final int int_9 = (int_2 << 7) - 1;
    if (!this.isOccluded(int_9, int_8, int_7)) {
      return false;
    }
    final int int_10 = (int_4 << 7) - 1;
    if (!this.isOccluded(int_6, int_8, int_10)) {
      return false;
    }
    if (!this.isOccluded(int_9, int_8, int_10)) {
      return false;
    }
    return true;
  }

  void draw(final Square tile_0, boolean bool_0) {
    tileDeque.addLast(tile_0);

    while (true) {
      Square tile_1;
      int int_0;
      int int_1;
      int int_2;
      int int_3;
      Square[][] tiles_0;
      Square tile_2;
      int int_4;
      int int_6;
      int int_7;
      int int_8;
      int int_9;
      int int_10;
      do {
        do {
          do {
            do {
              do {
                do {
                  while (true) {
                    WallObject wallobject_0;
                    GameObject gameobject_0;
                    boolean bool_1;
                    int int_5;
                    int int_11;
                    int int_12;
                    Square tile_5;
                    while (true) {
                      do {
                        tile_1 = (Square) tileDeque.pollFirst();
                        if (tile_1 == null) {
                          return;
                        }
                      } while (!tile_1.visible);

                      int_0 = tile_1.x;
                      int_1 = tile_1.z;
                      int_2 = tile_1.plane;
                      int_3 = tile_1.renderLevel;
                      tiles_0 = squares[int_2];
                      if (!tile_1.draw) {
                        break;
                      }

                      if (bool_0) {
                        if (int_2 > 0) {
                          tile_2 = squares[int_2 - 1][int_0][int_1];
                          if (tile_2 != null && tile_2.visible) {
                            continue;
                          }
                        }

                        if (int_0 <= csx && int_0 > lx) {
                          tile_2 = tiles_0[int_0 - 1][int_1];
                          if (tile_2 != null && tile_2.visible
                              && (tile_2.draw || (tile_1.cullingFlags & 0x1) == 0)) {
                            continue;
                          }
                        }

                        if (int_0 >= csx && int_0 < ux - 1) {
                          tile_2 = tiles_0[int_0 + 1][int_1];
                          if (tile_2 != null && tile_2.visible
                              && (tile_2.draw || (tile_1.cullingFlags & 0x4) == 0)) {
                            continue;
                          }
                        }

                        if (int_1 <= csz && int_1 > lz) {
                          tile_2 = tiles_0[int_0][int_1 - 1];
                          if (tile_2 != null && tile_2.visible
                              && (tile_2.draw || (tile_1.cullingFlags & 0x8) == 0)) {
                            continue;
                          }
                        }

                        if (int_1 >= csz && int_1 < uz - 1) {
                          tile_2 = tiles_0[int_0][int_1 + 1];
                          if (tile_2 != null && tile_2.visible
                              && (tile_2.draw || (tile_1.cullingFlags & 0x2) == 0)) {
                            continue;
                          }
                        }
                      } else {
                        bool_0 = true;
                      }

                      tile_1.draw = false;
                      if (tile_1.bridge != null) {
                        tile_2 = tile_1.bridge;
                        if (tile_2.solid != null) {
                          if (!isTileOccluded(0, int_0, int_1)) {
                            drawTileUnderlay(tile_2.solid, 0, rxs, rxc, rys,
                                ryc, int_0, int_1);
                          }
                        } else if (tile_2.shaped != null
                            && !isTileOccluded(0, int_0, int_1)) {
                          drawShapedSquare(tile_2.shaped, rxs, rxc, rys, ryc,
                              int_0, int_1);
                        }

                        wallobject_0 = tile_2.wallObject;
                        if (wallobject_0 != null) {
                          wallobject_0.renderable1.draw(0, rxs, rxc, rys, ryc,
                              wallobject_0.x - cameraX, wallobject_0.floor - cameraY,
                              wallobject_0.y - cameraZ, wallobject_0.hash);
                        }

                        for (int_4 = 0; int_4 < tile_2.entityCount; int_4++) {
                          gameobject_0 = tile_2.objects[int_4];
                          if (gameobject_0 != null) {
                            gameobject_0.renderable.draw(gameobject_0.orientation, rxs,
                                rxc, rys, ryc, gameobject_0.x - cameraX,
                                gameobject_0.height - cameraY,
                                gameobject_0.y - cameraZ, gameobject_0.hash);
                          }
                        }
                      }

                      bool_1 = false;
                      if (tile_1.solid != null) {
                        if (!isTileOccluded(int_3, int_0, int_1)) {
                          bool_1 = true;
                          if (tile_1.solid.neColor != 12345678
                              || checkClick && int_2 <= anInt146) {
                            drawTileUnderlay(tile_1.solid, int_3, rxs, rxc,
                                rys, ryc, int_0, int_1);
                          }
                        }
                      } else if (tile_1.shaped != null
                          && !isTileOccluded(int_3, int_0, int_1)) {
                        bool_1 = true;
                        drawShapedSquare(tile_1.shaped, rxs, rxc, rys, ryc,
                            int_0, int_1);
                      }

                      int_5 = 0;
                      int_4 = 0;
                      final WallObject wallobject_2 = tile_1.wallObject;
                      final DecorativeObject decorativeobject_0 = tile_1.decorativeObject;
                      if (wallobject_2 != null || decorativeobject_0 != null) {
                        if (int_0 == csx) {
                          ++int_5;
                        } else if (csx < int_0) {
                          int_5 += 2;
                        }

                        if (int_1 == csz) {
                          int_5 += 3;
                        } else if (csz > int_1) {
                          int_5 += 6;
                        }

                        int_4 = anIntArray37[int_5];
                        tile_1.wallDrawFlags = TILE_WALL_DRAW_FLAGS_1[int_5];
                      }

                      if (wallobject_2 != null) {
                        if ((wallobject_2.orientationA & anIntArray36[int_5]) != 0) {
                          if (wallobject_2.orientationA == 16) {
                            tile_1.wallCullDirection = 3;
                            tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_0[int_5];
                            tile_1.wallCullOppositeDirection = 3
                                - tile_1.wallUncullDirection;
                          } else if (wallobject_2.orientationA == 32) {
                            tile_1.wallCullDirection = 6;
                            tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_1[int_5];
                            tile_1.wallCullOppositeDirection = 6
                                - tile_1.wallUncullDirection;
                          } else if (wallobject_2.orientationA == 64) {
                            tile_1.wallCullDirection = 12;
                            tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_2[int_5];
                            tile_1.wallCullOppositeDirection = 12
                                - tile_1.wallUncullDirection;
                          } else {
                            tile_1.wallCullDirection = 9;
                            tile_1.wallUncullDirection = WALL_UNCULL_FLAGS_3[int_5];
                            tile_1.wallCullOppositeDirection = 9
                                - tile_1.wallUncullDirection;
                          }
                        } else {
                          tile_1.wallCullDirection = 0;
                        }

                        if ((wallobject_2.orientationA & int_4) != 0 && !isWallOccluded(int_3,
                            int_0, int_1, wallobject_2.orientationA)) {
                          wallobject_2.renderable1.draw(0, rxs, rxc, rys, ryc,
                              wallobject_2.x - cameraX, wallobject_2.floor - cameraY,
                              wallobject_2.y - cameraZ, wallobject_2.hash);
                        }

                        if ((wallobject_2.orientationB & int_4) != 0 && !isWallOccluded(int_3,
                            int_0, int_1, wallobject_2.orientationB)) {
                          wallobject_2.renderable2.draw(0, rxs, rxc, rys, ryc,
                              wallobject_2.x - cameraX, wallobject_2.floor - cameraY,
                              wallobject_2.y - cameraZ, wallobject_2.hash);
                        }
                      }

                      if (decorativeobject_0 != null && !this.isOccluded(int_3, int_0, int_1,
                          decorativeobject_0.renderable1.minimumY)) {
                        if ((decorativeobject_0.renderFlag & int_4) != 0) {
                          decorativeobject_0.renderable1.draw(0, rxs, rxc, rys,
                              ryc,
                              decorativeobject_0.x - cameraX
                                  + decorativeobject_0.offsetX,
                              decorativeobject_0.floor - cameraY,
                              decorativeobject_0.y - cameraZ
                                  + decorativeobject_0.offsetY,
                              decorativeobject_0.hash);
                        } else if (decorativeobject_0.renderFlag == 256) {
                          int_7 = decorativeobject_0.x - cameraX;
                          int_8 = decorativeobject_0.floor - cameraY;
                          int_9 = decorativeobject_0.y - cameraZ;
                          int_11 = decorativeobject_0.rotation;
                          if (int_11 != 1 && int_11 != 2) {
                            int_12 = int_7;
                          } else {
                            int_12 = -int_7;
                          }

                          int int_13;
                          if (int_11 != 2 && int_11 != 3) {
                            int_13 = int_9;
                          } else {
                            int_13 = -int_9;
                          }

                          if (int_13 < int_12) {
                            decorativeobject_0.renderable1.draw(0, rxs, rxc,
                                rys, ryc, int_7 + decorativeobject_0.offsetX,
                                int_8, int_9 + decorativeobject_0.offsetY,
                                decorativeobject_0.hash);
                          } else if (decorativeobject_0.renderable2 != null) {
                            decorativeobject_0.renderable2.draw(0, rxs, rxc,
                                rys, ryc, int_7, int_8, int_9,
                                decorativeobject_0.hash);
                          }
                        }
                      }

                      if (bool_1) {
                        final GroundObject groundobject_0 = tile_1.groundObject;
                        if (groundobject_0 != null) {
                          groundobject_0.renderable.draw(0, rxs, rxc, rys,
                              ryc, groundobject_0.x - cameraX,
                              groundobject_0.floor - cameraY,
                              groundobject_0.y - cameraZ, groundobject_0.hash);
                        }

                        final ItemLayer itemlayer_0 = tile_1.itemLayer;
                        if (itemlayer_0 != null && itemlayer_0.height == 0) {
                          if (itemlayer_0.middle != null) {
                            itemlayer_0.middle.draw(0, rxs, rxc, rys, ryc,
                                itemlayer_0.x - cameraX, itemlayer_0.hash - cameraY,
                                itemlayer_0.y - cameraZ, itemlayer_0.flags);
                          }

                          if (itemlayer_0.top != null) {
                            itemlayer_0.top.draw(0, rxs, rxc, rys, ryc,
                                itemlayer_0.x - cameraX, itemlayer_0.hash - cameraY,
                                itemlayer_0.y - cameraZ, itemlayer_0.flags);
                          }

                          if (itemlayer_0.bottom != null) {
                            itemlayer_0.bottom.draw(0, rxs, rxc, rys, ryc,
                                itemlayer_0.x - cameraX, itemlayer_0.hash - cameraY,
                                itemlayer_0.y - cameraZ, itemlayer_0.flags);
                          }
                        }
                      }

                      int_7 = tile_1.cullingFlags;
                      if (int_7 != 0) {
                        if (int_0 < csx && (int_7 & 0x4) != 0) {
                          tile_5 = tiles_0[int_0 + 1][int_1];
                          if (tile_5 != null && tile_5.visible) {
                            tileDeque.addLast(tile_5);
                          }
                        }

                        if (int_1 < csz && (int_7 & 0x2) != 0) {
                          tile_5 = tiles_0[int_0][int_1 + 1];
                          if (tile_5 != null && tile_5.visible) {
                            tileDeque.addLast(tile_5);
                          }
                        }

                        if (int_0 > csx && (int_7 & 0x1) != 0) {
                          tile_5 = tiles_0[int_0 - 1][int_1];
                          if (tile_5 != null && tile_5.visible) {
                            tileDeque.addLast(tile_5);
                          }
                        }

                        if (int_1 > csz && (int_7 & 0x8) != 0) {
                          tile_5 = tiles_0[int_0][int_1 - 1];
                          if (tile_5 != null && tile_5.visible) {
                            tileDeque.addLast(tile_5);
                          }
                        }
                      }
                      break;
                    }

                    if (tile_1.wallCullDirection != 0) {
                      bool_1 = true;

                      for (int_5 = 0; int_5 < tile_1.entityCount; int_5++) {
                        if (tile_1.objects[int_5].cycle != tick
                            && (tile_1.entityFlags[int_5]
                            & tile_1.wallCullDirection) == tile_1.wallUncullDirection) {
                          bool_1 = false;
                          break;
                        }
                      }

                      if (bool_1) {
                        wallobject_0 = tile_1.wallObject;
                        if (!isWallOccluded(int_3, int_0, int_1, wallobject_0.orientationA)) {
                          wallobject_0.renderable1.draw(0, rxs, rxc, rys, ryc,
                              wallobject_0.x - cameraX, wallobject_0.floor - cameraY,
                              wallobject_0.y - cameraZ, wallobject_0.hash);
                        }

                        tile_1.wallCullDirection = 0;
                      }
                    }

                    if (!tile_1.drawEntities) {
                      break;
                    }

                    try {
                      final int int_14 = tile_1.entityCount;
                      tile_1.drawEntities = false;
                      int_5 = 0;

                      label583:
                      for (int_4 = 0; int_4 < int_14; int_4++) {
                        gameobject_0 = tile_1.objects[int_4];
                        if (gameobject_0.cycle != tick) {
                          for (int_6 = gameobject_0.relativeX; int_6 <= gameobject_0.offsetX;
                              int_6++) {
                            for (int_7 = gameobject_0.relativeY; int_7 <= gameobject_0.offsetY;
                                int_7++) {
                              tile_5 = tiles_0[int_6][int_7];
                              if (tile_5.draw) {
                                tile_1.drawEntities = true;
                                continue label583;
                              }

                              if (tile_5.wallCullDirection != 0) {
                                int_9 = 0;
                                if (int_6 > gameobject_0.relativeX) {
                                  ++int_9;
                                }

                                if (int_6 < gameobject_0.offsetX) {
                                  int_9 += 4;
                                }

                                if (int_7 > gameobject_0.relativeY) {
                                  int_9 += 8;
                                }

                                if (int_7 < gameobject_0.offsetY) {
                                  int_9 += 2;
                                }

                                if ((int_9
                                    & tile_5.wallCullDirection)
                                    == tile_1.wallCullOppositeDirection) {
                                  tile_1.drawEntities = true;
                                  continue label583;
                                }
                              }
                            }
                          }

                          entityBuffer[int_5++] = gameobject_0;
                          int_6 = csx - gameobject_0.relativeX;
                          int_7 = gameobject_0.offsetX - csx;
                          if (int_7 > int_6) {
                            int_6 = int_7;
                          }

                          int_8 = csz - gameobject_0.relativeY;
                          int_9 = gameobject_0.offsetY - csz;
                          if (int_9 > int_8) {
                            gameobject_0.drawPriority = int_6 + int_9;
                          } else {
                            gameobject_0.drawPriority = int_6 + int_8;
                          }
                        }
                      }

                      while (int_5 > 0) {
                        int_4 = -50;
                        int_10 = -1;

                        for (int_6 = 0; int_6 < int_5; int_6++) {
                          final GameObject gameobject_1 = entityBuffer[int_6];
                          if (gameobject_1.cycle != tick) {
                            if (gameobject_1.drawPriority > int_4) {
                              int_4 = gameobject_1.drawPriority;
                              int_10 = int_6;
                            } else if (int_4 == gameobject_1.drawPriority) {
                              int_8 = gameobject_1.x - cameraX;
                              int_9 = gameobject_1.y - cameraZ;
                              int_11 = entityBuffer[int_10].x - cameraX;
                              int_12 = entityBuffer[int_10].y - cameraZ;
                              if (int_8 * int_8 + int_9 * int_9 > int_11 * int_11
                                  + int_12 * int_12) {
                                int_10 = int_6;
                              }
                            }
                          }
                        }

                        if (int_10 == -1) {
                          break;
                        }

                        final GameObject gameobject_2 = entityBuffer[int_10];
                        gameobject_2.cycle = tick;
                        if (!isAreaOccluded(int_3, gameobject_2.relativeX, gameobject_2.offsetX,
                            gameobject_2.relativeY, gameobject_2.offsetY,
                            gameobject_2.renderable.minimumY)) {
                          gameobject_2.renderable.draw(gameobject_2.orientation, rxs,
                              rxc, rys, ryc, gameobject_2.x - cameraX,
                              gameobject_2.height - cameraY, gameobject_2.y - cameraZ,
                              gameobject_2.hash);
                        }

                        for (int_7 = gameobject_2.relativeX; int_7 <= gameobject_2.offsetX;
                            int_7++) {
                          for (int_8 = gameobject_2.relativeY; int_8 <= gameobject_2.offsetY;
                              int_8++) {
                            final Square tile_3 = tiles_0[int_7][int_8];
                            if (tile_3.wallCullDirection != 0) {
                              tileDeque.addLast(tile_3);
                            } else if ((int_7 != int_0 || int_8 != int_1)
                                && tile_3.visible) {
                              tileDeque.addLast(tile_3);
                            }
                          }
                        }
                      }

                      if (!tile_1.drawEntities) {
                        break;
                      }
                    } catch (final Exception exception_0) {
                      tile_1.drawEntities = false;
                      break;
                    }
                  }
                } while (!tile_1.visible);
              } while (tile_1.wallCullDirection != 0);

              if (int_0 > csx || int_0 <= lx) {
                break;
              }

              tile_2 = tiles_0[int_0 - 1][int_1];
            } while (tile_2 != null && tile_2.visible);

            if (int_0 < csx || int_0 >= ux - 1) {
              break;
            }

            tile_2 = tiles_0[int_0 + 1][int_1];
          } while (tile_2 != null && tile_2.visible);

          if (int_1 > csz || int_1 <= lz) {
            break;
          }

          tile_2 = tiles_0[int_0][int_1 - 1];
        } while (tile_2 != null && tile_2.visible);

        if (int_1 < csz || int_1 >= uz - 1) {
          break;
        }

        tile_2 = tiles_0[int_0][int_1 + 1];
      } while (tile_2 != null && tile_2.visible);

      tile_1.visible = false;
      --tileUpdateCount;
      final ItemLayer itemlayer_1 = tile_1.itemLayer;
      if (itemlayer_1 != null && itemlayer_1.height != 0) {
        if (itemlayer_1.middle != null) {
          itemlayer_1.middle.draw(0, rxs, rxc, rys, ryc, itemlayer_1.x - cameraX,
              itemlayer_1.hash - cameraY - itemlayer_1.height, itemlayer_1.y - cameraZ,
              itemlayer_1.flags);
        }

        if (itemlayer_1.top != null) {
          itemlayer_1.top.draw(0, rxs, rxc, rys, ryc, itemlayer_1.x - cameraX,
              itemlayer_1.hash - cameraY - itemlayer_1.height, itemlayer_1.y - cameraZ,
              itemlayer_1.flags);
        }

        if (itemlayer_1.bottom != null) {
          itemlayer_1.bottom.draw(0, rxs, rxc, rys, ryc, itemlayer_1.x - cameraX,
              itemlayer_1.hash - cameraY - itemlayer_1.height, itemlayer_1.y - cameraZ,
              itemlayer_1.flags);
        }
      }

      if (tile_1.wallDrawFlags != 0) {
        final DecorativeObject decorativeobject_1 = tile_1.decorativeObject;
        if (decorativeobject_1 != null
            && !this.isOccluded(int_3, int_0, int_1, decorativeobject_1.renderable1.minimumY)) {
          if ((decorativeobject_1.renderFlag & tile_1.wallDrawFlags) != 0) {
            decorativeobject_1.renderable1.draw(0, rxs, rxc, rys, ryc,
                decorativeobject_1.x - cameraX + decorativeobject_1.offsetX,
                decorativeobject_1.floor - cameraY,
                decorativeobject_1.y - cameraZ + decorativeobject_1.offsetY,
                decorativeobject_1.hash);
          } else if (decorativeobject_1.renderFlag == 256) {
            int_4 = decorativeobject_1.x - cameraX;
            int_10 = decorativeobject_1.floor - cameraY;
            int_6 = decorativeobject_1.y - cameraZ;
            int_7 = decorativeobject_1.rotation;
            if (int_7 != 1 && int_7 != 2) {
              int_8 = int_4;
            } else {
              int_8 = -int_4;
            }

            if (int_7 != 2 && int_7 != 3) {
              int_9 = int_6;
            } else {
              int_9 = -int_6;
            }

            if (int_9 >= int_8) {
              decorativeobject_1.renderable1.draw(0, rxs, rxc, rys, ryc,
                  int_4 + decorativeobject_1.offsetX, int_10, int_6 + decorativeobject_1.offsetY,
                  decorativeobject_1.hash);
            } else if (decorativeobject_1.renderable2 != null) {
              decorativeobject_1.renderable2
                  .draw(0, rxs, rxc, rys, ryc, int_4, int_10,
                      int_6, decorativeobject_1.hash);
            }
          }
        }

        final WallObject wallobject_1 = tile_1.wallObject;
        if (wallobject_1 != null) {
          if ((wallobject_1.orientationB & tile_1.wallDrawFlags) != 0
              && !isWallOccluded(int_3, int_0, int_1, wallobject_1.orientationB)) {
            wallobject_1.renderable2
                .draw(0, rxs, rxc, rys, ryc, wallobject_1.x - cameraX,
                    wallobject_1.floor - cameraY, wallobject_1.y - cameraZ, wallobject_1.hash);
          }

          if ((wallobject_1.orientationA & tile_1.wallDrawFlags) != 0
              && !isWallOccluded(int_3, int_0, int_1, wallobject_1.orientationA)) {
            wallobject_1.renderable1
                .draw(0, rxs, rxc, rys, ryc, wallobject_1.x - cameraX,
                    wallobject_1.floor - cameraY, wallobject_1.y - cameraZ, wallobject_1.hash);
          }
        }
      }

      Square tile_4;
      if (int_2 < planes - 1) {
        tile_4 = squares[int_2 + 1][int_0][int_1];
        if (tile_4 != null && tile_4.visible) {
          tileDeque.addLast(tile_4);
        }
      }

      if (int_0 < csx) {
        tile_4 = tiles_0[int_0 + 1][int_1];
        if (tile_4 != null && tile_4.visible) {
          tileDeque.addLast(tile_4);
        }
      }

      if (int_1 < csz) {
        tile_4 = tiles_0[int_0][int_1 + 1];
        if (tile_4 != null && tile_4.visible) {
          tileDeque.addLast(tile_4);
        }
      }

      if (int_0 > csx) {
        tile_4 = tiles_0[int_0 - 1][int_1];
        if (tile_4 != null && tile_4.visible) {
          tileDeque.addLast(tile_4);
        }
      }

      if (int_1 > csz) {
        tile_4 = tiles_0[int_0][int_1 - 1];
        if (tile_4 != null && tile_4.visible) {
          tileDeque.addLast(tile_4);
        }
      }
    }
  }

  public boolean method369(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final Renderable renderable_0, final int int_5, final int int_6, final boolean bool_0) {
    if (renderable_0 == null) {
      return true;
    }
    int int_7 = int_1 - int_4;
    int int_8 = int_2 - int_4;
    int int_9 = int_4 + int_1;
    int int_10 = int_2 + int_4;
    if (bool_0) {
      if (int_5 > 640 && int_5 < 1408) {
        int_10 += 128;
      }

      if (int_5 > 1152 && int_5 < 1920) {
        int_9 += 128;
      }

      if (int_5 > 1664 || int_5 < 384) {
        int_8 -= 128;
      }

      if (int_5 > 128 && int_5 < 896) {
        int_7 -= 128;
      }
    }

    int_7 /= 128;
    int_8 /= 128;
    int_9 /= 128;
    int_10 /= 128;
    return addEntityMarker(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1,
        int_2, int_3,
        renderable_0, int_5, true, int_6, 0);
  }

  public void method370(final int[] dest, int pos, final int step, final int plane,
      final int x,
      final int z) {
    final Square tile_0 = squares[plane][x][z];
    if (tile_0 == null) {
      return;
    }
    final SolidSquare solid = tile_0.solid;
    int int_6;
    if (solid != null) {
      final int rgb = solid.rgb;
      if (rgb == 0) {
        return;
      }
      for (int i = 0; i < 4; i++) {
        dest[pos] = rgb;
        dest[pos + 1] = rgb;
        dest[pos + 2] = rgb;
        dest[pos + 3] = rgb;
        pos += step;
      }
    } else {
      final ShapedSquare shaped = tile_0.shaped;
      if (shaped != null) {
        int_6 = shaped.configuration;
        final int int_7 = shaped.orientation;
        final int int_8 = shaped.underlay;
        final int int_9 = shaped.overlay;
        final int[] ints_1 = TILE_MASK_2D[int_6];
        final int[] ints_2 = TILE_ROTATION_2D[int_7];
        int int_10 = 0;
        int int_11;
        if (int_8 != 0) {
          for (int_11 = 0; int_11 < 4; int_11++) {
            dest[pos] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
            dest[pos + 1] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
            dest[pos + 2] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
            dest[pos + 3] = ints_1[ints_2[int_10++]] == 0 ? int_8 : int_9;
            pos += step;
          }
        } else {
          for (int_11 = 0; int_11 < 4; int_11++) {
            if (ints_1[ints_2[int_10++]] != 0) {
              dest[pos] = int_9;
            }

            if (ints_1[ints_2[int_10++]] != 0) {
              dest[pos + 1] = int_9;
            }

            if (ints_1[ints_2[int_10++]] != 0) {
              dest[pos + 2] = int_9;
            }

            if (ints_1[ints_2[int_10++]] != 0) {
              dest[pos + 3] = int_9;
            }

            pos += step;
          }
        }

      }
    }
  }

  public void setup(final int int_0) {
    lowerPlane = int_0;

    for (int int_1 = 0; int_1 < width; int_1++) {
      for (int int_2 = 0; int_2 < height; int_2++) {
        if (squares[int_0][int_1][int_2] == null) {
          squares[int_0][int_1][int_2] = new Square(int_0, int_1, int_2);
        }
      }
    }

  }

  public boolean method371(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final Renderable renderable_0, final int int_5, final int int_6, final int int_7,
      final int int_8,
      final int int_9, final int int_10) {
    return renderable_0 == null ? true
        : addEntityMarker(int_0, int_7, int_8, int_9 - int_7 + 1, int_10 - int_8 + 1, int_1,
            int_2, int_3,
            renderable_0, int_5, true, int_6, 0);
  }

  public int method372(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    return tile_0 != null && tile_0.wallObject != null ? tile_0.wallObject.hash : 0;
  }

  public void method373(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      tile_0.itemLayer = null;
    }
  }

  public int method374(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    return tile_0 != null && tile_0.decorativeObject != null ? tile_0.decorativeObject.hash : 0;
  }

  public int method375(final int plane, final int x, final int z) {
    final Square tile_0 = squares[plane][x][z];
    return tile_0 != null && tile_0.groundObject != null ? tile_0.groundObject.hash : 0;
  }

  public int method376(final int int_0, final int int_1, final int int_2, final int int_3) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 == null) {
      return -1;
    }
    if (tile_0.wallObject != null && tile_0.wallObject.hash == int_3) {
      return tile_0.wallObject.config & 0xFF;
    }
    if (tile_0.decorativeObject != null && tile_0.decorativeObject.hash == int_3) {
      return tile_0.decorativeObject.renderInfoBitPacked & 0xFF;
    }
    if (tile_0.groundObject != null && tile_0.groundObject.hash == int_3) {
      return tile_0.groundObject.renderInfoBitPacked & 0xFF;
    }
    for (int int_4 = 0; int_4 < tile_0.entityCount; int_4++) {
      if (int_3 == tile_0.objects[int_4].hash) {
        return tile_0.objects[int_4].flags & 0xFF;
      }
    }

    return -1;
  }

  public int method377(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 == null) {
      return 0;
    }
    for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
      final GameObject gameobject_0 = tile_0.objects[int_3];
      if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX
          && int_2 == gameobject_0.relativeY) {
        return gameobject_0.hash;
      }
    }

    return 0;
  }

  public void addItemPile(final int int_0, final int int_1, final int int_2, final int int_3,
      final Renderable renderable_0, final int int_4, final Renderable renderable_1,
      final Renderable renderable_2) {
    final ItemLayer itemlayer_0 = new ItemLayer();
    itemlayer_0.bottom = renderable_0;
    itemlayer_0.x = int_1 * 128 + 64;
    itemlayer_0.y = int_2 * 128 + 64;
    itemlayer_0.hash = int_3;
    itemlayer_0.flags = int_4;
    itemlayer_0.middle = renderable_1;
    itemlayer_0.top = renderable_2;
    int int_5 = 0;
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      for (int int_6 = 0; int_6 < tile_0.entityCount; int_6++) {
        if ((tile_0.objects[int_6].flags & 0x100) == 256
            && tile_0.objects[int_6].renderable instanceof Model) {
          final Model model_0 = (Model) tile_0.objects[int_6].renderable;
          model_0.calculateRectangularBounds();
          if (model_0.minimumY > int_5) {
            int_5 = model_0.minimumY;
          }
        }
      }
    }

    itemlayer_0.height = int_5;
    if (squares[int_0][int_1][int_2] == null) {
      squares[int_0][int_1][int_2] = new Square(int_0, int_1, int_2);
    }

    squares[int_0][int_1][int_2].itemLayer = itemlayer_0;
  }

  public void method378(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      tile_0.wallObject = null;
    }
  }

  public void method379(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      tile_0.decorativeObject = null;
    }
  }

  public void method380(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
        final GameObject gameobject_0 = tile_0.objects[int_3];
        if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX
            && int_2 == gameobject_0.relativeY) {
          removeEntity(gameobject_0);
          return;
        }
      }

    }
  }

  public void method381(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      tile_0.groundObject = null;
    }
  }

  public void groundObjectSpawned(final int int_0, final int int_1, final int int_2,
      final int int_3,
      final Renderable renderable_0, final int int_4, final int int_5) {
    if (renderable_0 != null) {
      final GroundObject groundobject_0 = new GroundObject();
      groundobject_0.renderable = renderable_0;
      groundobject_0.x = int_1 * 128 + 64;
      groundobject_0.y = int_2 * 128 + 64;
      groundobject_0.floor = int_3;
      groundobject_0.hash = int_4;
      groundobject_0.renderInfoBitPacked = int_5;
      if (squares[int_0][int_1][int_2] == null) {
        squares[int_0][int_1][int_2] = new Square(int_0, int_1, int_2);
      }

      squares[int_0][int_1][int_2].groundObject = groundobject_0;
    }
  }

  public boolean method382(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final Renderable renderable_0, final int int_6, final int int_7,
      final int int_8) {
    if (renderable_0 == null) {
      return true;
    }
    final int int_9 = int_1 * 128 + int_4 * 64;
    final int int_10 = int_5 * 64 + int_2 * 128;
    return addEntityMarker(int_0, int_1, int_2, int_4, int_5, int_9, int_10, int_3, renderable_0,
        int_6, false,
        int_7, int_8);
  }

  public void addBoundary(final int int_0, final int int_1, final int int_2, final int int_3,
      final Renderable renderable_0, final Renderable renderable_1, final int int_4,
      final int int_5,
      final int int_6, final int int_7) {
    if (renderable_0 != null || renderable_1 != null) {
      final WallObject wallobject_0 = new WallObject();
      wallobject_0.hash = int_6;
      wallobject_0.config = int_7;
      wallobject_0.x = int_1 * 128 + 64;
      wallobject_0.y = int_2 * 128 + 64;
      wallobject_0.floor = int_3;
      wallobject_0.renderable1 = renderable_0;
      wallobject_0.renderable2 = renderable_1;
      wallobject_0.orientationA = int_4;
      wallobject_0.orientationB = int_5;

      for (int int_8 = int_0; int_8 >= 0; --int_8) {
        if (squares[int_8][int_1][int_2] == null) {
          squares[int_8][int_1][int_2] = new Square(int_8, int_1, int_2);
        }
      }

      squares[int_0][int_1][int_2].wallObject = wallobject_0;
    }
  }

  public void addBoundaryDecoration(final int int_0, final int int_1, final int int_2,
      final int int_3,
      final Renderable renderable_0, final Renderable renderable_1, final int int_4,
      final int int_5,
      final int int_6, final int int_7, final int int_8, final int int_9) {
    if (renderable_0 != null) {
      final DecorativeObject decorativeobject_0 = new DecorativeObject();
      decorativeobject_0.hash = int_8;
      decorativeobject_0.renderInfoBitPacked = int_9;
      decorativeobject_0.x = int_1 * 128 + 64;
      decorativeobject_0.y = int_2 * 128 + 64;
      decorativeobject_0.floor = int_3;
      decorativeobject_0.renderable1 = renderable_0;
      decorativeobject_0.renderable2 = renderable_1;
      decorativeobject_0.renderFlag = int_4;
      decorativeobject_0.rotation = int_5;
      decorativeobject_0.offsetX = int_6;
      decorativeobject_0.offsetY = int_7;

      for (int int_10 = int_0; int_10 >= 0; --int_10) {
        if (squares[int_10][int_1][int_2] == null) {
          squares[int_10][int_1][int_2] = new Square(int_10, int_1, int_2);
        }
      }

      squares[int_0][int_1][int_2].decorativeObject = decorativeobject_0;
    }
  }

  public void method383(final int int_0, final int int_1, final int int_2, final int int_3) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      final DecorativeObject decorativeobject_0 = tile_0.decorativeObject;
      if (decorativeobject_0 != null) {
        decorativeobject_0.offsetX = int_3 * decorativeobject_0.offsetX / 16;
        decorativeobject_0.offsetY = int_3 * decorativeobject_0.offsetY / 16;
      }
    }
  }

  public void draw(int cameraX, final int cameraY, int cameraZ, final int rx, final int ry,
      final int plane) {
    if (cameraX < 0) {
      cameraX = 0;
    } else if (cameraX >= width * 128) {
      cameraX = width * 128 - 1;
    }

    if (cameraZ < 0) {
      cameraZ = 0;
    } else if (cameraZ >= height * 128) {
      cameraZ = height * 128 - 1;
    }

    ++tick;
    rxs = Rasterizer3d.SINE[rx];
    rxc = Rasterizer3d.COSINE[rx];
    rys = Rasterizer3d.SINE[ry];
    ryc = Rasterizer3d.COSINE[ry];
    visible = sectors[(rx - 128) / 32][ry / 64];
    Scene.cameraX = cameraX;
    Scene.cameraY = cameraY;
    Scene.cameraZ = cameraZ;
    csx = cameraX / 128;
    csz = cameraZ / 128;
    Scene.plane = plane;
    lx = csx - 25;
    if (lx < 0) {
      lx = 0;
    }

    lz = csz - 25;
    if (lz < 0) {
      lz = 0;
    }

    ux = csx + 25;
    if (ux > width) {
      ux = width;
    }

    uz = csz + 25;
    if (uz > height) {
      uz = height;
    }

    updateOccluders();
    tileUpdateCount = 0;

    int int_6;
    Square[][] tiles_0;
    int int_7;
    int int_8;
    for (int p = lowerPlane; p < planes; p++) {
      Square[][] squares = this.squares[p];

      for (int x = lx; x < ux; x++) {
        for (int z = lz; z < uz; z++) {
          final Square square = squares[x][z];
          if (square == null) {
            continue;
          }

          if (square.physicalLevel <= plane
              && (visible[x - csx + 25][z - csz + 25]
              || heightmap[p][x][z] - cameraY >= 2000)) {
            square.draw = true;
            square.visible = true;
            if (square.entityCount > 0) {
              square.drawEntities = true;
            } else {
              square.drawEntities = false;
            }

            ++tileUpdateCount;
          } else {
            square.draw = false;
            square.visible = false;
            square.wallCullDirection = 0;
          }
        }
      }
    }

    int int_9;
    int int_10;
    int int_11;
    int int_12;
    Square tile_1;
    for (int p = lowerPlane; p < planes; p++) {
      Square[][] squares = this.squares[p];

      for (int dx = -25; dx <= 0; dx++) {
        int lowerX = dx + csx;
        int upperX = csx - dx;
        if (lowerX < lx && upperX >= ux) {
          continue;
        }
        for (int dz = -25; dz <= 0; dz++) {
          int lowerZ = dz + csz;
          int upperZ = csz - dz;
          if (lowerX >= lx) {
            if (lowerZ >= lz) {
              Square square = squares[lowerX][lowerZ];
              if (square != null && square.draw) {
                this.draw(square, true);
              }
            }

            if (upperZ < uz) {
              Square square = squares[lowerX][upperZ];
              if (square != null && square.draw) {
                this.draw(square, true);
              }
            }
          }

          if (upperX < ux) {
            if (lowerZ >= lz) {
              Square square = squares[upperX][lowerZ];
              if (square != null && square.draw) {
                this.draw(square, true);
              }
            }

            if (upperZ < uz) {
              Square square = squares[upperX][upperZ];
              if (square != null && square.draw) {
                this.draw(square, true);
              }
            }
          }

          if (tileUpdateCount == 0) {
            checkClick = false;
            return;
          }
        }
      }
    }

    for (int_6 = lowerPlane; int_6 < planes; int_6++) {
      Square[][] squares = this.squares[int_6];

      for (int_7 = -25; int_7 <= 0; int_7++) {
        int_8 = int_7 + csx;
        int_9 = csx - int_7;
        if (int_8 >= lx || int_9 < ux) {
          for (int_10 = -25; int_10 <= 0; int_10++) {
            int_11 = int_10 + csz;
            int_12 = csz - int_10;
            if (int_8 >= lx) {
              if (int_11 >= lz) {
                Square square = squares[int_8][int_11];
                if (square != null && square.draw) {
                  this.draw(square, false);
                }
              }

              if (int_12 < uz) {
                tile_1 = squares[int_8][int_12];
                if (tile_1 != null && tile_1.draw) {
                  this.draw(tile_1, false);
                }
              }
            }

            if (int_9 < ux) {
              if (int_11 >= lz) {
                tile_1 = squares[int_9][int_11];
                if (tile_1 != null && tile_1.draw) {
                  this.draw(tile_1, false);
                }
              }

              if (int_12 < uz) {
                Square square = squares[int_9][int_12];
                if (square != null && square.draw) {
                  this.draw(square, false);
                }
              }
            }

            if (tileUpdateCount == 0) {
              checkClick = false;
              return;
            }
          }
        }
      }
    }

    checkClick = false;
  }

  public void clearEntities() {
    for (int int_0 = 0; int_0 < entityCount; int_0++) {
      final GameObject gameobject_0 = objects[int_0];
      removeEntity(gameobject_0);
      objects[int_0] = null;
    }

    entityCount = 0;
  }

  public void applyLighting(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < planes; int_3++) {
      for (int int_4 = 0; int_4 < width; int_4++) {
        for (int int_5 = 0; int_5 < height; int_5++) {
          final Square tile_0 = squares[int_3][int_4][int_5];
          if (tile_0 != null) {
            final WallObject wallobject_0 = tile_0.wallObject;
            ModelBase modeldata_1;
            if (wallobject_0 != null && wallobject_0.renderable1 instanceof ModelBase) {
              final ModelBase modeldata_0 = (ModelBase) wallobject_0.renderable1;
              method366(modeldata_0, int_3, int_4, int_5, 1, 1);
              if (wallobject_0.renderable2 instanceof ModelBase) {
                modeldata_1 = (ModelBase) wallobject_0.renderable2;
                method366(modeldata_1, int_3, int_4, int_5, 1, 1);
                ModelBase.method1020(modeldata_0, modeldata_1, 0, 0, 0, false);
                wallobject_0.renderable2 = modeldata_1
                    .applyLighting(modeldata_1.aShort2, modeldata_1.contrast,
                        int_0, int_1, int_2);
              }

              wallobject_0.renderable1 = modeldata_0
                  .applyLighting(modeldata_0.aShort2, modeldata_0.contrast,
                      int_0, int_1, int_2);
            }

            for (int int_6 = 0; int_6 < tile_0.entityCount; int_6++) {
              final GameObject gameobject_0 = tile_0.objects[int_6];
              if (gameobject_0 != null && gameobject_0.renderable instanceof ModelBase) {
                final ModelBase modeldata_2 = (ModelBase) gameobject_0.renderable;
                method366(modeldata_2, int_3, int_4, int_5,
                    gameobject_0.offsetX - gameobject_0.relativeX + 1,
                    gameobject_0.offsetY - gameobject_0.relativeY + 1);
                gameobject_0.renderable = modeldata_2
                    .applyLighting(modeldata_2.aShort2, modeldata_2.contrast,
                        int_0, int_1, int_2);
              }
            }

            final GroundObject groundobject_0 = tile_0.groundObject;
            if (groundobject_0 != null && groundobject_0.renderable instanceof ModelBase) {
              modeldata_1 = (ModelBase) groundobject_0.renderable;
              method368(modeldata_1, int_3, int_4, int_5);
              groundobject_0.renderable = modeldata_1
                  .applyLighting(modeldata_1.aShort2, modeldata_1.contrast,
                      int_0, int_1, int_2);
            }
          }
        }
      }
    }

  }

  public void setBridge(final int int_0, final int int_1) {
    final Square tile_0 = squares[0][int_0][int_1];

    for (int int_2 = 0; int_2 < 3; int_2++) {
      final Square tile_1 = squares[int_2][int_0][int_1] = squares[int_2 + 1][int_0][int_1];
      if (tile_1 != null) {
        --tile_1.plane;

        for (int int_3 = 0; int_3 < tile_1.entityCount; int_3++) {
          final GameObject gameobject_0 = tile_1.objects[int_3];
          if ((gameobject_0.hash >> 29 & 0x3) == 2 && gameobject_0.relativeX == int_0
              && int_1 == gameobject_0.relativeY) {
            --gameobject_0.plane;
          }
        }
      }
    }

    if (squares[0][int_0][int_1] == null) {
      squares[0][int_0][int_1] = new Square(0, int_0, int_1);
    }

    squares[0][int_0][int_1].bridge = tile_0;
    squares[3][int_0][int_1] = null;
  }

  public void setPhysicalLevel(final int int_0, final int int_1, final int int_2, final int int_3) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 != null) {
      squares[int_0][int_1][int_2].physicalLevel = int_3;
    }
  }

  public WallObject method384(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    return tile_0 == null ? null : tile_0.wallObject;
  }

  public DecorativeObject method385(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    return tile_0 == null ? null : tile_0.decorativeObject;
  }

  public GameObject method386(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    if (tile_0 == null) {
      return null;
    }
    for (int int_3 = 0; int_3 < tile_0.entityCount; int_3++) {
      final GameObject gameobject_0 = tile_0.objects[int_3];
      if ((gameobject_0.hash >> 29 & 0x3) == 2 && int_1 == gameobject_0.relativeX
          && int_2 == gameobject_0.relativeY) {
        return gameobject_0;
      }
    }

    return null;
  }

  public GroundObject method387(final int int_0, final int int_1, final int int_2) {
    final Square tile_0 = squares[int_0][int_1][int_2];
    return tile_0 != null && tile_0.groundObject != null ? tile_0.groundObject : null;
  }

  public void addTile(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7, final int int_8, final int int_9,
      final int int_10,
      final int int_11, final int int_12, final int int_13, final int int_14, final int int_15,
      final int int_16,
      final int int_17, final int int_18, final int int_19) {
    SolidSquare scenetilepaint_0;
    int int_20;
    if (int_3 == 0) {
      scenetilepaint_0 = new SolidSquare(int_10, int_11, int_12, int_13, -1, int_18, false);

      for (int_20 = int_0; int_20 >= 0; --int_20) {
        if (squares[int_20][int_1][int_2] == null) {
          squares[int_20][int_1][int_2] = new Square(int_20, int_1, int_2);
        }
      }

      squares[int_0][int_1][int_2].solid = scenetilepaint_0;
    } else if (int_3 != 1) {
      final ShapedSquare scenetilemodel_0 = new ShapedSquare(int_3, int_4, int_5, int_1, int_2,
          int_6, int_7,
          int_8, int_9, int_10, int_11, int_12, int_13, int_14, int_15, int_16, int_17, int_18,
          int_19);

      for (int_20 = int_0; int_20 >= 0; --int_20) {
        if (squares[int_20][int_1][int_2] == null) {
          squares[int_20][int_1][int_2] = new Square(int_20, int_1, int_2);
        }
      }

      squares[int_0][int_1][int_2].shaped = scenetilemodel_0;
    } else {
      scenetilepaint_0 = new SolidSquare(int_14, int_15, int_16, int_17, int_5, int_19,
          int_7 == int_6 && int_6 == int_8 && int_9 == int_6);

      for (int_20 = int_0; int_20 >= 0; --int_20) {
        if (squares[int_20][int_1][int_2] == null) {
          squares[int_20][int_1][int_2] = new Square(int_20, int_1, int_2);
        }
      }

      squares[int_0][int_1][int_2].solid = scenetilepaint_0;
    }
  }

  public void method388() {
    viewportWalking = true;
  }

}
