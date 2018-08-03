package ru.job4j.converter;
 //override
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    @Test
    public void whenDollarTo60RubThen1() {
        Converter converter = new Converter();
        int result = converter.DollarToRuble(60);
        assertThat(result, is(60));
    }
    @Test
    public void whenEuroTo70RubThen1() {
        Converter converter = new Converter();
        int result = converter.EuroToRuble(70);
        assertThat(result, is(70));
    }
}