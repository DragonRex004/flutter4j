package de.dragonrex.components;

import de.dragonrex.BuildContext;
import de.dragonrex.states.StatelessWidget;

import javax.swing.*;

public class Button extends StatelessWidget {
    private final String text;
    private final Runnable onPressed;

    public Button(String text, Runnable onPressed) {
        this.text = text;
        this.onPressed = onPressed;
    }

    @Override
    protected JComponent render(BuildContext context) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> onPressed.run());
        return btn;
    }
}
