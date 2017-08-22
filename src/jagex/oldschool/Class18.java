package jagex.oldschool;

import jagex.oldschool.config.ObjectConfig;

public class Class18 {

  static void method203(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    if (int_2 >= 1 && int_3 >= 1 && int_2 <= 102 && int_3 <= 102) {
      if (Client.lowMemory && int_0 != Class12.plane) {
        return;
      }

      int int_7 = 0;
      if (int_1 == 0) {
        int_7 = Class11.region.method372(int_0, int_2, int_3);
      }

      if (int_1 == 1) {
        int_7 = Class11.region.method374(int_0, int_2, int_3);
      }

      if (int_1 == 2) {
        int_7 = Class11.region.method377(int_0, int_2, int_3);
      }

      if (int_1 == 3) {
        int_7 = Class11.region.method375(int_0, int_2, int_3);
      }

      int int_8;
      if (int_7 != 0) {
        int_8 = Class11.region.method376(int_0, int_2, int_3, int_7);
        final int int_9 = int_7 >> 14 & 0x7FFF;
        final int int_10 = int_8 & 0x1F;
        final int int_11 = int_8 >> 6 & 0x3;
        ObjectConfig objectcomposition_0;
        if (int_1 == 0) {
          Class11.region.method378(int_0, int_2, int_3);
          objectcomposition_0 = Class2.getObjectDefinition(int_9);
          if (objectcomposition_0.interactType != 0) {
            Client.collisionMaps[int_0].removeWall(int_2, int_3, int_10, int_11,
                objectcomposition_0.aBool55);
          }
        }

        if (int_1 == 1) {
          Class11.region.method379(int_0, int_2, int_3);
        }

        if (int_1 == 2) {
          Class11.region.method380(int_0, int_2, int_3);
          objectcomposition_0 = Class2.getObjectDefinition(int_9);
          if (int_2 + objectcomposition_0.sizeX > 103 || int_3 + objectcomposition_0.sizeX
              > 103
              || int_2 + objectcomposition_0.sizeY > 103) {
            return;
          }

          if (int_3 + objectcomposition_0.sizeY > 103) {
            return;
          }

          if (objectcomposition_0.interactType != 0) {
            Client.collisionMaps[int_0].removeObject(int_2, int_3, objectcomposition_0.sizeX,
                objectcomposition_0.sizeY, int_11, objectcomposition_0.aBool55);
          }
        }

        if (int_1 == 3) {
          Class11.region.method381(int_0, int_2, int_3);
          objectcomposition_0 = Class2.getObjectDefinition(int_9);
          if (objectcomposition_0.interactType == 1) {
            Client.collisionMaps[int_0].unblock(int_2, int_3);
          }
        }
      }

      if (int_4 >= 0) {
        int_8 = int_0;
        if (int_0 < 3 && (Class22.flags[1][int_2][int_3] & 0x2) == 2) {
          int_8 = int_0 + 1;
        }

        Comparator0.method306(int_0, int_8, int_2, int_3, int_4, int_5, int_6, Class11.region,
            Client.collisionMaps[int_0]);
        return;
      }
    }

  }

}
