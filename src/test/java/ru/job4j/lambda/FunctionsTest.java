package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Functions.diapason(4, 9, x -> Math.pow(x, 2) - 2 * x + 3);
        List<Double> expected = Arrays.asList(11D, 18D, 27D, 38D, 51D, 66D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSignificantFunction() {
        List<Double> result = Functions.diapason(1, 5, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D, 81D, 243D);
        assertThat(result, is(expected));
    }
}
