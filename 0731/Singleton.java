public class Singleton {
    private static Singleton singleton;
    private int no;

    private Singleton() {no++;};

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public int getNo() {
        return no;
    }
}

class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton.getNo());
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton2.getNo());
    }
}