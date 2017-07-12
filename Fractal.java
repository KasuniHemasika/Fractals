import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel{

		private static int WIDTH = 800; //set values for width & height of JPanel  
		private static int HEIGHT = 800;
		
        public static double [] argset= {-1,1,-1,1,1000,-0.4,0.6,0}; //default argument values for Julia and Mandelbrot
		//(real lower limit,real upper limit,complex lower limit,complex upper limit,iterations,c real,c complex, set type)
		//last element of argset is to idenfity the fractal type (Julia / Mandelbrot)  
        public static void main(String[] args) {

            JFrame frame = new JFrame(args[0]+" set"); //create JFrame
            frame.setContentPane(new Fractal());
            frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            frame.setSize(WIDTH, HEIGHT);
            frame.pack();
            frame.setVisible(true);
			frame.setResizable(false);

            if (args[0].equals("Julia")) { //if needed fractal is Julia
                if(args.length==1) {
                }
                else if (args.length==3){ //if x,y values for c are given replace the default values with x,y
                    argset[5]=Double.valueOf(args[1]);
                    argset[6]=Double.valueOf(args[2]);
                }
                else{ //if invalid no of arguments are given
                    System.out.println("Incorrect no of arguments\n"); 
					System.exit(0);
                }
            }
			
            else if (args[0].equals("Mandelbrot")){ //if needed fractal is Mandelbrot
				argset[7]=1;
                 if(args.length==1){
                 }
                 else if(args.length==5) { //if real,complex limits are given replace the default values 
                     argset[0]=Double.valueOf(args[1]);
                     argset[1]=Double.valueOf(args[2]);
                     argset[2]=Double.valueOf(args[3]);
                     argset[3]=Double.valueOf(args[4]);
                 }
                 else if(args.length==6){ //if real,complex limits and iterations are given replace the default values
                     argset[0]=Double.valueOf(args[1]);
                     argset[1]=Double.valueOf(args[2]);
                     argset[2]=Double.valueOf(args[3]);
                     argset[3]=Double.valueOf(args[4]);
                     argset[4]=Double.valueOf(args[5]);
                 }
                 else{ //if invalid no of arguments are given
                     System.out.println("Incorrect no of arguments\n");
					 System.exit(0);
                 }
            }
            else{ //if invalid fractal set name is given
                System.out.println("No such set\n");
				System.exit(0);
            }
        }

		@Override
        protected void paintComponent(Graphics g) { 
				super.paintComponent(g);
                Map FMap = new Map(argset); //create new Map object and call the iterate method
                FMap.iterate(g);
				
        }

}