package jagex.oldschool.util;

public class Arrays {

  public static void clear(final int[] arr, int off, int len) {
    for (len = len + off - 7; off < len; arr[off++] = 0) {
      arr[off++] = 0;
      arr[off++] = 0;
      arr[off++] = 0;
      arr[off++] = 0;
      arr[off++] = 0;
      arr[off++] = 0;
      arr[off++] = 0;
    }

    for (len += 7; off < len; arr[off++] = 0) {
    }

  }

  public static void copy(final byte[] bytes_0, int int_0, final byte[] bytes_1, int int_1,
      int int_2) {
    if (bytes_1 == bytes_0) {
      if (int_1 == int_0) {
        return;
      }

      if (int_1 > int_0 && int_1 < int_2 + int_0) {
        --int_2;
        int_0 += int_2;
        int_1 += int_2;
        int_2 = int_0 - int_2;

        for (int_2 += 7; int_0 >= int_2; bytes_1[int_1--] = bytes_0[int_0--]) {
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
          bytes_1[int_1--] = bytes_0[int_0--];
        }

        for (int_2 -= 7; int_0 >= int_2; bytes_1[int_1--] = bytes_0[int_0--]) {
        }

        return;
      }
    }

    int_2 += int_0;

    for (int_2 -= 7; int_0 < int_2; bytes_1[int_1++] = bytes_0[int_0++]) {
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
      bytes_1[int_1++] = bytes_0[int_0++];
    }

    for (int_2 += 7; int_0 < int_2; bytes_1[int_1++] = bytes_0[int_0++]) {
    }

  }

}
