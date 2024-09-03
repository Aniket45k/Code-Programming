public class minOperToMakePalindrome {
    public static int minOperations(int nums[]) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] < nums[j]) {
                i++;
                nums[i] += nums[i - 1];
                res++;
            } else {
                j--;
                nums[j] += nums[j + 1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 10, 1 };
        System.out.println(minOperations(arr));

    }

}
