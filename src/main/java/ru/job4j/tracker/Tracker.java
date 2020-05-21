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

    public Item findById(String id) {
        Item rsl = null;
        for (int index = 0; index < this.size; index++) {
            Item item = this.items[index];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
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
        items = Arrays.copyOf(items, index);
        return items;
    }

    public Item[] findAll() {
        Item[] items = new Item[this.size];
        int index = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.items[i] != null) {
                items[index] = this.items[i];
                index++;
            }
        }
        items = Arrays.copyOf(items, index);
        return items;
    }
}
