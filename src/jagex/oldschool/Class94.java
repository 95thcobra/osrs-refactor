package jagex.oldschool;

import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.scene.Player;

public class Class94 {

  public static int[] anIntArray48;
  static HuffmanCodec aHuffman1;

  static void method514(final Class23 class23_0) {
    if (GrandExchangeOffer.localPlayer.x >> 7 == Client.destinationX
        && GrandExchangeOffer.localPlayer.y >> 7 == Client.destinationY) {
      Client.destinationX = 0;
    }

    final int int_0 = Class39.anInt89;
    final int[] ints_0 = Class39.anIntArray14;
    int int_1 = int_0;
    if (Class23.aClass23_1 == class23_0 || Class23.aClass23_2 == class23_0) {
      int_1 = 1;
    }

    for (int int_2 = 0; int_2 < int_1; int_2++) {
      Player player_0;
      int int_3;
      if (Class23.aClass23_1 == class23_0) {
        player_0 = GrandExchangeOffer.localPlayer;
        int_3 = GrandExchangeOffer.localPlayer.anInt586 << 14;
      } else if (Class23.aClass23_2 == class23_0) {
        player_0 = Client.cachedPlayers[Client.anInt652];
        int_3 = Client.anInt652 << 14;
      } else {
        player_0 = Client.cachedPlayers[ints_0[int_2]];
        int_3 = ints_0[int_2] << 14;
        if (Class23.aClass23_4 == class23_0 && ints_0[int_2] == Client.anInt652) {
          continue;
        }
      }

      if (player_0 != null && player_0.hasConfig() && !player_0.hidden) {
        player_0.aBool75 = false;
        if ((Client.lowMemory && int_0 > 50 || int_0 > 200) && Class23.aClass23_1
            != class23_0
            && player_0.idlePoseAnimation == player_0.poseAnimation) {
          player_0.aBool75 = true;
        }

        final int int_4 = player_0.x >> 7;
        final int int_5 = player_0.y >> 7;
        if (int_4 >= 0 && int_4 < 104 && int_5 >= 0 && int_5 < 104) {
          if (player_0.model != null && Client.tick >= player_0.anInt579
              && Client.tick < player_0.anInt580) {
            player_0.aBool75 = false;
            player_0.anInt583 = Class29.getTileHeight(player_0.x, player_0.y, Class12.plane);
            Class11.region
                .method371(Class12.plane, player_0.x, player_0.y, player_0.anInt583, 60, player_0,
                    player_0.angle, int_3, player_0.anInt587, player_0.anInt588, player_0.anInt589,
                    player_0.anInt590);
          } else {
            if ((player_0.x & 0x7F) == 64 && (player_0.y & 0x7F) == 64) {
              if (Client.anIntArrayArray21[int_4][int_5] == Client.anInt643) {
                continue;
              }

              Client.anIntArrayArray21[int_4][int_5] = Client.anInt643;
            }

            player_0.anInt583 = Class29.getTileHeight(player_0.x, player_0.y, Class12.plane);
            Class11.region
                .method369(Class12.plane, player_0.x, player_0.y, player_0.anInt583, 60, player_0,
                    player_0.angle, int_3, player_0.aBool63);
          }
        }
      }
    }

  }

}
