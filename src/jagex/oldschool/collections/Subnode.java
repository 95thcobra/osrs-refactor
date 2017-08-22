package jagex.oldschool.collections;

public class Subnode extends Node {

  public Subnode nextSub;
  public Subnode prevSub;

  public void unlinkSubnode() {
    if (nextSub != null) {
      nextSub.prevSub = prevSub;
      prevSub.nextSub = nextSub;
      prevSub = null;
      nextSub = null;
    }
  }
}
