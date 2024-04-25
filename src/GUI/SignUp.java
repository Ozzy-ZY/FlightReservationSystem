package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static Controllers.SignUpControl.*;

public class SignUp extends JFrame{

    boolean[] totalStatus={false,false,false};
    JFrame SignUpFrame = new JFrame("Sign up");
    JPanel SignUpPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JButton SignUpButton = new JButton("Sign up");
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
    public SignUp()
    {
        SignUpFrame.setSize(500, 600);
        SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SignUpFrame.setIconImage(icon.getImage());
        SignUpFrame.setResizable(false);
        SignUpFrame.setLocationRelativeTo(null);
        SignUpFrame.add(SignUpPanel);

        SignUpPanel.setLayout(null);
        SignUpPanel.add(usernameField);
        SignUpPanel.add(usernameLabel);
        SignUpPanel.add(passwordField);
        SignUpPanel.add(passwordLabel);
        SignUpPanel.add(backButton);
        SignUpPanel.add(registerHeader);
        SignUpPanel.add(emailField);
        SignUpPanel.add(emailLabel);
        SignUpPanel.add(SignUpButton);
        SignUpPanel.add(errorEmail);
        SignUpPanel.add(errorUsername);
        SignUpPanel.add(errorPassword);

        errorEmail.setVisible(false);
        errorUsername.setVisible(false);
        errorPassword.setVisible(false);

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e ->
        {
            HomePage homePage = new HomePage();
            SignUpFrame.dispose();
        });
        emailField.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) {
                String email = emailField.getText();
                if(ValidateEmail(email)){
                    totalStatus[0] = true;
                    errorEmail.setVisible(false);
                }
                else {
                    totalStatus[0] = false;
                    errorEmail.setVisible(true);
                }
            }
        });
        usernameField.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) {
                String username = usernameField.getText();
                if(ValidateUsername(username)){
                    totalStatus[1] = true;
                    errorUsername.setVisible(false);
                }
                else {
                    totalStatus[1] = false;
                    errorUsername.setVisible(true);
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
                    totalStatus[2] = true;
                    errorPassword.setVisible(false);
                }
                else {
                    totalStatus[2] = false;
                    errorPassword.setVisible(true);
                }
            }
        });
            SignUpButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {

                    // Check all elements in totalStatus are true
                    if (totalStatus[0] && totalStatus[1] && totalStatus[2])
                    {
                        HomePage.status = true;
                        HomePage homePage = new HomePage();
                        SignUpFrame.dispose();
                        JOptionPane.showMessageDialog(null, "SignUp Successful!");
                    }
                }
            });
            SignUpPanel.setBackground(new Color(70, 109, 176));
            registerHeader.setFont(new Font("Arial", Font.BOLD, 18));
            registerHeader.setForeground(Color.CYAN);
            registerHeader.setBounds(230, 100, 100, 30);
            backButton.setBounds(0, 0, 50, 30);
            backButton.setBackground(Color.CYAN);

            emailLabel.setBounds(50, 150, 100, 30);
            emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
            emailField.setBounds(115, 150, 300, 30);
            errorEmail.setForeground(Color.RED);
            errorEmail.setBounds(115, 175, 300, 30);

            usernameLabel.setBounds(25, 200, 100, 30);
            usernameLabel.setFont(new Font("Arial",Font.BOLD, 15));
            usernameField.setBounds(115, 200, 300, 30);
            errorUsername.setForeground(Color.RED);
            errorUsername.setBounds(115, 225, 350, 30);

            passwordLabel.setBounds(25, 250, 100, 30);
            passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
            passwordField.setBounds(115, 250, 300, 30);
            errorPassword.setForeground(Color.RED);
            errorPassword.setBounds(115, 275, 300, 30);

            SignUpButton.setBounds(200, 300, 100, 30);
            SignUpButton.setBackground(Color.GREEN);
            SignUpFrame.setVisible(true);
            SignUpFrame.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
    }
}
