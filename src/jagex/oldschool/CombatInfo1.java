package jagex.oldschool;

import jagex.oldschool.collections.Node;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Projectile;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptExecutor;

public class CombatInfo1 extends Node {

  int anInt361;
  int healthRatio;
  int health;
  int anInt362;

  CombatInfo1(final int int_0, final int int_1, final int int_2, final int int_3) {
    anInt361 = int_0;
    healthRatio = int_1;
    health = int_2;
    anInt362 = int_3;
  }

  public static int method666(int int_0, int int_1) {
    int int_2;
    if (int_1 > int_0) {
      int_2 = int_0;
      int_0 = int_1;
      int_1 = int_2;
    }

    while (int_1 != 0) {
      int_2 = int_0 % int_1;
      int_0 = int_1;
      int_1 = int_2;
    }

    return int_0;
  }

  public static int copy(final CharSequence charsequence_0, final int int_0, final int int_1,
      final byte[] bytes_0, final int int_2) {
    final int int_3 = int_1 - int_0;

    for (int int_4 = 0; int_4 < int_3; int_4++) {
      final char char_0 = charsequence_0.charAt(int_4 + int_0);
      if (char_0 > 0 && char_0 < 128 || char_0 >= 160 && char_0 <= 255) {
        bytes_0[int_4 + int_2] = (byte) char_0;
      } else if (char_0 == 8364) {
        bytes_0[int_4 + int_2] = -128;
      } else if (char_0 == 8218) {
        bytes_0[int_4 + int_2] = -126;
      } else if (char_0 == 402) {
        bytes_0[int_4 + int_2] = -125;
      } else if (char_0 == 8222) {
        bytes_0[int_4 + int_2] = -124;
      } else if (char_0 == 8230) {
        bytes_0[int_4 + int_2] = -123;
      } else if (char_0 == 8224) {
        bytes_0[int_4 + int_2] = -122;
      } else if (char_0 == 8225) {
        bytes_0[int_4 + int_2] = -121;
      } else if (char_0 == 710) {
        bytes_0[int_4 + int_2] = -120;
      } else if (char_0 == 8240) {
        bytes_0[int_4 + int_2] = -119;
      } else if (char_0 == 352) {
        bytes_0[int_4 + int_2] = -118;
      } else if (char_0 == 8249) {
        bytes_0[int_4 + int_2] = -117;
      } else if (char_0 == 338) {
        bytes_0[int_4 + int_2] = -116;
      } else if (char_0 == 381) {
        bytes_0[int_4 + int_2] = -114;
      } else if (char_0 == 8216) {
        bytes_0[int_4 + int_2] = -111;
      } else if (char_0 == 8217) {
        bytes_0[int_4 + int_2] = -110;
      } else if (char_0 == 8220) {
        bytes_0[int_4 + int_2] = -109;
      } else if (char_0 == 8221) {
        bytes_0[int_4 + int_2] = -108;
      } else if (char_0 == 8226) {
        bytes_0[int_4 + int_2] = -107;
      } else if (char_0 == 8211) {
        bytes_0[int_4 + int_2] = -106;
      } else if (char_0 == 8212) {
        bytes_0[int_4 + int_2] = -105;
      } else if (char_0 == 732) {
        bytes_0[int_4 + int_2] = -104;
      } else if (char_0 == 8482) {
        bytes_0[int_4 + int_2] = -103;
      } else if (char_0 == 353) {
        bytes_0[int_4 + int_2] = -102;
      } else if (char_0 == 8250) {
        bytes_0[int_4 + int_2] = -101;
      } else if (char_0 == 339) {
        bytes_0[int_4 + int_2] = -100;
      } else if (char_0 == 382) {
        bytes_0[int_4 + int_2] = -98;
      } else if (char_0 == 376) {
        bytes_0[int_4 + int_2] = -97;
      } else {
        bytes_0[int_4 + int_2] = 63;
      }
    }

    return int_3;
  }

  public static String method668(String string_0, final boolean bool_0) {
    final String string_1 = bool_0 ? "https://" : "http://";
    if (Client.socketType == 1) {
      string_0 = string_0 + "-wtrc";
    } else if (Client.socketType == 2) {
      string_0 = string_0 + "-wtqa";
    } else if (Client.socketType == 3) {
      string_0 = string_0 + "-wtwip";
    } else if (Client.socketType == 5) {
      string_0 = string_0 + "-wti";
    } else if (Client.socketType == 4) {
      string_0 = "local";
    }

    String string_2 = "";
    if (Client.sessionToken != null) {
      string_2 = "/p=" + Client.sessionToken;
    }

    final String string_3 = "runescape.com";
    return string_1 + string_0 + "." + string_3 + "/l=" + Client.languageId + "/a="
        + Class27.anInt76 + string_2
        + "/";
  }

  public static int method669(final int int_0, final int int_1, int int_2) {
    int_2 &= 0x3;
    return int_2 == 0 ? int_1 : int_2 == 1 ? 7 - int_0 : int_2 == 2 ? 7 - int_1 : int_0;
  }

  public static int method670(final int int_0, final Script script_0, final boolean bool_0) {
    if (int_0 == 5000) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.anInt673;
      return 1;
    }
    int int_1;
    if (int_0 == 5001) {
      ScriptExecutor.intStackSize -= 3;
      Client.anInt673 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      final Class104[] class104s_0 = new Class104[] {
          Class104.TWO, Class104.ONE,
          Class104.ZERO
      };
      final Class104[] class104s_1 = class104s_0;
      int int_6 = 0;

      Class104 class104_1;
      while (true) {
        if (int_6 >= class104s_1.length) {
          class104_1 = null;
          break;
        }

        final Class104 class104_0 = class104s_1[int_6];
        if (int_1 == class104_0.anInt202) {
          class104_1 = class104_0;
          break;
        }

        ++int_6;
      }

      Projectile.aClass104_4 = class104_1;
      if (Projectile.aClass104_4 == null) {
        Projectile.aClass104_4 = Class104.ONE;
      }

      Client.anInt677 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
      Client.outbound.putEncipheredByte(125);
      Client.outbound.putByte(Client.anInt673);
      Client.outbound.putByte(Projectile.aClass104_4.anInt202);
      Client.outbound.putByte(Client.anInt677);
      return 1;
    }
    String string_1;
    int int_2;
    if (int_0 == 5002) {
      string_1 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      ScriptExecutor.intStackSize -= 2;
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      Client.outbound.putEncipheredByte(31);
      Client.outbound.putByte(Class64.getLength(string_1) + 2);
      Client.outbound.putString(string_1);
      Client.outbound.putByte(int_1 - 1);
      Client.outbound.putByte(int_2);
      return 1;
    }
    int int_3;
    if (int_0 == 5003) {
      ScriptExecutor.intStackSize -= 2;
      int_3 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
      int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
      final ChatLineBuffer chatlinebuffer_0 = (ChatLineBuffer) Class36.chatLineMap
          .get(Integer.valueOf(int_3));
      final MessageNode messagenode_1 = chatlinebuffer_0.method11(int_1);
      if (messagenode_1 != null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = messagenode_1.id;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = messagenode_1.tick;
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = messagenode_1.name != null
            ? messagenode_1.name
            : "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
            - 1] = messagenode_1.sender != null ? messagenode_1.sender : "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = messagenode_1.value != null
            ? messagenode_1.value
            : "";
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
      }

      return 1;
    }
    if (int_0 == 5004) {
      int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      final MessageNode messagenode_2 = (MessageNode) Class36.anIterableHashTable1.get(int_3);
      if (messagenode_2 != null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = messagenode_2.type;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = messagenode_2.tick;
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = messagenode_2.name != null
            ? messagenode_2.name
            : "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
            - 1] = messagenode_2.sender != null ? messagenode_2.sender : "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = messagenode_2.value != null
            ? messagenode_2.value
            : "";
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
      }

      return 1;
    }
    if (int_0 == 5005) {
      if (Projectile.aClass104_4 == null) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
      } else {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Projectile.aClass104_4.anInt202;
      }

      return 1;
    }
    if (int_0 == 5008) {
      string_1 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
      int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
      String string_0 = string_1.toLowerCase();
      byte byte_1 = 0;
      if (string_0.startsWith("yellow:")) {
        byte_1 = 0;
        string_1 = string_1.substring("yellow:".length());
      } else if (string_0.startsWith("red:")) {
        byte_1 = 1;
        string_1 = string_1.substring("red:".length());
      } else if (string_0.startsWith("green:")) {
        byte_1 = 2;
        string_1 = string_1.substring("green:".length());
      } else if (string_0.startsWith("cyan:")) {
        byte_1 = 3;
        string_1 = string_1.substring("cyan:".length());
      } else if (string_0.startsWith("purple:")) {
        byte_1 = 4;
        string_1 = string_1.substring("purple:".length());
      } else if (string_0.startsWith("white:")) {
        byte_1 = 5;
        string_1 = string_1.substring("white:".length());
      } else if (string_0.startsWith("flash1:")) {
        byte_1 = 6;
        string_1 = string_1.substring("flash1:".length());
      } else if (string_0.startsWith("flash2:")) {
        byte_1 = 7;
        string_1 = string_1.substring("flash2:".length());
      } else if (string_0.startsWith("flash3:")) {
        byte_1 = 8;
        string_1 = string_1.substring("flash3:".length());
      } else if (string_0.startsWith("glow1:")) {
        byte_1 = 9;
        string_1 = string_1.substring("glow1:".length());
      } else if (string_0.startsWith("glow2:")) {
        byte_1 = 10;
        string_1 = string_1.substring("glow2:".length());
      } else if (string_0.startsWith("glow3:")) {
        byte_1 = 11;
        string_1 = string_1.substring("glow3:".length());
      } else if (Client.languageId != 0) {
        if (string_0.startsWith("yellow:")) {
          byte_1 = 0;
          string_1 = string_1.substring("yellow:".length());
        } else if (string_0.startsWith("red:")) {
          byte_1 = 1;
          string_1 = string_1.substring("red:".length());
        } else if (string_0.startsWith("green:")) {
          byte_1 = 2;
          string_1 = string_1.substring("green:".length());
        } else if (string_0.startsWith("cyan:")) {
          byte_1 = 3;
          string_1 = string_1.substring("cyan:".length());
        } else if (string_0.startsWith("purple:")) {
          byte_1 = 4;
          string_1 = string_1.substring("purple:".length());
        } else if (string_0.startsWith("white:")) {
          byte_1 = 5;
          string_1 = string_1.substring("white:".length());
        } else if (string_0.startsWith("flash1:")) {
          byte_1 = 6;
          string_1 = string_1.substring("flash1:".length());
        } else if (string_0.startsWith("flash2:")) {
          byte_1 = 7;
          string_1 = string_1.substring("flash2:".length());
        } else if (string_0.startsWith("flash3:")) {
          byte_1 = 8;
          string_1 = string_1.substring("flash3:".length());
        } else if (string_0.startsWith("glow1:")) {
          byte_1 = 9;
          string_1 = string_1.substring("glow1:".length());
        } else if (string_0.startsWith("glow2:")) {
          byte_1 = 10;
          string_1 = string_1.substring("glow2:".length());
        } else if (string_0.startsWith("glow3:")) {
          byte_1 = 11;
          string_1 = string_1.substring("glow3:".length());
        }
      }

      string_0 = string_1.toLowerCase();
      byte byte_0 = 0;
      if (string_0.startsWith("wave:")) {
        byte_0 = 1;
        string_1 = string_1.substring("wave:".length());
      } else if (string_0.startsWith("wave2:")) {
        byte_0 = 2;
        string_1 = string_1.substring("wave2:".length());
      } else if (string_0.startsWith("shake:")) {
        byte_0 = 3;
        string_1 = string_1.substring("shake:".length());
      } else if (string_0.startsWith("scroll:")) {
        byte_0 = 4;
        string_1 = string_1.substring("scroll:".length());
      } else if (string_0.startsWith("slide:")) {
        byte_0 = 5;
        string_1 = string_1.substring("slide:".length());
      } else if (Client.languageId != 0) {
        if (string_0.startsWith("wave:")) {
          byte_0 = 1;
          string_1 = string_1.substring("wave:".length());
        } else if (string_0.startsWith("wave2:")) {
          byte_0 = 2;
          string_1 = string_1.substring("wave2:".length());
        } else if (string_0.startsWith("shake:")) {
          byte_0 = 3;
          string_1 = string_1.substring("shake:".length());
        } else if (string_0.startsWith("scroll:")) {
          byte_0 = 4;
          string_1 = string_1.substring("scroll:".length());
        } else if (string_0.startsWith("slide:")) {
          byte_0 = 5;
          string_1 = string_1.substring("slide:".length());
        }
      }

      Client.outbound.putEncipheredByte(140);
      Client.outbound.putByte(0);
      final int int_5 = Client.outbound.offset;
      Client.outbound.putByte(int_1);
      Client.outbound.putByte(byte_1);
      Client.outbound.putByte(byte_0);
      CacheableNode_Sub6.method861(Client.outbound, string_1);
      Client.outbound.putLengthByte(Client.outbound.offset - int_5);
      return 1;
    }
    if (int_0 == 5009) {
      Class26.scriptStringStackSize -= 2;
      string_1 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
      final String string_2 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
      Client.outbound.putEncipheredByte(71);
      Client.outbound.putShort(0);
      int_2 = Client.outbound.offset;
      Client.outbound.putString(string_1);
      CacheableNode_Sub6.method861(Client.outbound, string_2);
      Client.outbound.putLengthShort(Client.outbound.offset - int_2);
      return 1;
    }
    if (int_0 != 5015) {
      if (int_0 == 5016) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.anInt677;
        return 1;
      }
      if (int_0 == 5017) {
        int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class39.method267(int_3);
        return 1;
      }
      int[] ints_0;
      int int_4;
      MessageNode messagenode_0;
      if (int_0 == 5018) {
        int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ints_0 = ScriptExecutor.intStack;
        int_2 = ++ScriptExecutor.intStackSize - 1;
        messagenode_0 = (MessageNode) Class36.anIterableHashTable1.get(int_3);
        if (messagenode_0 == null) {
          int_4 = -1;
        } else if (messagenode_0.prevSub == Class36.aClass76_1.head) {
          int_4 = -1;
        } else {
          int_4 = ((MessageNode) messagenode_0.prevSub).id;
        }

        ints_0[int_2] = int_4;
        return 1;
      }
      if (int_0 == 5019) {
        int_3 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ints_0 = ScriptExecutor.intStack;
        int_2 = ++ScriptExecutor.intStackSize - 1;
        messagenode_0 = (MessageNode) Class36.anIterableHashTable1.get(int_3);
        if (messagenode_0 == null) {
          int_4 = -1;
        } else if (messagenode_0.nextSub == Class36.aClass76_1.head) {
          int_4 = -1;
        } else {
          int_4 = ((MessageNode) messagenode_0.nextSub).id;
        }

        ints_0[int_2] = int_4;
        return 1;
      }
      if (int_0 == 5020) {
        string_1 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        if (string_1.equalsIgnoreCase("toggleroof")) {
          LongVariable.preferences.hideRoofs = !LongVariable.preferences.hideRoofs;
          Class4.method125();
          if (LongVariable.preferences.hideRoofs) {
            Npc.sendGameMessage(99, "", "Roofs are now all hidden");
          } else {
            Npc.sendGameMessage(99, "", "Roofs will only be removed selectively");
          }
        }

        if (string_1.equalsIgnoreCase("displayfps")) {
          Client.displayFps = !Client.displayFps;
        }

        if (Client.rights >= 2) {
          if (string_1.equalsIgnoreCase("aabb")) {
            if (!Class38.aBool10) {
              Class38.aBool10 = true;
              Class38.aClass40_1 = Class40.aClass40_3;
            } else if (Class38.aClass40_1 == Class40.aClass40_3) {
              Class38.aBool10 = true;
              Class38.aClass40_1 = Class40.aClass40_2;
            } else {
              Class38.aBool10 = false;
            }
          }

          if (string_1.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
          }

          if (string_1.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
          }

          if (string_1.equalsIgnoreCase("gc")) {
            System.gc();
          }

          if (string_1.equalsIgnoreCase("clientdrop")) {
            if (Client.anInt595 > 0) {
              Class4.method123();
            } else {
              Mouse.setGameState(40);
              Class53.aSocketStream1 = VertexNormal.stream;
              VertexNormal.stream = null;
            }
          }

          if (string_1.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
          }
        }

        Client.outbound.putEncipheredByte(233);
        Client.outbound.putByte(string_1.length() + 1);
        Client.outbound.putString(string_1);
        return 1;
      }
      if (int_0 == 5021) {
        Client.aString36 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize]
            .toLowerCase().trim();
        return 1;
      }
      if (int_0 == 5022) {
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = Client.aString36;
        return 1;
      }
      return 2;
    }
    if (GrandExchangeOffer.localPlayer != null && GrandExchangeOffer.localPlayer.name != null) {
      string_1 = GrandExchangeOffer.localPlayer.name;
    } else {
      string_1 = "";
    }

    ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_1;
    return 1;
  }

  void method665(final int int_0, final int int_1, final int int_2, final int int_3) {
    anInt361 = int_0;
    healthRatio = int_1;
    health = int_2;
    anInt362 = int_3;
  }

}
