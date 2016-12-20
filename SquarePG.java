// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.*;
import javax.swing.JFrame;

public class SquarePG extends JFrame {
	boolean isRunning = true;
	int fps = 30;
	
	public static void main(String args[]) {
		SquarePG game = new SquarePG();
		game.run();
		System.exit(0);
	}
	
	//Constructor???
	/*public SquarePG() {
		
	}*/
	
	//runs game loop
	public void run(){
		
		initialize();
		
		while(isRunning){
			long time = System.currentTimeMillis();
			
			update();
			draw();
			
			//delay for each frame
			time = (1000/fps) - (System.currentTimeMillis()-time);
			
			if (time > 0){
				try{
					Thread.sleep(time);
				}
				catch (Exception e){}
			}
		}
		setVisible(false);
	}
	
	//initial setup
	void initialize(){
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 1000, 750 );
		setVisible( true );
	}
	
	//input check, movement
	void update(){
		
	}
	
	//Draws everything
	void draw(){
			
	}
}
