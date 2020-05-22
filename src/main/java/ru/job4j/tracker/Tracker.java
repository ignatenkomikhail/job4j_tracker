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

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
            result = true;
        }
        return result;
    }

    public void delete(String id) {
        int index = indexOf(id);
        this.items[index] = null;
        System.arraycopy(this.items, index + 1, this.items, index, this.size - index - 1);
        this.items[this.size - 1] = null;
        this.size -= 1;
    }
}
