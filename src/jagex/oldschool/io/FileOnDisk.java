package jagex.oldschool.io;

import jagex.oldschool.awt.Surface;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.WorldMapType1;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileOnDisk {

  long position;
  RandomAccessFile file;
  long length;

  public FileOnDisk(final File file_0, final String string_0, long long_0) throws IOException {
    if (long_0 == -1L) {
      long_0 = Long.MAX_VALUE;
    }

    if (file_0.length() >= long_0) {
      file_0.delete();
    }

    file = new RandomAccessFile(file_0, string_0);
    length = long_0;
    position = 0L;
    final int int_0 = file.read();
    if (int_0 != -1 && !string_0.equals("r")) {
      file.seek(0L);
      file.write(int_0);
    }

    file.seek(0L);
  }

  public static boolean method74(final AbstractPackage indexdatabase_0, final int int_0, final int int_1) {
    final byte[] bytes_0 = indexdatabase_0.get(int_0, int_1);
    if (bytes_0 == null) {
      return false;
    }
    Surface.decodeSprite(bytes_0);
    return true;
  }

  public static int getSmoothNoise(final int int_0, final int int_1, final int int_2) {
    final int int_3 = int_0 / int_2;
    final int int_4 = int_0 & int_2 - 1;
    final int int_5 = int_1 / int_2;
    final int int_6 = int_1 & int_2 - 1;
    final int int_7 = WorldMapType1.getSmoothNoise2D(int_3, int_5);
    final int int_8 = WorldMapType1.getSmoothNoise2D(int_3 + 1, int_5);
    final int int_9 = WorldMapType1.getSmoothNoise2D(int_3, int_5 + 1);
    final int int_10 = WorldMapType1.getSmoothNoise2D(int_3 + 1, int_5 + 1);
    final int int_11 = 65536 - Rasterizer3d.COSINE[int_4 * 1024 / int_2] >> 1;
    final int int_12 = ((65536 - int_11) * int_7 >> 16) + (int_11 * int_8 >> 16);
    final int int_13 = 65536 - Rasterizer3d.COSINE[int_4 * 1024 / int_2] >> 1;
    final int int_14 = ((65536 - int_13) * int_9 >> 16) + (int_13 * int_10 >> 16);
    final int int_15 = 65536 - Rasterizer3d.COSINE[int_6 * 1024 / int_2] >> 1;
    final int int_16 = (int_15 * int_14 >> 16) + ((65536 - int_15) * int_12 >> 16);
    return int_16;
  }

  public final long length() throws IOException {
    return file.length();
  }

  public final void close() throws IOException {
    if (file != null) {
      file.close();
      file = null;
    }

  }

  public final int read(final byte[] bytes_0, final int int_0, final int int_1) throws IOException {
    final int int_2 = file.read(bytes_0, int_0, int_1);
    if (int_2 > 0) {
      position += int_2;
    }

    return int_2;
  }

  final void seek(final long long_0) throws IOException {
    file.seek(long_0);
    position = long_0;
  }

  public final void write(final byte[] bytes_0, final int int_0, final int int_1)
      throws IOException {
    if (position + int_1 > length) {
      file.seek(1L + length);
      file.write(1);
      throw new EOFException();
    }
    file.write(bytes_0, int_0, int_1);
    position += int_1;
  }

  @Override
  protected void finalize() throws Throwable {
    if (file != null) {
      System.out.println("");
      close();
    }

  }

}
