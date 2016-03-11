package planets;

import org.joda.time.DateTime;

public class Formulae
{
	/*
	 * This formula returns the number of days that has passed since january
	 * 2000. This is done because a certainty is achieved by measuring directly
	 * a planets orbital values on a given date. It is from these values that
	 * later values are calculated. Primarily a day to day changes as we humans
	 * think of differences on a day to day basis.
	 */
	public static double getDaysDifference(DateTime a)
	{ // Returns 'd' in JD. Days from J2000.0 to a.

		return 367 * a.getYear()
				- (7 * (a.getYear() + ((a.getMonthOfYear() + 9) / 12))) / 4
				+ (275 * a.getMonthOfYear()) / 9 + a.getDayOfMonth() - 730530;
	}

	/*
	 * When a planet is at it's perihelion is when it is closest to the sun.
	 */
	public static double getTimeSincePerihelion(DateTime a, Planet p)
	{

		return a.getDayOfYear() - p.getTimeAtPerihelion();
	}

	public static double getPerihelionDistance(Planet p)
	{ // Shortest distance between earth and sun.

		return p.getOrbit().getSemiMajorAxis()
				* (1 - p.getOrbit().getEccentricity());
	}

	/*
	 * When a planet is at is aphelion is when it is furthest away from the sun.
	 */
	public static double getAphelionDistance(Planet p)
	{

		return p.getOrbit().getSemiMajorAxis()
				* (1 + p.getOrbit().getEccentricity());
	}

	/*
	 * This method returns the time it takes for a planet to go through it's
	 * orbit once.
	 */
	public static double getOrbitalPeriod(Planet p)
	{

		return 365.256898326 * Math.pow(p.getOrbit().getSemiMajorAxis(),
				(1.5 / Math.sqrt(1 + p.getMass())));
	}

	/*
	 * This method returns the daily motion a planet has in degrees.
	 */
	public static double getDailyMotion(Planet p)
	{

		return 360 / getOrbitalPeriod(p);
	}

	public static double getMeanAnomaly(DateTime a, Planet p)
	{

		return rev(getDailyMotion(p) * getTimeSincePerihelion(a, p));
	}

	public static double getMeanLongitude(DateTime a, Planet p)
	{

		return rev(p.getOrbit().getM() * p.getOrbit().getW()
				* p.getOrbit().getN());
	}

	public static double getEccentricAnomaly(DateTime a, Planet p)
	{
		double M = p.getOrbit().getM();
		double e = p.getOrbit().getEccentricity();

		// E0, as seen on page 16, http://www.stjarnhimlen.se/comp/tutorial.html
		double E0 = M + (180.0 / Math.PI) * e * Math.sin(Math.toRadians(M))
				* (1 + e * Math.cos(Math.toRadians(M)));
		// E1, as seen on page 16, http://www.stjarnhimlen.se/comp/tutorial.html
		double E1 = E0
				- (E0 - (180.0 / Math.PI) * e * Math.sin(Math.toRadians(E0)) - M)
				/ (1 - e * Math.cos(Math.toRadians(E0)));

		while (E0 - E1 > 0.005) {// 0.005 is used as a precision mark.

			E0 = E1;
			E1 = E0
					- (E0 - (180.0 / Math.PI) * e
							* Math.sin(Math.toRadians(E0)) - M)
					/ (1 - e * Math.cos(Math.toRadians(E0)));
		}
		return rev(E1);
	}

	/*
	 * A planet's position in it's orbit. The plane these coordinates lay upon
	 * is the plane a planet's orbits create/lie in.
	 */
	public static double getOrbitCoordinateX(DateTime a, Planet p)
	{

		return p.getOrbit().getSemiMajorAxis()
				* (Math.cos(Math.toRadians(getEccentricAnomaly(a, p))) - p
						.getOrbit().getEccentricity());
	}

	public static double getOrbitCoordinateY(DateTime a, Planet p)
	{

		return p.getOrbit().getSemiMajorAxis()
				* Math.sqrt(1 - p.getOrbit().getEccentricity()
						* p.getOrbit().getEccentricity())
				* Math.sin(Math.toRadians(getEccentricAnomaly(a, p)));
	}

	// True anomaly is calculated from rectangular coordinates in the ecliptic.
	public static double getTrueAnomaly(DateTime a, Planet p)
	{

		return Math.toDegrees(Math.atan2(getOrbitCoordinateY(a, p),
				getOrbitCoordinateX(a, p)));
	}

	/*
	 * Distance between planet and the sun.
	 */
	public static double getDistance(DateTime a, Planet p)
	{

		return Math.sqrt(getOrbitCoordinateX(a, p) * getOrbitCoordinateX(a, p)
				+ getOrbitCoordinateY(a, p) * getOrbitCoordinateY(a, p));
	}

	/*
	 * The helioEcliptic coordinates are, in this application, the coordinates
	 * of the planets in the ecliptic plane.
	 */
	public static double getHelioEclipticCoordinateX(DateTime a, Planet p)
	{

		double N = Math.toRadians(p.getOrbit().getN());
		double V = Math.toRadians(getTrueAnomaly(a, p));
		double w = Math.toRadians(p.getOrbit().getW());
		double i = Math.toRadians(p.getOrbit().getInclination());

		return getDistance(a, p)
				* (Math.cos(N) * Math.cos(V + w) - Math.sin(N)
						* Math.sin(V + w) * Math.cos(i));
	}

	public static double getHelioEclipticCoordinateY(DateTime a, Planet p)
	{

		double N = Math.toRadians(p.getOrbit().getN());
		double V = Math.toRadians(getTrueAnomaly(a, p));
		double w = Math.toRadians(p.getOrbit().getW());
		double i = Math.toRadians(p.getOrbit().getInclination());

		return getDistance(a, p)
				* (Math.sin(N) * Math.cos(V + w) + Math.cos(N)
						* Math.sin(V + w) * Math.cos(i));
	}

	public static double getHelioEclipticCoordinateZ(DateTime a, Planet p)
	{

		double V = Math.toRadians(getTrueAnomaly(a, p));
		double w = Math.toRadians(p.getOrbit().getW());
		double i = Math.toRadians(p.getOrbit().getInclination());

		return getDistance(a, p) * (Math.sin(V + w) * Math.sin(i));
	}

	/*
	 * Note to my self: Figure out what I meant when naming Ecliptic Longitude
	 * and Eclipit Latitude. What value do they represent?
	 */
	public static double getEclipticLongitude(DateTime a, Planet p)
	{

		double xEclip = getHelioEclipticCoordinateX(a, p);
		double yEclip = getHelioEclipticCoordinateY(a, p);

		return Math.toDegrees(rev((Math.atan2(yEclip, xEclip))));
	}

	public static double getEclipticLatitude(DateTime a, Planet p)
	{

		double xEclip = getHelioEclipticCoordinateX(a, p);
		double yEclip = getHelioEclipticCoordinateY(a, p);
		double zEclip = getHelioEclipticCoordinateZ(a, p);

		return rev(Math.toDegrees((Math.atan2(zEclip,
				Math.sqrt(xEclip * xEclip + yEclip * yEclip)))));
	}

	/*
	 * Method returns a given planets latitude in the imaginary sphere
	 * surrounding the Sun and a given planet.
	 */
	public static double getLatitude(DateTime a, Planet p)
	{

		double z = getHelioEclipticCoordinateZ(a, p);
		double e = p.getOrbit().getEccentricity();

		// E0, as seen on page 16, http://www.stjarnhimlen.se/comp/tutorial.html
		double lat0 = Math.atan(z / (getDistance(a, p) * (1 - e * e)));
		// E1, as seen on page 16, http://www.stjarnhimlen.se/comp/tutorial.html
		double lat1 = Math.asin((z + e * e * getTrueAnomaly(a, p)
				* Math.sin(Math.toRadians(lat0))));

		while (lat0 - lat1 > 0.005) {

			lat0 = lat1;
			lat1 = Math.asin((z + e * e * getTrueAnomaly(a, p)
					* Math.sin(Math.toRadians(lat0))));
		}
		return rev(lat1);
	}

	public static double getV(DateTime a, Planet p)
	{ // V value found on the internet. Variable helping determine cartesian
		// coordinates.

		double aSemiMajor = p.getOrbit().getSemiMajorAxis();
		double e = p.getOrbit().getEccentricity();
		double lat = Math.toRadians(getLatitude(a, p));

		return aSemiMajor / Math.sqrt(1 - e * e * Math.pow(Math.sin(lat), 2));
	}

	/*
	 * The equatorial coordinates below are not used in this application but has
	 * been included as I might further develop this application and this
	 * information might be usable later.
	 */
	public static double getXEquatorial(DateTime a, Planet p)
	{

		double xEclip = getHelioEclipticCoordinateX(a, p);

		return xEclip; // Coordinate system is rotated around the x-axis.
	}

	public static double getYEquatorial(DateTime a, Planet p)
	{

		double oblec = Math.toRadians(23.4393);
		double yEclip = getHelioEclipticCoordinateY(a, p);
		double zEclip = getHelioEclipticCoordinateZ(a, p);

		return yEclip * Math.cos(oblec) - zEclip * Math.sin(oblec);
	}

	public static double getZEquatorial(DateTime a, Planet p)
	{

		double oblec = Math.toRadians(23.4);
		double yEclip = getHelioEclipticCoordinateY(a, p);
		double zEclip = getHelioEclipticCoordinateZ(a, p);

		return yEclip * Math.sin(oblec) + zEclip * Math.cos(oblec);
	}

	/*
	 * Below are the new recalculated coordinates of Jupiter, Saturn and
	 * Uranus.(Neptune's perturbation is accounted for) The coordinates are, I
	 * assume, in the ecliptic.
	 */
	public static double getNewJupiterCoordinateX(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsJupiter);
		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.cos(jupiterLon);
	}

	public static double getNewJupiterCoordinateY(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsJupiter);
		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.sin(jupiterLon);
	}

	public static double getNewJupiterCoordinateZ(DateTime a, Planet p)
	{

		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.sin(jupiterLat);
	}

	public static double getNewSaturnCoordinateX(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsSaturn);
		double jupiterLat = Math.toRadians(p.getEclipLatitude()
				+ GivenValues.latitudePerturbationsSaturn);
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.cos(jupiterLon);
	}

	public static double getNewSaturnCoordinateY(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsSaturn);
		double jupiterLat = Math.toRadians(p.getEclipLatitude()
				+ GivenValues.latitudePerturbationsSaturn);
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.sin(jupiterLon);
	}

	public static double getNewSaturnCoordinateZ(DateTime a, Planet p)
	{

		double jupiterLat = Math.toRadians(p.getEclipLatitude()
				+ GivenValues.latitudePerturbationsSaturn);
		double r = getDistance(a, p);

		return r * Math.sin(jupiterLat);
	}

	public static double getNewUranusCoordinateX(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsUranus);
		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.cos(jupiterLon);
	}

	public static double getNewUranusCoordinateY(DateTime a, Planet p)
	{

		double jupiterLon = Math.toRadians(p.getEclipLongitude()
				+ GivenValues.longitudePerturbationsUranus);
		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.cos(jupiterLat) * Math.sin(jupiterLon);
	}

	public static double getNewUranusCoordinateZ(DateTime a, Planet p)
	{

		double jupiterLat = Math.toRadians(p.getEclipLatitude());
		double r = getDistance(a, p);

		return r * Math.sin(jupiterLat);
	}

	/*
	 * A utility function. Originally in the utilityFcuntions class. But it
	 * needed to be deleted due to too much unused code.
	 */
	public static double rev(double x)
	{ // Converts an angle above 360 to a equivalent degree between 0 - 360
		// degrees.

		return (double) x - Math.floor(x / 360) * 360;
	}
}
