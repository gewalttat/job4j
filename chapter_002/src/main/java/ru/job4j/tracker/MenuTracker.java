package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    List<Integer> range = new ArrayList<>();
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    void fillActions(StartUI startUI) {
        this.actions.add(new AddItem(0, "Add new task"));
        this.actions.add(new ShowItems(1, "Show all tasks"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit task"));
        this.actions.add(new DeleteItem(3, "Delete task"));
        this.actions.add(new ItemFindById(4, "Find task by id"));
        this.actions.add(new ItemFindByName(5, "Find task by name"));
        this.actions.add(new UserExit(startUI, 6, "Exit"));
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (null != action) {
                System.out.println(action.key() + " " + action.info());
            }
        }
    }

    private int getActionsLength() {
        return this.actions.size();
    }
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    public List<Integer> listValueCreate() {
        for (int i = 0; i < this.getActionsLength(); i++) {
            range.add(i);
        }
        return range;
    }

    private class AddItem implements UserAction {
        private int keyCount;
        private String menuOption;

        public AddItem(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String description = input.ask("Please, enter the task's desc: ");
            tracker.add(new Task(name, description));
        }
        public String info() {
            return menuOption;
        }
    }
    private static class ShowItems implements UserAction {
        private int keyCount;
        private String menuOption;

        public ShowItems(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
        public String info() {
            return menuOption;
        }
    }
    class EditItem implements UserAction {
        private int keyCount;
        private String menuOption;

        public EditItem(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task id: ");
            String name = input.ask("Please, enter the task's name: ");
            String description = input.ask("Please, enter the task's desc: ");
            Task task = new Task(name, description);
            task.setId(id);
            tracker.edit(task);
        }
        public String info() {
            return menuOption;
        }
    }
    class DeleteItem implements UserAction {
        private int keyCount;
        private String menuOption;

        public DeleteItem(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task id: ");
            tracker.delete(id);
            System.out.println("Task with id " + id + " is deleted");
        }
        public String info() {
            return menuOption;
        }
    }
    class ItemFindById implements UserAction {
        private int keyCount;
        private String menuOption;

        public ItemFindById(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(String.format("id=%s name=%s description=%s", item.getId(), item.getName(), item.getDescription()));
            } else {
                System.out.println("Task with this id is not found");
            }
        }
        public String info() {
            return menuOption;
        }
    }
    class ItemFindByName implements UserAction {
        private int keyCount;
        private String menuOption;

        public ItemFindByName(int keyCount, String menuOption) {
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        public int key() {
            return keyCount;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task name: ");
            for (Item index : tracker.findByName(name)) {
                if (index != null) {
                    System.out.println(String.format("id=%s name=%s description=%s", index.getId(), index.getName(), index.getDescription()));
                } else {
                    System.out.println("Task with this name is not found");
                }
            }
        }
        public String info() {
            return menuOption;
        }
    }

    class UserExit implements UserAction {
        private int keyCount;
        private String menuOption;
        private final StartUI startUI;
        public UserExit(StartUI startUI, int keyCount, String menuOption) {
            this.startUI = startUI;
            this.keyCount = keyCount;
            this.menuOption = menuOption;
        }
        @Override
        public int key() {
            return keyCount;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Program is exit. Goodbye!");
            startUI.stop();
        }
        @Override
        public String info() {
            return menuOption;
        }
    }
}