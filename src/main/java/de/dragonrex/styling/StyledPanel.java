package de.dragonrex.styling;

import javax.swing.*;
import java.awt.*;

public class StyledPanel extends JPanel {

    private int radius = 0;
    private int shadow = 0;

    public StyledPanel() {
        setOpaque(false);
    }

    public void setCornerRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setShadowSize(int shadow) {
        this.shadow = shadow;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Shadow
        if (shadow > 0) {
            g2.setColor(new Color(0, 0, 0, 50));
            g2.fillRoundRect(shadow, shadow, w - shadow * 2, h - shadow * 2, radius, radius);
        }

        // Background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, w - shadow, h - shadow, radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }
}

