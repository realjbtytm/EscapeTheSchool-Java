package io.github.realjbtytm.EscapeTheSchool.Methods.Positions;

import io.github.realjbtytm.EscapeTheSchool.Game;

public class startStory {

	public void startStory() {
		Game.position = "startStory";
		Game.mainTextArea.setText("Hello, Hero. ");
		
		Game.choice1.setText("Go up the stairs.");
		Game.choice2.setText("Give up.");
		Game.choice3.setText("");
		Game.choice4.setText("");
		
	}

}