package jagex.oldschool.collections;

import java.util.Iterator;

public class HashTableIterator implements Iterator {

  Node head;
  IterableHashTable table;
  int index;
  Node tail;

  HashTableIterator(final IterableHashTable iterablehashtable_0) {
    head = null;
    table = iterablehashtable_0;
    reset();
  }

  void reset() {
    tail = table.buckets[0].next;
    index = 1;
    head = null;
  }

  @Override
  public Object next() {
    Node node_0;
    if (table.buckets[index - 1] != tail) {
      node_0 = tail;
      tail = node_0.next;
      head = node_0;
      return node_0;
    }
    do {
      if (index >= table.size) {
        return null;
      }

      node_0 = table.buckets[index++].next;
    } while (node_0 == table.buckets[index - 1]);

    tail = node_0.next;
    head = node_0;
    return node_0;
  }

  @Override
  public void remove() {
    if (head == null) {
      throw new IllegalStateException();
    }
    head.unlink();
    head = null;
  }

  @Override
  public boolean hasNext() {
    if (table.buckets[index - 1] != tail) {
      return true;
    }
    while (index < table.size) {
      if (table.buckets[index++].next != table.buckets[index - 1]) {
        tail = table.buckets[index - 1].next;
        return true;
      }

      tail = table.buckets[index - 1];
    }

    return false;
  }

}
