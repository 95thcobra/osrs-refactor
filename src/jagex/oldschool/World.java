package jagex.oldschool;

import jagex.oldschool.awt.Stub;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.FaceNormal;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.social.LoginNotification;

public class World {

  public static int worldCount;
  public static int anInt210;
  static int[] anIntArray62;
  static int[] anIntArray63;
  public static World[] worldList;

  static {
    worldCount = 0;
    anInt210 = 0;
    anIntArray62 = new int[] {1, 1, 1, 1};
    anIntArray63 = new int[] {0, 1, 2, 3};
  }

  public int mask;
  public int index;
  public int playerCount;
  public int id;
  public String address;
  public String activity;
  public int location;

  static void method545(final Stub stub) {
    if (LoginScreen.selectWorld) {
      WorldMapType2.method564(stub);
    } else {
      if ((Mouse.anInt248 == 1 || !GrandExchangeOffer.aBool5 && Mouse.anInt248 == 4)
          && Mouse.anInt253 >= LoginScreen.anInt98 + 765 - 50 && Mouse.anInt254
          >= 453) {
        LongVariable.preferences.muted = !LongVariable.preferences.muted;
        Class4.method125();
        if (!LongVariable.preferences.muted) {
          Class3.method122(CacheableNode_Sub4.indexTrack1, "scape main", "", 255, false);
        } else {
          AudioSystem.anAClass4_Sub3_1.method790();
          AudioSystem.anInt168 = 1;
          AudioSystem.anIndexDataBase4 = null;
        }
      }

      if (Client.state != 5) {
        ++LoginScreen.anInt103;
        if (Client.state == 10 || Client.state == 11) {
          int int_0;
          if (Client.languageId == 0) {
            if (Mouse.anInt248 == 1 || !GrandExchangeOffer.aBool5 && Mouse.anInt248
                == 4) {
              int_0 = LoginScreen.anInt98 + 5;
              final short short_0 = 463;
              final byte byte_0 = 100;
              final byte byte_1 = 35;
              if (Mouse.anInt253 >= int_0 && Mouse.anInt253 <= byte_0 + int_0
                  && Mouse.anInt254 >= short_0
                  && Mouse.anInt254 <= byte_1 + short_0) {
                if (Client.loadWorlds()) {
                  LoginScreen.selectWorld = true;
                  return;
                }

                return;
              }
            }

            if (LoginNotification.listFetcher != null && Client.loadWorlds()) {
              LoginScreen.selectWorld = true;
            }
          }

          int_0 = Mouse.anInt248;
          final int int_3 = Mouse.anInt253;
          final int int_4 = Mouse.anInt254;
          if (!GrandExchangeOffer.aBool5 && int_0 == 4) {
            int_0 = 1;
          }

          int int_6;
          short short_3;
          if (LoginScreen.loginIndex == 0) {
            boolean bool_1 = false;

            while (ClanMember.method656()) {
              if (Class3.anInt22 == 84) {
                bool_1 = true;
              }
            }

            int_6 = LoginScreen.loginWindowX + 180 - 80;
            short_3 = 291;
            if (int_0 == 1 && int_3 >= int_6 - 75 && int_3 <= int_6 + 75
                && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
              final String string_0 = CombatInfo1.method668("secure", true)
                  + "m=account-creation/g=oldscape/create_account_funnel.ws";
              Class35.method254(string_0, true, "openjs", false);
            }

            int_6 = LoginScreen.loginWindowX + 180 + 80;
            if (int_0 == 1 && int_3 >= int_6 - 75 && int_3 <= int_6 + 75
                && int_4 >= short_3 - 20 && int_4 <= short_3 + 20 || bool_1) {
              if ((Client.flags & 0x2000000) != 0) {
                LoginScreen.aString10 = "";
                LoginScreen.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                LoginScreen.loginMessage2 = "Your normal account will not be affected.";
                LoginScreen.loginMessage3 = "";
                LoginScreen.loginIndex = 1;
                LoginScreen.loginIndex2 = 0;
              } else if ((Client.flags & 0x4) != 0) {
                if ((Client.flags & 0x400) != 0) {
                  LoginScreen.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                  LoginScreen.loginMessage2 = "Players can attack each other almost everywhere";
                  LoginScreen.loginMessage3 = "and the Protect jagex.osrs.GroundItem prayer won\'t work.";
                } else {
                  LoginScreen.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                  LoginScreen.loginMessage2 = "Players can attack each other";
                  LoginScreen.loginMessage3 = "almost everywhere.";
                }

                LoginScreen.aString10 = "Warning!";
                LoginScreen.loginIndex = 1;
                LoginScreen.loginIndex2 = 0;
              } else if ((Client.flags & 0x400) != 0) {
                LoginScreen.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                LoginScreen.loginMessage2 = "The Protect jagex.osrs.GroundItem prayer will";
                LoginScreen.loginMessage3 = "not work on this world.";
                LoginScreen.aString10 = "Warning!";
                LoginScreen.loginIndex = 1;
                LoginScreen.loginIndex2 = 0;
              } else {
                LoginScreen.loginMessage1 = "";
                LoginScreen.loginMessage2 = "Enter your username/email & password.";
                LoginScreen.loginMessage3 = "";
                LoginScreen.loginIndex = 2;
                LoginScreen.loginIndex2 = 0;
              }
            }
          } else {
            short short_1;
            int int_5;
            if (LoginScreen.loginIndex == 1) {
              while (ClanMember.method656()) {
                if (Class3.anInt22 == 84) {
                  LoginScreen.loginMessage1 = "";
                  LoginScreen.loginMessage2 = "Enter your username/email & password.";
                  LoginScreen.loginMessage3 = "";
                  LoginScreen.loginIndex = 2;
                  LoginScreen.loginIndex2 = 0;
                } else if (Class3.anInt22 == 13) {
                  LoginScreen.loginIndex = 0;
                }
              }

              int_5 = LoginScreen.loginWindowX + 180 - 80;
              short_1 = 321;
              if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                  && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                LoginScreen.loginMessage1 = "";
                LoginScreen.loginMessage2 = "Enter your username/email & password.";
                LoginScreen.loginMessage3 = "";
                LoginScreen.loginIndex = 2;
                LoginScreen.loginIndex2 = 0;
              }

              int_5 = LoginScreen.loginWindowX + 180 + 80;
              if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                  && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                LoginScreen.loginIndex = 0;
              }
            } else {
              short short_2;
              if (LoginScreen.loginIndex == 2) {
                short_2 = 231;
                int_5 = short_2 + 30;
                if (int_0 == 1 && int_4 >= int_5 - 15 && int_4 < int_5) {
                  LoginScreen.loginIndex2 = 0;
                }

                int_5 += 15;
                if (int_0 == 1 && int_4 >= int_5 - 15 && int_4 < int_5) {
                  LoginScreen.loginIndex2 = 1;
                }

                int_5 += 15;
                short_2 = 361;
                if (int_0 == 1 && int_4 >= short_2 - 15 && int_4 < short_2) {
                  UrlStreamWorker.method218("Please enter your username.",
                      "If you created your account after November",
                      "2010, this will be the creation email address.");
                  LoginScreen.loginIndex = 5;
                } else {
                  int_6 = LoginScreen.loginWindowX + 180 - 80;
                  short_3 = 321;
                  if (int_0 == 1 && int_3 >= int_6 - 75 && int_3 <= int_6 + 75
                      && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                    LoginScreen.username = LoginScreen.username.trim();
                    if (LoginScreen.username.length() == 0) {
                      UrlStreamWorker.method218("", "Please enter your username/email address.", "");
                    } else if (LoginScreen.password.length() == 0) {
                      UrlStreamWorker.method218("", "Please enter your password.", "");
                    } else {
                      UrlStreamWorker.method218("", "Connecting to server...", "");
                      LoginScreen.anEnum3_1 = LongVariable.preferences.preferences.containsKey(
                          Integer.valueOf(FaceNormal.method553(LoginScreen.username)))
                          ? Enum3.anEnum3_2
                          : Enum3.anEnum3_4;
                      Mouse.setGameState(20);
                    }
                  } else {
                    int_6 = LoginScreen.loginWindowX + 180 + 80;
                    if (int_0 == 1 && int_3 >= int_6 - 75 && int_3 <= int_6 + 75
                        && int_4 >= short_3 - 20 && int_4 <= short_3 + 20) {
                      LoginScreen.loginIndex = 0;
                      LoginScreen.username = "";
                      LoginScreen.password = "";
                      ClassInfo.authCodeForLogin = 0;
                      Preferences.authCode = "";
                      LoginScreen.aBool14 = true;
                    }

                    while (true) {
                      while (ClanMember.method656()) {
                        boolean bool_2 = false;

                        for (int int_2 = 0; int_2
                            < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                            .length(); int_2++) {
                          if (LoginScreen.aChar1
                              == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                              .charAt(int_2)) {
                            bool_2 = true;
                            break;
                          }
                        }

                        if (Class3.anInt22 == 13) {
                          LoginScreen.loginIndex = 0;
                          LoginScreen.username = "";
                          LoginScreen.password = "";
                          ClassInfo.authCodeForLogin = 0;
                          Preferences.authCode = "";
                          LoginScreen.aBool14 = true;
                        } else if (LoginScreen.loginIndex2 == 0) {
                          if (Class3.anInt22 == 85 && LoginScreen.username.length() > 0) {
                            LoginScreen.username = LoginScreen.username.substring(0,
                                LoginScreen.username.length() - 1);
                          }

                          if (Class3.anInt22 == 84 || Class3.anInt22 == 80) {
                            LoginScreen.loginIndex2 = 1;
                          }

                          if (bool_2 && LoginScreen.username.length() < 320) {
                            LoginScreen.username = LoginScreen.username + LoginScreen.aChar1;
                          }
                        } else if (LoginScreen.loginIndex2 == 1) {
                          if (Class3.anInt22 == 85 && LoginScreen.password.length() > 0) {
                            LoginScreen.password = LoginScreen.password.substring(0,
                                LoginScreen.password.length() - 1);
                          }

                          if (Class3.anInt22 == 84 || Class3.anInt22 == 80) {
                            LoginScreen.loginIndex2 = 0;
                          }

                          if (Class3.anInt22 == 84) {
                            LoginScreen.username = LoginScreen.username.trim();
                            if (LoginScreen.username.length() == 0) {
                              UrlStreamWorker.method218("",
                                  "Please enter your username/email address.", "");
                              return;
                            }

                            if (LoginScreen.password.length() == 0) {
                              UrlStreamWorker.method218("", "Please enter your password.", "");
                              return;
                            }

                            UrlStreamWorker.method218("", "Connecting to server...", "");
                            LoginScreen.anEnum3_1 = LongVariable.preferences.preferences.containsKey(
                                Integer.valueOf(FaceNormal.method553(LoginScreen.username)))
                                ? Enum3.anEnum3_2
                                : Enum3.anEnum3_4;
                            Mouse.setGameState(20);
                            return;
                          }

                          if (bool_2 && LoginScreen.password.length() < 20) {
                            LoginScreen.password = LoginScreen.password + LoginScreen.aChar1;
                          }
                        }
                      }

                      return;
                    }
                  }
                }
              } else if (LoginScreen.loginIndex == 3) {
                int_5 = LoginScreen.loginWindowX + 180;
                short_1 = 276;
                if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                    && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                  LoginScreen.loginMessage1 = "";
                  LoginScreen.loginMessage2 = "Enter your username/email & password.";
                  LoginScreen.loginMessage3 = "";
                  LoginScreen.loginIndex = 2;
                  LoginScreen.loginIndex2 = 0;
                }

                int_5 = LoginScreen.loginWindowX + 180;
                short_1 = 326;
                if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                    && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                  UrlStreamWorker.method218("Please enter your username.",
                      "If you created your account after November",
                      "2010, this will be the creation email address.");
                  LoginScreen.loginIndex = 5;
                }
              } else {
                boolean bool_0;
                int int_1;
                if (LoginScreen.loginIndex == 4) {
                  int_5 = LoginScreen.loginWindowX + 180 - 80;
                  short_1 = 321;
                  if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                      && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                    Preferences.authCode.trim();
                    if (Preferences.authCode.length() != 6) {
                      UrlStreamWorker.method218("", "Please enter a 6-digit PIN.", "");
                    } else {
                      ClassInfo.authCodeForLogin = Integer.parseInt(Preferences.authCode);
                      Preferences.authCode = "";
                      LoginScreen.anEnum3_1 = LoginScreen.aBool14 ? Enum3.anEnum3_3 : Enum3.anEnum3_5;
                      UrlStreamWorker.method218("", "Connecting to server...", "");
                      Mouse.setGameState(20);
                    }
                  } else {
                    if (int_0 == 1 && int_3 >= LoginScreen.loginWindowX + 180 - 9
                        && int_3 <= LoginScreen.loginWindowX + 180 + 130 && int_4 >= 263
                        && int_4 <= 296) {
                      LoginScreen.aBool14 = !LoginScreen.aBool14;
                    }

                    if (int_0 == 1 && int_3 >= LoginScreen.loginWindowX + 180 - 34
                        && int_3 <= LoginScreen.loginWindowX + 34 + 180 && int_4 >= 351
                        && int_4 <= 363) {
                      Class13.method167(CombatInfo1.method668("secure", true)
                          + "m=totp-authenticator/disableTOTPRequest", true, false);
                    }

                    int_5 = LoginScreen.loginWindowX + 180 + 80;
                    if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                        && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                      LoginScreen.loginIndex = 0;
                      LoginScreen.username = "";
                      LoginScreen.password = "";
                      ClassInfo.authCodeForLogin = 0;
                      Preferences.authCode = "";
                    }

                    while (ClanMember.method656()) {
                      bool_0 = false;

                      for (int_1 = 0; int_1 < "1234567890".length(); int_1++) {
                        if (LoginScreen.aChar1 == "1234567890".charAt(int_1)) {
                          bool_0 = true;
                          break;
                        }
                      }

                      if (Class3.anInt22 == 13) {
                        LoginScreen.loginIndex = 0;
                        LoginScreen.username = "";
                        LoginScreen.password = "";
                        ClassInfo.authCodeForLogin = 0;
                        Preferences.authCode = "";
                      } else {
                        if (Class3.anInt22 == 85 && Preferences.authCode.length() > 0) {
                          Preferences.authCode = Preferences.authCode.substring(0,
                              Preferences.authCode.length() - 1);
                        }

                        if (Class3.anInt22 == 84) {
                          Preferences.authCode.trim();
                          if (Preferences.authCode.length() != 6) {
                            UrlStreamWorker.method218("", "Please enter a 6-digit PIN.", "");
                            return;
                          }

                          ClassInfo.authCodeForLogin = Integer.parseInt(Preferences.authCode);
                          Preferences.authCode = "";
                          LoginScreen.anEnum3_1 = LoginScreen.aBool14 ? Enum3.anEnum3_3
                              : Enum3.anEnum3_5;
                          UrlStreamWorker.method218("", "Connecting to server...", "");
                          Mouse.setGameState(20);
                          return;
                        }

                        if (bool_0 && Preferences.authCode.length() < 6) {
                          Preferences.authCode = Preferences.authCode + LoginScreen.aChar1;
                        }
                      }
                    }

                  }
                } else if (LoginScreen.loginIndex == 5) {
                  int_5 = LoginScreen.loginWindowX + 180 - 80;
                  short_1 = 321;
                  if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                      && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                    Client.method241();
                  } else {
                    int_5 = LoginScreen.loginWindowX + 180 + 80;
                    if (int_0 == 1 && int_3 >= int_5 - 75 && int_3 <= int_5 + 75
                        && int_4 >= short_1 - 20 && int_4 <= short_1 + 20) {
                      LoginScreen.loginMessage1 = "";
                      LoginScreen.loginMessage2 = "Enter your username/email & password.";
                      LoginScreen.loginMessage3 = "";
                      LoginScreen.loginIndex = 2;
                      LoginScreen.loginIndex2 = 0;
                      LoginScreen.password = "";
                    }

                    while (ClanMember.method656()) {
                      bool_0 = false;

                      for (int_1 = 0; int_1
                          < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                          .length(); int_1++) {
                        if (LoginScreen.aChar1
                            == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| "
                            .charAt(int_1)) {
                          bool_0 = true;
                          break;
                        }
                      }

                      if (Class3.anInt22 == 13) {
                        LoginScreen.loginMessage1 = "";
                        LoginScreen.loginMessage2 = "Enter your username/email & password.";
                        LoginScreen.loginMessage3 = "";
                        LoginScreen.loginIndex = 2;
                        LoginScreen.loginIndex2 = 0;
                        LoginScreen.password = "";
                      } else {
                        if (Class3.anInt22 == 85 && LoginScreen.username.length() > 0) {
                          LoginScreen.username = LoginScreen.username.substring(0,
                              LoginScreen.username.length() - 1);
                        }

                        if (Class3.anInt22 == 84) {
                          Client.method241();
                          return;
                        }

                        if (bool_0 && LoginScreen.username.length() < 320) {
                          LoginScreen.username = LoginScreen.username + LoginScreen.aChar1;
                        }
                      }
                    }

                  }
                } else if (LoginScreen.loginIndex == 6) {
                  while (true) {
                    do {
                      if (!ClanMember.method656()) {
                        short_2 = 321;
                        if (int_0 == 1 && int_4 >= short_2 - 20
                            && int_4 <= short_2 + 20) {
                          LoginScreen.loginMessage1 = "";
                          LoginScreen.loginMessage2 = "Enter your username/email & password.";
                          LoginScreen.loginMessage3 = "";
                          LoginScreen.loginIndex = 2;
                          LoginScreen.loginIndex2 = 0;
                          LoginScreen.password = "";
                          return;
                        }

                        return;
                      }
                    } while (Class3.anInt22 != 84 && Class3.anInt22 != 13);

                    LoginScreen.loginMessage1 = "";
                    LoginScreen.loginMessage2 = "Enter your username/email & password.";
                    LoginScreen.loginMessage3 = "";
                    LoginScreen.loginIndex = 2;
                    LoginScreen.loginIndex2 = 0;
                    LoginScreen.password = "";
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void method546() {
    try {
      LocalInstall.aCacheFile2.method551();

      for (int int_0 = 0; int_0 < LocalInstall.anInt158; int_0++) {
        Isaac.aCacheFileArray1[int_0].method551();
      }

      LocalInstall.aCacheFile3.method551();
      LocalInstall.random.method551();
    } catch (final Exception exception_0) {
    }
  }

  public boolean method539() {
    return (0x1 & mask) != 0;
  }

  boolean method540() {
    return (0x2000000 & mask) != 0;
  }

  boolean method541() {
    return (0x20000000 & mask) != 0;
  }

  boolean method542() {
    return (0x4 & mask) != 0;
  }

  boolean method543() {
    return (0x8 & mask) != 0;
  }

  boolean method544() {
    return (0x2 & mask) != 0;
  }

}
