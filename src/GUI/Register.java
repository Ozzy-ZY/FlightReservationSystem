package GUI;
import Controllers.ThemeManager;
import Models.User;
import Utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import static Controllers.SessionControl.*;

import static Controllers.RegisterControl.*;

public class Register extends JFrame{

    boolean[] totalStatus = {false, false, false};
    JFrame regFrame = new JFrame("Register");
    JPanel regPanel = new JPanel();
    JPanel topPanel = new JPanel ();
    ImageIcon icon = new ImageIcon("Assets/logo.png");
    JButton backButton = new JButton("<");
    JButton regButton = new JButton("Register");
    JTextField usernameField = new JTextField(30);
    JLabel registerHeader = new JLabel("Create your account");
    JLabel emailLabel = new JLabel("Email");
    JTextField emailField = new JTextField(30);
    JLabel usernameLabel = new JLabel("Username");
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password");
    JLabel errorEmail = new JLabel("Invalid Email");
    JLabel errorUsername = new JLabel("please enter a valid password");
    JLabel errorPassword = new JLabel("Please enter a valid password");
    JLabel RedEmail = new JLabel("This Email already exist");
    JLabel RedUsername = new JLabel("This Username already exist");
    JLabel logoTxt = new JLabel("Rihla Flights");


    ImageIcon bg = new ImageIcon("Assets/clouds.jpeg");
    ImageIcon scaledBg = new ImageIcon(bg.getImage().
            getScaledInstance(500, 200, Image.SCALE_SMOOTH));

    ImageIcon bgD = new ImageIcon("Assets/cloudsD.png");
    ImageIcon scaledBgD = new ImageIcon(bgD.getImage().
            getScaledInstance(500, 200, Image.SCALE_SMOOTH));

    ImageIcon logo = new ImageIcon("Assets/logo.png");
    ImageIcon scaledLogo = new ImageIcon(logo.getImage().
            getScaledInstance(90, 70, Image.SCALE_SMOOTH));

    JLabel cloudsImg = new JLabel (scaledBg);
    JLabel logoImg = new JLabel (scaledLogo);

    public Register(){
        regFrame.setSize(450, 700);
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setIconImage(logo.getImage());
        regFrame.setResizable(false);
        regFrame.setLocationRelativeTo(null);
        regFrame.setIconImage(icon.getImage());
        regFrame.add(regPanel);

        topPanel.setLayout ( null );
        topPanel.add(backButton);
        regPanel.add(topPanel);
        regPanel.add(cloudsImg);
        topPanel.add(logoImg);
        topPanel.add(logoTxt);
        regPanel.setLayout(null);
        regPanel.add(registerHeader);
        regPanel.add(usernameField);
        regPanel.add(usernameLabel);
        regPanel.add(passwordField);
        regPanel.add(passwordLabel);

        regPanel.add(emailField);
        regPanel.add(emailLabel);
        regPanel.add(regButton);
        regPanel.add(errorEmail);
        regPanel.add(errorUsername);
        regPanel.add(errorPassword);
        regPanel.add(RedEmail);
        regPanel.add(RedUsername);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);
        RedEmail.setVisible(false);
        RedUsername.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e -> {
            new HomePage();
            regFrame.dispose();
        });
        emailField.addActionListener(e -> {
            String email = emailField.getText();
            if(ValidateEmail(email)){
                totalStatus[0] = true;
                errorEmail.setVisible(false);
                if(isEmailStored(email)) {
                    RedEmail.setVisible(true);
                    totalStatus[0] = false;
                }
                else {
                    RedEmail.setVisible(false);
                    totalStatus[0] = true;
                }
            }
            else{
                totalStatus[0] = false;
                RedEmail.setVisible(false);
                errorEmail.setVisible(true);
            }
        });
        usernameField.addActionListener(e -> {
            String username = usernameField.getText();
            if(ValidateUsername(username)){
                totalStatus[1] = true;
                errorUsername.setVisible(false);
                if(isUsernameStored(username)) {
                    totalStatus[1] = false;
                    RedUsername.setVisible(true);
                }
                else {
                    RedUsername.setVisible(false);
                    totalStatus[1] = true;
                }
            }
            else{
                totalStatus[1] = false;
                RedUsername.setVisible(false);
                errorUsername.setVisible(true);
            }
        });

        passwordField.addActionListener(e -> {
            String password = tostring(passwordField.getPassword());
            if(ValidatePassword(password)){
                totalStatus[2] = true;
                errorPassword.setVisible(false);
            }
            else{
                errorPassword.setVisible(true);
            }
        });
        regButton.addActionListener(e -> {
            String email = emailField.getText();
            if(ValidateEmail(email)) {
                totalStatus[0] = true;
                errorEmail.setVisible(false);
                if(isEmailStored(email)) {
                    RedEmail.setVisible(true);
                    totalStatus[0] = false;
                }
                else {
                    RedEmail.setVisible(false);
                    totalStatus[0] = true;
                }
            }
            else{
                totalStatus[0] = false;
                RedEmail.setVisible(false);
                errorEmail.setVisible(true);
            }
            String username = usernameField.getText();
            if(ValidateUsername(username)) {
                totalStatus[1] = true;
                errorUsername.setVisible(false);
                if(isUsernameStored(username)) {
                    totalStatus[1] = false;
                    RedUsername.setVisible(true);
                }
                else {
                    RedUsername.setVisible(false);
                    totalStatus[1] = true;
                }
            }
            else{
                totalStatus[1] = false;
                RedUsername.setVisible(false);
                errorUsername.setVisible(true);
            }

            String password = tostring(passwordField.getPassword());
            if(ValidatePassword(password)){
                totalStatus[2] = true;
                errorPassword.setVisible(false);
            }
            else{
                errorPassword.setVisible(true);
            }

            if(totalStatus[0] && totalStatus[1] && totalStatus[2]){
                saveData(email, username, password);
                generateToken(new User(email,username,password));
                new HomePage();
                regFrame.dispose();
            }
        });

        regPanel.setBackground(Color.decode("#ffffff"));
        topPanel.setBackground ( Color.decode ( "#28437a" ) );
        topPanel.setSize ( 450,150 );
        logoTxt.setBounds ( 160,90,200,60 );
        logoTxt.setFont ( new Font("SansSerif",Font.PLAIN,20) );
        logoTxt.setForeground ( Color.white );
        logoImg.setBounds ( 165,30,90,70 );
        cloudsImg.setBounds ( 0,99,450,180 );
        registerHeader.setFont(new Font("SansSerif", Font.BOLD, 20));
        registerHeader.setForeground(Color.decode ( "#05203C" ));
        registerHeader.setBounds(130, 280, 400, 30);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);


        usernameLabel.setBounds(50, 320, 100, 30);
        usernameLabel.setFont(new Font("SansSerif",Font.BOLD, 15));
        usernameLabel.setForeground(Color.decode ( "#05203C" ));
        usernameField.setBounds(50, 350, 330, 40);
        usernameField.setBorder ( new RoundedBorder () );
        RedUsername.setHorizontalAlignment(SwingConstants.LEFT);
        RedUsername.setForeground(Color.decode("#db3125"));
        RedUsername.setBounds(50, 382, 350, 30);
        errorUsername.setHorizontalAlignment(SwingConstants.LEFT);
        errorUsername.setForeground(Color.decode("#db3125"));
        errorUsername.setBounds(50, 382, 350, 30);


        emailLabel.setBounds(50, 400, 100, 30);
        emailLabel.setFont(new Font("SansSerif",Font.BOLD, 15));
        emailLabel.setForeground(Color.decode ( "#05203C" ));
        emailField.setBounds(50, 430, 330, 40);
        emailField.setBorder ( new RoundedBorder () );
        errorEmail.setHorizontalAlignment(SwingConstants.LEFT);
        errorEmail.setForeground(Color.decode("#db3125"));
        errorEmail.setBounds(50, 462, 300, 30);
        RedEmail.setHorizontalAlignment(SwingConstants.LEFT);
        RedEmail.setForeground(Color.decode("#db3125"));
        RedEmail.setBounds(50, 462, 300, 30);


        passwordLabel.setBounds(50, 480, 100, 30);
        passwordLabel.setFont(new Font("SansSerif",Font.BOLD, 15));
        passwordLabel.setForeground(Color.decode ( "#05203C" ));
        passwordField.setBounds(50, 510, 330, 40);
        passwordField.setBorder ( new RoundedBorder () );
        errorPassword.setHorizontalAlignment(SwingConstants.LEFT);
        errorPassword.setForeground(Color.decode("#db3125"));
        errorPassword.setBounds(50, 542, 300, 30);

        regButton.setBounds(50, 580, 330, 35);
        regButton.setBackground(Color.decode ( "#0B3E91" ));
        regButton.setForeground ( Color.white );
        regButton.setFont ( new Font("SansSeirf", Font.BOLD,15) );
        regButton.setBorder ( BorderFactory.createEmptyBorder () );
        regFrame.setVisible(true);


        if ( ThemeManager.isDarkMode ()) {
            setDarkMode();
        } else {
            setLightMode();
        }
    }

    private void setLightMode() {
        regPanel.setBackground(Color.decode("#ffffff"));
        topPanel.setBackground ( Color.decode ( "#28437a" ) );
        registerHeader.setForeground(Color.decode ( "#05203C" ));
        backButton.setBackground(Color.white);
        usernameLabel.setForeground(Color.decode ( "#05203C" ));
        emailLabel.setForeground(Color.decode ( "#05203C" ));
        passwordLabel.setForeground(Color.decode ( "#05203C" ));
        cloudsImg.setIcon ( scaledBg );
        ThemeManager.setDarkMode ( false );
    }

    private void setDarkMode() {
        regPanel.setBackground(Color.decode("#111827"));
        topPanel.setBackground ( Color.decode ( "#4877bd" ) );
        logoTxt.setForeground ( Color.white );
        registerHeader.setForeground(Color.decode ( "#ffffff" ));
        backButton.setBackground(Color.white);
        usernameLabel.setForeground(Color.decode ( "#ffffff" ));
        emailLabel.setForeground(Color.decode ( "#ffffff" ));
        passwordLabel.setForeground(Color.decode ( "#ffffff" ));
        cloudsImg.setIcon ( scaledBgD );
        ThemeManager.setDarkMode ( true );

    }

}