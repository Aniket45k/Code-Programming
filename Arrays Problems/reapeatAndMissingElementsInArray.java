public class reapeatAndMissingElementsInArray {
    public static void RAndM(int arr[]) {
        System.out.print("Repeat element: ");
        for (int i = 0; i < arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            } else {
                System.out.println(abs_val);
            }
        }
        System.out.print("Missing element: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println(i + 1);
            }

        }

    }

    public static void main(String[] args) {
        int num[] = { 2, 1, 3, 2, 5 };
        RAndM(num);

    }
}
