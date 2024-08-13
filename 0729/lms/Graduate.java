package lms;

// 대학원생
public class Graduate extends Student {
    private String major;

    public Graduate(int studentNo, String name, String cellphone, String major) {
        super(studentNo, name, cellphone);
        this.major = major;
    }

}
