package jagex.oldschool.asset;

import jagex.oldschool.CacheableNode_Sub3;
import jagex.oldschool.Class37;
import jagex.oldschool.Class55;
import jagex.oldschool.map.MapAsset;
import jagex.oldschool.Class63;
import jagex.oldschool.io.CacheWorker;
import jagex.oldschool.DecorativeObject;
import jagex.oldschool.Enum5;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.util.GzipDecompressor;
import java.util.zip.CRC32;

public class Package extends AbstractPackage {

  static CRC32 crc;

  static {
    crc = new CRC32();
  }

  FileCache manifests;
  FileCache archives;
  int providedChecksum;
  boolean aBool40;
  int id;
  boolean[] aBoolArray5;
  int providedVersion;
  int anInt300;
  boolean loadPassive;

  public Package(final FileCache archives, final FileCache manifests, final int id,
      final boolean removePacked, final boolean removeUnpacked, final boolean loadPassive) {
    super(removePacked, removeUnpacked);
    aBool40 = false;
    this.loadPassive = false;
    anInt300 = -1;
    this.archives = archives;
    this.manifests = manifests;
    this.id = id;
    this.loadPassive = loadPassive;

    final int i = this.id;
    if (Class55.releaseManifest != null) {
      Class55.releaseManifest.offset = i * 8 + 5;
      final int checksum = Class55.releaseManifest.getInt();
      final int build = Class55.releaseManifest.getInt();
      setBuild(checksum, build);
    } else {
      Class63.fetch(null, 255, 255, 0, (byte) 0, true);
      RemoteAssetRequestor.requestors[i] = this;
    }
  }

  public static DirectSprite method609(final AbstractPackage indexdatabase_0, final String string_0,
      final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    return CacheableNode_Sub3.method846(indexdatabase_0, int_0, int_1);
  }

  @Override
  void fetch(final int id) {
    if (archives != null && aBoolArray5 != null && aBoolArray5[id]) {
      Keyboard.fetch(id, archives, this);
    } else {
      Class63.fetch(this, this.id, id, super.checksums[id], (byte) 2, true);
    }
  }

  @Override
  int method448(final int id) {
    if (super.packedArchives[id] != null) {
      return 100;
    }
    if (aBoolArray5[id]) {
      return 100;
    }
    final int int_1 = this.id;
    final long hash = (int_1 << 16) + id;
    int int_2;
    if (RemoteAssetRequestor.current != null && hash == RemoteAssetRequestor.current.hash) {
      int_2 = MapAsset.aBuffer1.offset * 99
          / (MapAsset.aBuffer1.bytes.length - RemoteAssetRequestor.current.padding) + 1;
    } else {
      int_2 = 0;
    }

    return int_2;
  }

  void method605() {
    aBoolArray5 = new boolean[super.packedArchives.length];

    int int_0;
    for (int_0 = 0; int_0 < aBoolArray5.length; int_0++) {
      aBoolArray5[int_0] = false;
    }

    if (archives == null) {
      aBool40 = true;
    } else {
      anInt300 = -1;

      for (int_0 = 0; int_0 < aBoolArray5.length; int_0++) {
        if (super.sizes[int_0] > 0) {
          DecorativeObject.method478(int_0, archives, this);
          anInt300 = int_0;
        }
      }

      if (anInt300 == -1) {
        aBool40 = true;
      }

    }
  }

  @Override
  void request(final int id) {
    final int int_1 = this.id;
    final long hash = (int_1 << 16) + id;
    final RemoteRequest request = (RemoteRequest) RemoteAssetRequestor.aHashTable3.get(hash);
    if (request != null) {
      RemoteAssetRequestor.passiveRequests.addLast(request);
    }
  }

  public void validate(final FileCache indexfile_0, final int int_0, final byte[] bytes_0,
      final boolean bool_0) {
    int int_1;
    if (indexfile_0 == manifests) {
      if (aBool40) {
        throw new RuntimeException();
      }

      if (bytes_0 == null) {
        Class63.fetch(this, 255, id, providedChecksum, (byte) 0, true);
        return;
      }

      crc.reset();
      crc.update(bytes_0, 0, bytes_0.length);
      int_1 = (int) crc.getValue();
      final Buffer buffer_0 = new Buffer(GzipDecompressor.decompress(bytes_0));
      final int int_3 = buffer_0.getUnsignedByte();
      if (int_3 != 5 && int_3 != 6) {
        throw new RuntimeException(int_3 + "," + id + "," + int_0);
      }

      int int_4 = 0;
      if (int_3 >= 6) {
        int_4 = buffer_0.getInt();
      }

      if (int_1 != providedChecksum || int_4 != providedVersion) {
        Class63.fetch(this, 255, id, providedChecksum, (byte) 0, true);
        return;
      }

      parse(bytes_0);
      method605();
    } else {
      if (!bool_0 && int_0 == anInt300) {
        aBool40 = true;
      }

      if (bytes_0 == null || bytes_0.length <= 2) {
        aBoolArray5[int_0] = false;
        if (loadPassive || bool_0) {
          Class63.fetch(this, id, int_0, super.checksums[int_0], (byte) 2, bool_0);
        }

        return;
      }

      crc.reset();
      crc.update(bytes_0, 0, bytes_0.length - 2);
      int_1 = (int) crc.getValue();
      final int int_2 =
          ((bytes_0[bytes_0.length - 2] & 0xFF) << 8) + (bytes_0[bytes_0.length - 1] & 0xFF);
      if (int_1 != super.checksums[int_0] || int_2 != super.versions[int_0]) {
        aBoolArray5[int_0] = false;
        if (loadPassive || bool_0) {
          Class63.fetch(this, id, int_0, super.checksums[int_0], (byte) 2, bool_0);
        }

        return;
      }

      aBoolArray5[int_0] = true;
      if (bool_0) {
        super.packedArchives[int_0] = Class37.wrap(bytes_0);
        return;
      }
    }

  }

  public void setBuild(final int checksum, final int version) {
    providedChecksum = checksum;
    providedVersion = version;
    if (manifests != null) {
      Keyboard.fetch(id, manifests, this);
    } else {
      Class63.fetch(this, 255, id, providedChecksum, (byte) 0, true);
    }
  }

  public int getLoadedPercent() {
    if (aBool40) {
      return 100;
    }
    if (super.packedArchives != null) {
      return 99;
    }
    final int int_0 = id;
    final long long_0 = int_0 + 16711680;
    int int_1;
    if (RemoteAssetRequestor.current != null && long_0 == RemoteAssetRequestor.current.hash) {
      int_1 = MapAsset.aBuffer1.offset * 99
          / (MapAsset.aBuffer1.bytes.length - RemoteAssetRequestor.current.padding) + 1;
    } else {
      int_1 = 0;
    }

    int int_2 = int_1;
    if (int_1 >= 100) {
      int_2 = 99;
    }

    return int_2;
  }

  public int method607() {
    int int_0 = 0;
    int int_1 = 0;

    int int_2;
    for (int_2 = 0; int_2 < super.packedArchives.length; int_2++) {
      if (super.sizes[int_2] > 0) {
        int_0 += 100;
        int_1 += method448(int_2);
      }
    }

    if (int_0 == 0) {
      return 100;
    }
    int_2 = int_1 * 100 / int_0;
    return int_2;
  }

  public void method608(final int int_0, final byte[] bytes_0, final boolean bool_0,
      final boolean bool_1) {
    if (bool_0) {
      if (aBool40) {
        throw new RuntimeException();
      }
      if (manifests != null) {
        final int int_1 = id;
        final FileCache indexfile_1 = manifests;
        final LocalRequest filesystem_1 = new LocalRequest();
        filesystem_1.id = 0;
        filesystem_1.hash = int_1;
        filesystem_1.bytes = bytes_0;
        filesystem_1.cache = indexfile_1;
        synchronized (CacheWorker.aDeque1) {
          CacheWorker.aDeque1.addLast(filesystem_1);
        }

        Enum5.method663();
      }

      parse(bytes_0);
      method605();
    } else {
      bytes_0[bytes_0.length - 2] = (byte) (super.versions[int_0] >> 8);
      bytes_0[bytes_0.length - 1] = (byte) super.versions[int_0];
      if (archives != null) {
        final FileCache indexfile_0 = archives;
        final LocalRequest filesystem_0 = new LocalRequest();
        filesystem_0.id = 0;
        filesystem_0.hash = int_0;
        filesystem_0.bytes = bytes_0;
        filesystem_0.cache = indexfile_0;
        synchronized (CacheWorker.aDeque1) {
          CacheWorker.aDeque1.addLast(filesystem_0);
        }

        Enum5.method663();
        aBoolArray5[int_0] = true;
      }

      if (bool_1) {
        super.packedArchives[int_0] = Class37.wrap(bytes_0);
      }

    }
  }

}
