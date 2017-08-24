package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.util.Timestamp;

public class PlayerIdentity {

  static final int[] anIntArray47;
  public static short[][] colorsToReplace;
  public static Cache aNodeCache1;
  public static short[] colorsToFind;
  public static short[][] aShortArrayArray3;
  public static short[] aShortArray4;
  static int anInt188;

  static {
    anIntArray47 = new int[] {8, 11, 4, 6, 9, 7, 10};
    aNodeCache1 = new Cache(260);
  }

  public int transformedNpcId;
  public boolean isFemale;
  int[] bodyPartColours;
  long hash;
  int[] equipmentIds;
  long aLong10;

  public static MappedEnum forOrdinal(final MappedEnum[] rsenums_0, final int int_0) {
    final MappedEnum[] rsenums_1 = rsenums_0;

    for (int int_1 = 0; int_1 < rsenums_1.length; int_1++) {
      final MappedEnum rsenum_0 = rsenums_1[int_1];
      if (int_0 == rsenum_0.mappedOrdinal()) {
        return rsenum_0;
      }
    }

    return null;
  }

  public void method499(int[] ints_0, final int[] ints_1, final boolean bool_0, final int int_0) {
    if (ints_0 == null) {
      ints_0 = new int[12];

      for (int int_1 = 0; int_1 < 7; int_1++) {
        for (int int_2 = 0; int_2 < IdentityConfig.anInt429; int_2++) {
          final IdentityConfig kitdefinition_0 = MapIconConfig.getKitDefinition(int_2);
          if (kitdefinition_0 != null && !kitdefinition_0.nonSelectable
              && kitdefinition_0.bodyPartId == int_1 + (bool_0 ? 7 : 0)) {
            ints_0[anIntArray47[int_1]] = int_2 + 256;
            break;
          }
        }
      }
    }

    equipmentIds = ints_0;
    bodyPartColours = ints_1;
    isFemale = bool_0;
    transformedNpcId = int_0;
    setHash();
  }

  void setHash() {
    final long long_0 = hash;
    final int int_0 = equipmentIds[5];
    final int int_1 = equipmentIds[9];
    equipmentIds[5] = int_1;
    equipmentIds[9] = int_0;
    hash = 0L;

    int int_2;
    for (int_2 = 0; int_2 < 12; int_2++) {
      hash <<= 4;
      if (equipmentIds[int_2] >= 256) {
        hash += equipmentIds[int_2] - 256;
      }
    }

    if (equipmentIds[0] >= 256) {
      hash += equipmentIds[0] - 256 >> 4;
    }

    if (equipmentIds[1] >= 256) {
      hash += equipmentIds[1] - 256 >> 8;
    }

    for (int_2 = 0; int_2 < 5; int_2++) {
      hash <<= 3;
      hash += bodyPartColours[int_2];
    }

    hash <<= 1;
    hash += isFemale ? 1 : 0;
    equipmentIds[5] = int_0;
    equipmentIds[9] = int_1;
    if (long_0 != 0L && hash != long_0) {
      aNodeCache1.remove(long_0);
    }

  }

  public Model method500(final AnimationSequence sequence_0, final int int_0, final AnimationSequence sequence_1,
      final int int_1) {
    if (transformedNpcId != -1) {
      return Timestamp.getNpcDefinition(transformedNpcId)
          .method864(sequence_0, int_0, sequence_1, int_1);
    }
    long long_0 = hash;
    int[] ints_0 = equipmentIds;
    if (sequence_0 != null && (sequence_0.leftHandItem >= 0 || sequence_0.rightHandItem
        >= 0)) {
      ints_0 = new int[12];

      for (int int_2 = 0; int_2 < 12; int_2++) {
        ints_0[int_2] = equipmentIds[int_2];
      }

      if (sequence_0.leftHandItem >= 0) {
        long_0 += sequence_0.leftHandItem - equipmentIds[5] << 8;
        ints_0[5] = sequence_0.leftHandItem;
      }

      if (sequence_0.rightHandItem >= 0) {
        long_0 += sequence_0.rightHandItem - equipmentIds[3] << 16;
        ints_0[3] = sequence_0.rightHandItem;
      }
    }

    Model model_0 = (Model) aNodeCache1.get(long_0);
    if (model_0 == null) {
      boolean bool_0 = false;

      int int_4;
      for (int int_3 = 0; int_3 < 12; int_3++) {
        int_4 = ints_0[int_3];
        if (int_4 >= 256 && int_4 < 512 && !MapIconConfig.getKitDefinition(int_4 - 256).ready()) {
          bool_0 = true;
        }

        if (int_4 >= 512 && !AudioWorker.getItemDefinition(int_4 - 512).readyWorn(isFemale)) {
          bool_0 = true;
        }
      }

      if (bool_0) {
        if (aLong10 != -1L) {
          model_0 = (Model) aNodeCache1.get(aLong10);
        }

        if (model_0 == null) {
          return null;
        }
      }

      if (model_0 == null) {
        final ModelBase[] modeldatas_0 = new ModelBase[12];
        int_4 = 0;

        int int_6;
        for (int int_5 = 0; int_5 < 12; int_5++) {
          int_6 = ints_0[int_5];
          ModelBase modeldata_0;
          if (int_6 >= 256 && int_6 < 512) {
            modeldata_0 = MapIconConfig.getKitDefinition(int_6 - 256).getModelData();
            if (modeldata_0 != null) {
              modeldatas_0[int_4++] = modeldata_0;
            }
          }

          if (int_6 >= 512) {
            modeldata_0 = AudioWorker.getItemDefinition(int_6 - 512).getWornModelData(isFemale);
            if (modeldata_0 != null) {
              modeldatas_0[int_4++] = modeldata_0;
            }
          }
        }

        final ModelBase modeldata_1 = new ModelBase(modeldatas_0, int_4);

        for (int_6 = 0; int_6 < 5; int_6++) {
          if (bodyPartColours[int_6] < colorsToReplace[int_6].length) {
            modeldata_1
                .replaceColor(colorsToFind[int_6], colorsToReplace[int_6][bodyPartColours[int_6]]);
          }

          if (bodyPartColours[int_6] < aShortArrayArray3[int_6].length) {
            modeldata_1
                .replaceColor(aShortArray4[int_6], aShortArrayArray3[int_6][bodyPartColours[int_6]]);
          }
        }

        model_0 = modeldata_1.applyLighting(64, 850, -30, -50, -30);
        aNodeCache1.put(model_0, long_0);
        aLong10 = long_0;
      }
    }

    if (sequence_0 == null && sequence_1 == null) {
      return model_0;
    }
    Model model_1;
    if (sequence_0 != null && sequence_1 != null) {
      model_1 = sequence_0.method874(model_0, int_0, sequence_1, int_1);
    } else if (sequence_0 != null) {
      model_1 = sequence_0.method873(model_0, int_0);
    } else {
      model_1 = sequence_1.method873(model_0, int_1);
    }

    return model_1;
  }

  public ModelBase method501() {
    if (transformedNpcId != -1) {
      return Timestamp.getNpcDefinition(transformedNpcId).method863();
    }
    boolean bool_0 = false;

    int int_1;
    for (int int_0 = 0; int_0 < 12; int_0++) {
      int_1 = equipmentIds[int_0];
      if (int_1 >= 256 && int_1 < 512 && !MapIconConfig.getKitDefinition(int_1 - 256).method771()) {
        bool_0 = true;
      }

      if (int_1 >= 512 && !AudioWorker.getItemDefinition(int_1 - 512).method896(isFemale)) {
        bool_0 = true;
      }
    }

    if (bool_0) {
      return null;
    }
    final ModelBase[] modeldatas_0 = new ModelBase[12];
    int_1 = 0;

    int int_3;
    for (int int_2 = 0; int_2 < 12; int_2++) {
      int_3 = equipmentIds[int_2];
      ModelBase modeldata_0;
      if (int_3 >= 256 && int_3 < 512) {
        modeldata_0 = MapIconConfig.getKitDefinition(int_3 - 256).method772();
        if (modeldata_0 != null) {
          modeldatas_0[int_1++] = modeldata_0;
        }
      }

      if (int_3 >= 512) {
        modeldata_0 = AudioWorker.getItemDefinition(int_3 - 512).method897(isFemale);
        if (modeldata_0 != null) {
          modeldatas_0[int_1++] = modeldata_0;
        }
      }
    }

    final ModelBase modeldata_1 = new ModelBase(modeldatas_0, int_1);

    for (int_3 = 0; int_3 < 5; int_3++) {
      if (bodyPartColours[int_3] < colorsToReplace[int_3].length) {
        modeldata_1.replaceColor(colorsToFind[int_3], colorsToReplace[int_3][bodyPartColours[int_3]]);
      }

      if (bodyPartColours[int_3] < aShortArrayArray3[int_3].length) {
        modeldata_1.replaceColor(aShortArray4[int_3], aShortArrayArray3[int_3][bodyPartColours[int_3]]);
      }
    }

    return modeldata_1;
  }

  public int method502() {
    return transformedNpcId == -1
        ? (equipmentIds[0] << 15) + equipmentIds[1] + (equipmentIds[11] << 5) + (equipmentIds[8]
        << 10)
        + (bodyPartColours[0] << 25) + (bodyPartColours[4] << 20)
        : 305419896 + Timestamp.getNpcDefinition(transformedNpcId).id;
  }

  public void method503(final int int_0, final boolean bool_0) {
    if (int_0 != 1 || !isFemale) {
      int int_1 = equipmentIds[anIntArray47[int_0]];
      if (int_1 != 0) {
        int_1 -= 256;

        IdentityConfig kitdefinition_0;
        do {
          if (!bool_0) {
            --int_1;
            if (int_1 < 0) {
              int_1 = IdentityConfig.anInt429 - 1;
            }
          } else {
            ++int_1;
            if (int_1 >= IdentityConfig.anInt429) {
              int_1 = 0;
            }
          }

          kitdefinition_0 = MapIconConfig.getKitDefinition(int_1);
        } while (kitdefinition_0 == null || kitdefinition_0.nonSelectable
            || kitdefinition_0.bodyPartId != (isFemale ? 7 : 0) + int_0);

        equipmentIds[anIntArray47[int_0]] = int_1 + 256;
        setHash();
      }
    }
  }

  public void method504(final int int_0, final boolean bool_0) {
    int int_1 = bodyPartColours[int_0];
    if (!bool_0) {
      do {
        --int_1;
        if (int_1 < 0) {
          int_1 = colorsToReplace[int_0].length - 1;
        }
      } while (!Class17.method201(int_0, int_1));
    } else {
      do {
        ++int_1;
        if (int_1 >= colorsToReplace[int_0].length) {
          int_1 = 0;
        }
      } while (!Class17.method201(int_0, int_1));
    }

    bodyPartColours[int_0] = int_1;
    setHash();
  }

  public void method505(final boolean bool_0) {
    if (isFemale != bool_0) {
      method499(null, bodyPartColours, bool_0, -1);
    }
  }

  public void method506(final Buffer buffer_0) {
    buffer_0.putByte(isFemale ? 1 : 0);

    int int_0;
    for (int_0 = 0; int_0 < 7; int_0++) {
      final int int_1 = equipmentIds[anIntArray47[int_0]];
      if (int_1 == 0) {
        buffer_0.putByte(-1);
      } else {
        buffer_0.putByte(int_1 - 256);
      }
    }

    for (int_0 = 0; int_0 < 5; int_0++) {
      buffer_0.putByte(bodyPartColours[int_0]);
    }

  }

}
