package jagex.oldschool;

import jagex.oldschool.config.BitVariableConfig;
import jagex.oldschool.scene.CollisionData;
import java.math.BigInteger;

public class Class26 {

  static final BigInteger rsaKeyExponent;
  static final BigInteger rsaKeyModulus;
  public static int revision;
  public static int anInt75;
  public static int scriptStringStackSize;

  static {
    rsaKeyExponent = new BigInteger("10001", 16);
    rsaKeyModulus = new BigInteger(
        "a3ec4738cfccaae5958718f5369c4e442195a4f385729be09e0482c2cfbc9f149467f93e4d65ae01584e2acef9e26d22019470fb4ec9b1217867f2a208dfb8de5bb8373b361b0e6368f52f2ccb7372cd95d7322242ccc5b39a7ecb27d3df432a5f69bada1a1fc5af8e81247240c37b889512977bcc9f78cf328aab52b67a0af9",
        16);
  }

  static void method230(final int int_0, final int int_1, final int int_2, final int int_3) {
    for (int int_4 = 0; int_4 < Client.anInt596; int_4++) {
      if (Client.widgetPositionX[int_4] + Client.widgetBoundsWidth[int_4] > int_0
          && Client.widgetPositionX[int_4] < int_0 + int_2
          && Client.widgetBoundsHeight[int_4] + Client.widgetPositionY[int_4] > int_1
          && Client.widgetPositionY[int_4] < int_3 + int_1) {
        Client.aBoolArray8[int_4] = true;
      }
    }

  }

  public static void method231() {
    BitVariableConfig.configs.reset();
  }

  public static boolean method232(final int int_0, final int int_1, final AClass2 aclass2_0,
      final CollisionData collisiondata_0) {
    int int_2 = int_0;
    int int_3 = int_1;
    final byte byte_0 = 64;
    final byte byte_1 = 64;
    final int int_4 = int_0 - byte_0;
    final int int_5 = int_1 - byte_1;
    Class66.anIntArrayArray10[byte_0][byte_1] = 99;
    Class66.anIntArrayArray11[byte_0][byte_1] = 0;
    final byte byte_2 = 0;
    int int_6 = 0;
    Class66.anIntArray38[byte_2] = int_0;
    final byte byte_3 = byte_2;
    int int_12 = byte_2 + 1;
    Class66.anIntArray39[byte_3] = int_1;
    final int[][] ints_0 = collisiondata_0.flags;

    while (int_12 != int_6) {
      int_2 = Class66.anIntArray38[int_6];
      int_3 = Class66.anIntArray39[int_6];
      int_6 = int_6 + 1 & 0xFFF;
      final int int_10 = int_2 - int_4;
      final int int_11 = int_3 - int_5;
      final int int_7 = int_2 - collisiondata_0.x;
      final int int_8 = int_3 - collisiondata_0.y;
      if (aclass2_0.method399(1, int_2, int_3, collisiondata_0)) {
        AClass2.anInt153 = int_2;
        Class66.anInt166 = int_3;
        return true;
      }

      final int int_9 = Class66.anIntArrayArray11[int_10][int_11] + 1;
      if (int_10 > 0 && Class66.anIntArrayArray10[int_10 - 1][int_11] == 0
          && (ints_0[int_7 - 1][int_8] & 0x1240108) == 0) {
        Class66.anIntArray38[int_12] = int_2 - 1;
        Class66.anIntArray39[int_12] = int_3;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 - 1][int_11] = 2;
        Class66.anIntArrayArray11[int_10 - 1][int_11] = int_9;
      }

      if (int_10 < 127 && Class66.anIntArrayArray10[int_10 + 1][int_11] == 0
          && (ints_0[int_7 + 1][int_8] & 0x1240180) == 0) {
        Class66.anIntArray38[int_12] = int_2 + 1;
        Class66.anIntArray39[int_12] = int_3;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 + 1][int_11] = 8;
        Class66.anIntArrayArray11[int_10 + 1][int_11] = int_9;
      }

      if (int_11 > 0 && Class66.anIntArrayArray10[int_10][int_11 - 1] == 0
          && (ints_0[int_7][int_8 - 1] & 0x1240102) == 0) {
        Class66.anIntArray38[int_12] = int_2;
        Class66.anIntArray39[int_12] = int_3 - 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10][int_11 - 1] = 1;
        Class66.anIntArrayArray11[int_10][int_11 - 1] = int_9;
      }

      if (int_11 < 127 && Class66.anIntArrayArray10[int_10][int_11 + 1] == 0
          && (ints_0[int_7][int_8 + 1] & 0x1240120) == 0) {
        Class66.anIntArray38[int_12] = int_2;
        Class66.anIntArray39[int_12] = int_3 + 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10][int_11 + 1] = 4;
        Class66.anIntArrayArray11[int_10][int_11 + 1] = int_9;
      }

      if (int_10 > 0 && int_11 > 0 && Class66.anIntArrayArray10[int_10 - 1][int_11 - 1] == 0
          && (ints_0[int_7 - 1][int_8 - 1] & 0x124010E) == 0
          && (ints_0[int_7 - 1][int_8] & 0x1240108) == 0 && (ints_0[int_7][int_8 - 1] & 0x1240102)
          == 0) {
        Class66.anIntArray38[int_12] = int_2 - 1;
        Class66.anIntArray39[int_12] = int_3 - 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 - 1][int_11 - 1] = 3;
        Class66.anIntArrayArray11[int_10 - 1][int_11 - 1] = int_9;
      }

      if (int_10 < 127 && int_11 > 0 && Class66.anIntArrayArray10[int_10 + 1][int_11 - 1] == 0
          && (ints_0[int_7 + 1][int_8 - 1] & 0x1240183) == 0
          && (ints_0[int_7 + 1][int_8] & 0x1240180) == 0 && (ints_0[int_7][int_8 - 1] & 0x1240102)
          == 0) {
        Class66.anIntArray38[int_12] = int_2 + 1;
        Class66.anIntArray39[int_12] = int_3 - 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 + 1][int_11 - 1] = 9;
        Class66.anIntArrayArray11[int_10 + 1][int_11 - 1] = int_9;
      }

      if (int_10 > 0 && int_11 < 127 && Class66.anIntArrayArray10[int_10 - 1][int_11 + 1] == 0
          && (ints_0[int_7 - 1][int_8 + 1] & 0x1240138) == 0
          && (ints_0[int_7 - 1][int_8] & 0x1240108) == 0 && (ints_0[int_7][int_8 + 1] & 0x1240120)
          == 0) {
        Class66.anIntArray38[int_12] = int_2 - 1;
        Class66.anIntArray39[int_12] = int_3 + 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 - 1][int_11 + 1] = 6;
        Class66.anIntArrayArray11[int_10 - 1][int_11 + 1] = int_9;
      }

      if (int_10 < 127 && int_11 < 127 && Class66.anIntArrayArray10[int_10 + 1][int_11 + 1]
          == 0
          && (ints_0[int_7 + 1][int_8 + 1] & 0x12401E0) == 0
          && (ints_0[int_7 + 1][int_8] & 0x1240180) == 0 && (ints_0[int_7][int_8 + 1] & 0x1240120)
          == 0) {
        Class66.anIntArray38[int_12] = int_2 + 1;
        Class66.anIntArray39[int_12] = int_3 + 1;
        int_12 = int_12 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_10 + 1][int_11 + 1] = 12;
        Class66.anIntArrayArray11[int_10 + 1][int_11 + 1] = int_9;
      }
    }

    AClass2.anInt153 = int_2;
    Class66.anInt166 = int_3;
    return false;
  }

}
