package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.scene.Scene;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.social.Friend;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Time;
import java.util.Comparator;

public final class Comparator0 implements Comparator {

  static Class28 aClass28_1;

  static void method303(final InterfaceComponent widget_0, final int int_0, final int int_1) {
    if (widget_0.anInt261 == 0) {
      widget_0.relativeX = widget_0.originalX;
    } else if (widget_0.anInt261 == 1) {
      widget_0.relativeX = widget_0.originalX + (int_0 - widget_0.width) / 2;
    } else if (widget_0.anInt261 == 2) {
      widget_0.relativeX = int_0 - widget_0.width - widget_0.originalX;
    } else if (widget_0.anInt261 == 3) {
      widget_0.relativeX = widget_0.originalX * int_0 >> 14;
    } else if (widget_0.anInt261 == 4) {
      widget_0.relativeX = (int_0 - widget_0.width) / 2 + (widget_0.originalX * int_0 >> 14);
    } else {
      widget_0.relativeX = int_0 - widget_0.width - (widget_0.originalX * int_0 >> 14);
    }

    if (widget_0.anInt264 == 0) {
      widget_0.relativeY = widget_0.originalY;
    } else if (widget_0.anInt264 == 1) {
      widget_0.relativeY = (int_1 - widget_0.height) / 2 + widget_0.originalY;
    } else if (widget_0.anInt264 == 2) {
      widget_0.relativeY = int_1 - widget_0.height - widget_0.originalY;
    } else if (widget_0.anInt264 == 3) {
      widget_0.relativeY = int_1 * widget_0.originalY >> 14;
    } else if (widget_0.anInt264 == 4) {
      widget_0.relativeY = (int_1 - widget_0.height) / 2 + (int_1 * widget_0.originalY >> 14);
    } else {
      widget_0.relativeY = int_1 - widget_0.height - (int_1 * widget_0.originalY >> 14);
    }

    if (Client.aBool80 && widget_0.type == 0) {
      if (widget_0.relativeX < 0) {
        widget_0.relativeX = 0;
      } else if (widget_0.relativeX + widget_0.width > int_0) {
        widget_0.relativeX = int_0 - widget_0.width;
      }

      if (widget_0.relativeY < 0) {
        widget_0.relativeY = 0;
      } else if (widget_0.height + widget_0.relativeY > int_1) {
        widget_0.relativeY = int_1 - widget_0.height;
        return;
      }
    }

  }

  static AClass2 method304(final int int_0, final int int_1) {
    Client.anAClass2_Sub1_1.anInt154 = int_0;
    Client.anAClass2_Sub1_1.anInt155 = int_1;
    Client.anAClass2_Sub1_1.anInt156 = 1;
    Client.anAClass2_Sub1_1.anInt157 = 1;
    return Client.anAClass2_Sub1_1;
  }

  public static void method305(final OpenedInterface widgetnode_0, final boolean bool_0) {
    final int int_0 = widgetnode_0.id;
    final int int_1 = (int) widgetnode_0.hash;
    widgetnode_0.unlink();
    if (bool_0 && int_0 != -1 && PrimitiveType.validInterfaces[int_0]) {
      AudioWorker.widgetIndex.clear(int_0);
      if (Time.widgets[int_0] != null) {
        boolean bool_1 = true;

        for (int int_2 = 0; int_2 < Time.widgets[int_0].length; int_2++) {
          if (Time.widgets[int_0][int_2] != null) {
            if (Time.widgets[int_0][int_2].type != 2) {
              Time.widgets[int_0][int_2] = null;
            } else {
              bool_1 = false;
            }
          }
        }

        if (bool_1) {
          Time.widgets[int_0] = null;
        }

        PrimitiveType.validInterfaces[int_0] = false;
      }
    }

    for (IntegerNode integernode_0 = (IntegerNode) Client.widgetFlags
        .method66(); integernode_0 != null;
        integernode_0 = (IntegerNode) Client.widgetFlags.method67()) {
      if ((integernode_0.hash >> 48 & 0xFFFFL) == int_0) {
        integernode_0.unlink();
      }
    }

    final InterfaceComponent widget_0 = ScriptExecutor.method240(int_1);
    if (widget_0 != null) {
      Class28.method236(widget_0);
    }

    AClass2_Sub1.method616();
    if (Client.widgetRoot != -1) {
      Friend.method522(Client.widgetRoot, 1);
    }

  }

  static void method306(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final Scene region_0,
      final CollisionData collisiondata_0) {
    final ObjectConfig objectcomposition_0 = Class2.getObjectConfig(int_4);
    int int_7;
    int int_8;
    if (int_5 != 1 && int_5 != 3) {
      int_7 = objectcomposition_0.width;
      int_8 = objectcomposition_0.height;
    } else {
      int_7 = objectcomposition_0.height;
      int_8 = objectcomposition_0.width;
    }

    int int_9;
    int int_10;
    if (int_7 + int_2 <= 104) {
      int_9 = (int_7 >> 1) + int_2;
      int_10 = int_2 + (int_7 + 1 >> 1);
    } else {
      int_9 = int_2;
      int_10 = int_2 + 1;
    }

    int int_11;
    int int_12;
    if (int_3 + int_8 <= 104) {
      int_11 = int_3 + (int_8 >> 1);
      int_12 = int_3 + (int_8 + 1 >> 1);
    } else {
      int_11 = int_3;
      int_12 = int_3 + 1;
    }

    final int[][] ints_0 = Class22.heightmap[int_1];
    final int int_13 = ints_0[int_9][int_12] + ints_0[int_10][int_11] + ints_0[int_9][int_11]
        + ints_0[int_10][int_12] >> 2;
    final int int_14 = (int_2 << 7) + (int_7 << 6);
    final int int_15 = (int_3 << 7) + (int_8 << 6);
    int int_16 = (int_3 << 7) + int_2 + (int_4 << 14) + 1073741824;
    if (objectcomposition_0.anInt454 == 0) {
      int_16 -= Integer.MIN_VALUE;
    }

    int int_17 = (int_5 << 6) + int_6;
    if (objectcomposition_0.anInt455 == 1) {
      int_17 += 256;
    }

    Object object_0;
    if (int_6 == 22) {
      if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
        object_0 = objectcomposition_0.method824(22, int_5, ints_0, int_14, int_13, int_15);
      } else {
        object_0 = new DynamicObject(int_4, 22, int_5, int_1, int_2, int_3,
            objectcomposition_0.animationId,
            true, null);
      }

      region_0
          .groundObjectSpawned(int_0, int_2, int_3, int_13, (Renderable) object_0, int_16, int_17);
      if (objectcomposition_0.interactType == 1) {
        collisiondata_0.block(int_2, int_3);
      }

    } else if (int_6 != 10 && int_6 != 11) {
      if (int_6 >= 12) {
        if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
          object_0 = objectcomposition_0.method824(int_6, int_5, ints_0, int_14, int_13, int_15);
        } else {
          object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3,
              objectcomposition_0.animationId, true, null);
        }

        region_0
            .method382(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, int_16, int_17);
        if (objectcomposition_0.interactType != 0) {
          collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool55);
        }

      } else if (int_6 == 0) {
        if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
          object_0 = objectcomposition_0.method824(0, int_5, ints_0, int_14, int_13, int_15);
        } else {
          object_0 = new DynamicObject(int_4, 0, int_5, int_1, int_2, int_3,
              objectcomposition_0.animationId,
              true, null);
        }

        region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
            Class22.anIntArray6[int_5], 0, int_16, int_17);
        if (objectcomposition_0.interactType != 0) {
          collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool55);
        }

      } else if (int_6 == 1) {
        if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
          object_0 = objectcomposition_0.method824(1, int_5, ints_0, int_14, int_13, int_15);
        } else {
          object_0 = new DynamicObject(int_4, 1, int_5, int_1, int_2, int_3,
              objectcomposition_0.animationId,
              true, null);
        }

        region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
            Class22.anIntArray7[int_5], 0, int_16, int_17);
        if (objectcomposition_0.interactType != 0) {
          collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool55);
        }

      } else {
        int int_18;
        Object object_2;
        if (int_6 == 2) {
          int_18 = int_5 + 1 & 0x3;
          Object object_1;
          if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
              == null) {
            object_1 = objectcomposition_0.method824(2, int_5 + 4, ints_0, int_14, int_13, int_15);
            object_2 = objectcomposition_0.method824(2, int_18, ints_0, int_14, int_13, int_15);
          } else {
            object_1 = new DynamicObject(int_4, 2, int_5 + 4, int_1, int_2, int_3,
                objectcomposition_0.animationId, true, null);
            object_2 = new DynamicObject(int_4, 2, int_18, int_1, int_2, int_3,
                objectcomposition_0.animationId, true, null);
          }

          region_0.addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_1,
              (Renderable) object_2,
              Class22.anIntArray6[int_5], Class22.anIntArray6[int_18], int_16, int_17);
          if (objectcomposition_0.interactType != 0) {
            collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool55);
          }

        } else if (int_6 == 3) {
          if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
              == null) {
            object_0 = objectcomposition_0.method824(3, int_5, ints_0, int_14, int_13, int_15);
          } else {
            object_0 = new DynamicObject(int_4, 3, int_5, int_1, int_2, int_3,
                objectcomposition_0.animationId, true, null);
          }

          region_0
              .addBoundary(int_0, int_2, int_3, int_13, (Renderable) object_0, null,
                  Class22.anIntArray7[int_5], 0, int_16, int_17);
          if (objectcomposition_0.interactType != 0) {
            collisiondata_0.addWall(int_2, int_3, int_6, int_5, objectcomposition_0.aBool55);
          }

        } else if (int_6 == 9) {
          if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
              == null) {
            object_0 = objectcomposition_0.method824(int_6, int_5, ints_0, int_14, int_13, int_15);
          } else {
            object_0 = new DynamicObject(int_4, int_6, int_5, int_1, int_2, int_3,
                objectcomposition_0.animationId, true, null);
          }

          region_0.method382(int_0, int_2, int_3, int_13, 1, 1, (Renderable) object_0, 0, int_16,
              int_17);
          if (objectcomposition_0.interactType != 0) {
            collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool55);
          }

        } else if (int_6 == 4) {
          if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
              == null) {
            object_0 = objectcomposition_0.method824(4, int_5, ints_0, int_14, int_13, int_15);
          } else {
            object_0 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3,
                objectcomposition_0.animationId, true, null);
          }

          region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_0,
              null, Class22.anIntArray6[int_5], 0, 0, 0, int_16, int_17);
        } else {
          int int_19;
          if (int_6 == 5) {
            int_18 = 16;
            int_19 = region_0.method372(int_0, int_2, int_3);
            if (int_19 != 0) {
              int_18 = Class2.getObjectConfig(int_19 >> 14 & 0x7FFF).anInt459;
            }

            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
                == null) {
              object_2 = objectcomposition_0.method824(4, int_5, ints_0, int_14, int_13, int_15);
            } else {
              object_2 = new DynamicObject(int_4, 4, int_5, int_1, int_2, int_3,
                  objectcomposition_0.animationId, true, null);
            }

            region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2,
                null, Class22.anIntArray6[int_5], 0,
                int_18 * Class22.anIntArray8[int_5],
                int_18 * Class22.anIntArray9[int_5], int_16, int_17);
          } else if (int_6 == 6) {
            int_18 = 8;
            int_19 = region_0.method372(int_0, int_2, int_3);
            if (int_19 != 0) {
              int_18 = Class2.getObjectConfig(int_19 >> 14 & 0x7FFF).anInt459 / 2;
            }

            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
                == null) {
              object_2 = objectcomposition_0
                  .method824(4, int_5 + 4, ints_0, int_14, int_13, int_15);
            } else {
              object_2 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3,
                  objectcomposition_0.animationId, true, null);
            }

            region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2,
                null, 256, int_5, int_18 * Class22.anIntArray10[int_5],
                int_18 * Class22.anIntArray11[int_5], int_16, int_17);
          } else if (int_6 == 7) {
            int_19 = int_5 + 2 & 0x3;
            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
                == null) {
              object_0 = objectcomposition_0
                  .method824(4, int_19 + 4, ints_0, int_14, int_13, int_15);
            } else {
              object_0 = new DynamicObject(int_4, 4, int_19 + 4, int_1, int_2, int_3,
                  objectcomposition_0.animationId, true, null);
            }

            region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_0,
                null, 256, int_19, 0, 0, int_16, int_17);
          } else if (int_6 == 8) {
            int_18 = 8;
            int_19 = region_0.method372(int_0, int_2, int_3);
            if (int_19 != 0) {
              int_18 = Class2.getObjectConfig(int_19 >> 14 & 0x7FFF).anInt459 / 2;
            }

            final int int_20 = int_5 + 2 & 0x3;
            Object object_3;
            if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds
                == null) {
              object_2 = objectcomposition_0
                  .method824(4, int_5 + 4, ints_0, int_14, int_13, int_15);
              object_3 = objectcomposition_0
                  .method824(4, int_20 + 4, ints_0, int_14, int_13, int_15);
            } else {
              object_2 = new DynamicObject(int_4, 4, int_5 + 4, int_1, int_2, int_3,
                  objectcomposition_0.animationId, true, null);
              object_3 = new DynamicObject(int_4, 4, int_20 + 4, int_1, int_2, int_3,
                  objectcomposition_0.animationId, true, null);
            }

            region_0.addBoundaryDecoration(int_0, int_2, int_3, int_13, (Renderable) object_2,
                (Renderable) object_3, 256, int_5, int_18 * Class22.anIntArray10[int_5],
                int_18 * Class22.anIntArray11[int_5], int_16, int_17);
          }
        }
      }
    } else {
      if (objectcomposition_0.animationId == -1 && objectcomposition_0.impostorIds == null) {
        object_0 = objectcomposition_0.method824(10, int_5, ints_0, int_14, int_13, int_15);
      } else {
        object_0 = new DynamicObject(int_4, 10, int_5, int_1, int_2, int_3,
            objectcomposition_0.animationId,
            true, null);
      }

      if (object_0 != null) {
        region_0.method382(int_0, int_2, int_3, int_13, int_7, int_8, (Renderable) object_0,
            int_6 == 11 ? 256 : 0, int_16, int_17);
      }

      if (objectcomposition_0.interactType != 0) {
        collisiondata_0.addObject(int_2, int_3, int_7, int_8, objectcomposition_0.aBool55);
      }

    }
  }

  int method302(final Class44 class44_0, final Class44 class44_1) {
    return class44_0.aGrandExchangeOffer1.price < class44_1.aGrandExchangeOffer1.price ? -1
        : class44_1.aGrandExchangeOffer1.price == class44_0.aGrandExchangeOffer1.price ? 0 : 1;
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method302((Class44) object_0, (Class44) object_1);
  }

}
