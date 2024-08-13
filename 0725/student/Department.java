package student;

public class Department {
    private int departmentNo;
    private String departmentName;
    private CustomArrayList list;

    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        this.list = new CustomArrayList();
    }

    public void add(Student s) {
        this.list.add(s);
    }

    public Student getStudent(int index) {
        return (Student) this.list.get(index);
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String toString() {
        return String.format("Department no: %d, name: %s", departmentNo, departmentName);
    }
}
