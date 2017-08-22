package jagex.oldschool;

import jagex.oldschool.awt.Stub;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.script.Class34;
import jagex.oldschool.util.Timestamp;
import java.math.BigInteger;

public class Class51 {

  static final BigInteger aBigInteger1;
  static final BigInteger aBigInteger2;

  static {
    aBigInteger1 = new BigInteger(
        "80782894952180643741752986186714059433953886149239752893425047584684715842049");
    aBigInteger2 = new BigInteger(
        "7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
  }

  static void drawStatusBox(final String string_0, final boolean bool_0) {
    final byte byte_0 = 4;
    final int int_0 = byte_0 + 6;
    final int int_1 = byte_0 + 6;
    final int int_2 = Class12.font_p12full.method997(string_0, 250);
    final int int_3 = Class12.font_p12full.method994(string_0, 250) * 13;
    Rasterizer2d
        .fillRectangle(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0, byte_0 + int_3 + byte_0,
            0);
    Rasterizer2d.drawRectangle(int_0 - byte_0, int_1 - byte_0, byte_0 + int_2 + byte_0,
        int_3 + byte_0 + byte_0,
        16777215);
    Class12.font_p12full.method995(string_0, int_0, int_1, int_2, int_3, 16777215, -1, 1, 1, 0);
    Class26.method230(int_0 - byte_0, int_1 - byte_0, int_2 + byte_0 + byte_0,
        int_3 + byte_0 + byte_0);
    if (bool_0) {
      FileCache.aBufferProvider1.draw(0, 0);
    } else {
      final int int_4 = int_0;
      final int int_5 = int_1;
      final int int_6 = int_2;
      final int int_7 = int_3;

      for (int int_8 = 0; int_8 < Client.anInt596; int_8++) {
        if (Client.widgetPositionX[int_8] + Client.widgetBoundsWidth[int_8] > int_4
            && Client.widgetPositionX[int_8] < int_6 + int_4
            && Client.widgetBoundsHeight[int_8] + Client.widgetPositionY[int_8] > int_5
            && Client.widgetPositionY[int_8] < int_7 + int_5) {
          Client.aBoolArray10[int_8] = true;
        }
      }
    }

  }

  static void method327() {
    Client.outbound.putEncipheredByte(28);
    Client.outbound.putByte(Class45.method287());
    Client.outbound.putShort(Stub.canvasWidth);
    Client.outbound.putShort(Class34.canvasHeight);
  }

  static void method328(final boolean bool_0) {
    Client.anInt682 = 0;
    Client.pendingNpcFlagsCount = 0;
    Client.secretPacketBuffer2.beginBitAccess();
    int int_0 = Client.secretPacketBuffer2.getBits(8);
    int int_1;
    if (int_0 < Client.anInt636) {
      for (int_1 = int_0; int_1 < Client.anInt636; int_1++) {
        Client.anIntArray157[++Client.anInt682 - 1] = Client.npcIndices[int_1];
      }
    }

    if (int_0 > Client.anInt636) {
      throw new RuntimeException("");
    }
    Client.anInt636 = 0;

    int int_3;
    int int_5;
    int int_6;
    int int_7;
    int int_9;
    for (int_1 = 0; int_1 < int_0; int_1++) {
      final int int_2 = Client.npcIndices[int_1];
      final Npc npc_0 = Client.cachedNPCs[int_2];
      int_3 = Client.secretPacketBuffer2.getBits(1);
      if (int_3 == 0) {
        Client.npcIndices[++Client.anInt636 - 1] = int_2;
        npc_0.anInt517 = Client.tick;
      } else {
        int_5 = Client.secretPacketBuffer2.getBits(2);
        if (int_5 == 0) {
          Client.npcIndices[++Client.anInt636 - 1] = int_2;
          npc_0.anInt517 = Client.tick;
          Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
        } else if (int_5 == 1) {
          Client.npcIndices[++Client.anInt636 - 1] = int_2;
          npc_0.anInt517 = Client.tick;
          int_9 = Client.secretPacketBuffer2.getBits(3);
          npc_0.method1023(int_9, (byte) 1);
          int_6 = Client.secretPacketBuffer2.getBits(1);
          if (int_6 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
          }
        } else if (int_5 == 2) {
          Client.npcIndices[++Client.anInt636 - 1] = int_2;
          npc_0.anInt517 = Client.tick;
          int_9 = Client.secretPacketBuffer2.getBits(3);
          npc_0.method1023(int_9, (byte) 2);
          int_6 = Client.secretPacketBuffer2.getBits(3);
          npc_0.method1023(int_6, (byte) 2);
          int_7 = Client.secretPacketBuffer2.getBits(1);
          if (int_7 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_2;
          }
        } else if (int_5 == 3) {
          Client.anIntArray157[++Client.anInt682 - 1] = int_2;
        }
      }
    }

    Npc npc_1;
    int int_4;
    while (Client.secretPacketBuffer2.availableBits(Client.packetLength) >= 27) {
      int_0 = Client.secretPacketBuffer2.getBits(15);
      if (int_0 == 32767) {
        break;
      }

      boolean bool_1 = false;
      if (Client.cachedNPCs[int_0] == null) {
        Client.cachedNPCs[int_0] = new Npc();
        bool_1 = true;
      }

      npc_1 = Client.cachedNPCs[int_0];
      Client.npcIndices[++Client.anInt636 - 1] = int_0;
      npc_1.anInt517 = Client.tick;
      int_4 = Client.anIntArray163[Client.secretPacketBuffer2.getBits(3)];
      if (bool_1) {
        npc_1.orientation = npc_1.angle = int_4;
      }

      int_3 = Client.secretPacketBuffer2.getBits(1);
      if (bool_0) {
        int_5 = Client.secretPacketBuffer2.getBits(8);
        if (int_5 > 127) {
          int_5 -= 256;
        }
      } else {
        int_5 = Client.secretPacketBuffer2.getBits(5);
        if (int_5 > 15) {
          int_5 -= 32;
        }
      }

      if (bool_0) {
        int_9 = Client.secretPacketBuffer2.getBits(8);
        if (int_9 > 127) {
          int_9 -= 256;
        }
      } else {
        int_9 = Client.secretPacketBuffer2.getBits(5);
        if (int_9 > 15) {
          int_9 -= 32;
        }
      }

      npc_1.config = Timestamp.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
      int_6 = Client.secretPacketBuffer2.getBits(1);
      if (int_6 == 1) {
        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = int_0;
      }

      npc_1.anInt499 = npc_1.config.anInt477;
      npc_1.anInt519 = npc_1.config.anInt490;
      if (npc_1.anInt519 == 0) {
        npc_1.angle = 0;
      }

      npc_1.anInt502 = npc_1.config.anInt479;
      npc_1.anInt503 = npc_1.config.anInt484;
      npc_1.anInt504 = npc_1.config.anInt485;
      npc_1.anInt505 = npc_1.config.anInt487;
      npc_1.idlePoseAnimation = npc_1.config.anInt478;
      npc_1.anInt500 = npc_1.config.anInt480;
      npc_1.anInt501 = npc_1.config.anInt481;
      npc_1.method1024(GrandExchangeOffer.localPlayer.pathX[0] + int_9,
          GrandExchangeOffer.localPlayer.pathY[0] + int_5, int_3 == 1);
    }

    Client.secretPacketBuffer2.endBitAccess();

    for (int_0 = 0; int_0 < Client.pendingNpcFlagsCount; int_0++) {
      int_1 = Client.pendingNpcFlagsIndices[int_0];
      npc_1 = Client.cachedNPCs[int_1];
      int_4 = Client.secretPacketBuffer2.getUnsignedByte();
      if ((int_4 & 0x8) != 0) {
        npc_1.interacting = Client.secretPacketBuffer2.getUnsignedLeShortAdd();
        if (npc_1.interacting == 65535) {
          npc_1.interacting = -1;
        }
      }

      if ((int_4 & 0x10) != 0) {
        int_3 = Client.secretPacketBuffer2.getUnsignedByteSub();
        int int_8;
        int int_10;
        if (int_3 > 0) {
          for (int_5 = 0; int_5 < int_3; int_5++) {
            int_6 = -1;
            int_7 = -1;
            int_8 = -1;
            int_9 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            if (int_9 == 32767) {
              int_9 = Client.secretPacketBuffer2.getUnsignedSmartShort();
              int_7 = Client.secretPacketBuffer2.getUnsignedSmartShort();
              int_6 = Client.secretPacketBuffer2.getUnsignedSmartShort();
              int_8 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            } else if (int_9 != 32766) {
              int_7 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            } else {
              int_9 = -1;
            }

            int_10 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            npc_1.method911(int_9, int_7, int_6, int_8, Client.tick, int_10);
          }
        }

        int_5 = Client.secretPacketBuffer2.getUnsignedByteAdd();
        if (int_5 > 0) {
          for (int_9 = 0; int_9 < int_5; int_9++) {
            int_6 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            int_7 = Client.secretPacketBuffer2.getUnsignedSmartShort();
            if (int_7 != 32767) {
              int_8 = Client.secretPacketBuffer2.getUnsignedSmartShort();
              int_10 = Client.secretPacketBuffer2.getUnsignedByteNegate();
              final int int_11 = int_7 > 0 ? Client.secretPacketBuffer2.getUnsignedByte() : int_10;
              npc_1.method913(int_6, Client.tick, int_7, int_8, int_10, int_11);
            } else {
              npc_1.method912(int_6);
            }
          }
        }
      }

      if ((int_4 & 0x2) != 0) {
        npc_1.config = Timestamp.getNpcDefinition(Client.secretPacketBuffer2.getUnsignedShort());
        npc_1.anInt499 = npc_1.config.anInt477;
        npc_1.anInt519 = npc_1.config.anInt490;
        npc_1.anInt502 = npc_1.config.anInt479;
        npc_1.anInt503 = npc_1.config.anInt484;
        npc_1.anInt504 = npc_1.config.anInt485;
        npc_1.anInt505 = npc_1.config.anInt487;
        npc_1.idlePoseAnimation = npc_1.config.anInt478;
        npc_1.anInt500 = npc_1.config.anInt480;
        npc_1.anInt501 = npc_1.config.anInt481;
      }

      if ((int_4 & 0x1) != 0) {
        npc_1.graphic = Client.secretPacketBuffer2.getUnsignedShortAdd();
        int_3 = Client.secretPacketBuffer2.getLeInt();
        npc_1.anInt512 = int_3 >> 16;
        npc_1.graphicsDelay = (int_3 & 0xFFFF) + Client.tick;
        npc_1.anInt508 = 0;
        npc_1.anInt516 = 0;
        if (npc_1.graphicsDelay > Client.tick) {
          npc_1.anInt508 = -1;
        }

        if (npc_1.graphic == 65535) {
          npc_1.graphic = -1;
        }
      }

      if ((int_4 & 0x4) != 0) {
        int_3 = Client.secretPacketBuffer2.getUnsignedLeShortAdd();
        int_5 = Client.secretPacketBuffer2.getUnsignedLeShortAdd();
        int_9 = npc_1.x - (int_3 - Boundry.baseX - Boundry.baseX) * 64;
        int_6 = npc_1.y - (int_5 - WorldMapData_Sub1.baseY - WorldMapData_Sub1.baseY) * 64;
        if (int_9 != 0 || int_6 != 0) {
          npc_1.anInt496 = (int) (Math.atan2(int_9, int_6) * 325.949D) & 0x7FF;
        }
      }

      if ((int_4 & 0x20) != 0) {
        int_3 = Client.secretPacketBuffer2.getUnsignedLeShort();
        if (int_3 == 65535) {
          int_3 = -1;
        }

        int_5 = Client.secretPacketBuffer2.getUnsignedByteSub();
        if (int_3 == npc_1.animation && int_3 != -1) {
          int_9 = PendingSpawn.getAnimationSequence(int_3).replyMode;
          if (int_9 == 1) {
            npc_1.actionFrame = 0;
            npc_1.anInt514 = 0;
            npc_1.actionAnimationDisable = int_5;
            npc_1.anInt515 = 0;
          }

          if (int_9 == 2) {
            npc_1.anInt515 = 0;
          }
        } else if (int_3 == -1 || npc_1.animation == -1
            || PendingSpawn.getAnimationSequence(int_3).forcedPriority >= PendingSpawn
            .getAnimationSequence(npc_1.animation).forcedPriority) {
          npc_1.animation = int_3;
          npc_1.actionFrame = 0;
          npc_1.anInt514 = 0;
          npc_1.actionAnimationDisable = int_5;
          npc_1.anInt515 = 0;
          npc_1.anInt497 = npc_1.queueSize;
        }
      }

      if ((int_4 & 0x40) != 0) {
        npc_1.overhead = Client.secretPacketBuffer2.getString();
        npc_1.anInt509 = 100;
      }
    }

    for (int_0 = 0; int_0 < Client.anInt682; int_0++) {
      int_1 = Client.anIntArray157[int_0];
      if (Client.cachedNPCs[int_1].anInt517 != Client.tick) {
        Client.cachedNPCs[int_1].config = null;
        Client.cachedNPCs[int_1] = null;
      }
    }

    if (Client.packetLength != Client.secretPacketBuffer2.offset) {
      throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
    }
    for (int_0 = 0; int_0 < Client.anInt636; int_0++) {
      if (Client.cachedNPCs[Client.npcIndices[int_0]] == null) {
        throw new RuntimeException(int_0 + "," + Client.anInt636);
      }
    }

  }

}
