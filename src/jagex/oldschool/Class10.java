package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.collections.ObjectNode;

public final class Class10 {

  static byte[][] aByteArrayArray1;
  static int anInt50;
  static long aLong1;
  final Class7 this$0;
  int anInt51;
  int anInt52;
  int anInt53;
  int anInt54;

  Class10(final Class7 class7_0) {
    this$0 = class7_0;
  }

  public static String method158(final IterableHashTable iterablehashtable_0, final int int_0,
      final String string_0) {
    if (iterablehashtable_0 == null) {
      return string_0;
    }
    final ObjectNode objectnode_0 = (ObjectNode) iterablehashtable_0.get(int_0);
    return objectnode_0 == null ? string_0 : (String) objectnode_0.value;
  }

  public static void method159(final AbstractPackage indexdatabase_0) {
    CacheableNode_Sub4.anIndexDataBase27 = indexdatabase_0;
  }

}
