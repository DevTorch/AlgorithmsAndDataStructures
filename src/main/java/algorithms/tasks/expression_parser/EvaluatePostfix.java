package algorithms.tasks.expression_parser;

import java.util.Stack;

public class EvaluatePostfix {

    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Если символ – операнд, помещаем его в стек
            if (Character.isDigit(ch)) {
                stack.push((double) (ch - '0'));
            } else {
                double right = stack.pop();
                double left = stack.pop();

                // Если символ – оператор, выталкиваем два операнда из стека,
                // выполняем операцию и результат помещаем обратно в стек
                switch (ch) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
