package GUI;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD:src/GUI/Login.java
import java.awt.event.*;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
import java.util.Arrays;

import static Controllers.LoginControl.*;

public class Register extends JFrame{

<<<<<<< HEAD:src/GUI/Login.java
    boolean[] totalStatus={false,false,false};
    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton loginButton = new JButton("Login");
    JLabel loginHeader = new JLabel("Login");
    JLabel usernameoremailLabel = new JLabel("Username or Email:");
    JTextField usernameoremailField = new JTextField(30);
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password:");
    public Login()
    {
=======
    boolean[] totalStatus = {false, false, false};
    JFrame loginFrame = new JFrame("Register");
    JPanel loginPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton loginButton = new JButton("Register");
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
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
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
        loginPanel.add(usernameoremailField);
        loginPanel.add(usernameoremailLabel);
        loginPanel.add(loginButton);
        loginPanel.add(errorEmail);
        loginPanel.add(errorUsername);
        loginPanel.add(errorPassword);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e ->
        {
            HomePage homePage = new HomePage();
            loginFrame.dispose();
        });
<<<<<<< HEAD:src/GUI/Login.java
        usernameoremailField.addFocusListener(new FocusAdapter()
        {
=======

        emailField.addActionListener(new ActionListener() {
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
            @Override
            public void focusLost(FocusEvent e) {
                String usernameoremail = usernameoremailField.getText();
                if(ValidateEmail(usernameoremail)){
                    totalStatus[0] = true;
                    errorEmail.setVisible(false);
                }
                else{
                errorEmail.setVisible(true);
                }
<<<<<<< HEAD:src/GUI/Login.java
                else {
                    totalStatus[0] = false;
                }
                if(ValidateUsername(usernameoremail)){
=======
            }
        });

        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                if(ValidateUsername(username)){
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
                    totalStatus[1] = true;
                    errorUsername.setVisible(false);
                }
                else{
                errorUsername.setVisible(true);
                }
<<<<<<< HEAD:src/GUI/Login.java
                else {
                    totalStatus[1] = false;
                }
            }
        });
        passwordField.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e)
            {
                String password = Arrays.toString(passwordField.getPassword());
                if(ValidatePassword(password))
                {
=======
            }
        });

        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tostring(passwordField.getPassword());
                if(ValidatePassword(password)){
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
                    totalStatus[2] = true;
                    errorPassword.setVisible(false);
                }
                else{
                errorPassword.setVisible(true);
                }
<<<<<<< HEAD:src/GUI/Login.java
                else {
                    totalStatus[1] = false;
                }
            }
        });
            loginButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {

                    // Check all elements in totalStatus are true
                    if ((totalStatus[0] || totalStatus[1]) && totalStatus[2])
                    {
                        HomePage.status = true;
                        HomePage homePage = new HomePage();
                        loginFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Welcome back!");
                    }
                    else
                    {
                        // Unsuccessful Login: Provide feedback
                        String errorMessage = "Login failed: ";
                        if(!(totalStatus[0]||totalStatus[1]))
                            errorMessage+="\n Wrong Username or Email. ";
                            else if (!totalStatus[2])
                                errorMessage+="\n Wrong Password. ";
                                   else
                                       errorMessage+="Unknown error. ";

                        // Login panel refresh and retry prompt
                        loginPanel.revalidate();
                        loginPanel.repaint();
                        JOptionPane.showMessageDialog(null, errorMessage);

                    }
                }
            });
            loginPanel.setBackground(new Color(70, 109, 176));
            loginHeader.setFont(new Font("Arial", Font.BOLD, 18));
            loginHeader.setForeground(Color.CYAN);
            loginHeader.setBounds(230, 100, 100, 30);
            backButton.setBounds(0, 0, 50, 30);
            backButton.setBackground(Color.CYAN);
            usernameoremailLabel.setBounds(100, 150, 200, 30);
            usernameoremailLabel.setFont(new Font("Arial",Font.BOLD, 15));
            usernameoremailField.setBounds(100, 175, 300, 30);
            passwordLabel.setBounds(100, 225, 100, 30);
            passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
            passwordField.setBounds(100, 250, 300, 30);
            loginButton.setBounds(200, 300, 100, 30);
            loginButton.setBackground(Color.GREEN);
            loginFrame.setVisible(true);
            loginFrame.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
=======
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
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1:src/GUI/Register.java
    }
}
