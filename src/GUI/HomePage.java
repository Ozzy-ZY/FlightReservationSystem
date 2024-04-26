package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
    static Boolean status = false;
    JFrame mainFrame = new JFrame("Right Flight");
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(400, 300, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel();
    JLabel loginLabel = new JLabel("Register");
    JLabel logoLabel = new JLabel(scaledIcon);
    JLabel welcomeLabel = new JLabel("Welcome to Right Flight!");
    JButton Flights = new JButton("Flights");
    JButton Tickets = new JButton("Tickets");
    JButton Account = new JButton("Account");
    public HomePage(){
        mainFrame.setSize(550, 650);
        mainPanel.setBackground(Color.decode("#213D58"));
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
                Register login = new Register();
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

        loginLabel.setFont(new Font("New", Font.ITALIC, 18));
        loginLabel.setForeground(Color.lightGray);
        loginLabel.setBounds(30, 10, 500, 30);
        logoLabel.setBounds(0, 0, 525, 190);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.decode("#FFFFFF"));
        welcomeLabel.setBounds(135, 200, 400, 30);
        Flights.setBounds(75, 280, 400, 60);
        Flights.setFont(new Font("Arial", Font.BOLD, 18));
        Tickets.setBounds(75, 380, 400, 60);
        Tickets.setFont(new Font("Arial", Font.BOLD, 18));
        Account.setBounds(75, 480, 400, 60);
        Account.setFont(new Font("Arial", Font.BOLD, 18));

        mainFrame.setVisible(true);
    }
}