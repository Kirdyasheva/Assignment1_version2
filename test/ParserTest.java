import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void test()
    {
        Parser parser = new Parser("9+2");
        Expression expressionTree = parser.parse();
        assertNotNull(expressionTree);
        Parser parser1 = new Parser("9");
        Parser parser2 = new Parser("2");
        Expression expressionTree1 = parser1.parse();
        Expression expressionTree2 = parser2.parse();
        assertEquals(expressionTree.left.calculate(), expressionTree1.calculate());
        assertEquals(expressionTree.right.calculate(), expressionTree2.calculate());
    }
}