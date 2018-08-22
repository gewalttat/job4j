package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class Quertytest {
    @Test
    public void arraySortWithSixElements() {
        Qwerty qw = new Qwerty();
        int input[]  = new int[]{7, 1, 9, 4, 2};
        boolean result = qw.isSort(input);
        assertThat(result, is(true));
    }
}
