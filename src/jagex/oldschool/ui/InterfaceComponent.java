package jagex.oldschool.ui;

import jagex.oldschool.asset.LocalRequest;
import jagex.oldschool.CacheableNode_Sub1;
import jagex.oldschool.CacheableNode_Sub3;
import jagex.oldschool.Class43;
import jagex.oldschool.util.Timestamp;
import jagex.oldschool.Class99;
import jagex.oldschool.Enum9;
import jagex.oldschool.social.Ignore;
import jagex.oldschool.Model;
import jagex.oldschool.ModelBase;
import jagex.oldschool.PlayerIdentity;
import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.util.Time;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Node;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Npc;

public class InterfaceComponent extends Node {

  public static boolean aBool27;
  public static Cache aNodeCache2;
  public static Cache aNodeCache3;
  public static Cache aNodeCache4;
  public static AbstractPackage anIndexDataBase13;
  public static Cache aNodeCache5;

  static {
    aNodeCache2 = new Cache(200);
    aNodeCache4 = new Cache(50);
    aNodeCache3 = new Cache(20);
    aNodeCache5 = new Cache(8);
    aBool27 = false;
  }

  public int anInt258;
  public String[] actions;
  public int parentId;
  public int[] itemIds;
  public boolean hasScript;
  public int loopCycle;
  public int fontId;
  public int[] anIntArray70;
  public int spriteId;
  public int modelType;
  public int width;
  public int modelId;
  public boolean aBool28;
  public int id;
  public int type;
  public int height;
  public boolean flippedVertically;
  public int sprite2;
  public int boundsIndex;
  public int borderThickness;
  public int[] itemQuantities;
  public int index;
  public int anInt261;
  public int anInt262;
  public int anInt263;
  public int originalX;
  public int originalWidth;
  public boolean flippedHorizontally;
  public int relativeX;
  public int contentType;
  public int buttonType;
  public int anInt264;
  public int originalY;
  public int anInt265;
  public int relativeY;
  public boolean isHidden;
  public int scrollX;
  public int scrollWidth;
  public int anInt266;
  public int anInt267;
  public int anInt268;
  public int[] tableActions;
  public int anInt269;
  public int anInt270;
  public int[] anIntArray71;
  public int[][] dynamicValues;
  public InterfaceComponent[] children;
  public int scrollY;
  public int scrollHeight;
  public int rotationX;
  public int opacity;
  public int anInt271;
  public int rotationZ;
  public int anInt272;
  public int anInt273;
  public int config;
  public Object[] anObjectArray2;
  public int textColor;
  public int anInt274;
  public int anInt275;
  public int anInt276;
  public int anInt277;
  public int anInt278;
  public boolean aBool29;
  public Enum9 anEnum9_1;
  public int anInt279;
  public int anInt280;
  public boolean aBool30;
  public boolean aBool31;
  public int textureId;
  public Object[] anObjectArray3;
  public boolean aBool32;
  public int anInt281;
  public boolean aBool33;
  public Object[] anObjectArray4;
  public int anInt282;
  public int anInt283;
  public int anInt284;
  public int anInt285;
  public int rotationY;
  public int paddingX;
  public int itemId;
  public int modelZoom;
  public int anInt286;
  public boolean textShadowed;
  public int paddingY;
  public int[] xSprites;
  public String text;
  public boolean aBool34;
  public int[] anIntArray72;
  public int anInt287;
  public int itemQuantity;
  public String aString16;
  public String[] configActions;
  public Object[] anObjectArray5;
  public String name;
  public InterfaceComponent dragParent;
  public String selectedAction;
  public String aString17;
  public String tooltip;
  public boolean aBool35;
  public boolean aBool36;
  public int anInt288;
  public int anInt289;
  public int anInt290;
  public int anInt291;
  public boolean aBool37;
  public Object[] mouseEnterListener;
  public Object[] mouseExitListener;
  public Object[] anObjectArray6;
  public Object[] anObjectArray7;
  public Object[] configListenerArgs;
  public Object[] tableListenerArgs;
  public Object[] skillListenerArgs;
  public Object[] renderListener;
  public Object[] anObjectArray8;
  public Object[] mouseHoverListener;
  public Object[] anObjectArray9;
  public Object[] anObjectArray10;
  public Object[] anObjectArray11;
  public Object[] anObjectArray12;
  public int[] configTriggers;
  public Object[] scrollListener;
  public int[] tableModTriggers;
  public int[] skillTriggers;
  public Object[] anObjectArray13;
  public Object[] anObjectArray14;
  public Object[] anObjectArray15;
  public Object[] anObjectArray16;
  public Object[] anObjectArray17;
  public Object[] anObjectArray18;
  public Object[] anObjectArray19;
  public Object[] anObjectArray20;
  public Object[] anObjectArray21;
  int anInt259;
  int anInt260;

  public InterfaceComponent() {
    hasScript = false;
    id = -1;
    index = -1;
    anInt263 = 0;
    contentType = 0;
    anInt261 = 0;
    anInt264 = 0;
    anInt262 = 0;
    buttonType = 0;
    originalX = 0;
    originalY = 0;
    originalWidth = 0;
    anInt265 = 0;
    relativeX = 0;
    relativeY = 0;
    width = 0;
    height = 0;
    anInt267 = 1;
    anInt269 = 1;
    parentId = -1;
    isHidden = false;
    scrollX = 0;
    scrollY = 0;
    scrollWidth = 0;
    scrollHeight = 0;
    textColor = 0;
    anInt274 = 0;
    anInt276 = 0;
    anInt278 = 0;
    aBool29 = false;
    anEnum9_1 = Enum9.anEnum9_2;
    opacity = 0;
    anInt279 = 0;
    anInt280 = 1;
    aBool30 = false;
    spriteId = -1;
    anInt258 = -1;
    textureId = 0;
    aBool32 = false;
    borderThickness = 0;
    sprite2 = 0;
    modelType = 1;
    modelId = -1;
    anInt259 = 1;
    anInt260 = -1;
    anInt266 = -1;
    anInt268 = -1;
    anInt284 = 0;
    anInt285 = 0;
    rotationX = 0;
    rotationZ = 0;
    rotationY = 0;
    modelZoom = 100;
    anInt286 = 0;
    anInt270 = 0;
    aBool34 = false;
    anInt287 = 2;
    fontId = -1;
    text = "";
    aString16 = "";
    anInt283 = 0;
    anInt281 = 0;
    anInt282 = 0;
    textShadowed = false;
    paddingX = 0;
    paddingY = 0;
    config = 0;
    name = "";
    dragParent = null;
    anInt275 = 0;
    anInt277 = 0;
    aBool33 = false;
    selectedAction = "";
    aBool28 = false;
    anInt273 = -1;
    aString17 = "";
    tooltip = "Ok";
    itemId = -1;
    itemQuantity = 0;
    anInt272 = 0;
    anInt271 = 0;
    aBool35 = false;
    aBool36 = false;
    anInt288 = -1;
    anInt289 = 0;
    anInt290 = 0;
    anInt291 = 0;
    boundsIndex = -1;
    loopCycle = -1;
    aBool31 = false;
    aBool37 = false;
  }

  public static void method587(final int int_0, final int int_1, final int int_2,
      final boolean bool_0) {
    if (Ignore.loadWidget(int_0)) {
      Class43.method279(Time.widgets[int_0], -1, int_1, int_2, bool_0);
    }
  }

  public static int method588(final int int_0, final int int_1) {
    int int_2 = int_1 * 57 + int_0;
    int_2 ^= int_2 << 13;
    final int int_3 = int_2 * (789221 + int_2 * int_2 * 15731) + 1376312589 & 0x7FFFFFFF;
    return int_3 >> 19 & 0xFF;
  }

  public static boolean allowsContinueOption(final int int_0) {
    return (int_0 & 0x1) != 0;
  }

  public DirectSprite method578(final boolean bool_0) {
    aBool27 = false;
    int int_0;
    if (bool_0) {
      int_0 = anInt258;
    } else {
      int_0 = spriteId;
    }

    if (int_0 == -1) {
      return null;
    }
    final long long_0 =
        ((flippedVertically ? 1L : 0L) << 38) + ((long) borderThickness << 36) + int_0
            + ((flippedHorizontally ? 1L : 0L) << 39) + ((long) sprite2 << 40);
    DirectSprite spritepixels_0 = (DirectSprite) aNodeCache2.get(long_0);
    if (spritepixels_0 != null) {
      return spritepixels_0;
    }
    spritepixels_0 = CacheableNode_Sub3.method846(Npc.anIndexDataBase30, int_0, 0);
    if (spritepixels_0 == null) {
      aBool27 = true;
      return null;
    }
    if (flippedVertically) {
      spritepixels_0.method944();
    }

    if (flippedHorizontally) {
      spritepixels_0.method945();
    }

    if (borderThickness > 0) {
      spritepixels_0.method946(borderThickness);
    }

    if (borderThickness >= 1) {
      spritepixels_0.method947(1);
    }

    if (borderThickness >= 2) {
      spritepixels_0.method947(16777215);
    }

    if (sprite2 != 0) {
      spritepixels_0.method948(sprite2);
    }

    aNodeCache2.put(spritepixels_0, long_0);
    return spritepixels_0;
  }

  public void decodeActive(final Buffer buffer_0) {
    buffer_0.getUnsignedByte();
    hasScript = true;
    type = buffer_0.getUnsignedByte();
    contentType = buffer_0.getUnsignedShort();
    originalX = buffer_0.getShort();
    originalY = buffer_0.getShort();
    originalWidth = buffer_0.getUnsignedShort();
    if (type == 9) {
      anInt265 = buffer_0.getShort();
    } else {
      anInt265 = buffer_0.getUnsignedShort();
    }

    anInt262 = buffer_0.getByte();
    buttonType = buffer_0.getByte();
    anInt261 = buffer_0.getByte();
    anInt264 = buffer_0.getByte();
    parentId = buffer_0.getUnsignedShort();
    if (parentId == 65535) {
      parentId = -1;
    } else {
      parentId += id & 0xFFFF0000;
    }

    isHidden = buffer_0.getUnsignedByte() == 1;
    if (type == 0) {
      scrollWidth = buffer_0.getUnsignedShort();
      scrollHeight = buffer_0.getUnsignedShort();
      aBool31 = buffer_0.getUnsignedByte() == 1;
    }

    if (type == 5) {
      spriteId = buffer_0.getInt();
      textureId = buffer_0.getUnsignedShort();
      aBool32 = buffer_0.getUnsignedByte() == 1;
      opacity = buffer_0.getUnsignedByte();
      borderThickness = buffer_0.getUnsignedByte();
      sprite2 = buffer_0.getInt();
      flippedVertically = buffer_0.getUnsignedByte() == 1;
      flippedHorizontally = buffer_0.getUnsignedByte() == 1;
    }

    if (type == 6) {
      modelType = 1;
      modelId = buffer_0.getUnsignedShort();
      if (modelId == 65535) {
        modelId = -1;
      }

      anInt284 = buffer_0.getShort();
      anInt285 = buffer_0.getShort();
      rotationX = buffer_0.getUnsignedShort();
      rotationZ = buffer_0.getUnsignedShort();
      rotationY = buffer_0.getUnsignedShort();
      modelZoom = buffer_0.getUnsignedShort();
      anInt266 = buffer_0.getUnsignedShort();
      if (anInt266 == 65535) {
        anInt266 = -1;
      }

      aBool34 = buffer_0.getUnsignedByte() == 1;
      buffer_0.getUnsignedShort();
      if (anInt262 != 0) {
        anInt286 = buffer_0.getUnsignedShort();
      }

      if (buttonType != 0) {
        buffer_0.getUnsignedShort();
      }
    }

    if (type == 4) {
      fontId = buffer_0.getUnsignedShort();
      if (fontId == 65535) {
        fontId = -1;
      }

      text = buffer_0.getString();
      anInt283 = buffer_0.getUnsignedByte();
      anInt281 = buffer_0.getUnsignedByte();
      anInt282 = buffer_0.getUnsignedByte();
      textShadowed = buffer_0.getUnsignedByte() == 1;
      textColor = buffer_0.getInt();
    }

    if (type == 3) {
      textColor = buffer_0.getInt();
      aBool29 = buffer_0.getUnsignedByte() == 1;
      opacity = buffer_0.getUnsignedByte();
    }

    if (type == 9) {
      anInt280 = buffer_0.getUnsignedByte();
      textColor = buffer_0.getInt();
      aBool30 = buffer_0.getUnsignedByte() == 1;
    }

    config = buffer_0.getUnsignedMedium();
    name = buffer_0.getString();
    final int int_0 = buffer_0.getUnsignedByte();
    if (int_0 > 0) {
      actions = new String[int_0];

      for (int int_1 = 0; int_1 < int_0; int_1++) {
        actions[int_1] = buffer_0.getString();
      }
    }

    anInt275 = buffer_0.getUnsignedByte();
    anInt277 = buffer_0.getUnsignedByte();
    aBool33 = buffer_0.getUnsignedByte() == 1;
    selectedAction = buffer_0.getString();
    anObjectArray5 = method583(buffer_0);
    mouseEnterListener = method583(buffer_0);
    mouseExitListener = method583(buffer_0);
    anObjectArray6 = method583(buffer_0);
    anObjectArray7 = method583(buffer_0);
    configListenerArgs = method583(buffer_0);
    tableListenerArgs = method583(buffer_0);
    skillListenerArgs = method583(buffer_0);
    renderListener = method583(buffer_0);
    anObjectArray8 = method583(buffer_0);
    mouseHoverListener = method583(buffer_0);
    anObjectArray9 = method583(buffer_0);
    anObjectArray11 = method583(buffer_0);
    anObjectArray12 = method583(buffer_0);
    anObjectArray10 = method583(buffer_0);
    anObjectArray3 = method583(buffer_0);
    anObjectArray4 = method583(buffer_0);
    scrollListener = method583(buffer_0);
    configTriggers = method586(buffer_0);
    tableModTriggers = method586(buffer_0);
    skillTriggers = method586(buffer_0);
  }

  public void decode(final Buffer buffer_0) {
    hasScript = false;
    type = buffer_0.getUnsignedByte();
    anInt263 = buffer_0.getUnsignedByte();
    contentType = buffer_0.getUnsignedShort();
    originalX = buffer_0.getShort();
    originalY = buffer_0.getShort();
    originalWidth = buffer_0.getUnsignedShort();
    anInt265 = buffer_0.getUnsignedShort();
    opacity = buffer_0.getUnsignedByte();
    parentId = buffer_0.getUnsignedShort();
    if (parentId == 65535) {
      parentId = -1;
    } else {
      parentId += id & 0xFFFF0000;
    }

    anInt273 = buffer_0.getUnsignedShort();
    if (anInt273 == 65535) {
      anInt273 = -1;
    }

    final int int_0 = buffer_0.getUnsignedByte();
    int int_1;
    if (int_0 > 0) {
      tableActions = new int[int_0];
      anIntArray71 = new int[int_0];

      for (int_1 = 0; int_1 < int_0; int_1++) {
        tableActions[int_1] = buffer_0.getUnsignedByte();
        anIntArray71[int_1] = buffer_0.getUnsignedShort();
      }
    }

    int_1 = buffer_0.getUnsignedByte();
    int int_2;
    int int_3;
    int int_4;
    if (int_1 > 0) {
      dynamicValues = new int[int_1][];

      for (int_2 = 0; int_2 < int_1; int_2++) {
        int_3 = buffer_0.getUnsignedShort();
        dynamicValues[int_2] = new int[int_3];

        for (int_4 = 0; int_4 < int_3; int_4++) {
          dynamicValues[int_2][int_4] = buffer_0.getUnsignedShort();
          if (dynamicValues[int_2][int_4] == 65535) {
            dynamicValues[int_2][int_4] = -1;
          }
        }
      }
    }

    if (type == 0) {
      scrollHeight = buffer_0.getUnsignedShort();
      isHidden = buffer_0.getUnsignedByte() == 1;
    }

    if (type == 1) {
      buffer_0.getUnsignedShort();
      buffer_0.getUnsignedByte();
    }

    if (type == 2) {
      itemIds = new int[anInt265 * originalWidth];
      itemQuantities = new int[originalWidth * anInt265];
      int_2 = buffer_0.getUnsignedByte();
      if (int_2 == 1) {
        config |= 0x10000000;
      }

      int_3 = buffer_0.getUnsignedByte();
      if (int_3 == 1) {
        config |= 0x40000000;
      }

      int_4 = buffer_0.getUnsignedByte();
      if (int_4 == 1) {
        config |= 0x80000000;
      }

      final int int_5 = buffer_0.getUnsignedByte();
      if (int_5 == 1) {
        config |= 0x20000000;
      }

      paddingX = buffer_0.getUnsignedByte();
      paddingY = buffer_0.getUnsignedByte();
      xSprites = new int[20];
      anIntArray72 = new int[20];
      anIntArray70 = new int[20];

      int int_6;
      for (int_6 = 0; int_6 < 20; int_6++) {
        final int int_7 = buffer_0.getUnsignedByte();
        if (int_7 == 1) {
          xSprites[int_6] = buffer_0.getShort();
          anIntArray72[int_6] = buffer_0.getShort();
          anIntArray70[int_6] = buffer_0.getInt();
        } else {
          anIntArray70[int_6] = -1;
        }
      }

      configActions = new String[5];

      for (int_6 = 0; int_6 < 5; int_6++) {
        final String string_0 = buffer_0.getString();
        if (string_0.length() > 0) {
          configActions[int_6] = string_0;
          config |= 1 << int_6 + 23;
        }
      }
    }

    if (type == 3) {
      aBool29 = buffer_0.getUnsignedByte() == 1;
    }

    if (type == 4 || type == 1) {
      anInt281 = buffer_0.getUnsignedByte();
      anInt282 = buffer_0.getUnsignedByte();
      anInt283 = buffer_0.getUnsignedByte();
      fontId = buffer_0.getUnsignedShort();
      if (fontId == 65535) {
        fontId = -1;
      }

      textShadowed = buffer_0.getUnsignedByte() == 1;
    }

    if (type == 4) {
      text = buffer_0.getString();
      aString16 = buffer_0.getString();
    }

    if (type == 1 || type == 3 || type == 4) {
      textColor = buffer_0.getInt();
    }

    if (type == 3 || type == 4) {
      anInt274 = buffer_0.getInt();
      anInt276 = buffer_0.getInt();
      anInt278 = buffer_0.getInt();
    }

    if (type == 5) {
      spriteId = buffer_0.getInt();
      anInt258 = buffer_0.getInt();
    }

    if (type == 6) {
      modelType = 1;
      modelId = buffer_0.getUnsignedShort();
      if (modelId == 65535) {
        modelId = -1;
      }

      anInt259 = 1;
      anInt260 = buffer_0.getUnsignedShort();
      if (anInt260 == 65535) {
        anInt260 = -1;
      }

      anInt266 = buffer_0.getUnsignedShort();
      if (anInt266 == 65535) {
        anInt266 = -1;
      }

      anInt268 = buffer_0.getUnsignedShort();
      if (anInt268 == 65535) {
        anInt268 = -1;
      }

      modelZoom = buffer_0.getUnsignedShort();
      rotationX = buffer_0.getUnsignedShort();
      rotationZ = buffer_0.getUnsignedShort();
    }

    if (type == 7) {
      itemIds = new int[originalWidth * anInt265];
      itemQuantities = new int[originalWidth * anInt265];
      anInt281 = buffer_0.getUnsignedByte();
      fontId = buffer_0.getUnsignedShort();
      if (fontId == 65535) {
        fontId = -1;
      }

      textShadowed = buffer_0.getUnsignedByte() == 1;
      textColor = buffer_0.getInt();
      paddingX = buffer_0.getShort();
      paddingY = buffer_0.getShort();
      int_2 = buffer_0.getUnsignedByte();
      if (int_2 == 1) {
        config |= 0x40000000;
      }

      configActions = new String[5];

      for (int_3 = 0; int_3 < 5; int_3++) {
        final String string_1 = buffer_0.getString();
        if (string_1.length() > 0) {
          configActions[int_3] = string_1;
          config |= 1 << int_3 + 23;
        }
      }
    }

    if (type == 8) {
      text = buffer_0.getString();
    }

    if (anInt263 == 2 || type == 2) {
      selectedAction = buffer_0.getString();
      aString17 = buffer_0.getString();
      int_2 = buffer_0.getUnsignedShort() & 0x3F;
      config |= int_2 << 11;
    }

    if (anInt263 == 1 || anInt263 == 4 || anInt263 == 5 || anInt263 == 6) {
      tooltip = buffer_0.getString();
      if (tooltip.length() == 0) {
        if (anInt263 == 1) {
          tooltip = "Ok";
        }

        if (anInt263 == 4) {
          tooltip = "Select";
        }

        if (anInt263 == 5) {
          tooltip = "Select";
        }

        if (anInt263 == 6) {
          tooltip = "Continue";
        }
      }
    }

    if (anInt263 == 1 || anInt263 == 4 || anInt263 == 5) {
      config |= 0x400000;
    }

    if (anInt263 == 6) {
      config |= 0x1;
    }

  }

  public CacheableNode_Sub1 method579(boolean bool_0) {
    if (anInt258 == -1) {
      bool_0 = false;
    }

    final int int_0 = bool_0 ? anInt258 : spriteId;
    if (int_0 == -1) {
      return null;
    }
    final long long_0 = ((long) sprite2 << 40) + int_0 + ((long) borderThickness << 36)
        + ((flippedVertically ? 1L : 0L) << 38) + ((flippedHorizontally ? 1L : 0L) << 39);
    CacheableNode_Sub1 cacheablenode_sub1_0 = (CacheableNode_Sub1) aNodeCache5.get(long_0);
    if (cacheablenode_sub1_0 != null) {
      return cacheablenode_sub1_0;
    }
    final DirectSprite spritepixels_0 = method578(bool_0);
    if (spritepixels_0 == null) {
      return null;
    }
    final DirectSprite spritepixels_1 = spritepixels_0.copy();
    final int[] ints_0 = new int[spritepixels_1.height];
    final int[] ints_1 = new int[spritepixels_1.height];

    for (int int_1 = 0; int_1 < spritepixels_1.height; int_1++) {
      int int_2 = 0;
      int int_3 = spritepixels_1.width;

      int int_4;
      for (int_4 = 0; int_4 < spritepixels_1.width; int_4++) {
        if (spritepixels_1.buffer[int_1 * spritepixels_1.width + int_4] == 0) {
          int_2 = int_4;
          break;
        }
      }

      for (int_4 = spritepixels_1.width - 1; int_4 >= int_2; --int_4) {
        if (spritepixels_1.buffer[int_1 * spritepixels_1.width + int_4] == 0) {
          int_3 = int_4 + 1;
          break;
        }
      }

      ints_0[int_1] = int_2;
      ints_1[int_1] = int_3 - int_2;
    }

    cacheablenode_sub1_0 = new CacheableNode_Sub1(spritepixels_1.width, spritepixels_1.height,
        ints_1,
        ints_0, int_0);
    aNodeCache5.put(cacheablenode_sub1_0, long_0);
    return cacheablenode_sub1_0;
  }

  public BitmapFont method580() {
    aBool27 = false;
    if (fontId == -1) {
      return null;
    }
    BitmapFont font_0 = (BitmapFont) aNodeCache3.get(fontId);
    if (font_0 != null) {
      return font_0;
    }
    font_0 = LocalRequest.method650(Npc.anIndexDataBase30, anIndexDataBase13, fontId, 0);
    if (font_0 != null) {
      aNodeCache3.put(font_0, fontId);
    } else {
      aBool27 = true;
    }

    return font_0;
  }

  public DirectSprite method581(final int int_0) {
    aBool27 = false;
    if (int_0 >= 0 && int_0 < anIntArray70.length) {
      final int int_1 = anIntArray70[int_0];
      if (int_1 == -1) {
        return null;
      }
      DirectSprite spritepixels_0 = (DirectSprite) aNodeCache2.get(int_1);
      if (spritepixels_0 != null) {
        return spritepixels_0;
      }
      spritepixels_0 = CacheableNode_Sub3.method846(Npc.anIndexDataBase30, int_1, 0);
      if (spritepixels_0 != null) {
        aNodeCache2.put(spritepixels_0, int_1);
      } else {
        aBool27 = true;
      }

      return spritepixels_0;
    }
    return null;
  }

  public Model method582(final AnimationSequence sequence_0, final int int_0, final boolean bool_0,
      final PlayerIdentity playercomposition_0) {
    aBool27 = false;
    int int_1;
    int int_2;
    if (bool_0) {
      int_1 = anInt259;
      int_2 = anInt260;
    } else {
      int_1 = modelType;
      int_2 = modelId;
    }

    if (int_1 == 0) {
      return null;
    }
    if (int_1 == 1 && int_2 == -1) {
      return null;
    }
    Model model_0 = (Model) aNodeCache4.get(int_2 + (int_1 << 16));
    if (model_0 == null) {
      ModelBase modeldata_0;
      if (int_1 == 1) {
        modeldata_0 = ModelBase.decode(Class99.anIndexDataBase10, int_2, 0);
        if (modeldata_0 == null) {
          aBool27 = true;
          return null;
        }

        model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
      }

      if (int_1 == 2) {
        modeldata_0 = Timestamp.getNpcDefinition(int_2).method863();
        if (modeldata_0 == null) {
          aBool27 = true;
          return null;
        }

        model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
      }

      if (int_1 == 3) {
        if (playercomposition_0 == null) {
          return null;
        }

        modeldata_0 = playercomposition_0.method501();
        if (modeldata_0 == null) {
          aBool27 = true;
          return null;
        }

        model_0 = modeldata_0.applyLighting(64, 768, -50, -10, -50);
      }

      if (int_1 == 4) {
        final ItemConfig itemcomposition_0 = AudioWorker.getItemDefinition(int_2);
        modeldata_0 = itemcomposition_0.method895(10);
        if (modeldata_0 == null) {
          aBool27 = true;
          return null;
        }

        model_0 = modeldata_0
            .applyLighting(itemcomposition_0.ambient + 64, itemcomposition_0.contrast + 768, -50,
                -10, -50);
      }

      aNodeCache4.put(model_0, int_2 + (int_1 << 16));
    }

    if (sequence_0 != null) {
      model_0 = sequence_0.method877(model_0, int_0);
    }

    return model_0;
  }

  Object[] method583(final Buffer buffer_0) {
    final int int_0 = buffer_0.getUnsignedByte();
    if (int_0 == 0) {
      return null;
    }
    final Object[] objects_0 = new Object[int_0];

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      final int int_2 = buffer_0.getUnsignedByte();
      if (int_2 == 0) {
        objects_0[int_1] = new Integer(buffer_0.getInt());
      } else if (int_2 == 1) {
        objects_0[int_1] = buffer_0.getString();
      }
    }

    aBool28 = true;
    return objects_0;
  }

  public void method584(final int int_0, final String string_0) {
    if (actions == null || actions.length <= int_0) {
      final String[] strings_0 = new String[int_0 + 1];
      if (actions != null) {
        for (int int_1 = 0; int_1 < actions.length; int_1++) {
          strings_0[int_1] = actions[int_1];
        }
      }

      actions = strings_0;
    }

    actions[int_0] = string_0;
  }

  public void method585(final int int_0, final int int_1) {
    int int_2 = itemIds[int_1];
    itemIds[int_1] = itemIds[int_0];
    itemIds[int_0] = int_2;
    int_2 = itemQuantities[int_1];
    itemQuantities[int_1] = itemQuantities[int_0];
    itemQuantities[int_0] = int_2;
  }

  int[] method586(final Buffer buffer_0) {
    final int int_0 = buffer_0.getUnsignedByte();
    if (int_0 == 0) {
      return null;
    }
    final int[] ints_0 = new int[int_0];

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      ints_0[int_1] = buffer_0.getInt();
    }

    return ints_0;
  }

}
