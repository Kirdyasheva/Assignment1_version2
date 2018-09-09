import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicalTest {
    @Test
    public void test(){
        Parser parser = new Parser("1 and 0");
        Expression expression = parser.parse();
        Logical logical = new Logical("and", expression.left, expression.right);
        assertEquals(logical.calculate(), (long)0);
    }
}