package jagex.oldschool.animation;

import jagex.oldschool.Class12;
import jagex.oldschool.Class14;
import jagex.oldschool.Boundry;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.WorldMapData_Sub1;
import jagex.oldschool.asset.Package;
import jagex.oldschool.collections.Node;
import jagex.oldschool.io.Buffer;

public class FrameBase extends Node {

  public static Package indexScripts;
  int id;
  int count;
  public int[] types;
  public int[][] list;

  FrameBase(final int int_0, final byte[] bytes_0) {
    id = int_0;
    final Buffer buffer_0 = new Buffer(bytes_0);
    count = buffer_0.getUnsignedByte();
    types = new int[count];
    list = new int[count][];

    int int_1;
    for (int_1 = 0; int_1 < count; int_1++) {
      types[int_1] = buffer_0.getUnsignedByte();
    }

    for (int_1 = 0; int_1 < count; int_1++) {
      list[int_1] = new int[buffer_0.getUnsignedByte()];
    }

    for (int_1 = 0; int_1 < count; int_1++) {
      for (int int_2 = 0; int_2 < list[int_1].length; int_2++) {
        list[int_1][int_2] = buffer_0.getUnsignedByte();
      }
    }

  }

  public static void method672() {
    if (Class14.renderOverview != null) {
      Class14.renderOverview
          .method33(Class12.plane, (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX,
              (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY, false);
      Class14.renderOverview.method34();
    }

  }

}
