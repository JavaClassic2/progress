public class LinstTest {
    public static void main(String[] args) {
        List single = new SingleLinkedList();
        
        single.add(1);
        single.add("taco");

        System.out.println(single.get(0));
        System.out.println(single.get(1));

        single.clear();

        single.add(3);
        System.out.println(single.get(0));
    }
}
