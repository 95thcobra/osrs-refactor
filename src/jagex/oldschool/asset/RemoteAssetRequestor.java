package jagex.oldschool.asset;

import jagex.oldschool.io.CacheWorker;
import jagex.oldschool.collections.HashTable;
import jagex.oldschool.collections.Queue;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.SocketStream;
import java.util.zip.CRC32;

public class RemoteAssetRequestor {

  public static int anInt190;
  public static int anInt191;
  public static HashTable aHashTable3;
  public static int anInt192;
  public static HashTable aHashTable4;
  public static Queue passiveRequests;
  public static int anInt193;
  public static RemoteRequest current;
  public static HashTable aHashTable5;
  public static long aLong11;
  public static int anInt194;
  public static HashTable aHashTable6;
  public static int anInt195;
  public static Package[] requestors;
  public static int anInt196;
  public static SocketStream aSocketStream2;
  public static Buffer aBuffer5;
  public static int anInt197;
  public static CRC32 aCRC32_1;
  public static byte aByte1;
  public static boolean aBool23;

  static {
    anInt191 = 0;
    aHashTable4 = new HashTable(4096);
    anInt193 = 0;
    aHashTable5 = new HashTable(32);
    anInt194 = 0;
    passiveRequests = new Queue();
    aHashTable3 = new HashTable(4096);
    anInt195 = 0;
    aHashTable6 = new HashTable(4096);
    anInt196 = 0;
    aBuffer5 = new Buffer(8);
    anInt197 = 0;
    aCRC32_1 = new CRC32();
    requestors = new Package[256];
    aByte1 = 0;
    anInt190 = 0;
    anInt192 = 0;
  }

  public static void validateRequests() {
    while (true) {
      LocalRequest request;
      synchronized (CacheWorker.aDeque1) {
        request = (LocalRequest) CacheWorker.requests.pollFirst();
      }

      if (request == null) {
        return;
      }

      request.requestor
          .validate(request.cache, (int) request.hash, request.bytes, false);
    }
  }
}
