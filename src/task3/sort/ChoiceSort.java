package task3.sort;

import task3.myException.CoincidenceNameAndAge;
import task3.person.Person;

public class ChoiceSort implements MySort{

    private Person[] persons;

    private int elems;

    private int count = 0;

    /**
     * Конструктор класса. Создание массива размером max. При создании массив содержит 0 элементов
     * */
    public ChoiceSort(int max) {
        persons = new Person[max];
        elems = 0;
    }

    /**
     * Метод вставки элемента в массив. Вставка person в массив persons. Размер массива увеличивается.
     * */
    @Override
    public void into(Person person) throws CoincidenceNameAndAge {
        for (int i = 0; i < elems; i++) {
            if (person.getAge()==persons[i].getAge() & person.getName().equals(persons[i].getName())){
                throw new CoincidenceNameAndAge("Невозможно добавить человека " + person.toString() + ". Совпадение имени и возраста.");
            }
        }
        persons[elems] = person;
        elems++;
    }

    /**
     * Метод вывода массива в консоль
     * */
    @Override
    public void printer(){
        for (int i = 0; i < elems; i++) {
            System.out.println(persons[i] + " ");
            System.out.println("");
        }
        System.out.println("----Окончание вывода массива-----");
        System.out.println("Количество итераций сравнения " + count);
    }

    @Override
    public void toSwap(int first, int second) {
        Person defaultPerson = persons[first];
        persons[first]=persons[second];
        persons[second]=defaultPerson;
    }

    @Override
    public void sort(){
        for (int i = 0; i < elems; i++) {
            Person min = persons[i];
            int minimum = i;

            for (int j = i+1; j < elems; j++) {
                if (persons[j].compareTo(persons[minimum])<0){
                    min = persons[j];
                    minimum=j;
                    countIteration();
                }
                countIteration();
            }
            if (i !=minimum){
                toSwap(i,minimum);
            }
        }
    }

    @Override
    public int countIteration() {
        count++;
        return this.count;
    }
}
