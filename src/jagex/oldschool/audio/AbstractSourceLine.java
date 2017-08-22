package jagex.oldschool.audio;

import jagex.oldschool.AClass4;
import jagex.oldschool.AClass5;
import jagex.oldschool.Class23;
import jagex.oldschool.Class36;
import jagex.oldschool.Class56;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Arrays;
import jagex.oldschool.util.Time;
import java.awt.FontMetrics;

public class AbstractSourceLine {

  public static int sampleRate;
  public static FontMetrics aFontMetrics1;
  public static int priority;
  public int[] samples;
  AClass4[] anAClass4Array1;
  boolean aBool17;
  AClass4 anAClass4_1;
  int anInt133;
  public int offset;
  int anInt134;
  AClass4[] anAClass4Array2;
  long aLong4;
  long aLong5;
  int anInt135;
  int anInt136;
  int anInt137;
  public int anInt138;
  long aLong6;
  int anInt139;

  public AbstractSourceLine() {
    anInt134 = 32;
    aLong5 = Time.currentTimeMillis();
    aLong4 = 0L;
    anInt135 = 0;
    anInt137 = 0;
    anInt136 = 0;
    aLong6 = 0L;
    aBool17 = true;
    anInt133 = 0;
    anAClass4Array2 = new AClass4[8];
    anAClass4Array1 = new AClass4[8];
  }

  protected void flush() throws Exception {
  }

  protected void close() {
  }

  public final synchronized void method355() {
    if (samples != null) {
      long long_0 = Time.currentTimeMillis();

      try {
        if (aLong4 != 0L) {
          if (long_0 < aLong4) {
            return;
          }

          open(offset);
          aLong4 = 0L;
          aBool17 = true;
        }

        int int_0 = available();
        if (anInt136 - int_0 > anInt135) {
          anInt135 = anInt136 - int_0;
        }

        int int_1 = anInt138 + anInt139;
        if (int_1 + 256 > 16384) {
          int_1 = 16128;
        }

        if (int_1 + 256 > offset) {
          offset += 1024;
          if (offset > 16384) {
            offset = 16384;
          }

          close();
          open(offset);
          int_0 = 0;
          aBool17 = true;
          if (int_1 + 256 > offset) {
            int_1 = offset - 256;
            anInt139 = int_1 - anInt138;
          }
        }

        while (int_0 < int_1) {
          method361(samples, 256);
          write();
          int_0 += 256;
        }

        if (long_0 > aLong6) {
          if (!aBool17) {
            if (anInt135 == 0 && anInt137 == 0) {
              close();
              aLong4 = long_0 + 2000L;
              return;
            }

            anInt139 = Math.min(anInt137, anInt135);
            anInt137 = anInt135;
          } else {
            aBool17 = false;
          }

          anInt135 = 0;
          aLong6 = long_0 + 2000L;
        }

        anInt136 = int_0;
      } catch (final Exception exception_0) {
        close();
        aLong4 = long_0 + 2000L;
      }

      try {
        if (long_0 > aLong5 + 500000L) {
          long_0 = aLong5;
        }

        while (long_0 > 5000L + aLong5) {
          method357(256);
          aLong5 += 256000 / sampleRate;
        }

      } catch (final Exception exception_1) {
        aLong5 = long_0;
      }
    }
  }

  protected int available() throws Exception {
    return offset;
  }

  public void open(final int int_0) throws Exception {
  }

  public final synchronized void method356() {
    aBool17 = true;

    try {
      flush();
    } catch (final Exception exception_0) {
      close();
      aLong4 = Time.currentTimeMillis() + 2000L;
    }
  }

  final void method357(final int int_0) {
    anInt133 -= int_0;
    if (anInt133 < 0) {
      anInt133 = 0;
    }

    if (anAClass4_1 != null) {
      anAClass4_1.method633(int_0);
    }

  }

  final void method358(final AClass4 aclass4_0, final int int_0) {
    final int int_1 = int_0 >> 5;
    final AClass4 aclass4_1 = anAClass4Array1[int_1];
    if (aclass4_1 == null) {
      anAClass4Array2[int_1] = aclass4_0;
    } else {
      aclass4_1.anAClass4_2 = aclass4_0;
    }

    anAClass4Array1[int_1] = aclass4_0;
    aclass4_0.anInt321 = int_0;
  }

  public final synchronized void method359() {
    if (Class23.task != null) {
      boolean bool_0 = true;

      for (int int_0 = 0; int_0 < 2; int_0++) {
        if (this == Class23.task.systems[int_0]) {
          Class23.task.systems[int_0] = null;
        }

        if (Class23.task.systems[int_0] != null) {
          bool_0 = false;
        }
      }

      if (bool_0) {
        OpenedInterface.aScheduledExecutorService1.shutdownNow();
        OpenedInterface.aScheduledExecutorService1 = null;
        Class23.task = null;
      }
    }

    close();
    samples = null;
  }

  public final void method360() {
    aBool17 = true;
  }

  final void method361(final int[] ints_0, final int int_0) {
    int int_1 = int_0;
    if (Class56.stereo) {
      int_1 = int_0 << 1;
    }

    Arrays.clear(ints_0, 0, int_1);
    anInt133 -= int_0;
    if (anAClass4_1 != null && anInt133 <= 0) {
      anInt133 += sampleRate >> 4;
      Class36.method257(anAClass4_1);
      method358(anAClass4_1, anAClass4_1.method637());
      int int_2 = 0;
      int int_3 = 255;

      int int_4;
      AClass4 aclass4_1;
      label104:
      for (int_4 = 7; int_3 != 0; --int_4) {
        int int_5;
        int int_6;
        if (int_4 < 0) {
          int_5 = int_4 & 0x3;
          int_6 = -(int_4 >> 2);
        } else {
          int_5 = int_4;
          int_6 = 0;
        }

        for (int int_7 = int_3 >>> int_5 & 0x11111111; int_7 != 0; int_7 >>>= 4) {
          if ((int_7 & 0x1) != 0) {
            int_3 &= ~(1 << int_5);
            aclass4_1 = null;
            AClass4 aclass4_2 = anAClass4Array2[int_5];

            label98:
            while (true) {
              while (true) {
                if (aclass4_2 == null) {
                  break label98;
                }

                final AClass5 aclass5_0 = aclass4_2.anAClass5_1;
                if (aclass5_0 != null && aclass5_0.anInt330 > int_6) {
                  int_3 |= 1 << int_5;
                  aclass4_1 = aclass4_2;
                  aclass4_2 = aclass4_2.anAClass4_2;
                } else {
                  aclass4_2.aBool43 = true;
                  final int int_8 = aclass4_2.method638();
                  int_2 += int_8;
                  if (aclass5_0 != null) {
                    aclass5_0.anInt330 += int_8;
                  }

                  if (int_2 >= anInt134) {
                    break label104;
                  }

                  AClass4 aclass4_3 = aclass4_2.method636();
                  if (aclass4_3 != null) {
                    for (final int int_9 = aclass4_2.anInt321; aclass4_3 != null;
                        aclass4_3 = aclass4_2
                            .method635()) {
                      method358(aclass4_3, int_9 * aclass4_3.method637() >> 8);
                    }
                  }

                  final AClass4 aclass4_4 = aclass4_2.anAClass4_2;
                  aclass4_2.anAClass4_2 = null;
                  if (aclass4_1 == null) {
                    anAClass4Array2[int_5] = aclass4_4;
                  } else {
                    aclass4_1.anAClass4_2 = aclass4_4;
                  }

                  if (aclass4_4 == null) {
                    anAClass4Array1[int_5] = aclass4_1;
                  }

                  aclass4_2 = aclass4_4;
                }
              }
            }
          }

          int_5 += 4;
          ++int_6;
        }
      }

      for (int_4 = 0; int_4 < 8; int_4++) {
        AClass4 aclass4_0 = anAClass4Array2[int_4];
        final AClass4[] aclass4s_0 = anAClass4Array2;
        anAClass4Array1[int_4] = null;

        for (aclass4s_0[int_4] = null; aclass4_0 != null; aclass4_0 = aclass4_1) {
          aclass4_1 = aclass4_0.anAClass4_2;
          aclass4_0.anAClass4_2 = null;
        }
      }
    }

    if (anInt133 < 0) {
      anInt133 = 0;
    }

    if (anAClass4_1 != null) {
      anAClass4_1.method632(ints_0, 0, int_0);
    }

    aLong5 = Time.currentTimeMillis();
  }

  protected void write() throws Exception {
  }

  public final synchronized void method362(final AClass4 aclass4_0) {
    anAClass4_1 = aclass4_0;
  }

  public void init() throws Exception {
  }

}
