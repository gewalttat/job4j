package ru.job4j.array;
import org.junit.Test;
/*
задача на сортировку массива к контрольным вопросам по 1 блоку
 */

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class quertytest {
    @Test
    public void arraySortWithSixElements() {
        BubbleSort bs = new BubbleSort();
        int[] array = new int[]{5, 1, 2, 7, 3, 9};
        int[] result = bs.sort(array);
        int[] expect = new int[]{1, 2, 3, 5, 7, 9};
        assertThat(result, is(expect));
    }
}
