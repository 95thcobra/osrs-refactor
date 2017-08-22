package jagex.oldschool;

import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Position;
import jagex.oldschool.ui.InterfaceComponent;

public class WorldMapType1 implements WorldMapSectionBase {

  public static String userHome;
  static AbstractSourceLine soundSystem1;
  static int[] blendedSaturation;
  int anInt236;
  int anInt237;
  int anInt238;
  int anInt239;
  int anInt240;
  int anInt241;
  int anInt242;
  int anInt243;
  int anInt244;
  int anInt245;

  public static int getSmoothNoise2D(final int int_0, final int int_1) {
    final int int_2 =
        InterfaceComponent.method588(int_0 - 1, int_1 - 1) + InterfaceComponent
            .method588(int_0 + 1, int_1 - 1)
            + InterfaceComponent.method588(int_0 - 1, int_1 + 1) + InterfaceComponent
            .method588(int_0 + 1, int_1 + 1);
    final int int_3 = InterfaceComponent.method588(int_0 - 1, int_1) + InterfaceComponent
        .method588(int_0 + 1, int_1)
        + InterfaceComponent.method588(int_0, int_1 - 1) + InterfaceComponent
        .method588(int_0, int_1 + 1);
    final int int_4 = InterfaceComponent.method588(int_0, int_1);
    return int_2 / 16 + int_3 / 8 + int_4 / 4;
  }

  @Override
  public boolean method5(final int int_0, final int int_1) {
    return int_0 >> 6 >= anInt236 && int_0 >> 6 <= anInt239 && int_1 >> 6 >= anInt240
        && int_1 >> 6 <= anInt242;
  }

  @Override
  public boolean method6(final int int_0, final int int_1, final int int_2) {
    return int_0 >= anInt237 && int_0 < anInt238 + anInt237 ? int_1 >> 6 >= anInt241
        && int_1 >> 6 <= anInt243 && int_2 >> 6 >= anInt244 && int_2 >> 6 <= anInt245
        : false;
  }

  @Override
  public void method7(final WorldMapData worldmapdata_0) {
    if (worldmapdata_0.anInt112 > anInt236) {
      worldmapdata_0.anInt112 = anInt236;
    }

    if (worldmapdata_0.anInt110 < anInt239) {
      worldmapdata_0.anInt110 = anInt239;
    }

    if (worldmapdata_0.anInt113 > anInt240) {
      worldmapdata_0.anInt113 = anInt240;
    }

    if (worldmapdata_0.anInt111 < anInt242) {
      worldmapdata_0.anInt111 = anInt242;
    }

  }

  @Override
  public Position method8(final int int_0, final int int_1) {
    if (!method5(int_0, int_1)) {
      return null;
    }
    final int int_2 = int_0 + anInt241 * 64 - anInt236 * 64;
    final int int_3 = anInt244 * 64 - anInt240 * 64 + int_1;
    return new Position(anInt237, int_2, int_3);
  }

  @Override
  public int[] method9(final int int_0, final int int_1, final int int_2) {
    if (!method6(int_0, int_1, int_2)) {
      return null;
    }
    final int[] ints_0 = new int[] {
        anInt236 * 64 - anInt241 * 64 + int_1,
        int_2 + anInt240 * 64 - anInt244 * 64
    };
    return ints_0;
  }

  @Override
  public void method10(final Buffer buffer_0) {
    anInt237 = buffer_0.getUnsignedByte();
    anInt238 = buffer_0.getUnsignedByte();
    anInt241 = buffer_0.getUnsignedShort();
    anInt244 = buffer_0.getUnsignedShort();
    anInt243 = buffer_0.getUnsignedShort();
    anInt245 = buffer_0.getUnsignedShort();
    anInt236 = buffer_0.getUnsignedShort();
    anInt240 = buffer_0.getUnsignedShort();
    anInt239 = buffer_0.getUnsignedShort();
    anInt242 = buffer_0.getUnsignedShort();
    method568();
  }

  void method568() {
  }

}
