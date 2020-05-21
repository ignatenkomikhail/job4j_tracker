package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenTrackerFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[2];
        tracker.add(new Item("test1"));
        Item item1 = new Item("test2");
        tracker.add(item1);
        items[0] = item1;
        Item item2 = new Item("test2");
        tracker.add(item2);
        items[1] = item2;
        tracker.add(new Item("test3"));
        assertThat(items, is(tracker.findByName("test2")));
    }
    @Test
    public void whenTrackerFindAll() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        Item item1 = new Item("test1");
        tracker.add(item1);
        items[0] = item1;
        Item item2 = new Item("test2");
        tracker.add(item2);
        items[1] = item2;
        Item item3 = new Item("test3");
        tracker.add(item3);
        items[2] = item3;
        assertThat(items, is(tracker.findAll()));
    }
    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }
}
