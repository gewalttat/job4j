package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxNumTest {
    @Test
    public void checkMaximumSequence() {
        MaxNum max = new MaxNum();
        int[] check = new int[]{0, 0, 1, 1, 1, 2, 0, 2, 2};
        int result = max.maxNum(check);
        assertThat(result, is(3));
    }
}