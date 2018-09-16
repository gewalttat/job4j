package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
public class StartUI {


    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> arrayLength = new ArrayList<>();
        menu.fillActions();
        for (int index = 0; index < menu.getActionLength(); index++) {
            arrayLength.add(index);
        }
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Select option:")));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}