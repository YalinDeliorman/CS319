

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReader {
	public static BufferedImage readPNGImage(String filePath){
		try {
			BufferedImage img = ImageIO.read(new File(filePath));
//			return img;
			Image transpImg2 = TransformColorToTransparency(img, new Color(254, 254, 254), new Color(255, 255, 255));
		    BufferedImage resultImage2 = ImageToBufferedImage(transpImg2, img.getWidth(), img.getHeight());
		    return resultImage2;
		}catch(NullPointerException ne){
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Image TransformColorToTransparency(BufferedImage image, Color c1, Color c2)
	  {
	    // Primitive test, just an example
	    final int r1 = c1.getRed();
	    final int g1 = c1.getGreen();
	    final int b1 = c1.getBlue();
	    final int r2 = c2.getRed();
	    final int g2 = c2.getGreen();
	    final int b2 = c2.getBlue();
	    ImageFilter filter = new RGBImageFilter()
	    {
	      public final int filterRGB(int x, int y, int rgb)
	      {
	        int r = (rgb & 0xFF0000) >> 16;
	        int g = (rgb & 0xFF00) >> 8;
	        int b = rgb & 0xFF;
	        if (r >= r1 && r <= r2 &&
	            g >= g1 && g <= g2 &&
	            b >= b1 && b <= b2)
	        {
	          // Set fully transparent but keep color
	          return rgb & 0xFFFFFF;
	        }
	        return rgb;
	      }
	    };

	    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
	      return Toolkit.getDefaultToolkit().createImage(ip);
	  }
	
	private static BufferedImage ImageToBufferedImage(Image image, int width, int height)
	  {
	    BufferedImage dest = new BufferedImage(
	        width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = dest.createGraphics();
	    g2.drawImage(image, 0, 0, null);
	    g2.dispose();
	    return dest;
	  }
}
