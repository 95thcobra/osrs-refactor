package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.scene.Position;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Class1 {

  static final Position aCoordinates1;
  static int anInt14;
  static int anInt15;

  static {
    aCoordinates1 = new Position();
  }

  final HashMap aHashMap4;
  int[][] anIntArrayArray1;
  List aList2;
  DirectSprite aSpritePixels1;
  LinkedList aLinkedList1;
  HashMap aHashMap3;
  AClass1_Sub2 anAClass1_Sub2_1;
  int anInt16;
  int anInt17;
  int anInt18;
  int anInt19;

  Class1(final int int_0, final int int_1, final int int_2, final HashMap hashmap_0) {
    anInt16 = int_0;
    anInt19 = int_1;
    aLinkedList1 = new LinkedList();
    aList2 = new LinkedList();
    aHashMap3 = new HashMap();
    anInt18 = int_2 | 0xFF000000;
    aHashMap4 = hashmap_0;
  }

  public static void method116(final AbstractPackage indexdatabase_0) {
    FloorUnderlayDefinition.underlay_ref = indexdatabase_0;
  }

  public static void addChatMessage(final int int_0, final String string_0, final String string_1,
      final String string_2) {
    ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class36.chatLineMap
        .get(Integer.valueOf(int_0));
    if (chatlinebuffer_0 == null) {
      chatlinebuffer_0 = new ChatLineBuffer();
      Class36.chatLineMap.put(Integer.valueOf(int_0), chatlinebuffer_0);
    }

    final MessageNode messagenode_0 = chatlinebuffer_0
        .addMessage(int_0, string_0, string_1, string_2);
    Class36.anIterableHashTable1.put(messagenode_0, messagenode_0.id);
    Class36.aClass76_1.add(messagenode_0);
    Client.chatCycle = Client.cycleCntr;
  }

  static String method117(final int int_0, final int int_1) {
    final int int_2 = int_1 - int_0;
    return int_2 < -9 ? Square.getColTags(16711680)
        : int_2 < -6 ? Square.getColTags(16723968)
            : int_2 < -3 ? Square.getColTags(16740352)
                : int_2 < 0 ? Square.getColTags(16756736)
                    : int_2 > 9 ? Square.getColTags(65280)
                        : int_2 > 6 ? Square.getColTags(4259584)
                            : int_2 > 3 ? Square.getColTags(8453888)
                                : int_2 > 0 ? Square.getColTags(12648192)
                                    : Square.getColTags(16776960);
  }

  boolean method76(final int int_0) {
    if (aSpritePixels1 != null && anInt17 == int_0) {
      return false;
    }
    anInt17 = int_0;
    aSpritePixels1 = new DirectSprite(anInt17 * 64, anInt17 * 64);
    return true;
  }

  void method77(final int int_0, final int int_1, final AClass1 aclass1_0) {
    for (int int_2 = 0; int_2 < aclass1_0.anInt42; int_2++) {
      final Class13[] class13s_0 = aclass1_0.aClass13ArrayArrayArrayArray1[int_2][int_0][int_1];
      if (class13s_0 != null && class13s_0.length != 0) {
        final Class13[] class13s_1 = class13s_0;

        for (int int_3 = 0; int_3 < class13s_1.length; int_3++) {
          final Class13 class13_0 = class13s_1[int_3];
          if (Node_Sub5.method677(class13_0.anInt59)) {
            final ObjectConfig objectcomposition_0 = Class2
                .getObjectDefinition(class13_0.anInt58);
            final int int_4 = objectcomposition_0.anInt454 != 0 ? -3407872 : -3355444;
            if (class13_0.anInt59 == Enum6.anEnum6_1.anInt364) {
              method108(int_0, int_1, class13_0.anInt60, int_4);
            }

            if (class13_0.anInt59 == Enum6.anEnum6_3.anInt364) {
              method108(int_0, int_1, class13_0.anInt60, -3355444);
              method108(int_0, int_1, class13_0.anInt60 + 1, int_4);
            }

            if (class13_0.anInt59 == Enum6.anEnum6_4.anInt364) {
              if (class13_0.anInt60 == 0) {
                Rasterizer2d.drawHorizontalLine(anInt17 * int_0, anInt17 * (63 - int_1), 1, int_4);
              }

              if (class13_0.anInt60 == 1) {
                Rasterizer2d.drawHorizontalLine(anInt17 + anInt17 * int_0 - 1, anInt17 * (63 - int_1), 1,
                    int_4);
              }

              if (class13_0.anInt60 == 2) {
                Rasterizer2d.drawHorizontalLine(anInt17 * int_0 + anInt17 - 1,
                    anInt17 + anInt17 * (63 - int_1) - 1, 1, int_4);
              }

              if (class13_0.anInt60 == 3) {
                Rasterizer2d.drawHorizontalLine(anInt17 * int_0, anInt17 + anInt17 * (63 - int_1) - 1, 1,
                    int_4);
              }
            }

            if (class13_0.anInt59 == Enum6.anEnum6_5.anInt364) {
              final int int_5 = class13_0.anInt60 % 2;
              int int_6;
              if (int_5 == 0) {
                for (int_6 = 0; int_6 < anInt17; int_6++) {
                  Rasterizer2d.drawHorizontalLine(int_6 + anInt17 * int_0,
                      (64 - int_1) * anInt17 - 1 - int_6, 1, int_4);
                }
              } else {
                for (int_6 = 0; int_6 < anInt17; int_6++) {
                  Rasterizer2d
                      .drawHorizontalLine(int_6 + anInt17 * int_0, int_6 + anInt17 * (63 - int_1),
                          1, int_4);
                }
              }
            }
          }
        }
      }
    }

  }

  void method78(final int int_0, final int int_1, final HashSet hashset_0, final int int_2) {
    final float float_0 = int_2 / 64.0F;
    final float float_1 = float_0 / 2.0F;
    final Iterator iterator_0 = aHashMap3.entrySet().iterator();

    while (iterator_0.hasNext()) {
      final Entry map$entry_0 = (Entry) iterator_0.next();
      final Position coordinates_0 = (Position) map$entry_0.getKey();
      final int int_3 = (int) (coordinates_0.x * float_0 + int_0 - float_1);
      final int int_4 = (int) (int_1 + int_2 - float_0 * coordinates_0.z - float_1);
      final Class16 class16_0 = (Class16) map$entry_0.getValue();
      if (class16_0 != null) {
        class16_0.anInt65 = int_3;
        class16_0.anInt67 = int_4;
        final Area area_0 = Area.anAreaArray1[class16_0.anInt64];
        if (!hashset_0.contains(Integer.valueOf(area_0.method777()))) {
          method106(class16_0, int_3, int_4, float_0);
        }
      }
    }

  }

  Class4 method79(final Area area_0) {
    if (area_0.name != null && aHashMap4 != null && aHashMap4.get(Class41.aClass41_2)
        != null) {
      final Class41 class41_0 = Class41.method277(area_0.anInt436);
      if (class41_0 == null) {
        return null;
      }
      final BitmapFont font_0 = (BitmapFont) aHashMap4.get(class41_0);
      if (font_0 == null) {
        return null;
      }
      final int int_0 = font_0.method994(area_0.name, 1000000);
      final String[] strings_0 = new String[int_0];
      font_0.method990(area_0.name, null, strings_0);
      final int int_1 = strings_0.length * font_0.verticalSpace / 2;
      int int_2 = 0;
      final String[] strings_1 = strings_0;

      for (int int_3 = 0; int_3 < strings_1.length; int_3++) {
        final String string_0 = strings_1[int_3];
        final int int_4 = font_0.method989(string_0);
        if (int_4 > int_2) {
          int_2 = int_4;
        }
      }

      return new Class4(area_0.name, int_2, int_1, class41_0);
    }
    return null;
  }

  void method80(final int int_0, final int int_1, final AClass1 aclass1_0,
      final IndexedSprite[] indexedsprites_0) {
    for (int int_2 = 0; int_2 < aclass1_0.anInt42; int_2++) {
      final Class13[] class13s_0 = aclass1_0.aClass13ArrayArrayArrayArray1[int_2][int_0][int_1];
      if (class13s_0 != null && class13s_0.length != 0) {
        final Class13[] class13s_1 = class13s_0;

        for (int int_3 = 0; int_3 < class13s_1.length; int_3++) {
          final Class13 class13_0 = class13s_1[int_3];
          if (!Class13.method166(class13_0.anInt59)) {
            final int int_4 = class13_0.anInt59;
            final boolean bool_0 = int_4 == Enum6.anEnum6_23.anInt364;
            if (!bool_0) {
              continue;
            }
          }

          final ObjectConfig objectcomposition_0 = Class2
              .getObjectDefinition(class13_0.anInt58);
          if (objectcomposition_0.mapSceneId != -1) {
            if (objectcomposition_0.mapSceneId != 46 && objectcomposition_0.mapSceneId != 52) {
              indexedsprites_0[objectcomposition_0.mapSceneId].method934(anInt17 * int_0,
                  anInt17 * (63 - int_1), anInt17 * 2, anInt17 * 2);
            } else {
              indexedsprites_0[objectcomposition_0.mapSceneId].method934(anInt17 * int_0,
                  anInt17 * (63 - int_1), anInt17 * 2 + 1, 1 + anInt17 * 2);
            }
          }
        }
      }
    }

  }

  void method81(final Area area_0, final int int_0, final int int_1) {
    final DirectSprite spritepixels_0 = area_0.method774(false);
    if (spritepixels_0 != null) {
      final int int_2 = method84(spritepixels_0, area_0.anEnum7_4);
      final int int_3 = method94(spritepixels_0, area_0.anEnum8_4);
      spritepixels_0.method938(int_2 + int_0, int_1 + int_3);
    }

  }

  void method82(final int int_0, final int int_1, final AClass1 aclass1_0,
      final Class14 class14_0) {
    final int int_2 = aclass1_0.aShortArrayArrayArray1[0][int_0][int_1] - 1;
    final int int_3 = aclass1_0.aShortArrayArrayArray2[0][int_0][int_1] - 1;
    if (int_2 == -1 && int_3 == -1) {
      Rasterizer2d.fillRectangle(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, anInt17, anInt18);
    }

    int int_4 = 16711935;
    int int_6;
    if (int_3 != -1) {
      final int int_5 = anInt18;
      final Overlay overlay_0 = NpcConfig.method868(int_3);
      if (overlay_0 == null) {
        int_6 = int_5;
      } else if (overlay_0.otherRgbColor >= 0) {
        int_6 = overlay_0.otherRgbColor | 0xFF000000;
      } else if (overlay_0.texture >= 0) {
        final int int_7 = Friend
            .method521(Rasterizer3d.materials.getHsl(overlay_0.texture),
                96);
        int_6 = Rasterizer3d.HSL_TABLE[int_7] | 0xFF000000;
      } else if (overlay_0.color == 16711935) {
        int_6 = int_5;
      } else {
        final int int_8 = overlay_0.hue;
        int int_9 = overlay_0.saturation;
        final int int_10 = overlay_0.lightness;
        if (int_10 > 179) {
          int_9 /= 2;
        }

        if (int_10 > 192) {
          int_9 /= 2;
        }

        if (int_10 > 217) {
          int_9 /= 2;
        }

        if (int_10 > 243) {
          int_9 /= 2;
        }

        final int int_11 = (int_9 / 32 << 7) + int_10 / 2 + (int_8 / 4 << 10);
        final int int_12 = Friend.method521(int_11, 96);
        int_6 = Rasterizer3d.HSL_TABLE[int_12] | 0xFF000000;
      }

      int_4 = int_6;
    }

    if (int_3 > -1 && aclass1_0.aByteArrayArrayArray1[0][int_0][int_1] == 0) {
      Rasterizer2d.fillRectangle(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, anInt17, int_4);
    } else {
      int_6 = method96(int_0, int_1, aclass1_0);
      if (int_3 == -1) {
        Rasterizer2d.fillRectangle(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, anInt17, int_6);
      } else {
        class14_0.method187(anInt17 * int_0, anInt17 * (63 - int_1), int_6, int_4, anInt17, anInt17,
            aclass1_0.aByteArrayArrayArray1[0][int_0][int_1],
            aclass1_0.aByteArrayArrayArray2[0][int_0][int_1]);
      }
    }
  }

  void method83(final int int_0, final int int_1, final HashSet hashset_0, final int int_2) {
    final float float_0 = int_2 / 64.0F;
    final Iterator iterator_0 = aList2.iterator();

    while (iterator_0.hasNext()) {
      final Class16 class16_0 = (Class16) iterator_0.next();
      final int int_3 = class16_0.aCoordinates5.x % 64;
      final int int_4 = class16_0.aCoordinates5.z % 64;
      class16_0.anInt65 = (int) (float_0 * int_3 + int_0);
      class16_0.anInt67 = (int) (int_1 + (63 - int_4) * float_0);
      if (!hashset_0.contains(Integer.valueOf(class16_0.anInt64))) {
        method106(class16_0, class16_0.anInt65, class16_0.anInt67, float_0);
      }
    }

  }

  int method84(final DirectSprite spritepixels_0, final Enum7 enum7_0) {
    switch (enum7_0.anInt374) {
      case 1:
        return 0;
      case 2:
        return -spritepixels_0.width / 2;
      default:
        return -spritepixels_0.width;
    }
  }

  void method85(final Class16 class16_0, final Area area_0, final int int_0, final int int_1,
      final float float_0) {
    if (class16_0.aClass4_1 != null) {
      if (class16_0.aClass4_1.aClass41_1.method275(float_0)) {
        final BitmapFont font_0 = (BitmapFont) aHashMap4.get(class16_0.aClass4_1.aClass41_1);
        font_0.method995(class16_0.aClass4_1.aString1, int_0 - class16_0.aClass4_1.anInt33 / 2,
            int_1,
            class16_0.aClass4_1.anInt33, class16_0.aClass4_1.anInt34, 0xFF000000 | area_0.anInt435,
            0, 1, 0,
            font_0.verticalSpace / 2);
      }
    }
  }

  void method86(final int int_0, final int int_1, final AClass1 aclass1_0, final Class14 class14_0,
      final IndexedSprite[] indexedsprites_0) {
    method77(int_0, int_1, aclass1_0);
    method80(int_0, int_1, aclass1_0, indexedsprites_0);
  }

  int method87(final int int_0, final int int_1) {
    if (anAClass1_Sub2_1 != null) {
      return anAClass1_Sub2_1.method144(int_0, int_1);
    }
    if (!aLinkedList1.isEmpty()) {
      final Iterator iterator_0 = aLinkedList1.iterator();

      while (iterator_0.hasNext()) {
        final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
        if (aclass1_sub1_0.method590(int_0, int_1)) {
          return aclass1_sub1_0.method144(int_0, int_1);
        }
      }
    }

    return -1;
  }

  void method88(final HashSet hashset_0, final int int_0, final int int_1) {
    final Iterator iterator_0 = aList2.iterator();

    while (iterator_0.hasNext()) {
      final Class16 class16_0 = (Class16) iterator_0.next();
      final Area area_0 = Area.anAreaArray1[class16_0.anInt64];
      if (area_0 != null && hashset_0.contains(Integer.valueOf(area_0.method777()))) {
        method103(area_0, class16_0.anInt65, class16_0.anInt67, int_0, int_1);
      }
    }

  }

  void method89(final int int_0, final int int_1, final int int_2, final int int_3,
      final AClass1 aclass1_0) {
    for (int int_4 = int_0; int_4 < int_2 + int_0; int_4++) {
      label57:
      for (int int_5 = int_1; int_5 < int_1 + int_3; int_5++) {
        final Position coordinates_0 = new Position(0, int_4, int_5);

        for (int int_6 = 0; int_6 < aclass1_0.anInt42; int_6++) {
          final Class13[] class13s_0 = aclass1_0.aClass13ArrayArrayArrayArray1[int_6][int_4][int_5];
          if (class13s_0 != null && class13s_0.length != 0) {
            final Class13[] class13s_1 = class13s_0;

            for (int int_7 = 0; int_7 < class13s_1.length; int_7++) {
              final Class13 class13_0 = class13s_1[int_7];
              final Area area_0 = method98(class13_0.anInt58);
              if (area_0 != null) {
                final Position coordinates_1 = new Position(int_6, anInt16 * 64 + int_4,
                    int_5 + anInt19 * 64);
                Position coordinates_2 = null;
                if (anAClass1_Sub2_1 != null) {
                  coordinates_2 = new Position(anAClass1_Sub2_1.anInt43 + int_6,
                      int_4 + anAClass1_Sub2_1.anInt44 * 64,
                      int_5 + anAClass1_Sub2_1.anInt45 * 64);
                } else {
                  final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) aclass1_0;
                  coordinates_2 = new Position(int_6 + aclass1_sub1_0.anInt43,
                      int_4 + aclass1_sub1_0.anInt44 * 64 + aclass1_sub1_0.method593() * 8,
                      aclass1_sub1_0.anInt45 * 64 + int_5 + aclass1_sub1_0.method594() * 8);
                }

                final Class16 class16_0 = new Class16(area_0.anInt432, coordinates_2, coordinates_1,
                    method79(area_0));
                aHashMap3.put(coordinates_0, class16_0);
                continue label57;
              }
            }
          }
        }
      }
    }

  }

  void method90(final List list_0) {
    final Iterator iterator_0 = list_0.iterator();

    while (iterator_0.hasNext()) {
      final Class29 class29_0 = (Class29) iterator_0.next();
      if (class29_0.aCoordinates6.x >> 6 == anInt16
          && class29_0.aCoordinates6.z >> 6 == anInt19) {
        final Class16 class16_0 = new Class16(class29_0.anInt82, class29_0.aCoordinates6,
            class29_0.aCoordinates6, method104(class29_0.anInt82));
        aList2.add(class16_0);
      }
    }

  }

  boolean method91(final Class1[] class1s_0) {
    if (anIntArrayArray1 != null) {
      return false;
    }
    final Class8 class8_0 = new Class8(64, 64);
    if (anAClass1_Sub2_1 != null) {
      method95(0, 0, 64, 64, anAClass1_Sub2_1, class8_0);
    } else {
      final Iterator iterator_0 = aLinkedList1.iterator();

      while (iterator_0.hasNext()) {
        final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
        method95(aclass1_sub1_0.method589() * 8, aclass1_sub1_0.method591() * 8, 8, 8,
            aclass1_sub1_0,
            class8_0);
      }
    }

    method97(class1s_0, class8_0);
    method99(class8_0);
    return true;
  }

  void method92(final int int_0, final int int_1, final AClass1 aclass1_0) {
    aCoordinates1.method509(0, int_0, int_1);

    for (int int_2 = 0; int_2 < aclass1_0.anInt42; int_2++) {
      final Class13[] class13s_0 = aclass1_0.aClass13ArrayArrayArrayArray1[int_2][int_0][int_1];
      if (class13s_0 != null && class13s_0.length != 0) {
        final Class13[] class13s_1 = class13s_0;

        for (int int_3 = 0; int_3 < class13s_1.length; int_3++) {
          final Class13 class13_0 = class13s_1[int_3];
          final Area area_0 = method98(class13_0.anInt58);
          if (area_0 != null) {
            Class16 class16_0 = (Class16) aHashMap3.get(aCoordinates1);
            if (class16_0 != null) {
              if (class16_0.anInt64 != area_0.anInt432) {
                final Class16 class16_1 = new Class16(area_0.anInt432, class16_0.aCoordinates4,
                    class16_0.aCoordinates5, method79(area_0));
                aHashMap3.put(new Position(aCoordinates1), class16_1);
                class16_0 = class16_1;
              }

              final int int_4 = class16_0.aCoordinates4.plane - class16_0.aCoordinates5.plane;
              class16_0.aCoordinates5.plane = int_2;
              class16_0.aCoordinates4.plane = int_2 + int_4;
              return;
            }

            final Position coordinates_0 = new Position(int_2, anInt16 * 64 + int_0,
                anInt19 * 64 + int_1);
            Position coordinates_1 = null;
            if (anAClass1_Sub2_1 != null) {
              coordinates_1 = new Position(anAClass1_Sub2_1.anInt43 + int_2,
                  int_0 + anAClass1_Sub2_1.anInt44 * 64, int_1 + anAClass1_Sub2_1.anInt45 * 64);
            } else {
              final Iterator iterator_0 = aLinkedList1.iterator();

              while (iterator_0.hasNext()) {
                final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
                if (aclass1_sub1_0.method590(int_0, int_1)) {
                  coordinates_1 = new Position(int_2 + aclass1_sub1_0.anInt43,
                      aclass1_sub1_0.anInt44 * 64 + int_0 + aclass1_sub1_0.method593() * 8,
                      int_1 + aclass1_sub1_0.anInt45 * 64 + aclass1_sub1_0.method594() * 8);
                  break;
                }
              }
            }

            if (coordinates_1 != null) {
              class16_0 = new Class16(area_0.anInt432, coordinates_1, coordinates_0,
                  method79(area_0));
              aHashMap3.put(new Position(aCoordinates1), class16_0);
              return;
            }
          }
        }
      }
    }

    aHashMap3.remove(aCoordinates1);
  }

  void method93(final int int_0, final int int_1, final AClass1 aclass1_0,
      final Class14 class14_0) {
    for (int int_2 = 1; int_2 < aclass1_0.anInt42; int_2++) {
      final int int_3 = aclass1_0.aShortArrayArrayArray2[int_2][int_0][int_1] - 1;
      if (int_3 > -1) {
        final int int_4 = Class23.method211(int_3, anInt18);
        if (aclass1_0.aByteArrayArrayArray1[int_2][int_0][int_1] == 0) {
          Rasterizer2d.fillRectangle(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, anInt17, int_4);
        } else {
          class14_0.method187(anInt17 * int_0, anInt17 * (63 - int_1), 0, int_4, anInt17, anInt17,
              aclass1_0.aByteArrayArrayArray1[int_2][int_0][int_1],
              aclass1_0.aByteArrayArrayArray2[int_2][int_0][int_1]);
        }
      }
    }

  }

  int method94(final DirectSprite spritepixels_0, final Enum8 enum8_0) {
    switch (enum8_0.anInt376) {
      case 0:
        return -spritepixels_0.height / 2;
      case 1:
        return 0;
      default:
        return -spritepixels_0.height;
    }
  }

  void method95(final int int_0, final int int_1, final int int_2, final int int_3,
      final AClass1 aclass1_0,
      final Class8 class8_0) {
    for (int int_4 = int_0; int_4 < int_2 + int_0; int_4++) {
      for (int int_5 = int_1; int_5 < int_1 + int_3; int_5++) {
        final int int_6 = aclass1_0.aShortArrayArrayArray1[0][int_4][int_5] - 1;
        if (int_6 != -1) {
          final FloorUnderlayDefinition floorunderlaydefinition_0 = Class20.method204(int_6);
          class8_0.method152(int_4, int_5, 5, floorunderlaydefinition_0);
        }
      }
    }

  }

  int method96(final int int_0, final int int_1, final AClass1 aclass1_0) {
    return aclass1_0.aShortArrayArrayArray1[0][int_0][int_1] == 0 ? anInt18
        : anIntArrayArray1[int_0][int_1];
  }

  void method97(final Class1[] class1s_0, final Class8 class8_0) {
    final Enum5[] enum5s_0 = new Enum5[] {
        Enum5.anEnum5_7, Enum5.anEnum5_4, Enum5.anEnum5_2, Enum5.anEnum5_6,
        Enum5.anEnum5_8, Enum5.anEnum5_1, Enum5.anEnum5_5, Enum5.anEnum5_3
    };
    final Enum5[] enum5s_1 = enum5s_0;

    for (int int_0 = 0; int_0 < enum5s_1.length; int_0++) {
      final Enum5 enum5_0 = enum5s_1[int_0];
      if (class1s_0[enum5_0.mappedOrdinal()] != null) {
        byte byte_0 = 0;
        byte byte_1 = 0;
        byte byte_2 = 64;
        byte byte_3 = 64;
        byte byte_4 = 0;
        byte byte_5 = 0;
        switch (enum5_0.anInt360) {
          case 0:
            byte_0 = 59;
            byte_2 = 5;
            break;
          case 1:
            byte_5 = 59;
            byte_3 = 5;
            break;
          case 2:
            byte_1 = 59;
            byte_3 = 5;
            byte_0 = 59;
            byte_2 = 5;
            break;
          case 3:
            byte_1 = 59;
            byte_3 = 5;
            break;
          case 4:
            byte_1 = 59;
            byte_3 = 5;
            byte_4 = 59;
            byte_2 = 5;
            break;
          case 5:
            byte_4 = 59;
            byte_2 = 5;
            break;
          case 6:
            byte_5 = 59;
            byte_3 = 5;
            byte_0 = 59;
            byte_2 = 5;
            break;
          case 7:
            byte_4 = 59;
            byte_5 = 59;
            byte_2 = 5;
            byte_3 = 5;
        }

        method112(byte_4, byte_5, byte_0, byte_1, byte_2, byte_3, class1s_0[enum5_0.mappedOrdinal()],
            class8_0);
      }
    }

  }

  Area method98(final int int_0) {
    ObjectConfig objectcomposition_0 = Class2.getObjectDefinition(int_0);
    if (objectcomposition_0.impostorIds != null) {
      objectcomposition_0 = objectcomposition_0.getImpostor();
      if (objectcomposition_0 == null) {
        return null;
      }
    }

    return objectcomposition_0.mapIconId != -1 ? Area.anAreaArray1[objectcomposition_0.mapIconId]
        : null;
  }

  void method99(final Class8 class8_0) {
    anIntArrayArray1 = new int[64][64];

    for (int int_0 = 0; int_0 < 64; int_0++) {
      for (int int_1 = 0; int_1 < 64; int_1++) {
        anIntArrayArray1[int_0][int_1] = class8_0.method151(int_0, int_1) | 0xFF000000;
      }
    }

  }

  void method100(final Class14 class14_0, final Class1[] class1s_0,
      final IndexedSprite[] indexedsprites_0) {
    int int_0;
    int int_1;
    for (int_0 = 0; int_0 < 64; int_0++) {
      for (int_1 = 0; int_1 < 64; int_1++) {
        method82(int_0, int_1, anAClass1_Sub2_1, class14_0);
        method93(int_0, int_1, anAClass1_Sub2_1, class14_0);
      }
    }

    for (int_0 = 0; int_0 < 64; int_0++) {
      for (int_1 = 0; int_1 < 64; int_1++) {
        method86(int_0, int_1, anAClass1_Sub2_1, class14_0, indexedsprites_0);
      }
    }

  }

  void method101(final Class14 class14_0, final IndexedSprite[] indexedsprites_0) {
    Iterator iterator_0 = aLinkedList1.iterator();

    AClass1_Sub1 aclass1_sub1_0;
    int int_0;
    int int_1;
    while (iterator_0.hasNext()) {
      aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

      for (int_0 = aclass1_sub1_0.method589() * 8; int_0 < aclass1_sub1_0.method589() * 8 + 8;
          int_0++) {
        for (int_1 = aclass1_sub1_0.method591() * 8; int_1 < aclass1_sub1_0.method591() * 8 + 8;
            int_1++) {
          method82(int_0, int_1, aclass1_sub1_0, class14_0);
          method93(int_0, int_1, aclass1_sub1_0, class14_0);
        }
      }
    }

    iterator_0 = aLinkedList1.iterator();

    while (iterator_0.hasNext()) {
      aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

      for (int_0 = aclass1_sub1_0.method589() * 8; int_0 < aclass1_sub1_0.method589() * 8 + 8;
          int_0++) {
        for (int_1 = aclass1_sub1_0.method591() * 8; int_1 < aclass1_sub1_0.method591() * 8 + 8;
            int_1++) {
          method86(int_0, int_1, aclass1_sub1_0, class14_0, indexedsprites_0);
        }
      }
    }

  }

  List method102() {
    final LinkedList linkedlist_0 = new LinkedList();
    linkedlist_0.addAll(aList2);
    linkedlist_0.addAll(aHashMap3.values());
    return linkedlist_0;
  }

  void method103(final Area area_0, final int int_0, final int int_1, final int int_2,
      final int int_3) {
    final DirectSprite spritepixels_0 = area_0.method774(false);
    if (spritepixels_0 != null) {
      spritepixels_0
          .method938(int_0 - spritepixels_0.width / 2, int_1 - spritepixels_0.height / 2);
      if (int_2 % int_3 < int_3 / 2) {
        Rasterizer2d.method883(int_0, int_1, 15, 16776960, 128);
        Rasterizer2d.method883(int_0, int_1, 7, 16777215, 256);
      }

    }
  }

  Class4 method104(final int int_0) {
    final Area area_0 = Area.anAreaArray1[int_0];
    return method79(area_0);
  }

  void method105() {
    if (anAClass1_Sub2_1 != null) {
      for (int int_0 = 0; int_0 < 64; int_0++) {
        for (int int_1 = 0; int_1 < 64; int_1++) {
          method92(int_0, int_1, anAClass1_Sub2_1);
        }
      }

    } else {
      final Iterator iterator_0 = aLinkedList1.iterator();

      while (iterator_0.hasNext()) {
        final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();

        for (int int_2 = aclass1_sub1_0.method589() * 8; int_2 < aclass1_sub1_0.method589() * 8
            + 8; int_2++) {
          for (int int_3 = aclass1_sub1_0.method591() * 8; int_3 < aclass1_sub1_0.method591() * 8
              + 8; int_3++) {
            method92(int_2, int_3, aclass1_sub1_0);
          }
        }
      }

    }
  }

  void method106(final Class16 class16_0, final int int_0, final int int_1, final float float_0) {
    final Area area_0 = Area.anAreaArray1[class16_0.anInt64];
    method81(area_0, int_0, int_1);
    method85(class16_0, area_0, int_0, int_1, float_0);
  }

  void method107(final HashSet hashset_0, final int int_0, final int int_1) {
    final Iterator iterator_0 = aHashMap3.values().iterator();

    while (iterator_0.hasNext()) {
      final Class16 class16_0 = (Class16) iterator_0.next();
      if (hashset_0.contains(Integer.valueOf(class16_0.anInt64))) {
        final Area area_0 = Area.anAreaArray1[class16_0.anInt64];
        method103(area_0, class16_0.anInt65, class16_0.anInt67, int_0, int_1);
      }
    }

    method88(hashset_0, int_0, int_1);
  }

  void method108(final int int_0, final int int_1, int int_2, final int int_3) {
    int_2 %= 4;
    if (int_2 == 0) {
      Rasterizer2d.drawVerticalLine(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, int_3);
    }

    if (int_2 == 1) {
      Rasterizer2d.drawHorizontalLine(anInt17 * int_0, anInt17 * (63 - int_1), anInt17, int_3);
    }

    if (int_2 == 2) {
      Rasterizer2d
          .drawVerticalLine(anInt17 + anInt17 * int_0 - 1, anInt17 * (63 - int_1), anInt17, int_3);
    }

    if (int_2 == 3) {
      Rasterizer2d
          .drawHorizontalLine(anInt17 * int_0, anInt17 * (63 - int_1) + anInt17 - 1, anInt17, int_3);
    }

  }

  void method109(final int int_0, final int int_1, final int int_2, HashSet hashset_0) {
    if (hashset_0 == null) {
      hashset_0 = new HashSet();
    }

    method78(int_0, int_1, hashset_0, int_2);
    method83(int_0, int_1, hashset_0, int_2);
  }

  List method110(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    final LinkedList linkedlist_0 = new LinkedList();
    if (int_3 >= int_0 && int_4 >= int_1) {
      if (int_3 < int_2 + int_0 && int_4 < int_2 + int_1) {
        Iterator iterator_0 = aHashMap3.values().iterator();

        Class16 class16_0;
        while (iterator_0.hasNext()) {
          class16_0 = (Class16) iterator_0.next();
          if (class16_0.method195(int_3, int_4)) {
            linkedlist_0.add(class16_0);
          }
        }

        iterator_0 = aList2.iterator();

        while (iterator_0.hasNext()) {
          class16_0 = (Class16) iterator_0.next();
          if (class16_0.method195(int_3, int_4)) {
            linkedlist_0.add(class16_0);
          }
        }

        return linkedlist_0;
      }
      return linkedlist_0;
    }
    return linkedlist_0;
  }

  boolean method111(final int int_0, final Class14 class14_0, final Class1[] class1s_0,
      final IndexedSprite[] indexedsprites_0) {
    if (!method76(int_0)) {
      return false;
    }
    if (anAClass1_Sub2_1 == null && aLinkedList1.isEmpty()) {
      return false;
    }
    method91(class1s_0);
    aSpritePixels1.method943();
    if (anAClass1_Sub2_1 != null) {
      method100(class14_0, class1s_0, indexedsprites_0);
    } else {
      method101(class14_0, indexedsprites_0);
    }

    return true;
  }

  void method112(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4, final int int_5,
      final Class1 class1_1, final Class8 class8_0) {
    for (int int_6 = 0; int_6 < int_4; int_6++) {
      for (int int_7 = 0; int_7 < int_5; int_7++) {
        final int int_8 = class1_1.method87(int_6 + int_0, int_7 + int_1);
        if (int_8 != -1) {
          final FloorUnderlayDefinition floorunderlaydefinition_0 = Class20.method204(int_8);
          class8_0.method152(int_2 + int_6, int_7 + int_3, 5, floorunderlaydefinition_0);
        }
      }
    }

  }

  void method113(final int int_0, final int int_1, final int int_2) {
    if (aSpritePixels1 != null) {
      if (anInt17 * 64 == int_2) {
        aSpritePixels1.method942(int_0, int_1);
      } else {
        aSpritePixels1.method941(int_0, int_1, int_2, int_2);
      }
    }
  }

  void method114(final AClass1_Sub2 aclass1_sub2_0, final List list_0) {
    aHashMap3.clear();
    anAClass1_Sub2_1 = aclass1_sub2_0;
    method89(0, 0, 64, 64, anAClass1_Sub2_1);
    method90(list_0);
  }

  void method115(final HashSet hashset_0, final List list_0) {
    aHashMap3.clear();
    final Iterator iterator_0 = hashset_0.iterator();

    while (iterator_0.hasNext()) {
      final AClass1_Sub1 aclass1_sub1_0 = (AClass1_Sub1) iterator_0.next();
      if (aclass1_sub1_0.method147() == anInt16 && aclass1_sub1_0.method148() == anInt19) {
        aLinkedList1.add(aclass1_sub1_0);
        method89(aclass1_sub1_0.method589() * 8, aclass1_sub1_0.method591() * 8, 8, 8,
            aclass1_sub1_0);
      }
    }

    method90(list_0);
  }

}
