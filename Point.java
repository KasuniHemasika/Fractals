import java.awt.*;
import java.awt.geom.Line2D;

public class Point { 
    protected Color color; //
    private double x;
    private double y;

    public Point(Color color,double x,double y) { //constructor for the Point object
        this.color = color;
        this.x=x;
        this.y=y;
    }

    public void draw(Graphics g){ //method to draw a point with a color
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.draw(new Line2D.Double(x, y, x, y));
    }
}