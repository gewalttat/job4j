package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] undue = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, is(result));
    }
    }