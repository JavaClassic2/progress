public class Fibonacci {
    public int recursion(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return (recursion(n-1) + recursion(n-2));
    }

    public int iteration(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 0;
        } 

        if (n == 1) {
            return 1;
        }

        int result = 0;
        int first = 0;
        int second = 0;
        boolean isFirst = true;

        for (int i=0; i<n; i++) {
            if (i == 0) {
                result +=  0;
                first = i;
            } else if (i == 1) {
                result += 1;
                second = i;
            } else {
                result = first + second;
                if (isFirst) {
                    first = result;
                } else {
                    second = result;
                }
            }
        }

        return result;
    }
    
    public int iteration2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 0;
        } 

        if (n == 1) {
            return 1;
        }

        int result = 0;
        int first = 0;
        int second = 1;

        for (int i=2; i<=n; i++) {
            result = first + second;
            second = first;
            first = result;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] answer = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377};

        Fibonacci fibonachi = new Fibonacci();
        
        System.out.println("===== recursion test =====");
        for (int i=0; i<answer.length; i++) {
            System.out.printf("fibonachi(%d) = %d, result = %d%n",i, fibonachi.recursion(i), answer[i]);;
        }
        
        System.out.println("===== iteration test =====");
        for (int i=0; i<answer.length; i++) {
            System.out.printf("fibonachi(%d) = %d, result = %d%n",i, fibonachi.recursion(i), answer[i]);;
        }
    }
}