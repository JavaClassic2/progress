import student.Department;
import student.Student;

public class App {
    public static void main(String[] args) {
        Student s = new Student("taco", "IT");
        System.out.println(s);

        Department department = new Department(0, "IT");
        department.add(s);
        department.add(new Student("yakki", "IT"));

        System.out.println(department.getStudent(0));
        System.out.println(department.getStudent(1));
    }    
}
