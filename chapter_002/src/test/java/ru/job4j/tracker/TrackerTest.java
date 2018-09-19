package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        /*
        Добавляем заявку в трекер. Теперь в объект проинициализирован id.
         */
        tracker.add(previous);
        /*
         Создаем новую заявку.
          */
        Item next = new Item("test2", "testDescription2", 1234L);
        /*
         Проставляем старый id из previous, который был сгенерирован выше.
          */
        next.setId(previous.getId());
        /*
         Обновляем заявку в трекере.
          */
        tracker.replace(previous.getId(), next);
        /*
         Проверяем, что заявка с таким id имеет новые имя test2.
          */
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "desc1", 123L);
        Item itemTwo = new Item("test2", "desc2", 123L);
        Item itemThree = new Item("test3", "test3", 123L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[]{itemOne, itemTwo, itemThree}));
    }

    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("item", "desc1", 13L);
        Item itemTwo = new Item("item1", "desc2", 14L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        Item[] result = tracker.findByName("item");
        assertThat(result, is(new Item[]{itemOne}));
    }

    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("item", "desc1", 123L);
        Item itemTwo = new Item("item1", "desc2", 123L);
        Item itemThree = new Item("test3", "desc3", 123L);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        Item result = tracker.findById(itemTwo.getId());
        assertThat(result, is(itemTwo));
    }
}