package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.map.MapAsset;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.ScriptCall;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RenderOverview {

  static final FontType aClass105_1;
  static final FontType aClass105_2;
  static final FontType aClass105_3;

  static {
    aClass105_1 = FontType.aClass105_4;
    aClass105_2 = FontType.aClass105_6;
    aClass105_3 = FontType.aClass105_7;
  }

  final int[] anIntArray1;
  IndexedSprite[] anIndexedSpriteArray1;
  boolean aBool1;
  HashSet aHashSet1;
  int anInt1;
  int anInt2;
  int anInt3;
  int anInt4;
  HashSet aHashSet2;
  boolean aBool2;
  int anInt5;
  AbstractPackage anIndexDataBase1;
  HashSet aHashSet3;
  HashMap aHashMap1;
  HashSet aHashSet4;
  Class109 aClass109_1;
  Iterator anIterator1;
  int anInt6;
  float aFloat1;
  float aFloat2;
  WorldMapData aWorldMapData1;
  WorldMapData aWorldMapData2;
  int anInt7;
  int anInt8;
  int anInt9;
  int anInt10;
  HashMap aHashMap2;
  int anInt11;
  WorldMapData aWorldMapData3;
  BitmapFont aFont1;
  Class7 aClass7_1;
  int anInt12;
  HashSet aHashSet5;
  List aList1;
  HashSet aHashSet6;
  int anInt13;

  public RenderOverview() {
    anInt6 = -1;
    anInt8 = -1;
    anInt2 = -1;
    anInt3 = -1;
    anInt1 = 3;
    anInt5 = 50;
    aBool1 = false;
    aHashSet4 = null;
    anInt11 = -1;
    anInt12 = -1;
    anInt4 = -1;
    anInt7 = -1;
    aHashSet2 = new HashSet();
    aHashSet1 = new HashSet();
    aHashSet5 = new HashSet();
    aHashSet3 = new HashSet();
    aBool2 = false;
    anInt13 = 0;
    anIntArray1 = new int[] {1008, 1009, 1010, 1011, 1012};
    aHashSet6 = new HashSet();
  }

  boolean method14() {
    return anInt6 != -1 && anInt8 != -1;
  }

  public WorldMapData method15(final int int_0, final int int_1, final int int_2) {
    final Iterator iterator_0 = aHashMap1.values().iterator();

    WorldMapData worldmapdata_0;
    do {
      if (!iterator_0.hasNext()) {
        return null;
      }

      worldmapdata_0 = (WorldMapData) iterator_0.next();
    } while (!worldmapdata_0.method313(int_0, int_1, int_2));

    return worldmapdata_0;
  }

  float method16(final int int_0) {
    return int_0 == 25 ? 1.0F
        : int_0 == 37 ? 1.5F
            : int_0 == 50 ? 2.0F : int_0 == 75 ? 3.0F : int_0 == 100 ? 4.0F : 8.0F;
  }

  public WorldMapData method17(final int int_0) {
    final Iterator iterator_0 = aHashMap1.values().iterator();

    WorldMapData worldmapdata_0;
    do {
      if (!iterator_0.hasNext()) {
        return null;
      }

      worldmapdata_0 = (WorldMapData) iterator_0.next();
    } while (worldmapdata_0.method309() != int_0);

    return worldmapdata_0;
  }

  void method18(final WorldMapData worldmapdata_0) {
    aWorldMapData1 = worldmapdata_0;
    aClass7_1 = new Class7(anIndexedSpriteArray1, aHashMap2);
    aClass109_1.method532(aWorldMapData1.method307());
  }

  public int method19() {
    return aWorldMapData1 == null ? -1 : anInt10 + aWorldMapData1.method311() * 64;
  }

  void method20(final WorldMapData worldmapdata_0) {
    if (aWorldMapData1 == null || worldmapdata_0 != aWorldMapData1) {
      method18(worldmapdata_0);
      method23(-1, -1, -1);
    }
  }

  void method21() {
    if (aFloat2 < aFloat1) {
      aFloat2 = Math.min(aFloat1, aFloat2 + aFloat2 / 30.0F);
    }

    if (aFloat2 > aFloat1) {
      aFloat2 = Math.max(aFloat1, aFloat2 - aFloat2 / 30.0F);
    }

  }

  void method22() {
    aHashSet3.clear();
    aHashSet3.addAll(aHashSet2);
    aHashSet3.addAll(aHashSet5);
  }

  void method23(final int int_0, final int int_1, final int int_2) {
    if (aWorldMapData1 != null) {
      int[] ints_0 = aWorldMapData1.method310(int_0, int_1, int_2);
      if (ints_0 == null) {
        ints_0 = aWorldMapData1.method310(aWorldMapData1.method315(), aWorldMapData1.method316(),
            aWorldMapData1.method317());
      }

      anInt10 = ints_0[0] - aWorldMapData1.method311() * 64;
      anInt9 = ints_0[1] - aWorldMapData1.method312() * 64;
      anInt6 = -1;
      anInt8 = -1;
      aFloat2 = method16(aWorldMapData1.method318());
      aFloat1 = aFloat2;
      aList1 = null;
      anIterator1 = null;
      aClass7_1.method139();
    }
  }

  public int method24() {
    return aWorldMapData1 == null ? -1 : anInt9 + aWorldMapData1.method312() * 64;
  }

  void method25() {
    if (method14()) {
      int int_0 = anInt6 - anInt10;
      int int_1 = anInt8 - anInt9;
      if (int_0 != 0) {
        int_0 /= Math.min(8, Math.abs(int_0));
      }

      if (int_1 != 0) {
        int_1 /= Math.min(8, Math.abs(int_1));
      }

      anInt10 += int_0;
      anInt9 += int_1;
      if (anInt6 == anInt10 && anInt9 == anInt8) {
        anInt6 = -1;
        anInt8 = -1;
      }

    }
  }

  public void method26(final int int_0, final int int_1) {
    if (aWorldMapData1 != null) {
      if (aWorldMapData1.method308(int_0, int_1)) {
        anInt6 = int_0 - aWorldMapData1.method311() * 64;
        anInt8 = int_1 - aWorldMapData1.method312() * 64;
      }
    }
  }

  public void method27(final int int_0, final int int_1) {
    if (aWorldMapData1 != null) {
      anInt10 = int_0 - aWorldMapData1.method311() * 64;
      anInt9 = int_1 - aWorldMapData1.method312() * 64;
      anInt6 = -1;
      anInt8 = -1;
    }
  }

  public Class16 method28() {
    return anIterator1 == null ? null
        : !anIterator1.hasNext() ? null : (Class16) anIterator1.next();
  }

  void method29(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    final byte byte_0 = 20;
    final int int_5 = int_2 / 2 + int_0;
    final int int_6 = (int_3 / 2 + int_1) - 18 - byte_0;
    Rasterizer2d.fillRectangle(int_0, int_1, int_2, int_3, -16777216);
    Rasterizer2d.drawRectangle(int_5 - 152, int_6, 304, 34, -65536);
    Rasterizer2d.fillRectangle(int_5 - 150, int_6 + 2, int_4 * 3, 30, -65536);
    aFont1.method998("Loading...", int_5, int_6 + byte_0, -1, -1);
  }

  public int method30() {
    return anIndexDataBase1.method451(aWorldMapData2.method307(), MapAsset.aClass6_3.aString2) ? 100
        : anIndexDataBase1.method456(aWorldMapData2.method307());
  }

  public void method31(final AbstractPackage indexdatabase_0, final BitmapFont font_0,
      final HashMap hashmap_0,
      final IndexedSprite[] indexedsprites_0) {
    anIndexedSpriteArray1 = indexedsprites_0;
    anIndexDataBase1 = indexdatabase_0;
    aFont1 = font_0;
    aHashMap2 = new HashMap();
    aHashMap2.put(Class41.aClass41_2, hashmap_0.get(aClass105_1));
    aHashMap2.put(Class41.aClass41_3, hashmap_0.get(aClass105_2));
    aHashMap2.put(Class41.aClass41_4, hashmap_0.get(aClass105_3));
    aClass109_1 = new Class109(indexdatabase_0);
    final int int_0 = anIndexDataBase1.getFile(MapAsset.aClass6_1.aString2);
    final int[] ints_0 = anIndexDataBase1.getChilds(int_0);
    aHashMap1 = new HashMap(ints_0.length);

    for (int int_1 = 0; int_1 < ints_0.length; int_1++) {
      final Buffer buffer_0 = new Buffer(anIndexDataBase1.get(int_0, ints_0[int_1]));
      final WorldMapData worldmapdata_0 = new WorldMapData();
      worldmapdata_0.loadMapData(buffer_0, ints_0[int_1]);
      aHashMap1.put(worldmapdata_0.method307(), worldmapdata_0);
      if (worldmapdata_0.method321()) {
        aWorldMapData2 = worldmapdata_0;
      }
    }

    method20(aWorldMapData2);
    aWorldMapData3 = null;
  }

  public void extractWorldmap(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    final int[] ints_0 = new int[4];
    Rasterizer2d.getClip(ints_0);
    Rasterizer2d.setClip(int_0, int_1, int_2 + int_0, int_1 + int_3);
    Rasterizer2d.fillRectangle(int_0, int_1, int_2, int_3, -16777216);
    final int int_5 = aClass109_1.method533();
    if (int_5 < 100) {
      method29(int_0, int_1, int_2, int_3, int_5);
    } else {
      if (!aClass7_1.method134()) {
        aClass7_1.method137(anIndexDataBase1, aWorldMapData1.method307(), Client.isMembers);
        if (!aClass7_1.method134()) {
          return;
        }
      }

      if (aHashSet4 != null) {
        ++anInt12;
        if (anInt12 % anInt5 == 0) {
          anInt12 = 0;
          ++anInt11;
        }

        if (anInt11 >= anInt1 && !aBool1) {
          aHashSet4 = null;
        }
      }

      final int int_6 = (int) Math.ceil(int_2 / aFloat2);
      final int int_7 = (int) Math.ceil(int_3 / aFloat2);
      aClass7_1.method141(anInt10 - int_6 / 2, anInt9 - int_7 / 2, int_6 / 2 + anInt10,
          int_7 / 2 + anInt9, int_0, int_1, int_2 + int_0, int_1 + int_3);
      if (!aBool2) {
        boolean bool_0 = false;
        if (int_4 - anInt13 > 100) {
          anInt13 = int_4;
          bool_0 = true;
        }

        aClass7_1.method142(anInt10 - int_6 / 2, anInt9 - int_7 / 2, int_6 / 2 + anInt10,
            int_7 / 2 + anInt9, int_0, int_1, int_2 + int_0, int_1 + int_3, aHashSet3, aHashSet4,
            anInt12,
            anInt5, bool_0);
      }

      anInt2 = int_6;
      anInt3 = int_7;
      Rasterizer2d.setClip(ints_0);
    }
  }

  public void extractData(final int int_0, final int int_1, final int int_2, final int int_3) {
    if (aClass109_1.method531()) {
      if (!aClass7_1.method134()) {
        aClass7_1.method137(anIndexDataBase1, aWorldMapData1.method307(), Client.isMembers);
        if (!aClass7_1.method134()) {
          return;
        }
      }

      aClass7_1.method136(int_0, int_1, int_2, int_3, aHashSet4, anInt12, anInt5);
    }
  }

  public void method32(final int int_0, final int int_1, final Position coordinates_0,
      final Position coordinates_1) {
    final ScriptCall scriptevent_0 = new ScriptCall();
    final Boundry class9_0 = new Boundry(int_1, coordinates_0, coordinates_1);
    scriptevent_0.method705(new Object[] {class9_0});
    switch (int_0) {
      case 1008:
        scriptevent_0.method706(ScriptArguments.aClass83_1);
        break;
      case 1009:
        scriptevent_0.method706(ScriptArguments.aClass83_3);
        break;
      case 1010:
        scriptevent_0.method706(ScriptArguments.aClass83_5);
        break;
      case 1011:
        scriptevent_0.method706(ScriptArguments.aClass83_6);
        break;
      case 1012:
        scriptevent_0.method706(ScriptArguments.aClass83_4);
    }

    Position.execute(scriptevent_0);
  }

  public void method33(final int int_0, final int int_1, final int int_2, final boolean bool_0) {
    WorldMapData worldmapdata_0 = method15(int_0, int_1, int_2);
    if (worldmapdata_0 == null) {
      if (!bool_0) {
        return;
      }

      worldmapdata_0 = aWorldMapData2;
    }

    boolean bool_1 = false;
    if (worldmapdata_0 != aWorldMapData3 || bool_0) {
      aWorldMapData3 = worldmapdata_0;
      method20(worldmapdata_0);
      bool_1 = true;
    }

    if (bool_1 || bool_0) {
      method23(int_0, int_1, int_2);
    }

  }

  public void method34() {
    aClass109_1.method530();
  }

  public void method35(final int int_0, final int int_1, final boolean bool_0, final int int_2,
      final int int_3,
      final int int_4, final int int_5) {
    if (aClass109_1.method531()) {
      method21();
      method25();
      if (bool_0) {
        final int int_6 = (int) Math.ceil(int_4 / aFloat2);
        final int int_7 = (int) Math.ceil(int_5 / aFloat2);
        final List list_0 = aClass7_1.method138(anInt10 - int_6 / 2 - 1, anInt9 - int_7 / 2 - 1,
            int_6 / 2 + anInt10 + 1, int_7 / 2 + anInt9 + 1, int_2, int_3, int_4, int_5, int_0,
            int_1);
        final HashSet hashset_0 = new HashSet();

        Iterator iterator_0;
        Class16 class16_0;
        ScriptCall scriptevent_0;
        Boundry class9_0;
        for (iterator_0 = list_0.iterator(); iterator_0.hasNext();
            Position.execute(scriptevent_0)) {
          class16_0 = (Class16) iterator_0.next();
          hashset_0.add(class16_0);
          scriptevent_0 = new ScriptCall();
          class9_0 = new Boundry(class16_0.anInt64, class16_0.aCoordinates4,
              class16_0.aCoordinates5);
          scriptevent_0
              .method705(new Object[] {class9_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
          if (aHashSet6.contains(class16_0)) {
            scriptevent_0.method706(ScriptArguments.aClass83_9);
          } else {
            scriptevent_0.method706(ScriptArguments.aClass83_7);
          }
        }

        iterator_0 = aHashSet6.iterator();

        while (iterator_0.hasNext()) {
          class16_0 = (Class16) iterator_0.next();
          if (!hashset_0.contains(class16_0)) {
            scriptevent_0 = new ScriptCall();
            class9_0 = new Boundry(class16_0.anInt64, class16_0.aCoordinates4,
                class16_0.aCoordinates5);
            scriptevent_0
                .method705(new Object[] {class9_0, Integer.valueOf(int_0), Integer.valueOf(int_1)});
            scriptevent_0.method706(ScriptArguments.aClass83_8);
            Position.execute(scriptevent_0);
          }
        }

        aHashSet6 = hashset_0;
      }
    }
  }

  public void method36(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5) {
    if (aClass109_1.method531()) {
      final int int_6 = (int) Math.ceil(int_2 / aFloat2);
      final int int_7 = (int) Math.ceil(int_3 / aFloat2);
      final List list_0 = aClass7_1.method138(anInt10 - int_6 / 2 - 1, anInt9 - int_7 / 2 - 1,
          int_6 / 2 + anInt10 + 1, int_7 / 2 + anInt9 + 1, int_0, int_1, int_2, int_3, int_4,
          int_5);
      if (!list_0.isEmpty()) {
        final Iterator iterator_0 = list_0.iterator();

        boolean bool_0;
        do {
          if (!iterator_0.hasNext()) {
            return;
          }

          final Class16 class16_0 = (Class16) iterator_0.next();
          final Area area_0 = Area.anAreaArray1[class16_0.anInt64];
          bool_0 = false;

          for (int int_8 = anIntArray1.length - 1; int_8 >= 0; --int_8) {
            if (area_0.aStringArray4[int_8] != null) {
              DynamicObject.addMenuEntry(area_0.aStringArray4[int_8], area_0.aString28,
                  anIntArray1[int_8], class16_0.anInt64, class16_0.aCoordinates4.hash(),
                  class16_0.aCoordinates5.hash());
              bool_0 = true;
            }
          }
        } while (!bool_0);

      }
    }
  }

  public void method37(final int int_0) {
    final WorldMapData worldmapdata_0 = method17(int_0);
    if (worldmapdata_0 != null) {
      method20(worldmapdata_0);
    }

  }

  public int method38() {
    return aFloat1 == 1.0D ? 25
        : aFloat1 == 1.5D ? 37
            : aFloat1 == 2.0D ? 50 : aFloat1 == 3.0D ? 75 : aFloat1 == 4.0D ? 100 : 200;
  }

  public void method39(final int int_0) {
    aFloat1 = method16(int_0);
  }

  public boolean method40() {
    return aClass109_1.method531();
  }

  public Position method41() {
    return aWorldMapData1 == null ? null : aWorldMapData1.method314(method19(), method24());
  }

  public void method42(final int int_0, final int int_1, final int int_2) {
    if (aWorldMapData1 != null) {
      final int[] ints_0 = aWorldMapData1.method310(int_0, int_1, int_2);
      if (ints_0 != null) {
        method26(ints_0[0], ints_0[1]);
      }

    }
  }

  public void method43(final int int_0, final int int_1, final int int_2) {
    if (aWorldMapData1 != null) {
      final int[] ints_0 = aWorldMapData1.method310(int_0, int_1, int_2);
      if (ints_0 != null) {
        method27(ints_0[0], ints_0[1]);
      }

    }
  }

  public void method44(final int int_0, final int int_1, final boolean bool_0) {
    if (anInt4 == -1) {
      anInt4 = int_0;
    }

    if (anInt7 == -1) {
      anInt7 = int_1;
    }

    final int int_2 = int_0 - anInt4;
    final int int_3 = int_1 - anInt7;
    anInt4 = int_0;
    anInt7 = int_1;
    if (bool_0 && !method14()) {
      anInt10 -= (int) (int_2 / aFloat1);
      anInt9 += (int) (int_3 / aFloat1);
    }

  }

  public int method45() {
    return aWorldMapData1 == null ? -1 : aWorldMapData1.method309();
  }

  public WorldMapData method46() {
    return aWorldMapData1;
  }

  public void method47() {
    anInt1 = 3;
  }

  public void method48() {
    anInt5 = 50;
  }

  public int method49() {
    return anInt2;
  }

  public void method50(final int int_0) {
    if (int_0 >= 1) {
      anInt1 = int_0;
    }

  }

  public void method51() {
    aHashSet4 = null;
  }

  public void method52(final int int_0) {
    if (int_0 >= 1) {
      anInt5 = int_0;
    }

  }

  public void method53(final int int_0) {
    aHashSet4 = new HashSet();
    aHashSet4.add(Integer.valueOf(int_0));
    anInt11 = 0;
    anInt12 = 0;
  }

  public void method54(final boolean bool_0) {
    aBool1 = bool_0;
  }

  public void method55(final int int_0) {
    aHashSet4 = new HashSet();
    anInt11 = 0;
    anInt12 = 0;

    for (int int_1 = 0; int_1 < Area.anAreaArray1.length; int_1++) {
      if (Area.anAreaArray1[int_1] != null && Area.anAreaArray1[int_1].anInt438 == int_0) {
        aHashSet4.add(Integer.valueOf(Area.anAreaArray1[int_1].anInt432));
      }
    }

  }

  public void method56(final boolean bool_0) {
    aBool2 = !bool_0;
  }

  public int method57() {
    return anInt3;
  }

  public Class16 method58() {
    if (!aClass109_1.method531()) {
      return null;
    }
    if (!aClass7_1.method134()) {
      return null;
    }
    final HashMap hashmap_0 = aClass7_1.method135();
    aList1 = new LinkedList();
    final Iterator iterator_0 = hashmap_0.values().iterator();

    while (iterator_0.hasNext()) {
      final List list_0 = (List) iterator_0.next();
      aList1.addAll(list_0);
    }

    anIterator1 = aList1.iterator();
    return method28();
  }

  public boolean method59() {
    return !aBool2;
  }

  public void method60(final int int_0, final boolean bool_0) {
    if (!bool_0) {
      aHashSet2.add(Integer.valueOf(int_0));
    } else {
      aHashSet2.remove(Integer.valueOf(int_0));
    }

    method22();
  }

  public void method61(final int int_0, final boolean bool_0) {
    if (!bool_0) {
      aHashSet1.add(Integer.valueOf(int_0));
    } else {
      aHashSet1.remove(Integer.valueOf(int_0));
    }

    for (int int_1 = 0; int_1 < Area.anAreaArray1.length; int_1++) {
      if (Area.anAreaArray1[int_1] != null && Area.anAreaArray1[int_1].anInt438 == int_0) {
        final int int_2 = Area.anAreaArray1[int_1].anInt432;
        if (!bool_0) {
          aHashSet5.add(Integer.valueOf(int_2));
        } else {
          aHashSet5.remove(Integer.valueOf(int_2));
        }
      }
    }

    method22();
  }

  public void method62(final WorldMapData worldmapdata_0, final Position coordinates_0,
      final Position coordinates_1, final boolean bool_0) {
    if (worldmapdata_0 != null) {
      if (aWorldMapData1 == null || worldmapdata_0 != aWorldMapData1) {
        method18(worldmapdata_0);
      }

      if (!bool_0 && aWorldMapData1
          .method313(coordinates_0.plane, coordinates_0.x, coordinates_0.z)) {
        method23(coordinates_0.plane, coordinates_0.x, coordinates_0.z);
      } else {
        method23(coordinates_1.plane, coordinates_1.x, coordinates_1.z);
      }
    }
  }

  public boolean method63(final int int_0) {
    return !aHashSet2.contains(Integer.valueOf(int_0));
  }

  public boolean method64(final int int_0) {
    return !aHashSet1.contains(Integer.valueOf(int_0));
  }

  public Position method65(final int int_0, final Position coordinates_0) {
    if (!aClass109_1.method531()) {
      return null;
    }
    if (!aClass7_1.method134()) {
      return null;
    }
    if (!aWorldMapData1.method308(coordinates_0.x, coordinates_0.z)) {
      return null;
    }
    final HashMap hashmap_0 = aClass7_1.method135();
    final List list_0 = (List) hashmap_0.get(Integer.valueOf(int_0));
    if (list_0 != null && !list_0.isEmpty()) {
      Class16 class16_0 = null;
      int int_1 = -1;
      final Iterator iterator_0 = list_0.iterator();

      while (true) {
        Class16 class16_1;
        int int_4;
        do {
          if (!iterator_0.hasNext()) {
            return class16_0.aCoordinates5;
          }

          class16_1 = (Class16) iterator_0.next();
          final int int_2 = class16_1.aCoordinates5.x - coordinates_0.x;
          final int int_3 = class16_1.aCoordinates5.z - coordinates_0.z;
          int_4 = int_2 * int_2 + int_3 * int_3;
          if (int_4 == 0) {
            return class16_1.aCoordinates5;
          }
        } while (int_4 >= int_1 && class16_0 != null);

        class16_0 = class16_1;
        int_1 = int_4;
      }
    }
    return null;
  }

}
