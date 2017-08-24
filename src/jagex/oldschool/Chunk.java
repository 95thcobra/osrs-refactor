package jagex.oldschool;

import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Npc;

public class Chunk extends AClass1 {

  int bz;
  int bx;
  int anInt296;
  int anInt297;

  static int method595() {
    return 9;
  }

  static void method596(final boolean bool_0) {
    for (int int_0 = 0; int_0 < Client.anInt636; int_0++) {
      final Npc npc_0 = Client.cachedNPCs[Client.npcIndices[int_0]];
      int int_1 = (Client.npcIndices[int_0] << 14) + 536870912;
      if (npc_0 != null && npc_0.hasConfig() && npc_0.config.isVisible == bool_0
          && npc_0.config.method865()) {
        final int int_2 = npc_0.x >> 7;
        final int int_3 = npc_0.y >> 7;
        if (int_2 >= 0 && int_2 < 104 && int_3 >= 0 && int_3 < 104) {
          if (npc_0.anInt499 == 1 && (npc_0.x & 0x7F) == 64 && (npc_0.y & 0x7F) == 64) {
            if (Client.anIntArrayArray21[int_2][int_3] == Client.anInt643) {
              continue;
            }

            Client.anIntArrayArray21[int_2][int_3] = Client.anInt643;
          }

          if (!npc_0.config.aBool60) {
            int_1 -= Integer.MIN_VALUE;
          }

          Class11.scene.method369(Class12.plane, npc_0.x, npc_0.y,
              Client.getTileHeight(npc_0.x + npc_0.anInt499 * 64 - 64,
                  npc_0.y + npc_0.anInt499 * 64 - 64, Class12.plane),
              npc_0.anInt499 * 64 - 64 + 60, npc_0, npc_0.angle, int_1, npc_0.aBool63);
        }
      }
    }

  }

  int method589() {
    return anInt297;
  }

  boolean method590(final int int_0, final int int_1) {
    return int_0 < anInt297 * 8 ? false
        : int_1 < anInt296 * 8 ? false
            : int_0 >= 8 + anInt297 * 8 ? false : int_1 < 8 + anInt296 * 8;
  }

  int method591() {
    return anInt296;
  }

  void method592(final Buffer buffer_0, final Buffer buffer_1) {
    int int_0 = buffer_1.getUnsignedByte();
    if (int_0 != Class11.aClass11_1.anInt56) {
      throw new IllegalStateException("");
    }
    plane = buffer_1.getUnsignedByte();
    upperPlane = buffer_1.getUnsignedByte();
    x = buffer_1.getUnsignedShort();
    z = buffer_1.getUnsignedShort();
    bx = buffer_1.getUnsignedByte();
    bz = buffer_1.getUnsignedByte();
    anInt41 = buffer_1.getUnsignedShort();
    anInt40 = buffer_1.getUnsignedShort();
    anInt297 = buffer_1.getUnsignedByte();
    anInt296 = buffer_1.getUnsignedByte();
    upperPlane = Math.min(upperPlane, 4);
    aShortArrayArrayArray1 = new short[1][64][64];
    aShortArrayArrayArray2 = new short[upperPlane][64][64];
    aByteArrayArrayArray1 = new byte[upperPlane][64][64];
    aByteArrayArrayArray2 = new byte[upperPlane][64][64];
    aClass13ArrayArrayArrayArray1 = new Class13[upperPlane][64][64][];
    int_0 = buffer_0.getUnsignedByte();
    if (int_0 != Class12.aClass12_2.anInt57) {
      throw new IllegalStateException("");
    }
    final int int_1 = buffer_0.getUnsignedByte();
    final int int_2 = buffer_0.getUnsignedByte();
    final int int_3 = buffer_0.getUnsignedByte();
    final int int_4 = buffer_0.getUnsignedByte();
    if (int_1 == anInt41 && int_2 == anInt40 && int_3 == anInt297 && int_4 == anInt296) {
      for (int int_5 = 0; int_5 < 8; int_5++) {
        for (int int_6 = 0; int_6 < 8; int_6++) {
          method149(int_5 + anInt297 * 8, int_6 + anInt296 * 8, buffer_0);
        }
      }

    } else {
      throw new IllegalStateException("");
    }
  }

  int getBlockX() {
    return bx;
  }

  int getBlockZ() {
    return bz;
  }

  @Override
  public boolean equals(final Object object_0) {
    if (!(object_0 instanceof Chunk)) {
      return false;
    }
    final Chunk aclass1_sub1_1 = (Chunk) object_0;
    return anInt41 == aclass1_sub1_1.anInt41 && anInt40 == aclass1_sub1_1.anInt40
        ? anInt297 == aclass1_sub1_1.anInt297 && aclass1_sub1_1.anInt296 == anInt296
        : false;
  }

  @Override
  public int hashCode() {
    return anInt41 | anInt40 << 8 | anInt297 << 16 | anInt296 << 24;
  }

}
