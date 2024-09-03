public class spiralMatrix {
    public static void spiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {// important condition
            // top
            for (int j = startRow; j <= endCol; j++) {
                System.out.print(matrix[startRow][j]);
            }
            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol]);
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[endRow][j]);
            }
            // left
            for (int i = startRow - 1; i >= startRow + 1; i--) {
                if (startCol == endRow) {
                    break;
                }
                System.out.print(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;

        }
    }

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 6, 1, 9, 3 }

        };
        spiral(matrix);
    }
}