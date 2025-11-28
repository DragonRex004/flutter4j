package de.dragonrex.test;

import de.dragonrex.frame.Application;
import de.dragonrex.test.views.HomeView;

import java.awt.*;

public class FlutterApp extends Application {
    public static FlutterApp instance;

    void main() {
        instance = this;

        buildApp(
                "Test App",
                new Dimension(800, 600),
                new HomeView().create()
        );
    }
}
