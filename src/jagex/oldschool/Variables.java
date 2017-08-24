package jagex.oldschool;

import jagex.oldschool.animation.FrameBase;
import jagex.oldschool.asset.Package;
import jagex.oldschool.script.Class34;
import jagex.oldschool.script.Script;

public class Variables {

  public static int[] settings;
  public static int[] widgetSettings;
  public static int[] MASKS;
  static Package anIndexData2;
  public static short[] aShortArray3;

  static {
    MASKS = new int[32];
    int int_0 = 2;

    for (int int_1 = 0; int_1 < 32; int_1++) {
      MASKS[int_1] = int_0 - 1;
      int_0 += int_0;
    }

    settings = new int[2000];
    widgetSettings = new int[2000];
  }

  static void method489(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    final int int_7 = Math.min(int_3, Math.min(int_4, int_5)) - int_6;
    final int int_8 = Math.max(int_3, Math.max(int_4, int_5)) + int_6;
    final int int_9 = Math.min(int_0, Math.min(int_1, int_2)) - int_6;
    final int int_10 = Math.max(int_0, Math.max(int_1, int_2)) + int_6;
    Class34.method249(int_7, int_9, int_8, int_10, -49088);
  }

  static Script method490(final int int_0, final ScriptArguments class83_0) {
    Script script_0 = (Script) Script.aNodeCache18.get(int_0 << 16);
    if (script_0 != null) {
      return script_0;
    }
    final String string_0 = String.valueOf(int_0);
    final int int_1 = FrameBase.indexScripts.getFile(string_0);
    if (int_1 == -1) {
      return null;
    }
    final byte[] bytes_0 = FrameBase.indexScripts.method453(int_1);
    if (bytes_0 != null) {
      if (bytes_0.length <= 1) {
        return null;
      }

      script_0 = Enum1.method604(bytes_0);
      if (script_0 != null) {
        Script.aNodeCache18.put(script_0, int_0 << 16);
        return script_0;
      }
    }

    return null;
  }

}
