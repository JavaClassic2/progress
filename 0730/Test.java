interface Func {
    int apply(int i, int j);
}

class Adder implements Func {
    public int apply(int i, int j) {
        return i + j;
    }
}

class Test{
    public static int calc(Func f, int i, int j){
        return f.apply(i, j);
    }

    public static void main(String[] args) {
        calc(new Adder(), 1, 2); // 여기에 new Adder() 대신 람다식을 쓸 수 있지 않을까?
        calc((i, j) -> i+j, 1, 2);
    }
}