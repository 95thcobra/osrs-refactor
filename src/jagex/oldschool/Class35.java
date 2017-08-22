package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Materials;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Comparator;

public final class Class35 implements Comparator {

  public static int anInt87;
  static IndexedSprite logoSprite;

  public static int getLength(final CharSequence seq) {
    final int int_0 = seq.length();
    int int_1 = 0;

    for (int int_2 = 0; int_2 < int_0; int_2++) {
      final char char_0 = seq.charAt(int_2);
      if (char_0 <= 127) {
        ++int_1;
      } else if (char_0 <= 2047) {
        int_1 += 2;
      } else {
        int_1 += 3;
      }
    }

    return int_1;
  }

  public static FileOnDisk getPreferencesFile(final String string_0, final String string_1,
      final boolean bool_0) {
    final File file_0 = new File(LocalInstall.aFile1, "preferences" + string_0 + ".dat");
    if (file_0.exists()) {
      try {
        final FileOnDisk fileondisk_1 = new FileOnDisk(file_0, "rw", 10000L);
        return fileondisk_1;
      } catch (final IOException ioexception_1) {
      }
    }

    String string_2 = "";
    if (Class26.anInt75 == 33) {
      string_2 = "_rc";
    } else if (Class26.anInt75 == 34) {
      string_2 = "_wip";
    }

    final File file_1 = new File(WorldMapType1.userHome,
        "jagex_" + string_1 + "_preferences" + string_0 + string_2 + ".dat");
    FileOnDisk fileondisk_0;
    if (!bool_0 && file_1.exists()) {
      try {
        fileondisk_0 = new FileOnDisk(file_1, "rw", 10000L);
        return fileondisk_0;
      } catch (final IOException ioexception_2) {
      }
    }

    try {
      fileondisk_0 = new FileOnDisk(file_0, "rw", 10000L);
      return fileondisk_0;
    } catch (final IOException ioexception_0) {
      throw new RuntimeException();
    }
  }

  public static int hash(final CharSequence charsequence_0) {
    final int int_0 = charsequence_0.length();
    int int_1 = 0;

    for (int int_2 = 0; int_2 < int_0; int_2++) {
      int_1 = (int_1 << 5) - int_1 + Class52.method330(charsequence_0.charAt(int_2));
    }

    return int_1;
  }

  public static void method254(final String string_0, final boolean bool_0, final String string_1,
      final boolean bool_1) {
    if (!bool_0) {
      Square.method659(string_0, 3);
    } else {
      if (!bool_1 && Desktop.isDesktopSupported() && Desktop.getDesktop()
          .isSupported(Action.BROWSE)) {
        try {
          Desktop.getDesktop().browse(new URI(string_0));
          return;
        } catch (final Exception exception_0) {
        }
      }

      if (Class25.aString5.startsWith("win") && !bool_1) {
        Square.method659(string_0, 0);
      } else if (Class25.aString5.startsWith("mac")) {
        AClass3.method620(string_0, 1, string_1);
      } else {
        Square.method659(string_0, 2);
      }
    }
  }

  public static void method255(final int int_0) {
    CollisionData.method572();
    Stub.method1049();
    final int int_1 = Class64.method406(int_0).configType;
    if (int_1 != 0) {
      final int int_2 = Class85.widgetSettings[int_0];
      if (int_1 == 1) {
        if (int_2 == 1) {
          Rasterizer3d.setBrightness(0.9D);
          ((Materials) Rasterizer3d.materials).setLightness(0.9D);
        }

        if (int_2 == 2) {
          Rasterizer3d.setBrightness(0.8D);
          ((Materials) Rasterizer3d.materials).setLightness(0.8D);
        }

        if (int_2 == 3) {
          Rasterizer3d.setBrightness(0.7D);
          ((Materials) Rasterizer3d.materials).setLightness(0.7D);
        }

        if (int_2 == 4) {
          Rasterizer3d.setBrightness(0.6D);
          ((Materials) Rasterizer3d.materials).setLightness(0.6D);
        }

        ItemConfig.itemSpriteCache.reset();
      }

      if (int_1 == 3) {
        short short_0 = 0;
        if (int_2 == 0) {
          short_0 = 255;
        }

        if (int_2 == 1) {
          short_0 = 192;
        }

        if (int_2 == 2) {
          short_0 = 128;
        }

        if (int_2 == 3) {
          short_0 = 64;
        }

        if (int_2 == 4) {
          short_0 = 0;
        }

        if (short_0 != Client.anInt656) {
          if (Client.anInt656 == 0 && Client.anInt613 != -1) {
            Class23.method212(CacheableNode_Sub4.indexTrack1, Client.anInt613, 0, short_0, false);
            Client.aBool81 = false;
          } else if (short_0 == 0) {
            Class72.anAClass4_Sub3_1.method790();
            Class72.anInt168 = 1;
            Class72.anIndexDataBase4 = null;
            Client.aBool81 = false;
          } else {
            Enum6.method673(short_0);
          }

          Client.anInt656 = short_0;
        }
      }

      if (int_1 == 4) {
        if (int_2 == 0) {
          Client.anInt647 = 127;
        }

        if (int_2 == 1) {
          Client.anInt647 = 96;
        }

        if (int_2 == 2) {
          Client.anInt647 = 64;
        }

        if (int_2 == 3) {
          Client.anInt647 = 32;
        }

        if (int_2 == 4) {
          Client.anInt647 = 0;
        }
      }

      if (int_1 == 5) {
        Client.anInt598 = int_2;
      }

      if (int_1 == 6) {
        Client.anInt669 = int_2;
      }

      if (int_1 == 9) {
        Client.anInt671 = int_2;
      }

      if (int_1 == 10) {
        if (int_2 == 0) {
          Client.anInt634 = 127;
        }

        if (int_2 == 1) {
          Client.anInt634 = 96;
        }

        if (int_2 == 2) {
          Client.anInt634 = 64;
        }

        if (int_2 == 3) {
          Client.anInt634 = 32;
        }

        if (int_2 == 4) {
          Client.anInt634 = 0;
        }
      }

      if (int_1 == 17) {
        Client.anInt679 = int_2 & 0xFFFF;
      }

      Enum2[] enum2s_0;
      if (int_1 == 18) {
        enum2s_0 = new Enum2[] {Enum2.anEnum2_2, Enum2.anEnum2_4, Enum2.anEnum2_3, Enum2.anEnum2_1};
        Client.anEnum2_5 = (Enum2) PlayerIdentity.forOrdinal(enum2s_0, int_2);
        if (Client.anEnum2_5 == null) {
          Client.anEnum2_5 = Enum2.anEnum2_1;
        }
      }

      if (int_1 == 19) {
        if (int_2 == -1) {
          Client.anInt652 = -1;
        } else {
          Client.anInt652 = int_2 & 0x7FF;
        }
      }

      if (int_1 == 22) {
        enum2s_0 = new Enum2[] {Enum2.anEnum2_2, Enum2.anEnum2_4, Enum2.anEnum2_3, Enum2.anEnum2_1};
        Client.anEnum2_6 = (Enum2) PlayerIdentity.forOrdinal(enum2s_0, int_2);
        if (Client.anEnum2_6 == null) {
          Client.anEnum2_6 = Enum2.anEnum2_1;
        }
      }

    }
  }

  public static int method256(int int_0, final Script script_0, final boolean bool_0) {
    InterfaceComponent widget_0;
    if (int_0 >= 2000) {
      int_0 -= 1000;
      widget_0 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
    } else {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
    }

    Class28.method236(widget_0);
    if (int_0 != 1200 && int_0 != 1205 && int_0 != 1212) {
      if (int_0 == 1201) {
        widget_0.modelType = 2;
        widget_0.modelId = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        return 1;
      }
      if (int_0 == 1202) {
        widget_0.modelType = 3;
        widget_0.modelId = GrandExchangeOffer.localPlayer.composition.method502();
        return 1;
      }
      return 2;
    }
    ScriptExecutor.intStackSize -= 2;
    final int int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
    final int int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
    widget_0.itemId = int_1;
    widget_0.itemQuantity = int_2;
    final ItemConfig itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
    widget_0.rotationX = itemcomposition_0.xan2d;
    widget_0.rotationZ = itemcomposition_0.yan2d;
    widget_0.rotationY = itemcomposition_0.zan2d;
    widget_0.anInt284 = itemcomposition_0.offsetX2d;
    widget_0.anInt285 = itemcomposition_0.offsetY2d;
    widget_0.modelZoom = itemcomposition_0.zoom2d;
    if (int_0 == 1205) {
      widget_0.anInt287 = 0;
    } else if (int_0 == 1212 | itemcomposition_0.isStackable == 1) {
      widget_0.anInt287 = 1;
    } else {
      widget_0.anInt287 = 2;
    }

    if (widget_0.anInt286 > 0) {
      widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.anInt286;
    } else if (widget_0.originalWidth > 0) {
      widget_0.modelZoom = widget_0.modelZoom * 32 / widget_0.originalWidth;
    }

    return 1;
  }

  int method252(final Class44 class44_0, final Class44 class44_1) {
    return class44_0.anInt95 < class44_1.anInt95 ? -1
        : class44_1.anInt95 == class44_0.anInt95 ? 0 : 1;
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method252((Class44) object_0, (Class44) object_1);
  }

}
