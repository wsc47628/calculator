package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        var tmp = new ArrayList<>(List.of(expression));          // var- сам объявляет тип данных, List.of???

        int brOpenIdx;
        do {
            brOpenIdx = -1;
            for (int i = 0; i < tmp.size(); i++) {               //Пробегаемся по спискуу
                String a = tmp.get(i);                           //Заносим в переменную а элимента списка tmp
                if (a.equals("(")) {                             //Находим какой элимент списка евляется открываюшая скобка
                    brOpenIdx = i;                               //Записывае индекс открываюшей скобки в переменную brOpenIdx
                } else if (a.equals(")")) {                      //Находим закрываюшую скобку
                    var inBr = tmp.subList(brOpenIdx + 1, i);    //Записывае в переменную inBr то что находится в скобках к примеру если привер 2+(1+3)-2 то в inBr мы запишем 1+3
                    var result = calculate(inBr);                //То что в inBr мы передаем в метод calculate
                    tmp.subList(brOpenIdx, i + 1).clear();       //Очишаем то что было в скобках
                    tmp.add(brOpenIdx, result);                  //На место открываюшей скобки ставим результат что получилась в скобках, т.е. если
                    break;                                       // в tmp.add 2 аргумента то 1 аргумент это индекс в списке куда мы поставим а 2 аргумент это что мы поставим
                }
            }
        } while (brOpenIdx != -1);


        return calculate(tmp);
    }

    String calculate(List<String> expression) {
        List<String> tmp = new ArrayList<>();                   //Объявляем новый список куда будем занасить все значение других списков
        double a = Double.parseDouble(expression.get(0));       //В переменную а заносим нулевой элимент списка и переводим в doouble
        for (int i = 1; i < expression.size(); i += 2) {        //Пробегаемся только к по знакам(+, -, *, /)
            String op = expression.get(i);                      //В переменную i заносим знак
            double b = Double.parseDouble(expression.get(i + 1)); //В переменную b в заносим заносим число которое идёт после знака
            switch (op) {
                case "+":                                       //Если знак является + илл - то в список tmp мы заносим переменную а(первое число)
                case "-":                                       // и записываем его с типом String
                    tmp.add(String.valueOf(a));                 //Также добовляем в список знак
                    tmp.add(op);                                //И переменной а присваеваем значение b что бы при следуюшем пробеги по списку
                    a = b;                                      //возли знака стояли правельные числа, т.е. в примере 2+4*2+2
                    break;                                      //Сночала "2" и "+" добавяться в список tmp, потом 4 умножеться на 2 и получется 8,
                case "*":                                       //и уже "8" и "+"добавиться в список tmp, и на последок в список добавится "2"
                    a *= b;                                     // того мы получем в tmp [2.0, +, 8.0, +, 2.0]
                    break;
                case "/":
                    a /= b;
                    break;
            }
        }

        tmp.add(String.valueOf(a));

        System.out.println(tmp);

        double result = Double.parseDouble(tmp.get(0));
        for (int i = 1; i < tmp.size(); i += 2) {
            String op = tmp.get(i);
            double b = Double.parseDouble(tmp.get(i + 1));
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

