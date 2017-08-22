package jagex.oldschool.config;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class InventoryConfig extends Subnode {

  public static Cache inventoryCache;
  public static AbstractPackage anIndexDataBase17;

  static {
    inventoryCache = new Cache(64);
  }

  public int size;

  public InventoryConfig() {
    size = 0;
  }

  void method773(final Buffer buffer_0, final int int_0) {
    if (int_0 == 2) {
      size = buffer_0.getUnsignedShort();
    }

  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      method773(buffer_0, int_0);
    }
  }

}
