package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.util.Time;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;

public class Class44 {

  static Package maps;
  public final long aLong2;
  public final int anInt95;
  public final GrandExchangeOffer aGrandExchangeOffer1;
  String aString8;
  String aString9;

  Class44(final Buffer buffer_0, final byte byte_0, final int int_0) {
    aString9 = buffer_0.getString();
    aString8 = buffer_0.getString();
    anInt95 = buffer_0.getUnsignedShort();
    aLong2 = buffer_0.getLong();
    final int int_1 = buffer_0.getInt();
    final int int_2 = buffer_0.getInt();
    aGrandExchangeOffer1 = new GrandExchangeOffer();
    aGrandExchangeOffer1.method170(2);
    aGrandExchangeOffer1.method171(byte_0);
    aGrandExchangeOffer1.price = int_1;
    aGrandExchangeOffer1.totalQuantity = int_2;
    aGrandExchangeOffer1.quantitySold = 0;
    aGrandExchangeOffer1.spent = 0;
    aGrandExchangeOffer1.itemId = int_0;
  }

  public static void method284(final AbstractPackage indexdatabase_0) {
    PlayerVariable.configs = indexdatabase_0;
    Client.variableCount = PlayerVariable.configs.fileCount(16);
  }

  protected static int method285() {
    int int_0 = 0;
    if (Class3.aGarbageCollectorMXBean1 == null || !Class3.aGarbageCollectorMXBean1.isValid()) {
      try {
        final Iterator iterator_0 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

        while (iterator_0.hasNext()) {
          final GarbageCollectorMXBean garbagecollectormxbean_0 = (GarbageCollectorMXBean) iterator_0
              .next();
          if (garbagecollectormxbean_0.isValid()) {
            Class3.aGarbageCollectorMXBean1 = garbagecollectormxbean_0;
            Stub.aLong23 = -1L;
            Stub.aLong22 = -1L;
          }
        }
      } catch (final Throwable throwable_0) {
      }
    }

    if (Class3.aGarbageCollectorMXBean1 != null) {
      final long long_0 = Time.currentTimeMillis();
      final long long_1 = Class3.aGarbageCollectorMXBean1.getCollectionTime();
      if (Stub.aLong22 != -1L) {
        final long long_2 = long_1 - Stub.aLong22;
        final long long_3 = long_0 - Stub.aLong23;
        if (long_3 != 0L) {
          int_0 = (int) (100L * long_2 / long_3);
        }
      }

      Stub.aLong22 = long_1;
      Stub.aLong23 = long_0;
    }

    return int_0;
  }

  public String method282() {
    return aString9;
  }

  public String method283() {
    return aString8;
  }

}
