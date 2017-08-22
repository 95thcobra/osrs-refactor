package jagex.oldschool;

import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.CacheWorker;
import jagex.oldschool.script.ScriptCall;

public enum Enum5 implements MappedEnum {

  anEnum5_1(3, 0), anEnum5_2(2, 1), anEnum5_3(0, 2), anEnum5_4(6, 3), anEnum5_5(1, 4), anEnum5_6(7,
      5), anEnum5_7(5,
      6), anEnum5_8(4, 7);

  public final int anInt360;
  final int anInt359;

  Enum5(final int int_1, final int int_2) {
    anInt360 = int_1;
    anInt359 = int_2;
  }

  public static void method663() {
    synchronized (CacheWorker.anObject2) {
      if (CacheWorker.anInt189 == 0) {
        CacheWorker.aThread2 = new Thread(new CacheWorker());
        CacheWorker.aThread2.setDaemon(true);
        CacheWorker.aThread2.start();
        CacheWorker.aThread2.setPriority(5);
      }

      CacheWorker.anInt189 = 600;
    }
  }

  public static String method664(final Buffer buffer_0) {
    String string_1;
    try {
      int int_0 = buffer_0.getUnsignedSmartShort();
      if (int_0 > 32767) {
        int_0 = 32767;
      }

      final byte[] bytes_0 = new byte[int_0];
      buffer_0.offset += Class94.aHuffman1
          .decompress(buffer_0.bytes, buffer_0.offset, bytes_0, 0, int_0);
      final String string_0 = ScriptCall.getString(bytes_0, 0, int_0);
      string_1 = string_0;
    } catch (final Exception exception_0) {
      string_1 = "Cabbage";
    }

    return string_1;
  }

  @Override
  public int mappedOrdinal() {
    return anInt359;
  }

}
