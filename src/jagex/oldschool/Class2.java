package jagex.oldschool;

import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Square;
import jagex.oldschool.ui.InterfaceComponent;

public class Class2 {

  static int len;

  public static ObjectConfig getObjectConfig(final int int_0) {
    ObjectConfig objectcomposition_0 = (ObjectConfig) ObjectConfig.objects
        .get(int_0);
    if (objectcomposition_0 != null) {
      return objectcomposition_0;
    }
    final byte[] bytes_0 = ObjectConfig.objects_ref.get(6, int_0);
    objectcomposition_0 = new ObjectConfig();
    objectcomposition_0.id = int_0;
    if (bytes_0 != null) {
      objectcomposition_0.decode(new Buffer(bytes_0));
    }

    objectcomposition_0.post();
    if (objectcomposition_0.isSolid) {
      objectcomposition_0.interactType = 0;
      objectcomposition_0.aBool55 = false;
    }

    ObjectConfig.objects.put(objectcomposition_0, int_0);
    return objectcomposition_0;
  }

  static void method118() {
    Client.menuOptionCount = 0;
    Client.isMenuOpen = false;
    Client.menuOptions[0] = "Cancel";
    Client.menuTargets[0] = "";
    Client.menuTypes[0] = 1006;
    Client.aBoolArray11[0] = false;
    Client.menuOptionCount = 1;
  }

  static void method119() {
    Client.anInt655 = 0;
    final int int_0 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
    final int int_1 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
    if (int_0 >= 3053 && int_0 <= 3156 && int_1 >= 3056 && int_1 <= 3136) {
      Client.anInt655 = 1;
    }

    if (int_0 >= 3072 && int_0 <= 3118 && int_1 >= 9492 && int_1 <= 9535) {
      Client.anInt655 = 1;
    }

    if (Client.anInt655 == 1 && int_0 >= 3139 && int_0 <= 3199 && int_1 >= 3008 && int_1
        <= 3062) {
      Client.anInt655 = 0;
    }

  }

  static void method120(final InterfaceComponent widget_0, final ItemConfig itemcomposition_0,
      final int int_0,
      final int int_1, final boolean bool_0) {
    final String[] strings_0 = itemcomposition_0.inventoryActions;
    byte byte_0 = -1;
    String string_0 = null;
    if (strings_0 != null && strings_0[int_1] != null) {
      if (int_1 == 0) {
        byte_0 = 33;
      } else if (int_1 == 1) {
        byte_0 = 34;
      } else if (int_1 == 2) {
        byte_0 = 35;
      } else if (int_1 == 3) {
        byte_0 = 36;
      } else {
        byte_0 = 37;
      }

      string_0 = strings_0[int_1];
    } else if (int_1 == 4) {
      byte_0 = 37;
      string_0 = "Drop";
    }

    if (byte_0 != -1 && string_0 != null) {
      final String string_1 = Square.embedColor(16748608) + itemcomposition_0.name;
      final int int_2 = itemcomposition_0.id;
      final int int_3 = widget_0.id;
      if (!Client.isMenuOpen && Client.menuOptionCount < 500) {
        Client.menuOptions[Client.menuOptionCount] = string_0;
        Client.menuTargets[Client.menuOptionCount] = string_1;
        Client.menuTypes[Client.menuOptionCount] = byte_0;
        Client.menuIdentifiers[Client.menuOptionCount] = int_2;
        Client.menuActionParams0[Client.menuOptionCount] = int_0;
        Client.menuActionParams1[Client.menuOptionCount] = int_3;
        Client.aBoolArray11[Client.menuOptionCount] = bool_0;
        ++Client.menuOptionCount;
        return;
      }
    }

  }

}
