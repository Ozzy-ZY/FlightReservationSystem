package GUI;
import Controllers.LoginControl;
import Models.User;
import Utils.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Controllers.LoginControl.getUsername;
import static Controllers.SessionControl.*;
import static Controllers.RegisterControl.*;

import static Controllers.LoginControl.*;

import Controllers.ThemeManager;


public class Login extends JFrame{



    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();

    ImageIcon bg = new ImageIcon("Assets/loginBG.png");
    ImageIcon scaledBg = new ImageIcon(bg.getImage().
            getScaledInstance(500, 600, Image.SCALE_SMOOTH));

    ImageIcon bgD = new ImageIcon("Assets/loginBGD.png");

    ImageIcon scaledBgD = new ImageIcon(bgD.getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH));

    ImageIcon login = new ImageIcon("Assets/logo.png");
    ImageIcon scaledLogin = new ImageIcon(login.getImage().
            getScaledInstance(70, 50, Image.SCALE_SMOOTH));
    JLabel regLabel = new JLabel("Register");

    ImageIcon icon = new ImageIcon("Assets/logo.png");
    JButton backButton = new JButton("<");
    JButton loginButton = new JButton("Login");
    JLabel loginHeader = new JLabel("Login");
    JLabel emailLabel = new JLabel("Email or Username");
    JLabel haveAcc=new JLabel("Don't Have an Account ? " );
    JLabel bgIcon = new JLabel (scaledBg);
    JLabel loginIcon = new JLabel (scaledLogin);

    JTextField emailField = new JTextField(30);
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password");
    JLabel errorLogin = new JLabel("Invalid Email or Password");
    public Login()
    {
        loginFrame.setSize(500, 600);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setIconImage(icon.getImage());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.add(haveAcc);
        loginPanel.add(regLabel);
        loginPanel.add(loginIcon);
        loginPanel.add(passwordField);
        loginPanel.add(passwordLabel);
        loginPanel.add(backButton);
        loginPanel.add(loginHeader);
        loginPanel.add(emailField);
        loginPanel.add(emailLabel);
        loginPanel.add(loginButton);
        loginPanel.add(errorLogin);
        loginPanel.add(bgIcon);
        errorLogin.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e ->
        {
            new HomePage();
            loginFrame.dispose();
        });
        haveAcc.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                new Register(); // Open the Register frame

                loginFrame.dispose(); // Dispose of the current Login frame

            }

        });
        loginButton.addActionListener(e -> {
            int flag = LoginControl.ValidateUser(emailField.getText(),

                    tostring(passwordField.getPassword()));

            if (flag == EMAIL_VALID) {
                HomePage.currentUser = new User(emailField.getText(),

                        getUsername(emailField.getText()),

                        tostring(passwordField.getPassword()));

                generateToken(new User(emailField.getText(), getUsername(emailField.getText()),

                        tostring(passwordField.getPassword())));

                new HomePage();

                loginFrame.dispose();

            } else if (flag == USERNAME_VALID) {

                HomePage.currentUser = new User(getEmail(emailField.getText())

                        , emailField.getText(), tostring(passwordField.getPassword()));

                generateToken(new User(getEmail(emailField.getText())

                        , emailField.getText(), tostring(passwordField.getPassword())));

                new HomePage();

                loginFrame.dispose();

            }
        });

        regLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Register();
                loginFrame.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {HomePage.underlineLabel(regLabel);}
            @Override
            public void mouseExited(MouseEvent e) {
                HomePage.removeUnderline(regLabel);
            }
        });
        loginIcon.setBounds ( 230,40,50,50 );
        loginPanel.setBackground(Color.decode("#f6f6f6"));
        loginHeader.setFont(new Font("Arial", Font.BOLD, 35));
        loginHeader.setForeground(Color.decode("#05203C"));
        loginHeader.setBounds(210, 70, 200, 80);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.decode("#f1f1f1"));
        emailLabel.setBounds(75, 150, 200, 30);
        emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
        emailLabel.setForeground(Color.decode("#05203C"));
        emailField.setBounds(75, 175, 300, 30);
        emailField.setSize (350, 35);
        emailField.setBorder ( new RoundedBorder () );
        passwordLabel.setBounds(75, 225, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordLabel.setForeground(Color.decode("#05203C"));
        passwordField.setBounds(75, 250, 300, 35);
        passwordField.setSize (350, 35);
        passwordField.setBorder ( new RoundedBorder() );
        loginButton.setBounds(75, 320, 100, 30);
        loginButton.setBackground(Color.decode("#0B3E91"));
        loginButton.setSize ( 350,40 );
        loginButton.setFont ( new Font("Arial", Font.BOLD,16) );
        loginButton.setForeground ( Color.white );
        loginButton.setBorder ( BorderFactory.createEmptyBorder () );
        errorLogin.setBounds(180, 290, 200, 30);
        errorLogin.setForeground(Color.decode("#db3125"));
        haveAcc.setBounds(75,365,haveAcc.getMinimumSize().width,haveAcc.getMinimumSize().height);
        haveAcc.setForeground(Color.decode("#05203C"));
        regLabel.setBounds(haveAcc.getX()+haveAcc.getWidth(),haveAcc.getY(),regLabel.getMinimumSize().width,haveAcc.getMinimumSize().height);
        regLabel.setFont(new Font("Arial", Font.BOLD, 12));
        regLabel.setForeground(Color.decode("#05203C"));
        bgIcon.setBounds ( 150,-20,500,600 );
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        backButton.setFocusPainted(false);
        loginButton.setFocusPainted(false);

        if ( ThemeManager.isDarkMode ()) {

            setDarkMode();

        } else {

            setLightMode();

        }

    }



    private void setLightMode() {

        loginPanel.setBackground(Color.decode("#f6f6f6"));

        loginHeader.setForeground(Color.decode("#05203C"));

        backButton.setBackground(Color.decode("#f1f1f1"));

        emailLabel.setForeground(Color.decode("#05203C"));

        emailField.setBackground (Color.decode("#f6f6f6"));

        emailField.setForeground ( Color.decode("#000000") );

        passwordLabel.setForeground(Color.decode("#05203C"));

        passwordField.setBackground (Color.decode("#f6f6f6"));

        passwordField.setForeground ( Color.decode("#000000") );

        haveAcc.setForeground(Color.decode("#05203C"));

        bgIcon.setIcon ( scaledBg );

        bgIcon.setBounds ( 150,-20,500,600 );

        ThemeManager.setDarkMode ( false );

    }



    private void setDarkMode() {

        loginPanel.setBackground(Color.decode("#111827"));

        loginHeader.setForeground(Color.decode("#ffffff"));

        backButton.setBackground(Color.decode("#f1f1f1"));

        emailLabel.setForeground(Color.decode("#ffffff"));

        emailField.setBackground (Color.decode("#111827"));

        emailField.setForeground ( Color.decode("#ffffff") );

        passwordLabel.setForeground(Color.decode("#ffffff"));

        passwordField.setBackground (Color.decode("#111827"));

        passwordField.setForeground ( Color.decode("#ffffff") );

        haveAcc.setForeground(Color.decode("#ffffff"));

        bgIcon.setIcon (scaledBgD);

        bgIcon.setBounds ( -280,0,500,600 );

        ThemeManager.setDarkMode ( true );
    }

}