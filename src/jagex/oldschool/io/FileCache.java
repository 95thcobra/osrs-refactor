package jagex.oldschool.io;

import jagex.oldschool.AClass2;
import jagex.oldschool.Class66;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.graphics.AbstractRasterBuffer;
import java.io.EOFException;
import java.io.IOException;

public final class FileCache {

  public static AbstractRasterBuffer rasterBuffer;
  static byte[] aByteArray1;
  public static java.awt.Font aFont2;

  static {
    aByteArray1 = new byte[520];
  }

  BufferedFile volume;
  BufferedFile index;
  int maximumSize;
  int id;

  public FileCache(final int int_0, final BufferedFile cachefile_0, final BufferedFile cachefile_1,
      final int int_1) {
    volume = null;
    index = null;
    maximumSize = 65000;
    id = int_0;
    volume = cachefile_0;
    index = cachefile_1;
    maximumSize = int_1;
  }

  public static int method72(int int_0) {
    --int_0;
    int_0 |= int_0 >>> 1;
    int_0 |= int_0 >>> 2;
    int_0 |= int_0 >>> 4;
    int_0 |= int_0 >>> 8;
    int_0 |= int_0 >>> 16;
    return int_0 + 1;
  }

  public static boolean method73(final int int_0, final int int_1, final int int_2,
      final AClass2 aclass2_0,
      final CollisionData collisiondata_0) {
    int int_3 = int_0;
    int int_4 = int_1;
    final byte byte_0 = 64;
    final byte byte_1 = 64;
    final int int_5 = int_0 - byte_0;
    final int int_6 = int_1 - byte_1;
    Class66.anIntArrayArray10[byte_0][byte_1] = 99;
    Class66.anIntArrayArray11[byte_0][byte_1] = 0;
    final byte byte_2 = 0;
    int int_7 = 0;
    Class66.anIntArray38[byte_2] = int_0;
    int int_14 = byte_2 + 1;
    Class66.anIntArray39[byte_2] = int_1;
    final int[][] ints_0 = collisiondata_0.flags;

    while (true) {
      label300:
      while (true) {
        int int_8;
        int int_9;
        int int_10;
        int int_11;
        int int_12;
        int int_13;
        do {
          do {
            do {
              label277:
              do {
                if (int_14 == int_7) {
                  AClass2.anInt153 = int_3;
                  Class66.anInt166 = int_4;
                  return false;
                }

                int_3 = Class66.anIntArray38[int_7];
                int_4 = Class66.anIntArray39[int_7];
                int_7 = int_7 + 1 & 0xFFF;
                int_12 = int_3 - int_5;
                int_13 = int_4 - int_6;
                int_8 = int_3 - collisiondata_0.x;
                int_9 = int_4 - collisiondata_0.y;
                if (aclass2_0.method399(int_2, int_3, int_4, collisiondata_0)) {
                  AClass2.anInt153 = int_3;
                  Class66.anInt166 = int_4;
                  return true;
                }

                int_10 = Class66.anIntArrayArray11[int_12][int_13] + 1;
                if (int_12 > 0 && Class66.anIntArrayArray10[int_12 - 1][int_13] == 0
                    && (ints_0[int_8 - 1][int_9] & 0x124010E) == 0
                    && (ints_0[int_8 - 1][int_9 + int_2 - 1] & 0x1240138) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2 - 1) {
                      Class66.anIntArray38[int_14] = int_3 - 1;
                      Class66.anIntArray39[int_14] = int_4;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12 - 1][int_13] = 2;
                      Class66.anIntArrayArray11[int_12 - 1][int_13] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 - 1][int_11 + int_9] & 0x124013E) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_12 < 128 - int_2 && Class66.anIntArrayArray10[int_12 + 1][int_13] == 0
                    && (ints_0[int_8 + int_2][int_9] & 0x1240183) == 0
                    && (ints_0[int_8 + int_2][int_9 + int_2 - 1] & 0x12401E0) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2 - 1) {
                      Class66.anIntArray38[int_14] = int_3 + 1;
                      Class66.anIntArray39[int_14] = int_4;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12 + 1][int_13] = 8;
                      Class66.anIntArrayArray11[int_12 + 1][int_13] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 + int_2][int_11 + int_9] & 0x12401E3) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_13 > 0 && Class66.anIntArrayArray10[int_12][int_13 - 1] == 0
                    && (ints_0[int_8][int_9 - 1] & 0x124010E) == 0
                    && (ints_0[int_8 + int_2 - 1][int_9 - 1] & 0x1240183) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2 - 1) {
                      Class66.anIntArray38[int_14] = int_3;
                      Class66.anIntArray39[int_14] = int_4 - 1;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12][int_13 - 1] = 1;
                      Class66.anIntArrayArray11[int_12][int_13 - 1] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 + int_11][int_9 - 1] & 0x124018F) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_13 < 128 - int_2 && Class66.anIntArrayArray10[int_12][int_13 + 1] == 0
                    && (ints_0[int_8][int_9 + int_2] & 0x1240138) == 0
                    && (ints_0[int_8 + int_2 - 1][int_9 + int_2] & 0x12401E0) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2 - 1) {
                      Class66.anIntArray38[int_14] = int_3;
                      Class66.anIntArray39[int_14] = int_4 + 1;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12][int_13 + 1] = 4;
                      Class66.anIntArrayArray11[int_12][int_13 + 1] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 + int_11][int_9 + int_2] & 0x12401F8) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_12 > 0 && int_13 > 0
                    && Class66.anIntArrayArray10[int_12 - 1][int_13 - 1] == 0
                    && (ints_0[int_8 - 1][int_9 - 1] & 0x124010E) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2) {
                      Class66.anIntArray38[int_14] = int_3 - 1;
                      Class66.anIntArray39[int_14] = int_4 - 1;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12 - 1][int_13 - 1] = 3;
                      Class66.anIntArrayArray11[int_12 - 1][int_13 - 1] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 - 1][int_11 + int_9 - 1] & 0x124013E) != 0
                        || (ints_0[int_11 + int_8 - 1][int_9 - 1] & 0x124018F) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_12 < 128 - int_2 && int_13 > 0
                    && Class66.anIntArrayArray10[int_12 + 1][int_13 - 1] == 0
                    && (ints_0[int_8 + int_2][int_9 - 1] & 0x1240183) == 0) {
                  int_11 = 1;

                  while (true) {
                    if (int_11 >= int_2) {
                      Class66.anIntArray38[int_14] = int_3 + 1;
                      Class66.anIntArray39[int_14] = int_4 - 1;
                      int_14 = int_14 + 1 & 0xFFF;
                      Class66.anIntArrayArray10[int_12 + 1][int_13 - 1] = 9;
                      Class66.anIntArrayArray11[int_12 + 1][int_13 - 1] = int_10;
                      break;
                    }

                    if ((ints_0[int_8 + int_2][int_11 + int_9 - 1] & 0x12401E3) != 0
                        || (ints_0[int_11 + int_8][int_9 - 1] & 0x124018F) != 0) {
                      break;
                    }

                    ++int_11;
                  }
                }

                if (int_12 > 0 && int_13 < 128 - int_2
                    && Class66.anIntArrayArray10[int_12 - 1][int_13 + 1] == 0
                    && (ints_0[int_8 - 1][int_9 + int_2] & 0x1240138) == 0) {
                  for (int_11 = 1; int_11 < int_2; int_11++) {
                    if ((ints_0[int_8 - 1][int_9 + int_11] & 0x124013E) != 0
                        || (ints_0[int_11 + int_8 - 1][int_9 + int_2] & 0x12401F8) != 0) {
                      continue label277;
                    }
                  }

                  Class66.anIntArray38[int_14] = int_3 - 1;
                  Class66.anIntArray39[int_14] = int_4 + 1;
                  int_14 = int_14 + 1 & 0xFFF;
                  Class66.anIntArrayArray10[int_12 - 1][int_13 + 1] = 6;
                  Class66.anIntArrayArray11[int_12 - 1][int_13 + 1] = int_10;
                }
              } while (int_12 >= 128 - int_2);
            } while (int_13 >= 128 - int_2);
          } while (Class66.anIntArrayArray10[int_12 + 1][int_13 + 1] != 0);
        } while ((ints_0[int_8 + int_2][int_9 + int_2] & 0x12401E0) != 0);

        for (int_11 = 1; int_11 < int_2; int_11++) {
          if ((ints_0[int_8 + int_11][int_9 + int_2] & 0x12401F8) != 0
              || (ints_0[int_8 + int_2][int_9 + int_11] & 0x12401E3) != 0) {
            continue label300;
          }
        }

        Class66.anIntArray38[int_14] = int_3 + 1;
        Class66.anIntArray39[int_14] = int_4 + 1;
        int_14 = int_14 + 1 & 0xFFF;
        Class66.anIntArrayArray10[int_12 + 1][int_13 + 1] = 12;
        Class66.anIntArrayArray11[int_12 + 1][int_13 + 1] = int_10;
      }
    }
  }

  boolean method69(final int int_0, final byte[] bytes_0, final int int_1, boolean bool_0) {
    synchronized (volume) {
      try {
        int int_2;
        boolean bool_1;
        if (bool_0) {
          if (index.method549() < int_0 * 6 + 6) {
            bool_1 = false;
            return bool_1;
          }

          index.seek(int_0 * 6);
          index.method547(aByteArray1, 0, 6);
          int_2 =
              (aByteArray1[5] & 0xFF) + ((aByteArray1[3] & 0xFF) << 16) + ((aByteArray1[4] & 0xFF)
                  << 8);
          if (int_2 <= 0 || int_2 > volume.method549() / 520L) {
            bool_1 = false;
            return bool_1;
          }
        } else {
          int_2 = (int) ((volume.method549() + 519L) / 520L);
          if (int_2 == 0) {
            int_2 = 1;
          }
        }

        aByteArray1[0] = (byte) (int_1 >> 16);
        aByteArray1[1] = (byte) (int_1 >> 8);
        aByteArray1[2] = (byte) int_1;
        aByteArray1[3] = (byte) (int_2 >> 16);
        aByteArray1[4] = (byte) (int_2 >> 8);
        aByteArray1[5] = (byte) int_2;
        index.seek(int_0 * 6);
        index.write(aByteArray1, 0, 6);
        int int_3 = 0;
        int int_4 = 0;

        while (true) {
          if (int_3 < int_1) {
            label135:
            {
              int int_5 = 0;
              int int_6;
              if (bool_0) {
                label155:
                {
                  volume.seek(int_2 * 520);

                  try {
                    volume.method547(aByteArray1, 0, 8);
                  } catch (final EOFException eofexception_0) {
                    break label135;
                  }

                  int_6 = (aByteArray1[1] & 0xFF) + ((aByteArray1[0] & 0xFF) << 8);
                  final int int_7 = (aByteArray1[3] & 0xFF) + ((aByteArray1[2] & 0xFF) << 8);
                  int_5 = ((aByteArray1[5] & 0xFF) << 8) + ((aByteArray1[4] & 0xFF) << 16)
                      + (aByteArray1[6] & 0xFF);
                  final int int_8 = aByteArray1[7] & 0xFF;
                  if (int_6 == int_0 && int_4 == int_7 && int_8 == id) {
                    if (int_5 >= 0 && int_5 <= volume.method549() / 520L) {
                      break label155;
                    }

                    bool_1 = false;
                    return bool_1;
                  }

                  bool_1 = false;
                  return bool_1;
                }
              }

              if (int_5 == 0) {
                bool_0 = false;
                int_5 = (int) ((volume.method549() + 519L) / 520L);
                if (int_5 == 0) {
                  ++int_5;
                }

                if (int_5 == int_2) {
                  ++int_5;
                }
              }

              if (int_1 - int_3 <= 512) {
                int_5 = 0;
              }

              aByteArray1[0] = (byte) (int_0 >> 8);
              aByteArray1[1] = (byte) int_0;
              aByteArray1[2] = (byte) (int_4 >> 8);
              aByteArray1[3] = (byte) int_4;
              aByteArray1[4] = (byte) (int_5 >> 16);
              aByteArray1[5] = (byte) (int_5 >> 8);
              aByteArray1[6] = (byte) int_5;
              aByteArray1[7] = (byte) id;
              volume.seek(int_2 * 520);
              volume.write(aByteArray1, 0, 8);
              int_6 = int_1 - int_3;
              if (int_6 > 512) {
                int_6 = 512;
              }

              volume.write(bytes_0, int_3, int_6);
              int_3 += int_6;
              int_2 = int_5;
              ++int_4;
              continue;
            }
          }

          bool_1 = true;
          return bool_1;
        }
      } catch (final IOException ioexception_0) {
        return false;
      }
    }
  }

  public boolean method70(final int int_0, final byte[] bytes_0, final int int_1) {
    synchronized (volume) {
      if (int_1 >= 0 && int_1 <= maximumSize) {
        boolean bool_0 = method69(int_0, bytes_0, int_1, true);
        if (!bool_0) {
          bool_0 = method69(int_0, bytes_0, int_1, false);
        }

        return bool_0;
      }
      throw new IllegalArgumentException();
    }
  }

  public byte[] method71(final int int_0) {
    synchronized (volume) {
      Object object_0;
      try {
        if (index.method549() >= int_0 * 6 + 6) {
          index.seek(int_0 * 6);
          index.method547(aByteArray1, 0, 6);
          final int int_1 = ((aByteArray1[0] & 0xFF) << 16) + (aByteArray1[2] & 0xFF)
              + ((aByteArray1[1] & 0xFF) << 8);
          int int_2 = (aByteArray1[5] & 0xFF) + ((aByteArray1[3] & 0xFF) << 16)
              + ((aByteArray1[4] & 0xFF) << 8);
          if (int_1 >= 0 && int_1 <= maximumSize) {
            if (int_2 > 0 && int_2 <= volume.method549() / 520L) {
              final byte[] bytes_0 = new byte[int_1];
              int int_3 = 0;
              int int_4 = 0;

              while (int_3 < int_1) {
                if (int_2 == 0) {
                  object_0 = null;
                  return (byte[]) object_0;
                }

                volume.seek(int_2 * 520);
                int int_5 = int_1 - int_3;
                if (int_5 > 512) {
                  int_5 = 512;
                }

                volume.method547(aByteArray1, 0, int_5 + 8);
                final int int_6 = (aByteArray1[1] & 0xFF) + ((aByteArray1[0] & 0xFF) << 8);
                final int int_7 = (aByteArray1[3] & 0xFF) + ((aByteArray1[2] & 0xFF) << 8);
                final int int_8 = ((aByteArray1[5] & 0xFF) << 8) + ((aByteArray1[4] & 0xFF) << 16)
                    + (aByteArray1[6] & 0xFF);
                final int int_9 = aByteArray1[7] & 0xFF;
                if (int_6 == int_0 && int_7 == int_4 && int_9 == id) {
                  if (int_8 >= 0 && int_8 <= volume.method549() / 520L) {
                    for (int int_10 = 0; int_10 < int_5; int_10++) {
                      bytes_0[int_3++] = aByteArray1[int_10 + 8];
                    }

                    int_2 = int_8;
                    ++int_4;
                    continue;
                  }

                  object_0 = null;
                  return (byte[]) object_0;
                }

                object_0 = null;
                return (byte[]) object_0;
              }

              final byte[] bytes_1 = bytes_0;
              return bytes_1;
            }

            object_0 = null;
            return (byte[]) object_0;
          }

          object_0 = null;
          return (byte[]) object_0;
        }

        object_0 = null;
      } catch (final IOException ioexception_0) {
        return null;
      }

      return (byte[]) object_0;
    }
  }

}
