package jagex.oldschool;

import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.ui.InterfaceComponent;

public class Node_Sub5 extends Node {

  public static InterfaceComponent aWidget7;
  int[] anIntArray82;
  AClass5_Sub1[] anAClass5_Sub1Array1;
  short[] aShortArray5;
  byte[] aByteArray14;
  byte[] aByteArray15;
  Class78[] aClass78Array1;
  byte[] aByteArray16;
  int anInt365;

  Node_Sub5(final byte[] bytes_0) {
    anAClass5_Sub1Array1 = new AClass5_Sub1[128];
    aShortArray5 = new short[128];
    aByteArray14 = new byte[128];
    aByteArray15 = new byte[128];
    aClass78Array1 = new Class78[128];
    aByteArray16 = new byte[128];
    anIntArray82 = new int[128];
    final Buffer buffer_0 = new Buffer(bytes_0);

    int int_0;
    for (int_0 = 0; buffer_0.bytes[int_0 + buffer_0.offset] != 0; int_0++) {
    }

    final byte[] bytes_1 = new byte[int_0];

    int int_1;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      bytes_1[int_1] = buffer_0.getByte();
    }

    ++buffer_0.offset;
    ++int_0;
    int_1 = buffer_0.offset;
    buffer_0.offset += int_0;

    int int_2;
    for (int_2 = 0; buffer_0.bytes[int_2 + buffer_0.offset] != 0; int_2++) {
    }

    final byte[] bytes_2 = new byte[int_2];

    int int_3;
    for (int_3 = 0; int_3 < int_2; int_3++) {
      bytes_2[int_3] = buffer_0.getByte();
    }

    ++buffer_0.offset;
    ++int_2;
    int_3 = buffer_0.offset;
    buffer_0.offset += int_2;

    int int_4;
    for (int_4 = 0; buffer_0.bytes[int_4 + buffer_0.offset] != 0; int_4++) {
    }

    final byte[] bytes_3 = new byte[int_4];

    for (int int_5 = 0; int_5 < int_4; int_5++) {
      bytes_3[int_5] = buffer_0.getByte();
    }

    ++buffer_0.offset;
    ++int_4;
    final byte[] bytes_4 = new byte[int_4];
    int int_7;
    int int_8;
    if (int_4 > 1) {
      bytes_4[1] = 1;
      int int_6 = 1;
      int_7 = 2;

      for (int_8 = 2; int_8 < int_4; int_8++) {
        int int_9 = buffer_0.getUnsignedByte();
        if (int_9 == 0) {
          int_6 = int_7++;
        } else {
          if (int_9 <= int_6) {
            --int_9;
          }

          int_6 = int_9;
        }

        bytes_4[int_8] = (byte) int_6;
      }
    } else {
      int_7 = int_4;
    }

    final Class78[] class78s_0 = new Class78[int_7];

    Class78 class78_0;
    for (int_8 = 0; int_8 < class78s_0.length; int_8++) {
      class78_0 = class78s_0[int_8] = new Class78();
      int int_10 = buffer_0.getUnsignedByte();
      if (int_10 > 0) {
        class78_0.aByteArray9 = new byte[int_10 * 2];
      }

      int_10 = buffer_0.getUnsignedByte();
      if (int_10 > 0) {
        class78_0.aByteArray10 = new byte[int_10 * 2 + 2];
        class78_0.aByteArray10[1] = 64;
      }
    }

    int_8 = buffer_0.getUnsignedByte();
    final byte[] bytes_7 = int_8 > 0 ? new byte[int_8 * 2] : null;
    int_8 = buffer_0.getUnsignedByte();
    final byte[] bytes_5 = int_8 > 0 ? new byte[int_8 * 2] : null;

    int int_11;
    for (int_11 = 0; buffer_0.bytes[int_11 + buffer_0.offset] != 0; int_11++) {
    }

    final byte[] bytes_6 = new byte[int_11];

    int int_12;
    for (int_12 = 0; int_12 < int_11; int_12++) {
      bytes_6[int_12] = buffer_0.getByte();
    }

    ++buffer_0.offset;
    ++int_11;
    int_12 = 0;

    int int_13;
    for (int_13 = 0; int_13 < 128; int_13++) {
      int_12 += buffer_0.getUnsignedByte();
      aShortArray5[int_13] = (short) int_12;
    }

    int_12 = 0;

    for (int_13 = 0; int_13 < 128; int_13++) {
      int_12 += buffer_0.getUnsignedByte();
      aShortArray5[int_13] = (short) (aShortArray5[int_13] + (int_12 << 8));
    }

    int_13 = 0;
    int int_14 = 0;
    int int_15 = 0;

    int int_16;
    for (int_16 = 0; int_16 < 128; int_16++) {
      if (int_13 == 0) {
        if (int_14 < bytes_6.length) {
          int_13 = bytes_6[int_14++];
        } else {
          int_13 = -1;
        }

        int_15 = buffer_0.getVariableInt();
      }

      aShortArray5[int_16] = (short) (aShortArray5[int_16] + ((int_15 - 1 & 0x2) << 14));
      anIntArray82[int_16] = int_15;
      --int_13;
    }

    int_13 = 0;
    int_14 = 0;
    int_16 = 0;

    int int_17;
    for (int_17 = 0; int_17 < 128; int_17++) {
      if (anIntArray82[int_17] != 0) {
        if (int_13 == 0) {
          if (int_14 < bytes_1.length) {
            int_13 = bytes_1[int_14++];
          } else {
            int_13 = -1;
          }

          int_16 = buffer_0.bytes[int_1++] - 1;
        }

        aByteArray16[int_17] = (byte) int_16;
        --int_13;
      }
    }

    int_13 = 0;
    int_14 = 0;
    int_17 = 0;

    for (int int_18 = 0; int_18 < 128; int_18++) {
      if (anIntArray82[int_18] != 0) {
        if (int_13 == 0) {
          if (int_14 < bytes_2.length) {
            int_13 = bytes_2[int_14++];
          } else {
            int_13 = -1;
          }

          int_17 = buffer_0.bytes[int_3++] + 16 << 2;
        }

        aByteArray15[int_18] = (byte) int_17;
        --int_13;
      }
    }

    int_13 = 0;
    int_14 = 0;
    Class78 class78_1 = null;

    int int_19;
    for (int_19 = 0; int_19 < 128; int_19++) {
      if (anIntArray82[int_19] != 0) {
        if (int_13 == 0) {
          class78_1 = class78s_0[bytes_4[int_14]];
          if (int_14 < bytes_3.length) {
            int_13 = bytes_3[int_14++];
          } else {
            int_13 = -1;
          }
        }

        aClass78Array1[int_19] = class78_1;
        --int_13;
      }
    }

    int_13 = 0;
    int_14 = 0;
    int_19 = 0;

    int int_20;
    for (int_20 = 0; int_20 < 128; int_20++) {
      if (int_13 == 0) {
        if (int_14 < bytes_6.length) {
          int_13 = bytes_6[int_14++];
        } else {
          int_13 = -1;
        }

        if (anIntArray82[int_20] > 0) {
          int_19 = buffer_0.getUnsignedByte() + 1;
        }
      }

      aByteArray14[int_20] = (byte) int_19;
      --int_13;
    }

    anInt365 = buffer_0.getUnsignedByte() + 1;

    Class78 class78_2;
    int int_21;
    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.aByteArray9 != null) {
        for (int_21 = 1; int_21 < class78_2.aByteArray9.length; int_21 += 2) {
          class78_2.aByteArray9[int_21] = buffer_0.getByte();
        }
      }

      if (class78_2.aByteArray10 != null) {
        for (int_21 = 3; int_21 < class78_2.aByteArray10.length - 2; int_21 += 2) {
          class78_2.aByteArray10[int_21] = buffer_0.getByte();
        }
      }
    }

    if (bytes_7 != null) {
      for (int_20 = 1; int_20 < bytes_7.length; int_20 += 2) {
        bytes_7[int_20] = buffer_0.getByte();
      }
    }

    if (bytes_5 != null) {
      for (int_20 = 1; int_20 < bytes_5.length; int_20 += 2) {
        bytes_5[int_20] = buffer_0.getByte();
      }
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.aByteArray10 != null) {
        int_12 = 0;

        for (int_21 = 2; int_21 < class78_2.aByteArray10.length; int_21 += 2) {
          int_12 = 1 + int_12 + buffer_0.getUnsignedByte();
          class78_2.aByteArray10[int_21] = (byte) int_12;
        }
      }
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.aByteArray9 != null) {
        int_12 = 0;

        for (int_21 = 2; int_21 < class78_2.aByteArray9.length; int_21 += 2) {
          int_12 = 1 + int_12 + buffer_0.getUnsignedByte();
          class78_2.aByteArray9[int_21] = (byte) int_12;
        }
      }
    }

    byte byte_1;
    int int_22;
    int int_23;
    int int_24;
    int int_25;
    int int_26;
    int int_29;
    byte byte_3;
    if (bytes_7 != null) {
      int_12 = buffer_0.getUnsignedByte();
      bytes_7[0] = (byte) int_12;

      for (int_20 = 2; int_20 < bytes_7.length; int_20 += 2) {
        int_12 = int_12 + 1 + buffer_0.getUnsignedByte();
        bytes_7[int_20] = (byte) int_12;
      }

      byte_3 = bytes_7[0];
      byte byte_0 = bytes_7[1];

      for (int_21 = 0; int_21 < byte_3; int_21++) {
        aByteArray14[int_21] = (byte) (byte_0 * aByteArray14[int_21] + 32 >> 6);
      }

      for (int_21 = 2; int_21 < bytes_7.length; int_21 += 2) {
        byte_1 = bytes_7[int_21];
        final byte byte_2 = bytes_7[int_21 + 1];
        int_22 = byte_0 * (byte_1 - byte_3) + (byte_1 - byte_3) / 2;

        for (int_23 = byte_3; int_23 < byte_1; int_23++) {
          int_24 = byte_1 - byte_3;
          int_25 = int_22 >>> 31;
          int_26 = (int_25 + int_22) / int_24 - int_25;
          aByteArray14[int_23] = (byte) (32 + int_26 * aByteArray14[int_23] >> 6);
          int_22 += byte_2 - byte_0;
        }

        byte_3 = byte_1;
        byte_0 = byte_2;
      }

      for (int_29 = byte_3; int_29 < 128; int_29++) {
        aByteArray14[int_29] = (byte) (byte_0 * aByteArray14[int_29] + 32 >> 6);
      }

      class78_0 = null;
    }

    if (bytes_5 != null) {
      int_12 = buffer_0.getUnsignedByte();
      bytes_5[0] = (byte) int_12;

      for (int_20 = 2; int_20 < bytes_5.length; int_20 += 2) {
        int_12 = int_12 + 1 + buffer_0.getUnsignedByte();
        bytes_5[int_20] = (byte) int_12;
      }

      byte_3 = bytes_5[0];
      int int_28 = bytes_5[1] << 1;

      for (int_21 = 0; int_21 < byte_3; int_21++) {
        int_29 = int_28 + (aByteArray15[int_21] & 0xFF);
        if (int_29 < 0) {
          int_29 = 0;
        }

        if (int_29 > 128) {
          int_29 = 128;
        }

        aByteArray15[int_21] = (byte) int_29;
      }

      int int_30;
      for (int_21 = 2; int_21 < bytes_5.length; int_21 += 2) {
        byte_1 = bytes_5[int_21];
        int_30 = bytes_5[int_21 + 1] << 1;
        int_22 = int_28 * (byte_1 - byte_3) + (byte_1 - byte_3) / 2;

        for (int_23 = byte_3; int_23 < byte_1; int_23++) {
          int_24 = byte_1 - byte_3;
          int_25 = int_22 >>> 31;
          int_26 = (int_25 + int_22) / int_24 - int_25;
          int int_27 = int_26 + (aByteArray15[int_23] & 0xFF);
          if (int_27 < 0) {
            int_27 = 0;
          }

          if (int_27 > 128) {
            int_27 = 128;
          }

          aByteArray15[int_23] = (byte) int_27;
          int_22 += int_30 - int_28;
        }

        byte_3 = byte_1;
        int_28 = int_30;
      }

      for (int_29 = byte_3; int_29 < 128; int_29++) {
        int_30 = int_28 + (aByteArray15[int_29] & 0xFF);
        if (int_30 < 0) {
          int_30 = 0;
        }

        if (int_30 > 128) {
          int_30 = 128;
        }

        aByteArray15[int_29] = (byte) int_30;
      }
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78s_0[int_20].anInt175 = buffer_0.getUnsignedByte();
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.aByteArray9 != null) {
        class78_2.anInt179 = buffer_0.getUnsignedByte();
      }

      if (class78_2.aByteArray10 != null) {
        class78_2.anInt180 = buffer_0.getUnsignedByte();
      }

      if (class78_2.anInt175 > 0) {
        class78_2.anInt178 = buffer_0.getUnsignedByte();
      }
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78s_0[int_20].anInt174 = buffer_0.getUnsignedByte();
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.anInt174 > 0) {
        class78_2.anInt176 = buffer_0.getUnsignedByte();
      }
    }

    for (int_20 = 0; int_20 < int_7; int_20++) {
      class78_2 = class78s_0[int_20];
      if (class78_2.anInt176 > 0) {
        class78_2.anInt177 = buffer_0.getUnsignedByte();
      }
    }

  }

  public static boolean method677(final int int_0) {
    return int_0 >= Enum6.anEnum6_1.anInt364 && int_0 <= Enum6.anEnum6_4.anInt364
        || int_0 == Enum6.anEnum6_5.anInt364;
  }

  public static void method678(final Model model_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3) {
    Class38.aCombatInfoList1.addLast(new AClass3_Sub1(model_0, int_0, int_1, int_2, int_3));
  }

  static int getMaximum(final FormatConfig class108_0) {
    if (class108_0 == null) {
      return 12;
    }
    switch (class108_0.anInt206) {
      case 4:
        return 20;
      default:
        return 12;
    }
  }

  void method675() {
    anIntArray82 = null;
  }

  boolean method676(final Class55 class55_0, final byte[] bytes_0, final int[] ints_0) {
    boolean bool_0 = true;
    int int_0 = 0;
    AClass5_Sub1 aclass5_sub1_0 = null;

    for (int int_1 = 0; int_1 < 128; int_1++) {
      if (bytes_0 == null || bytes_0[int_1] != 0) {
        int int_2 = anIntArray82[int_1];
        if (int_2 != 0) {
          if (int_2 != int_0) {
            int_0 = int_2--;
            if ((int_2 & 0x1) == 0) {
              aclass5_sub1_0 = class55_0.method352(int_2 >> 2, ints_0);
            } else {
              aclass5_sub1_0 = class55_0.method353(int_2 >> 2, ints_0);
            }

            if (aclass5_sub1_0 == null) {
              bool_0 = false;
            }
          }

          if (aclass5_sub1_0 != null) {
            anAClass5_Sub1Array1[int_1] = aclass5_sub1_0;
            anIntArray82[int_1] = 0;
          }
        }
      }
    }

    return bool_0;
  }

}
