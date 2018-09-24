package calculator;
import java.util.*;

import java.util.ArrayList;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {


    String calculate(String[] expression) {
        List <String> tmp = new ArrayList<>();
        double a = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i+=2){
            String op = expression[i];
            double b = Double.parseDouble(expression[i + 1]);
            switch (op){
                case "+":
                case "-":
                    tmp.add(String.valueOf(a));
                    tmp.add(op);
                    a=b;
                    break;
                case "*":
                    a*=b;
                    break;
                case "/":
                    a/=b;
                    break;
            }


        }
        tmp.add(String.valueOf(a));
        System.out.println(tmp);




        double result = Double.parseDouble(expression[0]);
        for (int i = 1; i < tmp.size(); i += 2) {
            String op = tmp.get(1);
            double b = Double.parseDouble(tmp.get(i+1));
            switch (op) {
                case "+":
                    result += b;
                    break;
                case "-":
                    result -= b;
                    break;
                default:
                    return "ERROR";
            }

        }


        return String.valueOf(result);


    }

}

