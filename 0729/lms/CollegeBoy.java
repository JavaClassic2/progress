package lms;

// 대학생
public class CollegeBoy extends Student {
    private String doubleMajor;

    public CollegeBoy(int studentNo, String name, String cellphone) {
        super(studentNo, name, cellphone);
    }

    public CollegeBoy(int studentNo, String name, String cellphone, String doubleMajor) {
        super(studentNo, name, cellphone);
        this.doubleMajor = doubleMajor;
    }

    public String getDoubleMajor() {
        return doubleMajor;
    }

    @Override
    public String toString() {
        return String.format("%d. %s, doubleMajor: %s, phone : %s", getStudentNo(), getName(), getDoubleMajor(), getCellphone());
    }

}
