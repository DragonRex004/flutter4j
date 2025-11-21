package de.dragonrex.components;


import de.dragonrex.BuildContext;
import de.dragonrex.states.StatelessWidget;
import de.dragonrex.styling.Style;
import de.dragonrex.styling.TextStyle;

import javax.swing.*;
import java.awt.*;

public class Label extends StatelessWidget {

    private final String text;
    private final TextStyle textStyle;
    private final Style style;

    public Label(String text) {
        this(text, null, null);
    }

    public Label(String text, TextStyle textStyle) {
        this(text, textStyle, null);
    }

    public Label(String text, TextStyle textStyle, Style style) {
        this.text = text;
        this.textStyle = textStyle;
        this.style = style;
    }

    @Override
    protected JComponent render(BuildContext context) {
        JLabel label = new JLabel(text);

        if (textStyle != null)
            applyTextStyle(label);

        if (style != null)
            style.apply(label);

        return label;
    }

    private void applyTextStyle(JLabel label) {
        Font base = label.getFont();

        int styleBits = Font.PLAIN;
        if (textStyle.bold)  styleBits |= Font.BOLD;
        if (textStyle.italic) styleBits |= Font.ITALIC;

        String family = textStyle.fontFamily != null ? textStyle.fontFamily : base.getFamily();
        int size = textStyle.size != null ? textStyle.size : base.getSize();

        label.setFont(new Font(family, styleBits, size));

        if (textStyle.color != null)
            label.setForeground(textStyle.color);
    }
}

