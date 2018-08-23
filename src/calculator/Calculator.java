package calculator;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {


    String calculate(String[] expression) {
        System.out.println(expression[0]);
        System.out.println(expression[1]);
        System.out.println(expression[2]);
        double a = Double.parseDouble(expression[0]);
        double b = Double.parseDouble(expression[2]);
        double resault ;
        switch (expression[1]) {
            case "+":
                resault = a + b ;
                break;
            case "-":
                resault = a - b;
                break;
            case "*":
                resault = a * b;
                break;
            case "/":
                resault = a / b;
                break;
            default:
                return "ERROR";



        }
        double c = Double.parseDouble(expression[4]);
        if (expression.length < 4) {
            return String.valueOf(resault);
        }
        switch (expression[3]) {
            case "+":
                resault = resault + c ;
                break;
            case "-":
                resault = resault - c;
                break;
            case "*":
                resault = resault * c;
                break;
            case "/":
                resault = resault / c;
                break;
            default:
                return "ERROR";



        }
        return String.valueOf(resault);
    }

}
