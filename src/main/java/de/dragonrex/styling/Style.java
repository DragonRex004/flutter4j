package de.dragonrex.styling;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Style {

    private Insets padding;
    private Insets margin;
    private Color background;
    private Color foreground;
    private Border border;
    private int cornerRadius;
    private int shadowSize;

    public Style padding(int all) {
        this.padding = new Insets(all, all, all, all);
        return this;
    }

    public Style padding(int vertical, int horizontal) {
        this.padding = new Insets(vertical, horizontal, vertical, horizontal);
        return this;
    }

    public Style margin(int all) {
        this.margin = new Insets(all, all, all, all);
        return this;
    }

    public Style background(Color color) {
        this.background = color;
        return this;
    }

    public Style foreground(Color color) {
        this.foreground = color;
        return this;
    }

    public Style radius(int radius) {
        this.cornerRadius = radius;
        return this;
    }

    public Style shadow(int size) {
        this.shadowSize = size;
        return this;
    }

    public Style border(Color color, int thickness) {
        this.border = BorderFactory.createLineBorder(color, thickness);
        return this;
    }

    public void apply(JComponent c) {
        if (padding != null) {
            c.setBorder(BorderFactory.createEmptyBorder(
                    padding.top, padding.left, padding.bottom, padding.right
            ));
        }

        if (background != null)
            c.setBackground(background);

        if (foreground != null)
            c.setForeground(foreground);

        if (border != null)
            c.setBorder(border);

        if (c instanceof StyledPanel sp) {
            sp.setCornerRadius(cornerRadius);
            sp.setShadowSize(shadowSize);
        }
    }
}
