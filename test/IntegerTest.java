import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTest {
    @Test
    public void test() {
        Integer integer = new Integer(10);
        assertEquals(integer.getString(), "10");
        assertEquals(integer.getValue(), 10);
    }
}