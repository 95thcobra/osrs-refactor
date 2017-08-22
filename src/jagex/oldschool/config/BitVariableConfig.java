package jagex.oldschool.config;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.io.Buffer;

public class BitVariableConfig extends Subnode {

  public static Cache configs;
  public static AbstractPackage configPackage;

  static {
    configs = new Cache(64);
  }

  public int mappedId;
  public int lowBit;
  public int highBit;

  void parse(final Buffer buffer, final int opcode) {
    if (opcode == 1) {
      mappedId = buffer.getUnsignedShort();
      lowBit = buffer.getUnsignedByte();
      highBit = buffer.getUnsignedByte();
    }

  }

  public void parse(final Buffer buffer) {
    while (true) {
      final int opcode = buffer.getUnsignedByte();
      if (opcode == 0) {
        return;
      }

      parse(buffer, opcode);
    }
  }

}
