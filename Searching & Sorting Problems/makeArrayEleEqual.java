import java.util.Arrays;

public class makeArrayEleEqual {
    private static int getCost(int[] nums, int[] cost, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result += (int) Math.abs(nums[i] - target) * cost[i];
        }
        return result;
    }

    public static int minCost(int[] nums, int[] cost) {

        int answer = Integer.MAX_VALUE;

        int left = Arrays.stream(nums).min().orElse(Integer.MAX_VALUE); // 1
        int right = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE); // 5
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cost1 = getCost(nums, cost, mid);
            int cost2 = getCost(nums, cost, mid + 1);

            answer = Math.min(cost1, cost2);
            if (cost1 > cost2)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        int[] cost = { 5, 3, 1 };

        int result = minCost(nums, cost);
        System.out.println("Minimum Cost: " + result);
    }
}
