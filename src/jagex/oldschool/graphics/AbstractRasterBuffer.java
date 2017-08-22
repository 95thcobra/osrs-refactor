package jagex.oldschool.graphics;

public abstract class AbstractRasterBuffer {

  public int[] buffer;
  public int width;
  public int height;

  public final void init() {
    Rasterizer2d.init(buffer, width, height);
  }

  public abstract void draw(int x, int y);

  public abstract void method497(int var1, int var2, int var3, int var4);

}
