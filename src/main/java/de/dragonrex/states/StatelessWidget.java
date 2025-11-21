package de.dragonrex.states;

import de.dragonrex.BuildContext;
import de.dragonrex.widget.Widget;

import javax.swing.*;

public abstract class StatelessWidget extends Widget {
    @Override
    public final JComponent build(BuildContext context) {
        return render(context);
    }

    protected abstract JComponent render(BuildContext context);
}
