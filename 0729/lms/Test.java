package lms;

import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Department<Student> department = new Department<>(1, "Computer Engineering");

        department.addStudent(new CollegeBoy(3, "mallang", "010-4321-1234"));
        department.addStudent(new CollegeBoy(1, "taco", "010-1234-5678"));
        department.addStudent(new CollegeBoy(2, "yakki", "010-1234-1234"));
        
        for (Student s : department) {
            System.out.println(s);
        }
        
        Collections.sort(department.getList());
        System.out.println();
        
        for (Student s : department) {
            System.out.println(s);
        }
    }
}
