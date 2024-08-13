package stack;

public class IntStack implements Stack<Integer>{
    int[] elements;
    int maxIndex = 5;
    int index;

    public IntStack() {
        this.elements = new int[maxIndex];
    }

    @Override
    public void push(Integer t) {
        elements[index] = t;
        index++;
    }

    @Override
    public Integer pop() {
        return elements[index--];
    }
}
