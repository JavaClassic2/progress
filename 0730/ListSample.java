import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// A를 넣어서 B가 나오도록 apply
class Func implements Function<Integer, Integer> {
    public Integer apply(Integer i) {
        return i*2;
    }
}

public class ListSample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<10; i++) {
            list.add(i);
        }

        Function<Integer, Integer> func = new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t * 2;
            }
        };

        Function<Integer, Integer> func2 = i -> i * 2;

        list.stream().map(new Func()).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(func).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(func2).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map((i) -> i*2).collect(Collectors.toList()).forEach(System.out::println);

        Stream<Integer> stream = list.stream();
        stream.filter((i)-> i%2 == 0).map((i) -> i*2).collect(Collectors.toList()).forEach(System.out::println);
    }
}
