package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fac = new Factorial();
        int mltp = fac.calc(5);
        int expected = 120;
        assertThat(mltp, is(expected));
    }
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fac = new Factorial();
        int mltpifnull = fac.calc(0);
        int expected = 1;
        assertThat(mltpifnull, is(expected));
    }
}
