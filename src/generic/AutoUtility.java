package generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

public class AutoUtility {

	
	public static void getScreenshot(String path)
	{
		try
		{
			Robot r=new Robot();
			Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
	
		Rectangle rect=new Rectangle(tool);
		BufferedImage image = r.createScreenCapture(rect);
		ImageIO.write(image, "png", new File(path));
		}
		catch(Exception e)
		{
			
		}
	}
	public static String time()
	{
		SimpleDateFormat sm=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String time1=sm.format(new Date());
		return time1;
	}
	
	
	public static String getProprty(String path, String key)
	{
		String value=" ";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
	
}
