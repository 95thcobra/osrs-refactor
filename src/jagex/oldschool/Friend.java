package jagex.oldschool;

import jagex.oldschool.util.Time;

public class Friend {

  static int anInt203;
  public String name;
  public int world;
  boolean aBool24;
  boolean aBool25;
  public String previousName;
  public int rank;

  public static void method520() {
    Overlay.overlays.reset();
  }

  static int method521(final int int_0, int int_1) {
    if (int_0 == -2) {
      return 12345678;
    }
    if (int_0 == -1) {
      if (int_1 < 0) {
        int_1 = 0;
      } else if (int_1 > 127) {
        int_1 = 127;
      }

      int_1 = 127 - int_1;
      return int_1;
    }
    int_1 = (int_0 & 0x7F) * int_1 / 128;
    if (int_1 < 2) {
      int_1 = 2;
    } else if (int_1 > 126) {
      int_1 = 126;
    }

    return (int_0 & 0xFF80) + int_1;
  }

  static void method522(final int int_0, final int int_1) {
    if (Ignore.loadWidget(int_0)) {
      Class23.method213(Time.widgets[int_0], int_1);
    }
  }

}
