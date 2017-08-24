package jagex.oldschool;

import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Square;
import java.io.File;
import java.util.Hashtable;

public class Class65 {

  public static boolean aBool20;
  static Hashtable aHashtable1;
  public static File aFile3;

  static {
    aBool20 = false;
    aHashtable1 = new Hashtable(16);
  }

  static void method408(final Player player_0, final int int_0, final int int_1,
      final int int_2) {
    if (GrandExchangeOffer.localPlayer != player_0) {
      if (Client.menuOptionCount < 400) {
        String string_0;
        if (player_0.totalLevel == 0) {
          string_0 = player_0.actions[0] + player_0.name + player_0.actions[1]
              + Class1.method117(player_0.combatLevel, GrandExchangeOffer.localPlayer.combatLevel)
              + " "
              + " (" + "level-" + player_0.combatLevel + ")" + player_0.actions[2];
        } else {
          string_0 =
              player_0.actions[0] + player_0.name + player_0.actions[1] + " " + " (" + "skill-"
                  + player_0.totalLevel + ")" + player_0.actions[2];
        }

        int int_3;
        if (Client.itemSelectionState == 1) {
          DynamicObject.addMenuEntry("Use",
              Client.aString33 + " " + "->" + " " + Square.embedColor(16777215) + string_0, 14, int_0,
              int_1, int_2);
        } else if (Client.spellSelected) {
          if ((JavaxSourceDataLineProvider.anInt62 & 0x8) == 8) {
            DynamicObject.addMenuEntry(Client.aString34,
                Client.aString35 + " " + "->" + " " + Square.embedColor(16777215) + string_0, 15,
                int_0,
                int_1, int_2);
          }
        } else {
          for (int_3 = 7; int_3 >= 0; --int_3) {
            if (Client.playerOptions[int_3] != null) {
              short short_0 = 0;
              if (Client.playerOptions[int_3].equalsIgnoreCase("Attack")) {
                if (Client.anEnum2_5 == Enum2.anEnum2_4) {
                  continue;
                }

                if (Client.anEnum2_5 == Enum2.anEnum2_2 || Client.anEnum2_5 == Enum2.anEnum2_1
                    && player_0.combatLevel > GrandExchangeOffer.localPlayer.combatLevel) {
                  short_0 = 2000;
                }

                if (GrandExchangeOffer.localPlayer.team != 0 && player_0.team != 0) {
                  if (player_0.team == GrandExchangeOffer.localPlayer.team) {
                    short_0 = 2000;
                  } else {
                    short_0 = 0;
                  }
                }
              } else if (Client.playerOptionsPriorities[int_3]) {
                short_0 = 2000;
              }

              final int int_4 = Client.playerMenuTypes[int_3] + short_0;
              DynamicObject.addMenuEntry(Client.playerOptions[int_3],
                  Square.embedColor(16777215) + string_0, int_4, int_0, int_1, int_2);
            }
          }
        }

        for (int_3 = 0; int_3 < Client.menuOptionCount; int_3++) {
          if (Client.menuTypes[int_3] == 23) {
            Client.menuTargets[int_3] = Square.embedColor(16777215) + string_0;
            break;
          }
        }

      }
    }
  }

  static String[] method409(final String[] strings_0) {
    final String[] strings_1 = new String[5];

    for (int int_0 = 0; int_0 < 5; int_0++) {
      strings_1[int_0] = int_0 + ": ";
      if (strings_0 != null && strings_0[int_0] != null) {
        strings_1[int_0] = strings_1[int_0] + strings_0[int_0];
      }
    }

    return strings_1;
  }

}
