package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fac = new Factorial(); //конструктор метода
        int mltp = fac.calc(5); //задаем значение переменной в цикле
        int expected = 120; //задаем выходное значение
        assertThat(mltp, is(expected)); //проверяем
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fac = new Factorial();
        int mltpifnull = fac.calc(0);
        int expected = 1;
        assertThat(mltpifnull, is(expected));
    }
}
