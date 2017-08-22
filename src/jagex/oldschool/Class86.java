package jagex.oldschool;

import jagex.oldschool.io.Buffer;

public class Class86 {

  public static Enum method491(final int int_0) {
    Enum enum_0 = (Enum) Enum.aNodeCache10.get(int_0);
    if (enum_0 != null) {
      return enum_0;
    }
    final byte[] bytes_0 = Enum.anIndexDataBase22.get(8, int_0);
    enum_0 = new Enum();
    if (bytes_0 != null) {
      enum_0.decode(new Buffer(bytes_0));
    }

    Enum.aNodeCache10.put(enum_0, int_0);
    return enum_0;
  }

}
