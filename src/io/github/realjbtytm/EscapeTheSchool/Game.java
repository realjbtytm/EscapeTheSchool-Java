package io.github.realjbtytm.EscapeTheSchool;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, authorNamePanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, authorNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 75);
	Font normalFont = new Font ("Times New Roman", Font.PLAIN, 28);
	Font authorFont = new Font ("Times New Roman", Font.PLAIN, 55);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, CristopherHP;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		window.setResizable(false);
		window.setTitle("Escape The School");
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("Escape The School");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		authorNamePanel = new JPanel();
		authorNamePanel.setBounds(200, 200, 350, 100);
		authorNamePanel.setBackground(Color.black);
		authorNameLabel = new JLabel("By Room 142");
		authorNameLabel.setForeground(Color.white);
		authorNameLabel.setFont(authorFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		authorNamePanel.add(authorNameLabel);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		con.add(authorNamePanel);
	}

	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		authorNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area of the game. Make Gaming Great Again!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice3.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
		
	}
	public void playerSetup(){
		playerHP = 100;
		CristopherHP = 120;
		weapon = "Wand";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		schoolBasement();
	}

	public void schoolBasement(){
		position = "schoolBasement";
		mainTextArea.setText("'Why am I here?' You seem to be trapped in some sort of basement. You have a Wand in your hand. There is a staircase in front of \nyou. There is a sheet of paper beside you. What \nwould you like to do?");
		
		choice1.setText("Read the paper.");
		choice2.setText("Go up the stairs.");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void readPaper(){
		position = "readPaper";
		mainTextArea.setText("It says, 'Hello, Hero. I have given you the power \nto escape this School via your weapon. But, you \nfirst must defeat The Four Traitors. Go up the \nstairs to begin. Good luck. -The Creator'");
		
		choice1.setText("Go up the stairs");
		choice2.setText("Give up.");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void giveUp(){
		position = "giveUp";
		mainTextArea.setText("You die of natural causes. This was unfortunate. If you wish to exit the game, press the red X button the the top left.");
		
		choice1.setText("Restart.");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void schoolEntrance(){
		position = "schoolEntrance";
		mainTextArea.setText("The door to the basement suddenly closes. The \ndoor to the main building is to the front of you. \nThe exit is behind you. What would you like to \ndo?");
		
		choice1.setText("Enter.");
		choice2.setText("Exit. Immediately.");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void exitDeath(){
		position = "exitDeath";
		mainTextArea.setText("You died via radioactive ultrasunlight. If you wish to exit the game, press the red X button the the top left.");
		
		choice1.setText("Restart.");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void schoolMainHallway(){
		position = "schoolMainHallway";
		mainTextArea.setText("The door to the Entrance shut itself. You see the Main Office to your right. There is a Nurse's Office to the left of you.");
		
		choice1.setText("Enter the Main Office.");
		choice2.setText("Enter the Nurse's Office.");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void nurseOffice(){
		position = "nurseOffice";
		mainTextArea.setText("'Suprised to meet you here. I am Cristopher, one of the Four Traitors. Let us fight.' His weapon is a bow and arrow.'");
		
		choice1.setText("Fight.");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void cristopherFight(){
		position = "cristopherFight";
		mainTextArea.setText("Cristopher's HP: " + CristopherHP + "\n\nWhat is your next choice?");
		choice1.setText("Attack!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void mainOffice(){
		position = "mainOffice";
		mainTextArea.setText("You see piles of documents on a desk. There is a door that leads to the classroom hallways. There is a water fountain.");
		
		choice1.setText("Read the documents.");
		choice2.setText("Enter the Hallways.");
		choice3.setText("Drink.");
		choice4.setText("");
	}
	
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		playerDamage = new java.util.Random().nextInt(25);
		
		mainTextArea.setText("You attacked Cristopher and dealt " + playerDamage + " damage!");
		
		CristopherHP = CristopherHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void CristopherAttack() {
		position = "CristopherAttack";
		
		int CristopherDamage = 0;
		
		CristopherDamage = new java.util.Random().nextInt(15);
		
		mainTextArea.setText("Cristopher attacked you and dealt " + CristopherDamage + " damage!");
		
		playerHP = playerHP - CristopherDamage;
		hpLabelNumber.setText("" + playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void CristopherWin(){
		position = "cristopherWin";
		
		mainTextArea.setText("'Congratulations. You won.' \n\nCristopher dissolved into nothingness.");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void CristopherLose(){
		position = "cristopherlose";
		
		mainTextArea.setText("You are overexhausted.\n\n<GAME OVER>");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "schoolBasement":
				switch(yourChoice){
				case "c1": readPaper(); break;
				case "c2": schoolEntrance(); break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "readPaper":
				switch(yourChoice){
				case "c1": schoolEntrance(); break;
				case "c2": giveUp(); break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "giveUp":
				switch(yourChoice){
				case "c1": schoolBasement(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "exitDeath":
				switch(yourChoice){
				case "c1": schoolEntrance(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "schoolEntrance":
				switch(yourChoice){
				case "c1": schoolMainHallway(); break;
				case "c2": exitDeath(); break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "schoolMainHallway":
				switch(yourChoice){
				case "c1": mainOffice(); break;
				case "c2": nurseOffice(); break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "mainOffice":
				switch(yourChoice){
				case "c1": break; //(Read Documents)
				case "c2": break; //(Enter the classroom hallways)
				case "c3": break; //(Drink (Full HP))
				case "c4": break; 
				}
				break;
			case "nurseOffice":
				switch(yourChoice){
				case "c1": cristopherFight(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "cristopherFight":
				switch(yourChoice){
				case "c1": playerAttack(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(CristopherHP < 1){
						CristopherWin();
					}
					else{
						CristopherAttack();
					}
					break;
				}
				break;
			case "CristopherAttack":
				switch(yourChoice){
				case "c1":
					if(playerHP < 1){
						CristopherLose();
					}
					else{
						cristopherFight();
					}
					 break;
				}
				break;
			case "cristopherlose":
				switch(yourChoice){
				case "c1": nurseOffice(); break;
				}
				break;
			case "cristopherWin":
				switch(yourChoice){
				case "c1": mainOffice(); break;
				}
			}
		}
	}
	
}
