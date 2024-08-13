package util;

public class Converter {
    public int convertC(int f) {
        return (f-32) * 5/9;
    }

    public int convertF(int c) {
        return 9/5 * c + 32;
    }

    public String convertDecimal(int decimal) {
        String res = "";

        if (decimal == 0) {
            return "0";
        }
        
        while (decimal != 0) {
            res = decimal % 2 + res;
            decimal = decimal/2;
        }
        
        return res;
    }
}
