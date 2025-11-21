package de.dragonrex.test;

import de.dragonrex.states.State;
import de.dragonrex.states.StatefulWidget;

class TestApp extends StatefulWidget {
    @Override
    public State createState() {
        return new TestAppState();
    }
}
