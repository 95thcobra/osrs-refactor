package jagex.oldschool.collections;

public final class HashTable {

  int size;
  Node[] buckets;
  int index;
  Node aNode1;
  Node aNode2;

  public HashTable(final int int_0) {
    index = 0;
    size = int_0;
    buckets = new Node[int_0];

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final Node node_0 = buckets[int_1] = new Node();
      node_0.next = node_0;
      node_0.prev = node_0;
    }

  }

  public Node method66() {
    index = 0;
    return method67();
  }

  public Node get(final long long_0) {
    final Node node_0 = buckets[(int) (long_0 & size - 1)];

    for (aNode1 = node_0.next; node_0 != aNode1; aNode1 = aNode1.next) {
      if (aNode1.hash == long_0) {
        final Node node_1 = aNode1;
        aNode1 = aNode1.next;
        return node_1;
      }
    }

    aNode1 = null;
    return null;
  }

  public Node method67() {
    Node node_0;
    if (index > 0 && buckets[index - 1] != aNode2) {
      node_0 = aNode2;
      aNode2 = node_0.next;
      return node_0;
    }
    do {
      if (index >= size) {
        return null;
      }

      node_0 = buckets[index++].next;
    } while (node_0 == buckets[index - 1]);

    aNode2 = node_0.next;
    return node_0;
  }

  public void method68() {
    for (int int_0 = 0; int_0 < size; int_0++) {
      final Node node_0 = buckets[int_0];

      while (true) {
        final Node node_1 = node_0.next;
        if (node_1 == node_0) {
          break;
        }

        node_1.unlink();
      }
    }

    aNode1 = null;
    aNode2 = null;
  }

  public void put(final Node node_0, final long long_0) {
    if (node_0.prev != null) {
      node_0.unlink();
    }

    final Node node_1 = buckets[(int) (long_0 & size - 1)];
    node_0.prev = node_1.prev;
    node_0.next = node_1;
    node_0.prev.next = node_0;
    node_0.next.prev = node_0;
    node_0.hash = long_0;
  }

}
