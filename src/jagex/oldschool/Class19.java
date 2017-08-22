package jagex.oldschool;

import jagex.oldschool.device.Mouse;
import jagex.oldschool.ui.InterfaceComponent;

public class Class19 implements Runnable {

  static InterfaceComponent aWidget2;
  boolean aBool6;
  Object anObject1;
  int anInt69;
  int[] anIntArray4;
  int[] anIntArray5;

  Class19() {
    aBool6 = true;
    anObject1 = new Object();
    anInt69 = 0;
    anIntArray4 = new int[500];
    anIntArray5 = new int[500];
  }

  @Override
  public void run() {
    for (; aBool6; AClass3_Sub1.method725(50L)) {
      synchronized (anObject1) {
        if (anInt69 < 500) {
          anIntArray4[anInt69] = Mouse.anInt249;
          anIntArray5[anInt69] = Mouse.anInt251;
          ++anInt69;
        }
      }
    }

  }

}
