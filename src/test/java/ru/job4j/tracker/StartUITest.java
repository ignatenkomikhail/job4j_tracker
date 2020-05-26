package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {item.getId(), "replaced item"};
        StartUI.editItem(new StubInput(answer), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answer = {item.getId()};
        StartUI.deleteItem(new StubInput(answer), tracker);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
    @Test
    public void whenStartUIInit1() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[]{action});
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenStartUIInit2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream standart = System.out;
        System.setOut(new PrintStream(out));
        StubAction action = new StubAction();
        new StartUI().init(new StubInput(new String[]{"0"}), new Tracker(), new UserAction[]{action});
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n---------Menu---------")
                .add("0. Stub action")
                .add("----------------------")
                .toString();
        assertThat(out.toString(), is(expected));
        System.setOut(standart);
    }
}
