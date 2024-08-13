class Slot {
    String value;

    public Slot(String value) {
        this.value = value;
    }
}

// 100개 짜리 해쉬테이블 -> 배열은 125개 생성 (+25%)
public class Hashtable {
    Slot[] hashtable;   // bucket

    public Hashtable(int size) {
        this.hashtable = new Slot[size];
    }

    public int hashFunction(String key) {
        return key.charAt(0) % this.hashtable.length;
    }

    public boolean put(String key, String value) {
        int address = hashFunction(key);
        
        if (hashtable[address] != null) {
            hashtable[address].value = value;
        }

        hashtable[address] = new Slot(value);

        return true;
    }

    public String get(String key) {
        int address = hashFunction(key);
        
        if (hashtable[address] != null) {
            return hashtable[address].value;
        }

        return null;
    }
}

class Test {
    public static void main(String[] args) {
        Hashtable table = new Hashtable(10);
        table.put("taco", "yakki");
        table.put("doll", "mollang");
        table.put("hash", "function");

        System.out.println(table.get("taco"));
        System.out.println(table.get("doll"
        
        ));
        System.out.println(table.get("hash"));
    }
}