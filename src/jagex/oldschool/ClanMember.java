package jagex.oldschool;

import jagex.oldschool.collections.Node;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.io.FileCache;

public class ClanMember extends Node {

  static FileCache anIndexFile3;
  String aString19;
  public String username;
  public int world;
  public byte rank;

  public static void method655() {
    CacheableNode_Sub2.aNodeCache12.reset();
    CacheableNode_Sub2.aNodeCache13.reset();
    CacheableNode_Sub2.aNodeCache11.reset();
  }

  public static boolean method656() {
    synchronized (Keyboard.keyboard) {
      if (Keyboard.anInt128 == Keyboard.anInt126) {
        return false;
      }
      Class3.anInt22 = Keyboard.anIntArray31[Keyboard.anInt126];
      LoginScreen.aChar1 = Keyboard.aCharArray1[Keyboard.anInt126];
      Keyboard.anInt126 = Keyboard.anInt126 + 1 & 0x7F;
      return true;
    }
  }

}
