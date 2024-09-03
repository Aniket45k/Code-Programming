public class nextPermutation {
    public static String nextPermutations(String str) {
        char[] charArray = str.toCharArray();
        int n = charArray.length;
        int i = n - 2;
        while (i >= 0 && charArray[i] >= charArray[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(charArray, 0, n - 1);
        } else {
            int j = n - 1;
            while (charArray[j] <= charArray[i]) {
                j--;
            }
            swap(charArray, i, j);
            reverse(charArray, i + 1, n - 1);
        }
        return str = new String(charArray);
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    private static void reverse(char[] charArray, int i, int j) {
        while (i < j) {
            swap(charArray, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String str = "cadrt";

        System.out.println("Original string: " + str);

        String nextPermutedString = nextPermutations(str);

        System.out.println("Next permutation: " + nextPermutedString);
    }
}
