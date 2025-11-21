package de.dragonrex;

import de.dragonrex.states.StatelessWidget;
import de.dragonrex.widget.Widget;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Row extends StatelessWidget {
    private final List<Widget> children;

    public Row(Widget... children) {
        this.children = Arrays.asList(children);
    }

    @Override
    protected JComponent render(BuildContext context) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        children.forEach(w -> panel.add(w.build(context)));
        return panel;
    }
}
