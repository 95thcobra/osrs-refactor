package jagex.oldschool.scene;

import jagex.oldschool.scene.Renderable;

public final class GameObject {

  public int hash;
  public Renderable renderable;
  int relativeX;
  int offsetX;
  int flags;
  int relativeY;
  int offsetY;
  int plane;
  int x;
  int y;
  int height;
  int orientation;
  int cycle;
  int drawPriority;

  GameObject() {
    hash = 0;
    flags = 0;
  }

}
