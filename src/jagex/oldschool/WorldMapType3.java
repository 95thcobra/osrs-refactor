package jagex.oldschool;

import jagex.oldschool.device.Keyboard;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Position;

public class WorldMapType3 implements WorldMapSectionBase {

  static int[] anIntArray68;
  int anInt222;
  int anInt223;
  int anInt224;
  int anInt225;
  int anInt226;
  int anInt227;
  int anInt228;
  int anInt229;
  int anInt230;
  int anInt231;
  int anInt232;
  int anInt233;
  int anInt234;
  int anInt235;

  public static void method566() {
    if (Keyboard.keyboard != null) {
      synchronized (Keyboard.keyboard) {
        Keyboard.keyboard = null;
      }
    }

  }

  static RenderOverview method567() {
    return Class14.renderOverview;
  }

  @Override
  public boolean method5(final int int_0, final int int_1) {
    return int_0 >= (anInt223 << 6) + (anInt224 << 3) && int_0 <= (anInt223 << 6) + (anInt226
        << 3) + 7
        && int_1 >= (anInt229 << 6) + (anInt230 << 3) && int_1 <= (anInt229 << 6) + (anInt232
        << 3) + 7;
  }

  @Override
  public boolean method6(final int int_0, final int int_1, final int int_2) {
    return int_0 >= anInt222 && int_0 < anInt225 + anInt222 ?
        int_1 >= (anInt227 << 6) + (anInt228 << 3)
            && int_1 <= (anInt227 << 6) + (anInt231 << 3) + 7 && int_2 >= (anInt233 << 6) + (
            anInt234 << 3)
            && int_2 <= (anInt233 << 6) + (anInt235 << 3) + 7 : false;
  }

  @Override
  public void method7(final WorldMapData worldmapdata_0) {
    if (worldmapdata_0.anInt112 > anInt223) {
      worldmapdata_0.anInt112 = anInt223;
    }

    if (worldmapdata_0.anInt110 < anInt223) {
      worldmapdata_0.anInt110 = anInt223;
    }

    if (worldmapdata_0.anInt113 > anInt229) {
      worldmapdata_0.anInt113 = anInt229;
    }

    if (worldmapdata_0.anInt111 < anInt229) {
      worldmapdata_0.anInt111 = anInt229;
    }

  }

  @Override
  public Position method8(final int int_0, final int int_1) {
    if (!method5(int_0, int_1)) {
      return null;
    }
    final int int_2 =
        anInt228 * 8 - anInt224 * 8 + anInt227 * 64 - anInt223 * 64 + int_0;
    final int int_3 =
        anInt233 * 64 - anInt229 * 64 + int_1 + anInt234 * 8 - anInt230 * 8;
    return new Position(anInt222, int_2, int_3);
  }

  @Override
  public int[] method9(final int int_0, final int int_1, final int int_2) {
    if (!method6(int_0, int_1, int_2)) {
      return null;
    }
    final int[] ints_0 = new int[] {
        anInt224 * 8 - anInt228 * 8 + anInt223 * 64 - anInt227 * 64 + int_1,
        anInt229 * 64 - anInt233 * 64 + int_2 + anInt230 * 8 - anInt234 * 8
    };
    return ints_0;
  }

  @Override
  public void method10(final Buffer buffer_0) {
    anInt222 = buffer_0.getUnsignedByte();
    anInt225 = buffer_0.getUnsignedByte();
    anInt227 = buffer_0.getUnsignedShort();
    anInt228 = buffer_0.getUnsignedByte();
    anInt231 = buffer_0.getUnsignedByte();
    anInt233 = buffer_0.getUnsignedShort();
    anInt234 = buffer_0.getUnsignedByte();
    anInt235 = buffer_0.getUnsignedByte();
    anInt223 = buffer_0.getUnsignedShort();
    anInt224 = buffer_0.getUnsignedByte();
    anInt226 = buffer_0.getUnsignedByte();
    anInt229 = buffer_0.getUnsignedShort();
    anInt230 = buffer_0.getUnsignedByte();
    anInt232 = buffer_0.getUnsignedByte();
    method565();
  }

  void method565() {
  }

}
