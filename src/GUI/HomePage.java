package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
    static Boolean status = false;
    JFrame mainFrame = new JFrame("Right Flight");
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(500, 190, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel();
<<<<<<< HEAD
    JLabel loginLabel = new JLabel("..Login..");
    JLabel signupLabel = new JLabel("..Sign Up..");
=======
    JLabel loginLabel = new JLabel("Register");
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
    JLabel logoLabel = new JLabel(scaledIcon);
    JLabel welcomeLabel = new JLabel("Welcome to Right Flight!");
    JButton Flights = new JButton("Flights");
    JButton Tickets = new JButton("Tickets");
    JButton Account = new JButton("Account");
    public HomePage(){
        mainFrame.setSize(500, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(mainPanel);

        mainPanel.add(loginLabel);
        mainPanel.add(signupLabel);
        mainPanel.setLayout(null);
        mainPanel.add(logoLabel);
        mainPanel.add(welcomeLabel);
        mainPanel.add(Flights);
        mainPanel.add(Tickets);
        mainPanel.add(Account);

<<<<<<< HEAD
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Login login = new Login();
=======
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Register login = new Register();
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
                mainFrame.dispose();
            }
        });
        signupLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SignUp signup = new SignUp();
                mainFrame.dispose();
            }
        });
        Flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!status){
                    JOptionPane.showMessageDialog(mainFrame, "Please login to access this page");
                    return;
                }
                FlightsPage Flight = new FlightsPage();
                mainFrame.dispose();
            }
        });

        loginLabel.setFont(new Font("New", Font.ITALIC, 16));
        loginLabel.setForeground(Color.BLUE);
<<<<<<< HEAD
        loginLabel.setBounds(420, 190, 500, 30);
        signupLabel.setFont(new Font("New", Font.ITALIC, 16));
        signupLabel.setForeground(Color.BLUE);
        signupLabel.setBounds(350, 190, 500, 30);
=======
        loginLabel.setBounds(410, 190, 500, 30);
>>>>>>> c2c28d7011fed7d44847ddee1edbf72a4f47adf1
        logoLabel.setBounds(0, 0, 500, 190);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBounds(130, 200, 400, 30);
        Flights.setBounds(50, 250, 400, 30);
        Tickets.setBounds(50, 300, 400, 30);
        Account.setBounds(50, 350, 400, 30);
        mainFrame.setVisible(true);
    }
}