package jagex.oldschool;

import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.io.Buffer;

public final class Class20 {

  public static DirectSprite[] mapDots;
  static IndexedSprite[] anIndexedSpriteArray4;

  public static FloorUnderlayDefinition method204(final int int_0) {
    FloorUnderlayDefinition floorunderlaydefinition_0 = (FloorUnderlayDefinition) FloorUnderlayDefinition.underlays
        .get(int_0);
    if (floorunderlaydefinition_0 != null) {
      return floorunderlaydefinition_0;
    }
    final byte[] bytes_0 = FloorUnderlayDefinition.underlay_ref.get(1, int_0);
    floorunderlaydefinition_0 = new FloorUnderlayDefinition();
    if (bytes_0 != null) {
      floorunderlaydefinition_0.decode(new Buffer(bytes_0), int_0);
    }

    floorunderlaydefinition_0.post();
    FloorUnderlayDefinition.underlays.put(floorunderlaydefinition_0, int_0);
    return floorunderlaydefinition_0;
  }

}
