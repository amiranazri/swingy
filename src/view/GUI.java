import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GUI {
    JFrame window;
    Container container;
    JPanel titlePanel, consolePanel, startButtonPanel, heroSelectPanel, heroStatusPanel, choiceButtonPanel, playerPanel;
    JLabel titleLabel, classLabel, nameLabel, xpLabel, attackLabel, defenseLabel, hitLabel;
    
    JButton startButton, consoleSelectButton, guiSelectButton, choice1, choice2, choice3, choice4;
    JTextArea heroSelectArea, whimsyArea;

    Font titleFont = new Font("Amatic SC", Font.PLAIN, 70);
    Font bodyFont = new Font("Calibri", Font.PLAIN, 12);
    Font storyFont = new Font("Orange Kid", Font.PLAIN, 40);
    Font choiceFont = new Font("Minecraftia", Font.PLAIN, 15);
    Font statFont = new Font("Minecraftia", Font.PLAIN, 18);

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    int playerHP, attack, heroExperience, defense, hit;
    String weapon, position, heroClass;

    public static void main(String[] args) {
        System.out.println("Please select game mode:\n" + "Type Console for Console or GUI for GUI");
        Scanner scanner = new Scanner(System.in);
        String modeSelected = scanner.nextLine();

        if (modeSelected.equals("Console") || modeSelected.equals("console")) {
            System.out.println("WE WILL MAKE CONSOLE LATER BISH");
        }
        else {
            new GUI();
        }
        scanner.close();
    }

    public GUI() {
        window = new JFrame();
        window.setSize(1000, 800); //Replace with equation to calculate map size?
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows you to exit game window
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true); //This ensure you make the window appear despite it not being visible above.
        container = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);

        titleLabel = new JLabel("Whimsyshire");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350, 250, 100, 50);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start Adventure");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(bodyFont);
        startButton.setFocusPainted(false); //removes highlight around button when selected.
        startButton.addActionListener(tsHandler);
        
        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        container.add(titlePanel);
        container.add(startButtonPanel);

    }

    public void createGameScreen() {

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        heroSelectPanel = new JPanel();
        heroSelectPanel.setBounds(100, 100, 600, 250);;
        heroSelectPanel.setBackground(Color.black);
        container.add(heroSelectPanel);

        heroSelectArea = new JTextArea("Welcome to Whimsyshire. Please select your hero:");
        heroSelectArea.setBounds(100, 100, 600, 250);
        heroSelectArea.setBackground(Color.black);
        heroSelectArea.setForeground(Color.white);
        heroSelectArea.setFont(storyFont);
        heroSelectArea.setLineWrap(true);
        heroSelectPanel.add(heroSelectArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        choiceButtonPanel.setBackground(Color.black);
        container.add(choiceButtonPanel);

        // Button config for first option button.
        choice1 = new JButton("Witch Doctor");
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFocusPainted(false);
        choice1.setFont(choiceFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        //Button config for second option button.
        choice2 = new JButton("Demon Hunter");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFocusPainted(false);
        choice2.setFont(choiceFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        //Button config for third option button.
        choice3 = new JButton("Crusader");
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFocusPainted(false);
        choice3.setFont(choiceFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        //Button config for fourth option button.
        choice4 = new JButton("Monk");
        choice4.setBackground(Color.white);
        choice4.setForeground(Color.black);
        choice4.setFocusPainted(false);
        choice4.setFont(choiceFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        // Hero status bar container
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        container.add(playerPanel);

        classLabel = new JLabel("Class:");
        classLabel.setFont(statFont);
        classLabel.setForeground(Color.white);
        playerPanel.add(classLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(statFont);
        nameLabel.setForeground(Color.white);
        playerPanel.add(nameLabel);

        xpLabel = new JLabel("XP:");
        xpLabel.setFont(statFont);
        xpLabel.setForeground(Color.white);
        playerPanel.add(xpLabel);

        attackLabel = new JLabel("ATK:");
        attackLabel.setFont(statFont);
        attackLabel.setForeground(Color.white);
        playerPanel.add(attackLabel);

        classLabel = new JLabel("Class:");
        classLabel.setFont(statFont);
        classLabel.setForeground(Color.white);
        playerPanel.add(classLabel);

        defenseLabel = new JLabel("DEF:");
        defenseLabel.setFont(statFont);
        defenseLabel.setForeground(Color.white);
        playerPanel.add(defenseLabel);

        hitLabel = new JLabel("Hit:");
        hitLabel.setFont(statFont);
        hitLabel.setForeground(Color.white);
        playerPanel.add(hitLabel);

        // playerSetup();
    }

    // public void playerSetup() {
        
    // }

    public void whimsyshire() {
        position = "whimsyshire";

        whimsyArea.setText("You have entered the realm of Whimsyshire. \n Where would you like to go next?");

        choice1.setText("North");
        choice2.setText("South");
        choice3.setText("East");
        choice4.setText("West");
    }

    public void crusader() {
        position = "crusader";

        heroSelectArea.setText("Ah... A Crusader! We have been hoping for someone with your powers to help our town.\n If you're ready, let us begin...");

        choice1.setText("Enter Whimsyshire");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void demonHunter() {
        position = "demonHunter";

        heroSelectArea.setText("Ah... A Demon Hunter! We have been hoping for someone with your powers to help our town.\n If you're ready, let us begin...");

        choice1.setText("Enter Whimsyshire");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monk() {
        position = "monk";

        heroSelectArea.setText("Ah... A Monk! We have been hoping for someone with your powers to help our town.\n If you're ready, let us begin...");

        choice1.setText("Enter Whimsyshire");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void witchDoctor() {
        position = "witchDoctor";

        heroSelectArea.setText("Ah... A Witch Doctor! We have been hoping for someone with your powers to help our town.\n If you're ready, let us begin...");

        choice1.setText("Enter Whimsyshire");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            if (yourChoice.equals("c1")) {
                witchDoctor();
            }
            if (yourChoice.equals("c2")) {
                demonHunter();
            }
            if (yourChoice.equals("c3")) {
                crusader();
            }
            if (yourChoice.equals("c4")) {
                monk();
            }
            if (yourChoice.equals("c5")) {
                whimsyshire();
            }
        }
    }

    // classLabel, nameLabel, xpLabel, attackLabel, defenseLabel, hitLabel
    public void saveGame() {
        String witchDoctor = "Name: Bambara Class: Witch Doctor HP: 100";
        writer.storeMessage(witchDoctor);

    }
}