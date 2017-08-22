package jagex.oldschool; /**
 * Copyright (c) 2016 Kyle Fricilone <p> jagex.osrs.UserGroup is hereby granted, free of charge, to
 * any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p> The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software. <p> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 * @author Kyle Fricilone
 * @date Jun 19, 2016
 */
public class RS07Applet implements AppletStub {

  /**
   * Fetch current gamepack for class loader
   */
  private final boolean fetch = true;

  /**
   * The config crawler
   */
  private final Crawler crawler = new Crawler();

  /**
   * The main entry point of the current application.
   *
   * @param args
   *            The command line arguments.
   * @throws IOException
   * @throws MalformedURLException
   */
  public static void main(final String[] args) throws Exception {
    final RS07Applet applet = new RS07Applet();
    applet.initialize();

    final Class<?> client = Class.forName("jagex.oldschool.Client");
    final Applet instance = (Applet) client.getConstructor().newInstance();

    final JFrame frame = new JFrame("FrizDeob | #153");
    frame.add(instance);
    frame.setVisible(true);
    frame.setSize(781, 541);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    client.getSuperclass().getMethod("setStub", AppletStub.class).invoke(instance, applet);
    client.getMethod("init").invoke(instance);
    client.getMethod("start").invoke(instance);
  }

  /**
   * Reads the parameters text file, and stores the parameters.
   *
   * @throws IOException
   * @throws MalformedURLException
   */
  private void initialize() throws Exception {
    crawler.crawl();

    if (fetch) {
      final String path = crawler.download();
      final File file = new File(path + "/gamepack.jar");
      final URL url = file.toURI().toURL();
      final URLClassLoader clsl = (URLClassLoader) ClassLoader.getSystemClassLoader();
      final Method method = URLClassLoader.class
          .getDeclaredMethod("addURL", new Class[] {URL.class});
      method.setAccessible(true);
      method.invoke(clsl, new Object[] {url});
      System.out.println("Added " + file.getPath() + " to the classpath.");
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#getParameter(java.lang.String)
   */
  @Override
  public String getParameter(final String paramName) {
    return crawler.getParam(paramName);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#getDocumentBase()
   */
  @Override
  public URL getDocumentBase() {
    return getCodeBase();
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#getCodeBase()
   */
  @Override
  public URL getCodeBase() {
    try {
      return new URL(crawler.getConfig("codebase"));
    } catch (final MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#isActive()
   */
  @Override
  public boolean isActive() {
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#getAppletContext()
   */
  @Override
  public AppletContext getAppletContext() {
    return null;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.applet.AppletStub#appletResize(int, int)
   */
  @Override
  public void appletResize(final int width, final int height) {
  }

  public class Crawler {

    /**
     * Map of general configs
     */
    private final Map<String, String> configs = new HashMap<>();

    /**
     * Map of msg configs
     */
    private final Map<String, String> msgs = new HashMap<>();

    /**
     * Map of param configs
     */
    private final Map<String, String> params = new HashMap<>();

    /**
     * Stores the configs from the jav_config
     *
     * @throws IOException
     */
    public void crawl() throws IOException {
      final URL url = new URL("http://oldschool.runescape.com/jav_config.ws");
      final HttpURLConnection con = (HttpURLConnection) url.openConnection();

      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(con.getInputStream()))) {
        String line;
        String key;
        String value;
        while ((line = reader.readLine()) != null) {
          int index = line.indexOf('=');

          if (line.startsWith("msg")) {
            line = line.substring(index + 1);
            index = line.indexOf('=');

            key = line.substring(0, index);
            value = line.substring(index + 1);
            msgs.put(key, value);
          } else if (line.startsWith("param")) {
            line = line.substring(index + 1);
            index = line.indexOf('=');

            key = line.substring(0, index);
            value = line.substring(index + 1);
            params.put(key, value);
          } else {
            key = line.substring(0, index);
            value = line.substring(index + 1);
            configs.put(key, value);
          }
        }
      }
    }

    /**
     * Downloads and saves the gamepack. Also saves the configs
     *
     * @return
     * @throws IOException
     */
    public String download() throws IOException {
      final String gamepack = configs.get("initial_jar");
      final URL url = new URL(configs.get("codebase") + gamepack);

      final int hash = Integer
          .valueOf(gamepack.substring(gamepack.indexOf('_') + 1, gamepack.indexOf('.')));
      final File file = new File("./cfg/" + hash);
      file.mkdirs();

      try (InputStream is = new BufferedInputStream(url.openStream());
          OutputStream os = new BufferedOutputStream(
              new FileOutputStream(file.getPath() + "/gamepack.jar"))) {
        int read;
        final byte[] buffer = new byte[4096];
        while ((read = is.read(buffer, 0, buffer.length)) != -1) {
          os.write(buffer, 0, read);
        }
      }

      final StringBuilder bldr = new StringBuilder();
      configs.entrySet().forEach(e -> {
        bldr.append("configs.put(\"").append(e.getKey()).append(", \"").append(e.getValue())
            .append("\");\n");
      });
      msgs.entrySet().forEach(e -> {
        bldr.append("msgs.put(\"").append(e.getKey()).append(", \"").append(e.getValue())
            .append("\");\n");
      });
      params.entrySet().forEach(e -> {
        bldr.append("params.put(\"").append(e.getKey()).append(", \"").append(e.getValue())
            .append("\");\n");
      });

      try (BufferedWriter writer = new BufferedWriter(
          new FileWriter(file.getPath() + "/config.txt"))) {
        writer.write(bldr.toString());
      }

      return file.getAbsolutePath();
    }

    /**
     * Gets a value from the configs map
     *
     * @param key
     * @return
     */
    public final String getConfig(final String key) {
      return configs.get(key);
    }

    /**
     * Gets a value from the msgs map
     *
     * @param key
     * @return
     */
    public final String getMsg(final String key) {
      return msgs.get(key);
    }

    /**
     * Gets a value from the params map
     *
     * @param key
     * @return
     */
    public final String getParam(final String key) {
      return params.get(key);
    }
  }
}
