package jagex.oldschool.script;

import jagex.oldschool.ScriptArguments;
import jagex.oldschool.Class99;
import jagex.oldschool.collections.Node;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.World;

public class ScriptCall extends Node {

  public ScriptArguments aClass83_11;
  public Object[] anObjectArray22;
  public InterfaceComponent widget;
  public int anInt380;
  public int anInt381;
  public InterfaceComponent aWidget8;
  public int anInt382;
  public String aString27;
  public int anInt383;
  public int anInt384;
  public int anInt385;
  public boolean aBool49;

  public ScriptCall() {
    aClass83_11 = ScriptArguments.aClass83_2;
  }

  public static String getString(final byte[] bytes_0, final int int_0, final int int_1) {
    final char[] chars_0 = new char[int_1];
    int int_2 = 0;

    for (int int_3 = 0; int_3 < int_1; int_3++) {
      int int_4 = bytes_0[int_3 + int_0] & 0xFF;
      if (int_4 != 0) {
        if (int_4 >= 128 && int_4 < 160) {
          char char_0 = Class99.aCharArray5[int_4 - 128];
          if (char_0 == 0) {
            char_0 = 63;
          }

          int_4 = char_0;
        }

        chars_0[int_2++] = (char) int_4;
      }
    }

    return new String(chars_0, 0, int_2);
  }

  public static void method707(final World[] worlds_0, final int int_0, final int int_1,
      final int[] ints_0,
      final int[] ints_1) {
    if (int_0 < int_1) {
      int int_2 = int_0 - 1;
      int int_3 = int_1 + 1;
      final int int_4 = (int_1 + int_0) / 2;
      final World world_0 = worlds_0[int_4];
      worlds_0[int_4] = worlds_0[int_0];
      worlds_0[int_0] = world_0;

      while (int_2 < int_3) {
        boolean bool_0 = true;

        int int_5;
        int int_6;
        int int_7;
        do {
          --int_3;

          for (int_5 = 0; int_5 < 4; int_5++) {
            if (ints_0[int_5] == 2) {
              int_6 = worlds_0[int_3].index;
              int_7 = world_0.index;
            } else if (ints_0[int_5] == 1) {
              int_6 = worlds_0[int_3].playerCount;
              int_7 = world_0.playerCount;
              if (int_6 == -1 && ints_1[int_5] == 1) {
                int_6 = 2001;
              }

              if (int_7 == -1 && ints_1[int_5] == 1) {
                int_7 = 2001;
              }
            } else if (ints_0[int_5] == 3) {
              int_6 = worlds_0[int_3].method539() ? 1 : 0;
              int_7 = world_0.method539() ? 1 : 0;
            } else {
              int_6 = worlds_0[int_3].id;
              int_7 = world_0.id;
            }

            if (int_6 != int_7) {
              if ((ints_1[int_5] != 1 || int_6 <= int_7)
                  && (ints_1[int_5] != 0 || int_6 >= int_7)) {
                bool_0 = false;
              }
              break;
            }

            if (int_5 == 3) {
              bool_0 = false;
            }
          }
        } while (bool_0);

        bool_0 = true;

        do {
          ++int_2;

          for (int_5 = 0; int_5 < 4; int_5++) {
            if (ints_0[int_5] == 2) {
              int_6 = worlds_0[int_2].index;
              int_7 = world_0.index;
            } else if (ints_0[int_5] == 1) {
              int_6 = worlds_0[int_2].playerCount;
              int_7 = world_0.playerCount;
              if (int_6 == -1 && ints_1[int_5] == 1) {
                int_6 = 2001;
              }

              if (int_7 == -1 && ints_1[int_5] == 1) {
                int_7 = 2001;
              }
            } else if (ints_0[int_5] == 3) {
              int_6 = worlds_0[int_2].method539() ? 1 : 0;
              int_7 = world_0.method539() ? 1 : 0;
            } else {
              int_6 = worlds_0[int_2].id;
              int_7 = world_0.id;
            }

            if (int_6 != int_7) {
              if ((ints_1[int_5] != 1 || int_6 >= int_7)
                  && (ints_1[int_5] != 0 || int_6 <= int_7)) {
                bool_0 = false;
              }
              break;
            }

            if (int_5 == 3) {
              bool_0 = false;
            }
          }
        } while (bool_0);

        if (int_2 < int_3) {
          final World world_1 = worlds_0[int_2];
          worlds_0[int_2] = worlds_0[int_3];
          worlds_0[int_3] = world_1;
        }
      }

      method707(worlds_0, int_0, int_3, ints_0, ints_1);
      method707(worlds_0, int_3 + 1, int_1, ints_0, ints_1);
    }

  }

  public void method705(final Object[] objects_0) {
    anObjectArray22 = objects_0;
  }

  public void method706(final ScriptArguments class83_0) {
    aClass83_11 = class83_0;
  }

}
