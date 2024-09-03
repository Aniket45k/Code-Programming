public class containerWithMostWater {
    public static int maxArea(int height[]) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));
    }
}
