package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int keyCount;
    private final String menuOption;
    protected BaseAction(final int keyCount, final String menuOption) {
        this.keyCount = keyCount;
        this.menuOption = menuOption;
    }
    @Override
    public int key() {
        return keyCount;
    }
    @Override
    public String info() {
        return String.format("%s", menuOption);
    }
}
