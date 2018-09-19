package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder userMenu = new StringBuilder()
            .append("0 Add new task")
            .append(System.lineSeparator())
            .append("1 Show all tasks")
            .append(System.lineSeparator())
            .append("2 Edit task")
            .append(System.lineSeparator())
            .append("3 Delete task")
            .append(System.lineSeparator())
            .append("4 Find task by id")
            .append(System.lineSeparator())
            .append("5 Find task by name")
            .append(System.lineSeparator())
            .append("6 Exit")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "task updated", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker trackerAfterDeleteTask = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Item item3 = tracker.add(new Item("test name3", "desc3"));
        trackerAfterDeleteTask.add(item2);
        trackerAfterDeleteTask.add(item3);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(tracker.findAll()));
    }

    @Test
    public void whenTerminalFindByName() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is("test1"));
    }

    @Test
    public void whenUserFindByName() {
        Item itemFirst = tracker.add(new Item("test1", "desc1 "));
        Input input = new StubInput(new String[]{"5", itemFirst.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(userMenu)
                        .append("id=" + itemFirst.getId() + " ")
                        .append("name=" + itemFirst.getName() + " ")
                        .append("description=" + itemFirst.getDescription())
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .append("Program is exit. Goodbye!")
                        .append(System.lineSeparator())
                        .toString(

                        )
                )
        );
    }

    @Test
    public void whenFindById() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(userMenu)
                        .append("id=" + item.getId() + " ")
                        .append("name=" + item.getName() + " ")
                        .append("description=" + item.getDescription())
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .append("Program is exit. Goodbye!")
                        .append(System.lineSeparator())
                        .toString(

                        )
                )
        );
    }

    @Test
    public void whenShowAll() {
        Item item = new Item("test1", "desc1");
        Item item2 = new Item("test2", "desc2");
        Item item3 = new Item("test3", "desc3");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(userMenu)
                        .append(item.getId() + ". " + item.getName())
                        .append(System.lineSeparator())
                        .append(item2.getId() + ". " + item2.getName())
                        .append(System.lineSeparator())
                        .append(item3.getId() + ". " + item3.getName())
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .append("Program is exit. Goodbye!")
                        .append(System.lineSeparator())
                        .toString(

                        )
                )
        );
    }

    @Test
    public void whenUserExit() {
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(userMenu)
                        .append("Program is exit. Goodbye!")
                        .append(System.lineSeparator())
                        .toString(
                        )
                )
        );
    }
}