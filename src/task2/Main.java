/**
 * Условия: задачи
 * Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 * @autor Воробьев А.
 * @version 1.0
 */

package task2;
import task2.myException.WrongNumberRange;
import task2.myProg.MyProg;

public class Main {

    public static void main(String[] args) {

        //
        MyProg myProg = new MyProg(-10,100,5);

        try {
            myProg.generateRandomNumber();
            myProg.writeGenerateRandomNumber();

            myProg.calcSqrtNumbersArray();
            myProg.writeCalcSqrtNumbersArray();

            myProg.searchNumber();

        } catch (WrongNumberRange wrongNumberRange) {
            wrongNumberRange.printStackTrace();
        }

    }
}
