package ticTacToe.controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ticTacToe.view.XOButtons;

public class ManageBoard implements ActionListener {

	private XOButtons buttons[];
	public JPanel jPane;
	private XOButtons currentXOButtons;
	private int buttonClicked;

	public ManageBoard() {
		buttons = new XOButtons[9];
	}

	public void setButtons() {

		for (char i = 0; i < 9; i++) {
			buttons[i] = new XOButtons();
			jPane.add(buttons[i]);
						
			buttons[i].addActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentXOButtons = (XOButtons) e.getSource();
		currentXOButtons.setButton();
		currentXOButtons.removeActionListener(this);
		buttonClicked++;
		verifyWinner();

	}

	private void verifyWinner() {

		if (TicManager.getInstance().verifyCurrentTypeWinner(buttons)) {
			TicManager.getInstance().setWinner(currentXOButtons);
			System.out.println("you won!");

		} else {
			if (isTied()) {
				TicManager.getInstance().setWinner(null);
				System.out.println("Anyone Won");
			}
		}

	}

	private Boolean isTied() {
		if (buttonClicked == 9) {
			return true;
		}
		return false;
	}

	public void start() {

		setButtons();
	}

	public void stop() {
		buttonClicked = 0;
		currentXOButtons = null;
		for (char i = 0; i < 9; i++) {
			jPane.remove(buttons[i]);
			buttons[i].removeActionListener(this);
		}
		
	}

}
