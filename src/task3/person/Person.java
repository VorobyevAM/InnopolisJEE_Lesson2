package task3.person;

public class Person implements Comparable{

    private int age;

    private Sex sex;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        Person entry = (Person) o;

        int flag = getSex().compareTo(entry.getSex());

        if (flag==0){
            flag = entry.getAge()-getAge();
        }

        if (flag==0){
            flag = getName().compareTo(entry.getName());
        }

        return flag;
    }
}
