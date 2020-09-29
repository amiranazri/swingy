package swingy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, storyPanel, choiceButtonPanel, heroStatusPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
    JButton startButton, option1, option2, option3, option4;
    JTextArea storyArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    Font titleFont = new Font("Amatic SC", Font.PLAIN, 70);
    Font bodyFont = new Font("Calibri", Font.PLAIN, 12);
    Font storyFont = new Font("Orange Kid", Font.PLAIN, 40);
    Font choiceFont = new Font("Minecraftia", Font.PLAIN, 15);
    Font statFont = new Font("Minecraftia", Font.PLAIN, 18);

    int playerHP;
    String weapon;


    public static void main( String[] args ) {
        new App();
    }

    public App() {
        window = new JFrame();
        window.setSize(800, 600); //Replace with equation to calculate map size?
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows you to exit game window
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true); //This ensure you make the map appear despite it not being visible above.
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("Whimsyshire");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350, 250, 100, 50);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start Adventure");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(bodyFont);
        startButton.addActionListener(tsHandler); //gives button a functionality

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void gameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        storyPanel = new JPanel();
        storyPanel.setBounds(100, 100, 600, 250);
        storyPanel.setBackground(Color.black);
        con.add(storyPanel);

        storyArea = new JTextArea("Welcome to Whimsyshire, Dark One...");
        storyArea.setBounds(100, 100, 600, 200);
        storyArea.setBackground(Color.black);
        storyArea.setForeground(Color.white);
        storyArea.setFont(storyFont);
        storyArea.setLineWrap(true);
        storyPanel.add(storyArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        choiceButtonPanel.setBackground(Color.black);
        con.add(choiceButtonPanel);

        //Button config for first option button.
        option1 = new JButton("North");
        option1.setBackground(Color.white);
        option1.setForeground(Color.black);
        option1.setFont(choiceFont);
        choiceButtonPanel.add(option1);

        //Button config for second option button.
        option2 = new JButton("East");
        option2.setBackground(Color.white);
        option2.setForeground(Color.black);
        option2.setFont(choiceFont);
        choiceButtonPanel.add(option2);

        //Button config for third option button.
        option3 = new JButton("South");
        option3.setBackground(Color.white);
        option3.setForeground(Color.black);
        option3.setFont(choiceFont);
        choiceButtonPanel.add(option3);

        //Button config for fourth option button.
        option4 = new JButton("West");
        option4.setBackground(Color.white);
        option4.setForeground(Color.black);
        option4.setFont(choiceFont);
        choiceButtonPanel.add(option4);

        heroStatusPanel = new JPanel();
        heroStatusPanel.setBounds(100, 15, 600, 50);
        heroStatusPanel.setBackground(Color.black);
        heroStatusPanel.setLayout(new GridLayout(1,4));
        con.add(heroStatusPanel);
        //HP stat label:
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(statFont);
        hpLabel.setForeground(Color.white);
        heroStatusPanel.add(hpLabel);
        //HP stat number:
        hpNumberLabel = new JLabel("[REPLACE ME]");
        hpNumberLabel.setFont(statFont);
        hpNumberLabel.setForeground(Color.white);
        heroStatusPanel.add(hpNumberLabel);
        //Weapons stat label:
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(statFont);
        weaponLabel.setForeground(Color.white);
        heroStatusPanel.add(weaponLabel);
        //Weapons stat number:
        weaponNameLabel = new JLabel("[REPLACE ME]");
        weaponNameLabel.setFont(statFont);
        weaponNameLabel.setForeground(Color.white);
        heroStatusPanel.add(weaponNameLabel);

        playerSetup();
    }

    public void playerSetup() {
        playerHP = 100;
        weapon = "Steel Sword";
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){
            gameScreen();
        }

    }

}