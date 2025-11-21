package de.dragonrex;

import de.dragonrex.test.TestUI;
import de.dragonrex.widget.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BuildContext {
    private final Widget root;
    private JComponent built;

    public BuildContext(Widget root) {
        this.root = root;
    }

    public JComponent build() {
        built = root.build(this);
        return built;
    }

    public void rebuild() {
        JComponent newBuilt = root.build(this);
        SwingUtilities.invokeLater(() -> {
            Container parent = built.getParent();
            int idx = -1;
            if (parent != null) {
                idx = Arrays.asList(parent.getComponents()).indexOf(built);
                parent.remove(built);
            }
            built = newBuilt;
            if (parent != null) {
                parent.add(built, idx);
                parent.revalidate();
                parent.repaint();
            }
        });
    }
}
