public class ToBinary {
    public static String toBinary(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        return toBinary(n, "");
    }
    
    public static String toBinary(int n, String res) {
        if (n == 0) {
            if (res.isEmpty()) {
                return "0";
            }
            return res;
        }

        return toBinary(n/2, n%2 + res);
    }

    public static String toBinary2(int n) {
        if (n == 0) {
            return "0";
        }

        return toBinary2(n/2) + toBinary(n%2);
    } 

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            System.out.printf("%d to binary : %s%n", i, toBinary2(i));
        }
    }
}
