package jagex.oldschool.scene;

import jagex.oldschool.Client;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptExecutor;

public class Position {

  public int plane;
  public int z;
  public int x;

  public Position() {
    plane = -1;
  }

  public Position(final Position copy) {
    plane = copy.plane;
    x = copy.x;
    z = copy.z;
  }

  public Position(final int int_0, final int int_1, final int int_2) {
    plane = int_0;
    x = int_1;
    z = int_2;
  }

  public Position(final int int_0) {
    if (int_0 == -1) {
      plane = -1;
    } else {
      plane = int_0 >> 28 & 0x3;
      x = int_0 >> 14 & 0x3FFF;
      z = int_0 & 0x3FFF;
    }
  }

  public static void execute(final ScriptCall scriptevent_0) {
    ScriptExecutor.execute(scriptevent_0, 200000);
  }

  public static void method512(final int int_0) {
    if (int_0 >= 0) {
      final int int_1 = Client.menuActionParams0[int_0];
      final int int_2 = Client.menuActionParams1[int_0];
      final int int_3 = Client.menuTypes[int_0];
      final int int_4 = Client.menuIdentifiers[int_0];
      final String string_0 = Client.menuOptions[int_0];
      final String string_1 = Client.menuTargets[int_0];
      Client.menuAction(int_1, int_2, int_3, int_4, string_0, string_1, Mouse.anInt253,
          Mouse.anInt254);
    }
  }

  public int hash() {
    return plane << 28 | x << 14 | z;
  }

  public void method509(final int int_0, final int int_1, final int int_2) {
    plane = int_0;
    x = int_1;
    z = int_2;
  }

  boolean method510(final Position coordinates_1) {
    return plane != coordinates_1.plane ? false
        : x != coordinates_1.x ? false : z == coordinates_1.z;
  }

  @Override
  public boolean equals(final Object object_0) {
    return this == object_0 ? true
        : !(object_0 instanceof Position) ? false : method510((Position) object_0);
  }

  @Override
  public String toString() {
    return plane + "," + (x >> 6) + "," + (z >> 6) + "," + (x & 0x3F) + "," + (z
        & 0x3F);
  }

  @Override
  public int hashCode() {
    return hash();
  }

}
