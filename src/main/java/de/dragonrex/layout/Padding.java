package de.dragonrex.layout;

import de.dragonrex.FlutterWidget;

import javax.swing.*;
import java.awt.*;

public class Padding extends FlutterWidget {
    private FlutterWidget child;
    private Insets insets;

    public Padding(int left, int top, int right, int bottom, FlutterWidget child) {
        this.child = child;
        this.insets = new Insets(top, left, bottom, right);
    }

    @Override
    public JComponent build() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(child.build(), BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));
        return panel;
    }
}
