public class palindromicSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        char c[] = s.toCharArray();

        for (int i = 0; i < n; i++) {
            res += isPalindrome(i, i, c);
            res += isPalindrome(i, i + 1, c);
        }
        return res;
    }

    public static int isPalindrome(int s, int e, char c[]) {
        int count = 0;
        while (s >= 0 && e < c.length && c[s--] == c[e++])
            count++;
        return count;
    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(countSubstrings(str));
    }
}
