package GUI;

import Controllers.RegisterControl;
import Controllers.SessionControl;
import Controllers.ThemeManager;
import Models.Passenger;
import Models.User;
import Utils.FileManager;
import Utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import static Controllers.Account_FlightControls.*;
import static Controllers.SessionControl.removeToken;
import static Controllers.SessionControl.tokenExists;
import static Controllers.ThemeManager.isDarkMode;
import static GUI.HomePage.currentUser;
import static GUI.HomePage.status;
import static Utils.FileManager.updateField;
public class AccountPage extends JFrame {
    static Passenger Passenger;
    JFrame accountFrame = new JFrame("Account");

    JPanel accountPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/logo.png");

    ImageIcon logoIcon = new ImageIcon("Assets/image-removebg-preview.png");

    ImageIcon scaledLogo = new ImageIcon(logoIcon.getImage().
            getScaledInstance(190, 80, Image.SCALE_SMOOTH));
    JLabel logo = new JLabel(scaledLogo);
    JButton backButton = new JButton("<");
    JLabel accountHeader = new JLabel(currentUser.getUsername() + "'s Account");

    JLabel logoutButton = new JLabel("Logout");


    ImageIcon pencil = new ImageIcon("Assets/pen-to-square-regular.png");
    ImageIcon scaledPencil = new ImageIcon(pencil.getImage().
            getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    JLabel changeUsernameButton = new JLabel(scaledPencil);

    ImageIcon password = new ImageIcon("Assets/key-solid.png");
    ImageIcon scaledPassword = new ImageIcon(password.getImage().
            getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    JLabel changePasswordButton = new JLabel(scaledPassword);

    JLabel info = new JLabel("Account Information");

    JLabel usernameTxt = new JLabel("Username");

    JTextField username = new JTextField(currentUser.getUsername());

    JLabel passwordTxt = new JLabel("password");
    JPasswordField userPassword = new JPasswordField(currentUser.getPassword());

    JLabel personal = new JLabel("Personal Details");

    JLabel fNameTxt = new JLabel("First Name");
    JTextField fName ;

    JLabel lNameTxt = new JLabel("Last Name");
    JTextField lName;

    JLabel passIDTxt = new JLabel("Passport ID");
    JTextField passIDField ;

    JLabel noText = new JLabel("Phone number");
    JTextField NumberField ;

    JButton saveChanges = new JButton("Save Changes");

    JLabel delTxt = new JLabel("Delete Your Account");

    JLabel delLabel = new JLabel("<html>Click ACCOUNT DELETE to start the process of permanently" +

            " deleting your RIHLA Flights account including all personal" +

            " information, flights and tickets. <br> Once your RIHLA " +

            "flights account is deleted, your wallet balance will be" +

            " permanently deleted as well.");
    JButton deleteAccountButton = new JButton("DELETE ACCOUNT");

    JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JLabel ErrorID = new JLabel("Invalid ID");
    JLabel ErrorPhone = new JLabel("Invalid phone number");
    JLabel InvalidfName = new JLabel("Invalid first name");
    JLabel InvalidlName = new JLabel("Invalid last name");
    // CHANGE USERNAME FRAME VARIABLES
    JFrame changeUsernamePopup = new JFrame("Change Username");
    JPanel mainPanel;

    // CHANGE USERNAME FRAME VARIABLES
    JLabel changeUserNote = new JLabel ("<html>*Note: This will update your login" +

            " username on our application for all future logins.");

    JLabel mainTxt;
    JLabel validatePasswordLabel = new JLabel("Your Password:");
    JPasswordField validatePasswordField = new JPasswordField(30);

    JLabel ChangeUsernameLabel = new JLabel("New Username:");
    JTextField ChangeUsernameField = new JTextField(30);
    JButton changeUsernameConfirmButton = new JButton("Confirm Changes");
    JLabel usernameError = new JLabel("invalid username");
    JSplitPane userSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    // CHANGE PASSWORD FRAME VARIABLES
    JFrame changePasswordPopup = new JFrame("Change Password");

    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    JLabel passwordMainTxt = new JLabel("Change your password");

    JLabel passwordHeader = new JLabel("Reset Password");
    JLabel validatePasswordPopupLabel = new JLabel("Old Password");
    JPasswordField validatePasswordPopupField = new JPasswordField(30);
    JLabel newPasswordLabel = new JLabel("New Password");
    JPasswordField newPasswordField = new JPasswordField(30);
    JLabel confirmNewPasswordLabel = new JLabel("Confirm Password");
    JPasswordField confirmNewPasswordField = new JPasswordField(30);
    JCheckBox showPassword = new JCheckBox("Show Password");

    JButton changePasswordConfirmButton = new JButton("Confirm");

    JLabel passwordError = new JLabel("Password is incorrect!");

    ImageIcon passwordPopup = new ImageIcon("Assets/changepassword.png");
    ImageIcon scaledPasswordPop = new ImageIcon(passwordPopup.getImage().
            getScaledInstance(450, 320, Image.SCALE_SMOOTH));
    JLabel passwordImg = new JLabel(scaledPasswordPop);

    ImageIcon passwordLogo = new ImageIcon("Assets/logo.png");
    ImageIcon scaledPasswordLogo = new ImageIcon(passwordLogo.getImage().
            getScaledInstance(90, 70, Image.SCALE_SMOOTH));
    JLabel logo1 = new JLabel(scaledPasswordLogo);

    AccountPage() {
        if(isemailStored(currentUser.getEmail()))
        {
            Passenger = new Passenger(currentUser.getEmail(), currentUser.getUsername(), currentUser.getPassword(),getFirstname(currentUser.getEmail()),getLastname(currentUser.getEmail()),getPhoneNumber(currentUser.getEmail()),getPassportId(currentUser.getEmail()));
        }
        else if (Passenger == null) {
            Passenger = new Passenger(currentUser.getEmail(), currentUser.getUsername(),currentUser.getPassword());
        }
        if(!Passenger.getFirstName().equals(" "))
        {
            fName= new JTextField(Passenger.getFirstName());
        }
        else{
            fName= new JTextField("Firstname");
        }
        if(!Passenger.getLastName().equals(" "))
        {
            lName= new JTextField(Passenger.getLastName());
        }
        else{
            lName= new JTextField("Lastname");
        }
        if(!Passenger.getPassportId().equals(" "))
        {
            passIDField = new JTextField(Passenger.getPassportId());
        }
        else{
            passIDField = new JTextField("PassportID");
        }
        if(!Passenger.getPhoneNumber().equals(" "))
        {
            NumberField = new JTextField(Passenger.getPhoneNumber());
        }
        else{
            NumberField = new JTextField("Number");
        }
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
        accountPanel.add(passIDField);
        accountPanel.add(noText);
        accountPanel.add(NumberField);
        accountPanel.add(splitPane1);
        accountPanel.add(splitPane2);
        accountPanel.add(splitPane3);
        accountPanel.add(saveChanges);
        accountPanel.add(delTxt);
        accountPanel.add(delLabel);
        accountPanel.add(deleteAccountButton);
        accountPanel.add(ErrorID);
        accountPanel.add(ErrorPhone);
        accountPanel.add(InvalidfName);
        accountPanel.add(InvalidlName);
        ErrorID.setVisible(false);
        ErrorPhone.setVisible(false);
        InvalidfName.setVisible(false);
        InvalidlName.setVisible(false);
        fName.setForeground(Color.GRAY);
        backButton.addActionListener(e -> {
            ErrorID.setVisible(false);
            ErrorPhone.setVisible(false);
            InvalidfName.setVisible(false);
            InvalidlName.setVisible(false);
            new HomePage();

            accountFrame.dispose();
        });

        logoutButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (tokenExists()) {
                    removeToken();
                }
                ErrorID.setVisible(false);
                ErrorPhone.setVisible(false);
                InvalidfName.setVisible(false);
                InvalidlName.setVisible(false);
                Passenger = null;
                new HomePage();
                accountFrame.dispose();
            }
        });

        changeUsernameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ErrorID.setVisible(false);
                ErrorPhone.setVisible(false);
                InvalidfName.setVisible(false);
                InvalidlName.setVisible(false);
                changeUsernamePopup.setVisible(true);
                accountFrame.setEnabled(false);

            }
        });

        changePasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ErrorID.setVisible(false);
                ErrorPhone.setVisible(false);
                InvalidfName.setVisible(false);
                InvalidlName.setVisible(false);
                changePasswordPopup.setVisible(true);
                accountFrame.setEnabled(false);
            }
        });
        saveChanges.addActionListener(e -> {
            String firstname = fName.getText();
            if (Validatename(firstname)) {
                InvalidfName.setVisible(true);
            } else {
                if(!isFirstnameStored(firstname, currentUser.getEmail())) {

                    if (Passenger.getFirstName().isEmpty()||!firstname.equals("Firstname")) {
                        try {
                            updateField("Passenger.txt", currentUser.getEmail(), Passenger.getFirstName(), firstname, 1);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            throw new RuntimeException(ex);
                        }

                    }
                }
                Passenger.setFirstname(firstname);
                InvalidfName.setVisible(false);
            }
            String lastname = lName.getText();
            if (Validatename(lastname)) {
                InvalidlName.setVisible(true);
            } else {
                if(!isLastnameStored(lastname,currentUser.getEmail())&&!lastname.equals("Lastname")) {
                    try {
                        updateField("Passenger.txt", currentUser.getEmail(), Passenger.getLastName(), lastname, 2);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        throw new RuntimeException(ex);
                    }
                    Passenger.setLastname(lastname);
                }

                InvalidlName.setVisible(false);
            }
            String PassID = passIDField.getText();

            if (PassID.isEmpty()||PassID.equals("PassportID")) {
                ErrorID.setVisible(false);
            } else {
                if (ValidatePassportId(PassID)) {
                    ErrorID.setVisible(true);
                } else {
                    if(!isPassIdStored(PassID,currentUser.getEmail())) {
                        try {
                            updateField("Passenger.txt",currentUser.getEmail(), Passenger.getPassportId(), PassID, 3);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            throw new RuntimeException(ex);
                        }
                        Passenger.setPassportId(PassID);
                    }
                    ErrorID.setVisible(false);
                }

            }

            String number = NumberField.getText();
            if (number.isEmpty()||number.equals("Number")) {
                ErrorPhone.setVisible(false);
            } else {
                if (Validatephonenumber(number)) {
                    ErrorPhone.setVisible(true);
                } else {
                    if(!isPhoneNumberStored(number,currentUser.getEmail())) {
                        try {
                            updateField("Passenger.txt",currentUser.getEmail(), Passenger.getPhoneNumber(), number, 4);
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            throw new RuntimeException(ex);
                        }
                    }
                    Passenger.setPhoneNumber(number);
                    ErrorPhone.setVisible(false);
                }
            }
        });
        fName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (fName.getText().trim().isEmpty()) {
                    fName.setText("Firstname");  // Add "Firstname" when focus lost if empty
                    fName.setForeground(Color.GRAY);
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                if (fName.getText().equals("Firstname")||fName.getText().equals(" ")) {
                    fName.setText("");  // Clear the text when focused
                    if(isDarkMode()){
                        fName.setForeground(Color.WHITE);
                    }
                    else{
                        fName.setForeground(Color.BLACK);
                    }
                }
            }
        });
        lName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (lName.getText().trim().isEmpty()) {
                    lName.setText("Lastname");  // Add "Lastname" when focus lost if empty
                    lName.setForeground(Color.GRAY);
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                if (lName.getText().equals("Lastname")||lName.getText().equals(" ")) {
                    lName.setText("");  // Clear the text when focused
                    if(isDarkMode()){
                        fName.setForeground(Color.WHITE);
                    }
                    else{
                        fName.setForeground(Color.BLACK);
                    }
                }
            }
        });
        passIDField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (passIDField.getText().trim().isEmpty()) {
                    passIDField.setText("PassportID");  // Add "Passport ID" when focus lost if empty
                    passIDField.setForeground(Color.GRAY);
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                if (passIDField.getText().equals("PassportID")||passIDField.getText().equals(" ")){
                    passIDField.setText("");  // Clear the text when focused
                    if(isDarkMode()){
                        fName.setForeground(Color.WHITE);
                    }
                    else{
                        fName.setForeground(Color.BLACK);
                    }
                }
            }
        });
        NumberField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (NumberField.getText().trim().isEmpty()) {
                    NumberField.setText("Number");  // Add "Phone number" when focus lost if empty
                    NumberField.setForeground(Color.GRAY);
                }
            }
            @Override
            public void focusGained(FocusEvent e) {
                if (NumberField.getText().equals("Number")||NumberField.getText().equals(" ")){
                    NumberField.setText("");  // Clear the text when focused
                    if(isDarkMode()){
                        fName.setForeground(Color.WHITE);
                    }
                    else{
                        fName.setForeground(Color.BLACK);
                    }
                }
            }
        });
        deleteAccountButton.addActionListener(e -> {
            try {
                FileManager.deleteLine("Users.txt",
                        currentUser.getUsername()
                                + " " + currentUser.getEmail()
                                + " " + currentUser.getPassword());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
            try {
                FileManager.deleteLine("Passenger.txt",
                        currentUser.getEmail()
                                + "," +Passenger.getFirstName()
                                + "," + Passenger.getLastName()
                                +","+Passenger.getPassportId()
                                +","+Passenger.getPhoneNumber() );
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
            Passenger = null;
            ErrorID.setVisible(false);
            ErrorPhone.setVisible(false);
            InvalidfName.setVisible(false);
            InvalidlName.setVisible(false);
            removeToken();
            new HomePage();
            accountFrame.dispose();
        });


        accountPanel.setBackground(Color.decode("#ffffff"));

        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        accountHeader.setBounds(70, 50, 400, 80);
        accountHeader.setFont(new Font("SansSerif", Font.BOLD, 30));
        accountHeader.setForeground(Color.decode("#05203C"));

        logoutButton.setBounds(70, 100, 150, 50);
        logoutButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        logoutButton.setForeground(Color.decode("#db3125"));

        logo.setBounds(550, 70, 190, 80);

        info.setBounds(70, 160, 400, 40);
        info.setFont(new Font("SansSerif", Font.BOLD, 23));
        info.setForeground(Color.decode("#0B3E91"));

        splitPane1.setBounds(70, 200, 640, 3);

        usernameTxt.setBounds(70, 210, 400, 40);
        usernameTxt.setFont(new Font("SansSerif", Font.BOLD, 17));
        usernameTxt.setForeground(Color.decode("#05203C"));
        username.setBounds(70, 245, 270, 40);
        username.setFont(new Font("SansSerif", Font.PLAIN, 15));
        username.setEditable(false);
        username.setBorder(new RoundedBorder());
        changeUsernameButton.setBounds(340, 245, 40, 40);


        passwordTxt.setBounds(410, 210, 400, 40);
        passwordTxt.setFont(new Font("SansSerif", Font.BOLD, 17));
        passwordTxt.setForeground(Color.decode("#05203C"));
        userPassword.setBounds(410, 245, 270, 40);
        userPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
        userPassword.setEditable(false);
        userPassword.setBorder(new RoundedBorder());
        changePasswordButton.setBounds(680, 245, 40, 40);

        personal.setBounds(70, 300, 400, 40);
        personal.setFont(new Font("SansSerif", Font.BOLD, 23));
        personal.setForeground(Color.decode("#0B3E91"));

        splitPane2.setBounds(70, 340, 640, 3);

        fNameTxt.setBounds(70, 350, 400, 40);
        fNameTxt.setFont(new Font("SansSerif", Font.BOLD, 17));
        fNameTxt.setForeground(Color.decode("#05203C"));
        fName.setBounds(70, 385, 300, 40);
        fName.setFont(new Font("SansSerif", Font.PLAIN, 15));
        fName.setBorder(new RoundedBorder());
        InvalidfName.setBounds(70, 420, 200, 30);
        InvalidfName.setForeground(Color.decode("#DE3341"));

        lNameTxt.setBounds(410, 350, 400, 40);
        lNameTxt.setFont(new Font("SansSerif", Font.BOLD, 17));
        lNameTxt.setForeground(Color.decode("#05203C"));
        lName.setBounds(410, 385, 300, 40);
        lName.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lName.setBorder(new RoundedBorder());
        InvalidlName.setBounds(410, 420, 200, 30);
        InvalidlName.setForeground(Color.decode("#DE3341"));

        passIDTxt.setBounds(70, 430, 400, 40);
        passIDTxt.setFont(new Font("SansSerif", Font.BOLD, 17));
        passIDTxt.setForeground(Color.decode("#05203C"));
        passIDField.setBounds(70, 465, 640, 40);
        passIDField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        passIDField.setBorder(new RoundedBorder());
        ErrorID.setBounds(70, 500, 200, 30);
        ErrorID.setForeground(Color.decode("#DE3341"));

        noText.setBounds(70, 510, 400, 40);
        noText.setFont(new Font("SansSerif", Font.BOLD, 17));
        noText.setForeground(Color.decode("#05203C"));
        NumberField.setBounds(70, 545, 640, 40);
        NumberField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        NumberField.setBorder(new RoundedBorder());
        ErrorPhone.setBounds(70, 575, 200, 30);
        ErrorPhone.setForeground(Color.decode("#DE3341"));

        saveChanges.setBounds(70, 600, 640, 40);
        saveChanges.setFont(new Font("Arial", Font.BOLD, 18));
        saveChanges.setForeground(Color.white);
        saveChanges.setBackground(Color.decode("#0B3E91"));
        saveChanges.setBorder(BorderFactory.createEmptyBorder());

        delTxt.setBounds(70, 660, 400, 40);
        delTxt.setFont(new Font("SansSerif", Font.BOLD, 23));
        delTxt.setForeground(Color.decode("#DE3341"));

        splitPane3.setBounds(70, 700, 640, 3);

        delLabel.setBounds(70, 710, 640, 80);
        delLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        delLabel.setForeground(Color.decode("#5555555"));

        deleteAccountButton.setBounds(70, 810, 200, 40);
        deleteAccountButton.setFont(new Font("Arial", Font.BOLD, 15));
        deleteAccountButton.setForeground(Color.white);
        deleteAccountButton.setBackground(Color.decode("#DE3341"));
        deleteAccountButton.setBorder(BorderFactory.createEmptyBorder());
        saveChanges.setFocusPainted(false);
        deleteAccountButton.setFocusPainted(false);
        backButton.setFocusPainted(false);
        accountFrame.setVisible(true);


        //CHANGE USERNAME POPUP

        changeUsernamePopup.setTitle("Change Usernam");

        changeUsernamePopup.setSize(450, 500);

        changeUsernamePopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        changeUsernamePopup.setIconImage(icon.getImage());

        changeUsernamePopup.setResizable(false);
        changeUsernamePopup.add(changeUserNote);

        changeUsernamePopup.add(validatePasswordLabel);

        changeUsernamePopup.add(validatePasswordField);

        changeUsernamePopup.add(ChangeUsernameLabel);

        changeUsernamePopup.add(ChangeUsernameField);
        changeUsernamePopup.add(changeUserNote);
        changeUsernamePopup.add(changeUsernameConfirmButton);

        changeUsernamePopup.add(usernameError);


        changeUsernamePopup.setLocationRelativeTo(null);

        changeUsernamePopup.setVisible(false);
        changeUsernamePopup.add(userSplitPane);
        changeUsernamePopup.setLocationRelativeTo(null);

        usernameError.setVisible ( false );

        changeUsernamePopup.setVisible ( false );

        mainPanel = new JPanel(null);

        mainTxt = new JLabel ("<html> <b>Change</b> <i>Username</i>");


        mainPanel.add(mainTxt);

        mainPanel.add(validatePasswordLabel);

        mainPanel.add(validatePasswordField);

        mainPanel.add(ChangeUsernameLabel);

        mainPanel.add(ChangeUsernameField);


        mainPanel.add(changeUsernameConfirmButton);


        changeUsernamePopup.add(mainPanel);
        changeUserNote.setForeground ( Color.decode ( "#5555555" ) );
        mainPanel.setBounds ( 0,0,500,500 );

        mainPanel.setBackground ( Color.decode ( "#ffffff" ) );
        usernameError.setForeground(Color.decode("#db3125"));mainTxt.setBounds ( 30,5,450,90 );

        usernameError.setFont ( new Font ( "SansSerif",Font.PLAIN,14 ) );
        userSplitPane.setBounds ( 40, 360,355,3);



        changeUsernameConfirmButton.setBounds(40, 380, 355, 40);
        mainTxt.setBounds ( 30,5,450,90 );

        mainTxt.setFont ( new Font ( "SansSerif", Font.PLAIN, 22 ) );
        mainTxt.setForeground ( Color.decode("#0B3E91") );


        mainPanel.setBounds ( 0,0,500,500 );

        mainPanel.setBackground(Color.decode("#ffffff"));


        mainTxt.setBounds(20, 5, 450, 90);

        mainTxt.setFont(new Font("SansSerif", Font.BOLD, 25));

        mainTxt.setForeground(Color.decode("#0B3E91"));


        validatePasswordLabel.setBounds(80, 100, 180, validatePasswordLabel.getMinimumSize().height);

        validatePasswordLabel.setForeground(Color.decode("#05203C"));

        validatePasswordLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        validatePasswordField.setBounds(70, 130, 350, 30);

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
        userSplitPane.setBounds ( 40, 360,355,3);



        changeUsernameConfirmButton.setBounds(40, 380, 355, 40);
        usernameError.setFont ( new Font ( "SansSerif",Font.PLAIN,14 ) );

        changeUsernameConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));

        changeUsernameConfirmButton.setForeground ( Color.decode("#ffffff") );

        changeUsernameConfirmButton.setBackground ( Color.decode ( "#0B3E91" ) );

        changeUsernameConfirmButton.setBounds(150, 300, 170, 40);



        changeUsernamePopup.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                accountFrame.setEnabled(true);

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

                User afterUpdate = new User(currentUser.getEmail(), ChangeUsernameField.getText(),currentUser.getPassword());

                SessionControl.generateToken(afterUpdate);


                try {

                    FileManager.replaceLines("Users.txt", oldUser,currentUser.toString());

                    FileManager.replaceLines("token.txt", oldUser,currentUser.toString());


                } catch (IOException ex) {

                    System.out.println(ex.getMessage());

                    throw new RuntimeException(ex);

                }


                accountHeader.setText(currentUser.getUsername() + "'s Account");

                changeUsernamePopup.setVisible(false);

                accountFrame.dispose();

                new AccountPage();

                accountFrame.setEnabled(true);


            } else {

                usernameError.setVisible(true);

            }

        });


        // CHANGE PASSWORD POPUP


        changePasswordPopup.setLayout(null);

        changePasswordPopup.setSize(800, 500);

        changePasswordPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        changePasswordPopup.setIconImage(icon.getImage());

        changePasswordPopup.setResizable(false);

        changePasswordPopup.setLocationRelativeTo(null);

        changePasswordPopup.setResizable(false);


        changePasswordPopup.add(leftPanel);

        leftPanel.setLayout(null);

        leftPanel.add(passwordImg);

        leftPanel.add(passwordMainTxt);


        changePasswordPopup.add(rightPanel);

        rightPanel.setLayout(null);

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


        leftPanel.setBounds(0, 0, 400, 500);

        leftPanel.setBackground(Color.decode("#0B3E91"));

        passwordImg.setBounds(0, 10, 450, 320);

        passwordMainTxt.setBounds(60, 310, 400, 80);

        passwordMainTxt.setFont(new Font("SansSerif", Font.BOLD, 25));

        passwordMainTxt.setForeground(Color.white);

        rightPanel.setBounds(400, 0, 400, 500);

        rightPanel.setBackground(Color.decode("#ffffff"));

        logo1.setBounds(150, 10, 90, 70);

        passwordHeader.setBounds(120, 70, 300, 50);

        passwordHeader.setForeground(Color.decode("#05203C"));

        passwordHeader.setFont(new Font("SansSerif", Font.BOLD, 20));

        validatePasswordPopupLabel.setBounds(50, 120, 300, 50);

        validatePasswordPopupLabel.setForeground(Color.decode("#05203C"));

        validatePasswordPopupLabel.setFont(new Font("SansSerif", Font.BOLD, 15));

        validatePasswordPopupField.setBounds(50, 160, 300, 30);
        validatePasswordPopupField.setBorder ( new RoundedBorder () );

        newPasswordLabel.setBounds(50, 190, 300, 50);

        newPasswordLabel.setForeground(Color.decode("#05203C"));

        newPasswordLabel.setFont(new Font("SansSerif", Font.BOLD, 15));

        newPasswordField.setBounds(50, 230, 300, 30);
        newPasswordLabel.setForeground ( Color.decode ( "#05203C" ) );

        newPasswordLabel.setFont ( new Font ( "SansSerif", Font.BOLD , 15 ) );

        newPasswordField.setBounds(50, 230, 300, 30);
        newPasswordField.setBorder ( new RoundedBorder () );

        confirmNewPasswordLabel.setBounds(50, 260, 300, 50);

        confirmNewPasswordLabel.setForeground(Color.decode("#05203C"));

        confirmNewPasswordLabel.setFont(new Font("SansSerif", Font.BOLD, 15));

        confirmNewPasswordField.setBounds(50, 300, 300, 30);
        confirmNewPasswordField.setBorder ( new RoundedBorder () );

        showPassword.setBounds(50, 330, 300, 30);

        showPassword.setOpaque(false);

        passwordError.setBounds(130, 350, 300, 30);

        passwordError.setForeground(Color.decode("#db3125"));

        changePasswordConfirmButton.setBounds(50, 375, 300, 40);

        changePasswordConfirmButton.setFont(new Font("Arial", Font.BOLD, 18));

        changePasswordConfirmButton.setForeground(Color.white);

        changePasswordConfirmButton.setBackground(Color.decode("#0B3E91"));

        passwordError.setVisible(false);


        changePasswordPopup.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                accountFrame.setEnabled(true);

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

                    RegisterControl.ValidatePassword(String.valueOf(newPasswordField.getPassword()))) {

                passwordError.setVisible(false);

                currentUser.setPassword(String.valueOf(newPasswordField.getPassword()));

                SessionControl.generateToken(currentUser);

                removeToken();

                User afterUpdate = new User(currentUser.getEmail(),currentUser.getUsername(), String.valueOf(newPasswordField.getPassword()));

                SessionControl.generateToken(afterUpdate);


                try {

                    FileManager.replaceLines("Users.txt", oldUser,currentUser.toString());

                } catch (IOException ex) {

                    System.out.println(ex.getMessage());

                    throw new RuntimeException(ex);

                }


                changePasswordPopup.dispose();
                usernameTxt.setForeground ( Color.decode ( "#05203C" ) );

                accountFrame.setEnabled(true);

                accountFrame.dispose();

                new AccountPage();


            } else {

                passwordError.setVisible(true);

            }

        });


        if (isDarkMode()) {

            setDarkMode();

        } else {

            setLightMode();

        }

    }

    private void setLightMode() {
        if(Passenger.getFirstName().equals(" "))
        {
            fName.setForeground(Color.GRAY);
        }
        else{
            fName.setForeground(Color.BLACK);
        }
        if(Passenger.getLastName().equals(" "))
        {
            lName.setForeground(Color.GRAY);
        }
        else{
            lName.setForeground(Color.BLACK);
        }
        if(Passenger.getPassportId().equals(" "))
        {
            passIDField.setForeground(Color.GRAY);
        }
        else{
            passIDField.setForeground(Color.BLACK);
        }
        if(Passenger.getPhoneNumber().equals(" "))
        {
            NumberField.setForeground(Color.GRAY);
        }
        else{
            NumberField.setForeground(Color.BLACK);
        }
        Styling(fName, lNameTxt, lName, passIDTxt, passIDField);
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
        fName.setBackground ( Color.decode ( "#ffffff" ));
        lNameTxt.setForeground ( Color.decode ( "#05203C" ) );
        ChangeUsernameLabel.setForeground ( Color.decode ( "#05203C" ) );
        lName.setBackground ( Color.decode ( "#ffffff" ));
        passIDTxt.setForeground ( Color.decode ( "#05203C" ) );
        passIDField.setBackground ( Color.decode ( "#ffffff" ));
        noText.setForeground ( Color.decode ( "#05203C" ) );
        NumberField.setBackground ( Color.decode ( "#ffffff" ));
        changeUserNote.setForeground ( Color.decode ( "#5555555" ) );
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
        if(Passenger.getFirstName().equals(" "))
        {
            fName.setForeground(Color.GRAY);
        }
        else{
            fName.setForeground(Color.white);
        }
        if(Passenger.getLastName().equals(" "))
        {
            lName.setForeground(Color.GRAY);
        }
        else{
            lName.setForeground(Color.white);
        }
        if(Passenger.getPassportId().equals(" "))
        {
            passIDField.setForeground(Color.GRAY);
        }
        else{
            passIDField.setForeground(Color.white);
        }
        if(Passenger.getPhoneNumber().equals(" "))
        {
            NumberField.setForeground(Color.GRAY);
        }
        else{
            NumberField.setForeground(Color.white);
        }
        accountPanel.setBackground(Color.decode("#111827"));

        accountHeader.setForeground(Color.decode("#ffffff"));

        logoutButton.setForeground(Color.decode("#db3125"));

        info.setForeground(Color.decode("#ffffff"));

        usernameTxt.setForeground(Color.decode("#bfbfbf"));

        username.setBackground(Color.decode("#0e1421"));

        username.setForeground(Color.decode("#ffffff"));

        passwordTxt.setForeground(Color.decode("#ffffff"));

        userPassword.setBackground(Color.decode("#0e1421"));

        userPassword.setForeground(Color.decode("#ffffff"));

        personal.setForeground(Color.decode("#ffffff"));

        fNameTxt.setForeground(Color.decode("#bfbfbf"));

        fName.setBackground(Color.decode("#111827"));


        lNameTxt.setForeground(Color.decode("#bfbfbf"));

        lName.setBackground(Color.decode("#111827"));

        passIDTxt.setForeground(Color.decode("#bfbfbf"));

        passIDField.setBackground(Color.decode("#111827"));

        noText.setForeground(Color.decode("#bfbfbf"));

        NumberField.setBackground(Color.decode("#111827"));

        saveChanges.setForeground(Color.white);

        saveChanges.setBackground(Color.decode("#0B3E91"));

        delTxt.setForeground(Color.decode("#ffffff"));

        delLabel.setForeground(Color.decode("#bfbfbf"));

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
