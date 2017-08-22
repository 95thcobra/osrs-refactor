package jagex.oldschool.script;

import jagex.oldschool.Interface1;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.PendingSpawn;
import jagex.oldschool.scene.Player;
import jagex.oldschool.Preferences;
import jagex.oldschool.graphics.IndexedSprite;

public final class LongVariable implements Interface1 {

  public static AbstractPackage anIndexDataBase2;
  public static Preferences preferences;
  public static IndexedSprite anIndexedSprite2;

  public static void method278(final Player player_0, final int int_0, final int int_1) {
    if (player_0.animation == int_0 && int_0 != -1) {
      final int int_2 = PendingSpawn.getAnimationSequence(int_0).replyMode;
      if (int_2 == 1) {
        player_0.actionFrame = 0;
        player_0.anInt514 = 0;
        player_0.actionAnimationDisable = int_1;
        player_0.anInt515 = 0;
      }

      if (int_2 == 2) {
        player_0.anInt515 = 0;
      }
    } else if (int_0 == -1 || player_0.animation == -1 || PendingSpawn
        .getAnimationSequence(int_0).forcedPriority >= PendingSpawn
        .getAnimationSequence(player_0.animation).forcedPriority) {
      player_0.animation = int_0;
      player_0.actionFrame = 0;
      player_0.anInt514 = 0;
      player_0.actionAnimationDisable = int_1;
      player_0.anInt515 = 0;
      player_0.anInt497 = player_0.queueSize;
    }
  }

}
