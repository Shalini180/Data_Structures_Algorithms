class Solution {
    public void dfsHelper(int i, int j, char[][] grid, int[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(vis[i][j] == 1 || grid[i][j] == '0') return;
        vis[i][j] = 1;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, 1, -1};
        for(int k = 0; k < 4;k++){
            dfsHelper(i + row[k], j + col[k], grid, vis);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    dfsHelper(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }
}
