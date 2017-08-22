package jagex.oldschool.collections;

import java.util.Iterator;

public class QueueIterator implements Iterator {

  IterableQueue queue;
  Node current;
  Node prev;

  QueueIterator(final IterableQueue queue) {
    prev = null;
    this.queue = queue;
    current = this.queue.head.next;
    prev = null;
  }

  @Override
  public void remove() {
    if (prev == null) {
      throw new IllegalStateException();
    }
    prev.unlink();
    prev = null;
  }

  @Override
  public Object next() {
    Node node = current;
    if (node == queue.head) {
      node = null;
      current = null;
    } else {
      current = node.next;
    }

    prev = node;
    return node;
  }

  @Override
  public boolean hasNext() {
    return queue.head != current;
  }

}
