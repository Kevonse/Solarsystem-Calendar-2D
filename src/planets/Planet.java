package planets;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Planet
{

	private String name;
	private double volume;
	private double mass;
	private Orbit orbit;
	private double obliquity; // Degrees the equator differs from ecliptic.
	private double timeAtPerihelion;
	private double eclipLongitude;
	private double eclipLatitude;
	private JLabel picture;
	private int coordinateXEcliptic;
	private int coordinateYEcliptic;

	public Planet(String name, double volume, double mass, Orbit orbit,
			double obliquity, double timeAtPerihelion)
	{

		this.name = name;
		this.volume = volume;
		this.mass = mass;
		this.orbit = orbit;
		this.setObliquity(obliquity);
		this.setTimeAtPerihelion(timeAtPerihelion);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getVolume()
	{
		return volume;
	}

	public void setVolume(double volume)
	{
		this.volume = volume;
	}

	public double getMass()
	{
		return mass;
	}

	public void setMass(double mass)
	{
		this.mass = mass;
	}

	public Orbit getOrbit()
	{
		return orbit;
	}

	public void setOrbit(Orbit orbit)
	{
		this.orbit = orbit;
	}

	public double getObliquity()
	{
		return obliquity;
	}

	public void setObliquity(double obliquity)
	{
		this.obliquity = obliquity;
	}

	public double getTimeAtPerihelion()
	{
		return timeAtPerihelion;
	}

	public void setTimeAtPerihelion(double timeAtPerihelion)
	{
		this.timeAtPerihelion = timeAtPerihelion;
	}

	public double getEclipLongitude()
	{
		return eclipLongitude;
	}

	public void setEclipLongitude(double eclipLongitude)
	{
		this.eclipLongitude = eclipLongitude;
	}

	public double getEclipLatitude()
	{
		return eclipLatitude;
	}

	public void setEclipLatitude(double eclipLatitude)
	{
		this.eclipLatitude = eclipLatitude;
	}

	public JLabel getPicture()
	{
		return picture;
	}

	public int getCoordinateXEcliptic()
	{
		return coordinateXEcliptic;
	}

	public void setCoordinateXEcliptic(int coordinateXEcliptic)
	{
		this.coordinateXEcliptic = coordinateXEcliptic;
	}

	public int getCoordinateYEcliptic()
	{
		return coordinateYEcliptic;
	}

	public void setCoordinateYEcliptic(int coordinateYEcliptic)
	{
		this.coordinateYEcliptic = coordinateYEcliptic;
	}

	/*
	 * Method to set the picture of the Jlabel associated with a given planet.
	 */
	public void setPicture(String picturePath) throws Exception
	{
		BufferedImage picture = ImageIO.read(new File(picturePath));
		// resizeImage(picture, picture.getType());
		this.picture = new JLabel(new ImageIcon(resizeImage(picture,
				picture.getType())));
	}

	/*
	 * This method resizes a given image. In this program this function is used
	 * to resize pictures of planets which are typically too large to show
	 * together in an already small window frame. This method was found on the
	 * internet and I believe it was copied from a guy called MKyong who runs a
	 * blog about Java.
	 */
	private static BufferedImage resizeImage(BufferedImage originalImage,
			int type)
	{
		BufferedImage resizedImage = new BufferedImage(25, 25, type);
		Graphics2D g = resizedImage.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(originalImage, 0, 0, 25, 25, null);
		g.dispose();

		return resizedImage;
	}
}
