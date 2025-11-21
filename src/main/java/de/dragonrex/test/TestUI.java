package de.dragonrex.test;

import de.dragonrex.BuildContext;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class TestUI {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Flutter-Java Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);

        BuildContext ctx = new BuildContext(new TestApp());
        frame.setContentPane(ctx.build());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}



