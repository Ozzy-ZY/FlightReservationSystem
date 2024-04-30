package GUI;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
    static Boolean status = false;
    static User currentUser;
    JFrame mainFrame = new JFrame("Right Flight");
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(500, 200, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(36, 10, 52);
            Color color2 = new Color(137, 22, 82);
            GradientPaint gp = new GradientPaint(0, 750, color2, width, height, color1);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    };
    JLabel currentUserLabel = new JLabel();
    JLabel regLabel = new JLabel("Register");
    JLabel loginLabel = new JLabel("Login");
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

        mainPanel.add(regLabel);
        mainPanel.add(loginLabel);
        mainPanel.setLayout(null);
        mainPanel.add(logoLabel);
        mainPanel.add(welcomeLabel);
        mainPanel.add(Flights);
        mainPanel.add(Tickets);
        mainPanel.add(Account);
        mainPanel.add(currentUserLabel);

        currentUserLabel.setVisible(false);
        if(status){
            regLabel.setVisible(false);
            loginLabel.setVisible(false);
            currentUserLabel.setText(currentUser.getUsername());
            currentUserLabel.setVisible(true);
        }
        regLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Register register = new Register();
                mainFrame.dispose();
            }
        });
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

        regLabel.setFont(new Font("New", Font.ITALIC, 18));
        regLabel.setForeground(Color.decode("#ffffff"));
        regLabel.setBounds(30, 10, 100, 30);
        loginLabel.setFont(new Font("New", Font.ITALIC, 18));
        loginLabel.setForeground(Color.white);
        loginLabel.setBounds(460, 10, 100, 30);
        logoLabel.setBounds(0, 0, 525, 190);
        currentUserLabel.setFont(new Font("Arial", Font.BOLD, 18));
        currentUserLabel.setForeground(Color.lightGray);
        currentUserLabel.setBounds(30, 10, 300, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.decode("#ffffff"));
        welcomeLabel.setBounds(135, 200, 400, 30);
        Flights.setBounds(75, 280, 400, 60);
        Flights.setBackground(Color.decode("#FFEDD8"));
        Flights.setFont(new Font("Arial", Font.BOLD, 18));
        Flights.setForeground(Color.decode("#401F71"));
        Tickets.setBounds(75, 380, 400, 60);
        Tickets.setFont(new Font("Arial", Font.BOLD, 18));
        Tickets.setBackground(Color.decode("#FFEDD8"));
        Tickets.setForeground(Color.decode("#401F71"));
        Account.setBounds(75, 480, 400, 60);
        Account.setBackground(Color.decode("#FFEDD8"));
        Account.setFont(new Font("Arial", Font.BOLD, 18));
        Account.setForeground(Color.decode("#401F71"));

        mainFrame.setVisible(true);
    }
}