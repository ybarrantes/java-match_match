package graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;

public class TransformImage {

	public static BufferedImage scale(BufferedImage img, Dimension size) {
		BufferedImage cloneImg = clone(img);
		Image tmp = cloneImg.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
		BufferedImage imgScale = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = imgScale.createGraphics();
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    
		g2d.drawImage(tmp, 0, 0 , null);
		g2d.dispose();
		
		tmp = null;
		
		return imgScale;
	}
	
	public static BufferedImage clone(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static BufferedImage contrast(BufferedImage img, float scaleFactor, float offset) {
		BufferedImage cloneImg = clone(img);
		RescaleOp rop = new RescaleOp(scaleFactor, offset, new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		rop.filter(cloneImg, cloneImg);
		rop = null;
		return cloneImg;
	}

}
