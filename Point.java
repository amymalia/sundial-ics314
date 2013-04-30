/**
 * @author amytakayesu
 *
 */

public class Point {
  double x = 0;
	double y = 0;
	
	/**
	 * Constructs a coordinate point
	 */
	public Point(){
		
	}
	
	/**
	 * Constructs a coordinate point with coordinate x(parameter a) and y(parameter b) 
	 */
	public Point(double a, double b){
		x = a;
		y = b;
	}
	
	public void setX(double a){
		x = a;
	}
	
	public void setY(double b){
		y = b;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
