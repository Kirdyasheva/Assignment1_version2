/**
 * Created by Anastasia on 10.10.2017.
 */
public class Relation extends Expression {
    enum Opcode {
        less, lessEq, greater, greaterEq, equal, notEqual, none
    }

    Opcode op;

    Relation(String operation, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        switch (operation) {
            case "<":
                op = Opcode.less;
                break;
            case "<=":
                op = Opcode.lessEq;
                break;
            case ">":
                op = Opcode.greater;
                break;
            case ">=":
                op = Opcode.greaterEq;
                break;
            case "==":
                op = Opcode.equal;
                break;
            case "!=":
                op = Opcode.notEqual;
                break;
        }
    }

    public long calculate() {
        long r1 = left.calculate();
        long r2 = right.calculate();
        switch (op) {
            case less:
                return r1 < r2 ? 1 : 0;
            case lessEq:
                return r1 <= r2 ? 1 : 0;
            case greater:
                return r1 > r2 ? 1 : 0;
            case greaterEq:
                return r1 >= r2 ? 1 : 0;
            case equal:
                return r1 == r2 ? 1 : 0;
            case notEqual:
                return r1 != r2 ? 1 : 0;
            case none:
                return 0;
            default:
                return 0;
        }
    }

    public String toJSON() {
        String left = "{" + "\"left\":" + this.left.toJSON();
        String right = "\"right\":" + this.right.toJSON() + "}";
        return left + "," + "\"operator\":" + "\"" + op + "\"" + "," + right;
    }
}