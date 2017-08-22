package jagex.oldschool;

public class Class75 {

  Class69 aClass69_3;
  Class69 aClass69_4;

  public Class75() {
    aClass69_3 = new Class69();
    aClass69_3.aClass69_2 = aClass69_3;
    aClass69_3.aClass69_1 = aClass69_3;
  }

  public Class69 method463() {
    final Class69 class69_0 = aClass69_3.aClass69_2;
    if (class69_0 == aClass69_3) {
      aClass69_4 = null;
      return null;
    }
    aClass69_4 = class69_0.aClass69_2;
    return class69_0;
  }

  public void method464(final Class69 class69_0) {
    if (class69_0.aClass69_1 != null) {
      class69_0.method422();
    }

    class69_0.aClass69_1 = aClass69_3.aClass69_1;
    class69_0.aClass69_2 = aClass69_3;
    class69_0.aClass69_1.aClass69_2 = class69_0;
    class69_0.aClass69_2.aClass69_1 = class69_0;
  }

  public Class69 method465() {
    final Class69 class69_0 = aClass69_4;
    if (class69_0 == aClass69_3) {
      aClass69_4 = null;
      return null;
    }
    aClass69_4 = class69_0.aClass69_2;
    return class69_0;
  }

}
