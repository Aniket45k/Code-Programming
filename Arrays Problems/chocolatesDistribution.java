import java.util.*;

public class chocolatesDistribution {
    public static int Distributions(int arr[], int m) {
        if (arr.length == 0 || m == 0) {// imp condition
            return -1;
        }
        Arrays.sort(arr);
        if (arr.length - 1 < m) {// imp condition
            return -1;
        }

        int max = Integer.MIN_VALUE;
        if (max < 5) {
            System.out.println("true");
        }
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int j = i + m - 1;
            if (j >= arr.length) {// imp condition
                break;
            }
            int diff = arr[j] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
            }

        }
        return min_diff;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 1, 9, 56, 7, 9, 12 };

        int m = 5;
        int res = new chocolatesDistribution().Distributions(arr, m);
        System.out.println(res);

    }

}
