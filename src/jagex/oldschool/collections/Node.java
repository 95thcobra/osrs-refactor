package jagex.oldschool.collections;

public class Node {

  public Node next;
  public long hash;
  public Node prev;

  public void unlink() {
    if (prev != null) {
      prev.next = next;
      next.prev = prev;
      next = null;
      prev = null;
    }
  }

  public boolean isLinked() {
    return prev != null;
  }

}
