package jagex.oldschool;

import jagex.oldschool.collections.HashTable;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.ui.Inventory;

public class RemoteEnvironment {

  public static final RemoteEnvironment LIVE;
  public static final RemoteEnvironment LIVE_BUILD;
  public static final RemoteEnvironment RELEASE_CANDIDATE;
  public static final RemoteEnvironment WORK_IN_PROGRESS;

  static {
    LIVE = new RemoteEnvironment("LIVE", 0);
    LIVE_BUILD = new RemoteEnvironment("BUILDLIVE", 3);
    RELEASE_CANDIDATE = new RemoteEnvironment("RC", 1);
    WORK_IN_PROGRESS = new RemoteEnvironment("WIP", 2);
  }

  public final String identifier;
  public final int ordinal;

  RemoteEnvironment(final String identifier, final int ordinal) {
    this.identifier = identifier;
    this.ordinal = ordinal;
  }

  public static CacheableNode_Sub2 method523(final int int_0) {
    CacheableNode_Sub2 cacheablenode_sub2_0 = (CacheableNode_Sub2) CacheableNode_Sub2.aNodeCache12
        .get(int_0);
    if (cacheablenode_sub2_0 != null) {
      return cacheablenode_sub2_0;
    }
    final byte[] bytes_0 = CacheableNode_Sub2.anIndexDataBase23.get(32, int_0);
    cacheablenode_sub2_0 = new CacheableNode_Sub2();
    if (bytes_0 != null) {
      cacheablenode_sub2_0.method833(new Buffer(bytes_0));
    }

    CacheableNode_Sub2.aNodeCache12.put(cacheablenode_sub2_0, int_0);
    return cacheablenode_sub2_0;
  }

  public static CacheableNode_Sub3 method524(final int int_0) {
    CacheableNode_Sub3 cacheablenode_sub3_0 = (CacheableNode_Sub3) CacheableNode_Sub3.aNodeCache14
        .get(int_0);
    if (cacheablenode_sub3_0 != null) {
      return cacheablenode_sub3_0;
    }
    final byte[] bytes_0 = CacheableNode_Sub3.anIndexDataBase26.get(11, int_0);
    cacheablenode_sub3_0 = new CacheableNode_Sub3();
    if (bytes_0 != null) {
      cacheablenode_sub3_0.method844(new Buffer(bytes_0));
    }

    cacheablenode_sub3_0.method843();
    CacheableNode_Sub3.aNodeCache14.put(cacheablenode_sub3_0, int_0);
    return cacheablenode_sub3_0;
  }

  static void method525() {
    Inventory.inventories = new HashTable(32);
  }

}
