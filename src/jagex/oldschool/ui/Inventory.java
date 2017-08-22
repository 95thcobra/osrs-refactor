package jagex.oldschool.ui;

import jagex.oldschool.collections.HashTable;
import jagex.oldschool.collections.Node;

public class Inventory extends Node {

  public static HashTable inventories;
  public static int anInt340;

  static {
    inventories = new HashTable(32);
  }

  public int[] ids;
  public int[] counts;

  public Inventory() {
    ids = new int[] {-1};
    counts = new int[] {0};
  }

}
