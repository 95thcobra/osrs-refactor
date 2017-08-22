package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;

public class Area extends Subnode {

  public static Area[] anAreaArray1;
  public static AbstractPackage anIndexDataBase18;
  public static int anInt431;
  public static boolean aBool52;
  static Cache skeletonsIndex;

  static {
    skeletonsIndex = new Cache(256);
  }

  public final int anInt432;
  public int spriteId;
  public String name;
  public Enum7 anEnum7_4;
  public Enum8 anEnum8_4;
  public int anInt435;
  public int anInt436;
  public String[] aStringArray4;
  public int anInt438;
  public String aString28;
  int[] anIntArray84;
  int anInt433;
  int anInt434;
  int anInt437;
  int anInt439;
  int anInt440;
  int[] anIntArray85;
  byte[] aByteArray19;

  public Area(final int int_0) {
    spriteId = -1;
    anInt433 = -1;
    anInt436 = 0;
    aStringArray4 = new String[5];
    anInt434 = Integer.MAX_VALUE;
    anInt439 = Integer.MAX_VALUE;
    anInt437 = Integer.MIN_VALUE;
    anInt440 = Integer.MIN_VALUE;
    anEnum7_4 = Enum7.anEnum7_2;
    anEnum8_4 = Enum8.anEnum8_2;
    anInt438 = -1;
    anInt432 = int_0;
  }

  public static IdentityConfig getKitDefinition(final int int_0) {
    IdentityConfig kitdefinition_0 = (IdentityConfig) IdentityConfig.identKits.get(int_0);
    if (kitdefinition_0 != null) {
      return kitdefinition_0;
    }
    final byte[] bytes_0 = IdentityConfig.identKit_ref.get(3, int_0);
    kitdefinition_0 = new IdentityConfig();
    if (bytes_0 != null) {
      kitdefinition_0.decode(new Buffer(bytes_0));
    }

    IdentityConfig.identKits.put(kitdefinition_0, int_0);
    return kitdefinition_0;
  }

  public DirectSprite method774(final boolean bool_0) {
    final int int_0 = spriteId;
    return method775(int_0);
  }

  DirectSprite method775(final int int_0) {
    if (int_0 < 0) {
      return null;
    }
    DirectSprite spritepixels_0 = (DirectSprite) skeletonsIndex.get(int_0);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(anIndexDataBase18, int_0, 0);
    if (spritepixels_0 != null) {
      skeletonsIndex.put(spritepixels_0, int_0);
    }

    return spritepixels_0;
  }

  void method776(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      spriteId = buffer_0.getSmartInt();
    } else {
      if (int_0 == 2) {
        anInt433 = buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 3) {
        name = buffer_0.getString();
        return;
      }

      if (int_0 == 4) {
        anInt435 = buffer_0.getUnsignedMedium();
        return;
      }

      if (int_0 == 5) {
        buffer_0.getUnsignedMedium();
        return;
      }

      if (int_0 == 6) {
        anInt436 = buffer_0.getUnsignedByte();
        return;
      }

      int int_1;
      if (int_0 == 7) {
        int_1 = buffer_0.getUnsignedByte();
        if ((int_1 & 0x1) == 0) {
        }

        if ((int_1 & 0x2) == 2) {
          return;
        }

        return;
      }

      if (int_0 == 8) {
        buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 >= 10 && int_0 <= 14) {
        aStringArray4[int_0 - 10] = buffer_0.getString();
        return;
      }

      if (int_0 == 15) {
        int_1 = buffer_0.getUnsignedByte();
        anIntArray84 = new int[int_1 * 2];

        int int_2;
        for (int_2 = 0; int_2 < int_1 * 2; int_2++) {
          anIntArray84[int_2] = buffer_0.getShort();
        }

        buffer_0.getInt();
        int_2 = buffer_0.getUnsignedByte();
        anIntArray85 = new int[int_2];

        int int_3;
        for (int_3 = 0; int_3 < anIntArray85.length; int_3++) {
          anIntArray85[int_3] = buffer_0.getInt();
        }

        aByteArray19 = new byte[int_1];

        for (int_3 = 0; int_3 < int_1; int_3++) {
          aByteArray19[int_3] = buffer_0.getByte();
        }

        return;
      }

      if (int_0 == 16) {
        return;
      }

      if (int_0 == 17) {
        aString28 = buffer_0.getString();
        return;
      }

      if (int_0 == 18) {
        buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 19) {
        anInt438 = buffer_0.getUnsignedShort();
        return;
      }

      if (int_0 == 21) {
        buffer_0.getInt();
        return;
      }

      if (int_0 == 22) {
        buffer_0.getInt();
        return;
      }

      if (int_0 == 23) {
        buffer_0.getUnsignedByte();
        buffer_0.getUnsignedByte();
        buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 24) {
        buffer_0.getShort();
        buffer_0.getShort();
        return;
      }

      if (int_0 == 25) {
        buffer_0.getSmartInt();
        return;
      }

      if (int_0 == 28) {
        buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 29) {
        final Enum7[] enum7s_0 = new Enum7[] {Enum7.anEnum7_3, Enum7.anEnum7_1, Enum7.anEnum7_2};
        anEnum7_4 = (Enum7) PlayerIdentity.forOrdinal(enum7s_0, buffer_0.getUnsignedByte());
        return;
      }

      if (int_0 == 30) {
        anEnum8_4 = (Enum8) PlayerIdentity
            .forOrdinal(Class25.method222(), buffer_0.getUnsignedByte());
        return;
      }
    }

  }

  public int method777() {
    return anInt432;
  }

  public void method778(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method776(buffer_0, int_0);
    }
  }

  public void method779() {
    if (anIntArray84 != null) {
      for (int int_0 = 0; int_0 < anIntArray84.length; int_0 += 2) {
        if (anIntArray84[int_0] < anInt434) {
          anInt434 = anIntArray84[int_0];
        } else if (anIntArray84[int_0] > anInt437) {
          anInt437 = anIntArray84[int_0];
        }

        if (anIntArray84[int_0 + 1] < anInt439) {
          anInt439 = anIntArray84[int_0 + 1];
        } else if (anIntArray84[int_0 + 1] > anInt440) {
          anInt440 = anIntArray84[int_0 + 1];
        }
      }
    }

  }

}
