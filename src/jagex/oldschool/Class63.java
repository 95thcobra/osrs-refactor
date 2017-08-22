package jagex.oldschool;

import jagex.oldschool.asset.Package;
import jagex.oldschool.asset.RemoteAssetRequestor;
import jagex.oldschool.asset.RemoteRequest;

public class Class63 {

  static int anInt160;
  static int anInt161;
  static int anInt162;
  static byte[][] aByteArrayArray4;
  static byte[][] aByteArrayArray5;
  static byte[][] aByteArrayArray6;

  static {
    anInt160 = 0;
    anInt161 = 0;
    anInt162 = 0;
    aByteArrayArray4 = new byte[1000][];
    aByteArrayArray5 = new byte[250][];
    aByteArrayArray6 = new byte[50][];
  }

  public static synchronized byte[] getPooledBuffer(final int int_0) {
    byte[] bytes_0;
    if (int_0 == 100 && anInt160 > 0) {
      bytes_0 = aByteArrayArray4[--anInt160];
      aByteArrayArray4[anInt160] = null;
      return bytes_0;
    }
    if (int_0 == 5000 && anInt161 > 0) {
      bytes_0 = aByteArrayArray5[--anInt161];
      aByteArrayArray5[anInt161] = null;
      return bytes_0;
    }
    if (int_0 == 30000 && anInt162 > 0) {
      bytes_0 = aByteArrayArray6[--anInt162];
      aByteArrayArray6[anInt162] = null;
      return bytes_0;
    }
    return new byte[int_0];
  }

  public static void fetch(final Package indexdata_0, final int int_0, final int int_1,
      final int checksum,
      final byte padding, final boolean bool_0) {
    final long long_0 = (int_0 << 16) + int_1;
    RemoteRequest filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable4.get(long_0);
    if (filerequest_0 == null) {
      filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable5.get(long_0);
      if (filerequest_0 == null) {
        filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable3.get(long_0);
        if (filerequest_0 != null) {
          if (bool_0) {
            filerequest_0.unlinkSubnode();
            RemoteAssetRequestor.aHashTable4.put(filerequest_0, long_0);
            --RemoteAssetRequestor.anInt195;
            ++RemoteAssetRequestor.anInt193;
          }

        } else {
          if (!bool_0) {
            filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable6.get(long_0);
            if (filerequest_0 != null) {
              return;
            }
          }

          filerequest_0 = new RemoteRequest();
          filerequest_0.index = indexdata_0;
          filerequest_0.checksum = checksum;
          filerequest_0.padding = padding;
          if (bool_0) {
            RemoteAssetRequestor.aHashTable4.put(filerequest_0, long_0);
            ++RemoteAssetRequestor.anInt193;
          } else {
            RemoteAssetRequestor.passiveRequests.addFirst(filerequest_0);
            RemoteAssetRequestor.aHashTable3.put(filerequest_0, long_0);
            ++RemoteAssetRequestor.anInt195;
          }
        }
      }
    }
  }

}
