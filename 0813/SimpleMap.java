import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class SimpleMap<K, V> extends AbstractMap<K, V>{
    class SimpleEntry<I, E> implements Entry<I,E> {
        private I key;
        private E value;
        private int hashCode;
        
        public SimpleEntry(I key, E value) {
            this.key = key;
            this.value = value;
            this.hashCode = key.hashCode();
        }

        @Override
        public I getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return value;
        }

        @Override
        public E setValue(E value) {
            E prev = this.value;
            this.value = value;
            return prev;
        }

        // hashcode와 equals를 둘 다 정의해야 함
        @Override
        public int hashCode() {
            return hashCode;
        }
        
        @Override
        public boolean equals(Object o) {
            return (o instanceof SimpleEntry) && ((SimpleEntry<I, E>)o).hashCode() == hashCode();
        }
    }

    Set<Entry<K, V>> entries = new HashSet<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;    
    }
    
    @Override
    public V put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey() == key) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }

        // key가 중복이면 삽입X
        entries.add(new SimpleEntry<K, V>(key, value));

        return null;

    }


    public static void main(String[] args) {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("one", "4");
        
        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
