package student;

public class Student {
    private static int index;
    private int studentNo;
    private String name;
    private String department;

    public Student(String name, String department) {
        this.studentNo = nextNo();
        this.name = name;
        this.department = department;
    }

    private int nextNo() {
        return index++;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return String.format("studentNo: %d, name: %s, department: %s", studentNo, name, department);
    }
}
