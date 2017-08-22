package jagex.oldschool;

import jagex.oldschool.scene.Mobile;
import java.io.File;
import java.io.RandomAccessFile;

public class Class13 {

  static int[] anIntArray2;
  final int anInt58;
  final int anInt59;
  final int anInt60;

  Class13(final int int_0, final int int_1, final int int_2) {
    anInt58 = int_0;
    anInt59 = int_1;
    anInt60 = int_2;
  }

  public static boolean method166(final int int_0) {
    return int_0 >= Enum6.anEnum6_21.anInt364 && int_0 <= Enum6.anEnum6_22.anInt364;
  }

  public static void method167(final String string_0, final boolean bool_0, final boolean bool_1) {
    Class35.method254(string_0, bool_0, "openjs", bool_1);
  }

  public static File method168(final String string_0) {
    if (!Class65.aBool20) {
      throw new RuntimeException("");
    }
    final File file_0 = (File) Class65.aHashtable1.get(string_0);
    if (file_0 != null) {
      return file_0;
    }
    final File file_1 = new File(Class65.aFile3, string_0);
    RandomAccessFile randomaccessfile_0 = null;

    try {
      final File file_2 = new File(file_1.getParent());
      if (!file_2.exists()) {
        throw new RuntimeException("");
      }
      randomaccessfile_0 = new RandomAccessFile(file_1, "rw");
      final int int_0 = randomaccessfile_0.read();
      randomaccessfile_0.seek(0L);
      randomaccessfile_0.write(int_0);
      randomaccessfile_0.seek(0L);
      randomaccessfile_0.close();
      Class65.aHashtable1.put(string_0, file_1);
      return file_1;
    } catch (final Exception exception_0) {
      try {
        if (randomaccessfile_0 != null) {
          randomaccessfile_0.close();
          randomaccessfile_0 = null;
        }
      } catch (final Exception exception_1) {
      }

      throw new RuntimeException();
    }
  }

  static void characterToScreen(final Mobile actor_0, final int int_0) {
    Class38.method266(actor_0.x, actor_0.y, int_0);
  }

  public static void method169(final int int_0, final boolean bool_0, final int int_1,
      final boolean bool_1) {
    if (World.worldList != null) {
      Ignore.method537(0, World.worldList.length - 1, int_0, bool_0, int_1, bool_1);
    }

  }

}
