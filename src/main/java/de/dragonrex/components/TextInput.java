package de.dragonrex.components;

import de.dragonrex.states.State;
import de.dragonrex.states.StatefulWidget;
import de.dragonrex.states.TextInputState;
import de.dragonrex.styling.Style;

public class TextInput extends StatefulWidget {

    public String text = "";
    public Style style;
    public int columns = 10;

    public TextInput() {
        this(null);
    }

    public TextInput(Style style) {
        this.style = style;
    }

    @Override
    public State createState() {
        return new TextInputState();
    }
}

