package de.dragonrex.components;

import de.dragonrex.BuildContext;
import de.dragonrex.states.StatelessWidget;

import javax.swing.*;
import java.awt.*;

public class SizedBox extends StatelessWidget {

    private final int height;

    public SizedBox(int height) {
        this.height = height;
    }

    @Override
    protected JComponent render(BuildContext context) {
        JPanel p = new JPanel();
        p.setOpaque(false);
        p.setPreferredSize(new Dimension(1, height));
        return p;
    }
}
