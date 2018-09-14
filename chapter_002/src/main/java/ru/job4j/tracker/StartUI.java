package ru.job4j.tracker;

public class StartUI {
    /*
    меню приложения
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.SelectActions(key);
        } while (!"y".equals(this.input.ask("Exit? y")));
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Please input task name: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.itemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.itemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Add new task --------------");
        String name = this.input.ask("Input task name :");
        String desc = this.input.ask("Input task description :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New task с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("Add new task");
        System.out.println("Show all tasks");
        System.out.println("Edit task");
        System.out.println("Delete task");
        System.out.println("Find task by id");
        System.out.println("Find task by name");
        System.out.println("Exit");

    }

    private void showAllItems() {
        System.out.println("-----------All Tasks-------------" + this.tracker.findAll() + "--------------");
    }

    private void editItem() {
        System.out.println("-----------Edit task-----------");
        String id = this.input.ask("Input task id");
        String name = this.input.ask("Input new task name: ");
        String desc = this.input.ask("Input new task description: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Edited task : " + item.toString() + " -----------");
        } else {
            System.out.println("Task not find");
        }
    }

    /**
     * Метод реализует поиск заявки по name.
     */
    private void itemByName() {
        System.out.println("------------ Find task by name --------------");
        String name = this.input.ask("Input task name:");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.println("Task with name is " + name + " № " + (i + 1) + "" + result[i].toString());
            }
        } else {
            System.out.println(" Task with this name is not found. Input correct name: ");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void itemById() {
        System.out.println("------------ Find task by id --------------");
        String id = this.input.ask("Input task id :");
        if (this.tracker.findById(id) != null) {
            System.out.println("------------ Task with id " + id + " : " + this.tracker.findById(id));
        } else {
            System.out.println("------------ Task with id " + id + " is not found. Input correct id: ");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Delete task --------------");
        String id = this.input.ask("Input task id: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Task with id : " + id + " has deleted-----------");
        } else {
            System.out.println("Task with this id is not found. Input correct id: ");
        }
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}