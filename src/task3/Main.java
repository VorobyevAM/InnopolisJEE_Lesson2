/**
 * Условие: Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов. Предусмотреть единый интерфейс
 * для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
 * -первые идут мужчины
 * -выше в списке тот, кто более старший
 * -имена сортируются по алфавиту
 *
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 *
 * @autor Воробьев А.
 * @version 1.0
 */

package task3;

import task3.myException.CoincidenceNameAndAge;
import task3.person.Person;
import task3.person.PersonComparator;
import task3.person.Sex;
import task3.sort.BubbleSort;
import task3.sort.ChoiceSort;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(26, Sex.WOMAN,"Marie");
        Person person2 = new Person(45,Sex.MAN,"John");
        Person person3 = new Person(12,Sex.MAN,"Frederic");
        Person person4 = new Person(75,Sex.WOMAN,"Veronica");
        Person person5 = new Person(11,Sex.WOMAN,"Liza");
        Person person6 = new Person(34,Sex.MAN,"Frederic");
        Person person7 = new Person(67,Sex.WOMAN,"Zoe");
        Person person8 = new Person(27,Sex.MAN,"Alex");
        Person person9 = new Person(27,Sex.MAN,"Alex");

/*        ArrayList<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);

        System.out.println(personList);

        PersonComparator personComparator = new PersonComparator();
        Collections.sort(personList, personComparator);

        System.out.println(personList);*/


        BubbleSort array = new BubbleSort(9);

        //ChoiceSort array = new ChoiceSort(8);

        try {
            array.into(person1);
            array.into(person2);
            array.into(person3);
            array.into(person4);
            array.into(person5);
            array.into(person6);
            array.into(person7);
            array.into(person8);
            array.into(person9);
        } catch (CoincidenceNameAndAge coincidenceNameAndAge) {
            coincidenceNameAndAge.printStackTrace();
        }

        array.printer();
        array.sort();
        array.printer();

    }

}
