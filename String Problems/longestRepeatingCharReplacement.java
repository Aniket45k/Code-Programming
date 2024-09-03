public class longestRepeatingCharReplacement {
    public static int characterRepl(String s, int k) {
        int lo = 0;
        int arr[] = new int[26];
        int max_frq = 0;
        int max_length = 0;
        for (int hi = 0; hi < s.length(); hi++) {
            arr[s.charAt(hi) - 'A']++;
            int frq = arr[s.charAt(hi) - 'A'];
            max_frq = Math.max(max_frq, frq);
            while (hi - lo + 1 - max_frq > k) {
                arr[s.charAt(lo) - 'A']--;
                lo++;
            }
            max_length = Math.max(max_length, hi - lo + 1);
        }
        return max_length;
    }

    public static void main(String[] args) {
        String str = "AABABBB";
        System.out.println(characterRepl(str, 2));
    }
}
