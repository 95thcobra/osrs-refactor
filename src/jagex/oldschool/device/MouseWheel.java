package jagex.oldschool.device;

import jagex.oldschool.Interface3;
import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheel implements Interface3, MouseWheelListener {

  int anInt35;

  public MouseWheel() {
    anInt35 = 0;
  }

  public void method128(final Component component_0) {
    component_0.addMouseWheelListener(this);
  }

  public void method129(final Component component_0) {
    component_0.removeMouseWheelListener(this);
  }

  @Override
  public synchronized int method4() {
    final int int_0 = anInt35;
    anInt35 = 0;
    return int_0;
  }

  @Override
  public synchronized void mouseWheelMoved(final MouseWheelEvent mousewheelevent_0) {
    anInt35 += mousewheelevent_0.getWheelRotation();
  }

}
