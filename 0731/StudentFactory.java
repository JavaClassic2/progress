public class StudentFactory {
    private Student student;
    
    public StudentFactory() {
        if (student == null){
            student = new Student(0, "taco");
        }
    }

    public Student getStudent() {
        return student;
    }

    public class Student {
        private int no;
        private String name;

        private Student(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public String getName() {
            return name;
        }
    }
}

class StudentTest {
    public static void main(String[] args) {
        StudentFactory studentFactory = new StudentFactory();
        System.out.println(studentFactory.getStudent());
        System.out.println(studentFactory.getStudent());
        System.out.println(studentFactory.getStudent().getNo());
    }
}
