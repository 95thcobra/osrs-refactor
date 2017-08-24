package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.map.MapAsset;
import jagex.oldschool.util.GzipDecompressor;
import java.awt.Image;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class Class7 {

  public static Image anImage1;
  final HashMap aHashMap7;
  boolean aBool3;
  DirectSprite aSpritePixels2;
  boolean aBool4;
  HashMap aHashMap5;
  Class1[][] aClass1ArrayArray1;
  int anInt36;
  int anInt37;
  HashMap aHashMap6;
  IndexedSprite[] anIndexedSpriteArray2;
  WorldMapData_Sub1 aWorldMapData_Sub1_1;
  int anInt38;
  int anInt39;

  public Class7(final IndexedSprite[] indexedsprites_0, final HashMap hashmap_0) {
    aBool4 = false;
    aBool3 = false;
    aHashMap6 = new HashMap();
    anIndexedSpriteArray2 = indexedsprites_0;
    aHashMap7 = hashmap_0;
  }

  public static void method143(final int int_0, final boolean bool_0, final int int_1) {
    if (int_0 >= 8000 && int_0 <= 48000) {
      AbstractSourceLine.sampleRate = int_0;
      Class56.stereo = bool_0;
      AbstractSourceLine.priority = int_1;
    } else {
      throw new IllegalArgumentException();
    }
  }

  static void loadTerrain(final Buffer buffer_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5) {
    int int_6;
    if (int_1 >= 0 && int_1 < 104 && int_2 >= 0 && int_2 < 104) {
      Class22.flags[int_0][int_1][int_2] = 0;

      while (true) {
        int_6 = buffer_0.getUnsignedByte();
        if (int_6 == 0) {
          if (int_0 == 0) {
            Class22.heightmap[0][int_1][int_2] =
                -GzipDecompressor.method569(int_1 + int_3 + 932731,
                    int_2 + int_4 + 556238) * 8;
            return;
          }
          Class22.heightmap[int_0][int_1][int_2] =
              Class22.heightmap[int_0 - 1][int_1][int_2] - 240;
          return;
        }

        if (int_6 == 1) {
          int int_7 = buffer_0.getUnsignedByte();
          if (int_7 == 1) {
            int_7 = 0;
          }

          if (int_0 == 0) {
            Class22.heightmap[0][int_1][int_2] = -int_7 * 8;
            return;
          }

          Class22.heightmap[int_0][int_1][int_2] = Class22.heightmap[int_0 - 1][int_1][int_2]
              - int_7 * 8;
          return;
        }

        if (int_6 <= 49) {
          Class22.overlayIds[int_0][int_1][int_2] = buffer_0.getByte();
          Class22.overlayPaths[int_0][int_1][int_2] = (byte) ((int_6 - 2) / 4);
          Class22.overlayRotations[int_0][int_1][int_2] = (byte) (int_6 - 2 + int_5 & 0x3);
        } else if (int_6 <= 81) {
          Class22.flags[int_0][int_1][int_2] = (byte) (int_6 - 49);
        } else {
          Class22.underlayIds[int_0][int_1][int_2] = (byte) (int_6 - 81);
        }
      }
    }
    while (true) {
      int_6 = buffer_0.getUnsignedByte();
      if (int_6 == 0) {
        return;
      }

      if (int_6 == 1) {
        buffer_0.getUnsignedByte();
        return;
      }

      if (int_6 <= 49) {
        buffer_0.getUnsignedByte();
      }
    }
  }

  void method131() {
    if (aHashMap5 == null) {
      aHashMap5 = new HashMap();
    }

    aHashMap5.clear();

    for (int int_0 = 0; int_0 < aClass1ArrayArray1.length; int_0++) {
      for (int int_1 = 0; int_1 < aClass1ArrayArray1[int_0].length; int_1++) {
        final List list_0 = aClass1ArrayArray1[int_0][int_1].method102();
        final Iterator iterator_0 = list_0.iterator();

        while (iterator_0.hasNext()) {
          final Class16 class16_0 = (Class16) iterator_0.next();
          if (!aHashMap5.containsKey(Integer.valueOf(class16_0.anInt64))) {
            final LinkedList linkedlist_0 = new LinkedList();
            linkedlist_0.add(class16_0);
            aHashMap5.put(Integer.valueOf(class16_0.anInt64), linkedlist_0);
          } else {
            final List list_1 = (List) aHashMap5.get(Integer.valueOf(class16_0.anInt64));
            list_1.add(class16_0);
          }
        }
      }
    }

  }

  Class10 method132(final int int_0, final int int_1, final int int_2, final int int_3) {
    final Class10 class10_0 = new Class10(this);
    final int int_4 = anInt36 + int_0;
    final int int_5 = int_1 + anInt37;
    final int int_6 = int_2 + anInt36;
    final int int_7 = int_3 + anInt37;
    final int int_8 = int_4 / 64;
    final int int_9 = int_5 / 64;
    final int int_10 = int_6 / 64;
    final int int_11 = int_7 / 64;
    class10_0.anInt52 = int_10 - int_8 + 1;
    class10_0.anInt54 = int_11 - int_9 + 1;
    class10_0.anInt51 = int_8 - aWorldMapData_Sub1_1.method311();
    class10_0.anInt53 = int_9 - aWorldMapData_Sub1_1.method312();
    if (class10_0.anInt51 < 0) {
      class10_0.anInt52 += class10_0.anInt51;
      class10_0.anInt51 = 0;
    }

    if (class10_0.anInt51 > aClass1ArrayArray1.length - class10_0.anInt52) {
      class10_0.anInt52 = aClass1ArrayArray1.length - class10_0.anInt51;
    }

    if (class10_0.anInt53 < 0) {
      class10_0.anInt54 += class10_0.anInt53;
      class10_0.anInt53 = 0;
    }

    if (class10_0.anInt53 > aClass1ArrayArray1[0].length - class10_0.anInt54) {
      class10_0.anInt54 = aClass1ArrayArray1[0].length - class10_0.anInt53;
    }

    class10_0.anInt52 = Math.min(class10_0.anInt52, aClass1ArrayArray1.length);
    class10_0.anInt54 = Math.min(class10_0.anInt54, aClass1ArrayArray1[0].length);
    return class10_0;
  }

  float method133(final int int_0, final int int_1) {
    final float float_0 = (float) int_0 / (float) int_1;
    if (float_0 > 8.0F) {
      return 8.0F;
    }
    if (float_0 < 1.0F) {
      return 1.0F;
    }
    final int int_2 = Math.round(float_0);
    return Math.abs(int_2 - float_0) < 0.05F ? (float) int_2 : float_0;
  }

  public boolean method134() {
    return aBool4;
  }

  public HashMap method135() {
    method131();
    return aHashMap5;
  }

  public void method136(final int int_0, final int int_1, final int int_2, final int int_3,
      final HashSet hashset_0,
      final int int_4, final int int_5) {
    if (aSpritePixels2 != null) {
      aSpritePixels2.method940(int_0, int_1, int_2, int_3);
      if (int_4 > 0) {
        if (int_4 % int_5 < int_5 / 2) {
          if (aHashMap5 == null) {
            method131();
          }

          final Iterator iterator_0 = hashset_0.iterator();

          while (true) {
            List list_0;
            do {
              if (!iterator_0.hasNext()) {
                return;
              }

              final int int_6 = ((Integer) iterator_0.next()).intValue();
              list_0 = (List) aHashMap5.get(Integer.valueOf(int_6));
            } while (list_0 == null);

            final Iterator iterator_1 = list_0.iterator();

            while (iterator_1.hasNext()) {
              final Class16 class16_0 = (Class16) iterator_1.next();
              final int int_7 = int_2 * (class16_0.aCoordinates5.x - anInt36) / anInt38;
              final int int_8 =
                  int_3 - (class16_0.aCoordinates5.z - anInt37) * int_3 / anInt39;
              Rasterizer2d.method883(int_7 + int_0, int_8 + int_1, 2, 16776960, 256);
            }
          }
        }
      }
    }
  }

  public void method137(final AbstractPackage indexdatabase_0, final String string_0,
      final boolean bool_0) {
    if (!aBool3) {
      aBool4 = false;
      aBool3 = true;
      System.nanoTime();
      final int int_0 = indexdatabase_0.getFile(MapAsset.aClass6_1.aString2);
      final int int_1 = indexdatabase_0.getChild(int_0, string_0);
      final Buffer buffer_0 = new Buffer(
          indexdatabase_0.method457(MapAsset.aClass6_1.aString2, string_0));
      final Buffer buffer_1 = new Buffer(
          indexdatabase_0.method457(MapAsset.aClass6_2.aString2, string_0));
      final Buffer buffer_2 = new Buffer(
          indexdatabase_0.method457(string_0, MapAsset.aClass6_3.aString2));
      System.nanoTime();
      System.nanoTime();
      aWorldMapData_Sub1_1 = new WorldMapData_Sub1();

      try {
        aWorldMapData_Sub1_1.method598(buffer_0, buffer_2, buffer_1, int_1, bool_0);
      } catch (final IllegalStateException illegalstateexception_0) {
        return;
      }

      aWorldMapData_Sub1_1.method316();
      aWorldMapData_Sub1_1.method315();
      aWorldMapData_Sub1_1.method317();
      anInt36 = aWorldMapData_Sub1_1.method311() * 64;
      anInt37 = aWorldMapData_Sub1_1.method312() * 64;
      anInt38 = (aWorldMapData_Sub1_1.method322() - aWorldMapData_Sub1_1.method311() + 1) * 64;
      anInt39 = (aWorldMapData_Sub1_1.method323() - aWorldMapData_Sub1_1.method312() + 1) * 64;
      final int int_2 = aWorldMapData_Sub1_1.method322() - aWorldMapData_Sub1_1.method311() + 1;
      final int int_3 = aWorldMapData_Sub1_1.method323() - aWorldMapData_Sub1_1.method312() + 1;
      System.nanoTime();
      System.nanoTime();
      aClass1ArrayArray1 = new Class1[int_2][int_3];
      final Iterator iterator_0 = aWorldMapData_Sub1_1.aHashSet7.iterator();

      while (iterator_0.hasNext()) {
        final AClass1_Sub2 aclass1_sub2_0 = (AClass1_Sub2) iterator_0.next();
        final int int_4 = aclass1_sub2_0.x;
        final int int_5 = aclass1_sub2_0.z;
        final int int_6 = int_4 - aWorldMapData_Sub1_1.method311();
        final int int_7 = int_5 - aWorldMapData_Sub1_1.method312();
        aClass1ArrayArray1[int_6][int_7] = new Class1(int_4, int_5,
            aWorldMapData_Sub1_1.method324(),
            aHashMap7);
        aClass1ArrayArray1[int_6][int_7].method114(aclass1_sub2_0, aWorldMapData_Sub1_1.aList4);
      }

      for (int int_8 = 0; int_8 < int_2; int_8++) {
        for (int int_9 = 0; int_9 < int_3; int_9++) {
          if (aClass1ArrayArray1[int_8][int_9] == null) {
            aClass1ArrayArray1[int_8][int_9] = new Class1(aWorldMapData_Sub1_1.method311() + int_8,
                aWorldMapData_Sub1_1.method312() + int_9, aWorldMapData_Sub1_1.method324(),
                aHashMap7);
            aClass1ArrayArray1[int_8][int_9].method115(aWorldMapData_Sub1_1.aHashSet8,
                aWorldMapData_Sub1_1.aList4);
          }
        }
      }

      System.nanoTime();
      System.nanoTime();
      if (indexdatabase_0.method454(MapAsset.aClass6_4.aString2, string_0)) {
        final byte[] bytes_0 = indexdatabase_0.method457(MapAsset.aClass6_4.aString2, string_0);
        aSpritePixels2 = ClientScriptVariable.method527(bytes_0);
      }

      System.nanoTime();
      aBool4 = true;
    }
  }

  public List method138(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7, final int int_8, final int int_9) {
    final LinkedList linkedlist_0 = new LinkedList();
    if (!aBool4) {
      return linkedlist_0;
    }
    final Class10 class10_0 = method132(int_0, int_1, int_2, int_3);
    final float float_0 = method133(int_6, int_2 - int_0);
    final int int_10 = (int) (64.0F * float_0);
    final int int_11 = anInt36 + int_0;
    final int int_12 = int_1 + anInt37;

    for (int int_13 = class10_0.anInt51; int_13 < class10_0.anInt52 + class10_0.anInt51;
        int_13++) {
      for (int int_14 = class10_0.anInt53; int_14 < class10_0.anInt54 + class10_0.anInt53;
          int_14++) {
        final List list_0 = aClass1ArrayArray1[int_13][int_14].method110(
            int_4 + int_10 * (aClass1ArrayArray1[int_13][int_14].chunkX * 64 - int_11) / 64,
            int_7 + int_5
                - int_10 * (64 + aClass1ArrayArray1[int_13][int_14].chunkY * 64 - int_12)
                / 64,
            int_10, int_8, int_9);
        if (!list_0.isEmpty()) {
          linkedlist_0.addAll(list_0);
        }
      }
    }

    return linkedlist_0;
  }

  public final void method139() {
    aHashMap5 = null;
  }

  void method140(final int int_0, final int int_1, final Class1[] class1s_0) {
    final boolean bool_0 = int_0 <= 0;
    final boolean bool_1 = int_0 >= aClass1ArrayArray1.length - 1;
    final boolean bool_2 = int_1 <= 0;
    final boolean bool_3 = int_1 >= aClass1ArrayArray1[0].length - 1;
    if (bool_3) {
      class1s_0[Enum5.anEnum5_1.mappedOrdinal()] = null;
    } else {
      class1s_0[Enum5.anEnum5_1.mappedOrdinal()] = aClass1ArrayArray1[int_0][int_1 + 1];
    }

    class1s_0[Enum5.anEnum5_2.mappedOrdinal()] =
        !bool_3 && !bool_1 ? aClass1ArrayArray1[int_0 + 1][int_1 + 1] : null;
    class1s_0[Enum5.anEnum5_8.mappedOrdinal()] =
        !bool_3 && !bool_0 ? aClass1ArrayArray1[int_0 - 1][int_1 + 1] : null;
    class1s_0[Enum5.anEnum5_3.mappedOrdinal()] = bool_1 ? null : aClass1ArrayArray1[int_0 + 1][int_1];
    class1s_0[Enum5.anEnum5_7.mappedOrdinal()] = bool_0 ? null : aClass1ArrayArray1[int_0 - 1][int_1];
    class1s_0[Enum5.anEnum5_5.mappedOrdinal()] = bool_2 ? null : aClass1ArrayArray1[int_0][int_1 - 1];
    class1s_0[Enum5.anEnum5_4.mappedOrdinal()] =
        !bool_2 && !bool_1 ? aClass1ArrayArray1[int_0 + 1][int_1 - 1] : null;
    class1s_0[Enum5.anEnum5_6.mappedOrdinal()] =
        !bool_2 && !bool_0 ? aClass1ArrayArray1[int_0 - 1][int_1 - 1] : null;
  }

  public final void method141(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7) {
    final int[] ints_0 = Rasterizer2d.targetBuffer;
    final int int_8 = Rasterizer2d.targetWidth;
    final int int_9 = Rasterizer2d.targetHeight;
    final int[] ints_1 = new int[4];
    Rasterizer2d.getClip(ints_1);
    final Class10 class10_0 = method132(int_0, int_1, int_2, int_3);
    final float float_0 = method133(int_6 - int_4, int_2 - int_0);
    final int int_10 = (int) Math.ceil(float_0);
    if (!aHashMap6.containsKey(Integer.valueOf(int_10))) {
      final Class14 class14_0 = new Class14(int_10);
      class14_0.method189();
      aHashMap6.put(Integer.valueOf(int_10), class14_0);
    }

    final Class1[] class1s_0 = new Class1[8];

    int int_11;
    int int_12;
    for (int_11 = class10_0.anInt51; int_11 < class10_0.anInt52 + class10_0.anInt51; int_11++) {
      for (int_12 = class10_0.anInt53; int_12 < class10_0.anInt54 + class10_0.anInt53; int_12++) {
        method140(int_11, int_12, class1s_0);
        aClass1ArrayArray1[int_11][int_12]
            .method111(int_10, (Class14) aHashMap6.get(Integer.valueOf(int_10)),
                class1s_0, anIndexedSpriteArray2);
      }
    }

    Rasterizer2d.init(ints_0, int_8, int_9);
    Rasterizer2d.setClip(ints_1);
    int_11 = (int) (float_0 * 64.0F);
    int_12 = anInt36 + int_0;
    final int int_13 = int_1 + anInt37;

    for (int int_14 = class10_0.anInt51; int_14 < class10_0.anInt52 + class10_0.anInt51;
        int_14++) {
      for (int int_15 = class10_0.anInt53; int_15 < class10_0.anInt53 + class10_0.anInt54;
          int_15++) {
        aClass1ArrayArray1[int_14][int_15].method113(
            (aClass1ArrayArray1[int_14][int_15].chunkX * 64 - int_12) * int_11 / 64 + int_4,
            int_7 - int_11 * (aClass1ArrayArray1[int_14][int_15].chunkY * 64 - int_13 + 64)
                / 64,
            int_11);
      }
    }

  }

  public final void method142(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6, final int int_7, final HashSet hashset_0,
      final HashSet hashset_1,
      final int int_8, final int int_9, final boolean bool_0) {
    final Class10 class10_0 = method132(int_0, int_1, int_2, int_3);
    final float float_0 = method133(int_6 - int_4, int_2 - int_0);
    final int int_10 = (int) (float_0 * 64.0F);
    final int int_11 = anInt36 + int_0;
    final int int_12 = int_1 + anInt37;

    int int_13;
    int int_14;
    for (int_13 = class10_0.anInt51; int_13 < class10_0.anInt52 + class10_0.anInt51; int_13++) {
      for (int_14 = class10_0.anInt53; int_14 < class10_0.anInt54 + class10_0.anInt53; int_14++) {
        if (bool_0) {
          aClass1ArrayArray1[int_13][int_14].method105();
        }

        aClass1ArrayArray1[int_13][int_14].method109(
            int_4 + (aClass1ArrayArray1[int_13][int_14].chunkX * 64 - int_11) * int_10 / 64,
            int_7 - (aClass1ArrayArray1[int_13][int_14].chunkY * 64 - int_12 + 64) * int_10
                / 64,
            int_10, hashset_0);
      }
    }

    if (hashset_1 != null && int_8 > 0) {
      for (int_13 = class10_0.anInt51; int_13 < class10_0.anInt51 + class10_0.anInt52; int_13++) {
        for (int_14 = class10_0.anInt53; int_14 < class10_0.anInt54 + class10_0.anInt53;
            int_14++) {
          aClass1ArrayArray1[int_13][int_14].method107(hashset_1, int_8, int_9);
        }
      }
    }

  }

}
