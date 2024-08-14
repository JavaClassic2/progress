import java.util.HashMap;

public class DynamicFibonicci {
    private HashMap<Integer, Integer> fibonachiTable;

    public DynamicFibonicci() {
        fibonachiTable = new HashMap<>();
    }

    public int fibonacci(int n) {
        if (n == 0) {
            fibonachiTable.put(0, 0);
            return 0;
        }

        if (n == 1) {
            fibonachiTable.put(1, 1);
            return 1;
        }

        if (fibonachiTable.containsKey(n)) {
            return fibonachiTable.get(n);
        }

        int result = fibonacci(n-1) + fibonacci(n-2);
        fibonachiTable.put(n, result);
        
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
