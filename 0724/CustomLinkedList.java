class Node {
    Object data;
    Node nextNode;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }
}

public class CustomLinkedList implements CustomList{
    private Node node;

    @Override
    public void add(Object item) {
        if (node == null) {
            node = new Node(item);
        }
        else {
            Node endNode = findEndNode();
            endNode.nextNode = new Node(item);
        }
    }

    public Node findEndNode(){
        Node node = this.node;
        while(node.getNextNode() != null) {
            node = node.getNextNode();
        }

        return node;
    }

    @Override
    public Object get(int index) {
        Node findNode = this.node;
        
        if (index == 0) {
            return findNode.getData();
        }
        
        for (int i=0; i<index; i++) {
            if (findNode == null) {
                System.out.println("out of index");
            }
            else {
                findNode = findNode.getNextNode();
            }
        }
        
        return findNode.getData();
    }
    
}

class Test {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(3);
        list.add("taco");

        System.out.println("0 : " + list.get(0));
        System.out.println("1 : " + list.get(1));
    }
}