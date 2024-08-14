import java.util.Stack;

// 1개 -> 1개의 원판을 start에서 end로 이동

// 2개 이상
// -> (n-1)개의 원판을 start에서 end를 거쳐 middle로 이동
// -> 1개의 원판을 start에서 end로 이동 (hanoi(1))
// -> (n-1개의 원판을) middle에서 start을 거쳐 end로 이동

public class Hanoi {
    Stack<Integer> start;
    Stack<Integer> middle;
    Stack<Integer> end;

    public Hanoi(Stack<Integer> start, Stack<Integer> middle, Stack<Integer> end) {
        this.start = start;
        this.middle = middle;
        this.end = end;
    }

    // n개를 start에서 middle을 거쳐서 end로 이동시킨다.
    public void hanoi(int n, Stack<Integer> start, Stack<Integer> middle, Stack<Integer> end){
        if (n == 1) {
            end.push(start.pop());
            System.out.println(this);
            return;
        }
        
        hanoi(n-1, start, end, middle);
        
        hanoi(1, start, middle, end);
        // printHanoi(start, middle, end);
        
        hanoi(n-1, middle, start, end);
        // printHanoi(start, middle, end);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===============")
            .append("\nstart : ").append(start)
            .append("\nmiddle : ").append(middle)
            .append("\nend : ").append(end)
            .append("\n===============");
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> start = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> end = new Stack<>();

        for (int i=5; i>0; i--) {
            start.push(i);
        }

        Hanoi hanoi = new Hanoi(start, middle, end);
        System.out.printf("hanoi(%d) : %s%n", 5, hanoi);

        hanoi.hanoi(start.size(), start, middle, end);
    }
}
