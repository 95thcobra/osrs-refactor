package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.asset.RemoteRequest;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class CacheableNode_Sub4 extends Subnode {

  public static Cache aNodeCache15;
  public static Package indexTrack1;
  static AbstractPackage anIndexDataBase27;

  static {
    aNodeCache15 = new Cache(64);
  }

  IterableHashTable anIterableHashTable3;

  static void method855(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7, final int int_8) {
    PendingSpawn pendingspawn_0 = null;

    for (PendingSpawn pendingspawn_1 = (PendingSpawn) Client.pendingSpawns
        .getFirst(); pendingspawn_1 != null;
        pendingspawn_1 = (PendingSpawn) Client.pendingSpawns.getNext()) {
      if (int_0 == pendingspawn_1.level && pendingspawn_1.x == int_1 && int_2
          == pendingspawn_1.y
          && int_3 == pendingspawn_1.type) {
        pendingspawn_0 = pendingspawn_1;
        break;
      }
    }

    if (pendingspawn_0 == null) {
      pendingspawn_0 = new PendingSpawn();
      pendingspawn_0.level = int_0;
      pendingspawn_0.type = int_3;
      pendingspawn_0.x = int_1;
      pendingspawn_0.y = int_2;
      Class8.method154(pendingspawn_0);
      Client.pendingSpawns.addLast(pendingspawn_0);
    }

    pendingspawn_0.id = int_4;
    pendingspawn_0.anInt336 = int_5;
    pendingspawn_0.orientation = int_6;
    pendingspawn_0.delay = int_7;
    pendingspawn_0.hitpoints = int_8;
  }

  void method850(final Buffer buffer_0, final int int_0) {
    if (int_0 == 249) {
      anIterableHashTable3 = RemoteRequest.method780(buffer_0, anIterableHashTable3);
    }

  }

  public String method851(final int int_0, final String string_0) {
    return Class10.method158(anIterableHashTable3, int_0, string_0);
  }

  public int method852(final int int_0, final int int_1) {
    return ChatLineBuffer.method13(anIterableHashTable3, int_0, int_1);
  }

  void method853() {
  }

  void method854(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method850(buffer_0, int_0);
    }
  }

}
