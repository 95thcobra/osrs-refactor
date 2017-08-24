package jagex.oldschool.util;

import jagex.oldschool.AClass3_Sub1;

public class NanoRegulator extends Regulator {

  long next;

  public NanoRegulator() {
    next = System.nanoTime();
  }

  @Override
  public int sleep(final int delta, final int min) {
    final long deltaNano = min * 1000000L;
    long dt = next   - System.nanoTime();
    if (dt < deltaNano) {
      dt = deltaNano;
    }

    AClass3_Sub1.sleep(dt / 1000000L);
    final long curr = System.nanoTime();

    int int_2;
    for (int_2 = 0; int_2 < 10 && (int_2 < 1 || next < curr);
        next += 1000000L * delta) {
      ++int_2;
    }

    if (next < curr) {
      next = curr;
    }

    return int_2;
  }

  @Override
  public void reset() {
    next = System.nanoTime();
  }

}
