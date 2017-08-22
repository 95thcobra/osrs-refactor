package jagex.oldschool;

import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Position;
import java.util.Iterator;
import java.util.LinkedList;

public class WorldMapData {

  static int[] anIntArray24;
  static int anInt107;
  static int cameraZ;
  String aString11;
  int anInt108;
  int fileId;
  boolean aBool16;
  String aString12;
  int anInt109;
  Position aCoordinates7;
  LinkedList aLinkedList2;
  int anInt110;
  int anInt111;
  int anInt112;
  int anInt113;

  public WorldMapData() {
    fileId = -1;
    anInt108 = -1;
    anInt109 = -1;
    aCoordinates7 = null;
    anInt112 = Integer.MAX_VALUE;
    anInt110 = 0;
    anInt113 = Integer.MAX_VALUE;
    anInt111 = 0;
    aBool16 = false;
  }

  public void loadMapData(final Buffer buffer_0, final int int_0) {
    fileId = int_0;
    aString12 = buffer_0.getString();
    aString11 = buffer_0.getString();
    aCoordinates7 = new Position(buffer_0.getInt());
    anInt108 = buffer_0.getInt();
    buffer_0.getUnsignedByte();
    aBool16 = buffer_0.getUnsignedByte() == 1;
    anInt109 = buffer_0.getUnsignedByte();
    final int int_1 = buffer_0.getUnsignedByte();
    aLinkedList2 = new LinkedList();

    for (int int_2 = 0; int_2 < int_1; int_2++) {
      aLinkedList2.add(method320(buffer_0));
    }

    method319();
  }

  public String method307() {
    return aString12;
  }

  public boolean method308(final int int_0, final int int_1) {
    final int int_2 = int_0 / 64;
    final int int_3 = int_1 / 64;
    if (int_2 >= anInt112 && int_2 <= anInt110) {
      if (int_3 >= anInt113 && int_3 <= anInt111) {
        final Iterator iterator_0 = aLinkedList2.iterator();

        WorldMapSectionBase worldmapsectionbase_0;
        do {
          if (!iterator_0.hasNext()) {
            return false;
          }

          worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
        } while (!worldmapsectionbase_0.method5(int_0, int_1));

        return true;
      }
      return false;
    }
    return false;
  }

  public int method309() {
    return fileId;
  }

  public int[] method310(final int int_0, final int int_1, final int int_2) {
    final Iterator iterator_0 = aLinkedList2.iterator();

    WorldMapSectionBase worldmapsectionbase_0;
    do {
      if (!iterator_0.hasNext()) {
        return null;
      }

      worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
    } while (!worldmapsectionbase_0.method6(int_0, int_1, int_2));

    return worldmapsectionbase_0.method9(int_0, int_1, int_2);
  }

  public int method311() {
    return anInt112;
  }

  public int method312() {
    return anInt113;
  }

  public boolean method313(final int int_0, final int int_1, final int int_2) {
    final Iterator iterator_0 = aLinkedList2.iterator();

    WorldMapSectionBase worldmapsectionbase_0;
    do {
      if (!iterator_0.hasNext()) {
        return false;
      }

      worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
    } while (!worldmapsectionbase_0.method6(int_0, int_1, int_2));

    return true;
  }

  public Position method314(final int int_0, final int int_1) {
    final Iterator iterator_0 = aLinkedList2.iterator();

    WorldMapSectionBase worldmapsectionbase_0;
    do {
      if (!iterator_0.hasNext()) {
        return null;
      }

      worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
    } while (!worldmapsectionbase_0.method5(int_0, int_1));

    return worldmapsectionbase_0.method8(int_0, int_1);
  }

  public int method315() {
    return aCoordinates7.plane;
  }

  public int method316() {
    return aCoordinates7.x;
  }

  public int method317() {
    return aCoordinates7.z;
  }

  public int method318() {
    return anInt109;
  }

  void method319() {
    final Iterator iterator_0 = aLinkedList2.iterator();

    while (iterator_0.hasNext()) {
      final WorldMapSectionBase worldmapsectionbase_0 = (WorldMapSectionBase) iterator_0.next();
      worldmapsectionbase_0.method7(this);
    }

  }

  WorldMapSectionBase method320(final Buffer buffer_0) {
    final int int_0 = buffer_0.getUnsignedByte();
    final Enum1[] enum1s_0 = new Enum1[] {
        Enum1.anEnum1_1, Enum1.anEnum1_3, Enum1.anEnum1_4, Enum1.anEnum1_2
    };
    final Enum1 enum1_0 = (Enum1) PlayerIdentity.forOrdinal(enum1s_0, int_0);
    Object object_0 = null;
    switch (enum1_0.anInt298) {
      case 0:
        object_0 = new WorldMapType3();
        break;
      case 1:
        object_0 = new WorldMapType1();
        break;
      case 2:
        object_0 = new WorldMapType2();
        break;
      case 3:
        object_0 = new Class3();
        break;
      default:
        throw new IllegalStateException("");
    }

    ((WorldMapSectionBase) object_0).method10(buffer_0);
    return (WorldMapSectionBase) object_0;
  }

  public boolean method321() {
    return aBool16;
  }

  public int method322() {
    return anInt110;
  }

  public int method323() {
    return anInt111;
  }

  int method324() {
    return anInt108;
  }

  public String method325() {
    return aString11;
  }

  public Position method326() {
    return new Position(aCoordinates7);
  }

}
