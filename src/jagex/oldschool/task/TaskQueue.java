package jagex.oldschool.task;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class TaskQueue implements Runnable {

  public static String javaVendor;
  public static String javaVersion;
  boolean closed;
  Task currentTask;
  Thread thread;
  Task cachedTask;

  public TaskQueue() {
    currentTask = null;
    cachedTask = null;
    closed = false;
    javaVendor = "Unknown";
    javaVersion = "1.6";

    try {
      javaVendor = System.getProperty("java.vendor");
      javaVersion = System.getProperty("java.version");
    } catch (final Exception exception_0) {
    }

    closed = false;
    thread = new Thread(this);
    thread.setPriority(10);
    thread.setDaemon(true);
    thread.start();
  }

  final Task method498(final int int_0, final int int_1, final int int_2, final Object object_0) {
    final Task task_0 = new Task();
    task_0.type = int_0;
    task_0.intOperand = int_1;
    task_0.objOperand = object_0;
    synchronized (this) {
      if (cachedTask != null) {
        cachedTask.task = task_0;
        cachedTask = task_0;
      } else {
        cachedTask = currentTask = task_0;
      }

      notify();
      return task_0;
    }
  }

  public final Task createRunnable(final Runnable runnable_0, final int int_0) {
    return method498(2, int_0, 0, runnable_0);
  }

  public final void shutdown() {
    synchronized (this) {
      closed = true;
      notifyAll();
    }

    try {
      thread.join();
    } catch (final InterruptedException interruptedexception_0) {
    }
  }

  public final Task createSocket(final String string_0, final int int_0) {
    return method498(1, int_0, 0, string_0);
  }

  public final Task createHost(final int int_0) {
    return method498(3, int_0, 0, null);
  }

  @Override
  public final void run() {
    while (true) {
      Task task_0;
      synchronized (this) {
        while (true) {
          if (closed) {
            return;
          }

          if (currentTask != null) {
            task_0 = currentTask;
            currentTask = currentTask.task;
            if (currentTask == null) {
              cachedTask = null;
            }
            break;
          }

          try {
            this.wait();
          } catch (final InterruptedException interruptedexception_0) {
          }
        }
      }

      try {
        final int int_0 = task_0.type;
        if (int_0 == 1) {
          task_0.result = new Socket(InetAddress.getByName((String) task_0.objOperand),
              task_0.intOperand);
        } else if (int_0 == 2) {
          final Thread thread_0 = new Thread((Runnable) task_0.objOperand);
          thread_0.setDaemon(true);
          thread_0.start();
          thread_0.setPriority(task_0.intOperand);
          task_0.result = thread_0;
        } else if (int_0 == 4) {
          task_0.result = new DataInputStream(((URL) task_0.objOperand).openStream());
        } else if (int_0 == 3) {
          final String string_0 =
              (task_0.intOperand >> 24 & 0xFF) + "." + (task_0.intOperand >> 16 & 0xFF)
                  + "." + (task_0.intOperand >> 8 & 0xFF) + "." + (task_0.intOperand & 0xFF);
          task_0.result = InetAddress.getByName(string_0).getHostName();
        }

        task_0.status = 1;
      } catch (final ThreadDeath threaddeath_0) {
        throw threaddeath_0;
      } catch (final Throwable throwable_0) {
        task_0.status = 2;
      }
    }
  }

}
