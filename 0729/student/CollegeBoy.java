package student;

public class CollegeBoy extends Student{
    public String doubleMajor;

    public CollegeBoy(int studentNo, String name, String cellphone, String doubleMajor) {
        super(studentNo, name, cellphone);
        this.doubleMajor = doubleMajor;
    }

    public CollegeBoy(int studentNo, String name, String cellphone) {
        super(studentNo, name, cellphone);
    }
    
    public String getDoubleMajor() {
        return doubleMajor;
    }
    
    @Override
    public String toString() {
        return String.format("%d. name, cellphone : %s, doubleMajor : %s", getStudentNo(), getName(), getCellphone(), getDoubleMajor());
    }
}
