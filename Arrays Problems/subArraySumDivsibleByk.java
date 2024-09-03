import java.util.HashMap;

class subArraySumDivsibleByk {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;

        mp.put(0, 1);

        int result = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            if (mp.containsKey(rem)) {
                result += mp.get(rem);
            }

            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 2, -6, 3, 1, 2, 8, 2, 1 };
        System.out.println(subarraysDivByK(nums, 7));

    }
}
