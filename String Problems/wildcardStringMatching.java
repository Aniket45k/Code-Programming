public class wildcardStringMatching {
    static boolean match(String wild, String pattern) {
        int m = wild.length();
        int n = pattern.length();

        // dp[i][j] will be true if the first i characters in wild
        // match the first j characters in pattern
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty wild matches empty pattern
        dp[0][0] = true;

        // Handling '*' in wild for an empty pattern
        for (int i = 1; i <= m; i++) {
            if (wild.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Build the dp matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match or wild has '?'
                if (wild.charAt(i - 1) == pattern.charAt(j - 1) || wild.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (wild.charAt(i - 1) == '*') {
                    // '*' can match with empty sequence or any character
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String wild1 = "ge*ks";
        String pattern1 = "geeks";
        System.out.println(match(wild1, pattern1)); // Output: true

        String wild2 = "ge?ks*";
        String pattern2 = "geeksforgeeks";
        System.out.println(match(wild2, pattern2)); // Output: true
    }
}
