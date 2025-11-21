package de.dragonrex.widget;

import de.dragonrex.BuildContext;

import javax.swing.*;

public abstract class Widget {
    public abstract JComponent build(BuildContext context);
}
