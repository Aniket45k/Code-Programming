import java.util.*;

public class validPalindrome {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            } else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))) {
                return false;
            } else {
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: panama";
        System.out.println(isPalindrome(str));
    }
}
