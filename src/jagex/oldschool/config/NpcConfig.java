package jagex.oldschool.config;

import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.ChatLineBuffer;
import jagex.oldschool.Class10;
import jagex.oldschool.util.Timestamp;
import jagex.oldschool.Class85;
import jagex.oldschool.Class90;
import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.Overlay;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.RemoteRequest;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.io.Buffer;

public class NpcConfig extends Subnode {

  public static Cache npcModelCache;
  public static Cache npcs;
  public static AbstractPackage anIndexDataBase29;

  static {
    npcs = new Cache(64);
    npcModelCache = new Cache(50);
  }

  public int[] configs;
  public String name;
  public int id;
  public int anInt477;
  public int anInt478;
  public int anInt479;
  public int anInt480;
  public int anInt481;
  public String[] actions;
  public boolean isMinimapVisible;
  public int anInt484;
  public int anInt485;
  public int combatLevel;
  public boolean isVisible;
  public int anInt487;
  public int anInt489;
  public int anInt490;
  public boolean aBool60;
  public boolean isClickable;
  public boolean aBool61;
  IterableHashTable anIterableHashTable4;
  int varpIndex;
  int varp32Index;
  int[] anIntArray105;
  int[] models;
  int anInt482;
  short[] colors;
  int anInt483;
  short[] aShortArray10;
  short[] modifiedColors;
  short[] aShortArray11;
  int anInt486;
  int anInt488;

  public NpcConfig() {
    name = "null";
    anInt477 = 1;
    anInt478 = -1;
    anInt480 = -1;
    anInt481 = -1;
    anInt479 = -1;
    anInt484 = -1;
    anInt485 = -1;
    anInt487 = -1;
    actions = new String[5];
    isMinimapVisible = true;
    combatLevel = -1;
    anInt482 = 128;
    anInt483 = 128;
    isVisible = false;
    anInt486 = 0;
    anInt488 = 0;
    anInt489 = -1;
    anInt490 = 32;
    varpIndex = -1;
    varp32Index = -1;
    aBool60 = true;
    isClickable = true;
    aBool61 = false;
  }

  public static Overlay method868(final int int_0) {
    Overlay overlay_0 = (Overlay) Overlay.overlays.get(int_0);
    if (overlay_0 != null) {
      return overlay_0;
    }
    final byte[] bytes_0 = Class90.overlay_ref.get(4, int_0);
    overlay_0 = new Overlay();
    if (bytes_0 != null) {
      overlay_0.decode(new Buffer(bytes_0), int_0);
    }

    overlay_0.post();
    Overlay.overlays.put(overlay_0, int_0);
    return overlay_0;
  }

  public final NpcConfig transform() {
    int int_0 = -1;
    if (varpIndex != -1) {
      int_0 = PrimitiveType.method629(varpIndex);
    } else if (varp32Index != -1) {
      int_0 = Class85.widgetSettings[varp32Index];
    }

    int int_1;
    if (int_0 >= 0 && int_0 < configs.length - 1) {
      int_1 = configs[int_0];
    } else {
      int_1 = configs[configs.length - 1];
    }

    return int_1 != -1 ? Timestamp.getNpcDefinition(int_1) : null;
  }

  void method862(final Buffer buffer_0, final int int_0) {
    int int_1;
    int int_2;
    if (int_0 == 1) {
      int_1 = buffer_0.getUnsignedByte();
      models = new int[int_1];

      for (int_2 = 0; int_2 < int_1; int_2++) {
        models[int_2] = buffer_0.getUnsignedShort();
      }

    } else {
      if (int_0 == 2) {
        name = buffer_0.getString();
      } else {
        if (int_0 == 12) {
          anInt477 = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 13) {
          anInt478 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 14) {
          anInt479 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 15) {
          anInt480 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 16) {
          anInt481 = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 17) {
          anInt479 = buffer_0.getUnsignedShort();
          anInt484 = buffer_0.getUnsignedShort();
          anInt485 = buffer_0.getUnsignedShort();
          anInt487 = buffer_0.getUnsignedShort();
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
            colors = new short[int_1];
            modifiedColors = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              colors[int_2] = (short) buffer_0.getUnsignedShort();
              modifiedColors[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 41) {
            int_1 = buffer_0.getUnsignedByte();
            aShortArray10 = new short[int_1];
            aShortArray11 = new short[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              aShortArray10[int_2] = (short) buffer_0.getUnsignedShort();
              aShortArray11[int_2] = (short) buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 60) {
            int_1 = buffer_0.getUnsignedByte();
            anIntArray105 = new int[int_1];

            for (int_2 = 0; int_2 < int_1; int_2++) {
              anIntArray105[int_2] = buffer_0.getUnsignedShort();
            }

            return;
          }

          if (int_0 == 93) {
            isMinimapVisible = false;
            return;
          }

          if (int_0 == 95) {
            combatLevel = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 97) {
            anInt482 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 98) {
            anInt483 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 99) {
            isVisible = true;
            return;
          }

          if (int_0 == 100) {
            anInt486 = buffer_0.getByte();
            return;
          }

          if (int_0 == 101) {
            anInt488 = buffer_0.getByte() * 5;
            return;
          }

          if (int_0 == 102) {
            anInt489 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 103) {
            anInt490 = buffer_0.getUnsignedShort();
            return;
          }

          if (int_0 == 106 || int_0 == 118) {
            varpIndex = buffer_0.getUnsignedShort();
            if (varpIndex == 65535) {
              varpIndex = -1;
            }

            varp32Index = buffer_0.getUnsignedShort();
            if (varp32Index == 65535) {
              varp32Index = -1;
            }

            int_1 = -1;
            if (int_0 == 118) {
              int_1 = buffer_0.getUnsignedShort();
              if (int_1 == 65535) {
                int_1 = -1;
              }
            }

            int_2 = buffer_0.getUnsignedByte();
            configs = new int[int_2 + 2];

            for (int int_3 = 0; int_3 <= int_2; int_3++) {
              configs[int_3] = buffer_0.getUnsignedShort();
              if (configs[int_3] == 65535) {
                configs[int_3] = -1;
              }
            }

            configs[int_2 + 1] = int_1;
            return;
          }

          if (int_0 == 107) {
            aBool60 = false;
            return;
          }

          if (int_0 == 109) {
            isClickable = false;
            return;
          }

          if (int_0 == 111) {
            aBool61 = true;
            return;
          }

          if (int_0 == 249) {
            anIterableHashTable4 = RemoteRequest.method780(buffer_0, anIterableHashTable4);
            return;
          }
        }
      }

    }
  }

  public final ModelBase method863() {
    if (configs != null) {
      final NpcConfig npccomposition_1 = transform();
      return npccomposition_1 == null ? null : npccomposition_1.method863();
    }
    if (anIntArray105 == null) {
      return null;
    }
    boolean bool_0 = false;

    for (int int_0 = 0; int_0 < anIntArray105.length; int_0++) {
      if (!anIndexDataBase29.method450(anIntArray105[int_0], 0)) {
        bool_0 = true;
      }
    }

    if (bool_0) {
      return null;
    }
    final ModelBase[] modeldatas_0 = new ModelBase[anIntArray105.length];

    for (int int_1 = 0; int_1 < anIntArray105.length; int_1++) {
      modeldatas_0[int_1] = ModelBase.decode(anIndexDataBase29, anIntArray105[int_1], 0);
    }

    ModelBase modeldata_0;
    if (modeldatas_0.length == 1) {
      modeldata_0 = modeldatas_0[0];
    } else {
      modeldata_0 = new ModelBase(modeldatas_0, modeldatas_0.length);
    }

    int int_2;
    if (colors != null) {
      for (int_2 = 0; int_2 < colors.length; int_2++) {
        modeldata_0.replaceColor(colors[int_2], modifiedColors[int_2]);
      }
    }

    if (aShortArray10 != null) {
      for (int_2 = 0; int_2 < aShortArray10.length; int_2++) {
        modeldata_0.method1009(aShortArray10[int_2], aShortArray11[int_2]);
      }
    }

    return modeldata_0;
  }

  public final Model method864(final AnimationSequence sequence_0, final int int_0,
      final AnimationSequence sequence_1,
      final int int_1) {
    if (configs != null) {
      final NpcConfig npccomposition_1 = transform();
      return npccomposition_1 == null ? null
          : npccomposition_1.method864(sequence_0, int_0, sequence_1, int_1);
    }
    Model model_0 = (Model) npcModelCache.get(id);
    if (model_0 == null) {
      boolean bool_0 = false;

      for (int int_2 = 0; int_2 < models.length; int_2++) {
        if (!anIndexDataBase29.method450(models[int_2], 0)) {
          bool_0 = true;
        }
      }

      if (bool_0) {
        return null;
      }

      final ModelBase[] modeldatas_0 = new ModelBase[models.length];

      int int_3;
      for (int_3 = 0; int_3 < models.length; int_3++) {
        modeldatas_0[int_3] = ModelBase.decode(anIndexDataBase29, models[int_3], 0);
      }

      ModelBase modeldata_0;
      if (modeldatas_0.length == 1) {
        modeldata_0 = modeldatas_0[0];
      } else {
        modeldata_0 = new ModelBase(modeldatas_0, modeldatas_0.length);
      }

      if (colors != null) {
        for (int_3 = 0; int_3 < colors.length; int_3++) {
          modeldata_0.replaceColor(colors[int_3], modifiedColors[int_3]);
        }
      }

      if (aShortArray10 != null) {
        for (int_3 = 0; int_3 < aShortArray10.length; int_3++) {
          modeldata_0.method1009(aShortArray10[int_3], aShortArray11[int_3]);
        }
      }

      model_0 = modeldata_0.applyLighting(anInt486 + 64, anInt488 + 850, -30, -50, -30);
      npcModelCache.put(model_0, id);
    }

    Model model_1;
    if (sequence_0 != null && sequence_1 != null) {
      model_1 = sequence_0.method874(model_0, int_0, sequence_1, int_1);
    } else if (sequence_0 != null) {
      model_1 = sequence_0.method873(model_0, int_0);
    } else if (sequence_1 != null) {
      model_1 = sequence_1.method873(model_0, int_1);
    } else {
      model_1 = model_0.method972(true);
    }

    if (anInt482 != 128 || anInt483 != 128) {
      model_1.method979(anInt482, anInt483, anInt482);
    }

    return model_1;
  }

  public void post() {
  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method862(buffer_0, int_0);
    }
  }

  public boolean method865() {
    if (configs == null) {
      return true;
    }
    int int_0 = -1;
    if (varpIndex != -1) {
      int_0 = PrimitiveType.method629(varpIndex);
    } else if (varp32Index != -1) {
      int_0 = Class85.widgetSettings[varp32Index];
    }

    return int_0 >= 0 && int_0 < configs.length ? configs[int_0] != -1
        : configs[configs.length - 1] != -1;
  }

  public int method866(final int int_0, final int int_1) {
    return ChatLineBuffer.method13(anIterableHashTable4, int_0, int_1);
  }

  public String method867(final int int_0, final String string_0) {
    return Class10.method158(anIterableHashTable4, int_0, string_0);
  }

}
