import java.util.Arrays;

public class Exam6_4_6_1 {
    // 마스크(해쉬 코드의 길이를 일정하게 하기 위해서 사용)
    private static final int MASK = 0x7FFFFFFF; // 2^32-1
    // 최대 갯수
    private static final int CAPACITY = 11;
    // 갯수
    private static int size = 0;
    // 얼마나 쓰고있는지
    private static boolean[] used = new boolean[CAPACITY];

    private static void printHash(String word) {
        System.out.printf("hash(%s) : %d, load : %d%%%n", word, hash(word), size * 100 / CAPACITY);
    }

    private static int hash(Object object) {
        int hash = (object.hashCode() & MASK) % CAPACITY;
        
        // 빈 자리 찾기
        while (used[hash]) {
            if (size == CAPACITY) {
                throw new ArrayStoreException();
            }
            // 배열을 넘어가면 앞으로 돌려야함 -> (hash + 1) %capacity
            // 특정 범위를 돌릴때 %연산을 많이 씀
            // 그래서 capacity는 소수를 주로 사용한다.

            // 선형 탐색 : h = h + 1
            // 제곱 탐색 : h = h + jump * jump (jump는 임의의 수 지정 가능)
            // 제곱 탐색은 넓게 분산되게 하는 장점이 있음
            // 문제는 배열이 다 안찼는데 무한 점프 할 수도 있음
            System.out.printf("%d ", hash = (hash + 1)%CAPACITY);
        }

        used[hash] = true;
        size++;

        return hash;
    }

    public static void main(String[] args) {
        printHash("Rad");
        printHash("Uhr");
        printHash("Ohr");
        printHash("Tor");
        printHash("Hut");
        printHash("Tag");
        printHash("Eis");
        printHash("Ast");
        printHash("Zug");
        printHash("Hof");
        printHash("Mal");

        // used 전체 초기화
        size = 0;
        Arrays.fill(used, false);
        System.out.println("clear");

        printHash("Mal");
        printHash("Hof");
        printHash("Zug");
        printHash("Ast");
        printHash("Tag");
        printHash("Hut");
        printHash("Eis");
        printHash("Tor");
        printHash("Ohr");
        printHash("Uhr");
        printHash("Rad");
    }

}