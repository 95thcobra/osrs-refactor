package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.social.Ignore;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Time;

public final class Class22 {

  static final int[] anIntArray6;
  static final int[] anIntArray7;
  static final int[] anIntArray8;
  static final int[] anIntArray9;
  static final int[] anIntArray10;
  static final int[] anIntArray11;
  protected static String aString4;
  static BitmapFont aFont3;
  static int[][][] heightmap;
  public static byte[][][] flags;
  static int anInt70;
  static String aString3;
  static int anInt71;
  static int anInt72;
  static int anInt73;
  static byte[][][] underlayIds;
  static byte[][][] overlayIds;
  static byte[][][] overlayPaths;
  static byte[][][] overlayRotations;
  static byte[][][] aByteArrayArrayArray4;
  static int[] blendedHue;
  static Class45 aClass45_1;

  static {
    heightmap = new int[4][105][105];
    flags = new byte[4][104][104];
    anInt70 = 99;
    anIntArray6 = new int[] {1, 2, 4, 8};
    anIntArray7 = new int[] {16, 32, 64, 128};
    anIntArray8 = new int[] {1, 0, -1, 0};
    anIntArray9 = new int[] {0, -1, 0, 1};
    anIntArray10 = new int[] {1, -1, -1, 1};
    anIntArray11 = new int[] {-1, -1, 1, 1};
    anInt71 = (int) (Math.random() * 17.0D) - 8;
    anInt72 = (int) (Math.random() * 33.0D) - 16;
  }

  static void method207(final InterfaceComponent[] widgets_0, final int int_0) {
    for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
      final InterfaceComponent widget_0 = widgets_0[int_1];
      if (widget_0 != null && widget_0.parentId == int_0
          && (!widget_0.hasScript || !Renderable.method711(widget_0))) {
        int int_2;
        if (widget_0.type == 0) {
          if (!widget_0.hasScript && Renderable.method711(widget_0) && widget_0
              != IntegerVariable.aWidget4) {
            continue;
          }

          method207(widgets_0, widget_0.id);
          if (widget_0.children != null) {
            method207(widget_0.children, widget_0.id);
          }

          final OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable.get(widget_0.id);
          if (widgetnode_0 != null) {
            int_2 = widgetnode_0.id;
            if (Ignore.loadWidget(int_2)) {
              method207(Time.widgets[int_2], -1);
            }
          }
        }

        if (widget_0.type == 6) {
          if (widget_0.anInt266 != -1 || widget_0.anInt268 != -1) {
            final boolean bool_0 = Class59.method398(widget_0);
            if (bool_0) {
              int_2 = widget_0.anInt268;
            } else {
              int_2 = widget_0.anInt266;
            }

            if (int_2 != -1) {
              final AnimationSequence sequence_0 = PendingSpawn.getAnimationSequence(int_2);

              for (widget_0.anInt271 += Client.anInt610;
                  widget_0.anInt271 > sequence_0.frameLenghts[widget_0.anInt272]; Class28
                  .method236(widget_0)) {
                widget_0.anInt271 -= sequence_0.frameLenghts[widget_0.anInt272];
                ++widget_0.anInt272;
                if (widget_0.anInt272 >= sequence_0.frameIDs.length) {
                  widget_0.anInt272 -= sequence_0.frameStep;
                  if (widget_0.anInt272 < 0 || widget_0.anInt272
                      >= sequence_0.frameIDs.length) {
                    widget_0.anInt272 = 0;
                  }
                }
              }
            }
          }

          if (widget_0.anInt270 != 0 && !widget_0.hasScript) {
            int int_3 = widget_0.anInt270 >> 16;
            int_2 = widget_0.anInt270 << 16 >> 16;
            int_3 *= Client.anInt610;
            int_2 *= Client.anInt610;
            widget_0.rotationX = int_3 + widget_0.rotationX & 0x7FF;
            widget_0.rotationZ = int_2 + widget_0.rotationZ & 0x7FF;
            Class28.method236(widget_0);
          }
        }
      }
    }

  }

  static void method208() {
    if (Client.anInt660 != Class12.plane) {
      Client.anInt660 = Class12.plane;
      UrlStreamRequest.updateMap(Class12.plane);
    }

  }

  public static Class method209(final String string_0) throws ClassNotFoundException {
    return string_0.equals("B") ? Byte.TYPE
        : string_0.equals("I") ? Integer.TYPE
            : string_0.equals("S") ? Short.TYPE
                : string_0.equals("J") ? Long.TYPE
                    : string_0.equals("Z") ? Boolean.TYPE
                        : string_0.equals("F") ? Float.TYPE
                            : string_0.equals("D") ? Double.TYPE
                                : string_0.equals("C") ? Character.TYPE
                                    : string_0.equals("void") ? Void.TYPE
                                        : Class.forName(string_0);
  }

  public static void method210(final InterfaceComponent widget_0, final int int_0, final int int_1) {
    if (Client.aWidget9 == null) {
      if (!Client.isMenuOpen) {
        if (widget_0 != null) {
          if (Class23.method215(widget_0) != null) {
            Client.aWidget9 = widget_0;
            Client.aWidget10 = Class23.method215(widget_0);
            Client.anInt604 = int_0;
            Client.anInt605 = int_1;
            Class3.anInt21 = 0;
            Client.aBool85 = false;
            final int int_2 = Client.menuOptionCount - 1;
            if (int_2 != -1) {
              Comparator0.aClass28_1 = new Class28();
              Comparator0.aClass28_1.anInt77 = Client.menuActionParams0[int_2];
              Comparator0.aClass28_1.anInt78 = Client.menuActionParams1[int_2];
              Comparator0.aClass28_1.anInt79 = Client.menuTypes[int_2];
              Comparator0.aClass28_1.anInt80 = Client.menuIdentifiers[int_2];
              Comparator0.aClass28_1.aString6 = Client.menuOptions[int_2];
            }

          }
        }
      }
    }
  }

}
