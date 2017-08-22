package jagex.oldschool;

public class Class56 {

  public static boolean aBool18;
  public static int anInt140;
  public static int anInt141;
  public static boolean aBool19;
  public static int anInt142;
  public static int[] anIntArray35;
  public static boolean stereo;
  static int anInt143;

  static {
    aBool18 = false;
    anInt140 = 0;
    anInt141 = 0;
    aBool19 = false;
    anInt142 = 0;
    anIntArray35 = new int[1000];
  }

  public static int method364(int int_0, int int_1) {
    int int_2;
    for (int_2 = 0; int_1 > 0; --int_1) {
      int_2 = int_2 << 1 | int_0 & 0x1;
      int_0 >>>= 1;
    }

    return int_2;
  }

}
