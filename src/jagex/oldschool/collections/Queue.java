package jagex.oldschool.collections;

public final class Queue {

  Subnode head;

  public Queue() {
    head = new Subnode();
    head.prevSub = head;
    head.nextSub = head;
  }

  public void clear() {
    while (true) {
      final Subnode node = head.prevSub;
      if (node == head) {
        return;
      }
      node.unlinkSubnode();
    }
  }

  public Subnode poll() {
    final Subnode node = head.prevSub;
    if (node == head) {
      return null;
    }
    node.unlinkSubnode();
    return node;
  }

  public void addFirst(final Subnode node) {
    if (node.nextSub != null) {
      node.unlinkSubnode();
    }

    node.nextSub = head.nextSub;
    node.prevSub = head;
    node.nextSub.prevSub = node;
    node.prevSub.nextSub = node;
  }

  public void addLast(final Subnode node) {
    if (node.nextSub != null) {
      node.unlinkSubnode();
    }

    node.nextSub = head;
    node.prevSub = head.prevSub;
    node.nextSub.prevSub = node;
    node.prevSub.nextSub = node;
  }

  public Subnode peek() {
    final Subnode node = head.prevSub;
    return node == head ? null : node;
  }

}
