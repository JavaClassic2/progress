/**
 * Student
 */
public class Student {
    private int no;
    private String name;
    private String departmentName;
    private double point;
    
    private Student(Builder builder) {
        this.no = builder.no;
        this.name = builder.name;
        this.departmentName = builder.departmentName;
        this.point = builder.point;
    }

    public static class Builder {
        private int no;
        private String name;
        private String departmentName;
        private double point;

        public Builder studentNo(int no) {
            this.no = no;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder point(double point) {
            this.point = point;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
    
}

class Test {
    public static void main(String[] args) {
        Student s = new Student.Builder()
            .studentNo(1)
            .name("taco")
            .departmentName("IT")
            .point(1000)
            .build();

        System.out.println(s);
    }
}