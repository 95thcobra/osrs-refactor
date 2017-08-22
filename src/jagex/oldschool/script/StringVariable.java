package jagex.oldschool.script;

import jagex.oldschool.Interface1;
import jagex.oldschool.asset.AbstractPackage;

public final class StringVariable implements Interface1 {

  public static int method248(final AbstractPackage indexdatabase_0, final AbstractPackage indexdatabase_1) {
    int int_0 = 0;
    if (indexdatabase_0.method451("title.jpg", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("logo", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("logo_deadman_mode", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("titlebox", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("titlebutton", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("runes", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("title_mute", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("options_radio_buttons,0", "")) {
      ++int_0;
    }

    if (indexdatabase_1.method451("options_radio_buttons,2", "")) {
      ++int_0;
    }

    indexdatabase_1.method451("sl_back", "");
    indexdatabase_1.method451("sl_flags", "");
    indexdatabase_1.method451("sl_arrows", "");
    indexdatabase_1.method451("sl_stars", "");
    indexdatabase_1.method451("sl_button", "");
    return int_0;
  }

}
