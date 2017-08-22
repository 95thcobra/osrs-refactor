package jagex.oldschool;

import jagex.oldschool.io.Buffer;

public class Class39 {

  public static byte[] aByteArray3;
  static byte[] aByteArray4;
  public static Buffer[] aBufferArray1;
  public static int anInt89;
  public static int[] anIntArray14;
  public static int anInt90;
  public static int[] anIntArray15;
  public static int[] anIntArray16;
  public static int[] anIntArray17;
  public static int[] anIntArray18;
  static int anInt91;
  static int[] anIntArray19;
  static Buffer aBuffer2;

  static {
    aByteArray3 = new byte[2048];
    aByteArray4 = new byte[2048];
    aBufferArray1 = new Buffer[2048];
    anInt89 = 0;
    anIntArray14 = new int[2048];
    anInt90 = 0;
    anIntArray15 = new int[2048];
    anIntArray16 = new int[2048];
    anIntArray17 = new int[2048];
    anIntArray18 = new int[2048];
    anInt91 = 0;
    anIntArray19 = new int[2048];
    aBuffer2 = new Buffer(new byte[5000]);
  }

  static int method267(final int int_0) {
    final ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class36.chatLineMap
        .get(Integer.valueOf(int_0));
    return chatlinebuffer_0 == null ? 0 : chatlinebuffer_0.method12();
  }

}
