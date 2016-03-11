package planets;

import javax.swing.SwingUtilities;

import solarSystemGUI.SolarsystemGUI;

public class Run
{

	public static void main(String[] args) throws Exception
	{
		final Sun sun = new Sun();
		sun.setSunPicture("Sun.png");

		Orbit orbitMercury = new Orbit(GivenValues.getMercuryA(), // semiMajorAxis
				GivenValues.getMercuryE(), // Eccentricity
				GivenValues.getMercuryI(), // Inclination
				GivenValues.getMercuryN(), // Longitude of Ascending Node
				GivenValues.getMercuryW(), // The angle from the Ascending Node
											// to the perihelion, along the
											// orbit
				GivenValues.getMercuryM());// Mean anomaly
		final Planet mercury = new Planet("Mercury", 6.083 * Math.pow(10, 11),
				0.33 * Math.pow(10, 24), orbitMercury, 0.0, 2450007);
		mercury.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, mercury));
		mercury.setEclipLatitude(Formulae.getEclipticLatitude(
				GivenValues.dTest, mercury));
		mercury.setPicture("Mercury.png");
		mercury.setCoordinateXEcliptic((int) Math
				.round(GivenValues.factorMercury
						* Formulae.getHelioEclipticCoordinateX(
								GivenValues.dTest, mercury)
						+ (GivenValues.xAxis / 2)));
		mercury.setCoordinateYEcliptic((int) Math
				.round(GivenValues.factorMercury
						* Formulae.getHelioEclipticCoordinateY(
								GivenValues.dTest, mercury)
						+ (GivenValues.yAxis / 2)));

		Orbit orbitVenus = new Orbit(GivenValues.getVenusA(),
				GivenValues.getVenusE(), GivenValues.getVenusI(),
				GivenValues.getVenusN(), GivenValues.getVenusW(),
				GivenValues.getVenusM());
		final Planet venus = new Planet("Venus", 92.843 * Math.pow(10, 10),
				4.8685 * Math.pow(10, 24), orbitVenus, 177.36, 2449954);
		venus.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, venus));
		venus.setEclipLatitude(Formulae.getEclipticLatitude(GivenValues.dTest,
				venus));
		venus.setPicture("Venus.png");
		venus.setCoordinateXEcliptic((int) Math.round((GivenValues.factorVenus)
				* Formulae
						.getHelioEclipticCoordinateX(GivenValues.dTest, venus)
				+ (GivenValues.xAxis / 2)));
		venus.setCoordinateYEcliptic((int) Math.round((GivenValues.factorVenus)
				* Formulae
						.getHelioEclipticCoordinateY(GivenValues.dTest, venus)
				+ (GivenValues.yAxis / 2)));

		Orbit orbitEarth = new Orbit(GivenValues.getEarthA(),
				GivenValues.getEarthE(), GivenValues.getEarthI(),
				GivenValues.getEarthN(), GivenValues.getEarthW(),
				GivenValues.getEarthM());
		final Planet earth = new Planet("Earth", 1.08321 * Math.pow(10, 12),
				5.9722 * Math.pow(10, 24), orbitEarth, 23.4393, 2450086);
		earth.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, earth));
		earth.setEclipLatitude(Formulae.getEclipticLatitude(GivenValues.dTest,
				earth));
		earth.setPicture("Earth.png");
		earth.setCoordinateXEcliptic((int) Math.round((GivenValues.factorEarth)
				* Formulae
						.getHelioEclipticCoordinateX(GivenValues.dTest, earth)
				+ (GivenValues.xAxis / 2)));
		earth.setCoordinateYEcliptic((int) Math.round((GivenValues.factorEarth)
				* Formulae
						.getHelioEclipticCoordinateY(GivenValues.dTest, earth)
				+ (GivenValues.yAxis / 2)));

		Orbit orbitMars = new Orbit(GivenValues.getMarsA(),
				GivenValues.getMarsE(), GivenValues.getMarsI(),
				GivenValues.getMarsN(), GivenValues.getMarsW(),
				GivenValues.getMarsM());
		final Planet mars = new Planet("Mars", 16.318 * Math.pow(10, 10),
				0.64185 * Math.pow(10, 24), orbitMars, 25.19, 2450146);
		mars.setEclipLongitude(Formulae.getEclipticLongitude(GivenValues.dTest,
				mars));
		mars.setEclipLatitude(Formulae.getEclipticLatitude(GivenValues.dTest,
				mars));
		mars.setPicture("Mars.png");
		mars.setCoordinateXEcliptic((int) Math.round((GivenValues.factorMars)
				* Formulae.getHelioEclipticCoordinateX(GivenValues.dTest, mars)
				+ (GivenValues.xAxis / 2)));
		mars.setCoordinateYEcliptic((int) Math.round((GivenValues.factorMars)
				* Formulae.getHelioEclipticCoordinateY(GivenValues.dTest, mars)
				+ (GivenValues.yAxis / 2)));

		Orbit orbitJupiter = new Orbit(GivenValues.getJupiterA(),
				GivenValues.getJupiterE(), GivenValues.getJupiterI(),
				GivenValues.getJupiterN(), GivenValues.getJupiterW(),
				GivenValues.getJupiterM());
		final Planet jupiter = new Planet("Jupiter", 143128 * Math.pow(10, 10),
				1898.6 * Math.pow(10, 24), orbitJupiter, 3.13, 2451317);
		jupiter.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, jupiter)
				+ GivenValues.longitudePerturbationsJupiter);
		jupiter.setEclipLatitude(Formulae.getEclipticLatitude(
				GivenValues.dTest, jupiter));
		jupiter.setPicture("Jupiter.png");
		jupiter.setCoordinateXEcliptic((int) Math
				.round((GivenValues.factorJupiter)
						* Formulae.getHelioEclipticCoordinateX(
								GivenValues.dTest, jupiter)
						+ (GivenValues.xAxis / 2)));
		jupiter.setCoordinateYEcliptic((int) Math
				.round((GivenValues.factorJupiter)
						* Formulae.getHelioEclipticCoordinateY(
								GivenValues.dTest, jupiter)
						+ (GivenValues.yAxis / 2)));

		Orbit orbitSaturn = new Orbit(GivenValues.getSaturnA(),
				GivenValues.getSaturnE(), GivenValues.getSaturnI(),
				GivenValues.getSaturnN(), GivenValues.getSaturnW(),
				GivenValues.getSaturnM());
		final Planet saturn = new Planet("Saturn", 82713 * Math.pow(10, 10),
				568.46 * Math.pow(10, 24), orbitSaturn, 26.73, 2452799);
		saturn.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, saturn)
				+ GivenValues.longitudePerturbationsSaturn);
		saturn.setEclipLatitude(Formulae.getEclipticLatitude(GivenValues.dTest,
				saturn) + GivenValues.latitudePerturbationsSaturn);
		saturn.setPicture("Saturn.png");
		saturn.setCoordinateXEcliptic((int) Math
				.round((GivenValues.factorSaturn)
						* Formulae.getHelioEclipticCoordinateX(
								GivenValues.dTest, saturn)
						+ (GivenValues.xAxis / 2)));
		saturn.setCoordinateYEcliptic((int) Math
				.round((GivenValues.factorSaturn)
						* Formulae.getHelioEclipticCoordinateY(
								GivenValues.dTest, saturn)
						+ (GivenValues.yAxis / 2)));

		Orbit orbitUranus = new Orbit(GivenValues.getUranusA(),
				GivenValues.getUranusE(), GivenValues.getUranusI(),
				GivenValues.getUranusN(), GivenValues.getUranusW(),
				GivenValues.getUranusM());
		final Planet uranus = new Planet("Uranus", 6833 * Math.pow(10, 10),
				86.832 * Math.pow(10, 24), orbitUranus, 97.77, 2439294);
		uranus.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, uranus)
				+ GivenValues.longitudePerturbationsUranus);
		uranus.setEclipLatitude(Formulae.getEclipticLatitude(GivenValues.dTest,
				uranus));
		uranus.setPicture("Uranus.png");
		uranus.setCoordinateXEcliptic((int) Math
				.round((GivenValues.factorUranus)
						* Formulae.getHelioEclipticCoordinateX(
								GivenValues.dTest, uranus)
						+ (GivenValues.xAxis / 2)));
		uranus.setCoordinateYEcliptic((int) Math
				.round((GivenValues.factorUranus)
						* Formulae.getHelioEclipticCoordinateY(
								GivenValues.dTest, uranus)
						+ (GivenValues.yAxis / 2)));

		Orbit orbitNeptune = new Orbit(GivenValues.getNeptuneA(),
				GivenValues.getNeptuneE(), GivenValues.getNeptuneI(),
				GivenValues.getNeptuneN(), GivenValues.getNeptuneW(),
				GivenValues.getNeptuneM());
		final Planet neptune = new Planet("Neptune", 6254 * Math.pow(10, 10),
				102.43 * Math.pow(10, 24), orbitNeptune, 28.32, 2402309);
		neptune.setEclipLongitude(Formulae.getEclipticLongitude(
				GivenValues.dTest, neptune));
		neptune.setEclipLatitude(Formulae.getEclipticLatitude(
				GivenValues.dTest, neptune));
		neptune.setPicture("Neptune.png");
		neptune.setCoordinateXEcliptic((int) Math
				.round((GivenValues.factorNeptune)
						* Formulae.getHelioEclipticCoordinateX(
								GivenValues.dTest, neptune)
						+ (GivenValues.xAxis / 2)));
		neptune.setCoordinateYEcliptic((int) Math
				.round((GivenValues.factorNeptune)
						* Formulae.getHelioEclipticCoordinateY(
								GivenValues.dTest, neptune)
						+ (GivenValues.yAxis / 2)));

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				SolarsystemGUI frame = new SolarsystemGUI(sun, mercury, venus,
						earth, mars, jupiter, saturn, uranus, neptune);
				frame.setVisible(true);
			}
		});
	}
}
