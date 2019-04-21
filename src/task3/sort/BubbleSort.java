package task3.sort;

import task3.myException.CoincidenceNameAndAge;
import task3.person.Person;

public class BubbleSort implements MySort{

    private Person [] persons;

    private int elems;

    private int countIteration = 0;

    /**
     * Конструктор класса. Создание массива размером max. При создании массив содержит 0 элементов
     * */
    public BubbleSort(int max) {
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
                throw new CoincidenceNameAndAge("Невозможно добавить человека " + person.toString() + ". Совпадение имени и возраста");
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
        System.out.println("---------------Окончание вывода массива------------");
        System.out.println("Количество итераций сравнения " + countIteration());
    }

    @Override
    public void toSwap(int first, int second) {
        Person defaultPerson = persons[first];
        persons[first]=persons[second];
        persons[second]=defaultPerson;
    }


    @Override
    public void sort(){
        for (int out = elems-1; out >= 1 ; out--) {
            for (int in = 0; in < out; in++) {
                if (persons[in].compareTo(persons[in+1])>0){
                    toSwap(in,in+1);
                    countIteration();
                }
                countIteration();
            }
        }
    }

    @Override
    public int countIteration() {
         countIteration++;
        return countIteration;
    }
}
