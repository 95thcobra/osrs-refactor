package jagex.oldschool;

import jagex.oldschool.collections.Node;
import jagex.oldschool.map.MapIcon;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Projectile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo extends Node {

  static int authCodeForLogin;
  public int anInt363;
  public int count;
  public int[] errorIdentifiers;
  public int[] type;
  public Field[] fields;
  public int[] anIntArray81;
  public Method[] methods;
  public byte[][][] args;

  static void method671() {
    for (Projectile projectile_0 = (Projectile) Client.projectiles
        .getFirst(); projectile_0 != null;
        projectile_0 = (Projectile) Client.projectiles.getNext()) {
      if (projectile_0.floor == Class12.plane && Client.tick <= projectile_0.cycle) {
        if (Client.tick >= projectile_0.startTime) {
          if (projectile_0.interacting > 0) {
            final Npc npc_0 = Client.cachedNPCs[projectile_0.interacting - 1];
            if (npc_0 != null && npc_0.x >= 0 && npc_0.x < 13312 && npc_0.y >= 0
                && npc_0.y < 13312) {
              projectile_0.method965(npc_0.x, npc_0.y,
                  Client.getTileHeight(npc_0.x, npc_0.y, projectile_0.floor)
                      - projectile_0.endHeight,
                  Client.tick);
            }
          }

          if (projectile_0.interacting < 0) {
            final int int_0 = -projectile_0.interacting - 1;
            Player player_0;
            if (int_0 == Client.localInteractingIndex) {
              player_0 = GrandExchangeOffer.localPlayer;
            } else {
              player_0 = Client.cachedPlayers[int_0];
            }

            if (player_0 != null && player_0.x >= 0 && player_0.x < 13312 && player_0.y >= 0
                && player_0.y < 13312) {
              projectile_0.method965(player_0.x, player_0.y,
                  Client.getTileHeight(player_0.x, player_0.y, projectile_0.floor)
                      - projectile_0.endHeight,
                  Client.tick);
            }
          }

          projectile_0.method964(Client.anInt610);
          Class11.scene
              .method369(Class12.plane, (int) projectile_0.x, (int) projectile_0.velocityZ,
                  (int) projectile_0.z, 60, projectile_0, projectile_0.rotationX, -1, false);
        }
      } else {
        projectile_0.unlink();
      }
    }

  }

}
