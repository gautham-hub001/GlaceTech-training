import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.java.Day3;

public class Day3Test {
    @Test
    public void testVariable() {
        Day3 day3 = new Day3();
        // System.out.println(day3.a);
        assertEquals(10, day3.a);
        assertEquals(0, day3.b);
        assertEquals(null, Day3.c);
    }

    @Test
    public void testAdd() {
        Day3 day3 = new Day3();
        assertEquals(5, day3.add(2, 3));
    }
}
