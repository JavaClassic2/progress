public class toHexadecimal {
    static final String[] hexaCode = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String convert(int n){
        if (n < 16) {
            return hexaCode[n];
        }

        return convert(n/16) + convert(n%16);
    }

    public static void main(String[] args) {
        for (int i=0; i<20; i++){
            System.out.printf("%d to hexadecimal : %s%n", i, convert(i));
        }
    }
    
}