package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    public String description;
    public long create;

    public Item(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item() {
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }
}
