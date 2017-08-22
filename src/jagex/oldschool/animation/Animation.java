package jagex.oldschool.animation;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.Subnode;

public class Animation extends Subnode {

  public Frame[] frames;

  public Animation(final AbstractPackage indexdatabase_0, final AbstractPackage indexdatabase_1,
      final int int_0,
      final boolean bool_0) {
    final Deque deque_0 = new Deque();
    final int int_1 = indexdatabase_0.fileCount(int_0);
    frames = new Frame[int_1];
    final int[] ints_0 = indexdatabase_0.getChilds(int_0);

    for (int int_2 = 0; int_2 < ints_0.length; int_2++) {
      final byte[] bytes_0 = indexdatabase_0.get(int_0, ints_0[int_2]);
      FrameBase framemap_0 = null;
      final int int_3 = (bytes_0[0] & 0xFF) << 8 | bytes_0[1] & 0xFF;

      for (FrameBase framemap_1 = (FrameBase) deque_0
          .getFirst(); framemap_1 != null; framemap_1 = (FrameBase) deque_0.getNext()) {
        if (int_3 == framemap_1.id) {
          framemap_0 = framemap_1;
          break;
        }
      }

      if (framemap_0 == null) {
        byte[] bytes_1;
        if (bool_0) {
          bytes_1 = indexdatabase_1.getChild(0, int_3);
        } else {
          bytes_1 = indexdatabase_1.getChild(int_3, 0);
        }

        framemap_0 = new FrameBase(int_3, bytes_1);
        deque_0.addLast(framemap_0);
      }

      frames[ints_0[int_2]] = new Frame(bytes_0, framemap_0);
    }

  }

  public static void method849() {
    AnimationSequence.sequences.reset();
    AnimationSequence.skeletons.reset();
  }

  public boolean method848(final int int_0) {
    return frames[int_0].showing;
  }

}
