package GUI;

import Controllers.RegisterControl;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;

public class AccountPage extends JFrame {
    JFrame accountFrame = new JFrame("Account");
    JFrame changePasswordPopup = new JFrame("Change Password");
    JFrame changeUsernamePopup = new JFrame("Change Username");
    JLabel validatePasswordLabel = new JLabel("Your Password:");
    JPasswordField validatePasswordField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password:");
    JPasswordField newPasswordField = new JPasswordField(30);
    JButton changePasswordConfirmButton = new JButton("Confirm");
    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm");
    JPanel accountPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<");
    JLabel accountHeader = new JLabel(HomePage.currentUser.getUsername() + "'s Account");
    JButton logoutButton = new JButton("Logout");
    JButton changePasswordButton = new JButton("Change Password");
    JButton changeUsernameButton = new JButton("Change Username");
    JButton deleteAccountButton = new JButton("Delete Account");
    JLabel passwordError = new JLabel("Password is incorrect");
    JLabel usernameError = new JLabel("invalid username");


    AccountPage() {
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
        if(!changePasswordPopup.isFocusOwner()){
            changePasswordPopup.dispose();
        }

        changeUsernamePopup.setSize(400, 400);
        changeUsernamePopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changeUsernamePopup.setIconImage(icon.getImage());
        changeUsernamePopup.setResizable(false);
        changeUsernamePopup.add(validatePasswordLabel);
        changeUsernamePopup.add(validatePasswordField);
        changeUsernamePopup.add(ChangeUsernameLabel);
        changeUsernamePopup.add(ChangeUsernameField);
        changeUsernamePopup.add(changeUsernameConfirmButton);
        changeUsernamePopup.add(usernameError);
        changeUsernamePopup.setLocationRelativeTo(null);

        changePasswordPopup.setSize(400, 400);
        changePasswordPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePasswordPopup.setIconImage(icon.getImage());
        changePasswordPopup.setResizable(false);
        changePasswordPopup.add(validatePasswordLabel);
        changePasswordPopup.add(validatePasswordField);
        changePasswordPopup.add(newPasswordLabel);
        changePasswordPopup.add(newPasswordField);
        changePasswordPopup.add(changePasswordConfirmButton);
        changePasswordPopup.add(passwordError);
        changePasswordPopup.setLocationRelativeTo(null);

        validatePasswordLabel.setBounds(50, 50, 100, 30);
        validatePasswordField.setBounds(150, 50, 200, 30);
        ChangeUsernameLabel.setBounds(50, 100, 100, 30);
        ChangeUsernameField.setBounds(150, 100, 200, 30);
        changeUsernameConfirmButton.setBounds(150, 150, 100, 30);
        usernameError.setBounds(150, 200, 200, 30);
        usernameError.setVisible(false);
        changeUsernamePopup.setResizable(false);


        validatePasswordLabel.setBounds(50, 50, 100, 30);
        validatePasswordField.setBounds(150, 50, 200, 30);
        newPasswordLabel.setBounds(50, 100, 100, 30);
        newPasswordField.setBounds(150, 100, 200, 30);
        changePasswordConfirmButton.setBounds(150, 150, 100, 30);
        passwordError.setBounds(150, 200, 200, 30);
        passwordError.setVisible(false);
        changePasswordPopup.setResizable(false);



        backButton.addActionListener(e -> {
            new HomePage();
            accountFrame.dispose();
        });
        logoutButton.addActionListener(e -> {
            HomePage.status = false;
            new HomePage();
            accountFrame.dispose();
        });
        changeUsernameButton.addActionListener(e -> changeUsernamePopup.setVisible(true));
        changeUsernameConfirmButton.addActionListener(e -> {
            if(!status){
                changeUsernamePopup.setVisible(false);
            }
            String oldUser = currentUser.toString();
            if(currentUser.getPassword().equals(String.valueOf
                    (validatePasswordField.getPassword())) &&
                    RegisterControl.ValidateUsername(ChangeUsernameField.getText())){
                usernameError.setVisible(false);
                currentUser.setUsername(ChangeUsernameField.getText());
                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }
                changeUsernamePopup.dispose();
            }
            else{
                usernameError.setVisible(true);
            }
        });
        changePasswordButton.addActionListener(e -> changePasswordPopup.setVisible(true));
        changePasswordConfirmButton.addActionListener(e -> {
            if(!status){
                changePasswordPopup.setVisible(false);
            }
            String oldUser = currentUser.toString();
            if (currentUser.getPassword().equals(String.valueOf(validatePasswordField.getPassword()))&&
                    RegisterControl.ValidatePassword(String.valueOf(newPasswordField.getPassword()))) {
                passwordError.setVisible(false);
                currentUser.setPassword(String.valueOf(newPasswordField.getPassword()));
                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }
                changePasswordPopup.dispose();
            }
            else {
                passwordError.setVisible(true);
            }
        });
        deleteAccountButton.addActionListener(e -> {
            try {
                FileManager.deleteLine("Users.txt", currentUser.toString());
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
