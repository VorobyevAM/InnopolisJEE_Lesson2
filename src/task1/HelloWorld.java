package task1;

//Не забыть java-doc

import task1.myException.NameMustNotContainNumbers;
import task1.person.Person;

import java.util.Scanner;

public class HelloWorld {


    public static void main(String[] args) throws NameMustNotContainNumbers {

        //Person для моделирования NPE
        Person personForNPE = new Person();

        //Person для моделирования переполнения массива
        Person personForArrayOutOfBoundException = new Person("Пабло Диего Хозе Франциско де Паула Хуан Непомукено Криспин Криспиано де ла Сантисима Тринидад Руиз и Пикассо");

        //Person для кастомной ошибки
        Person personForNameMustNotContainNumbers = new Person("r2d2");

        //Вызывая данный метод получаем NPE
        giveNameToUpperCase(personForNPE.getName());

        //Вызывая данный метод получаем ArrayOutOfBoundException
        giveCharArray(personForArrayOutOfBoundException.getName());

        //Вызывая данный метод получаем кастомный exception
        checkNumberInName(personForNameMustNotContainNumbers.getName());

    }

    private static void giveNameToUpperCase(String name){
        System.out.println(name.toUpperCase());
    }

    private static void giveCharArray(String name) throws ArrayIndexOutOfBoundsException{
        char [] nameChars = new char[20];
        for (int i = 0; i < name.length(); i++) {
            System.out.print(nameChars[i] = name.charAt(i));
        }
    }

    private static void checkNumberInName(String name) throws NameMustNotContainNumbers {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new NameMustNotContainNumbers("Имя не может содержать цифры!");
            }
        }
    }
}
