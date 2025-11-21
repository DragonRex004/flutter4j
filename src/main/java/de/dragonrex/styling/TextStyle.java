package de.dragonrex.styling;

import java.awt.*;

public class TextStyle {

    public Integer size;
    public Color color;
    public boolean bold = false;
    public boolean italic = false;
    public String fontFamily;

    public TextStyle size(int size) {
        this.size = size;
        return this;
    }

    public TextStyle color(Color c) {
        this.color = c;
        return this;
    }

    public TextStyle bold() {
        this.bold = true;
        return this;
    }

    public TextStyle italic() {
        this.italic = true;
        return this;
    }

    public TextStyle font(String family) {
        this.fontFamily = family;
        return this;
    }
}

