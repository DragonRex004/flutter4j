package de.dragonrex.components;

import de.dragonrex.FlutterWidget;
import de.dragonrex.style.StyleParser;

import javax.swing.*;
import java.awt.*;

public class Container extends FlutterWidget {
    private FlutterWidget children;
    private int width = 100;
    private int height = 50;
    private Color color = Color.WHITE;
    private int cornerRadius = 10;

    public Container(String style, FlutterWidget children) {
        this.children = children;
        StyleParser.parse(style).forEach((key, value) -> {
            switch (key) {
                case "width" -> width = (int) value;
                case "height" -> height = (int) value;
                case "bg.color" -> color = Color.decode((String) value);
                case "border.radius" -> cornerRadius = (int) value;
                default -> System.out.println("Unknown style: " + key);
            }
        });
    }

    @Override
    public JComponent build() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(color);
        panel.setLayout(new BorderLayout());
        if (cornerRadius > 0) {
            panel.putClientProperty("JButton.buttonType", "roundRect");
            panel.putClientProperty("Component.arc", cornerRadius);
        }
        panel.add(children.build(), BorderLayout.CENTER);
        return panel;
    }
}
