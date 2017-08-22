package jagex.oldschool.scene;

import jagex.oldschool.AClass2_Sub1;
import jagex.oldschool.Class11;
import jagex.oldschool.util.Timestamp;
import jagex.oldschool.Client;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.Model;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.PlayerIdentity;
import jagex.oldschool.RuntimeException_Sub1;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.io.Buffer;

public final class Player extends Mobile {

  public static int[][] xteaKeys;
  public static int anInt578;
  public PlayerIdentity composition;
  public int skullIcon;
  public int overheadIcon;
  public boolean aBool75;
  public String[] actions;
  public int combatLevel;
  public int totalLevel;
  public int team;
  public int anInt579;
  public int anInt580;
  public boolean hidden;
  public boolean aBool76;
  public Model model;
  public int anInt581;
  public int anInt582;
  public int anInt583;
  public int anInt584;
  public int anInt585;
  public String name;
  public int anInt586;
  public int anInt587;
  public int anInt588;
  public int anInt589;
  public int anInt590;
  public int anInt591;
  public int anInt592;

  public Player() {
    skullIcon = -1;
    overheadIcon = -1;
    actions = new String[3];

    for (int int_0 = 0; int_0 < 3; int_0++) {
      actions[int_0] = "";
    }

    combatLevel = 0;
    totalLevel = 0;
    anInt579 = 0;
    anInt580 = 0;
    aBool75 = false;
    team = 0;
    hidden = false;
    aBool76 = false;
  }

  @Override
  public final Model getModel() {
    if (composition == null) {
      return null;
    }
    final AnimationSequence sequence_0 = super.animation != -1 && super.actionAnimationDisable == 0
        ? PendingSpawn.getAnimationSequence(super.animation)
        : null;
    final AnimationSequence sequence_1 = super.poseAnimation != -1 && !aBool75
        && (super.poseAnimation != super.idlePoseAnimation || sequence_0 == null)
        ? PendingSpawn.getAnimationSequence(super.poseAnimation)
        : null;
    Model model_0 = composition
        .method500(sequence_0, super.actionFrame, sequence_1, super.poseFrame);
    if (model_0 == null) {
      return null;
    }
    model_0.calculateRectangularBounds();
    super.anInt507 = model_0.minimumY;
    Model model_1;
    Model[] models_0;
    if (!aBool75 && super.graphic != -1 && super.anInt508 != -1) {
      model_1 = Class11.getSpotAnimationConfig(super.graphic).method729(super.anInt508);
      if (model_1 != null) {
        model_1.method985(0, -super.anInt512, 0);
        models_0 = new Model[] {model_0, model_1};
        model_0 = new Model(models_0, 2);
      }
    }

    if (!aBool75 && model != null) {
      if (Client.tick >= anInt580) {
        model = null;
      }

      if (Client.tick >= anInt579 && Client.tick < anInt580) {
        model_1 = model;
        model_1.method985(anInt581 - super.x, anInt582 - anInt583, anInt584 - super.y);
        if (super.orientation == 512) {
          model_1.method980();
          model_1.method980();
          model_1.method980();
        } else if (super.orientation == 1024) {
          model_1.method980();
          model_1.method980();
        } else if (super.orientation == 1536) {
          model_1.method980();
        }

        models_0 = new Model[] {model_0, model_1};
        model_0 = new Model(models_0, 2);
        if (super.orientation == 512) {
          model_1.method980();
        } else if (super.orientation == 1024) {
          model_1.method980();
          model_1.method980();
        } else if (super.orientation == 1536) {
          model_1.method980();
          model_1.method980();
          model_1.method980();
        }

        model_1.method985(super.x - anInt581, anInt583 - anInt582, super.y - anInt584);
      }
    }

    model_0.aBool68 = true;
    return model_0;
  }

  public void method1050(final int int_0, final int int_1) {
    super.queueSize = 0;
    super.anInt497 = 0;
    super.anInt498 = 0;
    super.pathX[0] = int_0;
    super.pathY[0] = int_1;
    final int int_2 = getSize();
    super.x = super.pathX[0] * 128 + int_2 * 64;
    super.y = int_2 * 64 + super.pathY[0] * 128;
  }

  public int getSize() {
    return composition != null && composition.transformedNpcId != -1
        ? Timestamp.getNpcDefinition(composition.transformedNpcId).anInt477
        : 1;
  }

  public final void method1051(final int int_0, final int int_1, final byte byte_0) {
    if (super.queueSize < 9) {
      ++super.queueSize;
    }

    for (int int_2 = super.queueSize; int_2 > 0; --int_2) {
      super.pathX[int_2] = super.pathX[int_2 - 1];
      super.pathY[int_2] = super.pathY[int_2 - 1];
      super.aByteArray20[int_2] = super.aByteArray20[int_2 - 1];
    }

    super.pathX[0] = int_0;
    super.pathY[0] = int_1;
    super.aByteArray20[0] = byte_0;
  }

  @Override
  public final boolean hasConfig() {
    return composition != null;
  }

  public final void decode(final Buffer buffer_0) {
    buffer_0.offset = 0;
    final int int_0 = buffer_0.getUnsignedByte();
    skullIcon = buffer_0.getByte();
    overheadIcon = buffer_0.getByte();
    int int_1 = -1;
    team = 0;
    final int[] ints_0 = new int[12];

    int int_3;
    int int_4;
    for (int int_2 = 0; int_2 < 12; int_2++) {
      int_3 = buffer_0.getUnsignedByte();
      if (int_3 == 0) {
        ints_0[int_2] = 0;
      } else {
        int_4 = buffer_0.getUnsignedByte();
        ints_0[int_2] = int_4 + (int_3 << 8);
        if (int_2 == 0 && ints_0[0] == 65535) {
          int_1 = buffer_0.getUnsignedShort();
          break;
        }

        if (ints_0[int_2] >= 512) {
          final int int_5 = AudioWorker.getItemDefinition(ints_0[int_2] - 512).anInt492;
          if (int_5 != 0) {
            team = int_5;
          }
        }
      }
    }

    final int[] ints_1 = new int[5];

    for (int_3 = 0; int_3 < 5; int_3++) {
      int_4 = buffer_0.getUnsignedByte();
      if (int_4 < 0 || int_4 >= PlayerIdentity.colorsToReplace[int_3].length) {
        int_4 = 0;
      }

      ints_1[int_3] = int_4;
    }

    super.idlePoseAnimation = buffer_0.getUnsignedShort();
    if (super.idlePoseAnimation == 65535) {
      super.idlePoseAnimation = -1;
    }

    super.anInt500 = buffer_0.getUnsignedShort();
    if (super.anInt500 == 65535) {
      super.anInt500 = -1;
    }

    super.anInt501 = super.anInt500;
    super.anInt502 = buffer_0.getUnsignedShort();
    if (super.anInt502 == 65535) {
      super.anInt502 = -1;
    }

    super.anInt503 = buffer_0.getUnsignedShort();
    if (super.anInt503 == 65535) {
      super.anInt503 = -1;
    }

    super.anInt504 = buffer_0.getUnsignedShort();
    if (super.anInt504 == 65535) {
      super.anInt504 = -1;
    }

    super.anInt505 = buffer_0.getUnsignedShort();
    if (super.anInt505 == 65535) {
      super.anInt505 = -1;
    }

    super.anInt506 = buffer_0.getUnsignedShort();
    if (super.anInt506 == 65535) {
      super.anInt506 = -1;
    }

    name = buffer_0.getString();
    if (this == GrandExchangeOffer.localPlayer) {
      RuntimeException_Sub1.aString31 = name;
    }

    combatLevel = buffer_0.getUnsignedByte();
    totalLevel = buffer_0.getUnsignedShort();
    hidden = buffer_0.getUnsignedByte() == 1;
    if (Client.socketType == 0 && Client.rights >= 2) {
      hidden = false;
    }

    if (composition == null) {
      composition = new PlayerIdentity();
    }

    composition.method499(ints_0, ints_1, int_0 == 1, int_1);
  }

  public final void method1052(final int int_0, final int int_1, final byte byte_0) {
    if (super.animation != -1 && PendingSpawn.getAnimationSequence(super.animation).priority == 1) {
      super.animation = -1;
    }

    super.anInt496 = -1;
    if (int_0 >= 0 && int_0 < 104 && int_1 >= 0 && int_1 < 104) {
      if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
        if (byte_0 == 2) {
          AClass2_Sub1.method615(this, int_0, int_1, (byte) 2);
        }

        method1051(int_0, int_1, byte_0);
      } else {
        method1050(int_0, int_1);
      }
    } else {
      method1050(int_0, int_1);
    }
  }

}
