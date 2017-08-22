package jagex.oldschool.asset;

import jagex.oldschool.Interface3;
import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.collections.Node;
import jagex.oldschool.collections.ObjectNode;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileCache;

public class RemoteRequest extends Subnode {

  public static Interface3 anInterface3_1;
  public byte padding;
  public Package index;
  public int checksum;

  public static IterableHashTable method780(final Buffer buffer_0,
      IterableHashTable iterablehashtable_0) {
    final int int_0 = buffer_0.getUnsignedByte();
    int int_1;
    if (iterablehashtable_0 == null) {
      int_1 = FileCache.method72(int_0);
      iterablehashtable_0 = new IterableHashTable(int_1);
    }

    for (int_1 = 0; int_1 < int_0; int_1++) {
      final boolean bool_0 = buffer_0.getUnsignedByte() == 1;
      final int int_2 = buffer_0.getUnsignedMedium();
      Object object_0;
      if (bool_0) {
        object_0 = new ObjectNode(buffer_0.getString());
      } else {
        object_0 = new IntegerNode(buffer_0.getInt());
      }

      iterablehashtable_0.put((Node) object_0, (long) int_2);
    }

    return iterablehashtable_0;
  }

}
