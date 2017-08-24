package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.collections.Node;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.ui.InterfaceComponent;
import java.net.URL;

public abstract class AClass3 extends Node {

  public static DirectSprite[] aSpritePixelsArray3;

  public static void method619() {
    InterfaceComponent.aNodeCache2.reset();
    InterfaceComponent.aNodeCache4.reset();
    InterfaceComponent.aNodeCache3.reset();
    InterfaceComponent.aNodeCache5.reset();
  }

  public static boolean method620(final String string_0, final int int_0, final String string_1) {
    if (int_0 == 0) {
      try {
        if (!Class25.aString5.startsWith("win")) {
          throw new Exception();
        }
        if (!string_0.startsWith("http://") && !string_0.startsWith("https://")) {
          throw new Exception();
        }
        final String string_2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

        for (int int_1 = 0; int_1 < string_0.length(); int_1++) {
          if (string_2.indexOf(string_0.charAt(int_1)) == -1) {
            throw new Exception();
          }
        }

        Runtime.getRuntime().exec("cmd /c start \"j\" \"" + string_0 + "\"");
        return true;
      } catch (final Throwable throwable_0) {
        return false;
      }
    }
    if (int_0 == 1) {
      try {
        final Object object_0 = Javascript.method205(Class25.anApplet1, string_1,
            new Object[] {new URL(Class25.anApplet1.getCodeBase(), string_0).toString()});
        return object_0 != null;
      } catch (final Throwable throwable_1) {
        return false;
      }
    }
    if (int_0 == 2) {
      try {
        Class25.anApplet1.getAppletContext()
            .showDocument(new URL(Class25.anApplet1.getCodeBase(), string_0),
                "_blank");
        return true;
      } catch (final Exception exception_0) {
        return false;
      }
    }
    if (int_0 == 3) {
      try {
        Javascript.method206(Class25.anApplet1, "loggedout");
      } catch (final Throwable throwable_2) {
      }

      try {
        Class25.anApplet1.getAppletContext()
            .showDocument(new URL(Class25.anApplet1.getCodeBase(), string_0),
                "_top");
        return true;
      } catch (final Exception exception_1) {
        return false;
      }
    }
    throw new IllegalArgumentException();
  }

  static void method621(final AnimationSequence sequence_0, final int int_0, final int int_1,
      final int int_2) {
    if (Client.anInt648 < 50) {
      if (Client.anInt634 != 0) {
        if (sequence_0.anIntArray108 != null && int_0 < sequence_0.anIntArray108.length) {
          final int int_3 = sequence_0.anIntArray108[int_0];
          if (int_3 != 0) {
            final int int_4 = int_3 >> 8;
            final int int_5 = int_3 >> 4 & 0x7;
            final int int_6 = int_3 & 0xF;
            Client.anIntArray145[Client.anInt648] = int_4;
            Client.anIntArray146[Client.anInt648] = int_5;
            Client.anIntArray147[Client.anInt648] = 0;
            Client.audioEffects[Client.anInt648] = null;
            final int int_7 = (int_1 - 64) / 128;
            final int int_8 = (int_2 - 64) / 128;
            Client.anIntArray148[Client.anInt648] = int_6 + (int_8 << 8) + (int_7 << 16);
            ++Client.anInt648;
          }
        }
      }
    }
  }

  abstract void method618();

}
