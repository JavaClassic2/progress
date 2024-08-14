public class Gcd {
    public static int gcd(int n1, int n2) {
        if (n1 < 0 || n2 < 0) {
            throw new IllegalArgumentException();
        }

        if (n1 == 0 || n2 == 0) {
            return n1 == 0 ? n2 : n1;
        }

        if (n1 > n2) {
            return gcd(n1-n2, n2);
        }

        return gcd(n1, n2-n1);
    }

    public static void main(String[] args) {
        int n1 = 48;
        int n2 = 13;
        System.out.printf("gcd(%d, %d) = %d", n1, n2, gcd(n1, n2));
    }
}
