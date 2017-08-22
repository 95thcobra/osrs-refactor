package jagex.oldschool.graphics;

import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.Class12;
import jagex.oldschool.Class39;
import jagex.oldschool.Class56;
import jagex.oldschool.Boundry;
import jagex.oldschool.Client;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.WorldMapData_Sub1;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Player;

public class Materials implements MaterialProvider {

  public static int anInt214;
  int width;
  double lightness;
  Material[] textures;
  Deque deque;
  int count;
  AbstractPackage sprites;
  int capacity;

  public Materials(final AbstractPackage materials, final AbstractPackage sprites,
      final int int_0,
      final double lightness, final int int_1) {
    deque = new Deque();
    count = 0;
    this.lightness = 1.0D;
    width = 128;
    this.sprites = sprites;
    capacity = int_0;
    count = capacity;
    this.lightness = lightness;
    width = int_1;
    final int[] ints_0 = materials.getChilds(0);
    final int int_2 = ints_0.length;
    this.textures = new Material[materials.fileCount(0)];

    for (int int_3 = 0; int_3 < int_2; int_3++) {
      final Buffer buffer_0 = new Buffer(materials.get(0, ints_0[int_3]));
      this.textures[ints_0[int_3]] = new Material(buffer_0);
    }

  }

  public static boolean method557() {
    return Class56.aBool18;
  }

  public static void initializeGPI(final GameBuffer packetbuffer_0) {
    packetbuffer_0.beginBitAccess();
    final int int_0 = Client.localInteractingIndex;
    final Player player_0 = GrandExchangeOffer.localPlayer = Client.cachedPlayers[int_0] = new Player();
    player_0.anInt586 = int_0;
    final int int_1 = packetbuffer_0.getBits(30);
    final byte byte_0 = (byte) (int_1 >> 28);
    final int int_2 = int_1 >> 14 & 0x3FFF;
    final int int_3 = int_1 & 0x3FFF;
    player_0.pathX[0] = int_2 - Boundry.baseX;
    player_0.x = (player_0.pathX[0] << 7) + (player_0.getSize() << 6);
    player_0.pathY[0] = int_3 - WorldMapData_Sub1.baseY;
    player_0.y = (player_0.pathY[0] << 7) + (player_0.getSize() << 6);
    Class12.plane = player_0.anInt585 = byte_0;
    if (Class39.aBufferArray1[int_0] != null) {
      player_0.decode(Class39.aBufferArray1[int_0]);
    }

    Class39.anInt89 = 0;
    Class39.anIntArray14[++Class39.anInt89 - 1] = int_0;
    Class39.aByteArray3[int_0] = 0;
    Class39.anInt90 = 0;

    for (int int_4 = 1; int_4 < 2048; int_4++) {
      if (int_4 != int_0) {
        final int int_5 = packetbuffer_0.getBits(18);
        final int int_6 = int_5 >> 16;
        final int int_7 = int_5 >> 8 & 0x255;
        final int int_8 = int_5 & 0x255;
        Class39.anIntArray16[int_4] = (int_7 << 14) + int_8 + (int_6 << 28);
        Class39.anIntArray17[int_4] = 0;
        Class39.anIntArray18[int_4] = -1;
        Class39.anIntArray15[++Class39.anInt90 - 1] = int_4;
        Class39.aByteArray3[int_4] = 0;
      }
    }

    packetbuffer_0.endBitAccess();
  }

  public void reset() {
    for (int int_0 = 0; int_0 < textures.length; int_0++) {
      if (textures[int_0] != null) {
        textures[int_0].clear();
      }
    }

    deque = new Deque();
    count = capacity;
  }

  @Override
  public int getHsl(final int id) {
    return textures[id] != null ? textures[id].hsl : 0;
  }

  @Override
  public int[] get(final int id) {
    final Material texture_0 = textures[id];
    if (texture_0 != null) {
      if (texture_0.pixels != null) {
        deque.addFirst(texture_0);
        texture_0.loaded = true;
        return texture_0.pixels;
      }

      final boolean bool_0 = texture_0.method613(lightness, width, sprites);
      if (bool_0) {
        if (count == 0) {
          final Material texture_1 = (Material) deque.pollLast();
          texture_1.clear();
        } else {
          --count;
        }

        deque.addFirst(texture_0);
        texture_0.loaded = true;
        return texture_0.pixels;
      }
    }

    return null;
  }

  @Override
  public boolean isSmall(final int id) {
    return width == 64;
  }

  @Override
  public boolean isSolid(final int int_0) {
    return textures[int_0].solid;
  }

  public void setLightness(final double lightness) {
    this.lightness = lightness;
    reset();
  }

  public void method556(final int int_0) {
    for (int int_1 = 0; int_1 < textures.length; int_1++) {
      final Material texture_0 = textures[int_1];
      if (texture_0 != null && texture_0.anInt302 != 0 && texture_0.loaded) {
        texture_0.method614(int_0);
        texture_0.loaded = false;
      }
    }

  }

}
