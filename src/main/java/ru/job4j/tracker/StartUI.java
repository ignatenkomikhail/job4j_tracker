package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker){
        System.out.println("==== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Tracker tracker){
        System.out.println("==== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Items not found\n");
        }
    }

    public static void editItem(Input input, Tracker tracker){
        System.out.println("==== Edit item ====");
        String id = input.askStr("Enter the item id: ");
        String name = input.askStr("Enter a new item name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.printf("Item (id: %s) successfully edited\n", id);
        } else {
            System.out.printf("Item (id: %s) the edit failed\n", id);
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        String id = input.askStr("Enter the item id: ");
        if (tracker.delete(id)) {
            System.out.printf("Item (id: %s) successfully deleted\n", id);
        } else {
            System.out.printf("Item (id: %s) deletion failed\n", id);
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("==== Find item by Id ====");
        String id = input.askStr("Enter the item id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.printf("Not found item with id: %s\n", id);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("\n---------Menu---------");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
