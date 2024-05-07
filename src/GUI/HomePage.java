package GUI;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.util.HashMap;
import java.util.Map;
import static Controllers.SessionControl.*;
public class HomePage {


    static boolean status = false;
    static User currentUser;
    JFrame mainFrame = new JFrame("Rihla Flights");

    ImageIcon logo = new ImageIcon ("Assets/logo.png");
    ImageIcon icon = new ImageIcon("Assets/image-removebg-preview.png");
    ImageIcon scaledIcon = new ImageIcon(icon.getImage().
            getScaledInstance(300, 130, Image.SCALE_SMOOTH));

    ImageIcon bg = new ImageIcon("Assets/homeBg.png");
    ImageIcon scaledBg = new ImageIcon(bg.getImage().
            getScaledInstance(550, 650, Image.SCALE_SMOOTH));
    JPanel mainPanel = new JPanel();
    JLabel currentUserLabel;
    JLabel regLabel = new JLabel("Register");
    JLabel loginLabel = new JLabel("Login");
    JLabel logoLabel = new JLabel(scaledIcon);
    JLabel bgLabel = new JLabel(scaledBg);

    JLabel welcomeLabel = new JLabel("Welcome to Rihla Flight!");
    JButton Flights = new JButton("Flights");
    JButton Tickets = new JButton("Tickets");
    JButton Account = new JButton("Account");
    JMenuItem signOutItem = new JMenuItem("Sign Out");
    JPopupMenu popupMenu = new JPopupMenu();
    public HomePage() {
        if(tokenExists()){
            status = true;
            currentUser = returnTokenData();
        }
        else
            status = false;
        mainFrame.setSize(550, 650);
        mainPanel.setBackground(Color.decode("#FFFFFF"));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setIconImage(logo.getImage());
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        mainPanel.add(regLabel);
        mainPanel.add(loginLabel);
        mainPanel.setLayout(null);
        mainPanel.add(logoLabel);
        mainPanel.add(welcomeLabel);
        mainPanel.add(Flights);
        mainPanel.add(Tickets);
        mainPanel.add(Account);
        mainPanel.add(bgLabel);
        popupMenu.add(signOutItem);


        mainFrame.add(mainPanel);


        if (status) {
            regLabel.setVisible(false);
            loginLabel.setVisible(false);
            this.currentUserLabel = new JLabel(currentUser.getUsername());
            mainPanel.add(currentUserLabel);
            currentUserLabel.setVisible(true);
            currentUserLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            currentUserLabel.setForeground(Color.decode("#FD9426"));
            currentUserLabel.setBounds(30, 10, currentUserLabel.getMinimumSize().width + 10, currentUserLabel.getMinimumSize().height);

            mainFrame.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (entered)
                    {
                        entered=false;
                        exited = false;
                    }
                    else
                        exited = true;
                }
            });
            currentUserLabel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    //currentUserLabel.setForeground(Color.yellow);
                    if (entered && !exited) {
                        entered = false;
                        exited = true;
                        popupMenu.setVisible(false);

                    }
                    else  {
                        entered = true;
                        exited = false;
                        showPopupMenu(currentUserLabel, currentUserLabel.getWidth() / 2, currentUserLabel.getHeight());
                    }

                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    underlineLabel(currentUserLabel);
                    if(!popupMenu.isVisible())
                    {
                        entered=false;
                        exited=true;
                    }
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    removeUnderline(currentUserLabel);
                }
            });
            signOutItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    handleSignOut();
                }
            });
        }
        regLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Register();
                mainFrame.dispose();
            }
        });
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
        Account.addActionListener(e -> {
            if(!status){
                JOptionPane.showMessageDialog(mainFrame, "Please login to access this page");
                return;
            }
            new AccountPage();
            mainFrame.dispose();
        });
        popupMenu.setPreferredSize(new Dimension(75, 30));
        regLabel.setFont(new Font("New", Font.ITALIC, 18));
        regLabel.setForeground(Color.decode ( "#FD9426" ));
        regLabel.setBounds(30, 10, 100, 30);
        loginLabel.setFont(new Font("New", Font.ITALIC, 18));
        loginLabel.setForeground(Color.decode ( "#FD9426" ));
        loginLabel.setBounds(460, 10, 100, 30);
        logoLabel.setBounds(0, 50, 525, 150);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.decode("#05203C"));
        welcomeLabel.setBounds(135, 200, 400, 30);
        Flights.setBounds(75, 280, 400, 60);
        Flights.setFont(new Font("Arial", Font.BOLD, 18));
        Flights.setForeground ( Color.white );
        Flights.setBackground ( Color.decode ( "#0B3E91" ) );
        Tickets.setBounds(75, 380, 400, 60);
        Tickets.setForeground ( Color.white );
        Tickets.setBackground ( Color.decode ( "#0B3E91" ) );
        Tickets.setFont(new Font("Arial", Font.BOLD, 18));
        Account.setBounds(75, 480, 400, 60);
        Account.setFont(new Font("Arial", Font.BOLD, 18));
        Account.setForeground ( Color.white );
        Account.setBackground ( Color.decode ( "#0B3E91" ) );
        bgLabel.setBounds ( 0,0,550,650 );

        mainFrame.setVisible(true);
    }
    private void handleSignOut() {
        String message = "Are you sure you want to sign out?\nYour unsaved work will be lost.";
        String title = "Confirmation: Sign Out";
        int confirmation = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            performSignOut();
        }

    }

    private void performSignOut() {
        if(tokenExists()){
            if(!removeToken()){
                System.err.println("error deleting current token");
            }
        }
        new HomePage();
        mainFrame.dispose();
    }
    boolean entered = false;
    boolean exited = true;

    public void showPopupMenu(JLabel label, int x, int y) {
        popupMenu.show(label, x, y);
    }
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
}