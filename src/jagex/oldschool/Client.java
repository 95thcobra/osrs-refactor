package jagex.oldschool;

import jagex.oldschool.animation.Animation;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.animation.FrameBase;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.asset.Package;
import jagex.oldschool.asset.RemoteAssetRequestor;
import jagex.oldschool.asset.RemoteRequest;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.audio.SoundEffect;
import jagex.oldschool.awt.CanvasWrapper;
import jagex.oldschool.awt.Parameter;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.collections.Deque;
import jagex.oldschool.collections.HashTable;
import jagex.oldschool.collections.IntegerNode;
import jagex.oldschool.collections.IterableQueue;
import jagex.oldschool.collections.Node;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.config.PlayerVariable;
import jagex.oldschool.config.SpotAnimationConfig;
import jagex.oldschool.device.Keyboard;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.AbstractFont;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.FaceNormal;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.graphics.IndexedSprite;
import jagex.oldschool.graphics.Materials;
import jagex.oldschool.graphics.Rasterizer2d;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.AbstractByteBuffer;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.BufferedFile;
import jagex.oldschool.io.FileCache;
import jagex.oldschool.io.FileOnDisk;
import jagex.oldschool.io.GameBuffer;
import jagex.oldschool.io.SocketStream;
import jagex.oldschool.map.MapAsset;
import jagex.oldschool.scene.Mobile;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.scene.Position;
import jagex.oldschool.scene.Projectile;
import jagex.oldschool.scene.Renderable;
import jagex.oldschool.script.Class34;
import jagex.oldschool.script.IntegerVariable;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptCall;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.script.ScriptState;
import jagex.oldschool.security.Isaac;
import jagex.oldschool.task.Task;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.Inventory;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.util.BzipDecompressor.State;
import jagex.oldschool.util.MilliRegulator;
import jagex.oldschool.util.Packets;
import jagex.oldschool.util.Regulator;
import jagex.oldschool.util.Skills;
import jagex.oldschool.util.Time;
import jagex.oldschool.util.Timestamp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import netscape.javascript.JSObject;

public final class Client extends Stub {

  static final AClass2_Sub1 anAClass2_Sub1_1;
  static final int[] anIntArray150;
  static final int[] playerMenuTypes;
  public static boolean isMembers;
  public static String host;
  public static int variableCount;
  static boolean aBool77;
  static Task socket;
  public static int anInt593;
  public static int socketType;
  public static int widgetRoot;
  public static InterfaceComponent aWidget9;
  public static int tick;
  public static int loginState;
  static int menuOptionCount;
  public static int state;
  public static int anInt594;
  public static int world;
  public static int anInt595;
  public static int anInt596;
  static int anInt597;
  static long aLong25;
  static int anInt598;
  static int anInt599;
  static int js5State;
  public static int flags;
  public static int[] menuTypes;
  static boolean[] aBoolArray8;
  static int packetType;
  static boolean[] aBoolArray9;
  public static boolean[] aBoolArray10;
  static boolean[] aBoolArray11;
  static boolean isMenuOpen;
  static int anInt600;
  public static String[] menuTargets;
  static boolean aBool78;
  static int secondLastFrameId;
  static boolean panic;
  static int packetLength;
  static int anInt601;
  static GameBuffer secretPacketBuffer2;
  static int menuX;
  static boolean lowMemory;
  public static String[] menuOptions;
  static int thridLastFrameId;
  static boolean isResized;
  public static int languageId;
  static int anInt602;
  public static boolean aBool79;
  public static int anInt603;
  public static boolean aBool80;
  public static boolean aBool81;
  static boolean aBool82;
  public static int anInt604;
  public static int[] menuActionParams0;
  static CollisionData[] collisionMaps;
  public static int anInt605;
  static long aLong26;
  public static int anInt606;
  public static GameBuffer outbound;
  static int anInt607;
  public static int[] menuActionParams1;
  static int anInt608;
  public static int[] menuIdentifiers;
  static int anInt609;
  public static InterfaceComponent aWidget10;
  static boolean aBool83;
  static int anInt610;
  static int gameDrawingMode;
  public static int[] widgetPositionX;
  static boolean displayFps;
  public static int[] widgetBoundsWidth;
  public static HashTable componentTable;
  public static int anInt611;
  public static int anInt612;
  public static int[] boostedSkillLevels;
  public static int anInt613;
  static int itemSelectionState;
  public static int anInt614;
  public static int anInt615;
  public static int[] realSkillLevels;
  static boolean spellSelected;
  public static int[] skillExperiences;
  public static int anInt616;
  public static int[] widgetBoundsHeight;
  static int anInt617;
  public static int anInt618;
  public static int[] widgetPositionY;
  static int anInt619;
  public static int anInt620;
  public static int anInt621;
  static HashTable widgetFlags;
  static int anInt622;
  public static int hintArrowX;
  public static int anInt623;
  static int loadingStage;
  static String sessionToken;
  static int cursorState;
  public static int hintArrowY;
  static String aString33;
  static String aString34;
  static int anInt624;
  static int hintArrowType;
  static String aString35;
  static int anInt625;
  static boolean aBool84;
  public static InterfaceComponent aWidget11;
  static int anInt626;
  static int anInt627;
  static int anInt628;
  static Enum2 anEnum2_5;
  static int anInt629;
  static int anInt630;
  public static int energy;
  static int anInt631;
  static Enum2 anEnum2_6;
  public static int weight;
  static int count;
  static int[] anIntArray141;
  static int[] anIntArray142;
  static int anInt632;
  public static int destinationX;
  public static Deque aDeque7;
  public static IndexedSprite[] anIndexedSpriteArray9;
  public static int destinationY;
  static int anInt633;
  public static int anInt634;
  public static boolean aBool85;
  public static Package anIndexData5;
  static int lastFrameId;
  static int anInt635;
  static byte[] aByteArray28;
  public static Npc[] cachedNPCs;
  public static int anInt636;
  public static int[] npcIndices;
  static HashMap aHashMap9;
  static int pendingNpcFlagsCount;
  static int[] pendingNpcFlagsIndices;
  static int anInt637;
  public static int anInt638;
  static boolean isDynamicRegion;
  public static PlayerIdentity aPlayerComposition1;
  public static int cycleCntr;
  static int anInt639;
  public static int anInt640;
  static GameBuffer aPacketBuffer1;
  static int[] interfaceItemTriggers;
  static InterfaceComponent aWidget12;
  static int anInt641;
  public static Player[] cachedPlayers;
  public static int localInteractingIndex;
  public static int rights;
  static int[] anIntArray143;
  static int anInt642;
  static int anInt643;
  public static int anInt644;
  static int[] anIntArray144;
  static int anInt645;
  static boolean aBool86;
  public static int mapAngle;
  public static int anInt646;
  public static int ignoreCount;
  public static int anInt647;
  public static Ignore[] ignores;
  public static int anInt648;
  public static int[] anIntArray145;
  static int anInt649;
  static int anInt650;
  public static int[] anIntArray146;
  static int anInt651;
  public static int[] anIntArray147;
  static int anInt652;
  public static SoundEffect[] audioEffects;
  static long[] aLongArray4;
  static long aLong27;
  public static int[] anIntArray148;
  public static InterfaceComponent aWidget13;
  public static int anInt653;
  static int[][][] anIntArrayArrayArray2;
  static int anInt654;
  static int anInt655;
  public static int anInt656;
  static int anInt657;
  static int anInt658;
  public static boolean aBool87;
  public static boolean aBool88;
  static boolean[] aBoolArray12;
  static int anInt659;
  public static String clanChatOwner;
  static GrandExchangeOffer[] grandExchangeOffers;
  static int anInt660;
  public static String clanChatName;
  public static int anInt661;
  public static int[] anIntArray149;
  static int anInt662;
  static Deque projectiles;
  public static Deque[][][] groundItemDeque;
  public static int anInt663;
  static int anInt664;
  static Deque graphicsObjectDeque;
  public static int[] anIntArray151;
  static Deque pendingSpawns;
  static int[][] anIntArrayArray21;
  static int anInt665;
  static int anInt666;
  static int anInt667;
  static int anInt668;
  public static DirectSprite[] aSpritePixelsArray4;
  static int anInt669;
  static boolean aBool89;
  public static int viewportHeight;
  public static int viewportWidth;
  static int anInt670;
  static int anInt671;
  public static short aShort3;
  public static short aShort4;
  static int anInt672;
  static int anInt673;
  static int anInt674;
  public static short aShort5;
  static int anInt675;
  public static short aShort6;
  static int anInt676;
  public static short aShort7;
  public static short aShort8;
  static int anInt677;
  public static short aShort9;
  public static short aShort10;
  public static int anInt678;
  static int scale;
  static int anInt679;
  static int anInt680;
  public static int friendCount;
  public static Friend[] friends;
  static int anInt681;
  static int anInt682;
  static int anInt683;
  static int[] anIntArray152;
  static int[] anIntArray153;
  static int[] anIntArray154;
  static int anInt684;
  static int[] anIntArray155;
  static int[] anIntArray156;
  static int[] anIntArray157;
  static int anInt685;
  static int[] anIntArray158;
  static int[] anIntArray159;
  static String[] playerOptions;
  static int anInt686;
  public static int anInt687;
  static int[] anIntArray160;
  static boolean[] playerOptionsPriorities;
  static String[] aStringArray6;
  static int anInt688;
  static int screenY;
  static int screenX;
  static int[] anIntArray161;
  static int[] anIntArray162;
  static int[] anIntArray163;
  static int[] anIntArray164;
  static int[] anIntArray165;
  static Deque aDeque8;
  static int[] anIntArray166;
  static Deque aDeque9;
  static int anInt689;
  static int chatCycle;
  static Class75 aClass75_1;
  static boolean aBool90;
  static int[] anIntArray167;
  public static boolean aBool91;
  public static boolean aBool92;
  static String aString36;
  static DirectSprite[] crosses;

  static {
    aBool77 = true;
    world = 1;
    flags = 0;
    socketType = 0;
    isMembers = false;
    lowMemory = false;
    languageId = 0;
    state = 0;
    aBool82 = true;
    tick = 0;
    aLong26 = -1L;
    anInt607 = -1;
    anInt608 = -1;
    anInt609 = -1;
    aBool83 = true;
    displayFps = false;
    anInt593 = 0;
    anInt614 = 0;
    anInt616 = 0;
    anInt620 = 0;
    hintArrowX = 0;
    hintArrowY = 0;
    hintArrowType = 0;
    anInt625 = 0;
    anInt626 = 0;
    anEnum2_5 = Enum2.anEnum2_4;
    anEnum2_6 = Enum2.anEnum2_4;
    loadingStage = 0;
    js5State = 0;
    anInt599 = 0;
    anInt602 = 0;
    loginState = 0;
    anInt603 = 0;
    anInt594 = 0;
    anInt635 = 0;
    aByteArray28 = null;
    cachedNPCs = new Npc[32768];
    anInt636 = 0;
    npcIndices = new int[32768];
    pendingNpcFlagsCount = 0;
    pendingNpcFlagsIndices = new int[250];
    outbound = new GameBuffer(5000);
    aPacketBuffer1 = new GameBuffer(5000);
    secretPacketBuffer2 = new GameBuffer(15000);
    packetLength = 0;
    packetType = 0;
    anInt633 = 0;
    count = 0;
    lastFrameId = 0;
    secondLastFrameId = 0;
    thridLastFrameId = 0;
    anInt595 = 0;
    panic = false;
    aHashMap9 = new HashMap();
    anInt615 = 0;
    anInt618 = 1;
    anInt621 = 0;
    anInt623 = 1;
    anInt612 = 0;
    collisionMaps = new CollisionData[4];
    isDynamicRegion = false;
    anIntArrayArrayArray2 = new int[4][13][13];
    anIntArray150 = new int[] {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    anInt610 = 0;
    anInt651 = 2301979;
    anInt662 = 5063219;
    anInt666 = 3353893;
    anInt665 = 7759444;
    aBool89 = false;
    anInt670 = 0;
    anInt653 = 128;
    mapAngle = 0;
    anInt672 = 0;
    anInt674 = 0;
    anInt675 = 0;
    anInt676 = 0;
    anInt678 = 50;
    anInt642 = 0;
    aBool86 = false;
    anInt680 = 0;
    anInt681 = 0;
    anInt683 = 50;
    anIntArray152 = new int[anInt683];
    anIntArray154 = new int[anInt683];
    anIntArray155 = new int[anInt683];
    anIntArray156 = new int[anInt683];
    anIntArray158 = new int[anInt683];
    anIntArray159 = new int[anInt683];
    anIntArray160 = new int[anInt683];
    aStringArray6 = new String[anInt683];
    anIntArrayArray21 = new int[104][104];
    anInt643 = 0;
    screenY = -1;
    screenX = -1;
    anInt619 = 0;
    anInt622 = 0;
    anInt624 = 0;
    cursorState = 0;
    anInt654 = 0;
    anInt658 = 0;
    anInt632 = 0;
    anInt630 = 0;
    anInt631 = 0;
    anInt689 = 0;
    aBool84 = false;
    anInt627 = 0;
    anInt655 = 0;
    cachedPlayers = new Player[2048];
    localInteractingIndex = -1;
    anInt663 = 0;
    anInt682 = 0;
    anIntArray157 = new int[1000];
    playerMenuTypes = new int[] {44, 45, 46, 47, 48, 49, 50, 51};
    playerOptions = new String[8];
    playerOptionsPriorities = new boolean[8];
    anIntArray163 = new int[] {768, 1024, 1280, 512, 1536, 256, 0, 1792};
    anInt652 = -1;
    groundItemDeque = new Deque[4][104][104];
    pendingSpawns = new Deque();
    projectiles = new Deque();
    graphicsObjectDeque = new Deque();
    boostedSkillLevels = new int[25];
    realSkillLevels = new int[25];
    skillExperiences = new int[25];
    anInt598 = 0;
    isMenuOpen = false;
    menuOptionCount = 0;
    menuActionParams0 = new int[500];
    menuActionParams1 = new int[500];
    menuTypes = new int[500];
    menuIdentifiers = new int[500];
    menuOptions = new String[500];
    menuTargets = new String[500];
    aBoolArray11 = new boolean[500];
    aBool92 = false;
    aBool91 = false;
    anInt600 = -1;
    anInt601 = -1;
    anInt649 = 0;
    anInt650 = 50;
    itemSelectionState = 0;
    aString33 = null;
    spellSelected = false;
    anInt685 = -1;
    anInt684 = -1;
    aString34 = null;
    aString35 = null;
    widgetRoot = -1;
    componentTable = new HashTable(8);
    anInt669 = 0;
    anInt671 = 0;
    aWidget13 = null;
    energy = 0;
    weight = 0;
    rights = 0;
    anInt679 = -1;
    aBool88 = false;
    aBool80 = false;
    aBool90 = false;
    aWidget11 = null;
    aWidget9 = null;
    aWidget10 = null;
    anInt604 = 0;
    anInt605 = 0;
    aWidget12 = null;
    aBool79 = false;
    anInt606 = -1;
    anInt611 = -1;
    aBool78 = false;
    anInt628 = -1;
    anInt629 = -1;
    aBool85 = false;
    cycleCntr = 1;
    anIntArray143 = new int[32];
    anInt637 = 0;
    interfaceItemTriggers = new int[32];
    anInt641 = 0;
    anIntArray144 = new int[32];
    anInt645 = 0;
    chatCycle = 0;
    anInt646 = 0;
    anInt659 = 0;
    anInt664 = 0;
    anInt688 = 0;
    anInt639 = 0;
    anInt617 = 0;
    aDeque7 = new Deque();
    aDeque8 = new Deque();
    aDeque9 = new Deque();
    widgetFlags = new HashTable(512);
    anInt596 = 0;
    anInt597 = -2;
    aBoolArray8 = new boolean[100];
    aBoolArray10 = new boolean[100];
    aBoolArray9 = new boolean[100];
    widgetPositionX = new int[100];
    widgetPositionY = new int[100];
    widgetBoundsWidth = new int[100];
    widgetBoundsHeight = new int[100];
    gameDrawingMode = 0;
    aLong25 = 0L;
    isResized = true;
    anIntArray167 = new int[] {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    anInt673 = 0;
    anInt677 = 0;
    aString36 = "";
    aLongArray4 = new long[100];
    anInt657 = 0;
    anInt686 = 0;
    anIntArray166 = new int[128];
    anIntArray165 = new int[128];
    aLong27 = -1L;
    clanChatOwner = null;
    clanChatName = null;
    anInt660 = -1;
    anInt661 = 0;
    anIntArray149 = new int[1000];
    anIntArray151 = new int[1000];
    aSpritePixelsArray4 = new DirectSprite[1000];
    destinationX = 0;
    destinationY = 0;
    anInt644 = 0;
    anInt656 = 255;
    anInt613 = -1;
    aBool81 = false;
    anInt647 = 127;
    anInt634 = 127;
    anInt648 = 0;
    anIntArray145 = new int[50];
    anIntArray146 = new int[50];
    anIntArray147 = new int[50];
    anIntArray148 = new int[50];
    audioEffects = new SoundEffect[50];
    aBool87 = false;
    aBoolArray12 = new boolean[5];
    anIntArray161 = new int[5];
    anIntArray153 = new int[5];
    anIntArray162 = new int[5];
    anIntArray164 = new int[5];
    aShort4 = 256;
    aShort3 = 205;
    aShort9 = 256;
    aShort8 = 320;
    aShort10 = 1;
    aShort7 = 32767;
    aShort5 = 1;
    aShort6 = 32767;
    anInt667 = 0;
    anInt668 = 0;
    viewportHeight = 0;
    viewportWidth = 0;
    scale = 0;
    friendCount = 0;
    anInt687 = 0;
    friends = new Friend[400];
    aClass75_1 = new Class75();
    ignoreCount = 0;
    ignores = new Ignore[400];
    aPlayerComposition1 = new PlayerIdentity();
    anInt638 = -1;
    anInt640 = 1;
    grandExchangeOffers = new GrandExchangeOffer[8];
    anAClass2_Sub1_1 = new AClass2_Sub1();
    anIntArray141 = new int[50];
    anIntArray142 = new int[50];
  }

  static void gameDraw(final InterfaceComponent[] widgets_0, final int int_0, final int int_1,
      final int int_2,
      final int int_3, final int int_4, final int int_5, final int int_6, final int int_7) {
    Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
    Rasterizer3d.init();

    for (int int_8 = 0; int_8 < widgets_0.length; int_8++) {
      final InterfaceComponent widget_0 = widgets_0[int_8];
      if (widget_0 != null
          && (widget_0.parentId == int_0 || int_0 == -1412584499 && widget_0
          == aWidget9)) {
        int int_9;
        if (int_7 == -1) {
          widgetPositionX[anInt596] = widget_0.relativeX + int_5;
          widgetPositionY[anInt596] = int_6 + widget_0.relativeY;
          widgetBoundsWidth[anInt596] = widget_0.width;
          widgetBoundsHeight[anInt596] = widget_0.height;
          int_9 = ++anInt596 - 1;
        } else {
          int_9 = int_7;
        }

        widget_0.boundsIndex = int_9;
        widget_0.loopCycle = tick;
        if (!widget_0.hasScript || !Renderable.method711(widget_0)) {
          if (widget_0.contentType > 0) {
            PrimitiveType.method631(widget_0);
          }

          int int_10 = widget_0.relativeX + int_5;
          int int_11 = int_6 + widget_0.relativeY;
          int int_12 = widget_0.opacity;
          int int_13;
          int int_14;
          if (widget_0 == aWidget9) {
            if (int_0 != -1412584499 && !widget_0.aBool33) {
              Class53.aWidgetArray1 = widgets_0;
              Class23.anInt74 = int_5;
              Boundry.anInt48 = int_6;
              continue;
            }

            if (aBool85 && aBool79) {
              int_13 = Mouse.anInt249;
              int_14 = Mouse.anInt251;
              int_13 -= anInt604;
              int_14 -= anInt605;
              if (int_13 < anInt606) {
                int_13 = anInt606;
              }

              if (int_13 + widget_0.width > anInt606 + aWidget10.width) {
                int_13 = anInt606 + aWidget10.width - widget_0.width;
              }

              if (int_14 < anInt611) {
                int_14 = anInt611;
              }

              if (int_14 + widget_0.height > anInt611 + aWidget10.height) {
                int_14 = anInt611 + aWidget10.height - widget_0.height;
              }

              int_10 = int_13;
              int_11 = int_14;
            }

            if (!widget_0.aBool33) {
              int_12 = 128;
            }
          }

          int int_15;
          int int_16;
          int int_17;
          int int_18;
          int int_19;
          int int_20;
          if (widget_0.type == 2) {
            int_13 = int_1;
            int_14 = int_2;
            int_15 = int_3;
            int_16 = int_4;
          } else if (widget_0.type == 9) {
            int_19 = int_10;
            int_17 = int_11;
            int_18 = int_10 + widget_0.width;
            int_20 = int_11 + widget_0.height;
            if (int_18 < int_10) {
              int_19 = int_18;
              int_18 = int_10;
            }

            if (int_20 < int_11) {
              int_17 = int_20;
              int_20 = int_11;
            }

            ++int_18;
            ++int_20;
            int_13 = int_19 > int_1 ? int_19 : int_1;
            int_14 = int_17 > int_2 ? int_17 : int_2;
            int_15 = int_18 < int_3 ? int_18 : int_3;
            int_16 = int_20 < int_4 ? int_20 : int_4;
          } else {
            int_19 = int_10 + widget_0.width;
            int_17 = int_11 + widget_0.height;
            int_13 = int_10 > int_1 ? int_10 : int_1;
            int_14 = int_11 > int_2 ? int_11 : int_2;
            int_15 = int_19 < int_3 ? int_19 : int_3;
            int_16 = int_17 < int_4 ? int_17 : int_4;
          }

          if (!widget_0.hasScript || int_13 < int_15 && int_14 < int_16) {
            int int_22;
            int int_23;
            int int_24;
            int int_25;
            int int_26;
            int int_27;
            int int_28;
            int int_29;
            int int_30;
            int int_31;
            int int_32;
            int int_33;
            int int_34;
            int int_35;
            int int_36;
            int int_37;
            int int_38;
            int int_39;
            int int_41;
            int int_42;
            int int_43;
            if (widget_0.contentType != 0) {
              if (widget_0.contentType == 1336) {
                if (displayFps) {
                  int_11 += 15;
                  Class12.font_p12full.method1000("Fps:" + FPS, int_10 + widget_0.width,
                      int_11, 16776960, -1);
                  int_11 += 15;
                  final Runtime runtime_0 = Runtime.getRuntime();
                  int_17 = (int) ((runtime_0.totalMemory() - runtime_0.freeMemory()) / 1024L);
                  int_18 = 16776960;
                  if (int_17 > 32768 && lowMemory) {
                    int_18 = 16711680;
                  }

                  if (int_17 > 65536 && !lowMemory) {
                    int_18 = 16711680;
                  }

                  Class12.font_p12full.method1000("Mem:" + int_17 + "k", int_10 + widget_0.width,
                      int_11, int_18, -1);
                  int_11 += 15;
                }
                continue;
              }

              if (widget_0.contentType == 1337) {
                anInt600 = int_10;
                anInt601 = int_11;
                int_18 = widget_0.width;
                int_20 = widget_0.height;
                ++anInt643;
                Class94.method514(Class23.aClass23_1);
                boolean bool_1 = false;
                if (anInt652 >= 0) {
                  int_22 = Class39.anInt89;
                  final int[] ints_0 = Class39.anIntArray14;

                  for (int_23 = 0; int_23 < int_22; int_23++) {
                    if (ints_0[int_23] == anInt652) {
                      bool_1 = true;
                      break;
                    }
                  }
                }

                if (bool_1) {
                  Class94.method514(Class23.aClass23_2);
                }

                AClass1_Sub1.method596(true);
                Class94.method514(bool_1 ? Class23.aClass23_4 : Class23.aClass23_3);
                AClass1_Sub1.method596(false);
                ClassInfo.method671();

                for (SpotAnimation graphicsobject_0 = (SpotAnimation) graphicsObjectDeque
                    .getFirst(); graphicsobject_0 != null;
                    graphicsobject_0 = (SpotAnimation) graphicsObjectDeque
                        .getNext()) {
                  if (graphicsobject_0.level == Class12.plane && !graphicsobject_0.finished) {
                    if (tick >= graphicsobject_0.startCycle) {
                      graphicsobject_0.method915(anInt610);
                      if (graphicsobject_0.finished) {
                        graphicsobject_0.unlink();
                      } else {
                        Class11.region.method369(graphicsobject_0.level, graphicsobject_0.x,
                            graphicsobject_0.y, graphicsobject_0.height, 60,
                            graphicsobject_0, 0, -1, false);
                      }
                    }
                  } else {
                    graphicsobject_0.unlink();
                  }
                }

                Class69_Sub1.method611(int_10, int_11, int_18, int_20, true);
                int_19 = anInt667;
                int_17 = anInt668;
                int_18 = viewportHeight;
                int_20 = viewportWidth;
                Rasterizer2d.setClip(int_19, int_17, int_19 + int_18, int_17 + int_20);
                Rasterizer3d.init();
                if (!aBool87) {
                  int_22 = anInt653;
                  if (anInt680 / 256 > int_22) {
                    int_22 = anInt680 / 256;
                  }

                  if (aBoolArray12[4] && anIntArray153[4] + 128 > int_22) {
                    int_22 = anIntArray153[4] + 128;
                  }

                  int_24 = mapAngle & 0x7FF;
                  int_23 = Class11.anInt55;
                  int_25 = Class29.getTileHeight(GrandExchangeOffer.localPlayer.x,
                      GrandExchangeOffer.localPlayer.y, Class12.plane) - anInt678;
                  int_26 = WorldMapData.anInt107;
                  int_27 = int_22 * 3 + 600;
                  int_28 = 2048 - int_22 & 0x7FF;
                  int_29 = 2048 - int_24 & 0x7FF;
                  int_30 = 0;
                  int_31 = 0;
                  int_32 = int_27;
                  if (int_28 != 0) {
                    int_33 = Rasterizer3d.SINE[int_28];
                    int_34 = Rasterizer3d.COSINE[int_28];
                    int_35 = int_34 * int_31 - int_33 * int_27 >> 16;
                    int_32 = int_33 * int_31 + int_27 * int_34 >> 16;
                    int_31 = int_35;
                  }

                  if (int_29 != 0) {
                    int_33 = Rasterizer3d.SINE[int_29];
                    int_34 = Rasterizer3d.COSINE[int_29];
                    int_35 = int_32 * int_33 + int_34 * int_30 >> 16;
                    int_32 = int_34 * int_32 - int_33 * int_30 >> 16;
                    int_30 = int_35;
                  }

                  Isaac.cameraX = int_23 - int_30;
                  WorldMapData.cameraZ = int_25 - int_31;
                  Class29.cameraY = int_26 - int_32;
                  Keyboard.cameraPitch = int_22;
                  Boundry.cameraYaw = int_24;
                }

                if (!aBool87) {
                  if (LongVariable.preferences.hideRoofs) {
                    int_24 = Class12.plane;
                  } else {
                    label1655:
                    {
                      int_23 = 3;
                      if (Keyboard.cameraPitch < 310) {
                        int_25 = Isaac.cameraX >> 7;
                        int_26 = Class29.cameraY >> 7;
                        int_27 = GrandExchangeOffer.localPlayer.x >> 7;
                        int_28 = GrandExchangeOffer.localPlayer.y >> 7;
                        if (int_25 < 0 || int_26 < 0 || int_25 >= 104
                            || int_26 >= 104) {
                          int_24 = Class12.plane;
                          break label1655;
                        }

                        if ((Class22.flags[Class12.plane][int_25][int_26] & 0x4) != 0) {
                          int_23 = Class12.plane;
                        }

                        if (int_27 > int_25) {
                          int_29 = int_27 - int_25;
                        } else {
                          int_29 = int_25 - int_27;
                        }

                        if (int_28 > int_26) {
                          int_30 = int_28 - int_26;
                        } else {
                          int_30 = int_26 - int_28;
                        }

                        if (int_29 > int_30) {
                          int_31 = int_30 * 65536 / int_29;
                          int_32 = 32768;

                          while (int_25 != int_27) {
                            if (int_25 < int_27) {
                              ++int_25;
                            } else if (int_25 > int_27) {
                              --int_25;
                            }

                            if ((Class22.flags[Class12.plane][int_25][int_26]
                                & 0x4) != 0) {
                              int_23 = Class12.plane;
                            }

                            int_32 += int_31;
                            if (int_32 >= 65536) {
                              int_32 -= 65536;
                              if (int_26 < int_28) {
                                ++int_26;
                              } else if (int_26 > int_28) {
                                --int_26;
                              }

                              if ((Class22.flags[Class12.plane][int_25][int_26]
                                  & 0x4) != 0) {
                                int_23 = Class12.plane;
                              }
                            }
                          }
                        } else {
                          int_31 = int_29 * 65536 / int_30;
                          int_32 = 32768;

                          while (int_26 != int_28) {
                            if (int_26 < int_28) {
                              ++int_26;
                            } else if (int_26 > int_28) {
                              --int_26;
                            }

                            if ((Class22.flags[Class12.plane][int_25][int_26]
                                & 0x4) != 0) {
                              int_23 = Class12.plane;
                            }

                            int_32 += int_31;
                            if (int_32 >= 65536) {
                              int_32 -= 65536;
                              if (int_25 < int_27) {
                                ++int_25;
                              } else if (int_25 > int_27) {
                                --int_25;
                              }

                              if ((Class22.flags[Class12.plane][int_25][int_26]
                                  & 0x4) != 0) {
                                int_23 = Class12.plane;
                              }
                            }
                          }
                        }
                      }

                      if (GrandExchangeOffer.localPlayer.x >= 0
                          && GrandExchangeOffer.localPlayer.y >= 0
                          && GrandExchangeOffer.localPlayer.x < 13312
                          && GrandExchangeOffer.localPlayer.y < 13312) {
                        if ((Class22.flags[Class12.plane][GrandExchangeOffer.localPlayer.x
                            >> 7][GrandExchangeOffer.localPlayer.y >> 7]
                            & 0x4) != 0) {
                          int_23 = Class12.plane;
                        }

                        int_24 = int_23;
                      } else {
                        int_24 = Class12.plane;
                      }
                    }
                  }

                  int_22 = int_24;
                } else {
                  if (LongVariable.preferences.hideRoofs) {
                    int_24 = Class12.plane;
                  } else {
                    int_23 = Class29.getTileHeight(Isaac.cameraX, Class29.cameraY,
                        Class12.plane);
                    if (int_23 - WorldMapData.cameraZ < 800
                        && (Class22.flags[Class12.plane][Isaac.cameraX >> 7][
                        Class29.cameraY >> 7]
                        & 0x4) != 0) {
                      int_24 = Class12.plane;
                    } else {
                      int_24 = 3;
                    }
                  }

                  int_22 = int_24;
                }

                int_24 = Isaac.cameraX;
                int_23 = WorldMapData.cameraZ;
                int_25 = Class29.cameraY;
                int_26 = Keyboard.cameraPitch;
                int_27 = Boundry.cameraYaw;

                for (int_28 = 0; int_28 < 5; int_28++) {
                  if (aBoolArray12[int_28]) {
                    int_29 = (int) (Math.random() * (anIntArray161[int_28] * 2 + 1)
                        - anIntArray161[int_28]
                        + Math.sin(anIntArray164[int_28]
                        * anIntArray162[int_28] / 100.0D)
                        * anIntArray153[int_28]);
                    if (int_28 == 0) {
                      Isaac.cameraX += int_29;
                    }

                    if (int_28 == 1) {
                      WorldMapData.cameraZ += int_29;
                    }

                    if (int_28 == 2) {
                      Class29.cameraY += int_29;
                    }

                    if (int_28 == 3) {
                      Boundry.cameraYaw = int_29 + Boundry.cameraYaw & 0x7FF;
                    }

                    if (int_28 == 4) {
                      Keyboard.cameraPitch += int_29;
                      if (Keyboard.cameraPitch < 128) {
                        Keyboard.cameraPitch = 128;
                      }

                      if (Keyboard.cameraPitch > 383) {
                        Keyboard.cameraPitch = 383;
                      }
                    }
                  }
                }

                int_28 = Mouse.anInt249;
                int_29 = Mouse.anInt251;
                if (Mouse.anInt248 != 0) {
                  int_28 = Mouse.anInt253;
                  int_29 = Mouse.anInt254;
                }

                if (int_28 >= int_19 && int_28 < int_19 + int_18 && int_29 >= int_17
                    && int_29 < int_17 + int_20) {
                  int_30 = int_28 - int_19;
                  int_31 = int_29 - int_17;
                  Class56.anInt140 = int_30;
                  Class56.anInt141 = int_31;
                  Class56.aBool18 = true;
                  Class56.anInt142 = 0;
                  Class56.aBool19 = false;
                } else {
                  Class56.aBool18 = false;
                  Class56.anInt142 = 0;
                }

                Class77.method468();
                Rasterizer2d.fillRectangle(int_19, int_17, int_18, int_20, 0);
                Class77.method468();
                int_30 = Rasterizer3d.anInt530;
                Rasterizer3d.anInt530 = scale;
                Class11.region.draw(Isaac.cameraX, WorldMapData.cameraZ, Class29.cameraY,
                    Keyboard.cameraPitch, Boundry.cameraYaw, int_22);
                Class45.method289();
                Rasterizer3d.anInt530 = int_30;
                Class77.method468();
                Class11.region.clearEntities();
                anInt681 = 0;
                boolean bool_4 = false;
                int_32 = -1;
                int_33 = Class39.anInt89;
                final int[] ints_1 = Class39.anIntArray14;

                for (int_35 = 0; int_35 < int_33 + anInt636; int_35++) {
                  Object object_0;
                  if (int_35 < int_33) {
                    object_0 = cachedPlayers[ints_1[int_35]];
                    if (ints_1[int_35] == anInt652) {
                      bool_4 = true;
                      int_32 = int_35;
                      continue;
                    }
                  } else {
                    object_0 = cachedNPCs[npcIndices[int_35 - int_33]];
                  }

                  Class48.method299((Mobile) object_0, int_35, int_19, int_17, int_18, int_20);
                }

                if (bool_4) {
                  Class48.method299(cachedPlayers[anInt652], int_32, int_19, int_17,
                      int_18, int_20);
                }

                for (int_35 = 0; int_35 < anInt681; int_35++) {
                  int_36 = anIntArray152[int_35];
                  int_37 = anIntArray154[int_35];
                  int_38 = anIntArray156[int_35];
                  int_39 = anIntArray155[int_35];
                  boolean bool_5 = true;

                  while (bool_5) {
                    bool_5 = false;

                    for (int_41 = 0; int_41 < int_35; int_41++) {
                      if (int_37 + 2 > anIntArray154[int_41]
                          - anIntArray155[int_41]
                          && int_37 - int_39 < anIntArray154[int_41] + 2
                          && int_36 - int_38 < anIntArray156[int_41]
                          + anIntArray152[int_41]
                          && int_36 + int_38 > anIntArray152[int_41]
                          - anIntArray156[int_41]
                          && anIntArray154[int_41]
                          - anIntArray155[int_41] < int_37) {
                        int_37 = anIntArray154[int_41] - anIntArray155[int_41];
                        bool_5 = true;
                      }
                    }
                  }

                  screenY = anIntArray152[int_35];
                  screenX = anIntArray154[int_35] = int_37;
                  final String string_2 = aStringArray6[int_35];
                  if (anInt669 == 0) {
                    int_42 = 16776960;
                    if (anIntArray158[int_35] < 6) {
                      int_42 = anIntArray167[anIntArray158[int_35]];
                    }

                    if (anIntArray158[int_35] == 6) {
                      int_42 = anInt643 % 20 < 10 ? 16711680 : 16776960;
                    }

                    if (anIntArray158[int_35] == 7) {
                      int_42 = anInt643 % 20 < 10 ? 255 : 65535;
                    }

                    if (anIntArray158[int_35] == 8) {
                      int_42 = anInt643 % 20 < 10 ? 45056 : 8454016;
                    }

                    if (anIntArray158[int_35] == 9) {
                      int_43 = 150 - anIntArray160[int_35];
                      if (int_43 < 50) {
                        int_42 = 16711680 + int_43 * 1280;
                      } else if (int_43 < 100) {
                        int_42 = 16776960 - (int_43 - 50) * 327680;
                      } else if (int_43 < 150) {
                        int_42 = 65280 + (int_43 - 100) * 5;
                      }
                    }

                    if (anIntArray158[int_35] == 10) {
                      int_43 = 150 - anIntArray160[int_35];
                      if (int_43 < 50) {
                        int_42 = int_43 * 5 + 16711680;
                      } else if (int_43 < 100) {
                        int_42 = 16711935 - (int_43 - 50) * 327680;
                      } else if (int_43 < 150) {
                        int_42 = (int_43 - 100) * 327680 + 255 - (int_43 - 100) * 5;
                      }
                    }

                    if (anIntArray158[int_35] == 11) {
                      int_43 = 150 - anIntArray160[int_35];
                      if (int_43 < 50) {
                        int_42 = 16777215 - int_43 * 327685;
                      } else if (int_43 < 100) {
                        int_42 = (int_43 - 50) * 327685 + 65280;
                      } else if (int_43 < 150) {
                        int_42 = 16777215 - (int_43 - 100) * 327680;
                      }
                    }

                    if (anIntArray159[int_35] == 0) {
                      Class22.aFont3.method998(string_2, int_19 + screenY,
                          int_17 + screenX, int_42, 0);
                    }

                    if (anIntArray159[int_35] == 1) {
                      Class22.aFont3.method1001(string_2, int_19 + screenY,
                          int_17 + screenX, int_42, 0, anInt643);
                    }

                    if (anIntArray159[int_35] == 2) {
                      Class22.aFont3.method1002(string_2, int_19 + screenY,
                          int_17 + screenX, int_42, 0, anInt643);
                    }

                    if (anIntArray159[int_35] == 3) {
                      Class22.aFont3.method1003(string_2, int_19 + screenY,
                          int_17 + screenX, int_42, 0, anInt643,
                          150 - anIntArray160[int_35]);
                    }

                    if (anIntArray159[int_35] == 4) {
                      int_43 = (150 - anIntArray160[int_35])
                          * (Class22.aFont3.method989(string_2) + 100) / 150;
                      Rasterizer2d.resizeClip(int_19 + screenY - 50, int_17,
                          int_19 + screenY + 50, int_17 + int_20);
                      Class22.aFont3.method999(string_2, int_19 + screenY + 50 - int_43,
                          int_17 + screenX, int_42, 0);
                      Rasterizer2d.setClip(int_19, int_17, int_18 + int_19,
                          int_17 + int_20);
                    }

                    if (anIntArray159[int_35] == 5) {
                      int_43 = 150 - anIntArray160[int_35];
                      int int_44 = 0;
                      if (int_43 < 25) {
                        int_44 = int_43 - 25;
                      } else if (int_43 > 125) {
                        int_44 = int_43 - 125;
                      }

                      Rasterizer2d.resizeClip(int_19,
                          (int_17 + screenX) - Class22.aFont3.verticalSpace - 1,
                          int_18 + int_19, int_17 + screenX + 5);
                      Class22.aFont3.method998(string_2, int_19 + screenY,
                          int_44 + int_17 + screenX, int_42, 0);
                      Rasterizer2d.setClip(int_19, int_17, int_18 + int_19,
                          int_17 + int_20);
                    }
                  } else {
                    Class22.aFont3.method998(string_2, int_19 + screenY,
                        int_17 + screenX, 16776960, 0);
                  }
                }

                if (anInt614 == 2) {
                  Class38.method266((hintArrowX - Boundry.baseX << 7) + anInt625,
                      (hintArrowY - WorldMapData_Sub1.baseY << 7) + anInt626,
                      hintArrowType * 2);
                  if (screenY > -1 && tick % 20 < 10) {
                    Class45.pkIcons[0].method938(int_19 + screenY - 12,
                        int_17 + screenX - 28);
                  }
                }

                ((Materials) Rasterizer3d.materials).method556(anInt610);
                if (cursorState == 1) {
                  crosses[anInt624 / 100].method938(anInt619 - 8,
                      anInt622 - 8);
                }

                if (cursorState == 2) {
                  crosses[anInt624 / 100 + 4]
                      .method938(anInt619 - 8, anInt622 - 8);
                }

                Class2.method119();
                Isaac.cameraX = int_24;
                WorldMapData.cameraZ = int_23;
                Class29.cameraY = int_25;
                Keyboard.cameraPitch = int_26;
                Boundry.cameraYaw = int_27;
                if (aBool82) {
                  final byte byte_0 = 0;
                  int_32 = byte_0 + RemoteAssetRequestor.anInt193 + RemoteAssetRequestor.anInt194;
                  if (int_32 == 0) {
                    aBool82 = false;
                  }
                }

                if (aBool82) {
                  Rasterizer2d.fillRectangle(int_19, int_17, int_18, int_20, 0);
                  Class51.drawStatusBox("Loading - please wait.", false);
                }

                aBoolArray8[widget_0.boundsIndex] = true;
                Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
                continue;
              }

              if (widget_0.contentType == 1338) {
                Keyboard.method341(widget_0, int_10, int_11, int_9);
                Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
                continue;
              }

              if (widget_0.contentType == 1339) {
                Class16.method196(widget_0, int_10, int_11, int_9);
                Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
                continue;
              }

              if (widget_0.contentType == 1400) {
                Class14.renderOverview
                    .extractWorldmap(int_10, int_11, widget_0.width, widget_0.height,
                        tick);
              }

              if (widget_0.contentType == 1401) {
                Class14.renderOverview.extractData(int_10, int_11, widget_0.width, widget_0.height);
              }
            }

            if (widget_0.type == 0) {
              if (!widget_0.hasScript && Renderable.method711(widget_0)
                  && widget_0 != IntegerVariable.aWidget4) {
                continue;
              }

              if (!widget_0.hasScript) {
                if (widget_0.scrollY > widget_0.scrollHeight - widget_0.height) {
                  widget_0.scrollY = widget_0.scrollHeight - widget_0.height;
                }

                if (widget_0.scrollY < 0) {
                  widget_0.scrollY = 0;
                }
              }

              gameDraw(widgets_0, widget_0.id, int_13, int_14, int_15, int_16,
                  int_10 - widget_0.scrollX,
                  int_11 - widget_0.scrollY, int_9);
              if (widget_0.children != null) {
                gameDraw(widget_0.children, widget_0.id, int_13, int_14, int_15, int_16,
                    int_10 - widget_0.scrollX, int_11 - widget_0.scrollY, int_9);
              }

              final OpenedInterface widgetnode_0 = (OpenedInterface) componentTable.get(widget_0.id);
              if (widgetnode_0 != null) {
                int_17 = widgetnode_0.id;
                if (!Ignore.loadWidget(int_17)) {
                  if (int_9 != -1) {
                    aBoolArray8[int_9] = true;
                  } else {
                    for (int_18 = 0; int_18 < 100; int_18++) {
                      aBoolArray8[int_18] = true;
                    }
                  }
                } else {
                  Class53.aWidgetArray1 = null;
                  gameDraw(Time.widgets[int_17], -1, int_13, int_14, int_15, int_16, int_10,
                      int_11, int_9);
                  if (Class53.aWidgetArray1 != null) {
                    gameDraw(Class53.aWidgetArray1, -1412584499, int_13, int_14, int_15, int_16,
                        Class23.anInt74, Boundry.anInt48, int_9);
                    Class53.aWidgetArray1 = null;
                  }
                }
              }

              Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
              Rasterizer3d.init();
            }

            if (isResized || aBoolArray9[int_9] || gameDrawingMode > 1) {
              if (widget_0.type == 0 && !widget_0.hasScript
                  && widget_0.scrollHeight > widget_0.height) {
                Class52
                    .method334(int_10 + widget_0.width, int_11, widget_0.scrollY, widget_0.height,
                        widget_0.scrollHeight);
              }

              if (widget_0.type != 1) {
                int int_21;
                if (widget_0.type == 2) {
                  int_19 = 0;

                  for (int_17 = 0; int_17 < widget_0.anInt265; int_17++) {
                    for (int_18 = 0; int_18 < widget_0.originalWidth; int_18++) {
                      int_20 = int_10 + int_18 * (widget_0.paddingX + 32);
                      int_21 = int_17 * (widget_0.paddingY + 32) + int_11;
                      if (int_19 < 20) {
                        int_20 += widget_0.xSprites[int_19];
                        int_21 += widget_0.anIntArray72[int_19];
                      }

                      if (widget_0.itemIds[int_19] <= 0) {
                        if (widget_0.anIntArray70 != null && int_19 < 20) {
                          final DirectSprite spritepixels_2 = widget_0.method581(int_19);
                          if (spritepixels_2 != null) {
                            spritepixels_2.method938(int_20, int_21);
                          } else if (InterfaceComponent.aBool27) {
                            Class28.method236(widget_0);
                          }
                        }
                      } else {
                        int_23 = widget_0.itemIds[int_19] - 1;
                        if (int_20 + 32 > int_1 && int_20 < int_3
                            && int_21 + 32 > int_2 && int_21 < int_4
                            || widget_0 == Class29.aWidget3
                            && int_19 == anInt632) {
                          DirectSprite spritepixels_0;
                          if (itemSelectionState == 1
                              && int_19 == MessageNode.selectedItemIndex
                              && widget_0.id == Class1.anInt15) {
                            spritepixels_0 = Class36.createSprite(int_23,
                                widget_0.itemQuantities[int_19], 2, 0, 2, false);
                          } else {
                            spritepixels_0 = Class36.createSprite(int_23,
                                widget_0.itemQuantities[int_19], 1, 3153952, 2, false);
                          }

                          if (spritepixels_0 != null) {
                            if (widget_0 == Class29.aWidget3
                                && int_19 == anInt632) {
                              int_22 = Mouse.anInt249 - anInt630;
                              int_24 = Mouse.anInt251 - anInt631;
                              if (int_22 < 5 && int_22 > -5) {
                                int_22 = 0;
                              }

                              if (int_24 < 5 && int_24 > -5) {
                                int_24 = 0;
                              }

                              if (anInt627 < 5) {
                                int_22 = 0;
                                int_24 = 0;
                              }

                              spritepixels_0.method953(int_20 + int_22, int_21 + int_24,
                                  128);
                              if (int_0 != -1) {
                                final InterfaceComponent widget_1 = widgets_0[int_0 & 0xFFFF];
                                if (int_24 + int_21 < Rasterizer2d.ly
                                    && widget_1.scrollY > 0) {
                                  int_27 = (Rasterizer2d.ly - int_21
                                      - int_24) * anInt610 / 3;
                                  if (int_27 > anInt610 * 10) {
                                    int_27 = anInt610 * 10;
                                  }

                                  if (int_27 > widget_1.scrollY) {
                                    int_27 = widget_1.scrollY;
                                  }

                                  widget_1.scrollY -= int_27;
                                  anInt631 += int_27;
                                  Class28.method236(widget_1);
                                }

                                if (int_21 + int_24
                                    + 32 > Rasterizer2d.uy
                                    && widget_1.scrollY < widget_1.scrollHeight
                                    - widget_1.height) {
                                  int_27 = (int_21 + int_24 + 32
                                      - Rasterizer2d.uy)
                                      * anInt610 / 3;
                                  if (int_27 > anInt610 * 10) {
                                    int_27 = anInt610 * 10;
                                  }

                                  if (int_27 > widget_1.scrollHeight
                                      - widget_1.height - widget_1.scrollY) {
                                    int_27 = widget_1.scrollHeight - widget_1.height
                                        - widget_1.scrollY;
                                  }

                                  widget_1.scrollY += int_27;
                                  anInt631 -= int_27;
                                  Class28.method236(widget_1);
                                }
                              }
                            } else if (widget_0 == Class19.aWidget2
                                && int_19 == anInt658) {
                              spritepixels_0.method953(int_20, int_21, 128);
                            } else {
                              spritepixels_0.method938(int_20, int_21);
                            }
                          } else {
                            Class28.method236(widget_0);
                          }
                        }
                      }

                      ++int_19;
                    }
                  }
                } else if (widget_0.type == 3) {
                  if (Class59.method398(widget_0)) {
                    int_19 = widget_0.anInt274;
                    if (widget_0 == IntegerVariable.aWidget4 && widget_0.anInt278 != 0) {
                      int_19 = widget_0.anInt278;
                    }
                  } else {
                    int_19 = widget_0.textColor;
                    if (widget_0 == IntegerVariable.aWidget4 && widget_0.anInt276 != 0) {
                      int_19 = widget_0.anInt276;
                    }
                  }

                  if (widget_0.aBool29) {
                    switch (widget_0.anEnum9_1.anInt378) {
                      case 1:
                        Rasterizer2d.method889(int_10, int_11, widget_0.width, widget_0.height,
                            widget_0.textColor, widget_0.anInt274,
                            256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt279 & 0xFF));
                        break;
                      case 2:
                        Rasterizer2d.method890(int_10, int_11, widget_0.width, widget_0.height,
                            widget_0.textColor, widget_0.anInt274,
                            256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt279 & 0xFF));
                        break;
                      case 3:
                        Rasterizer2d.method891(int_10, int_11, widget_0.width, widget_0.height,
                            widget_0.textColor, widget_0.anInt274,
                            256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt279 & 0xFF));
                        break;
                      case 4:
                        Rasterizer2d.method892(int_10, int_11, widget_0.width, widget_0.height,
                            widget_0.textColor, widget_0.anInt274,
                            256 - (widget_0.opacity & 0xFF), 256 - (widget_0.anInt279 & 0xFF));
                        break;
                      default:
                        if (int_12 == 0) {
                          Rasterizer2d.fillRectangle(int_10, int_11, widget_0.width, widget_0.height,
                              int_19);
                        } else {
                          Rasterizer2d.fillRectangle(int_10, int_11, widget_0.width,
                              widget_0.height, int_19, 256 - (int_12 & 0xFF));
                        }
                    }
                  } else if (int_12 == 0) {
                    Rasterizer2d.drawRectangle(int_10, int_11, widget_0.width, widget_0.height,
                        int_19);
                  } else {
                    Rasterizer2d.method888(int_10, int_11, widget_0.width, widget_0.height, int_19,
                        256 - (int_12 & 0xFF));
                  }
                } else {
                  BitmapFont font_1;
                  if (widget_0.type == 4) {
                    font_1 = widget_0.method580();
                    if (font_1 == null) {
                      if (InterfaceComponent.aBool27) {
                        Class28.method236(widget_0);
                      }
                    } else {
                      String string_3 = widget_0.text;
                      if (Class59.method398(widget_0)) {
                        int_17 = widget_0.anInt274;
                        if (widget_0 == IntegerVariable.aWidget4 && widget_0.anInt278 != 0) {
                          int_17 = widget_0.anInt278;
                        }

                        if (widget_0.aString16.length() > 0) {
                          string_3 = widget_0.aString16;
                        }
                      } else {
                        int_17 = widget_0.textColor;
                        if (widget_0 == IntegerVariable.aWidget4 && widget_0.anInt276 != 0) {
                          int_17 = widget_0.anInt276;
                        }
                      }

                      if (widget_0.hasScript && widget_0.itemId != -1) {
                        final ItemConfig itemcomposition_1 = AudioWorker
                            .getItemDefinition(widget_0.itemId);
                        string_3 = itemcomposition_1.name;
                        if (string_3 == null) {
                          string_3 = "null";
                        }

                        if ((itemcomposition_1.isStackable == 1
                            || widget_0.itemQuantity != 1)
                            && widget_0.itemQuantity != -1) {
                          string_3 = Square.getColTags(16748608) + string_3 + "</col>" + " "
                              + 'x' + Timestamp.method427(widget_0.itemQuantity);
                        }
                      }

                      if (widget_0 == aWidget13) {
                        string_3 = "Please wait...";
                        int_17 = widget_0.textColor;
                      }

                      if (!widget_0.hasScript) {
                        string_3 = Class4.method126(string_3, widget_0);
                      }

                      font_1.method995(string_3, int_10, int_11, widget_0.width, widget_0.height,
                          int_17, widget_0.textShadowed ? 0 : -1, widget_0.anInt281,
                          widget_0.anInt282, widget_0.anInt283);
                    }
                  } else if (widget_0.type == 5) {
                    DirectSprite spritepixels_1;
                    if (!widget_0.hasScript) {
                      spritepixels_1 = widget_0.method578(Class59.method398(widget_0));
                      if (spritepixels_1 != null) {
                        spritepixels_1.method938(int_10, int_11);
                      } else if (InterfaceComponent.aBool27) {
                        Class28.method236(widget_0);
                      }
                    } else {
                      if (widget_0.itemId != -1) {
                        spritepixels_1 = Class36.createSprite(widget_0.itemId,
                            widget_0.itemQuantity, widget_0.borderThickness,
                            widget_0.sprite2, widget_0.anInt287, false);
                      } else {
                        spritepixels_1 = widget_0.method578(false);
                      }

                      if (spritepixels_1 == null) {
                        if (InterfaceComponent.aBool27) {
                          Class28.method236(widget_0);
                        }
                      } else {
                        int_17 = spritepixels_1.unpackedWidth;
                        int_18 = spritepixels_1.unpackedHeight;
                        if (!widget_0.aBool32) {
                          int_20 = widget_0.width * 4096 / int_17;
                          if (widget_0.textureId != 0) {
                            spritepixels_1.method952(widget_0.width / 2 + int_10,
                                widget_0.height / 2 + int_11, widget_0.textureId,
                                int_20);
                          } else if (int_12 != 0) {
                            spritepixels_1.method951(int_10, int_11, widget_0.width,
                                widget_0.height, 256 - (int_12 & 0xFF));
                          } else if (int_17 == widget_0.width
                              && int_18 == widget_0.height) {
                            spritepixels_1.method938(int_10, int_11);
                          } else {
                            spritepixels_1.method940(int_10, int_11, widget_0.width,
                                widget_0.height);
                          }
                        } else {
                          Rasterizer2d.resizeClip(int_10, int_11,
                              int_10 + widget_0.width, int_11 + widget_0.height);
                          int_20 = (int_17 - 1 + widget_0.width) / int_17;
                          int_21 = (int_18 - 1 + widget_0.height) / int_18;

                          for (int_22 = 0; int_22 < int_20; int_22++) {
                            for (int_24 = 0; int_24 < int_21; int_24++) {
                              if (widget_0.textureId != 0) {
                                spritepixels_1.method952(
                                    int_17 / 2 + int_17 * int_22 + int_10,
                                    int_11 + int_18 * int_24 + int_18 / 2,
                                    widget_0.textureId, 4096);
                              } else if (int_12 != 0) {
                                spritepixels_1.method953(int_10 + int_17 * int_22,
                                    int_18 * int_24 + int_11,
                                    256 - (int_12 & 0xFF));
                              } else {
                                spritepixels_1.method938(int_10 + int_17 * int_22,
                                    int_11 + int_18 * int_24);
                              }
                            }
                          }

                          Rasterizer2d.setClip(int_1, int_2, int_3, int_4);
                        }
                      }
                    }
                  } else {
                    ItemConfig itemcomposition_0;
                    if (widget_0.type == 6) {
                      final boolean bool_0 = Class59.method398(widget_0);
                      if (bool_0) {
                        int_17 = widget_0.anInt268;
                      } else {
                        int_17 = widget_0.anInt266;
                      }

                      Model model_0 = null;
                      int_20 = 0;
                      if (widget_0.itemId != -1) {
                        itemcomposition_0 = AudioWorker.getItemDefinition(widget_0.itemId);
                        if (itemcomposition_0 != null) {
                          itemcomposition_0 = itemcomposition_0
                              .method901(widget_0.itemQuantity);
                          model_0 = itemcomposition_0.getModel(1);
                          if (model_0 != null) {
                            model_0.calculateRectangularBounds();
                            int_20 = model_0.minimumY / 2;
                          } else {
                            Class28.method236(widget_0);
                          }
                        }
                      } else if (widget_0.modelType == 5) {
                        if (widget_0.modelId == 0) {
                          model_0 = aPlayerComposition1.method500(null, -1,
                              null, -1);
                        } else {
                          model_0 = GrandExchangeOffer.localPlayer.getModel();
                        }
                      } else if (int_17 == -1) {
                        model_0 = widget_0.method582(null, -1, bool_0,
                            GrandExchangeOffer.localPlayer.composition);
                        if (model_0 == null && InterfaceComponent.aBool27) {
                          Class28.method236(widget_0);
                        }
                      } else {
                        final AnimationSequence sequence_0 = PendingSpawn.getAnimationSequence(int_17);
                        model_0 = widget_0.method582(sequence_0, widget_0.anInt272, bool_0,
                            GrandExchangeOffer.localPlayer.composition);
                        if (model_0 == null && InterfaceComponent.aBool27) {
                          Class28.method236(widget_0);
                        }
                      }

                      Rasterizer3d.method928(widget_0.width / 2 + int_10,
                          widget_0.height / 2 + int_11);
                      int_21 = Rasterizer3d.SINE[widget_0.rotationX] * widget_0.modelZoom >> 16;
                      int_22 = Rasterizer3d.COSINE[widget_0.rotationX] * widget_0.modelZoom >> 16;
                      if (model_0 != null) {
                        if (!widget_0.hasScript) {
                          model_0.method986(0, widget_0.rotationZ, 0, widget_0.rotationX, 0,
                              int_21, int_22);
                        } else {
                          model_0.calculateRectangularBounds();
                          if (widget_0.aBool34) {
                            model_0.method987(0, widget_0.rotationZ, widget_0.rotationY,
                                widget_0.rotationX, widget_0.anInt284,
                                int_21 + int_20 + widget_0.anInt285,
                                int_22 + widget_0.anInt285, widget_0.modelZoom);
                          } else {
                            model_0.method986(0, widget_0.rotationZ, widget_0.rotationY,
                                widget_0.rotationX, widget_0.anInt284,
                                int_20 + int_21 + widget_0.anInt285,
                                int_22 + widget_0.anInt285);
                          }
                        }
                      }

                      Rasterizer3d.calculateTarget();
                    } else {
                      if (widget_0.type == 7) {
                        font_1 = widget_0.method580();
                        if (font_1 == null) {
                          if (InterfaceComponent.aBool27) {
                            Class28.method236(widget_0);
                          }
                          continue;
                        }

                        int_17 = 0;

                        for (int_18 = 0; int_18 < widget_0.anInt265; int_18++) {
                          for (int_20 = 0; int_20 < widget_0.originalWidth; int_20++) {
                            if (widget_0.itemIds[int_17] > 0) {
                              itemcomposition_0 = AudioWorker
                                  .getItemDefinition(widget_0.itemIds[int_17] - 1);
                              String string_0;
                              if (itemcomposition_0.isStackable != 1
                                  && widget_0.itemQuantities[int_17] == 1) {
                                string_0 = Square.getColTags(16748608)
                                    + itemcomposition_0.name + "</col>";
                              } else {
                                string_0 = Square.getColTags(16748608)
                                    + itemcomposition_0.name + "</col>" + " " + 'x'
                                    + Timestamp.method427(
                                    widget_0.itemQuantities[int_17]);
                              }

                              int_24 = (widget_0.paddingX + 115) * int_20 + int_10;
                              int_23 = (widget_0.paddingY + 12) * int_18 + int_11;
                              if (widget_0.anInt281 == 0) {
                                font_1.method999(string_0, int_24, int_23,
                                    widget_0.textColor,
                                    widget_0.textShadowed ? 0 : -1);
                              } else if (widget_0.anInt281 == 1) {
                                font_1.method998(string_0,
                                    widget_0.width / 2 + int_24, int_23,
                                    widget_0.textColor,
                                    widget_0.textShadowed ? 0 : -1);
                              } else {
                                font_1.method1000(string_0,
                                    int_24 + widget_0.width - 1, int_23,
                                    widget_0.textColor,
                                    widget_0.textShadowed ? 0 : -1);
                              }
                            }

                            ++int_17;
                          }
                        }
                      }

                      if (widget_0.type == 8 && widget_0 == Class43.aWidget5
                          && anInt649 == anInt650) {
                        int_19 = 0;
                        int_17 = 0;
                        final BitmapFont font_0 = Class12.font_p12full;
                        String string_1 = widget_0.text;

                        String string_4;
                        for (string_1 = Class4.method126(string_1, widget_0); string_1
                            .length() > 0; int_17 = int_17 + font_0.verticalSpace + 1) {
                          int_22 = string_1.indexOf("<br>");
                          if (int_22 != -1) {
                            string_4 = string_1.substring(0, int_22);
                            string_1 = string_1.substring(int_22 + 4);
                          } else {
                            string_4 = string_1;
                            string_1 = "";
                          }

                          int_24 = font_0.method989(string_4);
                          if (int_24 > int_19) {
                            int_19 = int_24;
                          }
                        }

                        int_19 += 6;
                        int_17 += 7;
                        int_22 = (int_10 + widget_0.width) - 5 - int_19;
                        int_24 = int_11 + widget_0.height + 5;
                        if (int_22 < int_10 + 5) {
                          int_22 = int_10 + 5;
                        }

                        if (int_22 + int_19 > int_3) {
                          int_22 = int_3 - int_19;
                        }

                        if (int_17 + int_24 > int_4) {
                          int_24 = int_4 - int_17;
                        }

                        Rasterizer2d.fillRectangle(int_22, int_24, int_19, int_17, 16777120);
                        Rasterizer2d.drawRectangle(int_22, int_24, int_19, int_17, 0);
                        string_1 = widget_0.text;
                        int_23 = int_24 + font_0.verticalSpace + 2;

                        for (string_1 = Class4.method126(string_1, widget_0); string_1
                            .length() > 0; int_23 = int_23 + font_0.verticalSpace + 1) {
                          int_25 = string_1.indexOf("<br>");
                          if (int_25 != -1) {
                            string_4 = string_1.substring(0, int_25);
                            string_1 = string_1.substring(int_25 + 4);
                          } else {
                            string_4 = string_1;
                            string_1 = "";
                          }

                          font_0.method999(string_4, int_22 + 3, int_23, 0, -1);
                        }
                      }

                      if (widget_0.type == 9) {
                        if (widget_0.aBool30) {
                          int_19 = int_10;
                          int_17 = int_11 + widget_0.height;
                          int_18 = int_10 + widget_0.width;
                          int_20 = int_11;
                        } else {
                          int_19 = int_10;
                          int_17 = int_11;
                          int_18 = int_10 + widget_0.width;
                          int_20 = int_11 + widget_0.height;
                        }

                        if (widget_0.anInt280 == 1) {
                          Rasterizer2d.drawLine(int_19, int_17, int_18, int_20,
                              widget_0.textColor);
                        } else {
                          int_24 = widget_0.textColor;
                          int_23 = widget_0.anInt280;
                          int_25 = int_18 - int_19;
                          int_26 = int_20 - int_17;
                          int_27 = int_25 >= 0 ? int_25 : -int_25;
                          int_28 = int_26 >= 0 ? int_26 : -int_26;
                          int_29 = int_27;
                          if (int_27 < int_28) {
                            int_29 = int_28;
                          }

                          if (int_29 != 0) {
                            int_30 = (int_25 << 16) / int_29;
                            int_31 = (int_26 << 16) / int_29;
                            if (int_31 <= int_30) {
                              int_30 = -int_30;
                            } else {
                              int_31 = -int_31;
                            }

                            int_32 = int_23 * int_31 >> 17;
                            int_33 = int_31 * int_23 + 1 >> 17;
                            int_34 = int_23 * int_30 >> 17;
                            int_35 = int_23 * int_30 + 1 >> 17;
                            int_21 = int_19 - Rasterizer2d.lx;
                            int_22 = int_17 - Rasterizer2d.ly;
                            int_36 = int_21 + int_32;
                            int_37 = int_21 - int_33;
                            int_38 = int_21 + int_25 - int_33;
                            int_39 = int_21 + int_25 + int_32;
                            final int int_40 = int_34 + int_22;
                            int_41 = int_22 - int_35;
                            int_42 = int_26 + int_22 - int_35;
                            int_43 = int_22 + int_26 + int_34;
                            Rasterizer3d.setRasterClippingEnabled(int_36, int_37, int_38);
                            Rasterizer3d.drawSolid(int_40, int_41, int_42, int_36, int_37,
                                int_38, int_24);
                            Rasterizer3d.setRasterClippingEnabled(int_36, int_38, int_39);
                            Rasterizer3d.drawSolid(int_40, int_42, int_43, int_36, int_38,
                                int_39, int_24);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

  }

  public static void method662(final AbstractPackage indexdatabase_0, final AbstractPackage indexdatabase_1,
      final boolean bool_0, final int int_0) {
    if (LoginScreen.aBool15) {
      if (int_0 == 4) {
        LoginScreen.loginIndex = 4;
      }

    } else {
      LoginScreen.loginIndex = int_0;
      Rasterizer2d.clear();
      final byte[] bytes_0 = indexdatabase_0.method457("title.jpg", "");
      CacheableNode_Sub6.aSpritePixels4 = ClientScriptVariable.method527(bytes_0);
      Enum2.aSpritePixels3 = CacheableNode_Sub6.aSpritePixels4.method954();
      if ((flags & 0x20000000) != 0) {
        Class35.logoSprite = Projectile.getSprite(indexdatabase_1, "logo_deadman_mode", "");
      } else {
        Class35.logoSprite = Projectile.getSprite(indexdatabase_1, "logo", "");
      }

      LoginScreen.anIndexedSprite3 = Projectile.getSprite(indexdatabase_1, "titlebox", "");
      LoginScreen.anIndexedSprite4 = Projectile.getSprite(indexdatabase_1, "titlebutton", "");
      LoginScreen.anIndexedSpriteArray6 = Class29.method239(indexdatabase_1, "runes", "");
      Game.titlemuteSprite = Class29.method239(indexdatabase_1, "title_mute", "");
      Boundry.anIndexedSprite1 = Projectile
          .getSprite(indexdatabase_1, "options_radio_buttons,0", "");
      LongVariable.anIndexedSprite2 = Projectile
          .getSprite(indexdatabase_1, "options_radio_buttons,2", "");
      WorldMapData.anIntArray24 = new int[256];

      int int_1;
      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapData.anIntArray24[int_1] = int_1 * 262144;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapData.anIntArray24[int_1 + 64] = 16711680 + int_1 * 1024;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapData.anIntArray24[int_1 + 128] = 16776960 + int_1 * 4;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapData.anIntArray24[int_1 + 192] = 16777215;
      }

      WorldMapType3.anIntArray68 = new int[256];

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapType3.anIntArray68[int_1] = int_1 * 1024;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapType3.anIntArray68[int_1 + 64] = int_1 * 4 + 65280;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapType3.anIntArray68[int_1 + 128] = int_1 * 262144 + 65535;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        WorldMapType3.anIntArray68[int_1 + 192] = 16777215;
      }

      LoginScreen.anIntArray22 = new int[256];

      for (int_1 = 0; int_1 < 64; int_1++) {
        LoginScreen.anIntArray22[int_1] = int_1 * 4;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        LoginScreen.anIntArray22[int_1 + 64] = int_1 * 262144 + 255;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        LoginScreen.anIntArray22[int_1 + 128] = int_1 * 1024 + 16711935;
      }

      for (int_1 = 0; int_1 < 64; int_1++) {
        LoginScreen.anIntArray22[int_1 + 192] = 16777215;
      }

      PrimitiveType.anIntArray78 = new int[256];
      LoginScreen.anIntArray21 = new int[32768];
      Class84.anIntArray44 = new int[32768];
      WorldMapData_Sub1.method599(null);
      Ignore.anIntArray60 = new int[32768];
      LoginScreen.anIntArray23 = new int[32768];
      if (bool_0) {
        LoginScreen.username = "";
        LoginScreen.password = "";
      }

      ClassInfo.authCodeForLogin = 0;
      Preferences.authCode = "";
      LoginScreen.aBool14 = true;
      LoginScreen.selectWorld = false;
      if (!LongVariable.preferences.muted) {
        Class53.method337(2, CacheableNode_Sub4.indexTrack1, "scape main", "", 255, false);
      } else {
        Class72.anInt168 = 1;
        Class72.anIndexDataBase4 = null;
        Enum3.anInt339 = -1;
        RuntimeException_Sub1.anInt527 = -1;
        Class72.anInt170 = 0;
        Class36.aBool8 = false;
        Class72.anInt169 = 2;
      }

      Class8.sendConInfo(false);
      LoginScreen.aBool15 = true;
      LoginScreen.anInt98 = (canvasWidth - 765) / 2;
      LoginScreen.loginWindowX = LoginScreen.anInt98 + 202;
      CacheableNode_Sub6.aSpritePixels4.method942(LoginScreen.anInt98, 0);
      Enum2.aSpritePixels3.method942(LoginScreen.anInt98 + 382, 0);
      Class35.logoSprite
          .method933(LoginScreen.anInt98 + 382 - Class35.logoSprite.width / 2, 18);
    }
  }

  public static int getWidgetConfig(final InterfaceComponent widget_0) {
    final IntegerNode integernode_0 = (IntegerNode) widgetFlags
        .get(((long) widget_0.id << 32) + widget_0.index);
    return integernode_0 != null ? integernode_0.value : widget_0.config;
  }

  public static void menuAction(final int int_0, final int int_1, int int_2, final int int_3,
      final String string_0,
      final String string_1, final int int_4, final int int_5) {
    if (int_2 >= 2000) {
      int_2 -= 2000;
    }

    if (int_2 == 1) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(107);
      outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putShort(WorldMapData_Sub1.baseY + int_1);
      outbound.putLeInt(Class1.anInt15);
      outbound.putShortAdd(MessageNode.selectedItemIndex);
      outbound.putLeShortAdd(int_0 + Boundry.baseX);
      outbound.putShortAdd(PlayerIdentity.anInt188);
      outbound.putLeShort(int_3 >> 14 & 0x7FFF);
    } else if (int_2 == 2) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(126);
      outbound.putShort(int_0 + Boundry.baseX);
      outbound.putLeShortAdd(anInt685);
      outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putShortAdd(int_3 >> 14 & 0x7FFF);
      outbound.putLeShort(WorldMapData_Sub1.baseY + int_1);
      outbound.putInt(Class10.anInt50);
    } else if (int_2 == 3) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(45);
      outbound.putLeShort(WorldMapData_Sub1.baseY + int_1);
      outbound.putShort(int_3 >> 14 & 0x7FFF);
      outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putLeShort(int_0 + Boundry.baseX);
    } else if (int_2 == 4) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(244);
      outbound.putShortAdd(int_3 >> 14 & 0x7FFF);
      outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putShort(int_0 + Boundry.baseX);
      outbound.putShort(WorldMapData_Sub1.baseY + int_1);
    } else if (int_2 == 5) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(144);
      outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putLeShortAdd(WorldMapData_Sub1.baseY + int_1);
      outbound.putShort(int_0 + Boundry.baseX);
      outbound.putLeShortAdd(int_3 >> 14 & 0x7FFF);
    } else if (int_2 == 6) {
      anInt619 = int_4;
      anInt622 = int_5;
      cursorState = 2;
      anInt624 = 0;
      destinationX = int_0;
      destinationY = int_1;
      outbound.putEncipheredByte(124);
      outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
      outbound.putLeShort(int_3 >> 14 & 0x7FFF);
      outbound.putShort(WorldMapData_Sub1.baseY + int_1);
      outbound.putShortAdd(int_0 + Boundry.baseX);
    } else {
      Npc npc_0;
      if (int_2 == 7) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(219);
          outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putLeShortAdd(PlayerIdentity.anInt188);
          outbound.putInt(Class1.anInt15);
          outbound.putLeShort(int_3);
          outbound.putLeShortAdd(MessageNode.selectedItemIndex);
        }
      } else if (int_2 == 8) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(208);
          outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putIntMe(Class10.anInt50);
          outbound.putShort(anInt685);
          outbound.putLeShortAdd(int_3);
        }
      } else if (int_2 == 9) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(42);
          outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putLeShort(int_3);
        }
      } else if (int_2 == 10) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(220);
          outbound.putByte(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putShortAdd(int_3);
        }
      } else if (int_2 == 11) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(34);
          outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putLeShortAdd(int_3);
        }
      } else if (int_2 == 12) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(22);
          outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putShortAdd(int_3);
        }
      } else if (int_2 == 13) {
        npc_0 = cachedNPCs[int_3];
        if (npc_0 != null) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(112);
          outbound.putLeShortAdd(int_3);
          outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
        }
      } else {
        Player player_0;
        if (int_2 == 14) {
          player_0 = cachedPlayers[int_3];
          if (player_0 != null) {
            anInt619 = int_4;
            anInt622 = int_5;
            cursorState = 2;
            anInt624 = 0;
            destinationX = int_0;
            destinationY = int_1;
            outbound.putEncipheredByte(36);
            outbound.putShort(int_3);
            outbound.putShortAdd(MessageNode.selectedItemIndex);
            outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
            outbound.putImeInt(Class1.anInt15);
            outbound.putShort(PlayerIdentity.anInt188);
          }
        } else if (int_2 == 15) {
          player_0 = cachedPlayers[int_3];
          if (player_0 != null) {
            anInt619 = int_4;
            anInt622 = int_5;
            cursorState = 2;
            anInt624 = 0;
            destinationX = int_0;
            destinationY = int_1;
            outbound.putEncipheredByte(162);
            outbound.putLeShort(int_3);
            outbound.putShort(anInt685);
            outbound.putLeInt(Class10.anInt50);
            outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
          }
        } else if (int_2 == 16) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(43);
          outbound.putLeShort(MessageNode.selectedItemIndex);
          outbound.putLeShortAdd(int_0 + Boundry.baseX);
          outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putLeShortAdd(int_3);
          outbound.putLeShort(PlayerIdentity.anInt188);
          outbound.putShort(WorldMapData_Sub1.baseY + int_1);
          outbound.putInt(Class1.anInt15);
        } else if (int_2 == 17) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(201);
          outbound.putShortAdd(WorldMapData_Sub1.baseY + int_1);
          outbound.putShort(anInt685);
          outbound.putLeShortAdd(int_0 + Boundry.baseX);
          outbound.putShortAdd(int_3);
          outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putImeInt(Class10.anInt50);
        } else if (int_2 == 18) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(60);
          outbound.putByte(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putLeShort(int_3);
          outbound.putShortAdd(WorldMapData_Sub1.baseY + int_1);
          outbound.putShort(int_0 + Boundry.baseX);
        } else if (int_2 == 19) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(52);
          outbound.putShortAdd(WorldMapData_Sub1.baseY + int_1);
          outbound.putByte(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putShort(int_3);
          outbound.putShort(int_0 + Boundry.baseX);
        } else if (int_2 == 20) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(105);
          outbound.putShortAdd(int_0 + Boundry.baseX);
          outbound.putLeShortAdd(int_3);
          outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
          outbound.putShort(WorldMapData_Sub1.baseY + int_1);
        } else if (int_2 == 21) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(133);
          outbound.putShort(WorldMapData_Sub1.baseY + int_1);
          outbound.putLeShortAdd(int_0 + Boundry.baseX);
          outbound.putShort(int_3);
          outbound.putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
        } else if (int_2 == 22) {
          anInt619 = int_4;
          anInt622 = int_5;
          cursorState = 2;
          anInt624 = 0;
          destinationX = int_0;
          destinationY = int_1;
          outbound.putEncipheredByte(55);
          outbound.putLeShortAdd(int_0 + Boundry.baseX);
          outbound.putLeShort(WorldMapData_Sub1.baseY + int_1);
          outbound.putLeShort(int_3);
          outbound.putByte(Keyboard.aBoolArray3[82] ? 1 : 0);
        } else if (int_2 == 23) {
          if (isMenuOpen) {
            Class11.region.method388();
          } else {
            Class11.region.method367(Class12.plane, int_0, int_1, true);
          }
        } else {
          InterfaceComponent widget_1;
          if (int_2 == 24) {
            widget_1 = ScriptExecutor.method240(int_1);
            boolean bool_0 = true;
            if (widget_1.contentType > 0) {
              bool_0 = Class16.method200(widget_1);
            }

            if (bool_0) {
              outbound.putEncipheredByte(98);
              outbound.putInt(int_1);
            }
          } else {
            if (int_2 == 25) {
              widget_1 = AClass4_Sub3.method819(int_1, int_0);
              if (widget_1 != null) {
                GrandExchangeOffer.method177();
                final int int_9 = getWidgetConfig(widget_1);
                final int int_10 = int_9 >> 11 & 0x3F;
                AClass1_Sub2.method623(int_1, int_0, int_10, widget_1.itemId);
                itemSelectionState = 0;
                aString34 = Renderable.method713(widget_1);
                if (aString34 == null) {
                  aString34 = "Null";
                }

                if (!widget_1.hasScript) {
                  aString35 = Square.getColTags(65280) + widget_1.aString17
                      + Square.getColTags(16777215);
                  return;
                }

                aString35 = widget_1.name + Square.getColTags(16777215);
              }

              return;
            }

            if (int_2 == 26) {
              Mobile.method914();
            } else {
              int int_8;
              if (int_2 == 28) {
                outbound.putEncipheredByte(98);
                outbound.putInt(int_1);
                widget_1 = ScriptExecutor.method240(int_1);
                if (widget_1.dynamicValues != null && widget_1.dynamicValues[0][0] == 5) {
                  int_8 = widget_1.dynamicValues[0][1];
                  Class85.widgetSettings[int_8] = 1 - Class85.widgetSettings[int_8];
                  Class35.method255(int_8);
                }
              } else if (int_2 == 29) {
                outbound.putEncipheredByte(98);
                outbound.putInt(int_1);
                widget_1 = ScriptExecutor.method240(int_1);
                if (widget_1.dynamicValues != null && widget_1.dynamicValues[0][0] == 5) {
                  int_8 = widget_1.dynamicValues[0][1];
                  if (Class85.widgetSettings[int_8] != widget_1.anIntArray71[0]) {
                    Class85.widgetSettings[int_8] = widget_1.anIntArray71[0];
                    Class35.method255(int_8);
                  }
                }
              } else if (int_2 == 30) {
                if (aWidget13 == null) {
                  ScriptState.method561(int_1, int_0);
                  aWidget13 = AClass4_Sub3.method819(int_1, int_0);
                  Class28.method236(aWidget13);
                }
              } else if (int_2 == 31) {
                outbound.putEncipheredByte(227);
                outbound.putShortAdd(int_0);
                outbound.putLeShort(int_3);
                outbound.putLeShort(PlayerIdentity.anInt188);
                outbound.putIntMe(Class1.anInt15);
                outbound.putImeInt(int_1);
                outbound.putShortAdd(MessageNode.selectedItemIndex);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 32) {
                outbound.putEncipheredByte(19);
                outbound.putShortAdd(anInt685);
                outbound.putShort(int_0);
                outbound.putImeInt(Class10.anInt50);
                outbound.putImeInt(int_1);
                outbound.putLeShortAdd(int_3);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 33) {
                outbound.putEncipheredByte(171);
                outbound.putLeInt(int_1);
                outbound.putShort(int_0);
                outbound.putLeShort(int_3);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 34) {
                outbound.putEncipheredByte(41);
                outbound.putLeShortAdd(int_0);
                outbound.putInt(int_1);
                outbound.putShortAdd(int_3);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 35) {
                outbound.putEncipheredByte(134);
                outbound.putLeShortAdd(int_3);
                outbound.putLeInt(int_1);
                outbound.putShortAdd(int_0);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 36) {
                outbound.putEncipheredByte(29);
                outbound.putLeShort(int_3);
                outbound.putShortAdd(int_0);
                outbound.putLeInt(int_1);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else if (int_2 == 37) {
                outbound.putEncipheredByte(202);
                outbound.putInt(int_1);
                outbound.putShort(int_3);
                outbound.putLeShort(int_0);
                anInt654 = 0;
                Class19.aWidget2 = ScriptExecutor.method240(int_1);
                anInt658 = int_0;
              } else {
                if (int_2 == 38) {
                  GrandExchangeOffer.method177();
                  widget_1 = ScriptExecutor.method240(int_1);
                  itemSelectionState = 1;
                  MessageNode.selectedItemIndex = int_0;
                  Class1.anInt15 = int_1;
                  PlayerIdentity.anInt188 = int_3;
                  Class28.method236(widget_1);
                  aString33 = Square.getColTags(16748608)
                      + AudioWorker.getItemDefinition(int_3).name + Square.getColTags(16777215);
                  if (aString33 == null) {
                    aString33 = "null";
                  }

                  return;
                }

                if (int_2 == 39) {
                  outbound.putEncipheredByte(87);
                  outbound.putShort(int_0);
                  outbound.putImeInt(int_1);
                  outbound.putLeShortAdd(int_3);
                  anInt654 = 0;
                  Class19.aWidget2 = ScriptExecutor.method240(int_1);
                  anInt658 = int_0;
                } else if (int_2 == 40) {
                  outbound.putEncipheredByte(106);
                  outbound.putLeShortAdd(int_3);
                  outbound.putShort(int_0);
                  outbound.putInt(int_1);
                  anInt654 = 0;
                  Class19.aWidget2 = ScriptExecutor.method240(int_1);
                  anInt658 = int_0;
                } else if (int_2 == 41) {
                  outbound.putEncipheredByte(82);
                  outbound.putIntMe(int_1);
                  outbound.putShortAdd(int_3);
                  outbound.putShortAdd(int_0);
                  anInt654 = 0;
                  Class19.aWidget2 = ScriptExecutor.method240(int_1);
                  anInt658 = int_0;
                } else if (int_2 == 42) {
                  outbound.putEncipheredByte(198);
                  outbound.putLeShortAdd(int_0);
                  outbound.putInt(int_1);
                  outbound.putLeShort(int_3);
                  anInt654 = 0;
                  Class19.aWidget2 = ScriptExecutor.method240(int_1);
                  anInt658 = int_0;
                } else if (int_2 == 43) {
                  outbound.putEncipheredByte(66);
                  outbound.putLeShort(int_3);
                  outbound.putIntMe(int_1);
                  outbound.putShort(int_0);
                  anInt654 = 0;
                  Class19.aWidget2 = ScriptExecutor.method240(int_1);
                  anInt658 = int_0;
                } else if (int_2 == 44) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(190);
                    outbound.putLeShortAdd(int_3);
                    outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
                  }
                } else if (int_2 == 45) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(120);
                    outbound.putLeShortAdd(int_3);
                    outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
                  }
                } else if (int_2 == 46) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(176);
                    outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
                    outbound.putLeShort(int_3);
                  }
                } else if (int_2 == 47) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(154);
                    outbound.putShortAdd(int_3);
                    outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
                  }
                } else if (int_2 == 48) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(223);
                    outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
                    outbound.putShort(int_3);
                  }
                } else if (int_2 == 49) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(114);
                    outbound.putByteAdd(Keyboard.aBoolArray3[82] ? 1 : 0);
                    outbound.putLeShort(int_3);
                  }
                } else if (int_2 == 50) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(26);
                    outbound
                        .putByteNegate(Keyboard.aBoolArray3[82] ? 1 : 0);
                    outbound.putLeShortAdd(int_3);
                  }
                } else if (int_2 == 51) {
                  player_0 = cachedPlayers[int_3];
                  if (player_0 != null) {
                    anInt619 = int_4;
                    anInt622 = int_5;
                    cursorState = 2;
                    anInt624 = 0;
                    destinationX = int_0;
                    destinationY = int_1;
                    outbound.putEncipheredByte(185);
                    outbound.putShortAdd(int_3);
                    outbound.putByteSub(Keyboard.aBoolArray3[82] ? 1 : 0);
                  }
                } else {
                  label775:
                  {
                    if (int_2 != 57) {
                      if (int_2 == 58) {
                        widget_1 = AClass4_Sub3.method819(int_1, int_0);
                        if (widget_1 != null) {
                          outbound.putEncipheredByte(57);
                          outbound.putShort(anInt684);
                          outbound.putShort(anInt685);
                          outbound.putInt(int_1);
                          outbound.putShortAdd(int_0);
                          outbound.putInt(Class10.anInt50);
                          outbound.putLeShortAdd(widget_1.itemId);
                        }
                        break label775;
                      }

                      if (int_2 == 1001) {
                        anInt619 = int_4;
                        anInt622 = int_5;
                        cursorState = 2;
                        anInt624 = 0;
                        destinationX = int_0;
                        destinationY = int_1;
                        outbound.putEncipheredByte(4);
                        outbound.putShortAdd(int_0 + Boundry.baseX);
                        outbound
                            .putByte(Keyboard.aBoolArray3[82] ? 1 : 0);
                        outbound.putLeShort(WorldMapData_Sub1.baseY + int_1);
                        outbound.putShort(int_3 >> 14 & 0x7FFF);
                        break label775;
                      }

                      if (int_2 == 1002) {
                        anInt619 = int_4;
                        anInt622 = int_5;
                        cursorState = 2;
                        anInt624 = 0;
                        outbound.putEncipheredByte(115);
                        outbound.putLeShortAdd(int_3 >> 14 & 0x7FFF);
                        break label775;
                      }

                      if (int_2 == 1003) {
                        anInt619 = int_4;
                        anInt622 = int_5;
                        cursorState = 2;
                        anInt624 = 0;
                        npc_0 = cachedNPCs[int_3];
                        if (npc_0 != null) {
                          NpcConfig npccomposition_0 = npc_0.config;
                          if (npccomposition_0.configs != null) {
                            npccomposition_0 = npccomposition_0.transform();
                          }

                          if (npccomposition_0 != null) {
                            outbound.putEncipheredByte(167);
                            outbound.putShortAdd(npccomposition_0.id);
                          }
                        }
                        break label775;
                      }

                      if (int_2 == 1004) {
                        anInt619 = int_4;
                        anInt622 = int_5;
                        cursorState = 2;
                        anInt624 = 0;
                        outbound.putEncipheredByte(119);
                        outbound.putShort(int_3);
                        break label775;
                      }

                      if (int_2 == 1005) {
                        widget_1 = ScriptExecutor.method240(int_1);
                        if (widget_1 != null && widget_1.itemQuantities[int_0] >= 100000) {
                          Npc.sendGameMessage(27, "", widget_1.itemQuantities[int_0] + " x "
                              + AudioWorker.getItemDefinition(int_3).name);
                        } else {
                          outbound.putEncipheredByte(119);
                          outbound.putShort(int_3);
                        }

                        anInt654 = 0;
                        Class19.aWidget2 = ScriptExecutor.method240(int_1);
                        anInt658 = int_0;
                        break label775;
                      }

                      if (int_2 != 1007) {
                        if (int_2 == 1008 || int_2 == 1010 || int_2 == 1011
                            || int_2 == 1009 || int_2 == 1012) {
                          Class14.renderOverview.method32(int_2, int_3,
                              new Position(int_0), new Position(int_1));
                        }
                        break label775;
                      }
                    }

                    widget_1 = AClass4_Sub3.method819(int_1, int_0);
                    if (widget_1 != null) {
                      int_8 = widget_1.itemId;
                      final InterfaceComponent widget_0 = AClass4_Sub3.method819(int_1, int_0);
                      if (widget_0 != null) {
                        if (widget_0.anObjectArray8 != null) {
                          final ScriptCall scriptevent_0 = new ScriptCall();
                          scriptevent_0.widget = widget_0;
                          scriptevent_0.anInt383 = int_3;
                          scriptevent_0.aString27 = string_1;
                          scriptevent_0.anObjectArray22 = widget_0.anObjectArray8;
                          Position.execute(scriptevent_0);
                        }

                        boolean bool_2 = true;
                        if (widget_0.contentType > 0) {
                          bool_2 = Class16.method200(widget_0);
                        }

                        if (bool_2) {
                          final int int_6 = getWidgetConfig(widget_0);
                          final int int_7 = int_3 - 1;
                          final boolean bool_1 = (int_6 >> int_7 + 1 & 0x1) != 0;
                          if (bool_1) {
                            if (int_3 == 1) {
                              outbound.putEncipheredByte(145);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 2) {
                              outbound.putEncipheredByte(242);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 3) {
                              outbound.putEncipheredByte(37);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 4) {
                              outbound.putEncipheredByte(197);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 5) {
                              outbound.putEncipheredByte(1);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 6) {
                              outbound.putEncipheredByte(62);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 7) {
                              outbound.putEncipheredByte(178);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 8) {
                              outbound.putEncipheredByte(166);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 9) {
                              outbound.putEncipheredByte(234);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }

                            if (int_3 == 10) {
                              outbound.putEncipheredByte(56);
                              outbound.putInt(int_1);
                              outbound.putShort(int_0);
                              outbound.putShort(int_8);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    if (itemSelectionState != 0) {
      itemSelectionState = 0;
      Class28.method236(ScriptExecutor.method240(Class1.anInt15));
    }

    if (spellSelected) {
      GrandExchangeOffer.method177();
    }

    if (Class19.aWidget2 != null && anInt654 == 0) {
      Class28.method236(Class19.aWidget2);
    }
  }

  static void decodeMovement(final GameBuffer packetbuffer_0, final int int_0) {
    final boolean bool_0 = packetbuffer_0.getBits(1) == 1;
    if (bool_0) {
      Class39.anIntArray19[++Class39.anInt91 - 1] = int_0;
    }

    final int int_1 = packetbuffer_0.getBits(2);
    final Player player_0 = cachedPlayers[int_0];
    if (int_1 == 0) {
      if (bool_0) {
        player_0.aBool76 = false;
      } else if (localInteractingIndex == int_0) {
        throw new RuntimeException();
      } else {
        Class39.anIntArray16[int_0] = (player_0.anInt585 << 28)
            + (Boundry.baseX + player_0.pathX[0] >> 13 << 14)
            + (WorldMapData_Sub1.baseY + player_0.pathY[0] >> 13);
        if (player_0.anInt496 != -1) {
          Class39.anIntArray17[int_0] = player_0.anInt496;
        } else {
          Class39.anIntArray17[int_0] = player_0.orientation;
        }

        Class39.anIntArray18[int_0] = player_0.interacting;
        cachedPlayers[int_0] = null;
        if (packetbuffer_0.getBits(1) != 0) {
          WorldMapType2.decodeRegionHash(packetbuffer_0, int_0);
        }

      }
    } else {
      int int_2;
      int int_3;
      int int_4;
      if (int_1 == 1) {
        int_2 = packetbuffer_0.getBits(3);
        int_3 = player_0.pathX[0];
        int_4 = player_0.pathY[0];
        if (int_2 == 0) {
          --int_3;
          --int_4;
        } else if (int_2 == 1) {
          --int_4;
        } else if (int_2 == 2) {
          ++int_3;
          --int_4;
        } else if (int_2 == 3) {
          --int_3;
        } else if (int_2 == 4) {
          ++int_3;
        } else if (int_2 == 5) {
          --int_3;
          ++int_4;
        } else if (int_2 == 6) {
          ++int_4;
        } else if (int_2 == 7) {
          ++int_3;
          ++int_4;
        }

        if (localInteractingIndex != int_0 || player_0.x >= 1536 && player_0.y >= 1536
            && player_0.x < 11776 && player_0.y < 11776) {
          if (bool_0) {
            player_0.aBool76 = true;
            player_0.anInt591 = int_3;
            player_0.anInt592 = int_4;
          } else {
            player_0.aBool76 = false;
            player_0.method1052(int_3, int_4, Class39.aByteArray4[int_0]);
          }
        } else {
          player_0.method1050(int_3, int_4);
          player_0.aBool76 = false;
        }
      } else if (int_1 == 2) {
        int_2 = packetbuffer_0.getBits(4);
        int_3 = player_0.pathX[0];
        int_4 = player_0.pathY[0];
        if (int_2 == 0) {
          int_3 -= 2;
          int_4 -= 2;
        } else if (int_2 == 1) {
          --int_3;
          int_4 -= 2;
        } else if (int_2 == 2) {
          int_4 -= 2;
        } else if (int_2 == 3) {
          ++int_3;
          int_4 -= 2;
        } else if (int_2 == 4) {
          int_3 += 2;
          int_4 -= 2;
        } else if (int_2 == 5) {
          int_3 -= 2;
          --int_4;
        } else if (int_2 == 6) {
          int_3 += 2;
          --int_4;
        } else if (int_2 == 7) {
          int_3 -= 2;
        } else if (int_2 == 8) {
          int_3 += 2;
        } else if (int_2 == 9) {
          int_3 -= 2;
          ++int_4;
        } else if (int_2 == 10) {
          int_3 += 2;
          ++int_4;
        } else if (int_2 == 11) {
          int_3 -= 2;
          int_4 += 2;
        } else if (int_2 == 12) {
          --int_3;
          int_4 += 2;
        } else if (int_2 == 13) {
          int_4 += 2;
        } else if (int_2 == 14) {
          ++int_3;
          int_4 += 2;
        } else if (int_2 == 15) {
          int_3 += 2;
          int_4 += 2;
        }

        if (localInteractingIndex == int_0 && (player_0.x < 1536 || player_0.y < 1536
            || player_0.x >= 11776 || player_0.y >= 11776)) {
          player_0.method1050(int_3, int_4);
          player_0.aBool76 = false;
        } else if (bool_0) {
          player_0.aBool76 = true;
          player_0.anInt591 = int_3;
          player_0.anInt592 = int_4;
        } else {
          player_0.aBool76 = false;
          player_0.method1052(int_3, int_4, Class39.aByteArray4[int_0]);
        }
      } else {
        int_2 = packetbuffer_0.getBits(1);
        int int_5;
        int int_6;
        int int_7;
        int int_8;
        if (int_2 == 0) {
          int_3 = packetbuffer_0.getBits(12);
          int_4 = int_3 >> 10;
          int_5 = int_3 >> 5 & 0x1F;
          if (int_5 > 15) {
            int_5 -= 32;
          }

          int_6 = int_3 & 0x1F;
          if (int_6 > 15) {
            int_6 -= 32;
          }

          int_7 = int_5 + player_0.pathX[0];
          int_8 = int_6 + player_0.pathY[0];
          if (localInteractingIndex != int_0 || player_0.x >= 1536 && player_0.y
              >= 1536
              && player_0.x < 11776 && player_0.y < 11776) {
            if (bool_0) {
              player_0.aBool76 = true;
              player_0.anInt591 = int_7;
              player_0.anInt592 = int_8;
            } else {
              player_0.aBool76 = false;
              player_0.method1052(int_7, int_8, Class39.aByteArray4[int_0]);
            }
          } else {
            player_0.method1050(int_7, int_8);
            player_0.aBool76 = false;
          }

          player_0.anInt585 = (byte) (int_4 + player_0.anInt585 & 0x3);
          if (localInteractingIndex == int_0) {
            Class12.plane = player_0.anInt585;
          }

        } else {
          int_3 = packetbuffer_0.getBits(30);
          int_4 = int_3 >> 28;
          int_5 = int_3 >> 14 & 0x3FFF;
          int_6 = int_3 & 0x3FFF;
          int_7 = (int_5 + Boundry.baseX + player_0.pathX[0] & 0x3FFF) - Boundry.baseX;
          int_8 = (int_6 + WorldMapData_Sub1.baseY + player_0.pathY[0] & 0x3FFF)
              - WorldMapData_Sub1.baseY;
          if (localInteractingIndex != int_0 || player_0.x >= 1536 && player_0.y
              >= 1536
              && player_0.x < 11776 && player_0.y < 11776) {
            if (bool_0) {
              player_0.aBool76 = true;
              player_0.anInt591 = int_7;
              player_0.anInt592 = int_8;
            } else {
              player_0.aBool76 = false;
              player_0.method1052(int_7, int_8, Class39.aByteArray4[int_0]);
            }
          } else {
            player_0.method1050(int_7, int_8);
            player_0.aBool76 = false;
          }

          player_0.anInt585 = (byte) (int_4 + player_0.anInt585 & 0x3);
          if (localInteractingIndex == int_0) {
            Class12.plane = player_0.anInt585;
          }

        }
      }
    }
  }

  static void method241() {
    LoginScreen.username = LoginScreen.username.trim();
    if (LoginScreen.username.length() == 0) {
      Class24.method218("Please enter your username.", "If you created your account after November",
          "2010, this will be the creation email address.");
    } else {
      final long long_0 = Script.method871();
      int int_0;
      if (long_0 == 0L) {
        int_0 = 5;
      } else {
        int_0 = Class43.method280(long_0, LoginScreen.username);
      }

      switch (int_0) {
        case 2:
          Class24.method218("", "Page has opened in a new window.",
              "(Please check your popup blocker.)");
          LoginScreen.loginIndex = 6;
          return;
        case 3:
          Class24.method218("", "Error connecting to server.", "");
          return;
        case 4:
          Class24.method218("The part of the website you are trying",
              "to connect to is offline at the moment.",
              "Please try again later.");
          return;
        case 5:
          Class24.method218("Sorry, there was an error trying to",
              "log you in to this part of the website.",
              "Please try again later.");
          return;
        case 6:
          Class24.method218("", "Error connecting to server.", "");
          return;
        case 7:
          Class24.method218("You must enter a valid login to proceed. For accounts",
              "created after 24th November 2010, please use your",
              "email address. Otherwise please use your username.");
          return;
        default:
      }
    }
  }

  static void method507() {
    int int_0;
    int int_1;
    int int_2;
    int int_3;
    int int_4;
    int int_5;
    int int_6;
    if (packetType == 113) {
      int_0 = secretPacketBuffer2.getUnsignedByteNegate();
      int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
      int_2 = (int_0 & 0x7) + Class1.anInt14;
      int_3 = secretPacketBuffer2.getUnsignedByte();
      int_4 = int_3 >> 2;
      int_5 = int_3 & 0x3;
      int_6 = anIntArray150[int_4];
      if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
        CacheableNode_Sub4.method855(Class12.plane, int_1, int_2, int_6, -1, int_4, int_5, 0, -1);
      }

    } else {
      GroundItem item_0;
      if (packetType == 79) {
        int_0 = secretPacketBuffer2.getUnsignedByteSub();
        int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
        int_2 = (int_0 & 0x7) + Class1.anInt14;
        int_3 = secretPacketBuffer2.getUnsignedLeShort();
        if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
          final Deque deque_0 = groundItemDeque[Class12.plane][int_1][int_2];
          if (deque_0 != null) {
            for (item_0 = (GroundItem) deque_0.getFirst(); item_0 != null;
                item_0 = (GroundItem) deque_0.getNext()) {
              if ((int_3 & 0x7FFF) == item_0.id) {
                item_0.unlink();
                break;
              }
            }

            if (deque_0.getFirst() == null) {
              groundItemDeque[Class12.plane][int_1][int_2] = null;
            }

            AClass4_Sub4.groundItemSpawned(int_1, int_2);
            return;
          }
        }

      } else {
        int int_7;
        int int_9;
        if (packetType == 131) {
          int_0 = secretPacketBuffer2.getUnsignedLeShortAdd();
          int_1 = secretPacketBuffer2.getUnsignedByte();
          int_2 = int_1 >> 2;
          int_3 = int_1 & 0x3;
          int_4 = anIntArray150[int_2];
          int_5 = secretPacketBuffer2.getUnsignedByteSub();
          int_6 = (int_5 >> 4 & 0x7) + Materials.anInt214;
          int_7 = (int_5 & 0x7) + Class1.anInt14;
          if (int_6 >= 0 && int_7 >= 0 && int_6 < 103 && int_7 < 103) {
            if (int_4 == 0) {
              final WallObject wallobject_0 = Class11.region.method384(Class12.plane, int_6, int_7);
              if (wallobject_0 != null) {
                int_9 = wallobject_0.hash >> 14 & 0x7FFF;
                if (int_2 == 2) {
                  wallobject_0.renderable1 = new DynamicObject(int_9, 2, int_3 + 4, Class12.plane,
                      int_6, int_7, int_0, false, wallobject_0.renderable1);
                  wallobject_0.renderable2 = new DynamicObject(int_9, 2, int_3 + 1 & 0x3,
                      Class12.plane, int_6, int_7, int_0, false, wallobject_0.renderable2);
                } else {
                  wallobject_0.renderable1 = new DynamicObject(int_9, int_2, int_3, Class12.plane,
                      int_6, int_7, int_0, false, wallobject_0.renderable1);
                }
              }
            }

            if (int_4 == 1) {
              final DecorativeObject decorativeobject_0 = Class11.region
                  .method385(Class12.plane, int_6,
                      int_7);
              if (decorativeobject_0 != null) {
                int_9 = decorativeobject_0.hash >> 14 & 0x7FFF;
                if (int_2 != 4 && int_2 != 5) {
                  if (int_2 == 6) {
                    decorativeobject_0.renderable1 = new DynamicObject(int_9, 4, int_3 + 4,
                        Class12.plane, int_6, int_7, int_0, false,
                        decorativeobject_0.renderable1);
                  } else if (int_2 == 7) {
                    decorativeobject_0.renderable1 = new DynamicObject(int_9, 4,
                        (int_3 + 2 & 0x3) + 4, Class12.plane, int_6, int_7, int_0, false,
                        decorativeobject_0.renderable1);
                  } else if (int_2 == 8) {
                    decorativeobject_0.renderable1 = new DynamicObject(int_9, 4, int_3 + 4,
                        Class12.plane, int_6, int_7, int_0, false,
                        decorativeobject_0.renderable1);
                    decorativeobject_0.renderable2 = new DynamicObject(int_9, 4,
                        (int_3 + 2 & 0x3) + 4, Class12.plane, int_6, int_7, int_0, false,
                        decorativeobject_0.renderable2);
                  }
                } else {
                  decorativeobject_0.renderable1 = new DynamicObject(int_9, 4, int_3, Class12.plane,
                      int_6, int_7, int_0, false, decorativeobject_0.renderable1);
                }
              }
            }

            if (int_4 == 2) {
              final GameObject gameobject_0 = Class11.region.method386(Class12.plane, int_6, int_7);
              if (int_2 == 11) {
                int_2 = 10;
              }

              if (gameobject_0 != null) {
                gameobject_0.renderable = new DynamicObject(gameobject_0.hash >> 14 & 0x7FFF,
                    int_2,
                    int_3, Class12.plane, int_6, int_7, int_0, false, gameobject_0.renderable);
              }
            }

            if (int_4 == 3) {
              final GroundObject groundobject_0 = Class11.region
                  .method387(Class12.plane, int_6, int_7);
              if (groundobject_0 != null) {
                groundobject_0.renderable = new DynamicObject(groundobject_0.hash >> 14 & 0x7FFF,
                    22,
                    int_3, Class12.plane, int_6, int_7, int_0, false, groundobject_0.renderable);
                return;
              }
            }
          }

        } else if (packetType == 231) {
          int_0 = secretPacketBuffer2.getUnsignedByte();
          int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
          int_2 = (int_0 & 0x7) + Class1.anInt14;
          int_3 = secretPacketBuffer2.getUnsignedByteAdd();
          int_4 = int_3 >> 2;
          int_5 = int_3 & 0x3;
          int_6 = anIntArray150[int_4];
          int_7 = secretPacketBuffer2.getUnsignedLeShort();
          if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
            CacheableNode_Sub4
                .method855(Class12.plane, int_1, int_2, int_6, int_7, int_4, int_5, 0, -1);
          }

        } else if (packetType == 212) {
          int_0 = secretPacketBuffer2.getUnsignedByte();
          int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
          int_2 = (int_0 & 0x7) + Class1.anInt14;
          int_3 = secretPacketBuffer2.getUnsignedShort();
          int_4 = secretPacketBuffer2.getUnsignedShort();
          if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
            item_0 = new GroundItem();
            item_0.id = int_4;
            item_0.quantity = int_3;
            if (groundItemDeque[Class12.plane][int_1][int_2] == null) {
              groundItemDeque[Class12.plane][int_1][int_2] = new Deque();
            }

            groundItemDeque[Class12.plane][int_1][int_2].addLast(item_0);
            AClass4_Sub4.groundItemSpawned(int_1, int_2);
          }

        } else {
          int int_8;
          if (packetType == 92) {
            int_0 = secretPacketBuffer2.getUnsignedByte();
            int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
            int_2 = (int_0 & 0x7) + Class1.anInt14;
            int_3 = secretPacketBuffer2.getUnsignedShort();
            int_4 = secretPacketBuffer2.getUnsignedByte();
            int_5 = int_4 >> 4 & 0xF;
            int_6 = int_4 & 0x7;
            int_7 = secretPacketBuffer2.getUnsignedByte();
            if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
              int_8 = int_5 + 1;
              if (GrandExchangeOffer.localPlayer.pathX[0] >= int_1 - int_8
                  && GrandExchangeOffer.localPlayer.pathX[0] <= int_8 + int_1
                  && GrandExchangeOffer.localPlayer.pathY[0] >= int_2 - int_8
                  && GrandExchangeOffer.localPlayer.pathY[0] <= int_2 + int_8
                  && anInt634 != 0 && int_6 > 0 && anInt648 < 50) {
                anIntArray145[anInt648] = int_3;
                anIntArray146[anInt648] = int_6;
                anIntArray147[anInt648] = int_7;
                audioEffects[anInt648] = null;
                anIntArray148[anInt648] = int_5 + (int_2 << 8) + (int_1 << 16);
                ++anInt648;
              }
            }

          } else if (packetType == 156) {
            int_0 = secretPacketBuffer2.getUnsignedByte();
            int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
            int_2 = (int_0 & 0x7) + Class1.anInt14;
            int_3 = secretPacketBuffer2.getUnsignedShort();
            int_4 = secretPacketBuffer2.getUnsignedByte();
            int_5 = secretPacketBuffer2.getUnsignedShort();
            if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
              int_1 = int_1 * 128 + 64;
              int_2 = int_2 * 128 + 64;
              final SpotAnimation graphicsobject_0 = new SpotAnimation(int_3, Class12.plane,
                  int_1,
                  int_2, Class29.getTileHeight(int_1, int_2, Class12.plane) - int_4, int_5,
                  tick);
              graphicsObjectDeque.addLast(graphicsobject_0);
            }

          } else if (packetType == 115) {
            int_0 = secretPacketBuffer2.getUnsignedByte();
            int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
            int_2 = (int_0 & 0x7) + Class1.anInt14;
            int_3 = secretPacketBuffer2.getUnsignedShort();
            int_4 = secretPacketBuffer2.getUnsignedShort();
            int_5 = secretPacketBuffer2.getUnsignedShort();
            if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104) {
              final Deque deque_1 = groundItemDeque[Class12.plane][int_1][int_2];
              if (deque_1 != null) {
                for (GroundItem item_1 = (GroundItem) deque_1.getFirst(); item_1 != null;
                    item_1 = (GroundItem) deque_1
                        .getNext()) {
                  if ((int_3 & 0x7FFF) == item_1.id && int_4 == item_1.quantity) {
                    item_1.quantity = int_5;
                    break;
                  }
                }

                AClass4_Sub4.groundItemSpawned(int_1, int_2);
              }
            }

          } else {
            int int_10;
            int int_11;
            int int_12;
            if (packetType == 73) {
              byte byte_2 = secretPacketBuffer2.getByteAdd();
              byte byte_3 = secretPacketBuffer2.getByte();
              int_2 = secretPacketBuffer2.getUnsignedByteNegate();
              int_3 = int_2 >> 2;
              int_4 = int_2 & 0x3;
              int_5 = anIntArray150[int_3];
              int_6 = secretPacketBuffer2.getUnsignedLeShortAdd();
              int_7 = secretPacketBuffer2.getUnsignedShort();
              int_8 = secretPacketBuffer2.getUnsignedLeShortAdd();
              byte byte_4 = secretPacketBuffer2.getByteSub();
              int_10 = secretPacketBuffer2.getUnsignedByte();
              int_11 = (int_10 >> 4 & 0x7) + Materials.anInt214;
              int_12 = (int_10 & 0x7) + Class1.anInt14;
              final int int_13 = secretPacketBuffer2.getUnsignedLeShortAdd();
              byte byte_0 = secretPacketBuffer2.getByteAdd();
              Player player_0;
              if (int_13 == localInteractingIndex) {
                player_0 = GrandExchangeOffer.localPlayer;
              } else {
                player_0 = cachedPlayers[int_13];
              }

              if (player_0 != null) {
                final ObjectConfig objectcomposition_0 = Class2.getObjectDefinition(int_7);
                int int_14;
                int int_15;
                if (int_4 != 1 && int_4 != 3) {
                  int_14 = objectcomposition_0.sizeX;
                  int_15 = objectcomposition_0.sizeY;
                } else {
                  int_14 = objectcomposition_0.sizeY;
                  int_15 = objectcomposition_0.sizeX;
                }

                final int int_16 = int_11 + (int_14 >> 1);
                final int int_17 = (int_14 + 1 >> 1) + int_11;
                final int int_18 = int_12 + (int_15 >> 1);
                final int int_19 = int_12 + (int_15 + 1 >> 1);
                final int[][] ints_0 = Class22.heightmap[Class12.plane];
                final int int_20 = ints_0[int_17][int_18] + ints_0[int_16][int_18]
                    + ints_0[int_16][int_19] + ints_0[int_17][int_19] >> 2;
                final int int_21 = (int_11 << 7) + (int_14 << 6);
                final int int_22 = (int_12 << 7) + (int_15 << 6);
                final Model model_0 = objectcomposition_0.method824(int_3, int_4, ints_0, int_21,
                    int_20, int_22);
                if (model_0 != null) {
                  CacheableNode_Sub4.method855(Class12.plane, int_11, int_12, int_5, -1, 0, 0,
                      int_6 + 1, int_8 + 1);
                  player_0.anInt579 = int_6 + tick;
                  player_0.anInt580 = int_8 + tick;
                  player_0.model = model_0;
                  player_0.anInt581 = int_14 * 64 + int_11 * 128;
                  player_0.anInt584 = int_12 * 128 + int_15 * 64;
                  player_0.anInt582 = int_20;
                  byte byte_1;
                  if (byte_0 > byte_4) {
                    byte_1 = byte_0;
                    byte_0 = byte_4;
                    byte_4 = byte_1;
                  }

                  if (byte_3 > byte_2) {
                    byte_1 = byte_3;
                    byte_3 = byte_2;
                    byte_2 = byte_1;
                  }

                  player_0.anInt587 = byte_0 + int_11;
                  player_0.anInt589 = byte_4 + int_11;
                  player_0.anInt588 = byte_3 + int_12;
                  player_0.anInt590 = int_12 + byte_2;
                }
              }

            } else if (packetType == 13) {
              int_0 = secretPacketBuffer2.getUnsignedByte();
              int_1 = (int_0 >> 4 & 0x7) + Materials.anInt214;
              int_2 = (int_0 & 0x7) + Class1.anInt14;
              int_3 = int_1 + secretPacketBuffer2.getByte();
              int_4 = int_2 + secretPacketBuffer2.getByte();
              int_5 = secretPacketBuffer2.getShort();
              int_6 = secretPacketBuffer2.getUnsignedShort();
              int_7 = secretPacketBuffer2.getUnsignedByte() * 4;
              int_8 = secretPacketBuffer2.getUnsignedByte() * 4;
              int_9 = secretPacketBuffer2.getUnsignedShort();
              int_10 = secretPacketBuffer2.getUnsignedShort();
              int_11 = secretPacketBuffer2.getUnsignedByte();
              int_12 = secretPacketBuffer2.getUnsignedByte();
              if (int_1 >= 0 && int_2 >= 0 && int_1 < 104 && int_2 < 104 && int_3 >= 0
                  && int_4 >= 0 && int_3 < 104 && int_4 < 104 && int_6 != 65535) {
                int_1 = int_1 * 128 + 64;
                int_2 = int_2 * 128 + 64;
                int_3 = int_3 * 128 + 64;
                int_4 = 64 + int_4 * 128;
                final Projectile projectile_0 = new Projectile(int_6, Class12.plane, int_1, int_2,
                    Class29.getTileHeight(int_1, int_2, Class12.plane) - int_7,
                    int_9 + tick, int_10 + tick, int_11, int_12, int_5,
                    int_8);
                projectile_0.method965(int_3, int_4,
                    Class29.getTileHeight(int_3, int_4, Class12.plane) - int_8,
                    int_9 + tick);
                projectiles.addLast(projectile_0);
              }

            }
          }
        }
      }
    }
  }

  static void method516() {
    Friend.method520();
    Class52.method333();
    IdentityConfig.identKits.reset();
    Class54.method349();
    NpcConfig.npcs.reset();
    NpcConfig.npcModelCache.reset();
    ItemConfig.items.reset();
    ItemConfig.itemModelCache.reset();
    ItemConfig.itemSpriteCache.reset();
    Animation.method849();
    SpotAnimationConfig.spotanims.reset();
    SpotAnimationConfig.aNodeCache6.reset();
    Class26.method231();
    Ignore.method535();
    ClanMember.method655();
    CombatInfo2.aNodeCache7.reset();
    CombatInfo2.spriteCache.reset();
    CacheableNode_Sub4.aNodeCache15.reset();
    CacheableNode_Sub3.aNodeCache14.reset();
    Class8.method153();
    PlayerIdentity.aNodeCache1.reset();
    AClass3.method619();
    ((Materials) Rasterizer3d.materials).reset();
    Script.aNodeCache18.reset();
    Class4.indexInterfaces.reset();
    ScriptState.indexSoundEffects.reset();
    Class37.anIndexData1.reset();
    anIndexData5.reset();
    Class44.maps.reset();
    CacheableNode_Sub4.indexTrack1.reset();
    Boundry.indexModels.reset();
    Time.indexSprites.reset();
    Square.indexTextures.reset();
    Mouse.anIndexData4.reset();
    State.indexTrack2.reset();
    FrameBase.indexScripts.reset();
  }

  void fetchAssets() {
    if (state != 1000) {
      final long long_0 = Time.currentTimeMillis();
      int int_0 = (int) (long_0 - RemoteAssetRequestor.aLong11);
      RemoteAssetRequestor.aLong11 = long_0;
      if (int_0 > 200) {
        int_0 = 200;
      }

      RemoteAssetRequestor.anInt191 += int_0;
      boolean bool_0;
      if (RemoteAssetRequestor.anInt196 == 0 && RemoteAssetRequestor.anInt194 == 0 &&
          RemoteAssetRequestor.anInt195 == 0
          && RemoteAssetRequestor.anInt193 == 0) {
        bool_0 = true;
      } else if (RemoteAssetRequestor.aSocketStream2 == null) {
        bool_0 = false;
      } else {
        try {
          label245:
          {
            if (RemoteAssetRequestor.anInt191 > 30000) {
              throw new IOException();
            }

            RemoteRequest filerequest_0;
            Buffer buffer_0;
            while (RemoteAssetRequestor.anInt194 < 20 && RemoteAssetRequestor.anInt193 > 0) {
              filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable4.method66();
              buffer_0 = new Buffer(4);
              buffer_0.putByte(1);
              buffer_0.putMedium((int) filerequest_0.hash);
              RemoteAssetRequestor.aSocketStream2.write(buffer_0.bytes, 0, 4);
              RemoteAssetRequestor.aHashTable5.put(filerequest_0, filerequest_0.hash);
              --RemoteAssetRequestor.anInt193;
              ++RemoteAssetRequestor.anInt194;
            }

            while (RemoteAssetRequestor.anInt196 < 20 && RemoteAssetRequestor.anInt195 > 0) {
              filerequest_0 = (RemoteRequest) RemoteAssetRequestor.passiveRequests.peek();
              buffer_0 = new Buffer(4);
              buffer_0.putByte(0);
              buffer_0.putMedium((int) filerequest_0.hash);
              RemoteAssetRequestor.aSocketStream2.write(buffer_0.bytes, 0, 4);
              filerequest_0.unlinkSubnode();
              RemoteAssetRequestor.aHashTable6.put(filerequest_0, filerequest_0.hash);
              --RemoteAssetRequestor.anInt195;
              ++RemoteAssetRequestor.anInt196;
            }

            for (int int_1 = 0; int_1 < 100; int_1++) {
              final int int_2 = RemoteAssetRequestor.aSocketStream2.available();
              if (int_2 < 0) {
                throw new IOException();
              }

              if (int_2 == 0) {
                break;
              }

              RemoteAssetRequestor.anInt191 = 0;
              byte byte_0 = 0;
              if (RemoteAssetRequestor.current == null) {
                byte_0 = 8;
              } else if (RemoteAssetRequestor.anInt197 == 0) {
                byte_0 = 1;
              }

              int int_3;
              int int_4;
              int int_5;
              int checksum;
              if (byte_0 > 0) {
                int_3 = byte_0 - RemoteAssetRequestor.aBuffer5.offset;
                if (int_3 > int_2) {
                  int_3 = int_2;
                }

                RemoteAssetRequestor.aSocketStream2.read(RemoteAssetRequestor.aBuffer5.bytes, RemoteAssetRequestor.aBuffer5.offset, int_3);
                if (RemoteAssetRequestor.aByte1 != 0) {
                  for (int_4 = 0; int_4 < int_3; int_4++) {
                    RemoteAssetRequestor.aBuffer5.bytes[
                        RemoteAssetRequestor.aBuffer5.offset + int_4] ^= RemoteAssetRequestor.aByte1;
                  }
                }

                RemoteAssetRequestor.aBuffer5.offset += int_3;
                if (RemoteAssetRequestor.aBuffer5.offset < byte_0) {
                  break;
                }

                if (RemoteAssetRequestor.current == null) {
                  RemoteAssetRequestor.aBuffer5.offset = 0;
                  int_4 = RemoteAssetRequestor.aBuffer5.getUnsignedByte();
                  int_5 = RemoteAssetRequestor.aBuffer5.getUnsignedShort();
                  final int int_6 = RemoteAssetRequestor.aBuffer5.getUnsignedByte();
                  checksum = RemoteAssetRequestor.aBuffer5.getInt();
                  final long long_1 = int_5 + (int_4 << 16);
                  RemoteRequest filerequest_1 = (RemoteRequest) RemoteAssetRequestor.aHashTable5.get(long_1);
                  RemoteAssetRequestor.aBool23 = true;
                  if (filerequest_1 == null) {
                    filerequest_1 = (RemoteRequest) RemoteAssetRequestor.aHashTable6.get(long_1);
                    RemoteAssetRequestor.aBool23 = false;
                  }

                  if (filerequest_1 == null) {
                    throw new IOException();
                  }

                  final int int_9 = int_6 == 0 ? 5 : 9;
                  RemoteAssetRequestor.current = filerequest_1;
                  MapAsset.aBuffer1 = new Buffer(checksum + int_9 + RemoteAssetRequestor.current.padding);
                  MapAsset.aBuffer1.putByte(int_6);
                  MapAsset.aBuffer1.putInt(checksum);
                  RemoteAssetRequestor.anInt197 = 8;
                  RemoteAssetRequestor.aBuffer5.offset = 0;
                } else if (RemoteAssetRequestor.anInt197 == 0) {
                  if (RemoteAssetRequestor.aBuffer5.bytes[0] == -1) {
                    RemoteAssetRequestor.anInt197 = 1;
                    RemoteAssetRequestor.aBuffer5.offset = 0;
                  } else {
                    RemoteAssetRequestor.current = null;
                  }
                }
              } else {
                int_3 = MapAsset.aBuffer1.bytes.length - RemoteAssetRequestor.current.padding;
                int_4 = 512 - RemoteAssetRequestor.anInt197;
                if (int_4 > int_3 - MapAsset.aBuffer1.offset) {
                  int_4 = int_3 - MapAsset.aBuffer1.offset;
                }

                if (int_4 > int_2) {
                  int_4 = int_2;
                }

                RemoteAssetRequestor.aSocketStream2.read(MapAsset.aBuffer1.bytes, MapAsset.aBuffer1.offset, int_4);
                if (RemoteAssetRequestor.aByte1 != 0) {
                  for (int_5 = 0; int_5 < int_4; int_5++) {
                    MapAsset.aBuffer1.bytes[int_5 + MapAsset.aBuffer1.offset] ^= RemoteAssetRequestor.aByte1;
                  }
                }

                MapAsset.aBuffer1.offset += int_4;
                RemoteAssetRequestor.anInt197 += int_4;
                if (int_3 == MapAsset.aBuffer1.offset) {
                  if (RemoteAssetRequestor.current.hash == 0xff00ffL) {
                    Class55.releaseManifest = MapAsset.aBuffer1;

                    for (int_5 = 0; int_5 < 256; int_5++) {
                      final Package requestor = RemoteAssetRequestor.requestors[int_5];
                      if (requestor != null) {
                        Class55.releaseManifest.offset = int_5 * 8 + 5;
                        checksum = Class55.releaseManifest.getInt();
                        final int version = Class55.releaseManifest.getInt();
                        requestor.setBuild(checksum, version);
                      }
                    }
                  } else {
                    RemoteAssetRequestor.aCRC32_1.reset();
                    RemoteAssetRequestor.aCRC32_1.update(MapAsset.aBuffer1.bytes, 0, int_3);
                    int_5 = (int) RemoteAssetRequestor.aCRC32_1.getValue();
                    if (int_5 != RemoteAssetRequestor.current.checksum) {
                      try {
                        RemoteAssetRequestor.aSocketStream2.close();
                      } catch (final Exception exception_1) {
                      }

                      ++RemoteAssetRequestor.anInt190;
                      RemoteAssetRequestor.aSocketStream2 = null;
                      RemoteAssetRequestor.aByte1 = (byte) (int) (Math.random() * 255.0D + 1.0D);
                      bool_0 = false;
                      break label245;
                    }

                    RemoteAssetRequestor.anInt190 = 0;
                    RemoteAssetRequestor.anInt192 = 0;
                    RemoteAssetRequestor.current.index.method608(
                        (int) (RemoteAssetRequestor.current.hash & 0xFFFFL), MapAsset.aBuffer1.bytes,
                        (RemoteAssetRequestor.current.hash & 0xFF0000L) == 16711680L,
                        RemoteAssetRequestor.aBool23);
                  }

                  RemoteAssetRequestor.current.unlink();
                  if (RemoteAssetRequestor.aBool23) {
                    --RemoteAssetRequestor.anInt194;
                  } else {
                    --RemoteAssetRequestor.anInt196;
                  }

                  RemoteAssetRequestor.anInt197 = 0;
                  RemoteAssetRequestor.current = null;
                  MapAsset.aBuffer1 = null;
                } else {
                  if (RemoteAssetRequestor.anInt197 != 512) {
                    break;
                  }

                  RemoteAssetRequestor.anInt197 = 0;
                }
              }
            }

            bool_0 = true;
          }
        } catch (final IOException ioexception_0) {
          try {
            RemoteAssetRequestor.aSocketStream2.close();
          } catch (final Exception exception_0) {
          }

          ++RemoteAssetRequestor.anInt192;
          RemoteAssetRequestor.aSocketStream2 = null;
          bool_0 = false;
        }
      }

      if (!bool_0) {
        method1057();
      }
    }
  }

  void method1053() {
    int int_0 = Stub.canvasWidth;
    int int_1 = Class34.canvasHeight;
    if (super.anInt573 < int_0) {
      int_0 = super.anInt573;
    }

    if (super.anInt576 < int_1) {
      int_1 = super.anInt576;
    }

    if (LongVariable.preferences != null) {
      try {
        Class21.method205(Enum1.clientInstance, "resize",
            new Object[] {Integer.valueOf(Class45.method287())});
      } catch (final Throwable throwable_0) {
        return;
      }
    }

  }

  @Override
  protected final void method1029() {
    if (LocalInstall.chatMessages.changed()) {
      LocalInstall.chatMessages.serialize();
    }

    if (ScriptExecutor.aClass19_1 != null) {
      ScriptExecutor.aClass19_1.aBool6 = false;
    }

    ScriptExecutor.aClass19_1 = null;
    if (VertexNormal.stream != null) {
      VertexNormal.stream.close();
      VertexNormal.stream = null;
    }

    WorldMapType3.method566();
    CanvasWrapper.method715();
    RemoteRequest.anInterface3_1 = null;
    if (ScriptExecutor.soundSystem0 != null) {
      ScriptExecutor.soundSystem0.method359();
    }

    if (WorldMapType1.soundSystem1 != null) {
      WorldMapType1.soundSystem1.method359();
    }

    SceneTilePaint.method344();
    Class89.method494();
    if (Class40.aClass24_1 != null) {
      Class40.aClass24_1.method216();
      Class40.aClass24_1 = null;
    }

    World.method546();
  }

  @Override
  protected final void method1030() {
    Class103.anInt201 = socketType == 0 ? 43594 : world + 40000;
    Class29.anInt81 = socketType == 0 ? 443 : world + 50000;
    OpenedInterface.myWorldPort = Class103.anInt201;
    PlayerIdentity.colorsToFind = Identity.aShortArray1;
    PlayerIdentity.colorsToReplace = Identity.aShortArrayArray1;
    PlayerIdentity.aShortArray4 = Identity.aShortArray2;
    PlayerIdentity.aShortArrayArray3 = Identity.aShortArrayArray2;
    Class40.aClass24_1 = new Class24();
    method1035();
    method1036();
    RemoteRequest.anInterface3_1 = method1037();
    ClanMember.anIndexFile3 = new FileCache(255, LocalInstall.aCacheFile2, LocalInstall.aCacheFile3, 500000);
    FileOnDisk fileondisk_0 = null;
    Preferences preferences_0 = new Preferences();

    try {
      fileondisk_0 = Class35.getPreferencesFile("", Class12.game.aString20, false);
      final byte[] bytes_0 = new byte[(int) fileondisk_0.length()];

      int int_1;
      for (int int_0 = 0; int_0 < bytes_0.length; int_0 += int_1) {
        int_1 = fileondisk_0.read(bytes_0, int_0, bytes_0.length - int_0);
        if (int_1 == -1) {
          throw new IOException();
        }
      }

      preferences_0 = new Preferences(new Buffer(bytes_0));
    } catch (final Exception exception_0) {
    }

    try {
      if (fileondisk_0 != null) {
        fileondisk_0.close();
      }
    } catch (final Exception exception_1) {
    }

    LongVariable.preferences = preferences_0;
    method1040();
    final String string_0 = Class22.aString4;
    Class25.anApplet1 = this;
    Class25.aString5 = string_0;
    if (socketType != 0) {
      displayFps = true;
    }

    final int int_2 = LongVariable.preferences.windowMode;
    aLong25 = 0L;
    if (int_2 >= 2) {
      isResized = true;
    } else {
      isResized = false;
    }

    if (Class45.method287() == 1) {
      Enum1.clientInstance.method1041(765, 503);
    } else {
      Enum1.clientInstance.method1041(7680, 2160);
    }

    if (state >= 25) {
      Class51.method327();
    }

  }

  final void method1054(final boolean bool_0) {
    InterfaceComponent.method587(widgetRoot, Stub.canvasWidth, Class34.canvasHeight, bool_0);
  }

  void error(final int int_0) {
    socket = null;
    FontType.stream = null;
    js5State = 0;
    if (OpenedInterface.myWorldPort == Class103.anInt201) {
      OpenedInterface.myWorldPort = Class29.anInt81;
    } else {
      OpenedInterface.myWorldPort = Class103.anInt201;
    }

    ++anInt602;
    if (anInt602 >= 2 && (int_0 == 7 || int_0 == 9)) {
      if (state > 5) {
        anInt599 = 3000;
        return;
      }

      this.error("js5connect_full");
      state = 1000;
    } else {
      if (anInt602 >= 2 && int_0 == 6) {
        this.error("js5connect_outofdate");
        state = 1000;
        return;
      }

      if (anInt602 >= 4) {
        if (state <= 5) {
          this.error("js5connect");
          state = 1000;
          return;
        }

        anInt599 = 3000;
        return;
      }
    }

  }

  final boolean method1055() {
    final int int_0 = menuOptionCount - 1;
    if (menuOptionCount > 2) {
      if (anInt598 != 1 || aBoolArray11[int_0]) {
        boolean bool_0;
        if (int_0 < 0) {
          bool_0 = false;
        } else {
          int int_1 = menuTypes[int_0];
          if (int_1 >= 2000) {
            int_1 -= 2000;
          }

          if (int_1 == 1007) {
            bool_0 = true;
          } else {
            bool_0 = false;
          }
        }

        if (!bool_0) {
          return false;
        }
      }

      return true;
    }
    return false;
  }

  @Override
  protected final void method1033() {
  }

  final boolean processServerPacket() {
    if (VertexNormal.stream == null) {
      return false;
    }
    int int_2;
    String string_1;
    try {
      int int_0 = VertexNormal.stream.available();
      if (int_0 == 0) {
        return false;
      }

      if (packetType == -1) {
        VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 1);
        secretPacketBuffer2.offset = 0;
        packetType = secretPacketBuffer2.getDecipheredByte();
        packetLength = Packets.INBOUND_LENGTHS[packetType];
        --int_0;
      }

      if (packetLength == -1) {
        if (int_0 <= 0) {
          return false;
        }

        VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 1);
        packetLength = secretPacketBuffer2.bytes[0] & 0xFF;
        --int_0;
      }

      if (packetLength == -2) {
        if (int_0 <= 1) {
          return false;
        }

        VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 2);
        secretPacketBuffer2.offset = 0;
        packetLength = secretPacketBuffer2.getUnsignedShort();
        int_0 -= 2;
      }

      if (int_0 < packetLength) {
        return false;
      }

      secretPacketBuffer2.offset = 0;
      VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, packetLength);
      anInt633 = 0;
      thridLastFrameId = secondLastFrameId;
      secondLastFrameId = lastFrameId;
      lastFrameId = packetType;
      int int_1;
      if (packetType == 78) {
        aBool87 = false;

        for (int_1 = 0; int_1 < 5; int_1++) {
          aBoolArray12[int_1] = false;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 247) {
        anInt687 = 1;
        anInt646 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 56) {
        for (int_1 = 0; int_1 < cachedPlayers.length; int_1++) {
          if (cachedPlayers[int_1] != null) {
            cachedPlayers[int_1].animation = -1;
          }
        }

        for (int_1 = 0; int_1 < cachedNPCs.length; int_1++) {
          if (cachedNPCs[int_1] != null) {
            cachedNPCs[int_1].animation = -1;
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 18) {
        IntegerVariable.method246(secretPacketBuffer2, packetLength);
        packetType = -1;
        return true;
      }

      if (packetType == 223) {
        Class11.method160();

        for (int_1 = 0; int_1 < 2048; int_1++) {
          cachedPlayers[int_1] = null;
        }

        Materials.initializeGPI(secretPacketBuffer2);
        packetType = -1;
        return true;
      }

      if (packetType == 135) {
        for (int_1 = 0; int_1 < variableCount; int_1++) {
          final PlayerVariable varplayertype_0 = Class64.method406(int_1);
          if (varplayertype_0 != null) {
            Class85.settings[int_1] = 0;
            Class85.widgetSettings[int_1] = 0;
          }
        }

        CollisionData.method572();
        anInt637 += 32;
        packetType = -1;
        return true;
      }

      if (packetType == 5) {
        Class4.method123();
        packetType = -1;
        return false;
      }

      if (packetType == 4) {
        for (int_1 = 0; int_1 < Class85.widgetSettings.length; int_1++) {
          if (Class85.settings[int_1] != Class85.widgetSettings[int_1]) {
            Class85.widgetSettings[int_1] = Class85.settings[int_1];
            Class35.method255(int_1);
            anIntArray143[++anInt637 - 1 & 0x1F] = int_1;
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 51) {
        Class24.method219(secretPacketBuffer2, packetLength);
        packetType = -1;
        return true;
      }

      if (packetType == 58) {
        if (widgetRoot != -1) {
          Friend.method522(widgetRoot, 0);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 65) {
        anInt644 = secretPacketBuffer2.getUnsignedByte();
        packetType = -1;
        return true;
      }

      if (packetType == 164) {
        anInt593 = secretPacketBuffer2.getUnsignedShortAdd() * 30;
        anInt639 = cycleCntr;
        packetType = -1;
        return true;
      }

      int int_5;
      if (packetType == 129) {
        int_2 = secretPacketBuffer2.getUnsignedByte();
        final Class104[] class104s_0 = new Class104[] {
            Class104.TWO, Class104.ONE,
            Class104.ZERO
        };
        final Class104[] class104s_1 = class104s_0;
        int_5 = 0;

        Class104 class104_0;
        while (true) {
          if (int_5 >= class104s_1.length) {
            class104_0 = null;
            break;
          }

          final Class104 class104_1 = class104s_1[int_5];
          if (int_2 == class104_1.anInt202) {
            class104_0 = class104_1;
            break;
          }

          ++int_5;
        }

        Projectile.aClass104_4 = class104_0;
        packetType = -1;
        return true;
      }

      if (packetType == 253) {
        int_1 = secretPacketBuffer2.getImeInt();
        Class24.aTask1 = Stub.taskManager.createHost(int_1);
        packetType = -1;
        return true;
      }

      int int_3;
      if (packetType == 239) {
        int_1 = secretPacketBuffer2.getUnsignedShort();
        if (int_1 == 65535) {
          int_1 = -1;
        }

        if (int_1 == -1 && !aBool81) {
          Class72.anAClass4_Sub3_1.method790();
          Class72.anInt168 = 1;
          Class72.anIndexDataBase4 = null;
        } else if (int_1 != -1 && int_1 != anInt613 && anInt656 != 0 && !aBool81) {
          final Package indexdata_0 = CacheableNode_Sub4.indexTrack1;
          int_3 = anInt656;
          Class72.anInt168 = 1;
          Class72.anIndexDataBase4 = indexdata_0;
          Enum3.anInt339 = int_1;
          RuntimeException_Sub1.anInt527 = 0;
          Class72.anInt170 = int_3;
          Class36.aBool8 = false;
          Class72.anInt169 = 2;
        }

        anInt613 = int_1;
        packetType = -1;
        return true;
      }

      if (packetType == 169) {
        int_1 = secretPacketBuffer2.getUnsignedLeShort();
        Keyboard.method340(int_1);
        interfaceItemTriggers[++anInt641 - 1 & 0x1F] = int_1 & 0x7FFF;
        packetType = -1;
        return true;
      }

      InterfaceComponent widget_0;
      if (packetType == 249) {
        int_1 = secretPacketBuffer2.getInt();
        widget_0 = ScriptExecutor.method240(int_1);

        for (int_3 = 0; int_3 < widget_0.itemIds.length; int_3++) {
          widget_0.itemIds[int_3] = -1;
          widget_0.itemIds[int_3] = 0;
        }

        Class28.method236(widget_0);
        packetType = -1;
        return true;
      }

      if (packetType == 68) {
        int_1 = secretPacketBuffer2.getLeInt();
        widget_0 = ScriptExecutor.method240(int_1);
        widget_0.modelType = 3;
        widget_0.modelId = GrandExchangeOffer.localPlayer.composition.method502();
        Class28.method236(widget_0);
        packetType = -1;
        return true;
      }

      if (packetType == 101) {
        CollisionData.method572();
        energy = secretPacketBuffer2.getUnsignedByte();
        anInt639 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 25) {
        CollisionData.method572();
        weight = secretPacketBuffer2.getShort();
        anInt639 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 179) {
        int_1 = secretPacketBuffer2.getInt();
        final OpenedInterface widgetnode_1 = (OpenedInterface) componentTable.get(int_1);
        if (widgetnode_1 != null) {
          Comparator0.method305(widgetnode_1, true);
        }

        if (aWidget13 != null) {
          Class28.method236(aWidget13);
          aWidget13 = null;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 112) {
        int_1 = secretPacketBuffer2.getUnsignedLeShortAdd();
        widgetRoot = int_1;
        method1054(false);
        Class66.method411(int_1);
        AClass4_Sub3.method818(widgetRoot);

        for (int_2 = 0; int_2 < 100; int_2++) {
          aBoolArray8[int_2] = true;
        }

        packetType = -1;
        return true;
      }

      String string_0;
      if (packetType == 74) {
        string_1 = secretPacketBuffer2.getString();
        string_0 = AbstractFont
            .appendTags(PlayerVariable.method906(Enum5.method664(secretPacketBuffer2)));
        Npc.sendGameMessage(6, string_1, string_0);
        packetType = -1;
        return true;
      }

      String string_3;
      String string_7;
      if (packetType == 217) {
        string_1 = secretPacketBuffer2.getString();
        sessionToken = string_1;

        try {
          string_0 = Enum1.clientInstance.getParameter(Parameter.PARAMETER_11.key);
          string_3 = Enum1.clientInstance.getParameter(Parameter.PARAMETER_3.key);
          string_7 = string_0 + "settings=" + string_1 + "; version=1; path=/; domain=" + string_3;
          if (string_1.length() == 0) {
            string_7 = string_7 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
          } else {
            string_7 = string_7 + "; Expires="
                + Timestamp.get(Time.currentTimeMillis() + 94608000000L) + "; Max-Age="
                + 94608000L;
          }

          final Client client_1 = Enum1.clientInstance;
          final String string_5 = "document.cookie=\"" + string_7 + "\"";
          JSObject.getWindow(client_1).eval(string_5);
        } catch (final Throwable throwable_0) {
        }

        packetType = -1;
        return true;
      }

      if (packetType == 98) {
        secretPacketBuffer2.offset += 28;
        if (secretPacketBuffer2.validate()) {
          final GameBuffer packetbuffer_0 = secretPacketBuffer2;
          int_2 = secretPacketBuffer2.offset - 28;
          Square.method661(packetbuffer_0.bytes, int_2);
          if (LocalInstall.random != null) {
            try {
              LocalInstall.random.seek(0L);
              LocalInstall.random.write(packetbuffer_0.bytes, int_2, 24);
            } catch (final Exception exception_1) {
            }
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 42) {
        int_1 = secretPacketBuffer2.getUnsignedShort();
        final byte byte_2 = secretPacketBuffer2.getByteSub();
        Class85.settings[int_1] = byte_2;
        if (Class85.widgetSettings[int_1] != byte_2) {
          Class85.widgetSettings[int_1] = byte_2;
        }

        Class35.method255(int_1);
        anIntArray143[++anInt637 - 1 & 0x1F] = int_1;
        packetType = -1;
        return true;
      }

      if (packetType == 96) {
        Class1.anInt14 = secretPacketBuffer2.getUnsignedByteSub();
        Materials.anInt214 = secretPacketBuffer2.getUnsignedByte();
        packetType = -1;
        return true;
      }

      if (packetType == 31) {
        anInt673 = secretPacketBuffer2.getUnsignedByte();
        anInt677 = secretPacketBuffer2.getUnsignedByte();
        packetType = -1;
        return true;
      }

      if (packetType == 216) {
        destinationX = secretPacketBuffer2.getUnsignedByte();
        if (destinationX == 255) {
          destinationX = 0;
        }

        destinationY = secretPacketBuffer2.getUnsignedByte();
        if (destinationY == 255) {
          destinationY = 0;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 83) {
        int_1 = secretPacketBuffer2.getUnsignedLeMedium();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        if (int_2 == 65535) {
          int_2 = -1;
        }

        if (anInt656 != 0 && int_2 != -1) {
          Class23.method212(State.indexTrack2, int_2, 0, anInt656, false);
          aBool81 = true;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 254) {
        int_1 = secretPacketBuffer2.getUnsignedByte();
        if (secretPacketBuffer2.getUnsignedByte() == 0) {
          grandExchangeOffers[int_1] = new GrandExchangeOffer();
          secretPacketBuffer2.offset += 18;
        } else {
          --secretPacketBuffer2.offset;
          grandExchangeOffers[int_1] = new GrandExchangeOffer(secretPacketBuffer2, false);
        }

        anInt664 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 71) {
        int_1 = secretPacketBuffer2.getInt();
        int_2 = secretPacketBuffer2.getInt();
        int_3 = Class44.method285();
        outbound.putEncipheredByte(40);
        outbound.putLeInt(int_1);
        outbound.putLeInt(int_2);
        outbound.putByteNegate(Stub.FPS);
        outbound.putByteAdd(int_3);
        packetType = -1;
        return true;
      }

      int int_4;
      int int_6;
      if (packetType == 191) {
        int_1 = secretPacketBuffer2.getUnsignedLeShort();
        int_2 = secretPacketBuffer2.getMeInt();
        int_3 = int_1 >> 10 & 0x1F;
        int_4 = int_1 >> 5 & 0x1F;
        int_5 = int_1 & 0x1F;
        int_6 = (int_4 << 11) + (int_3 << 19) + (int_5 << 3);
        final InterfaceComponent widget_2 = ScriptExecutor.method240(int_2);
        if (int_6 != widget_2.textColor) {
          widget_2.textColor = int_6;
          Class28.method236(widget_2);
        }

        packetType = -1;
        return true;
      }

      boolean bool_6;
      InterfaceComponent widget_3;
      if (packetType == 140) {
        int_1 = secretPacketBuffer2.getInt();
        bool_6 = secretPacketBuffer2.getUnsignedByteSub() == 1;
        widget_3 = ScriptExecutor.method240(int_1);
        if (bool_6 != widget_3.isHidden) {
          widget_3.isHidden = bool_6;
          Class28.method236(widget_3);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 77) {
        int_1 = secretPacketBuffer2.getMeInt();
        int_2 = secretPacketBuffer2.getLeShortAdd();
        widget_3 = ScriptExecutor.method240(int_1);
        if (int_2 != widget_3.anInt266 || int_2 == -1) {
          widget_3.anInt266 = int_2;
          widget_3.anInt272 = 0;
          widget_3.anInt271 = 0;
          Class28.method236(widget_3);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 244) {
        int_1 = secretPacketBuffer2.getUnsignedLeShort();
        int_2 = secretPacketBuffer2.getInt();
        widget_3 = ScriptExecutor.method240(int_2);
        if (widget_3.modelType != 2 || int_1 != widget_3.modelId) {
          widget_3.modelType = 2;
          widget_3.modelId = int_1;
          Class28.method236(widget_3);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 219) {
        int_1 = secretPacketBuffer2.getUnsignedLeShort();
        int_2 = secretPacketBuffer2.getImeInt();
        widget_3 = ScriptExecutor.method240(int_2);
        if (widget_3.modelType != 1 || int_1 != widget_3.modelId) {
          widget_3.modelType = 1;
          widget_3.modelId = int_1;
          Class28.method236(widget_3);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 208) {
        int_1 = secretPacketBuffer2.getMeInt();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        widget_3 = ScriptExecutor.method240(int_1);
        if (widget_3 != null && widget_3.type == 0) {
          if (int_2 > widget_3.scrollHeight - widget_3.height) {
            int_2 = widget_3.scrollHeight - widget_3.height;
          }

          if (int_2 < 0) {
            int_2 = 0;
          }

          if (int_2 != widget_3.scrollY) {
            widget_3.scrollY = int_2;
            Class28.method236(widget_3);
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 102) {
        Materials.anInt214 = secretPacketBuffer2.getUnsignedByteNegate();
        Class1.anInt14 = secretPacketBuffer2.getUnsignedByteSub();

        for (int_1 = Materials.anInt214; int_1 < Materials.anInt214 + 8; int_1++) {
          for (int_2 = Class1.anInt14; int_2 < Class1.anInt14 + 8; int_2++) {
            if (groundItemDeque[Class12.plane][int_1][int_2] != null) {
              groundItemDeque[Class12.plane][int_1][int_2] = null;
              AClass4_Sub4.groundItemSpawned(int_1, int_2);
            }
          }
        }

        for (PendingSpawn pendingspawn_0 = (PendingSpawn) pendingSpawns
            .getFirst(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) pendingSpawns
            .getNext()) {
          if (pendingspawn_0.x >= Materials.anInt214
              && pendingspawn_0.x < Materials.anInt214 + 8
              && pendingspawn_0.y >= Class1.anInt14 && pendingspawn_0.y < Class1.anInt14 + 8
              && pendingspawn_0.level == Class12.plane) {
            pendingspawn_0.hitpoints = 0;
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 242) {
        int_1 = secretPacketBuffer2.getMeInt();
        int_2 = secretPacketBuffer2.getUnsignedLeShortAdd();
        Class85.settings[int_2] = int_1;
        if (Class85.widgetSettings[int_2] != int_1) {
          Class85.widgetSettings[int_2] = int_1;
        }

        Class35.method255(int_2);
        anIntArray143[++anInt637 - 1 & 0x1F] = int_2;
        packetType = -1;
        return true;
      }

      OpenedInterface widgetnode_0;
      InterfaceComponent widget_4;
      if (packetType == 109) {
        int_1 = secretPacketBuffer2.getInt();
        int_2 = secretPacketBuffer2.getInt();
        final OpenedInterface widgetnode_5 = (OpenedInterface) componentTable.get(int_1);
        widgetnode_0 = (OpenedInterface) componentTable.get(int_2);
        if (widgetnode_0 != null) {
          Comparator0.method305(widgetnode_0,
              widgetnode_5 == null || widgetnode_5.id != widgetnode_0.id);
        }

        if (widgetnode_5 != null) {
          widgetnode_5.unlink();
          componentTable.put(widgetnode_5, int_2);
        }

        widget_4 = ScriptExecutor.method240(int_1);
        if (widget_4 != null) {
          Class28.method236(widget_4);
        }

        widget_4 = ScriptExecutor.method240(int_2);
        if (widget_4 != null) {
          Class28.method236(widget_4);
          JavaxSourceDataLineProvider.method190(Time.widgets[widget_4.id >>> 16], widget_4, true);
        }

        if (widgetRoot != -1) {
          Friend.method522(widgetRoot, 1);
        }

        packetType = -1;
        return true;
      }

      boolean bool_5;
      if (packetType == 172) {
        bool_5 = secretPacketBuffer2.getUnsignedByte() == 1;
        if (bool_5) {
          Class10.aLong1 = Time.currentTimeMillis() - secretPacketBuffer2.getLong();
          Class22.aClass45_1 = new Class45(secretPacketBuffer2, true);
        } else {
          Class22.aClass45_1 = null;
        }

        anInt688 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 200) {
        string_1 = secretPacketBuffer2.getString();
        int_2 = secretPacketBuffer2.getInt();
        widget_3 = ScriptExecutor.method240(int_2);
        if (!string_1.equals(widget_3.text)) {
          widget_3.text = string_1;
          Class28.method236(widget_3);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 187) {
        int_1 = secretPacketBuffer2.getUnsignedShort();
        int_2 = secretPacketBuffer2.getUnsignedByte();
        int_3 = secretPacketBuffer2.getUnsignedShort();
        IntegerVariable.method245(int_1, int_2, int_3);
        packetType = -1;
        return true;
      }

      InterfaceComponent widget_5;
      if (packetType == 52) {
        int_1 = secretPacketBuffer2.getLeInt();
        int_2 = secretPacketBuffer2.getUnsignedShortAdd();
        int_3 = secretPacketBuffer2.getUnsignedLeShortAdd();
        widget_5 = ScriptExecutor.method240(int_1);
        widget_5.anInt270 = int_3 + (int_2 << 16);
        packetType = -1;
        return true;
      }

      if (packetType == 82) {
        CollisionData.method572();
        int_1 = secretPacketBuffer2.getUnsignedByteAdd();
        int_2 = secretPacketBuffer2.getUnsignedByteSub();
        int_3 = secretPacketBuffer2.getLeInt();
        skillExperiences[int_1] = int_3;
        boostedSkillLevels[int_1] = int_2;
        realSkillLevels[int_1] = 1;

        for (int_4 = 0; int_4 < 98; int_4++) {
          if (int_3 >= Skills.EXPERIENCE[int_4]) {
            realSkillLevels[int_1] = int_4 + 2;
          }
        }

        anIntArray144[++anInt645 - 1 & 0x1F] = int_1;
        packetType = -1;
        return true;
      }

      if (packetType == 12) {
        int_1 = secretPacketBuffer2.getLeShortAdd();
        int_2 = secretPacketBuffer2.getImeInt();
        int_3 = secretPacketBuffer2.getLeShort();
        widget_5 = ScriptExecutor.method240(int_2);
        if (int_1 != widget_5.originalX || int_3 != widget_5.originalY || widget_5.anInt261
            != 0
            || widget_5.anInt264 != 0) {
          widget_5.originalX = int_1;
          widget_5.originalY = int_3;
          widget_5.anInt261 = 0;
          widget_5.anInt264 = 0;
          Class28.method236(widget_5);
          method1061(widget_5);
          if (widget_5.type == 0) {
            JavaxSourceDataLineProvider.method190(Time.widgets[int_2 >> 16], widget_5, false);
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 60) {
        int_1 = secretPacketBuffer2.getLeInt();
        int_2 = secretPacketBuffer2.getUnsignedLeShortAdd();
        if (int_2 == 65535) {
          int_2 = -1;
        }

        int_3 = secretPacketBuffer2.getInt();
        widget_5 = ScriptExecutor.method240(int_3);
        ItemConfig itemcomposition_0;
        if (!widget_5.hasScript) {
          if (int_2 == -1) {
            widget_5.modelType = 0;
            packetType = -1;
            return true;
          }

          itemcomposition_0 = AudioWorker.getItemDefinition(int_2);
          widget_5.modelType = 4;
          widget_5.modelId = int_2;
          widget_5.rotationX = itemcomposition_0.xan2d;
          widget_5.rotationZ = itemcomposition_0.yan2d;
          widget_5.modelZoom = itemcomposition_0.zoom2d * 100 / int_1;
          Class28.method236(widget_5);
        } else {
          widget_5.itemId = int_2;
          widget_5.itemQuantity = int_1;
          itemcomposition_0 = AudioWorker.getItemDefinition(int_2);
          widget_5.rotationX = itemcomposition_0.xan2d;
          widget_5.rotationZ = itemcomposition_0.yan2d;
          widget_5.rotationY = itemcomposition_0.zan2d;
          widget_5.anInt284 = itemcomposition_0.offsetX2d;
          widget_5.anInt285 = itemcomposition_0.offsetY2d;
          widget_5.modelZoom = itemcomposition_0.zoom2d;
          if (itemcomposition_0.isStackable == 1) {
            widget_5.anInt287 = 1;
          } else {
            widget_5.anInt287 = 2;
          }

          if (widget_5.anInt286 > 0) {
            widget_5.modelZoom = widget_5.modelZoom * 32 / widget_5.anInt286;
          } else if (widget_5.originalWidth > 0) {
            widget_5.modelZoom = widget_5.modelZoom * 32 / widget_5.originalWidth;
          }

          Class28.method236(widget_5);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 176) {
        int_1 = secretPacketBuffer2.getUnsignedByteNegate();
        int_2 = secretPacketBuffer2.getInt();
        int_3 = secretPacketBuffer2.getUnsignedShortAdd();
        widgetnode_0 = (OpenedInterface) componentTable.get(int_2);
        if (widgetnode_0 != null) {
          Comparator0.method305(widgetnode_0, int_3 != widgetnode_0.id);
        }

        final OpenedInterface widgetnode_3 = new OpenedInterface();
        widgetnode_3.id = int_3;
        widgetnode_3.owner = int_1;
        componentTable.put(widgetnode_3, int_2);
        Class66.method411(int_3);
        final InterfaceComponent widget_1 = ScriptExecutor.method240(int_2);
        Class28.method236(widget_1);
        if (aWidget13 != null) {
          Class28.method236(aWidget13);
          aWidget13 = null;
        }

        AClass2_Sub1.method616();
        JavaxSourceDataLineProvider.method190(Time.widgets[int_2 >> 16], widget_1, false);
        AClass4_Sub3.method818(int_3);
        if (widgetRoot != -1) {
          Friend.method522(widgetRoot, 1);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 177) {
        int_1 = secretPacketBuffer2.getUnsignedByte();
        int_2 = secretPacketBuffer2.getUnsignedByteNegate();
        string_3 = secretPacketBuffer2.getString();
        if (int_2 >= 1 && int_2 <= 8) {
          if (string_3.equalsIgnoreCase("null")) {
            string_3 = null;
          }

          playerOptions[int_2 - 1] = string_3;
          playerOptionsPriorities[int_2 - 1] = int_1 == 0;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 75) {
        final World world_0 = new World();
        world_0.address = secretPacketBuffer2.getString();
        world_0.id = secretPacketBuffer2.getUnsignedShort();
        int_2 = secretPacketBuffer2.getInt();
        world_0.mask = int_2;
        Mouse.setGameState(45);
        VertexNormal.stream.close();
        VertexNormal.stream = null;
        AudioWorker.method338(world_0);
        packetType = -1;
        return false;
      }

      boolean bool_7;
      boolean bool_8;
      int int_10;
      if (packetType == 167) {
        string_1 = secretPacketBuffer2.getString();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        final byte byte_1 = secretPacketBuffer2.getByte();
        bool_7 = false;
        if (byte_1 == -128) {
          bool_7 = true;
        }

        if (bool_7) {
          if (Node_Sub1.clanChatCount == 0) {
            packetType = -1;
            return true;
          }

          bool_8 = false;

          for (int_5 = 0; int_5 < Node_Sub1.clanChatCount
              && (!AClass1.clanMembers[int_5].username.equals(string_1)
              || int_2 != AClass1.clanMembers[int_5].world); int_5++) {
          }

          if (int_5 < Node_Sub1.clanChatCount) {
            while (int_5 < Node_Sub1.clanChatCount - 1) {
              AClass1.clanMembers[int_5] = AClass1.clanMembers[int_5 + 1];
              ++int_5;
            }

            --Node_Sub1.clanChatCount;
            AClass1.clanMembers[Node_Sub1.clanChatCount] = null;
          }
        } else {
          secretPacketBuffer2.getString();
          final ClanMember clanmember_1 = new ClanMember();
          clanmember_1.username = string_1;
          clanmember_1.aString19 = FloorUnderlayDefinition.method869(clanmember_1.username,
              AClass1_Sub2.aClass108_10);
          clanmember_1.world = int_2;
          clanmember_1.rank = byte_1;

          for (int_6 = Node_Sub1.clanChatCount - 1; int_6 >= 0; --int_6) {
            int_10 = AClass1.clanMembers[int_6].aString19.compareTo(clanmember_1.aString19);
            if (int_10 == 0) {
              AClass1.clanMembers[int_6].world = int_2;
              AClass1.clanMembers[int_6].rank = byte_1;
              if (string_1.equals(GrandExchangeOffer.localPlayer.name)) {
                ScriptExecutor.clanChatRank = byte_1;
              }

              anInt659 = cycleCntr;
              packetType = -1;
              return true;
            }

            if (int_10 < 0) {
              break;
            }
          }

          if (Node_Sub1.clanChatCount >= AClass1.clanMembers.length) {
            packetType = -1;
            return true;
          }

          for (int_10 = Node_Sub1.clanChatCount - 1; int_10 > int_6; --int_10) {
            AClass1.clanMembers[int_10 + 1] = AClass1.clanMembers[int_10];
          }

          if (Node_Sub1.clanChatCount == 0) {
            AClass1.clanMembers = new ClanMember[100];
          }

          AClass1.clanMembers[int_6 + 1] = clanmember_1;
          ++Node_Sub1.clanChatCount;
          if (string_1.equals(GrandExchangeOffer.localPlayer.name)) {
            ScriptExecutor.clanChatRank = byte_1;
          }
        }

        anInt659 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 114) {
        int_1 = secretPacketBuffer2.getUnsignedByte();
        int_2 = secretPacketBuffer2.getUnsignedByte();
        int_3 = secretPacketBuffer2.getUnsignedByte();
        int_4 = secretPacketBuffer2.getUnsignedByte();
        aBoolArray12[int_1] = true;
        anIntArray161[int_1] = int_2;
        anIntArray153[int_1] = int_3;
        anIntArray162[int_1] = int_4;
        anIntArray164[int_1] = 0;
        packetType = -1;
        return true;
      }

      long long_5;
      if (packetType == 22) {
        int_1 = secretPacketBuffer2.getInt();
        int_2 = secretPacketBuffer2.getUnsignedLeShortAdd();
        if (int_2 == 65535) {
          int_2 = -1;
        }

        int_3 = secretPacketBuffer2.getUnsignedShortAdd();
        if (int_3 == 65535) {
          int_3 = -1;
        }

        int_4 = secretPacketBuffer2.getImeInt();

        for (int_5 = int_2; int_5 <= int_3; int_5++) {
          long_5 = int_5 + ((long) int_4 << 32);
          final Node node_0 = widgetFlags.get(long_5);
          if (node_0 != null) {
            node_0.unlink();
          }

          widgetFlags.put(new IntegerNode(int_1), long_5);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 14) {
        int_1 = secretPacketBuffer2.getUnsignedLeShort();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        int_3 = secretPacketBuffer2.getUnsignedShortAdd();
        int_4 = secretPacketBuffer2.getInt();
        widget_4 = ScriptExecutor.method240(int_4);
        if (int_1 != widget_4.rotationX || int_2 != widget_4.rotationZ
            || int_3 != widget_4.modelZoom) {
          widget_4.rotationX = int_1;
          widget_4.rotationZ = int_2;
          widget_4.modelZoom = int_3;
          Class28.method236(widget_4);
        }

        packetType = -1;
        return true;
      }

      long long_0;
      long long_1;
      if (packetType == 41) {
        string_1 = secretPacketBuffer2.getString();
        long_0 = secretPacketBuffer2.getUnsignedShort();
        long_1 = secretPacketBuffer2.getUnsignedMedium();
        final UserGroup[] permissions_1 = new UserGroup[] {
            UserGroup.USER_GROUP_3,
            UserGroup.USER_GROUP_5, UserGroup.USER_GROUP_1, UserGroup.USER_GROUP_4,
            UserGroup.USER_GROUP_2, UserGroup.USER_GROUP_0
        };
        final UserGroup permission_0 = (UserGroup) PlayerIdentity.forOrdinal(permissions_1,
            secretPacketBuffer2.getUnsignedByte());
        final long long_2 = (long_0 << 32) + long_1;
        boolean bool_0 = false;

        for (int int_9 = 0; int_9 < 100; int_9++) {
          if (aLongArray4[int_9] == long_2) {
            bool_0 = true;
            break;
          }
        }

        if (Enum1.isIgnored(string_1)) {
          bool_0 = true;
        }

        if (!bool_0 && anInt655 == 0) {
          aLongArray4[anInt657] = long_2;
          anInt657 = (anInt657 + 1) % 100;
          final String string_2 = AbstractFont
              .appendTags(PlayerVariable.method906(Enum5.method664(secretPacketBuffer2)));
          byte byte_0;
          if (permission_0.aBool38) {
            byte_0 = 7;
          } else {
            byte_0 = 3;
          }

          if (permission_0.anInt292 != -1) {
            Npc.sendGameMessage(byte_0, Class46.method292(permission_0.anInt292) + string_1,
                string_2);
          } else {
            Npc.sendGameMessage(byte_0, string_1, string_2);
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 178) {
        int_1 = secretPacketBuffer2.getUnsignedSmartShort();
        bool_6 = secretPacketBuffer2.getUnsignedByte() == 1;
        string_3 = "";
        bool_7 = false;
        if (bool_6) {
          string_3 = secretPacketBuffer2.getString();
          if (Enum1.isIgnored(string_3)) {
            bool_7 = true;
          }
        }

        final String string_6 = secretPacketBuffer2.getString();
        if (!bool_7) {
          Npc.sendGameMessage(int_1, string_3, string_6);
        }

        packetType = -1;
        return true;
      }

      if (packetType == 237) {
        string_1 = secretPacketBuffer2.getString();
        final Object[] objects_0 = new Object[string_1.length() + 1];

        for (int_3 = string_1.length() - 1; int_3 >= 0; --int_3) {
          if (string_1.charAt(int_3) == 115) {
            objects_0[int_3 + 1] = secretPacketBuffer2.getString();
          } else {
            objects_0[int_3 + 1] = new Integer(secretPacketBuffer2.getInt());
          }
        }

        objects_0[0] = new Integer(secretPacketBuffer2.getInt());
        final ScriptCall scriptevent_0 = new ScriptCall();
        scriptevent_0.anObjectArray22 = objects_0;
        Position.execute(scriptevent_0);
        packetType = -1;
        return true;
      }

      if (packetType == 207) {
        while (secretPacketBuffer2.offset < packetLength) {
          int_1 = secretPacketBuffer2.getUnsignedByte();
          bool_6 = (int_1 & 0x1) == 1;
          string_3 = secretPacketBuffer2.getString();
          string_7 = secretPacketBuffer2.getString();
          secretPacketBuffer2.getString();

          for (int_5 = 0; int_5 < ignoreCount; int_5++) {
            final Ignore ignore_0 = ignores[int_5];
            if (bool_6) {
              if (string_7.equals(ignore_0.name)) {
                ignore_0.name = string_3;
                ignore_0.previousName = string_7;
                string_3 = null;
                break;
              }
            } else if (string_3.equals(ignore_0.name)) {
              ignore_0.name = string_3;
              ignore_0.previousName = string_7;
              string_3 = null;
              break;
            }
          }

          if (string_3 != null && ignoreCount < 400) {
            final Ignore ignore_1 = new Ignore();
            ignores[ignoreCount] = ignore_1;
            ignore_1.name = string_3;
            ignore_1.previousName = string_7;
            ++ignoreCount;
          }
        }

        anInt646 = cycleCntr;
        packetType = -1;
        return true;
      }

      if (packetType == 139) {
        aBool87 = true;
        IntegerVariable.anInt85 = secretPacketBuffer2.getUnsignedByte();
        Mouse.anInt256 = secretPacketBuffer2.getUnsignedByte();
        Player.anInt578 = secretPacketBuffer2.getUnsignedShort();
        Inventory.anInt340 = secretPacketBuffer2.getUnsignedByte();
        AClass3_Sub2.anInt399 = secretPacketBuffer2.getUnsignedByte();
        if (AClass3_Sub2.anInt399 >= 100) {
          Isaac.cameraX = IntegerVariable.anInt85 * 128 + 64;
          Class29.cameraY = Mouse.anInt256 * 128 + 64;
          WorldMapData.cameraZ = Class29.getTileHeight(Isaac.cameraX, Class29.cameraY,
              Class12.plane) - Player.anInt578;
        }

        packetType = -1;
        return true;
      }

      if (packetType == 87) {
        aBool87 = true;
        AClass1_Sub2.anInt305 = secretPacketBuffer2.getUnsignedByte();
        Regulator.anInt257 = secretPacketBuffer2.getUnsignedByte();
        Class54.anInt130 = secretPacketBuffer2.getUnsignedShort();
        Class48.anInt97 = secretPacketBuffer2.getUnsignedByte();
        Keyboard.anInt129 = secretPacketBuffer2.getUnsignedByte();
        if (Keyboard.anInt129 >= 100) {
          int_1 = 64 + AClass1_Sub2.anInt305 * 128;
          int_2 = Regulator.anInt257 * 128 + 64;
          int_3 = Class29.getTileHeight(int_1, int_2, Class12.plane) - Class54.anInt130;
          int_4 = int_1 - Isaac.cameraX;
          int_5 = int_3 - WorldMapData.cameraZ;
          int_6 = int_2 - Class29.cameraY;
          int_10 = (int) Math.sqrt(int_6 * int_6 + int_4 * int_4);
          Keyboard.cameraPitch = (int) (Math.atan2(int_5, int_10) * 325.949D) & 0x7FF;
          Boundry.cameraYaw = (int) (Math.atan2(int_4, int_6) * -325.949D) & 0x7FF;
          if (Keyboard.cameraPitch < 128) {
            Keyboard.cameraPitch = 128;
          }

          if (Keyboard.cameraPitch > 383) {
            Keyboard.cameraPitch = 383;
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 24) {
        string_1 = secretPacketBuffer2.getString();
        long_0 = secretPacketBuffer2.getLong();
        long_1 = secretPacketBuffer2.getUnsignedShort();
        long_5 = secretPacketBuffer2.getUnsignedMedium();
        final UserGroup[] permissions_0 = new UserGroup[] {
            UserGroup.USER_GROUP_3,
            UserGroup.USER_GROUP_5, UserGroup.USER_GROUP_1, UserGroup.USER_GROUP_4,
            UserGroup.USER_GROUP_2, UserGroup.USER_GROUP_0
        };
        final UserGroup permission_1 = (UserGroup) PlayerIdentity.forOrdinal(permissions_0,
            secretPacketBuffer2.getUnsignedByte());
        final long long_6 = long_5 + (long_1 << 32);
        boolean bool_2 = false;

        for (int int_7 = 0; int_7 < 100; int_7++) {
          if (aLongArray4[int_7] == long_6) {
            bool_2 = true;
            break;
          }
        }

        if (permission_1.aBool39 && Enum1.isIgnored(string_1)) {
          bool_2 = true;
        }

        if (!bool_2 && anInt655 == 0) {
          aLongArray4[anInt657] = long_6;
          anInt657 = (anInt657 + 1) % 100;
          final String string_4 = AbstractFont
              .appendTags(PlayerVariable.method906(Enum5.method664(secretPacketBuffer2)));
          if (permission_1.anInt292 != -1) {
            Class1.addChatMessage(9, Class46.method292(permission_1.anInt292) + string_1, string_4,
                AClass1_Sub2.method624(long_0));
          } else {
            Class1.addChatMessage(9, string_1, string_4, AClass1_Sub2.method624(long_0));
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 241) {
        anInt614 = secretPacketBuffer2.getUnsignedByte();
        if (anInt614 == 1) {
          anInt616 = secretPacketBuffer2.getUnsignedShort();
        }

        if (anInt614 >= 2 && anInt614 <= 6) {
          if (anInt614 == 2) {
            anInt625 = 64;
            anInt626 = 64;
          }

          if (anInt614 == 3) {
            anInt625 = 0;
            anInt626 = 64;
          }

          if (anInt614 == 4) {
            anInt625 = 128;
            anInt626 = 64;
          }

          if (anInt614 == 5) {
            anInt625 = 64;
            anInt626 = 0;
          }

          if (anInt614 == 6) {
            anInt625 = 64;
            anInt626 = 128;
          }

          anInt614 = 2;
          hintArrowX = secretPacketBuffer2.getUnsignedShort();
          hintArrowY = secretPacketBuffer2.getUnsignedShort();
          hintArrowType = secretPacketBuffer2.getUnsignedByte();
        }

        if (anInt614 == 10) {
          anInt620 = secretPacketBuffer2.getUnsignedShort();
        }

        packetType = -1;
        return true;
      }

      if (packetType == 17) {
        int_1 = secretPacketBuffer2.getInt();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        if (int_1 < -70000) {
          int_2 += 32768;
        }

        if (int_1 >= 0) {
          widget_3 = ScriptExecutor.method240(int_1);
        } else {
          widget_3 = null;
        }

        if (widget_3 != null) {
          for (int_4 = 0; int_4 < widget_3.itemIds.length; int_4++) {
            widget_3.itemIds[int_4] = 0;
            widget_3.itemQuantities[int_4] = 0;
          }
        }

        PlayerVariable.method905(int_2);
        int_4 = secretPacketBuffer2.getUnsignedShort();

        for (int_5 = 0; int_5 < int_4; int_5++) {
          int_6 = secretPacketBuffer2.getUnsignedByteSub();
          if (int_6 == 255) {
            int_6 = secretPacketBuffer2.getImeInt();
          }

          int_10 = secretPacketBuffer2.getUnsignedLeShortAdd();
          if (widget_3 != null && int_5 < widget_3.itemIds.length) {
            widget_3.itemIds[int_5] = int_10;
            widget_3.itemQuantities[int_5] = int_6;
          }

          Boundry.setItemTableSlot(int_2, int_5, int_10 - 1, int_6);
        }

        if (widget_3 != null) {
          Class28.method236(widget_3);
        }

        CollisionData.method572();
        interfaceItemTriggers[++anInt641 - 1 & 0x1F] = int_2 & 0x7FFF;
        packetType = -1;
        return true;
      }

      if (packetType == 107) {
        int_1 = secretPacketBuffer2.getInt();
        int_2 = secretPacketBuffer2.getUnsignedShort();
        if (int_1 < -70000) {
          int_2 += 32768;
        }

        if (int_1 >= 0) {
          widget_3 = ScriptExecutor.method240(int_1);
        } else {
          widget_3 = null;
        }

        for (; secretPacketBuffer2.offset < packetLength;
            Boundry.setItemTableSlot(int_2, int_4, int_5 - 1,
                int_6)) {
          int_4 = secretPacketBuffer2.getUnsignedSmartShort();
          int_5 = secretPacketBuffer2.getUnsignedShort();
          int_6 = 0;
          if (int_5 != 0) {
            int_6 = secretPacketBuffer2.getUnsignedByte();
            if (int_6 == 255) {
              int_6 = secretPacketBuffer2.getInt();
            }
          }

          if (widget_3 != null && int_4 >= 0 && int_4 < widget_3.itemIds.length) {
            widget_3.itemIds[int_4] = int_5;
            widget_3.itemQuantities[int_4] = int_6;
          }
        }

        if (widget_3 != null) {
          Class28.method236(widget_3);
        }

        CollisionData.method572();
        interfaceItemTriggers[++anInt641 - 1 & 0x1F] = int_2 & 0x7FFF;
        packetType = -1;
        return true;
      }

      int int_11;
      if (packetType == 80) {
        anInt659 = cycleCntr;
        if (packetLength == 0) {
          clanChatOwner = null;
          clanChatName = null;
          Node_Sub1.clanChatCount = 0;
          AClass1.clanMembers = null;
          packetType = -1;
          return true;
        }

        clanChatName = secretPacketBuffer2.getString();
        final long long_4 = secretPacketBuffer2.getLong();
        clanChatOwner = Identity.method486(long_4);
        Mouse.aByte2 = secretPacketBuffer2.getByte();
        int_3 = secretPacketBuffer2.getUnsignedByte();
        if (int_3 == 255) {
          packetType = -1;
          return true;
        }

        Node_Sub1.clanChatCount = int_3;
        final ClanMember[] clanmembers_0 = new ClanMember[100];

        for (int_5 = 0; int_5 < Node_Sub1.clanChatCount; int_5++) {
          clanmembers_0[int_5] = new ClanMember();
          clanmembers_0[int_5].username = secretPacketBuffer2.getString();
          clanmembers_0[int_5].aString19 = FloorUnderlayDefinition
              .method869(clanmembers_0[int_5].username, AClass1_Sub2.aClass108_10);
          clanmembers_0[int_5].world = secretPacketBuffer2.getUnsignedShort();
          clanmembers_0[int_5].rank = secretPacketBuffer2.getByte();
          secretPacketBuffer2.getString();
          if (clanmembers_0[int_5].username.equals(GrandExchangeOffer.localPlayer.name)) {
            ScriptExecutor.clanChatRank = clanmembers_0[int_5].rank;
          }
        }

        bool_8 = false;
        int_10 = Node_Sub1.clanChatCount;

        while (int_10 > 0) {
          bool_8 = true;
          --int_10;

          for (int_11 = 0; int_11 < int_10; int_11++) {
            if (clanmembers_0[int_11].aString19.compareTo(clanmembers_0[int_11 + 1].aString19)
                > 0) {
              final ClanMember clanmember_0 = clanmembers_0[int_11];
              clanmembers_0[int_11] = clanmembers_0[int_11 + 1];
              clanmembers_0[int_11 + 1] = clanmember_0;
              bool_8 = false;
            }
          }

          if (bool_8) {
            break;
          }
        }

        AClass1.clanMembers = clanmembers_0;
        packetType = -1;
        return true;
      }

      if (packetType == 165) {
        int_1 = packetLength + secretPacketBuffer2.offset;
        int_2 = secretPacketBuffer2.getUnsignedShort();
        int_3 = secretPacketBuffer2.getUnsignedShort();
        if (int_2 != widgetRoot) {
          widgetRoot = int_2;
          method1054(false);
          Class66.method411(widgetRoot);
          AClass4_Sub3.method818(widgetRoot);

          for (int_4 = 0; int_4 < 100; int_4++) {
            aBoolArray8[int_4] = true;
          }
        }

        OpenedInterface widgetnode_2;
        for (; int_3-- > 0; widgetnode_2.aBool47 = true) {
          int_4 = secretPacketBuffer2.getInt();
          int_5 = secretPacketBuffer2.getUnsignedShort();
          int_6 = secretPacketBuffer2.getUnsignedByte();
          widgetnode_2 = (OpenedInterface) componentTable.get(int_4);
          if (widgetnode_2 != null && int_5 != widgetnode_2.id) {
            Comparator0.method305(widgetnode_2, true);
            widgetnode_2 = null;
          }

          if (widgetnode_2 == null) {
            final OpenedInterface widgetnode_4 = new OpenedInterface();
            widgetnode_4.id = int_5;
            widgetnode_4.owner = int_6;
            componentTable.put(widgetnode_4, int_4);
            Class66.method411(int_5);
            final InterfaceComponent widget_6 = ScriptExecutor.method240(int_4);
            Class28.method236(widget_6);
            if (aWidget13 != null) {
              Class28.method236(aWidget13);
              aWidget13 = null;
            }

            AClass2_Sub1.method616();
            JavaxSourceDataLineProvider.method190(Time.widgets[int_4 >> 16], widget_6, false);
            AClass4_Sub3.method818(int_5);
            if (widgetRoot != -1) {
              Friend.method522(widgetRoot, 1);
            }

            widgetnode_2 = widgetnode_4;
          }
        }

        for (widgetnode_0 = (OpenedInterface) componentTable
            .method66(); widgetnode_0 != null;
            widgetnode_0 = (OpenedInterface) componentTable.method67()) {
          if (widgetnode_0.aBool47) {
            widgetnode_0.aBool47 = false;
          } else {
            Comparator0.method305(widgetnode_0, true);
          }
        }

        widgetFlags = new HashTable(512);

        while (secretPacketBuffer2.offset < int_1) {
          int_4 = secretPacketBuffer2.getInt();
          int_5 = secretPacketBuffer2.getUnsignedShort();
          int_6 = secretPacketBuffer2.getUnsignedShort();
          int_10 = secretPacketBuffer2.getInt();

          for (int_11 = int_5; int_11 <= int_6; int_11++) {
            final long long_3 = ((long) int_4 << 32) + int_11;
            widgetFlags.put(new IntegerNode(int_10), long_3);
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 62) {
        while (secretPacketBuffer2.offset < packetLength) {
          bool_5 = secretPacketBuffer2.getUnsignedByte() == 1;
          string_0 = secretPacketBuffer2.getString();
          string_3 = secretPacketBuffer2.getString();
          int_4 = secretPacketBuffer2.getUnsignedShort();
          int_5 = secretPacketBuffer2.getUnsignedByte();
          int_6 = secretPacketBuffer2.getUnsignedByte();
          final boolean bool_3 = (int_6 & 0x2) != 0;
          final boolean bool_4 = (int_6 & 0x1) != 0;
          if (int_4 > 0) {
            secretPacketBuffer2.getString();
            secretPacketBuffer2.getUnsignedByte();
            secretPacketBuffer2.getInt();
          }

          secretPacketBuffer2.getString();

          for (int int_8 = 0; int_8 < friendCount; int_8++) {
            final Friend friend_4 = friends[int_8];
            if (!bool_5) {
              if (string_0.equals(friend_4.name)) {
                if (int_4 != friend_4.world) {
                  boolean bool_1 = true;

                  for (Class69_Sub1 class69_sub1_0 = (Class69_Sub1) aClass75_1
                      .method463(); class69_sub1_0 != null;
                      class69_sub1_0 = (Class69_Sub1) aClass75_1
                          .method465()) {
                    if (class69_sub1_0.aString18.equals(string_0)) {
                      if (int_4 != 0 && class69_sub1_0.aShort1 == 0) {
                        class69_sub1_0.method422();
                        bool_1 = false;
                      } else if (int_4 == 0 && class69_sub1_0.aShort1 != 0) {
                        class69_sub1_0.method422();
                        bool_1 = false;
                      }
                    }
                  }

                  if (bool_1) {
                    aClass75_1.method464(new Class69_Sub1(string_0, int_4));
                  }

                  friend_4.world = int_4;
                }

                friend_4.previousName = string_3;
                friend_4.rank = int_5;
                friend_4.aBool24 = bool_3;
                friend_4.aBool25 = bool_4;
                string_0 = null;
                break;
              }
            } else if (string_3.equals(friend_4.name)) {
              friend_4.name = string_0;
              friend_4.previousName = string_3;
              string_0 = null;
              break;
            }
          }

          if (string_0 != null && friendCount < 400) {
            final Friend friend_3 = new Friend();
            friends[friendCount] = friend_3;
            friend_3.name = string_0;
            friend_3.previousName = string_3;
            friend_3.world = int_4;
            friend_3.rank = int_5;
            friend_3.aBool24 = bool_3;
            friend_3.aBool25 = bool_4;
            ++friendCount;
          }
        }

        anInt687 = 2;
        anInt646 = cycleCntr;
        bool_5 = false;
        int_2 = friendCount;

        while (int_2 > 0) {
          bool_5 = true;
          --int_2;

          for (int_3 = 0; int_3 < int_2; int_3++) {
            bool_7 = false;
            final Friend friend_2 = friends[int_3];
            final Friend friend_0 = friends[int_3 + 1];
            if (friend_2.world != world && friend_0.world == world) {
              bool_7 = true;
            }

            if (!bool_7 && friend_2.world == 0 && friend_0.world != 0) {
              bool_7 = true;
            }

            if (!bool_7 && !friend_2.aBool24 && friend_0.aBool24) {
              bool_7 = true;
            }

            if (!bool_7 && !friend_2.aBool25 && friend_0.aBool25) {
              bool_7 = true;
            }

            if (bool_7) {
              final Friend friend_1 = friends[int_3];
              friends[int_3] = friends[int_3 + 1];
              friends[int_3 + 1] = friend_1;
              bool_5 = false;
            }
          }

          if (bool_5) {
            break;
          }
        }

        packetType = -1;
        return true;
      }

      if (packetType == 104) {
        Class29.xteaChanged(false);
        secretPacketBuffer2.getDecipheredByte();
        int_1 = secretPacketBuffer2.getUnsignedShort();
        Class24.method219(secretPacketBuffer2, int_1);
        packetType = -1;
        return true;
      }

      if (packetType == 127) {
        Class29.xteaChanged(true);
        secretPacketBuffer2.getDecipheredByte();
        int_1 = secretPacketBuffer2.getUnsignedShort();
        Class24.method219(secretPacketBuffer2, int_1);
        packetType = -1;
        return true;
      }

      if (packetType == 130) {
        Class51.method328(true);
        packetType = -1;
        return true;
      }

      if (packetType == 8) {
        Class51.method328(false);
        packetType = -1;
        return true;
      }

      if (packetType == 92 || packetType == 115 || packetType == 73 || packetType == 156
          || packetType == 13 || packetType == 79 || packetType == 212 || packetType == 131
          || packetType == 113 || packetType == 231) {
        Client.method507();
        packetType = -1;
        return true;
      }

      if (packetType == 198) {
        Materials.anInt214 = secretPacketBuffer2.getUnsignedByteNegate();
        Class1.anInt14 = secretPacketBuffer2.getUnsignedByteNegate();

        while (secretPacketBuffer2.offset < packetLength) {
          packetType = secretPacketBuffer2.getUnsignedByte();
          Client.method507();
        }

        packetType = -1;
        return true;
      }

      ClientScriptVariable.method526(
          "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength,
          null);
      Class4.method123();
    } catch (final IOException ioexception_0) {
      if (anInt595 > 0) {
        Class4.method123();
      } else {
        Mouse.setGameState(40);
        Class53.aSocketStream1 = VertexNormal.stream;
        VertexNormal.stream = null;
      }
    } catch (final Exception exception_0) {
      string_1 =
          "" + packetType + "," + secondLastFrameId + "," + thridLastFrameId + "," + packetLength
              + ","
              + (GrandExchangeOffer.localPlayer.pathX[0] + Boundry.baseX) + ","
              + (GrandExchangeOffer.localPlayer.pathY[0] + WorldMapData_Sub1.baseY) + ",";

      for (int_2 = 0; int_2 < packetLength && int_2 < 50; int_2++) {
        string_1 = string_1 + secretPacketBuffer2.bytes[int_2] + ",";
      }

      ClientScriptVariable.method526(string_1, exception_0);
      Class4.method123();
    }

    return true;
  }

  final void method1056(final int int_0, final int int_1) {
    int int_2 = Class22.aFont3.method989("Choose Option");

    int int_3;
    for (int_3 = 0; int_3 < menuOptionCount; int_3++) {
      final BitmapFont font_0 = Class22.aFont3;
      String string_0;
      if (int_3 < 0) {
        string_0 = "";
      } else if (menuTargets[int_3].length() > 0) {
        string_0 = menuOptions[int_3] + " " + menuTargets[int_3];
      } else {
        string_0 = menuOptions[int_3];
      }

      final int int_4 = font_0.method989(string_0);
      if (int_4 > int_2) {
        int_2 = int_4;
      }
    }

    int_2 += 8;
    int_3 = menuOptionCount * 15 + 22;
    int int_5 = int_0 - int_2 / 2;
    if (int_5 + int_2 > Stub.canvasWidth) {
      int_5 = Stub.canvasWidth - int_2;
    }

    if (int_5 < 0) {
      int_5 = 0;
    }

    int int_6 = int_1;
    if (int_3 + int_1 > Class34.canvasHeight) {
      int_6 = Class34.canvasHeight - int_3;
    }

    if (int_6 < 0) {
      int_6 = 0;
    }

    Class11.region.method367(Class12.plane, int_0, int_1, false);
    isMenuOpen = true;
    menuX = int_5;
    AnimationSequence.menuY = int_6;
    GrandExchangeOffer.menuWidth = int_2;
    Class31.menuHeight = menuOptionCount * 15 + 22;
  }

  @Override
  protected final void update() {
    ++tick;
    fetchAssets();
    RemoteAssetRequestor.validateCacheRequests();
    Class66.method410();
    Class77.method468();
    Keyboard.poll();
    Class47.pollMouse();
    int int_0;
    if (RemoteRequest.anInterface3_1 != null) {
      int_0 = RemoteRequest.anInterface3_1.method4();
      anInt617 = int_0;
    }

    if (state == 0) {
      Class41.loadEngine();
      Stub.regulator.reset();

      for (int_0 = 0; int_0 < 32; int_0++) {
        Stub.aLongArray3[int_0] = 0L;
      }

      for (int_0 = 0; int_0 < 32; int_0++) {
        Stub.memory[int_0] = 0L;
      }

      Stub.cycles = 0;
    } else if (state == 5) {
      World.method545(this);
      Class41.loadEngine();
      Stub.regulator.reset();

      for (int_0 = 0; int_0 < 32; int_0++) {
        Stub.aLongArray3[int_0] = 0L;
      }

      for (int_0 = 0; int_0 < 32; int_0++) {
        Stub.memory[int_0] = 0L;
      }

      Stub.cycles = 0;
    } else if (state == 10 || state == 11) {
      World.method545(this);
    } else if (state == 20) {
      World.method545(this);
      method1060();
    } else if (state == 25) {
      CacheableNode_Sub3.method847();
    }

    if (state == 30) {
      method1059();
    } else if (state == 40 || state == 45) {
      method1060();
      return;
    }

  }

  void method1057() {
    if (RemoteAssetRequestor.anInt190 >= 4) {
      this.error("js5crc");
      state = 1000;
    } else {
      if (RemoteAssetRequestor.anInt192 >= 4) {
        if (state <= 5) {
          this.error("js5io");
          state = 1000;
          return;
        }

        anInt599 = 3000;
        RemoteAssetRequestor.anInt192 = 3;
      }

      if (--anInt599 + 1 <= 0) {
        try {
          if (js5State == 0) {
            socket = Stub.taskManager.createSocket(host, OpenedInterface.myWorldPort);
            ++js5State;
          }

          if (js5State == 1) {
            if (socket.status == 2) {
              this.error(-1);
              return;
            }

            if (socket.status == 1) {
              ++js5State;
            }
          }

          if (js5State == 2) {
            FontType.stream = new SocketStream((Socket) socket.result, Stub.taskManager);
            final Buffer buffer_0 = new Buffer(5);
            buffer_0.putByte(15);
            buffer_0.putInt(153);
            FontType.stream.write(buffer_0.bytes, 0, 5);
            ++js5State;
            AClass1_Sub2.aLong18 = Time.currentTimeMillis();
          }

          if (js5State == 3) {
            if (state > 5 && FontType.stream.available() <= 0) {
              if (Time.currentTimeMillis() - AClass1_Sub2.aLong18 > 30000L) {
                this.error(-2);
                return;
              }
            } else {
              final int int_0 = FontType.stream.readByte();
              if (int_0 != 0) {
                this.error(int_0);
                return;
              }

              ++js5State;
            }
          }

          if (js5State == 4) {
            final SocketStream rssocket_0 = FontType.stream;
            final boolean bool_0 = state > 20;
            if (RemoteAssetRequestor.aSocketStream2 != null) {
              try {
                RemoteAssetRequestor.aSocketStream2.close();
              } catch (final Exception exception_0) {
              }

              RemoteAssetRequestor.aSocketStream2 = null;
            }

            RemoteAssetRequestor.aSocketStream2 = rssocket_0;
            Class8.sendConInfo(bool_0);
            RemoteAssetRequestor.aBuffer5.offset = 0;
            RemoteAssetRequestor.current = null;
            MapAsset.aBuffer1 = null;
            RemoteAssetRequestor.anInt197 = 0;

            while (true) {
              RemoteRequest filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable5.method66();
              if (filerequest_0 == null) {
                while (true) {
                  filerequest_0 = (RemoteRequest) RemoteAssetRequestor.aHashTable6.method66();
                  if (filerequest_0 == null) {
                    if (RemoteAssetRequestor.aByte1 != 0) {
                      try {
                        final Buffer buffer_1 = new Buffer(4);
                        buffer_1.putByte(4);
                        buffer_1.putByte(RemoteAssetRequestor.aByte1);
                        buffer_1.putShort(0);
                        RemoteAssetRequestor.aSocketStream2.write(buffer_1.bytes, 0, 4);
                      } catch (final IOException ioexception_1) {
                        try {
                          RemoteAssetRequestor.aSocketStream2.close();
                        } catch (final Exception exception_1) {
                        }

                        ++RemoteAssetRequestor.anInt192;
                        RemoteAssetRequestor.aSocketStream2 = null;
                      }
                    }

                    RemoteAssetRequestor.anInt191 = 0;
                    RemoteAssetRequestor.aLong11 = Time.currentTimeMillis();
                    socket = null;
                    FontType.stream = null;
                    js5State = 0;
                    anInt602 = 0;
                    return;
                  }

                  RemoteAssetRequestor.passiveRequests.addLast(filerequest_0);
                  RemoteAssetRequestor.aHashTable3.put(filerequest_0, filerequest_0.hash);
                  ++RemoteAssetRequestor.anInt195;
                  --RemoteAssetRequestor.anInt196;
                }
              }

              RemoteAssetRequestor.aHashTable4.put(filerequest_0, filerequest_0.hash);
              ++RemoteAssetRequestor.anInt193;
              --RemoteAssetRequestor.anInt194;
            }
          }
        } catch (final IOException ioexception_0) {
          this.error(-3);
        }
      }
    }
  }

  final void method1058() {
    int int_0;
    if (widgetRoot != -1) {
      int_0 = widgetRoot;
      if (Ignore.loadWidget(int_0)) {
        Class22.method207(Time.widgets[int_0], -1);
      }
    }

    for (int_0 = 0; int_0 < anInt596; int_0++) {
      if (aBoolArray8[int_0]) {
        aBoolArray10[int_0] = true;
      }

      aBoolArray9[int_0] = aBoolArray8[int_0];
      aBoolArray8[int_0] = false;
    }

    anInt597 = tick;
    anInt600 = -1;
    anInt601 = -1;
    Class104.aWidget6 = null;
    int int_1;
    int int_2;
    int int_3;
    if (widgetRoot != -1) {
      anInt596 = 0;
      int_0 = widgetRoot;
      int_1 = Stub.canvasWidth;
      int_2 = Class34.canvasHeight;
      if (!Ignore.loadWidget(int_0)) {
        for (int_3 = 0; int_3 < 100; int_3++) {
          aBoolArray8[int_3] = true;
        }
      } else {
        Class53.aWidgetArray1 = null;
        gameDraw(Time.widgets[int_0], -1, 0, 0, int_1, int_2, 0, 0, -1);
        if (Class53.aWidgetArray1 != null) {
          gameDraw(Class53.aWidgetArray1, -1412584499, 0, 0, int_1, int_2, Class23.anInt74,
                  Boundry.anInt48, -1);
          Class53.aWidgetArray1 = null;
        }
      }
    }

    Rasterizer2d.resetClip();
    if (!isMenuOpen) {
      if (anInt600 != -1) {
        int_0 = anInt600;
        int_1 = anInt601;
        if (menuOptionCount >= 2 || itemSelectionState != 0 || spellSelected) {
          int_2 = menuOptionCount - 1;
          String string_0;
          if (itemSelectionState == 1 && menuOptionCount < 2) {
            string_0 = "Use" + " " + aString33 + " " + "->";
          } else if (spellSelected && menuOptionCount < 2) {
            string_0 = aString34 + " " + aString35 + " " + "->";
          } else {
            String string_1;
            if (int_2 < 0) {
              string_1 = "";
            } else if (menuTargets[int_2].length() > 0) {
              string_1 = menuOptions[int_2] + " " + menuTargets[int_2];
            } else {
              string_1 = menuOptions[int_2];
            }

            string_0 = string_1;
          }

          if (menuOptionCount > 2) {
            string_0 =
                string_0 + Square.getColTags(16777215) + " " + '/' + " " + (menuOptionCount - 2)
                    + " more options";
          }

          Class22.aFont3.drawRandomizedMouseoverText(string_0, int_0 + 4, int_1 + 15, 16777215, 0,
              tick / 1000);
        }
      }
    } else {
      GrandExchangeOffer.method176();
    }

    if (gameDrawingMode == 3) {
      for (int_0 = 0; int_0 < anInt596; int_0++) {
        if (aBoolArray9[int_0]) {
          Rasterizer2d.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0],
              widgetBoundsWidth[int_0],
              widgetBoundsHeight[int_0], 16711935, 128);
        } else if (aBoolArray10[int_0]) {
          Rasterizer2d.fillRectangle(widgetPositionX[int_0], widgetPositionY[int_0],
              widgetBoundsWidth[int_0],
              widgetBoundsHeight[int_0], 16711680, 128);
        }
      }
    }

    int_0 = Class12.plane;
    int_1 = GrandExchangeOffer.localPlayer.x;
    int_2 = GrandExchangeOffer.localPlayer.y;
    int_3 = anInt610;

    for (Node_Sub1 node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3
        .getFirst(); node_sub1_0 != null; node_sub1_0 = (Node_Sub1) Node_Sub1.aDeque3.getNext()) {
      if (node_sub1_0.anInt309 != -1 || node_sub1_0.anIntArray77 != null) {
        int int_4 = 0;
        if (int_1 > node_sub1_0.anInt313) {
          int_4 += int_1 - node_sub1_0.anInt313;
        } else if (int_1 < node_sub1_0.anInt314) {
          int_4 += node_sub1_0.anInt314 - int_1;
        }

        if (int_2 > node_sub1_0.anInt315) {
          int_4 += int_2 - node_sub1_0.anInt315;
        } else if (int_2 < node_sub1_0.anInt316) {
          int_4 += node_sub1_0.anInt316 - int_2;
        }

        if (int_4 - 64 <= node_sub1_0.anInt310 && anInt634 != 0 && int_0
            == node_sub1_0.anInt317) {
          int_4 -= 64;
          if (int_4 < 0) {
            int_4 = 0;
          }

          final int int_5 = (node_sub1_0.anInt310 - int_4) * anInt634 / node_sub1_0.anInt310;
          if (node_sub1_0.anAClass4_Sub2_1 == null) {
            if (node_sub1_0.anInt309 >= 0) {
              final SoundEffect soundeffect_0 = SoundEffect
                  .getTrack(anIndexData5, node_sub1_0.anInt309,
                      0);
              if (soundeffect_0 != null) {
                final AClass5_Sub1 aclass5_sub1_0 = soundeffect_0.method428()
                    .method727(Class40.aClass54_1);
                final AClass4_Sub2 aclass4_sub2_0 = AClass4_Sub2
                    .method769(aclass5_sub1_0, 100, int_5);
                aclass4_sub2_0.method747(-1);
                Class25.anAClass4_Sub1_1.method721(aclass4_sub2_0);
                node_sub1_0.anAClass4_Sub2_1 = aclass4_sub2_0;
              }
            }
          } else {
            node_sub1_0.anAClass4_Sub2_1.method749(int_5);
          }

          if (node_sub1_0.anAClass4_Sub2_2 == null) {
            if (node_sub1_0.anIntArray77 != null && (node_sub1_0.anInt318 -= int_3) <= 0) {
              final int int_6 = (int) (Math.random() * node_sub1_0.anIntArray77.length);
              final SoundEffect soundeffect_1 = SoundEffect.getTrack(anIndexData5,
                  node_sub1_0.anIntArray77[int_6], 0);
              if (soundeffect_1 != null) {
                final AClass5_Sub1 aclass5_sub1_1 = soundeffect_1.method428()
                    .method727(Class40.aClass54_1);
                final AClass4_Sub2 aclass4_sub2_1 = AClass4_Sub2
                    .method769(aclass5_sub1_1, 100, int_5);
                aclass4_sub2_1.method747(0);
                Class25.anAClass4_Sub1_1.method721(aclass4_sub2_1);
                node_sub1_0.anAClass4_Sub2_2 = aclass4_sub2_1;
                node_sub1_0.anInt318 = node_sub1_0.anInt311
                    + (int) (Math.random() * (node_sub1_0.anInt312 - node_sub1_0.anInt311));
              }
            }
          } else {
            node_sub1_0.anAClass4_Sub2_2.method749(int_5);
            if (!node_sub1_0.anAClass4_Sub2_2.isLinked()) {
              node_sub1_0.anAClass4_Sub2_2 = null;
            }
          }
        } else {
          if (node_sub1_0.anAClass4_Sub2_1 != null) {
            Class25.anAClass4_Sub1_1.method722(node_sub1_0.anAClass4_Sub2_1);
            node_sub1_0.anAClass4_Sub2_1 = null;
          }

          if (node_sub1_0.anAClass4_Sub2_2 != null) {
            Class25.anAClass4_Sub1_1.method722(node_sub1_0.anAClass4_Sub2_2);
            node_sub1_0.anAClass4_Sub2_2 = null;
          }
        }
      }
    }

    anInt610 = 0;
  }

  final void method1059() {
    if (anInt593 > 1) {
      --anInt593;
    }

    if (anInt595 > 0) {
      --anInt595;
    }

    if (panic) {
      panic = false;
      if (anInt595 > 0) {
        Class4.method123();
      } else {
        Mouse.setGameState(40);
        Class53.aSocketStream1 = VertexNormal.stream;
        VertexNormal.stream = null;
      }
    } else {
      if (!isMenuOpen) {
        Class2.method118();
      }

      int int_0;
      for (int_0 = 0; int_0 < 100 && processServerPacket(); int_0++) {
      }

      if (state == 30) {
        while (Node_Sub3.method658()) {
          outbound.putEncipheredByte(35);
          outbound.putByte(0);
          int_0 = outbound.offset;
          WorldMapData_Sub1.encodeClassVerifier(outbound);
          outbound.putLengthByte(outbound.offset - int_0);
        }

        int int_1;
        int int_2;
        int int_3;
        int int_4;
        int int_5;
        int int_6;
        int int_7;
        int int_8;
        synchronized (ScriptExecutor.aClass19_1.anObject1) {
          if (!aBool77) {
            ScriptExecutor.aClass19_1.anInt69 = 0;
          } else if (Mouse.anInt248 != 0 || ScriptExecutor.aClass19_1.anInt69 >= 40) {
            outbound.putEncipheredByte(252);
            outbound.putByte(0);
            int_1 = outbound.offset;
            int_2 = 0;

            for (int_3 = 0; int_3 < ScriptExecutor.aClass19_1.anInt69
                && outbound.offset - int_1 < 240; int_3++) {
              ++int_2;
              int_4 = ScriptExecutor.aClass19_1.anIntArray5[int_3];
              if (int_4 < 0) {
                int_4 = 0;
              } else if (int_4 > 502) {
                int_4 = 502;
              }

              int_5 = ScriptExecutor.aClass19_1.anIntArray4[int_3];
              if (int_5 < 0) {
                int_5 = 0;
              } else if (int_5 > 764) {
                int_5 = 764;
              }

              int_6 = int_5 + int_4 * 765;
              if (ScriptExecutor.aClass19_1.anIntArray5[int_3] == -1
                  && ScriptExecutor.aClass19_1.anIntArray4[int_3] == -1) {
                int_5 = -1;
                int_4 = -1;
                int_6 = 524287;
              }

              if (int_5 == anInt607 && int_4 == anInt608) {
                if (anInt609 < 2047) {
                  ++anInt609;
                }
              } else {
                int_7 = int_5 - anInt607;
                anInt607 = int_5;
                int_8 = int_4 - anInt608;
                anInt608 = int_4;
                if (anInt609 < 8 && int_7 >= -32 && int_7 <= 31 && int_8 >= -32
                    && int_8 <= 31) {
                  int_7 += 32;
                  int_8 += 32;
                  outbound.putShort(int_8 + (anInt609 << 12) + (int_7 << 6));
                  anInt609 = 0;
                } else if (anInt609 < 8) {
                  outbound.putMedium((anInt609 << 19) + int_6 + 8388608);
                  anInt609 = 0;
                } else {
                  outbound.putInt((anInt609 << 19) + int_6 + -1073741824);
                  anInt609 = 0;
                }
              }
            }

            outbound.putLengthByte(outbound.offset - int_1);
            if (int_2 >= ScriptExecutor.aClass19_1.anInt69) {
              ScriptExecutor.aClass19_1.anInt69 = 0;
            } else {
              ScriptExecutor.aClass19_1.anInt69 -= int_2;

              for (int_3 = 0; int_3 < ScriptExecutor.aClass19_1.anInt69; int_3++) {
                ScriptExecutor.aClass19_1.anIntArray4[int_3] = ScriptExecutor.aClass19_1.anIntArray4[int_2
                    + int_3];
                ScriptExecutor.aClass19_1.anIntArray5[int_3] = ScriptExecutor.aClass19_1.anIntArray5[int_3
                    + int_2];
              }
            }
          }
        }

        if (Mouse.anInt248 == 1 || !GrandExchangeOffer.aBool5 && Mouse.anInt248 == 4
            || Mouse.anInt248 == 2) {
          long long_0 = (Mouse.aLong17 - aLong26) / 50L;
          if (long_0 > 4095L) {
            long_0 = 4095L;
          }

          aLong26 = Mouse.aLong17;
          int_2 = Mouse.anInt254;
          if (int_2 < 0) {
            int_2 = 0;
          } else if (int_2 > Class34.canvasHeight) {
            int_2 = Class34.canvasHeight;
          }

          int_3 = Mouse.anInt253;
          if (int_3 < 0) {
            int_3 = 0;
          } else if (int_3 > Stub.canvasWidth) {
            int_3 = Stub.canvasWidth;
          }

          int_4 = (int) long_0;
          outbound.putEncipheredByte(65);
          outbound.putShort((int_4 << 1) + (Mouse.anInt248 == 2 ? 1 : 0));
          outbound.putShort(int_3);
          outbound.putShort(int_2);
        }

        if (Keyboard.anInt127 > 0) {
          outbound.putEncipheredByte(118);
          outbound.putShort(0);
          int_0 = outbound.offset;
          final long long_1 = Time.currentTimeMillis();

          for (int_3 = 0; int_3 < Keyboard.anInt127; int_3++) {
            long long_2 = long_1 - aLong27;
            if (long_2 > 16777215L) {
              long_2 = 16777215L;
            }

            aLong27 = long_1;
            outbound.putMedium((int) long_2);
            outbound.putByte(Keyboard.anIntArray32[int_3]);
          }

          outbound.putLengthShort(outbound.offset - int_0);
        }

        if (anInt642 > 0) {
          --anInt642;
        }

        if (Keyboard.aBoolArray3[96] || Keyboard.aBoolArray3[97]
            || Keyboard.aBoolArray3[98] || Keyboard.aBoolArray3[99]) {
          aBool86 = true;
        }

        if (aBool86 && anInt642 <= 0) {
          anInt642 = 20;
          aBool86 = false;
          outbound.putEncipheredByte(21);
          outbound.putShortAdd(anInt653);
          outbound.putLeShort(mapAngle);
        }

        if (Area.aBool52 && !aBool83) {
          aBool83 = true;
          outbound.putEncipheredByte(85);
          outbound.putByte(1);
        }

        if (!Area.aBool52 && aBool83) {
          aBool83 = false;
          outbound.putEncipheredByte(85);
          outbound.putByte(0);
        }

        Class22.method208();
        if (state == 30) {
          for (PendingSpawn pendingspawn_0 = (PendingSpawn) pendingSpawns
              .getFirst(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn) pendingSpawns
              .getNext()) {
            if (pendingspawn_0.hitpoints > 0) {
              --pendingspawn_0.hitpoints;
            }

            if (pendingspawn_0.hitpoints == 0) {
              if (pendingspawn_0.anInt333 < 0
                  || MessageNode.method909(pendingspawn_0.anInt333, pendingspawn_0.anInt334)) {
                Class18.method203(pendingspawn_0.level, pendingspawn_0.type, pendingspawn_0.x,
                    pendingspawn_0.y, pendingspawn_0.anInt333, pendingspawn_0.anInt335,
                    pendingspawn_0.anInt334);
                pendingspawn_0.unlink();
              }
            } else {
              if (pendingspawn_0.delay > 0) {
                --pendingspawn_0.delay;
              }

              if (pendingspawn_0.delay == 0 && pendingspawn_0.x >= 1 && pendingspawn_0.y >= 1
                  && pendingspawn_0.x <= 102 && pendingspawn_0.y <= 102
                  && (pendingspawn_0.id < 0
                  || MessageNode.method909(pendingspawn_0.id, pendingspawn_0.anInt336))) {
                Class18.method203(pendingspawn_0.level, pendingspawn_0.type, pendingspawn_0.x,
                    pendingspawn_0.y, pendingspawn_0.id, pendingspawn_0.orientation,
                    pendingspawn_0.anInt336);
                pendingspawn_0.delay = -1;
                if (pendingspawn_0.id == pendingspawn_0.anInt333 && pendingspawn_0.anInt333
                    == -1) {
                  pendingspawn_0.unlink();
                } else if (pendingspawn_0.id == pendingspawn_0.anInt333
                    && pendingspawn_0.anInt335 == pendingspawn_0.orientation
                    && pendingspawn_0.anInt334 == pendingspawn_0.anInt336) {
                  pendingspawn_0.unlink();
                }
              }
            }
          }

          MilliRegulator.method710();
          ++anInt633;
          if (anInt633 > 750) {
            if (anInt595 > 0) {
              Class4.method123();
            } else {
              Mouse.setGameState(40);
              Class53.aSocketStream1 = VertexNormal.stream;
              VertexNormal.stream = null;
            }
          } else {
            int_0 = Class39.anInt89;
            final int[] ints_0 = Class39.anIntArray14;

            for (int_2 = 0; int_2 < int_0; int_2++) {
              final Player player_0 = cachedPlayers[ints_0[int_2]];
              if (player_0 != null) {
                Class98.method515(player_0, 1);
              }
            }

            Class48.method298();
            final int[] ints_1 = Class39.anIntArray14;

            for (int_1 = 0; int_1 < Class39.anInt89; int_1++) {
              final Player player_1 = cachedPlayers[ints_1[int_1]];
              if (player_1 != null && player_1.anInt509 > 0) {
                --player_1.anInt509;
                if (player_1.anInt509 == 0) {
                  player_1.overhead = null;
                }
              }
            }

            for (int_1 = 0; int_1 < anInt636; int_1++) {
              int_2 = npcIndices[int_1];
              final Npc npc_0 = cachedNPCs[int_2];
              if (npc_0 != null && npc_0.anInt509 > 0) {
                --npc_0.anInt509;
                if (npc_0.anInt509 == 0) {
                  npc_0.overhead = null;
                }
              }
            }

            ++anInt610;
            if (cursorState != 0) {
              anInt624 += 20;
              if (anInt624 >= 400) {
                cursorState = 0;
              }
            }

            if (Class19.aWidget2 != null) {
              ++anInt654;
              if (anInt654 >= 15) {
                Class28.method236(Class19.aWidget2);
                Class19.aWidget2 = null;
              }
            }

            final InterfaceComponent widget_0 = IntegerVariable.aWidget4;
            final InterfaceComponent widget_1 = Class43.aWidget5;
            IntegerVariable.aWidget4 = null;
            Class43.aWidget5 = null;
            aWidget12 = null;
            aBool78 = false;
            aBool79 = false;
            anInt686 = 0;

            while (ClanMember.method656() && anInt686 < 128) {
              if (rights >= 2 && Keyboard.aBoolArray3[82] && Class3.anInt22 == 66) {
                String string_0 = "";

                MessageNode messagenode_0;
                for (final Iterator iterator_0 = Class36.anIterableHashTable1.iterator(); iterator_0
                    .hasNext(); string_0 = string_0 + messagenode_0.name + ':' + messagenode_0.value
                    + '\n') {
                  messagenode_0 = (MessageNode) iterator_0.next();
                }

                Enum1.clientInstance.method1048(string_0);
              } else {
                anIntArray165[anInt686] = Class3.anInt22;
                anIntArray166[anInt686] = Class89.aChar1;
                ++anInt686;
              }
            }

            if (widgetRoot != -1) {
              AbstractByteBuffer.method274(widgetRoot, 0, 0, Stub.canvasWidth, Class34.canvasHeight,
                  0, 0);
            }

            ++cycleCntr;

            while (true) {
              ScriptCall scriptevent_0;
              InterfaceComponent widget_2;
              InterfaceComponent widget_3;
              do {
                scriptevent_0 = (ScriptCall) aDeque8.pollFirst();
                if (scriptevent_0 == null) {
                  while (true) {
                    do {
                      scriptevent_0 = (ScriptCall) aDeque9.pollFirst();
                      if (scriptevent_0 == null) {
                        while (true) {
                          do {
                            scriptevent_0 = (ScriptCall) aDeque7.pollFirst();
                            if (scriptevent_0 == null) {
                              method1062();
                              FrameBase.method672();
                              if (aWidget9 != null) {
                                method1063();
                              }

                              if (Class29.aWidget3 != null) {
                                Class28.method236(Class29.aWidget3);
                                ++anInt627;
                                if (Mouse.anInt252 == 0) {
                                  if (aBool84) {
                                    if (Class29.aWidget3 == Class104.aWidget6
                                        && anInt632 != anInt689) {
                                      final InterfaceComponent widget_4 = Class29.aWidget3;
                                      byte byte_0 = 0;
                                      if (anInt671 == 1
                                          && widget_4.contentType == 206) {
                                        byte_0 = 1;
                                      }

                                      if (widget_4.itemIds[anInt689] <= 0) {
                                        byte_0 = 0;
                                      }

                                      if (Class25.method224(
                                          getWidgetConfig(widget_4))) {
                                        int_4 = anInt632;
                                        int_5 = anInt689;
                                        widget_4.itemIds[int_5] = widget_4.itemIds[int_4];
                                        widget_4.itemQuantities[int_5] = widget_4.itemQuantities[int_4];
                                        widget_4.itemIds[int_4] = -1;
                                        widget_4.itemQuantities[int_4] = 0;
                                      } else if (byte_0 == 1) {
                                        int_4 = anInt632;
                                        int_5 = anInt689;

                                        while (int_5 != int_4) {
                                          if (int_4 > int_5) {
                                            widget_4.method585(int_4 - 1,
                                                int_4);
                                            --int_4;
                                          } else if (int_4 < int_5) {
                                            widget_4.method585(int_4 + 1,
                                                int_4);
                                            ++int_4;
                                          }
                                        }
                                      } else {
                                        widget_4.method585(anInt689, anInt632);
                                      }

                                      outbound.putEncipheredByte(241);
                                      outbound
                                          .putLeInt(Class29.aWidget3.id);
                                      outbound.putByteSub(byte_0);
                                      outbound.putLeShort(anInt632);
                                      outbound.putShort(anInt689);
                                    }
                                  } else if (method1055()) {
                                    method1056(anInt630, anInt631);
                                  } else if (menuOptionCount > 0) {
                                    int_2 = anInt630;
                                    int_3 = anInt631;
                                    final Class28 class28_0 = Comparator0.aClass28_1;
                                    menuAction(class28_0.anInt77,
                                        class28_0.anInt78, class28_0.anInt79,
                                        class28_0.anInt80, class28_0.aString6,
                                        class28_0.aString6, int_2, int_3);
                                    Comparator0.aClass28_1 = null;
                                  }

                                  anInt654 = 10;
                                  Mouse.anInt248 = 0;
                                  Class29.aWidget3 = null;
                                } else if (anInt627 >= 5
                                    && (Mouse.anInt249 > anInt630 + 5
                                    || Mouse.anInt249 < anInt630
                                    - 5
                                    || Mouse.anInt251 > anInt631
                                    + 5
                                    || Mouse.anInt251 < anInt631
                                    - 5)) {
                                  aBool84 = true;
                                }
                              }

                              if (Region.method389()) {
                                int_2 = Region.selectedRegionTileX;
                                int_3 = Region.selectedRegionTileY;
                                outbound.putEncipheredByte(195);
                                outbound.putByte(5);
                                outbound
                                    .putByteAdd(Keyboard.aBoolArray3[82]
                                        ? Keyboard.aBoolArray3[81] ? 2
                                        : 1
                                        : 0);
                                outbound.putLeShortAdd(int_2 + Boundry.baseX);
                                outbound
                                    .putShort(int_3 + WorldMapData_Sub1.baseY);
                                Region.method394();
                                anInt619 = Mouse.anInt253;
                                anInt622 = Mouse.anInt254;
                                cursorState = 1;
                                anInt624 = 0;
                                destinationX = int_2;
                                destinationY = int_3;
                              }

                              if (widget_0 != IntegerVariable.aWidget4) {
                                if (widget_0 != null) {
                                  Class28.method236(widget_0);
                                }

                                if (IntegerVariable.aWidget4 != null) {
                                  Class28.method236(IntegerVariable.aWidget4);
                                }
                              }

                              if (widget_1 != Class43.aWidget5
                                  && anInt649 == anInt650) {
                                if (widget_1 != null) {
                                  Class28.method236(widget_1);
                                }

                                if (Class43.aWidget5 != null) {
                                  Class28.method236(Class43.aWidget5);
                                }
                              }

                              if (Class43.aWidget5 != null) {
                                if (anInt649 < anInt650) {
                                  ++anInt649;
                                  if (anInt650 == anInt649) {
                                    Class28.method236(Class43.aWidget5);
                                  }
                                }
                              } else if (anInt649 > 0) {
                                --anInt649;
                              }

                              int_2 = GrandExchangeOffer.localPlayer.x;
                              int_3 = GrandExchangeOffer.localPlayer.y;
                              if (Class11.anInt55 - int_2 < -500
                                  || Class11.anInt55 - int_2 > 500
                                  || WorldMapData.anInt107 - int_3 < -500
                                  || WorldMapData.anInt107 - int_3 > 500) {
                                Class11.anInt55 = int_2;
                                WorldMapData.anInt107 = int_3;
                              }

                              if (int_2 != Class11.anInt55) {
                                Class11.anInt55 += (int_2 - Class11.anInt55) / 16;
                              }

                              if (int_3 != WorldMapData.anInt107) {
                                WorldMapData.anInt107 += (int_3 - WorldMapData.anInt107)
                                    / 16;
                              }

                              if (Mouse.anInt252 == 4
                                  && GrandExchangeOffer.aBool5) {
                                int_4 = Mouse.anInt251 - anInt676;
                                anInt674 = int_4 * 2;
                                anInt676 = int_4 != -1 && int_4 != 1
                                    ? (Mouse.anInt251 + anInt676) / 2
                                    : Mouse.anInt251;
                                int_5 = anInt675 - Mouse.anInt249;
                                anInt672 = int_5 * 2;
                                anInt675 = int_5 != -1 && int_5 != 1
                                    ? (Mouse.anInt249 + anInt675) / 2
                                    : Mouse.anInt249;
                              } else {
                                if (Keyboard.aBoolArray3[96]) {
                                  anInt672 += (-24 - anInt672) / 2;
                                } else if (Keyboard.aBoolArray3[97]) {
                                  anInt672 += (24 - anInt672) / 2;
                                } else {
                                  anInt672 /= 2;
                                }

                                if (Keyboard.aBoolArray3[98]) {
                                  anInt674 += (12 - anInt674) / 2;
                                } else if (Keyboard.aBoolArray3[99]) {
                                  anInt674 += (-12 - anInt674) / 2;
                                } else {
                                  anInt674 /= 2;
                                }

                                anInt676 = Mouse.anInt251;
                                anInt675 = Mouse.anInt249;
                              }

                              mapAngle = anInt672 / 2 + mapAngle & 0x7FF;
                              anInt653 += anInt674 / 2;
                              if (anInt653 < 128) {
                                anInt653 = 128;
                              }

                              if (anInt653 > 383) {
                                anInt653 = 383;
                              }

                              int_4 = Class11.anInt55 >> 7;
                              int_5 = WorldMapData.anInt107 >> 7;
                              int_6 = Class29.getTileHeight(Class11.anInt55,
                                  WorldMapData.anInt107, Class12.plane);
                              int_7 = 0;
                              int int_9;
                              int int_10;
                              int int_11;
                              if (int_4 > 3 && int_5 > 3 && int_4 < 100
                                  && int_5 < 100) {
                                for (int_8 = int_4 - 4; int_8 <= int_4 + 4; int_8++) {
                                  for (int_9 = int_5
                                      - 4; int_9 <= int_5 + 4; int_9++) {
                                    int_10 = Class12.plane;
                                    if (int_10 < 3
                                        && (Class22.flags[1][int_8][int_9]
                                        & 0x2) == 2) {
                                      ++int_10;
                                    }

                                    int_11 = int_6
                                        - Class22.heightmap[int_10][int_8][int_9];
                                    if (int_11 > int_7) {
                                      int_7 = int_11;
                                    }
                                  }
                                }
                              }

                              int_8 = int_7 * 192;
                              if (int_8 > 98048) {
                                int_8 = 98048;
                              }

                              if (int_8 < 32768) {
                                int_8 = 32768;
                              }

                              if (int_8 > anInt680) {
                                anInt680 += (int_8 - anInt680) / 24;
                              } else if (int_8 < anInt680) {
                                anInt680 += (int_8 - anInt680) / 80;
                              }

                              if (aBool87) {
                                int_2 = 64 + IntegerVariable.anInt85 * 128;
                                int_3 = Mouse.anInt256 * 128 + 64;
                                int_4 = Class29.getTileHeight(int_2, int_3,
                                    Class12.plane) - Player.anInt578;
                                if (Isaac.cameraX < int_2) {
                                  Isaac.cameraX += Inventory.anInt340
                                      + (int_2 - Isaac.cameraX)
                                      * AClass3_Sub2.anInt399 / 1000;
                                  if (Isaac.cameraX > int_2) {
                                    Isaac.cameraX = int_2;
                                  }
                                }

                                if (Isaac.cameraX > int_2) {
                                  Isaac.cameraX -= AClass3_Sub2.anInt399
                                      * (Isaac.cameraX - int_2) / 1000
                                      + Inventory.anInt340;
                                  if (Isaac.cameraX < int_2) {
                                    Isaac.cameraX = int_2;
                                  }
                                }

                                if (WorldMapData.cameraZ < int_4) {
                                  WorldMapData.cameraZ += (int_4
                                      - WorldMapData.cameraZ)
                                      * AClass3_Sub2.anInt399 / 1000
                                      + Inventory.anInt340;
                                  if (WorldMapData.cameraZ > int_4) {
                                    WorldMapData.cameraZ = int_4;
                                  }
                                }

                                if (WorldMapData.cameraZ > int_4) {
                                  WorldMapData.cameraZ -= Inventory.anInt340
                                      + AClass3_Sub2.anInt399
                                      * (WorldMapData.cameraZ - int_4)
                                      / 1000;
                                  if (WorldMapData.cameraZ < int_4) {
                                    WorldMapData.cameraZ = int_4;
                                  }
                                }

                                if (Class29.cameraY < int_3) {
                                  Class29.cameraY += (int_3 - Class29.cameraY)
                                      * AClass3_Sub2.anInt399 / 1000
                                      + Inventory.anInt340;
                                  if (Class29.cameraY > int_3) {
                                    Class29.cameraY = int_3;
                                  }
                                }

                                if (Class29.cameraY > int_3) {
                                  Class29.cameraY -= AClass3_Sub2.anInt399
                                      * (Class29.cameraY - int_3) / 1000
                                      + Inventory.anInt340;
                                  if (Class29.cameraY < int_3) {
                                    Class29.cameraY = int_3;
                                  }
                                }

                                int_2 = AClass1_Sub2.anInt305 * 128 + 64;
                                int_3 = Regulator.anInt257 * 128 + 64;
                                int_4 = Class29.getTileHeight(int_2, int_3,
                                    Class12.plane) - Class54.anInt130;
                                int_5 = int_2 - Isaac.cameraX;
                                int_6 = int_4 - WorldMapData.cameraZ;
                                int_7 = int_3 - Class29.cameraY;
                                int_8 = (int) Math
                                    .sqrt(int_7 * int_7 + int_5 * int_5);
                                int_9 = (int) (Math.atan2(int_6, int_8) * 325.949D)
                                    & 0x7FF;
                                int_10 = (int) (Math.atan2(int_5, int_7) * -325.949D)
                                    & 0x7FF;
                                if (int_9 < 128) {
                                  int_9 = 128;
                                }

                                if (int_9 > 383) {
                                  int_9 = 383;
                                }

                                if (Keyboard.cameraPitch < int_9) {
                                  Keyboard.cameraPitch = (int_9
                                      - Keyboard.cameraPitch)
                                      * Keyboard.anInt129 / 1000
                                      + Keyboard.cameraPitch
                                      + Class48.anInt97;
                                  if (Keyboard.cameraPitch > int_9) {
                                    Keyboard.cameraPitch = int_9;
                                  }
                                }

                                if (Keyboard.cameraPitch > int_9) {
                                  Keyboard.cameraPitch -= Keyboard.anInt129
                                      * (Keyboard.cameraPitch - int_9)
                                      / 1000 + Class48.anInt97;
                                  if (Keyboard.cameraPitch < int_9) {
                                    Keyboard.cameraPitch = int_9;
                                  }
                                }

                                int_11 = int_10 - Boundry.cameraYaw;
                                if (int_11 > 1024) {
                                  int_11 -= 2048;
                                }

                                if (int_11 < -1024) {
                                  int_11 += 2048;
                                }

                                if (int_11 > 0) {
                                  Boundry.cameraYaw += Class48.anInt97
                                      + int_11 * Keyboard.anInt129
                                      / 1000;
                                  Boundry.cameraYaw &= 0x7FF;
                                }

                                if (int_11 < 0) {
                                  Boundry.cameraYaw -= -int_11
                                      * Keyboard.anInt129 / 1000
                                      + Class48.anInt97;
                                  Boundry.cameraYaw &= 0x7FF;
                                }

                                int int_12 = int_10 - Boundry.cameraYaw;
                                if (int_12 > 1024) {
                                  int_12 -= 2048;
                                }

                                if (int_12 < -1024) {
                                  int_12 += 2048;
                                }

                                if (int_12 < 0 && int_11 > 0
                                    || int_12 > 0 && int_11 < 0) {
                                  Boundry.cameraYaw = int_10;
                                }
                              }

                              for (int_2 = 0; int_2 < 5; int_2++) {
                                ++anIntArray164[int_2];
                              }

                              LocalInstall.chatMessages.process();
                              int_2 = Class82.method488();
                              int_3 = Keyboard.keyboardIdleTicks;
                              if (int_2 > 15000 && int_3 > 15000) {
                                anInt595 = 250;
                                Mouse.mouseIdleTicks = 14500;
                                outbound.putEncipheredByte(250);
                              }

                              for (Class69_Sub1 class69_sub1_0 = (Class69_Sub1) aClass75_1
                                  .method463(); class69_sub1_0 != null;
                                  class69_sub1_0 = (Class69_Sub1) aClass75_1
                                      .method465()) {
                                if (class69_sub1_0.second < Time
                                    .currentTimeMillis() / 1000L - 5L) {
                                  if (class69_sub1_0.aShort1 > 0) {
                                    Npc.sendGameMessage(5, "",
                                        class69_sub1_0.aString18
                                            + " has logged in.");
                                  }

                                  if (class69_sub1_0.aShort1 == 0) {
                                    Npc.sendGameMessage(5, "",
                                        class69_sub1_0.aString18
                                            + " has logged out.");
                                  }

                                  class69_sub1_0.method422();
                                }
                              }

                              ++count;
                              if (count > 50) {
                                outbound.putEncipheredByte(143);
                              }

                              try {
                                if (VertexNormal.stream != null
                                    && outbound.offset > 0) {
                                  VertexNormal.stream.write(
                                      outbound.bytes, 0,
                                      outbound.offset);
                                  outbound.offset = 0;
                                  count = 0;
                                  return;
                                }

                                return;
                              } catch (final IOException ioexception_0) {
                                if (anInt595 > 0) {
                                  Class4.method123();
                                  return;
                                }

                                Mouse.setGameState(40);
                                Class53.aSocketStream1 = VertexNormal.stream;
                                VertexNormal.stream = null;
                                return;
                              }
                            }

                            widget_2 = scriptevent_0.widget;
                            if (widget_2.index < 0) {
                              break;
                            }

                            widget_3 = ScriptExecutor.method240(widget_2.parentId);
                          } while (widget_3 == null || widget_3.children == null
                              || widget_2.index >= widget_3.children.length
                              || widget_2 != widget_3.children[widget_2.index]);

                          Position.execute(scriptevent_0);
                        }
                      }

                      widget_2 = scriptevent_0.widget;
                      if (widget_2.index < 0) {
                        break;
                      }

                      widget_3 = ScriptExecutor.method240(widget_2.parentId);
                    } while (widget_3 == null || widget_3.children == null
                        || widget_2.index >= widget_3.children.length
                        || widget_2 != widget_3.children[widget_2.index]);

                    Position.execute(scriptevent_0);
                  }
                }

                widget_2 = scriptevent_0.widget;
                if (widget_2.index < 0) {
                  break;
                }

                widget_3 = ScriptExecutor.method240(widget_2.parentId);
              } while (widget_3 == null || widget_3.children == null
                  || widget_2.index >= widget_3.children.length
                  || widget_2 != widget_3.children[widget_2.index]);

              Position.execute(scriptevent_0);
            }
          }
        }
      }
    }
  }

  final void method1060() {
    try {
      if (loginState == 0) {
        if (VertexNormal.stream != null) {
          VertexNormal.stream.close();
          VertexNormal.stream = null;
        }

        WallObject.aTask2 = null;
        panic = false;
        anInt603 = 0;
        loginState = 1;
      }

      if (loginState == 1) {
        if (WallObject.aTask2 == null) {
          WallObject.aTask2 = Stub.taskManager.createSocket(host, OpenedInterface.myWorldPort);
        }

        if (WallObject.aTask2.status == 2) {
          throw new IOException();
        }

        if (WallObject.aTask2.status == 1) {
          VertexNormal.stream = new SocketStream((Socket) WallObject.aTask2.result, Stub.taskManager);
          WallObject.aTask2 = null;
          loginState = 2;
        }
      }

      if (loginState == 2) {
        outbound.offset = 0;
        outbound.putByte(14);
        VertexNormal.stream.write(outbound.bytes, 0, 1);
        secretPacketBuffer2.offset = 0;
        loginState = 3;
      }

      int int_0;
      if (loginState == 3) {
        if (ScriptExecutor.soundSystem0 != null) {
          ScriptExecutor.soundSystem0.method360();
        }

        if (WorldMapType1.soundSystem1 != null) {
          WorldMapType1.soundSystem1.method360();
        }

        int_0 = VertexNormal.stream.readByte();
        if (ScriptExecutor.soundSystem0 != null) {
          ScriptExecutor.soundSystem0.method360();
        }

        if (WorldMapType1.soundSystem1 != null) {
          WorldMapType1.soundSystem1.method360();
        }

        if (int_0 != 0) {
          Class52.method331(int_0);
          return;
        }

        secretPacketBuffer2.offset = 0;
        loginState = 4;
      }

      if (loginState == 4) {
        if (secretPacketBuffer2.offset < 8) {
          int_0 = VertexNormal.stream.available();
          if (int_0 > 8 - secretPacketBuffer2.offset) {
            int_0 = 8 - secretPacketBuffer2.offset;
          }

          if (int_0 > 0) {
            VertexNormal.stream
                .read(secretPacketBuffer2.bytes, secretPacketBuffer2.offset, int_0);
            secretPacketBuffer2.offset += int_0;
          }
        }

        if (secretPacketBuffer2.offset == 8) {
          secretPacketBuffer2.offset = 0;
          Class48.aLong3 = secretPacketBuffer2.getLong();
          loginState = 5;
        }
      }

      int int_1;
      int int_2;
      if (loginState == 5) {
        final int[] ints_0 = new int[] {
            (int) (Math.random() * 9.9999999E7D),
            (int) (Math.random() * 9.9999999E7D), (int) (Class48.aLong3 >> 32),
            (int) (Class48.aLong3 & 0xFFFFFFFFFFFFFFFFL)
        };
        outbound.offset = 0;
        outbound.putByte(1);
        outbound.putByte(LoginScreen.anEnum3_1.mappedOrdinal());
        outbound.putInt(ints_0[0]);
        outbound.putInt(ints_0[1]);
        outbound.putInt(ints_0[2]);
        outbound.putInt(ints_0[3]);
        switch (LoginScreen.anEnum3_1.anInt338) {
          case 0:
          case 3:
            outbound.putMedium(ClassInfo.authCodeForLogin);
            outbound.offset += 5;
            break;
          case 1:
            outbound.putInt(((Integer) LongVariable.preferences.preferences
                .get(Integer.valueOf(FaceNormal.method553(LoginScreen.username)))).intValue());
            outbound.offset += 4;
            break;
          case 2:
            outbound.offset += 8;
        }

        outbound.putString(LoginScreen.password);
        outbound.encipher(Class26.rsaKeyExponent, Class26.rsaKeyModulus);
        aPacketBuffer1.offset = 0;
        if (state == 40) {
          aPacketBuffer1.putByte(18);
        } else {
          aPacketBuffer1.putByte(16);
        }

        aPacketBuffer1.putShort(0);
        int_1 = aPacketBuffer1.offset;
        aPacketBuffer1.putInt(153);
        aPacketBuffer1.put(outbound.bytes, 0, outbound.offset);
        int_2 = aPacketBuffer1.offset;
        aPacketBuffer1.putString(LoginScreen.username);
        aPacketBuffer1.putByte((isResized ? 1 : 0) << 1 | (lowMemory ? 1 : 0));
        aPacketBuffer1.putShort(Stub.canvasWidth);
        aPacketBuffer1.putShort(Class34.canvasHeight);
        final GameBuffer packetbuffer_0 = aPacketBuffer1;
        if (aByteArray28 != null) {
          packetbuffer_0.put(aByteArray28, 0, aByteArray28.length);
        } else {
          final byte[] bytes_0 = Class66.method412();
          packetbuffer_0.put(bytes_0, 0, bytes_0.length);
        }

        aPacketBuffer1.putString(sessionToken);
        aPacketBuffer1.putInt(Class27.anInt76);
        final Buffer buffer_0 = new Buffer(ChatLineBuffer.aMachineInfo1.method681());
        ChatLineBuffer.aMachineInfo1.method682(buffer_0);
        aPacketBuffer1.put(buffer_0.bytes, 0, buffer_0.bytes.length);
        aPacketBuffer1.putByte(Friend.anInt203);
        aPacketBuffer1.putInt(0);
        aPacketBuffer1.putInt(Class4.indexInterfaces.checksum);
        aPacketBuffer1.putInt(ScriptState.indexSoundEffects.checksum);
        aPacketBuffer1.putInt(AClass1.configsIndex.checksum);
        aPacketBuffer1.putInt(Class37.anIndexData1.checksum);
        aPacketBuffer1.putInt(anIndexData5.checksum);
        aPacketBuffer1.putInt(Class44.maps.checksum);
        aPacketBuffer1.putInt(CacheableNode_Sub4.indexTrack1.checksum);
        aPacketBuffer1.putInt(Boundry.indexModels.checksum);
        aPacketBuffer1.putInt(Time.indexSprites.checksum);
        aPacketBuffer1.putInt(Square.indexTextures.checksum);
        aPacketBuffer1.putInt(Mouse.anIndexData4.checksum);
        aPacketBuffer1.putInt(State.indexTrack2.checksum);
        aPacketBuffer1.putInt(FrameBase.indexScripts.checksum);
        aPacketBuffer1.putInt(FontType.anIndexData3.checksum);
        aPacketBuffer1.putInt(Enum.vorbisIndex.checksum);
        aPacketBuffer1.putInt(Class85.anIndexData2.checksum);
        aPacketBuffer1.putInt(VertexNormal.indexWorldMap.checksum);
        aPacketBuffer1.encipher(ints_0, int_2, aPacketBuffer1.offset);
        aPacketBuffer1.putLengthShort(aPacketBuffer1.offset - int_1);
        VertexNormal.stream.write(aPacketBuffer1.bytes, 0, aPacketBuffer1.offset);
        outbound.seed(ints_0);

        for (int int_3 = 0; int_3 < 4; int_3++) {
          ints_0[int_3] += 50;
        }

        secretPacketBuffer2.seed(ints_0);
        loginState = 6;
      }

      if (loginState == 6 && VertexNormal.stream.available() > 0) {
        int_0 = VertexNormal.stream.readByte();
        if (int_0 == 21 && state == 20) {
          loginState = 7;
        } else if (int_0 == 2) {
          loginState = 9;
        } else if (int_0 == 15 && state == 40) {
          packetLength = -1;
          loginState = 13;
        } else if (int_0 == 23 && anInt594 < 1) {
          ++anInt594;
          loginState = 0;
        } else {
          if (int_0 != 29) {
            Class52.method331(int_0);
            return;
          }

          loginState = 11;
        }
      }

      if (loginState == 7 && VertexNormal.stream.available() > 0) {
        anInt635 = (VertexNormal.stream.readByte() + 3) * 60;
        loginState = 8;
      }

      if (loginState == 8) {
        anInt603 = 0;
        Class24.method218("You have only just left another world.",
            "Your profile will be transferred in:",
            anInt635 / 60 + " seconds.");
        if (--anInt635 <= 0) {
          loginState = 0;
        }
      } else {
        boolean bool_1;
        if (loginState == 9 && VertexNormal.stream.available() >= 13) {
          final boolean bool_0 = VertexNormal.stream.readByte() == 1;
          VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 4);
          secretPacketBuffer2.offset = 0;
          bool_1 = false;
          if (bool_0) {
            int_1 = secretPacketBuffer2.getDecipheredByte() << 24;
            int_1 |= secretPacketBuffer2.getDecipheredByte() << 16;
            int_1 |= secretPacketBuffer2.getDecipheredByte() << 8;
            int_1 |= secretPacketBuffer2.getDecipheredByte();
            int_2 = FaceNormal.method553(LoginScreen.username);
            if (LongVariable.preferences.preferences.size() >= 10
                && !LongVariable.preferences.preferences.containsKey(Integer.valueOf(int_2))) {
              final Iterator iterator_0 = LongVariable.preferences.preferences.entrySet().iterator();
              iterator_0.next();
              iterator_0.remove();
            }

            LongVariable.preferences.preferences.put(Integer.valueOf(int_2), Integer.valueOf(int_1));
            Class4.method125();
          }

          rights = VertexNormal.stream.readByte();
          aBool88 = VertexNormal.stream.readByte() == 1;
          localInteractingIndex = VertexNormal.stream.readByte();
          localInteractingIndex <<= 8;
          localInteractingIndex += VertexNormal.stream.readByte();
          anInt663 = VertexNormal.stream.readByte();
          VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 1);
          secretPacketBuffer2.offset = 0;
          packetType = secretPacketBuffer2.getDecipheredByte();
          VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 2);
          secretPacketBuffer2.offset = 0;
          packetLength = secretPacketBuffer2.getUnsignedShort();

          try {
            Class21.method206(Enum1.clientInstance, "zap");
          } catch (final Throwable throwable_0) {
          }

          loginState = 10;
        }

        if (loginState == 10) {
          if (VertexNormal.stream.available() >= packetLength) {
            secretPacketBuffer2.offset = 0;
            VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, packetLength);
            aLong26 = -1L;
            anInt609 = -1;
            ScriptExecutor.aClass19_1.anInt69 = 0;
            Area.aBool52 = true;
            aBool83 = true;
            aLong27 = -1L;
            Class103.aCombatInfoList3 = new IterableQueue();
            outbound.offset = 0;
            secretPacketBuffer2.offset = 0;
            packetType = -1;
            lastFrameId = -1;
            secondLastFrameId = -1;
            thridLastFrameId = -1;
            anInt633 = 0;
            anInt593 = 0;
            anInt595 = 0;
            anInt614 = 0;
            menuOptionCount = 0;
            isMenuOpen = false;
            Mouse.mouseIdleTicks = 0;
            Class36.chatLineMap.clear();
            Class36.anIterableHashTable1.clear();
            Class36.aClass76_1.clear();
            Class36.anInt88 = 0;
            itemSelectionState = 0;
            spellSelected = false;
            anInt648 = 0;
            mapAngle = 0;
            anInt644 = 0;
            anInt660 = -1;
            destinationX = 0;
            destinationY = 0;
            anEnum2_5 = Enum2.anEnum2_4;
            anEnum2_6 = Enum2.anEnum2_4;
            anInt636 = 0;
            Class11.method160();

            for (int_0 = 0; int_0 < 2048; int_0++) {
              cachedPlayers[int_0] = null;
            }

            for (int_0 = 0; int_0 < 32768; int_0++) {
              cachedNPCs[int_0] = null;
            }

            anInt652 = -1;
            projectiles.clear();
            graphicsObjectDeque.clear();

            for (int_0 = 0; int_0 < 4; int_0++) {
              for (int_1 = 0; int_1 < 104; int_1++) {
                for (int_2 = 0; int_2 < 104; int_2++) {
                  groundItemDeque[int_0][int_1][int_2] = null;
                }
              }
            }

            pendingSpawns = new Deque();
            anInt687 = 0;
            friendCount = 0;
            ignoreCount = 0;

            for (int_0 = 0; int_0 < variableCount; int_0++) {
              final PlayerVariable varplayertype_0 = Class64.method406(int_0);
              if (varplayertype_0 != null) {
                Class85.settings[int_0] = 0;
                Class85.widgetSettings[int_0] = 0;
              }
            }

            LocalInstall.chatMessages.reset();
            anInt679 = -1;
            if (widgetRoot != -1) {
              int_0 = widgetRoot;
              if (int_0 != -1 && PrimitiveType.validInterfaces[int_0]) {
                AudioWorker.widgetIndex.clear(int_0);
                if (Time.widgets[int_0] != null) {
                  bool_1 = true;

                  for (int_2 = 0; int_2 < Time.widgets[int_0].length; int_2++) {
                    if (Time.widgets[int_0][int_2] != null) {
                      if (Time.widgets[int_0][int_2].type != 2) {
                        Time.widgets[int_0][int_2] = null;
                      } else {
                        bool_1 = false;
                      }
                    }
                  }

                  if (bool_1) {
                    Time.widgets[int_0] = null;
                  }

                  PrimitiveType.validInterfaces[int_0] = false;
                }
              }
            }

            for (OpenedInterface widgetnode_0 = (OpenedInterface) componentTable
                .method66(); widgetnode_0 != null; widgetnode_0 = (OpenedInterface) componentTable
                .method67()) {
              Comparator0.method305(widgetnode_0, true);
            }

            widgetRoot = -1;
            componentTable = new HashTable(8);
            aWidget13 = null;
            menuOptionCount = 0;
            isMenuOpen = false;
            aPlayerComposition1.method499(null, new int[] {0, 0, 0, 0, 0}, false, -1);

            for (int_0 = 0; int_0 < 8; int_0++) {
              playerOptions[int_0] = null;
              playerOptionsPriorities[int_0] = false;
            }

            RemoteEnvironment.method525();
            aBool82 = true;

            for (int_0 = 0; int_0 < 100; int_0++) {
              aBoolArray8[int_0] = true;
            }

            Class51.method327();
            clanChatOwner = null;
            Node_Sub1.clanChatCount = 0;
            AClass1.clanMembers = null;

            for (int_0 = 0; int_0 < 8; int_0++) {
              grandExchangeOffers[int_0] = new GrandExchangeOffer();
            }

            Class22.aClass45_1 = null;
            Materials.initializeGPI(secretPacketBuffer2);
            Class45.anInt96 = -1;
            Class29.xteaChanged(false);
            packetType = -1;
          }
        } else {
          if (loginState == 11 && VertexNormal.stream.available() >= 2) {
            secretPacketBuffer2.offset = 0;
            VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 2);
            secretPacketBuffer2.offset = 0;
            Class2.len = secretPacketBuffer2.getUnsignedShort();
            loginState = 12;
          }

          if (loginState == 12 && VertexNormal.stream.available() >= Class2.len) {
            secretPacketBuffer2.offset = 0;
            VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, Class2.len);
            secretPacketBuffer2.offset = 0;
            final String string_2 = secretPacketBuffer2.getString();
            final String string_0 = secretPacketBuffer2.getString();
            final String string_1 = secretPacketBuffer2.getString();
            Class24.method218(string_2, string_0, string_1);
            Mouse.setGameState(10);
          }

          if (loginState != 13) {
            ++anInt603;
            if (anInt603 > 2000) {
              if (anInt594 < 1) {
                if (Class103.anInt201 == OpenedInterface.myWorldPort) {
                  OpenedInterface.myWorldPort = Class29.anInt81;
                } else {
                  OpenedInterface.myWorldPort = Class103.anInt201;
                }

                ++anInt594;
                loginState = 0;
              } else {
                Class52.method331(-3);
              }
            }
          } else {
            if (packetLength == -1) {
              if (VertexNormal.stream.available() < 2) {
                return;
              }

              VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, 2);
              secretPacketBuffer2.offset = 0;
              packetLength = secretPacketBuffer2.getUnsignedShort();
            }

            if (VertexNormal.stream.available() >= packetLength) {
              VertexNormal.stream.read(secretPacketBuffer2.bytes, 0, packetLength);
              secretPacketBuffer2.offset = 0;
              int_0 = packetLength;
              outbound.offset = 0;
              secretPacketBuffer2.offset = 0;
              packetType = -1;
              lastFrameId = -1;
              secondLastFrameId = -1;
              thridLastFrameId = -1;
              packetLength = 0;
              anInt633 = 0;
              anInt593 = 0;
              menuOptionCount = 0;
              isMenuOpen = false;
              anInt644 = 0;
              destinationX = 0;

              for (int_1 = 0; int_1 < 2048; int_1++) {
                cachedPlayers[int_1] = null;
              }

              GrandExchangeOffer.localPlayer = null;

              for (int_1 = 0; int_1 < cachedNPCs.length; int_1++) {
                final Npc npc_0 = cachedNPCs[int_1];
                if (npc_0 != null) {
                  npc_0.interacting = -1;
                  npc_0.aBool64 = false;
                }
              }

              RemoteEnvironment.method525();
              Mouse.setGameState(30);

              for (int_1 = 0; int_1 < 100; int_1++) {
                aBoolArray8[int_1] = true;
              }

              Class51.method327();
              Materials.initializeGPI(secretPacketBuffer2);
              if (int_0 != secretPacketBuffer2.offset) {
                throw new RuntimeException();
              }
            }
          }
        }
      }
    } catch (final IOException ioexception_0) {
      if (anInt594 < 1) {
        if (Class103.anInt201 == OpenedInterface.myWorldPort) {
          OpenedInterface.myWorldPort = Class29.anInt81;
        } else {
          OpenedInterface.myWorldPort = Class103.anInt201;
        }

        ++anInt594;
        loginState = 0;
      } else {
        Class52.method331(-2);
      }
    }
  }

  @Override
  protected final void method1042() {
    aLong25 = Time.currentTimeMillis() + 500L;
    method1053();
    if (widgetRoot != -1) {
      method1054(true);
    }

  }

  @Override
  protected final void method1045(final boolean bool_0) {
    boolean bool_1;
    label182:
    {
      try {
        if (Class72.anInt168 == 2) {
          if (Class72.aTrack1_1 == null) {
            Class72.aTrack1_1 = Track1.getMusicFile(Class72.anIndexDataBase4, Enum3.anInt339,
                RuntimeException_Sub1.anInt527);
            if (Class72.aTrack1_1 == null) {
              bool_1 = false;
              break label182;
            }
          }

          if (Class72.aClass55_1 == null) {
            Class72.aClass55_1 = new Class55(Class72.anIndexDataBase5, Class72.anIndexDataBase6);
          }

          if (Class72.anAClass4_Sub3_1.method799(Class72.aTrack1_1, Class72.anIndexDataBase7,
              Class72.aClass55_1, 22050)) {
            Class72.anAClass4_Sub3_1.method806();
            Class72.anAClass4_Sub3_1.method809(Class72.anInt170);
            Class72.anAClass4_Sub3_1.method811(Class72.aTrack1_1, Class36.aBool8);
            Class72.anInt168 = 0;
            Class72.aTrack1_1 = null;
            Class72.aClass55_1 = null;
            Class72.anIndexDataBase4 = null;
            bool_1 = true;
            break label182;
          }
        }
      } catch (final Exception exception_0) {
        exception_0.printStackTrace();
        Class72.anAClass4_Sub3_1.method790();
        Class72.anInt168 = 0;
        Class72.aTrack1_1 = null;
        Class72.aClass55_1 = null;
        Class72.anIndexDataBase4 = null;
      }

      bool_1 = false;
    }

    if (bool_1 && aBool81 && ScriptExecutor.soundSystem0 != null) {
      ScriptExecutor.soundSystem0.method356();
    }

    int int_0;
    if ((state == 10 || state == 20 || state == 30) && aLong25 != 0L
        && Time.currentTimeMillis() > aLong25) {
      int_0 = Class45.method287();
      aLong25 = 0L;
      if (int_0 >= 2) {
        isResized = true;
      } else {
        isResized = false;
      }

      if (Class45.method287() == 1) {
        Enum1.clientInstance.method1041(765, 503);
      } else {
        Enum1.clientInstance.method1041(7680, 2160);
      }

      if (state >= 25) {
        Class51.method327();
      }
    }

    if (bool_0) {
      for (int_0 = 0; int_0 < 100; int_0++) {
        aBoolArray8[int_0] = true;
      }
    }

    if (state == 0) {
      drawLoadingBar(LoginScreen.loadingPercent, LoginScreen.loadingText, bool_0);
    } else if (state == 5) {
      AClass4_Sub4
          .drawLoginScreen(Class22.aFont3, VertexNormal.aFont5, Class12.font_p12full, bool_0);
    } else if (state != 10 && state != 11) {
      if (state == 20) {
        AClass4_Sub4
            .drawLoginScreen(Class22.aFont3, VertexNormal.aFont5, Class12.font_p12full, bool_0);
      } else if (state == 25) {
        if (anInt612 == 1) {
          if (anInt615 > anInt618) {
            anInt618 = anInt615;
          }

          int_0 = (anInt618 * 50 - anInt615 * 50) / anInt618;
          Class51
              .drawStatusBox("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
        } else if (anInt612 == 2) {
          if (anInt621 > anInt623) {
            anInt623 = anInt621;
          }

          int_0 = (anInt623 * 50 - anInt621 * 50) / anInt623 + 50;
          Class51
              .drawStatusBox("Loading - please wait." + "<br>" + " (" + int_0 + "%" + ")", false);
        } else {
          Class51.drawStatusBox("Loading - please wait.", false);
        }
      } else if (state == 30) {
        method1058();
      } else if (state == 40) {
        Class51
            .drawStatusBox("Connection lost" + "<br>" + "Please wait - attempting to reestablish",
                false);
      } else if (state == 45) {
        Class51.drawStatusBox("Please wait...", false);
      }
    } else {
      AClass4_Sub4
          .drawLoginScreen(Class22.aFont3, VertexNormal.aFont5, Class12.font_p12full, bool_0);
    }

    if (state == 30 && gameDrawingMode == 0 && !bool_0 && !isResized) {
      for (int_0 = 0; int_0 < anInt596; int_0++) {
        if (aBoolArray10[int_0]) {
          FileCache.aBufferProvider1.method497(widgetPositionX[int_0], widgetPositionY[int_0],
              widgetBoundsWidth[int_0], widgetBoundsHeight[int_0]);
          aBoolArray10[int_0] = false;
        }
      }
    } else if (state > 0) {
      FileCache.aBufferProvider1.draw(0, 0);

      for (int_0 = 0; int_0 < anInt596; int_0++) {
        aBoolArray10[int_0] = false;
      }
    }

  }

  void method1061(final InterfaceComponent widget_0) {
    final InterfaceComponent widget_1 = widget_0.parentId == -1 ? null : ScriptExecutor.method240(widget_0.parentId);
    int int_0;
    int int_1;
    if (widget_1 == null) {
      int_0 = Stub.canvasWidth;
      int_1 = Class34.canvasHeight;
    } else {
      int_0 = widget_1.width;
      int_1 = widget_1.height;
    }

    WorldMapType2.method563(widget_0, int_0, int_1, false);
    Comparator0.method303(widget_0, int_0, int_1);
  }

  final void method1062() {
    boolean bool_0 = false;

    int int_0;
    int int_1;
    while (!bool_0) {
      bool_0 = true;

      for (int_0 = 0; int_0 < menuOptionCount - 1; int_0++) {
        if (menuTypes[int_0] < 1000 && menuTypes[int_0 + 1] > 1000) {
          final String string_0 = menuTargets[int_0];
          menuTargets[int_0] = menuTargets[int_0 + 1];
          menuTargets[int_0 + 1] = string_0;
          final String string_1 = menuOptions[int_0];
          menuOptions[int_0] = menuOptions[int_0 + 1];
          menuOptions[int_0 + 1] = string_1;
          int_1 = menuTypes[int_0];
          menuTypes[int_0] = menuTypes[int_0 + 1];
          menuTypes[int_0 + 1] = int_1;
          int_1 = menuActionParams0[int_0];
          menuActionParams0[int_0] = menuActionParams0[int_0 + 1];
          menuActionParams0[int_0 + 1] = int_1;
          int_1 = menuActionParams1[int_0];
          menuActionParams1[int_0] = menuActionParams1[int_0 + 1];
          menuActionParams1[int_0 + 1] = int_1;
          int_1 = menuIdentifiers[int_0];
          menuIdentifiers[int_0] = menuIdentifiers[int_0 + 1];
          menuIdentifiers[int_0 + 1] = int_1;
          final boolean bool_1 = aBoolArray11[int_0];
          aBoolArray11[int_0] = aBoolArray11[int_0 + 1];
          aBoolArray11[int_0 + 1] = bool_1;
          bool_0 = false;
        }
      }
    }

    if (Class29.aWidget3 == null) {
      if (aWidget9 == null) {
        int int_7 = Mouse.anInt248;
        int int_3;
        int int_5;
        int int_6;
        int int_8;
        if (isMenuOpen) {
          int int_2;
          if (int_7 != 1 && (GrandExchangeOffer.aBool5 || int_7 != 4)) {
            int_0 = Mouse.anInt249;
            int_2 = Mouse.anInt251;
            if (int_0 < menuX - 10 || int_0 > GrandExchangeOffer.menuWidth + menuX + 10
                || int_2 < AnimationSequence.menuY - 10
                || int_2 > Class31.menuHeight + AnimationSequence.menuY + 10) {
              isMenuOpen = false;
              Class26.method230(menuX, AnimationSequence.menuY, GrandExchangeOffer.menuWidth,
                  Class31.menuHeight);
            }
          }

          if (int_7 == 1 || !GrandExchangeOffer.aBool5 && int_7 == 4) {
            int_0 = menuX;
            int_2 = AnimationSequence.menuY;
            int_3 = GrandExchangeOffer.menuWidth;
            int_1 = Mouse.anInt253;
            int_8 = Mouse.anInt254;
            int int_4 = -1;

            for (int_5 = 0; int_5 < menuOptionCount; int_5++) {
              int_6 = int_2 + 31 + (menuOptionCount - 1 - int_5) * 15;
              if (int_1 > int_0 && int_1 < int_3 + int_0 && int_8 > int_6 - 13
                  && int_8 < int_6 + 3) {
                int_4 = int_5;
              }
            }

            if (int_4 != -1) {
              Position.method512(int_4);
            }

            isMenuOpen = false;
            Class26
                .method230(menuX, AnimationSequence.menuY, GrandExchangeOffer.menuWidth, Class31.menuHeight);
            return;
          }
        } else {
          int_0 = menuOptionCount - 1;
          if ((int_7 == 1 || !GrandExchangeOffer.aBool5 && int_7 == 4) && int_0 >= 0) {
            int_3 = menuTypes[int_0];
            if (int_3 == 39 || int_3 == 40 || int_3 == 41 || int_3 == 42 || int_3 == 43
                || int_3 == 33 || int_3 == 34 || int_3 == 35 || int_3 == 36 || int_3 == 37
                || int_3 == 38 || int_3 == 1005) {
              int_1 = menuActionParams0[int_0];
              int_8 = menuActionParams1[int_0];
              final InterfaceComponent widget_0 = ScriptExecutor.method240(int_8);
              if (Class27.method235(getWidgetConfig(widget_0))
                  || Class25.method224(getWidgetConfig(widget_0))) {
                if (Class29.aWidget3 != null && !aBool84 && menuOptionCount > 0
                    && !method1055()) {
                  int_5 = anInt630;
                  int_6 = anInt631;
                  final Class28 class28_0 = Comparator0.aClass28_1;
                  menuAction(class28_0.anInt77, class28_0.anInt78, class28_0.anInt79,
                      class28_0.anInt80, class28_0.aString6, class28_0.aString6, int_5, int_6);
                  Comparator0.aClass28_1 = null;
                }

                aBool84 = false;
                anInt627 = 0;
                if (Class29.aWidget3 != null) {
                  Class28.method236(Class29.aWidget3);
                }

                Class29.aWidget3 = ScriptExecutor.method240(int_8);
                anInt632 = int_1;
                anInt630 = Mouse.anInt253;
                anInt631 = Mouse.anInt254;
                if (int_0 >= 0) {
                  Comparator0.aClass28_1 = new Class28();
                  Comparator0.aClass28_1.anInt77 = menuActionParams0[int_0];
                  Comparator0.aClass28_1.anInt78 = menuActionParams1[int_0];
                  Comparator0.aClass28_1.anInt79 = menuTypes[int_0];
                  Comparator0.aClass28_1.anInt80 = menuIdentifiers[int_0];
                  Comparator0.aClass28_1.aString6 = menuOptions[int_0];
                }

                Class28.method236(Class29.aWidget3);
                return;
              }
            }
          }

          if ((int_7 == 1 || !GrandExchangeOffer.aBool5 && int_7 == 4) && method1055()) {
            int_7 = 2;
          }

          if ((int_7 == 1 || !GrandExchangeOffer.aBool5 && int_7 == 4) && menuOptionCount
              > 0) {
            Position.method512(int_0);
          }

          if (int_7 == 2 && menuOptionCount > 0) {
            method1056(Mouse.anInt253, Mouse.anInt254);
            return;
          }
        }

      }
    }
  }

  final void method1063() {
    Class28.method236(aWidget9);
    ++Class3.anInt21;
    if (aBool78 && aBool79) {
      int int_0 = Mouse.anInt249;
      int int_1 = Mouse.anInt251;
      int_0 -= anInt604;
      int_1 -= anInt605;
      if (int_0 < anInt606) {
        int_0 = anInt606;
      }

      if (int_0 + aWidget9.width > anInt606 + aWidget10.width) {
        int_0 = anInt606 + aWidget10.width - aWidget9.width;
      }

      if (int_1 < anInt611) {
        int_1 = anInt611;
      }

      if (int_1 + aWidget9.height > anInt611 + aWidget10.height) {
        int_1 = anInt611 + aWidget10.height - aWidget9.height;
      }

      final int int_2 = int_0 - anInt628;
      final int int_3 = int_1 - anInt629;
      final int int_4 = aWidget9.anInt275;
      if (Class3.anInt21 > aWidget9.anInt277
          && (int_2 > int_4 || int_2 < -int_4 || int_3 > int_4 || int_3 < -int_4)) {
        aBool85 = true;
      }

      final int int_5 = int_0 - anInt606 + aWidget10.scrollX;
      final int int_6 = int_1 - anInt611 + aWidget10.scrollY;
      ScriptCall scriptevent_0;
      if (aWidget9.anObjectArray3 != null && aBool85) {
        scriptevent_0 = new ScriptCall();
        scriptevent_0.widget = aWidget9;
        scriptevent_0.anInt380 = int_5;
        scriptevent_0.anInt381 = int_6;
        scriptevent_0.anObjectArray22 = aWidget9.anObjectArray3;
        Position.execute(scriptevent_0);
      }

      if (Mouse.anInt252 == 0) {
        if (aBool85) {
          if (aWidget9.anObjectArray4 != null) {
            scriptevent_0 = new ScriptCall();
            scriptevent_0.widget = aWidget9;
            scriptevent_0.anInt380 = int_5;
            scriptevent_0.anInt381 = int_6;
            scriptevent_0.aWidget8 = aWidget12;
            scriptevent_0.anObjectArray22 = aWidget9.anObjectArray4;
            Position.execute(scriptevent_0);
          }

          if (aWidget12 != null && Preferences.method424(aWidget9) != null) {
            outbound.putEncipheredByte(47);
            outbound.putLeShortAdd(aWidget9.itemId);
            outbound.putIntMe(aWidget12.id);
            outbound.putShortAdd(aWidget9.index);
            outbound.putLeInt(aWidget9.id);
            outbound.putShortAdd(aWidget12.index);
            outbound.putShort(aWidget12.itemId);
          }
        } else if (method1055()) {
          method1056(anInt604 + anInt628, anInt605 + anInt629);
        } else if (menuOptionCount > 0) {
          final int int_7 = anInt628 + anInt604;
          final int int_8 = anInt629 + anInt605;
          final Class28 class28_0 = Comparator0.aClass28_1;
          menuAction(class28_0.anInt77, class28_0.anInt78, class28_0.anInt79,
              class28_0.anInt80,
              class28_0.aString6, class28_0.aString6, int_7, int_8);
          Comparator0.aClass28_1 = null;
        }

        aWidget9 = null;
      }
    } else {
      if (Class3.anInt21 > 1) {
        aWidget9 = null;
      }

    }
  }

  @Override
  public final void init() {
    if (isValidHost()) {
      final Parameter[] parameterss_0 = Occluder.method402();

      int int_4;
      for (int int_0 = 0; int_0 < parameterss_0.length; int_0++) {
        final Parameter parameters_0 = parameterss_0[int_0];
        final String string_0 = getParameter(parameters_0.key);
        if (string_0 != null) {
          switch (Integer.parseInt(parameters_0.key)) {
            case 1:
              if (string_0.equalsIgnoreCase("true")) {
              }
              break;
            case 2:
              final int int_10 = Integer.parseInt(string_0);
              final RemoteEnvironment[] buildtypes_0 = new RemoteEnvironment[] {
                  RemoteEnvironment.LIVE_BUILD, RemoteEnvironment.RELEASE_CANDIDATE,
                  RemoteEnvironment.WORK_IN_PROGRESS, RemoteEnvironment.LIVE
              };
              final RemoteEnvironment[] buildtypes_1 = buildtypes_0;
              int_4 = 0;

              RemoteEnvironment buildtype_0;
              while (true) {
                if (int_4 >= buildtypes_1.length) {
                  buildtype_0 = null;
                  break;
                }

                final RemoteEnvironment buildtype_1 = buildtypes_1[int_4];
                if (int_10 == buildtype_1.ordinal) {
                  buildtype_0 = buildtype_1;
                  break;
                }

                ++int_4;
              }

              Class47.remoteEnv = buildtype_0;
            case 3:
            case 10:
            case 11:
            default:
              break;
            case 4:
              if (string_0.equalsIgnoreCase("true")) {
                isMembers = true;
              } else {
                isMembers = false;
              }
              break;
            case 5:
              flags = Integer.parseInt(string_0);
              break;
            case 6:
              Friend.anInt203 = Integer.parseInt(string_0);
              break;
            case 7:
              languageId = Integer.parseInt(string_0);
              break;
            case 8:
              Class22.aString3 = string_0;
              break;
            case 9:
              Class27.anInt76 = Integer.parseInt(string_0);
              break;
            case 12:
              world = Integer.parseInt(string_0);
              break;
            case 13:
              socketType = Integer.parseInt(string_0);
              break;
            case 14:
              sessionToken = string_0;
              break;
            case 15:
              Class12.game = (Game) PlayerIdentity.forOrdinal(Class40.method269(),
                  Integer.parseInt(string_0));
              if (Class12.game == Game.OLDSCHOOL) {
                AClass1_Sub2.aClass108_10 = Class108.aClass108_1;
              } else {
                AClass1_Sub2.aClass108_10 = Class108.aClass108_9;
              }
          }
        }
      }

      LoginScreen.method300();
      host = getCodeBase().getHost();
      final String string_2 = Class47.remoteEnv.identifier;
      final byte byte_0 = 0;

      try {
        LocalInstall.anInt158 = 17;
        Class26.anInt75 = byte_0;

        try {
          AbstractByteBuffer.osName = System.getProperty("os.name");
        } catch (final Exception exception_1) {
          AbstractByteBuffer.osName = "Unknown";
        }

        Class45.formattedOsName = AbstractByteBuffer.osName.toLowerCase();

        try {
          WorldMapType1.userHome = System.getProperty("user.home");
          if (WorldMapType1.userHome != null) {
            WorldMapType1.userHome = WorldMapType1.userHome + "/";
          }
        } catch (final Exception exception_2) {
        }

        try {
          if (Class45.formattedOsName.startsWith("win")) {
            if (WorldMapType1.userHome == null) {
              WorldMapType1.userHome = System.getenv("USERPROFILE");
            }
          } else if (WorldMapType1.userHome == null) {
            WorldMapType1.userHome = System.getenv("HOME");
          }

          if (WorldMapType1.userHome != null) {
            WorldMapType1.userHome = WorldMapType1.userHome + "/";
          }
        } catch (final Exception exception_3) {
        }

        if (WorldMapType1.userHome == null) {
          WorldMapType1.userHome = "~/";
        }

        LocalInstall.cacheParentPaths = new String[] {
            "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/",
            WorldMapType1.userHome, "/tmp/", ""
        };
        LocalInstall.cacheInstallPaths = new String[] {
            ".jagex_cache_" + Class26.anInt75,
            ".file_store_" + Class26.anInt75
        };
        int int_1 = 0;

        label273:
        while (int_1 < 4) {
          final String string_3 = int_1 == 0 ? "" : "" + int_1;
          LocalInstall.aFile2 = new File(WorldMapType1.userHome,
              "jagex_cl_oldschool_" + string_2 + string_3 + ".dat");
          String string_1 = null;
          String string_4 = null;
          boolean bool_0 = false;
          File file_6;
          if (LocalInstall.aFile2.exists()) {
            try {
              final FileOnDisk fileondisk_0 = new FileOnDisk(LocalInstall.aFile2, "rw", 10000L);

              int int_2;
              Buffer buffer_0;
              for (buffer_0 = new Buffer((int) fileondisk_0
                  .length()); buffer_0.offset < buffer_0.bytes.length; buffer_0.offset += int_2) {
                int_2 = fileondisk_0.read(buffer_0.bytes, buffer_0.offset,
                    buffer_0.bytes.length - buffer_0.offset);
                if (int_2 == -1) {
                  throw new IOException();
                }
              }

              buffer_0.offset = 0;
              int_2 = buffer_0.getUnsignedByte();
              if (int_2 < 1 || int_2 > 3) {
                throw new IOException("" + int_2);
              }

              int int_3 = 0;
              if (int_2 > 1) {
                int_3 = buffer_0.getUnsignedByte();
              }

              if (int_2 <= 2) {
                string_1 = buffer_0.getSuffixedString();
                if (int_3 == 1) {
                  string_4 = buffer_0.getSuffixedString();
                }
              } else {
                string_1 = buffer_0.getCESU8();
                if (int_3 == 1) {
                  string_4 = buffer_0.getCESU8();
                }
              }

              fileondisk_0.close();
            } catch (final IOException ioexception_1) {
              ioexception_1.printStackTrace();
            }

            if (string_1 != null) {
              file_6 = new File(string_1);
              if (!file_6.exists()) {
                string_1 = null;
              }
            }

            if (string_1 != null) {
              file_6 = new File(string_1, "test.dat");
              if (!JavaxSourceDataLineProvider.method192(file_6, true)) {
                string_1 = null;
              }
            }
          }

          if (string_1 == null && int_1 == 0) {
            label248:
            for (int_4 = 0; int_4 < LocalInstall.cacheInstallPaths.length; int_4++) {
              for (int int_5 = 0; int_5 < LocalInstall.cacheParentPaths.length; int_5++) {
                final File file_0 = new File(
                    LocalInstall.cacheParentPaths[int_5] + LocalInstall.cacheInstallPaths[int_4]
                        + File.separatorChar + "oldschool" + File.separatorChar);
                if (file_0.exists() && JavaxSourceDataLineProvider
                    .method192(new File(file_0, "test.dat"), true)) {
                  string_1 = file_0.toString();
                  bool_0 = true;
                  break label248;
                }
              }
            }
          }

          if (string_1 == null) {
            string_1 = WorldMapType1.userHome + File.separatorChar + "jagexcache" + string_3
                + File.separatorChar + "oldschool" + File.separatorChar + string_2
                + File.separatorChar;
            bool_0 = true;
          }

          if (string_4 != null) {
            final File file_5 = new File(string_4);
            file_6 = new File(string_1);

            try {
              final File[] files_3 = file_5.listFiles();
              final File[] files_0 = files_3;

              for (int int_6 = 0; int_6 < files_0.length; int_6++) {
                final File file_1 = files_0[int_6];
                final File file_2 = new File(file_6, file_1.getName());
                final boolean bool_1 = file_1.renameTo(file_2);
                if (!bool_1) {
                  throw new IOException();
                }
              }
            } catch (final Exception exception_4) {
              exception_4.printStackTrace();
            }

            bool_0 = true;
          }

          if (bool_0) {
            Class45.method288(new File(string_1), null);
          }

          final File file_4 = new File(string_1);
          LocalInstall.aFile1 = file_4;
          if (!LocalInstall.aFile1.exists()) {
            LocalInstall.aFile1.mkdirs();
          }

          final File[] files_1 = LocalInstall.aFile1.listFiles();
          if (files_1 == null) {
            break;
          }

          final File[] files_2 = files_1;
          int int_7 = 0;

          while (true) {
            if (int_7 >= files_2.length) {
              break label273;
            }

            final File file_8 = files_2[int_7];
            if (!JavaxSourceDataLineProvider.method192(file_8, false)) {
              ++int_1;
              break;
            }

            ++int_7;
          }
        }

        Renderable.method712(LocalInstall.aFile1);

        try {
          final File file_3 = new File(WorldMapType1.userHome, "random.dat");
          int int_8;
          if (file_3.exists()) {
            LocalInstall.random = new BufferedFile(new FileOnDisk(file_3, "rw", 25L), 24, 0);
          } else {
            label203:
            for (int int_9 = 0; int_9 < LocalInstall.cacheInstallPaths.length; int_9++) {
              for (int_8 = 0; int_8 < LocalInstall.cacheParentPaths.length; int_8++) {
                final File file_7 = new File(LocalInstall.cacheParentPaths[int_8]
                    + LocalInstall.cacheInstallPaths[int_9] + File.separatorChar + "random.dat");
                if (file_7.exists()) {
                  LocalInstall.random = new BufferedFile(new FileOnDisk(file_7, "rw", 25L), 24, 0);
                  break label203;
                }
              }
            }
          }

          if (LocalInstall.random == null) {
            final RandomAccessFile randomaccessfile_0 = new RandomAccessFile(file_3, "rw");
            int_8 = randomaccessfile_0.read();
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.write(int_8);
            randomaccessfile_0.seek(0L);
            randomaccessfile_0.close();
            LocalInstall.random = new BufferedFile(new FileOnDisk(file_3, "rw", 25L), 24, 0);
          }
        } catch (final IOException ioexception_0) {
        }

        LocalInstall.aCacheFile2 = new BufferedFile(
            new FileOnDisk(Class13.method168("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
        LocalInstall.aCacheFile3 = new BufferedFile(
            new FileOnDisk(Class13.method168("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
        Isaac.aCacheFileArray1 = new BufferedFile[LocalInstall.anInt158];

        for (int_1 = 0; int_1 < LocalInstall.anInt158; int_1++) {
          Isaac.aCacheFileArray1[int_1] = new BufferedFile(
              new FileOnDisk(Class13.method168("main_file_cache.idx" + int_1), "rw", 1048576L),
              6000, 0);
        }
      } catch (final Exception exception_0) {
        ClientScriptVariable.method526(null, exception_0);
      }

      Enum1.clientInstance = this;
      initialize(765, 503, 153);
    }
  }

}
