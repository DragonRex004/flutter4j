package de.dragonrex.test;

import de.dragonrex.BuildContext;
import de.dragonrex.Column;
import de.dragonrex.components.*;
import de.dragonrex.components.Button;
import de.dragonrex.components.Container;
import de.dragonrex.components.Label;
import de.dragonrex.states.State;
import de.dragonrex.states.TextInputState;
import de.dragonrex.states.TextInputStateLocator;
import de.dragonrex.styling.Style;
import de.dragonrex.styling.TextStyle;

import javax.swing.*;
import java.awt.*;

class TestAppState extends State<TestApp> {

    String input = "";

    @Override
    public JComponent build(BuildContext context) {
        return new Container(
                new Style().padding(20).background(new Color(245,245,245)),

                new Column(

                        // Überschrift
                        new Label(
                                "Demo App mit TextInput",
                                new TextStyle()
                                        .size(22)
                                        .bold()
                                        .color(new Color(30,30,30))
                        ),

                        // Abstand
                        new SizedBox(10),

                        // Eingabetext
                        new Container(
                                new Style()
                                        .padding(10)
                                        .radius(8)
                                        .background(Color.WHITE)
                                        .shadow(5),

                                new TextInput(
                                        new Style()
                                                .padding(8)
                                                .radius(6)
                                                .background(new Color(250,250,250))
                                )
                        ),

                        new SizedBox(10),

                        // Button
                        new Container(
                                new Style()
                                        .padding(10)
                                        .radius(8)
                                        .background(new Color(33,150,243))
                                        .shadow(4),

                                new Button("Übernehmen", () -> {
                                    // Text aus TextInput holen:
                                    TextInputState ts = findTextInputState(context);
                                    if (ts != null) {
                                        setState(() -> input = ts.text);
                                    }
                                })
                        ),

                        new SizedBox(20),

                        // Ausgabe
                        new Container(
                                new Style()
                                        .padding(14)
                                        .radius(8)
                                        .background(Color.WHITE)
                                        .shadow(6),

                                new Label(
                                        "Eingabe: " + input,
                                        new TextStyle().size(16).color(new Color(50,50,50))
                                )
                        )
                )
        ).build(context);
    }


    // Hilfsfunktion: ersten TextInputState im Widget-Baum holen
    private TextInputState findTextInputState(BuildContext ctx) {
        // Bei Bedarf kann ich dir später einen offiziellen Widget-Tree-Scanner bauen
        return TextInputStateLocator.lastFound;
    }
}

