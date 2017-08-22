package jagex.oldschool.config;

import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class SpotAnimationConfig extends Subnode {

  public static Cache aNodeCache6;
  public static Cache spotanims;
  public static AbstractPackage anIndexDataBase14;
  public static AbstractPackage anIndexDataBase15;

  static {
    spotanims = new Cache(64);
    aNodeCache6 = new Cache(30);
  }

  public int sequenceId;
  public int id;
  int anInt409;
  int anInt410;
  int anInt411;
  int anInt412;
  int anInt413;
  int anInt414;
  short[] aShortArray6;
  short[] aShortArray7;
  short[] aShortArray8;
  short[] aShortArray9;

  public SpotAnimationConfig() {
    sequenceId = -1;
    anInt410 = 128;
    anInt411 = 128;
    anInt412 = 0;
    anInt413 = 0;
    anInt414 = 0;
  }

  void method728(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      anInt409 = buffer_0.getUnsignedShort();
    } else {
      if (int_0 == 2) {
        sequenceId = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 4) {
        anInt410 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 5) {
        anInt411 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 6) {
        anInt412 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 7) {
        anInt413 = buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 8) {
        anInt414 = buffer_0.getUnsignedByte();
        return;
      }

      int int_1;
      int int_2;
      if (int_0 == 40) {
        int_1 = buffer_0.getUnsignedByte();
        aShortArray6 = new short[int_1];
        aShortArray8 = new short[int_1];

        for (int_2 = 0; int_2 < int_1; int_2++) {
          aShortArray6[int_2] = (short) buffer_0.getUnsignedShort();
          aShortArray8[int_2] = (short) buffer_0.getUnsignedShort();
        }

        return;
      }

      if (int_0 == 41) {
        int_1 = buffer_0.getUnsignedByte();
        aShortArray7 = new short[int_1];
        aShortArray9 = new short[int_1];

        for (int_2 = 0; int_2 < int_1; int_2++) {
          aShortArray7[int_2] = (short) buffer_0.getUnsignedShort();
          aShortArray9[int_2] = (short) buffer_0.getUnsignedShort();
        }
      }
    }

  }

  public final Model method729(final int int_0) {
    Model model_0 = (Model) aNodeCache6.get(id);
    if (model_0 == null) {
      final ModelBase modeldata_0 = ModelBase.decode(anIndexDataBase14, anInt409, 0);
      if (modeldata_0 == null) {
        return null;
      }

      int int_1;
      if (aShortArray6 != null) {
        for (int_1 = 0; int_1 < aShortArray6.length; int_1++) {
          modeldata_0.replaceColor(aShortArray6[int_1], aShortArray8[int_1]);
        }
      }

      if (aShortArray7 != null) {
        for (int_1 = 0; int_1 < aShortArray7.length; int_1++) {
          modeldata_0.method1009(aShortArray7[int_1], aShortArray9[int_1]);
        }
      }

      model_0 = modeldata_0.applyLighting(anInt413 + 64, anInt414 + 850, -30, -50, -30);
      aNodeCache6.put(model_0, id);
    }

    Model model_1;
    if (sequenceId != -1 && int_0 != -1) {
      model_1 = PendingSpawn.getAnimationSequence(sequenceId).method876(model_0, int_0);
    } else {
      model_1 = model_0.method974(true);
    }

    if (anInt410 != 128 || anInt411 != 128) {
      model_1.method979(anInt410, anInt411, anInt410);
    }

    if (anInt412 != 0) {
      if (anInt412 == 90) {
        model_1.method980();
      }

      if (anInt412 == 180) {
        model_1.method980();
        model_1.method980();
      }

      if (anInt412 == 270) {
        model_1.method980();
        model_1.method980();
        model_1.method980();
      }
    }

    return model_1;
  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method728(buffer_0, int_0);
    }
  }

}
