package ticTacToe.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ImageComponent extends JComponent {
	private BufferedImage image;
	
	
	public ImageComponent(String path) {
		
		try {					
			this.image = ImageIO.read((this.getClass().getResource(path)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		if (image == null)
			return;
		g.drawImage(image, 120, 120, this);

		
	}
}
