package jagex.oldschool.util;

import jagex.oldschool.LocalInstall;
import jagex.oldschool.scene.Square;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.io.Buffer;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timestamp {

  public static final String[][] aStringArrayArray1;
  public static final String[] aStringArray3;
  public static Calendar aCalendar2;

  static {
    aStringArrayArray1 = new String[][] {
        {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"},
        {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}
    };
    aStringArray3 = new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
    aCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
  }

  public static NpcConfig getNpcDefinition(final int int_0) {
    NpcConfig npccomposition_0 = (NpcConfig) NpcConfig.npcs.get(int_0);
    if (npccomposition_0 != null) {
      return npccomposition_0;
    }
    final byte[] bytes_0 = LocalInstall.anIndexDataBase3.get(9, int_0);
    npccomposition_0 = new NpcConfig();
    npccomposition_0.id = int_0;
    if (bytes_0 != null) {
      npccomposition_0.decode(new Buffer(bytes_0));
    }

    npccomposition_0.post();
    NpcConfig.npcs.put(npccomposition_0, int_0);
    return npccomposition_0;
  }

  public static String method427(final int int_0) {
    String string_0 = Integer.toString(int_0);

    for (int int_1 = string_0.length() - 3; int_1 > 0; int_1 -= 3) {
      string_0 = string_0.substring(0, int_1) + "," + string_0.substring(int_1);
    }

    return string_0.length() > 9
        ? " " + Square.embedColor(65408) + string_0.substring(0, string_0.length() - 8) + "M" + " "
        + " ("
        + string_0 + ")" + "</col>"
        : string_0.length() > 6
            ? " " + Square.embedColor(16777215) + string_0.substring(0, string_0.length() - 4) + "K"
            + " "
            + " (" + string_0 + ")" + "</col>"
            : " " + Square.embedColor(16776960) + string_0 + "</col>";
  }

  public static String get(final long long_0) {
    aCalendar2.setTime(new Date(long_0));
    final int int_0 = aCalendar2.get(7);
    final int int_1 = aCalendar2.get(5);
    final int int_2 = aCalendar2.get(2);
    final int int_3 = aCalendar2.get(1);
    final int int_4 = aCalendar2.get(11);
    final int int_5 = aCalendar2.get(12);
    final int int_6 = aCalendar2.get(13);
    return aStringArray3[int_0 - 1] + ", " + int_1 / 10 + int_1 % 10 + "-"
        + aStringArrayArray1[0][int_2] + "-" + int_3 + " " + int_4 / 10 + int_4 % 10
        + ":"
        + int_5 / 10 + int_5 % 10 + ":" + int_6 / 10 + int_6 % 10 + " GMT";
  }
}
