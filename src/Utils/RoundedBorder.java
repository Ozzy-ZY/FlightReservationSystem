package Utils;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundedBorder extends AbstractBorder {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        g2d.drawRoundRect(x, y, width - 1, height - 1, 10, 10);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(5, 5, 5, 5);
        return insets;
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}