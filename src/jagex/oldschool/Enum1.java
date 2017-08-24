package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.config.BitVariableConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.script.Script;
import jagex.oldschool.social.Ignore;

public enum Enum1 implements MappedEnum {

  anEnum1_1(1, (byte) 0), anEnum1_2(2, (byte) 1), anEnum1_3(0, (byte) 2), anEnum1_4(3, (byte) 3);

  static DirectSprite[] hitmarks;
  public static Client clientInstance;
  final int anInt298;
  final byte aByte3;

  Enum1(final int int_1, final byte byte_0) {
    anInt298 = int_1;
    aByte3 = byte_0;
  }

  static void method600(final int int_0) {
    Class56.anIntArray35[++Class56.anInt142 - 1] = int_0;
  }

  static boolean method601(final byte[] bytes_0, final int int_0, final int int_1) {
    boolean bool_0 = true;
    final Buffer buffer_0 = new Buffer(bytes_0);
    int int_2 = -1;

    label70:
    while (true) {
      final int int_3 = buffer_0.getUnsignedSmartShort();
      if (int_3 == 0) {
        return bool_0;
      }

      int_2 += int_3;
      int int_4 = 0;
      boolean bool_1 = false;

      while (true) {
        int int_5;
        while (!bool_1) {
          int_5 = buffer_0.getUnsignedSmartShort();
          if (int_5 == 0) {
            continue label70;
          }

          int_4 += int_5 - 1;
          final int int_6 = int_4 & 0x3F;
          final int int_7 = int_4 >> 6 & 0x3F;
          final int int_8 = buffer_0.getUnsignedByte() >> 2;
          final int int_9 = int_7 + int_0;
          final int int_10 = int_6 + int_1;
          if (int_9 > 0 && int_10 > 0 && int_9 < 103 && int_10 < 103) {
            final ObjectConfig objectcomposition_0 = Class2.getObjectConfig(int_2);
            if (int_8 != 22 || !Client.lowMemory || objectcomposition_0.anInt454 != 0
                || objectcomposition_0.interactType == 1 || objectcomposition_0.aBool56) {
              if (!objectcomposition_0.method821()) {
                ++Client.anInt621;
                bool_0 = false;
              }

              bool_1 = true;
            }
          }
        }

        int_5 = buffer_0.getUnsignedSmartShort();
        if (int_5 == 0) {
          break;
        }

        buffer_0.getUnsignedByte();
      }
    }
  }

  public static boolean isIgnored(final String string_0) {
    if (string_0 == null) {
      return false;
    }
    final String string_1 = FloorUnderlayDefinition.format(string_0, AClass1_Sub2.aClass108_10);

    for (int int_0 = 0; int_0 < Client.ignoreCount; int_0++) {
      final Ignore ignore_0 = Client.ignores[int_0];
      if (string_1.equalsIgnoreCase(
          FloorUnderlayDefinition.format(ignore_0.name, AClass1_Sub2.aClass108_10))) {
        return true;
      }

      if (string_1.equalsIgnoreCase(
          FloorUnderlayDefinition.format(ignore_0.previousName, AClass1_Sub2.aClass108_10))) {
        return true;
      }
    }

    return false;
  }

  public static void method602(final AbstractPackage indexdatabase_0) {
    CacheableNode_Sub5.anIndexDataBase28 = indexdatabase_0;
  }

  public static void method603(final int int_0, int int_1) {
    BitVariableConfig varbit_0 = (BitVariableConfig) BitVariableConfig.configs.get(int_0);
    BitVariableConfig varbit_1;
    if (varbit_0 != null) {
      varbit_1 = varbit_0;
    } else {
      final byte[] bytes_0 = BitVariableConfig.configPackage.get(14, int_0);
      varbit_0 = new BitVariableConfig();
      if (bytes_0 != null) {
        varbit_0.parse(new Buffer(bytes_0));
      }

      BitVariableConfig.configs.put(varbit_0, int_0);
      varbit_1 = varbit_0;
    }

    final int int_2 = varbit_1.mappedId;
    final int int_3 = varbit_1.lowBit;
    final int int_4 = varbit_1.highBit;
    int int_5 = Variables.MASKS[int_4 - int_3];
    if (int_1 < 0 || int_1 > int_5) {
      int_1 = 0;
    }

    int_5 <<= int_3;
    Variables.widgetSettings[int_2] =
        Variables.widgetSettings[int_2] & ~int_5 | int_1 << int_3 & int_5;
  }

  static Script method604(final byte[] bytes_0) {
    final Script script_0 = new Script();
    final Buffer buffer_0 = new Buffer(bytes_0);
    buffer_0.offset = buffer_0.bytes.length - 2;
    final int int_0 = buffer_0.getUnsignedShort();
    final int int_1 = buffer_0.bytes.length - 2 - int_0 - 12;
    buffer_0.offset = int_1;
    final int int_2 = buffer_0.getInt();
    script_0.localIntCount = buffer_0.getUnsignedShort();
    script_0.localStringCount = buffer_0.getUnsignedShort();
    script_0.intStackCount = buffer_0.getUnsignedShort();
    script_0.stringStackCount = buffer_0.getUnsignedShort();
    final int int_3 = buffer_0.getUnsignedByte();
    int int_4;
    int int_5;
    if (int_3 > 0) {
      script_0.switches = script_0.method870(int_3);

      for (int_4 = 0; int_4 < int_3; int_4++) {
        int_5 = buffer_0.getUnsignedShort();
        final IterableHashTable iterablehashtable_0 = new IterableHashTable(
            FileCache.method72(int_5));
        script_0.switches[int_4] = iterablehashtable_0;

        while (int_5-- > 0) {
          final int int_6 = buffer_0.getInt();
          final int int_7 = buffer_0.getInt();
          iterablehashtable_0.put(new IntegerNode(int_7), int_6);
        }
      }
    }

    buffer_0.offset = 0;
    buffer_0.getNullableString();
    script_0.instructions = new int[int_2];
    script_0.intOperands = new int[int_2];
    script_0.stringOperands = new String[int_2];

    for (int_4 = 0; buffer_0.offset < int_1; script_0.instructions[int_4++] = int_5) {
      int_5 = buffer_0.getUnsignedShort();
      if (int_5 == 3) {
        script_0.stringOperands[int_4] = buffer_0.getString();
      } else if (int_5 < 100 && int_5 != 21 && int_5 != 38 && int_5 != 39) {
        script_0.intOperands[int_4] = buffer_0.getInt();
      } else {
        script_0.intOperands[int_4] = buffer_0.getUnsignedByte();
      }
    }

    return script_0;
  }

  @Override
  public int mappedOrdinal() {
    return aByte3;
  }

}
