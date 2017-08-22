package jagex.oldschool;

import jagex.oldschool.io.CacheWorker;

public class Class89 {

  public static char aChar1;

  public static void method494() {
    synchronized (CacheWorker.anObject2) {
      if (CacheWorker.anInt189 != 0) {
        CacheWorker.anInt189 = 1;

        try {
          CacheWorker.anObject2.wait();
        } catch (final InterruptedException interruptedexception_0) {
        }
      }

    }
  }

  public static boolean method495(final int int_0) {
    return (int_0 >> 31 & 0x1) != 0;
  }

}
