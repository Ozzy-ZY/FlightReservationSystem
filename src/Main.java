import GUI.HomePage;
import Models.Flight;
import Models.Plane;
import com.google.zxing.WriterException;
import Utils.QrGenerator.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static Utils.QrGenerator.generateQRCode;
import static Utils.QrGenerator.saveQRCodeImage;

public class Main {
    public static void main(String[] args) {
        HomePage homePage= new HomePage();
    }

}