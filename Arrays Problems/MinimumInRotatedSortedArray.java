public class MinimumInRotatedSortedArray {
    public static int min(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        int mid = low + (high - low) / 2;
        while (low < high) {
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[high];
    }

    public static int find(int arr[], int tar) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == tar) {
                return mid;
            }
            // Determine which side is sorted
            if (arr[mid] >= arr[high]) { // Left side is sorted
                if (arr[low] <= tar && tar < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right side is sorted
                if (arr[mid] < tar && tar <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1; // low and high should be the same at the end
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        System.out.println(find(arr, 5)); // Output should be 1
        System.out.println(min(arr));
    }
}
