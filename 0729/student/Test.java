package student;

public class Test {
    public static void main(String[] args) {
        Student mallang = new Student(2, "mallang", "010-2222-3333");
        Student taco = new Student(0, "taco", "010-1111-2222");
        Student yakki = new Student(1, "yakki", "010-2222-1111");
        Student bear = new Student(3, "bear", "010-3333-2222");

        Department<Student> it = new Department(0, "IT");
        it.add(mallang);
        it.add(taco);
        it.add(yakki);
        it.add(bear);

        System.out.println("sort 전");
        for(Student s : it){
            System.out.println(s);
        }

        System.out.println("no 순 정렬");
        it.list.sort(new StudentNoComparator());
        
        for(Student s : it){
            System.out.println(s);
        }
        
        System.out.println("name 순 정렬");
        it.list.sort(new StudentNameComparaotr());

        for(Student s : it){
            System.out.println(s);
        }
    }
}
