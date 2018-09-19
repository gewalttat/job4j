package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
public class StartUI {
    private final Input input;
    private final Tracker tracker;
private boolean marker = true;
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show();
            menu.select(input.ask("Select option: ", menu.listValueCreate()));
        } while (this.marker);
    }
    public void stop() {
        this.marker = false;
    }
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}