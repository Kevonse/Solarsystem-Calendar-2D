package planets;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sun
{

	double meanDistance = 1.000000;// Measured in astronomical unit(au). Earth's
									// distance.
	double coordinateX = 0; // The coordinates are set to zero as the sun will
							// be in the center.
	double coordinateY = 0;
	double coordinateZ = 0;
	private JLabel sunPicture;

	public double getCoordinateX()
	{
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX)
	{
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY()
	{
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY)
	{
		this.coordinateY = coordinateY;
	}

	public double getCoordinateZ()
	{
		return coordinateZ;
	}

	public void setCoordinateZ(double coordinateZ)
	{
		this.coordinateZ = coordinateZ;
	}

	public JLabel getSunPicture()
	{
		return sunPicture;
	}

	/*
	 * The 2 methods below are almost identical to the ones in the class
	 * "Planet". It is copied here because the size of the picture is included
	 * in the method-body. Therefore I could not use the method from the
	 * "Planet"-class.
	 */
	public void setSunPicture(String picturePath) throws IOException
	{

		BufferedImage sunPicture = ImageIO.read(new File(picturePath));
		this.sunPicture = new JLabel(new ImageIcon(resizeImageSun(sunPicture,
				sunPicture.getType())));
	}

	private static BufferedImage resizeImageSun(BufferedImage originalImage,
			int type)
	{

		BufferedImage resizedImage = new BufferedImage(75, 75, type);
		Graphics2D g = resizedImage.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(originalImage, 0, 0, 75, 75, null);
		g.dispose();

		return resizedImage;
	}
}
