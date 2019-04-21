package task3.person;

import java.util.Comparator;

public class PersonComparator implements Comparator <Person> {
    @Override
    public int compare(Person o1, Person o2) {

        int flag = o1.getSex().compareTo(o2.getSex());

        if (flag==0){
            flag = o2.getAge()-o1.getAge();
        }

        if (flag==0){
            flag = o1.getName().compareTo(o2.getName());
        }
        return flag;
    }
}
