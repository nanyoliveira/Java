package ticTacToe.controls;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ticTacToe.view.ImageComponent;
import ticTacToe.view.RestartButton;

public class FinalScreen implements ActionListener {

	public static final String TIED = "tied";
	public static final String X = "x";
	public static final String O = "o";
	private JPanel jp;
	private ImageComponent component;
	private RestartButton rbtn;
	private JButton[] buttons;

	public FinalScreen(JPanel jp, JButton[] buttons) {
		this.jp = jp;
		this.buttons = buttons;

	}

	public void setWinner(String winner) {
		TicManager.getInstance().stop();
		
		jp.setLayout(new BorderLayout());
		if (winner == X) {
			component = new ImageComponent("../../../tictactoe/img/x.png");
		} else if (winner == O) {
			component = new ImageComponent("../../../tictactoe/img/o.png");
		} else {
			component = new ImageComponent("../../../tictactoe/img/elder.png");
		}
		
		jp.add(component, BorderLayout.CENTER);
		
		rbtn = new RestartButton();
		rbtn.addActionListener(this);
		jp.add(rbtn, BorderLayout.SOUTH);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.jp.remove(component);
		this.jp.remove(rbtn);
		rbtn = null;
		component = null;
		TicManager.getInstance().restart();

	}

}
