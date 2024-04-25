package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import static Controllers.LoginControl.*;

public class Login extends JFrame{

    boolean[] totalStatus = {false, false, false};
    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton loginButton = new JButton("Login");
    JTextField usernameField = new JTextField(30);
    JLabel registerHeader = new JLabel("Register");
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(30);
    JLabel usernameLabel = new JLabel("Username:");
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password:");
    JLabel errorEmail = new JLabel("Invalid Email");
    JLabel errorUsername = new JLabel("Username must be between 3 and 20 characters long");
    JLabel errorPassword = new JLabel("Passwords must be at least 8 characters long");
    public Login(){
        loginFrame.setSize(500, 600);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setIconImage(icon.getImage());
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.add(loginPanel);

        loginPanel.setLayout(null);
        loginPanel.add(usernameField);
        loginPanel.add(usernameLabel);
        loginPanel.add(passwordField);
        loginPanel.add(passwordLabel);
        loginPanel.add(backButton);
        loginPanel.add(registerHeader);
        loginPanel.add(emailField);
        loginPanel.add(emailLabel);
        loginPanel.add(loginButton);
        loginPanel.add(errorEmail);
        loginPanel.add(errorUsername);
        loginPanel.add(errorPassword);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                loginFrame.dispose();
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
                String password = Arrays.toString(passwordField.getPassword());
                if(ValidatePassword(password)){
                    totalStatus[2] = true;
                    errorPassword.setVisible(false);
                }
                else{
                errorPassword.setVisible(true);
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
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

                String password = Arrays.toString(passwordField.getPassword());
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
                    loginFrame.dispose();
                }
            }
        });

        loginPanel.setBackground(new Color(70, 109, 176));
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

        loginButton.setBounds(200, 300, 100, 30);
        loginButton.setBackground(Color.GREEN);
        loginFrame.setVisible(true);
    }
}
