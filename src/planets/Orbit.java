package planets;

public class Orbit
{

	private double semiMajorAxis; // Measured here in Astronomical units(AU).
	private double eccentricity;
	private double inclination;
	private double N; // Longitude of Ascending Node.
	private double w; // The angle from the Ascending Node to the perihelion,
						// along the orbit.
	private double M; // Mean anomaly.

	public Orbit(double semiMajorAxis, double eccentricity, double inclination,
			double N, double w, double M)
	{

		this.semiMajorAxis = semiMajorAxis;
		this.eccentricity = eccentricity;
		this.inclination = inclination;
		this.N = N;
		this.w = w;
		this.M = M;
	}

	public double getSemiMajorAxis()
	{
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(double semiMajorAxis)
	{
		this.semiMajorAxis = semiMajorAxis;
	}

	public double getEccentricity()
	{
		return eccentricity;
	}

	public void setEccentricity(double eccentricity)
	{
		this.eccentricity = eccentricity;
	}

	public double getInclination()
	{
		return inclination;
	}

	public void setInclination(double inclination)
	{
		this.inclination = inclination;
	}

	public double getN()
	{
		return N;
	}

	public void setN(double n)
	{
		N = n;
	}

	public double getW()
	{
		return w;
	}

	public void setW(double w)
	{
		this.w = w;
	}

	public double getM()
	{
		return M;
	}

	public void setM(double m)
	{
		M = m;
	}
}
