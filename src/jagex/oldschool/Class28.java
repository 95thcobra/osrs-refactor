package jagex.oldschool;

import jagex.oldschool.io.AbstractByteBuffer;
import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.script.LongVariable;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.social.Ignore;
import jagex.oldschool.ui.InterfaceComponent;

public class Class28 {

  int anInt77;
  int anInt78;
  int anInt79;
  int anInt80;
  String aString6;

  public static void method236(final InterfaceComponent widget_0) {
    if (widget_0.loopCycle == Client.anInt597) {
      Client.aBoolArray8[widget_0.boundsIndex] = true;
    }

  }

  public static byte[] toByteArray(final Object object_0, final boolean bool_0) {
    if (object_0 == null) {
      return null;
    }
    if (object_0 instanceof byte[]) {
      final byte[] bytes_1 = (byte[]) object_0;
      if (bool_0) {
        final int int_0 = bytes_1.length;
        final byte[] bytes_0 = new byte[int_0];
        System.arraycopy(bytes_1, 0, bytes_0, 0, int_0);
        return bytes_0;
      }
      return bytes_1;
    }
    if (object_0 instanceof AbstractByteBuffer) {
      final AbstractByteBuffer abstractbytebuffer_0 = (AbstractByteBuffer) object_0;
      return abstractbytebuffer_0.get();
    }
    throw new IllegalArgumentException();
  }

  public static void method237() {
    if (LoginScreen.aBool15) {
      LoginScreen.anIndexedSprite3 = null;
      LoginScreen.anIndexedSprite4 = null;
      LoginScreen.anIndexedSpriteArray6 = null;
      CacheableNode_Sub6.aSpritePixels4 = null;
      Enum2.aSpritePixels3 = null;
      Class35.logoSprite = null;
      Game.titlemuteSprite = null;
      Boundry.anIndexedSprite1 = null;
      LongVariable.anIndexedSprite2 = null;
      WorldMapType2.aSpritePixelsArray2 = null;
      LoginScreen.anIndexedSpriteArray5 = null;
      Class16.anIndexedSpriteArray3 = null;
      CombatInfoListHolder.anIndexedSpriteArray8 = null;
      WorldMapData_Sub1.anIndexedSprite5 = null;
      WorldMapData.anIntArray24 = null;
      WorldMapType3.anIntArray68 = null;
      LoginScreen.anIntArray22 = null;
      PrimitiveType.anIntArray78 = null;
      LoginScreen.anIntArray21 = null;
      Class84.anIntArray44 = null;
      Ignore.anIntArray60 = null;
      LoginScreen.anIntArray23 = null;
      AudioSystem.anInt168 = 1;
      AudioSystem.anIndexDataBase4 = null;
      Enum3.anInt339 = -1;
      NestedException.anInt527 = -1;
      AudioSystem.anInt170 = 0;
      Class36.aBool8 = false;
      AudioSystem.anInt169 = 2;
      Class8.sendConInfo(true);
      LoginScreen.aBool15 = false;
    }
  }

  static void method238() {
    Class22.underlayIds = null;
    Class22.overlayIds = null;
    Class22.overlayPaths = null;
    Class22.overlayRotations = null;
    Enum8.anIntArrayArrayArray1 = null;
    Class22.aByteArrayArrayArray4 = null;
    WorldMapType2.anIntArrayArray14 = null;
    Class22.blendedHue = null;
    WorldMapType1.blendedSaturation = null;
    Class13.anIntArray2 = null;
    HuffmanCodec.anIntArray67 = null;
    JavaxSourceDataLineProvider.anIntArray3 = null;
  }

}
