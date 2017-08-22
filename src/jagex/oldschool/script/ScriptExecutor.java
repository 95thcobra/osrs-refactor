package jagex.oldschool.script;

import jagex.oldschool.Area;
import jagex.oldschool.Boundry;
import jagex.oldschool.Class19;
import jagex.oldschool.Class26;
import jagex.oldschool.Class31;
import jagex.oldschool.Class35;
import jagex.oldschool.Class85;
import jagex.oldschool.DecorativeObject;
import jagex.oldschool.Enum1;
import jagex.oldschool.Ignore;
import jagex.oldschool.LocalInstall;
import jagex.oldschool.Preferences;
import jagex.oldschool.ScriptArguments;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.collections.IterableHashTable;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Time;
import java.util.Calendar;

public class ScriptExecutor {

  public static final String[] MONTHS;
  public static int[] anIntArray13;
  public static int[][] SHAPE_VERTICES;
  public static Class19 aClass19_1;
  public static int[] intStack;
  public static String[] scriptStringStack;
  public static int scriptStackCount;
  public static ScriptState[] scriptStack;
  public static Calendar aCalendar1;
  public static AbstractSourceLine soundSystem0;
  public static int anInt83;
  public static int intStackSize;
  public static int[] scriptLocalInts;
  public static String[] scriptLocalStrings;
  public static byte clanChatRank;

  static {
    anIntArray13 = new int[5];
    SHAPE_VERTICES = new int[5][5000];
    intStack = new int[1000];
    scriptStringStack = new String[1000];
    scriptStackCount = 0;
    scriptStack = new ScriptState[50];
    aCalendar1 = Calendar.getInstance();
    MONTHS = new String[] {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
        "Dec"
    };
    anInt83 = 0;
  }

  public static InterfaceComponent method240(final int int_0) {
    final int int_1 = int_0 >> 16;
    final int int_2 = int_0 & 0xFFFF;
    if (Time.widgets[int_1] == null || Time.widgets[int_1][int_2] == null) {
      final boolean bool_0 = Ignore.loadWidget(int_1);
      if (!bool_0) {
        return null;
      }
    }

    return Time.widgets[int_1][int_2];
  }

  public static int method242(final CharSequence charsequence_0, final CharSequence charsequence_1,
      final int int_0) {
    final int int_1 = charsequence_0.length();
    final int int_2 = charsequence_1.length();
    int int_3 = 0;
    int int_4 = 0;
    char char_0 = 0;
    char char_1 = 0;

    while (int_3 - char_0 < int_1 || int_4 - char_1 < int_2) {
      if (int_3 - char_0 >= int_1) {
        return -1;
      }

      if (int_4 - char_1 >= int_2) {
        return 1;
      }

      char char_2;
      if (char_0 != 0) {
        char_2 = char_0;
      } else {
        char_2 = charsequence_0.charAt(int_3++);
      }

      char char_3;
      if (char_1 != 0) {
        char_3 = char_1;
      } else {
        char_3 = charsequence_1.charAt(int_4++);
      }

      char_0 = DerivedType.method482(char_2);
      char_1 = DerivedType.method482(char_3);
      char_2 = Ignore.method538(char_2, int_0);
      char_3 = Ignore.method538(char_3, int_0);
      if (char_3 != char_2 && Character.toUpperCase(char_2) != Character.toUpperCase(char_3)) {
        char_2 = Character.toLowerCase(char_2);
        char_3 = Character.toLowerCase(char_3);
        if (char_2 != char_3) {
          return DecorativeObject.method480(char_2, int_0) - DecorativeObject
              .method480(char_3, int_0);
        }
      }
    }

    final int int_5 = Math.min(int_1, int_2);

    char char_5;
    int int_6;
    for (int_6 = 0; int_6 < int_5; int_6++) {
      char char_4 = charsequence_0.charAt(int_6);
      char_5 = charsequence_1.charAt(int_6);
      if (char_4 != char_5 && Character.toUpperCase(char_4) != Character.toUpperCase(char_5)) {
        char_4 = Character.toLowerCase(char_4);
        char_5 = Character.toLowerCase(char_5);
        if (char_4 != char_5) {
          return DecorativeObject.method480(char_4, int_0) - DecorativeObject
              .method480(char_5, int_0);
        }
      }
    }

    int_6 = int_1 - int_2;
    if (int_6 != 0) {
      return int_6;
    }
    for (int int_7 = 0; int_7 < int_5; int_7++) {
      char_5 = charsequence_0.charAt(int_7);
      final char char_6 = charsequence_1.charAt(int_7);
      if (char_6 != char_5) {
        return DecorativeObject.method480(char_5, int_0) - DecorativeObject
            .method480(char_6, int_0);
      }
    }

    return 0;
  }

  public static void execute(final ScriptCall scriptevent_0, final int int_0) {
    final Object[] objects_0 = scriptevent_0.anObjectArray22;
    final ScriptArguments class83_0 = scriptevent_0.aClass83_11;
    final boolean bool_0 = class83_0 == ScriptArguments.aClass83_1 || class83_0 == ScriptArguments.aClass83_3
        || class83_0 == ScriptArguments.aClass83_5 || class83_0 == ScriptArguments.aClass83_6
        || class83_0 == ScriptArguments.aClass83_4 || class83_0 == ScriptArguments.aClass83_7
        || class83_0 == ScriptArguments.aClass83_8 || class83_0 == ScriptArguments.aClass83_9;
    Script script_0;
    int int_1;
    if (bool_0) {
      AudioWorker.aClass9_1 = (Boundry) objects_0[0];
      final Area area_0 = Area.anAreaArray1[AudioWorker.aClass9_1.anInt49];
      script_0 = Class31.method244(scriptevent_0.aClass83_11, area_0.anInt432, area_0.anInt438);
    } else {
      int_1 = ((Integer) objects_0[0]).intValue();
      script_0 = Preferences.method425(int_1);
    }

    if (script_0 != null) {
      intStackSize = 0;
      Class26.scriptStringStackSize = 0;
      int_1 = -1;
      int[] ints_0 = script_0.instructions;
      int[] ints_1 = script_0.intOperands;
      final byte byte_0 = -1;
      scriptStackCount = 0;

      int int_4;
      try {
        scriptLocalInts = new int[script_0.localIntCount];
        int int_2 = 0;
        scriptLocalStrings = new String[script_0.localStringCount];
        int int_3 = 0;

        int int_5;
        String string_0;
        for (int_4 = 1; int_4 < objects_0.length; int_4++) {
          if (objects_0[int_4] instanceof Integer) {
            int_5 = ((Integer) objects_0[int_4]).intValue();
            if (int_5 == -2147483647) {
              int_5 = scriptevent_0.anInt380;
            }

            if (int_5 == -2147483646) {
              int_5 = scriptevent_0.anInt381;
            }

            if (int_5 == -2147483645) {
              int_5 = scriptevent_0.widget != null ? scriptevent_0.widget.id : -1;
            }

            if (int_5 == -2147483644) {
              int_5 = scriptevent_0.anInt383;
            }

            if (int_5 == -2147483643) {
              int_5 = scriptevent_0.widget != null ? scriptevent_0.widget.index : -1;
            }

            if (int_5 == -2147483642) {
              int_5 = scriptevent_0.aWidget8 != null ? scriptevent_0.aWidget8.id : -1;
            }

            if (int_5 == -2147483641) {
              int_5 = scriptevent_0.aWidget8 != null ? scriptevent_0.aWidget8.index : -1;
            }

            if (int_5 == -2147483640) {
              int_5 = scriptevent_0.anInt384;
            }

            if (int_5 == -2147483639) {
              int_5 = scriptevent_0.anInt385;
            }

            scriptLocalInts[int_2++] = int_5;
          } else if (objects_0[int_4] instanceof String) {
            string_0 = (String) objects_0[int_4];
            if (string_0.equals("event_opbase")) {
              string_0 = scriptevent_0.aString27;
            }

            scriptLocalStrings[int_3++] = string_0;
          }
        }

        int_4 = 0;
        anInt83 = scriptevent_0.anInt382;

        while (true) {
          while (true) {
            while (true) {
              while (true) {
                while (true) {
                  while (true) {
                    while (true) {
                      while (true) {
                        while (true) {
                          while (true) {
                            while (true) {
                              while (true) {
                                while (true) {
                                  while (true) {
                                    while (true) {
                                      while (true) {
                                        while (true) {
                                          while (true) {
                                            while (true) {
                                              while (true) {
                                                while (true) {
                                                  while (true) {
                                                    while (true) {
                                                      while (true) {
                                                        while (true) {
                                                          label339:
                                                          while (true) {
                                                            ++int_4;
                                                            if (int_4 > int_0) {
                                                              throw new RuntimeException();
                                                            }

                                                            ++int_1;
                                                            final int int_13 = ints_0[int_1];
                                                            int int_6;
                                                            if (int_13 < 100) {
                                                              if (int_13 != 0) {
                                                                if (int_13 != 1) {
                                                                  if (int_13 != 2) {
                                                                    if (int_13 != 3) {
                                                                      if (int_13 != 6) {
                                                                        if (int_13 != 7) {
                                                                          if (int_13 != 8) {
                                                                            if (int_13 != 9) {
                                                                              if (int_13 != 10) {
                                                                                if (int_13 != 21) {
                                                                                  if (int_13
                                                                                      != 25) {
                                                                                    if (int_13
                                                                                        != 27) {
                                                                                      if (int_13
                                                                                          != 31) {
                                                                                        if (int_13
                                                                                            != 32) {
                                                                                          if (int_13
                                                                                              != 33) {
                                                                                            if (int_13
                                                                                                != 34) {
                                                                                              if (int_13
                                                                                                  != 35) {
                                                                                                if (int_13
                                                                                                    != 36) {
                                                                                                  int int_8;
                                                                                                  if (int_13
                                                                                                      != 37) {
                                                                                                    if (int_13
                                                                                                        != 38) {
                                                                                                      if (int_13
                                                                                                          != 39) {
                                                                                                        if (int_13
                                                                                                            != 40) {
                                                                                                          if (int_13
                                                                                                              != 42) {
                                                                                                            if (int_13
                                                                                                                != 43) {
                                                                                                              if (int_13
                                                                                                                  == 44) {
                                                                                                                int_5 =
                                                                                                                    ints_1[int_1]
                                                                                                                        >> 16;
                                                                                                                int_6 =
                                                                                                                    ints_1[int_1]
                                                                                                                        & 0xFFFF;
                                                                                                                final int int_12 = intStack[--intStackSize];
                                                                                                                if (int_12
                                                                                                                    >= 0
                                                                                                                    &&
                                                                                                                    int_12
                                                                                                                        <= 5000) {
                                                                                                                  anIntArray13[int_5] = int_12;
                                                                                                                  byte byte_1 = -1;
                                                                                                                  if (int_6
                                                                                                                      == 105) {
                                                                                                                    byte_1 = 0;
                                                                                                                  }

                                                                                                                  int_8 = 0;

                                                                                                                  while (true) {
                                                                                                                    if (int_8
                                                                                                                        >= int_12) {
                                                                                                                      continue label339;
                                                                                                                    }

                                                                                                                    SHAPE_VERTICES[int_5][int_8] = byte_1;
                                                                                                                    ++int_8;
                                                                                                                  }
                                                                                                                }

                                                                                                                throw new RuntimeException();
                                                                                                              }
                                                                                                              if (int_13
                                                                                                                  == 45) {
                                                                                                                int_5 = ints_1[int_1];
                                                                                                                int_6 = intStack[--intStackSize];
                                                                                                                if (int_6
                                                                                                                    < 0
                                                                                                                    ||
                                                                                                                    int_6
                                                                                                                        >= anIntArray13[int_5]) {
                                                                                                                  throw new RuntimeException();
                                                                                                                }

                                                                                                                intStack[
                                                                                                                    ++intStackSize
                                                                                                                        - 1] = SHAPE_VERTICES[int_5][int_6];
                                                                                                              } else if (
                                                                                                                  int_13
                                                                                                                      == 46) {
                                                                                                                int_5 = ints_1[int_1];
                                                                                                                intStackSize -= 2;
                                                                                                                int_6 = intStack[intStackSize];
                                                                                                                if (int_6
                                                                                                                    < 0
                                                                                                                    ||
                                                                                                                    int_6
                                                                                                                        >= anIntArray13[int_5]) {
                                                                                                                  throw new RuntimeException();
                                                                                                                }

                                                                                                                SHAPE_VERTICES[int_5][int_6] = intStack[
                                                                                                                    intStackSize
                                                                                                                        + 1];
                                                                                                              } else if (
                                                                                                                  int_13
                                                                                                                      == 47) {
                                                                                                                string_0 = LocalInstall.chatMessages
                                                                                                                    .getVarcString(
                                                                                                                        ints_1[int_1]);
                                                                                                                if (string_0
                                                                                                                    == null) {
                                                                                                                  string_0 = "null";
                                                                                                                }

                                                                                                                scriptStringStack[
                                                                                                                    ++Class26.scriptStringStackSize
                                                                                                                        - 1] = string_0;
                                                                                                              } else if (
                                                                                                                  int_13
                                                                                                                      == 48) {
                                                                                                                LocalInstall.chatMessages
                                                                                                                    .putVarcString(
                                                                                                                        ints_1[int_1],
                                                                                                                        scriptStringStack[--Class26.scriptStringStackSize]);
                                                                                                              } else {
                                                                                                                if (int_13
                                                                                                                    != 60) {
                                                                                                                  throw new IllegalStateException();
                                                                                                                }

                                                                                                                final IterableHashTable iterablehashtable_0 = script_0.switches[ints_1[int_1]];
                                                                                                                final IntegerNode integernode_0 = (IntegerNode) iterablehashtable_0
                                                                                                                    .get(
                                                                                                                        intStack[--intStackSize]);
                                                                                                                if (integernode_0
                                                                                                                    != null) {
                                                                                                                  int_1 += integernode_0.value;
                                                                                                                }
                                                                                                              }
                                                                                                            } else {
                                                                                                              LocalInstall.chatMessages
                                                                                                                  .putVarc(
                                                                                                                      ints_1[int_1],
                                                                                                                      intStack[--intStackSize]);
                                                                                                            }
                                                                                                          } else {
                                                                                                            intStack[
                                                                                                                ++intStackSize
                                                                                                                    - 1] = LocalInstall.chatMessages
                                                                                                                .getVarc(
                                                                                                                    ints_1[int_1]);
                                                                                                          }
                                                                                                        } else {
                                                                                                          int_5 = ints_1[int_1];
                                                                                                          final Script script_1 = Preferences
                                                                                                              .method425(
                                                                                                                  int_5);
                                                                                                          final int[] ints_2 = new int[script_1.localIntCount];
                                                                                                          final String[] strings_1 = new String[script_1.localStringCount];

                                                                                                          for (
                                                                                                              int_8 = 0;
                                                                                                              int_8
                                                                                                                  < script_1.intStackCount;
                                                                                                              int_8++) {
                                                                                                            ints_2[int_8] = intStack[
                                                                                                                int_8
                                                                                                                    +
                                                                                                                    intStackSize
                                                                                                                        - script_1.intStackCount];
                                                                                                          }

                                                                                                          for (
                                                                                                              int_8 = 0;
                                                                                                              int_8
                                                                                                                  < script_1.stringStackCount;
                                                                                                              int_8++) {
                                                                                                            strings_1[int_8] = scriptStringStack[
                                                                                                                int_8
                                                                                                                    +
                                                                                                                    Class26.scriptStringStackSize
                                                                                                                        - script_1.stringStackCount];
                                                                                                          }

                                                                                                          intStackSize -= script_1.intStackCount;
                                                                                                          Class26.scriptStringStackSize -= script_1.stringStackCount;
                                                                                                          final ScriptState scriptstate_1 = new ScriptState();
                                                                                                          scriptstate_1.invokedFromScript = script_0;
                                                                                                          scriptstate_1.invokedFromPc = int_1;
                                                                                                          scriptstate_1.savedLocalInts = scriptLocalInts;
                                                                                                          scriptstate_1.savedLocalStrings = scriptLocalStrings;
                                                                                                          scriptStack[
                                                                                                              ++scriptStackCount
                                                                                                                  - 1] = scriptstate_1;
                                                                                                          script_0 = script_1;
                                                                                                          ints_0 = script_1.instructions;
                                                                                                          ints_1 = script_1.intOperands;
                                                                                                          int_1 = -1;
                                                                                                          scriptLocalInts = ints_2;
                                                                                                          scriptLocalStrings = strings_1;
                                                                                                        }
                                                                                                      } else {
                                                                                                        --Class26.scriptStringStackSize;
                                                                                                      }
                                                                                                    } else {
                                                                                                      --intStackSize;
                                                                                                    }
                                                                                                  } else {
                                                                                                    int_5 = ints_1[int_1];
                                                                                                    Class26.scriptStringStackSize -= int_5;
                                                                                                    final String[] strings_0 = scriptStringStack;
                                                                                                    final int int_7 = Class26.scriptStringStackSize;
                                                                                                    String string_1;
                                                                                                    if (int_5
                                                                                                        == 0) {
                                                                                                      string_1 = "";
                                                                                                    } else if (
                                                                                                        int_5
                                                                                                            == 1) {
                                                                                                      final String string_2 = strings_0[int_7];
                                                                                                      if (string_2
                                                                                                          == null) {
                                                                                                        string_1 = "null";
                                                                                                      } else {
                                                                                                        string_1 = string_2
                                                                                                            .toString();
                                                                                                      }
                                                                                                    } else {
                                                                                                      int_8 =
                                                                                                          int_7
                                                                                                              + int_5;
                                                                                                      int int_9 = 0;

                                                                                                      for (
                                                                                                          int int_10 = int_7;
                                                                                                          int_10
                                                                                                              < int_8;
                                                                                                          int_10++) {
                                                                                                        final String string_3 = strings_0[int_10];
                                                                                                        if (string_3
                                                                                                            == null) {
                                                                                                          int_9 += 4;
                                                                                                        } else {
                                                                                                          int_9 += string_3
                                                                                                              .length();
                                                                                                        }
                                                                                                      }

                                                                                                      final StringBuilder stringbuilder_0 = new StringBuilder(
                                                                                                          int_9);

                                                                                                      for (
                                                                                                          int int_11 = int_7;
                                                                                                          int_11
                                                                                                              < int_8;
                                                                                                          int_11++) {
                                                                                                        final String string_4 = strings_0[int_11];
                                                                                                        if (string_4
                                                                                                            == null) {
                                                                                                          stringbuilder_0
                                                                                                              .append(
                                                                                                                  "null");
                                                                                                        } else {
                                                                                                          stringbuilder_0
                                                                                                              .append(
                                                                                                                  string_4);
                                                                                                        }
                                                                                                      }

                                                                                                      string_1 = stringbuilder_0
                                                                                                          .toString();
                                                                                                    }

                                                                                                    scriptStringStack[
                                                                                                        ++Class26.scriptStringStackSize
                                                                                                            - 1] = string_1;
                                                                                                  }
                                                                                                } else {
                                                                                                  scriptLocalStrings[ints_1[int_1]] = scriptStringStack[--Class26.scriptStringStackSize];
                                                                                                }
                                                                                              } else {
                                                                                                scriptStringStack[
                                                                                                    ++Class26.scriptStringStackSize
                                                                                                        - 1] = scriptLocalStrings[ints_1[int_1]];
                                                                                              }
                                                                                            } else {
                                                                                              scriptLocalInts[ints_1[int_1]] = intStack[--intStackSize];
                                                                                            }
                                                                                          } else {
                                                                                            intStack[
                                                                                                ++intStackSize
                                                                                                    - 1] = scriptLocalInts[ints_1[int_1]];
                                                                                          }
                                                                                        } else {
                                                                                          intStackSize -= 2;
                                                                                          if (intStack[intStackSize]
                                                                                              >= intStack[
                                                                                              intStackSize
                                                                                                  + 1]) {
                                                                                            int_1 += ints_1[int_1];
                                                                                          }
                                                                                        }
                                                                                      } else {
                                                                                        intStackSize -= 2;
                                                                                        if (intStack[intStackSize]
                                                                                            <= intStack[
                                                                                            intStackSize
                                                                                                + 1]) {
                                                                                          int_1 += ints_1[int_1];
                                                                                        }
                                                                                      }
                                                                                    } else {
                                                                                      int_5 = ints_1[int_1];
                                                                                      Enum1
                                                                                          .method603(
                                                                                              int_5,
                                                                                              intStack[--intStackSize]);
                                                                                    }
                                                                                  } else {
                                                                                    int_5 = ints_1[int_1];
                                                                                    intStack[
                                                                                        ++intStackSize
                                                                                            - 1] = PrimitiveType
                                                                                        .method629(
                                                                                            int_5);
                                                                                  }
                                                                                } else {
                                                                                  if (scriptStackCount
                                                                                      == 0) {
                                                                                    return;
                                                                                  }

                                                                                  final ScriptState scriptstate_0 = scriptStack[--scriptStackCount];
                                                                                  script_0 = scriptstate_0.invokedFromScript;
                                                                                  ints_0 = script_0.instructions;
                                                                                  ints_1 = script_0.intOperands;
                                                                                  int_1 = scriptstate_0.invokedFromPc;
                                                                                  scriptLocalInts = scriptstate_0.savedLocalInts;
                                                                                  scriptLocalStrings = scriptstate_0.savedLocalStrings;
                                                                                }
                                                                              } else {
                                                                                intStackSize -= 2;
                                                                                if (intStack[intStackSize]
                                                                                    > intStack[
                                                                                    intStackSize
                                                                                        + 1]) {
                                                                                  int_1 += ints_1[int_1];
                                                                                }
                                                                              }
                                                                            } else {
                                                                              intStackSize -= 2;
                                                                              if (intStack[intStackSize]
                                                                                  < intStack[
                                                                                  intStackSize
                                                                                      + 1]) {
                                                                                int_1 += ints_1[int_1];
                                                                              }
                                                                            }
                                                                          } else {
                                                                            intStackSize -= 2;
                                                                            if (intStack[intStackSize]
                                                                                == intStack[
                                                                                intStackSize
                                                                                    + 1]) {
                                                                              int_1 += ints_1[int_1];
                                                                            }
                                                                          }
                                                                        } else {
                                                                          intStackSize -= 2;
                                                                          if (intStack[intStackSize]
                                                                              != intStack[
                                                                              intStackSize
                                                                                  + 1]) {
                                                                            int_1 += ints_1[int_1];
                                                                          }
                                                                        }
                                                                      } else {
                                                                        int_1 += ints_1[int_1];
                                                                      }
                                                                    } else {
                                                                      scriptStringStack[
                                                                          ++Class26.scriptStringStackSize
                                                                              - 1] = script_0.stringOperands[int_1];
                                                                    }
                                                                  } else {
                                                                    int_5 = ints_1[int_1];
                                                                    Class85.widgetSettings[int_5] = intStack[--intStackSize];
                                                                    Class35.method255(
                                                                        int_5);
                                                                  }
                                                                } else {
                                                                  int_5 = ints_1[int_1];
                                                                  intStack[
                                                                      ++intStackSize
                                                                          - 1] = Class85.widgetSettings[int_5];
                                                                }
                                                              } else {
                                                                intStack[
                                                                    ++intStackSize
                                                                        - 1] = ints_1[int_1];
                                                              }
                                                            } else {
                                                              boolean bool_1;
                                                              if (script_0.intOperands[int_1]
                                                                  == 1) {
                                                                bool_1 = true;
                                                              } else {
                                                                bool_1 = false;
                                                              }

                                                              int_6 = PlayerVariable
                                                                  .method907(
                                                                      int_13,
                                                                      script_0,
                                                                      bool_1);
                                                              switch (int_6) {
                                                                case 0:
                                                                  return;
                                                                case 1:
                                                                default:
                                                                  break;
                                                                case 2:
                                                                  throw new IllegalStateException();
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } catch (final Exception exception_0) {
        final StringBuilder stringbuilder_1 = new StringBuilder(30);
        stringbuilder_1.append("").append(script_0.hash).append(" ");

        for (int_4 = scriptStackCount - 1; int_4 >= 0; --int_4) {
          stringbuilder_1.append("").append(scriptStack[int_4].invokedFromScript.hash)
              .append(" ");
        }

        stringbuilder_1.append("").append(byte_0);
        ClientScriptVariable.method526(stringbuilder_1.toString(), exception_0);
      }
    }
  }
}
