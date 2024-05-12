package Utils;
import Models.Ticket;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {
    public static void write(String path, String data) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public static String read(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return content.toString();
    }
    
    public static void append(String path, String data) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }

    public static void deleteLine(String filePath,String lineToDelete) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        lines.removeIf(line -> line.equals(lineToDelete));
        Files.write(Path.of(filePath), lines);
    }
    public static void replaceLines(String filePath, String lineToReplace, String newLine) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(lineToReplace)) {
                lines.set(i, newLine);
            }
        }
        Files.write(Path.of(filePath), lines);
    }

    public static boolean isFileEmpty(String path){
        File file = new File(path);
        return file.length() == 0;
    }
    public static String[] GetEveryTicketIDGivenUsername(String username) {
            var data = read("tickets/" + username + "Tickets.txt");
            var dataArr = data.split("\n");
            String[] EveryTicketID = new String[dataArr.length];
            int i = 0;
            for (var ticket : dataArr) {
                var ticketData = ticket.split("-");
                EveryTicketID[i] = ticketData[0];
                i++;
            }
            return EveryTicketID;
    }
    public static Ticket[] GetEveryTicketGivenUsername(String username) {
        var data = read("tickets/" + username + "Tickets.txt");
        var dataArr = data.split("\n");
        Ticket[] EveryTicket = new Ticket[dataArr.length];
        int i = 0;
        for (var ticket : dataArr) {
            var ticketData = ticket.split("-");
            EveryTicket[i] = new Ticket( ticketData[0], ticketData[1],
                    ticketData[2], ticketData[3], ticketData[4], ticketData[5], Integer.parseInt(ticketData[6]));
            i++;
        }
        return EveryTicket;
    }

}
