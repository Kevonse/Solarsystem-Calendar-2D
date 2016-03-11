package planets;

import org.joda.time.DateTime;

public class GivenValues
{

	/*
	 * Dates are given to compute planetary values at the given dates. The
	 * computation of the given date is such that the given date is compared to
	 * the date of 2000, january, 1. at 00:00. The returned number 'd' is
	 * negative if date is before epoch(date above) and positive if after. The
	 * number of days is Julian days(JD).
	 */
	public static DateTime dTest = new DateTime();

	public static DateTime getdTest()
	{
		return dTest;
	}

	public static void setdTest(DateTime dTest)
	{
		GivenValues.dTest = dTest;
	}

	public static double getDate(DateTime d)
	{

		return Formulae.getDaysDifference(d);
	}

	public static int xAxis = 1000;
	public static int yAxis = 750;
	public static int factorMercury = 325;
	public static int factorVenus = 250;
	public static int factorEarth = 240;
	public static int factorMars = 200;
	public static final int factorJupiter = 70;
	public static int factorSaturn = 34;
	public static int factorUranus = 25;
	public static int factorNeptune = 19;

	/*
	 * The values given seems to be the daily change in degrees for each planet
	 * in our solarsystem. I have no idea as to where these values come from.
	 * They are given on page 21, http://www.stjarnhimlen.se/comp/tutorial.html
	 */

	// Mercury's values:
	public static double getMercuryN()
	{
		return 48.3313 + 3.24587 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getMercuryI()
	{
		return 7.0047 + 5.00 * Math.pow(10, -8) * getDate(dTest);
	}

	public static double getMercuryW()
	{
		return 29.1241 + 1.01444 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getMercuryA()
	{
		return 0.387098;
	}

	public static double getMercuryE()
	{
		return 0.205635 + 5.59 * Math.pow(10, -10) * getDate(dTest);
	}

	public static double getMercuryM()
	{
		return Formulae.rev(168.6562 + 4.0923344368 * getDate(dTest));
	}

	// Venus's values:
	public static double getVenusN()
	{
		return 76.6799 + 2.46590 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getVenusI()
	{
		return 3.3946 + 2.75 * Math.pow(10, -8) * getDate(dTest);
	}

	public static double getVenusW()
	{
		return 54.8910 + 1.38374 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getVenusA()
	{
		return 0.723330;
	}

	public static double getVenusE()
	{
		return 0.006773 - 1.302 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getVenusM()
	{
		return Formulae.rev(48.0052 + 1.6021302244 * getDate(dTest));
	}

	// Earth's values:
	public static double getEarthN()
	{
		return 0.0;
	}

	public static double getEarthI()
	{
		return 0.0;
	}

	public static double getEarthW()
	{
		return 282.9404 + 4.70935 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getEarthA()
	{
		return 1.000000;
	}

	public static double getEarthE()
	{
		return 0.016709 - 1.151 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getEarthM()
	{
		return 356.0470 + 0.9856002585 * getDate(dTest);
	}

	// Mars' values:
	public static double getMarsN()
	{
		return 49.5574 + 2.11081 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getMarsI()
	{
		return 1.8497 - 1.78 * Math.pow(10, -8) * getDate(dTest);
	}

	public static double getMarsW()
	{
		return 286.5016 + 2.92961 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getMarsA()
	{
		return 1.523688;
	}

	public static double getMarsE()
	{
		return 0.093405 + 2.516 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getMarsM()
	{
		return Formulae.rev(18.6021 + 0.5240207766 * getDate(dTest));
	}

	// Jupiter's values:
	public static double getJupiterN()
	{
		return 100.4542 + 2.76854 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getJupiterI()
	{
		return 1.3030 - 1.557 * Math.pow(10, -7) * getDate(dTest);
	}

	public static double getJupiterW()
	{
		return 273.8777 + 1.64505 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getJupiterA()
	{
		return 5.20256;
	}

	public static double getJupiterE()
	{
		return 0.048498 + 4.469 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getJupiterM()
	{
		return Formulae.rev(19.8950 + 0.0830853001 * getDate(dTest));
	}

	// Saturn's values:
	public static double getSaturnN()
	{
		return 113.6634 + 2.38980 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getSaturnI()
	{
		return 2.4886 - 1.081 * Math.pow(10, -7) * getDate(dTest);
	}

	public static double getSaturnW()
	{
		return 339.3939 + 2.97661 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getSaturnA()
	{
		return 9.55475;
	}

	public static double getSaturnE()
	{
		return 0.055546 - 9.499 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getSaturnM()
	{
		return Formulae.rev(316.9670 + 0.0334442282 * getDate(dTest));
	}

	// Uranus' values:
	public static double getUranusN()
	{
		return 74.0005 + 1.3978 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getUranusI()
	{
		return 0.7733 + 1.9 * Math.pow(10, -8) * getDate(dTest);
	}

	public static double getUranusW()
	{
		return 96.6612 + 3.056 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getUranusA()
	{
		return 19.18171 - 1.55 * Math.pow(10, -8) * getDate(dTest); // Special
																	// value.
	}

	public static double getUranusE()
	{
		return 0.047318 + 7.45 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getUranusM()
	{
		return Formulae.rev(142.5905 + 0.011725806 * getDate(dTest));
	}

	// Neptune's values:
	public static double getNeptuneN()
	{
		return 131.7806 + 3.0173 * Math.pow(10, -5) * getDate(dTest);
	}

	public static double getNeptuneI()
	{
		return 1.7700 - 2.55 * Math.pow(10, -7) * getDate(dTest);
	}

	public static double getNeptuneW()
	{
		return 272.8461 - 6.027 * Math.pow(10, -6) * getDate(dTest);
	}

	public static double getNeptuneA()
	{
		return 30.05826 - 3.313 * Math.pow(10, -8) * getDate(dTest); // Special
																		// value.
	}

	public static double getNeptuneE()
	{
		return 0.008606 + 2.15 * Math.pow(10, -9) * getDate(dTest);
	}

	public static double getNeptuneM()
	{
		return Formulae.rev(260.2471 + 0.005995147 * getDate(dTest));
	}

	/*
	 * The values below are added to their respective planet's longitude or
	 * latitude.
	 */
	public static double longitudePerturbationsJupiter = -0.332
			* Math.sin(2 * Math.toRadians(getJupiterM()) - 5
					* Math.toRadians(getSaturnM()) - Math.toRadians(67.6))
			- 0.056
			* Math.sin(2 * Math.toRadians(getJupiterM()) - 2
					* Math.toRadians(getSaturnM()) + Math.toRadians(21))
			+ 0.042
			* Math.sin(3 * Math.toRadians(getJupiterM()) - 5
					* Math.toRadians(getSaturnM()) + Math.toRadians(21))
			- 0.036
			* Math.sin(Math.toRadians(getJupiterM()) - 2
					* Math.toRadians(getSaturnM()))
			+ 0.022
			* Math.cos(Math.toRadians(getJupiterM())
					- Math.toRadians(getSaturnM()))
			+ 0.023
			* Math.sin(2 * Math.toRadians(getJupiterM()) - 3
					* Math.toRadians(getSaturnM()) + Math.toRadians(52))
			- 0.016
			* Math.sin(Math.toRadians(getJupiterM()) - 5
					* Math.toRadians(getSaturnM()) - Math.toRadians(69));

	public static double longitudePerturbationsSaturn = +0.812
			* Math.sin(2 * Math.toRadians(getJupiterM()) - 5
					* Math.toRadians(getSaturnM()) - Math.toRadians(67.6))
			- 0.229
			* Math.cos(2 * Math.toRadians(getJupiterM()) - 4
					* Math.toRadians(getSaturnM()) - Math.toRadians(2))
			+ 0.119
			* Math.sin(Math.toRadians(getJupiterM()) - 2
					* Math.toRadians(getSaturnM()) - Math.toRadians(3))
			+ 0.046
			* Math.sin(2 * Math.toRadians(getJupiterM()) - 6
					* Math.toRadians(getSaturnM()) - Math.toRadians(69))
			+ 0.014
			* Math.cos(Math.toRadians(getJupiterM()) - 3
					* Math.toRadians(getSaturnM()) + Math.toRadians(32));

	public static double latitudePerturbationsSaturn = -0.020
			* Math.cos(2 * Math.toRadians(getJupiterM()) - 4
					* Math.toRadians(getSaturnM()) - Math.toRadians(2))
			+ 0.018
			* Math.cos(2 * Math.toRadians(getJupiterM()) - 6
					* Math.toRadians(getSaturnM()) - Math.toRadians(49));

	public static double longitudePerturbationsUranus = +0.040
			* Math.sin(Math.toRadians(getSaturnM()) - 2
					* Math.toRadians(getUranusM()) + Math.toRadians(6))
			+ 0.035
			* Math.cos(Math.toRadians(getSaturnM()) - 3
					* Math.toRadians(getUranusM()) + Math.toRadians(33))
			- 0.015
			* Math.sin(Math.toRadians(getSaturnM())
					- Math.toRadians(getUranusM()) + Math.toRadians(20));

}
