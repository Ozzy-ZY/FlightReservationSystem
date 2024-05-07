package GUI;
import Controllers.RegisterControl;
import Models.User;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static Controllers.SessionControl.generateToken;
import static Controllers.SessionControl.removeToken;
import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;
public class ChangeUser extends JFrame{

    ImageIcon icon = new ImageIcon("Assets/logo.png");


    JFrame changeUsernamePopup = new JFrame("Change Username");

    JLabel accountHeader = new JLabel(HomePage.currentUser.getUsername() + "'s Account");

    JPanel mainPanel = new JPanel (null);
    JLabel header = new JLabel ("Reset Username");
    JLabel mainTxt = new JLabel ("Change your Username");
    JLabel validatePasswordLabel = new JLabel("Your Password:");
    JPasswordField validatePasswordField = new JPasswordField(30);

    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm");
    JLabel usernameError = new JLabel("invalid username");


    public ChangeUser() {
        changeUsernamePopup.setTitle ( "Change Usernam" );
        changeUsernamePopup.setSize(500, 580);
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

        mainPanel = new JPanel(null);
        header = new JLabel("Reset Username");
        mainTxt = new JLabel ("Change your Username");

        mainPanel.add ( mainTxt );
        mainPanel.add(validatePasswordLabel);
        mainPanel.add(validatePasswordField);
        mainPanel.add(ChangeUsernameLabel);
        mainPanel.add(ChangeUsernameField);

        mainPanel.add(changeUsernameConfirmButton);

        changeUsernamePopup.add(mainPanel);

        mainPanel.setBounds ( 0,0,500,580 );
        mainPanel.setBackground ( Color.decode ( "#ffffff" ) );

        mainTxt.setBounds ( 20,5,450,90 );
        mainTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 25 ) );
        mainTxt.setForeground ( Color.decode("#0B3E91") );

        validatePasswordLabel.setBounds(80, 100,180,validatePasswordLabel.getMinimumSize().height);
        validatePasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD, 14 ) );
        validatePasswordField.setBounds(70, 130, 350, 30);
        ChangeUsernameLabel.setBounds(80, 180, 300, 50);
        ChangeUsernameLabel.setForeground ( Color.decode ( "#05203C" ) );
        ChangeUsernameLabel.setFont ( new Font ( "SansSerif", Font.BOLD, 14 ) );
        ChangeUsernameField.setBounds(70,240,350,30);
        changeUsernameConfirmButton.setBounds(150, 300, 170, 40);
        changeUsernameConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        changeUsernameConfirmButton.setForeground ( Color.decode("#0B3E91") );
        changeUsernameConfirmButton.setBackground ( Color.decode ( "#ffffff" ) );



        changeUsernamePopup.addWindowListener(new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                AccountPage.accountFrame.setEnabled ( true );
            }
        });

        changeUsernameConfirmButton.addActionListener(e -> {
            AccountPage.accountFrame.setEnabled(true);

            if (!status) {
                changeUsernamePopup.setVisible(false);

            }
            String oldUser = currentUser.toString();
            if (currentUser.getPassword().equals(String.valueOf
                    (validatePasswordField.getPassword())) &&
                    RegisterControl.ValidateUsername(ChangeUsernameField.getText())) {
                usernameError.setVisible(false);
                currentUser.setUsername(ChangeUsernameField.getText());
                removeToken();
                User afterUpdate= new User(currentUser.getEmail(),ChangeUsernameField.getText(),currentUser.getPassword());
                generateToken(afterUpdate);

                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                    FileManager.replaceLines("token.txt", oldUser, currentUser.toString());

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }


                accountHeader.setText(currentUser.getUsername() + "'s Account");
                AccountPage.accountFrame.repaint();
                AccountPage.accountFrame.revalidate ();
                changeUsernamePopup.dispose();
                AccountPage.accountFrame.setEnabled ( true );
            } else {
                usernameError.setVisible(true);
            }
        });

        changeUsernamePopup.setVisible(true);
    }

    public static void main(String[] args) {
        new ChangeUser();
    }
}