public class alternatingRectangleOfZeroAndOne {
    static void fill0X(int m, int n) {
        int startRow = 0;
        int startCol = 0;
        int endRow = m - 1;
        int endCol = n - 1;
        char x = 'X';
        char matrix[][] = new char[m][n];
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = x;
            }
            startRow++;
            // right
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = x;
            }
            endCol--;
            // bottom
            for (int j = endCol; j >= startCol; j--) {
                matrix[endRow][j] = x;
            }
            endRow--;
            // left
            for (int i = endRow; i >= startRow; i--) {
                matrix[i][startCol] = x;
            }
            startCol++;
            // Flip character for next iteration
            x = (x == '0') ? 'X' : '0';
        }
        // Print the filled matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Output for m = 5, n = 6");
        fill0X(5, 6);

        System.out.println("Output for m = 4, n = 4");
        fill0X(4, 4);

        System.out.println("Output for m = 3, n = 4");
        fill0X(3, 4);
    }
}
