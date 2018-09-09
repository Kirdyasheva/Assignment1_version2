import org.junit.Test;
import static org.junit.Assert.*;

public class FactorTest {

    @Test
    public void Test() {
        Parser parser = new Parser("2*3");
        Expression expression = parser.parse();
        Factor factor = new Factor("multiplication", expression.left,  expression.right);
        assertEquals(factor.calculate(), (long)6);
    }
}