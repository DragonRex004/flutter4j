package de.dragonrex.test.views;

import de.dragonrex.FlutterWidget;
import de.dragonrex.View;
import de.dragonrex.components.Button;
import de.dragonrex.components.Container;
import de.dragonrex.components.Text;
import de.dragonrex.layout.Column;
import de.dragonrex.layout.Padding;
import de.dragonrex.layout.Row;
import de.dragonrex.test.FlutterApp;

public class HomeView extends View {
    @Override
    public FlutterWidget create() {
        return new Column(
                new Container(
                        "w-800 h-50 bg-[#0f0b1e]",
                        new Row(
                                new Padding(
                                        25, 0, 10, 0,
                                        new Text(
                                                "Home",
                                                "w-40 h-40 font-arial text-[#e7e5f0] text-2xl text-bold"
                                        )
                                ),
                                new Padding(
                                        100, 10, 25, 10,
                                        new Button(
                                                "Home",
                                                "w-40 h-40 bg-[#5c4fe8] font-arial text-[#e7e5f0] text-2xl text-bold rounded-full",
                                                e -> {
                                                    System.out.println("Home Clicked");
                                                    FlutterApp.instance.switchTo(new HomeView().create());
                                                }
                                        )
                                ),
                                new Padding(
                                        25, 10, 25, 10,
                                        new Button(
                                                "Settings",
                                                "w-40 h-40 bg-[#5c4fe8] font-arial text-[#e7e5f0] text-base font-italic rounded-md",
                                                e -> {
                                                    System.out.println("Settings Clicked");
                                                    FlutterApp.instance.switchTo(new SettingsView().create());
                                                }
                                        )
                                )
                        )
                ),
                new Row(
                        new Container(
                                "w-200 h-550 bg-[#5c4fe8]",
                                new Column(
                                        new Text(
                                                "Server 1",
                                                "w-40 h-40 font-arial text-[#e7e5f0] text-base font-bold"
                                        ),
                                        new Text(
                                                "Server 2",
                                                "w-40 h-40 font-arial text-[#e7e5f0] text-base font-bold"
                                        ),
                                        new Text(
                                                "Server 3",
                                                "w-40 h-40 font-arial text-[#e7e5f0] text-base font-bold"
                                        ),
                                        new Text(
                                                "Server 4",
                                                "w-40 h-40 font-arial text-[#e7e5f0] text-base font-bold"
                                        )
                                )
                        ),
                        new Container(
                                "w-600 h-550 bg-[#a295f9]",
                                new Column()
                                )
                )

        );
    }
}
