package jagex.oldschool.config;

import jagex.oldschool.AClass1;
import jagex.oldschool.CacheableNode_Sub5;
import jagex.oldschool.CacheableNode_Sub6;
import jagex.oldschool.Class12;
import jagex.oldschool.Class35;
import jagex.oldschool.Class47;
import jagex.oldschool.Class64;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.util.Time;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ClientScriptVariable {

  boolean changed;
  String[] varcstrings;
  int[] varcs;
  long lastSerialize;
  boolean[] varcstringSerials;
  boolean[] varcSerials;

  public ClientScriptVariable() {
    changed = false;
    varcs = new int[AClass1.configsIndex.fileCount(19)];
    varcstrings = new String[AClass1.configsIndex.fileCount(15)];
    varcSerials = new boolean[varcs.length];

    int int_0;
    for (int_0 = 0; int_0 < varcs.length; int_0++) {
      final CacheableNode_Sub6 cacheablenode_sub6_0 = Class47.method295(int_0);
      varcSerials[int_0] = cacheablenode_sub6_0.aBool59;
    }

    varcstringSerials = new boolean[varcstrings.length];

    for (int_0 = 0; int_0 < varcstrings.length; int_0++) {
      CacheableNode_Sub5 cacheablenode_sub5_0 = (CacheableNode_Sub5) CacheableNode_Sub5.aNodeCache16
          .get(int_0);
      CacheableNode_Sub5 cacheablenode_sub5_1;
      if (cacheablenode_sub5_0 != null) {
        cacheablenode_sub5_1 = cacheablenode_sub5_0;
      } else {
        final byte[] bytes_0 = CacheableNode_Sub5.anIndexDataBase28.get(15, int_0);
        cacheablenode_sub5_0 = new CacheableNode_Sub5();
        if (bytes_0 != null) {
          cacheablenode_sub5_0.method857(new Buffer(bytes_0));
        }

        CacheableNode_Sub5.aNodeCache16.put(cacheablenode_sub5_0, int_0);
        cacheablenode_sub5_1 = cacheablenode_sub5_0;
      }

      varcstringSerials[int_0] = cacheablenode_sub5_1.aBool58;
    }

    for (int_0 = 0; int_0 < varcs.length; int_0++) {
      varcs[int_0] = -1;
    }

    deserialize();
  }

  public static void method526(final String string_0, final Throwable throwable_0) {
    throwable_0.printStackTrace();
  }

  public static DirectSprite method527(final byte[] bytes_0) {
    BufferedImage bufferedimage_0 = null;

    try {
      bufferedimage_0 = ImageIO.read(new ByteArrayInputStream(bytes_0));
      final int int_0 = bufferedimage_0.getWidth();
      final int int_1 = bufferedimage_0.getHeight();
      final int[] ints_0 = new int[int_1 * int_0];
      final PixelGrabber pixelgrabber_0 = new PixelGrabber(bufferedimage_0, 0, 0, int_0, int_1,
          ints_0, 0, int_0);
      pixelgrabber_0.grabPixels();
      return new DirectSprite(ints_0, int_0, int_1);
    } catch (final IOException ioexception_0) {
    } catch (final InterruptedException interruptedexception_0) {
    }

    return new DirectSprite(0, 0);
  }

  public static int method128(final int int_0) {
    return int_0 >> 17 & 0x7;
  }

  FileOnDisk getVarPrefs(final boolean bool_0) {
    return Class35.getPreferencesFile("2", Class12.game.aString20, bool_0);
  }

  public boolean changed() {
    return changed;
  }

  public void serialize() {
    final FileOnDisk fileondisk_0 = getVarPrefs(true);

    try {
      int int_0 = 3;
      int int_1 = 0;

      int int_2;
      for (int_2 = 0; int_2 < varcs.length; int_2++) {
        if (varcSerials[int_2] && varcs[int_2] != -1) {
          int_0 += 6;
          ++int_1;
        }
      }

      int_0 += 2;
      int_2 = 0;

      for (int int_3 = 0; int_3 < varcstrings.length; int_3++) {
        if (varcstringSerials[int_3] && varcstrings[int_3] != null) {
          int_0 += 2 + Class64.getLength(varcstrings[int_3]);
          ++int_2;
        }
      }

      final Buffer buffer_0 = new Buffer(int_0);
      buffer_0.putByte(1);
      buffer_0.putShort(int_1);

      int int_4;
      for (int_4 = 0; int_4 < varcs.length; int_4++) {
        if (varcSerials[int_4] && varcs[int_4] != -1) {
          buffer_0.putShort(int_4);
          buffer_0.putInt(varcs[int_4]);
        }
      }

      buffer_0.putShort(int_2);

      for (int_4 = 0; int_4 < varcstrings.length; int_4++) {
        if (varcstringSerials[int_4] && varcstrings[int_4] != null) {
          buffer_0.putShort(int_4);
          buffer_0.putString(varcstrings[int_4]);
        }
      }

      fileondisk_0.write(buffer_0.bytes, 0, buffer_0.offset);
    } catch (final Exception exception_0) {
    } finally {
      try {
        fileondisk_0.close();
      } catch (final Exception exception_1) {
      }

    }

    changed = false;
    lastSerialize = Time.currentTimeMillis();
  }

  void deserialize() {
    final FileOnDisk fileondisk_0 = getVarPrefs(false);

    try {
      final byte[] bytes_0 = new byte[(int) fileondisk_0.length()];

      int int_1;
      for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
        int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
        if (int_1 == -1) {
          throw new EOFException();
        }
      }

      final Buffer buffer_0 = new Buffer(bytes_0);
      if (buffer_0.bytes.length - buffer_0.offset < 1) {
        return;
      }

      final int int_2 = buffer_0.getUnsignedByte();
      if (int_2 < 0 || int_2 > 1) {
        return;
      }

      final int int_3 = buffer_0.getUnsignedShort();

      int int_4;
      int int_5;
      int int_6;
      for (int_4 = 0; int_4 < int_3; int_4++) {
        int_5 = buffer_0.getUnsignedShort();
        int_6 = buffer_0.getInt();
        if (varcSerials[int_5]) {
          varcs[int_5] = int_6;
        }
      }

      int_4 = buffer_0.getUnsignedShort();

      for (int_5 = 0; int_5 < int_4; int_5++) {
        int_6 = buffer_0.getUnsignedShort();
        final String string_0 = buffer_0.getString();
        if (varcstringSerials[int_6]) {
          varcstrings[int_6] = string_0;
        }
      }
    } catch (final Exception exception_0) {
    } finally {
      try {
        fileondisk_0.close();
      } catch (final Exception exception_1) {
      }

    }

    changed = false;
  }

  public String getVarcString(final int int_0) {
    return varcstrings[int_0];
  }

  public void putVarc(final int int_0, final int int_1) {
    varcs[int_0] = int_1;
    if (varcSerials[int_0]) {
      changed = true;
    }

  }

  public int getVarc(final int int_0) {
    return varcs[int_0];
  }

  public void putVarcString(final int int_0, final String string_0) {
    varcstrings[int_0] = string_0;
    if (varcstringSerials[int_0]) {
      changed = true;
    }

  }

  public void reset() {
    int int_0;
    for (int_0 = 0; int_0 < varcs.length; int_0++) {
      if (!varcSerials[int_0]) {
        varcs[int_0] = -1;
      }
    }

    for (int_0 = 0; int_0 < varcstrings.length; int_0++) {
      if (!varcstringSerials[int_0]) {
        varcstrings[int_0] = null;
      }
    }

  }

  public void process() {
    if (changed && lastSerialize < Time.currentTimeMillis() - 60000L) {
      serialize();
    }

  }

}
