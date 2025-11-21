package de.dragonrex.states;

import de.dragonrex.BuildContext;

import javax.swing.*;

public abstract class State<T extends StatefulWidget> {
    private T widget;
    private BuildContext context;

    public void setWidget(T widget) {
        this.widget = widget;
    }

    public T getWidget() {
        return widget;
    }

    public void setContext(BuildContext ctx) {
        this.context = ctx;
    }

    public BuildContext getContext() {
        return context;
    }

    public abstract JComponent build(BuildContext context);

    public void setState(Runnable r) {
        r.run();
        context.rebuild();
    }
}
