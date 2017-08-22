package jagex.oldschool.device;

import jagex.oldschool.Class45;
import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;

public class MachineProfile extends Node {

  String aString21;
  int osType;
  int[] anIntArray83;
  String aString22;
  boolean os32Bit;
  String aString23;
  int osVersionType;
  String aString24;
  int javaVendorType;
  int javaVersionMajor;
  String aString25;
  int javaVersionMinor;
  String aString26;
  int javaVersionPatch;
  boolean aBool48;
  int maxMemoryMB;
  int anInt366;
  int anInt367;
  int anInt368;
  int anInt369;
  int anInt370;
  int anInt371;
  int anInt372;
  int anInt373;

  public MachineProfile(final boolean bool_0) {
    anIntArray83 = new int[3];
    if (Class45.formattedOsName.startsWith("win")) {
      osType = 1;
    } else if (Class45.formattedOsName.startsWith("mac")) {
      osType = 2;
    } else if (Class45.formattedOsName.startsWith("linux")) {
      osType = 3;
    } else {
      osType = 4;
    }

    String string_0;
    try {
      string_0 = System.getProperty("os.arch").toLowerCase();
    } catch (final Exception exception_0) {
      string_0 = "";
    }

    String string_1;
    try {
      string_1 = System.getProperty("os.version").toLowerCase();
    } catch (final Exception exception_1) {
      string_1 = "";
    }

    String string_2 = "Unknown";
    String string_3 = "1.1";

    try {
      string_2 = System.getProperty("java.vendor");
      string_3 = System.getProperty("java.version");
    } catch (final Exception exception_2) {
    }

    if (!string_0.startsWith("amd64") && !string_0.startsWith("x86_64")) {
      os32Bit = false;
    } else {
      os32Bit = true;
    }

    if (osType == 1) {
      if (string_1.indexOf("4.0") != -1) {
        osVersionType = 1;
      } else if (string_1.indexOf("4.1") != -1) {
        osVersionType = 2;
      } else if (string_1.indexOf("4.9") != -1) {
        osVersionType = 3;
      } else if (string_1.indexOf("5.0") != -1) {
        osVersionType = 4;
      } else if (string_1.indexOf("5.1") != -1) {
        osVersionType = 5;
      } else if (string_1.indexOf("5.2") != -1) {
        osVersionType = 8;
      } else if (string_1.indexOf("6.0") != -1) {
        osVersionType = 6;
      } else if (string_1.indexOf("6.1") != -1) {
        osVersionType = 7;
      } else if (string_1.indexOf("6.2") != -1) {
        osVersionType = 9;
      } else if (string_1.indexOf("6.3") != -1) {
        osVersionType = 10;
      } else if (string_1.indexOf("10.0") != -1) {
        osVersionType = 11;
      }
    } else if (osType == 2) {
      if (string_1.indexOf("10.4") != -1) {
        osVersionType = 20;
      } else if (string_1.indexOf("10.5") != -1) {
        osVersionType = 21;
      } else if (string_1.indexOf("10.6") != -1) {
        osVersionType = 22;
      } else if (string_1.indexOf("10.7") != -1) {
        osVersionType = 23;
      } else if (string_1.indexOf("10.8") != -1) {
        osVersionType = 24;
      } else if (string_1.indexOf("10.9") != -1) {
        osVersionType = 25;
      } else if (string_1.indexOf("10.10") != -1) {
        osVersionType = 26;
      } else if (string_1.indexOf("10.11") != -1) {
        osVersionType = 27;
      }
    }

    if (string_2.toLowerCase().indexOf("sun") != -1) {
      javaVendorType = 1;
    } else if (string_2.toLowerCase().indexOf("microsoft") != -1) {
      javaVendorType = 2;
    } else if (string_2.toLowerCase().indexOf("apple") != -1) {
      javaVendorType = 3;
    } else if (string_2.toLowerCase().indexOf("oracle") != -1) {
      javaVendorType = 5;
    } else {
      javaVendorType = 4;
    }

    int int_0 = 2;
    int int_1 = 0;

    char char_0;
    try {
      while (int_0 < string_3.length()) {
        char_0 = string_3.charAt(int_0);
        if (char_0 < 48 || char_0 > 57) {
          break;
        }

        int_1 = char_0 - 48 + int_1 * 10;
        ++int_0;
      }
    } catch (final Exception exception_3) {
    }

    javaVersionMajor = int_1;
    int_0 = string_3.indexOf(46, 2) + 1;
    int_1 = 0;

    try {
      while (int_0 < string_3.length()) {
        char_0 = string_3.charAt(int_0);
        if (char_0 < 48 || char_0 > 57) {
          break;
        }

        int_1 = int_1 * 10 + char_0 - 48;
        ++int_0;
      }
    } catch (final Exception exception_4) {
    }

    javaVersionMinor = int_1;
    int_0 = string_3.indexOf(95, 4) + 1;
    int_1 = 0;

    try {
      while (int_0 < string_3.length()) {
        char_0 = string_3.charAt(int_0);
        if (char_0 < 48 || char_0 > 57) {
          break;
        }

        int_1 = int_1 * 10 + char_0 - 48;
        ++int_0;
      }
    } catch (final Exception exception_5) {
    }

    javaVersionPatch = int_1;
    aBool48 = false;
    maxMemoryMB = (int) (Runtime.getRuntime().maxMemory() / 1048576L) + 1;
    if (javaVersionMajor > 3) {
      anInt366 = Runtime.getRuntime().availableProcessors();
    } else {
      anInt366 = 0;
    }

    anInt367 = 0;
    if (aString21 == null) {
      aString21 = "";
    }

    if (aString22 == null) {
      aString22 = "";
    }

    if (aString23 == null) {
      aString23 = "";
    }

    if (aString24 == null) {
      aString24 = "";
    }

    if (aString25 == null) {
      aString25 = "";
    }

    if (aString26 == null) {
      aString26 = "";
    }

    method680();
  }

  void method680() {
    if (aString21.length() > 40) {
      aString21 = aString21.substring(0, 40);
    }

    if (aString22.length() > 40) {
      aString22 = aString22.substring(0, 40);
    }

    if (aString23.length() > 10) {
      aString23 = aString23.substring(0, 10);
    }

    if (aString24.length() > 10) {
      aString24 = aString24.substring(0, 10);
    }

  }

  public int method681() {
    final byte byte_0 = 38;
    final String string_0 = aString21;
    final int int_0 = string_0.length() + 2;
    int int_6 = int_0 + byte_0;
    final String string_1 = aString22;
    final int int_1 = string_1.length() + 2;
    int_6 += int_1;
    final String string_2 = aString23;
    final int int_2 = string_2.length() + 2;
    int_6 += int_2;
    final String string_3 = aString24;
    final int int_3 = string_3.length() + 2;
    int_6 += int_3;
    final String string_4 = aString25;
    final int int_4 = string_4.length() + 2;
    int_6 += int_4;
    final String string_5 = aString26;
    final int int_5 = string_5.length() + 2;
    int_6 += int_5;
    return int_6;
  }

  public void method682(final Buffer buffer_0) {
    buffer_0.putByte(6);
    buffer_0.putByte(osType);
    buffer_0.putByte(os32Bit ? 1 : 0);
    buffer_0.putByte(osVersionType);
    buffer_0.putByte(javaVendorType);
    buffer_0.putByte(javaVersionMajor);
    buffer_0.putByte(javaVersionMinor);
    buffer_0.putByte(javaVersionPatch);
    buffer_0.putByte(aBool48 ? 1 : 0);
    buffer_0.putShort(maxMemoryMB);
    buffer_0.putByte(anInt366);
    buffer_0.putMedium(anInt367);
    buffer_0.putShort(anInt368);
    buffer_0.putPrefixedString(aString21);
    buffer_0.putPrefixedString(aString22);
    buffer_0.putPrefixedString(aString23);
    buffer_0.putPrefixedString(aString24);
    buffer_0.putByte(anInt369);
    buffer_0.putShort(anInt370);
    buffer_0.putPrefixedString(aString25);
    buffer_0.putPrefixedString(aString26);
    buffer_0.putByte(anInt371);
    buffer_0.putByte(anInt372);

    for (int int_0 = 0; int_0 < anIntArray83.length; int_0++) {
      buffer_0.putInt(anIntArray83[int_0]);
    }

    buffer_0.putInt(anInt373);
  }

}
