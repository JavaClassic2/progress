import java.util.Iterator;
import java.util.List;

public class Department implements Iterable<Student>{
    private int departmentNo;
    private String departmentName;
    private List<Student> studentList;
    
    public Department(int departmentNo, String departmentName, List<Student> studentList) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        this.studentList = studentList;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public Iterator<Student> iterator() {
        return new DepartmentManager(studentList);
    }
}