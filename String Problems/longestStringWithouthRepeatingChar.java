import java.util.Arrays;

public class longestStringWithouthRepeatingChar {
    public static int lengthOfString(String s) {
        int n = s.length();
        int freq[] = new int[256];
        Arrays.fill(freq, 0);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (freq[s.charAt(i)] == 1) {
                while (freq[s.charAt(i)] == 1) {
                    freq[s.charAt(j)]--;
                    j++;
                }
            }
            freq[s.charAt(i)]++;
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcabdbb";
        System.out.println(lengthOfString(str));
    }
}
