package jagex.oldschool;

import jagex.oldschool.security.Isaac;

public class Floor {

  static final int[] RANGES;
  static final float[] DB_STATIC_TABLE;
  static int[] xList;
  static int[] yList;
  static boolean[] aBoolArray1;

  static {
    RANGES = new int[] {256, 128, 86, 64};
    DB_STATIC_TABLE = new float[] {
        1.0649863E-7F, 1.1341951E-7F, 1.2079015E-7F, 1.2863978E-7F, 1.369995E-7F,
        1.459025E-7F, 1.5538409E-7F, 1.6548181E-7F, 1.7623574E-7F, 1.8768856E-7F, 1.998856E-7F,
        2.128753E-7F,
        2.2670913E-7F, 2.4144197E-7F, 2.5713223E-7F, 2.7384212E-7F, 2.9163792E-7F, 3.1059022E-7F,
        3.307741E-7F,
        3.5226967E-7F, 3.7516213E-7F, 3.995423E-7F, 4.255068E-7F, 4.5315863E-7F, 4.8260745E-7F,
        5.1397E-7F,
        5.4737063E-7F, 5.829419E-7F, 6.208247E-7F, 6.611694E-7F, 7.041359E-7F, 7.4989464E-7F,
        7.98627E-7F,
        8.505263E-7F, 9.057983E-7F, 9.646621E-7F, 1.0273513E-6F, 1.0941144E-6F, 1.1652161E-6F,
        1.2409384E-6F,
        1.3215816E-6F, 1.4074654E-6F, 1.4989305E-6F, 1.5963394E-6F, 1.7000785E-6F, 1.8105592E-6F,
        1.9282195E-6F,
        2.053526E-6F, 2.1869757E-6F, 2.3290977E-6F, 2.4804558E-6F, 2.6416496E-6F, 2.813319E-6F,
        2.9961443E-6F,
        3.1908505E-6F, 3.39821E-6F, 3.619045E-6F, 3.8542307E-6F, 4.1047006E-6F, 4.371447E-6F,
        4.6555283E-6F,
        4.958071E-6F, 5.280274E-6F, 5.623416E-6F, 5.988857E-6F, 6.3780467E-6F, 6.7925284E-6F,
        7.2339453E-6F,
        7.704048E-6F, 8.2047E-6F, 8.737888E-6F, 9.305725E-6F, 9.910464E-6F, 1.0554501E-5F,
        1.1240392E-5F,
        1.1970856E-5F, 1.2748789E-5F, 1.3577278E-5F, 1.4459606E-5F, 1.5399271E-5F, 1.6400005E-5F,
        1.7465769E-5F,
        1.8600793E-5F, 1.9809577E-5F, 2.1096914E-5F, 2.2467912E-5F, 2.3928002E-5F, 2.5482977E-5F,
        2.7139005E-5F,
        2.890265E-5F, 3.078091E-5F, 3.2781227E-5F, 3.4911533E-5F, 3.718028E-5F, 3.9596467E-5F,
        4.2169668E-5F,
        4.491009E-5F, 4.7828602E-5F, 5.0936775E-5F, 5.424693E-5F, 5.7772202E-5F, 6.152657E-5F,
        6.552491E-5F,
        6.9783084E-5F, 7.4317984E-5F, 7.914758E-5F, 8.429104E-5F, 8.976875E-5F, 9.560242E-5F,
        1.0181521E-4F,
        1.0843174E-4F, 1.1547824E-4F, 1.2298267E-4F, 1.3097477E-4F, 1.3948625E-4F, 1.4855085E-4F,
        1.5820454E-4F,
        1.6848555E-4F, 1.7943469E-4F, 1.9109536E-4F, 2.0351382E-4F, 2.167393E-4F, 2.3082423E-4F,
        2.4582449E-4F,
        2.6179955E-4F, 2.7881275E-4F, 2.9693157E-4F, 3.1622787E-4F, 3.3677815E-4F, 3.5866388E-4F,
        3.8197188E-4F,
        4.0679457E-4F, 4.3323037E-4F, 4.613841E-4F, 4.913675E-4F, 5.2329927E-4F, 5.573062E-4F,
        5.935231E-4F,
        6.320936E-4F, 6.731706E-4F, 7.16917E-4F, 7.635063E-4F, 8.1312325E-4F, 8.6596457E-4F,
        9.2223985E-4F,
        9.821722E-4F, 0.0010459992F, 0.0011139743F, 0.0011863665F, 0.0012634633F, 0.0013455702F,
        0.0014330129F,
        0.0015261382F, 0.0016253153F, 0.0017309374F, 0.0018434235F, 0.0019632196F, 0.0020908006F,
        0.0022266726F,
        0.0023713743F, 0.0025254795F, 0.0026895993F, 0.0028643848F, 0.0030505287F, 0.003248769F,
        0.0034598925F,
        0.0036847359F, 0.0039241905F, 0.0041792067F, 0.004450795F, 0.004740033F, 0.005048067F,
        0.0053761187F,
        0.005725489F, 0.0060975635F, 0.0064938175F, 0.0069158226F, 0.0073652514F, 0.007843887F,
        0.008353627F,
        0.008896492F, 0.009474637F, 0.010090352F, 0.01074608F, 0.011444421F, 0.012188144F,
        0.012980198F,
        0.013823725F, 0.014722068F, 0.015678791F, 0.016697686F, 0.017782796F, 0.018938422F,
        0.020169148F,
        0.021479854F, 0.022875736F, 0.02436233F, 0.025945531F, 0.027631618F, 0.029427277F,
        0.031339627F,
        0.03337625F, 0.035545226F, 0.037855156F, 0.0403152F, 0.042935107F, 0.045725275F,
        0.048696756F,
        0.05186135F, 0.05523159F, 0.05882085F, 0.062643364F, 0.06671428F, 0.07104975F, 0.075666964F,
        0.08058423F, 0.08582105F, 0.09139818F, 0.097337745F, 0.1036633F, 0.11039993F, 0.11757434F,
        0.12521498F,
        0.13335215F, 0.14201812F, 0.15124726F, 0.16107617F, 0.1715438F, 0.18269168F, 0.19456401F,
        0.20720787F,
        0.22067343F, 0.23501402F, 0.25028655F, 0.26655158F, 0.28387362F, 0.3023213F, 0.32196787F,
        0.34289113F,
        0.36517414F, 0.3889052F, 0.41417846F, 0.44109413F, 0.4697589F, 0.50028646F, 0.53279793F,
        0.5674221F,
        0.6042964F, 0.64356697F, 0.6853896F, 0.72993004F, 0.777365F, 0.8278826F, 0.88168305F,
        0.9389798F,
        1.0F
    };
  }

  int[] anIntArray12;
  int multiplier;
  int[] paritionClassList;
  int[] classDimensions;
  int[] classSubClasses;
  int[] classMasterbooks;
  int[][] subclassBooks;

  Floor() {
    final int int_0 = Node_Sub2.get(16);
    if (int_0 != 1) {
      throw new RuntimeException();
    }
    final int int_1 = Node_Sub2.get(5);
    int int_2 = 0;
    paritionClassList = new int[int_1];

    int int_3;
    int int_4;
    for (int_3 = 0; int_3 < int_1; int_3++) {
      int_4 = Node_Sub2.get(4);
      paritionClassList[int_3] = int_4;
      if (int_4 >= int_2) {
        int_2 = int_4 + 1;
      }
    }

    classDimensions = new int[int_2];
    classSubClasses = new int[int_2];
    classMasterbooks = new int[int_2];
    subclassBooks = new int[int_2][];

    int int_5;
    for (int_3 = 0; int_3 < int_2; int_3++) {
      classDimensions[int_3] = Node_Sub2.get(3) + 1;
      int_4 = classSubClasses[int_3] = Node_Sub2.get(2);
      if (int_4 != 0) {
        classMasterbooks[int_3] = Node_Sub2.get(8);
      }

      int_4 = 1 << int_4;
      final int[] ints_0 = new int[int_4];
      subclassBooks[int_3] = ints_0;

      for (int_5 = 0; int_5 < int_4; int_5++) {
        ints_0[int_5] = Node_Sub2.get(8) - 1;
      }
    }

    multiplier = Node_Sub2.get(2) + 1;
    int_3 = Node_Sub2.get(4);
    int_4 = 2;

    int int_6;
    for (int_6 = 0; int_6 < int_1; int_6++) {
      int_4 += classDimensions[paritionClassList[int_6]];
    }

    anIntArray12 = new int[int_4];
    anIntArray12[0] = 0;
    anIntArray12[1] = 1 << int_3;
    int_4 = 2;

    for (int_6 = 0; int_6 < int_1; int_6++) {
      int_5 = paritionClassList[int_6];

      for (int int_7 = 0; int_7 < classDimensions[int_5]; int_7++) {
        anIntArray12[int_4++] = Node_Sub2.get(int_3);
      }
    }

    if (xList == null || xList.length < int_4) {
      xList = new int[int_4];
      yList = new int[int_4];
      aBoolArray1 = new boolean[int_4];
    }

  }

  static int method228(final int[] ints_0, final int int_0) {
    final int int_1 = ints_0[int_0];
    int int_2 = -1;
    int int_3 = Integer.MIN_VALUE;

    for (int int_4 = 0; int_4 < int_0; int_4++) {
      final int int_5 = ints_0[int_4];
      if (int_5 < int_1 && int_5 > int_3) {
        int_2 = int_4;
        int_3 = int_5;
      }
    }

    return int_2;
  }

  static int method229(final int[] ints_0, final int int_0) {
    final int int_1 = ints_0[int_0];
    int int_2 = -1;
    int int_3 = Integer.MAX_VALUE;

    for (int int_4 = 0; int_4 < int_0; int_4++) {
      final int int_5 = ints_0[int_4];
      if (int_5 > int_1 && int_5 < int_3) {
        int_2 = int_4;
        int_3 = int_5;
      }
    }

    return int_2;
  }

  void method225(final int int_0, final int int_1) {
    if (int_0 < int_1) {
      int int_2 = int_0;
      final int int_3 = xList[int_0];
      final int int_4 = yList[int_0];
      final boolean bool_0 = aBoolArray1[int_0];

      for (int int_5 = int_0 + 1; int_5 <= int_1; int_5++) {
        final int int_6 = xList[int_5];
        if (int_6 < int_3) {
          xList[int_2] = int_6;
          yList[int_2] = yList[int_5];
          aBoolArray1[int_2] = aBoolArray1[int_5];
          ++int_2;
          xList[int_5] = xList[int_2];
          yList[int_5] = yList[int_2];
          aBoolArray1[int_5] = aBoolArray1[int_2];
        }
      }

      xList[int_2] = int_3;
      yList[int_2] = int_4;
      aBoolArray1[int_2] = bool_0;
      method225(int_0, int_2 - 1);
      method225(int_2 + 1, int_1);
    }
  }

  int method226(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    final int int_5 = int_3 - int_1;
    final int int_6 = int_2 - int_0;
    final int int_7 = int_5 < 0 ? -int_5 : int_5;
    final int int_8 = (int_4 - int_0) * int_7;
    final int int_9 = int_8 / int_6;
    return int_5 < 0 ? int_1 - int_9 : int_9 + int_1;
  }

  void method227(final int int_0, final int int_1, int int_2, final int int_3,
      final float[] floats_0,
      final int int_4) {
    final int int_5 = int_3 - int_1;
    final int int_6 = int_2 - int_0;
    int int_7 = int_5 < 0 ? -int_5 : int_5;
    final int int_8 = int_5 / int_6;
    int int_9 = int_1;
    int int_10 = 0;
    final int int_11 = int_5 < 0 ? int_8 - 1 : int_8 + 1;
    int_7 -= (int_8 < 0 ? -int_8 : int_8) * int_6;
    floats_0[int_0] *= DB_STATIC_TABLE[int_1];
    if (int_2 > int_4) {
      int_2 = int_4;
    }

    for (int int_12 = int_0 + 1; int_12 < int_2; int_12++) {
      int_10 += int_7;
      if (int_10 >= int_6) {
        int_10 -= int_6;
        int_9 += int_11;
      } else {
        int_9 += int_8;
      }

      floats_0[int_12] *= DB_STATIC_TABLE[int_9];
    }

  }

  boolean decodedFloor() {
    final boolean bool_0 = Node_Sub2.getBit() != 0;
    if (!bool_0) {
      return false;
    }
    final int int_0 = anIntArray12.length;

    int int_1;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      xList[int_1] = anIntArray12[int_1];
    }

    int_1 = RANGES[multiplier - 1];
    final int int_2 = Isaac.log(int_1 - 1);
    yList[0] = Node_Sub2.get(int_2);
    yList[1] = Node_Sub2.get(int_2);
    int int_3 = 2;

    for (int int_4 = 0; int_4 < paritionClassList.length; int_4++) {
      final int int_5 = paritionClassList[int_4];
      final int int_6 = classDimensions[int_5];
      final int int_7 = classSubClasses[int_5];
      final int int_8 = (1 << int_7) - 1;
      int int_9 = 0;
      if (int_7 > 0) {
        int_9 = Node_Sub2.codeBooks[classMasterbooks[int_5]].getHuffmanRoot();
      }

      for (int int_10 = 0; int_10 < int_6; int_10++) {
        final int int_11 = subclassBooks[int_5][int_9 & int_8];
        int_9 >>>= int_7;
        yList[int_3++] = int_11 >= 0 ? Node_Sub2.codeBooks[int_11].getHuffmanRoot() : 0;
      }
    }

    return true;
  }

  void computeFloor(final float[] floats_0, final int int_0) {
    final int int_1 = anIntArray12.length;
    final int int_2 = RANGES[multiplier - 1];
    final boolean[] bools_0 = aBoolArray1;
    aBoolArray1[1] = true;
    bools_0[0] = true;

    int int_3;
    int int_4;
    int int_5;
    int int_6;
    int int_7;
    for (int_3 = 2; int_3 < int_1; int_3++) {
      int_4 = method228(xList, int_3);
      int_5 = method229(xList, int_3);
      int_6 = method226(xList[int_4], yList[int_4], xList[int_5], yList[int_5], xList[int_3]);
      int_7 = yList[int_3];
      final int int_8 = int_2 - int_6;
      final int int_9 = (int_8 < int_6 ? int_8 : int_6) << 1;
      if (int_7 != 0) {
        final boolean[] bools_1 = aBoolArray1;
        aBoolArray1[int_5] = true;
        bools_1[int_4] = true;
        aBoolArray1[int_3] = true;
        if (int_7 >= int_9) {
          yList[int_3] = int_8 > int_6 ? int_6 + int_7 - int_6 : int_8 + int_6 - int_7 - 1;
        } else {
          yList[int_3] = (int_7 & 0x1) != 0 ? int_6 - (int_7 + 1) / 2 : int_7 / 2 + int_6;
        }
      } else {
        aBoolArray1[int_3] = false;
        yList[int_3] = int_6;
      }
    }

    method225(0, int_1 - 1);
    int_3 = 0;
    int_4 = yList[0] * multiplier;

    for (int_5 = 1; int_5 < int_1; int_5++) {
      if (aBoolArray1[int_5]) {
        int_6 = xList[int_5];
        int_7 = yList[int_5] * multiplier;
        method227(int_3, int_4, int_6, int_7, floats_0, int_0);
        if (int_6 >= int_0) {
          return;
        }

        int_3 = int_6;
        int_4 = int_7;
      }
    }

    final float float_0 = DB_STATIC_TABLE[int_4];

    for (int_6 = int_3; int_6 < int_0; int_6++) {
      floats_0[int_6] *= float_0;
    }

  }

}
