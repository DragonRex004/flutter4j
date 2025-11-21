package de.dragonrex.states;

import de.dragonrex.BuildContext;
import de.dragonrex.components.TextInput;
import de.dragonrex.styling.Style;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextInputState extends State<TextInput> {

    public String text = "";
    JTextField field;

    @Override
    public JComponent build(BuildContext context) {
        TextInput widget = getWidget();

        TextInputStateLocator.lastFound = this;

        JTextField field = new JTextField(text, widget.columns);

        // Style?
        if (widget.style != null) {
            widget.style.apply(field);
        }

        // State-Update
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { update(); }
            @Override public void removeUpdate(DocumentEvent e) { update(); }
            @Override public void changedUpdate(DocumentEvent e) {}

            private void update() {
                setState(() -> text = field.getText());
            }
        });

        return field;
    }
}

