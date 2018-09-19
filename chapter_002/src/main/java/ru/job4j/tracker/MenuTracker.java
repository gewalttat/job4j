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

    private class AddItem extends BaseAction {
        public AddItem(int keyCount, String menuOption) {
            super(keyCount, menuOption);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's description: ");
            tracker.add(new Item(name, desc));
        }
    }

    private static class ShowItems extends BaseAction {
        public ShowItems(int keyCount, String menuOption) {
            super(keyCount, menuOption);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }
    }

    public static class EditItem extends BaseAction {
        public EditItem(int keyCount, String menuOption) {
            super(keyCount, menuOption);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task id: ");
            String name = input.ask("Please, enter the task's name: ");
            String description = input.ask("Please, enter the task's desc: ");
            Task task = new Task(name, description);
            task.setId(id);
            tracker.edit(task);
        }
        }
    }

class DeleteItem extends BaseAction {
    public DeleteItem(int keyCount, String menuOption) {
        super(keyCount, menuOption);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter task id: ");
        tracker.delete(id);
        System.out.println("Task with id " + id + " is deleted");
    }
}

class ItemFindById extends BaseAction {
    public ItemFindById(int keyCount, String menuOption) {
        super(keyCount, menuOption);
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
}

class ItemFindByName extends BaseAction {
    public ItemFindByName(int keyCount, String menuOption) {
        super(keyCount, menuOption);
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
}

class UserExit extends BaseAction {
    private final StartUI startUI;

    public UserExit(StartUI startUI, int keyCount, String menuOption) {
        super(keyCount, menuOption);
        this.startUI = startUI;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Program is exit. Goodbye!");
        startUI.stop();
    }
}


