import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<String>> map = new HashMap<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name: ");
            String name = sc.next();
            System.out.print("Enter department: ");
            String dept = sc.next();

            if (!map.containsKey(dept)) {
                map.put(dept, new ArrayList<>());
            }
            map.get(dept).add(name);
        }

        System.out.println("Grouped by Department:");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            List<String> list = entry.getValue();
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
                if (j != list.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
