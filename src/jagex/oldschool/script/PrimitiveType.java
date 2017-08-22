package jagex.oldschool.script;

import jagex.oldschool.Class85;
import jagex.oldschool.Client;
import jagex.oldschool.Interface1;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.MappedEnum;
import jagex.oldschool.config.BitVariableConfig;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.Buffer;

public enum PrimitiveType implements MappedEnum {

  INTEGER(0, 0, Integer.class, new IntegerVariable()),
  LONG(1, 1, Long.class, new LongVariable()),
  STRING(2, 2, String.class, new StringVariable());

  public static boolean[] validInterfaces;
  public static int[] anIntArray78;
  public static IndexedSprite[] anIndexedSpriteArray7;
  final int anInt319;
  final int id;

  PrimitiveType(final int int_1, final int int_2, final Class cls, final Interface1 interface1_0) {
    anInt319 = int_1;
    id = int_2;
  }

  public static int method629(final int int_0) {
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

    final int int_1 = varbit_1.mappedId;
    final int int_2 = varbit_1.lowBit;
    final int int_3 = varbit_1.highBit;
    final int int_4 = Class85.anIntArray45[int_3 - int_2];
    return Class85.widgetSettings[int_1] >> int_2 & int_4;
  }

  public static boolean method630(final CharSequence charsequence_0, final int int_0,
      final boolean bool_0) {
    if (int_0 >= 2 && int_0 <= 36) {
      boolean bool_1 = false;
      boolean bool_2 = false;
      int int_1 = 0;
      final int int_2 = charsequence_0.length();

      for (int int_3 = 0; int_3 < int_2; int_3++) {
        final char char_0 = charsequence_0.charAt(int_3);
        if (int_3 == 0) {
          if (char_0 == 45) {
            bool_1 = true;
            continue;
          }

          if (char_0 == 43) {
            continue;
          }
        }

        int int_5;
        if (char_0 >= 48 && char_0 <= 57) {
          int_5 = char_0 - 48;
        } else if (char_0 >= 65 && char_0 <= 90) {
          int_5 = char_0 - 55;
        } else {
          if (char_0 < 97 || char_0 > 122) {
            return false;
          }

          int_5 = char_0 - 87;
        }

        if (int_5 >= int_0) {
          return false;
        }

        if (bool_1) {
          int_5 = -int_5;
        }

        final int int_4 = int_1 * int_0 + int_5;
        if (int_4 / int_0 != int_1) {
          return false;
        }

        int_1 = int_4;
        bool_2 = true;
      }

      return bool_2;
    }
    throw new IllegalArgumentException("");
  }

  public static void method631(final InterfaceComponent widget_0) {
    final int int_0 = widget_0.contentType;
    if (int_0 == 324) {
      if (Client.anInt638 == -1) {
        Client.anInt638 = widget_0.spriteId;
        Client.anInt640 = widget_0.anInt258 * -1;
      }

      if (Client.aPlayerComposition1.isFemale) {
        widget_0.spriteId = Client.anInt638;
      } else {
        widget_0.spriteId = Client.anInt640 * -1;
      }
    } else if (int_0 == 325) {
      if (Client.anInt638 == -1) {
        Client.anInt638 = widget_0.spriteId;
        Client.anInt640 = widget_0.anInt258 * -1;
      }

      if (Client.aPlayerComposition1.isFemale) {
        widget_0.spriteId = Client.anInt640 * -1;
      } else {
        widget_0.spriteId = Client.anInt638;
      }
    } else if (int_0 == 327) {
      widget_0.rotationX = 150;
      widget_0.rotationZ = (int) (Math.sin(Client.tick / 40.0D) * 256.0D) & 0x7FF;
      widget_0.modelType = 5;
      widget_0.modelId = 0;
    } else if (int_0 == 328) {
      widget_0.rotationX = 150;
      widget_0.rotationZ = (int) (Math.sin(Client.tick / 40.0D) * 256.0D) & 0x7FF;
      widget_0.modelType = 5;
      widget_0.modelId = 1;
    }
  }

  @Override
  public int mappedOrdinal() {
    return id;
  }

}
