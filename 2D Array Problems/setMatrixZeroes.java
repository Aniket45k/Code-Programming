class setMatrixZeroes {
    public static void setZeroes(int matrix[][]) {
        boolean firstRow = false, firstCol = false;
        // set markers in first row and first column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }

                    if (j == 0) {
                        firstCol = true;
                    }
                    // mark for first row and first col
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                }
            }
        }
        // Replace inner matrix
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Last remaining checks
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        // print matrix

    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 2, 0 }, { 1, 4, 0, 2 }, { 1, 3, 1, 5 }, { 8, 7, 6, 9 } };
        setZeroes(matrix);
        printMatrix(matrix);

    }
}
