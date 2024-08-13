public class App {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add("taco");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        
        arrayList.remove(0);
        arrayList.add("yakki");
        
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        
        arrayList.clear();
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
    }
}
