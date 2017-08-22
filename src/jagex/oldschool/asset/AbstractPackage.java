package jagex.oldschool.asset;

import jagex.oldschool.Class28;
import jagex.oldschool.Class35;
import jagex.oldschool.Class37;
import jagex.oldschool.CollisionData;
import jagex.oldschool.collections.LinearHashTable;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.util.GzipDecompressor;

public abstract class AbstractPackage {

  public static GzipDecompressor gz;
  public static int MAXIMUM_LENGTH;

  static {
    gz = new GzipDecompressor();
    MAXIMUM_LENGTH = 0;
  }

  public int checksum;
  int[][] childIds;
  int[] archiveIds;
  Object[] packedArchives;
  Object[][] unpackedArchives;
  boolean removePacked;
  LinearHashTable[] childIdentifiers;
  LinearHashTable names;
  int[] versions;
  int[] sizes;
  boolean removeUnpacked;
  int[] checksums;
  int size;
  int[] hashes;
  int[][] archiveFileNames;

  AbstractPackage(final boolean removePacked, final boolean removeUnpacked) {
    this.removePacked = removePacked;
    this.removeUnpacked = removeUnpacked;
  }

  public static boolean method462(final char char_0) {
    return char_0 == 160 || char_0 == 32 || char_0 == 95 || char_0 == 45;
  }

  public byte[] get(final int id, final int child, final int[] key) {
    if (id >= 0 && id < unpackedArchives.length && unpackedArchives[id] != null
        && child >= 0 && child < unpackedArchives[id].length) {
      if (unpackedArchives[id][child] == null) {
        boolean bool_0 = unpack(id, key);
        if (!bool_0) {
          fetch(id);
          bool_0 = unpack(id, key);
          if (!bool_0) {
            return null;
          }
        }
      }

      final byte[] bytes_0 = Class28.toByteArray(unpackedArchives[id][child], false);
      if (removeUnpacked) {
        unpackedArchives[id][child] = null;
      }

      return bytes_0;
    }
    return null;
  }

  public int size() {
    return unpackedArchives.length;
  }

  public byte[] getChild(final int int_0, final int int_1) {
    if (int_0 >= 0 && int_0 < unpackedArchives.length && unpackedArchives[int_0] != null &&
        int_1 >= 0
        && int_1 < unpackedArchives[int_0].length) {
      if (unpackedArchives[int_0][int_1] == null) {
        boolean bool_0 = unpack(int_0, null);
        if (!bool_0) {
          fetch(int_0);
          bool_0 = unpack(int_0, null);
          if (!bool_0) {
            return null;
          }
        }
      }

      final byte[] bytes_0 = Class28.toByteArray(unpackedArchives[int_0][int_1], false);
      return bytes_0;
    }
    return null;
  }

  void fetch(final int id) {
  }

  public byte[] get(final int id, final int child) {
    return this.get(id, child, null);
  }

  public byte[] method447(final int int_0) {
    if (unpackedArchives.length == 1) {
      return this.getChild(0, int_0);
    }
    if (unpackedArchives[int_0].length == 1) {
      return this.getChild(int_0, 0);
    }
    throw new RuntimeException();
  }

  int method448(final int int_0) {
    return packedArchives[int_0] != null ? 100 : 0;
  }

  public int fileCount(final int int_0) {
    return unpackedArchives[int_0].length;
  }

  void parse(final byte[] src) {
    final int len = src.length;

    final int checksum = CollisionData.getChecksum(src, 0, len);
    this.checksum = checksum;

    final Buffer buffer = new Buffer(GzipDecompressor.decompress(src));
    final int protocol = buffer.getUnsignedByte();
    if (protocol >= 5 && protocol <= 7) {
      if (protocol >= 6) {
        buffer.getInt();
      }

      final int int_3 = buffer.getUnsignedByte();
      if (protocol >= 7) {
        size = buffer.getUnsignedSmartInt();
      } else {
        size = buffer.getUnsignedShort();
      }

      int counter = 0;
      int int_5 = -1;
      archiveIds = new int[size];
      int int_6;
      if (protocol >= 7) {
        for (int_6 = 0; int_6 < size; int_6++) {
          archiveIds[int_6] = counter += buffer.getUnsignedSmartInt();
          if (archiveIds[int_6] > int_5) {
            int_5 = archiveIds[int_6];
          }
        }
      } else {
        for (int_6 = 0; int_6 < size; int_6++) {
          archiveIds[int_6] = counter += buffer.getUnsignedShort();
          if (archiveIds[int_6] > int_5) {
            int_5 = archiveIds[int_6];
          }
        }
      }

      checksums = new int[int_5 + 1];
      versions = new int[int_5 + 1];
      sizes = new int[int_5 + 1];
      childIds = new int[int_5 + 1][];
      packedArchives = new Object[int_5 + 1];
      unpackedArchives = new Object[int_5 + 1][];
      if (int_3 != 0) {
        hashes = new int[int_5 + 1];

        for (int_6 = 0; int_6 < size; int_6++) {
          hashes[archiveIds[int_6]] = buffer.getInt();
        }

        names = new LinearHashTable(hashes);
      }

      for (int_6 = 0; int_6 < size; int_6++) {
        checksums[archiveIds[int_6]] = buffer.getInt();
      }

      for (int_6 = 0; int_6 < size; int_6++) {
        versions[archiveIds[int_6]] = buffer.getInt();
      }

      for (int_6 = 0; int_6 < size; int_6++) {
        sizes[archiveIds[int_6]] = buffer.getUnsignedShort();
      }

      int int_7;
      int int_8;
      int int_9;
      int int_10;
      int int_11;
      if (protocol >= 7) {
        for (int_6 = 0; int_6 < size; int_6++) {
          int_7 = archiveIds[int_6];
          int_8 = sizes[int_7];
          counter = 0;
          int_9 = -1;
          childIds[int_7] = new int[int_8];

          for (int_10 = 0; int_10 < int_8; int_10++) {
            int_11 = childIds[int_7][int_10] = counter += buffer.getUnsignedSmartInt();
            if (int_11 > int_9) {
              int_9 = int_11;
            }
          }

          unpackedArchives[int_7] = new Object[int_9 + 1];
        }
      } else {
        for (int_6 = 0; int_6 < size; int_6++) {
          int_7 = archiveIds[int_6];
          int_8 = sizes[int_7];
          counter = 0;
          int_9 = -1;
          childIds[int_7] = new int[int_8];

          for (int_10 = 0; int_10 < int_8; int_10++) {
            int_11 = childIds[int_7][int_10] = counter += buffer.getUnsignedShort();
            if (int_11 > int_9) {
              int_9 = int_11;
            }
          }

          unpackedArchives[int_7] = new Object[int_9 + 1];
        }
      }

      if (int_3 != 0) {
        archiveFileNames = new int[int_5 + 1][];
        childIdentifiers = new LinearHashTable[int_5 + 1];

        for (int_6 = 0; int_6 < size; int_6++) {
          int_7 = archiveIds[int_6];
          int_8 = sizes[int_7];
          archiveFileNames[int_7] = new int[unpackedArchives[int_7].length];

          for (int_9 = 0; int_9 < int_8; int_9++) {
            archiveFileNames[int_7][childIds[int_7][int_9]] = buffer.getInt();
          }

          childIdentifiers[int_7] = new LinearHashTable(archiveFileNames[int_7]);
        }
      }

    } else {
      throw new RuntimeException("");
    }
  }

  public boolean method450(final int int_0, final int int_1) {
    if (int_0 >= 0 && int_0 < unpackedArchives.length && unpackedArchives[int_0] != null &&
        int_1 >= 0
        && int_1 < unpackedArchives[int_0].length) {
      if (unpackedArchives[int_0][int_1] != null) {
        return true;
      }
      if (packedArchives[int_0] != null) {
        return true;
      }
      fetch(int_0);
      return packedArchives[int_0] != null;
    }
    return false;
  }

  public boolean contains(final int id) {
    if (packedArchives[id] != null) {
      return true;
    }
    fetch(id);
    return packedArchives[id] != null;
  }

  public boolean method451(String string_0, String string_1) {
    string_0 = string_0.toLowerCase();
    string_1 = string_1.toLowerCase();
    final int int_0 = names.get(Class35.hash(string_0));
    final int int_1 = childIdentifiers[int_0].get(Class35.hash(string_1));
    return method450(int_0, int_1);
  }

  void request(final int id) {
  }

  public int[] getChilds(final int int_0) {
    return childIds[int_0];
  }

  public byte[] method453(final int int_0) {
    if (unpackedArchives.length == 1) {
      return this.get(0, int_0);
    }
    if (unpackedArchives[int_0].length == 1) {
      return this.get(int_0, 0);
    }
    throw new RuntimeException();
  }

  public int getFile(String string_0) {
    string_0 = string_0.toLowerCase();
    return names.get(Class35.hash(string_0));
  }

  public boolean method454(String string_0, String string_1) {
    string_0 = string_0.toLowerCase();
    string_1 = string_1.toLowerCase();
    final int int_0 = names.get(Class35.hash(string_0));
    if (int_0 < 0) {
      return false;
    }
    final int int_1 = childIdentifiers[int_0].get(Class35.hash(string_1));
    return int_1 >= 0;
  }

  boolean unpack(final int id, final int[] key) {
    if (packedArchives[id] == null) {
      return false;
    }
    final int size = sizes[id];
    final int[] ids = this.childIds[id];

    final Object[] unpackedArchive = unpackedArchives[id];
    boolean bool_0 = true;

    for (int int_2 = 0; int_2 < size; int_2++) {
      if (unpackedArchive[ids[int_2]] == null) {
        bool_0 = false;
        break;
      }
    }

    if (bool_0) {
      return true;
    }

    byte[] packed;
    if (key != null && (key[0] != 0 || key[1] != 0 || key[2] != 0 || key[3] != 0)) {
      packed = Class28.toByteArray(this.packedArchives[id], true);
      final Buffer buffer = new Buffer(packed);
      buffer.decipher(key, 5, buffer.bytes.length);
    } else {
      packed = Class28.toByteArray(this.packedArchives[id], false);
    }

    final byte[] decompressed = GzipDecompressor.decompress(packed);
    if (removePacked) {
      this.packedArchives[id] = null;
    }

    if (size > 1) {
      int off = decompressed.length;
      --off;
      final int rounds = decompressed[off] & 0xFF;
      off -= size * rounds * 4;
      final Buffer buffer = new Buffer(decompressed);
      final int[] offsets = new int[size];
      buffer.offset = off;

      int counter;
      for (int i = 0; i < rounds; i++) {
        counter = 0;

        for (int j = 0; j < size; j++) {
          counter += buffer.getInt();
          offsets[j] += counter;
        }
      }

      final byte[][] children = new byte[size][];

      for (counter = 0; counter < size; counter++) {
        children[counter] = new byte[offsets[counter]];
        offsets[counter] = 0;
      }

      buffer.offset = off;
      counter = 0;

      for (int i = 0; i < rounds; i++) {
        int len = 0;

        for (int j = 0; j < size; j++) {
          len += buffer.getInt();
          System.arraycopy(decompressed, counter, children[j], offsets[j], len);
          offsets[j] += len;
          counter += len;
        }
      }

      for (int i = 0; i < size; i++) {
        if (!removeUnpacked) {
          unpackedArchive[ids[i]] = Class37.wrap(children[i]);
        } else {
          unpackedArchive[ids[i]] = children[i];
        }
      }
    } else if (!removeUnpacked) {
      unpackedArchive[ids[0]] = Class37.wrap(decompressed);
    } else {
      unpackedArchive[ids[0]] = decompressed;
    }

    return true;
  }

  public int getChild(final int int_0, String string_0) {
    string_0 = string_0.toLowerCase();
    return childIdentifiers[int_0].get(Class35.hash(string_0));
  }

  public int method456(String string_0) {
    string_0 = string_0.toLowerCase();
    final int int_0 = names.get(Class35.hash(string_0));
    return method448(int_0);
  }

  public byte[] method457(String string_0, String string_1) {
    string_0 = string_0.toLowerCase();
    string_1 = string_1.toLowerCase();
    final int int_0 = names.get(Class35.hash(string_0));
    final int int_1 = childIdentifiers[int_0].get(Class35.hash(string_1));
    return this.get(int_0, int_1);
  }

  public boolean method458() {
    boolean bool_0 = true;

    for (int int_0 = 0; int_0 < archiveIds.length; int_0++) {
      final int int_1 = archiveIds[int_0];
      if (packedArchives[int_1] == null) {
        fetch(int_1);
        if (packedArchives[int_1] == null) {
          bool_0 = false;
        }
      }
    }

    return bool_0;
  }

  public boolean method459(String name) {
    name = name.toLowerCase();
    final int int_0 = names.get(Class35.hash(name));
    return contains(int_0);
  }

  public void reset() {
    for (int int_0 = 0; int_0 < unpackedArchives.length; int_0++) {
      if (unpackedArchives[int_0] != null) {
        for (int int_1 = 0; int_1 < unpackedArchives[int_0].length; int_1++) {
          unpackedArchives[int_0][int_1] = null;
        }
      }
    }

  }

  public void clear(final int id) {
    for (int i = 0; i < unpackedArchives[id].length; i++) {
      unpackedArchives[id][i] = null;
    }
  }

  public void method461(String name) {
    name = name.toLowerCase();
    final int id = names.get(Class35.hash(name));
    if (id >= 0) {
      request(id);
    }
  }

}
