// Authors: Tiger Dong, Cathy Hua
// Date: yes please
// Description: 

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class SquarePG extends JFrame {
	private boolean isRunning = true;
	private int FPS = 30;
	private int state = 0;
	
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
			
			state = update(state);
			draw();
			
			//delay for each frame
			time = (1000/FPS) - (System.currentTimeMillis()-time);
			
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
	int update(int state){
		/*
		switch (state) {
			case MENU:
				break;
			case COMBAT:
				break;
		}
		*/
		return state;
	}
	
	//Draws everything
	void draw(){
			
	}
}
