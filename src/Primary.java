abstract class Primary extends Expression {
    enum Opcode {
        integer, expression
    }

    Opcode op;


    public Primary(long value){
        op = Opcode.integer;
    }

    public Primary(Expression expression){
        op = Opcode.expression;
    }
}
