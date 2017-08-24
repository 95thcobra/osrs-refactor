package jagex.oldschool.audio;

import jagex.oldschool.CacheableNode_Sub3;
import jagex.oldschool.Class103;
import jagex.oldschool.map.MapIcon;
import jagex.oldschool.Class47;
import jagex.oldschool.Boundry;
import jagex.oldschool.Client;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.collections.Node;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.RemoteEnvironment;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.World;
import jagex.oldschool.io.Buffer;

public class AudioWorker implements Runnable {

  public static AbstractPackage widgetIndex;
  public static Boundry aClass9_1;
  public AbstractSourceLine[] systems;

  public AudioWorker() {
    systems = new AbstractSourceLine[2];
  }

  public static ItemConfig getItemDefinition(final int int_0) {
    ItemConfig itemcomposition_0 = (ItemConfig) ItemConfig.items.get(int_0);
    if (itemcomposition_0 != null) {
      return itemcomposition_0;
    }
    final byte[] bytes_0 = Class47.item_ref.get(10, int_0);
    itemcomposition_0 = new ItemConfig();
    itemcomposition_0.id = int_0;
    if (bytes_0 != null) {
      itemcomposition_0.loadBuffer(new Buffer(bytes_0));
    }

    itemcomposition_0.post();
    if (itemcomposition_0.notedTemplate != -1) {
      itemcomposition_0.method898(getItemDefinition(itemcomposition_0.notedTemplate),
          getItemDefinition(itemcomposition_0.note));
    }

    if (itemcomposition_0.notedId != -1) {
      itemcomposition_0.method899(getItemDefinition(itemcomposition_0.notedId),
          getItemDefinition(itemcomposition_0.unnotedId));
    }

    if (itemcomposition_0.anInt493 != -1) {
      itemcomposition_0.method900(getItemDefinition(itemcomposition_0.anInt493),
          getItemDefinition(itemcomposition_0.anInt494));
    }

    if (!ItemConfig.isMembersWorld && itemcomposition_0.isMembers) {
      itemcomposition_0.name = "Members object";
      itemcomposition_0.aBool62 = false;
      itemcomposition_0.groundActions = null;
      itemcomposition_0.inventoryActions = null;
      itemcomposition_0.team = -1;
      itemcomposition_0.anInt492 = 0;
      if (itemcomposition_0.anIterableHashTable5 != null) {
        boolean bool_0 = false;

        for (Node node_0 = itemcomposition_0.anIterableHashTable5
            .getHead(); node_0 != null; node_0 = itemcomposition_0.anIterableHashTable5.getTail()) {
          final CacheableNode_Sub3 cacheablenode_sub3_0 = RemoteEnvironment.method524((int) node_0.hash);
          if (cacheablenode_sub3_0.aBool57) {
            node_0.unlink();
          } else {
            bool_0 = true;
          }
        }

        if (!bool_0) {
          itemcomposition_0.anIterableHashTable5 = null;
        }
      }
    }

    ItemConfig.items.put(itemcomposition_0, int_0);
    return itemcomposition_0;
  }

  public static void method338(final World world_0) {
    if (world_0.method539() != Client.isMembers) {
      Client.isMembers = world_0.method539();
      final boolean bool_0 = world_0.method539();
      if (bool_0 != ItemConfig.isMembersWorld) {
        ItemConfig.items.reset();
        ItemConfig.itemModelCache.reset();
        ItemConfig.itemSpriteCache.reset();
        ItemConfig.isMembersWorld = bool_0;
      }
    }

    Client.host = world_0.address;
    Client.world = world_0.id;
    Client.flags = world_0.mask;
    Class103.anInt201 = Client.socketType == 0 ? 43594 : world_0.id + 40000;
    MapIcon.anInt81 = Client.socketType == 0 ? 443 : world_0.id + 50000;
    OpenedInterface.myWorldPort = Class103.anInt201;
  }

  @Override
  public void run() {
    try {
      for (int int_0 = 0; int_0 < 2; int_0++) {
        final AbstractSourceLine abstractsoundsystem_0 = systems[int_0];
        if (abstractsoundsystem_0 != null) {
          abstractsoundsystem_0.method355();
        }
      }

    } catch (final Exception exception_0) {
      ClientScriptVariable.method526(null, exception_0);
    }
  }

}
