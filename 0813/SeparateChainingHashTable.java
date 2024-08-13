import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SeparateChainingHashTable {
    public static class Entry {
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

        public boolean equals(Object o) {
            return (o instanceof Entry) && ((Entry)o).hash() == hash();
        }

        public int hash() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            return builder.append("[").append(key).append(", ").append(value)
                            .append("]").toString();
        }
    }

    static class Node{
        Entry entry;
        Node next;

        public Node(SeparateChainingHashTable.Entry entry) {
            this.entry = entry;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Node && entry.key.hashCode() == ((Node)o).entry.hashCode();
        }

        public int hash() {
            return entry.key.hashCode();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Node node = this;
            
            builder.append("[").append(node.entry);
            while (node.next != null) {
                builder.append(", ").append(node.entry);
                node = node.next;
            }
            builder.append("] ");

            return builder.toString();
        }
    }

    private Set<Node> entries = new HashSet<>();
    private int capacity;
    private int size;

    /**
     * 기존데이터
     * @param key
     * @param value
     */
    public String put(String key, String value) {
        if (entries.contains(key)) {
            for (Node entry : entries) {
                if (entry.entry.getKey().equals(key)) {
                    String oldValue = entry.entry.getValue();
                    entry.next = new Node(new Entry(key, value));
                    return oldValue;
                }
            }
        }

        entries.add(new Node(new Entry(key, value)));
        return null;
    }

    
    public String get(String key) {
        return key;
    }

    public boolean contains(String key) {
        return keySet().contains(key);
    }

    public int size() {
        return size;
    }

    // 여기부터는 옵션
    public Set<String> keySet() {
        Set<String> keySet = new HashSet<>();

        for (Node entry : entries) {
            keySet.add(entry.entry.getKey());
        }

        return keySet;
    }

    public Set<Node> getEntries() {
        return entries;
    }

    public void setCapacity(int capacity) {
        if (this.capacity < capacity) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
    }

    @Override
    public String toString() {
        if (entries.isEmpty()) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(" [ ");
        entries.forEach(node -> {
            builder.append("[").append(node.entry);
            while (node.next != null) {
                builder.append(", ").append(node.entry);
                node = node.next;
            }
            builder.append("] ");
        });
        builder.append("]");

        return builder.toString();
    }

    public static void main(String[] args) {
        SeparateChainingHashTable table1 = new SeparateChainingHashTable();
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
            table1.put(datas[i], datas[datas.length-i-1]);
        }

        for (Node node : table1.entries) {
            System.out.println(node);
        }
    }

    // public static void main(String[] args) {
    //     SeparateChainingHashTable table1 = new SeparateChainingHashTable();
    //     table1.put("Tor", "gate");
    //     System.out.printf("table1.put(%s) : %s%n","Tor", table1);
    //     table1.put("Rad", "wheel");
    //     System.out.printf("table1.put(%s) : %s%n","Rad", table1);
    //     table1.put("Tag", "day");
    //     System.out.printf("table1.put(%s) : %s%n","Tag", table1);
    //     table1.put("Uhr", "clock");
    //     System.out.printf("table1.put(%s) : %s%n","Uhr", table1);
    //     table1.put("Hut", "hat");
    //     System.out.printf("table1.put(%s) : %s%n","Hut", table1);
    //     table1.put("Ohr", "ear");
    //     System.out.printf("table1.put(%s) : %s%n","Ohr", table1);
    //     table1.put("gate", "Ohr");
    //     System.out.printf("table1.put(%s) : %s%n","gate", table1);
    //     table1.put("wheel", "Hut");
    //     System.out.printf("table1.put(%s) : %s%n","wheel", table1);
    //     table1.put("day", "Uhr");
    //     System.out.printf("table1.put(%s) : %s%n","day", table1);
    //     table1.put("clock", "Tag");
    //     System.out.printf("table1.put(%s) : %s%n","clock", table1);
    //     table1.put("hat", "Rad");
    //     System.out.printf("table1.put(%s) : %s%n","hat", table1);
    //     table1.put("ear", "Tor");
    //     System.out.printf("table1.put(%s) : %s%n","ear", table1);
    // }
}
