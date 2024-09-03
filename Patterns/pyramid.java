public class pyramid {
    public static void oddSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print("");
            } else {
                System.out.println(arr[i]);
                sum += arr[i];

            }

        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        // int n = 5;
        // for (int i = 0; i <= n; i++) {
        // for (int j = i; j <= n; j++) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= 1 + (i * 2); j++) {
        // System.out.print(" * ");
        // }

        // System.out.println();
        // }

        // }
        int arr[] = { 3, 2, 4, 6, 9, 7 };
        oddSum(arr);

    }
}
