package lms;

public abstract class Student implements Comparable<Student>{
    private int studentNo;
    private String name;
    private String cellphone;

    public Student(int studentNo, String name, String cellphone) {
        this.studentNo = studentNo;
        this.name = name;
        this.cellphone = cellphone;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public String getCellphone() {
        return cellphone;
    }

    @Override
    public int compareTo(Student o) {
        return studentNo - o.getStudentNo();
    }

    @Override
    public String toString() {
        return String.format("%d. %s, phone : %s", studentNo, name, cellphone);
    }
}
