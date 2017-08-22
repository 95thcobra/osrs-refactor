package jagex.oldschool.collections;

import java.util.Iterator;

public class Bag implements Iterable {

  public Subnode head;

  public Bag() {
    head = new Subnode();
    head.prevSub = head;
    head.nextSub = head;
  }

  public void clear() {
    while (head.prevSub != head) {
      head.prevSub.unlinkSubnode();
    }

  }

  public void add(final Subnode node) {
    if (node.nextSub != null) {
      node.unlinkSubnode();
    }

    node.nextSub = head.nextSub;
    node.prevSub = head;
    node.nextSub.prevSub = node;
    node.prevSub.nextSub = node;
  }

  @Override
  public Iterator iterator() {
    return new BagIterator(this);
  }

}
