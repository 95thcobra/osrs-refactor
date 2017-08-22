package jagex.oldschool.collections;

import java.util.Iterator;

public class IterableQueue implements Iterable {

  Node current;
  Node head;

  public IterableQueue() {
    head = new Node();
    head.next = head;
    head.prev = head;
  }

  public static void appendAsChild(final Node parent, final Node child) {
    if (parent.prev != null) {
      parent.unlink();
    }

    parent.prev = child;
    parent.next = child.next;
    parent.prev.next = parent;
    parent.next.prev = parent;
  }

  Node getNext(final Node node) {
    Node node_1;
    if (node == null) {
      node_1 = head.next;
    } else {
      node_1 = node;
    }

    if (node_1 == head) {
      current = null;
      return null;
    }
    current = node_1.next;
    return node_1;
  }

  public boolean isEmpty() {
    return head.next == head;
  }

  public Node getFirst() {
    return getNext(null);
  }

  public Node getNext() {
    final Node node_0 = current;
    if (node_0 == head) {
      current = null;
      return null;
    }
    current = node_0.next;
    return node_0;
  }

  public void addFirst(final Node node_0) {
    if (node_0.prev != null) {
      node_0.unlink();
    }

    node_0.prev = head;
    node_0.next = head.next;
    node_0.prev.next = node_0;
    node_0.next.prev = node_0;
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

  public Node poll() {
    final Node node = head.next;
    if (node == head) {
      return null;
    }
    node.unlink();
    return node;
  }

  @Override
  public Iterator iterator() {
    return new QueueIterator(this);
  }

}
