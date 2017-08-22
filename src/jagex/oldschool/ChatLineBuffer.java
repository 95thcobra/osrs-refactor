package jagex.oldschool;

import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.device.MachineProfile;

public class ChatLineBuffer {

  static MachineProfile aMachineInfo1;
  MessageNode[] lines;
  int length;

  ChatLineBuffer() {
    lines = new MessageNode[100];
  }

  public static int method13(final IterableHashTable iterablehashtable_0, final int int_0,
      final int int_1) {
    if (iterablehashtable_0 == null) {
      return int_1;
    }
    final IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0.get(int_0);
    return integernode_0 == null ? int_1 : integernode_0.value;
  }

  MessageNode addMessage(final int int_0, final String string_0, final String string_1,
      final String string_2) {
    MessageNode messagenode_0 = lines[99];

    for (int int_1 = length; int_1 > 0; --int_1) {
      if (int_1 != 100) {
        lines[int_1] = lines[int_1 - 1];
      }
    }

    if (messagenode_0 == null) {
      messagenode_0 = new MessageNode(int_0, string_0, string_2, string_1);
    } else {
      messagenode_0.unlink();
      messagenode_0.unlinkSubnode();
      messagenode_0.setMessage(int_0, string_0, string_2, string_1);
    }

    lines[0] = messagenode_0;
    if (length < 100) {
      ++length;
    }

    return messagenode_0;
  }

  MessageNode method11(final int int_0) {
    return int_0 >= 0 && int_0 < length ? lines[int_0] : null;
  }

  int method12() {
    return length;
  }

}
