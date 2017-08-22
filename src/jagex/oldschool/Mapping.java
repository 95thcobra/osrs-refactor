package jagex.oldschool;

public class Mapping {

  int anInt209;
  int mux;
  int[] submapFloors;
  int[] anIntArray61;

  Mapping() {
    Node_Sub2.get(16);
    anInt209 = Node_Sub2.getBit() != 0 ? Node_Sub2.get(4) + 1 : 1;
    if (Node_Sub2.getBit() != 0) {
      Node_Sub2.get(8);
    }

    Node_Sub2.get(2);
    if (anInt209 > 1) {
      mux = Node_Sub2.get(4);
    }

    submapFloors = new int[anInt209];
    anIntArray61 = new int[anInt209];

    for (int int_0 = 0; int_0 < anInt209; int_0++) {
      Node_Sub2.get(8);
      submapFloors[int_0] = Node_Sub2.get(8);
      anIntArray61[int_0] = Node_Sub2.get(8);
    }

  }

}
