class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + age + " - $" + salary;
    }
}

public class SortByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 55000),
            new Person("Charlie", 35, 60000)
        );

        people.stream()
              .sorted(Comparator.comparingInt(p -> p.age))
              .forEach(System.out::println);
    }
}