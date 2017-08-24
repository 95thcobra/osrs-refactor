package jagex.oldschool;

import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.util.Time;

public enum Enum6 implements MappedEnum {

  anEnum6_1(0, 0), anEnum6_2(1, 0), anEnum6_3(2, 0), anEnum6_4(3, 0), anEnum6_5(9, 2), anEnum6_6(4,
      1), anEnum6_7(5,
      1), anEnum6_8(6, 1), anEnum6_9(7, 1), anEnum6_10(8, 1), anEnum6_11(12, 2), anEnum6_12(13,
      2), anEnum6_13(14,
      2), anEnum6_14(15, 2), anEnum6_15(16, 2), anEnum6_16(17, 2), anEnum6_17(18,
      2), anEnum6_18(19, 2), anEnum6_19(20,
      2), anEnum6_20(21, 2), anEnum6_21(10, 2), anEnum6_22(11, 2), anEnum6_23(22, 3);

  public final int anInt364;

  Enum6(final int int_1, final int int_2) {
    anInt364 = int_1;
  }

  public static void method673(final int int_0) {
    if (AudioSystem.anInt168 != 0) {
      AudioSystem.anInt170 = int_0;
    } else {
      AudioSystem.anAClass4_Sub3_1.method809(int_0);
    }
  }

  public static int method674(final int int_0, final Script script_0, final boolean bool_0) {
    int int_1;
    if (int_0 == 3903) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.grandExchangeOffers[int_1].method172();
      return 1;
    }
    if (int_0 == 3904) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.grandExchangeOffers[int_1].itemId;
      return 1;
    }
    if (int_0 == 3905) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.grandExchangeOffers[int_1].price;
      return 1;
    }
    if (int_0 == 3906) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize
          - 1] = Client.grandExchangeOffers[int_1].totalQuantity;
      return 1;
    }
    if (int_0 == 3907) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.grandExchangeOffers[int_1].quantitySold;
      return 1;
    }
    if (int_0 == 3908) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.grandExchangeOffers[int_1].spent;
      return 1;
    }
    int int_5;
    if (int_0 == 3910) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      int_5 = Client.grandExchangeOffers[int_1].method173();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_5 == 0 ? 1 : 0;
      return 1;
    }
    if (int_0 == 3911) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      int_5 = Client.grandExchangeOffers[int_1].method173();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_5 == 2 ? 1 : 0;
      return 1;
    }
    if (int_0 == 3912) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      int_5 = Client.grandExchangeOffers[int_1].method173();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_5 == 5 ? 1 : 0;
      return 1;
    }
    if (int_0 == 3913) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      int_5 = Client.grandExchangeOffers[int_1].method173();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_5 == 1 ? 1 : 0;
      return 1;
    }
    boolean bool_2;
    if (int_0 == 3914) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      if (Class22.aClass45_1 != null) {
        Class22.aClass45_1.method286(Class45.aComparator3, bool_2);
      }

      return 1;
    }
    if (int_0 == 3915) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      if (Class22.aClass45_1 != null) {
        Class22.aClass45_1.method286(Class45.aComparator2, bool_2);
      }

      return 1;
    }
    if (int_0 == 3916) {
      ScriptExecutor.intStackSize -= 2;
      bool_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize] == 1;
      final boolean bool_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1] == 1;
      if (Class22.aClass45_1 != null) {
        Class22.aClass45_1.method286(new Class27(bool_1), bool_2);
      }

      return 1;
    }
    if (int_0 == 3917) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      if (Class22.aClass45_1 != null) {
        Class22.aClass45_1.method286(Class45.aComparator1, bool_2);
      }

      return 1;
    }
    if (int_0 == 3918) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      if (Class22.aClass45_1 != null) {
        Class22.aClass45_1.method286(Class45.aComparator4, bool_2);
      }

      return 1;
    }
    if (int_0 == 3919) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class22.aClass45_1 == null ? 0
          : Class22.aClass45_1.aList3.size();
      return 1;
    }
    Class44 class44_0;
    if (int_0 == 3920) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class44_0.anInt95;
      return 1;
    }
    if (int_0 == 3921) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = class44_0.method282();
      return 1;
    }
    if (int_0 == 3922) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = class44_0.method283();
      return 1;
    }
    if (int_0 == 3923) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      final long long_0 = Time.currentTimeMillis() - Class10.aLong1 - class44_0.aLong2;
      final int int_2 = (int) (long_0 / 3600000L);
      final int int_3 = (int) ((long_0 - int_2 * 3600000) / 60000L);
      final int int_4 = (int) ((long_0 - int_2 * 3600000 - int_3 * 60000) / 1000L);
      final String string_0 = int_2 + ":" + int_3 / 10 + int_3 % 10 + ":" + int_4 / 10
          + int_4 % 10;
      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_0;
      return 1;
    }
    if (int_0 == 3924) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class44_0.aGrandExchangeOffer1.totalQuantity;
      return 1;
    }
    if (int_0 == 3925) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class44_0.aGrandExchangeOffer1.price;
      return 1;
    }
    if (int_0 == 3926) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      class44_0 = (Class44) Class22.aClass45_1.aList3.get(int_1);
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class44_0.aGrandExchangeOffer1.itemId;
      return 1;
    }
    return 2;
  }

  @Override
  public int mappedOrdinal() {
    return anInt364;
  }

}
