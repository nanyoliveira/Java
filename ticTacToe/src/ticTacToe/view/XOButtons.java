package ticTacToe.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class XOButtons extends JButton {

	private ImageIcon X, O;
	private static byte value = 0;
	private String ico  = "null";
	private BufferedImage image;

	/**
	 * 0 = nothing; 1 = X 2 = O
	 */
	public XOButtons() {
		setContentAreaFilled(false);
		setFocusPainted(false);
		X = new ImageIcon(this.getClass().getResource("../../../tictactoe/img/x.png"));
		O = new ImageIcon(this.getClass().getResource("../../../tictactoe/img/o.png"));
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		setImage();
		TexturePaint texturePaint= new TexturePaint(image, new Rectangle(0, 0, getWidth(), getHeight()));

		g2.setPaint(texturePaint);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.dispose();
		
		super.paintComponent(g);
	}

	private void setImage() {
		 try {
             image = ImageIO.read(this.getClass().getResource("../../../tictactoe/img/fundo.png"));
         } catch (IOException e) {
             e.printStackTrace();
         }
		  
		
	}
	public void setButton() {

		value++;
		value %= 3;

		if (value == 0) {
			value++;
			value %= 3;
		}

		switch (value) {
			case 0:
				setIcon(null);
				ico = "null";
				break;
			case 1:
				setIcon(X);
				ico = "x";
				break;
			case 2:
				setIcon(O);
				ico = "o";
				break;
	
			default:
				ico = "null";
				break;
		}

	}

	public String getIco() {
		return this.ico;
	}

}
