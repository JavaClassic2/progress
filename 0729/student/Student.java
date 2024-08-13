package student;

public class Student implements Comparable<Student>{
    public int studentNo;
    public String name;
    public String cellphone;
    
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
    public String toString() {
        return String.format("%d. name, cellphone : %s", getStudentNo(), getName(), getCellphone());
    }

    @Override
    public int compareTo(Student s) {
        return this.getStudentNo() - s.getStudentNo();
    }
}
