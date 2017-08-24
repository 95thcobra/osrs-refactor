package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;

public class Class82 {

  public static int method487(final int int_0, final Script script_0, final boolean bool_0) {
    int int_1;
    if (int_0 == 6600) {
      int_1 = Class12.plane;
      final int int_6 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
      final int int_2 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
      WorldMapType3.method567().method33(int_1, int_6, int_2, true);
      return 1;
    }
    WorldMapData worldmapdata_0;
    if (int_0 == 6601) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      String string_0 = "";
      worldmapdata_0 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_0 != null) {
        string_0 = worldmapdata_0.method325();
      }

      ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_0;
      return 1;
    }
    if (int_0 == 6602) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      WorldMapType3.method567().method37(int_1);
      return 1;
    }
    if (int_0 == 6603) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method38();
      return 1;
    }
    if (int_0 == 6604) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      WorldMapType3.method567().method39(int_1);
      return 1;
    }
    if (int_0 == 6605) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method40() ? 1 : 0;
      return 1;
    }
    Position coordinates_3;
    if (int_0 == 6606) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      WorldMapType3.method567().method26(coordinates_3.x, coordinates_3.z);
      return 1;
    }
    if (int_0 == 6607) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      WorldMapType3.method567().method27(coordinates_3.x, coordinates_3.z);
      return 1;
    }
    if (int_0 == 6608) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      WorldMapType3.method567()
          .method42(coordinates_3.plane, coordinates_3.x, coordinates_3.z);
      return 1;
    }
    if (int_0 == 6609) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      WorldMapType3.method567()
          .method43(coordinates_3.plane, coordinates_3.x, coordinates_3.z);
      return 1;
    }
    if (int_0 == 6610) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method19();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method24();
      return 1;
    }
    WorldMapData worldmapdata_1;
    if (int_0 == 6611) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      worldmapdata_1 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method326().hash();
      }

      return 1;
    }
    if (int_0 == 6612) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      worldmapdata_1 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize
            - 1] = (worldmapdata_1.method322() - worldmapdata_1.method311() + 1) * 64;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize
            - 1] = (worldmapdata_1.method323() - worldmapdata_1.method312() + 1) * 64;
      }

      return 1;
    }
    if (int_0 == 6613) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      worldmapdata_1 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method311() * 64;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method312() * 64;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method322() * 64 + 64 - 1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method323() * 64 + 64 - 1;
      }

      return 1;
    }
    if (int_0 == 6614) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      worldmapdata_1 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method318();
      }

      return 1;
    }
    if (int_0 == 6615) {
      coordinates_3 = WorldMapType3.method567().method41();
      if (coordinates_3 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = coordinates_3.x;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = coordinates_3.z;
      }

      return 1;
    }
    if (int_0 == 6616) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method45();
      return 1;
    }
    if (int_0 == 6617) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      worldmapdata_1 = WorldMapType3.method567().method46();
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        return 1;
      }
      final int[] ints_0 = worldmapdata_1.method310(coordinates_3.plane, coordinates_3.x,
          coordinates_3.z);
      if (ints_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = ints_0[0];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = ints_0[1];
      }

      return 1;
    }
    Position coordinates_0;
    if (int_0 == 6618) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      worldmapdata_1 = WorldMapType3.method567().method46();
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        return 1;
      }
      coordinates_0 = worldmapdata_1.method314(coordinates_3.x, coordinates_3.z);
      if (coordinates_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = coordinates_0.hash();
      }

      return 1;
    }
    int int_3;
    int int_4;
    int int_5;
    Position coordinates_1;
    Position coordinates_2;
    if (int_0 == 6619) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      coordinates_2 = new Position(ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1]);
      worldmapdata_0 = WorldMapType3.method567().method17(int_1);
      int_3 = GrandExchangeOffer.localPlayer.anInt585;
      int_4 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
      int_5 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
      coordinates_1 = new Position(int_3, int_4, int_5);
      WorldMapType3.method567().method62(worldmapdata_0, coordinates_1, coordinates_2, false);
      return 1;
    }
    if (int_0 == 6620) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      coordinates_2 = new Position(ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1]);
      worldmapdata_0 = WorldMapType3.method567().method17(int_1);
      int_3 = GrandExchangeOffer.localPlayer.anInt585;
      int_4 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
      int_5 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
      coordinates_1 = new Position(int_3, int_4, int_5);
      WorldMapType3.method567().method62(worldmapdata_0, coordinates_1, coordinates_2, true);
      return 1;
    }
    if (int_0 == 6621) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      coordinates_2 = new Position(ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1]);
      worldmapdata_0 = WorldMapType3.method567().method17(int_1);
      if (worldmapdata_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        return 1;
      }
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_0.method313(
          coordinates_2.plane, coordinates_2.x, coordinates_2.z) ? 1 : 0;
      return 1;
    }
    if (int_0 == 6622) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method49();
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567().method57();
      return 1;
    }
    if (int_0 == 6623) {
      coordinates_3 = new Position(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      worldmapdata_1 = WorldMapType3.method567().method15(coordinates_3.plane,
          coordinates_3.x, coordinates_3.z);
      if (worldmapdata_1 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = worldmapdata_1.method309();
      }

      return 1;
    }
    if (int_0 == 6624) {
      WorldMapType3.method567().method50(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      return 1;
    }
    if (int_0 == 6625) {
      WorldMapType3.method567().method47();
      return 1;
    }
    if (int_0 == 6626) {
      WorldMapType3.method567().method52(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      return 1;
    }
    if (int_0 == 6627) {
      WorldMapType3.method567().method48();
      return 1;
    }
    boolean bool_2;
    if (int_0 == 6628) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      WorldMapType3.method567().method54(bool_2);
      return 1;
    }
    if (int_0 == 6629) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      WorldMapType3.method567().method53(int_1);
      return 1;
    }
    if (int_0 == 6630) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      WorldMapType3.method567().method55(int_1);
      return 1;
    }
    if (int_0 == 6631) {
      WorldMapType3.method567().method51();
      return 1;
    }
    if (int_0 == 6632) {
      bool_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
      WorldMapType3.method567().method56(bool_2);
      return 1;
    }
    boolean bool_1;
    if (int_0 == 6633) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      bool_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1] == 1;
      WorldMapType3.method567().method60(int_1, bool_1);
      return 1;
    }
    if (int_0 == 6634) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      bool_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1] == 1;
      WorldMapType3.method567().method61(int_1, bool_1);
      return 1;
    }
    if (int_0 == 6635) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567()
          .method59() ? 1 : 0;
      return 1;
    }
    if (int_0 == 6636) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567()
          .method63(int_1) ? 1 : 0;
      return 1;
    }
    if (int_0 == 6637) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType3.method567()
          .method64(int_1) ? 1 : 0;
      return 1;
    }
    if (int_0 == 6638) {
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      coordinates_2 = new Position(ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1]);
      coordinates_0 = WorldMapType3.method567().method65(int_1, coordinates_2);
      if (coordinates_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = coordinates_0.hash();
      }

      return 1;
    }
    Class16 class16_0;
    if (int_0 == 6639) {
      class16_0 = WorldMapType3.method567().method58();
      if (class16_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class16_0.anInt64;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class16_0.aCoordinates5
            .hash();
      }

      return 1;
    }
    if (int_0 == 6640) {
      class16_0 = WorldMapType3.method567().method28();
      if (class16_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class16_0.anInt64;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = class16_0.aCoordinates5
            .hash();
      }

      return 1;
    }
    MapIconConfig area_0;
    if (int_0 == 6693) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      area_0 = MapIconConfig.icons[int_1];
      if (area_0.name == null) {
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
      } else {
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
            - 1] = area_0.name;
      }

      return 1;
    }
    if (int_0 == 6694) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      area_0 = MapIconConfig.icons[int_1];
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = area_0.anInt436;
      return 1;
    }
    if (int_0 == 6695) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      area_0 = MapIconConfig.icons[int_1];
      if (area_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = area_0.anInt438;
      }

      return 1;
    }
    if (int_0 == 6696) {
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      area_0 = MapIconConfig.icons[int_1];
      if (area_0 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = area_0.spriteId;
      }

      return 1;
    }
    if (int_0 == 6697) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize
          - 1] = AudioWorker.aClass9_1.anInt49;
      return 1;
    }
    if (int_0 == 6698) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize
          - 1] = AudioWorker.aClass9_1.aCoordinates2.hash();
      return 1;
    }
    if (int_0 == 6699) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize
          - 1] = AudioWorker.aClass9_1.aCoordinates3.hash();
      return 1;
    }
    return 2;
  }

  public static int method488() {
    return ++Mouse.mouseIdleTicks - 1;
  }

}
