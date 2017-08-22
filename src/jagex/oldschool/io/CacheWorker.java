package jagex.oldschool.io;

import jagex.oldschool.AClass3_Sub1;
import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.config.ClientScriptVariable;

public class CacheWorker implements Runnable {

  public static Deque aDeque1;
  public static Deque requests;
  public static Object anObject2;
  public static int anInt189;
  public static Thread aThread2;

  static {
    aDeque1 = new Deque();
    requests = new Deque();
    anInt189 = 0;
    anObject2 = new Object();
  }

  @Override
  public void run() {
    try {
      while (true) {
        LocalRequest filesystem_0;
        synchronized (aDeque1) {
          filesystem_0 = (LocalRequest) aDeque1.getFirst();
        }

        if (filesystem_0 != null) {
          if (filesystem_0.id == 0) {
            filesystem_0.cache.method70((int) filesystem_0.hash, filesystem_0.bytes,
                filesystem_0.bytes.length);
            synchronized (aDeque1) {
              filesystem_0.unlink();
            }
          } else if (filesystem_0.id == 1) {
            filesystem_0.bytes = filesystem_0.cache.method71((int) filesystem_0.hash);
            synchronized (aDeque1) {
              requests.addLast(filesystem_0);
            }
          }

          synchronized (anObject2) {
            if (anInt189 <= 1) {
              anInt189 = 0;
              anObject2.notifyAll();
              return;
            }

            anInt189 = 600;
          }
        } else {
          AClass3_Sub1.method725(100L);
          synchronized (anObject2) {
            if (anInt189 <= 1) {
              anInt189 = 0;
              anObject2.notifyAll();
              return;
            }

            --anInt189;
          }
        }
      }
    } catch (final Exception exception_0) {
      ClientScriptVariable.method526(null, exception_0);
    }
  }

}
