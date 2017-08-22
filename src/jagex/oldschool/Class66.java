package jagex.oldschool;

import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;
import java.io.IOException;

public class Class66 {

  public static int[][] anIntArrayArray10;
  public static int[][] anIntArrayArray11;
  public static int[] anIntArray38;
  public static int[] anIntArray39;
  public static int anInt166;

  static {
    anIntArrayArray10 = new int[128][128];
    anIntArrayArray11 = new int[128][128];
    anIntArray38 = new int[4096];
    anIntArray39 = new int[4096];
  }

  public static void method410() {
    try {
      if (Class72.anInt168 == 1) {
        int int_0 = Class72.anAClass4_Sub3_1.method802();
        if (int_0 > 0 && Class72.anAClass4_Sub3_1.method805()) {
          int_0 -= Class72.anInt169;
          if (int_0 < 0) {
            int_0 = 0;
          }

          Class72.anAClass4_Sub3_1.method809(int_0);
        } else {
          Class72.anAClass4_Sub3_1.method790();
          Class72.anAClass4_Sub3_1.method807();
          if (Class72.anIndexDataBase4 != null) {
            Class72.anInt168 = 2;
          } else {
            Class72.anInt168 = 0;
          }

          Class72.aTrack1_1 = null;
          Class72.aClass55_1 = null;
        }
      }
    } catch (final Exception exception_0) {
      exception_0.printStackTrace();
      Class72.anAClass4_Sub3_1.method790();
      Class72.anInt168 = 0;
      Class72.aTrack1_1 = null;
      Class72.aClass55_1 = null;
      Class72.anIndexDataBase4 = null;
    }
  }

  static void method411(final int int_0) {
    if (Ignore.loadWidget(int_0)) {
      final InterfaceComponent[] widgets_0 = Time.widgets[int_0];

      for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
        final InterfaceComponent widget_0 = widgets_0[int_1];
        if (widget_0 != null) {
          widget_0.anInt272 = 0;
          widget_0.anInt271 = 0;
        }
      }

    }
  }

  public static byte[] method412() {
    final byte[] bytes_0 = new byte[24];

    try {
      LocalInstall.random.seek(0L);
      LocalInstall.random.read(bytes_0);

      int int_0;
      for (int_0 = 0; int_0 < 24 && bytes_0[int_0] == 0; int_0++) {
      }

      if (int_0 >= 24) {
        throw new IOException();
      }
    } catch (final Exception exception_0) {
      for (int int_1 = 0; int_1 < 24; int_1++) {
        bytes_0[int_1] = -1;
      }
    }

    return bytes_0;
  }

}
