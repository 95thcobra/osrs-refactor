package jagex.oldschool.util;

public class Base64 {

  public static char[] ALPHABET;
  static char[] SAFE_ALPHABET;
  static int[] anIntArray55;

  static {
    ALPHABET = new char[64];

    int int_0;
    for (int_0 = 0; int_0 < 26; int_0++) {
      ALPHABET[int_0] = (char) (int_0 + 65);
    }

    for (int_0 = 26; int_0 < 52; int_0++) {
      ALPHABET[int_0] = (char) (int_0 + 97 - 26);
    }

    for (int_0 = 52; int_0 < 62; int_0++) {
      ALPHABET[int_0] = (char) (int_0 + 48 - 52);
    }

    ALPHABET[62] = 43;
    ALPHABET[63] = 47;
    SAFE_ALPHABET = new char[64];

    for (int_0 = 0; int_0 < 26; int_0++) {
      SAFE_ALPHABET[int_0] = (char) (int_0 + 65);
    }

    for (int_0 = 26; int_0 < 52; int_0++) {
      SAFE_ALPHABET[int_0] = (char) (int_0 + 97 - 26);
    }

    for (int_0 = 52; int_0 < 62; int_0++) {
      SAFE_ALPHABET[int_0] = (char) (int_0 + 48 - 52);
    }

    SAFE_ALPHABET[62] = 42;
    SAFE_ALPHABET[63] = 45;
    anIntArray55 = new int[128];

    for (int_0 = 0; int_0 < anIntArray55.length; int_0++) {
      anIntArray55[int_0] = -1;
    }

    for (int_0 = 65; int_0 <= 90; int_0++) {
      anIntArray55[int_0] = int_0 - 65;
    }

    for (int_0 = 97; int_0 <= 122; int_0++) {
      anIntArray55[int_0] = int_0 - 97 + 26;
    }

    for (int_0 = 48; int_0 <= 57; int_0++) {
      anIntArray55[int_0] = int_0 - 48 + 52;
    }

    final int[] ints_0 = anIntArray55;
    anIntArray55[43] = 62;
    ints_0[42] = 62;
    final int[] ints_1 = anIntArray55;
    anIntArray55[47] = 63;
    ints_1[45] = 63;
  }

  public static String method785(final byte[] bytes_0, final int int_0, final int int_1) {
    final StringBuilder stringbuilder_0 = new StringBuilder();

    for (int int_2 = int_0; int_2 < int_1 + int_0; int_2 += 3) {
      final int int_3 = bytes_0[int_2] & 0xFF;
      stringbuilder_0.append(ALPHABET[int_3 >>> 2]);
      if (int_2 < int_1 - 1) {
        final int int_4 = bytes_0[int_2 + 1] & 0xFF;
        stringbuilder_0.append(ALPHABET[(int_3 & 0x3) << 4 | int_4 >>> 4]);
        if (int_2 < int_1 - 2) {
          final int int_5 = bytes_0[int_2 + 2] & 0xFF;
          stringbuilder_0.append(ALPHABET[(int_4 & 0xF) << 2 | int_5 >>> 6])
              .append(ALPHABET[int_5 & 0x3F]);
        } else {
          stringbuilder_0.append(ALPHABET[(int_4 & 0xF) << 2]).append("=");
        }
      } else {
        stringbuilder_0.append(ALPHABET[(int_3 & 0x3) << 4]).append("==");
      }
    }

    return stringbuilder_0.toString();
  }
}
