public class rotateImage {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

// public static void rotate(int matrix[][]) {
// int n = matrix.length;
// for (int i = 0; i < (n + 1) / 2; i++) {
// for (int j = 0; j < n / 2; j++) {
// // start 4 ways swaps
// // temp=bottom left
// int temp = matrix[n - 1 - j][i];
// // bottom left=bottom right
// matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
// // bottom right=top right
// matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
// // top right=top left
// matrix[j][n - 1 - i] = matrix[i][j];
// // top left=temp
// matrix[i][j] = temp;
// }
// }
// }

// public static void main(String[] args) {
// int matrix[][] = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15,
// 14, 12, 16 } };
// rotate(matrix);
// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// System.out.print(matrix[i][j] + " ");
// }
// System.out.println();
// }
// }
