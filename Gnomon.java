/**
 * @author amytakayesu
 *
 */
import java.awt.*;
import java.awt.geom.Line2D;


public class Gnomon{
  Point a = new Point();
	Point b = new Point();
	Point c = new Point();
	double height;
	double width;
	
	
	/**
	 * Constructs gnomon 
	 * @param double d (angle of gnomon and dial), JPanelBExt panel (on which to draw the gnomon)
	 */
	public Gnomon(double lat, JPanelBExt panel){
		height = panel.getHeight();
		width = panel.getWidth();
		setPoints(a, 0, 0);
		setPoints(b, 0, height);
		setPoints(c, gnomonHeight(lat), 0);
	}	
	
	/**
	 * Calculates the height of the gnomon
	 * @param double d (angle of gnomon and dial)
	 */
	public double gnomonHeight(double lat){
		double gHeight;
		gHeight = height * Math.tan(Math.toRadians(lat));
		return gHeight;
	}
	public void setPoints(Point p, double setx, double sety){
		p.setX(setx);
		p.setY(sety);
	}
	public Point getPointa(){
		return a;
	}
	public Point getPointb(){
		return b;
	}
	public Point getPointc(){
		return c;
	}
	
	/**
	 * Draws out gnomon
	 * @param Graphics gr (one which to draw the gnomon on)
	 */
	public void drawGnomon(Graphics gr){
		Graphics2D gr2 = (Graphics2D) gr;
		System.out.println("called gnomon");
		gr2.draw(new Line2D.Double(a.getX(), a.getY(), b.getX(), b.getY()));
		gr2.draw(new Line2D.Double(a.getX(), a.getY(), c.getX(), c.getY()));
		gr2.draw(new Line2D.Double(b.getX(), b.getY(), c.getX(), c.getY()));

	}
}
