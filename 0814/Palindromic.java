public class Palindromic  {
    public static boolean search(String s, int index) {
        if (index == s.length()/2) {
            return true;
        }

        if (s.charAt(index) != s.charAt(s.length()-1-index)) {
            return false;
        }

        return search(s, index+1);
    }

    public static boolean isPalindromic(String s) {
        return search(s, 0);
    }

    public static void main(String[] args) {
        String[] testStrings = {"ABA", "tomato", "Aba", "bob"};

        for (String testString : testStrings){
            System.out.printf("isPalindromic (%s) : %b%n", testString, isPalindromic(testString));
        }
    }
}
