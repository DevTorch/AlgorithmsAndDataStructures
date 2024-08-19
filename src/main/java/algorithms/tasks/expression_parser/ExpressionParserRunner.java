package algorithms.tasks.expression_parser;

public class ExpressionParserRunner {
    public static void main(String[] args) {

        String expression = "2*(2+5)+((2-1)/(4-3))";

        System.out.printf("Original expression: %s\n", expression);
        System.out.printf("Infix: %s\n", InfixToPostfix.infixToPostfix(expression));
        System.out.printf("Result: %.2f\n", EvaluatePostfix.evaluatePostfix(InfixToPostfix.infixToPostfix(expression)));

    }
}
