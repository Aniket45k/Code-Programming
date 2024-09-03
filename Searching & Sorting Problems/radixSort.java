import java.util.Arrays;

public class radixSort {
    private static void countingSort(int[] arr, int place) {
        int size = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] output = new int[size + 1];
        int[] count = new int[max + 1];

        // Calculate count of elements
        for (int j : arr)
            count[(j / place) % 10]++;

        // Calculate cumulative count

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, size);
    }

    // Main function to implement radix sort
    public static void radixSort(int arr[]) {

        boolean isNegative = false;
        for (int i : arr) {
            if (i < 0) {
                isNegative = true;
                break;
            }
        }

        int min = 0;
        if (isNegative) {
            min = Arrays.stream(arr).min().getAsInt();
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= min;
            }
        }

        // Get maximum element
        int max = Arrays.stream(arr).max().getAsInt();

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(arr, place);

        for (int i = 0; i < arr.length; i++) {
            arr[i] += min;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 800, 1, -5, 3, -9, 13 };
        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
