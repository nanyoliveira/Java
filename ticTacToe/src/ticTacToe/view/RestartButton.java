package ticTacToe.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RestartButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestartButton() {
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		ImageIcon restartlt = new ImageIcon(this.getClass().getResource("../../../tictactoe/img/restart.png"));
		setIcon(restartlt);
	}
	
	

}
