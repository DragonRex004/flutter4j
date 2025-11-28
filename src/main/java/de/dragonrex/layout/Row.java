package de.dragonrex.layout;

import de.dragonrex.FlutterWidget;

import javax.swing.*;

public class Row extends FlutterWidget {
    private FlutterWidget[] children;

    public Row(FlutterWidget... children) {
        this.children = children;
    }

    @Override
    public JComponent build() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        for (FlutterWidget child : children) {
            panel.add(child.build());
        }
        return panel;
    }
}
