import java.util.*;

abstract class JobRole {
    String candidate;
    JobRole(String candidate) { this.candidate = candidate; }
    public String toString() { return candidate; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String candidate) { super(candidate); }
}

class DataScientist extends JobRole {
    DataScientist(String candidate) { super(candidate); }
}

class ProductManager extends JobRole {
    ProductManager(String candidate) { super(candidate); }
}

class Resume<T extends JobRole> {
    T role;
    Resume(T role) { this.role = role; }
    void process() {
        System.out.println("Screening resume for: " + role);
    }
}

public class ResumeScreening {
    public static void screenAll(List<? extends JobRole> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Screening: " + list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<SoftwareEngineer> seList = new ArrayList<>();
        List<DataScientist> dsList = new ArrayList<>();

        System.out.println("Enter number of software engineer applicants:");
        int se = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < se; i++) seList.add(new SoftwareEngineer(sc.nextLine()));

        System.out.println("Enter number of data scientist applicants:");
        int ds = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < ds; i++) dsList.add(new DataScientist(sc.nextLine()));

        System.out.println("Screening Software Engineers:");
        screenAll(seList);
        System.out.println("Screening Data Scientists:");
        screenAll(dsList);
    }
}
