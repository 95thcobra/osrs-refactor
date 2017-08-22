package jagex.oldschool;

import jagex.oldschool.animation.Animation;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.asset.Package;
import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.AbstractFont;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.ui.InterfaceComponent;

public class Class4 {

  static Package indexInterfaces;
  String aString1;
  Class41 aClass41_1;
  int anInt33;
  int anInt34;

  Class4(final String string_0, final int int_0, final int int_1, final Class41 class41_0) {
    aString1 = string_0;
    anInt33 = int_0;
    anInt34 = int_1;
    aClass41_1 = class41_0;
  }

  public static Animation getFrames(final int int_0) {
    Animation frames_0 = (Animation) AnimationSequence.skeletons.get(int_0);
    if (frames_0 != null) {
      return frames_0;
    }
    frames_0 = GrandExchangeOffer.method174(Class47.skel_ref, AnimationSequence.skin_ref, int_0, false);
    if (frames_0 != null) {
      AnimationSequence.skeletons.put(frames_0, int_0);
    }

    return frames_0;
  }

  static void method123() {
    if (VertexNormal.stream != null) {
      VertexNormal.stream.close();
      VertexNormal.stream = null;
    }

    Client.method516();
    Class11.region.reset();

    for (int int_0 = 0; int_0 < 4; int_0++) {
      Client.collisionMaps[int_0].reset();
    }

    System.gc();
    Class72.anInt168 = 1;
    Class72.anIndexDataBase4 = null;
    Enum3.anInt339 = -1;
    RuntimeException_Sub1.anInt527 = -1;
    Class72.anInt170 = 0;
    Class36.aBool8 = false;
    Class72.anInt169 = 2;
    Client.anInt613 = -1;
    Client.aBool81 = false;
    Class25.method223();
    Mouse.setGameState(10);
  }

  public static BitmapFont method124(final AbstractPackage indexdatabase_0,
      final AbstractPackage indexdatabase_1,
      final String string_0, final String string_1) {
    final int int_0 = indexdatabase_0.getFile(string_0);
    final int int_1 = indexdatabase_0.getChild(int_0, string_1);
    return LocalRequest.method650(indexdatabase_0, indexdatabase_1, int_0, int_1);
  }

  public static void method125() {
    FileOnDisk fileondisk_0 = null;

    try {
      fileondisk_0 = Class35.getPreferencesFile("", Class12.game.aString20, true);
      final Buffer buffer_0 = LongVariable.preferences.encode();
      fileondisk_0.write(buffer_0.bytes, 0, buffer_0.offset);
    } catch (final Exception exception_0) {
    }

    try {
      if (fileondisk_0 != null) {
        fileondisk_0.close();
      }

    } catch (final Exception exception_1) {
    }
  }

  static String method126(String string_0, final InterfaceComponent widget_0) {
    if (string_0.indexOf("%") != -1) {
      int int_0;
      for (int_0 = 1; int_0 <= 5; int_0++) {
        while (true) {
          final int int_1 = string_0.indexOf("%" + int_0);
          if (int_1 == -1) {
            break;
          }

          final String string_1 = string_0.substring(0, int_1);
          final int int_2 = Class77.method469(widget_0, int_0 - 1);
          String string_2;
          if (int_2 < 999999999) {
            string_2 = Integer.toString(int_2);
          } else {
            string_2 = "*";
          }

          string_0 = string_1 + string_2 + string_0.substring(int_1 + 2);
        }
      }

      while (true) {
        int_0 = string_0.indexOf("%dns");
        if (int_0 == -1) {
          break;
        }

        String string_3 = "";
        if (Class24.aTask1 != null) {
          string_3 = Occluder.method403(Class24.aTask1.intOperand);
          if (Class24.aTask1.result != null) {
            string_3 = (String) Class24.aTask1.result;
          }
        }

        string_0 = string_0.substring(0, int_0) + string_3 + string_0.substring(int_0 + 4);
      }
    }

    return string_0;
  }

  static void method127(final GameBuffer packetbuffer_0, final int int_0,
      final Player player_0,
      final int int_1) {
    byte byte_0 = -1;
    int int_2;
    if ((int_1 & 0x1) != 0) {
      int_2 = packetbuffer_0.getUnsignedByte();
      final byte[] bytes_0 = new byte[int_2];
      final Buffer buffer_0 = new Buffer(bytes_0);
      packetbuffer_0.get(bytes_0, 0, int_2);
      Class39.aBufferArray1[int_0] = buffer_0;
      player_0.decode(buffer_0);
    }

    int int_3;
    if ((int_1 & 0x10) != 0) {
      int_2 = packetbuffer_0.getUnsignedShort();
      if (int_2 == 65535) {
        int_2 = -1;
      }

      int_3 = packetbuffer_0.getUnsignedByte();
      LongVariable.method278(player_0, int_2, int_3);
    }

    if ((int_1 & 0x4) != 0) {
      player_0.interacting = packetbuffer_0.getUnsignedShort();
      if (player_0.interacting == 65535) {
        player_0.interacting = -1;
      }
    }

    if ((int_1 & 0x80) != 0) {
      player_0.overhead = packetbuffer_0.getString();
      if (player_0.overhead.charAt(0) == 126) {
        player_0.overhead = player_0.overhead.substring(1);
        Npc.sendGameMessage(2, player_0.name, player_0.overhead);
      } else if (player_0 == GrandExchangeOffer.localPlayer) {
        Npc.sendGameMessage(2, player_0.name, player_0.overhead);
      }

      player_0.aBool65 = false;
      player_0.anInt510 = 0;
      player_0.anInt511 = 0;
      player_0.anInt509 = 150;
    }

    int int_5;
    int int_6;
    if ((int_1 & 0x8) != 0) {
      int_2 = packetbuffer_0.getUnsignedByte();
      int int_4;
      int int_7;
      int int_8;
      if (int_2 > 0) {
        for (int_3 = 0; int_3 < int_2; int_3++) {
          int_4 = -1;
          int_5 = -1;
          int_6 = -1;
          int_7 = packetbuffer_0.getUnsignedSmartShort();
          if (int_7 == 32767) {
            int_7 = packetbuffer_0.getUnsignedSmartShort();
            int_5 = packetbuffer_0.getUnsignedSmartShort();
            int_4 = packetbuffer_0.getUnsignedSmartShort();
            int_6 = packetbuffer_0.getUnsignedSmartShort();
          } else if (int_7 != 32766) {
            int_5 = packetbuffer_0.getUnsignedSmartShort();
          } else {
            int_7 = -1;
          }

          int_8 = packetbuffer_0.getUnsignedSmartShort();
          player_0.method911(int_7, int_5, int_4, int_6, Client.tick, int_8);
        }
      }

      int_3 = packetbuffer_0.getUnsignedByte();
      if (int_3 > 0) {
        for (int_7 = 0; int_7 < int_3; int_7++) {
          int_4 = packetbuffer_0.getUnsignedSmartShort();
          int_5 = packetbuffer_0.getUnsignedSmartShort();
          if (int_5 != 32767) {
            int_6 = packetbuffer_0.getUnsignedSmartShort();
            int_8 = packetbuffer_0.getUnsignedByte();
            final int int_9 = int_5 > 0 ? packetbuffer_0.getUnsignedByte() : int_8;
            player_0.method913(int_4, Client.tick, int_5, int_6, int_8, int_9);
          } else {
            player_0.method912(int_4);
          }
        }
      }
    }

    if ((int_1 & 0x20) != 0) {
      player_0.anInt496 = packetbuffer_0.getUnsignedShort();
      if (player_0.queueSize == 0) {
        player_0.orientation = player_0.anInt496;
        player_0.anInt496 = -1;
      }
    }

    if ((int_1 & 0x2) != 0) {
      int_2 = packetbuffer_0.getUnsignedShort();
      final UserGroup[] permissions_0 = new UserGroup[] {
          UserGroup.USER_GROUP_3, UserGroup.USER_GROUP_5,
          UserGroup.USER_GROUP_1, UserGroup.USER_GROUP_4, UserGroup.USER_GROUP_2,
          UserGroup.USER_GROUP_0
      };
      final UserGroup permission_0 = (UserGroup) PlayerIdentity.forOrdinal(permissions_0,
          packetbuffer_0.getUnsignedByte());
      final boolean bool_0 = packetbuffer_0.getUnsignedByte() == 1;
      int_5 = packetbuffer_0.getUnsignedByte();
      int_6 = packetbuffer_0.offset;
      if (player_0.name != null && player_0.composition != null) {
        boolean bool_1 = false;
        if (permission_0.aBool39 && Enum1.isIgnored(player_0.name)) {
          bool_1 = true;
        }

        if (!bool_1 && Client.anInt655 == 0 && !player_0.hidden) {
          Class39.aBuffer2.offset = 0;
          packetbuffer_0.get(Class39.aBuffer2.bytes, 0, int_5);
          Class39.aBuffer2.offset = 0;
          final String string_0 = AbstractFont
              .appendTags(PlayerVariable.method906(Enum5.method664(Class39.aBuffer2)));
          player_0.overhead = string_0.trim();
          player_0.anInt510 = int_2 >> 8;
          player_0.anInt511 = int_2 & 0xFF;
          player_0.anInt509 = 150;
          player_0.aBool65 = bool_0;
          player_0.inSequence = player_0 != GrandExchangeOffer.localPlayer && permission_0.aBool39
              && "" != Client.aString36 && string_0.toLowerCase().indexOf(Client.aString36)
              == -1;
          int int_10;
          if (permission_0.aBool38) {
            int_10 = bool_0 ? 91 : 1;
          } else {
            int_10 = bool_0 ? 90 : 2;
          }

          if (permission_0.anInt292 != -1) {
            Npc.sendGameMessage(int_10, Class46.method292(permission_0.anInt292) + player_0.name,
                string_0);
          } else {
            Npc.sendGameMessage(int_10, player_0.name, string_0);
          }
        }
      }

      packetbuffer_0.offset = int_5 + int_6;
    }

    if ((int_1 & 0x100) != 0) {
      player_0.graphic = packetbuffer_0.getUnsignedShort();
      int_2 = packetbuffer_0.getInt();
      player_0.anInt512 = int_2 >> 16;
      player_0.graphicsDelay = (int_2 & 0xFFFF) + Client.tick;
      player_0.anInt508 = 0;
      player_0.anInt516 = 0;
      if (player_0.graphicsDelay > Client.tick) {
        player_0.anInt508 = -1;
      }

      if (player_0.graphic == 65535) {
        player_0.graphic = -1;
      }
    }

    if ((int_1 & 0x800) != 0) {
      player_0.anInt522 = packetbuffer_0.getByte();
      player_0.anInt523 = packetbuffer_0.getByte();
      player_0.anInt524 = packetbuffer_0.getByte();
      player_0.anInt525 = packetbuffer_0.getByte();
      player_0.anInt520 = packetbuffer_0.getUnsignedShort() + Client.tick;
      player_0.anInt521 = packetbuffer_0.getUnsignedShort() + Client.tick;
      player_0.anInt526 = packetbuffer_0.getUnsignedShort();
      if (player_0.aBool76) {
        player_0.anInt522 += player_0.anInt591;
        player_0.anInt523 += player_0.anInt592;
        player_0.anInt524 += player_0.anInt591;
        player_0.anInt525 += player_0.anInt592;
        player_0.queueSize = 0;
      } else {
        player_0.anInt522 += player_0.pathX[0];
        player_0.anInt523 += player_0.pathY[0];
        player_0.anInt524 += player_0.pathX[0];
        player_0.anInt525 += player_0.pathY[0];
        player_0.queueSize = 1;
      }

      player_0.anInt497 = 0;
    }

    if ((int_1 & 0x200) != 0) {
      Class39.aByteArray4[int_0] = packetbuffer_0.getByte();
    }

    if ((int_1 & 0x400) != 0) {
      byte_0 = packetbuffer_0.getByte();
    }

    if ((int_1 & 0x1000) != 0) {
      for (int_2 = 0; int_2 < 3; int_2++) {
        player_0.actions[int_2] = packetbuffer_0.getString();
      }
    }

    if (player_0.aBool76) {
      if (byte_0 == 127) {
        player_0.method1050(player_0.anInt591, player_0.anInt592);
      } else {
        byte byte_1;
        if (byte_0 != -1) {
          byte_1 = byte_0;
        } else {
          byte_1 = Class39.aByteArray4[int_0];
        }

        player_0.method1052(player_0.anInt591, player_0.anInt592, byte_1);
      }
    }
  }

}
