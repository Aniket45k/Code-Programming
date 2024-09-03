import java.util.*;

public class countPalindromicSubsequence {
    public static void main(String[] args) {
        int mod = 1000_000_007;
        String s = "103301";
        int n = s.length();
        int[][][] pre = new int[n][10][10];
        int[][][] suf = new int[n][10][10];
        int[] cnts = new int[10];
        for (int i = 0; i < n; i++) {
            int dig = s.charAt(i) - '0';
            if (i >= 1) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        pre[i][j][k] = pre[i - 1][j][k];
                        if (k == dig) {
                            pre[i][j][k] += cnts[j];
                        }
                    }
                }
            }
            cnts[dig]++;
        }
        Arrays.fill(cnts, 0);
        for (int i = n - 1; i >= 0; i--) {
            int dig = s.charAt(i) - '0';
            if (i <= n - 2) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 0; k <= 9; k++) {
                        suf[i][j][k] = suf[i + 1][j][k];
                        if (k == dig) {
                            suf[i][j][k] += cnts[j];
                        }
                    }
                }
            }
            cnts[dig]++;
        }
        int ans = 0;
        for (int i = 2; i < n - 2; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    ans = (ans + (pre[i - 1][j][k] * suf[i + 1][j][k]) % mod) % mod;
                }
            }
        }
        System.out.println(ans);
    }
}
