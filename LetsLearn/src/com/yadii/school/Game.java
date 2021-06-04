package com.yadii.school;

import java.awt.Canvas;

public class Game extends Canvas {
	

private static final long serialVersionUID = -45553514731182420L;

public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; // values of all widths and heights.(size of the frame)
	
	//lets add our game class
	public Game() {
	// Values of the constructor created on GameFRame.java(int,int,String,game)on GameFrame public class.
		new GameFrame(WIDTH, HEIGHT, "Let's Learn!", this); 
	}
	
	public void Image() {
		
	}
	
		//This method here will start our thread
		public synchronized void start() {
			
		}
		
		
	public void run() {			
		}


	public static void main(String[] args) {
		new Game();
	}

}
