interface Operation {
    int calc(int i, int j);
}

class Adder implements Operation{
    public int calc(int i, int j) {
        return i + j;
    }
}

class Multiplier implements Operation {
    public int calc(int i, int j) {
        return i * j;
    }
}

public class Calc{
    public int calc(Operation op, int i, int j) {
        return op.calc(i, j);
    }
}
