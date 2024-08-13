public class ArrayList implements List{
    private Object[] list;
    private int maxSize;
    private int index;

    public ArrayList() {
        this(50);
    }

    public ArrayList(int maxSize) {
        this.maxSize = maxSize;
        list = new Object[maxSize];
    }

    @Override
    public void add(Object o) {
        this.list[index] = o;
        this.index++;
    }


    @Override
    public Object get(int index) {
        return this.list[index];
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public void remove(int index) {
        Object[] preList = this.list.clone();
        
        for (int i=0; i<index; i++) {
            list[i] = preList[i];
        }

        for (int i=index; i<size(); i++) {
            list[i] = preList[i+1];
        }

        this.index--;
    }
    
    @Override
    public boolean isEmpty() {
        return this.list[0] == null;
    }
    
    @Override
    public void clear() {
        this.list = new Object[maxSize];
        this.index = 0;
    }
    
}
