package jagex.oldschool.io;

import java.io.EOFException;
import java.io.IOException;

public class BufferedFile {

  long aLong12;
  int anInt211;
  long aLong13;
  long aLong14;
  long position;
  long aLong15;
  FileOnDisk aFileOnDisk1;
  int anInt212;
  byte[] writePayload;
  byte[] readPayload;
  long length;

  public BufferedFile(final FileOnDisk fileondisk_0, final int int_0, final int int_1)
      throws IOException {
    aLong15 = -1L;
    aLong14 = -1L;
    anInt212 = 0;
    aFileOnDisk1 = fileondisk_0;
    aLong12 = length = fileondisk_0.length();
    readPayload = new byte[int_0];
    writePayload = new byte[int_1];
    position = 0L;
  }

  public void method547(final byte[] bytes_0, int int_0, int int_1) throws IOException {
    try {
      if (int_1 + int_0 > bytes_0.length) {
        throw new ArrayIndexOutOfBoundsException(int_1 + int_0 - bytes_0.length);
      }

      if (aLong14 != -1L && position >= aLong14 && position + int_1 <= aLong14
          + anInt212) {
        System.arraycopy(writePayload, (int) (position - aLong14), bytes_0, int_0, int_1);
        position += int_1;
        return;
      }

      final long long_0 = position;
      final int int_2 = int_1;
      int int_3;
      if (position >= aLong15 && position < aLong15 + anInt211) {
        int_3 = (int) (anInt211 - (position - aLong15));
        if (int_3 > int_1) {
          int_3 = int_1;
        }

        System.arraycopy(readPayload, (int) (position - aLong15), bytes_0, int_0, int_3);
        position += int_3;
        int_0 += int_3;
        int_1 -= int_3;
      }

      if (int_1 > readPayload.length) {
        aFileOnDisk1.seek(position);

        for (aLong13 = position; int_1 > 0; int_1 -= int_3) {
          int_3 = aFileOnDisk1.read(bytes_0, int_0, int_1);
          if (int_3 == -1) {
            break;
          }

          aLong13 += int_3;
          position += int_3;
          int_0 += int_3;
        }
      } else if (int_1 > 0) {
        method550();
        int_3 = int_1;
        if (int_1 > anInt211) {
          int_3 = anInt211;
        }

        System.arraycopy(readPayload, 0, bytes_0, int_0, int_3);
        int_0 += int_3;
        int_1 -= int_3;
        position += int_3;
      }

      if (aLong14 != -1L) {
        if (aLong14 > position && int_1 > 0) {
          int_3 = int_0 + (int) (aLong14 - position);
          if (int_3 > int_1 + int_0) {
            int_3 = int_1 + int_0;
          }

          while (int_0 < int_3) {
            bytes_0[int_0++] = 0;
            --int_1;
            ++position;
          }
        }

        long long_1 = -1L;
        long long_2 = -1L;
        if (aLong14 >= long_0 && aLong14 < long_0 + int_2) {
          long_1 = aLong14;
        } else if (long_0 >= aLong14 && long_0 < anInt212 + aLong14) {
          long_1 = long_0;
        }

        if (anInt212 + aLong14 > long_0 && aLong14 + anInt212 <= long_0 + int_2) {
          long_2 = aLong14 + anInt212;
        } else if (int_2 + long_0 > aLong14 && int_2 + long_0 <= anInt212 + aLong14) {
          long_2 = long_0 + int_2;
        }

        if (long_1 > -1L && long_2 > long_1) {
          final int int_4 = (int) (long_2 - long_1);
          System.arraycopy(writePayload, (int) (long_1 - aLong14), bytes_0,
              (int) (long_1 - long_0) + int_0,
              int_4);
          if (long_2 > position) {
            int_1 = (int) (int_1 - (long_2 - position));
            position = long_2;
          }
        }
      }
    } catch (final IOException ioexception_0) {
      aLong13 = -1L;
      throw ioexception_0;
    }

    if (int_1 > 0) {
      throw new EOFException();
    }
  }

  void method548() throws IOException {
    if (aLong14 != -1L) {
      if (aLong13 != aLong14) {
        aFileOnDisk1.seek(aLong14);
        aLong13 = aLong14;
      }

      aFileOnDisk1.write(writePayload, 0, anInt212);
      aLong13 += anInt212 * -794226537 * -50630873L;
      if (aLong13 > length) {
        length = aLong13;
      }

      long long_0 = -1L;
      long long_1 = -1L;
      if (aLong14 >= aLong15 && aLong14 < anInt211 + aLong15) {
        long_0 = aLong14;
      } else if (aLong15 >= aLong14 && aLong15 < aLong14 + anInt212) {
        long_0 = aLong15;
      }

      if (anInt212 + aLong14 > aLong15 && aLong14 + anInt212 <= anInt211 + aLong15) {
        long_1 = anInt212 + aLong14;
      } else if (aLong15 + anInt211 > aLong14 && anInt211 + aLong15 <= aLong14
          + anInt212) {
        long_1 = aLong15 + anInt211;
      }

      if (long_0 > -1L && long_1 > long_0) {
        final int int_0 = (int) (long_1 - long_0);
        System.arraycopy(writePayload, (int) (long_0 - aLong14), readPayload,
            (int) (long_0 - aLong15), int_0);
      }

      aLong14 = -1L;
      anInt212 = 0;
    }
  }

  public long method549() {
    return aLong12;
  }

  public void seek(final long long_0) throws IOException {
    if (long_0 < 0L) {
      throw new IOException("");
    }
    position = long_0;
  }

  public void write(final byte[] bytes_0, int int_0, int int_1) throws IOException {
    try {
      if (int_1 + position > aLong12) {
        aLong12 = position + int_1;
      }

      if (aLong14 != -1L && (position < aLong14 || position > aLong14 + anInt212)) {
        method548();
      }

      if (aLong14 != -1L && int_1 + position > aLong14 + writePayload.length) {
        final int int_2 = (int) (writePayload.length - (position - aLong14));
        System.arraycopy(bytes_0, int_0, writePayload, (int) (position - aLong14), int_2);
        position += int_2;
        int_0 += int_2;
        int_1 -= int_2;
        anInt212 = writePayload.length;
        method548();
      }

      if (int_1 <= writePayload.length) {
        if (int_1 > 0) {
          if (aLong14 == -1L) {
            aLong14 = position;
          }

          System.arraycopy(bytes_0, int_0, writePayload, (int) (position - aLong14), int_1);
          position += int_1;
          if (position - aLong14 > anInt212) {
            anInt212 = (int) (position - aLong14);
          }
        }
      } else {
        if (aLong13 != position) {
          aFileOnDisk1.seek(position);
          aLong13 = position;
        }

        aFileOnDisk1.write(bytes_0, int_0, int_1);
        aLong13 += int_1;
        if (aLong13 > length) {
          length = aLong13;
        }

        long long_0 = -1L;
        long long_1 = -1L;
        if (position >= aLong15 && position < aLong15 + anInt211) {
          long_0 = position;
        } else if (aLong15 >= position && aLong15 < int_1 + position) {
          long_0 = aLong15;
        }

        if (int_1 + position > aLong15 && int_1 + position <= anInt211 + aLong15) {
          long_1 = position + int_1;
        } else if (anInt211 + aLong15 > position && anInt211 + aLong15 <= position
            + int_1) {
          long_1 = aLong15 + anInt211;
        }

        if (long_0 > -1L && long_1 > long_0) {
          final int int_3 = (int) (long_1 - long_0);
          System.arraycopy(bytes_0, (int) (int_0 + long_0 - position), readPayload,
              (int) (long_0 - aLong15), int_3);
        }

        position += int_1;
      }
    } catch (final IOException ioexception_0) {
      aLong13 = -1L;
      throw ioexception_0;
    }
  }

  void method550() throws IOException {
    anInt211 = 0;
    if (position != aLong13) {
      aFileOnDisk1.seek(position);
      aLong13 = position;
    }

    int int_0;
    for (aLong15 = position; anInt211 < readPayload.length; anInt211 += int_0) {
      int_0 = aFileOnDisk1.read(readPayload, anInt211, readPayload.length - anInt211);
      if (int_0 == -1) {
        return;
      }

      aLong13 += int_0;
    }

  }

  public void method551() throws IOException {
    method548();
    aFileOnDisk1.close();
  }

  public void read(final byte[] bytes_0) throws IOException {
    method547(bytes_0, 0, bytes_0.length);
  }

}
