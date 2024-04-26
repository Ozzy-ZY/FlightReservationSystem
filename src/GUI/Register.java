package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import static Controllers.RegisterControl.*;

public class Register extends JFrame{

    boolean[] totalStatus = {false, false, false};
    JFrame registerFrame = new JFrame("Register");
    JPanel registerPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton registerButton = new JButton("Register");
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
        registerFrame.setSize(500, 600);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setIconImage(icon.getImage());
        registerFrame.setResizable(false);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.add(registerPanel);

        registerPanel.setLayout(null);
        registerPanel.add(usernameField);
        registerPanel.add(usernameLabel);
        registerPanel.add(passwordField);
        registerPanel.add(passwordLabel);
        registerPanel.add(backButton);
        registerPanel.add(registerHeader);
        registerPanel.add(emailField);
        registerPanel.add(emailLabel);
        registerPanel.add(registerButton);
        registerPanel.add(errorEmail);
        registerPanel.add(errorUsername);
        registerPanel.add(errorPassword);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                registerFrame.dispose();
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

        registerButton.addActionListener(new ActionListener() {
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
                    FlightsPage flights = new FlightsPage();
                    registerFrame.dispose();
                }
            }
        });

        registerPanel.setBackground(new Color(70, 109, 176));
        registerHeader.setFont(new Font("Arial", Font.BOLD, 18));
        registerHeader.setForeground(Color.CYAN);
        registerHeader.setBounds(230, 100, 100, 30);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.CYAN);

        emailLabel.setBounds(50, 150, 100, 30);
        emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
        emailField.setBounds(130, 150, 300, 30);
        errorEmail.setForeground(Color.RED);
        errorEmail.setBounds(115, 175, 300, 30);

        usernameLabel.setBounds(50, 200, 100, 30);
        usernameLabel.setFont(new Font("Arial",Font.BOLD, 15));
        usernameField.setBounds(130, 200, 300, 30);
        errorUsername.setForeground(Color.RED);
        errorUsername.setBounds(115, 225, 350, 30);

        passwordLabel.setBounds(50, 250, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordField.setBounds(130, 250, 300, 30);
        errorPassword.setForeground(Color.RED);
        errorPassword.setBounds(115, 275, 300, 30);

        registerButton.setBounds(200, 300, 100, 30);
        registerButton.setBackground(Color.GREEN);
        registerFrame.setVisible(true);
    }
}
