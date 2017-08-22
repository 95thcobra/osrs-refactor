package jagex.oldschool.util;

import jagex.oldschool.AClass3_Sub1;

public class NanoRegulator extends Regulator {

  long time;

  public NanoRegulator() {
    time = System.nanoTime();
  }

  @Override
  public int sleep(final int min, final int delta) {
    final long long_0 = delta * 1000000L;
    long long_1 = time - System.nanoTime();
    if (long_1 < long_0) {
      long_1 = long_0;
    }

    AClass3_Sub1.method725(long_1 / 1000000L);
    final long long_2 = System.nanoTime();

    int int_2;
    for (int_2 = 0; int_2 < 10 && (int_2 < 1 || time < long_2);
        time += 1000000L * min) {
      ++int_2;
    }

    if (time < long_2) {
      time = long_2;
    }

    return int_2;
  }

  @Override
  public void reset() {
    time = System.nanoTime();
  }

}
