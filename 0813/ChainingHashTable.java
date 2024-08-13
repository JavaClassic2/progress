public class ChainingHashTable {
    class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Entry && ((Entry)o).getKey().equals(getKey());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(key).append(", ").append(value).append("]");
            return sb.toString();
        }
    }
    
    class Node {
        Entry entry;
        Node next;
        
        public Node(ChainingHashTable.Entry entry) {
            this.entry = entry;
        }

        public Node(ChainingHashTable.Entry entry, ChainingHashTable.Node next) {
            this.entry = entry;
            this.next = next;
        }
    }

    class Column {
        Node head;

        public void add(Entry entry) {
            if (contains(entry)) {
                search(entry.getKey(), false).entry = entry;
                return;
            }

            head = new Node(entry, head);
        }

        public boolean contains(Entry entry) {
            return search(entry.getKey(), false) != null;
        }

        private Node search(String key, boolean remove) {
            if (head == null) {
                return null;
            }

            Node node = head;

            // 첫번째에서 발견
            if (node.entry.getKey().equals(key)) {
                if (remove) {
                    head = head.next;
                }
                return node;
            }

            // 2번째부터 찾기
            while (node.next != null) {
                if (node.next.entry.getKey().equals(key)) {
                    Node result = node.next;
                    if (remove) {
                        node.next = result.next;
                    }
                    return result;
                }
                node = node.next;
            }

            return null;
        }

        public Entry getEntry(String key) {
            return search(key, false).entry;
        }

        public Entry remove(String key) {
            return search(key, true).entry;
        }

        public void clear() {
            head = null;
        }

        @Override
        public String toString() {
            if (head == null) {
                return "[]";
            }

            StringBuilder builder = new StringBuilder().append("[").append(head.entry);
            Node node = head.next;

            while (node != null) {
                builder.append(", ").append(node.entry);
                node = node.next;
            }

            return builder.append("]").toString();
        }
    }

    private int capacity;
    private int size;
    private Column[] table;
    private static final int DEFAULT_CAPACITY = 10;

    public ChainingHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Column[capacity];
        for (int i=0; i<capacity; i++) {
            table[i] = new Column();
        }
    }

    public ChainingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    private int getIndex(String key) {
        return key.hashCode() % capacity;
    }

    public void add(String key, String value) {
        table[getIndex(key)].add(new Entry(key, value));
        size++;
    }

    public Entry get(String key) {
        return table[getIndex(key)].getEntry(key);
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("{\n");
        
        for (int i=0; i<capacity; i++) {
            sb.append("    ").append(i).append(" : ").append(table[i]).append("\n");
        }

        return sb.append("}").toString();
    }

    public static void main(String[] args) {
        ChainingHashTable table = new ChainingHashTable(10);
        String[] datas = {
            "Rad",
            "Uhr",
            "Ohr",
            "Tor",
            "Hut",
            "Tag",
            "Eis",
            "Ast",
            "Zug",
            "Hof",
            "Mal"
        };

        for (int i=0; i<datas.length; i++) {
            table.add(datas[i], datas[datas.length-i-1]);
            System.out.printf("append(%s, %s) : %n%s%n", datas[i], datas[datas.length-i-1], table);
        }


    }
}
