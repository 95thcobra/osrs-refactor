package jagex.oldschool;

import jagex.oldschool.ui.InterfaceComponent;

public class Class59 {

  public static boolean method397(final char char_0) {
    if ((char_0 <= 0 || char_0 >= 128) && (char_0 < 160 || char_0 > 255)) {
      if (char_0 != 0) {
        final char[] chars_0 = Class99.aCharArray5;

        for (int int_0 = 0; int_0 < chars_0.length; int_0++) {
          final char char_1 = chars_0[int_0];
          if (char_0 == char_1) {
            return true;
          }
        }
      }

      return false;
    }
    return true;
  }

  static boolean method398(final InterfaceComponent widget_0) {
    if (widget_0.tableActions == null) {
      return false;
    }
    for (int int_0 = 0; int_0 < widget_0.tableActions.length; int_0++) {
      final int int_1 = Class77.method469(widget_0, int_0);
      final int int_2 = widget_0.anIntArray71[int_0];
      if (widget_0.tableActions[int_0] == 2) {
        if (int_1 >= int_2) {
          return false;
        }
      } else if (widget_0.tableActions[int_0] == 3) {
        if (int_1 <= int_2) {
          return false;
        }
      } else if (widget_0.tableActions[int_0] == 4) {
        if (int_1 == int_2) {
          return false;
        }
      } else if (int_1 != int_2) {
        return false;
      }
    }

    return true;
  }

}
