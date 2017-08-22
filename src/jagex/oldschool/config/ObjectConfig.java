package jagex.oldschool.config;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.ChatLineBuffer;
import jagex.oldschool.Class10;
import jagex.oldschool.Class2;
import jagex.oldschool.Class85;
import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.asset.RemoteRequest;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.PrimitiveType;

public class ObjectConfig extends Subnode {

  public static boolean aBool54;
  public static AbstractPackage anIndexDataBase21;
  public static AbstractPackage objects_ref;
  public static Cache aNodeCache9;
  public static Cache objects;
  public static Cache aNodeCache8;
  public static Cache cachedModels;
  static ModelBase[] aModelDataArray1;

  static {
    aBool54 = false;
    objects = new Cache(4096);
    aNodeCache9 = new Cache(500);
    cachedModels = new Cache(30);
    aNodeCache8 = new Cache(30);
    aModelDataArray1 = new ModelBase[4];
  }

  public int anInt454;
  public int[] impostorIds;
  public int ambientSoundId;
  public int anInt455;
  public String name;
  public int id;
  public int mapIconId;
  public int[] anIntArray101;
  public int sizeX;
  public int interactType;
  public int sizeY;
  public String[] actions;
  public boolean aBool55;
  public int anInt456;
  public int anInt457;
  public boolean modelClipped;
  public int anInt458;
  public int animationId;
  public int anInt459;
  public boolean clipped;
  public int mapSceneId;
  public boolean aBool56;
  IterableHashTable anIterableHashTable2;
  int varpId;
  int[] objectModels;
  int[] objectTypes;
  int configId;
  boolean isRotated;
  boolean nonFlatShading;
  int clipType;
  int ambient;
  int contrast;
  public boolean isSolid;
  int modelSizeX;
  int modelSizeHeight;
  int modelSizeY;
  short[] recolorToFind;
  short[] textureToFind;
  short[] recolorToReplace;
  int offsetX;
  short[] textureToReplace;
  int offsetHeight;
  int offsetY;

  public ObjectConfig() {
    name = "null";
    sizeX = 1;
    sizeY = 1;
    interactType = 2;
    aBool55 = true;
    anInt454 = -1;
    clipType = -1;
    nonFlatShading = false;
    modelClipped = false;
    animationId = -1;
    anInt459 = 16;
    ambient = 0;
    contrast = 0;
    actions = new String[5];
    mapIconId = -1;
    mapSceneId = -1;
    isRotated = false;
    clipped = true;
    modelSizeX = 128;
    modelSizeHeight = 128;
    modelSizeY = 128;
    offsetX = 0;
    offsetHeight = 0;
    offsetY = 0;
    aBool56 = false;
    isSolid = false;
    anInt455 = -1;
    varpId = -1;
    configId = -1;
    ambientSoundId = -1;
    anInt456 = 0;
    anInt457 = 0;
    anInt458 = 0;
  }

  public final ObjectConfig getImpostor() {
    int int_0 = -1;
    if (varpId != -1) {
      int_0 = PrimitiveType.method629(varpId);
    } else if (configId != -1) {
      int_0 = Class85.widgetSettings[configId];
    }

    int int_1;
    if (int_0 >= 0 && int_0 < impostorIds.length - 1) {
      int_1 = impostorIds[int_0];
    } else {
      int_1 = impostorIds[impostorIds.length - 1];
    }

    return int_1 != -1 ? Class2.getObjectDefinition(int_1) : null;
  }

  void loadData(final Buffer buffer_0, final int int_0) {
    int int_1;
    int int_2;
    if (int_0 == 1) {
      int_1 = buffer_0.getUnsignedByte();
      if (int_1 > 0) {
        if (objectModels == null || aBool54) {
          objectTypes = new int[int_1];
          objectModels = new int[int_1];

          for (int_2 = 0; int_2 < int_1; int_2++) {
            objectModels[int_2] = buffer_0.getUnsignedShort();
            objectTypes[int_2] = buffer_0.getUnsignedByte();
          }

          return;
        }

        buffer_0.offset += int_1 * 3;
      }
    } else {
      if (int_0 == 2) {
        name = buffer_0.getString();
        return;
      }

      if (int_0 == 5) {
        int_1 = buffer_0.getUnsignedByte();
        if (int_1 > 0) {
          if (objectModels == null || aBool54) {
            objectTypes = null;
            objectModels = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              objectModels[int_2] = buffer_0.getUnsignedShort();
            }

            return;
          }

          buffer_0.offset += int_1 * 2;
        }

        return;
      }

      if (int_0 == 14) {
        sizeX = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 15) {
        sizeY = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 17) {
        interactType = 0;
        aBool55 = false;
        return;
      }

      if (int_0 == 18) {
        aBool55 = false;
        return;
      }

      if (int_0 == 19) {
        anInt454 = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 21) {
        clipType = 0;
        return;
      }

      if (int_0 == 22) {
        nonFlatShading = true;
        return;
      }

      if (int_0 == 23) {
        modelClipped = true;
        return;
      }

      if (int_0 == 24) {
        animationId = buffer_0.getUnsignedShort();
        if (animationId == 65535) {
          animationId = -1;
          return;
        }
      } else {
        if (int_0 == 27) {
          interactType = 1;
          return;
        }

        if (int_0 == 28) {
          anInt459 = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 29) {
          ambient = buffer_0.getByte();
          return;
        }

        if (int_0 == 39) {
          contrast = buffer_0.getByte() * 25;
          return;
        }

        if (int_0 >= 30 && int_0 < 35) {
          actions[int_0 - 30] = buffer_0.getString();
          if (actions[int_0 - 30].equalsIgnoreCase("Hidden")) {
            actions[int_0 - 30] = null;
            return;
          }
        } else {
          if (int_0 == 40) {
            int_1 = buffer_0.getUnsignedByte();
            recolorToFind = new short[int_1];
            recolorToReplace = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              recolorToFind[int_2] = (short) buffer_0.getUnsignedShort();
              recolorToReplace[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 41) {
            int_1 = buffer_0.getUnsignedByte();
            textureToFind = new short[int_1];
            textureToReplace = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              textureToFind[int_2] = (short) buffer_0.getUnsignedShort();
              textureToReplace[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 62) {
            isRotated = true;
            return;
          }

          if (int_0 == 64) {
            clipped = false;
            return;
          }

          if (int_0 == 65) {
            modelSizeX = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 66) {
            modelSizeHeight = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 67) {
            modelSizeY = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 68) {
            mapSceneId = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 69) {
            buffer_0.getUnsignedByte();
            return;
          }

          if (int_0 == 70) {
            offsetX = buffer_0.getShort();
            return;
          }

          if (int_0 == 71) {
            offsetHeight = buffer_0.getShort();
            return;
          }

          if (int_0 == 72) {
            offsetY = buffer_0.getShort();
            return;
          }

          if (int_0 == 73) {
            aBool56 = true;
            return;
          }

          if (int_0 == 74) {
            isSolid = true;
            return;
          }

          if (int_0 == 75) {
            anInt455 = buffer_0.getUnsignedByte();
            return;
          }

          if (int_0 == 77 || int_0 == 92) {
            varpId = buffer_0.getUnsignedShort();
            if (varpId == 65535) {
              varpId = -1;
            }

            configId = buffer_0.getUnsignedShort();
            if (configId == 65535) {
              configId = -1;
            }

            int_1 = -1;
            if (int_0 == 92) {
              int_1 = buffer_0.getUnsignedShort();
              if (int_1 == 65535) {
                int_1 = -1;
              }
            }

            int_2 = buffer_0.getUnsignedByte();
            impostorIds = new int[int_2 + 2];

            for (int int_3 = 0; int_3 <= int_2; int_3++) {
              impostorIds[int_3] = buffer_0.getUnsignedShort();
              if (impostorIds[int_3] == 65535) {
                impostorIds[int_3] = -1;
              }
            }

            impostorIds[int_2 + 1] = int_1;
            return;
          }

          if (int_0 == 78) {
            ambientSoundId = buffer_0.getUnsignedShort();
            anInt456 = buffer_0.getUnsignedByte();
            return;
          }

          if (int_0 == 79) {
            anInt457 = buffer_0.getUnsignedShort();
            anInt458 = buffer_0.getUnsignedShort();
            anInt456 = buffer_0.getUnsignedByte();
            int_1 = buffer_0.getUnsignedByte();
            anIntArray101 = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              anIntArray101[int_2] = buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 81) {
            clipType = buffer_0.getUnsignedByte() * 256;
            return;
          }

          if (int_0 == 82) {
            mapIconId = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 249) {
            anIterableHashTable2 = RemoteRequest.method780(buffer_0, anIterableHashTable2);
            return;
          }
        }
      }
    }

  }

  final ModelBase getModel(final int int_0, int int_1) {
    ModelBase modeldata_0 = null;
    boolean bool_0;
    int int_2;
    int int_4;
    if (objectTypes == null) {
      if (int_0 != 10) {
        return null;
      }

      if (objectModels == null) {
        return null;
      }

      bool_0 = isRotated;
      if (int_0 == 2 && int_1 > 3) {
        bool_0 = !bool_0;
      }

      int_2 = objectModels.length;

      for (int int_3 = 0; int_3 < int_2; int_3++) {
        int_4 = objectModels[int_3];
        if (bool_0) {
          int_4 += 65536;
        }

        modeldata_0 = (ModelBase) aNodeCache9.get(int_4);
        if (modeldata_0 == null) {
          modeldata_0 = ModelBase.decode(anIndexDataBase21, int_4 & 0xFFFF, 0);
          if (modeldata_0 == null) {
            return null;
          }

          if (bool_0) {
            modeldata_0.method1013();
          }

          aNodeCache9.put(modeldata_0, int_4);
        }

        if (int_2 > 1) {
          aModelDataArray1[int_3] = modeldata_0;
        }
      }

      if (int_2 > 1) {
        modeldata_0 = new ModelBase(aModelDataArray1, int_2);
      }
    } else {
      int int_5 = -1;

      for (int_2 = 0; int_2 < objectTypes.length; int_2++) {
        if (objectTypes[int_2] == int_0) {
          int_5 = int_2;
          break;
        }
      }

      if (int_5 == -1) {
        return null;
      }

      int_2 = objectModels[int_5];
      final boolean bool_1 = isRotated ^ int_1 > 3;
      if (bool_1) {
        int_2 += 65536;
      }

      modeldata_0 = (ModelBase) aNodeCache9.get(int_2);
      if (modeldata_0 == null) {
        modeldata_0 = ModelBase.decode(anIndexDataBase21, int_2 & 0xFFFF, 0);
        if (modeldata_0 == null) {
          return null;
        }

        if (bool_1) {
          modeldata_0.method1013();
        }

        aNodeCache9.put(modeldata_0, int_2);
      }
    }

    if (modelSizeX == 128 && modelSizeHeight == 128 && modelSizeY == 128) {
      bool_0 = false;
    } else {
      bool_0 = true;
    }

    boolean bool_2;
    if (offsetX == 0 && offsetHeight == 0 && offsetY == 0) {
      bool_2 = false;
    } else {
      bool_2 = true;
    }

    final ModelBase modeldata_1 = new ModelBase(modeldata_0, int_1 == 0 && !bool_0 && !bool_2,
        recolorToFind == null, textureToFind == null, true);
    if (int_0 == 4 && int_1 > 3) {
      modeldata_1.method1014(256);
      modeldata_1.method1011(45, 0, -45);
    }

    int_1 &= 0x3;
    if (int_1 == 1) {
      modeldata_1.method1015();
    } else if (int_1 == 2) {
      modeldata_1.method1016();
    } else if (int_1 == 3) {
      modeldata_1.method1017();
    }

    if (recolorToFind != null) {
      for (int_4 = 0; int_4 < recolorToFind.length; int_4++) {
        modeldata_1.replaceColor(recolorToFind[int_4], recolorToReplace[int_4]);
      }
    }

    if (textureToFind != null) {
      for (int_4 = 0; int_4 < textureToFind.length; int_4++) {
        modeldata_1.method1009(textureToFind[int_4], textureToReplace[int_4]);
      }
    }

    if (bool_0) {
      modeldata_1.method1010(modelSizeX, modelSizeHeight, modelSizeY);
    }

    if (bool_2) {
      modeldata_1.method1011(offsetX, offsetHeight, offsetY);
    }

    return modeldata_1;
  }

  public void post() {
    if (anInt454 == -1) {
      anInt454 = 0;
      if (objectModels != null && (objectTypes == null || objectTypes[0] == 10)) {
        anInt454 = 1;
      }

      for (int int_0 = 0; int_0 < 5; int_0++) {
        if (actions[int_0] != null) {
          anInt454 = 1;
        }
      }
    }

    if (anInt455 == -1) {
      anInt455 = interactType != 0 ? 1 : 0;
    }

  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      loadData(buffer_0, int_0);
    }
  }

  public final Model method820(final int int_0, final int int_1, final int[][] ints_0,
      final int int_2,
      final int int_3, final int int_4, final AnimationSequence sequence_0, final int int_5) {
    long long_0;
    if (objectTypes == null) {
      long_0 = int_1 + (id << 10);
    } else {
      long_0 = int_1 + (int_0 << 3) + (id << 10);
    }

    Model model_0 = (Model) aNodeCache8.get(long_0);
    if (model_0 == null) {
      final ModelBase modeldata_0 = this.getModel(int_0, int_1);
      if (modeldata_0 == null) {
        return null;
      }

      model_0 = modeldata_0.applyLighting(ambient + 64, contrast + 768, -50, -10, -50);
      aNodeCache8.put(model_0, long_0);
    }

    if (sequence_0 == null && clipType == -1) {
      return model_0;
    }
    if (sequence_0 != null) {
      model_0 = sequence_0.method875(model_0, int_5, int_1);
    } else {
      model_0 = model_0.method972(true);
    }

    if (clipType >= 0) {
      model_0 = model_0.method976(ints_0, int_2, int_3, int_4, false, clipType);
    }

    return model_0;
  }

  public final boolean method821() {
    if (objectModels == null) {
      return true;
    }
    boolean bool_0 = true;

    for (int int_0 = 0; int_0 < objectModels.length; int_0++) {
      bool_0 &= anIndexDataBase21.method450(objectModels[int_0] & 0xFFFF, 0);
    }

    return bool_0;
  }

  public final boolean method822(final int int_0) {
    if (objectTypes != null) {
      for (int int_2 = 0; int_2 < objectTypes.length; int_2++) {
        if (objectTypes[int_2] == int_0) {
          return anIndexDataBase21.method450(objectModels[int_2] & 0xFFFF, 0);
        }
      }

      return true;
    }
    if (objectModels == null) {
      return true;
    }
    if (int_0 != 10) {
      return true;
    }
    boolean bool_0 = true;

    for (int int_1 = 0; int_1 < objectModels.length; int_1++) {
      bool_0 &= anIndexDataBase21.method450(objectModels[int_1] & 0xFFFF, 0);
    }

    return bool_0;
  }

  public boolean method823() {
    if (impostorIds == null) {
      return ambientSoundId != -1 || anIntArray101 != null;
    }
    for (int int_0 = 0; int_0 < impostorIds.length; int_0++) {
      if (impostorIds[int_0] != -1) {
        final ObjectConfig objectcomposition_1 = Class2
            .getObjectDefinition(impostorIds[int_0]);
        if (objectcomposition_1.ambientSoundId != -1 || objectcomposition_1.anIntArray101
            != null) {
          return true;
        }
      }
    }

    return false;
  }

  public final Renderable getModel(final int int_0, final int int_1, final int[][] ints_0,
      final int int_2,
      final int int_3, final int int_4) {
    long long_0;
    if (objectTypes == null) {
      long_0 = int_1 + (id << 10);
    } else {
      long_0 = int_1 + (int_0 << 3) + (id << 10);
    }

    Object object_0 = cachedModels.get(long_0);
    if (object_0 == null) {
      final ModelBase modeldata_0 = this.getModel(int_0, int_1);
      if (modeldata_0 == null) {
        return null;
      }

      if (!nonFlatShading) {
        object_0 = modeldata_0.applyLighting(ambient + 64, contrast + 768, -50, -10, -50);
      } else {
        modeldata_0.aShort2 = (short) (ambient + 64);
        modeldata_0.contrast = (short) (contrast + 768);
        modeldata_0.calculateNormals();
        object_0 = modeldata_0;
      }

      cachedModels.put((Subnode) object_0, long_0);
    }

    if (nonFlatShading) {
      object_0 = ((ModelBase) object_0).method1008();
    }

    if (clipType >= 0) {
      if (object_0 instanceof Model) {
        object_0 = ((Model) object_0).method976(ints_0, int_2, int_3, int_4, true, clipType);
      } else if (object_0 instanceof ModelBase) {
        object_0 = ((ModelBase) object_0).method1012(ints_0, int_2, int_3, int_4, true, clipType);
      }
    }

    return (Renderable) object_0;
  }

  public final Model method824(final int int_0, final int int_1, final int[][] ints_0,
      final int int_2,
      final int int_3, final int int_4) {
    long long_0;
    if (objectTypes == null) {
      long_0 = int_1 + (id << 10);
    } else {
      long_0 = int_1 + (int_0 << 3) + (id << 10);
    }

    Model model_0 = (Model) aNodeCache8.get(long_0);
    if (model_0 == null) {
      final ModelBase modeldata_0 = this.getModel(int_0, int_1);
      if (modeldata_0 == null) {
        return null;
      }

      model_0 = modeldata_0.applyLighting(ambient + 64, contrast + 768, -50, -10, -50);
      aNodeCache8.put(model_0, long_0);
    }

    if (clipType >= 0) {
      model_0 = model_0.method976(ints_0, int_2, int_3, int_4, true, clipType);
    }

    return model_0;
  }

  public int method825(final int int_0, final int int_1) {
    return ChatLineBuffer.method13(anIterableHashTable2, int_0, int_1);
  }

  public String method826(final int int_0, final String string_0) {
    return Class10.method158(anIterableHashTable2, int_0, string_0);
  }

}
