package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.ui.Inventory;

public final class GroundItem extends Renderable {

  int id;
  int quantity;

  public static int method931(final int int_0, final int int_1) {
    final Inventory itemcontainer_0 = (Inventory) Inventory.inventories.get(int_0);
    return itemcontainer_0 == null ? -1
        : int_1 >= 0 && int_1 < itemcontainer_0.ids.length ? itemcontainer_0.ids[int_1]
            : -1;
  }

  @Override
  protected final Model getModel() {
    return AudioWorker.getItemDefinition(id).getModel(quantity);
  }

}
