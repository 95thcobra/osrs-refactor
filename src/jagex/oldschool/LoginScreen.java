package jagex.oldschool;

import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.scene.Scene;

public class LoginScreen {

  public static char aChar1;
  static int anInt98;
  static int loginWindowX;
  static int[] anIntArray20;
  public static int loginIndex;
  static int anInt99;
  static int anInt100;
  static int anInt101;
  static int anInt102;
  static int anInt103;
  static int anInt104;
  static int loadingPercent;
  static String loadingText;
  static String aString10;
  static String loginMessage1;
  static String loginMessage2;
  static String loginMessage3;
  static String username;
  static boolean selectWorld;
  static String password;
  static Enum3 anEnum3_1;
  static boolean aBool14;
  static int loginIndex2;
  static int anInt105;
  static IndexedSprite[] anIndexedSpriteArray5;
  static IndexedSprite anIndexedSprite3;
  static int anInt106;
  static int[] anIntArray21;
  static IndexedSprite anIndexedSprite4;
  static IndexedSprite[] anIndexedSpriteArray6;
  static int[] anIntArray22;
  public static boolean aBool15;
  static int[] anIntArray23;

  static {
    anInt98 = 0;
    loginWindowX = anInt98 + 202;
    anIntArray20 = new int[256];
    anInt99 = 0;
    anInt100 = 0;
    anInt101 = 0;
    anInt102 = 0;
    anInt103 = 0;
    anInt104 = 0;
    loadingPercent = 10;
    loadingText = "";
    loginIndex = 0;
    aString10 = "";
    loginMessage1 = "";
    loginMessage2 = "";
    loginMessage3 = "";
    username = "";
    password = "";
    anEnum3_1 = Enum3.anEnum3_4;
    aBool14 = true;
    loginIndex2 = 0;
    selectWorld = false;
    anInt105 = -1;
  }

  static void method300() {
    Scene.lowMemory = false;
    Client.lowMemory = false;
  }

  public static void method301(final String[] strings_0, final short[] shorts_0) {
    AClass1_Sub2.method625(strings_0, shorts_0, 0, strings_0.length - 1);
  }

}
