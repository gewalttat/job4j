package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TwoArraysToOneTest {
    @Test
    public void arrayFirstPlusArraySecond() {
        TwoArraysToOne tato = new TwoArraysToOne();
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        int[] c = tato.merge(a, b);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6};
        assertThat(c, is(expect));
    }
}
