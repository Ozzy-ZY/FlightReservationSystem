package GUI;

import javax.swing.*;
import java.awt.*;
import Models.Flight;
import Models.Plane;
import Models.Ticket;
import javax.swing.JPanel;
import static GUI.HomePage.*;

public class TicketGUI {

    private JFrame frame;
    ///////////////////////////////////////
    //use this to fill the ticket page data **URGENT**
    //private Ticket ticket = new Ticket();
    ///////////////////////////////////////
    public TicketGUI() {
        // Create a new JFrame
        frame = new JFrame( "Ticket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);

        ImageIcon icon = new ImageIcon("Assets/airplane.png");
        ImageIcon scaledIcon = new ImageIcon(icon.getImage().
                getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        ImageIcon logo = new ImageIcon("Assets/logo.png");
        ImageIcon scaledLogo = new ImageIcon(logo.getImage().
                getScaledInstance(100, 80, Image.SCALE_SMOOTH));

        ImageIcon QR = new ImageIcon("");
        ImageIcon scaledQR = new ImageIcon(QR.getImage().
                getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        ImageIcon bg = new ImageIcon("Assets/bg.png");
        ImageIcon scaledBG = new ImageIcon(bg.getImage().
                getScaledInstance(700, 430, Image.SCALE_SMOOTH));

        // Create a panel for the north
        JPanel northPanel = new JPanel();
        northPanel.setLayout ( null );

        JLabel flightText = new JLabel();
        flightText.setForeground(Color.white);
        flightText.setFont(new Font("Arial", Font.BOLD, 12));
        flightText.setBounds(30, 15, 200, 20);
        northPanel.add(flightText);
        northPanel.setBackground(Color.decode("#3E6BE8"));


        JLabel firstName = new JLabel();
        firstName.setForeground(Color.white);
        firstName.setBounds(30, 35, 200, 20);
        firstName.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(firstName);


        JLabel PassengerText = new JLabel("PASSENGER");
        PassengerText.setForeground(Color.white);
        PassengerText.setFont(new Font("Arial", Font.BOLD, 12));
        PassengerText.setBounds(280, 15, 200, 20);
        northPanel.add(PassengerText);

        JLabel PassengerName = new JLabel("ADEL KAIZER");
        PassengerName.setForeground(Color.white);
        PassengerName.setBounds(280, 35, 200, 20);
        PassengerName.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(PassengerName);


        JLabel SeatTxt = new JLabel("SEAT");
        SeatTxt.setForeground(Color.white);
        SeatTxt.setBounds(500, 15, 100, 20);
        SeatTxt.setFont(new Font("Arial", Font.BOLD, 12));
        northPanel.add(SeatTxt);


        JLabel SeatNum = new JLabel("A4");
        SeatNum.setForeground(Color.white);
        SeatNum.setBounds(500,35, 100, 23);
        SeatNum.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(SeatNum);


        northPanel.setBounds(0, 0, 700, 70);


        // Create a panel for the center
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(null);

        centerPanel.setBounds(0, 30, 700, 330);
        centerPanel.setBackground ( Color.decode ( "#E0E2E1" ) );


        JLabel FromCity = new JLabel();
        FromCity.setForeground(Color.decode ( "#0B3E91" ));
        FromCity.setBounds(0, 90, 250, 150);
        FromCity.setFont(new Font("Arial", Font.BOLD, 55));
        FromCity.setHorizontalAlignment ( JLabel.RIGHT );
        centerPanel.add(FromCity);


        JLabel planeIcon = new JLabel(scaledIcon);
        planeIcon.setBounds(105, 60, 450, 150);
        centerPanel.add(planeIcon);


        JLabel ToCity = new JLabel();
        ToCity.setForeground(Color.decode ( "#FD8F1C" ));
        ToCity.setBounds(400, 90, 450, 150);
        ToCity.setFont(new Font("Arial", Font.BOLD, 55));
        centerPanel.add(ToCity);


        JLabel logoIcon = new JLabel(scaledLogo);
        logoIcon.setBounds(0, 220, 150, 150);
        centerPanel.add(logoIcon);


        JLabel PassTxt = new JLabel("FLIGHT ID.");
        PassTxt.setForeground(Color.decode ( "#FD8F1C" ));
        PassTxt.setBounds(150, 280, 150, 20);
        PassTxt.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(PassTxt);


        JLabel PassNum = new JLabel();
        PassNum.setForeground(Color.decode ( "#002FA4" ));
        PassNum.setBounds(150, 300, 150, 20);
        PassNum.setFont(new Font("Arial", Font.BOLD, 23));
        centerPanel.add(PassNum);

        JLabel dateText = new JLabel("DATE");
        dateText.setForeground(Color.decode ( "#FD8F1C" ));
        dateText.setBounds(280, 280, 150, 20);
        dateText.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(dateText);


        JLabel date = new JLabel();
        date.setForeground(Color.decode ( "#002FA4" ));
        date.setBounds(280, 300, 150, 20);
        date.setFont(new Font("Arial", Font.BOLD, 23));
        centerPanel.add(date);




        JLabel QRico = new JLabel(scaledQR);
        QRico.setBounds(515, 240, 100, 100);
        centerPanel.add(QRico);

        JPanel square = new JPanel ();
        square.setSize ( 100,100 );
        square.setBackground (  new Color(169, 172, 176, 80));
        square.setBounds(515, 240, 100, 100);
        centerPanel.add ( square );



        JLabel bgIco = new JLabel(scaledBG);
        bgIco.setBounds(-50, 50, 700, 330);
        centerPanel.add(bgIco);



        // Add panels to the frame
        frame.add(northPanel);
        frame.add(centerPanel);

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        TicketGUI start = new TicketGUI();
    }

}