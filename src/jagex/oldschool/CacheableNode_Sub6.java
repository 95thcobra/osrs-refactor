package jagex.oldschool;

import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;

public class CacheableNode_Sub6 extends Subnode {

  static Cache aNodeCache17;
  public static DirectSprite aSpritePixels4;

  static {
    aNodeCache17 = new Cache(64);
  }

  public boolean aBool59;

  CacheableNode_Sub6() {
    aBool59 = false;
  }

  public static int method861(final Buffer buffer_0, final String string_0) {
    final int int_0 = buffer_0.offset;
    final byte[] bytes_0 = Class43.method281(string_0);
    buffer_0.putShortSmart(bytes_0.length);
    buffer_0.offset += Class94.aHuffman1
        .compress(bytes_0, 0, bytes_0.length, buffer_0.bytes, buffer_0.offset);
    return buffer_0.offset - int_0;
  }

  void method859(final Buffer buffer_0, final int int_0) {
    if (int_0 == 2) {
      aBool59 = true;
    }

  }

  void method860(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method859(buffer_0, int_0);
    }
  }

}
