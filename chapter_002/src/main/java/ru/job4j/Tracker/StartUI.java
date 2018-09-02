package ru.job4j.Tracker;

public class StartUI {
    /*
    меню приложения
     */
    private static final String add = "0";
    private static final String show = "1";
    private static final String edit = "2";
    private static final String delete = "3";
    private static final String findbyid = "4";
    private static final String findbyname = "5";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Пожалуйста, введите наименование заявки: ");
            if (add.equals(answer)) {
                this.createItem();
            } else if (show.equals(answer)) {
                this.showAllItems();
            } else if (edit.equals(answer)) {
                this.editItem();
            } else if (delete.equals(answer)) {
                this.deleteItem();
            } else if (findbyid.equals(answer)) {
                this.itemById();
            } else if (findbyname.equals(answer)) {
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
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("Добавление новой заявки");
        System.out.println("Показать все заявки");
        System.out.println("Редактировать заявку");
        System.out.println("Удалить заявку");
        System.out.println("Найти заявку по Id");
        System.out.println("Найти заявку по наименованию");
        System.out.println("Выход");

    }

    private void showAllItems() {
        System.out.println("-----------Все заявки-------------" + this.tracker.findAll());
    }

    private void editItem() {
        System.out.println("-----------Редактирование заявки-----------");
        String id = this.input.ask("Введите id заявки");
        String name = this.input.ask("Введите новое наименование заявки: ");
        String desc = this.input.ask("Введите новое описание: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Отредактированная заявка : " + item.toString() + " -----------");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    /**
     * Метод реализует поиск заявки по name.
     */
    private void itemByName() {
        System.out.println("------------ Поиск заявки по наименованию --------------");
        String name = this.input.ask("Введите наименование заявки :");
        Item[] result = this.tracker.findByName(name);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(" Заявка с наименованием " + name + " № " + (i + 1) + "" + result[i].toString());
            }
        } else {
            System.out.println(" Заявка с таким наименованием не найдена. Введите корректное наименование.");
        }
    }

    /**
     * Метод реализует поиск заявки по id.
     */
    private void itemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.findById(id) != null) {
            System.out.println("------------ Заявка с id " + id + " : " + this.tracker.findById(id));
        } else {
            System.out.println("------------ Заявка с id " + id + " не найдена. Введите корректный id.");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с id : " + id + " удалена-----------");
        } else {
            System.out.println("Заявки с введеным id не существует. Введите корректый id");
        }
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}