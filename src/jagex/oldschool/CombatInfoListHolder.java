package jagex.oldschool;

import jagex.oldschool.collections.IterableQueue;
import jagex.oldschool.collections.Node;
import jagex.oldschool.graphics.IndexedSprite;

public class CombatInfoListHolder extends Node {

  static IndexedSprite[] anIndexedSpriteArray8;
  IterableQueue combatInfo1;
  public CombatInfo2 combatInfo2;

  public CombatInfoListHolder(final CombatInfo2 combatinfo2_0) {
    combatInfo1 = new IterableQueue();
    combatInfo2 = combatinfo2_0;
  }

  public void method639(final int int_0, final int int_1, final int int_2, final int int_3) {
    CombatInfo1 combatinfo1_0 = null;
    int int_4 = 0;

    for (CombatInfo1 combatinfo1_1 = (CombatInfo1) combatInfo1
        .getFirst(); combatinfo1_1 != null;
        combatinfo1_1 = (CombatInfo1) combatInfo1.getNext()) {
      ++int_4;
      if (combatinfo1_1.anInt361 == int_0) {
        combatinfo1_1.method665(int_0, int_1, int_2, int_3);
        return;
      }

      if (combatinfo1_1.anInt361 <= int_0) {
        combatinfo1_0 = combatinfo1_1;
      }
    }

    if (combatinfo1_0 == null) {
      if (int_4 < 4) {
        combatInfo1.addFirst(new CombatInfo1(int_0, int_1, int_2, int_3));
      }

    } else {
      IterableQueue.appendAsChild(new CombatInfo1(int_0, int_1, int_2, int_3), combatinfo1_0);
      if (int_4 >= 4) {
        combatInfo1.getFirst().unlink();
      }

    }
  }

  CombatInfo1 method640(final int int_0) {
    CombatInfo1 combatinfo1_0 = (CombatInfo1) combatInfo1.getFirst();
    if (combatinfo1_0 != null && combatinfo1_0.anInt361 <= int_0) {
      for (CombatInfo1 combatinfo1_1 = (CombatInfo1) combatInfo1.getNext();
          combatinfo1_1 != null
              && combatinfo1_1.anInt361 <= int_0;
          combatinfo1_1 = (CombatInfo1) combatInfo1.getNext()) {
        combatinfo1_0.unlink();
        combatinfo1_0 = combatinfo1_1;
      }

      if (combatInfo2.anInt446 + combatinfo1_0.anInt361 + combatinfo1_0.anInt362 > int_0) {
        return combatinfo1_0;
      }
      combatinfo1_0.unlink();
      return null;
    }
    return null;
  }

  boolean method641() {
    return combatInfo1.isEmpty();
  }

}
