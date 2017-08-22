package jagex.oldschool;

import java.applet.Applet;

public class Class25 {

  public static Applet anApplet1;
  public static String aString5;
  public static AClass4_Sub1 anAClass4_Sub1_1;

  static {
    anApplet1 = null;
    aString5 = null;
  }

  static Enum8[] method222() {
    return new Enum8[] {Enum8.anEnum8_2, Enum8.anEnum8_1, Enum8.anEnum8_3};
  }

  static void method223() {
    for (Node_Sub1 node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3
        .getFirst(); node_sub1_0 != null; node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getNext()) {
      if (node_sub1_0.anAClass4_Sub2_1 != null) {
        anAClass4_Sub1_1.method722(node_sub1_0.anAClass4_Sub2_1);
        node_sub1_0.anAClass4_Sub2_1 = null;
      }

      if (node_sub1_0.anAClass4_Sub2_2 != null) {
        anAClass4_Sub1_1.method722(node_sub1_0.anAClass4_Sub2_2);
        node_sub1_0.anAClass4_Sub2_2 = null;
      }
    }

    Node_Sub1.aDeque3.clear();
  }

  public static boolean method224(final int int_0) {
    return (int_0 >> 29 & 0x1) != 0;
  }

}
