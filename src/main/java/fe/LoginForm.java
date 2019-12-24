package fe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import be.InitializerTelegramBot;
import utils.FileWorker;
import utils.Properties;

/**
 * Create UI form for input variables and login in the game
 */
public class LoginForm extends JFrame {

    private String[] chatIdNameToken = FileWorker.readTelegramDataFile();
    private JTextField chatIdField = new JTextField(chatIdNameToken[0], 20);
    private JTextField nameField = new JTextField(chatIdNameToken[1], 20);
    private JTextField tokenField = new JTextField(chatIdNameToken[2], 20);

    public LoginForm() {
        super("HappyNewYear");
        setBounds(800, 500, 450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Box chatIdBox = Box.createHorizontalBox();
        JLabel chatIdLabel = new JLabel("ChatId:");
        chatIdBox.add(chatIdLabel);
        chatIdBox.add(Box.createHorizontalStrut(6));
        chatIdBox.add(chatIdField);

        Box nameBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Name:");
        nameBox.add(nameLabel);
        nameBox.add(Box.createHorizontalStrut(6));
        nameBox.add(nameField);

        Box tokenBox = Box.createHorizontalBox();
        JLabel tokenLabel = new JLabel("Token:");
        tokenBox.add(tokenLabel);
        tokenBox.add(Box.createHorizontalStrut(6));
        tokenBox.add(tokenField);

        nameLabel.setPreferredSize(chatIdLabel.getPreferredSize());
        tokenLabel.setPreferredSize(chatIdLabel.getPreferredSize());

        Box buttonsBox = Box.createHorizontalBox();
        buttonsBox.add(Box.createHorizontalGlue());
        buttonsBox.add(Box.createHorizontalStrut(140));
        JButton startButton = new JButton("Start");
        buttonsBox.add(startButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(chatIdBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(nameBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(tokenBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(buttonsBox);
        setContentPane(mainBox);
        pack();

        this.getRootPane().setDefaultButton(startButton);

        startButton.addActionListener(new ButtonStartListener());
        startButton.addActionListener(e -> this.dispose());
    }

    class ButtonStartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Properties.setChatId(chatIdField.getText());
            Properties.setBotUsername(nameField.getText());
            Properties.setBotToken(tokenField.getText());

            InitializerTelegramBot.startTelegramBot();
        }
    }

}

