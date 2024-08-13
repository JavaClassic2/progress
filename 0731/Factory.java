public class Factory {
    private Object[] objects;

    public Factory() {
        this.objects = new Object[]{new Singleton2(), new ProtoType(1)};
    }

    // 하나만
    public Singleton2 getSingleton() {
        return (Singleton2)objects[0];
    }

    // 복제해서 주니까 여러개
    public ProtoType getProtoType() {
        return ((ProtoType)objects[1]).clone();
    }
}

class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Singleton2 s1 = factory.getSingleton();
        Singleton2 s2 = factory.getSingleton();

        ProtoType p1 = factory.getProtoType();
        ProtoType p2 = factory.getProtoType();
        
        System.out.println(s1);
        System.out.println(s2);

        System.out.println(p1);
        System.out.println(p2);
    }
}