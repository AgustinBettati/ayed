package main.stacks.calculator;
import struct.impl.LinkedStack;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class is capable of solving simple arithmetic expresions.
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(stringCalculator("4^2+2*4/2-1"));
    }


    /**
     * This method can solve arithmetic expressions that contain addition, substracion, division
     * ,product and exponential operations.
     * @param mathExpression A String that contains the expression with no spaces present.
     * @return
     */
    public static double stringCalculator(String mathExpression) {
        LinkedStack<Character> expression = new LinkedStack<>();
        for (int i = mathExpression.length() - 1; i >= 0; i--) {
            expression.push(mathExpression.charAt(i));
        }

        double partialResult = 0;

        while (expression.size() > 0) {

            boolean isSum;
            if (Character.isDigit(expression.peek())) {
                isSum = true;
            }

            else {
                if (expression.peek() == '+') {
                    isSum = true;
                } else {
                    isSum = false;
                }
                expression.pop();
            }

            String numberA = "";
            while (expression.size() > 0 && Character.isDigit(expression.peek())) {
                numberA += expression.peek();
                expression.pop();
            }

            double innerTerm = Integer.parseInt(numberA);

            while( expression.size() > 0 && !isAdditionOrSubstraction( expression.peek() ) ){
                char operationThatIsNotAddition = expression.peek();
                expression.pop();

                String auxNumber = "";
                while (expression.size() > 0 && Character.isDigit(expression.peek())) {
                    auxNumber += expression.peek();
                    expression.pop();
                }
                double auxiliaryNumber = Integer.parseInt(auxNumber);

                innerTerm = calculateOperation(innerTerm, auxiliaryNumber, operationThatIsNotAddition);
            }

            if(isSum){
                partialResult += innerTerm;
            }
            else{
                partialResult -= innerTerm;
            }

        }
        return partialResult;
    }

    /**
     * This method takes 2 numbers and an operation that is either product, division, or exponencial.
     * @param number1
     * @param number2
     * @param operation
     * @return
     */
    private static double calculateOperation(double number1, double number2, Character operation){
        if(operation == '*'){
            return number1 * number2;
        }
        else if(operation == '/'){
            return number1 / number2;
        }
        else{
            return Math.pow(number1, number2);
        }
    }

    /**
     * This method states if an operation is an addition or substraction.
     * @param operation
     * @return
     */
    private static boolean isAdditionOrSubstraction(Character operation) {
        if(operation == '+' || operation == '-'){
            return true;
        }
        else{
            return false;
        }
    }

}





