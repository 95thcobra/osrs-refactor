package jagex.oldschool.config;

import jagex.oldschool.ChatLineBuffer;
import jagex.oldschool.Class10;
import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.asset.RemoteRequest;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.LongVariable;

public class ItemConfig extends Subnode {

  public static Cache items;
  public static Cache itemModelCache;
  public static Cache itemSpriteCache;
  public static boolean isMembersWorld;
  public static int anInt491;
  public static DirectSprite aSpritePixels5;

  static {
    items = new Cache(64);
    itemModelCache = new Cache(50);
    itemSpriteCache = new Cache(200);
  }

  public String[] inventoryActions;
  public String name;
  public int zoom2d;
  public int id;
  public int xan2d;
  public int yan2d;
  public int offsetX2d;
  public int isStackable;
  public int offsetY2d;
  public int zan2d;
  public boolean isMembers;
  public int price;
  public int notedTemplate;
  public String[] groundActions;
  public boolean aBool62;
  public int ambient;
  public int contrast;
  public int note;
  public int anInt492;
  public int anInt493;
  public int anInt494;
  int maleHeadModel;
  int maleModel;
  int inventoryModel;
  public int[] countObj;
  public int team;
  public IterableHashTable anIterableHashTable5;
  int maleHeadModel2;
  int maleModel1;
  int maleModel2;
  int femaleHeadModel;
  int femaleHeadModel2;
  int femaleModel;
  public int[] countCo;
  int femaleModel1;
  int femaleModel2;
  int resizeX;
  int resizeY;
  int resizeZ;
  short[] colourToReplace;
  int maleOffset;
  short[] textureToReplace;
  short[] colourToReplaceWith;
  int femaleOffset;
  short[] textToReplaceWith;
  public int notedId;
  public int unnotedId;

  public ItemConfig() {
    name = "null";
    zoom2d = 2000;
    xan2d = 0;
    yan2d = 0;
    zan2d = 0;
    offsetX2d = 0;
    offsetY2d = 0;
    isStackable = 0;
    price = 1;
    isMembers = false;
    groundActions = new String[] {null, null, "Take", null, null};
    inventoryActions = new String[] {null, null, null, null, "Drop"};
    team = -2;
    maleModel = -1;
    maleModel1 = -1;
    maleOffset = 0;
    femaleModel = -1;
    femaleModel1 = -1;
    femaleOffset = 0;
    maleModel2 = -1;
    femaleModel2 = -1;
    maleHeadModel = -1;
    maleHeadModel2 = -1;
    femaleHeadModel = -1;
    femaleHeadModel2 = -1;
    note = -1;
    notedTemplate = -1;
    resizeX = 128;
    resizeY = 128;
    resizeZ = 128;
    ambient = 0;
    contrast = 0;
    anInt492 = 0;
    aBool62 = false;
    unnotedId = -1;
    notedId = -1;
    anInt494 = -1;
    anInt493 = -1;
  }

  void populateFromBuffer(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      inventoryModel = buffer_0.getUnsignedShort();
    } else {
      if (int_0 == 2) {
        name = buffer_0.getString();
        return;
      }

      if (int_0 == 4) {
        zoom2d = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 5) {
        xan2d = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 6) {
        yan2d = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 7) {
        offsetX2d = buffer_0.getUnsignedShort();
        if (offsetX2d > 32767) {
          offsetX2d -= 65536;
          return;
        }
      } else if (int_0 == 8) {
        offsetY2d = buffer_0.getUnsignedShort();
        if (offsetY2d > 32767) {
          offsetY2d -= 65536;
          return;
        }
      } else {
        if (int_0 == 11) {
          isStackable = 1;
          return;
        }

        if (int_0 == 12) {
          price = buffer_0.getInt();
          return;
        }

        if (int_0 == 16) {
          isMembers = true;
          return;
        }

        if (int_0 == 23) {
          maleModel = buffer_0.getUnsignedShort();
          maleOffset = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 24) {
          maleModel1 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 25) {
          femaleModel = buffer_0.getUnsignedShort();
          femaleOffset = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 26) {
          femaleModel1 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 >= 30 && int_0 < 35) {
          groundActions[int_0 - 30] = buffer_0.getString();
          if (groundActions[int_0 - 30].equalsIgnoreCase("Hidden")) {
            groundActions[int_0 - 30] = null;
            return;
          }
        } else {
          if (int_0 >= 35 && int_0 < 40) {
            inventoryActions[int_0 - 35] = buffer_0.getString();
            return;
          }

          int int_1;
          int int_2;
          if (int_0 == 40) {
            int_1 = buffer_0.getUnsignedByte();
            colourToReplace = new short[int_1];
            colourToReplaceWith = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              colourToReplace[int_2] = (short) buffer_0.getUnsignedShort();
              colourToReplaceWith[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 41) {
            int_1 = buffer_0.getUnsignedByte();
            textureToReplace = new short[int_1];
            textToReplaceWith = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              textureToReplace[int_2] = (short) buffer_0.getUnsignedShort();
              textToReplaceWith[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 42) {
            team = buffer_0.getByte();
            return;
          }

          if (int_0 == 65) {
            aBool62 = true;
            return;
          }

          if (int_0 == 78) {
            maleModel2 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 79) {
            femaleModel2 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 90) {
            maleHeadModel = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 91) {
            femaleHeadModel = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 92) {
            maleHeadModel2 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 93) {
            femaleHeadModel2 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 95) {
            zan2d = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 97) {
            note = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 98) {
            notedTemplate = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 >= 100 && int_0 < 110) {
            if (countObj == null) {
              countObj = new int[10];
              countCo = new int[10];
            }

            countObj[int_0 - 100] = buffer_0.getUnsignedShort();
            countCo[int_0 - 100] = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 110) {
            resizeX = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 111) {
            resizeY = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 112) {
            resizeZ = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 113) {
            ambient = buffer_0.getByte();
            return;
          }

          if (int_0 == 114) {
            contrast = buffer_0.getByte() * 5;
            return;
          }

          if (int_0 == 115) {
            anInt492 = buffer_0.getUnsignedByte();
            return;
          }

          if (int_0 == 139) {
            unnotedId = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 140) {
            notedId = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 148) {
            anInt494 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 149) {
            anInt493 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 249) {
            anIterableHashTable5 = RemoteRequest.method780(buffer_0, anIterableHashTable5);
            return;
          }
        }
      }
    }

  }

  public final Model getModel(final int int_0) {
    if (countObj != null && int_0 > 1) {
      int int_1 = -1;

      for (int int_2 = 0; int_2 < 10; int_2++) {
        if (int_0 >= countCo[int_2] && countCo[int_2] != 0) {
          int_1 = countObj[int_2];
        }
      }

      if (int_1 != -1) {
        return AudioWorker.getItemDefinition(int_1).getModel(1);
      }
    }

    Model model_0 = (Model) itemModelCache.get(id);
    if (model_0 != null) {
      return model_0;
    }
    final ModelBase modeldata_0 = ModelBase
        .decode(LongVariable.anIndexDataBase2, inventoryModel, 0);
    if (modeldata_0 == null) {
      return null;
    }
    if (resizeX != 128 || resizeY != 128 || resizeZ != 128) {
      modeldata_0.method1010(resizeX, resizeY, resizeZ);
    }

    int int_3;
    if (colourToReplace != null) {
      for (int_3 = 0; int_3 < colourToReplace.length; int_3++) {
        modeldata_0.replaceColor(colourToReplace[int_3], colourToReplaceWith[int_3]);
      }
    }

    if (textureToReplace != null) {
      for (int_3 = 0; int_3 < textureToReplace.length; int_3++) {
        modeldata_0.method1009(textureToReplace[int_3], textToReplaceWith[int_3]);
      }
    }

    model_0 = modeldata_0.applyLighting(ambient + 64, contrast + 768, -50, -10, -50);
    model_0.aBool68 = true;
    itemModelCache.put(model_0, id);
    return model_0;
  }

  public final ModelBase method895(final int int_0) {
    int int_2;
    if (countObj != null && int_0 > 1) {
      int int_1 = -1;

      for (int_2 = 0; int_2 < 10; int_2++) {
        if (int_0 >= countCo[int_2] && countCo[int_2] != 0) {
          int_1 = countObj[int_2];
        }
      }

      if (int_1 != -1) {
        return AudioWorker.getItemDefinition(int_1).method895(1);
      }
    }

    final ModelBase modeldata_0 = ModelBase
        .decode(LongVariable.anIndexDataBase2, inventoryModel, 0);
    if (modeldata_0 == null) {
      return null;
    }
    if (resizeX != 128 || resizeY != 128 || resizeZ != 128) {
      modeldata_0.method1010(resizeX, resizeY, resizeZ);
    }

    if (colourToReplace != null) {
      for (int_2 = 0; int_2 < colourToReplace.length; int_2++) {
        modeldata_0.replaceColor(colourToReplace[int_2], colourToReplaceWith[int_2]);
      }
    }

    if (textureToReplace != null) {
      for (int_2 = 0; int_2 < textureToReplace.length; int_2++) {
        modeldata_0.method1009(textureToReplace[int_2], textToReplaceWith[int_2]);
      }
    }

    return modeldata_0;
  }

  public final boolean method896(final boolean bool_0) {
    int int_0 = maleHeadModel;
    int int_1 = maleHeadModel2;
    if (bool_0) {
      int_0 = femaleHeadModel;
      int_1 = femaleHeadModel2;
    }

    if (int_0 == -1) {
      return true;
    }
    boolean bool_1 = true;
    if (!LongVariable.anIndexDataBase2.method450(int_0, 0)) {
      bool_1 = false;
    }

    if (int_1 != -1 && !LongVariable.anIndexDataBase2.method450(int_1, 0)) {
      bool_1 = false;
    }

    return bool_1;
  }

  public void post() {
  }

  public final ModelBase method897(final boolean bool_0) {
    int int_0 = maleHeadModel;
    int int_1 = maleHeadModel2;
    if (bool_0) {
      int_0 = femaleHeadModel;
      int_1 = femaleHeadModel2;
    }

    if (int_0 == -1) {
      return null;
    }
    ModelBase modeldata_0 = ModelBase.decode(LongVariable.anIndexDataBase2, int_0, 0);
    if (int_1 != -1) {
      final ModelBase modeldata_1 = ModelBase.decode(LongVariable.anIndexDataBase2, int_1, 0);
      final ModelBase[] modeldatas_0 = new ModelBase[] {modeldata_0, modeldata_1};
      modeldata_0 = new ModelBase(modeldatas_0, 2);
    }

    int int_2;
    if (colourToReplace != null) {
      for (int_2 = 0; int_2 < colourToReplace.length; int_2++) {
        modeldata_0.replaceColor(colourToReplace[int_2], colourToReplaceWith[int_2]);
      }
    }

    if (textureToReplace != null) {
      for (int_2 = 0; int_2 < textureToReplace.length; int_2++) {
        modeldata_0.method1009(textureToReplace[int_2], textToReplaceWith[int_2]);
      }
    }

    return modeldata_0;
  }

  public void loadBuffer(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      populateFromBuffer(buffer_0, int_0);
    }
  }

  public final boolean readyWorn(final boolean bool_0) {
    int int_0 = maleModel;
    int int_1 = maleModel1;
    int int_2 = maleModel2;
    if (bool_0) {
      int_0 = femaleModel;
      int_1 = femaleModel1;
      int_2 = femaleModel2;
    }

    if (int_0 == -1) {
      return true;
    }
    boolean bool_1 = true;
    if (!LongVariable.anIndexDataBase2.method450(int_0, 0)) {
      bool_1 = false;
    }

    if (int_1 != -1 && !LongVariable.anIndexDataBase2.method450(int_1, 0)) {
      bool_1 = false;
    }

    if (int_2 != -1 && !LongVariable.anIndexDataBase2.method450(int_2, 0)) {
      bool_1 = false;
    }

    return bool_1;
  }

  public final ModelBase getWornModelData(final boolean bool_0) {
    int int_0 = maleModel;
    int int_1 = maleModel1;
    int int_2 = maleModel2;
    if (bool_0) {
      int_0 = femaleModel;
      int_1 = femaleModel1;
      int_2 = femaleModel2;
    }

    if (int_0 == -1) {
      return null;
    }
    ModelBase modeldata_0 = ModelBase.decode(LongVariable.anIndexDataBase2, int_0, 0);
    if (int_1 != -1) {
      final ModelBase modeldata_1 = ModelBase.decode(LongVariable.anIndexDataBase2, int_1, 0);
      if (int_2 != -1) {
        final ModelBase modeldata_2 = ModelBase
            .decode(LongVariable.anIndexDataBase2, int_2, 0);
        final ModelBase[] modeldatas_0 = new ModelBase[] {modeldata_0, modeldata_1, modeldata_2};
        modeldata_0 = new ModelBase(modeldatas_0, 3);
      } else {
        final ModelBase[] modeldatas_1 = new ModelBase[] {modeldata_0, modeldata_1};
        modeldata_0 = new ModelBase(modeldatas_1, 2);
      }
    }

    if (!bool_0 && maleOffset != 0) {
      modeldata_0.method1011(0, maleOffset, 0);
    }

    if (bool_0 && femaleOffset != 0) {
      modeldata_0.method1011(0, femaleOffset, 0);
    }

    int int_3;
    if (colourToReplace != null) {
      for (int_3 = 0; int_3 < colourToReplace.length; int_3++) {
        modeldata_0.replaceColor(colourToReplace[int_3], colourToReplaceWith[int_3]);
      }
    }

    if (textureToReplace != null) {
      for (int_3 = 0; int_3 < textureToReplace.length; int_3++) {
        modeldata_0.method1009(textureToReplace[int_3], textToReplaceWith[int_3]);
      }
    }

    return modeldata_0;
  }

  public void method898(final ItemConfig itemcomposition_1,
      final ItemConfig itemcomposition_2) {
    inventoryModel = itemcomposition_1.inventoryModel;
    zoom2d = itemcomposition_1.zoom2d;
    xan2d = itemcomposition_1.xan2d;
    yan2d = itemcomposition_1.yan2d;
    zan2d = itemcomposition_1.zan2d;
    offsetX2d = itemcomposition_1.offsetX2d;
    offsetY2d = itemcomposition_1.offsetY2d;
    colourToReplace = itemcomposition_1.colourToReplace;
    colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
    textureToReplace = itemcomposition_1.textureToReplace;
    textToReplaceWith = itemcomposition_1.textToReplaceWith;
    name = itemcomposition_2.name;
    isMembers = itemcomposition_2.isMembers;
    price = itemcomposition_2.price;
    isStackable = 1;
  }

  public void method899(final ItemConfig itemcomposition_1,
      final ItemConfig itemcomposition_2) {
    inventoryModel = itemcomposition_1.inventoryModel;
    zoom2d = itemcomposition_1.zoom2d;
    xan2d = itemcomposition_1.xan2d;
    yan2d = itemcomposition_1.yan2d;
    zan2d = itemcomposition_1.zan2d;
    offsetX2d = itemcomposition_1.offsetX2d;
    offsetY2d = itemcomposition_1.offsetY2d;
    colourToReplace = itemcomposition_2.colourToReplace;
    colourToReplaceWith = itemcomposition_2.colourToReplaceWith;
    textureToReplace = itemcomposition_2.textureToReplace;
    textToReplaceWith = itemcomposition_2.textToReplaceWith;
    name = itemcomposition_2.name;
    isMembers = itemcomposition_2.isMembers;
    isStackable = itemcomposition_2.isStackable;
    maleModel = itemcomposition_2.maleModel;
    maleModel1 = itemcomposition_2.maleModel1;
    maleModel2 = itemcomposition_2.maleModel2;
    femaleModel = itemcomposition_2.femaleModel;
    femaleModel1 = itemcomposition_2.femaleModel1;
    femaleModel2 = itemcomposition_2.femaleModel2;
    maleHeadModel = itemcomposition_2.maleHeadModel;
    maleHeadModel2 = itemcomposition_2.maleHeadModel2;
    femaleHeadModel = itemcomposition_2.femaleHeadModel;
    femaleHeadModel2 = itemcomposition_2.femaleHeadModel2;
    anInt492 = itemcomposition_2.anInt492;
    groundActions = itemcomposition_2.groundActions;
    inventoryActions = new String[5];
    if (itemcomposition_2.inventoryActions != null) {
      for (int int_0 = 0; int_0 < 4; int_0++) {
        inventoryActions[int_0] = itemcomposition_2.inventoryActions[int_0];
      }
    }

    inventoryActions[4] = "Discard";
    price = 0;
  }

  public void method900(final ItemConfig itemcomposition_1,
      final ItemConfig itemcomposition_2) {
    inventoryModel = itemcomposition_1.inventoryModel;
    zoom2d = itemcomposition_1.zoom2d;
    xan2d = itemcomposition_1.xan2d;
    yan2d = itemcomposition_1.yan2d;
    zan2d = itemcomposition_1.zan2d;
    offsetX2d = itemcomposition_1.offsetX2d;
    offsetY2d = itemcomposition_1.offsetY2d;
    colourToReplace = itemcomposition_1.colourToReplace;
    colourToReplaceWith = itemcomposition_1.colourToReplaceWith;
    textureToReplace = itemcomposition_1.textureToReplace;
    textToReplaceWith = itemcomposition_1.textToReplaceWith;
    isStackable = itemcomposition_1.isStackable;
    name = itemcomposition_2.name;
    price = 0;
    isMembers = false;
    aBool62 = false;
  }

  public ItemConfig method901(final int int_0) {
    if (countObj != null && int_0 > 1) {
      int int_1 = -1;

      for (int int_2 = 0; int_2 < 10; int_2++) {
        if (int_0 >= countCo[int_2] && countCo[int_2] != 0) {
          int_1 = countObj[int_2];
        }
      }

      if (int_1 != -1) {
        return AudioWorker.getItemDefinition(int_1);
      }
    }

    return this;
  }

  public int method902() {
    return team != -1 && inventoryActions != null
        ? team >= 0 ? inventoryActions[team] != null ? team : -1
        : "Drop".equalsIgnoreCase(inventoryActions[4]) ? 4 : -1
        : -1;
  }

  public int method903(final int int_0, final int int_1) {
    return ChatLineBuffer.method13(anIterableHashTable5, int_0, int_1);
  }

  public String method904(final int int_0, final String string_0) {
    return Class10.method158(anIterableHashTable5, int_0, string_0);
  }

}
