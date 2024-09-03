import java.util.Arrays;

public class pairWithGivenDifference {
    public static int findPair(int arr[], int tar) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            if (arr[j] - arr[i] == tar) {
                System.out.println(arr[i] + " " + arr[j]);
                break;
            } else if (arr[j] - arr[i] < tar) {
                j++;
            } else {
                i++;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[] = { 5, 20, 3, 2, 50, 80 };
        findPair(arr, 78);
    }

}
