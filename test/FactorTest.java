import org.junit.Assert;
import org.junit.Test;

public class FactorTest {

    @Test
    public void Test() {
        Parser parser = new Parser("2*3");
        Expression expression = parser.parse();
        Factor factor = new Factor("*", expression.left,  expression.right);
        System.out.print(factor.calculate());
        Parser parser1 = new Parser("6");
        Expression expression1 = parser1.parse();
        Assert.assertEquals(factor.calculate(),(expression1.calculate()));
    }
}