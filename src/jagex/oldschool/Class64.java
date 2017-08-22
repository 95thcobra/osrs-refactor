package jagex.oldschool;

import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.io.Buffer;
import java.util.HashMap;

public class Class64 {

  public static int anInt165;

  static {
    new HashMap();
  }

  public static int getLength(final String string_0) {
    return string_0.length() + 1;
  }

  public static PlayerVariable method406(final int int_0) {
    PlayerVariable varplayertype_0 = (PlayerVariable) PlayerVariable.varplayers.get(int_0);
    if (varplayertype_0 != null) {
      return varplayertype_0;
    }
    final byte[] bytes_0 = PlayerVariable.configs.get(16, int_0);
    varplayertype_0 = new PlayerVariable();
    if (bytes_0 != null) {
      varplayertype_0.decode(new Buffer(bytes_0));
    }

    PlayerVariable.varplayers.put(varplayertype_0, int_0);
    return varplayertype_0;
  }

}
