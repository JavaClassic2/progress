@FunctionalInterface
public interface BinaryOp {
    int apply(int i, int j);
}

class Test2 {
    public static int calc(BinaryOp binder, int i, int j) {
        return binder.apply(i, j);
    }

    public static void main(String[] args) {
        // 익명 클래스 제작
        // 벗어나면 재활용 불가
        BinaryOp adder = new BinaryOp() {
            public int apply(int i, int j) {
                return i + j;
            }
        }; 

        int result = calc(adder, 2, 3);
        System.out.println(result);
    }


}

class Calc {
    public static int add(int i, int j) {
        return i + j;
    }

    public int mult(int i, int j) {
        return i * j;
    }
}

class Test4 {
    public static void main(String[] args) {
        BinaryOp adder = Calc::add;
        BinaryOp multer = new Calc()::mult;
        System.out.println(adder.apply(1, 2));
        System.out.println(multer.apply(2, 3));
    }
}