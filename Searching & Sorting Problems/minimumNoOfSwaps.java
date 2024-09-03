import java.util.Arrays;
import java.util.HashMap;

public class minimumNoOfSwaps {
    public static int minSwaps(int nums[]) {
        int n = nums.length;
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        Arrays.sort(a);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(a[i], i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            while (hm.get(nums[i]) != i) {
                count++;
                swap(nums, hm.get(nums[i]), i);
            }
        }
        return count;
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };

        System.out.println(minSwaps(a));
    }
}
