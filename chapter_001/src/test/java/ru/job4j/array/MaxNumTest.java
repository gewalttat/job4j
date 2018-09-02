package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxNumTest {
    @Test
    public void checkMaximumSequence() {
        MaxNum mn = new MaxNum();
        int[] a = new int[]{1, 1, 1, 1, 3, 2, 2, 2, 3, 3, 0, 0, 4};
        int[] result = new int[]{1, 1, 1, 1};
        assertThat(result, is(result));
    }
}