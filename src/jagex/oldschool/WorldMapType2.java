package jagex.oldschool;

import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Position;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.ui.InterfaceComponent;
import java.io.IOException;

public class WorldMapType2 implements WorldMapSectionBase {

  static DirectSprite[] aSpritePixelsArray2;
  static int[][] anIntArrayArray14;
  int anInt216;
  int anInt217;
  int anInt218;
  int anInt219;
  int anInt220;
  int anInt221;

  static void method563(final InterfaceComponent widget_0, final int int_0, final int int_1,
      final boolean bool_0) {
    final int int_2 = widget_0.width;
    final int int_3 = widget_0.height;
    if (widget_0.anInt262 == 0) {
      widget_0.width = widget_0.originalWidth;
    } else if (widget_0.anInt262 == 1) {
      widget_0.width = int_0 - widget_0.originalWidth;
    } else if (widget_0.anInt262 == 2) {
      widget_0.width = widget_0.originalWidth * int_0 >> 14;
    }

    if (widget_0.buttonType == 0) {
      widget_0.height = widget_0.anInt265;
    } else if (widget_0.buttonType == 1) {
      widget_0.height = int_1 - widget_0.anInt265;
    } else if (widget_0.buttonType == 2) {
      widget_0.height = int_1 * widget_0.anInt265 >> 14;
    }

    if (widget_0.anInt262 == 4) {
      widget_0.width = widget_0.anInt267 * widget_0.height / widget_0.anInt269;
    }

    if (widget_0.buttonType == 4) {
      widget_0.height = widget_0.width * widget_0.anInt269 / widget_0.anInt267;
    }

    if (Client.aBool80 && widget_0.type == 0) {
      if (widget_0.height < 5 && widget_0.width < 5) {
        widget_0.height = 5;
        widget_0.width = 5;
      } else {
        if (widget_0.height <= 0) {
          widget_0.height = 5;
        }

        if (widget_0.width <= 0) {
          widget_0.width = 5;
        }
      }
    }

    if (widget_0.contentType == 1337) {
      Client.aWidget11 = widget_0;
    }

    if (bool_0 && widget_0.anObjectArray2 != null && (int_2 != widget_0.width || int_3
        != widget_0.height)) {
      final ScriptCall scriptevent_0 = new ScriptCall();
      scriptevent_0.widget = widget_0;
      scriptevent_0.anObjectArray22 = widget_0.anObjectArray2;
      Client.aDeque7.addLast(scriptevent_0);
    }
  }

  static void method564(final Stub gameengine_0) {
    if (Mouse.anInt248 == 1 || !GrandExchangeOffer.aBool5 && Mouse.anInt248 == 4) {
      final int int_0 = LoginScreen.anInt98 + 280;
      if (Mouse.anInt253 >= int_0 && Mouse.anInt253 <= int_0 + 14 && Mouse.anInt254 >= 4
          && Mouse.anInt254 <= 18) {
        Class40.method270(0, 0);
        return;
      }

      if (Mouse.anInt253 >= int_0 + 15 && Mouse.anInt253 <= int_0 + 80
          && Mouse.anInt254 >= 4 && Mouse.anInt254 <= 18) {
        Class40.method270(0, 1);
        return;
      }

      final int int_1 = LoginScreen.anInt98 + 390;
      if (Mouse.anInt253 >= int_1 && Mouse.anInt253 <= int_1 + 14 && Mouse.anInt254 >= 4
          && Mouse.anInt254 <= 18) {
        Class40.method270(1, 0);
        return;
      }

      if (Mouse.anInt253 >= int_1 + 15 && Mouse.anInt253 <= int_1 + 80
          && Mouse.anInt254 >= 4 && Mouse.anInt254 <= 18) {
        Class40.method270(1, 1);
        return;
      }

      final int int_2 = LoginScreen.anInt98 + 500;
      if (Mouse.anInt253 >= int_2 && Mouse.anInt253 <= int_2 + 14 && Mouse.anInt254 >= 4
          && Mouse.anInt254 <= 18) {
        Class40.method270(2, 0);
        return;
      }

      if (Mouse.anInt253 >= int_2 + 15 && Mouse.anInt253 <= int_2 + 80
          && Mouse.anInt254 >= 4 && Mouse.anInt254 <= 18) {
        Class40.method270(2, 1);
        return;
      }

      final int int_3 = LoginScreen.anInt98 + 610;
      if (Mouse.anInt253 >= int_3 && Mouse.anInt253 <= int_3 + 14 && Mouse.anInt254 >= 4
          && Mouse.anInt254 <= 18) {
        Class40.method270(3, 0);
        return;
      }

      if (Mouse.anInt253 >= int_3 + 15 && Mouse.anInt253 <= int_3 + 80
          && Mouse.anInt254 >= 4 && Mouse.anInt254 <= 18) {
        Class40.method270(3, 1);
        return;
      }

      if (Mouse.anInt253 >= LoginScreen.anInt98 + 708 && Mouse.anInt254 >= 4
          && Mouse.anInt253 <= LoginScreen.anInt98 + 708 + 50 && Mouse.anInt254 <= 20) {
        LoginScreen.selectWorld = false;
        CacheableNode_Sub6.aSpritePixels4.method942(LoginScreen.anInt98, 0);
        Enum2.aSpritePixels3.method942(LoginScreen.anInt98 + 382, 0);
        Class35.logoSprite
            .method933(LoginScreen.anInt98 + 382 - Class35.logoSprite.width / 2, 18);
        return;
      }

      if (LoginScreen.anInt105 != -1) {
        final World world_0 = World.worldList[LoginScreen.anInt105];
        AudioWorker.method338(world_0);
        LoginScreen.selectWorld = false;
        CacheableNode_Sub6.aSpritePixels4.method942(LoginScreen.anInt98, 0);
        Enum2.aSpritePixels3.method942(LoginScreen.anInt98 + 382, 0);
        Class35.logoSprite
            .method933(LoginScreen.anInt98 + 382 - Class35.logoSprite.width / 2, 18);
        return;
      }
    }

  }

  static void flush(final boolean force) {
    Class77.method468();
    ++Client.count;
    if (Client.count >= 50 || force) {
      Client.count = 0;
      if (!Client.panic && VertexNormal.stream != null) {
        Client.outbound.putEncipheredByte(143);

        try {
          VertexNormal.stream.write(Client.outbound.bytes, 0,
              Client.outbound.offset);
          Client.outbound.offset = 0;
        } catch (final IOException ioexception_0) {
          Client.panic = true;
          return;
        }
      }

    }
  }

  public static boolean isFriended(final String string_0, final boolean bool_0) {
    if (string_0 == null) {
      return false;
    }
    final String string_1 = FloorUnderlayDefinition.format(string_0, AClass1_Sub2.aClass108_10);

    for (int int_0 = 0; int_0 < Client.friendCount; int_0++) {
      if (string_1.equalsIgnoreCase(
          FloorUnderlayDefinition.format(Client.friends[int_0].name, AClass1_Sub2.aClass108_10))
          && (!bool_0 || Client.friends[int_0].world != 0)) {
        return true;
      }
    }

    if (string_1
        .equalsIgnoreCase(FloorUnderlayDefinition.format(GrandExchangeOffer.localPlayer.name,
            AClass1_Sub2.aClass108_10))) {
      return true;
    }
    return false;
  }

  static boolean decodeRegionHash(final GameBuffer packetbuffer_0, final int int_0) {
    final int int_1 = packetbuffer_0.getBits(2);
    int int_2;
    int int_3;
    int int_5;
    int int_6;
    int int_7;
    int int_8;
    if (int_1 == 0) {
      if (packetbuffer_0.getBits(1) != 0) {
        decodeRegionHash(packetbuffer_0, int_0);
      }

      int_2 = packetbuffer_0.getBits(13);
      int_3 = packetbuffer_0.getBits(13);
      final boolean bool_0 = packetbuffer_0.getBits(1) == 1;
      if (bool_0) {
        Class39.anIntArray19[++Class39.anInt91 - 1] = int_0;
      }

      if (Client.cachedPlayers[int_0] != null) {
        throw new RuntimeException();
      }
      final Player player_0 = Client.cachedPlayers[int_0] = new Player();
      player_0.anInt586 = int_0;
      if (Class39.aBufferArray1[int_0] != null) {
        player_0.decode(Class39.aBufferArray1[int_0]);
      }

      player_0.orientation = Class39.anIntArray17[int_0];
      player_0.interacting = Class39.anIntArray18[int_0];
      int_5 = Class39.anIntArray16[int_0];
      int_6 = int_5 >> 28;
      int_7 = int_5 >> 14 & 0xFF;
      int_8 = int_5 & 0xFF;
      player_0.aByteArray20[0] = Class39.aByteArray4[int_0];
      player_0.anInt585 = (byte) int_6;
      player_0.method1050((int_7 << 13) + int_2 - Boundry.baseX,
          (int_8 << 13) + int_3 - WorldMapData_Sub1.baseY);
      player_0.aBool76 = false;
      return true;
    }
    if (int_1 == 1) {
      int_2 = packetbuffer_0.getBits(2);
      int_3 = Class39.anIntArray16[int_0];
      Class39.anIntArray16[int_0] = (int_3 & 0xFFFFFFF) + (((int_3 >> 28) + int_2 & 0x3) << 28);
      return false;
    }
    int int_4;
    int int_9;
    if (int_1 == 2) {
      int_2 = packetbuffer_0.getBits(5);
      int_3 = int_2 >> 3;
      int_4 = int_2 & 0x7;
      int_9 = Class39.anIntArray16[int_0];
      int_5 = (int_9 >> 28) + int_3 & 0x3;
      int_6 = int_9 >> 14 & 0xFF;
      int_7 = int_9 & 0xFF;
      if (int_4 == 0) {
        --int_6;
        --int_7;
      }

      if (int_4 == 1) {
        --int_7;
      }

      if (int_4 == 2) {
        ++int_6;
        --int_7;
      }

      if (int_4 == 3) {
        --int_6;
      }

      if (int_4 == 4) {
        ++int_6;
      }

      if (int_4 == 5) {
        --int_6;
        ++int_7;
      }

      if (int_4 == 6) {
        ++int_7;
      }

      if (int_4 == 7) {
        ++int_6;
        ++int_7;
      }

      Class39.anIntArray16[int_0] = (int_6 << 14) + int_7 + (int_5 << 28);
      return false;
    }
    int_2 = packetbuffer_0.getBits(18);
    int_3 = int_2 >> 16;
    int_4 = int_2 >> 8 & 0xFF;
    int_9 = int_2 & 0xFF;
    int_5 = Class39.anIntArray16[int_0];
    int_6 = (int_5 >> 28) + int_3 & 0x3;
    int_7 = int_4 + (int_5 >> 14) & 0xFF;
    int_8 = int_9 + int_5 & 0xFF;
    Class39.anIntArray16[int_0] = (int_7 << 14) + int_8 + (int_6 << 28);
    return false;
  }

  @Override
  public boolean method5(final int int_0, final int int_1) {
    return int_0 >> 6 == anInt217 && int_1 >> 6 == anInt219;
  }

  @Override
  public boolean method6(final int int_0, final int int_1, final int int_2) {
    return int_0 >= anInt216 && int_0 < anInt218 + anInt216
        ? int_1 >> 6 == anInt220 && int_2 >> 6 == anInt221
        : false;
  }

  @Override
  public void method7(final WorldMapData worldmapdata_0) {
    if (worldmapdata_0.anInt112 > anInt217) {
      worldmapdata_0.anInt112 = anInt217;
    }

    if (worldmapdata_0.anInt110 < anInt217) {
      worldmapdata_0.anInt110 = anInt217;
    }

    if (worldmapdata_0.anInt113 > anInt219) {
      worldmapdata_0.anInt113 = anInt219;
    }

    if (worldmapdata_0.anInt111 < anInt219) {
      worldmapdata_0.anInt111 = anInt219;
    }

  }

  @Override
  public Position method8(final int int_0, final int int_1) {
    if (!method5(int_0, int_1)) {
      return null;
    }
    final int int_2 = anInt220 * 64 - anInt217 * 64 + int_0;
    final int int_3 = anInt221 * 64 - anInt219 * 64 + int_1;
    return new Position(anInt216, int_2, int_3);
  }

  @Override
  public int[] method9(final int int_0, final int int_1, final int int_2) {
    if (!method6(int_0, int_1, int_2)) {
      return null;
    }
    final int[] ints_0 = new int[] {
        anInt217 * 64 - anInt220 * 64 + int_1,
        anInt219 * 64 - anInt221 * 64 + int_2
    };
    return ints_0;
  }

  void method562() {
  }

  @Override
  public void method10(final Buffer buffer_0) {
    anInt216 = buffer_0.getUnsignedByte();
    anInt218 = buffer_0.getUnsignedByte();
    anInt220 = buffer_0.getUnsignedShort();
    anInt221 = buffer_0.getUnsignedShort();
    anInt217 = buffer_0.getUnsignedShort();
    anInt219 = buffer_0.getUnsignedShort();
    method562();
  }

}
