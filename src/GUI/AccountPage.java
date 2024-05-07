package GUI;

import Controllers.RegisterControl;
import Models.User;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Controllers.SessionControl;
import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;
import static Controllers.SessionControl.*;


public class AccountPage extends JFrame {

    static User user;
    static JFrame accountFrame = new JFrame("Account");


    JPanel accountPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/logo.png");

    ImageIcon logoIcon = new ImageIcon("Assets/image-removebg-preview.png");

    ImageIcon scaledLogo = new ImageIcon(logoIcon.getImage().
            getScaledInstance(190, 80, Image.SCALE_SMOOTH));
    JLabel logo = new JLabel (scaledLogo);
    JButton backButton = new JButton("<");
    JLabel accountHeader = new JLabel(HomePage.currentUser.getUsername() + "'s Account");

    JLabel logoutButton = new JLabel("Logout");


    ImageIcon pencil = new ImageIcon("Assets/pen-to-square-regular.png");
    ImageIcon scaledPencil = new ImageIcon(pencil.getImage().
            getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    JLabel changeUsernameButton = new JLabel(scaledPencil);

    ImageIcon password = new ImageIcon("Assets/key-solid.png");
    ImageIcon scaledPassword = new ImageIcon(password.getImage().
            getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    JLabel changePasswordButton = new JLabel(scaledPassword);

    JLabel info = new JLabel ("Account Information");

    JLabel usernameTxt = new JLabel ("Username");

    JTextField username = new JTextField ( HomePage.currentUser.getUsername ());

    JLabel passwordTxt = new JLabel ("password");
    JPasswordField userPassword = new JPasswordField (HomePage.currentUser.getPassword ());

    JLabel personal = new JLabel ("Personal Details");

    JLabel fNameTxt = new JLabel ("First Name");
    JTextField fName = new JTextField ();

    JLabel lNameTxt = new JLabel ("Last Name");
    JTextField lName = new JTextField ();

    JLabel passIDTxt = new JLabel ("Passport ID");
    JTextField passID = new JTextField ();

    JLabel noText = new JLabel ("Phone number");
    JTextField number = new JTextField ();

    JButton saveChanges = new JButton ("Save Changes");

    JLabel delTxt = new JLabel ("Delete Your Account");

    JLabel delLabel = new JLabel("<html>Click ACCOUNT DELETE to start the process of permanently deleting your RIHLA Flights account including all personal information, flights and tickets. <br> Once your RIHLA flights account is deleted, your wallet balance will be permanently deleted as well.");
    JButton deleteAccountButton = new JButton ("ACCOUNT DELETE");

    JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);



    AccountPage() {
        accountFrame.setSize(800, 950);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setIconImage(icon.getImage());
        accountFrame.setResizable(false);
        accountFrame.setLocationRelativeTo(null);
        accountFrame.add(accountPanel);

        accountPanel.setLayout(null);
        accountPanel.add(backButton);
        accountPanel.add(accountHeader);
        accountPanel.add(logoutButton);
        accountPanel.add(logo);
        accountPanel.add(changePasswordButton);
        accountPanel.add(changeUsernameButton);
        accountPanel.add(deleteAccountButton);
        accountPanel.add(info);
        accountPanel.add(usernameTxt);
        accountPanel.add(username);
        accountPanel.add(passwordTxt);
        accountPanel.add(userPassword);
        accountPanel.add(personal);
        accountPanel.add(fNameTxt);
        accountPanel.add(fName);
        accountPanel.add(lNameTxt);
        accountPanel.add(lName);
        accountPanel.add(passIDTxt);
        accountPanel.add(passID);
        accountPanel.add(noText);
        accountPanel.add(number);
        accountPanel.add(splitPane1);
        accountPanel.add(splitPane2);
        accountPanel.add(splitPane3);
        accountPanel.add(saveChanges);
        accountPanel.add(delTxt);
        accountPanel.add(delLabel);
        accountPanel.add(deleteAccountButton);


        backButton.addActionListener(e -> {
            new HomePage();
            accountFrame.dispose();
        });

        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(tokenExists()){
                    removeToken();
                }
                new HomePage();
                accountFrame.dispose();
            }
        });

        changeUsernameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                new ChangeUser ();
                accountFrame.setEnabled(false);

            }
        });

        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new ChangePassword ();
                accountFrame.setEnabled(false);
            }
        });

        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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


        accountPanel.setBackground(Color.decode("#ffffff"));

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        accountHeader.setBounds(70, 50, 400, 80);
        accountHeader.setFont(new Font("SansSerif", Font.BOLD, 30));
        accountHeader.setForeground(Color.decode ( "#05203C" ));

        logoutButton.setBounds(70, 100, 150, 50);
        logoutButton.setFont ( new Font("SansSerif",Font.BOLD,15) );
        logoutButton.setForeground ( Color.decode ( "#db3125" ) );

        logo.setBounds ( 550,70,190,80 );

        info.setBounds ( 70, 160,400,40 );
        info.setFont ( new Font ( "SansSerif", Font.BOLD, 23 ) );
        info.setForeground ( Color.decode ( "#0B3E91" ) );

        splitPane1.setBounds(70,200,640,3);

        usernameTxt.setBounds ( 70,210,400,40 );
        usernameTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        usernameTxt.setForeground ( Color.decode ( "#05203C" ) );
        username.setBounds ( 70, 245,270,40);
        username.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        username.setEditable(false);
        changeUsernameButton.setBounds(340, 245, 40, 40);


        passwordTxt.setBounds ( 410,210,400,40 );
        passwordTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        passwordTxt.setForeground ( Color.decode ( "#05203C" ) );
        userPassword.setBounds ( 410, 245,270,40);
        userPassword.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        userPassword.setEditable(false);
        changePasswordButton.setBounds(680, 245, 40, 40);

        personal.setBounds ( 70, 300,400,40 );
        personal.setFont ( new Font ( "SansSerif", Font.BOLD, 23 ) );
        personal.setForeground ( Color.decode ( "#0B3E91" ) );

        splitPane2.setBounds(70,340,640,3);

        fNameTxt.setBounds ( 70,350,400,40 );
        fNameTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        fNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        fName.setBounds ( 70, 385,300,40);
        fName.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        lNameTxt.setBounds ( 410,350,400,40 );
        lNameTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        lNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        lName.setBounds ( 410, 385,300,40);
        lName.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        passIDTxt.setBounds ( 70,430,400,40 );
        passIDTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        passIDTxt.setForeground ( Color.decode ( "#05203C" ) );
        passID.setBounds ( 70, 465,640,40);
        passID.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        noText.setBounds ( 70,510,400,40 );
        noText.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        noText.setForeground ( Color.decode ( "#05203C" ) );
        number.setBounds ( 70, 545,640,40);
        number.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        saveChanges.setBounds(70, 600, 640, 40);
        saveChanges.setFont(new Font("Arial", Font.BOLD, 18));
        saveChanges.setForeground ( Color.white );
        saveChanges.setBackground ( Color.decode ( "#0B3E91" ) );

        delTxt.setBounds ( 70, 660,400,40 );
        delTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 23 ) );
        delTxt.setForeground ( Color.decode ( "#DE3341" ) );

        splitPane3.setBounds(70,700,640,3);

        delLabel.setBounds ( 70,710,640,80 );
        delLabel.setFont ( new Font ( "SansSerif", Font.PLAIN, 16 ) );
        delLabel.setForeground ( Color.decode ( "#5555555" ) );

        deleteAccountButton.setBounds(70, 810, 200, 40);
        deleteAccountButton.setFont(new Font("Arial", Font.BOLD, 15));
        deleteAccountButton.setForeground ( Color.white );
        deleteAccountButton.setBackground ( Color.decode ( "#DE3341" ) );


        accountFrame.setVisible(true);
    }


}