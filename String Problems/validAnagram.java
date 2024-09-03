public class validAnagram {
    public static boolean isAnagram(String s, String t) {
        int count[] = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "aghds";
        String str2 = "aghsd";
        System.out.println(isAnagram(str1, str2));
    }
}
