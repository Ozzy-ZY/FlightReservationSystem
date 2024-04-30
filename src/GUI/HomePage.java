package GUI;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class HomePage {
    static Boolean status = false;
    static User currentUser;
    JFrame mainFrame = new JFrame("Right Flight");
    ImageIcon icon = new ImageIcon("Assets/Right_Flight.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(300, 300, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel();
    JLabel currentUserLabel;
    JLabel regLabel = new JLabel("Register");
    JLabel loginLabel = new JLabel("Login");
    JLabel logoLabel = new JLabel(scaledIcon);
    JLabel welcomeLabel = new JLabel("Welcome to Right Flight!");
    JButton Flights = new JButton("Flights");
    JButton Tickets = new JButton("Tickets");
    JButton Account = new JButton("Account");
    JMenuItem option1Item = new JMenuItem("Option 1");
    JMenuItem signOutItem = new JMenuItem("Sign Out");
    JPopupMenu popupMenu = new JPopupMenu();
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
        popupMenu.add(option1Item);
        popupMenu.add(signOutItem);


        if(status) {
            regLabel.setVisible(false);
            loginLabel.setVisible(false);
            this.currentUserLabel = new JLabel(currentUser.getUsername());
            mainPanel.add(currentUserLabel);
            currentUserLabel.setVisible(true);
            currentUserLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            currentUserLabel.setForeground(Color.lightGray);
            currentUserLabel.setBounds(30, 10, currentUserLabel.getMinimumSize().width+10, currentUserLabel.getMinimumSize().height);

            currentUserLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked (MouseEvent e) {
                    if (expanded[0]) {
                        popupMenu.setVisible(false);
                        expanded[0] =false;
                    } else {
                        showPopupMenu();// Optional for highlighting
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    underlineLabel(currentUserLabel);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    removeUnderline(currentUserLabel);
                }
            });
            signOutItem.addMouseListener(new MouseAdapter() {
                @Override
                public void  mouseClicked(MouseEvent evt) {
                    // Code to handle "Sign Out" selection (e.g., confirm sign out)
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign out?");
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Perform sign out logic here
                    }
                }
            });


        }

        regLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                new Register();
                mainFrame.dispose();
            }
        });
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                new Login();
                mainFrame.dispose();
            }
        });
        Flights.addActionListener(e -> {
            if(!status){
                JOptionPane.showMessageDialog(mainFrame, "Please login to access this page");
                return;
            }
            new FlightsPage();
            mainFrame.dispose();
        });
        popupMenu.setPreferredSize(new Dimension(150, 100));
        regLabel.setFont(new Font("New", Font.ITALIC, 18));
        regLabel.setForeground(Color.lightGray);
        regLabel.setBounds(30, 10, 100, 30);
        loginLabel.setFont(new Font("New", Font.ITALIC, 18));
        loginLabel.setForeground(Color.lightGray);
        loginLabel.setBounds(460, 10, 100, 30);
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
    boolean[] expanded = {false};
    public void underlineLabel(JLabel label) {
        Map<TextAttribute, Object> fontAttributes = new HashMap<>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(label.getFont().deriveFont(fontAttributes));
    }
    public void removeUnderline(JLabel label) {
        if (label.getFont() != null) {
            Map<TextAttribute, Object> fontAttributes = new HashMap<>(label.getFont().getAttributes());
            fontAttributes.put(TextAttribute.UNDERLINE, -1);
            label.setFont(label.getFont().deriveFont(fontAttributes));
        }
    }
    public void showPopupMenu() {
        popupMenu.setVisible(true);
        expanded= new boolean[]{true};
        // Consider using a slightly larger offset for better positioning
        popupMenu.show(currentUserLabel, 0, currentUserLabel.getHeight()); // Show below the label
    }
}