package jagex.oldschool.util;

public class Skills {

  public static final boolean[] ACTIVE;
  public static int[] EXPERIENCE;

  static {
    ACTIVE = new boolean[] {
        true, true, true, true, true, true, true, true, true, true, true, true, true,
        true, true, true, true, true, true, true, true, true, true, false, false
    };
    EXPERIENCE = new int[99];
    int int_0 = 0;

    for (int int_1 = 0; int_1 < 99; int_1++) {
      final int int_2 = int_1 + 1;
      final int int_3 = (int) (int_2 + 300.0D * Math.pow(2.0D, int_2 / 7.0D));
      int_0 += int_3;
      EXPERIENCE[int_1] = int_0 / 4;
    }

  }

}
