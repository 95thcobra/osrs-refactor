package jagex.oldschool;

import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.Node;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Player;

public final class Node_Sub1 extends Node {

  public static Deque aDeque3;
  public static int clanChatCount;

  static {
    aDeque3 = new Deque();
  }

  int anInt309;
  public ObjectConfig anObjectComposition1;
  int anInt310;
  int anInt311;
  int anInt312;
  int[] anIntArray77;
  AClass4_Sub2 anAClass4_Sub2_1;
  int anInt313;
  int anInt314;
  int anInt315;
  int anInt316;
  int anInt317;
  AClass4_Sub2 anAClass4_Sub2_2;
  int anInt318;

  static void method628(final GameBuffer packetbuffer_0) {
    for (int int_0 = 0; int_0 < Class39.anInt91; int_0++) {
      final int int_1 = Class39.anIntArray19[int_0];
      final Player player_0 = Client.cachedPlayers[int_1];
      int int_2 = packetbuffer_0.getUnsignedByte();
      if ((int_2 & 0x40) != 0) {
        int_2 += packetbuffer_0.getUnsignedByte() << 8;
      }

      Class4.method127(packetbuffer_0, int_1, player_0, int_2);
    }

  }

  public void method627() {
    final int int_0 = anInt309;
    final ObjectConfig objectcomposition_0 = anObjectComposition1.getImpostor();
    if (objectcomposition_0 != null) {
      anInt309 = objectcomposition_0.ambientSoundId;
      anInt310 = objectcomposition_0.anInt456 * 128;
      anInt311 = objectcomposition_0.anInt457;
      anInt312 = objectcomposition_0.anInt458;
      anIntArray77 = objectcomposition_0.anIntArray101;
    } else {
      anInt309 = -1;
      anInt310 = 0;
      anInt311 = 0;
      anInt312 = 0;
      anIntArray77 = null;
    }

    if (int_0 != anInt309 && anAClass4_Sub2_1 != null) {
      Class25.anAClass4_Sub1_1.method722(anAClass4_Sub2_1);
      anAClass4_Sub2_1 = null;
    }
  }

}
