package jagex.oldschool;

import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Player;
import jagex.oldschool.task.Task;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

public class Class24 implements Runnable {

  static Task aTask1;
  final Thread aThread1;
  boolean aBool7;
  Queue aQueue1;

  Class24() {
    aQueue1 = new LinkedList();
    aThread1 = new Thread(this);
    aThread1.setPriority(1);
    aThread1.start();
  }

  static void method218(final String string_0, final String string_1, final String string_2) {
    LoginScreen.loginMessage1 = string_0;
    LoginScreen.loginMessage2 = string_1;
    LoginScreen.loginMessage3 = string_2;
  }

  static void method219(final GameBuffer packetbuffer_0, final int int_0) {
    final int int_1 = packetbuffer_0.offset;
    Class39.anInt91 = 0;
    method220(packetbuffer_0);
    Node_Sub1.method628(packetbuffer_0);
    if (packetbuffer_0.offset - int_1 != int_0) {
      throw new RuntimeException((packetbuffer_0.offset - int_1) + " " + int_0);
    }
  }

  static void method220(final GameBuffer packetbuffer_0) {
    int int_0 = 0;
    packetbuffer_0.beginBitAccess();

    int int_1;
    int int_2;
    int int_3;
    for (int_1 = 0; int_1 < Class39.anInt89; int_1++) {
      int_2 = Class39.anIntArray14[int_1];
      if ((Class39.aByteArray3[int_2] & 0x1) == 0) {
        if (int_0 > 0) {
          --int_0;
          Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
        } else {
          int_3 = packetbuffer_0.getBits(1);
          if (int_3 == 0) {
            int_0 = Ignore.method536(packetbuffer_0);
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          } else {
            Client.decodeMovement(packetbuffer_0, int_2);
          }
        }
      }
    }

    packetbuffer_0.endBitAccess();
    if (int_0 != 0) {
      throw new RuntimeException();
    }
    packetbuffer_0.beginBitAccess();

    for (int_1 = 0; int_1 < Class39.anInt89; int_1++) {
      int_2 = Class39.anIntArray14[int_1];
      if ((Class39.aByteArray3[int_2] & 0x1) != 0) {
        if (int_0 > 0) {
          --int_0;
          Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
        } else {
          int_3 = packetbuffer_0.getBits(1);
          if (int_3 == 0) {
            int_0 = Ignore.method536(packetbuffer_0);
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          } else {
            Client.decodeMovement(packetbuffer_0, int_2);
          }
        }
      }
    }

    packetbuffer_0.endBitAccess();
    if (int_0 != 0) {
      throw new RuntimeException();
    }
    packetbuffer_0.beginBitAccess();

    for (int_1 = 0; int_1 < Class39.anInt90; int_1++) {
      int_2 = Class39.anIntArray15[int_1];
      if ((Class39.aByteArray3[int_2] & 0x1) != 0) {
        if (int_0 > 0) {
          --int_0;
          Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
        } else {
          int_3 = packetbuffer_0.getBits(1);
          if (int_3 == 0) {
            int_0 = Ignore.method536(packetbuffer_0);
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          } else if (WorldMapType2.decodeRegionHash(packetbuffer_0, int_2)) {
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          }
        }
      }
    }

    packetbuffer_0.endBitAccess();
    if (int_0 != 0) {
      throw new RuntimeException();
    }
    packetbuffer_0.beginBitAccess();

    for (int_1 = 0; int_1 < Class39.anInt90; int_1++) {
      int_2 = Class39.anIntArray15[int_1];
      if ((Class39.aByteArray3[int_2] & 0x1) == 0) {
        if (int_0 > 0) {
          --int_0;
          Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
        } else {
          int_3 = packetbuffer_0.getBits(1);
          if (int_3 == 0) {
            int_0 = Ignore.method536(packetbuffer_0);
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          } else if (WorldMapType2.decodeRegionHash(packetbuffer_0, int_2)) {
            Class39.aByteArray3[int_2] = (byte) (Class39.aByteArray3[int_2] | 0x2);
          }
        }
      }
    }

    packetbuffer_0.endBitAccess();
    if (int_0 != 0) {
      throw new RuntimeException();
    }
    Class39.anInt89 = 0;
    Class39.anInt90 = 0;

    for (int_1 = 1; int_1 < 2048; int_1++) {
      Class39.aByteArray3[int_1] = (byte) (Class39.aByteArray3[int_1] >> 1);
      final Player player_0 = Client.cachedPlayers[int_1];
      if (player_0 != null) {
        Class39.anIntArray14[++Class39.anInt89 - 1] = int_1;
      } else {
        Class39.anIntArray15[++Class39.anInt90 - 1] = int_1;
      }
    }

  }

  public static void method221(final String string_0, final int int_0) {
    Client.outbound.putEncipheredByte(161);
    Client.outbound.putByte(Class64.getLength(string_0) + 1);
    Client.outbound.putString(string_0);
    Client.outbound.putByteSub(int_0);
  }

  void method216() {
    aBool7 = true;

    try {
      synchronized (this) {
        notify();
      }

      aThread1.join();
    } catch (final InterruptedException interruptedexception_0) {
    }
  }

  Class37 method217(final URL url_0) {
    final Class37 class37_0 = new Class37(url_0);
    synchronized (this) {
      aQueue1.add(class37_0);
      notify();
      return class37_0;
    }
  }

  @Override
  public void run() {
    while (!aBool7) {
      try {
        Class37 class37_0;
        synchronized (this) {
          class37_0 = (Class37) aQueue1.poll();
          if (class37_0 == null) {
            try {
              this.wait();
            } catch (final InterruptedException interruptedexception_0) {
            }
            continue;
          }
        }

        DataInputStream datainputstream_0 = null;
        URLConnection urlconnection_0 = null;

        try {
          urlconnection_0 = class37_0.anURL1.openConnection();
          urlconnection_0.setConnectTimeout(5000);
          urlconnection_0.setReadTimeout(5000);
          urlconnection_0.setUseCaches(false);
          urlconnection_0.setRequestProperty("Connection", "close");
          final int int_0 = urlconnection_0.getContentLength();
          if (int_0 >= 0) {
            final byte[] bytes_0 = new byte[int_0];
            datainputstream_0 = new DataInputStream(urlconnection_0.getInputStream());
            datainputstream_0.readFully(bytes_0);
            class37_0.aByteArray2 = bytes_0;
          }

          class37_0.aBool9 = true;
        } catch (final IOException ioexception_0) {
          class37_0.aBool9 = true;
        } finally {
          if (datainputstream_0 != null) {
            datainputstream_0.close();
          }

          if (urlconnection_0 != null && urlconnection_0 instanceof HttpURLConnection) {
            ((HttpURLConnection) urlconnection_0).disconnect();
          }

        }
      } catch (final Exception exception_0) {
        ClientScriptVariable.method526(null, exception_0);
      }
    }

  }

}
