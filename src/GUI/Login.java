package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class Login extends JFrame{
    JFrame loginFrame = new JFrame("Login");
    JPanel loginPanel = new JPanel();
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    JButton backButton = new JButton("<<--");
    JTextField usernameField = new JTextField(30);
    JLabel registerHeader = new JLabel("Register");
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(30);
    JLabel usernameLabel = new JLabel("Username:");
    JPasswordField passwordField = new JPasswordField(30);
    JLabel passwordLabel = new JLabel("Password:");
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

        backButton.setLayout(new BorderLayout());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                loginFrame.dispose();
            }
        });
        usernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = Arrays.toString(passwordField.getPassword());
                if(username.equals("admin") && password.equals("admin")){
                    FlightsPage flights = new FlightsPage();
                    loginFrame.dispose();
                }
            }
        });
        loginPanel.setBackground(new Color(70, 109, 176));
        registerHeader.setFont(new Font("Arial", Font.BOLD, 18));
        registerHeader.setForeground(Color.CYAN);
        registerHeader.setBounds(250, 100, 100, 30);
        backButton.setBounds(0, 0, 50, 30);
        backButton.setBackground(Color.CYAN);
        emailLabel.setBounds(70, 150, 100, 30);
        emailLabel.setFont(new Font("Arial",Font.BOLD, 15));
        emailField.setBounds(150, 150, 300, 30);
        usernameLabel.setBounds(70, 200, 100, 30);
        usernameLabel.setFont(new Font("Arial",Font.BOLD, 15));
        usernameField.setBounds(150, 200, 300, 30);
        passwordLabel.setBounds(70, 250, 100, 30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD, 15));
        passwordField.setBounds(150, 250, 300, 30);
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
