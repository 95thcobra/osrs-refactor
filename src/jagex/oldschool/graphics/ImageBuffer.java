package jagex.oldschool.graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public final class ImageBuffer extends AbstractRasterBuffer {

  Image image;
  Component component;

  public ImageBuffer(final int int_0, final int int_1, final Component component_0) {
    super.width = int_0;
    super.height = int_1;
    super.buffer = new int[int_1 * int_0 + 1];
    final DataBufferInt databufferint_0 = new DataBufferInt(super.buffer, super.buffer.length);
    final DirectColorModel directcolormodel_0 = new DirectColorModel(32, 16711680, 65280, 255);
    final WritableRaster writableraster_0 = Raster.createWritableRaster(
        directcolormodel_0.createCompatibleSampleModel(super.width, super.height), databufferint_0,
        null);
    image = new BufferedImage(directcolormodel_0, writableraster_0, false, new Hashtable());
    method612(component_0);
    init();
  }

  final void draw(final Graphics graphics_0, final int lx, final int ly, final int ux,
      final int uy) {
    try {
      final Shape shape_0 = graphics_0.getClip();
      graphics_0.clipRect(lx, ly, ux, uy);
      graphics_0.drawImage(image, 0, 0, component);
      graphics_0.setClip(shape_0);
    } catch (final Exception exception_0) {
      component.repaint();
    }
  }

  final void draw(final Graphics graphics_0, final int int_0, final int int_1) {
    try {
      graphics_0.drawImage(image, int_0, int_1, component);
    } catch (final Exception exception_0) {
      component.repaint();
    }
  }

  public final void method612(final Component component_0) {
    component = component_0;
  }

  @Override
  public final void draw(final int x, final int y) {
    draw(component.getGraphics(), x, y);
  }

  @Override
  public final void method497(final int int_0, final int int_1, final int int_2, final int int_3) {
    draw(component.getGraphics(), int_0, int_1, int_2, int_3);
  }

}
