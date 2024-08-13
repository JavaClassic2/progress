@FunctionalInterface
public interface RunSomething {
    void doIt();    // 추상 메소드는 doIt() 하나

    static void printName(){
        System.out.println("catsbi");
    }

    default void printAge(){
        System.out.println("33");
    }
}

class Test3 {
    public static void main(String[] args) {
        // 람다식을 만드는 방법
        RunSomething r = () -> System.out.println("Hello");
        r.doIt();

        // 익명클래스를 만드는 방법
        RunSomething r2 = new RunSomething() {
            public void doIt() {
                System.out.println("Hello");
            }
        };
        r2.doIt();

        // 추상메로드를 구현하는 클래스를 만드는 방법
        DoRun d = new DoRun();
        d.doIt();
    }
}

// 구현하는 버전
class DoRun implements RunSomething {
    public void doIt() {
        System.out.println("Hello");
    }
}