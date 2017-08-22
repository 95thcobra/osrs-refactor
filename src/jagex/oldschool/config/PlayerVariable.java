package jagex.oldschool.config;

import jagex.oldschool.AClass1;
import jagex.oldschool.AClass1_Sub2;
import jagex.oldschool.AClass4_Sub3;
import jagex.oldschool.CacheableNode_Sub2;
import jagex.oldschool.CacheableNode_Sub3;
import jagex.oldschool.awt.CanvasWrapper;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.Class11;
import jagex.oldschool.Class12;
import jagex.oldschool.Class13;
import jagex.oldschool.Class16;
import jagex.oldschool.Class2;
import jagex.oldschool.Class22;
import jagex.oldschool.Class23;
import jagex.oldschool.Class24;
import jagex.oldschool.Class26;
import jagex.oldschool.Class28;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.Class35;
import jagex.oldschool.Class39;
import jagex.oldschool.Class4;
import jagex.oldschool.Class40;
import jagex.oldschool.Class45;
import jagex.oldschool.Class46;
import jagex.oldschool.Class47;
import jagex.oldschool.Class57;
import jagex.oldschool.Class64;
import jagex.oldschool.Class69_Sub1;
import jagex.oldschool.util.Timestamp;
import jagex.oldschool.Class8;
import jagex.oldschool.Class82;
import jagex.oldschool.Class85;
import jagex.oldschool.Class86;
import jagex.oldschool.Boundry;
import jagex.oldschool.Client;
import jagex.oldschool.CombatInfo1;
import jagex.oldschool.DecorativeObject;
import jagex.oldschool.Enum;
import jagex.oldschool.Enum1;
import jagex.oldschool.Enum6;
import jagex.oldschool.FloorUnderlayDefinition;
import jagex.oldschool.Friend;
import jagex.oldschool.GrandExchangeOffer;
import jagex.oldschool.GroundItem;
import jagex.oldschool.Ignore;
import jagex.oldschool.Node_Sub1;
import jagex.oldschool.Node_Sub5;
import jagex.oldschool.RemoteEnvironment;
import jagex.oldschool.UserGroup;
import jagex.oldschool.ui.OpenedInterface;
import jagex.oldschool.World;
import jagex.oldschool.WorldMapData_Sub1;
import jagex.oldschool.WorldMapType2;
import jagex.oldschool.asset.AbstractPackage;
import jagex.oldschool.audio.AudioWorker;
import jagex.oldschool.collections.Cache;
import jagex.oldschool.collections.Subnode;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.AbstractFont;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.scene.Mobile;
import jagex.oldschool.scene.Npc;
import jagex.oldschool.scene.Player;
import jagex.oldschool.script.Class34;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.Script;
import jagex.oldschool.script.ScriptState;
import jagex.oldschool.ui.InterfaceComponent;
import jagex.oldschool.ui.Inventory;
import jagex.oldschool.util.Time;
import java.util.Date;

public class PlayerVariable extends Subnode {

  public static Cache varplayers;
  public static int anInt495;
  public static AbstractPackage configs;

  static {
    varplayers = new Cache(64);
  }

  public int configType;

  public PlayerVariable() {
    configType = 0;
  }

  public static void method905(final int int_0) {
    final Inventory itemcontainer_0 = (Inventory) Inventory.inventories.get(int_0);
    if (itemcontainer_0 != null) {
      for (int int_1 = 0; int_1 < itemcontainer_0.ids.length; int_1++) {
        itemcontainer_0.ids[int_1] = -1;
        itemcontainer_0.counts[int_1] = 0;
      }

    }
  }

  public static String method906(final String string_0) {
    final int int_0 = string_0.length();
    final char[] chars_0 = new char[int_0];
    byte byte_0 = 2;

    for (int int_1 = 0; int_1 < int_0; int_1++) {
      char char_0 = string_0.charAt(int_1);
      if (byte_0 == 0) {
        char_0 = Character.toLowerCase(char_0);
      } else if (byte_0 == 2 || Character.isUpperCase(char_0)) {
        char char_1;
        if (char_0 != 181 && char_0 != 131) {
          char_1 = Character.toTitleCase(char_0);
        } else {
          char_1 = char_0;
        }

        char_0 = char_1;
      }

      if (Character.isLetter(char_0)) {
        byte_0 = 0;
      } else if (char_0 != 46 && char_0 != 63 && char_0 != 33) {
        if (Character.isSpaceChar(char_0)) {
          if (byte_0 != 2) {
            byte_0 = 1;
          }
        } else {
          byte_0 = 1;
        }
      } else {
        byte_0 = 2;
      }

      chars_0[int_1] = char_0;
    }

    return new String(chars_0);
  }

  public static int method907(final int int_0, final Script script_0, final boolean bool_0) {
    int int_1;
    int int_2;
    int int_3;
    byte byte_0;
    int int_8;
    InterfaceComponent widget_0;
    InterfaceComponent widget_2;
    InterfaceComponent widget_4;
    if (int_0 < 1000) {
      if (int_0 == 100) {
        ScriptExecutor.intStackSize -= 3;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        if (int_8 == 0) {
          throw new RuntimeException();
        }

        widget_0 = ScriptExecutor.method240(int_1);
        if (widget_0.children == null) {
          widget_0.children = new InterfaceComponent[int_2 + 1];
        }

        if (widget_0.children.length <= int_2) {
          final InterfaceComponent[] widgets_0 = new InterfaceComponent[int_2 + 1];

          for (int_3 = 0; int_3 < widget_0.children.length; int_3++) {
            widgets_0[int_3] = widget_0.children[int_3];
          }

          widget_0.children = widgets_0;
        }

        if (int_2 > 0 && widget_0.children[int_2 - 1] == null) {
          throw new RuntimeException("" + (int_2 - 1));
        }

        final InterfaceComponent widget_1 = new InterfaceComponent();
        widget_1.type = int_8;
        widget_1.parentId = widget_1.id = widget_0.id;
        widget_1.index = int_2;
        widget_1.hasScript = true;
        widget_0.children[int_2] = widget_1;
        if (bool_0) {
          Class8.aWidget1 = widget_1;
        } else {
          Node_Sub5.aWidget7 = widget_1;
        }

        Class28.method236(widget_0);
        byte_0 = 1;
      } else if (int_0 == 101) {
        widget_4 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
        final InterfaceComponent widget_3 = ScriptExecutor.method240(widget_4.id);
        widget_3.children[widget_4.index] = null;
        Class28.method236(widget_3);
        byte_0 = 1;
      } else if (int_0 == 102) {
        widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
        widget_4.children = null;
        Class28.method236(widget_4);
        byte_0 = 1;
      } else if (int_0 == 200) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        widget_2 = AClass4_Sub3.method819(int_1, int_8);
        if (widget_2 != null && int_8 != -1) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 1;
          if (bool_0) {
            Class8.aWidget1 = widget_2;
          } else {
            Node_Sub5.aWidget7 = widget_2;
          }
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 201) {
        widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
        if (widget_4 != null) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 1;
          if (bool_0) {
            Class8.aWidget1 = widget_4;
          } else {
            Node_Sub5.aWidget7 = widget_4;
          }
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 1100) {
      return Class23.method214(int_0, script_0, bool_0);
    }
    if (int_0 < 1200) {
      return Class34.method250(int_0, script_0, bool_0);
    }
    if (int_0 < 1300) {
      return Class35.method256(int_0, script_0, bool_0);
    }
    if (int_0 < 1400) {
      return Class11.method162(int_0, script_0, bool_0);
    }
    if (int_0 < 1500) {
      return CanvasWrapper.method716(int_0, script_0, bool_0);
    }
    if (int_0 < 1600) {
      return Class16.method198(int_0, script_0, bool_0);
    }
    if (int_0 < 1700) {
      return Class47.method296(int_0, script_0, bool_0);
    }
    if (int_0 < 1800) {
      widget_0 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
      if (int_0 == 1700) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.itemId;
        byte_0 = 1;
      } else if (int_0 == 1701) {
        if (widget_0.itemId != -1) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.itemQuantity;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 1702) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_0.index;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    int int_4;
    int int_9;
    int[] ints_2;
    if (int_0 < 1900) {
      widget_4 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
      if (int_0 == 1800) {
        ints_2 = ScriptExecutor.intStack;
        int_2 = ++ScriptExecutor.intStackSize - 1;
        int_4 = Client.getWidgetConfig(widget_4);
        int_9 = int_4 >> 11 & 0x3F;
        ints_2[int_2] = int_9;
        byte_0 = 1;
      } else if (int_0 == 1801) {
        int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        --int_8;
        if (widget_4.actions != null && int_8 < widget_4.actions.length
            && widget_4.actions[int_8] != null) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_4.actions[int_8];
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 1802) {
        if (widget_4.name == null) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_4.name;
        }

        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 2000) {
      return ScriptState.method560(int_0, script_0, bool_0);
    }
    if (int_0 < 2100) {
      return Class23.method214(int_0, script_0, bool_0);
    }
    if (int_0 < 2200) {
      return Class34.method250(int_0, script_0, bool_0);
    }
    if (int_0 < 2300) {
      return Class35.method256(int_0, script_0, bool_0);
    }
    if (int_0 < 2400) {
      return Class11.method162(int_0, script_0, bool_0);
    }
    if (int_0 < 2500) {
      return CanvasWrapper.method716(int_0, script_0, bool_0);
    }
    if (int_0 < 2600) {
      widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      if (int_0 == 2500) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.relativeX;
        byte_0 = 1;
      } else if (int_0 == 2501) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.relativeY;
        byte_0 = 1;
      } else if (int_0 == 2502) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.width;
        byte_0 = 1;
      } else if (int_0 == 2503) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.height;
        byte_0 = 1;
      } else if (int_0 == 2504) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.isHidden ? 1 : 0;
        byte_0 = 1;
      } else if (int_0 == 2505) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.parentId;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 2700) {
      return Class45.method290(int_0, script_0, bool_0);
    }
    if (int_0 < 2800) {
      if (int_0 == 2700) {
        widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.itemId;
        byte_0 = 1;
      } else if (int_0 == 2701) {
        widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
        if (widget_4.itemId != -1) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = widget_4.itemQuantity;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 2702) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        final OpenedInterface widgetnode_0 = (OpenedInterface) Client.componentTable.get(int_1);
        if (widgetnode_0 != null) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 1;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 2706) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.widgetRoot;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 2900) {
      widget_4 = ScriptExecutor.method240(ScriptExecutor.intStack[--ScriptExecutor.intStackSize]);
      if (int_0 == 2800) {
        ints_2 = ScriptExecutor.intStack;
        int_2 = ++ScriptExecutor.intStackSize - 1;
        int_4 = Client.getWidgetConfig(widget_4);
        int_9 = int_4 >> 11 & 0x3F;
        ints_2[int_2] = int_9;
        byte_0 = 1;
      } else if (int_0 == 2801) {
        int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        --int_8;
        if (widget_4.actions != null && int_8 < widget_4.actions.length
            && widget_4.actions[int_8] != null) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_4.actions[int_8];
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 2802) {
        if (widget_4.name == null) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = widget_4.name;
        }

        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 3000) {
      return ScriptState.method560(int_0, script_0, bool_0);
    }
    boolean bool_1;
    String string_4;
    String string_5;
    if (int_0 < 3200) {
      if (int_0 == 3100) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        Npc.sendGameMessage(0, "", string_4);
        byte_0 = 1;
      } else if (int_0 == 3101) {
        ScriptExecutor.intStackSize -= 2;
        LongVariable.method278(GrandExchangeOffer.localPlayer, ScriptExecutor.intStack[ScriptExecutor.intStackSize],
            ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1]);
        byte_0 = 1;
      } else if (int_0 == 3103) {
        Mobile.method914();
        byte_0 = 1;
      } else if (int_0 == 3104) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        int_8 = 0;
        if (Class57.method365(string_4)) {
          int_8 = CacheableNode_Sub2.method841(string_4);
        }

        Client.outbound.putEncipheredByte(5);
        Client.outbound.putInt(int_8);
        byte_0 = 1;
      } else if (int_0 == 3105) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        Client.outbound.putEncipheredByte(251);
        Client.outbound.putByte(string_4.length() + 1);
        Client.outbound.putString(string_4);
        byte_0 = 1;
      } else if (int_0 == 3106) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        Client.outbound.putEncipheredByte(0);
        Client.outbound.putByte(string_4.length() + 1);
        Client.outbound.putString(string_4);
        byte_0 = 1;
      } else if (int_0 == 3107) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        string_5 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        int_2 = Class39.anInt89;
        final int[] ints_0 = Class39.anIntArray14;
        boolean bool_5 = false;

        for (int_3 = 0; int_3 < int_2; int_3++) {
          final Player player_0 = Client.cachedPlayers[ints_0[int_3]];
          if (player_0 != null && player_0 != GrandExchangeOffer.localPlayer
              && player_0.name != null && player_0.name.equalsIgnoreCase(string_5)) {
            if (int_1 == 1) {
              Client.outbound.putEncipheredByte(190);
              Client.outbound.putLeShortAdd(ints_0[int_3]);
              Client.outbound.putByteAdd(0);
            } else if (int_1 == 4) {
              Client.outbound.putEncipheredByte(154);
              Client.outbound.putShortAdd(ints_0[int_3]);
              Client.outbound.putByteAdd(0);
            } else if (int_1 == 6) {
              Client.outbound.putEncipheredByte(114);
              Client.outbound.putByteAdd(0);
              Client.outbound.putLeShort(ints_0[int_3]);
            } else if (int_1 == 7) {
              Client.outbound.putEncipheredByte(26);
              Client.outbound.putByteNegate(0);
              Client.outbound.putLeShortAdd(ints_0[int_3]);
            }

            bool_5 = true;
            break;
          }
        }

        if (!bool_5) {
          Npc.sendGameMessage(4, "", "Unable to find " + string_5);
        }

        byte_0 = 1;
      } else if (int_0 == 3108) {
        ScriptExecutor.intStackSize -= 3;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        widget_0 = ScriptExecutor.method240(int_2);
        Class22.method210(widget_0, int_1, int_8);
        byte_0 = 1;
      } else if (int_0 == 3109) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        widget_2 = bool_0 ? Class8.aWidget1 : Node_Sub5.aWidget7;
        Class22.method210(widget_2, int_1, int_8);
        byte_0 = 1;
      } else if (int_0 == 3110) {
        GrandExchangeOffer.aBool5 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
        byte_0 = 1;
      } else if (int_0 == 3111) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = LongVariable.preferences.hideRoofs ? 1 : 0;
        byte_0 = 1;
      } else if (int_0 == 3112) {
        LongVariable.preferences.hideRoofs = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
        Class4.method125();
        byte_0 = 1;
      } else if (int_0 == 3113) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        bool_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
        Class13.method167(string_4, bool_1, false);
        byte_0 = 1;
      } else if (int_0 == 3115) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        Client.outbound.putEncipheredByte(69);
        Client.outbound.putShort(int_1);
        byte_0 = 1;
      } else if (int_0 == 3116) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        Class26.scriptStringStackSize -= 2;
        string_5 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
        final String string_6 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
        if (string_5.length() > 500) {
          byte_0 = 1;
        } else if (string_6.length() > 500) {
          byte_0 = 1;
        } else {
          Client.outbound.putEncipheredByte(200);
          Client.outbound
              .putShort(1 + Class64.getLength(string_5) + Class64.getLength(string_6));
          Client.outbound.putByteSub(int_1);
          Client.outbound.putString(string_5);
          Client.outbound.putString(string_6);
          byte_0 = 1;
        }
      } else if (int_0 == 3117) {
        Client.aBool91 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 3300) {
      return CanvasWrapper.method717(int_0, script_0, bool_0);
    }
    int int_5;
    if (int_0 < 3400) {
      if (int_0 == 3300) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.tick;
        byte_0 = 1;
      } else if (int_0 == 3301) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = GroundItem.method931(int_1, int_8);
        byte_0 = 1;
      } else {
        int[] ints_3;
        Inventory itemcontainer_0;
        if (int_0 == 3302) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          ints_3 = ScriptExecutor.intStack;
          int_9 = ++ScriptExecutor.intStackSize - 1;
          itemcontainer_0 = (Inventory) Inventory.inventories.get(int_1);
          if (itemcontainer_0 == null) {
            int_4 = 0;
          } else if (int_8 >= 0 && int_8 < itemcontainer_0.counts.length) {
            int_4 = itemcontainer_0.counts[int_8];
          } else {
            int_4 = 0;
          }

          ints_3[int_9] = int_4;
          byte_0 = 1;
        } else {
          int int_10;
          if (int_0 == 3303) {
            ScriptExecutor.intStackSize -= 2;
            int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            ints_3 = ScriptExecutor.intStack;
            int_9 = ++ScriptExecutor.intStackSize - 1;
            itemcontainer_0 = (Inventory) Inventory.inventories.get(int_1);
            if (itemcontainer_0 == null) {
              int_4 = 0;
            } else if (int_8 == -1) {
              int_4 = 0;
            } else {
              int_10 = 0;

              for (int_5 = 0; int_5 < itemcontainer_0.counts.length; int_5++) {
                if (int_8 == itemcontainer_0.ids[int_5]) {
                  int_10 += itemcontainer_0.counts[int_5];
                }
              }

              int_4 = int_10;
            }

            ints_3[int_9] = int_4;
            byte_0 = 1;
          } else if (int_0 == 3304) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class34.method251(int_1).size;
            byte_0 = 1;
          } else if (int_0 == 3305) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.boostedSkillLevels[int_1];
            byte_0 = 1;
          } else if (int_0 == 3306) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.realSkillLevels[int_1];
            byte_0 = 1;
          } else if (int_0 == 3307) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.skillExperiences[int_1];
            byte_0 = 1;
          } else if (int_0 == 3308) {
            int_1 = Class12.plane;
            int_8 = (GrandExchangeOffer.localPlayer.x >> 7) + Boundry.baseX;
            int_2 = (GrandExchangeOffer.localPlayer.y >> 7) + WorldMapData_Sub1.baseY;
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int_8 << 14) + int_2
                + (int_1 << 28);
            byte_0 = 1;
          } else if (int_0 == 3309) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 >> 14 & 0x3FFF;
            byte_0 = 1;
          } else if (int_0 == 3310) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 >> 28;
            byte_0 = 1;
          } else if (int_0 == 3311) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 & 0x3FFF;
            byte_0 = 1;
          } else if (int_0 == 3312) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.isMembers ? 1 : 0;
            byte_0 = 1;
          } else if (int_0 == 3313) {
            ScriptExecutor.intStackSize -= 2;
            int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize] + 32768;
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = GroundItem.method931(int_1, int_8);
            byte_0 = 1;
          } else if (int_0 == 3314) {
            ScriptExecutor.intStackSize -= 2;
            int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize] + 32768;
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Enum.method829(int_1, int_8);
            byte_0 = 1;
          } else if (int_0 == 3315) {
            ScriptExecutor.intStackSize -= 2;
            int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize] + 32768;
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            ints_3 = ScriptExecutor.intStack;
            int_9 = ++ScriptExecutor.intStackSize - 1;
            itemcontainer_0 = (Inventory) Inventory.inventories.get(int_1);
            if (itemcontainer_0 == null) {
              int_4 = 0;
            } else if (int_8 == -1) {
              int_4 = 0;
            } else {
              int_10 = 0;

              for (int_5 = 0; int_5 < itemcontainer_0.counts.length; int_5++) {
                if (int_8 == itemcontainer_0.ids[int_5]) {
                  int_10 += itemcontainer_0.counts[int_5];
                }
              }

              int_4 = int_10;
            }

            ints_3[int_9] = int_4;
            byte_0 = 1;
          } else if (int_0 == 3316) {
            if (Client.rights >= 2) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.rights;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
            }

            byte_0 = 1;
          } else if (int_0 == 3317) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.anInt593;
            byte_0 = 1;
          } else if (int_0 == 3318) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.world;
            byte_0 = 1;
          } else if (int_0 == 3321) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.energy;
            byte_0 = 1;
          } else if (int_0 == 3322) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.weight;
            byte_0 = 1;
          } else if (int_0 == 3323) {
            if (Client.aBool88) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 1;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
            }

            byte_0 = 1;
          } else if (int_0 == 3324) {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.flags;
            byte_0 = 1;
          } else if (int_0 == 3325) {
            ScriptExecutor.intStackSize -= 4;
            int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
            int_9 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
            int_1 += int_8 << 14;
            int_1 += int_2 << 28;
            int_1 += int_9;
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1;
            byte_0 = 1;
          } else {
            byte_0 = 2;
          }
        }
      }

      return byte_0;
    }
    if (int_0 < 3500) {
      if (int_0 == 3400) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        Enum enum_1 = Class86.method491(int_1);
        if (enum_1.valType != 115) {
        }

        for (int_9 = 0; int_9 < enum_1.size; int_9++) {
          if (int_8 == enum_1.keys[int_9]) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                - 1] = enum_1.stringVals[int_9];
            enum_1 = null;
            break;
          }
        }

        if (enum_1 != null) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = enum_1.defaultString;
        }

        byte_0 = 1;
      } else if (int_0 == 3408) {
        ScriptExecutor.intStackSize -= 4;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        int_9 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
        Enum enum_0 = Class86.method491(int_2);
        if (int_1 == enum_0.keyType && int_8 == enum_0.valType) {
          for (int_3 = 0; int_3 < enum_0.size; int_3++) {
            if (int_9 == enum_0.keys[int_3]) {
              if (int_8 == 115) {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                    - 1] = enum_0.stringVals[int_3];
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = enum_0.intVals[int_3];
              }

              enum_0 = null;
              break;
            }
          }

          if (enum_0 != null) {
            if (int_8 == 115) {
              ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                  - 1] = enum_0.defaultString;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = enum_0.defaultInt;
            }
          }

          byte_0 = 1;
        } else {
          if (int_8 == 115) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "null";
          } else {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          }

          byte_0 = 1;
        }
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    String string_0;
    if (int_0 < 3700) {
      if (int_0 == 3600) {
        if (Client.anInt687 == 0) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -2;
        } else if (Client.anInt687 == 1) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.friendCount;
        }

        byte_0 = 1;
      } else if (int_0 == 3601) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        if (Client.anInt687 == 2 && int_1 < Client.friendCount) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = Client.friends[int_1].name;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = Client.friends[int_1].previousName;
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 3602) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        if (Client.anInt687 == 2 && int_1 < Client.friendCount) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.friends[int_1].world;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 3603) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        if (Client.anInt687 == 2 && int_1 < Client.friendCount) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.friends[int_1].rank;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        }

        byte_0 = 1;
      } else if (int_0 == 3604) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        Class24.method221(string_4, int_8);
        byte_0 = 1;
      } else {
        Friend friend_0;
        Ignore ignore_0;
        String string_2;
        if (int_0 == 3605) {
          string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
          if (string_4 != null) {
            if ((Client.friendCount < 200 || Client.anInt663 == 1)
                && Client.friendCount < 400) {
              string_5 = FloorUnderlayDefinition.method869(string_4,
                  AClass1_Sub2.aClass108_10);
              if (string_5 != null) {
                int_2 = 0;

                label2009:
                while (true) {
                  if (int_2 >= Client.friendCount) {
                    for (int_2 = 0; int_2 < Client.ignoreCount; int_2++) {
                      ignore_0 = Client.ignores[int_2];
                      string_2 = FloorUnderlayDefinition.method869(ignore_0.name,
                          AClass1_Sub2.aClass108_10);
                      if (string_2 != null && string_2.equals(string_5)) {
                        Npc.sendGameMessage(30, "", "Please remove " + string_4
                            + " from your ignore list first");
                        break label2009;
                      }

                      if (ignore_0.previousName != null) {
                        string_0 = FloorUnderlayDefinition.method869(
                            ignore_0.previousName,
                            AClass1_Sub2.aClass108_10);
                        if (string_0 != null && string_0.equals(string_5)) {
                          Npc.sendGameMessage(30, "",
                              "Please remove " + string_4
                                  + " from your ignore list first");
                          break label2009;
                        }
                      }
                    }

                    if (FloorUnderlayDefinition
                        .method869(GrandExchangeOffer.localPlayer.name,
                            AClass1_Sub2.aClass108_10)
                        .equals(string_5)) {
                      Npc.sendGameMessage(30, "",
                          "You can\'t addFirst yourself to your own friend list");
                    } else {
                      Client.outbound.putEncipheredByte(226);
                      Client.outbound
                          .putByte(Class64.getLength(string_4));
                      Client.outbound.putString(string_4);
                    }
                    break;
                  }

                  friend_0 = Client.friends[int_2];
                  string_2 = FloorUnderlayDefinition.method869(friend_0.name,
                      AClass1_Sub2.aClass108_10);
                  if (string_2 != null && string_2.equals(string_5)) {
                    Npc.sendGameMessage(30, "",
                        string_4 + " is already on your friend list");
                    break;
                  }

                  if (friend_0.previousName != null) {
                    string_0 = FloorUnderlayDefinition.method869(
                        friend_0.previousName, AClass1_Sub2.aClass108_10);
                    if (string_0 != null && string_0.equals(string_5)) {
                      Npc.sendGameMessage(30, "",
                          string_4 + " is already on your friend list");
                      break;
                    }
                  }

                  ++int_2;
                }
              }
            } else {
              Npc.sendGameMessage(30, "",
                  "Your friend list is full. Max of 200 for free users, and 400 for members");
            }
          }

          byte_0 = 1;
        } else {
          boolean bool_3;
          if (int_0 == 3606) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            if (string_4 != null) {
              string_5 = FloorUnderlayDefinition.method869(string_4,
                  AClass1_Sub2.aClass108_10);
              if (string_5 != null) {
                for (int_2 = 0; int_2 < Client.friendCount; int_2++) {
                  friend_0 = Client.friends[int_2];
                  string_2 = friend_0.name;
                  string_0 = FloorUnderlayDefinition.method869(string_2,
                      AClass1_Sub2.aClass108_10);
                  if (string_4 != null && string_2 != null) {
                    if (!string_4.startsWith("#") && !string_2.startsWith("#")) {
                      bool_3 = string_5.equals(string_0);
                    } else {
                      bool_3 = string_4.equals(string_2);
                    }
                  } else {
                    bool_3 = false;
                  }

                  if (bool_3) {
                    --Client.friendCount;

                    for (int_5 = int_2; int_5 < Client.friendCount; int_5++) {
                      Client.friends[int_5] = Client.friends[int_5 + 1];
                    }

                    Client.anInt646 = Client.cycleCntr;
                    Client.outbound.putEncipheredByte(175);
                    Client.outbound.putByte(Class64.getLength(string_4));
                    Client.outbound.putString(string_4);
                    break;
                  }
                }
              }
            }

            byte_0 = 1;
          } else if (int_0 == 3607) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            if (string_4 != null) {
              if ((Client.ignoreCount < 100 || Client.anInt663 == 1)
                  && Client.ignoreCount < 400) {
                string_5 = FloorUnderlayDefinition.method869(string_4,
                    AClass1_Sub2.aClass108_10);
                if (string_5 != null) {
                  int_2 = 0;

                  label1947:
                  while (true) {
                    if (int_2 >= Client.ignoreCount) {
                      for (int_2 = 0; int_2 < Client.friendCount; int_2++) {
                        friend_0 = Client.friends[int_2];
                        string_2 = FloorUnderlayDefinition.method869(
                            friend_0.name, AClass1_Sub2.aClass108_10);
                        if (string_2 != null && string_2.equals(string_5)) {
                          Npc.sendGameMessage(31, "",
                              "Please remove " + string_4
                                  + " from your friend list first");
                          break label1947;
                        }

                        if (friend_0.previousName != null) {
                          string_0 = FloorUnderlayDefinition.method869(
                              friend_0.previousName,
                              AClass1_Sub2.aClass108_10);
                          if (string_0 != null
                              && string_0.equals(string_5)) {
                            Npc.sendGameMessage(31, "", "Please remove "
                                + string_4
                                + " from your friend list first");
                            break label1947;
                          }
                        }
                      }

                      if (FloorUnderlayDefinition
                          .method869(GrandExchangeOffer.localPlayer.name,
                              AClass1_Sub2.aClass108_10)
                          .equals(string_5)) {
                        Npc.sendGameMessage(31, "",
                            "You can\'t addFirst yourself to your own ignore list");
                      } else {
                        Client.outbound.putEncipheredByte(64);
                        Client.outbound
                            .putByte(Class64.getLength(string_4));
                        Client.outbound.putString(string_4);
                      }
                      break;
                    }

                    ignore_0 = Client.ignores[int_2];
                    string_2 = FloorUnderlayDefinition.method869(ignore_0.name,
                        AClass1_Sub2.aClass108_10);
                    if (string_2 != null && string_2.equals(string_5)) {
                      Npc.sendGameMessage(31, "",
                          string_4 + " is already on your ignore list");
                      break;
                    }

                    if (ignore_0.previousName != null) {
                      string_0 = FloorUnderlayDefinition.method869(
                          ignore_0.previousName, AClass1_Sub2.aClass108_10);
                      if (string_0 != null && string_0.equals(string_5)) {
                        Npc.sendGameMessage(31, "",
                            string_4 + " is already on your ignore list");
                        break;
                      }
                    }

                    ++int_2;
                  }
                }
              } else {
                Npc.sendGameMessage(31, "",
                    "Your ignore list is full. Max of 100 for free users, and 400 for members");
              }
            }

            byte_0 = 1;
          } else if (int_0 == 3608) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            if (string_4 != null) {
              string_5 = FloorUnderlayDefinition.method869(string_4,
                  AClass1_Sub2.aClass108_10);
              if (string_5 != null) {
                for (int_2 = 0; int_2 < Client.ignoreCount; int_2++) {
                  ignore_0 = Client.ignores[int_2];
                  string_2 = ignore_0.name;
                  string_0 = FloorUnderlayDefinition.method869(string_2,
                      AClass1_Sub2.aClass108_10);
                  if (string_4 != null && string_2 != null) {
                    if (!string_4.startsWith("#") && !string_2.startsWith("#")) {
                      bool_3 = string_5.equals(string_0);
                    } else {
                      bool_3 = string_4.equals(string_2);
                    }
                  } else {
                    bool_3 = false;
                  }

                  if (bool_3) {
                    --Client.ignoreCount;

                    for (int_5 = int_2; int_5 < Client.ignoreCount; int_5++) {
                      Client.ignores[int_5] = Client.ignores[int_5 + 1];
                    }

                    Client.anInt646 = Client.cycleCntr;
                    Client.outbound.putEncipheredByte(180);
                    Client.outbound.putByte(Class64.getLength(string_4));
                    Client.outbound.putString(string_4);
                    break;
                  }
                }
              }
            }

            byte_0 = 1;
          } else if (int_0 == 3609) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            final UserGroup[] permissions_1 = new UserGroup[] {
                UserGroup.USER_GROUP_3,
                UserGroup.USER_GROUP_5, UserGroup.USER_GROUP_1,
                UserGroup.USER_GROUP_4, UserGroup.USER_GROUP_2,
                UserGroup.USER_GROUP_0
            };
            final UserGroup[] permissions_0 = permissions_1;

            for (int_9 = 0; int_9 < permissions_0.length; int_9++) {
              final UserGroup permission_0 = permissions_0[int_9];
              if (permission_0.anInt292 != -1
                  && string_4.startsWith(Class46.method292(permission_0.anInt292))) {
                string_4 = string_4.substring(
                    6 + Integer.toString(permission_0.anInt292).length());
                break;
              }
            }

            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = WorldMapType2
                .isFriended(string_4, false) ? 1 : 0;
            byte_0 = 1;
          } else {
            String string_1;
            long long_4;
            int int_6;
            int int_7;
            char char_0;
            String string_3;
            String[] strings_1;
            if (int_0 == 3611) {
              if (Client.clanChatOwner == null) {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
              } else {
                strings_1 = ScriptExecutor.scriptStringStack;
                int_8 = ++Class26.scriptStringStackSize - 1;
                string_3 = Client.clanChatOwner;
                long_4 = 0L;
                int_6 = string_3.length();

                for (int_7 = 0; int_7 < int_6; int_7++) {
                  long_4 *= 37L;
                  char_0 = string_3.charAt(int_7);
                  if (char_0 >= 65 && char_0 <= 90) {
                    long_4 += char_0 + 1 - 65;
                  } else if (char_0 >= 97 && char_0 <= 122) {
                    long_4 += char_0 + 1 - 97;
                  } else if (char_0 >= 48 && char_0 <= 57) {
                    long_4 += char_0 + 27 - 48;
                  }

                  if (long_4 >= 177917621779460413L) {
                    break;
                  }
                }

                while (long_4 % 37L == 0L && long_4 != 0L) {
                  long_4 /= 37L;
                }

                string_1 = AClass1_Sub2.method624(long_4);
                if (string_1 == null) {
                  string_1 = "";
                }

                strings_1[int_8] = string_1;
              }

              byte_0 = 1;
            } else if (int_0 == 3612) {
              if (Client.clanChatOwner != null) {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Node_Sub1.clanChatCount;
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
              }

              byte_0 = 1;
            } else if (int_0 == 3613) {
              int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
              if (Client.clanChatOwner != null && int_1 < Node_Sub1.clanChatCount) {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                    - 1] = AClass1.clanMembers[int_1].username;
              } else {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
              }

              byte_0 = 1;
            } else if (int_0 == 3614) {
              int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
              if (Client.clanChatOwner != null && int_1 < Node_Sub1.clanChatCount) {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                    - 1] = AClass1.clanMembers[int_1].world;
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
              }

              byte_0 = 1;
            } else if (int_0 == 3615) {
              int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
              if (Client.clanChatOwner != null && int_1 < Node_Sub1.clanChatCount) {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                    - 1] = AClass1.clanMembers[int_1].rank;
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
              }

              byte_0 = 1;
            } else if (int_0 == 3616) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Mouse.aByte2;
              byte_0 = 1;
            } else if (int_0 == 3617) {
              string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
              if (AClass1.clanMembers != null) {
                Client.outbound.putEncipheredByte(12);
                Client.outbound.putByte(Class64.getLength(string_4));
                Client.outbound.putString(string_4);
              }

              byte_0 = 1;
            } else if (int_0 == 3618) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = ScriptExecutor.clanChatRank;
              byte_0 = 1;
            } else if (int_0 == 3619) {
              string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
              if (!string_4.equals("")) {
                Client.outbound.putEncipheredByte(136);
                Client.outbound.putByte(Class64.getLength(string_4));
                Client.outbound.putString(string_4);
              }

              byte_0 = 1;
            } else if (int_0 == 3620) {
              Client.outbound.putEncipheredByte(136);
              Client.outbound.putByte(0);
              byte_0 = 1;
            } else if (int_0 == 3621) {
              if (Client.anInt687 == 0) {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.ignoreCount;
              }

              byte_0 = 1;
            } else if (int_0 == 3622) {
              int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
              if (Client.anInt687 != 0 && int_1 < Client.ignoreCount) {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                    - 1] = Client.ignores[int_1].name;
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                    - 1] = Client.ignores[int_1].previousName;
              } else {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
              }

              byte_0 = 1;
            } else if (int_0 == 3623) {
              string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
              if (string_4.startsWith(Class46.method292(0))
                  || string_4.startsWith(Class46.method292(1))) {
                string_4 = string_4.substring(7);
              }

              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Enum1.isIgnored(string_4) ? 1
                  : 0;
              byte_0 = 1;
            } else if (int_0 == 3624) {
              int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
              if (AClass1.clanMembers != null && int_1 < Node_Sub1.clanChatCount
                  && AClass1.clanMembers[int_1].username
                  .equalsIgnoreCase(GrandExchangeOffer.localPlayer.name)) {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 1;
              } else {
                ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
              }

              byte_0 = 1;
            } else if (int_0 == 3625) {
              if (Client.clanChatName == null) {
                ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
              } else {
                strings_1 = ScriptExecutor.scriptStringStack;
                int_8 = ++Class26.scriptStringStackSize - 1;
                string_3 = Client.clanChatName;
                long_4 = 0L;
                int_6 = string_3.length();

                for (int_7 = 0; int_7 < int_6; int_7++) {
                  long_4 *= 37L;
                  char_0 = string_3.charAt(int_7);
                  if (char_0 >= 65 && char_0 <= 90) {
                    long_4 += char_0 + 1 - 65;
                  } else if (char_0 >= 97 && char_0 <= 122) {
                    long_4 += char_0 + 1 - 97;
                  } else if (char_0 >= 48 && char_0 <= 57) {
                    long_4 += char_0 + 27 - 48;
                  }

                  if (long_4 >= 177917621779460413L) {
                    break;
                  }
                }

                while (long_4 % 37L == 0L && long_4 != 0L) {
                  long_4 /= 37L;
                }

                string_1 = AClass1_Sub2.method624(long_4);
                if (string_1 == null) {
                  string_1 = "";
                }

                strings_1[int_8] = string_1;
              }

              byte_0 = 1;
            } else {
              byte_0 = 2;
            }
          }
        }
      }

      return byte_0;
    }
    if (int_0 < 4000) {
      return Enum6.method674(int_0, script_0, bool_0);
    }
    if (int_0 < 4100) {
      if (int_0 == 4000) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_8 + int_1;
        byte_0 = 1;
      } else if (int_0 == 4001) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 - int_8;
        byte_0 = 1;
      } else if (int_0 == 4002) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_8 * int_1;
        byte_0 = 1;
      } else if (int_0 == 4003) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 / int_8;
        byte_0 = 1;
      } else if (int_0 == 4004) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int) (Math.random() * int_1);
        byte_0 = 1;
      } else if (int_0 == 4005) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int) (Math.random() * (int_1 + 1));
        byte_0 = 1;
      } else if (int_0 == 4006) {
        ScriptExecutor.intStackSize -= 5;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        int_9 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
        int_4 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 4];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1
            + (int_4 - int_2) * (int_8 - int_1) / (int_9 - int_2);
        byte_0 = 1;
      } else if (int_0 == 4007) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 + int_1 * int_8 / 100;
        byte_0 = 1;
      } else if (int_0 == 4008) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 | 1 << int_8;
        byte_0 = 1;
      } else if (int_0 == 4009) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 & -1 - (1 << int_8);
        byte_0 = 1;
      } else if (int_0 == 4010) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int_1 & 1 << int_8) != 0 ? 1 : 0;
        byte_0 = 1;
      } else if (int_0 == 4011) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 % int_8;
        byte_0 = 1;
      } else if (int_0 == 4012) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (int_1 == 0) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int) Math.pow(int_1, int_8);
        }

        byte_0 = 1;
      } else if (int_0 == 4013) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (int_1 == 0) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
        } else if (int_8 == 0) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Integer.MAX_VALUE;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int) Math.pow(int_1, 1.0D / int_8);
        }

        byte_0 = 1;
      } else if (int_0 == 4014) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 & int_8;
        byte_0 = 1;
      } else if (int_0 == 4015) {
        ScriptExecutor.intStackSize -= 2;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1 | int_8;
        byte_0 = 1;
      } else if (int_0 == 4018) {
        ScriptExecutor.intStackSize -= 3;
        final long long_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        final long long_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        final long long_3 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = (int) (long_1 * long_3 / long_2);
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    boolean bool_2;
    if (int_0 < 4200) {
      if (int_0 == 4100) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4 + int_8;
        byte_0 = 1;
      } else if (int_0 == 4101) {
        Class26.scriptStringStackSize -= 2;
        string_4 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
        string_5 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4
            + string_5;
        byte_0 = 1;
      } else if (int_0 == 4102) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        final String[] strings_0 = ScriptExecutor.scriptStringStack;
        int_9 = ++Class26.scriptStringStackSize - 1;
        if (int_8 < 0) {
          string_0 = Integer.toString(int_8);
        } else {
          string_0 = method908(int_8, 10, true);
        }

        strings_0[int_9] = string_4 + string_0;
        byte_0 = 1;
      } else if (int_0 == 4103) {
        string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4
            .toLowerCase();
        byte_0 = 1;
      } else if (int_0 == 4104) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        final long long_0 = (int_1 + 11745L) * 86400000L;
        ScriptExecutor.aCalendar1.setTime(new Date(long_0));
        int_9 = ScriptExecutor.aCalendar1.get(5);
        int_4 = ScriptExecutor.aCalendar1.get(2);
        int_3 = ScriptExecutor.aCalendar1.get(1);
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = int_9 + "-"
            + ScriptExecutor.MONTHS[int_4] + "-" + int_3;
        byte_0 = 1;
      } else if (int_0 == 4105) {
        Class26.scriptStringStackSize -= 2;
        string_4 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
        string_5 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
        if (GrandExchangeOffer.localPlayer.composition != null
            && GrandExchangeOffer.localPlayer.composition.isFemale) {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_5;
        } else {
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4;
        }

        byte_0 = 1;
      } else if (int_0 == 4106) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = Integer
            .toString(int_1);
        byte_0 = 1;
      } else if (int_0 == 4107) {
        Class26.scriptStringStackSize -= 2;
        final int[] ints_1 = ScriptExecutor.intStack;
        int_8 = ++ScriptExecutor.intStackSize - 1;
        int_9 = ScriptExecutor.method242(ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize],
            ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1],
            Client.languageId);
        byte byte_1;
        if (int_9 > 0) {
          byte_1 = 1;
        } else if (int_9 < 0) {
          byte_1 = -1;
        } else {
          byte_1 = 0;
        }

        ints_1[int_8] = byte_1;
        byte_0 = 1;
      } else {
        byte[] bytes_0;
        BitmapFont font_0;
        if (int_0 == 4108) {
          string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
          ScriptExecutor.intStackSize -= 2;
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          bytes_0 = FontType.anIndexData3.get(int_2, 0);
          font_0 = new BitmapFont(bytes_0);
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = font_0.method994(string_4,
              int_8);
          byte_0 = 1;
        } else if (int_0 == 4109) {
          string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
          ScriptExecutor.intStackSize -= 2;
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          bytes_0 = FontType.anIndexData3.get(int_2, 0);
          font_0 = new BitmapFont(bytes_0);
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = font_0.method997(string_4,
              int_8);
          byte_0 = 1;
        } else if (int_0 == 4110) {
          Class26.scriptStringStackSize -= 2;
          string_4 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
          string_5 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
          if (ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4;
          } else {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_5;
          }

          byte_0 = 1;
        } else if (int_0 == 4111) {
          string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = AbstractFont
              .appendTags(string_4);
          byte_0 = 1;
        } else if (int_0 == 4112) {
          string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
          int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4
              + (char) int_8;
          byte_0 = 1;
        } else if (int_0 == 4113) {
          int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class12.method164((char) int_1)
              ? 1
              : 0;
          byte_0 = 1;
        } else if (int_0 == 4114) {
          int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = DecorativeObject
              .method479((char) int_1) ? 1 : 0;
          byte_0 = 1;
        } else {
          char char_1;
          if (int_0 == 4115) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ints_2 = ScriptExecutor.intStack;
            int_2 = ++ScriptExecutor.intStackSize - 1;
            char_1 = (char) int_1;
            bool_2 = char_1 >= 65 && char_1 <= 90
                || char_1 >= 97 && char_1 <= 122;
            ints_2[int_2] = bool_2 ? 1 : 0;
            byte_0 = 1;
          } else if (int_0 == 4116) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ints_2 = ScriptExecutor.intStack;
            int_2 = ++ScriptExecutor.intStackSize - 1;
            char_1 = (char) int_1;
            bool_2 = char_1 >= 48 && char_1 <= 57;
            ints_2[int_2] = bool_2 ? 1 : 0;
            byte_0 = 1;
          } else if (int_0 == 4117) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            if (string_4 != null) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = string_4.length();
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
            }

            byte_0 = 1;
          } else if (int_0 == 4118) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            ScriptExecutor.intStackSize -= 2;
            int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
            int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = string_4
                .substring(int_8, int_2);
            byte_0 = 1;
          } else if (int_0 == 4119) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            final StringBuilder stringbuilder_0 = new StringBuilder(string_4.length());
            boolean bool_4 = false;

            for (int_9 = 0; int_9 < string_4.length(); int_9++) {
              char_1 = string_4.charAt(int_9);
              if (char_1 == 60) {
                bool_4 = true;
              } else if (char_1 == 62) {
                bool_4 = false;
              } else if (!bool_4) {
                stringbuilder_0.append(char_1);
              }
            }

            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                - 1] = stringbuilder_0.toString();
            byte_0 = 1;
          } else if (int_0 == 4120) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = string_4.indexOf(int_8);
            byte_0 = 1;
          } else if (int_0 == 4121) {
            Class26.scriptStringStackSize -= 2;
            string_4 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize];
            string_5 = ScriptExecutor.scriptStringStack[Class26.scriptStringStackSize + 1];
            int_2 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = string_4.indexOf(string_5,
                int_2);
            byte_0 = 1;
          } else {
            byte_0 = 2;
          }
        }
      }

      return byte_0;
    }
    if (int_0 < 4300) {
      if (int_0 == 4200) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = AudioWorker
            .getItemDefinition(int_1).name;
        byte_0 = 1;
      } else {
        ItemConfig itemcomposition_1;
        if (int_0 == 4201) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          itemcomposition_1 = AudioWorker.getItemDefinition(int_1);
          if (int_8 >= 1 && int_8 <= 5
              && itemcomposition_1.groundActions[int_8 - 1] != null) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                - 1] = itemcomposition_1.groundActions[int_8 - 1];
          } else {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          }

          byte_0 = 1;
        } else if (int_0 == 4202) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          itemcomposition_1 = AudioWorker.getItemDefinition(int_1);
          if (int_8 >= 1 && int_8 <= 5
              && itemcomposition_1.inventoryActions[int_8 - 1] != null) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                - 1] = itemcomposition_1.inventoryActions[int_8 - 1];
          } else {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          }

          byte_0 = 1;
        } else if (int_0 == 4203) {
          int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = AudioWorker
              .getItemDefinition(int_1).price;
          byte_0 = 1;
        } else if (int_0 == 4204) {
          int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize
              - 1] = AudioWorker.getItemDefinition(int_1).isStackable == 1 ? 1 : 0;
          byte_0 = 1;
        } else {
          ItemConfig itemcomposition_0;
          if (int_0 == 4205) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
            if (itemcomposition_0.notedTemplate == -1
                && itemcomposition_0.note >= 0) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = itemcomposition_0.note;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1;
            }

            byte_0 = 1;
          } else if (int_0 == 4206) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
            if (itemcomposition_0.notedTemplate >= 0
                && itemcomposition_0.note >= 0) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = itemcomposition_0.note;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1;
            }

            byte_0 = 1;
          } else if (int_0 == 4207) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                - 1] = AudioWorker.getItemDefinition(int_1).isMembers ? 1 : 0;
            byte_0 = 1;
          } else if (int_0 == 4208) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
            if (itemcomposition_0.anInt493 == -1
                && itemcomposition_0.anInt494 >= 0) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                  - 1] = itemcomposition_0.anInt494;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1;
            }

            byte_0 = 1;
          } else if (int_0 == 4209) {
            int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            itemcomposition_0 = AudioWorker.getItemDefinition(int_1);
            if (itemcomposition_0.anInt493 >= 0
                && itemcomposition_0.anInt494 >= 0) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                  - 1] = itemcomposition_0.anInt494;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = int_1;
            }

            byte_0 = 1;
          } else if (int_0 == 4210) {
            string_4 = ScriptExecutor.scriptStringStack[--Class26.scriptStringStackSize];
            int_8 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
            Class16.method199(string_4, int_8 == 1);
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = AClass1_Sub2.anInt306;
            byte_0 = 1;
          } else if (int_0 == 4211) {
            if (Class85.aShortArray3 != null
                && Class64.anInt165 < AClass1_Sub2.anInt306) {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize
                  - 1] = Class85.aShortArray3[++Class64.anInt165 - 1] & 0xFFFF;
            } else {
              ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
            }

            byte_0 = 1;
          } else if (int_0 == 4212) {
            Class64.anInt165 = 0;
            byte_0 = 1;
          } else {
            byte_0 = 2;
          }
        }
      }

      return byte_0;
    }
    if (int_0 < 5100) {
      return CombatInfo1.method670(int_0, script_0, bool_0);
    }
    if (int_0 < 5400) {
      return Class40.method273(int_0, script_0, bool_0);
    }
    if (int_0 < 5600) {
      if (int_0 == 5504) {
        ScriptExecutor.intStackSize -= 2;
        int_9 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        int_4 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (!Client.aBool87) {
          Client.anInt653 = int_9;
          Client.mapAngle = int_4;
        }

        byte_0 = 1;
      } else if (int_0 == 5505) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.anInt653;
        byte_0 = 1;
      } else if (int_0 == 5506) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.mapAngle;
        byte_0 = 1;
      } else if (int_0 == 5530) {
        int_9 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        if (int_9 < 0) {
          int_9 = 0;
        }

        Client.anInt678 = int_9;
        byte_0 = 1;
      } else if (int_0 == 5531) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.anInt678;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 < 5700) {
      return Time.method396(int_0, script_0, bool_0);
    }
    if (int_0 < 6300) {
      if (int_0 == 6200) {
        ScriptExecutor.intStackSize -= 2;
        Client.aShort4 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        if (Client.aShort4 <= 0) {
          Client.aShort4 = 256;
        }

        Client.aShort3 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (Client.aShort3 <= 0) {
          Client.aShort3 = 205;
        }

        byte_0 = 1;
      } else if (int_0 == 6201) {
        ScriptExecutor.intStackSize -= 2;
        Client.aShort9 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        if (Client.aShort9 <= 0) {
          Client.aShort9 = 256;
        }

        Client.aShort8 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (Client.aShort8 <= 0) {
          Client.aShort8 = 320;
        }

        byte_0 = 1;
      } else if (int_0 == 6202) {
        ScriptExecutor.intStackSize -= 4;
        Client.aShort10 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        if (Client.aShort10 <= 0) {
          Client.aShort10 = 1;
        }

        Client.aShort7 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
        if (Client.aShort7 <= 0) {
          Client.aShort7 = 32767;
        } else if (Client.aShort7 < Client.aShort10) {
          Client.aShort7 = Client.aShort10;
        }

        Client.aShort5 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        if (Client.aShort5 <= 0) {
          Client.aShort5 = 1;
        }

        Client.aShort6 = (short) ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3];
        if (Client.aShort6 <= 0) {
          Client.aShort6 = 32767;
        } else if (Client.aShort6 < Client.aShort5) {
          Client.aShort6 = Client.aShort5;
        }

        byte_0 = 1;
      } else if (int_0 == 6203) {
        if (Client.aWidget11 != null) {
          Class69_Sub1.method611(0, 0, Client.aWidget11.width, Client.aWidget11.height,
              false);
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.viewportHeight;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.viewportWidth;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
        }

        byte_0 = 1;
      } else if (int_0 == 6204) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.aShort9;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.aShort8;
        byte_0 = 1;
      } else if (int_0 == 6205) {
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.aShort4;
        ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Client.aShort3;
        byte_0 = 1;
      } else {
        byte_0 = 2;
      }

      return byte_0;
    }
    if (int_0 >= 6600) {
      return int_0 < 6700 ? Class82.method487(int_0, script_0, bool_0) : 2;
    }
    if (int_0 == 6500) {
      ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Ignore.loadWorlds() ? 1 : 0;
      byte_0 = 1;
    } else {
      World world_1;
      if (int_0 == 6501) {
        World.anInt210 = 0;
        if (World.anInt210 < World.worldCount) {
          world_1 = World.worldList[++World.anInt210 - 1];
        } else {
          world_1 = null;
        }

        if (world_1 != null) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.id;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.mask;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.activity;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.location;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.playerCount;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.address;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 6502) {
        World world_0;
        if (World.anInt210 < World.worldCount) {
          world_0 = World.worldList[++World.anInt210 - 1];
        } else {
          world_0 = null;
        }

        if (world_0 != null) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_0.id;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_0.mask;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_0.activity;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_0.location;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_0.playerCount;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_0.address;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 6506) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        world_1 = null;

        for (int_2 = 0; int_2 < World.worldCount; int_2++) {
          if (int_1 == World.worldList[int_2].id) {
            world_1 = World.worldList[int_2];
            break;
          }
        }

        if (world_1 != null) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.id;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.mask;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.activity;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.location;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.playerCount;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.address;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 6507) {
        ScriptExecutor.intStackSize -= 4;
        int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
        bool_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1] == 1;
        int_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 2];
        bool_2 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 3] == 1;
        Class13.method169(int_1, bool_1, int_2, bool_2);
        byte_0 = 1;
      } else if (int_0 == 6511) {
        int_1 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize];
        if (int_1 >= 0 && int_1 < World.worldCount) {
          world_1 = World.worldList[int_1];
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.id;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.mask;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.activity;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.location;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = world_1.playerCount;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
              - 1] = world_1.address;
        } else {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = -1;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = "";
        }

        byte_0 = 1;
      } else if (int_0 == 6512) {
        Client.aBool92 = ScriptExecutor.intStack[--ScriptExecutor.intStackSize] == 1;
        byte_0 = 1;
      } else {
        CacheableNode_Sub3 cacheablenode_sub3_0;
        if (int_0 == 6513) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          cacheablenode_sub3_0 = RemoteEnvironment.method524(int_8);
          if (cacheablenode_sub3_0.method845()) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = Timestamp
                .getNpcDefinition(int_1)
                .method867(int_8, cacheablenode_sub3_0.aString30);
          } else {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Timestamp
                .getNpcDefinition(int_1)
                .method866(int_8, cacheablenode_sub3_0.anInt476);
          }

          byte_0 = 1;
        } else if (int_0 == 6514) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          cacheablenode_sub3_0 = RemoteEnvironment.method524(int_8);
          if (cacheablenode_sub3_0.method845()) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = Class2
                .getObjectDefinition(int_1)
                .method826(int_8, cacheablenode_sub3_0.aString30);
          } else {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Class2
                .getObjectDefinition(int_1)
                .method825(int_8, cacheablenode_sub3_0.anInt476);
          }

          byte_0 = 1;
        } else if (int_0 == 6515) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          cacheablenode_sub3_0 = RemoteEnvironment.method524(int_8);
          if (cacheablenode_sub3_0.method845()) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize
                - 1] = AudioWorker.getItemDefinition(int_1).method904(int_8,
                cacheablenode_sub3_0.aString30);
          } else {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = AudioWorker
                .getItemDefinition(int_1)
                .method903(int_8, cacheablenode_sub3_0.anInt476);
          }

          byte_0 = 1;
        } else if (int_0 == 6516) {
          ScriptExecutor.intStackSize -= 2;
          int_1 = ScriptExecutor.intStack[ScriptExecutor.intStackSize];
          int_8 = ScriptExecutor.intStack[ScriptExecutor.intStackSize + 1];
          cacheablenode_sub3_0 = RemoteEnvironment.method524(int_8);
          if (cacheablenode_sub3_0.method845()) {
            ScriptExecutor.scriptStringStack[++Class26.scriptStringStackSize - 1] = Boundry
                .method157(int_1)
                .method851(int_8, cacheablenode_sub3_0.aString30);
          } else {
            ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = Boundry.method157(int_1)
                .method852(int_8, cacheablenode_sub3_0.anInt476);
          }

          byte_0 = 1;
        } else if (int_0 == 6518) {
          ScriptExecutor.intStack[++ScriptExecutor.intStackSize - 1] = 0;
          byte_0 = 1;
        } else if (int_0 == 6520) {
          byte_0 = 1;
        } else if (int_0 == 6521) {
          byte_0 = 1;
        } else {
          byte_0 = 2;
        }
      }
    }

    return byte_0;
  }

  public static String method908(int int_0, final int int_1, final boolean bool_0) {
    if (int_1 >= 2 && int_1 <= 36) {
      if (int_0 < 0) {
        return Integer.toString(int_0, int_1);
      }
      int int_2 = 2;

      for (int int_3 = int_0 / int_1; int_3 != 0; int_2++) {
        int_3 /= int_1;
      }

      final char[] chars_0 = new char[int_2];
      chars_0[0] = 43;

      for (int int_4 = int_2 - 1; int_4 > 0; --int_4) {
        final int int_5 = int_0;
        int_0 /= int_1;
        final int int_6 = int_5 - int_0 * int_1;
        if (int_6 >= 10) {
          chars_0[int_4] = (char) (int_6 + 87);
        } else {
          chars_0[int_4] = (char) (int_6 + 48);
        }
      }

      return new String(chars_0);
    }
    throw new IllegalArgumentException("");
  }

  void decode(final Buffer buffer_0, final int int_0) {
    if (int_0 == 5) {
      configType = buffer_0.getUnsignedShort();
    }

  }

  public void decode(final Buffer buffer_0) {
    while (true) {
      final int int_0 = buffer_0.getUnsignedByte();
      if (int_0 == 0) {
        return;
      }

      this.decode(buffer_0, int_0);
    }
  }

}
