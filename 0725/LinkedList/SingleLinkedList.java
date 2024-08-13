public class SingleLinkedList implements List{
    private Node node;

    @Override
    public void add(Object o) {
        if (node == null) {
            this.node = new Node(o);
            return;
        }

        Node endNode = getEndNode();
        endNode.setNextNode(new Node(o));
    }

    private Node getEndNode() {
        Node findNode = this.node;

        if (findNode == null) {
            return findNode;
        }

        while (findNode.nextNode != null) {
            findNode = findNode.nextNode;
        }

        return findNode;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("index out of bounds");
        }

        Node findNode = this.node;
        for (int i = 0; i<index; i++) {
            findNode = findNode.nextNode;
        }

        return findNode.getData();
    }

    public Node findNode(int index) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("index out of bounds");
        }

        Node findNode = this.node;
        for (int i = 0; i<index; i++) {
            findNode = findNode.nextNode;
        }

        return findNode;
    }

    @Override
    public int size() {
        int size = 1;
        Node findNode = this.node;

        while (findNode.nextNode != null) {
            findNode = findNode.nextNode;
            size++;    
        }

        return size;
    }

    @Override
    public Object remove(int index) {
        Node removeNode = findNode(index);
        Node preNode = findNode(index-1);
        Node nextNode = removeNode.nextNode;

        Object data = removeNode.getData();
        removeNode = null;
        preNode.setNextNode(nextNode);

        return data;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    @Override
    public void clear() {
        this.node = null;
    }
    
}
