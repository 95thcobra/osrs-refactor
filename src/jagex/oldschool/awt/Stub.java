package jagex.oldschool.awt;

import jagex.oldschool.AClass3_Sub1;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.JavaxSourceDataLineProvider;
import jagex.oldschool.Class26;
import jagex.oldschool.Class35;
import jagex.oldschool.Class40;
import jagex.oldschool.Class52;
import jagex.oldschool.Class57;
import jagex.oldschool.Class7;
import jagex.oldschool.IdentityConfig;
import jagex.oldschool.Interface3;
import jagex.oldschool.scene.AreaSound;
import jagex.oldschool.NestedException;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.device.MouseWheel;
import jagex.oldschool.graphics.ImageBuffer;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.script.Class34;
import jagex.oldschool.task.TaskQueue;
import jagex.oldschool.util.MilliRegulator;
import jagex.oldschool.util.NanoRegulator;
import jagex.oldschool.util.Regulator;
import jagex.oldschool.util.Time;
import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

public abstract class Stub extends Applet implements Runnable, FocusListener, WindowListener {

  public static int canvasWidth;
  public static long[] memory;
  public static Regulator regulator;
  public static long[] aLongArray3;
  public static TaskQueue taskManager;
  public static int FPS;
  public static int cycles;
  static boolean focused;
  static Stub shell;
  static boolean aBool70;
  static int shellCount;
  static long aLong21;
  static int min;
  static int delta;
  static int anInt568;
  public static long aLong22;
  public static long aLong23;

  static {
    shell = null;
    shellCount = 0;
    aLong21 = 0L;
    aBool70 = false;
    min = 20;
    delta = 1;
    FPS = 0;
    aLongArray3 = new long[32];
    memory = new long[32];
    anInt568 = 500;
    focused = true;
    aLong22 = -1L;
    aLong23 = -1L;
  }

  final EventQueue anEventQueue1;
  protected int anInt573;
  protected int anInt576;
  Clipboard aClipboard1;
  boolean aBool71;
  MouseWheel aMouseWheel_1;
  int anInt570;
  boolean aBool72;
  int anInt571;
  java.awt.Frame aFrame1;
  Canvas canvas;
  int anInt572;
  boolean aBool73;
  int anInt574;
  int minimumWidth;
  int minimumHeight;
  long aLong24;
  boolean aBool74;

  protected Stub() {
    aBool72 = false;
    anInt570 = 0;
    anInt572 = 0;
    aBool73 = true;
    aBool71 = false;
    aBool74 = false;
    aLong24 = 0L;
    EventQueue eventqueue_0 = null;

    try {
      eventqueue_0 = Toolkit.getDefaultToolkit().getSystemEventQueue();
    } catch (final Throwable throwable_0) {
    }

    anEventQueue1 = eventqueue_0;
    FontType.method519(new JavaxSourceDataLineProvider());
  }

  public static void method1049() {
    for (AreaSound node_sub1_0 = (AreaSound) AreaSound.aDeque3
        .getFirst(); node_sub1_0 != null; node_sub1_0 = (AreaSound) AreaSound.aDeque3.getNext()) {
      if (node_sub1_0.anObjectComposition1 != null) {
        node_sub1_0.method627();
      }
    }

  }

  protected final boolean isValidHost() {
    String string_0 = getDocumentBase().getHost().toLowerCase();
    if (!string_0.equals("jagex.com") && !string_0.endsWith(".jagex.com")) {
      if (!string_0.equals("runescape.com") && !string_0.endsWith(".runescape.com")) {
        if (string_0.endsWith("127.0.0.1")) {
          return true;
        }
        while (string_0.length() > 0 && string_0.charAt(string_0.length() - 1) >= 48
            && string_0.charAt(string_0.length() - 1) <= 57) {
          string_0 = string_0.substring(0, string_0.length() - 1);
        }

        if (string_0.endsWith("192.168.1.")) {
          return true;
        }
        error("invalidhost");
        return false;
      }
      return true;
    }
    return true;
  }

  @Override
  public final void destroy() {
    if (this == shell && !aBool70) {
      aLong21 = Time.currentTimeMillis();
      AClass3_Sub1.sleep(5000L);
      method1028();
    }
  }

  @Override
  public final synchronized void paint(final Graphics graphics_0) {
    if (this == shell && !aBool70) {
      aBool73 = true;
      if (Time.currentTimeMillis() - aLong24 > 1000L) {
        final Rectangle rectangle_0 = graphics_0.getClipBounds();
        if (rectangle_0 == null
            || rectangle_0.width >= canvasWidth && rectangle_0.height
            >= Class34.canvasHeight) {
          aBool74 = true;
          return;
        }
      }

    }
  }

  Surface method1025() {
    final Container container_0 = container();
    int int_0 = Math.max(container_0.getWidth(), minimumWidth);
    int int_1 = Math.max(container_0.getHeight(), minimumHeight);
    if (aFrame1 != null) {
      final Insets insets_0 = aFrame1.getInsets();
      int_0 -= insets_0.right + insets_0.left;
      int_1 -= insets_0.bottom + insets_0.top;
    }

    return new Surface(int_0, int_1);
  }

  Container container() {
    return aFrame1 != null ? aFrame1 : this;
  }

  protected void error(final String string_0) {
    if (!aBool72) {
      aBool72 = true;
      System.out.println("error_game_" + string_0);

      try {
        getAppletContext()
            .showDocument(new URL(getCodeBase(), "error_game_" + string_0 + ".ws"), "_self");
      } catch (final Exception exception_0) {
      }
    }
  }

  final void method1026() {
    aBool71 = true;
  }

  final synchronized void method1027() {
    final Container container_0 = container();
    if (canvas != null) {
      canvas.removeFocusListener(this);
      container_0.remove(canvas);
    }

    canvasWidth = Math.max(container_0.getWidth(), minimumWidth);
    Class34.canvasHeight = Math.max(container_0.getHeight(), minimumHeight);
    Insets insets_0;
    if (aFrame1 != null) {
      insets_0 = aFrame1.getInsets();
      canvasWidth -= insets_0.left + insets_0.right;
      Class34.canvasHeight -= insets_0.bottom + insets_0.top;
    }

    canvas = new CanvasWrapper(this);
    container_0.add(canvas);
    canvas.setSize(canvasWidth, Class34.canvasHeight);
    canvas.setVisible(true);
    canvas.setBackground(Color.BLACK);
    if (container_0 == aFrame1) {
      insets_0 = aFrame1.getInsets();
      canvas.setLocation(insets_0.left + anInt570, anInt572 + insets_0.top);
    } else {
      canvas.setLocation(anInt570, anInt572);
    }

    canvas.addFocusListener(this);
    canvas.requestFocus();
    aBool73 = true;
    if (FileCache.rasterBuffer != null && canvasWidth == FileCache.rasterBuffer.width
        && Class34.canvasHeight == FileCache.rasterBuffer.height) {
      ((ImageBuffer) FileCache.rasterBuffer).method612(canvas);
      FileCache.rasterBuffer.draw(0, 0);
    } else {
      FileCache.rasterBuffer = new ImageBuffer(canvasWidth, Class34.canvasHeight,
          canvas);
    }

    aBool74 = false;
    aLong24 = Time.currentTimeMillis();
  }

  final synchronized void method1028() {
    if (!aBool70) {
      aBool70 = true;

      try {
        canvas.removeFocusListener(this);
      } catch (final Exception exception_0) {
      }

      try {
        method1029();
      } catch (final Exception exception_1) {
      }

      if (aFrame1 != null) {
        try {
          System.exit(0);
        } catch (final Throwable throwable_0) {
        }
      }

      if (taskManager != null) {
        try {
          taskManager.shutdown();
        } catch (final Exception exception_2) {
        }
      }

      method1033();
    }
  }

  protected abstract void method1029();

  protected abstract void method1030();

  final void method1031() {
    final Container container_0 = container();
    if (container_0 != null) {
      final Surface class102_0 = method1025();
      anInt573 = Math.max(class102_0.anInt199, minimumWidth);
      anInt576 = Math.max(class102_0.anInt200, minimumHeight);
      if (anInt573 <= 0) {
        anInt573 = 1;
      }

      if (anInt576 <= 0) {
        anInt576 = 1;
      }

      canvasWidth = Math.min(anInt573, anInt571);
      Class34.canvasHeight = Math.min(anInt576, anInt574);
      anInt570 = (anInt573 - canvasWidth) / 2;
      anInt572 = 0;
      canvas.setSize(canvasWidth, Class34.canvasHeight);
      FileCache.rasterBuffer = new ImageBuffer(canvasWidth, Class34.canvasHeight,
          canvas);
      if (container_0 == aFrame1) {
        final Insets insets_0 = aFrame1.getInsets();
        canvas.setLocation(anInt570 + insets_0.left, insets_0.top + anInt572);
      } else {
        canvas.setLocation(anInt570, anInt572);
      }

      aBool73 = true;
      method1042();
    }
  }

  public final void method1032() {
    Class7.anImage1 = null;
    FileCache.aFont2 = null;
    AbstractSourceLine.aFontMetrics1 = null;
  }

  protected abstract void method1033();

  void callUpdate() {
    final long long_0 = Time.currentTimeMillis();
    final long long_1 = memory[IdentityConfig.counter];
    memory[IdentityConfig.counter] = long_0;
    IdentityConfig.counter = IdentityConfig.counter + 1 & 0x1F;
    if (long_1 != 0L && long_0 > long_1) {
    }

    synchronized (this) {
      MapIconConfig.aBool52 = focused;
    }

    update();
  }

  protected final void method1035() {
    Class40.method268();
    final Canvas canvas_0 = canvas;
    canvas_0.setFocusTraversalKeysEnabled(false);
    canvas_0.addKeyListener(Keyboard.keyboard);
    canvas_0.addFocusListener(Keyboard.keyboard);
  }

  protected final void method1036() {
    final Canvas canvas_0 = canvas;
    canvas_0.addMouseListener(Mouse.mouse);
    canvas_0.addMouseMotionListener(Mouse.mouse);
    canvas_0.addFocusListener(Mouse.mouse);
  }

  protected abstract void update();

  protected Interface3 method1037() {
    if (aMouseWheel_1 == null) {
      aMouseWheel_1 = new MouseWheel();
      aMouseWheel_1.method128(canvas);
    }

    return aMouseWheel_1;
  }

  protected final void drawLoadingBar(final int int_0, final String string_0,
      final boolean bool_0) {
    try {
      final Graphics graphics_0 = canvas.getGraphics();
      if (FileCache.aFont2 == null) {
        FileCache.aFont2 = new java.awt.Font("Helvetica", 1, 13);
        AbstractSourceLine.aFontMetrics1 = canvas.getFontMetrics(FileCache.aFont2);
      }

      if (bool_0) {
        graphics_0.setColor(Color.black);
        graphics_0.fillRect(0, 0, canvasWidth, Class34.canvasHeight);
      }

      final Color color_0 = new Color(140, 17, 17);

      try {
        if (Class7.anImage1 == null) {
          Class7.anImage1 = canvas.createImage(304, 34);
        }

        final Graphics graphics_1 = Class7.anImage1.getGraphics();
        graphics_1.setColor(color_0);
        graphics_1.drawRect(0, 0, 303, 33);
        graphics_1.fillRect(2, 2, int_0 * 3, 30);
        graphics_1.setColor(Color.black);
        graphics_1.drawRect(1, 1, 301, 31);
        graphics_1.fillRect(int_0 * 3 + 2, 2, 300 - int_0 * 3, 30);
        graphics_1.setFont(FileCache.aFont2);
        graphics_1.setColor(Color.white);
        graphics_1.drawString(string_0,
            (304 - AbstractSourceLine.aFontMetrics1.stringWidth(string_0)) / 2,
            22);
        graphics_0
            .drawImage(Class7.anImage1, canvasWidth / 2 - 152, Class34.canvasHeight / 2 - 18,
                null);
      } catch (final Exception exception_1) {
        final int int_1 = canvasWidth / 2 - 152;
        final int int_2 = Class34.canvasHeight / 2 - 18;
        graphics_0.setColor(color_0);
        graphics_0.drawRect(int_1, int_2, 303, 33);
        graphics_0.fillRect(int_1 + 2, int_2 + 2, int_0 * 3, 30);
        graphics_0.setColor(Color.black);
        graphics_0.drawRect(int_1 + 1, int_2 + 1, 301, 31);
        graphics_0.fillRect(int_1 + 2 + int_0 * 3, int_2 + 2, 300 - int_0 * 3, 30);
        graphics_0.setFont(FileCache.aFont2);
        graphics_0.setColor(Color.white);
        graphics_0.drawString(string_0,
            int_1 + (304 - AbstractSourceLine.aFontMetrics1.stringWidth(string_0)) / 2,
            int_2 + 22);
      }
    } catch (final Exception exception_0) {
      canvas.repaint();
    }
  }

  void callDraw() {
    final Container container_0 = container();
    final long long_0 = Time.currentTimeMillis();
    final long long_1 = aLongArray3[Class35.anInt87];
    aLongArray3[Class35.anInt87] = long_0;
    Class35.anInt87 = Class35.anInt87 + 1 & 0x1F;
    if (long_1 != 0L && long_0 > long_1) {
      final int int_0 = (int) (long_0 - long_1);
      FPS = ((int_0 >> 1) + 32000) / int_0;
    }

    if (++anInt568 - 1 > 50) {
      anInt568 -= 50;
      aBool73 = true;
      canvas.setSize(canvasWidth, Class34.canvasHeight);
      canvas.setVisible(true);
      if (container_0 == aFrame1) {
        final Insets insets_0 = aFrame1.getInsets();
        canvas.setLocation(insets_0.left + anInt570, anInt572 + insets_0.top);
      } else {
        canvas.setLocation(anInt570, anInt572);
      }
    }

    if (aBool74) {
      method1043();
    }

    method1044();
    method1045(aBool73);
    if (aBool73) {
      method1046();
    }

    aBool73 = false;
  }

  final void method1039(final Object object_0) {
    if (anEventQueue1 != null) {
      for (int int_0 = 0; int_0 < 50 && anEventQueue1.peekEvent() != null; int_0++) {
        AClass3_Sub1.sleep(1L);
      }

      if (object_0 != null) {
        anEventQueue1.postEvent(new ActionEvent(object_0, 1001, "dummy"));
      }

    }
  }

  protected void method1040() {
    aClipboard1 = getToolkit().getSystemClipboard();
  }

  public final void method1041(final int int_0, final int int_1) {
    if (anInt571 != int_0 || int_1 != anInt574) {
      method1026();
    }

    anInt571 = int_0;
    anInt574 = int_1;
  }

  protected abstract void method1042();

  final void method1043() {
    final Canvas canvas_0 = canvas;
    canvas_0.removeKeyListener(Keyboard.keyboard);
    canvas_0.removeFocusListener(Keyboard.keyboard);
    Keyboard.anInt123 = -1;
    Mouse.method575(canvas);
    if (aMouseWheel_1 != null) {
      aMouseWheel_1.method129(canvas);
    }

    method1027();
    final Canvas canvas_1 = canvas;
    canvas_1.setFocusTraversalKeysEnabled(false);
    canvas_1.addKeyListener(Keyboard.keyboard);
    canvas_1.addFocusListener(Keyboard.keyboard);
    final Canvas canvas_2 = canvas;
    canvas_2.addMouseListener(Mouse.mouse);
    canvas_2.addMouseMotionListener(Mouse.mouse);
    canvas_2.addFocusListener(Mouse.mouse);
    if (aMouseWheel_1 != null) {
      aMouseWheel_1.method128(canvas);
    }

    method1026();
  }

  final void method1044() {
    final Surface class102_0 = method1025();
    if (anInt573 != class102_0.anInt199 || class102_0.anInt200 != anInt576 || aBool71) {
      method1031();
      aBool71 = false;
    }

  }

  protected abstract void method1045(boolean var1);

  protected final void initialize(final int int_0, final int int_1, final int int_2) {
    try {
      if (shell != null) {
        ++shellCount;
        if (shellCount >= 3) {
          error("alreadyloaded");
        } else {
          getAppletContext().showDocument(getDocumentBase(), "_self");
        }
      } else {
        shell = this;
        canvasWidth = int_0;
        Class34.canvasHeight = int_1;
        Class26.revision = int_2;
        NestedException.anApplet2 = this;
        if (taskManager == null) {
          taskManager = new TaskQueue();
        }

        taskManager.createRunnable(this, 1);
      }
    } catch (final Exception exception_0) {
      ClientScriptVariable.method526(null, exception_0);
      error("crash");
    }
  }

  void method1046() {
    final int int_0 = anInt570;
    final int int_1 = anInt572;
    final int int_2 = anInt573 - canvasWidth - int_0;
    final int int_3 = anInt576 - Class34.canvasHeight - int_1;
    if (int_0 > 0 || int_2 > 0 || int_1 > 0 || int_3 > 0) {
      try {
        final Container container_0 = container();
        int int_4 = 0;
        int int_5 = 0;
        if (container_0 == aFrame1) {
          final Insets insets_0 = aFrame1.getInsets();
          int_4 = insets_0.left;
          int_5 = insets_0.top;
        }

        final Graphics graphics_0 = container_0.getGraphics();
        graphics_0.setColor(Color.black);
        if (int_0 > 0) {
          graphics_0.fillRect(int_4, int_5, int_0, anInt576);
        }

        if (int_1 > 0) {
          graphics_0.fillRect(int_4, int_5, anInt573, int_1);
        }

        if (int_2 > 0) {
          graphics_0.fillRect(int_4 + anInt573 - int_2, int_5, int_2, anInt576);
        }

        if (int_3 > 0) {
          graphics_0.fillRect(int_4, int_5 + anInt576 - int_3, anInt573, int_3);
          return;
        }
      } catch (final Exception exception_0) {
        return;
      }
    }

  }

  public final boolean method1047() {
    return aFrame1 != null;
  }

  protected void method1048(final String string_0) {
    aClipboard1.setContents(new StringSelection(string_0), null);
  }

  @Override
  public final void windowDeactivated(final WindowEvent windowevent_0) {
  }

  @Override
  public void run() {
    try {
      if (TaskQueue.javaVendor != null) {
        final String string_0 = TaskQueue.javaVendor.toLowerCase();
        if (string_0.indexOf("sun") != -1 || string_0.indexOf("apple") != -1) {
          final String string_1 = TaskQueue.javaVersion;
          if (string_1.equals("1.1") || string_1.startsWith("1.1.") || string_1.equals("1.2")
              || string_1.startsWith("1.2.") || string_1.equals("1.3") || string_1
              .startsWith("1.3.")
              || string_1.equals("1.4") || string_1.startsWith("1.4.") || string_1.equals("1.5")
              || string_1.startsWith("1.5.") || string_1.equals("1.6.0")) {
            error("wrongjava");
            return;
          }

          if (string_1.startsWith("1.6.0_")) {
            int int_0;
            for (int_0 = 6; int_0 < string_1.length(); int_0++) {
              final char char_0 = string_1.charAt(int_0);
              final boolean bool_0 = char_0 >= 48 && char_0 <= 57;
              if (!bool_0) {
                break;
              }
            }

            final String string_2 = string_1.substring(6, int_0);
            if (Class57.method365(string_2)) {
              final int int_2 = Class52.parseInt(string_2, 10, true);
              if (int_2 < 10) {
                error("wrongjava");
                return;
              }
            }
          }

          delta = 5;
        }
      }

      setFocusCycleRoot(true);
      method1027();
      method1030();

      Object object_0;
      try {
        object_0 = new NanoRegulator();
      } catch (final Throwable throwable_0) {
        object_0 = new MilliRegulator();
      }

      regulator = (Regulator) object_0;

      while (aLong21 == 0L || Time.currentTimeMillis() < aLong21) {
        cycles = regulator.sleep(min, delta);

        for (int int_1 = 0; int_1 < cycles; int_1++) {
          callUpdate();
        }

        callDraw();
        method1039(canvas);
      }
    } catch (final Exception exception_0) {
      ClientScriptVariable.method526(null, exception_0);
      error("crash");
    }

    method1028();
  }

  @Override
  public final void start() {
    if (this == shell && !aBool70) {
      aLong21 = 0L;
    }
  }

  @Override
  public final void stop() {
    if (this == shell && !aBool70) {
      aLong21 = Time.currentTimeMillis() + 4000L;
    }
  }

  @Override
  public final void focusGained(final FocusEvent focusevent_0) {
    focused = true;
    aBool73 = true;
  }

  @Override
  public final void focusLost(final FocusEvent focusevent_0) {
    focused = false;
  }

  @Override
  public final void windowActivated(final WindowEvent windowevent_0) {
  }

  @Override
  public final void windowClosed(final WindowEvent windowevent_0) {
  }

  @Override
  public final void windowClosing(final WindowEvent windowevent_0) {
    destroy();
  }

  @Override
  public final void windowIconified(final WindowEvent windowevent_0) {
  }

  @Override
  public final void windowOpened(final WindowEvent windowevent_0) {
  }

  @Override
  public abstract void init();

  @Override
  public final void update(final Graphics graphics_0) {
    paint(graphics_0);
  }

  @Override
  public final void windowDeiconified(final WindowEvent windowevent_0) {
  }

}
