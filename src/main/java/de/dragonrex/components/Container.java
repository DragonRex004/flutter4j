package de.dragonrex.components;

import de.dragonrex.BuildContext;
import de.dragonrex.states.StatelessWidget;
import de.dragonrex.styling.Style;
import de.dragonrex.styling.StyledPanel;
import de.dragonrex.widget.Widget;

import javax.swing.*;
import java.awt.*;

public class Container extends StatelessWidget {

    private final Widget child;
    private final Style style;

    public Container(Style style, Widget child) {
        this.child = child;
        this.style = style;
    }

    @Override
    protected JComponent render(BuildContext context) {
        StyledPanel panel = new StyledPanel();
        panel.setLayout(new BorderLayout());

        JComponent content = child.build(context);
        panel.add(content, BorderLayout.CENTER);

        style.apply(panel);

        return panel;
    }
}

