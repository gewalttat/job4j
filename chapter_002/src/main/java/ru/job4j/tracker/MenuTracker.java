package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new ItemFindById();

    }

    public void SelectActions(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (null != action) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String description = input.ask("Please, enter the task's desc: ");
            tracker.add(new Task(name, "first desc"));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new task ");
        }
    }

    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all tasks");
        }
    }

    class EditItem implements UserAction {
        public int key() {
            return 2;
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
            return String.format("%s. %s", this.key(), "Edit task");
        }
    }

    class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task id: ");
            tracker.delete(id);
            System.out.println("Task with id " + id + " is deleted");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete task");
        }
    }

    class ItemFindById implements UserAction {
        public int key() {
            return 4;
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
            return String.format("%s. %s", this.key(), "Find task by id");
        }
    }

    class ItemFindByName implements UserAction {
        public int key() {
            return 5;
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
            return String.format("%s. %s", this.key(), "Find task by name");
        }
    }
}
