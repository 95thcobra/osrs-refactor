package jagex.oldschool.script;

import jagex.oldschool.Class103;
import jagex.oldschool.Class2;
import jagex.oldschool.Class22;
import jagex.oldschool.Class46;
import jagex.oldschool.ClassInfo;
import jagex.oldschool.Client;
import jagex.oldschool.CollisionData;
import jagex.oldschool.Interface1;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.Preferences;
import jagex.oldschool.Region;
import jagex.oldschool.io.Buffer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class IntegerVariable implements Interface1 {

  public static InterfaceComponent aWidget4;
  public static int anInt84;
  public static int anInt85;

  public static void method245(final int int_0, final int int_1, final int int_2) {
    if (Client.anInt647 != 0 && int_1 != 0 && Client.anInt648 < 50) {
      Client.anIntArray145[Client.anInt648] = int_0;
      Client.anIntArray146[Client.anInt648] = int_1;
      Client.anIntArray147[Client.anInt648] = int_2;
      Client.audioEffects[Client.anInt648] = null;
      Client.anIntArray148[Client.anInt648] = 0;
      ++Client.anInt648;
    }

  }

  public static void method246(final Buffer buffer_0, final int int_0) {
    final ClassInfo classinfo_0 = new ClassInfo();
    classinfo_0.count = buffer_0.getUnsignedByte();
    classinfo_0.anInt363 = buffer_0.getInt();
    classinfo_0.type = new int[classinfo_0.count];
    classinfo_0.errorIdentifiers = new int[classinfo_0.count];
    classinfo_0.fields = new Field[classinfo_0.count];
    classinfo_0.anIntArray81 = new int[classinfo_0.count];
    classinfo_0.methods = new Method[classinfo_0.count];
    classinfo_0.args = new byte[classinfo_0.count][][];

    for (int int_1 = 0; int_1 < classinfo_0.count; int_1++) {
      try {
        final int int_2 = buffer_0.getUnsignedByte();
        String string_0;
        String string_1;
        int int_3;
        if (int_2 != 0 && int_2 != 1 && int_2 != 2) {
          if (int_2 == 3 || int_2 == 4) {
            string_0 = buffer_0.getString();
            string_1 = buffer_0.getString();
            int_3 = buffer_0.getUnsignedByte();
            final String[] strings_0 = new String[int_3];

            for (int int_4 = 0; int_4 < int_3; int_4++) {
              strings_0[int_4] = buffer_0.getString();
            }

            final String string_2 = buffer_0.getString();
            final byte[][] bytes_0 = new byte[int_3][];
            int int_6;
            if (int_2 == 3) {
              for (int int_5 = 0; int_5 < int_3; int_5++) {
                int_6 = buffer_0.getInt();
                bytes_0[int_5] = new byte[int_6];
                buffer_0.get(bytes_0[int_5], 0, int_6);
              }
            }

            classinfo_0.type[int_1] = int_2;
            final Class[] classs_0 = new Class[int_3];

            for (int_6 = 0; int_6 < int_3; int_6++) {
              classs_0[int_6] = Class22.method209(strings_0[int_6]);
            }

            final Class class_0 = Class22.method209(string_2);
            if (Class22.method209(string_0).getClassLoader() == null) {
              throw new SecurityException();
            }

            final Method[] methods_0 = Class22.method209(string_0).getDeclaredMethods();
            final Method[] methods_1 = methods_0;

            for (int int_7 = 0; int_7 < methods_1.length; int_7++) {
              final Method method_0 = methods_1[int_7];
              if (method_0.getName().equals(string_1)) {
                final Class[] classs_1 = method_0.getParameterTypes();
                if (classs_0.length == classs_1.length) {
                  boolean bool_0 = true;

                  for (int int_8 = 0; int_8 < classs_0.length; int_8++) {
                    if (classs_1[int_8] != classs_0[int_8]) {
                      bool_0 = false;
                      break;
                    }
                  }

                  if (bool_0 && class_0 == method_0.getReturnType()) {
                    classinfo_0.methods[int_1] = method_0;
                  }
                }
              }
            }

            classinfo_0.args[int_1] = bytes_0;
          }
        } else {
          string_0 = buffer_0.getString();
          string_1 = buffer_0.getString();
          int_3 = 0;
          if (int_2 == 1) {
            int_3 = buffer_0.getInt();
          }

          classinfo_0.type[int_1] = int_2;
          classinfo_0.anIntArray81[int_1] = int_3;
          if (Class22.method209(string_0).getClassLoader() == null) {
            throw new SecurityException();
          }

          classinfo_0.fields[int_1] = Class22.method209(string_0).getDeclaredField(string_1);
        }
      } catch (final ClassNotFoundException classnotfoundexception_0) {
        classinfo_0.errorIdentifiers[int_1] = -1;
      } catch (final SecurityException securityexception_0) {
        classinfo_0.errorIdentifiers[int_1] = -2;
      } catch (final NullPointerException nullpointerexception_0) {
        classinfo_0.errorIdentifiers[int_1] = -3;
      } catch (final Exception exception_0) {
        classinfo_0.errorIdentifiers[int_1] = -4;
      } catch (final Throwable throwable_0) {
        classinfo_0.errorIdentifiers[int_1] = -5;
      }
    }

    Class103.aCombatInfoList3.addLast(classinfo_0);
  }

  public static void method247(final byte[] bytes_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5, final int int_6, final Region region_0,
      final CollisionData[] collisiondatas_0) {
    final Buffer buffer_0 = new Buffer(bytes_0);
    int int_7 = -1;

    while (true) {
      final int int_8 = buffer_0.getUnsignedSmartShort();
      if (int_8 == 0) {
        return;
      }

      int_7 += int_8;
      int int_9 = 0;

      while (true) {
        final int int_10 = buffer_0.getUnsignedSmartShort();
        if (int_10 == 0) {
          break;
        }

        int_9 += int_10 - 1;
        final int int_11 = int_9 & 0x3F;
        final int int_12 = int_9 >> 6 & 0x3F;
        final int int_13 = int_9 >> 12;
        final int int_14 = buffer_0.getUnsignedByte();
        final int int_15 = int_14 >> 2;
        final int int_16 = int_14 & 0x3;
        if (int_13 == int_3 && int_12 >= int_4 && int_12 < int_4 + 8 && int_11 >= int_5
            && int_11 < int_5 + 8) {
          final ObjectConfig objectcomposition_0 = Class2.getObjectDefinition(int_7);
          final int int_17 = int_1 + Preferences.method426(int_12 & 0x7, int_11 & 0x7, int_6,
              objectcomposition_0.sizeX, objectcomposition_0.sizeY, int_16);
          final int int_18 = int_12 & 0x7;
          final int int_19 = int_11 & 0x7;
          int int_21 = objectcomposition_0.sizeX;
          int int_22 = objectcomposition_0.sizeY;
          int int_23;
          if ((int_16 & 0x1) == 1) {
            int_23 = int_21;
            int_21 = int_22;
            int_22 = int_23;
          }

          final int int_20 = int_6 & 0x3;
          int int_24;
          if (int_20 == 0) {
            int_24 = int_19;
          } else if (int_20 == 1) {
            int_24 = 7 - int_18 - (int_21 - 1);
          } else if (int_20 == 2) {
            int_24 = 7 - int_19 - (int_22 - 1);
          } else {
            int_24 = int_18;
          }

          int_23 = int_2 + int_24;
          if (int_17 > 0 && int_23 > 0 && int_17 < 103 && int_23 < 103) {
            int int_25 = int_0;
            if ((Class22.flags[1][int_17][int_23] & 0x2) == 2) {
              int_25 = int_0 - 1;
            }

            CollisionData collisiondata_0 = null;
            if (int_25 >= 0) {
              collisiondata_0 = collisiondatas_0[int_25];
            }

            Class46
                .addObject(int_0, int_17, int_23, int_7, int_16 + int_6 & 0x3, int_15, region_0,
                    collisiondata_0);
          }
        }
      }
    }
  }

}
