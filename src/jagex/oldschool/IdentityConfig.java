package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class IdentityConfig extends Subnode {

  public static int anInt429;
  public static Cache identKits;
  public static AbstractPackage anIndexDataBase16;
  public static AbstractPackage identKit_ref;
  public static int counter;

  static {
    identKits = new Cache(64);
  }

  public int bodyPartId;
  public boolean nonSelectable;
  int[] modelIds;
  int[] models;
  short[] recolorToFind;
  short[] retextureToFind;
  short[] recolorToReplace;
  short[] retextureToReplace;

  public IdentityConfig() {
    bodyPartId = -1;
    models = new int[] {-1, -1, -1, -1, -1};
    nonSelectable = false;
  }

  void method770(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      bodyPartId = buffer_0.getUnsignedByte();
    } else {
      int int_1;
      int int_2;
      if (int_0 == 2) {
        int_1 = buffer_0.getUnsignedByte();
        modelIds = new int[int_1];

        for (int_2 = 0; int_2 < int_1; int_2++) {
          modelIds[int_2] = buffer_0.getUnsignedShort();
        }

        return;
      }

      if (int_0 == 3) {
        nonSelectable = true;
        return;
      }

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
        retextureToFind = new short[int_1];
        retextureToReplace = new short[int_1];

        for (int_2 = 0; int_2 < int_1; int_2++) {
          retextureToFind[int_2] = (short) buffer_0.getUnsignedShort();
          retextureToReplace[int_2] = (short) buffer_0.getUnsignedShort();
        }

        return;
      }

      if (int_0 >= 60 && int_0 < 70) {
        models[int_0 - 60] = buffer_0.getUnsignedShort();
        return;
      }
    }

  }

  public boolean method771() {
    boolean bool_0 = true;

    for (int int_0 = 0; int_0 < 5; int_0++) {
      if (models[int_0] != -1 && !anIndexDataBase16.method450(models[int_0], 0)) {
        bool_0 = false;
      }
    }

    return bool_0;
  }

  public ModelBase method772() {
    final ModelBase[] modeldatas_0 = new ModelBase[5];
    int int_0 = 0;

    for (int int_1 = 0; int_1 < 5; int_1++) {
      if (models[int_1] != -1) {
        modeldatas_0[int_0++] = ModelBase.decode(anIndexDataBase16, models[int_1], 0);
      }
    }

    final ModelBase modeldata_0 = new ModelBase(modeldatas_0, int_0);
    int int_2;
    if (recolorToFind != null) {
      for (int_2 = 0; int_2 < recolorToFind.length; int_2++) {
        modeldata_0.replaceColor(recolorToFind[int_2], recolorToReplace[int_2]);
      }
    }

    if (retextureToFind != null) {
      for (int_2 = 0; int_2 < retextureToFind.length; int_2++) {
        modeldata_0.method1009(retextureToFind[int_2], retextureToReplace[int_2]);
      }
    }

    return modeldata_0;
  }

  public boolean ready() {
    if (modelIds == null) {
      return true;
    }
    boolean bool_0 = true;

    for (int int_0 = 0; int_0 < modelIds.length; int_0++) {
      if (!anIndexDataBase16.method450(modelIds[int_0], 0)) {
        bool_0 = false;
      }
    }

    return bool_0;
  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method770(buffer_0, int_0);
    }
  }

  public ModelBase getModelData() {
    if (modelIds == null) {
      return null;
    }
    final ModelBase[] modeldatas_0 = new ModelBase[modelIds.length];

    for (int int_0 = 0; int_0 < modelIds.length; int_0++) {
      modeldatas_0[int_0] = ModelBase.decode(anIndexDataBase16, modelIds[int_0], 0);
    }

    ModelBase modeldata_0;
    if (modeldatas_0.length == 1) {
      modeldata_0 = modeldatas_0[0];
    } else {
      modeldata_0 = new ModelBase(modeldatas_0, modeldatas_0.length);
    }

    int int_1;
    if (recolorToFind != null) {
      for (int_1 = 0; int_1 < recolorToFind.length; int_1++) {
        modeldata_0.replaceColor(recolorToFind[int_1], recolorToReplace[int_1]);
      }
    }

    if (retextureToFind != null) {
      for (int_1 = 0; int_1 < retextureToFind.length; int_1++) {
        modeldata_0.method1009(retextureToFind[int_1], retextureToReplace[int_1]);
      }
    }

    return modeldata_0;
  }

}
