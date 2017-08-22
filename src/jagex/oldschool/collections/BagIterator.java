package jagex.oldschool.collections;

import java.util.Iterator;

public class BagIterator implements Iterator {

  Bag aClass76_2;
  Subnode aCacheableNode2;
  Subnode aCacheableNode3;

  BagIterator(final Bag class76_0) {
    aCacheableNode3 = null;
    aClass76_2 = class76_0;
    aCacheableNode2 = aClass76_2.head.prevSub;
    aCacheableNode3 = null;
  }

  @Override
  public Object next() {
    Subnode cacheablenode_0 = aCacheableNode2;
    if (cacheablenode_0 == aClass76_2.head) {
      cacheablenode_0 = null;
      aCacheableNode2 = null;
    } else {
      aCacheableNode2 = cacheablenode_0.prevSub;
    }

    aCacheableNode3 = cacheablenode_0;
    return cacheablenode_0;
  }

  @Override
  public boolean hasNext() {
    return aClass76_2.head != aCacheableNode2;
  }

  @Override
  public void remove() {
    if (aCacheableNode3 == null) {
      throw new IllegalStateException();
    }
    aCacheableNode3.unlinkSubnode();
    aCacheableNode3 = null;
  }

}
