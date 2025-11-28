package de.dragonrex.frame;

import com.formdev.flatlaf.FlatLightLaf;
import de.dragonrex.FlutterWidget;

import javax.swing.*;
import java.awt.*;

public abstract class Application {
    private JFrame frame;

    public void buildApp(String title, Dimension size, FlutterWidget root) {
        SwingUtilities.invokeLater(() -> {
            FlatLightLaf.setup();
            frame = new JFrame(title);
            frame.setPreferredSize(size);
            frame.setContentPane(root.build());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public void switchTo(FlutterWidget root) {
        frame.getContentPane().removeAll();
        frame.setContentPane(root.build());
        frame.pack();
    }
}
