package jagex.oldschool;

import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.audio.JavaxSourceLine;
import jagex.oldschool.task.TaskQueue;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.Time;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JavaxSourceDataLineProvider implements SourceLineProvider  {

  static int[] anIntArray3;
  static int anInt62;

  public static void method190(final InterfaceComponent[] widgets_0,
      final InterfaceComponent widget_0, final boolean bool_0) {
    final int int_0 = widget_0.scrollWidth != 0 ? widget_0.scrollWidth : widget_0.width;
    final int int_1 = widget_0.scrollHeight != 0 ? widget_0.scrollHeight : widget_0.height;
    Class43.method279(widgets_0, widget_0.id, int_0, int_1, bool_0);
    if (widget_0.children != null) {
      Class43.method279(widget_0.children, widget_0.id, int_0, int_1, bool_0);
    }

    final OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable.get(widget_0.id);
    if (widgetnode_0 != null) {
      final int int_2 = widgetnode_0.id;
      if (Ignore.loadWidget(int_2)) {
        Class43.method279(Time.widgets[int_2], -1, int_0, int_1, bool_0);
      }
    }

    if (widget_0.contentType != 1337) {
    }
  }

  public static AbstractSourceLine method191(final TaskQueue signlink_0, final int int_0,
      int int_1) {
    if (AbstractSourceLine.sampleRate == 0) {
      throw new IllegalStateException();
    }
    if (int_0 >= 0 && int_0 < 2) {
      if (int_1 < 256) {
        int_1 = 256;
      }

      try {
        final AbstractSourceLine abstractsoundsystem_0 = Class106.anInterface2_1.method3();
        abstractsoundsystem_0.samples = new int[256 * (Class56.stereo ? 2 : 1)];
        abstractsoundsystem_0.anInt138 = int_1;
        abstractsoundsystem_0.init();
        abstractsoundsystem_0.offset = (int_1 & 0xFFFFFC00) + 1024;
        if (abstractsoundsystem_0.offset > 16384) {
          abstractsoundsystem_0.offset = 16384;
        }

        abstractsoundsystem_0.open(abstractsoundsystem_0.offset);
        if (AbstractSourceLine.priority > 0 && Class23.task == null) {
          Class23.task = new AudioWorker();
          OpenedInterface.aScheduledExecutorService1 = Executors.newScheduledThreadPool(1);
          OpenedInterface.aScheduledExecutorService1.scheduleAtFixedRate(Class23.task, 0L, 10L,
              TimeUnit.MILLISECONDS);
        }

        if (Class23.task != null) {
          if (Class23.task.systems[int_0] != null) {
            throw new IllegalArgumentException();
          }

          Class23.task.systems[int_0] = abstractsoundsystem_0;
        }

        return abstractsoundsystem_0;
      } catch (final Throwable throwable_0) {
        return new AbstractSourceLine();
      }
    }
    throw new IllegalArgumentException();
  }

  public static boolean method192(final File file_0, final boolean bool_0) {
    try {
      final RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file_0, "rw");
      final int int_0 = randomaccessfile_0.read();
      randomaccessfile_0.seek(0L);
      randomaccessfile_0.write(int_0);
      randomaccessfile_0.seek(0L);
      randomaccessfile_0.close();
      if (bool_0) {
        file_0.delete();
      }

      return true;
    } catch (final Exception exception_0) {
      return false;
    }
  }

  @Override
  public AbstractSourceLine method3() {
    return new JavaxSourceLine();
  }

}
