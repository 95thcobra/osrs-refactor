package jagex.oldschool;

import jagex.oldschool.graphics.IndexedSprite;

public enum Game implements MappedEnum {

  RUNESCAPE("runescape", "RuneScape", 0), STELLARDAWN("stellardawn", "Stellar Dawn", 1), GAME3(
      "game3", "Game 3",
      2), GAME4("game4", "Game 4",
      3), GAME5("game5", "Game 5", 4), OLDSCHOOL("oldscape", "RuneScape 2007", 5);

  static IndexedSprite[] titlemuteSprite;
  public final String aString20;
  final int anInt358;

  Game(final String string_1, final String string_2, final int int_1) {
    aString20 = string_1;
    anInt358 = int_1;
  }

  @Override
  public int mappedOrdinal() {
    return anInt358;
  }

}
