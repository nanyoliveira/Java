package ticTacToe.controls;

import ticTacToe.view.XOButtons;


public class ManagerWinner {

	public ManagerWinner() {

	}

	public boolean isThereSequenceWinner(XOButtons[] buttons) {

		int i = 0;
		int oCounter = 0;
		int xCounter = 0;
		while (i < 3) // counting line
		{
			oCounter = 0;
			xCounter = 0;
			for (int j = (3 * i); j < 3 * (i + 1); j++) // counting object per
														// line
			{
				if (buttons[j].getIco() == "o") {
					oCounter++;
				}

				if (oCounter == 3) {
					return true;
				}

				if (buttons[j].getIco() == "x") {
					xCounter++;
				}
				if (xCounter == 3) {
					return true;
				}
			}

			++i;
		}
		return false;
	}

	public boolean isThereSkip3SequenceWinner(XOButtons[] buttons) {
		boolean win = false;
		XOButtons currentButton;

	
		for (int j = 0; j < 3; j++) {

			currentButton = buttons[j];
			
			if((currentButton.getIco() == "o" || currentButton.getIco() == "x") && 
					currentButton.getIco() == buttons[j+3].getIco() &&  
					currentButton.getIco() == buttons[j+6].getIco())
			{
				win = true;
			}
			
			
			if((currentButton.getIco() == "o" || currentButton.getIco() == "x") && 
					j == 0 &&
					currentButton.getIco() == buttons[j+4].getIco() &&  
					currentButton.getIco() == buttons[j+8].getIco())
			{
				win = true;
			}
			
			if((currentButton.getIco() == "o" || currentButton.getIco() == "x") && 
					j == 2 &&
					currentButton.getIco() == buttons[j+2].getIco() &&  
					currentButton.getIco() == buttons[j+4].getIco())
			{
				win = true;
			}
			
			
			
		}

		return win;
	}

}
