package jagex.oldschool.util;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileOnDisk;
import java.util.zip.Inflater;

public class GzipDecompressor {

  Inflater inflater;

  GzipDecompressor(final int int_0, final int int_1, final int int_2) {
  }

  public GzipDecompressor() {
    this(-1, 1000000, 1000000);
  }

  public static byte[] decompress(final byte[] src) {
    final Buffer buffer = new Buffer(src);
    final int algorithm = buffer.getUnsignedByte();
    final int len = buffer.getInt();
    if (len < 0 || AbstractPackage.MAXIMUM_LENGTH != 0 && len > AbstractPackage.MAXIMUM_LENGTH) {
      throw new RuntimeException();
    }
    if (algorithm == 0) {
      final byte[] bytes = new byte[len];
      buffer.get(bytes, 0, len);
      return bytes;
    }
    final int unpackedLen = buffer.getInt();
    if (unpackedLen >= 0 && (AbstractPackage.MAXIMUM_LENGTH
        == 0 || unpackedLen <= AbstractPackage.MAXIMUM_LENGTH)) {
      final byte[] bytes = new byte[unpackedLen];
      if (algorithm == 1) {
        BzipDecompressor.decompress(bytes, unpackedLen, src, len, 9);
      } else {
        AbstractPackage.gz.decompress(buffer, bytes);
      }

      return bytes;
    }
    throw new RuntimeException();
  }

  public static int method569(final int int_0, final int int_1) {
    int int_2 = FileOnDisk.getSmoothNoise(int_0 + 45365, int_1 + 91923, 4) - 128
        + (FileOnDisk.getSmoothNoise(int_0 + 10294, int_1 + 37821, 2) - 128 >> 1)
        + (FileOnDisk.getSmoothNoise(int_0, int_1, 1) - 128 >> 2);
    int_2 = (int) (0.3D * int_2) + 35;
    if (int_2 < 10) {
      int_2 = 10;
    } else if (int_2 > 60) {
      int_2 = 60;
    }

    return int_2;
  }

  public void decompress(final Buffer buffer, final byte[] dest) {
    if (buffer.bytes[buffer.offset] == 31 && buffer.bytes[buffer.offset + 1] == -117) {
      if (inflater == null) {
        inflater = new Inflater(true);
      }

      try {
        inflater.setInput(buffer.bytes, buffer.offset + 10,
            buffer.bytes.length - (buffer.offset + 8 + 10));
        inflater.inflate(dest);
      } catch (final Exception exception_0) {
        inflater.reset();
        throw new RuntimeException("");
      }

      inflater.reset();
    } else {
      throw new RuntimeException("");
    }
  }

}
