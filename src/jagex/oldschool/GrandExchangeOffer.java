package jagex.oldschool;

import jagex.oldschool.animation.Animation;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.ui.InterfaceComponent;

public class GrandExchangeOffer {

  public static boolean aBool5;
  static int menuWidth;
  public static Player localPlayer;
  public int price;
  public int totalQuantity;
  public int itemId;
  public int quantitySold;
  public int spent;
  byte progress;

  public GrandExchangeOffer() {
  }

  public GrandExchangeOffer(final Buffer buffer_0, final boolean bool_0) {
    progress = buffer_0.getByte();
    itemId = buffer_0.getUnsignedShort();
    price = buffer_0.getInt();
    totalQuantity = buffer_0.getInt();
    quantitySold = buffer_0.getInt();
    spent = buffer_0.getInt();
  }

  public static Animation method174(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final int int_0, final boolean bool_0) {
    boolean bool_1 = true;
    final int[] ints_0 = indexdatabase_0.getChilds(int_0);

    for (int int_1 = 0; int_1 < ints_0.length; int_1++) {
      final byte[] bytes_0 = indexdatabase_0.getChild(int_0, ints_0[int_1]);
      if (bytes_0 == null) {
        bool_1 = false;
      } else {
        final int int_2 = (bytes_0[0] & 0xFF) << 8 | bytes_0[1] & 0xFF;
        byte[] bytes_1;
        if (bool_0) {
          bytes_1 = indexdatabase_1.getChild(0, int_2);
        } else {
          bytes_1 = indexdatabase_1.getChild(int_2, 0);
        }

        if (bytes_1 == null) {
          bool_1 = false;
        }
      }
    }

    if (!bool_1) {
      return null;
    }
    try {
      return new Animation(indexdatabase_0, indexdatabase_1, int_0, bool_0);
    } catch (final Exception exception_0) {
      return null;
    }
  }

  public static void method175(final Model model_0, final int int_0) {
    for (int int_1 = 0; int_1 < model_0.fc; int_1++) {
      if (model_0.hsl2[int_1] != -2) {
        final int int_2 = model_0.v0[int_1];
        final int int_3 = model_0.v1[int_1];
        final int int_4 = model_0.v2[int_1];
        final int int_5 = Model.sx[int_2];
        final int int_6 = Model.sx[int_3];
        final int int_7 = Model.sx[int_4];
        Class85.method489(Model.sy[int_2], Model.sy[int_3],
            Model.sy[int_4],
            int_5, int_6, int_7, int_0);
      }
    }

  }

  static void method176() {
    final int int_0 = Client.menuX;
    final int int_1 = AnimationSequence.menuY;
    final int int_2 = menuWidth;
    final int int_3 = Class31.menuHeight;
    final int int_4 = 6116423;
    Rasterizer2d.fillRectangle(int_0, int_1, int_2, int_3, int_4);
    Rasterizer2d.fillRectangle(int_0 + 1, int_1 + 1, int_2 - 2, 16, 0);
    Rasterizer2d.drawRectangle(int_0 + 1, int_1 + 18, int_2 - 2, int_3 - 19, 0);
    Class22.aFont3.method999("Choose Option", int_0 + 3, int_1 + 14, int_4, -1);
    final int int_5 = Mouse.anInt249;
    final int int_6 = Mouse.anInt251;

    int int_7;
    int int_8;
    int int_9;
    for (int_7 = 0; int_7 < Client.menuOptionCount; int_7++) {
      int_8 = int_1 + (Client.menuOptionCount - 1 - int_7) * 15 + 31;
      int_9 = 16777215;
      if (int_5 > int_0 && int_5 < int_0 + int_2 && int_6 > int_8 - 13 && int_6 < int_8
          + 3) {
        int_9 = 16776960;
      }

      final BitmapFont font_0 = Class22.aFont3;
      String string_0;
      if (int_7 < 0) {
        string_0 = "";
      } else if (Client.menuTargets[int_7].length() > 0) {
        string_0 = Client.menuOptions[int_7] + " " + Client.menuTargets[int_7];
      } else {
        string_0 = Client.menuOptions[int_7];
      }

      font_0.method999(string_0, int_0 + 3, int_8, int_9, 0);
    }

    int_7 = Client.menuX;
    int_8 = AnimationSequence.menuY;
    int_9 = menuWidth;
    final int int_10 = Class31.menuHeight;

    for (int int_11 = 0; int_11 < Client.anInt596; int_11++) {
      if (Client.widgetBoundsWidth[int_11] + Client.widgetPositionX[int_11] > int_7
          && Client.widgetPositionX[int_11] < int_7 + int_9
          && Client.widgetBoundsHeight[int_11] + Client.widgetPositionY[int_11] > int_8
          && Client.widgetPositionY[int_11] < int_8 + int_10) {
        Client.aBoolArray10[int_11] = true;
      }
    }

  }

  static void method177() {
    if (Client.spellSelected) {
      final InterfaceComponent widget_0 = AClass4_Sub3.method819(Class10.anInt50, Client.anInt685);
      if (widget_0 != null && widget_0.anObjectArray6 != null) {
        final ScriptCall scriptevent_0 = new ScriptCall();
        scriptevent_0.widget = widget_0;
        scriptevent_0.anObjectArray22 = widget_0.anObjectArray6;
        Position.execute(scriptevent_0);
      }

      Client.spellSelected = false;
      Class28.method236(widget_0);
    }
  }

  void method170(final int int_0) {
    progress &= 0xFFFFFFF8;
    progress = (byte) (progress | int_0 & 0x7);
  }

  void method171(final int int_0) {
    progress &= 0xFFFFFFF7;
    if (int_0 == 1) {
      progress = (byte) (progress | 0x8);
    }

  }

  public int method172() {
    return (progress & 0x8) == 8 ? 1 : 0;
  }

  public int method173() {
    return progress & 0x7;
  }

}
