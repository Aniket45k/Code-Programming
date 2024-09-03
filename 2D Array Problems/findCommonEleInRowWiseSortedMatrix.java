public class findCommonEleInRowWiseSortedMatrix {
    public static int answer(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int ans = 0;
        for (int j = m - 1; j >= 0; j--) {
            int temp = arr[0][j];
            int i = 1;
            int count = 1;
            while (i != n) {
                int col = m - 1;
                while (col >= 0 && arr[i][col] > temp) {
                    col--;
                }
                if (col >= 0 && arr[i][col] == temp) {
                    count++;
                } else {
                    break;
                }
                i++;
            }
            if (count == n) {
                ans = temp;
                break;
            }
        }
        if (ans == 0) {
            return -1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 3, 4, 5 },
                { 1, 4, 5, 8, 10 },
                { 1, 5, 7, 9, 11 },
                { 1, 3, 5, 7, 9 },
        };
        System.out.println(answer(arr));
    }
}
