import java.util.HashMap;

public class DynamicFibonicci {
    private HashMap<Integer, Integer> fibonachiTable;

    public DynamicFibonicci() {
        fibonachiTable = new HashMap<>();
    }

    public int fibonacci(int n) {
        System.out.printf("Called fibonacci(%d)%n", n);
        
        if (n == 0 || n == 1) {
            fibonachiTable.put(n, n);
            System.out.printf("return fibonacci(%d) = %d%n", n, n);
            return n;
        }
        
        if (fibonachiTable.containsKey(n)) {
            System.out.printf("return fibonacci(%d) = %d%n", n, fibonachiTable.get(n));
            return fibonachiTable.get(n);
        }
        
        int result = fibonacci(n-1) + fibonacci(n-2);
        fibonachiTable.put(n, result);
        System.out.printf("fibonacci(%d) = fibonacci(%d) + fibonacci(%d) = %d%n", n, n-1, n-2, result);
        
        return result;
    }

    public static void main(String[] args) {
        int[] answer = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

        DynamicFibonicci fibonachi = new DynamicFibonicci();
        
        for (int i=0; i<answer.length; i++) {
            System.out.printf("fibonachi(%d) = %d, result = %d%n",i, fibonachi.fibonacci(i), answer[i]);;
        }
    }
}
