/**
 * @autor Воробьев А.
 * @version 1.0
 */

package task2.myProg;

import task2.myException.SqrtForNegativeNumber;
import task2.myException.WrongNumberRange;

public class MyProg {

    /** Поле нижний предел диапазона */
    private int min;

    /** Поле верхний предел диапазона */
    private int max;

    /** Поле количество случайных чисел */
    private int countRandomNumber;

    /** Поле сгенерированнй массив случайных чисел, количество которых определяется полем countRandomNumber*/
    private int [] sourceIntArrayNumbers;

    /** Поле массив квадратных корней чисел из массива sourceIntArrayNumbers*/
    private double [] sqrtNumbersFromSourceIntArray;

    /** Поле массив квадратов чисел из массива sqrtNumbersFromSourceIntArray*/
    private int [] squareNumber;

    /** Конструктор - создание нового объекта с определенными значениями
     * @param min - нижний предел диапазона
     * @param max - верхний предел диапазона
     * @param countRandomNumber - количество случайных чисел*/
    public MyProg(int min, int max, int countRandomNumber) {
        this.min = min;
        this.max = max;
        this.countRandomNumber = countRandomNumber;
    }

    public int getCountRandomNumber() {
        return countRandomNumber;
    }

    public void setCountRandomNumber(int countRandomNumber) {
        this.countRandomNumber = countRandomNumber;
    }

    public int[] getSourceIntArrayNumbers() {
        return sourceIntArrayNumbers;
    }

    public void setSourceIntArrayNumbers(int[] sourceIntArrayNumbers) {
        this.sourceIntArrayNumbers = sourceIntArrayNumbers;
    }

    public double[] getSqrtNumbersFromSourceIntArray() {
        return sqrtNumbersFromSourceIntArray;
    }

    public void setSqrtNumbersFromSourceIntArray(double[] sqrtNumbersFromSourceIntArray) {
        this.sqrtNumbersFromSourceIntArray = sqrtNumbersFromSourceIntArray;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    /**
     * Функция получения значения поля {@link Product#maker}
     * @return возвращает название производителя
     */
    private int diap() throws WrongNumberRange {
        int diap = this.max-this.min;

        if (diap<=0){
            throw new WrongNumberRange("Диапазон не может быть отрицательным");
        }
        return diap;
    }

    public void generateRandomNumber() throws WrongNumberRange {
        this.sourceIntArrayNumbers = new int[this.countRandomNumber];

        for (int i = 0; i < this.countRandomNumber; i++) {
            this.sourceIntArrayNumbers[i] = (int) (min + Math.random()*diap());
        }
    }

    public void writeGenerateRandomNumber(){
        for (int i = 0; i < this.sourceIntArrayNumbers.length; i++) {
            System.out.println(this.sourceIntArrayNumbers[i]);
        }
        System.out.println();
    }

    public void calcSqrtNumbersArray(){
        this.sqrtNumbersFromSourceIntArray = new double[this.sourceIntArrayNumbers.length];

        for (int i = 0; i < this.sourceIntArrayNumbers.length; i++) {
            if (this.sourceIntArrayNumbers[i]>=0){
                this.sqrtNumbersFromSourceIntArray [i] = Math.sqrt(this.sourceIntArrayNumbers[i]);
            }else{
                throw new SqrtForNegativeNumber("Попытка взять квадратный корень из отрицательного числа " + this.sourceIntArrayNumbers[i] +
                        ". Измените диапазон чисел. Текущий диапазон от " + this.min + " до " + this.max);
            }
        }
    }

    public void searchNumber(){
        this.squareNumber = new int[this.countRandomNumber];

        for (int i = 0; i < this.countRandomNumber; i++) {
            this.squareNumber[i]=((int)this.sqrtNumbersFromSourceIntArray[i])*((int)this.sqrtNumbersFromSourceIntArray[i]);
            if (this.squareNumber[i]==this.sourceIntArrayNumbers[i]){
                System.out.println("Найдено число удовлетворяющие условиям задачи " + this.sourceIntArrayNumbers[i]);
            }
        }
    }

    public void writeCalcSqrtNumbersArray(){
        for (int i = 0; i < this.sqrtNumbersFromSourceIntArray.length; i++) {
            System.out.println(this.sqrtNumbersFromSourceIntArray[i]);
        }
        System.out.println();
    }

}
