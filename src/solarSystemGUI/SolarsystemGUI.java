package solarSystemGUI;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.joda.time.DateTime;

import com.toedter.calendar.JDateChooser;

import planets.Formulae;
import planets.GivenValues;
import planets.Planet;
import planets.Sun;

public class SolarsystemGUI extends JFrame
{
	private static final long serialVersionUID = -468352522911305338L;
	private JPanel contentPane;
	private JLabel lblGotmercury;
	private JLabel lblGotvenus;
	private JLabel lblGotearth;
	private JLabel lblGotmars;
	private JLabel lblGotjupiter;
	private JLabel lblGotsaturn;
	private JLabel lblGoturanus;
	private JLabel lblGotneptune;

	/**
	 * Create the frame.
	 */
	public SolarsystemGUI(Sun sun, final Planet p1, final Planet p2,
						  		   final Planet p3, final Planet p4,
						  		   final Planet p5, final Planet p6,
						  		   final Planet p7, final Planet p8)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setTitle("Solarsystem 2D");
		setLocationRelativeTo(null);
		int xAxis = GivenValues.xAxis;
		int yAxis = GivenValues.yAxis;
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(null);
		setSize(xAxis, yAxis);

		/*
		 * Every planet needs a factor to be multiplied with coordinates in
		 * order for them to be be shown properly. At the same time if a common
		 * factor is used the only the four innermost planets are shown. The
		 * distance between the planets/Especially the outer ones) are so great
		 * that even when scaling one must scale differently per planet.
		 */

		JLabel lblGotsun = new JLabel("gotSun");
		lblGotsun = sun.getSunPicture();
		lblGotsun.setBounds(100, 100, (xAxis / 2), (yAxis / 2));
		contentPane.add(lblGotsun);

		lblGotmercury = new JLabel("gotMercury");
		lblGotmercury = p1.getPicture();
		lblGotmercury.setBounds(100, 100, (int) p1.getCoordinateXEcliptic(),
				(int) p1.getCoordinateYEcliptic());
		contentPane.add(lblGotmercury);

		lblGotvenus = new JLabel("gotVenus");
		lblGotvenus = p2.getPicture();
		lblGotvenus.setBounds(100, 100, p2.getCoordinateXEcliptic(),
				p2.getCoordinateYEcliptic());
		contentPane.add(lblGotvenus);

		lblGotearth = new JLabel("gotEarth");
		lblGotearth = p3.getPicture();
		lblGotearth.setBounds(100, 100, p3.getCoordinateXEcliptic(),
				p3.getCoordinateYEcliptic());
		contentPane.add(lblGotearth);

		lblGotmars = new JLabel("gotMars");
		lblGotmars = p4.getPicture();
		lblGotmars.setBounds(100, 100, p4.getCoordinateXEcliptic(),
				p4.getCoordinateYEcliptic());
		contentPane.add(lblGotmars);

		lblGotjupiter = new JLabel("gotJupiter");
		lblGotjupiter = p5.getPicture();
		lblGotjupiter.setBounds(100, 100, p5.getCoordinateXEcliptic(),
				p5.getCoordinateYEcliptic());
		contentPane.add(lblGotjupiter);

		lblGotsaturn = new JLabel("gotSaturn");
		lblGotsaturn = p6.getPicture();
		lblGotsaturn.setBounds(100, 100, p6.getCoordinateXEcliptic(),
				p6.getCoordinateYEcliptic());
		contentPane.add(lblGotsaturn);

		lblGoturanus = new JLabel("gotUranus");
		lblGoturanus = p7.getPicture();
		lblGoturanus.setBounds(100, 100, p7.getCoordinateXEcliptic(),
				p7.getCoordinateYEcliptic());
		contentPane.add(lblGoturanus);

		lblGotneptune = new JLabel("gotNeptune");
		lblGotneptune = p8.getPicture();
		lblGotneptune.setBounds(100, 100, p8.getCoordinateXEcliptic(),
				p8.getCoordinateYEcliptic());
		contentPane.add(lblGotneptune);

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent evt)
			{
				DateTime newDate = new DateTime(dateChooser.getDate());
				GivenValues.setdTest(newDate);

				p1.getOrbit().setSemiMajorAxis(GivenValues.getMercuryA());
				p1.getOrbit().setEccentricity(GivenValues.getMercuryE());
				p1.getOrbit().setInclination(GivenValues.getMercuryI());
				p1.getOrbit().setN(GivenValues.getMercuryN());
				p1.getOrbit().setW(GivenValues.getMercuryW());
				p1.getOrbit().setM(GivenValues.getMercuryM());

				p2.getOrbit().setSemiMajorAxis(GivenValues.getVenusA());
				p2.getOrbit().setEccentricity(GivenValues.getVenusE());
				p2.getOrbit().setInclination(GivenValues.getVenusI());
				p2.getOrbit().setN(GivenValues.getVenusN());
				p2.getOrbit().setW(GivenValues.getVenusW());
				p2.getOrbit().setM(GivenValues.getVenusM());

				p3.getOrbit().setSemiMajorAxis(GivenValues.getEarthA());
				p3.getOrbit().setEccentricity(GivenValues.getEarthE());
				p3.getOrbit().setInclination(GivenValues.getEarthI());
				p3.getOrbit().setN(GivenValues.getEarthN());
				p3.getOrbit().setW(GivenValues.getEarthW());
				p3.getOrbit().setM(GivenValues.getEarthM());

				p4.getOrbit().setSemiMajorAxis(GivenValues.getMarsA());
				p4.getOrbit().setEccentricity(GivenValues.getMarsE());
				p4.getOrbit().setInclination(GivenValues.getMarsI());
				p4.getOrbit().setN(GivenValues.getMarsN());
				p4.getOrbit().setW(GivenValues.getMarsW());
				p4.getOrbit().setM(GivenValues.getMarsM());

				p5.getOrbit().setSemiMajorAxis(GivenValues.getJupiterA());
				p5.getOrbit().setEccentricity(GivenValues.getJupiterE());
				p5.getOrbit().setInclination(GivenValues.getJupiterI());
				p5.getOrbit().setN(GivenValues.getJupiterN());
				p5.getOrbit().setW(GivenValues.getJupiterW());
				p5.getOrbit().setM(GivenValues.getJupiterM());

				p6.getOrbit().setSemiMajorAxis(GivenValues.getSaturnA());
				p6.getOrbit().setEccentricity(GivenValues.getSaturnE());
				p6.getOrbit().setInclination(GivenValues.getSaturnI());
				p6.getOrbit().setN(GivenValues.getSaturnN());
				p6.getOrbit().setW(GivenValues.getSaturnW());
				p6.getOrbit().setM(GivenValues.getSaturnM());

				p7.getOrbit().setSemiMajorAxis(GivenValues.getUranusA());
				p7.getOrbit().setEccentricity(GivenValues.getUranusE());
				p7.getOrbit().setInclination(GivenValues.getUranusI());
				p7.getOrbit().setN(GivenValues.getUranusN());
				p7.getOrbit().setW(GivenValues.getUranusW());
				p7.getOrbit().setM(GivenValues.getUranusM());

				p8.getOrbit().setSemiMajorAxis(GivenValues.getNeptuneA());
				p8.getOrbit().setEccentricity(GivenValues.getNeptuneE());
				p8.getOrbit().setInclination(GivenValues.getNeptuneI());
				p8.getOrbit().setN(GivenValues.getNeptuneN());
				p8.getOrbit().setW(GivenValues.getNeptuneW());
				p8.getOrbit().setM(GivenValues.getNeptuneM());

				p1.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorMercury
								* Formulae.getHelioEclipticCoordinateX(
										GivenValues.dTest, p1) + (GivenValues.xAxis / 2))));
				p1.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorMercury
								* Formulae.getHelioEclipticCoordinateY(
										GivenValues.dTest, p1) + (GivenValues.yAxis / 2))));

				p2.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorVenus
								* Formulae.getHelioEclipticCoordinateX(
										GivenValues.dTest, p2) + (GivenValues.xAxis / 2))));
				p2.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorVenus
								* Formulae.getHelioEclipticCoordinateY(
										GivenValues.dTest, p2) + (GivenValues.yAxis / 2))));

				p3.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorEarth
								* Formulae.getHelioEclipticCoordinateX(
										GivenValues.dTest, p3) + (GivenValues.xAxis / 2))));
				p3.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorEarth
								* Formulae.getHelioEclipticCoordinateY(
										GivenValues.dTest, p3) + (GivenValues.yAxis / 2))));

				p4.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorMars
								* Formulae.getHelioEclipticCoordinateX(
										GivenValues.dTest, p4) + (GivenValues.xAxis / 2))));
				p4.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorMars
								* Formulae.getHelioEclipticCoordinateY(
										GivenValues.dTest, p4) + (GivenValues.yAxis / 2))));

				p5.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorJupiter
								* Formulae.getNewJupiterCoordinateX(
										GivenValues.dTest, p5) + (GivenValues.xAxis / 2))));
				p5.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorJupiter
								* Formulae.getNewJupiterCoordinateY(
										GivenValues.dTest, p5) + (GivenValues.yAxis / 2))));

				p6.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorSaturn
								* Formulae.getNewSaturnCoordinateX(
										GivenValues.dTest, p6) + (GivenValues.xAxis / 2))));
				p6.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorSaturn
								* Formulae.getNewSaturnCoordinateY(
										GivenValues.dTest, p6) + (GivenValues.yAxis / 2))));

				p7.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorUranus
								* Formulae.getNewUranusCoordinateX(
										GivenValues.dTest, p7) + (GivenValues.xAxis / 2))));
				p7.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorUranus
								* Formulae.getNewUranusCoordinateY(
										GivenValues.dTest, p7) + (GivenValues.yAxis / 2))));

				p8.setCoordinateXEcliptic((int) Math
						.round((GivenValues.factorNeptune
								* Formulae.getHelioEclipticCoordinateX(
										GivenValues.dTest, p8) + (GivenValues.xAxis / 2))));
				p8.setCoordinateYEcliptic((int) Math
						.round((GivenValues.factorNeptune
								* Formulae.getHelioEclipticCoordinateY(
										GivenValues.dTest, p8) + (GivenValues.yAxis / 2))));

				lblGotmercury.setBounds(100, 100, p1.getCoordinateXEcliptic(),
						p1.getCoordinateYEcliptic());
				lblGotvenus.setBounds(100, 100, p2.getCoordinateXEcliptic(),
						p2.getCoordinateYEcliptic());
				lblGotearth.setBounds(100, 100, p3.getCoordinateXEcliptic(),
						p3.getCoordinateYEcliptic());
				lblGotmars.setBounds(100, 100, p4.getCoordinateXEcliptic(),
						p4.getCoordinateYEcliptic());
				lblGotjupiter.setBounds(100, 100, p5.getCoordinateXEcliptic(),
						p5.getCoordinateYEcliptic());
				lblGotsaturn.setBounds(100, 100, p6.getCoordinateXEcliptic(),
						p6.getCoordinateYEcliptic());
				lblGoturanus.setBounds(100, 100, p7.getCoordinateXEcliptic(),
						p7.getCoordinateYEcliptic());
				lblGotneptune.setBounds(100, 100, p8.getCoordinateXEcliptic(),
						p8.getCoordinateYEcliptic());
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		dateChooser.setBounds(159, 0, 125, 19);
		contentPane.add(dateChooser);
	}
}
