package ticTacToe.controls;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ticTacToe.view.TicPanel;
import ticTacToe.view.XOButtons;

public class TicManager {

	private static TicManager ticManager = null;
	private JPanel panel;
	private ManageBoard manageBoard;
	private ManagerWinner manageWinner;
	private FinalScreen finalScreen;
	private XOButtons[] buttons;
	private JFrame jFrame;

	private TicManager() {
		
	}

	public static TicManager getInstance() {
		if (ticManager == null) {
			ticManager = new TicManager();
		}
		return ticManager;
	}

	private void initBoard() {
		panel = new TicPanel();
		this.jFrame.add(panel);
				
		manageBoard = new ManageBoard();
		manageBoard.jPane = this.panel;
		finalScreen= new FinalScreen(this.panel,  this.buttons); 
		manageWinner = new ManagerWinner();
				
		panel.setLayout(new GridLayout(3, 3));

	}

	public Boolean verifyCurrentTypeWinner(XOButtons[] buttons) {
		this.buttons = buttons;
		
		if (manageWinner.isThereSequenceWinner(this.buttons)) {
			return true;
		} else if (manageWinner.isThereSkip3SequenceWinner(this.buttons)) {
			return true;
		}

		return false;
	}

	public void start() {
		manageBoard.start();
	}

	public void stop() {
		manageBoard.stop();
	}

	public void setPanel(JPanel jp) {
		if (jp != null) {
			this.panel = jp;
			
		}

	}

	public void setWinner(XOButtons currentXOButtons) {
		
		if(currentXOButtons == null)
		{
			finalScreen.setWinner(FinalScreen.TIED);
			return;
		}
		
		if(currentXOButtons.getIco() == "x")
		{
			finalScreen.setWinner(FinalScreen.X);
		}
		else
		{
			finalScreen.setWinner(FinalScreen.O);
		}
		
	}

	public void restart() {
		
		jFrame.remove(panel);
		panel = null;
		finalScreen= null; 
		jFrame.setVisible(false);
		
		panel = new TicPanel();
		panel.setLayout(new GridLayout(3, 3));
		jFrame.add(panel);

		manageBoard.jPane = this.panel;
		finalScreen= new FinalScreen(this.panel,  this.buttons); 
		start();
		jFrame.setVisible(true);
	}
	

	public void setJframe(JFrame jframe) {
		if(jframe !=null)
		{
			this.jFrame = jframe;
			initBoard();
		}
		
	}
}
