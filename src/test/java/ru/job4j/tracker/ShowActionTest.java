package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ShowActionTest {

    @Test
    public void whenShowAction() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream standart = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAction action = new ShowAction();
        action.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(item.toString())
                .toString();
        assertThat(out.toString(), is(expect));
        System.setOut(standart);
    }
}
