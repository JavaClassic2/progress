public class ProtoType implements Cloneable {
    public int no;

    public ProtoType(int no) {
        super();
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ProtoType clone() {
        return new ProtoType(getNo());
    }
}
