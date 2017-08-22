package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.SoundEffect;
import jagex.oldschool.collections.HashTable;
import jagex.oldschool.io.Buffer;

public class Class55 {

  public static Buffer releaseManifest;
  AbstractPackage vorbis_index;
  AbstractPackage sfx_index;
  HashTable aHashTable1;
  HashTable aHashTable2;

  public Class55(final AbstractPackage indexdatabase_0, final AbstractPackage indexdatabase_1) {
    aHashTable2 = new HashTable(256);
    aHashTable1 = new HashTable(256);
    sfx_index = indexdatabase_0;
    vorbis_index = indexdatabase_1;
  }

  AClass5_Sub1 method350(final int int_0, final int int_1, final int[] ints_0) {
    int int_2 = int_1 ^ (int_0 << 4 & 0xFFFF | int_0 >>> 12);
    int_2 |= int_0 << 16;
    final long long_0 = int_2;
    AClass5_Sub1 aclass5_sub1_0 = (AClass5_Sub1) aHashTable1.get(long_0);
    if (aclass5_sub1_0 != null) {
      return aclass5_sub1_0;
    }
    if (ints_0 != null && ints_0[0] <= 0) {
      return null;
    }
    final SoundEffect soundeffect_0 = SoundEffect.getTrack(sfx_index, int_0, int_1);
    if (soundeffect_0 == null) {
      return null;
    }
    aclass5_sub1_0 = soundeffect_0.method428();
    aHashTable1.put(aclass5_sub1_0, long_0);
    if (ints_0 != null) {
      ints_0[0] -= aclass5_sub1_0.aByteArray18.length;
    }

    return aclass5_sub1_0;
  }

  AClass5_Sub1 method351(final int int_0, final int int_1, final int[] ints_0) {
    int int_2 = int_1 ^ (int_0 << 4 & 0xFFFF | int_0 >>> 12);
    int_2 |= int_0 << 16;
    final long long_0 = int_2 ^ 0x100000000L;
    AClass5_Sub1 aclass5_sub1_0 = (AClass5_Sub1) aHashTable1.get(long_0);
    if (aclass5_sub1_0 != null) {
      return aclass5_sub1_0;
    }
    if (ints_0 != null && ints_0[0] <= 0) {
      return null;
    }
    Node_Sub2 node_sub2_0 = (Node_Sub2) aHashTable2.get(long_0);
    if (node_sub2_0 == null) {
      node_sub2_0 = Node_Sub2.method646(vorbis_index, int_0, int_1);
      if (node_sub2_0 == null) {
        return null;
      }

      aHashTable2.put(node_sub2_0, long_0);
    }

    aclass5_sub1_0 = node_sub2_0.method643(ints_0);
    if (aclass5_sub1_0 == null) {
      return null;
    }
    node_sub2_0.unlink();
    aHashTable1.put(aclass5_sub1_0, long_0);
    return aclass5_sub1_0;
  }

  public AClass5_Sub1 method352(final int int_0, final int[] ints_0) {
    if (sfx_index.size() == 1) {
      return method350(0, int_0, ints_0);
    }
    if (sfx_index.fileCount(int_0) == 1) {
      return method350(int_0, 0, ints_0);
    }
    throw new RuntimeException();
  }

  public AClass5_Sub1 method353(final int int_0, final int[] ints_0) {
    if (vorbis_index.size() == 1) {
      return method351(0, int_0, ints_0);
    }
    if (vorbis_index.fileCount(int_0) == 1) {
      return method351(int_0, 0, ints_0);
    }
    throw new RuntimeException();
  }

}
