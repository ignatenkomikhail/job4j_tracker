package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                Item[] items = tracker.findAll();
                if (items.length != 0) {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i]);
                    }
                } else {
                    System.out.println("Items not found\n");
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                String id = input.askStr("Enter the item id: ");
                String name = input.askStr("Enter a new item name: ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.printf("Item (id: %s) successfully edited\n", id);
                } else {
                    System.out.printf("Item (id: %s) the edit failed\n", id);
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                String id = input.askStr("Enter the item id: ");
                if (tracker.delete(id)) {
                    System.out.printf("Item (id: %s) successfully deleted\n", id);
                } else {
                    System.out.printf("Item (id: %s) deletion failed\n", id);
                }
            } else if (select == 4) {
                System.out.println("==== Find item by Id ====");
                String id = input.askStr("Enter the item id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.printf("Not found item with id: %s\n", id);
                }
            } else if (select == 5) {
                System.out.println("==== Find items by name ====");
                String name = input.askStr("Enter a name: ");
                Item[] items = tracker.findByName(name);
                if (items != null) {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i]);
                    }
                } else {
                    System.out.printf("Not found item with name: %s\n", name);
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("---------Menu---------");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}