package jagex.oldschool.map;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.scene.GroundObject;
import jagex.oldschool.scene.Position;
import jagex.oldschool.ui.InterfaceComponent;

public class MapIcon {

  public static InterfaceComponent aWidget3;
  public static int anInt81;
  public static int cameraY;
  public int iconId;
  public Position aCoordinates6;

  public MapIcon(final int int_0, final Position coordinates_0) {
    iconId = int_0;
    aCoordinates6 = coordinates_0;
  }

  public static IndexedSprite[] method239(final AbstractPackage indexdatabase_0,
      final String string_0,
      final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    return GroundObject.method552(indexdatabase_0, int_0, int_1);
  }

}
