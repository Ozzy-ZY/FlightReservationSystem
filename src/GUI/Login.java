package GUI;

import Controllers.LoginControl;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static Controllers.RegisterControl.*;

public class Login extends JFrame{
    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton loginButton = new JButton("Login");
    JLabel loginHeader = new JLabel("Login");
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(30);
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password:");
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
        loginPanel.add(passwordField);
        loginPanel.add(passwordLabel);
        loginPanel.add(backButton);
        loginPanel.add(loginHeader);
        loginPanel.add(emailField);
        loginPanel.add(emailLabel);
        loginPanel.add(loginButton);
        loginPanel.add(errorLogin);

        errorLogin.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e ->
        {
            HomePage homePage = new HomePage();
            loginFrame.dispose();
        });
        loginButton.addActionListener(e -> {
            if(LoginControl.ValidateUser(emailField.getText(),
                    tostring(passwordField.getPassword()))){
                HomePage.currentUser = new User(emailField.getText(),
                        LoginControl.getUsername(emailField.getText()),
                        tostring(passwordField.getPassword()));
                HomePage.status = true;
                FlightsPage flightsPage = new FlightsPage();
                loginFrame.dispose();
            }
            else{
                errorLogin.setVisible(true);
            }
        });
        loginPanel.setBackground(Color.decode("#213D58"));
        loginHeader.setFont(new Font("Arial", Font.BOLD, 18));
        loginHeader.setForeground(Color.white);
        loginHeader.setBounds(230, 100, 100, 30);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);
        emailLabel.setBounds(100, 150, 200, 30);
        emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
        emailLabel.setForeground(Color.white);
        emailField.setBounds(100, 175, 300, 30);
        passwordLabel.setBounds(100, 225, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordLabel.setForeground(Color.white);
        passwordField.setBounds(100, 250, 300, 30);
        loginButton.setBounds(200, 300, 100, 30);
        loginButton.setBackground(Color.white);
        errorLogin.setBounds(180, 350, 200, 30);
        errorLogin.setForeground(Color.decode("#db3125"));
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