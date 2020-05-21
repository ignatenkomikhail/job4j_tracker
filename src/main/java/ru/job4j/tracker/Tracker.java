package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int size = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.size++] = item;
        return item;
    }

    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < this.size; i++) {
            if(this.items[i].getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? this.items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] items = new Item[this.size];
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            if (key.equals(this.items[i].getName())) {
                items[index] = this.items[i];
                index++;
            }
        }
        return Arrays.copyOf(items, index);
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }

    public void replace(String id, Item item) {
        item.setId(id);
        this.items[indexOf(id)] = item;
    }
}
