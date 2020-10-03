package swingy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import swingy.*;

public class App
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, storyPanel, choiceButtonPanel, heroStatusPanel, heroSelectPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, classLabel, experienceLabel, attackLabel, defenseLabel, hitLabel;
    JButton startButton, enterButton, option1, option2, option3, option4, witchDoctor, demonHunter, crusader;
    JTextArea storyArea;

//    HeroSelectHandler hsHandler = new HeroSelectHandler();
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    Font titleFont = new Font("Amatic SC", Font.PLAIN, 70);
    Font bodyFont = new Font("Calibri", Font.PLAIN, 12);
    Font storyFont = new Font("Orange Kid", Font.PLAIN, 40);
    Font choiceFont = new Font("Minecraftia", Font.PLAIN, 15);
    Font statFont = new Font("Minecraftia", Font.PLAIN, 18);

    int playerHP;
    String weapon, position, heroClass, heroExperience, attack, defense, hit;

    public static void main( String[] args ) {
        new App();
    }

    public App() {
        window = new JFrame();
        window.setSize(1000, 800); //Replace with equation to calculate map size?
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows you to exit game window
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true); //This ensure you make the window appear despite it not being visible above.
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
        startButton.setFocusPainted(false); //removes highlight around button when selected.
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
        option1.setFocusPainted(false);
        option1.setFont(choiceFont);
        option1.addActionListener(choiceHandler);
        option1.setActionCommand("c1");
        choiceButtonPanel.add(option1);

        //Button config for second option button.
        option2 = new JButton("East");
        option2.setBackground(Color.white);
        option2.setForeground(Color.black);
        option2.setFocusPainted(false);
        option2.setFont(choiceFont);
        option2.addActionListener(choiceHandler);
        option2.setActionCommand("c2");
        choiceButtonPanel.add(option2);

        //Button config for third option button.
        option3 = new JButton("South");
        option3.setBackground(Color.white);
        option3.setForeground(Color.black);
        option3.setFocusPainted(false);
        option3.setFont(choiceFont);
        option3.addActionListener(choiceHandler);
        option3.setActionCommand("c3");
        choiceButtonPanel.add(option3);

        //Button config for fourth option button.
        option4 = new JButton("West");
        option4.setBackground(Color.white);
        option4.setForeground(Color.black);
        option4.setFocusPainted(false);
        option4.setFont(choiceFont);
        option4.addActionListener(choiceHandler);
        option4.setActionCommand("c4");
        choiceButtonPanel.add(option4);

        heroStatusPanel = new JPanel();
        heroStatusPanel.setBounds(100, 15, 800, 50);
        heroStatusPanel.setBackground(Color.black);
        heroStatusPanel.setLayout(new GridLayout(1,7));
        con.add(heroStatusPanel);

        //HP stat label:
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(statFont);
        hpLabel.setForeground(Color.white);
        heroStatusPanel.add(hpLabel);

        //HP stat number:
        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(statFont);
        hpNumberLabel.setForeground(Color.white);
        heroStatusPanel.add(hpNumberLabel);

        //Weapons stat label:
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(statFont);
        weaponLabel.setForeground(Color.white);
        heroStatusPanel.add(weaponLabel);

        //Weapons stat number:
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(statFont);
        weaponNameLabel.setForeground(Color.white);
        heroStatusPanel.add(weaponNameLabel);

        //Hero class label:
        classLabel = new JLabel("Class:");
        classLabel.setFont(statFont);
        classLabel.setForeground(Color.white);
        heroStatusPanel.add(classLabel);

        //Hero class label:
        experienceLabel = new JLabel("XP:");
        experienceLabel.setFont(statFont);
        experienceLabel.setForeground(Color.white);
        heroStatusPanel.add(experienceLabel);
        playerSetup();

    }

    public void playerSetup() {
        playerHP = 100;
        heroClass = ;
        heroExperience = ;
        attack = ;
        defense = ;
        hit = ;
        weapon = swingy.weapon.getWeapon();
        weaponNameLabel.setText(weapon);
        hpNumberLabel.setText("" + playerHP);

        heroSelect();
    }

    public void heroSelect() {
        position = "Hero Select";

        storyArea.setText("Please select your Hero...");

        option1.setText("Witch Doctor");
        option2.setText("Demon Hunter");
        option3.setText("Crusader");
        option4.setText("Monk");
    }

    public void witchDoctor() {
        position = "witchDoctor";

        storyArea.setText("Ah... A Witch Doctor! We have been hoping for someone with your powers to help our town.\n If you're ready, let us begin...");

        option1.setText("Enter Whimsyshire");
        option2.setText("");
        option3.setText("");
        option4.setText("");
    }

    public void whimsyshire() {
        position = "whimsyshire";

        storyArea.setText("Hello stranger... \n You have entered the realm of Whimsyshire. \n Where would you like to go next?");

        option1.setText("North");
        option2.setText("South");
        option3.setText("East");
        option4.setText("West");
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){
            gameScreen();
        }

    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(position) {
                case "Hero Select":
                    switch (yourChoice) {
                        case "c1":
                            witchDoctor();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                    }
                    break;
            }

            switch(position) {
                    case "witchDoctor":
                        switch (yourChoice) {
                            case "c1": whimsyshire(); break;
                        }
            }
        }
    }
}