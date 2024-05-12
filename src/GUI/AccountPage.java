package GUI;

import Controllers.RegisterControl;
import Controllers.PassengerControl;
import Controllers.ThemeManager;
import Models.User;
import Utils.FileManager;
import Utils.RoundedBorder;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import static Controllers.SessionControl.*;
import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;


public class AccountPage extends JFrame {

    static User user;

    boolean[] totalStatus = {false, false, false,false};

    JFrame accountFrame = new JFrame("Account");

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
    JLabel errorFName = new JLabel("Invalid Name");

    JLabel errorLName = new JLabel("Invalid Name");

    JLabel errorPassport = new JLabel("Invalid valid passport");

    JLabel errorNumber = new JLabel("Invalid phone number");
    JTextField fName = new JTextField (PassengerControl.getFirstname ( currentUser.getEmail () ) );

    JLabel lNameTxt = new JLabel ("Last Name");
    JTextField lName = new JTextField (PassengerControl.getLastname ( currentUser.getEmail () ));

    JLabel passIDTxt = new JLabel ("Passport ID");
    JTextField passID = new JTextField (PassengerControl.getPassportID ( currentUser.getEmail () ));

    JLabel noText = new JLabel ("Phone number");
    JTextField number = new JTextField (PassengerControl.getPhoneNumber ( currentUser.getEmail () ));

    JButton saveChanges = new JButton ("Save Changes");

    JLabel delTxt = new JLabel ("Delete Your Account");

    JLabel delLabel = new JLabel("<html>Click ACCOUNT DELETE to start the process of permanently" +
            " deleting your RIHLA Flights account including all personal" +
            " information, flights and tickets. <br> Once your RIHLA " +
            "flights account is deleted, your wallet balance will be" +
            " permanently deleted as well.");
    JButton deleteAccountButton = new JButton ("ACCOUNT DELETE");

    JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);


    // CHANGE USERNAME FRAME VARIABLES
    JFrame changeUsernamePopup = new JFrame("Change Username");
    JPanel mainPanel = new JPanel (null);

    JLabel changeUserNote = new JLabel ("<html>*Note: This will update your login" +
            " username on our application for all future logins.");

    JLabel mainTxt = new JLabel ("Change your Username");
    JLabel validatePasswordLabel = new JLabel("Your Password:");
    JPasswordField validatePasswordField = new JPasswordField(30);

    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm Changes");
    JLabel usernameError = new JLabel("invalid username");

    JSplitPane userSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    // CHANGE PASSWORD FRAME VARIABLES
    JFrame changePasswordPopup = new JFrame("Change Password");

    JPanel leftPanel = new JPanel ();
    JPanel rightPanel = new JPanel ();

    JLabel passwordMainTxt = new JLabel ("Change your password");

    JLabel passwordHeader = new JLabel ("Reset Password");
    JLabel validatePasswordPopupLabel = new JLabel("Old Password");
    JPasswordField validatePasswordPopupField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password");
    JPasswordField newPasswordField = new JPasswordField(30);
    JLabel confirmNewPasswordLabel = new JLabel("Confirm Password");
    JPasswordField confirmNewPasswordField = new JPasswordField(30);
    JCheckBox showPassword = new JCheckBox ("Show Password");

    JButton changePasswordConfirmButton = new JButton("Confirm");

    JLabel passwordError = new JLabel("Password is incorrect!");

    ImageIcon passwordPopup = new ImageIcon("Assets/changepassword.png");
    ImageIcon scaledPasswordPop = new ImageIcon(passwordPopup.getImage().
            getScaledInstance(450, 320, Image.SCALE_SMOOTH));
    JLabel passwordImg = new JLabel (scaledPasswordPop);

    ImageIcon passwordLogo = new ImageIcon("Assets/logo.png");
    ImageIcon scaledPasswordLogo = new ImageIcon(passwordLogo.getImage().
            getScaledInstance(90, 70, Image.SCALE_SMOOTH));

    JLabel logo1 = new JLabel (scaledPasswordLogo);

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
        accountPanel.add(errorFName);
        accountPanel.add(errorLName);
        accountPanel.add(errorPassport);
        accountPanel.add(errorNumber);
        errorFName.setVisible ( false );
        errorLName.setVisible ( false );
        errorPassport.setVisible ( false );
        errorNumber.setVisible ( false );
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
                changeUsernamePopup.setVisible(true);
                accountFrame.setEnabled(false);

            }
        });

        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                changePasswordPopup.setVisible ( true );
                accountFrame.setEnabled(false);
            }
        });

        saveChanges.addActionListener(e -> {



            String first_name = fName.getText();

            if(PassengerControl.nameValidation (first_name)) {

                totalStatus[0] = true;

                errorFName.setVisible(false);

            }

            else{
                totalStatus[0] = false;
                errorFName.setVisible(true);
            }

            String last_name = fName.getText();

            if(PassengerControl.nameValidation (last_name)) {

                totalStatus[1] = true;

                errorLName.setVisible(false);

            }

            else{

                totalStatus[1] = false;

                errorLName.setVisible(true);

            }



            String passport = passID.getText();

            if(PassengerControl.passportIdValidation (passport)) {

                totalStatus[2] = true;

                errorPassport.setVisible(false);

            }

            else{

                totalStatus[2] = false;

                errorPassport.setVisible(true);

            }



            String phone_number = number.getText();

            if(PassengerControl.phoneNumberValidation (phone_number)) {

                totalStatus[3] = true;

                errorNumber.setVisible(false);

            }

            else{

                totalStatus[3] = false;

                errorNumber.setVisible(true);

            }





            if(totalStatus[0] && totalStatus[1] && totalStatus[2] && totalStatus[3] && !PassengerControl.isEmailStored ( currentUser.getEmail () )){

                Controllers.PassengerControl.saveAccountData ( "Passengers.txt",

                        currentUser.getUsername ()

                                + " " + currentUser.getEmail ()

                                + " " + currentUser.getPassword ()

                                + " " + fName.getText ()

                                + " " + lName.getText ()

                                + " " + passID.getText ()

                                + " " + number.getText () + "\n");



            }else if (totalStatus[0] && totalStatus[1] && totalStatus[2] && totalStatus[3] && PassengerControl.isEmailStored ( currentUser.getEmail () )){

                String passenger = PassengerControl.getPassenger (currentUser.getEmail ());

                Controllers.PassengerControl.updateAccountData ( "Passengers.txt", passenger

                        , currentUser.getUsername ()

                                + " " + currentUser.getEmail ()

                                + " " + currentUser.getPassword ()

                                + " " + fName.getText ()

                                + " " + lName.getText ()

                                + " " + passID.getText ()

                                + " " + number.getText () );

            }

        });


        deleteAccountButton.addActionListener(new ActionListener () {
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
        username.setBorder ( new RoundedBorder () );

        changeUsernameButton.setBounds(340, 245, 40, 40);

        passwordTxt.setBounds ( 410,210,400,40 );
        passwordTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        passwordTxt.setForeground ( Color.decode ( "#05203C" ) );
        userPassword.setBounds ( 410, 245,270,40);
        userPassword.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        userPassword.setEditable(false);
        userPassword.setBorder ( new RoundedBorder () );

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
        fName.setBorder ( new RoundedBorder () );
        errorFName.setBounds ( 70,415,300,30 );
        errorFName.setForeground ( Color.decode ( "#DE3341" ) );

        lNameTxt.setBounds ( 410,350,400,40 );
        lNameTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        lNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        lName.setBounds ( 410, 385,300,40);
        lName.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        lName.setBorder ( new RoundedBorder () );
        errorLName.setBounds ( 410,415,300,30 );
        errorLName.setForeground ( Color.decode ( "#DE3341" ) );

        passIDTxt.setBounds ( 70,430,400,40 );
        passIDTxt.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        passIDTxt.setForeground ( Color.decode ( "#05203C" ) );
        passID.setBounds ( 70, 465,640,40);
        passID.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        passID.setBorder ( new RoundedBorder () );
        errorPassport.setBounds ( 70,495,300,30 );
        errorPassport.setForeground ( Color.decode ( "#DE3341" ) );

        noText.setBounds ( 70,510,400,40 );
        noText.setFont ( new Font ( "SansSerif", Font.BOLD, 17 ) );
        noText.setForeground ( Color.decode ( "#05203C" ) );
        number.setBounds ( 70, 545,640,40);
        number.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );
        number.setBorder ( new RoundedBorder () );
        errorNumber.setBounds ( 70,575,300,30 );
        errorNumber.setForeground ( Color.decode ( "#DE3341" ) );

        saveChanges.setBounds(70, 600, 640, 40);
        saveChanges.setFont(new Font("Arial", Font.BOLD, 18));
        saveChanges.setForeground ( Color.white );
        saveChanges.setBackground ( Color.decode ( "#0B3E91" ) );
        saveChanges.setBorder ( BorderFactory.createEmptyBorder () );


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
        deleteAccountButton.setBorder ( BorderFactory.createEmptyBorder () );

        accountFrame.setVisible(true);

        //CHANGE USERNAME POPUP

        changeUsernamePopup.setTitle ( "Change Username" );
        changeUsernamePopup.setSize(450, 500);
        changeUsernamePopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changeUsernamePopup.setIconImage(icon.getImage());
        changeUsernamePopup.setResizable(false);
        changeUsernamePopup.add(validatePasswordLabel);
        changeUsernamePopup.add(validatePasswordField);
        changeUsernamePopup.add(ChangeUsernameLabel);
        changeUsernamePopup.add(ChangeUsernameField);
        changeUsernamePopup.add(changeUserNote);
        changeUsernamePopup.add(changeUsernameConfirmButton);
        changeUsernamePopup.add(usernameError);
        changeUsernamePopup.add(userSplitPane);
        changeUsernamePopup.setLocationRelativeTo(null);
        usernameError.setVisible ( false );
        changeUsernamePopup.setVisible ( false );

        mainPanel = new JPanel(null);
        mainTxt = new JLabel ("<html> <b>Change</b> <i>Username</i>");

        mainPanel.add ( mainTxt );
        mainPanel.add(validatePasswordLabel);
        mainPanel.add(validatePasswordField);
        mainPanel.add(ChangeUsernameLabel);
        mainPanel.add(ChangeUsernameField);

        mainPanel.add(changeUsernameConfirmButton);

        changeUsernamePopup.add(mainPanel);

        mainPanel.setBounds ( 0,0,500,500 );
        mainPanel.setBackground ( Color.decode ( "#ffffff" ) );

        mainTxt.setBounds ( 30,5,450,90 );
        mainTxt.setFont ( new Font ( "SansSerif", Font.PLAIN, 22 ) );
        mainTxt.setForeground ( Color.decode("#0B3E91") );


        ChangeUsernameLabel.setBounds(40, 100, 180, 30);
        ChangeUsernameLabel.setForeground ( Color.decode ( "#05203C" ) );
        ChangeUsernameLabel.setFont ( new Font ( "SansSerif", Font.BOLD, 14 ) );
        ChangeUsernameField.setBounds(40,130,355,40);
        ChangeUsernameField.setBorder ( new RoundedBorder () );
        ChangeUsernameField.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        validatePasswordLabel.setBounds(40, 190,180,30);
        validatePasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD, 14 ) );
        validatePasswordField.setBounds(40, 220, 355, 40);
        validatePasswordField.setBorder ( new RoundedBorder () );
        validatePasswordField.setFont ( new Font ( "SansSerif", Font.PLAIN, 15 ) );

        changeUserNote.setBounds ( 40,270,355,50 );
        changeUserNote.setFont ( new Font ( "SansSerif", Font.BOLD, 14 ) );
        changeUserNote.setForeground ( Color.decode ( "#5555555" ) );

        usernameError.setBounds ( 40,165,200,30 );
        usernameError.setForeground(Color.decode("#db3125"));
        usernameError.setFont ( new Font ( "SansSerif",Font.PLAIN,14 ) );

        userSplitPane.setBounds ( 40, 360,355,3);

        changeUsernameConfirmButton.setBounds(40, 380, 355, 40);
        changeUsernameConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        changeUsernameConfirmButton.setForeground ( Color.decode("#ffffff") );
        changeUsernameConfirmButton.setBackground ( Color.decode ( "#0B3E91" ) );




        changeUsernamePopup.addWindowListener(new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                accountFrame.setEnabled ( true );
            }
        });

        changeUsernameConfirmButton.addActionListener(e -> {
            accountFrame.setEnabled(true);

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
                changeUsernamePopup.setVisible (false);
                accountFrame.dispose ();
                new AccountPage ();
                accountFrame.setEnabled ( true );

            } else {
                usernameError.setVisible(true);
            }
        });


        // CHANGE PASSWORD POPUP

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
        leftPanel.add ( passwordMainTxt );

        changePasswordPopup.add(rightPanel);
        rightPanel.setLayout ( null );
        rightPanel.add(logo1);
        rightPanel.add(passwordHeader);
        rightPanel.add(validatePasswordPopupLabel);
        rightPanel.add(validatePasswordPopupField);
        rightPanel.add(newPasswordLabel);
        rightPanel.add(newPasswordField);
        rightPanel.add(changePasswordConfirmButton);
        rightPanel.add(passwordError);
        rightPanel.add(confirmNewPasswordLabel);
        rightPanel.add(confirmNewPasswordField);
        rightPanel.add(showPassword);

        leftPanel.setBounds ( 0,0,400,500 );
        leftPanel.setBackground ( Color.decode ( "#0B3E91" ) );
        passwordImg.setBounds ( 0,10,450,320 );
        passwordMainTxt.setBounds ( 60,310,400,80 );
        passwordMainTxt.setFont ( new Font ( "SansSerif", Font.BOLD , 25 ) );
        passwordMainTxt.setForeground ( Color.white );
        rightPanel.setBounds ( 400,0,400,500 );
        rightPanel.setBackground ( Color.decode ( "#ffffff" ) );
        logo1.setBounds ( 150 ,10,90,70);
        passwordHeader.setBounds (120, 70,300,50 );
        passwordHeader.setForeground ( Color.decode ( "#05203C" ) );
        passwordHeader.setFont ( new Font ( "SansSerif", Font.BOLD , 20 ) );
        validatePasswordPopupLabel.setBounds(50, 120, 300, 50);
        validatePasswordPopupLabel.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordPopupLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        validatePasswordPopupField.setBounds(50, 160, 300, 30);

        validatePasswordPopupField.setBorder ( new RoundedBorder () );
        newPasswordLabel.setBounds(50, 190, 300, 50);
        newPasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        newPasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        newPasswordField.setBounds(50, 230, 300, 30);

        newPasswordField.setBorder ( new RoundedBorder () );

        confirmNewPasswordLabel.setBounds(50, 260, 300, 50);
        confirmNewPasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        confirmNewPasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );
        confirmNewPasswordField.setBorder ( new RoundedBorder () );
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

        changePasswordPopup.addWindowListener(new WindowAdapter () {
            @Override
            public void windowClosing(WindowEvent e) {
                accountFrame.setEnabled ( true );
            }
        });

        showPassword.addActionListener(e -> {
            boolean showPassword = ((JCheckBox) e.getSource()).isSelected();
            toggleFieldType(showPassword);
        });

        changePasswordConfirmButton.addActionListener(e -> {
            if (!status) {
                changePasswordPopup.setVisible(false);
            }
            String oldUser = currentUser.toString();
            if (currentUser.getPassword().equals(String.valueOf(validatePasswordPopupField.getPassword())) &&
                    RegisterControl.ValidatePassword(String.valueOf(newPasswordField.getPassword())))
            {
                passwordError.setVisible(false);
                currentUser.setPassword(String.valueOf(newPasswordField.getPassword()));
                generateToken(currentUser);
                removeToken ();
                User afterUpdate= new User(currentUser.getEmail(),currentUser.getUsername(),String.valueOf(newPasswordField.getPassword()));
                generateToken(afterUpdate);

                try {
                    FileManager.replaceLines("Users.txt", oldUser, currentUser.toString());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    throw new RuntimeException(ex);
                }

                changePasswordPopup.dispose();
                accountFrame.setEnabled ( true );
                accountFrame.dispose ();
                new AccountPage();

            } else {
                passwordError.setVisible(true);
            }
        });


        if ( ThemeManager.isDarkMode ()) {
            setDarkMode();
        } else {
            setLightMode();
        }

    }

    private void setLightMode() {
        accountPanel.setBackground(Color.decode("#ffffff"));
        accountHeader.setForeground(Color.decode ( "#05203C" ));
        logoutButton.setForeground ( Color.decode ( "#db3125" ) );
        info.setForeground ( Color.decode ( "#0B3E91" ) );
        usernameTxt.setForeground ( Color.decode ( "#05203C" ) );
        username.setBackground ( Color.decode ( "#eeeeee" ));
        username.setForeground ( Color.decode ( "#000000" ));
        passwordTxt.setForeground ( Color.decode ( "#05203C" ) );
        userPassword.setBackground ( Color.decode ( "#eeeeee" ));
        userPassword.setForeground ( Color.decode ( "#000000" ));
        personal.setForeground ( Color.decode ( "#0B3E91" ) );
        fNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        Styling(fName, lNameTxt, lName, passIDTxt, passID);
        noText.setForeground ( Color.decode ( "#05203C" ) );
        number.setBackground ( Color.decode ( "#ffffff" ));
        number.setForeground ( Color.decode ( "#000000" ));
        saveChanges.setForeground ( Color.white );
        saveChanges.setBackground ( Color.decode ( "#0B3E91" ) );
        delTxt.setForeground ( Color.decode ( "#DE3341" ) );
        delLabel.setForeground ( Color.decode ( "#5555555" ) );



        // Password popup

        leftPanel.setBackground ( Color.decode ( "#0B3E91" ) );
        passwordMainTxt.setForeground ( Color.white );
        rightPanel.setBackground ( Color.decode ( "#ffffff" ) );
        passwordHeader.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordPopupLabel.setForeground ( Color.decode ( "#05203C" ) );
        Styling(validatePasswordPopupField, newPasswordLabel, newPasswordField, confirmNewPasswordLabel, confirmNewPasswordField);
        passwordError.setForeground ( Color.decode ( "#db3125" ) );
        changePasswordConfirmButton.setForeground ( Color.white );
        changePasswordConfirmButton.setBackground ( Color.decode ( "#0B3E91" ) );

        // Username popup

        mainPanel.setBackground ( Color.decode ( "#ffffff" ) );
        mainTxt.setForeground ( Color.decode("#0B3E91") );
        ChangeUsernameLabel.setForeground ( Color.decode ( "#05203C" ) );
        ChangeUsernameField.setBackground ( Color.decode ( "#ffffff" ) );
        ChangeUsernameField.setForeground ( Color.decode ( "#000000" ) );
        validatePasswordLabel.setForeground ( Color.decode ( "#05203C" ) );
        validatePasswordField.setBackground ( Color.decode ( "#ffffff" ) );
        validatePasswordField.setForeground ( Color.decode ( "#000000" ) );
        changeUserNote.setForeground ( Color.decode ( "#5555555" ) );

        ThemeManager.setDarkMode ( false );
    }

    private void Styling(JTextField fName, JLabel lNameTxt, JTextField lName, JLabel passIDTxt, JTextField passID) {
        fName.setBackground ( Color.decode ( "#ffffff" ));
        fName.setForeground ( Color.decode ( "#000000" ));
        lNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        lName.setBackground ( Color.decode ( "#ffffff" ));
        lName.setForeground ( Color.decode ( "#000000" ));
        passIDTxt.setForeground ( Color.decode ( "#05203C" ) );
        passID.setBackground ( Color.decode ( "#ffffff" ));
        passID.setForeground ( Color.decode ( "#000000" ));
    }

    private void setDarkMode() {
        accountPanel.setBackground(Color.decode("#111827"));
        accountHeader.setForeground(Color.decode ( "#ffffff" ));
        logoutButton.setForeground ( Color.decode ( "#db3125" ) );
        info.setForeground ( Color.decode ( "#ffffff" ) );
        usernameTxt.setForeground ( Color.decode ( "#bfbfbf" ) );
        username.setBackground ( Color.decode ( "#0e1421" ));
        username.setForeground ( Color.decode ( "#ffffff" ));
        passwordTxt.setForeground ( Color.decode ( "#ffffff" ) );
        userPassword.setBackground ( Color.decode ( "#0e1421" ));
        userPassword.setForeground ( Color.decode ( "#ffffff" ));
        personal.setForeground ( Color.decode ( "#ffffff" ) );
        fNameTxt.setForeground ( Color.decode ( "#bfbfbf" ) );
        fName.setBackground ( Color.decode ( "#111827" ));
        fName.setForeground ( Color.decode ( "#ffffff" ));
        lNameTxt.setForeground ( Color.decode ( "#bfbfbf" ) );
        lName.setBackground ( Color.decode ( "#111827" ));
        lName.setForeground ( Color.decode ( "#ffffff" ));
        passIDTxt.setForeground ( Color.decode ( "#bfbfbf" ) );
        passID.setBackground ( Color.decode ( "#111827" ));
        passID.setForeground ( Color.decode ( "#ffffff" ));
        noText.setForeground ( Color.decode ( "#bfbfbf" ) );
        number.setBackground ( Color.decode ( "#111827" ));
        number.setForeground ( Color.decode ( "#ffffff" ));
        saveChanges.setForeground ( Color.white );
        saveChanges.setBackground ( Color.decode ( "#0B3E91" ) );
        delTxt.setForeground ( Color.decode ( "#ffffff" ) );
        delLabel.setForeground ( Color.decode ( "#bfbfbf" ) );

        // Password popup

        leftPanel.setBackground ( Color.decode ( "#04193a" ) );
        passwordMainTxt.setForeground ( Color.white );
        rightPanel.setBackground ( Color.decode ( "#111827" ) );
        passwordHeader.setForeground ( Color.decode ( "#ffffff" ) );

        validatePasswordPopupLabel.setForeground ( Color.decode ( "#bfbfbf" ) );
        validatePasswordPopupField.setBackground ( Color.decode ( "#111827") );
        validatePasswordPopupField.setForeground ( Color.decode ( "#ffffff" ) );

        newPasswordLabel.setForeground ( Color.decode ( "#bfbfbf" ) );
        newPasswordField.setBackground ( Color.decode ( "#111827") );
        newPasswordField.setForeground ( Color.decode ( "#ffffff" ) );

        confirmNewPasswordLabel.setForeground ( Color.decode ( "#bfbfbf" ) );
        confirmNewPasswordField.setBackground ( Color.decode ( "#111827") );
        confirmNewPasswordField.setForeground ( Color.decode ( "#ffffff" ) );

        passwordError.setForeground ( Color.decode ( "#db3125" ) );
        changePasswordConfirmButton.setForeground ( Color.white );
        changePasswordConfirmButton.setBackground ( Color.decode ( "#0B3E91" ) );
        showPassword.setForeground ( Color.decode ( "#bfbfbf" ) );
        changePasswordConfirmButton.setBorder ( BorderFactory.createEmptyBorder () );

        // Username popup

        mainPanel.setBackground ( Color.decode ( "#111827" ) );
        mainTxt.setForeground ( Color.decode("#ffffff") );
        ChangeUsernameLabel.setForeground ( Color.decode ( "#bfbfbf" ) );
        ChangeUsernameField.setBackground ( Color.decode ( "#111827" ) );
        ChangeUsernameField.setForeground ( Color.decode ( "#ffffff" ) );
        validatePasswordLabel.setForeground ( Color.decode ( "#bfbfbf" ) );
        validatePasswordField.setBackground ( Color.decode ( "#111827" ) );
        validatePasswordField.setForeground ( Color.decode ( "#ffffff" ) );
        changeUserNote.setForeground ( Color.decode ( "#bfbfbf" ) );
        userSplitPane.setBackground ( Color.decode ( "#04193a" ) );
        changeUsernameConfirmButton.setBorder ( BorderFactory.createEmptyBorder () );

        ThemeManager.setDarkMode ( true );

    }
    private void toggleFieldType(boolean showPassword) {
        if (showPassword) {
            validatePasswordPopupField.setEchoChar('\u0000');
            newPasswordField.setEchoChar('\u0000');
            confirmNewPasswordField.setEchoChar('\u0000');
        } else {
            validatePasswordPopupField.setEchoChar('*');
            newPasswordField.setEchoChar('*');
            confirmNewPasswordField.setEchoChar('*');
        }
    }



}