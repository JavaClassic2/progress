package student;

public class Graduate extends Student{
    public String major;

    public Graduate(int studentNo, String name, String cellphone) {
        super(studentNo, name, cellphone);
    }

    public Graduate(int studentNo, String name, String cellphone, String major) {
        super(studentNo, name, cellphone);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return String.format("%d. name, cellphone : %s, major : %s", getStudentNo(), getName(), getCellphone(), getMajor());
    }
}
