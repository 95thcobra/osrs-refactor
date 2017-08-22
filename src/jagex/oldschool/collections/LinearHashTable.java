package jagex.oldschool.collections;

public class LinearHashTable {

  int[] values;

  public LinearHashTable(final int[] ints_0) {
    int int_0;
    for (int_0 = 1; int_0 <= (ints_0.length >> 1) + ints_0.length; int_0 <<= 1) {
    }

    values = new int[int_0 + int_0];

    int int_1;
    for (int_1 = 0; int_1 < int_0 + int_0; int_1++) {
      values[int_1] = -1;
    }

    int int_2;
    for (int_1 = 0; int_1 < ints_0.length; values[int_2 + int_2 + 1] = int_1++) {
      for (int_2 = ints_0[int_1] & int_0 - 1; values[int_2 + int_2 + 1] != -1; int_2 = int_2 + 1
          & int_0 - 1) {
      }

      values[int_2 + int_2] = ints_0[int_1];
    }

  }

  public int get(final int int_0) {
    final int int_1 = (values.length >> 1) - 1;
    int int_2 = int_0 & int_1;

    while (true) {
      final int int_3 = values[int_2 + int_2 + 1];
      if (int_3 == -1) {
        return -1;
      }

      if (values[int_2 + int_2] == int_0) {
        return int_3;
      }

      int_2 = int_2 + 1 & int_1;
    }
  }

}
