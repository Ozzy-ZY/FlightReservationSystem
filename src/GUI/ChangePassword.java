package GUI;

import Controllers.RegisterControl;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static Controllers.SessionControl.generateToken;
import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;

public class ChangePassword extends JFrame {
    JFrame changePasswordPopup = new JFrame("Change Password");

    JPanel leftPanel = new JPanel ();
    JPanel rightPanel = new JPanel ();

    JLabel mainTxt = new JLabel ("Change your password");

    JLabel header = new JLabel ("Reset Password");
    JLabel validatePasswordLabel = new JLabel("Old Password");
    JPasswordField validatePasswordField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password");
    JPasswordField newPasswordField = new JPasswordField(30);
    JLabel confirmNewPasswordLabel = new JLabel("Confirm Password");
    JPasswordField confirmNewPasswordField = new JPasswordField(30);
    JCheckBox showPassword = new JCheckBox ("Show Password");

    JButton changePasswordConfirmButton = new JButton("Confirm");

    JLabel passwordError = new JLabel("Password is incorrect!");
    ImageIcon icon = new ImageIcon("Assets/logo.png");
    ImageIcon scaledLogo = new ImageIcon(icon.getImage().
            getScaledInstance(90, 70, Image.SCALE_SMOOTH));

    JLabel logo = new JLabel (scaledLogo);


    ImageIcon password = new ImageIcon("Assets/changepassword.png");
    ImageIcon scaledPassword = new ImageIcon(password.getImage().
            getScaledInstance(450, 320, Image.SCALE_SMOOTH));
    JLabel passwordImg = new JLabel (scaledPassword);



    ChangePassword(){

        changePasswordPopup.setLayout ( null );
        changePasswordPopup.setSize(800, 500);
        changePasswordPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePasswordPopup.setIconImage(icon.getImage());
        changePasswordPopup.setResizable(false);
        changePasswordPopup.setLocationRelativeTo(null);
        changePasswordPopup.setResizable(false);

        changePasswordPopup.add(leftPanel);
        leftPanel.setLayout ( null );
        leftPanel.add(passwordImg);
        leftPanel.add ( mainTxt );

        changePasswordPopup.add(rightPanel);
        rightPanel.setLayout ( null );
        rightPanel.add(logo);
        rightPanel.add(header);
        rightPanel.add(validatePasswordLabel);
        rightPanel.add(validatePasswordField);
        rightPanel.add(newPasswordLabel);
        rightPanel.add(newPasswordField);
        rightPanel.add(changePasswordConfirmButton);
        rightPanel.add(passwordError);
        rightPanel.add(confirmNewPasswordLabel);
        rightPanel.add(confirmNewPasswordField);
        rightPanel.add(showPassword);


        leftPanel.setBounds ( 0,0,400,500 );
        leftPanel.setBackground ( Color.decode ( "#0B3E91" ) );

        passwordImg.setBounds ( 00,10,450,320 );
        mainTxt.setBounds ( 60,310,400,80 );
        mainTxt.setFont ( new Font ( "SansSerif", Font.BOLD , 25 ) );
        mainTxt.setForeground ( Color.white );

        rightPanel.setBounds ( 400,0,400,500 );
        rightPanel.setBackground ( Color.decode ( "#ffffff" ) );
        logo.setBounds ( 150 ,10,90,70);
        header.setBounds (120, 70,300,50 );
        header.setForeground ( Color.decode ( "#05203C" ) );
        header.setFont ( new Font ( "SansSerif", Font.BOLD , 20 ) );
        validatePasswordLabel.setBounds(50, 120, 100, 50);
        validatePasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        validatePasswordField.setBounds(50, 160, 300, 30);
        newPasswordLabel.setBounds(50, 190, 300, 50);
        newPasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        newPasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        newPasswordField.setBounds(50, 230, 300, 30);
        confirmNewPasswordLabel.setBounds(50, 260, 300, 50);
        confirmNewPasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        confirmNewPasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        confirmNewPasswordField.setBounds(50, 300, 300, 30);
        showPassword.setBounds ( 50,330,300,30 );
        showPassword.setOpaque(false);
        passwordError.setBounds ( 130,350,300,30 );
        passwordError.setForeground ( Color.decode ( "#db3125" ) );
        changePasswordConfirmButton.setBounds(50, 375, 300, 40);
        changePasswordConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        changePasswordConfirmButton.setForeground ( Color.white );
        changePasswordConfirmButton.setBackground ( Color.decode ( "#0B3E91" ) );
        passwordError.setVisible(false);


        showPassword.addActionListener(e -> {
            boolean showPassword = ((JCheckBox) e.getSource()).isSelected();
            toggleFieldType(showPassword);
        });

        changePasswordConfirmButton.addActionListener(e -> {
            validatePasswordField.setEchoChar('*');
            newPasswordField.setEchoChar('*');
            confirmNewPasswordField.setEchoChar('*');
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

        changePasswordPopup.setVisible ( true );
    }

    private void toggleFieldType(boolean showPassword) {
        if (showPassword) {
            validatePasswordField.setEchoChar('\u0000');
            newPasswordField.setEchoChar('\u0000');
            confirmNewPasswordField.setEchoChar('\u0000');
        } else {
            validatePasswordField.setEchoChar('*');
            newPasswordField.setEchoChar('*');
            confirmNewPasswordField.setEchoChar('*');
        }
    }

    public static void main(String[] args) {
        new ChangePassword ();
    }
}
