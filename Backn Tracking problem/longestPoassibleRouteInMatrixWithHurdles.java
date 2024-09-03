import java.util.ArrayList;

public class longestPoassibleRouteInMatrixWithHurdles {

    public static void solve(int[][] mat, int i, int j, int[] di, int[] dj, int m, int n, int cur, int[] ans) {
        // If we reach the destination
        if (i == m && j == n) {
            // If current path steps are more than previous path steps
            if (cur > ans[0])
                ans[0] = cur;
            return;
        }

        // if the source or destination is a hurdle itself
        if (mat[i][j] == 0 || mat[m][n] == 0)
            return;

        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if (nexti >= 0 && nextj >= 0 && nexti < mat.length && nextj < mat[0].length && mat[nexti][nextj] == 1) {
                mat[i][j] = 0;
                solve(mat, nexti, nextj, di, dj, m, n, cur + 1, ans);
                mat[i][j] = 1;
            }
        }

        // Backtrack

    }

    public static int findLongestPath(int[][] mat, int m, int n) {
        int[] di = { +1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };
        int[] ans = { -1 }; // Array to store the result
        if (mat[0][0] == 1)
            solve(mat, 0, 0, di, dj, m, n, 0, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 } };

        // Find the longest path with source (0, 0) and destination (2, 3)
        int result = findLongestPath(mat, 2, 3);
        System.out.println(result);
    }
}
