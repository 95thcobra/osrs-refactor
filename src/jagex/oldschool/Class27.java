package jagex.oldschool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Comparator;

final class Class27 implements Comparator {

  static int anInt76;
  final boolean val$preferOwnWorld;

  Class27(final boolean bool_0) {
    val$preferOwnWorld = bool_0;
  }

  static String method234(Throwable throwable_0) throws IOException {
    String string_0;
    if (throwable_0 instanceof NestedException) {
      final NestedException runtimeexception_sub1_0 = (NestedException) throwable_0;
      string_0 = runtimeexception_sub1_0.aString32 + " | ";
      throwable_0 = runtimeexception_sub1_0.aThrowable1;
    } else {
      string_0 = "";
    }

    final StringWriter stringwriter_0 = new StringWriter();
    final PrintWriter printwriter_0 = new PrintWriter(stringwriter_0);
    throwable_0.printStackTrace(printwriter_0);
    printwriter_0.close();
    final String string_1 = stringwriter_0.toString();
    final BufferedReader bufferedreader_0 = new BufferedReader(new StringReader(string_1));
    final String string_2 = bufferedreader_0.readLine();

    while (true) {
      while (true) {
        String string_3 = bufferedreader_0.readLine();
        if (string_3 == null) {
          string_0 = string_0 + "| " + string_2;
          return string_0;
        }

        final int int_0 = string_3.indexOf(40);
        final int int_1 = string_3.indexOf(41, int_0 + 1);
        if (int_0 >= 0 && int_1 >= 0) {
          String string_4 = string_3.substring(int_0 + 1, int_1);
          final int int_2 = string_4.indexOf(".java:");
          if (int_2 >= 0) {
            string_4 = string_4.substring(0, int_2) + string_4.substring(int_2 + 5);
            string_0 = string_0 + string_4 + ' ';
            continue;
          }

          string_3 = string_3.substring(0, int_0);
        }

        string_3 = string_3.trim();
        string_3 = string_3.substring(string_3.lastIndexOf(32) + 1);
        string_3 = string_3.substring(string_3.lastIndexOf(9) + 1);
        string_0 = string_0 + string_3 + ' ';
      }
    }
  }

  public static boolean method235(final int int_0) {
    return (int_0 >> 28 & 0x1) != 0;
  }

  int method233(final Class44 class44_0, final Class44 class44_1) {
    if (class44_1.anInt95 == class44_0.anInt95) {
      return 0;
    }
    if (val$preferOwnWorld) {
      if (Client.world == class44_0.anInt95) {
        return -1;
      }

      if (class44_1.anInt95 == Client.world) {
        return 1;
      }
    }

    return class44_0.anInt95 < class44_1.anInt95 ? -1 : 1;
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method233((Class44) object_0, (Class44) object_1);
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

}
