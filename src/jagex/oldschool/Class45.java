package jagex.oldschool;

import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Class45 {

  public static Comparator aComparator1;
  public static String formattedOsName;
  public static Comparator aComparator2;
  public static Comparator aComparator3;
  public static Comparator aComparator4;
  static DirectSprite[] pkIcons;
  static int anInt96;

  static {
    aComparator1 = new Class52();
    new Class35();
    aComparator2 = new Comparator0();
    aComparator3 = new Class47();
    aComparator4 = new Class31();
  }

  public final List aList3;

  public Class45(final Buffer buffer_0, final boolean bool_0) {
    final int int_0 = buffer_0.getUnsignedShort();
    final boolean bool_1 = buffer_0.getUnsignedByte() == 1;
    byte byte_0;
    if (bool_1) {
      byte_0 = 1;
    } else {
      byte_0 = 0;
    }

    final int int_1 = buffer_0.getUnsignedShort();
    aList3 = new ArrayList(int_1);

    for (int int_2 = 0; int_2 < int_1; int_2++) {
      aList3.add(new Class44(buffer_0, byte_0, int_0));
    }

  }

  static int method287() {
    return Client.isResized ? 2 : 1;
  }

  public static void method288(final File file_0, final File file_1) {
    try {
      final FileOnDisk fileondisk_0 = new FileOnDisk(LocalInstall.aFile2, "rw", 10000L);
      final Buffer buffer_0 = new Buffer(500);
      buffer_0.putByte(3);
      buffer_0.putByte(file_1 != null ? 1 : 0);
      buffer_0.putCESU8(file_0.getPath());
      if (file_1 != null) {
        buffer_0.putCESU8("");
      }

      fileondisk_0.write(buffer_0.bytes, 0, buffer_0.offset);
      fileondisk_0.close();
    } catch (final IOException ioexception_0) {
      ioexception_0.printStackTrace();
    }
  }

  public static void method289() {
    while (true) {
      final AClass3 aclass3_0 = (AClass3) Class38.aCombatInfoList1.poll();
      if (aclass3_0 == null) {
        return;
      }

      aclass3_0.method618();
    }
  }

  public static int method290(final int int_0, final Script script_0, final boolean bool_0) {
    final InterfaceComponent widget_0 = ScriptExecutor
        .method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
    if (int_0 == 2600) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollX;
      return 1;
    }
    if (int_0 == 2601) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollY;
      return 1;
    }
    if (int_0 == 2602) {
      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_0.text;
      return 1;
    }
    if (int_0 == 2603) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollWidth;
      return 1;
    }
    if (int_0 == 2604) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.scrollHeight;
      return 1;
    }
    if (int_0 == 2605) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.modelZoom;
      return 1;
    }
    if (int_0 == 2606) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationX;
      return 1;
    }
    if (int_0 == 2607) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationY;
      return 1;
    }
    if (int_0 == 2608) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.rotationZ;
      return 1;
    }
    if (int_0 == 2609) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.opacity;
      return 1;
    }
    if (int_0 == 2610) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anInt279;
      return 1;
    }
    if (int_0 == 2611) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.textColor;
      return 1;
    }
    if (int_0 == 2612) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anInt274;
      return 1;
    }
    if (int_0 == 2613) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.anEnum9_1.mappedOrdinal();
      return 1;
    }
    return 2;
  }

  public void method286(final Comparator comparator_0, final boolean bool_0) {
    if (bool_0) {
      Collections.sort(aList3, comparator_0);
    } else {
      Collections.sort(aList3, Collections.reverseOrder(comparator_0));
    }
  }

}
