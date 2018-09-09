import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorTest {

    @Test
    public void Test() {
        Parser parser = new Parser("2*3");
        Expression expression = parser.parse();
        Factor factor = new Factor("*", expression.left,  expression.right);
        System.out.print(factor.calculate());
        assertEquals(Long.toString(factor.calculate()), "6");
    }
}