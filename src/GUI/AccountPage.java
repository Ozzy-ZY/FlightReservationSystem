package GUI;

import Controllers.RegisterControl;
import Models.User;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;
import static Controllers.SessionControl.*;

public class AccountPage extends JFrame {

    static User user;
    JFrame accountFrame = new JFrame("Account");

    JFrame changePasswordPopup = new JFrame("Change Password");
    JFrame changeUsernamePopup = new JFrame("Change Username");
    JLabel validatePasswordLabel = new JLabel("Your Password:");
    JPasswordField validatePasswordField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password:");
    JPasswordField newPasswordField = new JPasswordField(30);
    JLabel confirmNewPasswordLabel = new JLabel("Confirm:");
    JPasswordField confirmNewPasswordField = new JPasswordField(30);

    JButton changePasswordConfirmButton = new JButton("Confirm");
    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm");
    JPanel accountPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/logo.png");
    JButton backButton = new JButton("<");
    JLabel accountHeader = new JLabel(HomePage.currentUser.getUsername() + "'s Account");

    JLabel logoutButton = new JLabel("Logout");

    ImageIcon icone = new ImageIcon("cloud.png");

    JLabel passwordError = new JLabel("Password is incorrect");
    JLabel usernameError = new JLabel("invalid username");

    JLabel mailTxt = new JLabel ("E-MAIL");
    JLabel mail = new JLabel ( "<html>"+currentUser.getEmail()+"</html>");

    ImageIcon delete = new ImageIcon("Assets/trash-can-regular.png");
    ImageIcon scaledDel = new ImageIcon(delete.getImage().
            getScaledInstance(20, 25, Image.SCALE_SMOOTH));
    JLabel deleteAccountButton = new JLabel(scaledDel);

    ImageIcon pencil = new ImageIcon("Assets/pen-to-square-regular.png");
    ImageIcon scaledPencil = new ImageIcon(pencil.getImage().
            getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    JLabel changeUsernameButton = new JLabel(scaledPencil);

    ImageIcon password = new ImageIcon("Assets/key-solid.png");
    ImageIcon scaledPassword = new ImageIcon(password.getImage().
            getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    JLabel changePasswordButton = new JLabel(scaledPassword);


    AccountPage() {
        accountFrame.setSize(800, 400);
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
        accountPanel.add(mailTxt);
        accountPanel.add(mail);

        if (!changePasswordPopup.isFocusOwner()) {
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
        changePasswordPopup.add(confirmNewPasswordLabel);
        changePasswordPopup.add(confirmNewPasswordField);
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
        confirmNewPasswordLabel.setBounds(50, 200, 100, 30);
        confirmNewPasswordField.setBounds(150, 200, 250, 40);
        passwordError.setVisible(false);
        changePasswordPopup.setResizable(false);


        backButton.addActionListener(e -> {
            new HomePage();
            accountFrame.dispose();
        });
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(tokenExists()){
                    removeToken();
                }
                status = false;
                new HomePage();
                accountFrame.dispose();
            }
        });
        changeUsernameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                changeUsernamePopup.setVisible(true);
            }
        });
        changeUsernameConfirmButton.addActionListener(e -> {
            if (!status) {
                changeUsernamePopup.setVisible(false);
            }
            String oldUser = currentUser.toString();
            if (currentUser.getPassword().equals(String.valueOf
                    (validatePasswordField.getPassword())) &&
                    RegisterControl.ValidateUsername(ChangeUsernameField.getText())) {
                usernameError.setVisible(false);
                currentUser.setUsername(ChangeUsernameField.getText());
                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }
                changeUsernamePopup.dispose();
            } else {
                usernameError.setVisible(true);
            }
        });

        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                changePasswordPopup.setVisible(true);
            }
        });
        changePasswordConfirmButton.addActionListener(e -> {
            if (!status) {
                changePasswordPopup.setVisible(false);
            }
            String oldUser = currentUser.toString();
            if (currentUser.getPassword().equals(String.valueOf(validatePasswordField.getPassword())) &&
                    RegisterControl.ValidatePassword(String.valueOf(newPasswordField.getPassword())))
            {
                passwordError.setVisible(false);
                currentUser.setPassword(String.valueOf(newPasswordField.getPassword()));
                generateToken(currentUser);
                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }
                changePasswordPopup.dispose();
            } else {
                passwordError.setVisible(true);
            }
        });
        deleteAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    FileManager.deleteLine("Users.txt",
                            HomePage.currentUser.getUsername()
                                    + " " + HomePage.currentUser.getEmail()
                                    + " " + HomePage.currentUser.getPassword());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }
                removeToken();
                new HomePage();
                accountFrame.dispose();
            }
        });

        try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the format in Users.txt is: username email password
                String[] parts = line.split("\\s+"); // Split by one or more spaces
                if (parts.length >= 3) {
                    String username = parts[0].trim(); // Store the username to pass it into the quiz list label
                    String storedEmail = parts[1].trim();
                    String storedPassword = parts[2].trim();


                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }

        accountPanel.setBackground(Color.decode("#f8f8f8"));
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);
        accountHeader.setBounds(80, 50, 400, 80);
        accountHeader.setFont(new Font("SansSerif", Font.BOLD, 30));
        accountHeader.setForeground(Color.decode ( "#05203C" ));
        logoutButton.setBounds(80, 100, 150, 50);
        logoutButton.setFont ( new Font("SansSerif",Font.BOLD,15) );
        logoutButton.setForeground ( Color.decode ( "#db3125" ) );
        changeUsernameButton.setBounds(500, 70, 25, 25);
        changePasswordButton.setBounds(550, 70, 25, 25);
        deleteAccountButton.setBounds(600, 70, 20, 25);
        mailTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 13 ) );
        mailTxt.setForeground ( Color.decode ( "#FD9426" ) );
        mailTxt.setBounds ( 80,250,150,20 );
        mail.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        mail.setForeground ( Color.decode ( "#05203C" ) );
        mail.setBounds ( 80,270,150,20 );


        accountFrame.setVisible(true);
    }


}
