package de.dragonrex.layout;

import de.dragonrex.FlutterWidget;

import javax.swing.*;
import java.awt.*;

public class Column extends FlutterWidget {
    private FlutterWidget[] children;

    public Column(FlutterWidget... children) {
        this.children = children;
    }

    @Override
    public JComponent build() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (FlutterWidget child : children) {
            panel.add(child.build());
        }
        return panel;
    }
}
