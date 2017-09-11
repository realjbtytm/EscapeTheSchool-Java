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

import io.github.realjbtytm.EscapeTheSchool.Methods.Positions.startStory;
import io.github.realjbtytm.EscapeTheSchool.Methods.Positions.Test;

public class Game {
	
	public void startStory() {
		startStory startStory = new startStory();
		startStory.startStory();
	}
	
	public void Test() {
		Test test = new Test();
		test.Test();
	}

	public JFrame window;
	public Container con;
	public JPanel titleNamePanel, startButtonPanel, authorNamePanel, mainTextPanel, choiceButtonPanel, playerPanel;
	public JLabel titleNameLabel, authorNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	public Font titleFont = new Font("Times New Roman", Font.PLAIN, 75);
	public Font normalFont = new Font ("Times New Roman", Font.PLAIN, 28);
	public Font authorFont = new Font ("Times New Roman", Font.PLAIN, 55);
	public JButton startButton;
	public static JButton choice1;
	public static JButton choice2;
	public static JButton choice3;
	public static JButton choice4;
	public static JTextArea mainTextArea;
	int playerHP, CristopherHP;
	public String weapon;
	public static String position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() { 
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
	
	public void createGameScreen() {
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
		choice4.setActionCommand("c4");
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
	public void playerSetup() {
		playerHP = 100;
		CristopherHP = 120;
		weapon = "Wand";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		startStory();
	}
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "startStory":
				switch(yourChoice) {
				case "c1": Test(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
			}
		}
	}
}
