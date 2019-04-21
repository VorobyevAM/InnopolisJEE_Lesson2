package task3.sort;

import task3.myException.CoincidenceNameAndAge;
import task3.person.Person;

public interface MySort {

    void printer();

    void sort();

    void toSwap(int first, int second);

    void into(Person person) throws CoincidenceNameAndAge;

    int countIteration();

}
