package jagex.oldschool;

import java.applet.Applet;
import netscape.javascript.JSObject;

public class Class21 {

  public static Object method205(final Applet applet_0, final String string_0,
      final Object[] objects_0)
      throws Throwable {
    return JSObject.getWindow(applet_0).call(string_0, objects_0);
  }

  public static Object method206(final Applet applet_0, final String string_0) throws Throwable {
    return JSObject.getWindow(applet_0).call(string_0, (Object[]) null);
  }

}
