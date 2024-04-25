package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static Controllers.LoginControl.*;

public class Login extends JFrame{

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

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(e ->
        {
            HomePage homePage = new HomePage();
            loginFrame.dispose();
        });
        usernameoremailField.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusLost(FocusEvent e) {
                String usernameoremail = usernameoremailField.getText();
                if(ValidateEmail(usernameoremail)){
                    totalStatus[0] = true;
                }
                else {
                    totalStatus[0] = false;
                }
                if(ValidateUsername(usernameoremail)){
                    totalStatus[1] = true;
                }
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
                    totalStatus[2] = true;
                }
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
    }
}