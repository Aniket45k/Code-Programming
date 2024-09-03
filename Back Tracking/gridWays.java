public class gridWays {
    public static int gridWay(int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {// condition for last call
            return 1;
        } else if (i == n || j == n) {
            return 0;
        }

        int w1 = gridWay(i + 1, j, n, m);
        int w2 = gridWay(i, j + 1, n, m);
        return w1 + w2;

    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        System.out.println(gridWay(0, 0, n, m));
    }
}
