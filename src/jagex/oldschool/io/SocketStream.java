package jagex.oldschool.io;

import jagex.oldschool.AClass3_Sub1;
import jagex.oldschool.AudioSystem;
import jagex.oldschool.task.TaskQueue;
import jagex.oldschool.task.Task;
import jagex.oldschool.config.ClientScriptVariable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class SocketStream implements Runnable {

  int outbufLen;
  boolean closed;
  int streamOffset;
  boolean throwException;
  InputStream inputStream;
  byte[] outbuffer;
  Task socketThread;
  OutputStream outputStream;
  TaskQueue manager;
  Socket socket;

  public SocketStream(final Socket socket_0, final TaskQueue signlink_0) throws IOException {
    closed = false;
    streamOffset = 0;
    outbufLen = 0;
    throwException = false;
    manager = signlink_0;
    socket = socket_0;
    socket.setSoTimeout(30000);
    socket.setTcpNoDelay(true);
    socket.setReceiveBufferSize(16384);
    socket.setSendBufferSize(16384);
    inputStream = socket.getInputStream();
    outputStream = socket.getOutputStream();
  }

  public static boolean method554() {
    return AudioSystem.anInt168 != 0 ? true : AudioSystem.anAClass4_Sub3_1.method805();
  }

  public static int method555(final int int_0, int int_1, final int int_2) {
    if (int_2 > 179) {
      int_1 /= 2;
    }

    if (int_2 > 192) {
      int_1 /= 2;
    }

    if (int_2 > 217) {
      int_1 /= 2;
    }

    if (int_2 > 243) {
      int_1 /= 2;
    }

    final int int_3 = (int_1 / 32 << 7) + (int_0 / 4 << 10) + int_2 / 2;
    return int_3;
  }

  public void close() {
    if (!closed) {
      synchronized (this) {
        closed = true;
        notifyAll();
      }

      if (socketThread != null) {
        while (socketThread.status == 0) {
          AClass3_Sub1.sleep(1L);
        }

        if (socketThread.status == 1) {
          try {
            ((Thread) socketThread.result).join();
          } catch (final InterruptedException interruptedexception_0) {
          }
        }
      }

      socketThread = null;
    }
  }

  public int available() throws IOException {
    return closed ? 0 : inputStream.available();
  }

  public void read(final byte[] bytes_0, int int_0, int int_1) throws IOException {
    if (!closed) {
      while (int_1 > 0) {
        final int int_2 = inputStream.read(bytes_0, int_0, int_1);
        if (int_2 <= 0) {
          throw new EOFException();
        }

        int_0 += int_2;
        int_1 -= int_2;
      }

    }
  }

  public void write(final byte[] bytes_0, final int int_0, final int int_1)
      throws IOException {
    if (!closed) {
      if (throwException) {
        throwException = false;
        throw new IOException();
      }
      if (outbuffer == null) {
        outbuffer = new byte[5000];
      }

      synchronized (this) {
        for (int int_2 = 0; int_2 < int_1; int_2++) {
          outbuffer[outbufLen] = bytes_0[int_2 + int_0];
          outbufLen = (outbufLen + 1) % 5000;
          if (outbufLen == (streamOffset + 4900) % 5000) {
            throw new IOException();
          }
        }

        if (socketThread == null) {
          socketThread = manager.createRunnable(this, 3);
        }

        notifyAll();
      }
    }
  }

  public int readByte() throws IOException {
    return closed ? 0 : inputStream.read();
  }

  @Override
  protected void finalize() {
    close();
  }

  @Override
  public void run() {
    try {
      while (true) {
        label79:
        {
          int int_0;
          int int_1;
          synchronized (this) {
            if (outbufLen == streamOffset) {
              if (closed) {
                break label79;
              }

              try {
                this.wait();
              } catch (final InterruptedException interruptedexception_0) {
              }
            }

            int_0 = streamOffset;
            if (outbufLen >= streamOffset) {
              int_1 = outbufLen - streamOffset;
            } else {
              int_1 = 5000 - streamOffset;
            }
          }

          if (int_1 <= 0) {
            continue;
          }

          try {
            outputStream.write(outbuffer, int_0, int_1);
          } catch (final IOException ioexception_1) {
            throwException = true;
          }

          streamOffset = (int_1 + streamOffset) % 5000;

          try {
            if (streamOffset == outbufLen) {
              outputStream.flush();
            }
          } catch (final IOException ioexception_2) {
            throwException = true;
          }
          continue;
        }

        try {
          if (inputStream != null) {
            inputStream.close();
          }

          if (outputStream != null) {
            outputStream.close();
          }

          if (socket != null) {
            socket.close();
          }
        } catch (final IOException ioexception_0) {
        }

        outbuffer = null;
        return;
      }
    } catch (final Exception exception_0) {
      ClientScriptVariable.method526(null, exception_0);
    }
  }

}
