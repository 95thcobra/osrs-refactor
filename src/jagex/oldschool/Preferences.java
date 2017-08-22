package jagex.oldschool;

import jagex.oldschool.animation.FrameBase;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Preferences {

  static int anInt167;
  static String authCode;

  static {
    anInt167 = 4;
  }

  int windowMode;
  LinkedHashMap preferences;
  public boolean hideRoofs;
  boolean muted;

  Preferences() {
    windowMode = 1;
    preferences = new LinkedHashMap();
    method423(true);
  }

  Preferences(final Buffer buffer_0) {
    windowMode = 1;
    preferences = new LinkedHashMap();
    if (buffer_0 != null && buffer_0.bytes != null) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 < 0 || int_0 > anInt167) {
        method423(true);
        return;
      }

      if (buffer_0.getUnsignedByte() == 1) {
        hideRoofs = true;
      }

      if (int_0 > 1) {
        muted = buffer_0.getUnsignedByte() == 1;
      }

      if (int_0 > 3) {
        windowMode = buffer_0.getUnsignedByte();
      }

      if (int_0 > 2) {
        final int int_1 = buffer_0.getUnsignedByte();

        for (int int_2 = 0; int_2 < int_1; int_2++) {
          final int int_3 = buffer_0.getInt();
          final int int_4 = buffer_0.getInt();
          preferences.put(Integer.valueOf(int_3), Integer.valueOf(int_4));
        }
      }
    } else {
      method423(true);
    }

  }

  static InterfaceComponent method424(InterfaceComponent widget_0) {
    final int int_0 = ClientScriptVariable.method128(Client.getWidgetConfig(widget_0));
    if (int_0 == 0) {
      return null;
    }
    for (int int_1 = 0; int_1 < int_0; int_1++) {
      widget_0 = ScriptExecutor.method240(widget_0.parentId);
      if (widget_0 == null) {
        return null;
      }
    }

    return widget_0;
  }

  public static Script method425(final int int_0) {
    Script script_0 = (Script) Script.aNodeCache18.get(int_0);
    if (script_0 != null) {
      return script_0;
    }
    final byte[] bytes_0 = FrameBase.indexScripts.get(int_0, 0);
    if (bytes_0 == null) {
      return null;
    }
    script_0 = Enum1.method604(bytes_0);
    Script.aNodeCache18.put(script_0, int_0);
    return script_0;
  }

  public static int method426(final int int_0, final int int_1, int int_2, int int_3, int int_4,
      final int int_5) {
    if ((int_5 & 0x1) == 1) {
      final int int_6 = int_3;
      int_3 = int_4;
      int_4 = int_6;
    }

    int_2 &= 0x3;
    return int_2 == 0 ? int_0
        : int_2 == 1 ? int_1 : int_2 == 2 ? 7 - int_0 - (int_3 - 1) : 7 - int_1 - (int_4 - 1);
  }

  void method423(final boolean bool_0) {
  }

  Buffer encode() {
    final Buffer buffer_0 = new Buffer(100);
    buffer_0.putByte(anInt167);
    buffer_0.putByte(hideRoofs ? 1 : 0);
    buffer_0.putByte(muted ? 1 : 0);
    buffer_0.putByte(windowMode);
    buffer_0.putByte(preferences.size());
    final Iterator iterator_0 = preferences.entrySet().iterator();

    while (iterator_0.hasNext()) {
      final Entry map$entry_0 = (Entry) iterator_0.next();
      buffer_0.putInt(((Integer) map$entry_0.getKey()).intValue());
      buffer_0.putInt(((Integer) map$entry_0.getValue()).intValue());
    }

    return buffer_0;
  }

}
