package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.util.Skills;

public class Class77 {

  public static void method468() {
    if (WorldMapType1.soundSystem1 != null) {
      WorldMapType1.soundSystem1.method355();
    }

    if (ScriptExecutor.soundSystem0 != null) {
      ScriptExecutor.soundSystem0.method355();
    }

  }

  static int method469(final InterfaceComponent widget_0, final int int_0) {
    if (widget_0.dynamicValues != null && int_0 < widget_0.dynamicValues.length) {
      try {
        final int[] ints_0 = widget_0.dynamicValues[int_0];
        int int_1 = 0;
        int int_2 = 0;
        byte byte_0 = 0;

        while (true) {
          final int int_3 = ints_0[int_2++];
          int int_4 = 0;
          byte byte_1 = 0;
          if (int_3 == 0) {
            return int_1;
          }

          if (int_3 == 1) {
            int_4 = Client.boostedSkillLevels[ints_0[int_2++]];
          }

          if (int_3 == 2) {
            int_4 = Client.realSkillLevels[ints_0[int_2++]];
          }

          if (int_3 == 3) {
            int_4 = Client.skillExperiences[ints_0[int_2++]];
          }

          int int_5;
          InterfaceComponent widget_1;
          int int_6;
          int int_7;
          if (int_3 == 4) {
            int_5 = ints_0[int_2++] << 16;
            int_5 += ints_0[int_2++];
            widget_1 = ScriptExecutor.method240(int_5);
            int_6 = ints_0[int_2++];
            if (int_6 != -1 && (!AudioWorker.getItemDefinition(int_6).isMembers
                || Client.isMembers)) {
              for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++) {
                if (int_6 + 1 == widget_1.itemIds[int_7]) {
                  int_4 += widget_1.itemQuantities[int_7];
                }
              }
            }
          }

          if (int_3 == 5) {
            int_4 = Variables.widgetSettings[ints_0[int_2++]];
          }

          if (int_3 == 6) {
            int_4 = Skills.EXPERIENCE[Client.realSkillLevels[ints_0[int_2++]] - 1];
          }

          if (int_3 == 7) {
            int_4 = Variables.widgetSettings[ints_0[int_2++]] * 100 / 46875;
          }

          if (int_3 == 8) {
            int_4 = GrandExchangeOffer.localPlayer.combatLevel;
          }

          if (int_3 == 9) {
            for (int_5 = 0; int_5 < 25; int_5++) {
              if (Skills.ACTIVE[int_5]) {
                int_4 += Client.realSkillLevels[int_5];
              }
            }
          }

          if (int_3 == 10) {
            int_5 = ints_0[int_2++] << 16;
            int_5 += ints_0[int_2++];
            widget_1 = ScriptExecutor.method240(int_5);
            int_6 = ints_0[int_2++];
            if (int_6 != -1 && (!AudioWorker.getItemDefinition(int_6).isMembers
                || Client.isMembers)) {
              for (int_7 = 0; int_7 < widget_1.itemIds.length; int_7++) {
                if (int_6 + 1 == widget_1.itemIds[int_7]) {
                  int_4 = 999999999;
                  break;
                }
              }
            }
          }

          if (int_3 == 11) {
            int_4 = Client.energy;
          }

          if (int_3 == 12) {
            int_4 = Client.weight;
          }

          if (int_3 == 13) {
            int_5 = Variables.widgetSettings[ints_0[int_2++]];
            final int int_8 = ints_0[int_2++];
            int_4 = (int_5 & 1 << int_8) != 0 ? 1 : 0;
          }

          if (int_3 == 14) {
            int_5 = ints_0[int_2++];
            int_4 = PrimitiveType.method629(int_5);
          }

          if (int_3 == 15) {
            byte_1 = 1;
          }

          if (int_3 == 16) {
            byte_1 = 2;
          }

          if (int_3 == 17) {
            byte_1 = 3;
          }

          if (int_3 == 18) {
            int_4 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
          }

          if (int_3 == 19) {
            int_4 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
          }

          if (int_3 == 20) {
            int_4 = ints_0[int_2++];
          }

          if (byte_1 == 0) {
            if (byte_0 == 0) {
              int_1 += int_4;
            }

            if (byte_0 == 1) {
              int_1 -= int_4;
            }

            if (byte_0 == 2 && int_4 != 0) {
              int_1 /= int_4;
            }

            if (byte_0 == 3) {
              int_1 *= int_4;
            }

            byte_0 = 0;
          } else {
            byte_0 = byte_1;
          }
        }
      } catch (final Exception exception_0) {
        return -1;
      }
    }
    return -2;
  }

}
