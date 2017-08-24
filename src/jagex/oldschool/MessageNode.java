package jagex.oldschool;

import jagex.oldschool.collections.Subnode;
import jagex.oldschool.config.ObjectConfig;

public class MessageNode extends Subnode {

  static int selectedItemIndex;
  int id;
  int tick;
  int type;
  String name;
  String sender;
  String value;

  MessageNode(final int int_0, final String string_0, final String string_1,
      final String string_2) {
    final int int_1 = ++Class36.anInt88 - 1;
    id = int_1;
    tick = Client.tick;
    type = int_0;
    name = string_0;
    sender = string_1;
    value = string_2;
  }

  static boolean method909(final int int_0, int int_1) {
    final ObjectConfig objectcomposition_0 = Class2.getObjectConfig(int_0);
    if (int_1 == 11) {
      int_1 = 10;
    }

    if (int_1 >= 5 && int_1 <= 8) {
      int_1 = 4;
    }

    return objectcomposition_0.method822(int_1);
  }

  void setMessage(final int int_0, final String string_0, final String string_1,
      final String string_2) {
    final int int_1 = ++Class36.anInt88 - 1;
    id = int_1;
    tick = Client.tick;
    type = int_0;
    name = string_0;
    sender = string_1;
    value = string_2;
  }

}
