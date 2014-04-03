package ticTacToe.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TicPanel extends JPanel {
	 private static final long serialVersionUID = 1L;
     private ImageIcon image = new ImageIcon(this.getClass().getResource("../../../tictactoe/img/winner.png"));
 
    
     @Override
     public void paintComponent(Graphics g)
     {
         g.drawImage(image.getImage(), 0, 0, null);
     }
     
     @Override
    public void setPreferredSize(Dimension preferredSize) {
    	super.setPreferredSize( new Dimension(400, 400));
    }
}

