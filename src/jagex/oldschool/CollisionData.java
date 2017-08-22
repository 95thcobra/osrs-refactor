package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Time;

public class CollisionData {

  static AbstractPackage anIndexDataBase12;
  public int x;
  public int[][] flags;
  public int y;
  int width;
  int height;

  public CollisionData(final int int_0, final int int_1) {
    x = 0;
    y = 0;
    width = int_0;
    height = int_1;
    flags = new int[width][height];
    reset();
  }

  public static int getChecksum(final byte[] src, final int start, final int end) {
    int checksum = -1;
    for (int off = start; off < end; off++) {
      checksum = checksum >>> 8 ^ Buffer.CRC_TABLE[(checksum ^ src[off]) & 0xFF];
    }
    checksum = ~checksum;
    return checksum;
  }

  static void method572() {
    for (OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable
        .method66(); widgetnode_0 != null;
        widgetnode_0 = (OpenedInterface) Client.componentTable.method67()) {
      final int int_0 = widgetnode_0.id;
      if (Ignore.loadWidget(int_0)) {
        boolean bool_0 = true;
        final InterfaceComponent[] widgets_0 = Time.widgets[int_0];

        int int_1;
        for (int_1 = 0; int_1 < widgets_0.length; int_1++) {
          if (widgets_0[int_1] != null) {
            bool_0 = widgets_0[int_1].hasScript;
            break;
          }
        }

        if (!bool_0) {
          int_1 = (int) widgetnode_0.hash;
          final InterfaceComponent widget_0 = ScriptExecutor.method240(int_1);
          if (widget_0 != null) {
            Class28.method236(widget_0);
          }
        }
      }
    }

  }

  static void method573(final int int_0, final int int_1, final int int_2,
      final ObjectConfig objectcomposition_0, final int int_3) {
    final Node_Sub1 node_sub1_0 = new Node_Sub1();
    node_sub1_0.anInt317 = int_0;
    node_sub1_0.anInt314 = int_1 * 128;
    node_sub1_0.anInt316 = int_2 * 128;
    int int_4 = objectcomposition_0.sizeX;
    int int_5 = objectcomposition_0.sizeY;
    if (int_3 == 1 || int_3 == 3) {
      int_4 = objectcomposition_0.sizeY;
      int_5 = objectcomposition_0.sizeX;
    }

    node_sub1_0.anInt313 = (int_4 + int_1) * 128;
    node_sub1_0.anInt315 = (int_5 + int_2) * 128;
    node_sub1_0.anInt309 = objectcomposition_0.ambientSoundId;
    node_sub1_0.anInt310 = objectcomposition_0.anInt456 * 128;
    node_sub1_0.anInt311 = objectcomposition_0.anInt457;
    node_sub1_0.anInt312 = objectcomposition_0.anInt458;
    node_sub1_0.anIntArray77 = objectcomposition_0.anIntArray101;
    if (objectcomposition_0.impostorIds != null) {
      node_sub1_0.anObjectComposition1 = objectcomposition_0;
      node_sub1_0.method627();
    }

    Node_Sub1.aDeque3.addLast(node_sub1_0);
    if (node_sub1_0.anIntArray77 != null) {
      node_sub1_0.anInt318 = node_sub1_0.anInt311
          + (int) (Math.random() * (node_sub1_0.anInt312 - node_sub1_0.anInt311));
    }

  }

  void remove(final int int_0, final int int_1, final int int_2) {
    flags[int_0][int_1] &= ~int_2;
  }

  void add(final int int_0, final int int_1, final int int_2) {
    flags[int_0][int_1] |= int_2;
  }

  public void reset() {
    for (int int_0 = 0; int_0 < width; int_0++) {
      for (int int_1 = 0; int_1 < height; int_1++) {
        if (int_0 != 0 && int_1 != 0 && int_0 < width - 5 && int_1 < height - 5) {
          flags[int_0][int_1] = 16777216;
        } else {
          flags[int_0][int_1] = 16777215;
        }
      }
    }

  }

  public void removeWall(int int_0, int int_1, final int int_2, final int int_3,
      final boolean bool_0) {
    int_0 -= x;
    int_1 -= y;
    if (int_2 == 0) {
      if (int_3 == 0) {
        remove(int_0, int_1, 128);
        remove(int_0 - 1, int_1, 8);
      }

      if (int_3 == 1) {
        remove(int_0, int_1, 2);
        remove(int_0, int_1 + 1, 32);
      }

      if (int_3 == 2) {
        remove(int_0, int_1, 8);
        remove(int_0 + 1, int_1, 128);
      }

      if (int_3 == 3) {
        remove(int_0, int_1, 32);
        remove(int_0, int_1 - 1, 2);
      }
    }

    if (int_2 == 1 || int_2 == 3) {
      if (int_3 == 0) {
        remove(int_0, int_1, 1);
        remove(int_0 - 1, int_1 + 1, 16);
      }

      if (int_3 == 1) {
        remove(int_0, int_1, 4);
        remove(int_0 + 1, int_1 + 1, 64);
      }

      if (int_3 == 2) {
        remove(int_0, int_1, 16);
        remove(int_0 + 1, int_1 - 1, 1);
      }

      if (int_3 == 3) {
        remove(int_0, int_1, 64);
        remove(int_0 - 1, int_1 - 1, 4);
      }
    }

    if (int_2 == 2) {
      if (int_3 == 0) {
        remove(int_0, int_1, 130);
        remove(int_0 - 1, int_1, 8);
        remove(int_0, int_1 + 1, 32);
      }

      if (int_3 == 1) {
        remove(int_0, int_1, 10);
        remove(int_0, int_1 + 1, 32);
        remove(int_0 + 1, int_1, 128);
      }

      if (int_3 == 2) {
        remove(int_0, int_1, 40);
        remove(int_0 + 1, int_1, 128);
        remove(int_0, int_1 - 1, 2);
      }

      if (int_3 == 3) {
        remove(int_0, int_1, 160);
        remove(int_0, int_1 - 1, 2);
        remove(int_0 - 1, int_1, 8);
      }
    }

    if (bool_0) {
      if (int_2 == 0) {
        if (int_3 == 0) {
          remove(int_0, int_1, 65536);
          remove(int_0 - 1, int_1, 4096);
        }

        if (int_3 == 1) {
          remove(int_0, int_1, 1024);
          remove(int_0, int_1 + 1, 16384);
        }

        if (int_3 == 2) {
          remove(int_0, int_1, 4096);
          remove(int_0 + 1, int_1, 65536);
        }

        if (int_3 == 3) {
          remove(int_0, int_1, 16384);
          remove(int_0, int_1 - 1, 1024);
        }
      }

      if (int_2 == 1 || int_2 == 3) {
        if (int_3 == 0) {
          remove(int_0, int_1, 512);
          remove(int_0 - 1, int_1 + 1, 8192);
        }

        if (int_3 == 1) {
          remove(int_0, int_1, 2048);
          remove(int_0 + 1, int_1 + 1, 32768);
        }

        if (int_3 == 2) {
          remove(int_0, int_1, 8192);
          remove(int_0 + 1, int_1 - 1, 512);
        }

        if (int_3 == 3) {
          remove(int_0, int_1, 32768);
          remove(int_0 - 1, int_1 - 1, 2048);
        }
      }

      if (int_2 == 2) {
        if (int_3 == 0) {
          remove(int_0, int_1, 66560);
          remove(int_0 - 1, int_1, 4096);
          remove(int_0, int_1 + 1, 16384);
        }

        if (int_3 == 1) {
          remove(int_0, int_1, 5120);
          remove(int_0, int_1 + 1, 16384);
          remove(int_0 + 1, int_1, 65536);
        }

        if (int_3 == 2) {
          remove(int_0, int_1, 20480);
          remove(int_0 + 1, int_1, 65536);
          remove(int_0, int_1 - 1, 1024);
        }

        if (int_3 == 3) {
          remove(int_0, int_1, 81920);
          remove(int_0, int_1 - 1, 1024);
          remove(int_0 - 1, int_1, 4096);
          return;
        }
      }
    }

  }

  public void unblock(int int_0, int int_1) {
    int_0 -= x;
    int_1 -= y;
    flags[int_0][int_1] &= 0xFFFBFFFF;
  }

  public void removeObject(int int_0, int int_1, int int_2, int int_3, final int int_4,
      final boolean bool_0) {
    int int_5 = 256;
    if (bool_0) {
      int_5 += 131072;
    }

    int_0 -= x;
    int_1 -= y;
    int int_6;
    if (int_4 == 1 || int_4 == 3) {
      int_6 = int_2;
      int_2 = int_3;
      int_3 = int_6;
    }

    for (int_6 = int_0; int_6 < int_2 + int_0; int_6++) {
      if (int_6 >= 0 && int_6 < width) {
        for (int int_7 = int_1; int_7 < int_1 + int_3; int_7++) {
          if (int_7 >= 0 && int_7 < height) {
            remove(int_6, int_7, int_5);
          }
        }
      }
    }

  }

  public void block(int int_0, int int_1) {
    int_0 -= x;
    int_1 -= y;
    flags[int_0][int_1] |= 0x40000;
  }

  public void addObject(int int_0, int int_1, final int int_2, final int int_3,
      final boolean bool_0) {
    int int_4 = 256;
    if (bool_0) {
      int_4 += 131072;
    }

    int_0 -= x;
    int_1 -= y;

    for (int int_5 = int_0; int_5 < int_2 + int_0; int_5++) {
      if (int_5 >= 0 && int_5 < width) {
        for (int int_6 = int_1; int_6 < int_1 + int_3; int_6++) {
          if (int_6 >= 0 && int_6 < height) {
            add(int_5, int_6, int_4);
          }
        }
      }
    }

  }

  public void addWall(int int_0, int int_1, final int int_2, final int int_3,
      final boolean bool_0) {
    int_0 -= x;
    int_1 -= y;
    if (int_2 == 0) {
      if (int_3 == 0) {
        add(int_0, int_1, 128);
        add(int_0 - 1, int_1, 8);
      }

      if (int_3 == 1) {
        add(int_0, int_1, 2);
        add(int_0, int_1 + 1, 32);
      }

      if (int_3 == 2) {
        add(int_0, int_1, 8);
        add(int_0 + 1, int_1, 128);
      }

      if (int_3 == 3) {
        add(int_0, int_1, 32);
        add(int_0, int_1 - 1, 2);
      }
    }

    if (int_2 == 1 || int_2 == 3) {
      if (int_3 == 0) {
        add(int_0, int_1, 1);
        add(int_0 - 1, int_1 + 1, 16);
      }

      if (int_3 == 1) {
        add(int_0, int_1, 4);
        add(int_0 + 1, int_1 + 1, 64);
      }

      if (int_3 == 2) {
        add(int_0, int_1, 16);
        add(int_0 + 1, int_1 - 1, 1);
      }

      if (int_3 == 3) {
        add(int_0, int_1, 64);
        add(int_0 - 1, int_1 - 1, 4);
      }
    }

    if (int_2 == 2) {
      if (int_3 == 0) {
        add(int_0, int_1, 130);
        add(int_0 - 1, int_1, 8);
        add(int_0, int_1 + 1, 32);
      }

      if (int_3 == 1) {
        add(int_0, int_1, 10);
        add(int_0, int_1 + 1, 32);
        add(int_0 + 1, int_1, 128);
      }

      if (int_3 == 2) {
        add(int_0, int_1, 40);
        add(int_0 + 1, int_1, 128);
        add(int_0, int_1 - 1, 2);
      }

      if (int_3 == 3) {
        add(int_0, int_1, 160);
        add(int_0, int_1 - 1, 2);
        add(int_0 - 1, int_1, 8);
      }
    }

    if (bool_0) {
      if (int_2 == 0) {
        if (int_3 == 0) {
          add(int_0, int_1, 65536);
          add(int_0 - 1, int_1, 4096);
        }

        if (int_3 == 1) {
          add(int_0, int_1, 1024);
          add(int_0, int_1 + 1, 16384);
        }

        if (int_3 == 2) {
          add(int_0, int_1, 4096);
          add(int_0 + 1, int_1, 65536);
        }

        if (int_3 == 3) {
          add(int_0, int_1, 16384);
          add(int_0, int_1 - 1, 1024);
        }
      }

      if (int_2 == 1 || int_2 == 3) {
        if (int_3 == 0) {
          add(int_0, int_1, 512);
          add(int_0 - 1, int_1 + 1, 8192);
        }

        if (int_3 == 1) {
          add(int_0, int_1, 2048);
          add(int_0 + 1, int_1 + 1, 32768);
        }

        if (int_3 == 2) {
          add(int_0, int_1, 8192);
          add(int_0 + 1, int_1 - 1, 512);
        }

        if (int_3 == 3) {
          add(int_0, int_1, 32768);
          add(int_0 - 1, int_1 - 1, 2048);
        }
      }

      if (int_2 == 2) {
        if (int_3 == 0) {
          add(int_0, int_1, 66560);
          add(int_0 - 1, int_1, 4096);
          add(int_0, int_1 + 1, 16384);
        }

        if (int_3 == 1) {
          add(int_0, int_1, 5120);
          add(int_0, int_1 + 1, 16384);
          add(int_0 + 1, int_1, 65536);
        }

        if (int_3 == 2) {
          add(int_0, int_1, 20480);
          add(int_0 + 1, int_1, 65536);
          add(int_0, int_1 - 1, 1024);
        }

        if (int_3 == 3) {
          add(int_0, int_1, 81920);
          add(int_0, int_1 - 1, 1024);
          add(int_0 - 1, int_1, 4096);
          return;
        }
      }
    }

  }

  public void method570(int int_0, int int_1) {
    int_0 -= x;
    int_1 -= y;
    flags[int_0][int_1] |= 0x200000;
  }

}
