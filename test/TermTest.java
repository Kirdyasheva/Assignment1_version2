import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TermTest {
    @Test
    public void test(){
        Parser parser = new Parser("5+2");
        Parser parser1 = new Parser("5");
        Parser parser2 = new Parser("2");
        Expression expression = parser.parse();
        Expression expression1 = parser1.parse();
        Expression expression2 = parser2.parse();
        Term term = new Term("+", expression1, expression2);
        assertEquals(term.calculate(), (long)7);
    }
}