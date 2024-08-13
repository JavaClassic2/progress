package student;

import java.util.Comparator;

/**
 * StudentNameComparaotr
 */
public class StudentNameComparaotr implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

    
}