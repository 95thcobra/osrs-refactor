package jagex.oldschool.script;

import jagex.oldschool.CombatInfo1;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.io.Buffer;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Script extends Subnode {

  public static Cache aNodeCache18;

  static {
    aNodeCache18 = new Cache(128);
  }

  public int[] instructions;
  public int[] intOperands;
  public int localIntCount;
  public int localStringCount;
  public String[] stringOperands;
  public int intStackCount;
  public int stringStackCount;
  public IterableHashTable[] switches;

  public static long method871() {
    try {
      final URL url_0 = new URL(
          CombatInfo1.method668("services", false) + "m=accountappeal/login.ws");
      final URLConnection urlconnection_0 = url_0.openConnection();
      urlconnection_0.setRequestProperty("connection", "close");
      urlconnection_0.setDoInput(true);
      urlconnection_0.setDoOutput(true);
      urlconnection_0.setConnectTimeout(5000);
      final OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(
          urlconnection_0.getOutputStream());
      outputstreamwriter_0.write("data1=req");
      outputstreamwriter_0.flush();
      final InputStream inputstream_0 = urlconnection_0.getInputStream();
      final Buffer buffer_0 = new Buffer(new byte[1000]);

      do {
        final int int_0 = inputstream_0
            .read(buffer_0.bytes, buffer_0.offset, 1000 - buffer_0.offset);
        if (int_0 == -1) {
          buffer_0.offset = 0;
          final long long_0 = buffer_0.getLong();
          return long_0;
        }

        buffer_0.offset += int_0;
      } while (buffer_0.offset < 1000);

      return 0L;
    } catch (final Exception exception_0) {
      return 0L;
    }
  }

  public IterableHashTable[] method870(final int int_0) {
    return new IterableHashTable[int_0];
  }

}
