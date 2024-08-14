public class ConvertDecimal {
    static final String[] hexaCode = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    
    public static String convert (int n, int decimal) {
        if (n < decimal) {
            return hexaCode[n];
        }

        return convert(n/decimal, decimal) + convert(n%decimal, decimal);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            System.out.printf("%d to binary : %s%n", i, convert(i, 2));
        }

        for (int i=0; i<30; i++){
            System.out.printf("%d to hexaDecial : %s%n", i, convert(i, 16));
        }
    }
}
