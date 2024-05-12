package GUI;

import Models.Ticket;
import Utils.FileManager;

import javax.swing.*;
import java.awt.*;

public class TicketsPage extends JFrame {
    JFrame frame = new JFrame ("Your Tickets");
    ImageIcon logo = new ImageIcon ("Assets/logo.png");
    JPanel panel = new JPanel (null);
    JLabel subHeading = new JLabel ("This is,");
    JLabel heading = new JLabel ("<html> Your Reserved <br> Tickets");


    public TicketsPage(){
        String[] ticketIDs = FileManager.GetEveryTicketIDGivenUsername(HomePage.currentUser.getUsername());
        JButton[] buttons = new JButton[ticketIDs.length];
        frame.setSize(400, 550);
        frame.setBackground( Color.decode("#FFFFFF"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo.getImage());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        panel.add(subHeading);
        panel.add ( heading );


        subHeading.setBounds (20,20,300,50  );
        subHeading.setFont ( new Font ( "SansSerif", Font.BOLD,25 ) );
        subHeading.setForeground ( Color.decode ( "#FD9426" ) );
        heading.setBounds (20,60,360,120  );
        heading.setFont ( new Font ( "SansSerif", Font.BOLD,50 ) );
        heading.setForeground ( Color.decode ( "#0B3E91" ) );

        int gap = 220;
        for (int i=0 ; i < ticketIDs.length; i++){
            buttons[i] = new JButton("Ticket " + (i + 1));
            buttons[i].setBounds ( 20,gap,340,60 );
            buttons[i].setFont(new Font("Arial", Font.BOLD, 18));
            buttons[i].setForeground ( Color.white );
            buttons[i].setBackground ( Color.decode ( "#0B3E91" ) );
            buttons[i].setBorder ( BorderFactory.createEmptyBorder () );

            gap+=80;
            panel.add(buttons[i]);

        }
        frame.add(panel);
        frame.setVisible ( true );
    }

}

