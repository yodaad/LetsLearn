package com.yadii.school;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;


//Creates an icon-worthy Image from scratch.
protected static Image createFDImage() {
	private static final Component Image = null;
    //Create a 16x16 pixel image.
    BufferedImage bi = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);

    //Draw into it.
    Graphics g = bi.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 15, 15);
    g.setColor(Color.RED);
    g.fillOval(5, 3, 6, 6);

    //Clean up.
    g.dispose();

    //Return it.
    return bi;
}
//Returns an Image or null.
protected static Image getFDImage() {
    java.net.URL imgURL = FrameDemo2.class.getResource("images/logo-16x16.jpg");
    if (imgURL != null) {
        return new ImageIcon(imgURL).getImage();
    } else {
        return null;
    }
}



public class GameFrame extends Canvas {

	private static final long serialVersionUID = 1773271386652294203L;
	private static final Component Image = null;

	//lets create a class for our Frame.
		public GameFrame( int width, int height, String title, Game game) {
			
			try {
	            UIManager.setLookAndFeel(
	                UIManager.getCrossPlatformLookAndFeelClassName());
	        } catch (Exception e) { }
	 
			
			//the Frame will have decoration provided by the look and feel
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			
			//let's create the JFrame or window , we will call it frame.
			JFrame frame = new JFrame(title);
			
			
			//Add icon to the frame
//			frame.setIconImage(new ImageIcon(imgURL).getImage());
			
			// let's specify the dimensions of our window frame.
			frame.setPreferredSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setMinimumSize(new Dimension(width, height));
			
			//Game will finish when the window is closed, to exit the game properly
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
			frame.setResizable(false); //we don't want to resize the window
			
			frame.setLocationRelativeTo(null); // we want our game to start at the middle of the screen
			
			frame.add(game); // we're adding our Game(main) class into our frame this is very important
			
			frame.setVisible(true); // so we can see the window.
			frame.add(Image);
			
			game.start();
				
			
		}
}
}
