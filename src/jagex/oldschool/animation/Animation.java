package jagex.oldschool.animation;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.Subnode;

public class Animation extends Subnode {

  public Frame[] frames;

  public Animation(final AbstractPackage frames, final AbstractPackage bases,
      final int parent,
      final boolean useParent) {
    final Deque deque = new Deque();
    final int count = frames.fileCount(parent);
    this.frames = new Frame[count];
    final int[] ids = frames.getChilds(parent);

    for (int i = 0; i < ids.length; i++) {
      final byte[] frameSrc = frames.get(parent, ids[i]);
      FrameBase base = null;
      final int id = (frameSrc[0] & 0xFF) << 8 | frameSrc[1] & 0xFF;

      for (FrameBase b = (FrameBase) deque.getFirst(); b != null; b = (FrameBase) deque.getNext()) {
        if (id == b.id) {
          base = b;
          break;
        }
      }

      if (base == null) {
        byte[] baseSrc;
        if (useParent) {
          baseSrc = bases.getChild(0, id);
        } else {
          baseSrc = bases.getChild(id, 0);
        }

        base = new FrameBase(id, baseSrc);
        deque.addLast(base);
      }

      this.frames[ids[i]] = new Frame(frameSrc, base);
    }

  }

  public static void method849() {
    AnimationSequence.sequences.reset();
    AnimationSequence.animations.reset();
  }

  public boolean method848(final int int_0) {
    return frames[int_0].showing;
  }

}
