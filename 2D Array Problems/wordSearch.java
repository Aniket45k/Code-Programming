public class wordSearch {
    public static boolean isFind(char board[][], String word) {
        // dfs->'.' visited
        int r = board.length, c = board[0].length;
        boolean ans = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, i, j, word)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.') {
            return false;
        }
        if (board[i][j] == word.charAt(0)) {
            boolean ans = false;
            board[i][j] = '.';
            ans = ans || dfs(board, i -1 1, j, word.substring(1));
            ans = ans || dfs(board, i, j + 1, word.substring(1));
            ans = ans || dfs(board, i + 1, j, word.substring(1));
            ans = ans || dfs(board, i, j - 1, word.substring(1));
            board[i][j] = word.charAt(0);
            return ans;
        }
        return false;
    }

    public static void main(String[] args) {
        char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";
        System.out.println(isFind(board, word));
    }
}
