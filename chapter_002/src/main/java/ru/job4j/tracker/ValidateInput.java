package ru.job4j.tracker;
import java.util.*;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        int key = this.input.ask(question, range);
        if (!range.contains(key)) {
            throw new MenuOutException("Please enter validate data:");
        }
        return key;
    }
}
