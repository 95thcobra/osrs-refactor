package jagex.oldschool;

import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.scene.GroundObject;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Scene;
import java.util.Comparator;

public final class Class52 implements Comparator {

  public static byte method330(final char char_0) {
    byte byte_0;
    if (char_0 > 0 && char_0 < 128 || char_0 >= 160 && char_0 <= 255) {
      byte_0 = (byte) char_0;
    } else if (char_0 == 8364) {
      byte_0 = -128;
    } else if (char_0 == 8218) {
      byte_0 = -126;
    } else if (char_0 == 402) {
      byte_0 = -125;
    } else if (char_0 == 8222) {
      byte_0 = -124;
    } else if (char_0 == 8230) {
      byte_0 = -123;
    } else if (char_0 == 8224) {
      byte_0 = -122;
    } else if (char_0 == 8225) {
      byte_0 = -121;
    } else if (char_0 == 710) {
      byte_0 = -120;
    } else if (char_0 == 8240) {
      byte_0 = -119;
    } else if (char_0 == 352) {
      byte_0 = -118;
    } else if (char_0 == 8249) {
      byte_0 = -117;
    } else if (char_0 == 338) {
      byte_0 = -116;
    } else if (char_0 == 381) {
      byte_0 = -114;
    } else if (char_0 == 8216) {
      byte_0 = -111;
    } else if (char_0 == 8217) {
      byte_0 = -110;
    } else if (char_0 == 8220) {
      byte_0 = -109;
    } else if (char_0 == 8221) {
      byte_0 = -108;
    } else if (char_0 == 8226) {
      byte_0 = -107;
    } else if (char_0 == 8211) {
      byte_0 = -106;
    } else if (char_0 == 8212) {
      byte_0 = -105;
    } else if (char_0 == 732) {
      byte_0 = -104;
    } else if (char_0 == 8482) {
      byte_0 = -103;
    } else if (char_0 == 353) {
      byte_0 = -102;
    } else if (char_0 == 8250) {
      byte_0 = -101;
    } else if (char_0 == 339) {
      byte_0 = -100;
    } else if (char_0 == 382) {
      byte_0 = -98;
    } else if (char_0 == 376) {
      byte_0 = -97;
    } else {
      byte_0 = 63;
    }

    return byte_0;
  }

  static void method331(final int int_0) {
    if (int_0 == -3) {
      UrlStreamWorker.method218("Connection timed out.", "Please try using a different world.", "");
    } else if (int_0 == -2) {
      UrlStreamWorker.method218("", "Error connecting to server.", "");
    } else if (int_0 == -1) {
      UrlStreamWorker
          .method218("No response from server.", "Please try using a different world.", "");
    } else if (int_0 == 3) {
      LoginScreen.loginIndex = 3;
    } else if (int_0 == 4) {
      UrlStreamWorker.method218("Your account has been disabled.",
          "Please check your message-centre for details.", "");
    } else if (int_0 == 5) {
      UrlStreamWorker.method218("Your account has not logged out from its last",
          "session or the server is too busy right now.", "Please try again in a few minutes.");
    } else if (int_0 == 6) {
      UrlStreamWorker.method218("RuneScape has been updated!", "Please reload this page.", "");
    } else if (int_0 == 7) {
      UrlStreamWorker.method218("This world is full.", "Please use a different world.", "");
    } else if (int_0 == 8) {
      UrlStreamWorker.method218("Unable to connect.", "Login server offline.", "");
    } else if (int_0 == 9) {
      UrlStreamWorker
          .method218("Login limit exceeded.", "Too many connections from your address.", "");
    } else if (int_0 == 10) {
      UrlStreamWorker.method218("Unable to connect.", "Bad session id.", "");
    } else if (int_0 == 11) {
      UrlStreamWorker.method218("We suspect someone knows your password.",
          "Press \'change your password\' on front page.", "");
    } else if (int_0 == 12) {
      UrlStreamWorker.method218("You need a members account to login to this world.",
          "Please subscribe, or use a different world.", "");
    } else if (int_0 == 13) {
      UrlStreamWorker
          .method218("Could not complete login.", "Please try using a different world.", "");
    } else if (int_0 == 14) {
      UrlStreamWorker
          .method218("The server is being updated.", "Please wait 1 minute and try again.", "");
    } else if (int_0 == 16) {
      UrlStreamWorker
          .method218("Too many login attempts.", "Please wait a few minutes before trying again.",
              "");
    } else if (int_0 == 17) {
      UrlStreamWorker.method218("You are standing in a members-only area.",
          "To play on this world move to a free area first", "");
    } else if (int_0 == 18) {
      UrlStreamWorker.method218("Account locked as we suspect it has been stolen.",
          "Press \'recover a locked account\' on front page.", "");
    } else if (int_0 == 19) {
      UrlStreamWorker
          .method218("This world is running a closed Beta.", "Sorry invited players only.",
          "Please use a different world.");
    } else if (int_0 == 20) {
      UrlStreamWorker
          .method218("Invalid loginserver requested.", "Please try using a different world.", "");
    } else if (int_0 == 22) {
      UrlStreamWorker.method218("Malformed login packet.", "Please try again.", "");
    } else if (int_0 == 23) {
      UrlStreamWorker
          .method218("No reply from loginserver.", "Please wait 1 minute and try again.", "");
    } else if (int_0 == 24) {
      UrlStreamWorker
          .method218("Error loading your profile.", "Please contact customer support.", "");
    } else if (int_0 == 25) {
      UrlStreamWorker
          .method218("Unexpected loginserver response.", "Please try using a different world.", "");
    } else if (int_0 == 26) {
      UrlStreamWorker.method218("This computers address has been blocked",
          "as it was used to break our rules.", "");
    } else if (int_0 == 27) {
      UrlStreamWorker.method218("", "Service unavailable.", "");
    } else if (int_0 == 31) {
      UrlStreamWorker.method218("Your account must have a displayname set",
          "in order to play the game.  Please set it",
          "via the website, or the main game.");
    } else if (int_0 == 32) {
      UrlStreamWorker.method218("Your attempt to log into your account was",
          "unsuccessful.  Don\'t worry, you can sort",
          "this out by visiting the billing system.");
    } else if (int_0 == 37) {
      UrlStreamWorker.method218("Your account is currently inaccessible.",
          "Please try again in a few minutes.", "");
    } else if (int_0 == 38) {
      UrlStreamWorker.method218("You need to vote to play!", "Visit runescape.com and vote,",
          "and then come back here!");
    } else if (int_0 == 55) {
      UrlStreamWorker.method218("Sorry, but your account is not eligible to",
          "play this version of the game.  Please try", "playing the main game instead!");
    } else {
      if (int_0 == 56) {
        UrlStreamWorker
            .method218("Enter the 6-digit code generated by your", "authenticator app.", "");
        Mouse.setGameState(11);
        return;
      }

      if (int_0 == 57) {
        UrlStreamWorker.method218("The code you entered was incorrect.", "Please try again.", "");
        Mouse.setGameState(11);
        return;
      }

      UrlStreamWorker
          .method218("Unexpected server response", "Please try using a different world.", "");
    }

    Mouse.setGameState(10);
  }

  public static int parseInt(final CharSequence charsequence_0, final int int_0,
      final boolean bool_0) {
    if (int_0 >= 2 && int_0 <= 36) {
      boolean bool_1 = false;
      boolean bool_2 = false;
      int int_1 = 0;
      final int int_2 = charsequence_0.length();

      for (int int_3 = 0; int_3 < int_2; int_3++) {
        final char char_0 = charsequence_0.charAt(int_3);
        if (int_3 == 0) {
          if (char_0 == 45) {
            bool_1 = true;
            continue;
          }

          if (char_0 == 43) {
            continue;
          }
        }

        int int_5;
        if (char_0 >= 48 && char_0 <= 57) {
          int_5 = char_0 - 48;
        } else if (char_0 >= 65 && char_0 <= 90) {
          int_5 = char_0 - 55;
        } else {
          if (char_0 < 97 || char_0 > 122) {
            throw new NumberFormatException();
          }

          int_5 = char_0 - 87;
        }

        if (int_5 >= int_0) {
          throw new NumberFormatException();
        }

        if (bool_1) {
          int_5 = -int_5;
        }

        final int int_4 = int_1 * int_0 + int_5;
        if (int_4 / int_0 != int_1) {
          throw new NumberFormatException();
        }

        int_1 = int_4;
        bool_2 = true;
      }

      if (!bool_2) {
        throw new NumberFormatException();
      }
      return int_1;
    }
    throw new IllegalArgumentException("");
  }

  static void method332(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4,
      final int int_5, final int int_6) {
    final int[] ints_0 = Scene.method390(int_0, int_1, int_2);
    final int[] ints_1 = Scene.method390(int_3, int_4, int_5);
    Rasterizer2d.drawLine(ints_0[0], ints_0[1], ints_1[0], ints_1[1], int_6);
  }

  public static void method333() {
    FloorUnderlayDefinition.underlays.reset();
  }

  static void method334(final int int_0, final int int_1, final int int_2, final int int_3,
      final int int_4) {
    Class20.anIndexedSpriteArray4[0].method933(int_0, int_1);
    Class20.anIndexedSpriteArray4[1].method933(int_0, int_3 + int_1 - 16);
    Rasterizer2d.fillRectangle(int_0, int_1 + 16, 16, int_3 - 32, Client.anInt651);
    int int_5 = int_3 * (int_3 - 32) / int_4;
    if (int_5 < 8) {
      int_5 = 8;
    }

    final int int_6 = (int_3 - 32 - int_5) * int_2 / (int_4 - int_3);
    Rasterizer2d.fillRectangle(int_0, int_6 + int_1 + 16, 16, int_5, Client.anInt662);
    Rasterizer2d.drawVerticalLine(int_0, int_6 + int_1 + 16, int_5, Client.anInt665);
    Rasterizer2d.drawVerticalLine(int_0 + 1, int_6 + int_1 + 16, int_5, Client.anInt665);
    Rasterizer2d.drawHorizontalLine(int_0, int_6 + int_1 + 16, 16, Client.anInt665);
    Rasterizer2d.drawHorizontalLine(int_0, int_6 + int_1 + 17, 16, Client.anInt665);
    Rasterizer2d.drawVerticalLine(int_0 + 15, int_6 + int_1 + 16, int_5, Client.anInt666);
    Rasterizer2d.drawVerticalLine(int_0 + 14, int_6 + int_1 + 17, int_5 - 1, Client.anInt666);
    Rasterizer2d.drawHorizontalLine(int_0, int_5 + int_6 + int_1 + 15, 16, Client.anInt666);
    Rasterizer2d.drawHorizontalLine(int_0 + 1, int_6 + int_5 + int_1 + 14, 15, Client.anInt666);
  }

  static void method335(final int int_0, final int int_1, final boolean bool_0) {
    if (!bool_0 || int_0 != Class45.anInt96 || GroundObject.anInt213 != int_1) {
      Class45.anInt96 = int_0;
      GroundObject.anInt213 = int_1;
      Mouse.setGameState(25);
      Class51.drawStatusBox("Loading - please wait.", true);
      int int_2 = Boundry.baseX;
      int int_3 = WorldMapData_Sub1.baseY;
      Boundry.baseX = (int_0 - 6) * 8;
      WorldMapData_Sub1.baseY = (int_1 - 6) * 8;
      final int int_4 = Boundry.baseX - int_2;
      final int int_5 = WorldMapData_Sub1.baseY - int_3;
      int_2 = Boundry.baseX;
      int_3 = WorldMapData_Sub1.baseY;

      int int_6;
      int int_7;
      for (int_6 = 0; int_6 < 32768; int_6++) {
        final Npc npc_0 = Client.cachedNPCs[int_6];
        if (npc_0 != null) {
          for (int_7 = 0; int_7 < 10; int_7++) {
            npc_0.pathX[int_7] -= int_4;
            npc_0.pathY[int_7] -= int_5;
          }

          npc_0.x -= int_4 * 128;
          npc_0.y -= int_5 * 128;
        }
      }

      for (int_6 = 0; int_6 < 2048; int_6++) {
        final Player player_0 = Client.cachedPlayers[int_6];
        if (player_0 != null) {
          for (int_7 = 0; int_7 < 10; int_7++) {
            player_0.pathX[int_7] -= int_4;
            player_0.pathY[int_7] -= int_5;
          }

          player_0.x -= int_4 * 128;
          player_0.y -= int_5 * 128;
        }
      }

      byte byte_4 = 0;
      byte byte_0 = 104;
      byte byte_5 = 1;
      if (int_4 < 0) {
        byte_4 = 103;
        byte_0 = -1;
        byte_5 = -1;
      }

      byte byte_1 = 0;
      byte byte_2 = 104;
      byte byte_3 = 1;
      if (int_5 < 0) {
        byte_1 = 103;
        byte_2 = -1;
        byte_3 = -1;
      }

      int int_9;
      for (int int_8 = byte_4; int_8 != byte_0; int_8 += byte_5) {
        for (int_9 = byte_1; int_9 != byte_2; int_9 += byte_3) {
          final int int_10 = int_4 + int_8;
          final int int_11 = int_5 + int_9;

          for (int int_12 = 0; int_12 < 4; int_12++) {
            if (int_10 >= 0 && int_11 >= 0 && int_10 < 104 && int_11 < 104) {
              Client.groundItemDeque[int_12][int_8][int_9] = Client.groundItemDeque[int_12][int_10][int_11];
            } else {
              Client.groundItemDeque[int_12][int_8][int_9] = null;
            }
          }
        }
      }

      for (PendingSpawn pendingspawn_0 = (PendingSpawn) Client.pendingSpawns
          .getFirst(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) Client.pendingSpawns
          .getNext()) {
        pendingspawn_0.x -= int_4;
        pendingspawn_0.y -= int_5;
        if (pendingspawn_0.x < 0 || pendingspawn_0.y < 0 || pendingspawn_0.x >= 104
            || pendingspawn_0.y >= 104) {
          pendingspawn_0.unlink();
        }
      }

      if (Client.destinationX != 0) {
        Client.destinationX -= int_4;
        Client.destinationY -= int_5;
      }

      Client.anInt648 = 0;
      Client.aBool87 = false;
      Client.anInt660 = -1;
      Client.graphicsObjectDeque.clear();
      Client.projectiles.clear();

      for (int_9 = 0; int_9 < 4; int_9++) {
        Client.collisionMaps[int_9].reset();
      }

    }
  }

  public static boolean method336(final int int_0) {
    return (int_0 >> 21 & 0x1) != 0;
  }

  int method329(final Class44 class44_0, final Class44 class44_1) {
    return class44_0.aLong2 < class44_1.aLong2 ? -1
        : class44_1.aLong2 == class44_0.aLong2 ? 0 : 1;
  }

  @Override
  public int compare(final Object object_0, final Object object_1) {
    return method329((Class44) object_0, (Class44) object_1);
  }

  @Override
  public boolean equals(final Object object_0) {
    return super.equals(object_0);
  }

}
