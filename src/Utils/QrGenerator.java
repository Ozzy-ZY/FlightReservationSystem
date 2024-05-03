package Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import javax.imageio.ImageIO;

public class QrGenerator {



    public static BufferedImage generateQRCode(String content) throws WriterException {
        int width = 300;
        int height = 300;

        EnumMap<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.MARGIN, 2);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        BufferedImage qrCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        qrCodeImage.createGraphics();

        Graphics2D graphics = qrCodeImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.BLACK);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        graphics.dispose();
        return qrCodeImage;
    }

    public static void saveQRCodeImage(BufferedImage qrCodeImage, String filePath) throws IOException {
        File outputFile = new File(filePath);
        ImageIO.write(qrCodeImage, "png", outputFile);
        ImageIO.createImageOutputStream(outputFile).flush();
        System.out.println("QR Code saved to: " + outputFile.getAbsolutePath());
    }
}