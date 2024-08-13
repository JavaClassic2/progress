public class ArrayList implements List{
    private Object[] elements;
    private int index;

    public ArrayList() {
        this.elements = new Object[5];
    }

    public ArrayList(ArrayList list) {
        this.elements = list.elements.clone();
    }

    @Override
    public void add(Object o) {
        this.elements[index] = o;
        index++;
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public int size() {
        return index+1;
    }
    
}
