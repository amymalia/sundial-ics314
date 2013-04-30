/**
 * @author amytakayesu
 *
 */
import java.awt.*;
import java.awt.geom.Line2D;

public class Dial {
	/*height and width of panel*/
	double height;
	double width;
	/*array of the points of the dial lines*/
	Point[] dialPoints = new Point[13];	
	
	/**
	 * Constructs horizontal sundial
	 */
	public Dial(JPanelBExt panel){
		height = panel.getHeight();
		width = panel.getWidth();
		for(int x = 0; x <= 12; x ++){
			dialPoints[x] = new Point();
		}
		System.out.println("HERE?");
	}
	
	
	/**
	 * Sets sundial hour line point
	 * @param int h (hour), double angle (angle of gnomon and hour line)
	 */
	public void setPoint(int h, double angle){
		double lengthTop = height * Math.tan(angle);
		double lengthSide = width/2 * Math.tan((Math.toRadians(90)) - angle);
		System.out.println("Hour: " + h + " angle: " + angle + " Math.tan: " + Math.tan(angle));
		System.out.println("length: " + lengthTop);
		System.out.println("height: " + height);
		System.out.println("width: " + width);
		/*line intersects with side of panel*/
		if(Math.abs(lengthTop) >= width/2){
			/*if line is to the right of the gnomon*/
			if(angle > 0){
				System.out.println("side, PM");
				dialPoints[h].setX(width);
				dialPoints[h].setY(height - Math.abs(lengthSide));
			}
			/*if line is to the left of the gnomon*/
			else{
				System.out.println("side, AM");
				dialPoints[h].setX(0.0);
				dialPoints[h].setY(height - Math.abs(lengthSide));
			}
		}
		/*line intersects with top of panel*/
		else{
			/*if line is to the right of the gnomon*/
			if(angle > 0){
				System.out.println("top, PM");
				dialPoints[h].setX((width/2) + Math.abs(lengthTop));
				dialPoints[h].setY(0.0);
			}
			/*if line is to the left of the gnomon*/
			else{
				System.out.println("top, AM");
				dialPoints[h].setX((width/2) - Math.abs(lengthTop));
				dialPoints[h].setY(0.0);
			}
		}
	}
	
	
	/**
	 * Sets sundial hour point
	 * @param int h (hour), double x (x coordinate), double y (y coordinate)
	 */
	public void setPoint(int h, double x, double y){
		dialPoints[h].setX(x);
		dialPoints[h].setY(y);
	}
	
	
	/**
	 * Draws out sundial
	 * @param Graphics gr (on which to draw the dial)
	 */
	public void drawDial(Graphics gr){
		Graphics2D gr2 = (Graphics2D) gr;
		System.out.println("DRAW!!!!!!!!!!");
		//gr.drawLine(0, 314, 782, 314);
		try{
			for(int i = 1; i <= 12; i++){
				if(i == 6){
					System.out.println("x==6");
					gr2.draw(new Line2D.Double(0.0, height, width, height));
				}
				else if(i == 12){
					System.out.println("x==12");
					gr2.draw(new Line2D.Double(width/2, 0.0, width/2, height));
				}
				else{
					System.out.println("x==123457891011");
					gr2.draw(new Line2D.Double(width/2, height, dialPoints[i].getX(), dialPoints[i].getY()));
				}
			}
		}
		catch(NullPointerException npe){
			System.out.println("One or more of the hour line points are missing.");
		}
	}
}
