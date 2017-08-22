package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.config.InventoryConfig;
import jagex.oldschool.io.Buffer;
import java.util.LinkedList;

public abstract class AClass1 {

  public static Package configsIndex;
  public static ClanMember[] clanMembers;
  int anInt40;
  int anInt41;
  short[][][] aShortArrayArrayArray1;
  int anInt42;
  short[][][] aShortArrayArrayArray2;
  Class13[][][][] aClass13ArrayArrayArrayArray1;
  int anInt43;
  byte[][][] aByteArrayArrayArray1;
  int anInt44;
  byte[][][] aByteArrayArrayArray2;
  int anInt45;

  AClass1() {
    new LinkedList();
  }

  public static void method150(final AbstractPackage indexdatabase_0) {
    InventoryConfig.anIndexDataBase17 = indexdatabase_0;
  }

  int method144(final int int_0, final int int_1) {
    return int_0 >= 0 && int_1 >= 0
        ? int_0 < 64 && int_1 < 64 ? aShortArrayArrayArray1[0][int_0][int_1] - 1 : -1
        : -1;
  }

  void method145(final int int_0, final int int_1, final Buffer buffer_0, final int int_2) {
    final boolean bool_0 = (int_2 & 0x2) != 0;
    if (bool_0) {
      aShortArrayArrayArray2[0][int_0][int_1] = (short) buffer_0.getUnsignedByte();
    }

    aShortArrayArrayArray1[0][int_0][int_1] = (short) buffer_0.getUnsignedByte();
  }

  void method146(final int int_0, final int int_1, final Buffer buffer_0, final int int_2) {
    final int int_3 = ((int_2 & 0x18) >> 3) + 1;
    final boolean bool_0 = (int_2 & 0x2) != 0;
    final boolean bool_1 = (int_2 & 0x4) != 0;
    aShortArrayArrayArray1[0][int_0][int_1] = (short) buffer_0.getUnsignedByte();
    int int_4;
    int int_5;
    int int_7;
    if (bool_0) {
      int_4 = buffer_0.getUnsignedByte();

      for (int_5 = 0; int_5 < int_4; int_5++) {
        final int int_6 = buffer_0.getUnsignedByte();
        if (int_6 != 0) {
          aShortArrayArrayArray2[int_5][int_0][int_1] = (short) int_6;
          int_7 = buffer_0.getUnsignedByte();
          aByteArrayArrayArray1[int_5][int_0][int_1] = (byte) (int_7 >> 2);
          aByteArrayArrayArray2[int_5][int_0][int_1] = (byte) (int_7 & 0x3);
        }
      }
    }

    if (bool_1) {
      for (int_4 = 0; int_4 < int_3; int_4++) {
        int_5 = buffer_0.getUnsignedByte();
        if (int_5 != 0) {
          final Class13[] class13s_0 = aClass13ArrayArrayArrayArray1[int_4][int_0][int_1] = new Class13[int_5];

          for (int_7 = 0; int_7 < int_5; int_7++) {
            final int int_8 = buffer_0.getSmartInt();
            final int int_9 = buffer_0.getUnsignedByte();
            class13s_0[int_7] = new Class13(int_8, int_9 >> 2, int_9 & 0x3);
          }
        }
      }
    }

  }

  int method147() {
    return anInt41;
  }

  int method148() {
    return anInt40;
  }

  void method149(final int int_0, final int int_1, final Buffer buffer_0) {
    final int int_2 = buffer_0.getUnsignedByte();
    if (int_2 != 0) {
      if ((int_2 & 0x1) != 0) {
        method145(int_0, int_1, buffer_0, int_2);
      } else {
        method146(int_0, int_1, buffer_0, int_2);
      }
    }
  }

}
