package ticTacToe;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ticTacToe.controls.ManageBoard;
import ticTacToe.controls.TicManager;
import ticTacToe.view.TicPanel;

public class TicTacToe extends JFrame {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe();
	}

	public TicTacToe() {
		super("tic tac toe");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout();
	}

	public void setLayout() {
		
		TicManager.getInstance().setJframe(this);
		TicManager.getInstance().start();
		
		setVisible(true);
	}

}
