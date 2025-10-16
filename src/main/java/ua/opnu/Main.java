package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Іваненко", "Петро", 35);
        Student student = new Student("Петренко", "Марія", 20, "ІПЗ-21-1", "IP123456");
        Lecturer lecturer = new Lecturer("Сидоренко", "Олександр", 45, "Комп'ютерних наук", 25000.0);

        Person[] people = {person, student, lecturer};

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}