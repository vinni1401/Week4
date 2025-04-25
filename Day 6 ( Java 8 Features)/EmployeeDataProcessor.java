import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary;
    }
}

public class EmployeeDataProcessor {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 75000),
            new Employee(3, "Charlie", "HR", 65000),
            new Employee(4, "David", "Engineering", 85000),
            new Employee(5, "Eve", "Marketing", 70000)
        );

        // 1. Filter
        List<Employee> filtered = employees.stream()
            .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
            .collect(Collectors.toList());

        // 2. Sort descending by salary
        List<Employee> sorted = filtered.stream()
            .sorted(Comparator.comparingDouble(Employee::salary).reversed())
            .collect(Collectors.toList());

        // 3. Group by department
        Map<String, List<Employee>> grouped = sorted.stream()
            .collect(Collectors.groupingBy(e -> e.department));

        // 4. Aggregate average salary per department
        Map<String, Double> avgSalary = grouped.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream().mapToDouble(e -> e.salary).average().orElse(0.0)
            ));

        // Display results
        System.out.println("Filtered & Sorted Employees:");
        sorted.forEach(System.out::println);

        System.out.println("\nGrouped by Department:");
        grouped.forEach((dept, list) -> System.out.println(dept + ": " + list));

        System.out.println("\nAverage Salary by Department:");
        avgSalary.forEach((dept, avg) -> System.out.println(dept + ": $" + avg));
    }
}
