import java.util.HashMap;
import java.util.Map;

public class Exam6_2 {
    // key, entry에 대한 해쉬코드가 기준은 아닌듯함
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("Tor", "gate");
        map1.put("Rad", "wheel");
        map1.put("Tag", "day");
        map1.put("Uhr", "clock");
        map1.put("Hut", "hat");
        map1.put("Ohr", "ear");
        System.out.println("map1=" + map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("Rad", "wheel");
        map2.put("Uhr", "clock");
        map2.put("Ohr", "ear");
        map2.put("Tag", "day");
        map2.put("Tor", "gate");
        map2.put("Hut", "hat");
        System.out.println("map2=" + map2);
    }
}
