public interface CustomList {
    void add(Object item);
    Object get(int index);
}

class CustomArrayList implements CustomList {
    private int size;
    private int maxSize = 10;
    private Object[] items = new Object[maxSize];

    @Override
    public void add(Object item) {
        if (size == maxSize) {
            System.out.println("list 크기가 꽉 찼습니다.");
            return;
        }

        items[size] = item;
        size++;
    }

    @Override
    public Object get(int index) {
        if (getSize() < index && index > maxSize) {
            throw new IllegalArgumentException("잘못된 index 번호");
        }

        return items[index];
    }

    public int getSize() {
        return this.size;
    }

}

class Test {
    public static void main(String[] args) {
        CustomList list = new CustomArrayList();
        list.add(1);
        list.add("taco");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
