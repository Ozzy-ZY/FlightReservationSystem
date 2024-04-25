package GUI;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
    static Boolean status = false;
    JFrame mainFrame = new JFrame("Right Flight");
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(500, 190, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel();
    JLabel loginLabel = new JLabel("..Login..");
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
        mainPanel.setLayout(null);
        mainPanel.add(logoLabel);
        mainPanel.add(welcomeLabel);
        mainPanel.add(Flights);
        mainPanel.add(Tickets);
        mainPanel.add(Account);

        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login login = new Login();
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
        loginLabel.setBounds(420, 190, 500, 30);
        logoLabel.setBounds(0, 0, 500, 190);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBounds(130, 200, 400, 30);
        Flights.setBounds(50, 250, 400, 30);
        Tickets.setBounds(50, 300, 400, 30);
        Account.setBounds(50, 350, 400, 30);
        mainFrame.setVisible(true);
    }
}