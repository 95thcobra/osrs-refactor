package jagex.oldschool.audio;

import jagex.oldschool.Class56;
import jagex.oldschool.io.FileCache;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class JavaxSourceLine extends AbstractSourceLine {

  AudioFormat format;
  int capacity;
  SourceDataLine line;
  byte[] buffer;

  @Override
  protected void flush() {
    line.flush();
  }

  @Override
  protected void close() {
    if (line != null) {
      line.close();
      line = null;
    }

  }

  @Override
  protected int available() {
    return capacity - (line.available() >> (Class56.stereo ? 2 : 1));
  }

  @Override
  public void open(final int capacity) throws LineUnavailableException {
    try {
      final Info info = new Info(SourceDataLine.class, format,
          capacity << (Class56.stereo ? 2 : 1));
      line = (SourceDataLine) AudioSystem.getLine(info);
      line.open();
      line.start();
      this.capacity = capacity;
    } catch (final LineUnavailableException ex) {
      int int_1 = (capacity >>> 1 & 0x55555555) + (capacity & 0x55555555);
      int_1 = (int_1 >>> 2 & 0x33333333) + (int_1 & 0x33333333);
      int_1 = (int_1 >>> 4) + int_1 & 0xF0F0F0F;
      int_1 += int_1 >>> 8;
      int_1 += int_1 >>> 16;
      final int int_2 = int_1 & 0xFF;
      if (int_2 != 1) {
        open(FileCache.method72(capacity));
      } else {
        line = null;
        throw ex;
      }
    }
  }

  @Override
  protected void write() {
    int len = 256;
    if (Class56.stereo) {
      len <<= 1;
    }

    for (int i = 0; i < len; i++) {
      int sample = super.samples[i];
      if ((sample + 8388608 & 0xFF000000) != 0) {
        sample = 0x7FFFFF ^ sample >> 31;
      }

      buffer[i * 2] = (byte) (sample >> 8);
      buffer[i * 2 + 1] = (byte) (sample >> 16);
    }

    line.write(buffer, 0, len << 1);
  }

  @Override
  public void init() {
    format = new AudioFormat(AbstractSourceLine.sampleRate, 16,
        Class56.stereo ? 2 : 1, true, false);
    buffer = new byte[256 << (Class56.stereo ? 2 : 1)];
  }
}
