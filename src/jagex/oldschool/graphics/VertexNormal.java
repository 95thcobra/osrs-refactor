package jagex.oldschool.graphics;

import jagex.oldschool.asset.Package;
import jagex.oldschool.io.SocketStream;

public class VertexNormal {

  public static SocketStream stream;
  public static BitmapFont aFont5;
  public static Package indexWorldMap;
  public int x;
  public int y;
  public int z;
  public int c;

  public VertexNormal() {
  }

  public VertexNormal(final VertexNormal normal) {
    x = normal.x;
    y = normal.y;
    z = normal.z;
    c = normal.c;
  }

}
