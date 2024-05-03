package Utils;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static boolean isFileEmpty(String path){
        File file = new File(path);
        return file.length() == 0;
    }
}
