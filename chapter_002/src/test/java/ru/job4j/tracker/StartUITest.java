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
            .append("0. Add new task")
            .append("1. Show all tasks")
            .append("2. Edit task")
            .append("3. Delete task")
            .append("4. Find task by id")
            .append("5. Find task by name")
            .append("6. Exit")
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
    /*
    ADD
     */
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    /*
     *EDIT
     */
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "task updated", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    /*
    DELETE
     */
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

    /*
    FIND BY NAME
     */
    @Test
    public void whenTerminalFindByName() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is("test1"));
    }

    @Test
    public void whenUserFindByName() {
        Item itemFirst = tracker.add(new Item("test1", "desc1"));
        Item itemSecond = tracker.add(new Item("test1", "desc2"));
        Item itemThird = tracker.add(new Item("test3", "desc3"));
        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(userMenu)
                        .append("------------ Find task by name --------------")
                        .append(System.lineSeparator())
                        .append(" Task with name test1 № 1 " + itemFirst.toString())
                        .append(System.lineSeparator())
                        .append(" Task with name test1 № 2 " + itemSecond.toString())
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .toString()));
    }

    /*
    FIND BY ID
     */
    @Test
    public void whenFindById() {
        Item item = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder().append(userMenu)
                        .append("------------ Find task by id --------------")
                        .append(System.lineSeparator())
                        .append("------------ Task with id " + item.getId() + " : " + tracker.findById(item.getId()))
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .toString()));
    }

    /*
    SHOW ALL
     */
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
                        .append("------------ Task name : " + item.getName() + " ; Task descriptioin : " + item.getDescription() + " ------------")
                        .append(System.lineSeparator())
                        .append("------------ Task name : " + item2.getName() + " ; Task descriptioin : " + item2.getDescription() + " ------------")
                        .append(System.lineSeparator())
                        .append("------------ Task name : " + item3.getName() + " ; Task descriptioin : " + item3.getDescription() + " ------------")
                        .append(System.lineSeparator())
                        .append(userMenu)
                        .toString()));
    }
}