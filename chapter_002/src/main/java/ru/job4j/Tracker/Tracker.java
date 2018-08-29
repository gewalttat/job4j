package ru.job4j.Tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random rand = new Random();

    public Item add(Item item) {
        item.setId(String.valueOf(rand.nextInt()));
        this.items[position++] = item;
        return item;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++)
            if (this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
            }
    }

    public void delete(String id) {
        int PosLength = 0;
        for (int i = 0; i != this.position; i++) {
            if (this.items[i] != null && this.items.equals(id)) {
                PosLength = i;
                System.arraycopy(this.items, PosLength, items, PosLength--, position - 1);
                break;
            }
        }
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] nameSearcher = new Item[position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                nameSearcher[count++] = items[i];
            }
        }
        return Arrays.copyOf(nameSearcher, count);
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + rand.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        return Arrays.copyOf(this.items, this.position);
    }
}