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
                this.items[i] = item;
                break;
            }
    }

    public void delete(String id) {
        int PosLength = 0;
        for (int i = 0; i < this.position; i++) {
            for (int j = i + 1; j < PosLength; j++) {
                if (items[i].getId().equals(PosLength)) {
                    items[i] = items[1 - PosLength];
                    PosLength--;
                    j--;
                }
            }
        }
        Arrays.copyOf(items, PosLength);
    }

    public Item[] findAll() {
        Item[] searcher = new Item[position];
        System.arraycopy(items, 0, searcher, 0, position);
        return searcher;
    }

    public Item[] findByName(String key) {
        Item[] nameSearcher = new Item[position];
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                nameSearcher[i] = items[i];
                i++;
            }
        }
        return nameSearcher;
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

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + rand.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
}