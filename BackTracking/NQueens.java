class Solution {
    public Boolean isSafe(int i, int j, char[][] chessBoard) {
        // Top
        int temp_i = i, temp_j = j;
        while (temp_i >= 0 && temp_j >= 0) {
            if (chessBoard[temp_i][temp_j] == 'Q') return false;
            temp_i--;
        }

        // Top Left
        temp_i = i;
        temp_j = j;
        while (temp_i >= 0 && temp_j >= 0) {
            if (chessBoard[temp_i][temp_j] == 'Q') return false;
            temp_i--;
            temp_j--;
        }

        // Top Right
        temp_i = i;
        temp_j = j;
        while (temp_i >= 0 && temp_j < chessBoard[0].length) {
            if (chessBoard[temp_i][temp_j] == 'Q') return false;
            temp_i--;
            temp_j++;
        }

        return true;
    }

    public void helper(int row, int n, List<List<String>> ans, char[][] chessBoard) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (Character ch : chessBoard[i]) {
                    str.append(ch);
                }
                temp.add(str.toString());
            }
            ans.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(row, j, chessBoard)) {
                chessBoard[row][j] = 'Q';
                helper(row + 1, n, ans, chessBoard);
                chessBoard[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0, n, ans, chess);
        return ans;
    }
}
