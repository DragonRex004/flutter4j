package de.dragonrex.states;

import de.dragonrex.BuildContext;
import de.dragonrex.widget.Widget;

import javax.swing.*;

public abstract class StatefulWidget extends Widget {
    public abstract State createState();

    @Override
    public final JComponent build(BuildContext context) {
        State state = createState();
        state.setWidget(this);
        state.setContext(context);
        return state.build(context);
    }
}
