package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QwertyTest {
    @Test
    public void arraySortWithSixElements() {
        Qwerty qw = new Qwerty();
        int input[] = new int[]{1, 2, 4, 7, 9};
        boolean result = qw.isSort(input);
        assertThat(result, is(true));
    }
}