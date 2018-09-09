import org.junit.Test;
import static org.junit.Assert.*;

public class PrimaryTest {

    @Test
    public void test()
    {
        Parser parser = new Parser("10");
        Expression expression = parser.parse();
        Primary primary = (Primary)expression;
        assertEquals("integer", primary.op.toString());
    }
}