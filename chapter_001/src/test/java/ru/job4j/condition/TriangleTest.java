package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Pooint a = new Pooint(0, 0);
        Pooint b = new Pooint(0, 2);
        Pooint c = new Pooint(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}