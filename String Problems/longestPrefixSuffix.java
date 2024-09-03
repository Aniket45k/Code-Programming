public class longestPrefixSuffix {
    static int lps(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int i = 1;
        int j = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {

                lps[i] = j + 1;
                j++;
                i++;

            } else {
                lps[i] = 0;
                i++;

            }
        }
        return lps[n - 1];

    }

    public static void main(String[] args) {
        String str = "abab";
        System.out.println(lps(str));
    }
}
