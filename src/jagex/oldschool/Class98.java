package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.scene.Mobile;
import jagex.oldschool.scene.Npc;

public class Class98 {

  public static final char[] aCharArray3;
  public static final char[] aCharArray4;

  static {
    aCharArray3 = new char[] {
        ' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê',
        'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó',
        'Ô', 'Ö', 'Õ',
        'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'
    };
    aCharArray4 = new char[] {'[', ']', '#'};
  }

  static void method515(final Mobile actor_0, final int int_0) {
    int int_1;
    int int_2;
    int int_3;
    AnimationSequence sequence_0;
    if (actor_0.anInt520 > Client.tick) {
      int_1 = actor_0.anInt520 - Client.tick;
      int_2 = actor_0.anInt499 * 64 + actor_0.anInt522 * 128;
      int_3 = actor_0.anInt523 * 128 + actor_0.anInt499 * 64;
      actor_0.x += (int_2 - actor_0.x) / int_1;
      actor_0.y += (int_3 - actor_0.y) / int_1;
      actor_0.anInt498 = 0;
      actor_0.orientation = actor_0.anInt526;
    } else if (actor_0.anInt521 >= Client.tick) {
      AClass3_Sub1.method726(actor_0);
    } else {
      actor_0.poseAnimation = actor_0.idlePoseAnimation;
      if (actor_0.queueSize == 0) {
        actor_0.anInt498 = 0;
      } else {
        label415:
        {
          if (actor_0.animation != -1 && actor_0.actionAnimationDisable == 0) {
            sequence_0 = PendingSpawn.getAnimationSequence(actor_0.animation);
            if (actor_0.anInt497 > 0 && sequence_0.precedenceAnimating == 0) {
              ++actor_0.anInt498;
              break label415;
            }

            if (actor_0.anInt497 <= 0 && sequence_0.priority == 0) {
              ++actor_0.anInt498;
              break label415;
            }
          }

          int_1 = actor_0.x;
          int_2 = actor_0.y;
          int_3 = actor_0.pathX[actor_0.queueSize - 1] * 128 + actor_0.anInt499 * 64;
          final int int_4 = actor_0.pathY[actor_0.queueSize - 1] * 128 + actor_0.anInt499 * 64;
          if (int_1 < int_3) {
            if (int_2 < int_4) {
              actor_0.orientation = 1280;
            } else if (int_2 > int_4) {
              actor_0.orientation = 1792;
            } else {
              actor_0.orientation = 1536;
            }
          } else if (int_1 > int_3) {
            if (int_2 < int_4) {
              actor_0.orientation = 768;
            } else if (int_2 > int_4) {
              actor_0.orientation = 256;
            } else {
              actor_0.orientation = 512;
            }
          } else if (int_2 < int_4) {
            actor_0.orientation = 1024;
          } else if (int_2 > int_4) {
            actor_0.orientation = 0;
          }

          final byte byte_0 = actor_0.aByteArray20[actor_0.queueSize - 1];
          if (int_3 - int_1 <= 256 && int_3 - int_1 >= -256 && int_4 - int_2 <= 256
              && int_4 - int_2 >= -256) {
            int int_5 = actor_0.orientation - actor_0.angle & 0x7FF;
            if (int_5 > 1024) {
              int_5 -= 2048;
            }

            int int_6 = actor_0.anInt503;
            if (int_5 >= -256 && int_5 <= 256) {
              int_6 = actor_0.anInt502;
            } else if (int_5 >= 256 && int_5 < 768) {
              int_6 = actor_0.anInt505;
            } else if (int_5 >= -768 && int_5 <= -256) {
              int_6 = actor_0.anInt504;
            }

            if (int_6 == -1) {
              int_6 = actor_0.anInt502;
            }

            actor_0.poseAnimation = int_6;
            int int_7 = 4;
            boolean bool_0 = true;
            if (actor_0 instanceof Npc) {
              bool_0 = ((Npc) actor_0).config.isClickable;
            }

            if (bool_0) {
              if (actor_0.angle != actor_0.orientation && actor_0.interacting == -1
                  && actor_0.anInt519 != 0) {
                int_7 = 2;
              }

              if (actor_0.queueSize > 2) {
                int_7 = 6;
              }

              if (actor_0.queueSize > 3) {
                int_7 = 8;
              }

              if (actor_0.anInt498 > 0 && actor_0.queueSize > 1) {
                int_7 = 8;
                --actor_0.anInt498;
              }
            } else {
              if (actor_0.queueSize > 1) {
                int_7 = 6;
              }

              if (actor_0.queueSize > 2) {
                int_7 = 8;
              }

              if (actor_0.anInt498 > 0 && actor_0.queueSize > 1) {
                int_7 = 8;
                --actor_0.anInt498;
              }
            }

            if (byte_0 == 2) {
              int_7 <<= 1;
            }

            if (int_7 >= 8 && actor_0.anInt502 == actor_0.poseAnimation && actor_0.anInt506
                != -1) {
              actor_0.poseAnimation = actor_0.anInt506;
            }

            if (int_1 != int_3 || int_2 != int_4) {
              if (int_1 < int_3) {
                actor_0.x += int_7;
                if (actor_0.x > int_3) {
                  actor_0.x = int_3;
                }
              } else if (int_1 > int_3) {
                actor_0.x -= int_7;
                if (actor_0.x < int_3) {
                  actor_0.x = int_3;
                }
              }

              if (int_2 < int_4) {
                actor_0.y += int_7;
                if (actor_0.y > int_4) {
                  actor_0.y = int_4;
                }
              } else if (int_2 > int_4) {
                actor_0.y -= int_7;
                if (actor_0.y < int_4) {
                  actor_0.y = int_4;
                }
              }
            }

            if (int_3 == actor_0.x && int_4 == actor_0.y) {
              --actor_0.queueSize;
              if (actor_0.anInt497 > 0) {
                --actor_0.anInt497;
              }
            }
          } else {
            actor_0.x = int_3;
            actor_0.y = int_4;
            --actor_0.queueSize;
            if (actor_0.anInt497 > 0) {
              --actor_0.anInt497;
            }
          }
        }
      }
    }

    if (actor_0.x < 128 || actor_0.y < 128 || actor_0.x >= 13184 || actor_0.y >= 13184) {
      actor_0.animation = -1;
      actor_0.graphic = -1;
      actor_0.anInt520 = 0;
      actor_0.anInt521 = 0;
      actor_0.x = actor_0.anInt499 * 64 + actor_0.pathX[0] * 128;
      actor_0.y = actor_0.pathY[0] * 128 + actor_0.anInt499 * 64;
      actor_0.method910();
    }

    if (GrandExchangeOffer.localPlayer == actor_0
        && (actor_0.x < 1536 || actor_0.y < 1536 || actor_0.x >= 11776 || actor_0.y
        >= 11776)) {
      actor_0.animation = -1;
      actor_0.graphic = -1;
      actor_0.anInt520 = 0;
      actor_0.anInt521 = 0;
      actor_0.x = actor_0.pathX[0] * 128 + actor_0.anInt499 * 64;
      actor_0.y = actor_0.pathY[0] * 128 + actor_0.anInt499 * 64;
      actor_0.method910();
    }

    Boundry.method156(actor_0);
    actor_0.aBool63 = false;
    if (actor_0.poseAnimation != -1) {
      sequence_0 = PendingSpawn.getAnimationSequence(actor_0.poseAnimation);
      if (sequence_0 != null && sequence_0.frameIDs != null) {
        ++actor_0.anInt513;
        if (actor_0.poseFrame < sequence_0.frameIDs.length
            && actor_0.anInt513 > sequence_0.frameLenghts[actor_0.poseFrame]) {
          actor_0.anInt513 = 1;
          ++actor_0.poseFrame;
          AClass3.method621(sequence_0, actor_0.poseFrame, actor_0.x, actor_0.y);
        }

        if (actor_0.poseFrame >= sequence_0.frameIDs.length) {
          actor_0.anInt513 = 0;
          actor_0.poseFrame = 0;
          AClass3.method621(sequence_0, actor_0.poseFrame, actor_0.x, actor_0.y);
        }
      } else {
        actor_0.poseAnimation = -1;
      }
    }

    if (actor_0.graphic != -1 && Client.tick >= actor_0.graphicsDelay) {
      if (actor_0.anInt508 < 0) {
        actor_0.anInt508 = 0;
      }

      int_1 = Class11.getSpotAnimationConfig(actor_0.graphic).sequenceId;
      if (int_1 != -1) {
        final AnimationSequence sequence_1 = PendingSpawn.getAnimationSequence(int_1);
        if (sequence_1 != null && sequence_1.frameIDs != null) {
          ++actor_0.anInt516;
          if (actor_0.anInt508 < sequence_1.frameIDs.length
              && actor_0.anInt516 > sequence_1.frameLenghts[actor_0.anInt508]) {
            actor_0.anInt516 = 1;
            ++actor_0.anInt508;
            AClass3.method621(sequence_1, actor_0.anInt508, actor_0.x, actor_0.y);
          }

          if (actor_0.anInt508 >= sequence_1.frameIDs.length
              && (actor_0.anInt508 < 0 || actor_0.anInt508 >= sequence_1.frameIDs.length)) {
            actor_0.graphic = -1;
          }
        } else {
          actor_0.graphic = -1;
        }
      } else {
        actor_0.graphic = -1;
      }
    }

    if (actor_0.animation != -1 && actor_0.actionAnimationDisable <= 1) {
      sequence_0 = PendingSpawn.getAnimationSequence(actor_0.animation);
      if (sequence_0.precedenceAnimating == 1 && actor_0.anInt497 > 0
          && actor_0.anInt520 <= Client.tick && actor_0.anInt521 < Client.tick) {
        actor_0.actionAnimationDisable = 1;
        return;
      }
    }

    if (actor_0.animation != -1 && actor_0.actionAnimationDisable == 0) {
      sequence_0 = PendingSpawn.getAnimationSequence(actor_0.animation);
      if (sequence_0 != null && sequence_0.frameIDs != null) {
        ++actor_0.anInt514;
        if (actor_0.actionFrame < sequence_0.frameIDs.length
            && actor_0.anInt514 > sequence_0.frameLenghts[actor_0.actionFrame]) {
          actor_0.anInt514 = 1;
          ++actor_0.actionFrame;
          AClass3.method621(sequence_0, actor_0.actionFrame, actor_0.x, actor_0.y);
        }

        if (actor_0.actionFrame >= sequence_0.frameIDs.length) {
          actor_0.actionFrame -= sequence_0.frameStep;
          ++actor_0.anInt515;
          if (actor_0.anInt515 >= sequence_0.maxLoops) {
            actor_0.animation = -1;
          } else if (actor_0.actionFrame >= 0 && actor_0.actionFrame
              < sequence_0.frameIDs.length) {
            AClass3.method621(sequence_0, actor_0.actionFrame, actor_0.x, actor_0.y);
          } else {
            actor_0.animation = -1;
          }
        }

        actor_0.aBool63 = sequence_0.stretches;
      } else {
        actor_0.animation = -1;
      }
    }

    if (actor_0.actionAnimationDisable > 0) {
      --actor_0.actionAnimationDisable;
    }
  }

}
