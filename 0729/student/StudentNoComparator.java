package student;

import java.util.Comparator;

public class StudentNoComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        int sub = s1.getStudentNo() - s2.getStudentNo();
        if (sub > 0) {
            return 1;
        } else if (sub == 0) {
            return 0;
        }
        return -1;
    }
    
}