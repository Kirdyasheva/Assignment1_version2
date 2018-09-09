import org.junit.Test;
import static org.junit.Assert.*;

public class RelationTest {

    @Test
    public void test(){
        Parser parser = new Parser("5<2");
        Expression expression = parser.parse();
        Relation relation = new Relation ("<",expression.left, expression.right);
        assertEquals(relation.calculate(), (long)0);
    }
}