package algorithms.tasks.expression_parser;

import java.util.Stack;

public class InfixToPostfix {

    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    /**
     * Метод для преобразования инфиксного выражения в постфиксное
     */
    public static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            //Пробелы
            if (Character.isWhitespace(ch)) {
                continue;
            }

            // Если символ - операнд, добавляем его к результату в постфиксном формате
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            }
            // Если символ – открывающая скобка, помещаем её в стек
            else if (ch == '(') {
                stack.push(ch);
            }
            // Если символ – закрывающая скобка, выталкиваем все операторы из стека до открывающей скобки
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            // Если символ - оператор
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}
