import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
        // 반공변적, 불공변적
        // 타입 파라미터는 반공변적이기때문에 한번 정해지면 변경 불가
        // 그럴거면 Object 쓰는게 더 낫겠다.

        // 타입 파라미터랑 관계없이 모든게 들어올 수 있게 하는거 : 와일드카드
        // ? : 뭐가 올지 모르겠지만 모든 것
        // * : 정해진것중에 모든 것 (보통 필드)

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        printAll(list);
        System.out.println(addAll(list));
    }

    public static void printAll(List<?> list) {
        Iterator<?> i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    // ?를 제한할 수 있다.
    // super 타입 제한 와일드카드, 서브타입 제한 와일드카드
    public static Integer addAll(List<? extends Number> list) {
        Iterator<?> i = list.iterator();
        int res = 0;

        while (i.hasNext()) {
            res += (int) i.next();
        }

        return res;
    }
}
