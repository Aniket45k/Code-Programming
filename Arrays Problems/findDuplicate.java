import java.util.HashSet;

public class findDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                // If the element is already in the set, it's a duplicate
                return true;
            }
        }

        // No duplicates found
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 9, 3 };

        boolean res = new findDuplicate().containsDuplicate(nums1);
        System.out.println(res); // Output: true

    }
}
