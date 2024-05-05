package GUI;
import Controllers.LoginControl;
import Models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static Controllers.RegisterControl.*;

public class Login extends JFrame{



    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();

    ImageIcon bg = new ImageIcon("Assets/loginBG.png");
    ImageIcon scaledBg = new ImageIcon(bg.getImage().
            getScaledInstance(500, 600, Image.SCALE_SMOOTH));

    ImageIcon login = new ImageIcon("Assets/logo.png");
    ImageIcon scaledLogin = new ImageIcon(login.getImage().
            getScaledInstance(70, 50, Image.SCALE_SMOOTH));

    ImageIcon icon = new ImageIcon("Assets/logo.png");
    JButton backButton = new JButton("<");
    JButton loginButton = new JButton("Login");
    JLabel loginHeader = new JLabel("Login");
    JLabel emailLabel = new JLabel("Email or Username");
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
        loginButton.addActionListener(e -> {
            if(LoginControl.ValidateUser(emailField.getText(),
                    tostring(passwordField.getPassword()))){
                HomePage.currentUser = new User(emailField.getText(),
                        LoginControl.getUsername(emailField.getText()),
                        tostring(passwordField.getPassword()));
                HomePage.status = true;


                new HomePage();
                loginFrame.dispose();
            }
            else{
                errorLogin.setVisible(true);
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
        passwordLabel.setBounds(75, 225, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordLabel.setForeground(Color.decode("#05203C"));
        passwordField.setBounds(75, 250, 300, 35);
        passwordField.setSize (350, 35);
        loginButton.setBounds(75, 320, 100, 30);
        loginButton.setBackground(Color.decode("#0B3E91"));
        loginButton.setSize ( 350,40 );
        loginButton.setFont ( new Font("Arial", Font.BOLD,16) );
        loginButton.setForeground ( Color.white );
        errorLogin.setBounds(180, 290, 200, 30);
        errorLogin.setForeground(Color.decode("#db3125"));
        bgIcon.setBounds ( 150,-20,500,600 );
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


    }

}