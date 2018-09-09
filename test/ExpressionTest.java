import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void test(){
        Parser parser = new Parser("9+2");
        Expression expressionTree = parser.parse();
        assertNotNull(expressionTree);
    }
}