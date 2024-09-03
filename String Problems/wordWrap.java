public class wordWrap {
    // Function to find the minimum total cost of line breaks
    public static int solveWordWrap(int nums[], int k) {
        int n = nums.length;

        // Create a table to store the cost of each line
        int[] cost = new int[n];

        // Initialize the cost of the last line
        cost[n - 1] = 0;

        // Calculate the cost of each line in a bottom-up manner
        for (int i = n - 2; i >= 0; i--) {
            int currentLength = -1;
            cost[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                currentLength += (nums[j] + 1);

                // If the current words fit in the line
                if (currentLength <= k) {
                    int remainingSpaces = k - currentLength;
                    int currentCost = remainingSpaces * remainingSpaces + cost[j + 1];

                    // Update the cost for the current line
                    cost[i] = Math.min(cost[i], currentCost);
                } else {
                    // Break if the current words don't fit in the line
                    break;
                }
            }
        }

        return cost[0];
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 2, 5 };
        int k1 = 6;
        System.out.println(solveWordWrap(nums1, k1)); // Output: 10

        int[] nums2 = { 3, 2, 2 };
        int k2 = 4;
        System.out.println(solveWordWrap(nums2, k2)); // Output: 5
    }
}