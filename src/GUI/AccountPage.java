package GUI;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AccountPage extends JFrame{
    JFrame accountFrame = new JFrame("Account");
    JFrame changePasswordPopup = new JFrame("Change Password");
    JFrame changeUsernamePopup = new JFrame("Change Username");
    JLabel oldPasswordLabel = new JLabel("Old Password:");
    JPasswordField oldPasswordField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password:");
    JPasswordField newPasswordField = new JPasswordField(30);
    JButton changePasswordConfirmButton = new JButton("Confirm");
    JLabel changePasswordErrorLabel = new JLabel("Invalid Password");
    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm");
    JLabel changeUsernameErrorLabel = new JLabel("Username must be between 3 and 20 characters long");
    JPanel accountPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<");
    JLabel accountHeader = new JLabel(HomePage.currentUser.getUsername() + "'s Account");
    JButton logoutButton = new JButton("Logout");
    JButton changePasswordButton = new JButton("Change Password");
    JButton changeUsernameButton = new JButton("Change Username");
    JButton deleteAccountButton = new JButton("Delete Account");
    AccountPage(){

        accountFrame.setSize(550, 650);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setIconImage(icon.getImage());
        accountFrame.setResizable(false);
        accountFrame.setLocationRelativeTo(null);
        accountFrame.add(accountPanel);

        accountPanel.setLayout(null);
        accountPanel.add(backButton);
        accountPanel.add(accountHeader);
        accountPanel.add(logoutButton);
        accountPanel.add(changePasswordButton);
        accountPanel.add(changeUsernameButton);
        accountPanel.add(deleteAccountButton);


        changePasswordPopup.setSize(400, 400);
        changePasswordPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePasswordPopup.setIconImage(icon.getImage());
        changePasswordPopup.setResizable(false);
        changePasswordPopup.add(oldPasswordLabel);
        changePasswordPopup.add(oldPasswordField);
        changePasswordPopup.add(newPasswordLabel);
        changePasswordPopup.add(newPasswordField);
        changePasswordPopup.add(changePasswordConfirmButton);
        changePasswordPopup.add(changePasswordErrorLabel);

        oldPasswordLabel.setBounds(50, 50, 100, 30);
        oldPasswordField.setBounds(150, 50, 200, 30);
        newPasswordLabel.setBounds(50, 100, 100, 30);
        newPasswordField.setBounds(150, 100, 200, 30);
        changePasswordConfirmButton.setBounds(150, 150, 100, 30);
        changePasswordPopup.setResizable(false);

        changePasswordErrorLabel.setVisible(false);

        backButton.addActionListener(e -> {
            new HomePage();
            accountFrame.dispose();
        });
        logoutButton.addActionListener(e -> {
            HomePage.status = false;
            new HomePage();
            accountFrame.dispose();
        });
        changePasswordButton.addActionListener(e -> {
            changePasswordPopup.setVisible(true);
        });
        deleteAccountButton.addActionListener(e -> {
            try {
                FileManager.deleteLine("Users.txt",
                        HomePage.currentUser.getUsername()
                                + " " + HomePage.currentUser.getEmail()
                                + " " + HomePage.currentUser.getPassword());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
            HomePage.status = false;
            new HomePage();
            accountFrame.dispose();
        });
        accountPanel.setBackground(Color.decode("#213D58"));
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);
        accountHeader.setBounds(200, 10, 200, 50);
        accountHeader.setFont(new Font("Arial", Font.BOLD, 20));
        accountHeader.setForeground(Color.LIGHT_GRAY);
        logoutButton.setBounds(200, 100, 150, 50);
        changeUsernameButton.setBounds(200, 200, 150, 50);
        changePasswordButton.setBounds(200, 300, 150, 50);
        deleteAccountButton.setBounds(200, 400, 150, 50);
        deleteAccountButton.setForeground(Color.RED);

        accountFrame.setVisible(true);
    }

}
