package jagex.oldschool.io;

import java.nio.ByteBuffer;

public class DirectByteBuffer extends AbstractByteBuffer {
  ByteBuffer buffer;

  @Override
  public byte[] get() {
    final byte[] bytes = new byte[buffer.capacity()];
    buffer.position(0);
    buffer.get(bytes);
    return bytes;
  }

  @Override
  public void put(final byte[] bytes) {
    buffer = ByteBuffer.allocateDirect(bytes.length);
    buffer.position(0);
    buffer.put(bytes);
  }
}