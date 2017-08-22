package jagex.oldschool.device;

import jagex.oldschool.Class28;
import jagex.oldschool.Class53;
import jagex.oldschool.util.Time;
import jagex.oldschool.Client;
import jagex.oldschool.Enum1;
import jagex.oldschool.asset.Package;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener, FocusListener {

  public static int mouseIdleTicks;
  public static int anInt248;
  public static int anInt249;
  public static int anInt251;
  public static int anInt252;
  public static int anInt253;
  public static int anInt254;
  public static long aLong17;
  public static Mouse mouse;
  public static int anInt246;
  public static int mouseX;
  public static int anInt247;
  public static int mouseY;
  public static int anInt250;
  public static int anInt255;
  public static long aLong16;
  public static Package anIndexData4;
  public static byte aByte2;
  public static int anInt256;

  static {
    mouse = new Mouse();
    mouseIdleTicks = 0;
    anInt246 = 0;
    mouseX = -1;
    mouseY = -1;
    anInt252 = 0;
    anInt249 = 0;
    anInt251 = 0;
    anInt255 = 0;
    anInt247 = 0;
    anInt250 = 0;
    aLong16 = 0L;
    anInt248 = 0;
    anInt253 = 0;
    anInt254 = 0;
    aLong17 = 0L;
  }

  public static void setGameState(final int int_0) {
    if (int_0 != Client.state) {
      if (Client.state == 0) {
        Enum1.clientInstance.method1032();
      }

      if (int_0 == 20 || int_0 == 40 || int_0 == 45) {
        Client.loginState = 0;
        Client.anInt603 = 0;
        Client.anInt594 = 0;
      }

      if (int_0 != 20 && int_0 != 40 && Class53.aSocketStream1 != null) {
        Class53.aSocketStream1.close();
        Class53.aSocketStream1 = null;
      }

      if (Client.state == 25) {
        Client.anInt612 = 0;
        Client.anInt615 = 0;
        Client.anInt618 = 1;
        Client.anInt621 = 0;
        Client.anInt623 = 1;
      }

      if (int_0 != 5 && int_0 != 10) {
        if (int_0 == 20) {
          Client
              .method662(anIndexData4, Time.indexSprites, true, Client.state == 11 ? 4 : 0);
        } else if (int_0 == 11) {
          Client.method662(anIndexData4, Time.indexSprites, false, 4);
        } else {
          Class28.method237();
        }
      } else {
        Client.method662(anIndexData4, Time.indexSprites, true, 0);
      }

      Client.state = int_0;
    }
  }

  public static void method575(final Component component_0) {
    component_0.removeMouseListener(mouse);
    component_0.removeMouseMotionListener(mouse);
    component_0.removeFocusListener(mouse);
    anInt246 = 0;
  }

  final int method574(final MouseEvent mouseevent_0) {
    final int int_0 = mouseevent_0.getButton();
    return !mouseevent_0.isAltDown() && int_0 != 2 ? !mouseevent_0.isMetaDown() && int_0 != 3
        ? 1 : 2 : 4;
  }

  @Override
  public final void mouseClicked(final MouseEvent mouseevent_0) {
    if (mouseevent_0.isPopupTrigger()) {
      mouseevent_0.consume();
    }

  }

  @Override
  public final synchronized void mouseExited(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      mouseX = -1;
      mouseY = -1;
    }

  }

  @Override
  public final synchronized void mouseDragged(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      mouseX = mouseevent_0.getX();
      mouseY = mouseevent_0.getY();
    }

  }

  @Override
  public final synchronized void focusLost(final FocusEvent focusevent_0) {
    if (mouse != null) {
      anInt246 = 0;
    }

  }

  @Override
  public final synchronized void mouseMoved(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      mouseX = mouseevent_0.getX();
      mouseY = mouseevent_0.getY();
    }

  }

  @Override
  public final synchronized void mousePressed(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      anInt247 = mouseevent_0.getX();
      anInt250 = mouseevent_0.getY();
      aLong16 = Time.currentTimeMillis();
      anInt255 = method574(mouseevent_0);
      if (anInt255 != 0) {
        anInt246 = anInt255 * 562025627;
      }
    }

    if (mouseevent_0.isPopupTrigger()) {
      mouseevent_0.consume();
    }

  }

  @Override
  public final synchronized void mouseReleased(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      anInt246 = 0;
    }

    if (mouseevent_0.isPopupTrigger()) {
      mouseevent_0.consume();
    }

  }

  @Override
  public final void focusGained(final FocusEvent focusevent_0) {
  }

  @Override
  public final synchronized void mouseEntered(final MouseEvent mouseevent_0) {
    if (mouse != null) {
      mouseIdleTicks = 0;
      mouseX = mouseevent_0.getX();
      mouseY = mouseevent_0.getY();
    }

  }

}
