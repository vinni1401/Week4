import java.util.*;

abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
    public String toString() { return name; }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    void addCourse(T course) { courseList.add(course); }
    List<T> getCourses() { return courseList; }
}

public class UniversitySystem {
    public static void displayCourses(List<? extends CourseType> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignCourses = new Course<>();

        System.out.println("Enter number of exam courses:");
        int ex = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < ex; i++) examCourses.addCourse(new ExamCourse(sc.nextLine()));

        System.out.println("Enter number of assignment courses:");
        int as = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < as; i++) assignCourses.addCourse(new AssignmentCourse(sc.nextLine()));

        System.out.println("Exam Courses:");
        displayCourses(examCourses.getCourses());
        System.out.println("Assignment Courses:");
        displayCourses(assignCourses.getCourses());
    }
}
