public interface Fraction {
    int getNomination();
    int getDenomination();

    // 공통으로 동작하는 기능의 경우 default 메소드로 선언 가능
    // 재정의 가능 (해도 되고, 안해도 된다.)
    default double getDoubleValue() {
        return (double) getNomination() / (double) getDenomination();
    }

    // 재정의 불가
    // 인터페이스를 통해 호출
    static void print(int n, int d) {
        System.out.println(n + "/" + d);
    }
}
