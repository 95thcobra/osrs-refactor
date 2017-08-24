package jagex.oldschool;

import jagex.oldschool.animation.AnimationSequence;
import jagex.oldschool.animation.FrameBase;
import jagex.oldschool.asset.Package;
import jagex.oldschool.audio.AbstractSourceLine;
import jagex.oldschool.awt.CanvasWrapper;
import jagex.oldschool.awt.Stub;
import jagex.oldschool.config.BitVariableConfig;
import jagex.oldschool.config.ClientScriptVariable;
import jagex.oldschool.config.ItemConfig;
import jagex.oldschool.config.NpcConfig;
import jagex.oldschool.config.ObjectConfig;
import jagex.oldschool.config.SpotAnimationConfig;
import jagex.oldschool.device.MachineProfile;
import jagex.oldschool.device.Mouse;
import jagex.oldschool.graphics.AbstractFont;
import jagex.oldschool.graphics.BitmapFont;
import jagex.oldschool.graphics.DirectSprite;
import jagex.oldschool.graphics.FontType;
import jagex.oldschool.graphics.Materials;
import jagex.oldschool.graphics.Rasterizer3d;
import jagex.oldschool.graphics.VertexNormal;
import jagex.oldschool.io.Buffer;
import jagex.oldschool.io.HuffmanCodec;
import jagex.oldschool.map.MapAsset;
import jagex.oldschool.map.MapIcon;
import jagex.oldschool.map.MapIconConfig;
import jagex.oldschool.scene.CollisionData;
import jagex.oldschool.scene.ItemLayer;
import jagex.oldschool.scene.Scene;
import jagex.oldschool.scene.SolidSquare;
import jagex.oldschool.scene.Square;
import jagex.oldschool.script.PrimitiveType;
import jagex.oldschool.script.ScriptExecutor;
import jagex.oldschool.script.ScriptState;
import jagex.oldschool.script.StringVariable;
import jagex.oldschool.util.BzipDecompressor.State;
import jagex.oldschool.util.Time;

public class Class41 {

  public static final Class41 aClass41_2;
  public static final Class41 aClass41_3;
  public static final Class41 aClass41_4;

  static {
    aClass41_2 = new Class41("SMALL", 2, 0, 4);
    aClass41_3 = new Class41("MEDIUM", 0, 1, 2);
    aClass41_4 = new Class41("LARGE", 1, 2, 0);
  }

  final int anInt92;
  final String aString7;
  final int anInt93;
  final int anInt94;

  Class41(final String string_0, final int int_0, final int int_1, final int int_2) {
    aString7 = string_0;
    anInt93 = int_0;
    anInt94 = int_1;
    anInt92 = int_2;
  }

  static Class41[] method276() {
    return new Class41[] {aClass41_2, aClass41_4, aClass41_3};
  }

  static Class41 method277(final int int_0) {
    final Class41[] class41s_0 = method276();

    for (int int_1 = 0; int_1 < class41s_0.length; int_1++) {
      final Class41 class41_0 = class41s_0[int_1];
      if (int_0 == class41_0.anInt94) {
        return class41_0;
      }
    }

    return null;
  }

  static void loadEngine() {
    int int_0;
    if (Client.loadingStage == 0) {
      Class11.scene = new Scene(4, 104, 104, Class22.heightmap);

      for (int_0 = 0; int_0 < 4; int_0++) {
        Client.collisionMaps[int_0] = new CollisionData(104, 104);
      }

      ItemConfig.map = new DirectSprite(512, 512);
      LoginScreen.loadingText = "Starting game engine...";
      LoginScreen.loadingPercent = 5;
      Client.loadingStage = 20;
    } else {
      int int_1;
      int int_2;
      int int_3;
      int int_4;
      if (Client.loadingStage == 20) {
        final int[] ints_0 = new int[9];

        for (int_1 = 0; int_1 < 9; int_1++) {
          int_2 = int_1 * 32 + 15 + 128;
          int_3 = int_2 * 3 + 600;
          int_4 = Rasterizer3d.SINE[int_2];
          ints_0[int_1] = int_4 * int_3 >> 16;
        }

        Scene.method391(ints_0, 500, 800, 512, 334);
        LoginScreen.loadingText = "Prepared visibility map";
        LoginScreen.loadingPercent = 10;
        Client.loadingStage = 30;
      } else if (Client.loadingStage == 30) {
        Class4.indexInterfaces = AClass4_Sub4.openCacheIndex(0, false, true, true);
        ScriptState.indexSoundEffects = AClass4_Sub4.openCacheIndex(1, false, true, true);
        AClass1.configsIndex = AClass4_Sub4.openCacheIndex(2, true, false, true);
        UrlStreamRequest.anIndexData1 = AClass4_Sub4.openCacheIndex(3, false, true, true);
        Client.anIndexData5 = AClass4_Sub4.openCacheIndex(4, false, true, true);
        Class44.maps = AClass4_Sub4.openCacheIndex(5, true, true, true);
        CacheableNode_Sub4.indexTrack1 = AClass4_Sub4.openCacheIndex(6, true, true, false);
        Boundry.indexModels = AClass4_Sub4.openCacheIndex(7, false, true, true);
        Time.indexSprites = AClass4_Sub4.openCacheIndex(8, false, true, true);
        Square.indexTextures = AClass4_Sub4.openCacheIndex(9, false, true, true);
        Mouse.anIndexData4 = AClass4_Sub4.openCacheIndex(10, false, true, true);
        State.indexTrack2 = AClass4_Sub4.openCacheIndex(11, false, true, true);
        FrameBase.indexScripts = AClass4_Sub4.openCacheIndex(12, false, true, true);
        FontType.anIndexData3 = AClass4_Sub4.openCacheIndex(13, true, false, true);
        Enum.vorbisIndex = AClass4_Sub4.openCacheIndex(14, false, true, false);
        Variables.anIndexData2 = AClass4_Sub4.openCacheIndex(15, false, true, true);
        VertexNormal.indexWorldMap = AClass4_Sub4.openCacheIndex(16, false, true, false);
        LoginScreen.loadingText = "Connecting to update server";
        LoginScreen.loadingPercent = 20;
        Client.loadingStage = 40;
      } else if (Client.loadingStage == 40) {
        final byte byte_0 = 0;
        int_0 = byte_0 + Class4.indexInterfaces.getLoadedPercent() * 4 / 100;
        int_0 += ScriptState.indexSoundEffects.getLoadedPercent() * 4 / 100;
        int_0 += AClass1.configsIndex.getLoadedPercent() * 2 / 100;
        int_0 += UrlStreamRequest.anIndexData1.getLoadedPercent() * 2 / 100;
        int_0 += Client.anIndexData5.getLoadedPercent() * 6 / 100;
        int_0 += Class44.maps.getLoadedPercent() * 4 / 100;
        int_0 += CacheableNode_Sub4.indexTrack1.getLoadedPercent() * 2 / 100;
        int_0 += Boundry.indexModels.getLoadedPercent() * 58 / 100;
        int_0 += Time.indexSprites.getLoadedPercent() * 2 / 100;
        int_0 += Square.indexTextures.getLoadedPercent() * 2 / 100;
        int_0 += Mouse.anIndexData4.getLoadedPercent() * 2 / 100;
        int_0 += State.indexTrack2.getLoadedPercent() * 2 / 100;
        int_0 += FrameBase.indexScripts.getLoadedPercent() * 2 / 100;
        int_0 += FontType.anIndexData3.getLoadedPercent() * 2 / 100;
        int_0 += Enum.vorbisIndex.getLoadedPercent() * 2 / 100;
        int_0 += Variables.anIndexData2.getLoadedPercent() * 2 / 100;
        int_0 += VertexNormal.indexWorldMap.getLoadedPercent() * 2 / 100;
        if (int_0 != 100) {
          if (int_0 != 0) {
            LoginScreen.loadingText = "Checking for updates - " + int_0 + "%";
          }

          LoginScreen.loadingPercent = 30;
        } else {
          LoginScreen.loadingText = "Loaded update list";
          LoginScreen.loadingPercent = 30;
          Client.loadingStage = 45;
        }
      } else if (Client.loadingStage == 45) {
        Class7.method143(22050, !Client.lowMemory, 2);
        final AClass4_Sub3 aclass4_sub3_0 = new AClass4_Sub3();
        aclass4_sub3_0.method816(9, 128);
        ScriptExecutor.soundSystem0 = JavaxSourceDataLineProvider
            .method191(Stub.taskManager, 0, 22050);
        ScriptExecutor.soundSystem0.method362(aclass4_sub3_0);
        UrlStreamRequest
            .method261(Variables.anIndexData2, Enum.vorbisIndex, Client.anIndexData5, aclass4_sub3_0);
        WorldMapType1.soundSystem1 = JavaxSourceDataLineProvider.method191(Stub.taskManager, 1, 2048);
        Class25.anAClass4_Sub1_1 = new AClass4_Sub1();
        WorldMapType1.soundSystem1.method362(Class25.anAClass4_Sub1_1);
        Class40.aClass54_1 = new Class54(22050, AbstractSourceLine.sampleRate);
        LoginScreen.loadingText = "Prepared sound engine";
        LoginScreen.loadingPercent = 35;
        Client.loadingStage = 50;
        SolidSquare.aClass93_1 = new Class93(Time.indexSprites, FontType.anIndexData3);
      } else if (Client.loadingStage == 50) {
        final FontType[] class105s_0 = new FontType[] {
            FontType.aClass105_5, FontType.aClass105_4,
            FontType.aClass105_7, FontType.aClass105_9, FontType.aClass105_6, FontType.aClass105_8
        };
        int_1 = class105s_0.length;
        final Class93 class93_0 = SolidSquare.aClass93_1;
        final FontType[] class105s_1 = new FontType[] {
            FontType.aClass105_5, FontType.aClass105_4,
            FontType.aClass105_7, FontType.aClass105_9, FontType.aClass105_6, FontType.aClass105_8
        };
        Client.aHashMap9 = class93_0.method513(class105s_1);
        if (Client.aHashMap9.size() < int_1) {
          LoginScreen.loadingText =
              "Loading fonts - " + Client.aHashMap9.size() * 100 / int_1 + "%";
          LoginScreen.loadingPercent = 40;
        } else {
          VertexNormal.aFont5 = (BitmapFont) Client.aHashMap9.get(FontType.aClass105_5);
          Class12.font_p12full = (BitmapFont) Client.aHashMap9.get(FontType.aClass105_8);
          Class22.aFont3 = (BitmapFont) Client.aHashMap9.get(FontType.aClass105_9);
          ChatLineBuffer.aMachineInfo1 = new MachineProfile(true);
          LoginScreen.loadingText = "Loaded fonts";
          LoginScreen.loadingPercent = 40;
          Client.loadingStage = 60;
        }
      } else if (Client.loadingStage == 60) {
        int_0 = StringVariable.method248(Mouse.anIndexData4, Time.indexSprites);
        int_1 = Chunk.method595();
        if (int_0 < int_1) {
          LoginScreen.loadingText = "Loading title screen - " + int_0 * 100 / int_1 + "%";
          LoginScreen.loadingPercent = 50;
        } else {
          LoginScreen.loadingText = "Loaded title screen";
          LoginScreen.loadingPercent = 50;
          Mouse.setGameState(5);
          Client.loadingStage = 70;
        }
      } else if (Client.loadingStage == 70) {
        if (!AClass1.configsIndex.method458()) {
          LoginScreen.loadingText = "Loading config - " + AClass1.configsIndex.method607() + "%";
          LoginScreen.loadingPercent = 60;
        } else {
          final Package indexdata_17 = AClass1.configsIndex;
          Class90.overlay_ref = indexdata_17;
          Class1.method116(AClass1.configsIndex);
          final Package indexdata_2 = AClass1.configsIndex;
          final Package indexdata_0 = Boundry.indexModels;
          IdentityConfig.identKit_ref = indexdata_2;
          IdentityConfig.anIndexDataBase16 = indexdata_0;
          IdentityConfig.anInt429 = IdentityConfig.identKit_ref.fileCount(3);
          final Package indexdata_1 = AClass1.configsIndex;
          final Package indexdata_3 = Boundry.indexModels;
          final boolean bool_0 = Client.lowMemory;
          ObjectConfig.objects_ref = indexdata_1;
          ObjectConfig.anIndexDataBase21 = indexdata_3;
          ObjectConfig.aBool54 = bool_0;
          final Package indexdata_4 = AClass1.configsIndex;
          final Package indexdata_5 = Boundry.indexModels;
          LocalInstall.anIndexDataBase3 = indexdata_4;
          NpcConfig.anIndexDataBase29 = indexdata_5;
          Class10.method159(AClass1.configsIndex);
          CacheableNode_Sub5.method858(AClass1.configsIndex, Boundry.indexModels, Client.isMembers,
              VertexNormal.aFont5);
          final Package indexdata_6 = AClass1.configsIndex;
          final Package indexdata_7 = Class4.indexInterfaces;
          final Package indexdata_8 = ScriptState.indexSoundEffects;
          AnimationSequence.config = indexdata_6;
          Class47.skel_ref = indexdata_7;
          AnimationSequence.skin_ref = indexdata_8;
          final Package indexdata_9 = AClass1.configsIndex;
          final Package indexdata_10 = Boundry.indexModels;
          SpotAnimationConfig.anIndexDataBase15 = indexdata_9;
          SpotAnimationConfig.anIndexDataBase14 = indexdata_10;
          final Package indexdata_11 = AClass1.configsIndex;
          BitVariableConfig.configPackage = indexdata_11;
          Class44.method284(AClass1.configsIndex);
          ItemLayer.method529(UrlStreamRequest.anIndexData1, Boundry.indexModels, Time.indexSprites,
              FontType.anIndexData3);
          AClass1.method150(AClass1.configsIndex);
          Enum3.method654(AClass1.configsIndex);
          Class46.method291(AClass1.configsIndex);
          Enum1.method602(AClass1.configsIndex);
          final Package indexdata_12 = AClass1.configsIndex;
          CacheableNode_Sub3.anIndexDataBase26 = indexdata_12;
          LocalInstall.chatMessages = new ClientScriptVariable();
          Time.method395(AClass1.configsIndex, Time.indexSprites, FontType.anIndexData3);
          final Package indexdata_13 = AClass1.configsIndex;
          final Package indexdata_14 = Time.indexSprites;
          CombatInfo2.anIndexDataBase19 = indexdata_13;
          CombatInfo2.anIndexDataBase20 = indexdata_14;
          final Package indexdata_15 = AClass1.configsIndex;
          final Package indexdata_16 = Time.indexSprites;
          MapIconConfig.anIndexDataBase18 = indexdata_16;
          if (indexdata_15.method458()) {
            MapIconConfig.anInt431 = indexdata_15.fileCount(35);
            MapIconConfig.icons = new MapIconConfig[MapIconConfig.anInt431];

            for (int int_5 = 0; int_5 < MapIconConfig.anInt431; int_5++) {
              final byte[] bytes_0 = indexdata_15.get(35, int_5);
              if (bytes_0 != null) {
                MapIconConfig.icons[int_5] = new MapIconConfig(int_5);
                MapIconConfig.icons[int_5].method778(new Buffer(bytes_0));
                MapIconConfig.icons[int_5].method779();
              }
            }
          }

          LoginScreen.loadingText = "Loaded config";
          LoginScreen.loadingPercent = 60;
          Client.loadingStage = 80;
        }
      } else if (Client.loadingStage == 80) {
        int_0 = 0;
        if (CanvasWrapper.compass == null) {
          CanvasWrapper.compass = Package.method609(Time.indexSprites, "compass", "");
        } else {
          ++int_0;
        }

        if (Class57.mapedge == null) {
          Class57.mapedge = Package.method609(Time.indexSprites, "mapedge", "");
        } else {
          ++int_0;
        }

        if (Client.anIndexedSpriteArray9 == null) {
          Client.anIndexedSpriteArray9 = MapIcon.method239(Time.indexSprites, "mapscene", "");
        } else {
          ++int_0;
        }

        if (CanvasWrapper.mapfunctions == null) {
          CanvasWrapper.mapfunctions = Class17.method202(Time.indexSprites, "headicons_pk", "");
        } else {
          ++int_0;
        }

        if (Enum1.hitmarks == null) {
          Enum1.hitmarks = Class17.method202(Time.indexSprites, "headicons_prayer", "");
        } else {
          ++int_0;
        }

        if (Class45.pkIcons == null) {
          Class45.pkIcons = Class17.method202(Time.indexSprites, "headicons_hint", "");
        } else {
          ++int_0;
        }

        if (AClass3.aSpritePixelsArray3 == null) {
          AClass3.aSpritePixelsArray3 = Class17.method202(Time.indexSprites, "mapmarker", "");
        } else {
          ++int_0;
        }

        if (Client.crosses == null) {
          Client.crosses = Class17.method202(Time.indexSprites, "cross", "");
        } else {
          ++int_0;
        }

        if (Class20.mapDots == null) {
          Class20.mapDots = Class17.method202(Time.indexSprites, "mapdots", "");
        } else {
          ++int_0;
        }

        if (Class20.anIndexedSpriteArray4 == null) {
          Class20.anIndexedSpriteArray4 = MapIcon.method239(Time.indexSprites, "scrollbar", "");
        } else {
          ++int_0;
        }

        if (PrimitiveType.anIndexedSpriteArray7 == null) {
          PrimitiveType.anIndexedSpriteArray7 = MapIcon
              .method239(Time.indexSprites, "mod_icons", "");
        } else {
          ++int_0;
        }

        if (int_0 < 11) {
          LoginScreen.loadingText = "Loading sprites - " + int_0 * 100 / 12 + "%";
          LoginScreen.loadingPercent = 70;
        } else {
          AbstractFont.modIcons = PrimitiveType.anIndexedSpriteArray7;
          Class57.mapedge.method949();
          int_1 = (int) (Math.random() * 21.0D) - 10;
          int_2 = (int) (Math.random() * 21.0D) - 10;
          int_3 = (int) (Math.random() * 21.0D) - 10;
          int_4 = (int) (Math.random() * 41.0D) - 20;
          Client.anIndexedSpriteArray9[0].add(int_4 + int_1, int_4 + int_2, int_4 + int_3);
          LoginScreen.loadingText = "Loaded sprites";
          LoginScreen.loadingPercent = 70;
          Client.loadingStage = 90;
        }
      } else if (Client.loadingStage == 90) {
        if (!Square.indexTextures.method458()) {
          LoginScreen.loadingText = "Loading textures - " + Square.indexTextures.method607() + "%";
          LoginScreen.loadingPercent = 90;
        } else {
          final Materials textureprovider_0 = new Materials(Square.indexTextures,
              Time.indexSprites, 20, 0.8D, Client.lowMemory ? 64 : 128);
          Rasterizer3d.setMaterials(textureprovider_0);
          Rasterizer3d.setBrightness(0.8D);
          LoginScreen.loadingText = "Loaded textures";
          LoginScreen.loadingPercent = 90;
          Client.loadingStage = 110;
        }
      } else if (Client.loadingStage == 110) {
        ScriptExecutor.aClass19_1 = new Class19();
        Stub.taskManager.createRunnable(ScriptExecutor.aClass19_1, 10);
        LoginScreen.loadingText = "Loaded input handler";
        LoginScreen.loadingPercent = 94;
        Client.loadingStage = 120;
      } else if (Client.loadingStage == 120) {
        if (!Mouse.anIndexData4.method451("huffman", "")) {
          LoginScreen.loadingText = "Loading wordpack - " + 0 + "%";
          LoginScreen.loadingPercent = 96;
        } else {
          final HuffmanCodec huffman_0 = new HuffmanCodec(Mouse.anIndexData4.method457("huffman", ""));
          SolidSquare.method345(huffman_0);
          LoginScreen.loadingText = "Loaded wordpack";
          LoginScreen.loadingPercent = 96;
          Client.loadingStage = 130;
        }
      } else if (Client.loadingStage == 130) {
        if (!UrlStreamRequest.anIndexData1.method458()) {
          LoginScreen.loadingText =
              "Loading interfaces - " + UrlStreamRequest.anIndexData1.method607() * 4 / 5 + "%";
          LoginScreen.loadingPercent = 100;
        } else if (!FrameBase.indexScripts.method458()) {
          LoginScreen.loadingText =
              "Loading interfaces - " + (80 + FrameBase.indexScripts.method607() / 6)
                  + "%";
          LoginScreen.loadingPercent = 100;
        } else if (!FontType.anIndexData3.method458()) {
          LoginScreen.loadingText =
              "Loading interfaces - " + (96 + FontType.anIndexData3.method607() / 50)
                  + "%";
          LoginScreen.loadingPercent = 100;
        } else {
          LoginScreen.loadingText = "Loaded interfaces";
          LoginScreen.loadingPercent = 98;
          Client.loadingStage = 140;
        }
      } else if (Client.loadingStage == 140) {
        if (!VertexNormal.indexWorldMap.method459(MapAsset.aClass6_1.aString2)) {
          LoginScreen.loadingText = "Loading world map - "
              + VertexNormal.indexWorldMap.method456(MapAsset.aClass6_1.aString2) / 10 + "%";
        } else {
          if (Class14.renderOverview == null) {
            Class14.renderOverview = new RenderOverview();
            Class14.renderOverview
                .method31(VertexNormal.indexWorldMap, Class22.aFont3, Client.aHashMap9,
                    Client.anIndexedSpriteArray9);
          }

          int_0 = Class14.renderOverview.method30();
          if (int_0 < 100) {
            LoginScreen.loadingText = "Loading world map - " + (int_0 * 9 / 10 + 10) + "%";
          } else {
            LoginScreen.loadingText = "Loaded world map";
            LoginScreen.loadingPercent = 100;
            Client.loadingStage = 150;
          }
        }
      } else if (Client.loadingStage == 150) {
        Mouse.setGameState(10);
      }
    }
  }

  boolean method275(final float float_0) {
    return float_0 >= anInt92;
  }

}
