package jagex.oldschool.collections;

public class Deque {

  public Node head;
  Node current;

  public Deque() {
    head = new Node();
    head.next = head;
    head.prev = head;
  }

  public static void appendAsChild(final Node parent, final Node child) {
    if (parent.prev != null) {
      parent.unlink();
    }

    parent.prev = child.prev;
    parent.next = child;
    parent.prev.next = parent;
    parent.next.prev = parent;
  }

  public void addFirst(final Node node) {
    if (node.prev != null) {
      node.unlink();
    }

    node.prev = head;
    node.next = head.next;
    node.prev.next = node;
    node.next.prev = node;
  }

  public Node getFirst() {
    final Node node = head.next;
    if (node == head) {
      current = null;
      return null;
    }
    current = node.next;
    return node;
  }

  public Node getNext() {
    final Node node = current;
    if (node == head) {
      current = null;
      return null;
    }
    current = node.next;
    return node;
  }

  public void addLast(final Node node) {
    if (node.prev != null) {
      node.unlink();
    }

    node.prev = head.prev;
    node.next = head;
    node.prev.next = node;
    node.next.prev = node;
  }

  public Node pollFirst() {
    final Node node = head.next;
    if (node == head) {
      return null;
    }
    node.unlink();
    return node;
  }

  public Node getLast() {
    final Node node = head.prev;
    if (node == head) {
      current = null;
      return null;
    }
    current = node.prev;
    return node;
  }

  public Node pollLast() {
    final Node node = head.prev;
    if (node == head) {
      return null;
    }
    node.unlink();
    return node;
  }

  public Node getPrevious() {
    final Node node = current;
    if (node == head) {
      current = null;
      return null;
    }
    current = node.prev;
    return node;
  }

  public void clear() {
    while (true) {
      final Node node = head.next;
      if (node == head) {
        current = null;
        return;
      }

      node.unlink();
    }
  }

}
