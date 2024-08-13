public class Hash {
    public static void main(String[] args) {
        String[] messages = {
            "ABC",
            "CBA",
            "BCA"
        };

        for (String message : messages) {
            System.out.printf("%s hash : %d%n", message, hash(message));
        }
    }


    static int hash(String s) {
        return s.charAt(0) + s.charAt(s.length()/2) * s.charAt(s.length()-1);
    }
}