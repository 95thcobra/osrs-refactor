package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.FaceNormal;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Renderable;

public class ModelBase extends Renderable {

  static int[] SINE;
  static int[] anIntArray138;
  static int[] COSINE;
  static int[] anIntArray140;
  static int anInt557;

  static {
    anIntArray138 = new int[10000];
    anIntArray140 = new int[10000];
    anInt557 = 0;
    SINE = Rasterizer3d.SINE;
    COSINE = Rasterizer3d.COSINE;
  }

  public short aShort2;
  public short contrast;
  boolean aBool69;
  int[] bones;

  /**
   * Vertex count.
   */
  int vertexCount;

  /**
   * Vertex spatial positions.
   */
  int[] vx;
  int[] vy;
  int[] vz;

  /**
   * Face indices.
   */
  int[] v0;
  int[] v1;
  int[] v2;

  /**
   * Computed vertex normals.
   */
  VertexNormal[] normals;

  short[] materials;

  /**
   * Face count.
   */
  int faceCount;

  int anInt558;
  int[] skins;

  /**
   * Shading directives; 0 for gouraud shading.
   */
  byte[] shading;

  /**
   * Face hue saturation lightness values (16 bit).
   */
  short[] faceHsl;

  VertexNormal[] aVertexNormalArray1;
  int anInt559;
  int anInt560;
  FaceNormal[] faceNormals;

  int[][] anIntArrayArray19;
  int anInt561;
  byte priority;
  int[][] anIntArrayArray20;
  int anInt562;
  int anInt563;
  byte[] textureCoords;
  byte[] alpha;
  byte[] textureRenderTypes;
  byte[] priorities;
  short[] t0;
  short[] t1;
  short[] t2;
  short[] aShortArray13;
  short[] aShortArray14;
  short[] aShortArray15;
  short[] aShortArray16;
  byte[] aByteArray27;
  short[] aShortArray17;
  short[] texturePrimaryColor;

  ModelBase() {
    vertexCount = 0;
    faceCount = 0;
    priority = 0;
    aBool69 = false;
  }

  public ModelBase(final ModelBase[] modeldatas_0, final int int_0) {
    vertexCount = 0;
    faceCount = 0;
    priority = 0;
    aBool69 = false;
    boolean bool_0 = false;
    boolean bool_1 = false;
    boolean bool_2 = false;
    boolean bool_3 = false;
    boolean bool_4 = false;
    boolean bool_5 = false;
    vertexCount = 0;
    faceCount = 0;
    anInt563 = 0;
    priority = -1;

    int int_1;
    ModelBase modeldata_1;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      modeldata_1 = modeldatas_0[int_1];
      if (modeldata_1 != null) {
        vertexCount += modeldata_1.vertexCount;
        faceCount += modeldata_1.faceCount;
        anInt563 += modeldata_1.anInt563;
        if (modeldata_1.priorities != null) {
          bool_1 = true;
        } else {
          if (priority == -1) {
            priority = modeldata_1.priority;
          }

          if (priority != modeldata_1.priority) {
            bool_1 = true;
          }
        }

        bool_0 |= modeldata_1.shading != null;
        bool_2 |= modeldata_1.alpha != null;
        bool_3 |= modeldata_1.skins != null;
        bool_4 |= modeldata_1.materials != null;
        bool_5 |= modeldata_1.textureCoords != null;
      }
    }

    vx = new int[vertexCount];
    vy = new int[vertexCount];
    vz = new int[vertexCount];
    bones = new int[vertexCount];
    v0 = new int[faceCount];
    v1 = new int[faceCount];
    v2 = new int[faceCount];
    if (bool_0) {
      shading = new byte[faceCount];
    }

    if (bool_1) {
      priorities = new byte[faceCount];
    }

    if (bool_2) {
      alpha = new byte[faceCount];
    }

    if (bool_3) {
      skins = new int[faceCount];
    }

    if (bool_4) {
      materials = new short[faceCount];
    }

    if (bool_5) {
      textureCoords = new byte[faceCount];
    }

    faceHsl = new short[faceCount];
    if (anInt563 > 0) {
      textureRenderTypes = new byte[anInt563];
      t0 = new short[anInt563];
      t1 = new short[anInt563];
      t2 = new short[anInt563];
      aShortArray13 = new short[anInt563];
      aShortArray14 = new short[anInt563];
      aShortArray15 = new short[anInt563];
      aShortArray16 = new short[anInt563];
      aByteArray27 = new byte[anInt563];
      aShortArray17 = new short[anInt563];
      texturePrimaryColor = new short[anInt563];
    }

    vertexCount = 0;
    faceCount = 0;
    anInt563 = 0;

    for (int_1 = 0; int_1 < int_0; int_1++) {
      modeldata_1 = modeldatas_0[int_1];
      if (modeldata_1 != null) {
        int int_2;
        for (int_2 = 0; int_2 < modeldata_1.faceCount; int_2++) {
          if (bool_0 && modeldata_1.shading != null) {
            shading[faceCount] = modeldata_1.shading[int_2];
          }

          if (bool_1) {
            if (modeldata_1.priorities != null) {
              priorities[faceCount] = modeldata_1.priorities[int_2];
            } else {
              priorities[faceCount] = modeldata_1.priority;
            }
          }

          if (bool_2 && modeldata_1.alpha != null) {
            alpha[faceCount] = modeldata_1.alpha[int_2];
          }

          if (bool_3 && modeldata_1.skins != null) {
            skins[faceCount] = modeldata_1.skins[int_2];
          }

          if (bool_4) {
            if (modeldata_1.materials != null) {
              materials[faceCount] = modeldata_1.materials[int_2];
            } else {
              materials[faceCount] = -1;
            }
          }

          if (bool_5) {
            if (modeldata_1.textureCoords != null && modeldata_1.textureCoords[int_2] != -1) {
              textureCoords[faceCount] = (byte) (anInt563
                  + modeldata_1.textureCoords[int_2]);
            } else {
              textureCoords[faceCount] = -1;
            }
          }

          faceHsl[faceCount] = modeldata_1.faceHsl[int_2];
          v0[faceCount] = appendVertex(modeldata_1,
              modeldata_1.v0[int_2]);
          v1[faceCount] = appendVertex(modeldata_1,
              modeldata_1.v1[int_2]);
          v2[faceCount] = appendVertex(modeldata_1,
              modeldata_1.v2[int_2]);
          ++faceCount;
        }

        for (int_2 = 0; int_2 < modeldata_1.anInt563; int_2++) {
          final byte byte_0 = textureRenderTypes[anInt563] = modeldata_1.textureRenderTypes[int_2];
          if (byte_0 == 0) {
            t0[anInt563] = (short) appendVertex(modeldata_1,
                modeldata_1.t0[int_2]);
            t1[anInt563] = (short) appendVertex(modeldata_1,
                modeldata_1.t1[int_2]);
            t2[anInt563] = (short) appendVertex(modeldata_1,
                modeldata_1.t2[int_2]);
          }

          if (byte_0 >= 1 && byte_0 <= 3) {
            t0[anInt563] = modeldata_1.t0[int_2];
            t1[anInt563] = modeldata_1.t1[int_2];
            t2[anInt563] = modeldata_1.t2[int_2];
            aShortArray13[anInt563] = modeldata_1.aShortArray13[int_2];
            aShortArray14[anInt563] = modeldata_1.aShortArray14[int_2];
            aShortArray15[anInt563] = modeldata_1.aShortArray15[int_2];
            aShortArray16[anInt563] = modeldata_1.aShortArray16[int_2];
            aByteArray27[anInt563] = modeldata_1.aByteArray27[int_2];
            aShortArray17[anInt563] = modeldata_1.aShortArray17[int_2];
          }

          if (byte_0 == 2) {
            texturePrimaryColor[anInt563] = modeldata_1.texturePrimaryColor[int_2];
          }

          ++anInt563;
        }
      }
    }

  }

  ModelBase(final byte[] bytes) {
    vertexCount = 0;
    faceCount = 0;
    priority = 0;
    aBool69 = false;
    if (bytes[bytes.length - 1] == -1 && bytes[bytes.length - 2] == -1) {
      decode(bytes);
    } else {
      parseLegacy(bytes);
    }
  }

  public ModelBase(final ModelBase modeldata_1, final boolean bool_0, final boolean bool_1,
      final boolean bool_2,
      final boolean bool_3) {
    vertexCount = 0;
    faceCount = 0;
    priority = 0;
    aBool69 = false;
    vertexCount = modeldata_1.vertexCount;
    faceCount = modeldata_1.faceCount;
    anInt563 = modeldata_1.anInt563;
    int int_0;
    if (bool_0) {
      vx = modeldata_1.vx;
      vy = modeldata_1.vy;
      vz = modeldata_1.vz;
    } else {
      vx = new int[vertexCount];
      vy = new int[vertexCount];
      vz = new int[vertexCount];

      for (int_0 = 0; int_0 < vertexCount; int_0++) {
        vx[int_0] = modeldata_1.vx[int_0];
        vy[int_0] = modeldata_1.vy[int_0];
        vz[int_0] = modeldata_1.vz[int_0];
      }
    }

    if (bool_1) {
      faceHsl = modeldata_1.faceHsl;
    } else {
      faceHsl = new short[faceCount];

      for (int_0 = 0; int_0 < faceCount; int_0++) {
        faceHsl[int_0] = modeldata_1.faceHsl[int_0];
      }
    }

    if (!bool_2 && modeldata_1.materials != null) {
      materials = new short[faceCount];

      for (int_0 = 0; int_0 < faceCount; int_0++) {
        materials[int_0] = modeldata_1.materials[int_0];
      }
    } else {
      materials = modeldata_1.materials;
    }

    alpha = modeldata_1.alpha;
    v0 = modeldata_1.v0;
    v1 = modeldata_1.v1;
    v2 = modeldata_1.v2;
    shading = modeldata_1.shading;
    priorities = modeldata_1.priorities;
    textureCoords = modeldata_1.textureCoords;
    priority = modeldata_1.priority;
    textureRenderTypes = modeldata_1.textureRenderTypes;
    t0 = modeldata_1.t0;
    t1 = modeldata_1.t1;
    t2 = modeldata_1.t2;
    aShortArray13 = modeldata_1.aShortArray13;
    aShortArray14 = modeldata_1.aShortArray14;
    aShortArray15 = modeldata_1.aShortArray15;
    aShortArray16 = modeldata_1.aShortArray16;
    aByteArray27 = modeldata_1.aByteArray27;
    aShortArray17 = modeldata_1.aShortArray17;
    texturePrimaryColor = modeldata_1.texturePrimaryColor;
    bones = modeldata_1.bones;
    skins = modeldata_1.skins;
    anIntArrayArray19 = modeldata_1.anIntArrayArray19;
    anIntArrayArray20 = modeldata_1.anIntArrayArray20;
    normals = modeldata_1.normals;
    faceNormals = modeldata_1.faceNormals;
    aVertexNormalArray1 = modeldata_1.aVertexNormalArray1;
    aShort2 = modeldata_1.aShort2;
    contrast = modeldata_1.contrast;
  }

  public static ModelBase decode(final AbstractPackage models, final int id, final int child) {
    final byte[] bytes = models.get(id, child);
    return bytes == null ? null : new ModelBase(bytes);
  }

  public static void method1020(final ModelBase modeldata_0, final ModelBase modeldata_1,
      final int int_0,
      final int int_1,
      final int int_2, final boolean bool_0) {
    modeldata_0.calculateDimensions();
    modeldata_0.calculateNormals();
    modeldata_1.calculateDimensions();
    modeldata_1.calculateNormals();
    ++anInt557;
    int int_3 = 0;
    final int[] ints_0 = modeldata_1.vx;
    final int int_4 = modeldata_1.vertexCount;

    int int_5;
    for (int_5 = 0; int_5 < modeldata_0.vertexCount; int_5++) {
      final VertexNormal vertexnormal_0 = modeldata_0.normals[int_5];
      if (vertexnormal_0.c != 0) {
        final int int_6 = modeldata_0.vy[int_5] - int_1;
        if (int_6 <= modeldata_1.anInt560) {
          final int int_7 = modeldata_0.vx[int_5] - int_0;
          if (int_7 >= modeldata_1.anInt558 && int_7 <= modeldata_1.anInt559) {
            final int int_8 = modeldata_0.vz[int_5] - int_2;
            if (int_8 >= modeldata_1.anInt561 && int_8 <= modeldata_1.anInt562) {
              for (int int_9 = 0; int_9 < int_4; int_9++) {
                final VertexNormal vertexnormal_1 = modeldata_1.normals[int_9];
                if (int_7 == ints_0[int_9] && int_8 == modeldata_1.vz[int_9]
                    && int_6 == modeldata_1.vy[int_9] && vertexnormal_1.c != 0) {
                  if (modeldata_0.aVertexNormalArray1 == null) {
                    modeldata_0.aVertexNormalArray1 = new VertexNormal[modeldata_0.vertexCount];
                  }

                  if (modeldata_1.aVertexNormalArray1 == null) {
                    modeldata_1.aVertexNormalArray1 = new VertexNormal[int_4];
                  }

                  VertexNormal vertexnormal_2 = modeldata_0.aVertexNormalArray1[int_5];
                  if (vertexnormal_2 == null) {
                    vertexnormal_2 = modeldata_0.aVertexNormalArray1[int_5] = new VertexNormal(
                        vertexnormal_0);
                  }

                  VertexNormal vertexnormal_3 = modeldata_1.aVertexNormalArray1[int_9];
                  if (vertexnormal_3 == null) {
                    vertexnormal_3 = modeldata_1.aVertexNormalArray1[int_9] = new VertexNormal(
                        vertexnormal_1);
                  }

                  vertexnormal_2.x += vertexnormal_1.x;
                  vertexnormal_2.y += vertexnormal_1.y;
                  vertexnormal_2.z += vertexnormal_1.z;
                  vertexnormal_2.c += vertexnormal_1.c;
                  vertexnormal_3.x += vertexnormal_0.x;
                  vertexnormal_3.y += vertexnormal_0.y;
                  vertexnormal_3.z += vertexnormal_0.z;
                  vertexnormal_3.c += vertexnormal_0.c;
                  ++int_3;
                  anIntArray138[int_5] = anInt557;
                  anIntArray140[int_9] = anInt557;
                }
              }
            }
          }
        }
      }
    }

    if (int_3 >= 3) {
      if (bool_0) {
        for (int_5 = 0; int_5 < modeldata_0.faceCount; int_5++) {
          if (anIntArray138[modeldata_0.v0[int_5]] == anInt557
              && anIntArray138[modeldata_0.v1[int_5]] == anInt557
              && anIntArray138[modeldata_0.v2[int_5]] == anInt557) {
            if (modeldata_0.shading == null) {
              modeldata_0.shading = new byte[modeldata_0.faceCount];
            }

            modeldata_0.shading[int_5] = 2;
          }
        }

        for (int_5 = 0; int_5 < modeldata_1.faceCount; int_5++) {
          if (anInt557 == anIntArray140[modeldata_1.v0[int_5]]
              && anInt557 == anIntArray140[modeldata_1.v1[int_5]]
              && anInt557 == anIntArray140[modeldata_1.v2[int_5]]) {
            if (modeldata_1.shading == null) {
              modeldata_1.shading = new byte[modeldata_1.faceCount];
            }

            modeldata_1.shading[int_5] = 2;
          }
        }

      }
    }
  }

  static int clamp(int lightness) {
    if (lightness < 2) {
      lightness = 2;
    } else if (lightness > 126) {
      lightness = 126;
    }
    return lightness;
  }

  static int lighten(final int int_0, int int_1) {
    int_1 = (int_0 & 0x7F) * int_1 >> 7;
    if (int_1 < 2) {
      int_1 = 2;
    } else if (int_1 > 126) {
      int_1 = 126;
    }

    return (int_0 & 0xFF80) + int_1;
  }

  void calculateDimensions() {
    if (!aBool69) {
      super.minimumY = 0;
      anInt560 = 0;
      anInt558 = 999999;
      anInt559 = -999999;
      anInt562 = -99999;
      anInt561 = 99999;

      for (int int_0 = 0; int_0 < vertexCount; int_0++) {
        final int int_1 = vx[int_0];
        final int int_2 = vy[int_0];
        final int int_3 = vz[int_0];
        if (int_1 < anInt558) {
          anInt558 = int_1;
        }

        if (int_1 > anInt559) {
          anInt559 = int_1;
        }

        if (int_3 < anInt561) {
          anInt561 = int_3;
        }

        if (int_3 > anInt562) {
          anInt562 = int_3;
        }

        if (-int_2 > super.minimumY) {
          super.minimumY = -int_2;
        }

        if (int_2 > anInt560) {
          anInt560 = int_2;
        }
      }

      aBool69 = true;
    }
  }

  public void calculateNormals() {
    if (normals == null) {
      normals = new VertexNormal[vertexCount];

      int int_0;
      for (int i = 0; i < vertexCount; i++) {
        normals[i] = new VertexNormal();
      }

      for (int i = 0; i < faceCount; i++) {
        final int v0 = this.v0[i];
        final int v1 = this.v1[i];
        final int v2 = this.v2[i];
        final int vx0 = this.vx[v1] - this.vx[v0];
        final int vy0 = vy[v1] - vy[v0];
        final int vz0 = vz[v1] - vz[v0];
        final int vx1 = this.vx[v2] - this.vx[v0];
        final int vy1 = vy[v2] - vy[v0];
        final int vz1 = vz[v2] - vz[v0];
        int nx = vy0 * vz1 - vy1 * vz0;
        int ny = vz0 * vx1 - vz1 * vx0;

        int nz;
        for (nz = vx0 * vy1 - vx1 * vy0;
            nx > 8192 || ny > 8192 || nz > 8192
                || nx < -8192 || ny < -8192 || nz < -8192; nz >>= 1) {
          nx >>= 1;
          ny >>= 1;
        }

        int m = (int) Math.sqrt(nx * nx + ny * ny + nz * nz);
        if (m <= 0) {
          m = 1;
        }

        nx = nx * 256 / m;
        ny = ny * 256 / m;
        nz = nz * 256 / m;

        byte shading;
        if (this.shading == null) {
          shading = 0;
        } else {
          shading = this.shading[i];
        }

        if (shading == 0) {
          VertexNormal normal = normals[v0];
          normal.x += nx;
          normal.y += ny;
          normal.z += nz;
          ++normal.c;
          normal = normals[v1];
          normal.x += nx;
          normal.y += ny;
          normal.z += nz;
          ++normal.c;
          normal = normals[v2];
          normal.x += nx;
          normal.y += ny;
          normal.z += nz;
          ++normal.c;
        } else if (shading == 1) {
          if (faceNormals == null) {
            faceNormals = new FaceNormal[faceCount];
          }

          final FaceNormal normal = faceNormals[i] = new FaceNormal();
          normal.x = nx;
          normal.y = ny;
          normal.z = nz;
        }
      }

    }
  }

  void method1007() {
    normals = null;
    aVertexNormalArray1 = null;
    faceNormals = null;
    aBool69 = false;
  }

  public void replaceColor(final short hsl, final short replace) {
    for (int i = 0; i < faceCount; i++) {
      if (faceHsl[i] == hsl) {
        faceHsl[i] = replace;
      }
    }
  }

  public ModelBase method1008() {
    final ModelBase modeldata_1 = new ModelBase();
    if (shading != null) {
      modeldata_1.shading = new byte[faceCount];

      for (int int_0 = 0; int_0 < faceCount; int_0++) {
        modeldata_1.shading[int_0] = shading[int_0];
      }
    }

    modeldata_1.vertexCount = vertexCount;
    modeldata_1.faceCount = faceCount;
    modeldata_1.anInt563 = anInt563;
    modeldata_1.vx = vx;
    modeldata_1.vy = vy;
    modeldata_1.vz = vz;
    modeldata_1.v0 = v0;
    modeldata_1.v1 = v1;
    modeldata_1.v2 = v2;
    modeldata_1.priorities = priorities;
    modeldata_1.alpha = alpha;
    modeldata_1.textureCoords = textureCoords;
    modeldata_1.faceHsl = faceHsl;
    modeldata_1.materials = materials;
    modeldata_1.priority = priority;
    modeldata_1.textureRenderTypes = textureRenderTypes;
    modeldata_1.t0 = t0;
    modeldata_1.t1 = t1;
    modeldata_1.t2 = t2;
    modeldata_1.aShortArray13 = aShortArray13;
    modeldata_1.aShortArray14 = aShortArray14;
    modeldata_1.aShortArray15 = aShortArray15;
    modeldata_1.aShortArray16 = aShortArray16;
    modeldata_1.aByteArray27 = aByteArray27;
    modeldata_1.aShortArray17 = aShortArray17;
    modeldata_1.texturePrimaryColor = texturePrimaryColor;
    modeldata_1.bones = bones;
    modeldata_1.skins = skins;
    modeldata_1.anIntArrayArray19 = anIntArrayArray19;
    modeldata_1.anIntArrayArray20 = anIntArrayArray20;
    modeldata_1.normals = normals;
    modeldata_1.faceNormals = faceNormals;
    modeldata_1.aShort2 = aShort2;
    modeldata_1.contrast = contrast;
    return modeldata_1;
  }

  public void method1009(final short short_0, final short short_1) {
    if (materials != null) {
      for (int int_0 = 0; int_0 < faceCount; int_0++) {
        if (materials[int_0] == short_0) {
          materials[int_0] = short_1;
        }
      }

    }
  }

  void parseLegacy(final byte[] bytes_0) {
    boolean bool_0 = false;
    boolean bool_1 = false;
    final Buffer buffer_0 = new Buffer(bytes_0);
    final Buffer buffer_1 = new Buffer(bytes_0);
    final Buffer buffer_2 = new Buffer(bytes_0);
    final Buffer buffer_3 = new Buffer(bytes_0);
    final Buffer buffer_4 = new Buffer(bytes_0);
    buffer_0.offset = bytes_0.length - 18;
    final int int_0 = buffer_0.getUnsignedShort();
    final int int_1 = buffer_0.getUnsignedShort();
    final int int_2 = buffer_0.getUnsignedByte();
    final int int_3 = buffer_0.getUnsignedByte();
    final int int_4 = buffer_0.getUnsignedByte();
    final int int_5 = buffer_0.getUnsignedByte();
    final int int_6 = buffer_0.getUnsignedByte();
    final int int_7 = buffer_0.getUnsignedByte();
    final int int_9 = buffer_0.getUnsignedShort();
    final int int_10 = buffer_0.getUnsignedShort();
    final int int_11 = buffer_0.getUnsignedShort();
    final int int_12 = buffer_0.getUnsignedShort();
    final byte byte_0 = 0;
    int int_34 = byte_0 + int_0;
    final int int_13 = int_34;
    int_34 += int_1;
    final int int_14 = int_34;
    if (int_4 == 255) {
      int_34 += int_1;
    }

    final int int_15 = int_34;
    if (int_6 == 1) {
      int_34 += int_1;
    }

    final int int_16 = int_34;
    if (int_3 == 1) {
      int_34 += int_1;
    }

    final int int_17 = int_34;
    if (int_7 == 1) {
      int_34 += int_0;
    }

    final int int_18 = int_34;
    if (int_5 == 1) {
      int_34 += int_1;
    }

    final int int_19 = int_34;
    int_34 += int_12;
    final int int_20 = int_34;
    int_34 += int_1 * 2;
    final int int_21 = int_34;
    int_34 += int_2 * 6;
    final int int_22 = int_34;
    int_34 += int_9;
    final int int_23 = int_34;
    int_34 += int_10;
    vertexCount = int_0;
    faceCount = int_1;
    anInt563 = int_2;
    vx = new int[int_0];
    vy = new int[int_0];
    vz = new int[int_0];
    v0 = new int[int_1];
    v1 = new int[int_1];
    v2 = new int[int_1];
    if (int_2 > 0) {
      textureRenderTypes = new byte[int_2];
      t0 = new short[int_2];
      t1 = new short[int_2];
      t2 = new short[int_2];
    }

    if (int_7 == 1) {
      bones = new int[int_0];
    }

    if (int_3 == 1) {
      shading = new byte[int_1];
      textureCoords = new byte[int_1];
      materials = new short[int_1];
    }

    if (int_4 == 255) {
      priorities = new byte[int_1];
    } else {
      priority = (byte) int_4;
    }

    if (int_5 == 1) {
      alpha = new byte[int_1];
    }

    if (int_6 == 1) {
      skins = new int[int_1];
    }

    faceHsl = new short[int_1];
    buffer_0.offset = byte_0;
    buffer_1.offset = int_22;
    buffer_2.offset = int_23;
    buffer_3.offset = int_34;
    buffer_4.offset = int_17;
    int int_24 = 0;
    int int_25 = 0;
    int int_26 = 0;

    int int_27;
    int int_28;
    int int_29;
    int int_30;
    int int_31;
    for (int_27 = 0; int_27 < int_0; int_27++) {
      int_28 = buffer_0.getUnsignedByte();
      int_29 = 0;
      if ((int_28 & 0x1) != 0) {
        int_29 = buffer_1.getSmartShort();
      }

      int_30 = 0;
      if ((int_28 & 0x2) != 0) {
        int_30 = buffer_2.getSmartShort();
      }

      int_31 = 0;
      if ((int_28 & 0x4) != 0) {
        int_31 = buffer_3.getSmartShort();
      }

      vx[int_27] = int_24 + int_29;
      vy[int_27] = int_25 + int_30;
      vz[int_27] = int_26 + int_31;
      int_24 = vx[int_27];
      int_25 = vy[int_27];
      int_26 = vz[int_27];
      if (int_7 == 1) {
        bones[int_27] = buffer_4.getUnsignedByte();
      }
    }

    buffer_0.offset = int_20;
    buffer_1.offset = int_16;
    buffer_2.offset = int_14;
    buffer_3.offset = int_18;
    buffer_4.offset = int_15;

    for (int_27 = 0; int_27 < int_1; int_27++) {
      faceHsl[int_27] = (short) buffer_0.getUnsignedShort();
      if (int_3 == 1) {
        int_28 = buffer_1.getUnsignedByte();
        if ((int_28 & 0x1) == 1) {
          shading[int_27] = 1;
          bool_0 = true;
        } else {
          shading[int_27] = 0;
        }

        if ((int_28 & 0x2) == 2) {
          textureCoords[int_27] = (byte) (int_28 >> 2);
          materials[int_27] = faceHsl[int_27];
          faceHsl[int_27] = 127;
          if (materials[int_27] != -1) {
            bool_1 = true;
          }
        } else {
          textureCoords[int_27] = -1;
          materials[int_27] = -1;
        }
      }

      if (int_4 == 255) {
        priorities[int_27] = buffer_2.getByte();
      }

      if (int_5 == 1) {
        alpha[int_27] = buffer_3.getByte();
      }

      if (int_6 == 1) {
        skins[int_27] = buffer_4.getUnsignedByte();
      }
    }

    buffer_0.offset = int_19;
    buffer_1.offset = int_13;
    int_27 = 0;
    int_28 = 0;
    int_29 = 0;
    int_30 = 0;

    int int_32;
    int int_33;
    for (int_31 = 0; int_31 < int_1; int_31++) {
      int_32 = buffer_1.getUnsignedByte();
      if (int_32 == 1) {
        int_27 = buffer_0.getSmartShort() + int_30;
        int_28 = buffer_0.getSmartShort() + int_27;
        int_29 = buffer_0.getSmartShort() + int_28;
        int_30 = int_29;
        v0[int_31] = int_27;
        v1[int_31] = int_28;
        v2[int_31] = int_29;
      }

      if (int_32 == 2) {
        int_28 = int_29;
        int_29 = buffer_0.getSmartShort() + int_30;
        int_30 = int_29;
        v0[int_31] = int_27;
        v1[int_31] = int_28;
        v2[int_31] = int_29;
      }

      if (int_32 == 3) {
        int_27 = int_29;
        int_29 = buffer_0.getSmartShort() + int_30;
        int_30 = int_29;
        v0[int_31] = int_27;
        v1[int_31] = int_28;
        v2[int_31] = int_29;
      }

      if (int_32 == 4) {
        int_33 = int_27;
        int_27 = int_28;
        int_28 = int_33;
        int_29 = buffer_0.getSmartShort() + int_30;
        int_30 = int_29;
        v0[int_31] = int_27;
        v1[int_31] = int_33;
        v2[int_31] = int_29;
      }
    }

    buffer_0.offset = int_21;

    for (int_31 = 0; int_31 < int_2; int_31++) {
      textureRenderTypes[int_31] = 0;
      t0[int_31] = (short) buffer_0.getUnsignedShort();
      t1[int_31] = (short) buffer_0.getUnsignedShort();
      t2[int_31] = (short) buffer_0.getUnsignedShort();
    }

    if (textureCoords != null) {
      boolean bool_2 = false;

      for (int_32 = 0; int_32 < int_1; int_32++) {
        int_33 = textureCoords[int_32] & 0xFF;
        if (int_33 != 255) {
          if (v0[int_32] == (t0[int_33] & 0xFFFF)
              && v1[int_32] == (t1[int_33] & 0xFFFF)
              && v2[int_32] == (t2[int_33] & 0xFFFF)) {
            textureCoords[int_32] = -1;
          } else {
            bool_2 = true;
          }
        }
      }

      if (!bool_2) {
        textureCoords = null;
      }
    }

    if (!bool_1) {
      materials = null;
    }

    if (!bool_0) {
      shading = null;
    }

  }

  public void method1010(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < vertexCount; int_3++) {
      vx[int_3] = vx[int_3] * int_0 / 128;
      vy[int_3] = int_1 * vy[int_3] / 128;
      vz[int_3] = int_2 * vz[int_3] / 128;
    }

    method1007();
  }

  void decode(final byte[] bytes_0) {
    final Buffer buffer_0 = new Buffer(bytes_0);
    final Buffer buffer_1 = new Buffer(bytes_0);
    final Buffer buffer_2 = new Buffer(bytes_0);
    final Buffer buffer_3 = new Buffer(bytes_0);
    final Buffer buffer_4 = new Buffer(bytes_0);
    final Buffer buffer_5 = new Buffer(bytes_0);
    final Buffer buffer_6 = new Buffer(bytes_0);
    buffer_0.offset = bytes_0.length - 23;
    final int int_0 = buffer_0.getUnsignedShort();
    final int int_1 = buffer_0.getUnsignedShort();
    final int int_2 = buffer_0.getUnsignedByte();
    final int int_3 = buffer_0.getUnsignedByte();
    final int int_4 = buffer_0.getUnsignedByte();
    final int int_5 = buffer_0.getUnsignedByte();
    final int int_6 = buffer_0.getUnsignedByte();
    final int int_7 = buffer_0.getUnsignedByte();
    final int int_8 = buffer_0.getUnsignedByte();
    final int int_9 = buffer_0.getUnsignedShort();
    final int int_10 = buffer_0.getUnsignedShort();
    final int int_11 = buffer_0.getUnsignedShort();
    final int int_12 = buffer_0.getUnsignedShort();
    final int int_13 = buffer_0.getUnsignedShort();
    int int_14 = 0;
    int int_15 = 0;
    int int_16 = 0;
    int int_17;
    if (int_2 > 0) {
      textureRenderTypes = new byte[int_2];
      buffer_0.offset = 0;

      for (int_17 = 0; int_17 < int_2; int_17++) {
        final byte byte_0 = textureRenderTypes[int_17] = buffer_0.getByte();
        if (byte_0 == 0) {
          ++int_14;
        }

        if (byte_0 >= 1 && byte_0 <= 3) {
          ++int_15;
        }

        if (byte_0 == 2) {
          ++int_16;
        }
      }
    }

    int_17 = int_2 + int_0;
    final int int_18 = int_17;
    if (int_3 == 1) {
      int_17 += int_1;
    }

    final int int_19 = int_17;
    int_17 += int_1;
    final int int_20 = int_17;
    if (int_4 == 255) {
      int_17 += int_1;
    }

    final int int_21 = int_17;
    if (int_6 == 1) {
      int_17 += int_1;
    }

    final int int_22 = int_17;
    if (int_8 == 1) {
      int_17 += int_0;
    }

    final int int_23 = int_17;
    if (int_5 == 1) {
      int_17 += int_1;
    }

    final int int_24 = int_17;
    int_17 += int_12;
    final int int_25 = int_17;
    if (int_7 == 1) {
      int_17 += int_1 * 2;
    }

    final int int_26 = int_17;
    int_17 += int_13;
    final int int_27 = int_17;
    int_17 += int_1 * 2;
    final int int_28 = int_17;
    int_17 += int_9;
    final int int_29 = int_17;
    int_17 += int_10;
    final int int_30 = int_17;
    int_17 += int_11;
    final int int_31 = int_17;
    int_17 += int_14 * 6;
    final int int_32 = int_17;
    int_17 += int_15 * 6;
    final int int_33 = int_17;
    int_17 += int_15 * 6;
    final int int_34 = int_17;
    int_17 += int_15 * 2;
    final int int_35 = int_17;
    int_17 += int_15;
    final int int_36 = int_17;
    int_17 += int_15 * 2 + int_16 * 2;
    vertexCount = int_0;
    faceCount = int_1;
    anInt563 = int_2;
    vx = new int[int_0];
    vy = new int[int_0];
    vz = new int[int_0];
    v0 = new int[int_1];
    v1 = new int[int_1];
    v2 = new int[int_1];
    if (int_8 == 1) {
      bones = new int[int_0];
    }

    if (int_3 == 1) {
      shading = new byte[int_1];
    }

    if (int_4 == 255) {
      priorities = new byte[int_1];
    } else {
      priority = (byte) int_4;
    }

    if (int_5 == 1) {
      alpha = new byte[int_1];
    }

    if (int_6 == 1) {
      skins = new int[int_1];
    }

    if (int_7 == 1) {
      materials = new short[int_1];
    }

    if (int_7 == 1 && int_2 > 0) {
      textureCoords = new byte[int_1];
    }

    faceHsl = new short[int_1];
    if (int_2 > 0) {
      t0 = new short[int_2];
      t1 = new short[int_2];
      t2 = new short[int_2];
      if (int_15 > 0) {
        aShortArray13 = new short[int_15];
        aShortArray14 = new short[int_15];
        aShortArray15 = new short[int_15];
        aShortArray16 = new short[int_15];
        aByteArray27 = new byte[int_15];
        aShortArray17 = new short[int_15];
      }

      if (int_16 > 0) {
        texturePrimaryColor = new short[int_16];
      }
    }

    buffer_0.offset = int_2;
    buffer_1.offset = int_28;
    buffer_2.offset = int_29;
    buffer_3.offset = int_30;
    buffer_4.offset = int_22;
    int int_37 = 0;
    int int_38 = 0;
    int int_39 = 0;

    int int_40;
    int int_41;
    int int_42;
    int int_43;
    int int_44;
    for (int_40 = 0; int_40 < int_0; int_40++) {
      int_41 = buffer_0.getUnsignedByte();
      int_42 = 0;
      if ((int_41 & 0x1) != 0) {
        int_42 = buffer_1.getSmartShort();
      }

      int_43 = 0;
      if ((int_41 & 0x2) != 0) {
        int_43 = buffer_2.getSmartShort();
      }

      int_44 = 0;
      if ((int_41 & 0x4) != 0) {
        int_44 = buffer_3.getSmartShort();
      }

      vx[int_40] = int_37 + int_42;
      vy[int_40] = int_38 + int_43;
      vz[int_40] = int_39 + int_44;
      int_37 = vx[int_40];
      int_38 = vy[int_40];
      int_39 = vz[int_40];
      if (int_8 == 1) {
        bones[int_40] = buffer_4.getUnsignedByte();
      }
    }

    buffer_0.offset = int_27;
    buffer_1.offset = int_18;
    buffer_2.offset = int_20;
    buffer_3.offset = int_23;
    buffer_4.offset = int_21;
    buffer_5.offset = int_25;
    buffer_6.offset = int_26;

    for (int_40 = 0; int_40 < int_1; int_40++) {
      faceHsl[int_40] = (short) buffer_0.getUnsignedShort();
      if (int_3 == 1) {
        shading[int_40] = buffer_1.getByte();
      }

      if (int_4 == 255) {
        priorities[int_40] = buffer_2.getByte();
      }

      if (int_5 == 1) {
        alpha[int_40] = buffer_3.getByte();
      }

      if (int_6 == 1) {
        skins[int_40] = buffer_4.getUnsignedByte();
      }

      if (int_7 == 1) {
        materials[int_40] = (short) (buffer_5.getUnsignedShort() - 1);
      }

      if (textureCoords != null && materials[int_40] != -1) {
        textureCoords[int_40] = (byte) (buffer_6.getUnsignedByte() - 1);
      }
    }

    buffer_0.offset = int_24;
    buffer_1.offset = int_19;
    int_40 = 0;
    int_41 = 0;
    int_42 = 0;
    int_43 = 0;

    int int_45;
    for (int_44 = 0; int_44 < int_1; int_44++) {
      int_45 = buffer_1.getUnsignedByte();
      if (int_45 == 1) {
        int_40 = buffer_0.getSmartShort() + int_43;
        int_41 = buffer_0.getSmartShort() + int_40;
        int_42 = buffer_0.getSmartShort() + int_41;
        int_43 = int_42;
        v0[int_44] = int_40;
        v1[int_44] = int_41;
        v2[int_44] = int_42;
      }

      if (int_45 == 2) {
        int_41 = int_42;
        int_42 = buffer_0.getSmartShort() + int_43;
        int_43 = int_42;
        v0[int_44] = int_40;
        v1[int_44] = int_41;
        v2[int_44] = int_42;
      }

      if (int_45 == 3) {
        int_40 = int_42;
        int_42 = buffer_0.getSmartShort() + int_43;
        int_43 = int_42;
        v0[int_44] = int_40;
        v1[int_44] = int_41;
        v2[int_44] = int_42;
      }

      if (int_45 == 4) {
        final int int_46 = int_40;
        int_40 = int_41;
        int_41 = int_46;
        int_42 = buffer_0.getSmartShort() + int_43;
        int_43 = int_42;
        v0[int_44] = int_40;
        v1[int_44] = int_46;
        v2[int_44] = int_42;
      }
    }

    buffer_0.offset = int_31;
    buffer_1.offset = int_32;
    buffer_2.offset = int_33;
    buffer_3.offset = int_34;
    buffer_4.offset = int_35;
    buffer_5.offset = int_36;

    for (int_44 = 0; int_44 < int_2; int_44++) {
      int_45 = textureRenderTypes[int_44] & 0xFF;
      if (int_45 == 0) {
        t0[int_44] = (short) buffer_0.getUnsignedShort();
        t1[int_44] = (short) buffer_0.getUnsignedShort();
        t2[int_44] = (short) buffer_0.getUnsignedShort();
      }

      if (int_45 == 1) {
        t0[int_44] = (short) buffer_1.getUnsignedShort();
        t1[int_44] = (short) buffer_1.getUnsignedShort();
        t2[int_44] = (short) buffer_1.getUnsignedShort();
        aShortArray13[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray14[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray15[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray16[int_44] = (short) buffer_3.getUnsignedShort();
        aByteArray27[int_44] = buffer_4.getByte();
        aShortArray17[int_44] = (short) buffer_5.getUnsignedShort();
      }

      if (int_45 == 2) {
        t0[int_44] = (short) buffer_1.getUnsignedShort();
        t1[int_44] = (short) buffer_1.getUnsignedShort();
        t2[int_44] = (short) buffer_1.getUnsignedShort();
        aShortArray13[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray14[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray15[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray16[int_44] = (short) buffer_3.getUnsignedShort();
        aByteArray27[int_44] = buffer_4.getByte();
        aShortArray17[int_44] = (short) buffer_5.getUnsignedShort();
        texturePrimaryColor[int_44] = (short) buffer_5.getUnsignedShort();
      }

      if (int_45 == 3) {
        t0[int_44] = (short) buffer_1.getUnsignedShort();
        t1[int_44] = (short) buffer_1.getUnsignedShort();
        t2[int_44] = (short) buffer_1.getUnsignedShort();
        aShortArray13[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray14[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray15[int_44] = (short) buffer_2.getUnsignedShort();
        aShortArray16[int_44] = (short) buffer_3.getUnsignedShort();
        aByteArray27[int_44] = buffer_4.getByte();
        aShortArray17[int_44] = (short) buffer_5.getUnsignedShort();
      }
    }

    buffer_0.offset = int_17;
    int_44 = buffer_0.getUnsignedByte();
    if (int_44 != 0) {
      new Class57();
      buffer_0.getUnsignedShort();
      buffer_0.getUnsignedShort();
      buffer_0.getUnsignedShort();
      buffer_0.getInt();
    }

  }

  public final Model applyLighting(final int ambient, final int attenuation,
      final int lx, final int ly, final int lz) {
    calculateNormals();
    final int mag = (int) Math.sqrt(lx * lx + ly * ly + lz * lz);
    final int att = mag * attenuation >> 8;
    final Model model = new Model();
    model.hsl0 = new int[faceCount];
    model.hsl1 = new int[faceCount];
    model.hsl2 = new int[faceCount];
    if (anInt563 > 0 && textureCoords != null) {
      final int[] ints_0 = new int[anInt563];

      int int_7;
      for (int_7 = 0; int_7 < faceCount; int_7++) {
        if (textureCoords[int_7] != -1) {
          ++ints_0[textureCoords[int_7] & 0xFF];
        }
      }

      model.anInt548 = 0;

      for (int_7 = 0; int_7 < anInt563; int_7++) {
        if (ints_0[int_7] > 0 && textureRenderTypes[int_7] == 0) {
          ++model.anInt548;
        }
      }

      model.t0 = new int[model.anInt548];
      model.t1 = new int[model.anInt548];
      model.t2 = new int[model.anInt548];
      int_7 = 0;

      int int_9;
      for (int_9 = 0; int_9 < anInt563; int_9++) {
        if (ints_0[int_9] > 0 && textureRenderTypes[int_9] == 0) {
          model.t0[int_7] = t0[int_9] & 0xFFFF;
          model.t1[int_7] = t1[int_9] & 0xFFFF;
          model.t2[int_7] = t2[int_9] & 0xFFFF;
          ints_0[int_9] = int_7++;
        } else {
          ints_0[int_9] = -1;
        }
      }

      model.ti = new byte[faceCount];

      for (int_9 = 0; int_9 < faceCount; int_9++) {
        if (textureCoords[int_9] != -1) {
          model.ti[int_9] = (byte) ints_0[textureCoords[int_9] & 0xFF];
        } else {
          model.ti[int_9] = -1;
        }
      }
    }

    for (int i = 0; i < faceCount; i++) {
      byte shading;
      if (this.shading == null) {
        shading = 0;
      } else {
        shading = this.shading[i];
      }

      byte alpha;
      if (this.alpha == null) {
        alpha = 0;
      } else {
        alpha = this.alpha[i];
      }

      short material;
      if (materials == null) {
        material = -1;
      } else {
        material = materials[i];
      }

      if (alpha == -2) {
        shading = 3;
      }

      if (alpha == -1) {
        shading = 2;
      }

      VertexNormal vertexNormal;
      int int_11;
      FaceNormal facenormal_0;
      if (material == -1) {

        // Apply for each vertex.
        if (shading == 0) {
          final int hsl = faceHsl[i] & 0xFFFF;
          if (aVertexNormalArray1 != null && aVertexNormalArray1[v0[i]] != null) {
            vertexNormal = aVertexNormalArray1[v0[i]];
          } else {
            vertexNormal = normals[v0[i]];
          }

          int lightness = ambient
              + (ly * vertexNormal.y + lz * vertexNormal.z + lx * vertexNormal.x)
                  / (att * vertexNormal.c);
          model.hsl0[i] = lighten(hsl, lightness);
          if (aVertexNormalArray1 != null && aVertexNormalArray1[v1[i]]
              != null) {
            vertexNormal = aVertexNormalArray1[v1[i]];
          } else {
            vertexNormal = normals[v1[i]];
          }

          lightness = ambient
              + (lx * vertexNormal.x + ly * vertexNormal.y + lz * vertexNormal.z)
                  / (att * vertexNormal.c);
          model.hsl1[i] = lighten(hsl, lightness);
          if (aVertexNormalArray1 != null && aVertexNormalArray1[v2[i]]
              != null) {
            vertexNormal = aVertexNormalArray1[v2[i]];
          } else {
            vertexNormal = normals[v2[i]];
          }

          lightness = ambient
              + (lx * vertexNormal.x + ly * vertexNormal.y + lz * vertexNormal.z)
                  / (att * vertexNormal.c);
          model.hsl2[i] = lighten(hsl, lightness);
        } else if (shading == 1) {
          FaceNormal normal = faceNormals[i];
          int lightness = ambient + (lx * normal.x + ly * normal.y + lz * normal.z)
              / (att / 2 + att);
          model.hsl0[i] = lighten(faceHsl[i] & 0xFFFF, lightness);
          model.hsl2[i] = -1;
        } else if (shading == 3) {
          model.hsl0[i] = 128;
          model.hsl2[i] = -1;
        } else {
          model.hsl2[i] = -2;
        }
      } else if (shading == 0) {
        if (aVertexNormalArray1 != null && aVertexNormalArray1[v0[i]]
            != null) {
          vertexNormal = aVertexNormalArray1[v0[i]];
        } else {
          vertexNormal = normals[v0[i]];
        }

        int lightness =
            (lx * vertexNormal.x + ly * vertexNormal.y + lz * vertexNormal.z)
                / (att * vertexNormal.c) + ambient;
        model.hsl0[i] = clamp(lightness);
        if (aVertexNormalArray1 != null && aVertexNormalArray1[v1[i]]
            != null) {
          vertexNormal = aVertexNormalArray1[v1[i]];
        } else {
          vertexNormal = normals[v1[i]];
        }

        lightness = ambient + (lx * vertexNormal.x + ly * vertexNormal.y + lz * vertexNormal.z)
            / (att * vertexNormal.c);
        model.hsl1[i] = clamp(lightness);
        if (aVertexNormalArray1 != null && aVertexNormalArray1[v2[i]]
            != null) {
          vertexNormal = aVertexNormalArray1[v2[i]];
        } else {
          vertexNormal = normals[v2[i]];
        }

        lightness = ambient + (lx * vertexNormal.x + ly * vertexNormal.y + lz * vertexNormal.z)
            / (att * vertexNormal.c);
        model.hsl2[i] = clamp(lightness);
      } else if (shading == 1) {
        facenormal_0 = faceNormals[i];
        int_11 = ambient + (ly * facenormal_0.y + lz * facenormal_0.z + lx * facenormal_0.x)
            / (att / 2 + att);
        model.hsl0[i] = clamp(int_11);
        model.hsl2[i] = -1;
      } else {
        model.hsl2[i] = -2;
      }
    }

    calculateBonesAndSkins();
    model.vc = vertexCount;
    model.vx = vx;
    model.vy = vy;
    model.vz = vz;
    model.fc = faceCount;
    model.v0 = v0;
    model.v1 = v1;
    model.v2 = v2;
    model.priorities = priorities;
    model.alpha = alpha;
    model.aByte5 = priority;
    model.anIntArrayArray17 = anIntArrayArray19;
    model.anIntArrayArray18 = anIntArrayArray20;
    model.materials = materials;
    return model;
  }

  public void method1011(final int int_0, final int int_1, final int int_2) {
    for (int int_3 = 0; int_3 < vertexCount; int_3++) {
      vx[int_3] += int_0;
      vy[int_3] += int_1;
      vz[int_3] += int_2;
    }

    method1007();
  }

  public ModelBase method1012(final int[][] ints_0, final int int_0, final int int_1,
      final int int_2,
      final boolean bool_0, final int int_3) {
    calculateDimensions();
    int int_4 = int_0 + anInt558;
    int int_5 = int_0 + anInt559;
    int int_6 = int_2 + anInt561;
    int int_7 = int_2 + anInt562;
    if (int_4 >= 0 && int_5 + 128 >> 7 < ints_0.length && int_6 >= 0
        && int_7 + 128 >> 7 < ints_0[0].length) {
      int_4 >>= 7;
      int_5 = int_5 + 127 >> 7;
      int_6 >>= 7;
      int_7 = int_7 + 127 >> 7;
      if (int_1 == ints_0[int_4][int_6] && int_1 == ints_0[int_5][int_6] && int_1
          == ints_0[int_4][int_7]
          && int_1 == ints_0[int_5][int_7]) {
        return this;
      }
      final ModelBase modeldata_1 = new ModelBase();
      modeldata_1.vertexCount = vertexCount;
      modeldata_1.faceCount = faceCount;
      modeldata_1.anInt563 = anInt563;
      modeldata_1.vx = vx;
      modeldata_1.vz = vz;
      modeldata_1.v0 = v0;
      modeldata_1.v1 = v1;
      modeldata_1.v2 = v2;
      modeldata_1.shading = shading;
      modeldata_1.priorities = priorities;
      modeldata_1.alpha = alpha;
      modeldata_1.textureCoords = textureCoords;
      modeldata_1.faceHsl = faceHsl;
      modeldata_1.materials = materials;
      modeldata_1.priority = priority;
      modeldata_1.textureRenderTypes = textureRenderTypes;
      modeldata_1.t0 = t0;
      modeldata_1.t1 = t1;
      modeldata_1.t2 = t2;
      modeldata_1.aShortArray13 = aShortArray13;
      modeldata_1.aShortArray14 = aShortArray14;
      modeldata_1.aShortArray15 = aShortArray15;
      modeldata_1.aShortArray16 = aShortArray16;
      modeldata_1.aByteArray27 = aByteArray27;
      modeldata_1.aShortArray17 = aShortArray17;
      modeldata_1.texturePrimaryColor = texturePrimaryColor;
      modeldata_1.bones = bones;
      modeldata_1.skins = skins;
      modeldata_1.anIntArrayArray19 = anIntArrayArray19;
      modeldata_1.anIntArrayArray20 = anIntArrayArray20;
      modeldata_1.aShort2 = aShort2;
      modeldata_1.contrast = contrast;
      modeldata_1.vy = new int[modeldata_1.vertexCount];
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      int int_12;
      int int_13;
      int int_14;
      int int_15;
      int int_16;
      int int_17;
      if (int_3 == 0) {
        for (int_8 = 0; int_8 < modeldata_1.vertexCount; int_8++) {
          int_9 = int_0 + vx[int_8];
          int_10 = int_2 + vz[int_8];
          int_11 = int_9 & 0x7F;
          int_12 = int_10 & 0x7F;
          int_13 = int_9 >> 7;
          int_14 = int_10 >> 7;
          int_15 = ints_0[int_13][int_14] * (128 - int_11)
              + ints_0[int_13 + 1][int_14] * int_11 >> 7;
          int_16 = ints_0[int_13][int_14 + 1] * (128 - int_11)
              + ints_0[int_13 + 1][int_14 + 1] * int_11 >> 7;
          int_17 = int_15 * (128 - int_12) + int_16 * int_12 >> 7;
          modeldata_1.vy[int_8] = int_17 + vy[int_8] - int_1;
        }
      } else {
        for (int_8 = 0; int_8 < modeldata_1.vertexCount; int_8++) {
          int_9 = (-vy[int_8] << 16) / super.minimumY;
          if (int_9 < int_3) {
            int_10 = int_0 + vx[int_8];
            int_11 = int_2 + vz[int_8];
            int_12 = int_10 & 0x7F;
            int_13 = int_11 & 0x7F;
            int_14 = int_10 >> 7;
            int_15 = int_11 >> 7;
            int_16 = ints_0[int_14][int_15] * (128 - int_12)
                + ints_0[int_14 + 1][int_15] * int_12 >> 7;
            int_17 = ints_0[int_14][int_15 + 1] * (128 - int_12)
                + int_12 * ints_0[int_14 + 1][int_15 + 1] >> 7;
            final int int_18 = int_16 * (128 - int_13) + int_17 * int_13 >> 7;
            modeldata_1.vy[int_8] = (int_3 - int_9) * (int_18 - int_1) / int_3
                + vy[int_8];
          }
        }
      }

      modeldata_1.method1007();
      return modeldata_1;
    }
    return this;
  }

  void calculateBonesAndSkins() {
    int[] ints_0;
    int int_0;
    int int_1;
    int int_2;
    if (bones != null) {
      ints_0 = new int[256];
      int_0 = 0;

      for (int_1 = 0; int_1 < vertexCount; int_1++) {
        int_2 = bones[int_1];
        ++ints_0[int_2];
        if (int_2 > int_0) {
          int_0 = int_2;
        }
      }

      anIntArrayArray19 = new int[int_0 + 1][];

      for (int_1 = 0; int_1 <= int_0; int_1++) {
        anIntArrayArray19[int_1] = new int[ints_0[int_1]];
        ints_0[int_1] = 0;
      }

      for (int_1 = 0; int_1 < vertexCount; anIntArrayArray19[int_2][ints_0[int_2]++] = int_1++) {
        int_2 = bones[int_1];
      }

      bones = null;
    }

    if (skins != null) {
      ints_0 = new int[256];
      int_0 = 0;

      for (int_1 = 0; int_1 < faceCount; int_1++) {
        int_2 = skins[int_1];
        ++ints_0[int_2];
        if (int_2 > int_0) {
          int_0 = int_2;
        }
      }

      anIntArrayArray20 = new int[int_0 + 1][];

      for (int_1 = 0; int_1 <= int_0; int_1++) {
        anIntArrayArray20[int_1] = new int[ints_0[int_1]];
        ints_0[int_1] = 0;
      }

      for (int_1 = 0; int_1 < faceCount;
          anIntArrayArray20[int_2][ints_0[int_2]++] = int_1++) {
        int_2 = skins[int_1];
      }

      skins = null;
    }

  }

  public void method1013() {
    int int_0;
    for (int_0 = 0; int_0 < vertexCount; int_0++) {
      vz[int_0] = -vz[int_0];
    }

    for (int_0 = 0; int_0 < faceCount; int_0++) {
      final int int_1 = v0[int_0];
      v0[int_0] = v2[int_0];
      v2[int_0] = int_1;
    }

    method1007();
  }

  public void method1014(final int int_0) {
    final int int_1 = SINE[int_0];
    final int int_2 = COSINE[int_0];

    for (int int_3 = 0; int_3 < vertexCount; int_3++) {
      final int int_4 = int_1 * vz[int_3] + int_2 * vx[int_3] >> 16;
      vz[int_3] = int_2 * vz[int_3] - int_1 * vx[int_3] >> 16;
      vx[int_3] = int_4;
    }

    method1007();
  }

  public void method1015() {
    for (int int_0 = 0; int_0 < vertexCount; int_0++) {
      final int int_1 = vx[int_0];
      vx[int_0] = vz[int_0];
      vz[int_0] = -int_1;
    }

    method1007();
  }

  public void method1016() {
    for (int int_0 = 0; int_0 < vertexCount; int_0++) {
      vx[int_0] = -vx[int_0];
      vz[int_0] = -vz[int_0];
    }

    method1007();
  }

  public void method1017() {
    for (int int_0 = 0; int_0 < vertexCount; int_0++) {
      final int int_1 = vz[int_0];
      vz[int_0] = vx[int_0];
      vx[int_0] = -int_1;
    }

    method1007();
  }

  final int appendVertex(final ModelBase modeldata_1, final int i) {
    int n = -1;
    final int int_2 = modeldata_1.vx[i];
    final int int_3 = modeldata_1.vy[i];
    final int int_4 = modeldata_1.vz[i];

    for (int int_5 = 0; int_5 < vertexCount; int_5++) {
      if (int_2 == vx[int_5] && int_3 == vy[int_5] && int_4 == vz[int_5]) {
        n = int_5;
        break;
      }
    }

    if (n == -1) {
      vx[vertexCount] = int_2;
      vy[vertexCount] = int_3;
      vz[vertexCount] = int_4;
      if (modeldata_1.bones != null) {
        bones[vertexCount] = modeldata_1.bones[i];
      }

      n = vertexCount++;
    }

    return n;
  }

}
