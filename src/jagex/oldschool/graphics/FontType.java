package jagex.oldschool.graphics;

import jagex.oldschool.Class106;
import jagex.oldschool.SourceLineProvider;
import jagex.oldschool.asset.Package;
import jagex.oldschool.io.SocketStream;

public class FontType {

  public static final FontType aClass105_4;
  public static final FontType aClass105_5;
  public static final FontType aClass105_6;
  public static final FontType aClass105_7;
  public static final FontType aClass105_8;
  public static final FontType aClass105_9;
  public static SocketStream stream;
  public static Package anIndexData3;

  static {
    aClass105_5 = new FontType("PLAIN11", "p11_full");
    aClass105_8 = new FontType("PLAIN12", "p12_full");
    aClass105_9 = new FontType("BOLD12", "b12_full");
    aClass105_4 = new FontType("VERDANA11", "verdana_11pt_regular");
    aClass105_6 = new FontType("VERDANA13", "verdana_13pt_regular");
    aClass105_7 = new FontType("VERDANA15", "verdana_15pt_regular");
  }

  final String aString13;
  public String aString14;

  FontType(final String string_0, final String string_1) {
    aString13 = string_0;
    aString14 = string_1;
  }

  public static void method519(final SourceLineProvider interface2_0) {
    Class106.anInterface2_1 = interface2_0;
  }

}
