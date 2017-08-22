package jagex.oldschool;

import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Position;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WorldMapData_Sub1 extends WorldMapData {

  public static int baseY;
  static IndexedSprite anIndexedSprite5;
  List aList4;
  HashSet aHashSet7;
  HashSet aHashSet8;

  public static void encodeClassVerifier(final GameBuffer packetbuffer_0) {
    final ClassInfo classinfo_0 = (ClassInfo) Class103.aCombatInfoList3.getFirst();
    if (classinfo_0 != null) {
      final int int_0 = packetbuffer_0.offset;
      packetbuffer_0.putInt(classinfo_0.anInt363);

      for (int int_1 = 0; int_1 < classinfo_0.count; int_1++) {
        if (classinfo_0.errorIdentifiers[int_1] != 0) {
          packetbuffer_0.putByte(classinfo_0.errorIdentifiers[int_1]);
        } else {
          try {
            final int int_2 = classinfo_0.type[int_1];
            Field field_0;
            int int_3;
            if (int_2 == 0) {
              field_0 = classinfo_0.fields[int_1];
              int_3 = field_0.getInt(null);
              packetbuffer_0.putByte(0);
              packetbuffer_0.putInt(int_3);
            } else if (int_2 == 1) {
              field_0 = classinfo_0.fields[int_1];
              field_0.setInt(null, classinfo_0.anIntArray81[int_1]);
              packetbuffer_0.putByte(0);
            } else if (int_2 == 2) {
              field_0 = classinfo_0.fields[int_1];
              int_3 = field_0.getModifiers();
              packetbuffer_0.putByte(0);
              packetbuffer_0.putInt(int_3);
            }

            Method method_0;
            if (int_2 != 3) {
              if (int_2 == 4) {
                method_0 = classinfo_0.methods[int_1];
                int_3 = method_0.getModifiers();
                packetbuffer_0.putByte(0);
                packetbuffer_0.putInt(int_3);
              }
            } else {
              method_0 = classinfo_0.methods[int_1];
              final byte[][] bytes_0 = classinfo_0.args[int_1];
              final Object[] objects_0 = new Object[bytes_0.length];

              for (int int_4 = 0; int_4 < bytes_0.length; int_4++) {
                final ObjectInputStream objectinputstream_0 = new ObjectInputStream(
                    new ByteArrayInputStream(bytes_0[int_4]));
                objects_0[int_4] = objectinputstream_0.readObject();
              }

              final Object object_0 = method_0.invoke(null, objects_0);
              if (object_0 == null) {
                packetbuffer_0.putByte(0);
              } else if (object_0 instanceof Number) {
                packetbuffer_0.putByte(1);
                packetbuffer_0.putLong(((Number) object_0).longValue());
              } else if (object_0 instanceof String) {
                packetbuffer_0.putByte(2);
                packetbuffer_0.putString((String) object_0);
              } else {
                packetbuffer_0.putByte(4);
              }
            }
          } catch (final ClassNotFoundException classnotfoundexception_0) {
            packetbuffer_0.putByte(-10);
          } catch (final InvalidClassException invalidclassexception_0) {
            packetbuffer_0.putByte(-11);
          } catch (final StreamCorruptedException streamcorruptedexception_0) {
            packetbuffer_0.putByte(-12);
          } catch (final OptionalDataException optionaldataexception_0) {
            packetbuffer_0.putByte(-13);
          } catch (final IllegalAccessException illegalaccessexception_0) {
            packetbuffer_0.putByte(-14);
          } catch (final IllegalArgumentException illegalargumentexception_0) {
            packetbuffer_0.putByte(-15);
          } catch (final InvocationTargetException invocationtargetexception_0) {
            packetbuffer_0.putByte(-16);
          } catch (final SecurityException securityexception_0) {
            packetbuffer_0.putByte(-17);
          } catch (final IOException ioexception_0) {
            packetbuffer_0.putByte(-18);
          } catch (final NullPointerException nullpointerexception_0) {
            packetbuffer_0.putByte(-19);
          } catch (final Exception exception_0) {
            packetbuffer_0.putByte(-20);
          } catch (final Throwable throwable_0) {
            packetbuffer_0.putByte(-21);
          }
        }
      }

      packetbuffer_0.putChecksum(int_0);
      classinfo_0.unlink();
    }
  }

  static void method599(final IndexedSprite indexedsprite_0) {
    final short short_0 = 256;

    int int_0;
    for (int_0 = 0; int_0 < LoginScreen.anIntArray21.length; int_0++) {
      LoginScreen.anIntArray21[int_0] = 0;
    }

    int int_1;
    for (int_0 = 0; int_0 < 5000; int_0++) {
      int_1 = (int) (Math.random() * 128.0D * short_0);
      LoginScreen.anIntArray21[int_1] = (int) (Math.random() * 256.0D);
    }

    int int_2;
    int int_3;
    for (int_0 = 0; int_0 < 20; int_0++) {
      for (int_1 = 1; int_1 < short_0 - 1; int_1++) {
        for (int_2 = 1; int_2 < 127; int_2++) {
          int_3 = int_2 + (int_1 << 7);
          Class84.anIntArray44[int_3] =
              (LoginScreen.anIntArray21[int_3 + 128] + LoginScreen.anIntArray21[int_3 - 128]
                  + LoginScreen.anIntArray21[int_3 + 1] + LoginScreen.anIntArray21[int_3 - 1]) / 4;
        }
      }

      final int[] ints_0 = LoginScreen.anIntArray21;
      LoginScreen.anIntArray21 = Class84.anIntArray44;
      Class84.anIntArray44 = ints_0;
    }

    if (indexedsprite_0 != null) {
      int_0 = 0;

      for (int_1 = 0; int_1 < indexedsprite_0.height; int_1++) {
        for (int_2 = 0; int_2 < indexedsprite_0.width; int_2++) {
          if (indexedsprite_0.pixels[int_0++] != 0) {
            int_3 = int_2 + indexedsprite_0.offsetX + 16;
            final int int_4 = int_1 + indexedsprite_0.offsetY + 16;
            final int int_5 = int_3 + (int_4 << 7);
            LoginScreen.anIntArray21[int_5] = 0;
          }
        }
      }
    }

  }

  public static void drawDot(final int int_0, final int int_1, final int int_2, final int int_3,
      final DirectSprite spritepixels_0, final CacheableNode_Sub1 cacheablenode_sub1_0) {
    if (spritepixels_0 != null) {
      final int int_4 = Client.mapAngle & 0x7FF;
      final int int_5 = int_3 * int_3 + int_2 * int_2;
      if (int_5 <= 6400) {
        final int int_6 = Rasterizer3d.SINE[int_4];
        final int int_7 = Rasterizer3d.COSINE[int_4];
        final int int_8 = int_7 * int_2 + int_3 * int_6 >> 16;
        final int int_9 = int_3 * int_7 - int_6 * int_2 >> 16;
        if (int_5 > 2500) {
          spritepixels_0.method955(
              int_8 + cacheablenode_sub1_0.anInt460 / 2 - spritepixels_0.unpackedWidth / 2,
              cacheablenode_sub1_0.anInt461 / 2 - int_9 - spritepixels_0.unpackedHeight / 2, int_0,
              int_1,
              cacheablenode_sub1_0.anInt460, cacheablenode_sub1_0.anInt461,
              cacheablenode_sub1_0.anIntArray102, cacheablenode_sub1_0.anIntArray103);
        } else {
          spritepixels_0.method938(
              int_0 + int_8 + cacheablenode_sub1_0.anInt460 / 2 - spritepixels_0.unpackedWidth
                  / 2,
              (cacheablenode_sub1_0.anInt461 / 2 + int_1) - int_9 - spritepixels_0.unpackedHeight
                  / 2);
        }
      }
    }
  }

  void method597(final Buffer buffer_0, final boolean bool_0) {
    aList4 = new LinkedList();
    final int int_0 = buffer_0.getUnsignedShort();

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final int int_2 = buffer_0.getSmartInt();
      final Position coordinates_0 = new Position(buffer_0.getInt());
      final boolean bool_1 = buffer_0.getUnsignedByte() == 1;
      if (bool_0 || !bool_1) {
        aList4.add(new Class29(int_2, coordinates_0));
      }
    }

  }

  void method598(final Buffer buffer_0, final Buffer buffer_1, final Buffer buffer_2,
      final int int_0,
      final boolean bool_0) {
    loadMapData(buffer_0, int_0);
    final int int_1 = buffer_2.getUnsignedShort();
    aHashSet7 = new HashSet(int_1);

    int int_2;
    for (int_2 = 0; int_2 < int_1; int_2++) {
      final AClass1_Sub2 aclass1_sub2_0 = new AClass1_Sub2();

      try {
        aclass1_sub2_0.method622(buffer_1, buffer_2);
      } catch (final IllegalStateException illegalstateexception_0) {
        continue;
      }

      aHashSet7.add(aclass1_sub2_0);
    }

    int_2 = buffer_2.getUnsignedShort();
    aHashSet8 = new HashSet(int_2);

    for (int int_3 = 0; int_3 < int_2; int_3++) {
      final AClass1_Sub1 aclass1_sub1_0 = new AClass1_Sub1();

      try {
        aclass1_sub1_0.method592(buffer_1, buffer_2);
      } catch (final IllegalStateException illegalstateexception_1) {
        continue;
      }

      aHashSet8.add(aclass1_sub1_0);
    }

    method597(buffer_1, bool_0);
  }

}
