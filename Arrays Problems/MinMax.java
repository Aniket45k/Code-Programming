
import java.util.*;

class MinMax {
    public static void getMinMax(int arr[], int n) {
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        System.out.println("Minimum element is " + min);
        System.out.println("Maximum element is " + max);
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = arr.length;
        getMinMax(arr, arr_size);

    }
}
