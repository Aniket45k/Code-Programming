import java.util.*;

public class formBiggestNumInArray {
    public static String largestNumber(int arr[]) {
        int n = arr.length;
        String s[] = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = String.valueOf(arr[i]);

        }
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));// nlogn
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 8, 1, 5, 9, 2 };
        System.out.println(largestNumber(arr));
    }
}
