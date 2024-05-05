package Utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest{


    @Test
    public void deleteLineRemovesSpecifiedLine() throws IOException {
        String path = "test.txt";
        String data = "hany \n mahmoud\n";
        FileManager.write(path, data);
        FileManager.deleteLine(path, " mahmoud");
        String readData = FileManager.read(path);
        assertEquals("hany \n", readData);
    }

    @Test
    public void replaceLinesChangesSpecifiedLine() throws IOException {
        String path = "test.txt";
        String data = "galio\nferr\n";
        FileManager.write(path, data);
        FileManager.replaceLines(path, "galio", "prompt");
        String readData = FileManager.read(path);
        assertEquals("prompt\nferr\n", readData);
    }

    @Test
    public void isFileEmptyReturnsTrueForEmptyFile() {
        String path = "test.txt";
        FileManager.write(path, "");
        assertTrue(FileManager.isFileEmpty(path));
    }

    @Test
    public void isFileEmptyReturnsFalseForNonEmptyFile() {
        String path = "test.txt";
        FileManager.write(path, "run it!!");
        assertFalse(FileManager.isFileEmpty(path));
    }
}