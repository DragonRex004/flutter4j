package de.dragonrex.components;

import de.dragonrex.FlutterWidget;
import de.dragonrex.style.StyleParser;

import javax.swing.*;
import java.awt.*;

public class Text extends FlutterWidget {
    private String content;
    private int width = 100;
    private int height = 50;
    private Font font = new Font("Arial", Font.PLAIN, 16);
    private Color color = new Color(0, 0, 0, 0);
    private Color textColor = Color.BLACK;
    private int cornerRadius = 10;

    public Text(String content, String style) {
        this.content = content;

        StyleParser.parse(style).forEach((key, value) -> {
            switch (key) {
                case "width" -> width = (int) value;
                case "height" -> height = (int) value;
                case "bg.color" -> color = Color.decode((String) value);
                case "text.color" -> textColor = Color.decode((String) value);
                case "text.size" -> font = new Font(font.getName(), font.getStyle(), (int) value);
                case "font.family" -> font = new Font((String) value, font.getStyle(), font.getSize());
                case "font.weight" -> font = new Font(font.getName(), (int) value, font.getSize());
                case "border.radius" -> cornerRadius = (int) value;
                default -> System.out.println("Unknown style: " + key);
            }
        });
    }

    @Override
    public JComponent build() {
        JLabel jLabel = new JLabel(content);
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setFont(font);
        jLabel.setBackground(color);
        jLabel.setForeground(textColor);
        if (cornerRadius > 0) {
            jLabel.putClientProperty("JButton.buttonType", "roundRect");
            jLabel.putClientProperty("Component.arc", cornerRadius);
        }
        return jLabel;
    }
}