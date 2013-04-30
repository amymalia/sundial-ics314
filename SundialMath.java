/**
 *@author Reginald Nartatez
 */
 
public class SundialMath
{  
	private double phi;			/*latitude*/
	private double longitude; 	/*longitude*/
	private double sm;			/*standard meridian*/
	private String month;		/*month of the year*/
	private int day;			/*day of the month*/

	/**
	 * Constructs SundialMath
	 */
	public SundialMath(double lat, double lon, double standardM, String mon, int d)
	{
		phi = lat;
		longitude = lon;
		sm = standardM;
		month = mon;
		day = d;
	}
	
	/**			
	 *	@params:	double t:	time measured from noon in degrees of arc
	 *	
	 *	finds the angle of the hour line for time t
	 *	formula:	tan(d) = tan(t)*sin(phi)
	 */
	public double calculateAngle(double t){
		double angle = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(t))*Math.sin(Math.toRadians(phi))));
		return angle;
	}
	
	/**
	 * 
	 * @param t (hourline time), 
	 * @param dayOfTheYear (the day of the year i.e. Jan 1 is day 1, Feb 1 is day 32, Dec 31 is day 365)
	 * @return adjustedAngle in degrees (angle adjusted with both first and second refinements)
	 */
	public double adjustAngle(double t){
		double actualTime = (t - firstRefinement()) - eot(calcDayOfYear());
		double adjustedAngle = calculateAngle(actualTime);
		return adjustedAngle;
	}

	/**			
	 *	First Refinement
	 *	finds the amount of minutes to adjust the hour lines due to difference in longitude
	 *  @return minOff (amount of minutes the sundial is off of clock time)
	 */
	public double firstRefinement()
	{
		/* minutes earlier or later than standard time (1 degree = 4 minutes)*/
		double minOff = (longitude - sm) * 4;
		return minOff;
	}
	
	/**
	 * 
	 * @return Day of the year, calculated from month and day of month.
	 */
	public int calcDayOfYear(){
		return 0;
	}
	
	/**			
	 *	@params int dayOfTheYear: the day of the year i.e. Jan 1 is day 1, Feb 1 is day 32, Dec 31 is day 365
	 *	@return difference due to Equation of Time in minutes
	 */
	public double eot(int dayOfTheYear)
	{
		double b = Math.toRadians(360 * (dayOfTheYear - 81) / 365);
		double eot = 60 * (9.87 * Math.sin(2 * b) - 7.53 * Math.cos(b) - 1.5 * Math.sin(b));
		return eot;
	}

	/**				
	 *	@params:	String degree: the value to convert
	 *	@return:	double: the converted value
	 *	@usage:	    45\"30'23 = 45 degrees, 30 minutes, 23 seconds
	 *				You need that first backslash to indicate that the
	 *				double quote does not close the string
	 *			
	 *				convertHourToDecimal("45\"30'23)
	 *	
	 *	Converts hour to decimal;
	 *	@author from stackoverflow
	 */
	public double convertHourToDecimal(String degree)
	{
    	if(!degree.matches("(-)?[0-6][0-9]\"[0-6][0-9]\'[0-6][0-9](.[0-9]{1,5})?"))
  	      throw new IllegalArgumentException();
  	      
  		String[] strArray=degree.split("[\"']");
  		return Double.parseDouble(strArray[0])+Double.parseDouble(strArray[1])/60+Double.parseDouble(strArray[2])/3600;
	}
	
	public double getLat(){
		return phi;
	}
	
	public double getLon(){
		return longitude;
	}
	
	public double getSm(){
		return sm;
	}
	
	public String getMon(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
}
