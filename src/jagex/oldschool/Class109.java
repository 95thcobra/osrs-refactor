package jagex.oldschool;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.map.MapAsset;

public class Class109 {

  boolean aBool26;
  int anInt207;
  AbstractPackage anIndexDataBase11;
  String aString15;

  Class109(final AbstractPackage indexdatabase_0) {
    anInt207 = 0;
    aBool26 = false;
    anIndexDataBase11 = indexdatabase_0;
  }

  int method530() {
    if (anInt207 < 25) {
      if (!anIndexDataBase11.method451(MapAsset.aClass6_2.aString2, aString15)) {
        return anInt207;
      }

      anInt207 = 25;
    }

    if (anInt207 == 25) {
      if (!anIndexDataBase11.method451(aString15, MapAsset.aClass6_3.aString2)) {
        return 25 + anIndexDataBase11.method456(aString15) * 25 / 100;
      }

      anInt207 = 50;
    }

    if (anInt207 == 50) {
      if (anIndexDataBase11.method454(MapAsset.aClass6_4.aString2, aString15)
          && !anIndexDataBase11.method451(MapAsset.aClass6_4.aString2, aString15)) {
        return 50;
      }

      anInt207 = 75;
    }

    if (anInt207 == 75) {
      if (!anIndexDataBase11.method451(aString15, MapAsset.aClass6_5.aString2)) {
        return 75;
      }

      anInt207 = 100;
      aBool26 = true;
    }

    return anInt207;
  }

  boolean method531() {
    return aBool26;
  }

  void method532(final String string_0) {
    if (string_0 != null && !string_0.isEmpty()) {
      if (string_0 != aString15) {
        aString15 = string_0;
        anInt207 = 0;
        aBool26 = false;
        method530();
      }
    }
  }

  int method533() {
    return anInt207;
  }

}
