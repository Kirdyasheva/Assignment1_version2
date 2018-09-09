import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void test()
    {
        Parser parser = new Parser("9+2");
        Expression expressionTree = parser.parse();
        assertNotNull(expressionTree);
        assertEquals(expressionTree.left, 9);
        assertEquals(expressionTree.right, 2);
    }
}