public class findDuplicateWithOrderNComplexity {
    static void printRepeating(int[] arr, int size) {
        System.out.println("the ele is ");
        for (int i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
        int arr_size = arr.length;
        printRepeating(arr, arr_size);
    }
}
