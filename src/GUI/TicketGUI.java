package GUI;

import javax.swing.*;
import java.awt.*;

import Models.Ticket;
import javax.swing.JPanel;

public class TicketGUI {

    private JFrame frame;
    ///////////////////////////////////////
    //use this to fill the ticket page data **URGENT**
    //private Ticket ticket = new Ticket();
    ///////////////////////////////////////
    public TicketGUI(Ticket ticket) {
        // Create a new JFrame
        frame = new JFrame( "Ticket");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 400);

        ImageIcon icon = new ImageIcon("Assets/airplane.png");
        ImageIcon scaledIcon = new ImageIcon(icon.getImage().
                getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        ImageIcon logo = new ImageIcon("Assets/logo.png");
        ImageIcon scaledLogo = new ImageIcon(logo.getImage().
                getScaledInstance(100, 80, Image.SCALE_SMOOTH));

        ImageIcon QR = new ImageIcon("qr_codes/" + ticket.getTicketID () + ".png");
        ImageIcon scaledQR = new ImageIcon(QR.getImage().
                getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        ImageIcon bg = new ImageIcon("Assets/bg.png");
        ImageIcon scaledBG = new ImageIcon(bg.getImage().
                getScaledInstance(700, 430, Image.SCALE_SMOOTH));

        // Create a panel for the north
        JPanel northPanel = new JPanel();
        northPanel.setLayout ( null );

        JLabel ticketTxt = new JLabel("Ticket ID.");
        ticketTxt.setForeground(Color.white);
        ticketTxt.setFont(new Font("Arial", Font.BOLD, 12));
        ticketTxt.setBounds(30, 15, 200, 20);
        northPanel.add(ticketTxt);
        northPanel.setBackground(Color.decode("#3E6BE8"));


        JLabel ticketID = new JLabel(ticket.getTicketID ());
        ticketID.setForeground(Color.white);
        ticketID.setBounds(30, 35, 200, 20);
        ticketID.setFont(new Font("Arial", Font.BOLD, 17));
        northPanel.add(ticketID);


        JLabel passengerTxt = new JLabel("Passenger");
        passengerTxt.setForeground(Color.white);
        passengerTxt.setFont(new Font("Arial", Font.BOLD, 12));
        passengerTxt.setBounds(280, 15, 200, 20);
        northPanel.add(passengerTxt);

        JLabel PassengerName = new JLabel(ticket.getPassenger ().getFirstName ().toUpperCase () + " " + ticket.getPassenger ().getLastName ().toUpperCase ());
        PassengerName.setForeground(Color.white);
        PassengerName.setBounds(280, 35, 200, 20);
        PassengerName.setFont(new Font("Arial", Font.BOLD, 18));
        northPanel.add(PassengerName);


        JLabel SeatTxt = new JLabel("SEAT");
        SeatTxt.setForeground(Color.white);
        SeatTxt.setBounds(500, 15, 100, 20);
        SeatTxt.setFont(new Font("Arial", Font.BOLD, 12));
        northPanel.add(SeatTxt);


        JLabel SeatNum = new JLabel(Integer.toString ( ticket.getSeatNumber () ));
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


        JLabel FromCity = new JLabel(ticket.getFlight ().getOrigin ());
        FromCity.setForeground(Color.decode ( "#0B3E91" ));
        FromCity.setBounds(0, 90, 200, 150);
        FromCity.setFont(new Font("Arial", Font.BOLD, 45));
        FromCity.setHorizontalAlignment ( JLabel.RIGHT );
        centerPanel.add(FromCity);


        JLabel planeIcon = new JLabel(scaledIcon);
        planeIcon.setBounds(40, 60, 450, 150);
        centerPanel.add(planeIcon);


        JLabel ToCity = new JLabel(ticket.getFlight ().getDestination ());
        ToCity.setForeground(Color.decode ( "#FD8F1C" ));
        ToCity.setBounds(320, 90, 450, 150);
        ToCity.setFont(new Font("Arial", Font.BOLD, 45));
        centerPanel.add(ToCity);


        JLabel logoIcon = new JLabel(scaledLogo);
        logoIcon.setBounds(0, 220, 150, 150);
        centerPanel.add(logoIcon);


        JLabel flightTxt = new JLabel("FLIGHT ID.");
        flightTxt.setForeground(Color.decode ( "#FD8F1C" ));
        flightTxt.setBounds(150, 280, 150, 20);
        flightTxt.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add( flightTxt );


        JLabel flightID = new JLabel(ticket.getTicketID ().split("_")[0]);
        flightID.setForeground(Color.decode ( "#002FA4" ));
        flightID.setBounds(150, 300, 150, 20);
        flightID.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add( flightID );

        JLabel dateText = new JLabel("DATE");
        dateText.setForeground(Color.decode ( "#FD8F1C" ));
        dateText.setBounds(340, 280, 150, 20);
        dateText.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(dateText);


        JLabel date = new JLabel(ticket.getFlight ().getDate ());
        date.setForeground(Color.decode ( "#002FA4" ));
        date.setBounds(340, 300, 150, 20);
        date.setFont(new Font("Arial", Font.BOLD, 12));
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


}