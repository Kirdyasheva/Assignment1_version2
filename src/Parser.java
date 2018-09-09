public class Parser {
    private String input;
    Logical expressionTree;

    Parser(String input) {
        this.input = input.replaceAll(" ", "");
    }

    public Expression parse() {
        return parseLogical();
    }


    private Expression parseLogical() {
        Expression result = parseRelation();
        if (input.isEmpty()) return result;
        while (!input.isEmpty()) {
            String op = parseLogOperator();
            if (op != "none") {
               /* if (op != "and") {
                    Expression right = parseRelation();
                    result = new Logical(op, result, right);
                }
                if (op == "and") {
                    Expression current = result;
                    Expression buf;
                    while (true) {
                        if (current.right == null && current.left == null) {
                            buf = current;
                            current = new Logical(op, buf, parseRelation());
                            break;
                        } else {
                            current = current.right;
                        }
                    }
                }*/
                Expression right = parseRelation();
                result = new Logical(op, result, right);
            } else break;
        }
        return result;
    }

    private String parseLogOperator() {
        String op;
        switch (input.charAt(0)) {
            case 'a':
                op = "and";
                input = input.substring(3);
                break;
            case 'o':
                op = "or";
                input = input.substring(2);
                break;
            case 'x':
                op = "xor";
                input = input.substring(3);
                break;
            default:
                op = "none";
        }
        return op;
    }


    private Expression parseRelation() {
        Expression result = parseTerm();
        if (input.isEmpty()) {
            return result;
        }
        while (!input.isEmpty()) {
            String op = parseRelOperator();
            if (op != "none") {
                Expression right = parseTerm();
                result = new Relation(op, result, right);
            } else break;
        }
        return result;
    }

    private String parseRelOperator() {
        String op;
        if ((input.charAt(0) == '>' || input.charAt(0) == '<' || input.charAt(0) == '=' || input.charAt(0) == '!') && input.charAt(1) == '=') {
            op = Character.toString(input.charAt(0)) + Character.toString(input.charAt(1));
            input = input.substring(2);
        } else {
            if (input.charAt(0) == '>' || input.charAt(0) == '<') {
                op = Character.toString(input.charAt(0));
                input = input.substring(1);

            } else {
                op = "none";
            }
        }
        return op;
    }

    private Expression parseTerm() {
        Expression result = parseFactor();
        if (input.isEmpty()) {
            return result;
        }
        while (!input.isEmpty()) {
            String op = parseTermOperator();
            if (op != "none") {
                Expression right = parseFactor();
                result = new Term(op, result, right);
            } else break;
        }
        return result;
    }

    private String parseTermOperator() {
        String op;
        if (input.charAt(0) == '+' || input.charAt(0) == '-') {
            op = Character.toString(input.charAt(0));
            input = input.substring(1);
        } else {
            op = "none";
        }
        return op;
    }

    private Expression parseFactor() {
        Expression result = parsePrimary();
        if (input.equals("")) return result;
        while (!input.isEmpty()) {
            String op = parseFactOperator();
            if (op != "none") {
                Expression right = parsePrimary();
                result = new Factor(op, result, right);
            } else break;
        }
        return result;
    }

    private String parseFactOperator() {
        String op;
        if (input.charAt(0) == '*' || input.charAt(0) == '/') {
            op = Character.toString(input.charAt(0));
            input = input.substring(1);
        } else {
            op = "none";
        }
        return op;
    }

    private Expression parsePrimary() {
        Expression result = null;
        if (input.isEmpty()) {
            System.out.println("Input is empty");
        } else if (Character.isDigit(input.charAt(0)) || input.charAt(0) == '-') {
            result = parseInteger();
        } else if ((input.charAt(0) == '(')) { //parse all symbols in brackets
            input = input.substring(1); //deletes the first bracket
            result = parse();
            input = input.substring(1); //deletes the second brackets
        }
        return result;
    }

    private Expression parseInteger() {
        Expression result;
        String expressions = "";
        String integers = "";
        int flag = 0;
        if (input.charAt(0) == '-') {
            flag = 1;
            integers += "-";
            input = input.substring(1);
        }
        char[] tokens = input.toCharArray();
        int i = 0;
        while (Character.isDigit(tokens[i])) {
            integers += Character.toString(tokens[i]);
            i++;
            if (i == tokens.length) {
                break;                     //the end of the input is reached
            }
        }

        while (i < tokens.length) {
            expressions += Character.toString(tokens[i]);
            i++;
        }

        input = expressions.toString();
        result = new Integer(Long.parseLong(integers.toString()));
        return result;
    }
}
