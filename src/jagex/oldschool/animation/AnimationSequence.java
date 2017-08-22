package jagex.oldschool.animation;

import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.Class102;
import jagex.oldschool.graphics.SpriteLoader;
import jagex.oldschool.Class4;
import jagex.oldschool.Class94;
import jagex.oldschool.Model;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.security.Isaac;

public class AnimationSequence extends Subnode {

  public static AbstractPackage skin_ref;
  public static AbstractPackage config;
  public static Cache skeletons;
  public static Cache sequences;
  public static int menuY;

  static {
    sequences = new Cache(64);
    skeletons = new Cache(100);
  }

  public int precedenceAnimating;
  public int[] frameIDs;
  public int priority;
  public int frameStep;
  public int[] frameLenghts;
  public boolean stretches;
  public int leftHandItem;
  public int forcedPriority;
  public int rightHandItem;
  public int maxLoops;
  public int replyMode;
  public int[] anIntArray108;
  int[] interleaveLeave;
  int[] anIntArray107;

  public AnimationSequence() {
    frameStep = -1;
    stretches = false;
    forcedPriority = 5;
    leftHandItem = -1;
    rightHandItem = -1;
    maxLoops = 99;
    precedenceAnimating = -1;
    priority = -1;
    replyMode = 2;
  }

  public static IndexedSprite method878(final AbstractPackage indexdatabase_0, final int int_0) {
    final byte[] bytes_0 = indexdatabase_0.method453(int_0);
    boolean bool_0;
    if (bytes_0 == null) {
      bool_0 = false;
    } else {
      Class102.decodeSprite(bytes_0);
      bool_0 = true;
    }

    if (!bool_0) {
      return null;
    }
    final IndexedSprite indexedsprite_0 = new IndexedSprite();
    indexedsprite_0.unpackedWidth = SpriteLoader.anInt204;
    indexedsprite_0.unpackedHeight = Isaac.anInt181;
    indexedsprite_0.offsetX = SpriteLoader.anIntArray56[0];
    indexedsprite_0.offsetY = CacheableNode_Sub1.offsetsY[0];
    indexedsprite_0.width = Class94.anIntArray48[0];
    indexedsprite_0.height = SpriteLoader.anIntArray57[0];
    indexedsprite_0.palette = SpriteLoader.anIntArray58;
    indexedsprite_0.pixels = SpriteLoader.spritePixels[0];
    SpriteLoader.anIntArray56 = null;
    CacheableNode_Sub1.offsetsY = null;
    Class94.anIntArray48 = null;
    SpriteLoader.anIntArray57 = null;
    SpriteLoader.anIntArray58 = null;
    SpriteLoader.spritePixels = null;
    return indexedsprite_0;
  }

  void method872(final Buffer buffer_0, final int int_0) {
    int int_1;
    int int_2;
    if (int_0 == 1) {
      int_1 = buffer_0.getUnsignedShort();
      frameLenghts = new int[int_1];

      for (int_2 = 0; int_2 < int_1; int_2++) {
        frameLenghts[int_2] = buffer_0.getUnsignedShort();
      }

      frameIDs = new int[int_1];

      for (int_2 = 0; int_2 < int_1; int_2++) {
        frameIDs[int_2] = buffer_0.getUnsignedShort();
      }

      for (int_2 = 0; int_2 < int_1; int_2++) {
        frameIDs[int_2] += buffer_0.getUnsignedShort() << 16;
      }

    } else {
      if (int_0 == 2) {
        frameStep = buffer_0.getUnsignedShort();
      } else {
        if (int_0 == 3) {
          int_1 = buffer_0.getUnsignedByte();
          interleaveLeave = new int[int_1 + 1];

          for (int_2 = 0; int_2 < int_1; int_2++) {
            interleaveLeave[int_2] = buffer_0.getUnsignedByte();
          }

          interleaveLeave[int_1] = 9999999;
          return;
        }

        if (int_0 == 4) {
          stretches = true;
          return;
        }

        if (int_0 == 5) {
          forcedPriority = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 6) {
          leftHandItem = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 7) {
          rightHandItem = buffer_0.getUnsignedShort();
          return;
        }

        if (int_0 == 8) {
          maxLoops = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 9) {
          precedenceAnimating = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 10) {
          priority = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 11) {
          replyMode = buffer_0.getUnsignedByte();
          return;
        }

        if (int_0 == 12) {
          int_1 = buffer_0.getUnsignedByte();
          anIntArray107 = new int[int_1];

          for (int_2 = 0; int_2 < int_1; int_2++) {
            anIntArray107[int_2] = buffer_0.getUnsignedShort();
          }

          for (int_2 = 0; int_2 < int_1; int_2++) {
            anIntArray107[int_2] += buffer_0.getUnsignedShort() << 16;
          }

          return;
        }

        if (int_0 == 13) {
          int_1 = buffer_0.getUnsignedByte();
          anIntArray108 = new int[int_1];

          for (int_2 = 0; int_2 < int_1; int_2++) {
            anIntArray108[int_2] = buffer_0.getUnsignedMedium();
          }
        }
      }

    }
  }

  public Model method873(final Model model_0, int int_0) {
    int_0 = frameIDs[int_0];
    final Animation frames_0 = Class4.getFrames(int_0 >> 16);
    int_0 &= 0xFFFF;
    if (frames_0 == null) {
      return model_0.method972(true);
    }
    final Model model_1 = model_0.method972(!frames_0.method848(int_0));
    model_1.method968(frames_0, int_0);
    return model_1;
  }

  public Model method874(final Model model_0, int int_0, final AnimationSequence sequence_1, int int_1) {
    int_0 = frameIDs[int_0];
    final Animation frames_0 = Class4.getFrames(int_0 >> 16);
    int_0 &= 0xFFFF;
    if (frames_0 == null) {
      return sequence_1.method873(model_0, int_1);
    }
    int_1 = sequence_1.frameIDs[int_1];
    final Animation frames_1 = Class4.getFrames(int_1 >> 16);
    int_1 &= 0xFFFF;
    Model model_1;
    if (frames_1 == null) {
      model_1 = model_0.method972(!frames_0.method848(int_0));
      model_1.method968(frames_0, int_0);
      return model_1;
    }
    model_1 = model_0.method972(!frames_0.method848(int_0) & !frames_1.method848(int_1));
    model_1.method982(frames_0, int_0, frames_1, int_1, interleaveLeave);
    return model_1;
  }

  public Model method875(final Model model_0, int int_0, int int_1) {
    int_0 = frameIDs[int_0];
    final Animation frames_0 = Class4.getFrames(int_0 >> 16);
    int_0 &= 0xFFFF;
    if (frames_0 == null) {
      return model_0.method972(true);
    }
    final Model model_1 = model_0.method972(!frames_0.method848(int_0));
    int_1 &= 0x3;
    if (int_1 == 1) {
      model_1.method977();
    } else if (int_1 == 2) {
      model_1.method978();
    } else if (int_1 == 3) {
      model_1.method980();
    }

    model_1.method968(frames_0, int_0);
    if (int_1 == 1) {
      model_1.method980();
    } else if (int_1 == 2) {
      model_1.method978();
    } else if (int_1 == 3) {
      model_1.method977();
    }

    return model_1;
  }

  public Model method876(final Model model_0, int int_0) {
    int_0 = frameIDs[int_0];
    final Animation frames_0 = Class4.getFrames(int_0 >> 16);
    int_0 &= 0xFFFF;
    if (frames_0 == null) {
      return model_0.method974(true);
    }
    final Model model_1 = model_0.method974(!frames_0.method848(int_0));
    model_1.method968(frames_0, int_0);
    return model_1;
  }

  public Model method877(final Model model_0, final int int_0) {
    int int_1 = frameIDs[int_0];
    final Animation frames_0 = Class4.getFrames(int_1 >> 16);
    int_1 &= 0xFFFF;
    if (frames_0 == null) {
      return model_0.method972(true);
    }
    Animation frames_1 = null;
    int int_2 = 0;
    if (anIntArray107 != null && int_0 < anIntArray107.length) {
      int_2 = anIntArray107[int_0];
      frames_1 = Class4.getFrames(int_2 >> 16);
      int_2 &= 0xFFFF;
    }

    Model model_1;
    if (frames_1 != null && int_2 != 65535) {
      model_1 = model_0.method972(!frames_0.method848(int_1) & !frames_1.method848(int_2));
      model_1.method968(frames_0, int_1);
      model_1.method968(frames_1, int_2);
      return model_1;
    }
    model_1 = model_0.method972(!frames_0.method848(int_1));
    model_1.method968(frames_0, int_1);
    return model_1;
  }

  public void post() {
    if (precedenceAnimating == -1) {
      if (interleaveLeave != null) {
        precedenceAnimating = 2;
      } else {
        precedenceAnimating = 0;
      }
    }

    if (priority == -1) {
      if (interleaveLeave != null) {
        priority = 2;
        return;
      }

      priority = 0;
    }

  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method872(buffer_0, int_0);
    }
  }

}
