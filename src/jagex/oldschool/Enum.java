package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.ui.Inventory;

public class Enum extends Subnode {

  static Cache aNodeCache10;
  static Package vorbisIndex;
  static AbstractPackage anIndexDataBase22;

  static {
    aNodeCache10 = new Cache(64);
  }

  public String defaultString;
  public char keyType;
  public char valType;
  public int size;
  public int defaultInt;
  public int[] keys;
  public String[] stringVals;
  public int[] intVals;

  Enum() {
    defaultString = "null";
    size = 0;
  }

  public static int method829(final int int_0, final int int_1) {
    final Inventory itemcontainer_0 = (Inventory) Inventory.inventories.get(int_0);
    return itemcontainer_0 == null ? 0
        : int_1 >= 0 && int_1 < itemcontainer_0.counts.length
            ? itemcontainer_0.counts[int_1] : 0;
  }

  void method828(final Buffer buffer_0, final int int_0) {
    if (int_0 == 1) {
      keyType = (char) buffer_0.getUnsignedByte();
    } else {
      if (int_0 == 2) {
        valType = (char) buffer_0.getUnsignedByte();
        return;
      }

      if (int_0 == 3) {
        defaultString = buffer_0.getString();
        return;
      }

      if (int_0 == 4) {
        defaultInt = buffer_0.getInt();
        return;
      }

      int int_1;
      if (int_0 == 5) {
        size = buffer_0.getUnsignedShort();
        keys = new int[size];
        stringVals = new String[size];

        for (int_1 = 0; int_1 < size; int_1++) {
          keys[int_1] = buffer_0.getInt();
          stringVals[int_1] = buffer_0.getString();
        }

        return;
      }

      if (int_0 == 6) {
        size = buffer_0.getUnsignedShort();
        keys = new int[size];
        intVals = new int[size];

        for (int_1 = 0; int_1 < size; int_1++) {
          keys[int_1] = buffer_0.getInt();
          intVals[int_1] = buffer_0.getInt();
        }
      }
    }

  }

  void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method828(buffer_0, int_0);
    }
  }

}
