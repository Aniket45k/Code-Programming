public class givenSum {
    // This function returns true if arr[0..n-1]
    // has a pair with sum equals to x.
    static boolean pairInSortedRotated(int arr[], int n, int x) {
        // Find the pivot element
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        // l is now index of smallest element
        int l = (i + 1) % n;

        // r is now index of largest element
        int r = i;

        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum x, we
            // return true
            if (arr[l] + arr[r] == x)
                System.out.print(" (" + arr[l] + "," + arr[r] + ") ");

            // If current pair sum is less, move
            // to the higher sum
            if (arr[l] + arr[r] < x)
                l = (l + 1) % n;

            // Move to the lower sum side
            else
                r = (n + r - 1) % n;
        }
        return false;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2, 3 };
        int X = 7;
        int N = arr.length;
        pairInSortedRotated(arr, N, X);

    }
}