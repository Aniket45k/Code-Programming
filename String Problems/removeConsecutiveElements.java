public class removeConsecutiveElements {
    public static String removeConsecutivechar(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            } else {
                res += s.charAt(i);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aabbccdeab";
        System.out.println(removeConsecutivechar(str));
    }
}
