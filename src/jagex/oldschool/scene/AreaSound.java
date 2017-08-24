package jagex.oldschool.scene;

import jagex.oldschool.AClass4_Sub2;
import jagex.oldschool.Class25;
import jagex.oldschool.Class39;
import jagex.oldschool.Class4;
import jagex.oldschool.Client;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.Node;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.io.GameBuffer;

public final class AreaSound extends Node {

  public static Deque aDeque3;
  public static int clanChatCount;

  static {
    aDeque3 = new Deque();
  }

  public int anInt309;
  public ObjectConfig anObjectComposition1;
  public int anInt310;
  public int anInt311;
  public int anInt312;
  public int[] anIntArray77;
  public AClass4_Sub2 anAClass4_Sub2_1;
  public int anInt313;
  public int anInt314;
  public int anInt315;
  public int anInt316;
  public int anInt317;
  public AClass4_Sub2 anAClass4_Sub2_2;
  public int anInt318;

  public static void method628(final GameBuffer packetbuffer_0) {
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

  public static void method573(final int int_0, final int int_1, final int int_2,
      final ObjectConfig config, final int int_3) {
    final AreaSound node_sub1_0 = new AreaSound();
    node_sub1_0.anInt317 = int_0;
    node_sub1_0.anInt314 = int_1 * 128;
    node_sub1_0.anInt316 = int_2 * 128;
    int int_4 = config.width;
    int int_5 = config.height;
    if (int_3 == 1 || int_3 == 3) {
      int_4 = config.height;
      int_5 = config.width;
    }

    node_sub1_0.anInt313 = (int_4 + int_1) * 128;
    node_sub1_0.anInt315 = (int_5 + int_2) * 128;
    node_sub1_0.anInt309 = config.ambientSoundId;
    node_sub1_0.anInt310 = config.anInt456 * 128;
    node_sub1_0.anInt311 = config.anInt457;
    node_sub1_0.anInt312 = config.anInt458;
    node_sub1_0.anIntArray77 = config.anIntArray101;
    if (config.impostorIds != null) {
      node_sub1_0.anObjectComposition1 = config;
      node_sub1_0.method627();
    }

    aDeque3.addLast(node_sub1_0);
    if (node_sub1_0.anIntArray77 != null) {
      node_sub1_0.anInt318 = node_sub1_0.anInt311
          + (int) (Math.random() * (node_sub1_0.anInt312 - node_sub1_0.anInt311));
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
