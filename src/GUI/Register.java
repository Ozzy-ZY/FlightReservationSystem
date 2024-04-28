package GUI;
import Controllers.LoginControl;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controllers.RegisterControl.*;

public class Register extends JFrame{

    boolean[] totalStatus = {false, false, false};
    JFrame regFrame = new JFrame("Register");
    JPanel regPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton regButton = new JButton("Register");
    JTextField usernameField = new JTextField(30);
    JLabel registerHeader = new JLabel("Register");
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(30);
    JLabel usernameLabel = new JLabel("Username:");
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password:");
    JLabel errorEmail = new JLabel("Invalid Email");
    JLabel errorUsername = new JLabel("Username must be between 3 and 20 characters long");
    JLabel errorPassword = new JLabel("Please enter a valid password");
    public Register(){
        regFrame.setSize(500, 600);
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setIconImage(icon.getImage());
        regFrame.setResizable(false);
        regFrame.setLocationRelativeTo(null);
        regFrame.add(regPanel);

        regPanel.setLayout(null);
        regPanel.add(usernameField);
        regPanel.add(usernameLabel);
        regPanel.add(passwordField);
        regPanel.add(passwordLabel);
        regPanel.add(backButton);
        regPanel.add(registerHeader);
        regPanel.add(emailField);
        regPanel.add(emailLabel);
        regPanel.add(regButton);
        regPanel.add(errorEmail);
        regPanel.add(errorUsername);
        regPanel.add(errorPassword);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                regFrame.dispose();
            }
        });

        emailField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if(ValidateEmail(email)){
                    totalStatus[0] = true;
                    errorEmail.setVisible(false);
                }
                else{
                errorEmail.setVisible(true);
                }
            }
        });

        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if(ValidateUsername(username)){
                    totalStatus[1] = true;
                    errorUsername.setVisible(false);
                }
                else{
                errorUsername.setVisible(true);
                }
            }
        });

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tostring(passwordField.getPassword());
                if(ValidatePassword(password)){
                    totalStatus[2] = true;
                    errorPassword.setVisible(false);
                }
                else{
                errorPassword.setVisible(true);
                }
            }
        });

        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if(ValidateEmail(email)){
                    totalStatus[0] = true;
                    errorEmail.setVisible(false);
                }
                else{
                    errorEmail.setVisible(true);
                }

                String username = usernameField.getText();
                if(ValidateUsername(username)){
                    totalStatus[1] = true;
                    errorUsername.setVisible(false);
                }
                else{
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
                    HomePage.status = true;
                    HomePage.currentUser = new User(emailField.getText(),
                            LoginControl.getUsername(emailField.getText()),
                            tostring(passwordField.getPassword()));
                    saveData(email, username, password);
                    FlightsPage flights = new FlightsPage();
                    regFrame.dispose();
                }
            }
        });

        regPanel.setBackground(Color.decode("#213D58"));
        registerHeader.setFont(new Font("Arial", Font.BOLD, 18));
        registerHeader.setForeground(Color.white);
        registerHeader.setBounds(230, 100, 100, 30);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.white);

        emailLabel.setBounds(50, 150, 100, 30);
        emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
        emailLabel.setForeground(Color.white);
        emailField.setBounds(130, 150, 300, 30);
        errorEmail.setHorizontalAlignment(SwingConstants.LEFT);
        errorEmail.setForeground(Color.decode("#db3125"));
        errorEmail.setBounds(130, 175, 300, 30);


        usernameLabel.setBounds(50, 200, 100, 30);
        usernameLabel.setFont(new Font("Arial",Font.BOLD, 15));
        usernameLabel.setForeground(Color.white);
        usernameField.setBounds(130, 200, 300, 30);
        errorUsername.setHorizontalAlignment(SwingConstants.LEFT);
        errorUsername.setForeground(Color.decode("#db3125"));
        errorUsername.setBounds(130, 225, 350, 30);


        passwordLabel.setBounds(50, 250, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordLabel.setForeground(Color.white);
        passwordField.setBounds(130, 250, 300, 30);
        errorPassword.setHorizontalAlignment(SwingConstants.LEFT);
        errorPassword.setForeground(Color.decode("#db3125"));
        errorPassword.setBounds(130, 275, 300, 30);


        regButton.setBounds(200, 300, 100, 30);
        regButton.setBackground(Color.white);
        regFrame.setVisible(true);
    }
}
