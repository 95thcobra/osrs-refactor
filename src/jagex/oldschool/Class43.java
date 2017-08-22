package jagex.oldschool;

import jagex.oldschool.io.Buffer;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Base64;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class Class43 {

  static InterfaceComponent aWidget5;

  public static void method279(final InterfaceComponent[] widgets_0, final int int_0,
      final int int_1, final int int_2,
      final boolean bool_0) {
    for (int int_3 = 0; int_3 < widgets_0.length; int_3++) {
      final InterfaceComponent widget_0 = widgets_0[int_3];
      if (widget_0 != null && widget_0.parentId == int_0) {
        WorldMapType2.method563(widget_0, int_1, int_2, bool_0);
        Comparator0.method303(widget_0, int_1, int_2);
        if (widget_0.scrollX > widget_0.scrollWidth - widget_0.width) {
          widget_0.scrollX = widget_0.scrollWidth - widget_0.width;
        }

        if (widget_0.scrollX < 0) {
          widget_0.scrollX = 0;
        }

        if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
          widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
        }

        if (widget_0.scrollY < 0) {
          widget_0.scrollY = 0;
        }

        if (widget_0.type == 0) {
          JavaxSourceDataLineProvider.method190(widgets_0, widget_0, bool_0);
        }
      }
    }

  }

  static int method280(final long seed, final String string_0) {
    final Random random = new Random();
    final Buffer buffer_0 = new Buffer(128);
    final Buffer buffer_1 = new Buffer(128);

    final int[] key = new int[] {
        random.nextInt(),
        random.nextInt(),
        (int) (seed >> 32),
        (int) seed
    };

    buffer_0.putByte(10);

    int int_0;
    for (int_0 = 0; int_0 < 4; int_0++) {
      buffer_0.putInt(random.nextInt());
    }

    buffer_0.putInt(key[0]);
    buffer_0.putInt(key[1]);
    buffer_0.putLong(seed);
    buffer_0.putLong(0L);

    for (int_0 = 0; int_0 < 4; int_0++) {
      buffer_0.putInt(random.nextInt());
    }

    buffer_0.encipher(Class51.aBigInteger1, Class51.aBigInteger2);
    buffer_1.putByte(10);

    for (int_0 = 0; int_0 < 3; int_0++) {
      buffer_1.putInt(random.nextInt());
    }

    buffer_1.putLong(random.nextLong());
    buffer_1.putWideInt(random.nextLong());
    if (Client.aByteArray28 != null) {
      buffer_1.put(Client.aByteArray28, 0, Client.aByteArray28.length);
    } else {
      final byte[] bytes_1 = Class66.method412();
      buffer_1.put(bytes_1, 0, bytes_1.length);
    }

    buffer_1.putLong(random.nextLong());
    buffer_1.encipher(Class51.aBigInteger1, Class51.aBigInteger2);
    int_0 = Class64.getLength(string_0);
    if (int_0 % 8 != 0) {
      int_0 += 8 - int_0 % 8;
    }

    final Buffer buffer_2 = new Buffer(int_0);
    buffer_2.putString(string_0);
    buffer_2.offset = int_0;
    buffer_2.encipher(key);
    Buffer buffer_3 = new Buffer(buffer_0.offset + buffer_1.offset + buffer_2.offset + 5);
    buffer_3.putByte(2);
    buffer_3.putByte(buffer_0.offset);
    buffer_3.put(buffer_0.bytes, 0, buffer_0.offset);
    buffer_3.putByte(buffer_1.offset);
    buffer_3.put(buffer_1.bytes, 0, buffer_1.offset);
    buffer_3.putShort(buffer_2.offset);
    buffer_3.put(buffer_2.bytes, 0, buffer_2.offset);
    final byte[] bytes_0 = buffer_3.bytes;
    final String string_1 = Base64.method785(bytes_0, 0, bytes_0.length);
    final String string_2 = string_1;

    try {
      final URL url_0 = new URL(
          CombatInfo1.method668("services", false) + "m=accountappeal/login.ws");
      final URLConnection urlconnection_0 = url_0.openConnection();
      urlconnection_0.setDoInput(true);
      urlconnection_0.setDoOutput(true);
      urlconnection_0.setConnectTimeout(5000);
      final OutputStreamWriter outputstreamwriter_0 = new OutputStreamWriter(
          urlconnection_0.getOutputStream());
      outputstreamwriter_0.write(
          "data2=" + Isaac.method485(string_2) + "&dest=" + Isaac
              .method485("passwordchoice.ws"));
      outputstreamwriter_0.flush();
      final InputStream inputstream_0 = urlconnection_0.getInputStream();
      buffer_3 = new Buffer(new byte[1000]);

      do {
        final int int_1 = inputstream_0
            .read(buffer_3.bytes, buffer_3.offset, 1000 - buffer_3.offset);
        if (int_1 == -1) {
          outputstreamwriter_0.close();
          inputstream_0.close();
          String string_3 = new String(buffer_3.bytes);
          if (string_3.startsWith("OFFLINE")) {
            return 4;
          }
          if (string_3.startsWith("WRONG")) {
            return 7;
          }
          if (string_3.startsWith("RELOAD")) {
            return 3;
          }
          if (string_3.startsWith("Not permitted for social network accounts.")) {
            return 6;
          }
          buffer_3.decipher(key);

          while (buffer_3.offset > 0 && buffer_3.bytes[buffer_3.offset - 1] == 0) {
            --buffer_3.offset;
          }

          string_3 = new String(buffer_3.bytes, 0, buffer_3.offset);
          boolean bool_0;
          if (string_3 == null) {
            bool_0 = false;
          } else {
            label84:
            {
              try {
                new URL(string_3);
              } catch (final MalformedURLException malformedurlexception_0) {
                bool_0 = false;
                break label84;
              }

              bool_0 = true;
            }
          }

          if (bool_0) {
            Class13.method167(string_3, true, false);
            return 2;
          }
          return 5;
        }

        buffer_3.offset += int_1;
      } while (buffer_3.offset < 1000);

      return 5;
    } catch (final Throwable throwable_0) {
      throwable_0.printStackTrace();
      return 5;
    }
  }

  public static byte[] method281(final CharSequence charsequence_0) {
    final int int_0 = charsequence_0.length();
    final byte[] bytes_0 = new byte[int_0];

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final char char_0 = charsequence_0.charAt(int_1);
      if (char_0 > 0 && char_0 < 128 || char_0 >= 160 && char_0 <= 255) {
        bytes_0[int_1] = (byte) char_0;
      } else if (char_0 == 8364) {
        bytes_0[int_1] = -128;
      } else if (char_0 == 8218) {
        bytes_0[int_1] = -126;
      } else if (char_0 == 402) {
        bytes_0[int_1] = -125;
      } else if (char_0 == 8222) {
        bytes_0[int_1] = -124;
      } else if (char_0 == 8230) {
        bytes_0[int_1] = -123;
      } else if (char_0 == 8224) {
        bytes_0[int_1] = -122;
      } else if (char_0 == 8225) {
        bytes_0[int_1] = -121;
      } else if (char_0 == 710) {
        bytes_0[int_1] = -120;
      } else if (char_0 == 8240) {
        bytes_0[int_1] = -119;
      } else if (char_0 == 352) {
        bytes_0[int_1] = -118;
      } else if (char_0 == 8249) {
        bytes_0[int_1] = -117;
      } else if (char_0 == 338) {
        bytes_0[int_1] = -116;
      } else if (char_0 == 381) {
        bytes_0[int_1] = -114;
      } else if (char_0 == 8216) {
        bytes_0[int_1] = -111;
      } else if (char_0 == 8217) {
        bytes_0[int_1] = -110;
      } else if (char_0 == 8220) {
        bytes_0[int_1] = -109;
      } else if (char_0 == 8221) {
        bytes_0[int_1] = -108;
      } else if (char_0 == 8226) {
        bytes_0[int_1] = -107;
      } else if (char_0 == 8211) {
        bytes_0[int_1] = -106;
      } else if (char_0 == 8212) {
        bytes_0[int_1] = -105;
      } else if (char_0 == 732) {
        bytes_0[int_1] = -104;
      } else if (char_0 == 8482) {
        bytes_0[int_1] = -103;
      } else if (char_0 == 353) {
        bytes_0[int_1] = -102;
      } else if (char_0 == 8250) {
        bytes_0[int_1] = -101;
      } else if (char_0 == 339) {
        bytes_0[int_1] = -100;
      } else if (char_0 == 382) {
        bytes_0[int_1] = -98;
      } else if (char_0 == 376) {
        bytes_0[int_1] = -97;
      } else {
        bytes_0[int_1] = 63;
      }
    }

    return bytes_0;
  }

}
