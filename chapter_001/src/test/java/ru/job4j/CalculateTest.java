package ru.job4j;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Ivan Trishin (rbhorses@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */ @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Ivan Trishin";
        String expect = "Echo, echo, echo : Ivan Trishin";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}