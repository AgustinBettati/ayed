package main.stacks.calculator;
import struct.impl.LinkedStack;

/**
 * This class is capable of solving simple arithmetic expresions.
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(stringCalculator("-4+2*4/2+1"));
    }


    /**
     * This method can solve arithmetic expresions that contain addition, substracion, division
     * and product.
     * @param mathExpression A String that contains the expresion with no spaces present.
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
                if (isAddition(expression.peek())) {
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
                boolean isProduct = isProduct( expression.peek() );
                expression.pop();

                String auxNumber = "";
                while (expression.size() > 0 && Character.isDigit(expression.peek())) {
                    auxNumber += expression.peek();
                    expression.pop();
                }
                double auxiliaryNumber = Integer.parseInt(auxNumber);

                if(isProduct){
                    innerTerm = innerTerm * auxiliaryNumber;
                }
                else{
                    innerTerm = innerTerm / auxiliaryNumber;
                }
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

    private static boolean isAddition(Character operation) {
        if(operation == '+'){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isAdditionOrSubstraction(Character operation) {
        if(operation == '+' || operation == '-'){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean isProduct(Character operation) {
        if(operation == '*'){
            return true;
        }
        else{
            return false;
        }
    }

}





