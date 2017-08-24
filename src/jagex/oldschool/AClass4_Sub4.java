package jagex.oldschool;

import jagex.oldschool.asset.Package;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.AbstractFont;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.map.MapIcon;
import jagex.oldschool.scene.Projectile;
import jagex.oldschool.scene.Square;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.social.Ignore;
import jagex.oldschool.social.LoginNotification;
import jagex.oldschool.util.Time;

public class AClass4_Sub4 extends AClass4 {

  AClass4_Sub1 anAClass4_Sub1_2;
  AClass4_Sub3 anAClass4_Sub3_2;
  Deque aDeque6;

  AClass4_Sub4(final AClass4_Sub3 aclass4_sub3_0) {
    aDeque6 = new Deque();
    anAClass4_Sub1_2 = new AClass4_Sub1();
    anAClass4_Sub3_2 = aclass4_sub3_0;
  }

  static void drawLoginScreen(final BitmapFont font_0, final BitmapFont font_1, final BitmapFont font_2,
      final boolean bool_0) {
    if (bool_0) {
      LoginScreen.anInt98 = (Stub.canvasWidth - 765) / 2;
      LoginScreen.loginWindowX = LoginScreen.anInt98 + 202;
    }

    byte byte_0;
    int int_0;
    int int_1;
    int int_2;
    int int_3;
    int int_4;
    int int_5;
    int int_6;
    int int_10;
    int int_11;
    int int_12;
    int int_13;
    if (LoginScreen.selectWorld) {
      if (WorldMapType2.aSpritePixelsArray2 == null) {
        WorldMapType2.aSpritePixelsArray2 = Class17.method202(Time.indexSprites, "sl_back", "");
      }

      if (LoginScreen.anIndexedSpriteArray5 == null) {
        LoginScreen.anIndexedSpriteArray5 = MapIcon.method239(Time.indexSprites, "sl_flags", "");
      }

      if (Class16.anIndexedSpriteArray3 == null) {
        Class16.anIndexedSpriteArray3 = MapIcon.method239(Time.indexSprites, "sl_arrows", "");
      }

      if (CombatInfoListHolder.anIndexedSpriteArray8 == null) {
        CombatInfoListHolder.anIndexedSpriteArray8 = MapIcon
            .method239(Time.indexSprites, "sl_stars", "");
      }

      Rasterizer2d.fillRectangle(LoginScreen.anInt98, 23, 765, 480, 0);
      Rasterizer2d.method886(LoginScreen.anInt98, 0, 125, 23, 12425273, 9135624);
      Rasterizer2d.method886(LoginScreen.anInt98 + 125, 0, 640, 23, 5197647, 2697513);
      font_0.method998("Select a world", LoginScreen.anInt98 + 62, 15, 0, -1);
      if (CombatInfoListHolder.anIndexedSpriteArray8 != null) {
        CombatInfoListHolder.anIndexedSpriteArray8[1].method933(LoginScreen.anInt98 + 140, 1);
        font_1.method999("Members only world", LoginScreen.anInt98 + 152, 10, 16777215, -1);
        CombatInfoListHolder.anIndexedSpriteArray8[0].method933(LoginScreen.anInt98 + 140, 12);
        font_1.method999("Free world", LoginScreen.anInt98 + 152, 21, 16777215, -1);
      }

      if (Class16.anIndexedSpriteArray3 != null) {
        int_10 = LoginScreen.anInt98 + 280;
        if (World.anIntArray63[0] == 0 && World.anIntArray62[0] == 0) {
          Class16.anIndexedSpriteArray3[2].method933(int_10, 4);
        } else {
          Class16.anIndexedSpriteArray3[0].method933(int_10, 4);
        }

        if (World.anIntArray63[0] == 0 && World.anIntArray62[0] == 1) {
          Class16.anIndexedSpriteArray3[3].method933(int_10 + 15, 4);
        } else {
          Class16.anIndexedSpriteArray3[1].method933(int_10 + 15, 4);
        }

        font_0.method999("jagex.osrs.World", int_10 + 32, 17, 16777215, -1);
        int_0 = LoginScreen.anInt98 + 390;
        if (World.anIntArray63[0] == 1 && World.anIntArray62[0] == 0) {
          Class16.anIndexedSpriteArray3[2].method933(int_0, 4);
        } else {
          Class16.anIndexedSpriteArray3[0].method933(int_0, 4);
        }

        if (World.anIntArray63[0] == 1 && World.anIntArray62[0] == 1) {
          Class16.anIndexedSpriteArray3[3].method933(int_0 + 15, 4);
        } else {
          Class16.anIndexedSpriteArray3[1].method933(int_0 + 15, 4);
        }

        font_0.method999("Players", int_0 + 32, 17, 16777215, -1);
        int_11 = LoginScreen.anInt98 + 500;
        if (World.anIntArray63[0] == 2 && World.anIntArray62[0] == 0) {
          Class16.anIndexedSpriteArray3[2].method933(int_11, 4);
        } else {
          Class16.anIndexedSpriteArray3[0].method933(int_11, 4);
        }

        if (World.anIntArray63[0] == 2 && World.anIntArray62[0] == 1) {
          Class16.anIndexedSpriteArray3[3].method933(int_11 + 15, 4);
        } else {
          Class16.anIndexedSpriteArray3[1].method933(int_11 + 15, 4);
        }

        font_0.method999("Location", int_11 + 32, 17, 16777215, -1);
        int_1 = LoginScreen.anInt98 + 610;
        if (World.anIntArray63[0] == 3 && World.anIntArray62[0] == 0) {
          Class16.anIndexedSpriteArray3[2].method933(int_1, 4);
        } else {
          Class16.anIndexedSpriteArray3[0].method933(int_1, 4);
        }

        if (World.anIntArray63[0] == 3 && World.anIntArray62[0] == 1) {
          Class16.anIndexedSpriteArray3[3].method933(int_1 + 15, 4);
        } else {
          Class16.anIndexedSpriteArray3[1].method933(int_1 + 15, 4);
        }

        font_0.method999("Type", int_1 + 32, 17, 16777215, -1);
      }

      Rasterizer2d.fillRectangle(LoginScreen.anInt98 + 708, 4, 50, 16, 0);
      font_1.method998("Cancel", LoginScreen.anInt98 + 708 + 25, 16, 16777215, -1);
      LoginScreen.anInt105 = -1;
      if (WorldMapType2.aSpritePixelsArray2 != null) {
        byte_0 = 88;
        final byte byte_4 = 19;
        int_11 = 765 / (byte_0 + 1);
        int_1 = 480 / (byte_4 + 1);

        do {
          int_12 = int_1;
          int_4 = int_11;
          if (int_1 * (int_11 - 1) >= World.worldCount) {
            --int_11;
          }

          if (int_11 * (int_1 - 1) >= World.worldCount) {
            --int_1;
          }

          if (int_11 * (int_1 - 1) >= World.worldCount) {
            --int_1;
          }
        } while (int_1 != int_12 || int_11 != int_4);

        int_12 = (765 - int_11 * byte_0) / (int_11 + 1);
        if (int_12 > 5) {
          int_12 = 5;
        }

        int_4 = (480 - byte_4 * int_1) / (int_1 + 1);
        if (int_4 > 5) {
          int_4 = 5;
        }

        int_5 = (765 - byte_0 * int_11 - int_12 * (int_11 - 1)) / 2;
        int_6 = (480 - byte_4 * int_1 - int_4 * (int_1 - 1)) / 2;
        int_2 = int_6 + 23;
        int_13 = int_5 + LoginScreen.anInt98;
        int_3 = 0;
        boolean bool_1 = false;

        int int_7;
        for (int_7 = 0; int_7 < World.worldCount; int_7++) {
          final World world_0 = World.worldList[int_7];
          boolean bool_2 = true;
          String string_5 = Integer.toString(world_0.playerCount);
          if (world_0.playerCount == -1) {
            string_5 = "OFF";
            bool_2 = false;
          } else if (world_0.playerCount > 1980) {
            string_5 = "FULL";
            bool_2 = false;
          }

          int int_8 = 0;
          byte byte_1;
          if (world_0.method540()) {
            if (world_0.method539()) {
              byte_1 = 7;
            } else {
              byte_1 = 6;
            }
          } else if (world_0.method541()) {
            int_8 = 16711680;
            if (world_0.method539()) {
              byte_1 = 5;
            } else {
              byte_1 = 4;
            }
          } else if (world_0.method542()) {
            if (world_0.method539()) {
              byte_1 = 3;
            } else {
              byte_1 = 2;
            }
          } else if (world_0.method539()) {
            byte_1 = 1;
          } else {
            byte_1 = 0;
          }

          if (Mouse.anInt249 >= int_13 && Mouse.anInt251 >= int_2
              && Mouse.anInt249 < byte_0 + int_13 && Mouse.anInt251 < byte_4
              + int_2
              && bool_2) {
            LoginScreen.anInt105 = int_7;
            WorldMapType2.aSpritePixelsArray2[byte_1].method957(int_13, int_2, 128, 16777215);
            bool_1 = true;
          } else {
            WorldMapType2.aSpritePixelsArray2[byte_1].method942(int_13, int_2);
          }

          if (LoginScreen.anIndexedSpriteArray5 != null) {
            LoginScreen.anIndexedSpriteArray5[(world_0.method539() ? 8 : 0) + world_0.location]
                .method933(int_13 + 29, int_2);
          }

          font_0
              .method998(Integer.toString(world_0.id), int_13 + 15, byte_4 / 2 + int_2 + 5, int_8,
                  -1);
          font_1.method998(string_5, int_13 + 60, byte_4 / 2 + int_2 + 5, 268435455, -1);
          int_2 = int_2 + int_4 + byte_4;
          ++int_3;
          if (int_3 >= int_1) {
            int_2 = int_6 + 23;
            int_13 = int_13 + int_12 + byte_0;
            int_3 = 0;
          }
        }

        if (bool_1) {
          int_7 = font_1.method989(World.worldList[LoginScreen.anInt105].activity) + 6;
          final int int_9 = font_1.verticalSpace + 8;
          Rasterizer2d
              .fillRectangle(Mouse.anInt249 - int_7 / 2, Mouse.anInt251 + 20 + 5, int_7,
                  int_9, 16777120);
          Rasterizer2d
              .drawRectangle(Mouse.anInt249 - int_7 / 2, Mouse.anInt251 + 20 + 5, int_7,
                  int_9, 0);
          font_1.method998(World.worldList[LoginScreen.anInt105].activity, Mouse.anInt249,
              Mouse.anInt251 + font_1.verticalSpace + 20 + 5 + 4, 0, -1);
        }
      }

      FileCache.rasterBuffer.draw(0, 0);
    } else {
      if (bool_0) {
        CacheableNode_Sub6.aSpritePixels4.method942(LoginScreen.anInt98, 0);
        Enum2.aSpritePixels3.method942(LoginScreen.anInt98 + 382, 0);
        Class35.logoSprite
            .method933(LoginScreen.anInt98 + 382 - Class35.logoSprite.width / 2, 18);
      }

      if (Client.state == 0 || Client.state == 5) {
        byte_0 = 20;
        font_0.method998("RuneScape is loading - please wait...", LoginScreen.loginWindowX + 180,
            245 - byte_0,
            16777215, -1);
        int_0 = 253 - byte_0;
        Rasterizer2d.drawRectangle(LoginScreen.loginWindowX + 180 - 152, int_0, 304, 34, 9179409);
        Rasterizer2d.drawRectangle(LoginScreen.loginWindowX + 180 - 151, int_0 + 1, 302, 32, 0);
        Rasterizer2d.fillRectangle(LoginScreen.loginWindowX + 180 - 150, int_0 + 2,
            LoginScreen.loadingPercent * 3,
            30, 9179409);
        Rasterizer2d
            .fillRectangle(LoginScreen.loginWindowX + 180 - 150 + LoginScreen.loadingPercent * 3,
                int_0 + 2, 300 - LoginScreen.loadingPercent * 3, 30, 0);
        font_0
            .method998(LoginScreen.loadingText, LoginScreen.loginWindowX + 180, 276 - byte_0, 16777215, -1);
      }

      String string_0;
      String string_1;
      String string_2;
      char[] chars_0;
      String string_3;
      short short_3;
      short short_4;
      if (Client.state == 20) {
        LoginScreen.anIndexedSprite3.method933(
            LoginScreen.loginWindowX + 180 - LoginScreen.anIndexedSprite3.width / 2,
            271 - LoginScreen.anIndexedSprite3.height / 2);
        short_3 = 211;
        font_0.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16776960, 0);
        int_10 = short_3 + 15;
        font_0.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
        int_10 += 15;
        font_0.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
        int_10 += 15;
        int_10 += 10;
        if (LoginScreen.loginIndex != 4) {
          font_0.method999("Login: ", LoginScreen.loginWindowX + 180 - 110, int_10, 16777215, 0);
          short_4 = 200;

          for (string_0 = LoginScreen.username; font_0.method989(string_0) > short_4;
              string_0 = string_0
                  .substring(0, string_0.length() - 1)) {
          }

          font_0.method999(AbstractFont.appendTags(string_0), LoginScreen.loginWindowX + 180 - 70,
              int_10,
              16777215, 0);
          int_10 += 15;
          string_1 = "Password: ";
          string_2 = LoginScreen.password;
          int_2 = string_2.length();
          chars_0 = new char[int_2];

          for (int_3 = 0; int_3 < int_2; int_3++) {
            chars_0[int_3] = 42;
          }

          string_3 = new String(chars_0);
          font_0
              .method999(string_1 + string_3, LoginScreen.loginWindowX + 180 - 108, int_10, 16777215,
                  0);
          int_10 += 15;
        }
      }

      if (Client.state == 10 || Client.state == 11) {
        LoginScreen.anIndexedSprite3.method933(LoginScreen.loginWindowX, 171);
        short short_0;
        if (LoginScreen.loginIndex == 0) {
          short_3 = 251;
          font_0
              .method998("Welcome to RuneScape", LoginScreen.loginWindowX + 180, short_3, 16776960, 0);
          int_10 = short_3 + 30;
          int_0 = LoginScreen.loginWindowX + 180 - 80;
          short_0 = 291;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_0.method995("New User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
          int_0 = LoginScreen.loginWindowX + 180 + 80;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_0
              .method995("Existing User", int_0 - 73, short_0 - 20, 144, 40, 16777215, 0, 1, 1, 0);
        } else if (LoginScreen.loginIndex == 1) {
          font_0.method998(LoginScreen.aString10, LoginScreen.loginWindowX + 180, 211, 16776960, 0);
          short_3 = 236;
          font_0.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16777215, 0);
          int_10 = short_3 + 15;
          font_0.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16777215, 0);
          int_10 += 15;
          font_0.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16777215, 0);
          int_10 += 15;
          int_0 = LoginScreen.loginWindowX + 180 - 80;
          short_0 = 321;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_0.method998("Continue", int_0, short_0 + 5, 16777215, 0);
          int_0 = LoginScreen.loginWindowX + 180 + 80;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_0.method998("Cancel", int_0, short_0 + 5, 16777215, 0);
        } else if (LoginScreen.loginIndex == 2) {
          short_3 = 211;
          font_0.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16776960, 0);
          int_10 = short_3 + 15;
          font_0.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          font_0.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          int_10 += 10;
          font_0.method999("Login: ", LoginScreen.loginWindowX + 180 - 110, int_10, 16777215, 0);
          short_4 = 200;

          for (string_0 = LoginScreen.username; font_0.method989(string_0) > short_4;
              string_0 = string_0
                  .substring(1)) {
          }

          font_0.method999(AbstractFont.appendTags(string_0)
                  + (LoginScreen.loginIndex2 == 0 & Client.tick % 40 < 20
                  ? Square.embedColor(16776960) + "|"
                  : ""),
              LoginScreen.loginWindowX + 180 - 70, int_10, 16777215, 0);
          int_10 += 15;
          string_1 = "Password: ";
          string_2 = LoginScreen.password;
          int_2 = string_2.length();
          chars_0 = new char[int_2];

          for (int_3 = 0; int_3 < int_2; int_3++) {
            chars_0[int_3] = 42;
          }

          string_3 = new String(chars_0);
          font_0.method999(string_1 + string_3
                  + (LoginScreen.loginIndex2 == 1 & Client.tick % 40 < 20
                  ? Square.embedColor(16776960) + "|"
                  : ""),
              LoginScreen.loginWindowX + 180 - 108, int_10, 16777215, 0);
          int_10 += 15;
          int_6 = LoginScreen.loginWindowX + 180 - 80;
          final short short_5 = 321;
          LoginScreen.anIndexedSprite4.method933(int_6 - 73, short_5 - 20);
          font_0.method998("Login", int_6, short_5 + 5, 16777215, 0);
          int_6 = LoginScreen.loginWindowX + 180 + 80;
          LoginScreen.anIndexedSprite4.method933(int_6 - 73, short_5 - 20);
          font_0.method998("Cancel", int_6, short_5 + 5, 16777215, 0);
          short_3 = 357;
          font_1.method998("Forgotten your password? <col=ffffff>Click here.",
              LoginScreen.loginWindowX + 180,
              short_3, 16776960, 0);
        } else if (LoginScreen.loginIndex == 3) {
          short_3 = 201;
          font_0.method998("Invalid username or password.", LoginScreen.loginWindowX + 180, short_3,
              16776960, 0);
          int_10 = short_3 + 20;
          font_1.method998("For accounts created after 24th November 2010, please use your",
              LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          font_1.method998("email address to login. Otherwise please login with your username.",
              LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          int_0 = LoginScreen.loginWindowX + 180;
          short_0 = 276;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_2.method998("Try again", int_0, short_0 + 5, 16777215, 0);
          int_0 = LoginScreen.loginWindowX + 180;
          short_0 = 326;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_2.method998("Forgotten password?", int_0, short_0 + 5, 16777215, 0);
        } else if (LoginScreen.loginIndex == 4) {
          font_0.method998("Authenticator", LoginScreen.loginWindowX + 180, 211, 16776960, 0);
          short_3 = 236;
          font_0.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16777215, 0);
          int_10 = short_3 + 15;
          font_0.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16777215, 0);
          int_10 += 15;
          font_0.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16777215, 0);
          int_10 += 15;
          string_0 = "PIN: ";
          string_1 = Preferences.authCode;
          int_5 = string_1.length();
          final char[] chars_1 = new char[int_5];

          for (int_2 = 0; int_2 < int_5; int_2++) {
            chars_1[int_2] = 42;
          }

          final String string_4 = new String(chars_1);
          font_0.method999(
              string_0 + string_4 + (Client.tick % 40 < 20 ? Square.embedColor(16776960) + "|"
                  : ""),
              LoginScreen.loginWindowX + 180 - 108, int_10, 16777215, 0);
          int_10 -= 8;
          font_0
              .method999("Trust this computer", LoginScreen.loginWindowX + 180 - 9, int_10, 16776960,
                  0);
          int_10 += 15;
          font_0.method999("for 30 days: ", LoginScreen.loginWindowX + 180 - 9, int_10, 16776960, 0);
          int_4 = LoginScreen.loginWindowX + 180 - 9 + font_0.method989("for 30 days: ") + 15;
          int_5 = int_10 - font_0.verticalSpace;
          IndexedSprite indexedsprite_0;
          if (LoginScreen.aBool14) {
            indexedsprite_0 = LongVariable.anIndexedSprite2;
          } else {
            indexedsprite_0 = Boundry.anIndexedSprite1;
          }

          indexedsprite_0.method933(int_4, int_5);
          int_10 += 15;
          int_2 = LoginScreen.loginWindowX + 180 - 80;
          final short short_2 = 321;
          LoginScreen.anIndexedSprite4.method933(int_2 - 73, short_2 - 20);
          font_0.method998("Continue", int_2, short_2 + 5, 16777215, 0);
          int_2 = LoginScreen.loginWindowX + 180 + 80;
          LoginScreen.anIndexedSprite4.method933(int_2 - 73, short_2 - 20);
          font_0.method998("Cancel", int_2, short_2 + 5, 16777215, 0);
          font_1
              .method998("<u=ff>Can\'t Log In?</u>", LoginScreen.loginWindowX + 180, short_2 + 36, 255,
                  0);
        } else if (LoginScreen.loginIndex == 5) {
          font_0
              .method998("Forgotten your password?", LoginScreen.loginWindowX + 180, 201, 16776960, 0);
          short_3 = 221;
          font_2.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16776960, 0);
          int_10 = short_3 + 15;
          font_2.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          font_2.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          int_10 += 14;
          font_0.method999("Username/email: ", LoginScreen.loginWindowX + 180 - 145, int_10, 16777215,
              0);
          short_4 = 174;

          for (string_0 = LoginScreen.username; font_0.method989(string_0) > short_4;
              string_0 = string_0
                  .substring(1)) {
          }

          font_0.method999(
              AbstractFont.appendTags(string_0)
                  + (Client.tick % 40 < 20 ? Square.embedColor(16776960) + "|" : ""),
              LoginScreen.loginWindowX + 180 - 34, int_10, 16777215, 0);
          int_10 += 15;
          int_1 = LoginScreen.loginWindowX + 180 - 80;
          final short short_1 = 321;
          LoginScreen.anIndexedSprite4.method933(int_1 - 73, short_1 - 20);
          font_0.method998("Recover", int_1, short_1 + 5, 16777215, 0);
          int_1 = LoginScreen.loginWindowX + 180 + 80;
          LoginScreen.anIndexedSprite4.method933(int_1 - 73, short_1 - 20);
          font_0.method998("Back", int_1, short_1 + 5, 16777215, 0);
        } else if (LoginScreen.loginIndex == 6) {
          short_3 = 211;
          font_0.method998(LoginScreen.loginMessage1, LoginScreen.loginWindowX + 180, short_3, 16776960, 0);
          int_10 = short_3 + 15;
          font_0.method998(LoginScreen.loginMessage2, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          font_0.method998(LoginScreen.loginMessage3, LoginScreen.loginWindowX + 180, int_10, 16776960, 0);
          int_10 += 15;
          int_0 = LoginScreen.loginWindowX + 180;
          short_0 = 321;
          LoginScreen.anIndexedSprite4.method933(int_0 - 73, short_0 - 20);
          font_0.method998("Back", int_0, short_0 + 5, 16777215, 0);
        }
      }

      if (LoginScreen.anInt103 > 0) {
        PendingSpawn.method651(LoginScreen.anInt103);
        LoginScreen.anInt103 = 0;
      }

      short_3 = 256;
      if (LoginScreen.anInt99 > 0) {
        for (int_0 = 0; int_0 < 256; int_0++) {
          if (LoginScreen.anInt99 > 768) {
            PrimitiveType.anIntArray78[int_0] = Class40.method271(WorldMapData.anIntArray24[int_0],
                WorldMapType3.anIntArray68[int_0], 1024 - LoginScreen.anInt99);
          } else if (LoginScreen.anInt99 > 256) {
            PrimitiveType.anIntArray78[int_0] = WorldMapType3.anIntArray68[int_0];
          } else {
            PrimitiveType.anIntArray78[int_0] = Class40.method271(WorldMapType3.anIntArray68[int_0],
                WorldMapData.anIntArray24[int_0], 256 - LoginScreen.anInt99);
          }
        }
      } else if (LoginScreen.anInt100 > 0) {
        for (int_0 = 0; int_0 < 256; int_0++) {
          if (LoginScreen.anInt100 > 768) {
            PrimitiveType.anIntArray78[int_0] = Class40.method271(WorldMapData.anIntArray24[int_0],
                LoginScreen.anIntArray22[int_0], 1024 - LoginScreen.anInt100);
          } else if (LoginScreen.anInt100 > 256) {
            PrimitiveType.anIntArray78[int_0] = LoginScreen.anIntArray22[int_0];
          } else {
            PrimitiveType.anIntArray78[int_0] = Class40.method271(LoginScreen.anIntArray22[int_0],
                WorldMapData.anIntArray24[int_0], 256 - LoginScreen.anInt100);
          }
        }
      } else {
        for (int_0 = 0; int_0 < 256; int_0++) {
          PrimitiveType.anIntArray78[int_0] = WorldMapData.anIntArray24[int_0];
        }
      }

      Rasterizer2d.setClip(LoginScreen.anInt98, 9, LoginScreen.anInt98 + 128, short_3 + 7);
      CacheableNode_Sub6.aSpritePixels4.method942(LoginScreen.anInt98, 0);
      Rasterizer2d.resetClip();
      int_0 = 0;
      int_11 = FileCache.rasterBuffer.width * 9 + LoginScreen.anInt98;

      for (int_1 = 1; int_1 < short_3 - 1; int_1++) {
        int_12 = LoginScreen.anIntArray20[int_1] * (short_3 - int_1) / short_3;
        int_4 = int_12 + 22;
        if (int_4 < 0) {
          int_4 = 0;
        }

        int_0 += int_4;

        for (int_5 = int_4; int_5 < 128; int_5++) {
          int_6 = Ignore.anIntArray60[int_0++];
          if (int_6 != 0) {
            int_2 = int_6;
            int_13 = 256 - int_6;
            int_6 = PrimitiveType.anIntArray78[int_6];
            int_3 = FileCache.rasterBuffer.buffer[int_11];
            FileCache.rasterBuffer.buffer[int_11++] = ((int_3 & 0xFF00FF) * int_13
                + (int_6 & 0xFF00FF) * int_2 & 0xFF00FF00)
                + (int_2 * (int_6 & 0xFF00) + int_13 * (int_3 & 0xFF00) & 0xFF0000) >> 8;
          } else {
            ++int_11;
          }
        }

        int_11 += int_4 + FileCache.rasterBuffer.width - 128;
      }

      Rasterizer2d
          .setClip(LoginScreen.anInt98 + 765 - 128, 9, LoginScreen.anInt98 + 765, short_3 + 7);
      Enum2.aSpritePixels3.method942(LoginScreen.anInt98 + 382, 0);
      Rasterizer2d.resetClip();
      int_0 = 0;
      int_11 = FileCache.rasterBuffer.width * 9 + LoginScreen.anInt98 + 637 + 24;

      for (int_1 = 1; int_1 < short_3 - 1; int_1++) {
        int_12 = LoginScreen.anIntArray20[int_1] * (short_3 - int_1) / short_3;
        int_4 = 103 - int_12;
        int_11 += int_12;

        for (int_5 = 0; int_5 < int_4; int_5++) {
          int_6 = Ignore.anIntArray60[int_0++];
          if (int_6 != 0) {
            int_2 = int_6;
            int_13 = 256 - int_6;
            int_6 = PrimitiveType.anIntArray78[int_6];
            int_3 = FileCache.rasterBuffer.buffer[int_11];
            FileCache.rasterBuffer.buffer[int_11++] = (int_13 * (int_3 & 0xFF00)
                + int_2 * (int_6 & 0xFF00) & 0xFF0000)
                + ((int_6 & 0xFF00FF) * int_2 + (int_3 & 0xFF00FF) * int_13 & 0xFF00FF00)
                >> 8;
          } else {
            ++int_11;
          }
        }

        int_0 += 128 - int_4;
        int_11 += FileCache.rasterBuffer.width - int_4 - int_12;
      }

      Game.titlemuteSprite[LongVariable.preferences.muted ? 1 : 0]
          .method933(LoginScreen.anInt98 + 765 - 40, 463);
      if (Client.state > 5 && Client.languageId == 0) {
        if (WorldMapData_Sub1.anIndexedSprite5 == null) {
          WorldMapData_Sub1.anIndexedSprite5 = Projectile
              .getSprite(Time.indexSprites, "sl_button", "");
          return;
        }

        int_10 = LoginScreen.anInt98 + 5;
        short_4 = 463;
        final byte byte_3 = 100;
        final byte byte_2 = 35;
        WorldMapData_Sub1.anIndexedSprite5.method933(int_10, short_4);
        font_0.method998("jagex.osrs.World" + " " + Client.world, byte_3 / 2 + int_10,
            byte_2 / 2 + short_4 - 2,
            16777215, 0);
        if (LoginNotification.listFetcher == null) {
          font_1.method998("Click to switch", byte_3 / 2 + int_10, byte_2 / 2 + short_4 + 12,
              16777215,
              0);
          return;
        }

        font_1.method998("Loading...", byte_3 / 2 + int_10, byte_2 / 2 + short_4 + 12, 16777215,
            0);
      }

    }
  }

  static Package openCacheIndex(final int int_0, final boolean bool_0, final boolean bool_1,
      final boolean bool_2) {
    FileCache indexfile_0 = null;
    if (LocalInstall.aCacheFile2 != null) {
      indexfile_0 = new FileCache(int_0, LocalInstall.aCacheFile2, Isaac.aCacheFileArray1[int_0],
          1000000);
    }

    return new Package(indexfile_0, ClanMember.anIndexFile3, int_0, bool_0, bool_1, bool_2);
  }

  static void groundItemSpawned(final int int_0, final int int_1) {
    final Deque deque_0 = Client.groundItemDeque[Class12.plane][int_0][int_1];
    if (deque_0 == null) {
      Class11.scene.method373(Class12.plane, int_0, int_1);
    } else {
      long long_0 = -99999999L;
      GroundItem item_0 = null;

      GroundItem item_1;
      for (item_1 = (GroundItem) deque_0.getFirst(); item_1 != null; item_1 = (GroundItem) deque_0.getNext()) {
        final ItemConfig itemcomposition_0 = AudioWorker.getItemDefinition(item_1.id);
        long long_1 = itemcomposition_0.price;
        if (itemcomposition_0.isStackable == 1) {
          long_1 *= item_1.quantity + 1;
        }

        if (long_1 > long_0) {
          long_0 = long_1;
          item_0 = item_1;
        }
      }

      if (item_0 == null) {
        Class11.scene.method373(Class12.plane, int_0, int_1);
      } else {
        deque_0.addFirst(item_0);
        GroundItem item_3 = null;
        GroundItem item_2 = null;

        for (item_1 = (GroundItem) deque_0.getFirst(); item_1 != null;
            item_1 = (GroundItem) deque_0.getNext()) {
          if (item_1.id != item_0.id) {
            if (item_3 == null) {
              item_3 = item_1;
            }

            if (item_1.id != item_3.id && item_2 == null) {
              item_2 = item_1;
            }
          }
        }

        final int int_2 = int_0 + (int_1 << 7) + 1610612736;
        Class11.scene.addItemPile(Class12.plane, int_0, int_1,
            Client.getTileHeight(int_0 * 128 + 64, int_1 * 128 + 64, Class12.plane), item_0,
            int_2,
            item_3, item_2);
      }
    }
  }

  @Override
  public void method632(final int[] ints_0, final int int_0, final int int_1) {
    anAClass4_Sub1_2.method632(ints_0, int_0, int_1);

    for (Node_Sub3 node_sub3_0 = (Node_Sub3) aDeque6
        .getFirst(); node_sub3_0 != null; node_sub3_0 = (Node_Sub3) aDeque6.getNext()) {
      if (!anAClass4_Sub3_2.method800(node_sub3_0)) {
        int int_2 = int_0;
        int int_3 = int_1;

        do {
          if (int_3 <= node_sub3_0.anInt346) {
            method831(node_sub3_0, ints_0, int_2, int_3, int_2 + int_3);
            node_sub3_0.anInt346 -= int_3;
            break;
          }

          method831(node_sub3_0, ints_0, int_2, node_sub3_0.anInt346, int_3 + int_2);
          int_2 += node_sub3_0.anInt346;
          int_3 -= node_sub3_0.anInt346;
        } while (!anAClass4_Sub3_2.method808(node_sub3_0, ints_0, int_2, int_3));
      }
    }

  }

  @Override
  public void method633(final int int_0) {
    anAClass4_Sub1_2.method633(int_0);

    for (Node_Sub3 node_sub3_0 = (Node_Sub3) aDeque6
        .getFirst(); node_sub3_0 != null; node_sub3_0 = (Node_Sub3) aDeque6.getNext()) {
      if (!anAClass4_Sub3_2.method800(node_sub3_0)) {
        int int_1 = int_0;

        do {
          if (int_1 <= node_sub3_0.anInt346) {
            method830(node_sub3_0, int_1);
            node_sub3_0.anInt346 -= int_1;
            break;
          }

          method830(node_sub3_0, node_sub3_0.anInt346);
          int_1 -= node_sub3_0.anInt346;
        } while (!anAClass4_Sub3_2.method808(node_sub3_0, null, 0, int_1));
      }
    }

  }

  @Override
  public AClass4 method635() {
    Node_Sub3 node_sub3_0;
    do {
      node_sub3_0 = (Node_Sub3) aDeque6.getNext();
      if (node_sub3_0 == null) {
        return null;
      }
    } while (node_sub3_0.anAClass4_Sub2_3 == null);

    return node_sub3_0.anAClass4_Sub2_3;
  }

  void method830(final Node_Sub3 node_sub3_0, int int_0) {
    if ((anAClass4_Sub3_2.anIntArray91[node_sub3_0.anInt343] & 0x4) != 0 && node_sub3_0.anInt345
        < 0) {
      final int int_1 =
          anAClass4_Sub3_2.anIntArray93[node_sub3_0.anInt343] / AbstractSourceLine.sampleRate;
      final int int_2 = (int_1 + 1048575 - node_sub3_0.anInt350) / int_1;
      node_sub3_0.anInt350 = node_sub3_0.anInt350 + int_1 * int_0 & 0xFFFFF;
      if (int_2 <= int_0) {
        if (anAClass4_Sub3_2.anIntArray96[node_sub3_0.anInt343] == 0) {
          node_sub3_0.anAClass4_Sub2_3 = AClass4_Sub2.method768(node_sub3_0.anAClass5_Sub1_1,
              node_sub3_0.anAClass4_Sub2_3.method742(), node_sub3_0.anAClass4_Sub2_3.method744(),
              node_sub3_0.anAClass4_Sub2_3.method730());
        } else {
          node_sub3_0.anAClass4_Sub2_3 = AClass4_Sub2.method768(node_sub3_0.anAClass5_Sub1_1,
              node_sub3_0.anAClass4_Sub2_3.method742(), 0,
              node_sub3_0.anAClass4_Sub2_3.method730());
          anAClass4_Sub3_2.method813(node_sub3_0,
              node_sub3_0.aNode_Sub5_1.aShortArray5[node_sub3_0.anInt351] < 0);
        }

        if (node_sub3_0.aNode_Sub5_1.aShortArray5[node_sub3_0.anInt351] < 0) {
          node_sub3_0.anAClass4_Sub2_3.method747(-1);
        }

        int_0 = node_sub3_0.anInt350 / int_1;
      }
    }

    node_sub3_0.anAClass4_Sub2_3.method633(int_0);
  }

  void method831(final Node_Sub3 node_sub3_0, final int[] ints_0, int int_0, int int_1,
      final int int_2) {
    if ((anAClass4_Sub3_2.anIntArray91[node_sub3_0.anInt343] & 0x4) != 0 && node_sub3_0.anInt345
        < 0) {
      final int int_3 =
          anAClass4_Sub3_2.anIntArray93[node_sub3_0.anInt343] / AbstractSourceLine.sampleRate;

      while (true) {
        final int int_4 = (int_3 + 1048575 - node_sub3_0.anInt350) / int_3;
        if (int_4 > int_1) {
          node_sub3_0.anInt350 += int_3 * int_1;
          break;
        }

        node_sub3_0.anAClass4_Sub2_3.method632(ints_0, int_0, int_4);
        int_0 += int_4;
        int_1 -= int_4;
        node_sub3_0.anInt350 += int_4 * int_3 - 1048576;
        int int_5 = AbstractSourceLine.sampleRate / 100;
        final int int_6 = 262144 / int_3;
        if (int_6 < int_5) {
          int_5 = int_6;
        }

        final AClass4_Sub2 aclass4_sub2_0 = node_sub3_0.anAClass4_Sub2_3;
        if (anAClass4_Sub3_2.anIntArray96[node_sub3_0.anInt343] == 0) {
          node_sub3_0.anAClass4_Sub2_3 = AClass4_Sub2.method768(node_sub3_0.anAClass5_Sub1_1,
              aclass4_sub2_0.method742(), aclass4_sub2_0.method744(), aclass4_sub2_0.method730());
        } else {
          node_sub3_0.anAClass4_Sub2_3 = AClass4_Sub2.method768(node_sub3_0.anAClass5_Sub1_1,
              aclass4_sub2_0.method742(), 0, aclass4_sub2_0.method730());
          anAClass4_Sub3_2.method813(node_sub3_0,
              node_sub3_0.aNode_Sub5_1.aShortArray5[node_sub3_0.anInt351] < 0);
          node_sub3_0.anAClass4_Sub2_3.method748(int_5, aclass4_sub2_0.method744());
        }

        if (node_sub3_0.aNode_Sub5_1.aShortArray5[node_sub3_0.anInt351] < 0) {
          node_sub3_0.anAClass4_Sub2_3.method747(-1);
        }

        aclass4_sub2_0.method738(int_5);
        aclass4_sub2_0.method632(ints_0, int_0, int_2 - int_0);
        if (aclass4_sub2_0.method740()) {
          anAClass4_Sub1_2.method721(aclass4_sub2_0);
        }
      }
    }

    node_sub3_0.anAClass4_Sub2_3.method632(ints_0, int_0, int_1);
  }

  @Override
  public AClass4 method636() {
    final Node_Sub3 node_sub3_0 = (Node_Sub3) aDeque6.getFirst();
    return node_sub3_0 == null ? null
        : node_sub3_0.anAClass4_Sub2_3 != null ? node_sub3_0.anAClass4_Sub2_3 : method635();
  }

  @Override
  public int method638() {
    return 0;
  }

}
