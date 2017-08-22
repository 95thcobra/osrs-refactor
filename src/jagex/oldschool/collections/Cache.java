package jagex.oldschool.collections;

public final class Cache {

  int anInt186;
  HashTable table;
  Queue list;
  Subnode aCacheableNode4;
  int anInt187;

  public Cache(final int int_0) {
    aCacheableNode4 = new Subnode();
    list = new Queue();
    anInt187 = int_0;
    anInt186 = int_0;

    int int_1;
    for (int_1 = 1; int_1 + int_1 < int_0; int_1 += int_1) {
    }

    table = new HashTable(int_1);
  }

  public Subnode get(final long long_0) {
    final Subnode cacheablenode_0 = (Subnode) table.get(long_0);
    if (cacheablenode_0 != null) {
      list.addFirst(cacheablenode_0);
    }

    return cacheablenode_0;
  }

  public void put(final Subnode cacheablenode_0, final long long_0) {
    if (anInt186 == 0) {
      Subnode cacheablenode_1 = list.poll();
      cacheablenode_1.unlink();
      cacheablenode_1.unlinkSubnode();
      if (cacheablenode_1 == aCacheableNode4) {
        cacheablenode_1 = list.poll();
        cacheablenode_1.unlink();
        cacheablenode_1.unlinkSubnode();
      }
    } else {
      --anInt186;
    }

    table.put(cacheablenode_0, long_0);
    list.addFirst(cacheablenode_0);
  }

  public void reset() {
    list.clear();
    table.method68();
    aCacheableNode4 = new Subnode();
    anInt186 = anInt187;
  }

  public void remove(final long long_0) {
    final Subnode cacheablenode_0 = (Subnode) table.get(long_0);
    if (cacheablenode_0 != null) {
      cacheablenode_0.unlink();
      cacheablenode_0.unlinkSubnode();
      ++anInt186;
    }

  }

}
