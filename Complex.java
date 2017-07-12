public class Complex {
    private double x; //real and imaginary parts of the Complex object
    private double y;

    public Complex(double x, double y) { //constructor of the object
        this.x = x; 
        this.y = y;
    }
    public double[] getSquared(){ //method to return square of a complex object
        double [] z = new double [2];
        z[0]=x*x-y*y;
        z[1]=2*x*y;
        return z;
    }
    public double getMagnitude(){ //method to return the magnitude of a complex object
        double m= Math.sqrt(x*x+y*y);
        return m;
    }
}