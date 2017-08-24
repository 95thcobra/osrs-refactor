package jagex.oldschool.io;

import jagex.oldschool.Client;
import jagex.oldschool.util.Time;
import jagex.oldschool.social.Ignore;

public abstract class AbstractByteBuffer {

  public static String osName;
  public static boolean USE_HEAP_BUFFERS;

  static {
    USE_HEAP_BUFFERS = false;
  }

  public static void method274(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    if (Ignore.loadWidget(int_0)) {
      Client.method405(Time.widgets[int_0], -1, int_1, int_2, int_3, int_4, int_5, int_6);
    }
  }

  public abstract byte[] get();

  public abstract void put(byte[] var1);

}
