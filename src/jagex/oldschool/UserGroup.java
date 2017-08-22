package jagex.oldschool;

public enum UserGroup implements MappedEnum {

  USER_GROUP_0(0, -1, true, false, true),
  USER_GROUP_1(1, 0, true, true, true),
  USER_GROUP_2(2, 1, true, true, false),
  USER_GROUP_3(3, 2, false, false, true),
  USER_GROUP_4(4, 3, false, false, true),
  USER_GROUP_5(5, 10, false, false, true);

  public final int anInt292;
  public final boolean aBool38;
  public final boolean aBool39;
  final int anInt293;

  UserGroup(final int int_1, final int int_2, final boolean bool_0,
      final boolean bool_1, final boolean bool_2) {
    anInt293 = int_1;
    anInt292 = int_2;
    aBool38 = bool_1;
    aBool39 = bool_2;
  }

  @Override
  public int mappedOrdinal() {
    return anInt293;
  }

}
