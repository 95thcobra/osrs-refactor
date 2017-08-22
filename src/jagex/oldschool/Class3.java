package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Position;
import java.lang.management.GarbageCollectorMXBean;

public class Class3 implements WorldMapSectionBase {

  public static int anInt22;
  static int anInt21;
  static GarbageCollectorMXBean aGarbageCollectorMXBean1;
  int anInt23;
  int anInt24;
  int anInt25;
  int anInt26;
  int anInt27;
  int anInt28;
  int anInt29;
  int anInt30;
  int anInt31;
  int anInt32;

  public static void method122(final AbstractPackage indexdatabase_0, final String string_0,
      final String string_1,
      final int int_0, final boolean bool_0) {
    final int int_1 = indexdatabase_0.getFile(string_0);
    final int int_2 = indexdatabase_0.getChild(int_1, string_1);
    Class23.method212(indexdatabase_0, int_1, int_2, int_0, bool_0);
  }

  @Override
  public boolean method5(final int int_0, final int int_1) {
    return int_0 >= (anInt24 << 6) + (anInt25 << 3) && int_0 <= (anInt24 << 6) + (anInt25
        << 3) + 7
        && int_1 >= (anInt29 << 6) + (anInt30 << 3) && int_1 <= (anInt29 << 6) + (anInt30
        << 3) + 7;
  }

  @Override
  public boolean method6(final int int_0, final int int_1, final int int_2) {
    return int_0 >= anInt23 && int_0 < anInt23 + anInt26 ?
        int_1 >= (anInt27 << 6) + (anInt28 << 3)
            && int_1 <= (anInt27 << 6) + (anInt28 << 3) + 7 && int_2 >= (anInt31 << 6) + (
            anInt32 << 3)
            && int_2 <= (anInt31 << 6) + (anInt32 << 3) + 7 : false;
  }

  @Override
  public void method7(final WorldMapData worldmapdata_0) {
    if (worldmapdata_0.anInt112 > anInt24) {
      worldmapdata_0.anInt112 = anInt24;
    }

    if (worldmapdata_0.anInt110 < anInt24) {
      worldmapdata_0.anInt110 = anInt24;
    }

    if (worldmapdata_0.anInt113 > anInt29) {
      worldmapdata_0.anInt113 = anInt29;
    }

    if (worldmapdata_0.anInt111 < anInt29) {
      worldmapdata_0.anInt111 = anInt29;
    }

  }

  @Override
  public Position method8(final int int_0, final int int_1) {
    if (!method5(int_0, int_1)) {
      return null;
    }
    final int int_2 = anInt28 * 8 - anInt25 * 8 + int_0 + anInt27 * 64 - anInt24 * 64;
    final int int_3 = anInt32 * 8 - anInt30 * 8 + anInt31 * 64 - anInt29 * 64 + int_1;
    return new Position(anInt23, int_2, int_3);
  }

  @Override
  public int[] method9(final int int_0, final int int_1, final int int_2) {
    if (!method6(int_0, int_1, int_2)) {
      return null;
    }
    final int[] ints_0 = new int[] {
        int_1 + anInt24 * 64 - anInt27 * 64 + anInt25 * 8 - anInt28 * 8,
        int_2 + anInt29 * 64 - anInt31 * 64 + anInt30 * 8 - anInt32 * 8
    };
    return ints_0;
  }

  @Override
  public void method10(final Buffer buffer_0) {
    anInt23 = buffer_0.getUnsignedByte();
    anInt26 = buffer_0.getUnsignedByte();
    anInt27 = buffer_0.getUnsignedShort();
    anInt28 = buffer_0.getUnsignedByte();
    anInt31 = buffer_0.getUnsignedShort();
    anInt32 = buffer_0.getUnsignedByte();
    anInt24 = buffer_0.getUnsignedShort();
    anInt25 = buffer_0.getUnsignedByte();
    anInt29 = buffer_0.getUnsignedShort();
    anInt30 = buffer_0.getUnsignedByte();
    method121();
  }

  void method121() {
  }

}
