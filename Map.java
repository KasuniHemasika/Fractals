import java.awt.*;

public class Map {

	double [] z =new double [2]; // Zn is at z
    private double v; //x coordinate of a pixels
    private double h; //y coordinate of a pixels
    protected Color color; //color for a pixel
	
    private double realRange; //variable declaration
	private double compRange;
    private double cx;
    private double cy;
	private double realMin;
	private double compMax;
	private double iterations;
	private double setType;

    public Map (double[] array) { //constructor for Map object
        this.realRange=array[1]-array[0];  
        this.compRange=array[3]-array[2];
		this.cx =array[5];
		this.cy =array[6];
		this.realMin = array[0];
		this.compMax = array[3];
		this.iterations = array[4];
		setType = array[7];
    }
    public void iterate(Graphics g){ // method to go through all the pixels and draw
        for(v=0;v<=800;v++){
            for(h=0;h<=800;h++){
                if(setType==0){
                    z[0]=realMin+(h/800)*realRange;
                    z[1]=compMax-(v/800)*compRange;
                }
                else{
                    z[0]=0.0;
                    z[1]=0.0;
                    cx=realMin+(h/800)*realRange;
                    cy=compMax-(v/800)*compRange;
                }
                check(g,z[0],z[1]); //call method check
            }
        }
    }
    public void check(Graphics g,double zx,double zy){ //method to check whether point is within the set and draw
        double [] z = {zx,zy}; //initially Z0 at z
        int count; 
        for(count=0;count<iterations;count++) { 
            Complex no = new Complex(z[0],z[1]); //create new complex object
            double mag = no.getMagnitude(); //get magnitude of complex object
            if(mag>=2){ //if magnitude > 2 point is out of the set
                break;
            }
			z = no.getSquared(); //get square of z
			z[0]=z[0]+cx; // z^2 + c
            z[1]=z[1]+cy;
		}
            int R,G,B; //R,G,B for color object
            if(count==iterations){ //set different color combinations for different no of iterations
                R=0;G=0;B=0;
            }else if(count>iterations-10){
              R=0;G=0;B=128;
            }else if(count>iterations-20){
                R=0;G=0;B=255;
            }else if(count>970){
                R=30;G=144;B=255;
            }else if(count>960){
                R=135;G=206;B=235;
            }else if(count>700){
                R=173;G=216;B=230;
            }else if(count>500){
              R=238;G=130;B=238;
            }else if(count>400){
                R=255;G=0;B=255;
            }else if(count>250){
                R=199;G=21;B=133;
            }else if(count>100){
              R=128;G=0;B=128;
            }else if(count>50){
               R=0;G=128;B=128;
            }else if(count>40){
                R=0;G=205;B=209;
            }else if(count>30){
                R=127;G=255;B=212;
            }else if(count>20){
                R=192;G=192;B=192;
            }else if(count>10){
                R=25;G=25;B=112;
            }else if(count>7){
                R=100;G=149;B=237;
            }else if(count>3){
                R=135;G=206;B=250;
            }else{
                R=0;G=206;B=209;
            }
            Color color = new Color(R, G, B); //create new color object 
            Point x = new Point(color, h, v); //create new point object
            x.draw(g); //draw point
     
    }
}