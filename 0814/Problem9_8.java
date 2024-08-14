public class Problem9_8 {

    public static void main(String[] args) {
        hanoiTowers(3, 'A', 'B', 'C');

        System.out.println("예상 결과 : ");
        System.out.println("Move top disk from peg A to peg C.\r\n" + //
                        "Move top disk from peg A to peg B.\r\n" + //
                        "Move top disk from peg C to peg B.\r\n" + //
                        "Move top disk from peg A to peg C.\r\n" + //
                        "Move top disk from peg B to peg A.\r\n" + //
                        "Move top disk from peg B to peg C.\r\n" + //
                        "Move top disk from peg A to peg C.");
    }

    public static void hanoiTowers(int n, char x, char y, char z) {
        if (n == 1) {
            System.out.printf("Move top disk from peg %s to peg %s.%n", x, z);
            return;
        }

        hanoiTowers(n-1, x, z, y);
        hanoiTowers(1, x, y, z);
        hanoiTowers(n-1, y, x, z);
    }
    
}