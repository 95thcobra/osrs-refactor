package jagex.oldschool.graphics;

public interface MaterialProvider {

  int getHsl(int id);

  int[] get(int id);

  boolean isSmall(int var1);

  boolean isSolid(int var1);

}
