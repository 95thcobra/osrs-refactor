package jagex.oldschool;

import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.Node;

public class AClass4_Sub1 extends AClass4 {

  Deque aDeque4;
  Deque aDeque5;
  int anInt389;
  int anInt390;

  public AClass4_Sub1() {
    aDeque4 = new Deque();
    aDeque5 = new Deque();
    anInt390 = 0;
    anInt389 = -1;
  }

  void method718(final int[] ints_0, final int int_0, final int int_1) {
    for (AClass4 aclass4_0 = (AClass4) aDeque4.getFirst(); aclass4_0 != null;
        aclass4_0 = (AClass4) aDeque4
            .getNext()) {
      aclass4_0.method634(ints_0, int_0, int_1);
    }

  }

  void method719(final int int_0) {
    for (AClass4 aclass4_0 = (AClass4) aDeque4.getFirst(); aclass4_0 != null;
        aclass4_0 = (AClass4) aDeque4
            .getNext()) {
      aclass4_0.method633(int_0);
    }

  }

  @Override
  public final synchronized void method632(final int[] ints_0, int int_0, int int_1) {
    do {
      if (anInt389 < 0) {
        method718(ints_0, int_0, int_1);
        return;
      }

      if (int_1 + anInt390 < anInt389) {
        anInt390 += int_1;
        method718(ints_0, int_0, int_1);
        return;
      }

      final int int_2 = anInt389 - anInt390;
      method718(ints_0, int_0, int_2);
      int_0 += int_2;
      int_1 -= int_2;
      anInt390 += int_2;
      method720();
      final AClass6 aclass6_0 = (AClass6) aDeque5.getFirst();
      synchronized (aclass6_0) {
        final int int_3 = aclass6_0.method649(this);
        if (int_3 < 0) {
          aclass6_0.anInt331 = 0;
          method723(aclass6_0);
        } else {
          aclass6_0.anInt331 = int_3;
          method724(aclass6_0.next, aclass6_0);
        }
      }
    } while (int_1 != 0);

  }

  @Override
  public final synchronized void method633(int int_0) {
    do {
      if (anInt389 < 0) {
        method719(int_0);
        return;
      }

      if (anInt390 + int_0 < anInt389) {
        anInt390 += int_0;
        method719(int_0);
        return;
      }

      final int int_1 = anInt389 - anInt390;
      method719(int_1);
      int_0 -= int_1;
      anInt390 += int_1;
      method720();
      final AClass6 aclass6_0 = (AClass6) aDeque5.getFirst();
      synchronized (aclass6_0) {
        final int int_2 = aclass6_0.method649(this);
        if (int_2 < 0) {
          aclass6_0.anInt331 = 0;
          method723(aclass6_0);
        } else {
          aclass6_0.anInt331 = int_2;
          method724(aclass6_0.next, aclass6_0);
        }
      }
    } while (int_0 != 0);

  }

  @Override
  public AClass4 method635() {
    return (AClass4) aDeque4.getNext();
  }

  void method720() {
    if (anInt390 > 0) {
      for (AClass6 aclass6_0 = (AClass6) aDeque5.getFirst(); aclass6_0 != null;
          aclass6_0 = (AClass6) aDeque5
              .getNext()) {
        aclass6_0.anInt331 -= anInt390;
      }

      anInt389 -= anInt390;
      anInt390 = 0;
    }
  }

  public final synchronized void method721(final AClass4 aclass4_0) {
    aDeque4.addFirst(aclass4_0);
  }

  @Override
  public AClass4 method636() {
    return (AClass4) aDeque4.getFirst();
  }

  public final synchronized void method722(final AClass4 aclass4_0) {
    aclass4_0.unlink();
  }

  void method723(final AClass6 aclass6_0) {
    aclass6_0.unlink();
    aclass6_0.method648();
    final Node node_0 = aDeque5.head.next;
    if (node_0 == aDeque5.head) {
      anInt389 = -1;
    } else {
      anInt389 = ((AClass6) node_0).anInt331;
    }
  }

  void method724(Node node_0, final AClass6 aclass6_0) {
    while (aDeque5.head != node_0 && ((AClass6) node_0).anInt331 <= aclass6_0.anInt331) {
      node_0 = node_0.next;
    }

    Deque.appendAsChild(aclass6_0, node_0);
    anInt389 = ((AClass6) aDeque5.head.next).anInt331;
  }

  @Override
  public int method638() {
    return 0;
  }

}
